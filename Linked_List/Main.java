
public class Main {
	public static void main(String args[]) {
		LinkedList a = new LinkedList(10);
//		a.insertFront(20);
//		a.insertFront(30);
		a.insertRare(10);
		a.insertRare(20);
		a.insertRare(30);
		a.insertRare(40);
		a.insertRare(50);
		a.insertAtPos(70, 1);
		a.insertAtPos(90, 2);
		//a.insertAtPos(80, 0);
		//a.deleteFirst();
//		a.deleteLast();
//		a.deleteAtPos(1);
		a.printList();
		System.out.println("''''''''''''''''''''''' Reveresed order '''''''''''''''''''''''''''''''''");
		a.reverse();
		a.printList();
	}
}
