import java.util.*;
import java.util.stream.Collectors;

// interface Printable {
// }

// class A implements Printable {
//     public void a() {
//         System.out.println("a method");
//     }
// }

// class B implements Printable {
//     public void b() {
//         System.out.println("b method");
//     }
// }

// class Call {
//     void invoke(Printable p) {
//         if (p instanceof A) {
//             A a = (A) p;
//             a.a();
//         }
//         if (p instanceof B) {
//             B b = (B) p;
//             b.b();
//         }

//     }
// }

// class a{
// int salary=100;
// }

// class b extends a{

// void q(){
// System.out.println("salary");
// }
// }

// class operation{
// int ca(int A){
// return A*A*A;
// }

// }

// class cal{
// operation op;
// int B=10;
// int q(int e){
// op = new operation();
// int AB= op.ca(e);
// return B+AB;
// }
// }

// abstract class sound{
// abstract void voice();
// }

// class v extends sound{
// void voice(){
// System.out.println("b");
// }
// }

// class pa extends sound{
// void voice(){
// System.out.println("c");
// }
// }

// interface a{
// void show();
// void see();

// interface b{
// void print();
// }
// }

// interface c{
// void write();
// }

// class first implements a,c{

// public void show(){
// System.out.println("show");
// }
// public void print(){
// System.out.println("print");
// }

// public void see(){
// System.out.println("see");
// }

// public void write(){
// System.out.println("write");
// }

// int add(int x,int y){
// return x+y;
// }

// int add(int x, int y,int z){
// return x+y+z;
// }

// }

// class B1{
// B1 show(){
// return this;
// }

// int a=10;

// void print(){
// System.out.println("B1");
// }
// }

// class B2 extends B1
// {
// B2 show(){
// return this;
// }

// int a=20;

// void print(){
// System.out.println("B2");
// System.out.println(a);
// System.out.println(super.a);
// super.print();
// }

// }

// class B3 extends B2{
// B3 show(){
// return this;
// }

// void print(){
// System.out.println("B3");
// }
// }

// class student extends Thread {

// private String name;

// public String getName() {

// return name;
// }

// public void setName(String name) {
// this.name = name;
// }

//     public void run() {
//         for (int i = 1; i < 5; i++) {
//             try {
//                 Thread.sleep(500);
//             } catch (Exception e) {
//                 System.out.println(e);
//             }
//             System.out.println(i);
//         }
//         System.out.println("str");
//     }
// }

// class student{

// void cal() throws IOException{
// int a=1/0;
// throw new IOException("a");
// }

// }
class Book {
    int id, no;
    String name;

    public Book(int id, String name, int no) {
        this.id = id;
        this.name = name;
        this.no = no;
    }
}

