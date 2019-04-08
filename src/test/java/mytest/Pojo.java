package mytest;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Pojo {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		for (ListIterator<String> iterator = list.listIterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
	}
}
