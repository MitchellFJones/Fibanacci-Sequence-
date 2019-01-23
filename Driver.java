import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Driver {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        //quicksort elements in ar
        quickSort(ar, 0, n-1);
        //iterate through ar, if ar(n) == ar(n+1) remove them both
        int counter = 0;
        
        boolean is_used = false;
       
            
        for(int i = 0; i < ar.length; i++){
            if(ar[i] == ar[i+1]){
                 
                if(is_used == false){
                counter++;
                
                is_used = !is_used;}
            }
        }
        //return # of times ar(n) == ar(n+1)
        return counter;
    }
    static void quickSort(int[] ar, int low, int high){
        if(low < high){
            int pi = partition(ar, low, high);
            
            quickSort(ar, low, pi - 1);
            quickSort(ar, pi + 1, high);
        }
    }
    static int partition(int[] ar, int low, int high){
        int pivot = ar[high];
        int i = (low - 1);
        
        for(int j = low; j < high; j++){
            if(ar[j] <= pivot){
                i++;
                
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i];
        ar[i+1] = ar[high];
        ar[high] = temp; 
    
        return i+1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

