package cn.tedu.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.login.entity.User;

/**
 * ���ݷ��ʲ�ʵ����
 * @author Administrator
 *	ע:@Repository(�־û�):���ݷ��ʲ�Ӧ��ʹ��ע��
 *	,�������ɨ��
 *		
 */
//@Repository("userDAO")
public class UserDaoJdbcImpl implements UserDao{
	@Resource(name="ds")
	private DataSource ds;
	public User findByUsername(String uname){
		User user=null;
		Connection conn=null;
		try {
			conn=ds.getConnection();
			String sql="select * from t_user where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(uname);
				user.setPwd(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
		return user;
	}
}
