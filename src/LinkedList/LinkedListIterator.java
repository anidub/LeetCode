package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator {

	public static void main(String[] args) {

		Node start = new Node(1);
		start.addNextNode(2).addNestedNode(3).addNestedNode(4).addNextNode(5).addNestedNode(6);
		List list = new List(start);
		Iterator<Integer> t = list.iterator();

		while (t.hasNext()) {
			System.out.print(t.next() + "  ");
		}
		System.out.println();
	}
		
	//itertator has these 3 methods ! imp!//study this class
	static class MyIterator implements Iterator<Integer> {

		Node n1; //traverses main nodes
		Node n2; //traverses nested nodes

		boolean traverseNestedNodes;

		MyIterator(List list) {
			n1 = list.start;
			n2 = null;
		}

		@Override
		public boolean hasNext() {
			return n2 != null || n1 != null;
		}

		@Override
		public Integer next() {
			int value;
			if (n1 == null && n2 == null) {
				throw new NoSuchElementException();
			}

			if (n2 == null) {
				value = n1.value;
				n2 = n1.nestedNodes;
				n1 = n1.next;
			} else {
				value = n2.value;
				n2 = n2.next;
			}

			return value;

		}

		@Override
		public void remove() {

		}
	}

	static class Node {
		int value;
		Node next;

		Node nestedNodes;

		Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value + "";
		}

		Node addNextNode(int value) {
			Node nextNode = new Node(value);
			this.next = nextNode;
			return nextNode;
		}

		Node addNestedNode(int value) {
			Node newNode = new Node(value);
			if (nestedNodes == null) {
				nestedNodes = newNode;
			} else {

				Node cursor = nestedNodes;
				while (cursor.next != null) {
					cursor = cursor.next;
				}
				cursor.next = newNode;
			}
			return this;
		}

	}

	static class List {
		Node start;

		List(Node start) {
			this.start = start;
		}

		@Override
		public String toString() {
			Node current = start;
			StringBuilder buf = new StringBuilder();
			while (current != null) {
				buf.append(current + "  ");
				current = current.next;
			}
			return buf.toString();
		}

		Iterator<Integer> iterator() {
			return new MyIterator(this);
		}
	}

}
