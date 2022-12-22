package DayOne;

public class DieGame {
    public static void main(String[] args){
        Die die1 = new Die();
        Die die2 = new Die(8);

        for(int i = 0; i < 10; i++){
            int numPairs = 0;
            die1.roll();
            die2.roll();
            System.out.println(die1);
            System.out.println(die2);
        

        if (die1.getTopSide() == die2.getTopSide()){
            numPairs++;
        }
    }
    }
}
