package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/*
 * http://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
 * Flatten a multilevel linked list
Given a linked list where in addition to the next pointer, each node has a child pointer, which may or may not point to a separate list.
 These child lists may have one or more children of their own, and so on, to produce a multilevel data structure
 Time complexity : O(n)
 */
public class flattenMultiLevelLinkedList {

	private static class Node{
		int data;
		Node next;
		Node child;
		
		public Node(int data){
			this.data = data;
			next = child = null;
		}		
	}

	static Node createList(int arr[], int n) {
		Node node = null;
		Node p = null;
		int i;
		for (i = 0; i < n; ++i) {
			if (node == null) {
				node = p = new Node(arr[i]);
			} else {
				p.next = new Node(arr[i]);
				p = p.next;
			}
			p.next = p.child = null;
		}
		return node;
	}
	
	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int arr1[] = new int[] { 10, 5, 12, 7, 11 };
		int arr2[] = new int[] { 4, 20, 13 };
		Node head1 = createList(arr1, arr1.length);
		Node head2 = createList(arr2, arr2.length);
		head1.child = head2;
		flatten(head1);
		printList(head1);
	}
	// without additional space
	public static void flatten(Node head){
		if(head == null) return;
		Node cur = head;
		Node tail = head;
		
		while(tail.next != null){
			tail = tail.next;
		}
		
		while(cur != null){
			
			if(cur.child != null){
				tail.next = cur.child;
				Node temp = cur.child;
				while(temp.next != null){
					temp = temp.next;
				}
				tail = temp;
			}
			
			cur = cur.next;			
		}
	}
	
	//with additional space
	 public static void flattenWithSpace(Node head){
		 if(head == null) return;
		 Queue<Node> queue = new LinkedList<Node>();
		 Node cur = head;
		 while(cur != null){
			 queue.add(cur);
			 Node child = cur.child;
			 while(child != null){
				 queue.add(child);
				 child = child.next;
			 }
			 cur = cur.next;
		 }
		 while(!queue.isEmpty()){
			 Node n = queue.poll();
			 System.out.print(n.data + " ");
		 }
	 } 
	
	

}
