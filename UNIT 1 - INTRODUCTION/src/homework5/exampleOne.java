package homework5;

public class exampleOne {
    public static void main(String[] args) {

        int price = 985;
        double tax = 1.055;
        double total = Math.round(price * tax * 100) / 100.0;

        System.out.print("The price of the computer with tax is " + total + " dollars");

    }
}