class test {
    public static void main(String args[]) {

        ArrayList<String> a = new ArrayList<String>();

        a.add("parth");
        a.add("Rutvik");
        a.add("ads");
        a.add(1, "adssadasd");
        a.remove("parth");

        Iterator<String> i = a.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        // LinkedList<String> b = new LinkedList<String>();

        // b.add("parth");
        // b.add("Rutvik");
        // b.add(1, "adssadasd");
        // b.add("ads");

        // // b.remove("parth");

        // Iterator p = b.descendingIterator();
        // while (p.hasNext()) {
        // System.out.println(p.next());
        // }

        List<Book> list = new LinkedList<Book>();

        Book a1 = new Book(1, "rutvik", 12);
        Book a2 = new Book(2, "Package", 122);
        Book a3 = new Book(3, "Package", 190);
        Book a4 = new Book(4, "Package", 100);
        Book b5 = new Book(5, "Package", 200);

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(b5);

        List<Integer> list2 = list.stream().map(l -> l.no).collect(Collectors.toList());
        System.out.println(list2);

        int total = list.stream().collect(Collectors.summingInt(l -> l.no));
        System.out.println(total);

        double avg = list.stream().collect(Collectors.averagingDouble(l -> l.no));
        System.out.println(avg);

        Book m = list.stream().max((o1, o2) -> o1.no > o2.no ? 1 : -1).get();
        Book o = list.stream().min((o1, o2) -> o1.no < o2.no ? -1 : 1).get();
        System.out.println(m.no);
        System.out.println(o.no);

        long l1 = list.stream().filter(o3 -> o3.no >= 122).count();
        System.out.println("count " + l1);

        Set<Integer> a0 = list.stream().filter(o1 -> o1.no < 101).map(o1 -> o1.no).collect(Collectors.toSet());
        System.out.println(a0);

        Map<Integer, String> a9 = list.stream().collect(Collectors.toMap(o1 -> o1.id, o1 -> o1.name));
        System.out.println(a9);

        List<Integer> a7 = list.stream().filter(p -> p.no < 123).map(p -> p.no).collect(Collectors.toList());
        System.out.println(a7);

        // Stream.iterate(1, l -> l + 1).filter(l -> l % 2 ==
        // 0).limit(6).forEach(System.out::println);

        // for (Book c : list) {
        // System.out.println(c.id + " " + c.name + " " + c.no);
        // }

        // HashSet<String> e = new HashSet<String>();

        // e.add("Rutvik");
        // e.add("parth");
        // e.add("Rutvik");
        // e.add("adssadasd");
        // e.add("ads");

        // // b.remove("parth");

        // Iterator p1 = e.iterator();
        // while (p1.hasNext()) {
        // System.out.println(p1.next());
        // }

        // TreeSet<String> u = new TreeSet<String>();

        // u.add("sfa");
        // u.add("acf");
        // u.add("bth");
        // u.add("dre");

        // Iterator u1 = u.iterator();

        // while (u1.hasNext()) {
        // System.out.println(u1.next());
        // }

        // time date

        // LocalDate date = LocalDate.now();
        // LocalDate y = date.minusDays(3);
        // LocalDate a = date.plusDays(5);
        // LocalTime t = LocalTime.now();
        // LocalTime b = t.minusHours(10);
        // LocalTime c = t.plusHours(5);
        // System.out.println(date);
        // System.out.println(date.isLeapYear());
        // System.out.println(y);
        // System.out.println(a);
        // System.out.println(t);
        // System.out.println(c);
        // System.out.println(b);

        // String d = "2021/05/30";
        // String strdate1 = date.format(DateTimeFormatter.ISO_DATE);
        // DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/yyyy
        // mm:HH:ss");
        // LocalDateTime td = LocalDateTime.now();
        // String strdate = td.format(format);
        // System.out.println(strdate1);
        // System.out.println(strdate);

        // ZoneId f = ZoneId.of("Asia/Tokyo");
        // ZoneId f1 = ZoneId.of("Asia/Kolkata");
        // TimeZone f4 = TimeZone.getDefault();
        // LocalTime l = LocalTime.now(f);
        // LocalTime l1 = LocalTime.now(f1);
        // LocalTime r = LocalTime.now(f);
        // System.out.println(r);
        // System.out.println(td.get(ChronoField.MICRO_OF_SECOND));
        // System.out.println(l.isAfter(l1));
        // System.out.println(f.getDisplayName(TextStyle.FULL, Locale.ROOT));
        // System.out.println(f4.getDisplayName());

        // OffsetDateTime d1 = OffsetDateTime.now();
        // int h1 = d1.getMinute();
        // int h2 = date.getDayOfMonth();
        // System.out.println(h2);
        // System.out.println(td.getDayOfWeek());

        // Clock td1 = Clock.systemDefaultZone();
        // System.out.println(td1.instant());

        // // ZoneOffset k = ZoneOffset.UTC;
        // // System.out.println(k.now());

        // java.util.Date a8 = new java.util.Date();
        // System.out.println(a8);

        // long date3 = System.currentTimeMillis();
        // java.sql.Date a9 = new java.sql.Date(date3);
        // System.out.println(a9);

        // Calendar a0 = Calendar.getInstance();

        // a0.set(2010, 05, 11);

        // // Date a7 = a0.getInstance();
        // // System.out.println(a7);
        // System.out.println(a0.getMinimum(Calendar.DAY_OF_WEEK));

        // String[] id = TimeZone.getAvailableIDs();

        // for (var i = 0; i < 3; i++) {
        // System.out.println(id[i]);
        // }

        // Period z = Period.of(2010, 2, 1);
        // System.out.println(z);

        // student r = new student();
        // r.setName("Parth");
        // r.start();
        // r.run();
        // r.start();
        // System.out.println(r.getName());

        // String
        // String p ="parth";
        // String e = "parth parmar";
        // String t = " PARTH ";
        // p = p.concat("rth");
        // System.out.println(p);
        // System.out.println(p.equals(e));
        // System.out.println(e.equalsIgnoreCase(p));
        // System.out.println(p.compareTo(e));
        // System.out.println(e.contains("rut"));

        // System.out.println(e.substring(1));
        // System.out.println(e.substring(1,6));

        // System.out.println(e.toUpperCase());
        // System.out.println(t.toLowerCase());
        // System.out.println(t.trim());
        // System.out.println(e.startsWith("r"));
        // System.out.println(e.startsWith("p"));
        // System.out.println(e.charAt(5));
        // System.out.println(e.length());
        // int a = 1;
        // String str2 = String.valueOf(a);
        // System.out.println(str2+15);
        // System.out.println(e.replace("parth" , "o"));

        // String text = new String("abc,ef,g");
        // String[] str1 = text.split("g");
        // System.out.println(Arrays.toString(str1));

        // StringBuilder q = new StringBuilder("ru");
        // StringBuilder q1 = new StringBuilder("tvik");
        // System.out.println(q.append(q1));
        // String w = String.format("%s %s",p,e);
        // System.out.println(w);
        // System.out.println(String.join(" ",p,e));
        // String z = String.join("",p,e);
        // System.out.println(z.toString());
        // // StringJoiner x = new StringJoiner(",");
        // // x.add("par");
        // // x.add("th");
        // // System.out.println(x.toString());

        // List <String> v = Arrays.asList("par","th","parmar");
        // String str = v.stream().collect(Collectors.joining(","));
        // System.out.println(str);

        // StringBuffer r1 = new StringBuffer();
        // System.out.println(r1.append("rtvik"));
        // System.out.println(r1.insert(1,"u"));
        // System.out.println(r1.capacity());
        // System.out.println(r1.append("rtvikasdhjahsjklh"));
        // System.out.println(r1.replace(1,4,"mis"));
        // System.out.println(r1.delete(2 ,4 ));
        // r1.ensureCapacity(90);
        // System.out.println(r1.capacity());
        // System.out.println(r1.reverse());

        // StringTokenizer a3= new StringTokenizer("abc,efg hij", " ");
        // System.out.println(a3.countTokens());
        // while (a3.hasMoreTokens()){
        // System.out.println(a3.nextToken());
        // }

        // StringTokenizer a4= new StringTokenizer("efg hij");
        // System.out.println(a4.nextToken());
        // System.out.println(a3.nextElement());

        // try{
        // String a=null;
        // System.out.println(a.length());
        // }
        // catch(Exception e){
        // System.out.println(e);
        // }

        // try{
        // student d = new student();
        // d.cal();
        // }
        // catch(Exception e){
        // System.out.println(e);
        // }

        // try{
        // try{
        // int b[]={1,2,3};
        // System.out.println(b[10]);
        // }
        // catch(ArithmeticException e){
        // System.out.println(e);
        // }
        // }
        // catch(Exception e){
        // System.out.println(e);
        // }
        // finally{
        // System.out.println("abc");
        // }

        // B1 T1=new B1();
        // T1.show().print();

        // B2 T2=new B2();
        // T2.show().print();

        // B3 T3=new B3();
        // T3.show().print();

        // first a=new first();
        // a.show();
        // a.print();
        // a.write();
        // a.see();
        // System.out.println(a.add(1,2));
        // System.out.println(a.add(1,2,3));

        // pa a = new pa();
        // a.voice();

        // Printable p = new A();
        // Call c = new Call();
        // c.invoke(p);

        // cal p = new cal();
        // p.q();
        // int math = p.q(10);
        // System.out.println(math);
        // System.out.println(r.salary);

    }
}