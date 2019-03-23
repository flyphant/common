package cn.iq99.common;

import lombok.Data;

@Data
public class ArrayUtil {
	
	/**
	 * 交换数组顺序
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	public static void swapArray(int[] array,int i,int j) {
		
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	/**
	 * 打印数组
	 * @param arr
	 */
	public static void printArray(int arr[]) {
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}
