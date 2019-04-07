package mytest.algorithm;

public class QuickSort {
	public static void main(String[] args) {
		int a[] = {5,4,9,8,7,6,0,1,3,2};
		int len = a.length;
		long starttime = System.nanoTime();
		quickSort(a);
		long endtime = System.nanoTime();
		System.out.println("ºÄÊ±"+(endtime-starttime)+"ns");
		for (int j = 0; j < len; j++) {
			System.out.print(a[j]+" ");
		}
	}

	public static void quickSort(int[] array) {
		// TODO Auto-generated method stub
		sort(array,0,array.length-1);
	}

	public static void sort(int[] array, int low, int high) {
		// TODO Auto-generated method stub
		int i,j;
		int index;
		if(low>=high) {
			return;
		}
		i=low;
		j=high;
		index =array[i];
		while(i<j) {
			while(i<j&&array[j]>=index) {
				j--;
			}
			if(i<j) {
				array[i++] = array[j];
			}
			while(i<j&&array[i]<index) {
				i++;
			}
			if(i<j) {
				array[j--] = array[i];
			}
		}
		array[i]=index;
		sort(array,low,i-1);
		sort(array,i+1,high);
	}
}
