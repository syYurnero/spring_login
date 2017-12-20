package cn.tedu.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.login.dao.UserDao;
import cn.tedu.login.entity.User;
/**
 * ҵ���ʵ����
 *	ע:ҵ���Ӧ��ʹ��@Service,����
 *	���ɨ��.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="userDAO")
	private UserDao dao;
	
	public User checkLogin(String uname, String pwd) {
		User user=null;
		user=dao.findByUsername(uname);
		if(user==null){
			/*
			 * �׳�Ӧ���쳣:
			 * (�˽�)
			 * Ӧ���쳣,ָ������Ϊ�û��Ĵ������������쳣
			 * ,�����û�����д����.�������쳣����֮��,
			 * Ӧ�ø��û���ȷ����ʾ.
			 */
			throw new AppException("�û�������");
		}
		if(!user.getPwd().equals(pwd)){
			throw new AppException("�������"); 
		}
		//��¼��֤ͨ��
		return user;
	}
	
}
