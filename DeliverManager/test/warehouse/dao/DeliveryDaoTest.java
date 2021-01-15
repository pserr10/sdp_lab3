package warehouse.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import warehouse.models.Delivery;

class DeliveryDaoTest {
	
	private DriverManagerDataSource dataSource;
	private DeliveryDaoImpl dao;
	
	@BeforeEach
	void setupBeforeEach() throws SQLException {
		
		dataSource = new DriverManagerDataSource();
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/warehouse?&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("raszx452");

		dao = new DeliveryDaoImpl(dataSource);
	}
	
	

	@Test
	void testRegisterDelivery() {
		Delivery delivery = new Delivery(5, 27, "Calçada Santana 100");
		int result = dao.registerDelivery(delivery);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdateAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDeliveries() {
		fail("Not yet implemented");
	}

}
