import java.util.Scanner;
import java.time.LocalDate;

public class Calendar {

	public static void main(String[] args) {
		Calendar c = new Calendar();
		c.calendar();
	}

	public void calendar() {
		Scanner scanner = new Scanner(System.in);
		LocalDate todayDate = LocalDate.now();
		System.out.println("Enter an year");
		int year = scanner.nextInt();
		scanner.close();
		String month[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String days[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		int daysCount[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int space = spaces(year);
		if ((year % 400 == 0) | ((year % 100 != 0) & (year % 4 == 0)))
			daysCount[1] = 29;
		for (int i = 0; i < 12; i++) {
			int number = 1;
			if (space == 7)
				space = 0;
			String date[][] = new String[6][7];
			System.out.println("\t\t" + month[i]);
			for (int j = 0; j < days.length; j++)
				System.out.print(days[j] + "   ");
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 7; k++) {
					if (number > daysCount[i])
						space++;
					else if (space == 0)
						date[j][k] = Integer.toString(number++);
					else {
						date[j][k] = "0";
						space--;
					}
				}
			}
			if (space > 7)
				space = space - 7;
			for (int j = 0; j < 6; j++) {
				System.out.println();
				for (int k = 0; k < 7; k++) {
					if (date[j][k] == "0")
						System.out.print("      ");
					else if (date[j][k] != null) {
						if (Integer.parseInt(date[j][k]) < 10)
							System.out.print(" " + date[j][k] + "    ");
						else
							System.out.print(date[j][k] + "    ");
					}
				}
			}
			space = 7 - space;
			System.out.println();
		}
		System.out.print("\nCurrent Date : " + todayDate);
	}

	public static int spaces(int year) {
		int a;
		if ((year % 400 == 0) | ((year % 100 != 0) & (year % 4 == 0))) {
			a = year + ((year / 4) - 1) - ((year / 100) - (year / 400));
		} else {
			a = year + ((year / 4)) - ((year / 100) - (year / 400));
		}
		return a % 7;
	}
}