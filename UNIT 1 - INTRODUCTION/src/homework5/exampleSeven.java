package homework5;

public class exampleSeven {
    public static void main(String[] args) {

        double fahrenheit = 98.0;

        double celcius = (fahrenheit - 32) * 5 / 9;

        double celciusRounded = Math.round(celcius * 10) / 10.0;

        System.out.print("If the temperature is 98 degrees fahrenheit, it is " + celciusRounded + " degrees celcius");
    
    }
}
