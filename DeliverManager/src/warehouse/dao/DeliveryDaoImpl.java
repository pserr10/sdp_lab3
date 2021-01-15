package warehouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import warehouse.models.Delivery;

public class DeliveryDaoImpl implements DeliveryDao<Delivery>{
	private JdbcTemplate jdbcTemplate;
	
	public DeliveryDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int registerDelivery(Delivery delivery) {  //este método n está completo, só regista uma entrega com um item, e não coleção de items
		String sql = "INSERT INTO deliveries (item_id, quantity, address)" + "VALUES(?,?,?)";
		return jdbcTemplate.update(sql, delivery.getItem_id(), delivery.getQuantity(), delivery.getDelivery_address());
	}

	@Override
	public int updateAddress(Delivery delivery) {
		String sql = "UPDATE deliveries SET address=? WHERE deliveries_id=?";
		return jdbcTemplate.update(sql, delivery.getDelivery_address(), delivery.getDelivery_id());
	}

	@Override
	public List<Delivery> getDeliveries() {
		String sql = "SELECT * FROM deliveries";
		
		RowMapper<Delivery> rowMapper = new RowMapper<Delivery>() {

			@Override
			public Delivery mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer delivery_id = rs.getInt("deliveries_id");
				String address = rs.getString("address");
				Integer quantity = rs.getInt("quantity");
				Integer item_id = rs.getInt("item_id");
				return new Delivery(delivery_id, address, quantity, item_id);
			}
			
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
}
