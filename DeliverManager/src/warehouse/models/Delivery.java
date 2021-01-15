package warehouse.models;

public class Delivery{
	
	private Integer delivery_id;
	private String delivery_address;
	private Integer item_id;
	private Integer quantity;

	
	public Delivery(Integer delivery_id, String delivery_address, Integer item_id, Integer quantity) {
		this(quantity, item_id, delivery_address);
		this.delivery_id = delivery_id;
	}
	
	public Delivery(int i, int j, String k) {
		this.item_id = i;
		this.quantity = j;
		this.delivery_address = k;
	}

	public Integer getDelivery_id() {
		return delivery_id;
	}
	public void setDelivery_id(Integer delivery_id) {
		this.delivery_id = delivery_id;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
