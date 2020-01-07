
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
		while(temp!=null && temp.next!=null && count<pos-1) {
			temp = temp.next;
			count++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return node;
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
