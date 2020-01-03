/**
 * 
 */
package myCodes.testcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author manoj.kumar6
 *
 */
//usinf frequency to calculate the frequency. hackerank code for interv prep
public class TestClass1 {
	public static void main(String[] args) {

		int arr[] = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };

		List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
		HashMap<Integer, Integer> hm = new HashMap<>();
		l.stream().forEach(e -> {

			Integer f = Collections.frequency(l, e);
			hm.put(e, f);
		});
		System.out.println(hm);
		ArrayList<Integer> al = new ArrayList<Integer>();
		hm.forEach((k, v) -> {
			int a = v / 2;
			al.add(a);
		});
		System.out.println(al);
		int total_pairs = al.stream().mapToInt(e -> e).sum();
		System.out.println(total_pairs);
	}
}


/**
 * import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the sockMerchant function below.
    static Integer sockMerchant(int n, int[] ar) {
 List<Integer> l = Arrays.stream(ar).boxed().collect(Collectors.toList());
    HashMap<Integer,Integer>hm=new HashMap<>();
    l.stream().forEach(e->{
        
        Integer f=Collections.frequency(l,e);
        hm.put(e, f);
    });
    ArrayList<Integer> al=new ArrayList<Integer>();
    hm.forEach((k,v)->{
       int a=v/2;
       al.add(a);
    });
    int sum=al.stream().mapToInt(e->e).sum();
    
    return sum;
    

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

        Integer result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

























