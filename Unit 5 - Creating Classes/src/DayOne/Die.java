package DayOne;

public class Die {
    private int numSides; // private attributes are only visible in the class
    private int topSide; // attributes define the current state of this class

    public int getTopSide() {
        return topSide;
    }

    public Die(int numSides) {
        this.numSides = numSides;
        this.roll();

    }

    public Die(){
        this.numSides = 6;
        roll();
    }

    // If you do not explicitly write your own constructor, Java will implicitly supply one that takes 
    // no argument and calls your parends constructor 

    public void roll() {
        topSide = (int) (Math.random() * numSides) + 1;

    }

    public String toString(){

        return "" + this.topSide;
    }

}
