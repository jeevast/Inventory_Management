/** acts as a bridge between the user and the operation **/

public class Interface_Class {

	Command_Operation com = new Command_Operation();// class used to operate given commands

	// match command with respective operation
	public void generate_command(String[] command_line) {
		
		String command = command_line[0];
		switch (command) {
		case "create":
			create_command_parser(command_line);
			break;
		case "delete":
			delete_command_parser(command_line);
			break;
		case "updateBuy":
			updateBuy_command_parser(command_line);
			break;
		case "updateSell":
			updateSell_command_parser(command_line);
			break;
		case "updateSellPrice":
			updateNewPrice(command_line);
		case "print":
			print_details(command_line);
			break;
		case "printSalesRecord":
			print_sales_record();
			break;
		case "report":
			printReport();
			break;
		default:
			System.out.println("Either no command or wrong command recieved");
			break;

		}
	}

	// parse the create command and pass through the operation
	public void create_command_parser(String[] command_line) {
		try {
			String item_name = command_line[1];
			double cp = Math.round(Double.parseDouble(command_line[2]) * 100.0)/100.0;
			double sp = Math.round(Double.parseDouble(command_line[3]) * 100.0)/100.0;
			com.create(item_name, cp, sp);
			System.out.println("Command Successfull");
		} catch (Exception e) {

			System.out.println("you've given a wrong command");

		}
	}

	// parse the delete command and pass through the operation
	public void delete_command_parser(String[] command_line) {
		try {
			String item_name = command_line[1];
			com.delete(item_name);
			System.out.println("Command Successfull");
		} catch (Exception e) {
			System.out.println("you've given a wrong command");
		}

	}

	// parse the updateBuy command and pass through the operation
	public void updateBuy_command_parser(String[] command_line) {
		try {
			String item_name = command_line[1];
			int quantity = Integer.parseInt(command_line[2]);
			com.update_buy_item_quantity(item_name, quantity);
			System.out.println("Command Successfull");
		} catch (Exception e) {
			System.out.println("you've given a wrong command");
		}
	}

	// parse the updateSell command and pass through the operation
	public void updateSell_command_parser(String[] command_line) {
		try {
			String item_name = command_line[1];
			int quantity = Integer.parseInt(command_line[2]);
			com.update_sell_item_quantity(item_name, quantity);
			System.out.println("Command Successfull");
		} catch (Exception e) {
			System.out.println("you've given a wrong command");
		}
	}

	//debugging purpose
	public void print_details(String[] command_line) {
		String item_name = command_line[1];
		com.print_item_desc(item_name);
	}
	
	//debugging purpose
	public void print_sales_record() {
		com.print_sales_record();
	}

	//updates to the new price
	public void updateNewPrice(String[] command_line) {
		try {
			String item_name = command_line[1];
			double new_price = Double.parseDouble(command_line[2]);
			com.newPrice(item_name, new_price);
			System.out.println("Command Successfull");
		} catch (Exception e) {
			System.out.println("you've given a wrong command");
		}
	}

	//prints entire report by using the function in command_operation
	public void printReport() {
		try {
			com.print_report();
		} catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
	}

}
