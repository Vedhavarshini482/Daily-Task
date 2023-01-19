import java.util.Scanner;

class ArrayList {
	static int count;
	static int array[] = new int[5];

	public static void insert(int num) {
		if (count % 5 == 0) {
			int temp[] = array.clone();
			array = new int[array.length + 5];
			for (int i = 0; i < temp.length; i++)
				array[i] = temp[i];

		}
		array[count] = num;
		count++;
	}

	public static void delete(int index) {
		count--;
		for (int i = index - 1; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
	}

	public static void printArray() {
		int length = array.length - count;
		for (int i = 0; i < array.length - length; i++)
			System.out.print(array[i] + " ");
	}
}

public class Arrays {

	public static void main(String[] args) {
		Arrays array = new Arrays();
		array.arrays();
	}

	public void arrays() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int size = scanner.nextInt();
		System.out.println("Enter the elements");
		for (int i = 0; i < size; i++)
			ArrayList.insert(scanner.nextInt());
		for (;;) {
			System.out.println("If you want to delete an element please enter YES or else enter NOq");
			String confirmation = scanner.next();
			if (confirmation == "YES") {
				System.out.println("Enter which index you want to delete");
				ArrayList.delete(scanner.nextInt());
			} else {
				scanner.close();
				break;
			}
		}
		ArrayList.printArray();
	}
}