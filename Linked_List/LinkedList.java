
public class LinkedList {

	Node node;
//	Node next = Node.next(this.node);
//	int data = Node.data(this.node);
	LinkedList(int data){
		this.node = new Node(data); 
		
	}
	  void insertFront(int data){
		this.node = Node.insertFront(this.node, data);
	 }
	  
	  void insertRare(int data) {
		this.node = Node.insertRare(this.node, data);
	  }
	  
	  void insertAtPos(int data, int pos) {
		  this.node = Node.insertAtPos(this.node, data, pos);
	  }
	  void printList() {
		node.printList();
	  }
	  
	  
}
