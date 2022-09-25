package homework5;

public class exampleFive {
    public static void main(String[] args) {

        int wins = 110;
        double totalgames = 154;

        double winningpercentage = wins / totalgames;

        System.out.print("The 1927 New York Yankees Winning Percentage Was " + Math.round(winningpercentage * 1000) / 1000.0);

    }
}
