package Day1;

public class exampleOne {
    public static void main(String[] args) {

        String club = "Deca";
        String name = "Michael";

        System.out.println(club);
        System.out.println(name);

        String s1 = new String("Alphabet");
        String s2 = new String("Nolan Ryan");

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("The Length of s2 is: " + s2.length());

        System.out.println(s1.substring(2, 5));

        System.out.println("Bayview Glen".substring(8));

        System.out.println(s1.substring(0, s1.length() / 2));

        System.out.println("Hello".indexOf("ll"));
        System.out.println("Alphabet".indexOf("et"));
        System.out.println("banana".indexOf("an"));
        System.out.println("eye".indexOf("contact"));

    }
}