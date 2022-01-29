
public class LinkedList<I extends Number> {

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
	  void deleteFirst() {
		  this.node = Node.deleteFirst(this.node);
	  }
	  void deleteLast() {
		  this.node = Node.deleteLast(this.node);
	  }
	  void deleteAtPos(int pos) {
		  this.node = Node.deleteAtPos(this.node, pos);
	  }
	  void reverse() {
		  this.node = Node.reverse(this.node);
	  }
	  void printList() {
		node.printList();
	  }
	  
	  
}
