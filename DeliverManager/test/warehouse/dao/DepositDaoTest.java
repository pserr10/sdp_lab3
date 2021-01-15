package warehouse.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import warehouse.models.Deposit;
import warehouse.models.Item;

class DepositDaoTest {
	
	private DriverManagerDataSource dataSource;
	private DepositDaoImpl dao;
	
	@BeforeEach
	void setupBeforeEach() throws SQLException {
		
		dataSource = new DriverManagerDataSource();
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/warehouse?&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("raszx452");

		dao = new DepositDaoImpl(dataSource);
	}
	
	

	@Test
	void testDepositItem() {
		Deposit deposit = new Deposit(43, 6); 
		int result = dao.depositItem(deposit);
		assertTrue(result > 0);
	}

	@Test
	void testListDeposits() {
		List<Deposit> listOfDeposits = dao.listDeposits();
		
		for(Deposit listOff : listOfDeposits) {
			System.out.println(listOff);
		}
		
		 assertTrue(!listOfDeposits.isEmpty());
	}

}
