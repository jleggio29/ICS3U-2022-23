package day4;

public class Example5 {
    public static void main(String[] args) {
        int pennies = 10;
        int dimes = 3;
        int quarters = 6;
        int nickels = 5;
        int loonies = 8;
        int toonies = 7;

        double total = pennies * 0.01 + nickels * 0.05 + 
        dimes * 0.1 + quarters * 0.25 + loonies * 1 + toonies * 2;
        System.out.println(total);

    }
}