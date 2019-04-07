package mytest.algorithm;

public class MyLinkedList {
	class Node{
		Node next = null;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
	Node head = null;
	public void addNode(int d) {
		Node newNode = new Node(d);
		if(head==null) {
			head = newNode;
			return;
		}
		Node tmp = head;
		while(tmp.next!=null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	public Boolean deleteNode(int index) {
		if(index>length()||index<1) {
			return false;
		}
		if(index==1) {
			head = head.next;
			return true;
		}
		int i =2;
		Node preNode = head;
		Node curNode = preNode.next;
		while(curNode!=null) {
			if(i==index) {
				preNode = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
	public int length() {
		int length = 0;
		Node tmp = head;
		while(tmp!=null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	public Node orderList() {
		Node nextNode = null;
		int temp = 0;
		Node curNode = head;
		while(curNode.next!=null) {
			nextNode = curNode.next;
			while(nextNode!=null) {
				if(curNode.data>nextNode.data) {
					temp = nextNode.data;
					nextNode.data = curNode.data;
					curNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
	public void printList() {
		Node tmp = head;
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(3);
		list.addNode(1);
		list.addNode(5);
		list.addNode(3);
		list.deleteNode(1);
		System.out.println("listLen="+list.length());
		System.out.println("Before order:");
		list.printList();
		list.orderList();
		System.out.println("After order:");
		list.printList();
	}
}
