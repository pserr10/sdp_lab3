package warehouse.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import warehouse.models.Deposit;


public class DepositDaoImpl implements DepositDao<Deposit> {
	private JdbcTemplate jdbcTemplate;

	public DepositDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//falta método para depositar uma coleção de items com indicação de quantidade de cada itme
	
	
	@Override
	public int depositItem(Deposit deposit) {
		String sql = "INSERT INTO deposits (item_id, quantity)" + "VALUES( ?, ?)";
		return jdbcTemplate.update(sql, deposit.getItem_id(), deposit.getQuantity());	
		
	}

	@Override
	public List<Deposit> listDeposits() {
		String sql = "Select * FROM deposits";
		
			RowMapper<Deposit> rowMapper = new RowMapper<Deposit>() {

			@Override
			public Deposit mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer deposits_id = rs.getInt("deposits_id");
				Integer quantity = rs.getInt("quantity");
				Integer item_id = rs.getInt("item_id");
				return new Deposit(deposits_id, quantity, item_id );
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	
}
	
