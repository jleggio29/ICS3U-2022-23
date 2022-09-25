package homework5;

public class exampleFour {
    public static void main(String[] args) {

        long speedoflightkilometerpersecond = 300000;
        long secondsinday = 86400;
        long distancelighttravelsinday = speedoflightkilometerpersecond * secondsinday;
        long daysinyear = 365;
        long distancelightyear = distancelighttravelsinday * daysinyear;
        
        System.out.print("Light travels " + distancelightyear + " kilometers in 1 year");

        

    }
}