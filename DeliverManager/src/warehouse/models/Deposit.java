package warehouse.models;

public class Deposit  {
	
	private Integer deposit_id;
	private Integer item_id;
	private Integer quantity;
	
	
	
	public Deposit(Integer deposit_id, Integer item_id, Integer quantity) {
		this(quantity, item_id);
		this.deposit_id = deposit_id;
		
	}
	
	public Deposit(Integer quantity, Integer item_id) {
		this.quantity = quantity;
		this.item_id = item_id;
	}
	
	

	public int getDeposit_id() {
		return deposit_id;
	}
	public void setDeposit_id(int deposit_id) {
		this.deposit_id = deposit_id;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Deposit [deposit_id=" + deposit_id + ", item_id=" + item_id + ", quantity=" + quantity + "]";
	}
	
	
}
