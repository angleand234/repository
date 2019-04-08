package mytest.algorithm;

public class HeapSort {
	public static void main(String[] args) {
		int i=0;
		int a[] = {5,4,9,8,7,6,0,1,3,2};
		int len = a.length;
		long starttime = System.nanoTime();
		myMinHeapSort(a);
		long endtime = System.nanoTime();
		System.out.println("耗时"+(endtime-starttime)+"ns");
		for (i = 0; i < len; i++) {
			System.out.print(a[i]+" ");
		}
		/*int pos=2;
		int child;
		int temp;
		for (temp=9; 2*pos+1<10; pos=child) {
			child = 2*pos+1;
			if(temp--<9) {
				break;
			}
		}
		System.out.println(pos);*/
	}

	private static void myMinHeapSort(int[] array) {
		// TODO Auto-generated method stub
		int i;
		int len = array.length;
		//构建堆，i是最后一个非叶子结点，-1是因为数组下标从0开始,对每一个非叶子结点及其孩子节点进行堆构造
		for(i=len/2-1;i>=0;i--) {
			adjustMinHeap(array,i,len-1);
		}
		//排序堆
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
		/*
		 * pos用于指定当前“根”节点，与其左右子节点比较，将小值赋予“根”节点，pos指向小值节点
		 * 然后将“根”节点原值赋予pos所指
		 */
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
