
public class Node {
	private int data;
	private Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
//	static Node next(Node node) {
//		return node.next;
//	}
//	
//	static int data(Node node) {
//		return node.data;
//	}
	
	static Node insertFront(Node node,int data) {
		Node  newNode = new Node(data);
		newNode.next = node;
		return newNode;
	}
	
	static Node insertRare(Node node, int data) {
		Node  newNode = new Node(data);
		Node temp = node;
		while(temp!=null && temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return node;
	}
	static Node insertAtPos(Node node, int data, int pos) {
		Node  newNode = new Node(data);
		int count = 1;
		Node temp = node;
		if(pos == 0)
			return insertFront(node,data);
		while(temp!=null && temp.next!=null && count<pos) {
			temp = temp.next;
			count++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return node;
	}
	
	static Node deleteFirst(Node node) {
		return node.next;
	}
	
	static Node deleteLast(Node node) {
		Node temp = node;
		while(temp!=null && temp.next!=null && temp.next.next!=null)
			 temp = temp.next;
		temp.next = null;
		return node;
	}
	static Node deleteAtPos(Node node, int pos) {
		Node temp = node;
		while(temp!=null && temp.next!=null && --pos>0) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return node;
	}
	static Node reverse(Node head) {
		Node node = head;
		Node temp = null;
		while(head!=null) {
		  head = head.next;		  
		  node.next = temp;
		  temp = node;
		  node = head;
		}
		
		return temp;
	}
	public void printList()
	{
		Node temp = this;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
