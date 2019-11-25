//create a object of items using this class
public class Item {

	private String item_name;
	private double cost_price;
	private double selling_price;
	private int total_quantity;
	private int remaining_quantity;
	private double value;

	Item() {

	}

	Item(String item_name, double cp, double sp, int quantity) {
		this.item_name = item_name;
		this.cost_price = cp;
		this.selling_price = sp;
		this.total_quantity = quantity;
	}

	public void set_item_name(String item_name) {
		this.item_name = item_name;
	}

	public String get_item_name() {
		return item_name;
	}

	public void set_cost_price(double cost_price) {
		this.cost_price = cost_price;
	}

	public double get_cost_price() {
		return cost_price;
	}

	public void set_selling_price(double selling_price) {
		this.selling_price = selling_price;
	}

	public double get_selling_price() {
		return selling_price;
	}

	public void set_total_quantity(int quantity) {
		this.remaining_quantity = remaining_quantity + quantity;
		this.total_quantity = total_quantity + quantity;
	}

	public int get_total_quantity() {
		return total_quantity;
	}

	public int get_remaining_quantity() {
		return remaining_quantity;
	}

	public void calc_remaining_quantity(int sold_quantity) {                     //calculate remaining quantity after sale
		this.remaining_quantity = remaining_quantity - sold_quantity;
		if (remaining_quantity < 0) {
			remaining_quantity = 0;
			System.out.println("No more Items Remaining");
			
		}
	}
   
	public void set_calculate_value() {                             //calculate the value of an item
		value = remaining_quantity * cost_price;

	}

	public double get_calculate_value() {                            //returns the value of an item
		return value;
	}

	public void print_item_details() {
		System.out.println(item_name + " " + cost_price + " " + selling_price + " " + remaining_quantity + " " + value);
	}//debugging purpose

}
