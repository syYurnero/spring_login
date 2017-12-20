package cn.tedu.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.tedu.login.entity.User;
@Repository("userDAO")
public class UserDaoSpringJdbcImpl implements UserDao {
	@Resource(name="jt")
	private JdbcTemplate jt;
	public User findByUsername(String uname) {
		String sql="select * from t_user where username=?";
		Object[] args={uname};
		User user=null;
		try{
			user=jt.queryForObject(sql, args,new UserRowMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		
		return user;
	}
	class UserRowMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int index) throws SQLException {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPwd(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			return user;
		}
		
	}
}
