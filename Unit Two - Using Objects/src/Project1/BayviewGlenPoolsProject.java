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

        System.out.println("Please enter the length of the transition in meters: ");
        double transitionLength = in.nextDouble();

        System.out.println("Please enter the length of shallow end in meters: ");
        double shallowLength = in.nextDouble();

        System.out.println("Please enter the cost of the liner per meter squared: ");
        double linerCost = in.nextDouble();

        // Calculations:

        // Amount Of Water to Keep Pool 90% Full (Volume * 0.9, Then Converted From Meters Cubed To Gallons):

        double transitionHeight = (deepHeight - shallowHeight);

        double amountOfWater = ((shallowHeight * length * width) + (transitionHeight 
        * width * (length - shallowLength 
        - Math.sqrt(Math.pow(transitionLength,2) - Math.pow(transitionHeight,2)))) + (width * 
        transitionHeight * Math.sqrt(Math.pow(transitionLength,2) - 
        Math.pow(transitionHeight,2))) 
        * 0.9);

        double amountOfWaterInGallons = amountOfWater * 264.17205;

        // Amount Of Liner For Pool (Surface Area In Meters Squared - Area Of Top Of Pool)

        double amountOfLiner = (width * deepHeight) + (width * shallowHeight) + 
        (2 * ((length * shallowHeight) 
        + (Math.sqrt(Math.pow(transitionLength,2) - Math.pow(deepHeight - shallowHeight,2)) 
        * transitionHeight) + ((transitionHeight * Math.sqrt(Math.pow(transitionLength,2) 
        - Math.pow(deepHeight - shallowHeight,2)))/2))); 

        // Cost Of Liner For Pool (Amount Of Liner In Meters Squared * Price Of Liner Per Meter Squared)
      
        double costLiner = amountOfLiner * linerCost; 

        // Results (Rounded To Nearest 100th of a gallon, 100th of a meter squared, and 100th of a dollar):

        System.out.println("The amount of water needed to keep the pool 90% full is " + Math.round(amountOfWaterInGallons * 100) / 100.0 + " gallons");
        System.out.println("The amount of liner needed to create the pool is " + Math.round(amountOfLiner * 100) / 100.0 + " meters squared");
        System.out.println("The total cost of the liner needed to create the pool is $" + Math.round(costLiner * 100) / 100.0);

        in.close();

    }
}
