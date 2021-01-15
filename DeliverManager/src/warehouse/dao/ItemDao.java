package warehouse.dao;
import java.util.*;

import warehouse.models.Delivery;
import warehouse.models.Deposit;
import warehouse.models.Item;



public interface ItemDao<T> {
    

	public int registerItem(Item item);
	public int updateDescription(Item item);
	public Item get(Integer id);
    public int delete(Integer id); 
    public List<T> getAll();
    
    //deposits methods
    
    
    
    //deliveries methods
    
   /* public int registerDelivery(Delivery delivery);
    public int updateDeliveryAddress (Delivery delivery);
    public List <T> getDeliveries();*/
    
    
}
    
    
    
    