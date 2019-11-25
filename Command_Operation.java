
/** performs the required operation for the respective commands**/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.text.DecimalFormat;

public class Command_Operation {

	public HashMap<String, Item> map = new HashMap<String, Item>();// item_name and items object gets stored here
	ArrayList<Sales_Record> list = new ArrayList<Sales_Record>();// every record of sale is stored here to get displayed
																	// in report
	ArrayList<String> items = new ArrayList<String>();// name of the items used to traverse through hashmap when
														// required
	public double deleted_price = 0;
	private static DecimalFormat df = new DecimalFormat("0.00");

	// create a new item in a map and in list
	public void create(String item_name, double cp, double sp) {

		Item item = new Item();
		item.set_item_name(item_name);
		item.set_cost_price(cp);
		item.set_selling_price(sp);
		map.put(item_name, item);
		items.add(item_name);
		Collections.sort(items);

	}

	// delete the item from the map and array_list
	public void delete(String item_name) {
		deleted_price = map.get(item_name).get_cost_price() * map.get(item_name).get_remaining_quantity();
		map.remove(item_name);
		items.remove(item_name);
	}

	// update the no of quantity of items in the item's object
	public void update_buy_item_quantity(String item_name, int additional_quantity) {
		map.get(item_name).set_total_quantity(additional_quantity);

	}

	// sales record of the sales happened
	public void update_sell_item_quantity(String item_name, int sold_quantity) {
		Item item = map.get(item_name);
		if (sold_quantity > item.get_remaining_quantity()) {
			System.out.println("This operation cannot be done");
		} else {
			item.calc_remaining_quantity(sold_quantity);
			update_sell_procedure(item, sold_quantity);
		}

	}

	// Helper method for the sales record
	public void update_sell_procedure(Item item, int sold_quantity) {
		Sales_Record rec = new Sales_Record();
		rec.set_item_name(item.get_item_name());
		rec.set_total_quantity(item.get_total_quantity());
		rec.set_cp(item.get_cost_price());
		rec.set_sp(item.get_selling_price());
		rec.set_quantity_sold(sold_quantity);
		rec.calculate_transact_profit();
		list.add(rec);

	}

	// given the command "print item_name" displays items details (debugging
	// purpose)
	public void print_item_desc(String item_name) {
		map.get(item_name).print_item_details();
	}

	public void newPrice(String item_name, double new_price) {
		map.get(item_name).set_selling_price(new_price);
	}

	// debugging purpose, used to print all the sales record
	public void print_sales_record() {
		for (Sales_Record rec : list)
			System.out.println(rec.get_item_name() + " " + rec.get_transact_profit());
	}

	// print the entire report
	public void print_report() {
		print_all();
	}

	// Helper function to print entire report
	public void print_all() {
		double total_value = 0;
		double profit = 0;
		System.out.println("\t\t INVENTORY REPORT");
		System.out.println("Item Name   " + "\t\t" + "Bought At   " + "\t\t" + "Sold At     " + "\t\t" + "AvailableQty"
				+ "\t\t" + "Value       ");
		System.out.println();
		System.out.println("---------" + "\t\t" + "---------" + "\t\t" + "---------" + "\t\t" + "---------" + "\t\t"
				+ "---------");
		// display items
		for (String li : items) {
			Item item = map.get(li);
			item.set_calculate_value();
			total_value = item.get_calculate_value() + total_value;
			System.out.println(item.get_item_name() + "\t\t\t " + df.format(item.get_cost_price()) + "\t\t\t "
					+ df.format(item.get_selling_price()) + "\t\t\t " + item.get_remaining_quantity() + "\t\t\t "
					+ df.format(item.get_calculate_value()));
		}

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println("Total Value" + "\t\t\t\t\t\t" + df.format(total_value));

		// calculate sum of profit for every sales
		for (Sales_Record sales : list) {
			profit = profit + sales.get_transact_profit();

		}

		System.out.println("Profit since previous report" + "\t\t\t\t" + df.format(profit - deleted_price));
		deleted_price = 0;
		list.removeAll(list);

	}
	
    
}
