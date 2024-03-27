from flask import Flask, render_template, request, redirect, url_for, session, Response
# from mysql.connector import MySQLConnection, Error
from flask_mysqldb import MySQL
from flask import flash
from camera import *
import MySQLdb.cursors
import re
import os


app = Flask(__name__)

app.secret_key = '1a2b3c4d5e'


app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = ''
app.config['MYSQL_DB'] = 'music'


mysql = MySQL(app)


@app.route('/pythonlogin/', methods=['GET', 'POST'])
def login():

    msg = ''

    if request.method == 'POST' and 'username' in request.form and 'password' in request.form:

        username = request.form['username']
        password = request.form['password']

        cursor = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
        cursor.execute(
            'SELECT * FROM accounts WHERE username = %s AND password = %s', [username, password])

        account = cursor.fetchone()

        if account:

            session['loggedin'] = True
            session['id'] = account['id']
            session['username'] = account['username']

            return redirect(url_for('home'))
        else:

            msg = 'Incorrect username/password!'
    return render_template('index.html', msg='')


@app.route('/pythonlogin/register', methods=['GET', 'POST'])
def register():

    msg = ''

    if request.method == 'POST' and 'username' in request.form and 'password' in request.form and 'email' in request.form:

        username = request.form['username']
        password = request.form['password']
        email = request.form['email']

        cursor = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
        cursor.execute(
            'SELECT * FROM accounts WHERE username = %s', [username])
        account = cursor.fetchone()

        if account:
            msg = 'Account already exists!'
        elif not re.match(r'[^@]+@[^@]+\.[^@]+', email):
            msg = 'Invalid email address!'
        elif not re.match(r'[A-Za-z0-9]+', username):
            msg = 'Username must contain only characters and numbers!'
        elif not username or not password or not email:
            msg = 'Please fill out the form!'
        else:

            cursor.execute('INSERT INTO accounts VALUES (NULL, %s, %s, %s)', [
                           username, password, email])
            mysql.connection.commit()
            msg = 'You have successfully registered!'
    elif request.method == 'POST':

        msg = 'Please fill out the form!'

    return render_template('register.html', msg=msg)


@app.route('/pythonlogin/home')
def home():

    if 'loggedin' in session:

        return render_template('home.html', username=session['username'])

    return redirect(url_for('login'))


@app.route('/pythonlogin/profile')
def profile():

    if 'loggedin' in session:

        cursor = mysql.connection.cursor(MySQLdb.cursors.DictCursor)
        cursor.execute('SELECT * FROM accounts WHERE id = %s',
                       (session['id'],))
        account = cursor.fetchone()

        return render_template('profile.html', account=account)

    return redirect(url_for('login'))


@app.route('/pythonlogin/logout')
def logout():

    session.pop('loggedin', None)
    session.pop('id', None)
    session.pop('username', None)

    return redirect(url_for('login'))


@app.route('/pythonlogin/search', methods=['GET', 'POST'])
def search():
    if request.method == 'POST' and 'Moods' in request.form:
        mood = request.form['Moods']
        cursor = mysql.connection.cursor()
        cursor.execute(
            'select * FROM tracks WHERE mood_description = %s', [mood])
        tracks = cursor.fetchall()
        if len(tracks) == 0 and mood == 'all':
            cursor.execute(
                'select * FROM tracks WHERE mood_description = %s', [mood])
            tracks = cursor.fetchall()
        return render_template('search.html', tracks=tracks)
    return render_template('search.html')


@app.route('/pythonlogin/songs', methods=['GET', 'POST'])
def songs():
    if 'loggedin' in session:
        songs = os.listdir('static/music/')
        cursor = mysql.connection.cursor()
        cursor.execute('select * FROM tracks')
        tracks = cursor.fetchall()
        return render_template('songs.html', songs=songs, tracks=tracks)
        # Show the profile page with account info


def emotion1(camera):

    while True:
        text = camera.emotion()
        return text


@app.route('/pythonlogin/display', methods=['GET', 'POST'])
def display():
    if 'loggedin' in session:
        songs = os.listdir('static/music/')
        text = emotion1(VideoCamera())
        cursor = mysql.connection.cursor()
        cursor.execute(
            'select * FROM tracks WHERE mood_description = %s', [text])
        tracks = cursor.fetchall()
        if len(tracks) == 0 and text == 'all':
            cursor.execute(
                'select * FROM tracks WHERE mood_description = %s', [text])
            tracks = cursor.fetchall()
        return render_template('songs.html', songs=songs, tracks=tracks)
    return redirect(url_for('login'))


@app.route('/pythonlogin/player')
def player():
    return render_template('cam.html')


@app.route('/pythonlogin/edit/<string:p_id>', methods=['GET', 'POST'])
def update(p_id):
    if request.method == 'GET':
        cursor = mysql.connection.cursor()
        tracks1 = cursor.execute(
            'select * FROM tracks WHERE track_no = %s', [p_id])
        tracks1 = cursor.fetchall()
        mysql.connection.commit()
        cursor.close()
        return (render_template("edit.html", tracks1=tracks1))

    if request.method == 'POST':
        cursor = mysql.connection.cursor()
        # fetch form data
        tracks = request.form
        # p_id=tracks['p_id']
        title = tracks['mood']
        cursor.execute(
            "UPDATE tracks SET mood_description=%s WHERE track_no=%s", [title, p_id])
        mysql.connection.commit()
        cursor.close()
        flash("Data Updated Successfully")
        return redirect('/pythonlogin/product')


@app.route('/pythonlogin/product')
def product():
    cursor = mysql.connection.cursor()
    cursor.execute('select * FROM tracks')
    tracks = cursor.fetchall()
    return render_template('display.html', tracks=tracks)


def gen(camera):
    while True:
        frame = camera.get_frame()
        yield (b'--frame\r\n' b'Content-Type: image/jpeg\r\n\r\n' + frame + b'\r\n\r\n')


@app.route('/video_feed')
def video_feed():
    return Response(gen(VideoCamera()), mimetype='multipart/x-mixed-replace; boundary=frame')


if __name__ == '__main__':
    app.run(host='0.0.0.0', port='5000', debug=True)
