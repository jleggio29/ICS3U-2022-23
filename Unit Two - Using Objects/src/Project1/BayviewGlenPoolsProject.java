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

        // Amount Of Water to Keep Pool 90% Full: (Volume Of Pool, Converted From Meters Cubed To Gallons, Multiplied By 0.9 In Order To Keep Pool 90% Full):

        double amountOfWater = shallowHeight * length * width + transitionHeight * width * deepLength + 
        width * transitionHeight * transitionLength / 2;

        double amountOfWaterInGallons = amountOfWater * 264.17205;

        double amountOfWaterInGallons90PercentFull = amountOfWaterInGallons * 0.9;

        // Amount Of Liner Needed For Pool: (Surface Area In Meters Squared Excluding Area Of Top Of Pool)

        double amountOfLiner = width * deepHeight + width * shallowHeight + 
        2 * (length * shallowHeight + transitionLength * transitionHeight / 2 + deepLength * transitionHeight); 

        // Cost Of Liner Needed For Pool: (Surface Area Of Pool In Meters Squared * Price Of Liner In Dollars Per Meter Squared)
      
        double costLiner = amountOfLiner * linerCost; 

        // Results: (Rounded To Nearest 100th of a gallon, 100th of a meter squared, and 100th of a dollar):

        System.out.println("The amount of water needed to keep the pool 90% full is " + Math.round(amountOfWaterInGallons90PercentFull * 100) / 100.0 + " gallons.");
        System.out.println("The amount of liner needed to create the pool is " + Math.round(amountOfLiner * 100) / 100.0 + " meters squared.");
        System.out.println("The total cost of the liner needed to create the pool is $" + Math.round(costLiner * 100) / 100.0 + ".");

        in.close();

    }
}