package warehouse.dao;

import java.util.List;

import warehouse.models.Deposit;

public interface DepositDao<T> {

	public int depositItem(Deposit id);
    public List <Deposit> listDeposits();
    
	
}
