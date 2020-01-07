
public class Main {
	public static void main(String args[]) {
		LinkedList a = new LinkedList(10);
		a.insertFront(20);
		a.insertFront(30);
		a.insertRare(40);
		a.insertRare(50);
		//a.insertAtPos(70, 2);
		a.insertAtPos(90, 1);
		a.insertAtPos(80, 0);
		a.printList();
	}
}
