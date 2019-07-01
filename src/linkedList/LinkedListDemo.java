package linkedList;

import linkedList.LinkedList.Node;

class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// print elements of linkedlist
	public void printList() {
		Node n = head;
		if (n != null) {
			while (n != null) {
				System.out.println(n.data);
				n = n.next;
			}
		}
	}

	// adding node to the end of the list
	public void addNodeEnd(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node n1 = head;
		Node newNode = new Node(data);
		while (n1.next != null) {
			n1 = n1.next;
		}
		n1.next = newNode;
		newNode = null;
		return;
	}

	// adding node to the mid of linked list by giving node reference
	public void addNodeMid(Node prev, int data) {
		if (prev == null) {

			System.out.println("prev node null");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = prev.next;
		prev.next = newNode;
		System.out.println("successfully added node after" + ":" + prev.data);
	}

	// adding node in from at head
	public void addNodeHead(int data) {
		if (head == null) {
			System.out.println("head null");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		System.out.println("added at head");
	}
	//deleting the element by key for first occurneces
	public void deleteByKey(int data) {
		Node n=head;
		if(n!=null && n.data==data) {
			n=n.next;
			
		}
		while(n!=null && n.data!=data) {
			////////////////////
		}
	}
	
}

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList ls = new LinkedList();

		// Node n2 = new Node(2);
		// Node n3 = new Node(3);
		// Node n4 = new Node(4);
		// Node n5=new Node(5);

		/// ls.head.next = n2;
		// n2.next = n3;
		// n3.next = n4;
		// n4.next=n5;
		for (int i = 1; i < 6; i++) {
			ls.addNodeEnd(i);
			System.out.println("added" + " : " + i);
			ls.printList();
		}
		ls.addNodeMid(ls.head.next.next, 9);
		System.out.println("Final list display: ");
		ls.addNodeHead(12);
		ls.printList();
	}

}