package warehouse.dao;
import warehouse.models.Item;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;


public class ItemDaoImpl implements ItemDao<Item> {

	// connect to databases using JDBC
	private JdbcTemplate jdbcTemplate;

	public ItemDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int registerItem(Item item) {  //register items in warehouse
		String sql = "INSERT INTO items (name, description)" + "VALUES( ?, ?)";
		return jdbcTemplate.update(sql, item.getTypeName(), item.getDescription() );	
	}

	@Override
	public int updateDescription(Item item) {	//update items description by id
		String sql = "UPDATE items SET  description=? WHERE item_id=?";
		return jdbcTemplate.update(sql, item.getDescription(), item.getItem_id());

	}

	@Override
	public Item get(Integer id) {  //get one item by id <not use if usable yet>
		String sql = "Select * from items WHERE item_id=" + id;
		
		ResultSetExtractor<Item> extractor = new ResultSetExtractor<Item>() {

			@Override
			public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String typeName = rs.getString("name");
					String description = rs.getString("description");
					return new Item(id, typeName, description);
				}
				return null;
			}
			
		};
		
		return jdbcTemplate.query(sql, extractor);
	}
	
	@Override
	public List<Item> getAll() { //gets all items but prints two times (?)
		String sql = "SELECT * FROM items";
		
		RowMapper<Item> rowMapper = new RowMapper<Item>() {

			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("item_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				return new Item(id, name, description);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	
	@Override
	public int delete(Integer id) { //este método n se certifica se o item tem depósito ou entrega registado
		String sql = "DELETE FROM items WHERE item_id=" + id;
		return jdbcTemplate.update(sql);
	}

	
	


}
