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
	 * junit在执行测试方法前会先执行@Before
	 * 修饰的方法.可以在这个方法里,做一些测试前
	 * 的准备工作.
	 */
	public void init(){
		ac=new ClassPathXmlApplicationContext("spring-mvc.xml");
		dao=ac.getBean("userDAO",UserDao.class);
	}
	@Test
	//测试连接池
	public void test1() throws SQLException{
//		BasicDataSource ds=ac.getBean("ds",BasicDataSource.class);
		/*
		 * DataSource是一个接口,BasicDataSource
		 * 是该接口的实现类.
		 */
		DataSource ds=ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	@Test
	//测试 数据访问层
	public void test2(){
		UserDao dao=ac.getBean("userDAO",UserDao.class);
		User user=dao.findByUsername("King");
		System.out.println(user);
	}
	@Test
	//测试 业务层
	public void test3(){
		LoginService service=ac.getBean("loginService",LoginService.class);
		User user=service.checkLogin("King", "1234");
		System.out.println("user:"+user);
	}
	@Test
	public void test4(){
		
	}
}
