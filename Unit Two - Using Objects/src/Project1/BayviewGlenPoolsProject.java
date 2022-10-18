package Project1;

import java.util.Scanner;

public class BayviewGlenPoolsProject {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Prompts:

        System.out.println("Please enter the length of the pool in meters: ");
        double length = in.nextDouble();

        System.out.println("Please enter the width of the pool in meters: ");
        double width = in.nextDouble();

        System.out.println("Please enter the depth of the shallow end in meters: ");
        double shallowHeight = in.nextDouble();

        System.out.println("Please enter the depth of the deep end in meters: ");
        double deepHeight = in.nextDouble();

        System.out.println("Please enter the length of the slope of the transition in meters: ");
        double transitionSlope = in.nextDouble();

        System.out.println("Please enter the length of the shallow end in meters: ");
        double shallowLength = in.nextDouble();

        System.out.println("Please enter the cost of the liner in dollars per meter squared: ");
        double linerCost = in.nextDouble();

        // Calculations:

        // Other Dimensions:

        double transitionHeight = (double) deepHeight - shallowHeight;
        double transitionLength = (double) Math.sqrt(Math.pow(transitionSlope,2) - Math.pow(transitionHeight,2));
        double deepLength = (double) length - shallowLength - transitionLength ;

        // Amount Of Water (In Gallons) Needed To Keep Pool 90% Full: (Volume Of Pool In Meters Cubed Multiplied By 0.9):

        double amountOfWater = shallowHeight * length * width + transitionHeight * width * deepLength + width * transitionHeight * transitionLength / 2;

        double amountOfWater90PercentFull = amountOfWater * 0.9;
        
        // Amount Of Liner Needed For Pool: (Surface Area Of Pool In Meters Squared Excluding Area Of Top Of Pool)

        double amountOfLiner = width * deepHeight + width * shallowHeight + width * transitionSlope + width * shallowLength + width * deepLength + 2 * (length * shallowHeight + transitionLength * transitionHeight / 2 + deepLength * transitionHeight); 

        // Cost Of Liner Needed For Pool: (Surface Area Of Pool In Meters Squared * Price Of Liner (In Dollars) Per Meter Squared)
      
        double costLiner = amountOfLiner * linerCost; 

        // Printed Results: (Rounded To Nearest 100th Of A Meter Cubed, 100th Of A Meter Squared, And 100th Of A Dollar):

        System.out.println("The amount of water needed to keep the pool 90% full is " + Math.round(amountOfWater90PercentFull * 100) / 100.0 + " meters cubed.");
        System.out.println("The amount of liner needed to create the pool is " + Math.round(amountOfLiner * 100) / 100.0 + " meters squared.");
        System.out.println("The total cost of the liner needed to create the pool is $" + Math.round(costLiner * 100) / 100.0 + ".");

        in.close();

    }
}
