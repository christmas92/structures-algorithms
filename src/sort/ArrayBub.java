package sort;

import java.util.Calendar;

public class ArrayBub {
	
	public static int[] crarteArray(int size,int max){
		if(size <= 0){
			return null;
		}
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*max + 1);
		}
		return arr;
	}
	
	
	public static int[] bubbleSort(int[] arr){
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					
					//print(arr);
				}
			}	
		}
		return arr;
	}
	
	public static int[] selectSort(int[] arr){
		int flag,temp;
		for (int i = 0; i < arr.length-1; i++) {
			flag = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[flag]){
					flag = j;
				}			
			}
			temp = arr[i];
			arr[i] = arr[flag];
			arr[flag] = temp;
			
			//print(arr);
		}
		return arr;
	}
	
	public static int[] insertionSort(int[] arr){
		int temp,flag;
		for (int i = 1; i < arr.length; i++) {
			temp = arr[i];
			flag = i;
			while (flag > 0 && temp < arr[flag-1]) {
				arr[flag] = arr[flag-1];
				flag--;
			}
			arr[flag] = temp;
			
			//print(arr);
		}
		return arr;
	}
		
		
		
	
	
	public static void print(int[] arr){
		for (int i : arr) {
			System.out.print(i+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = crarteArray(500000,1000000);	
		print(arr);
		System.out.println(Calendar.getInstance().getTime());
		//bubbleSort(arr);
		//selectSort(arr);
		insertionSort(arr);
		System.out.println(Calendar.getInstance().getTime());
	}
}
