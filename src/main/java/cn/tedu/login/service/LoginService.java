package cn.tedu.login.service;

import cn.tedu.login.entity.User;

/**
 * ҵ���ӿ�
 * @author Administrator
 *
 */
public interface LoginService {
	public User checkLogin(String uname,String pwd);
}
