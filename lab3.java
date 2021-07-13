package ata;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class lab3 {
public static final double PI = 3.141592;
	
	public static int[] concatArrays(int[] arr1, int[] arr2) {
		
		int[] resArr = new int[arr1.length + arr2.length];
		
		for (int i = 0; i < arr1.length; i++) {
			resArr[i] = arr1[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			resArr[i + arr1.length] = arr2[i];
		}
		
		return resArr;
	}
	
	public static double round(double value, int places) {
		
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.DOWN);
	    
	    return bd.doubleValue();
	}
	
	static double calcPi(int accuracy) {
	
		double pi = 2;
		
		for (double i = 1; i <= accuracy; i++) {
			pi = ((2*i)*(2*i)) / ((2*i-1)*(2*i+1));
		}
		
		return pi;
	}
	
	static double calcPi2(int accuracy) {
		
		double pi = 0;
		
		for (int i = 0; i <= accuracy; i++) {
			pi += Math.pow(-1, i) / (2*i+1);
		}
		
		return pi*4;
	}
	
	static boolean compareToPi(double pi) {
		
		pi = round(pi, 6);
		
		return PI == pi;
	}

	public static void main(String[] args) {
		
		int acc1 = 5000000;
		int acc2 = 5000000;
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {6, 7, 8};
		
		
		double pi1 = calcPi(acc1);
		double pi2 = calcPi2(acc2);
		System.out.println("PI calculated using Wallis' method: " + pi1);
		System.out.println("PI calculated using Gregory's method: " + pi1);
		
		System.out.println("First 6 digits comparison:\n" + PI + " & " + pi1 + " ==> " + compareToPi(pi1));
		System.out.println("First 6 digits comparison:\n" + PI + " & " + pi2 + " ==> " + compareToPi(pi2));
	
		int[] arr3 = concatArrays(arr1, arr2);
		System.out.println("Concat of test arrays:");
		System.out.print("{");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]);
			if (i != arr3.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("}");
	}

}
