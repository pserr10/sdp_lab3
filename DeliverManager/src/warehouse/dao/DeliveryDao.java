package warehouse.dao;

import java.util.List;

import warehouse.models.Delivery;

public interface DeliveryDao<T> {
	
	public int registerDelivery(Delivery delivery);
	public int updateAddress(Delivery delivery);
	public List<T> getDeliveries();
	
	
}
