package cn.tedu.login.dao;

import cn.tedu.login.entity.User;

/**
 * ���ݷ��ʽӿ�
 * @author Administrator
 *
 */
public interface UserDao {
	public User findByUsername(String uname);
}
