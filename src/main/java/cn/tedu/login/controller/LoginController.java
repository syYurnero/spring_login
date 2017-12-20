package cn.tedu.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.login.entity.User;
import cn.tedu.login.service.AppException;
import cn.tedu.login.service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService service;
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session){
		System.out.println("login();");
		String uname=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		System.out.println("uname:"+uname+"pwd"+pwd);
		//����ҵ���ķ�����е�¼��֤
		User user=service.checkLogin(uname, pwd);
		//������,����session��֤.
		session.setAttribute("user", user);
		//��½�ɹ�,�ض�����ҳ
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	@ExceptionHandler
	public String handle(Exception e,HttpServletRequest request){
		System.out.println("handle()");
		if(e instanceof AppException){
			//Ӧ���쳣
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		//ϵͳ�쳣
		return "error";
	}
}
