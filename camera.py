import time
import cv2
import os,random
import subprocess
# from keras.preprocessing.image import img_to_array
from tensorflow.keras.utils import img_to_array
from keras.preprocessing import image
import numpy as np
from keras.models import load_model

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
size = 4
face_classifier = cv2.CascadeClassifier('./haarcascade_frontalface_default.xml')
classifier =load_model('./Emotion_Detection.h5')
class_labels = ['Angry','Happy','Neutral','Sad','Surprise']


class VideoCamera(object):
    def __init__(self):
        self.video = cv2.VideoCapture(0,cv2.CAP_DSHOW)  # Using default WebCam connected to the PC.
        now = time.time()###For calculate seconds of video
        future = now + 20  ####here is second of time which taken by emotion recognition system ,you can change it
        
    def __del__(self):
        self.video.releast()
    
    def get_frame(self):
        ret, frame = self.video.read()
        gray = cv2.cvtColor(frame,cv2.COLOR_BGR2GRAY)
        labels = []
        faces = face_classifier.detectMultiScale(gray,1.3,5)
        if len(faces)>=1:
            for (x,y,w,h) in faces:
                cv2.rectangle(frame,(x,y),(x+w,y+h),(255,0,0),2)
                roi_gray = gray[y:y+h,x:x+w]
                roi_gray = cv2.resize(roi_gray,(48,48),interpolation=cv2.INTER_AREA)
                FaceFileName = "test.jpg"  # Saving the current image from the webcam for testing.
                cv2.imwrite(FaceFileName, roi_gray)
                  # Getting the Result from the label_image file, i.e., Classification Result.


                if np.sum([roi_gray])!=0:
                    roi = roi_gray.astype('float')/255.0
                    roi = img_to_array(roi)
                    roi = np.expand_dims(roi,axis=0)

            # make a prediction on the ROI, then lookup the class

                    preds = classifier.predict(roi)[0]
                    print("\nprediction = ",preds)
                    text=class_labels[preds.argmax()]
                    print("\nprediction max = ",preds.argmax())
                    print("\nlabel = ",text)
                    label_position = (x,y)
                    
               
                    text = text.title()  # Title Case looks Stunning.
                    font = cv2.FONT_HERSHEY_TRIPLEX

                if text == 'Angry':
                    cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 25, 255), 7)
                    cv2.putText(frame, text, (x + h, y), font, 1, (0, 25,255), 2)

                if text == 'Happy':
                    cv2.rectangle(frame, (x, y), (x + w, y + h), (0,260,0), 7)
                    cv2.putText(frame, text, (x + h, y), font, 1, (0,260,0), 2)

                if text == 'Surprise':
                    cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 255), 7)
                    cv2.putText(frame, text, (x + h, y), font, 1, (0, 255, 255), 2)

                if text == 'Sad':
                    cv2.rectangle(frame, (x, y), (x + w, y + h), (0,191,255), 7)
                    cv2.putText(frame, text, (x + h, y), font, 1, (0,191,255), 2)
                
                if text == 'Neutral':
                    cv2.rectangle(frame, (x, y), (x + w, y + h), (0,100,0), 7)
                    cv2.putText(frame, text, (x + h, y), font, 1, (0,100,0), 2)
            
        

    # Show the image/
            
        ret, jpeg = cv2.imencode('.jpg', frame)
        return jpeg.tobytes()
        
    def emotion(self):
        labels = []
        ret, frame = self.video.read()
        gray = cv2.cvtColor(frame,cv2.COLOR_BGR2GRAY)
        
        faces = face_classifier.detectMultiScale(gray,1.3,5)
        for (x,y,w,h) in faces:
            cv2.rectangle(frame,(x,y),(x+w,y+h),(255,0,0),2)
            roi_gray = gray[y:y+h,x:x+w]
            roi_gray = cv2.resize(roi_gray,(48,48),interpolation=cv2.INTER_AREA)
            FaceFileName = "test.jpg"  # Saving the current image from the webcam for testing.
            cv2.imwrite(FaceFileName, roi_gray)
              # Getting the Result from the label_image file, i.e., Classification Result.


            if np.sum([roi_gray])!=0:
                roi = roi_gray.astype('float')/255.0
                roi = img_to_array(roi)
                roi = np.expand_dims(roi,axis=0)

        # make a prediction on the ROI, then lookup the class

                preds = classifier.predict(roi)[0]
                print("\nprediction = ",preds)
                text=class_labels[preds.argmax()]
                print("\nprediction max = ",preds.argmax())
                print("\nlabel = ",text)
                label_position = (x,y)
                
           
                text = text.title()  # Title Case looks Stunning.
                font = cv2.FONT_HERSHEY_TRIPLEX

            if text == 'Angry':
                cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 25, 255), 7)
                cv2.putText(frame, text, (x + h, y), font, 1, (0, 25,255), 2)

            if text == 'Happy':
                cv2.rectangle(frame, (x, y), (x + w, y + h), (0,260,0), 7)
                cv2.putText(frame, text, (x + h, y), font, 1, (0,260,0), 2)

            if text == 'Surprise':
                cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 255), 7)
                cv2.putText(frame, text, (x + h, y), font, 1, (0, 255, 255), 2)

            if text == 'Sad':
                cv2.rectangle(frame, (x, y), (x + w, y + h), (0,191,255), 7)
                cv2.putText(frame, text, (x + h, y), font, 1, (0,191,255), 2)
            
            if text == 'Neutral':
                cv2.rectangle(frame, (x, y), (x + w, y + h), (0,100,0), 7)
                cv2.putText(frame, text, (x + h, y), font, 1, (0,100,0), 2)
                
        return text
