public class exampleOne {

    public static void main(String[] args) {
   
    int[] arr = {1,52,69,7,88,32,95,55};

    // for (int i = arr.length; i>=0;i--){
    //     System.out.println(arr[i]);
    // }

    // double average = getBetterAverage(arr);
    // System.out.println(average);

    int index = search(arr,7);
    System.out.println(index);
    index = search(arr,4);
    System.out.println(index);


    }

    private static int search(int[] arr, int val) {
        for (int i = 0; i < arr.length;i++){
          if(arr[i] == val)
          return i;
        };

        return -1;
    }

    // private static double getBetterAverage(int[] arr) {
    //     int sum = 0;
    //     int min = arr[0];
    //     int max = arr[0];
    //     for (int i = 0; i < arr.length; i++){
    //         sum += arr[1];
    //         if (min > arr[i]){
    //             min = arr[i];
    //         }
            
    //         if (max > arr[i]){
    //             max = arr[1];
    //         }

    //     }
    //     return((sum - min - max)/(arr.length - 2.0));
    // }

}
