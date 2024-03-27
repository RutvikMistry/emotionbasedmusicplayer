import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collectors;



/**
 * concatString
 */
class add {

    public void run1() {
        String str = "abc";

        for (int i = 0; i < 10000; i++) {
            str = str + "adjlk";

        }
    }

    public void run() {
        StringBuilder a = new StringBuilder();

        for (int i = 0; i < 1000; i++) {
            a.append("adshkj");
        }
    }

}

class test1 {
    public static void main(String[] args) {
        String i = "xabcdes";
        // Q3
        System.out.println(i.substring(1, 5));

        StringBuilder h = new StringBuilder("abcdes");
         h.append("abcdes");

        System.out.println(i);

        // Q8
        HashSet<String> g = new HashSet<String>();

        g.add("y");
        g.add("z");
        g.add("x");
        g.add("a");

        System.out.println(String.join("", g));

        StringBuffer a = new StringBuffer();
        a.append("abcde");
        // Q4
        System.out.println(a.reverse());

        // Q10
        List<String> c = Arrays.asList("apple", "de", "po");

        System.out.println(String.join(",", c));
        c.stream().collect(Collectors.toList()).forEach(System.out::println);
        String d = c.stream().collect(Collectors.joining(", "));
        System.out.println("Stream = " + d);

        // Q9
        StringTokenizer e = new StringTokenizer("abc , efd,hij", " ,");

        while (e.hasMoreTokens()) {

            System.out.println(e.nextToken());
        }

        // Q5
        String p = "abcbda";
        String p2 = "athdl";

        // System.out.println(p.compareTo(p2));
        // char p1[] = p.toCharArray();

        for (int j = 0; j < p.length(); j++) {

            char p3 = p2.charAt(j);

            while (p.contains(p3 + "")) {
                p = p.replace((p3 + ""), "");
            }

            // int count = 1;

            // for (int k = 0; k < p3.length; k++) {
            // if (p1[j] == p3[k]) {
            // count = count + 1;
            // }

            // }

            // if (count <= 1) {
            // System.out.println("Q5 " + p1[j]);
            // }

        }
        System.out.println("remove char = " + p);
        // String r = "abcdefg";
        // byte r1[] = new byte[9];
        // // int n = 5;
        // new Random().nextBytes(r1);
        // String r = new String(r1, Charset.forName("UTF-8"));
        // System.out.println(r);

        // Q6
        int left = 47;
        int right = 122;
        int size = 10;

        Random foo = new Random();

        String v = foo.ints(left, right + 1).limit(size)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        System.out.println(v);

        // Q2
        add foo1 = new add();

        long start = System.currentTimeMillis();

        foo1.run1();
        System.out.println(System.currentTimeMillis() - start);

        foo1.run();
        start = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - start);
    }

}