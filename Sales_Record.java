/** for each sale the calculation of profit happens here **/

public class Sales_Record {

	private String item_name;
	private int total_quantity;
	private int quantity_sold;
	private double sp;
	private double cp;
	private double transaction_profit;
	public double value;

	// profit for each transaction is calculated
	public void calculate_transact_profit() {
		transaction_profit = sp * quantity_sold - cp * quantity_sold;

	}

	// return the transaction_profit
	public double get_transact_profit() {
		return transaction_profit;
	}

	public void set_item_name(String item_name) {
		this.item_name = item_name;
	}

	public String get_item_name() {
		return item_name;
	}

	public void set_total_quantity(int quantity) {
		this.total_quantity = quantity;
	}

	public int get_total_quantity() {
		return total_quantity;
	}

	public void set_quantity_sold(int quantitySold) {
		this.quantity_sold = quantitySold;
	}

	public int get_quantity_sold() {
		return quantity_sold;
	}

	public void set_sp(double sp) {
		this.sp = sp;
	}

	public double get_sp() {
		return sp;
	}

	public void set_cp(double cp) {
		this.cp = cp;
	}

	public double get_cp() {
		return cp;
	}

}
