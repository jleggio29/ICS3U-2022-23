package homework5;

public class exampleNine {
    public static void main(String[] args) {

        int itemsSold = 28;

        double pay = Math.round(itemsSold * 0.27 * 100) / 100.0;

        System.out.print("If a salesperson sells " + itemsSold + " items, they will make $" + pay);

    }
}