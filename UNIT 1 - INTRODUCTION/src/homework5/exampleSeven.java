package homework5;

public class exampleSeven {
    public static void main(String[] args) {

        double fahrenheit = 98.0;

        double celcius = Math.round(((fahrenheit - 32) * 5 / 9) * 10) / 10.0;

        System.out.print("If the temperature is 98 degrees fahrenheit, it is " + celcius + " degrees celcius");
    
    }
}
