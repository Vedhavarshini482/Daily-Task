import java.util.Scanner;

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
		next = null;
	}
}

class LinkedList {
	Node head;
	Node tail;
	static int length = 0;

	LinkedList() {
		head = null;
		tail = null;
	}

	public void insert(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		length++;
	}

	public void replaceAtPosition(int position, int value) {
		Node node = new Node(value);
		Node traverse;
		traverse = head;
		for (int i = 1; i < position - 1; i++) {
			traverse = traverse.next;
		}
		node.next = traverse.next.next;
		traverse.next = node;
	}

	public void insertAtPosition(int position, int value) {
		Node node = new Node(value);
		Node traverse;
		traverse = head;
		for (int i = 1; i < position - 1; i++)
			traverse = traverse.next;
		node.next = traverse.next;
		traverse.next = node;
		length++;
	}

	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public void deleteElement() {
		Node node = head;
		for (int i = 1; i < length - 1; i++)
			node = node.next;
		node.next = null;
	}

	public void deleteElementAtPosition(int position) {
		Node temp = head;
		for (int i = 1; i < position - 1; i++)
			temp = temp.next;
		temp.next = temp.next.next;

	}

	public int linkedListLength() {
		return length;
	}
}

public class DSLinkedList {

	public static void main(String[] args) {
		DSLinkedList linkedList = new DSLinkedList();
		linkedList.listImplementation();
	}

	public void listImplementation() {
		LinkedList list = new LinkedList();
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Exit --> 0\nInsert an element --> 1\nDelete an element --> 2\nLength of the LinkedList --> 3\nInsert an element at given position --> 4\nDelete an elements at given position --> 5\nReplace an element at given position --> 6\nTo print the List --> 7");
		for (;;) {
			System.out.println("Enter any number for operations");
			switch (scanner.nextInt()) {
			case 0:
				scanner.close();
				return;
			case 1:
				System.out.println("Enter an element");
				list.insert(scanner.nextInt());
				break;
			case 2:
				list.deleteElement();
				break;
			case 3:
				list.linkedListLength();
				break;
			case 4:
				System.out.println("Enter the position");
				int position = scanner.nextInt();
				System.out.println("Enter an element");
				int element = scanner.nextInt();
				list.insertAtPosition(position, element);
				break;
			case 5:
				System.out.println("Enter the position");
				position = scanner.nextInt();
				list.deleteElementAtPosition(position);
				break;
			case 6:
				System.out.println("Enter the position");
				position = scanner.nextInt();
				System.out.println("Enter an element to replace");
				element = scanner.nextInt();
				break;
			case 7:
				list.printList();
			}
		}
	}
}