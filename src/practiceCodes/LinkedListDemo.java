

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
		//System.out.println("successfully added node after" + ":" + prev.data);
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
		//System.out.println("added at head");
	}
	//deleting the element by key for first occurrences
	public void deleteByKey(int data) {
		Node n =head , prev_node=null;
		//if head contains the key value and we need to delete the head
		if(n!=null && n.data==data) {
			n=n.next;
			
		}//1->2->3->4->5->6
		//this while is just for iterating the node and checking the key position
		//the while loop will break by two reason 
		//1. either if next node is null 
		//2. or key is found
		//if node is null then the app will terminate else prev_node is changed to point to next
		while(n!=null && n.data!=data) {
		prev_node=n;
		n=n.next;
		}
		// if key is not found in the list
	if(n==null) return;
	//if key is found in the list
	prev_node.next=n.next;
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
			//System.out.println("added" + " : " + i);
			//ls.printList();
		}
		ls.addNodeMid(ls.head.next.next, 9);
		System.out.println("after adding  by given position a value : 9 ");
		ls.printList();
		//System.out.println("Final list display: ");
		ls.addNodeHead(12);
		System.out.println("after adding node to head : 12");
		ls.printList();
		ls.deleteByKey(3);
		System.out.println("after deletion by key : 3");
		ls.printList();
	}

}