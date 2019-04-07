package mytest.algorithm;

public class HeapSort {
	public static void main(String[] args) {
		int i=0;
		int a[] = {5,4,9,8,7,6,0,1,3,2};
		int len = a.length;
		long starttime = System.nanoTime();
		myMinHeapSort(a);
		long endtime = System.nanoTime();
		System.out.println("ºÄÊ±"+(endtime-starttime)+"ns");
		for (i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
	}

	private static void myMinHeapSort(int[] array) {
		// TODO Auto-generated method stub
		int i;
		int len = array.length;
		for(i=len/2-1;i>=0;i--) {
			adjustMinHeap(array,i,len-1);
		}
		for(i=len-1;i>=0;i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] =tmp;
			adjustMinHeap(array,0,i-1);
		}
	}

	private static void adjustMinHeap(int[] a, int pos, int len) {
		// TODO Auto-generated method stub
		int temp;
		int child;
		for(temp=a[pos];2*pos+1<=len;pos=child) {
			child = 2* pos+1;
			if(child<len&&a[child]>a[child+1]) {
				child++;
			}
			if(a[child]<temp) {
				a[pos]=a[child];
			}else
				break;
		}
		a[pos]=temp;
	}
}
