import java.util.*;

public class LinkedListReverse {

	private  LinkedList<Node> list; 
	private final static int END = 10;
	
	public LinkedListReverse() {
		list = new LinkedList<Node>();
		for (int i=0; i <= END; i++) {
			Node node = new Node(i);
			list.add(node);
			if (i != END) {
				Node next = new Node(++i);
				node.setNext(next);
			}
		}
	}
	
	public void printList() {
		System.out.println("_________________________");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Node node = (Node)it.next();
			System.out.println(node.value);
			if (node.value != END)
				System.out.println(node.next.value);
		}
	}
	
	class Node {
		int value;
		Node next;
		Node(int value) { this.value = value; }
		void setNext(Node node) { next = node; }
		Node getNext() { return next; }
	}
	
	public Node reverse(Node head, Node node) {
		if(head == null) {
			return node;
		} else {
			Node tmp = head.getNext();
			head.setNext(node);
			return reverse(tmp, head);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListReverse r = new LinkedListReverse();
		r.printList();
		r.reverse(r.list.get(0), r.list.get(0).getNext());
		r.printList();
			
	}

}
