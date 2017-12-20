package cn.tedu.login.dao;

import cn.tedu.login.entity.User;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserDao {
	public User findByUsername(String uname);
}
