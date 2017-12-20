package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.login.dao.UserDao;
import cn.tedu.login.entity.User;
import cn.tedu.login.service.LoginService;

public class TesstCase {
	private UserDao dao;
	private ApplicationContext ac;
	@Before
	/*
	 * junit��ִ�в��Է���ǰ����ִ��@Before
	 * ���εķ���.���������������,��һЩ����ǰ
	 * ��׼������.
	 */
	public void init(){
		ac=new ClassPathXmlApplicationContext("spring-mvc.xml");
		dao=ac.getBean("userDAO",UserDao.class);
	}
	@Test
	//�������ӳ�
	public void test1() throws SQLException{
//		BasicDataSource ds=ac.getBean("ds",BasicDataSource.class);
		/*
		 * DataSource��һ���ӿ�,BasicDataSource
		 * �Ǹýӿڵ�ʵ����.
		 */
		DataSource ds=ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	@Test
	//���� ���ݷ��ʲ�
	public void test2(){
		UserDao dao=ac.getBean("userDAO",UserDao.class);
		User user=dao.findByUsername("King");
		System.out.println(user);
	}
	@Test
	//���� ҵ���
	public void test3(){
		LoginService service=ac.getBean("loginService",LoginService.class);
		User user=service.checkLogin("King", "1234");
		System.out.println("user:"+user);
	}
	@Test
	public void test4(){
		
	}
}
