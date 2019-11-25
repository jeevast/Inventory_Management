
/**class that acts as a terminal, one that recieves command from the user
**/

import java.util.Scanner;

public class Main_Class {

	public static void main(String[] args) {
		Interface_Class face = new Interface_Class();
		while (true) {
			Scanner in = new Scanner(System.in);
			String arr[] = in.nextLine().split(" ");
			face.generate_command(arr);
		}
	}

}
