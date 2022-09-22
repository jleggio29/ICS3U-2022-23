package day5;

import java.util.Scanner;

public class exampleOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        double radius;

        System.out.print("Please enter the radius:");
        radius = in.nextDouble();

        double area = Math.PI * radius * radius;

        System.out.print("The area of a circle of radius " + radius + " is: " + area);

        in.close();

    }
}