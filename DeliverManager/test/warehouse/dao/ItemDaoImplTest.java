package warehouse.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import warehouse.models.Item;

class ItemDaoImplTest {
	private DriverManagerDataSource dataSource;
	private ItemDaoImpl dao;
	
	@BeforeEach
	void setupBeforeEach() throws SQLException {
		
		dataSource = new DriverManagerDataSource();
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/warehouse?&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("raszx452");

		dao = new ItemDaoImpl(dataSource);
	}
	
	@Test
	void testRegisterItem() {
		Item item = new Item("Computador", " Portátil 17 ,1TB disco, 32GB ram");
		int result = dao.registerItem(item);
		assertTrue(result > 0);
	}

	@Test
	void testupdateDescription() {
		Item item = new Item(1,"Portátil 16 ,1TB disco, 32GB ram");
		int result = dao.updateDescription(item);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Item registeredItem = dao.get(id);
		if(registeredItem != null) {
			
			System.out.println(registeredItem);
		}
		
		assertNotNull(registeredItem);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);
		
		assertTrue (result > 0);
	}

	@Test
	void testGetAll() {
		List<Item> registeredItems = dao.getAll();
		
		for(Item item : registeredItems) {
			System.out.println(registeredItems);
		}
		assertTrue(!registeredItems.isEmpty());
	
	}

}
