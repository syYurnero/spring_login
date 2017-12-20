package cn.tedu.login.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用于session验证的拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获得session
		HttpSession session=request.getSession();
		//通过session对象获取数据
		Object obj=session.getAttribute("user");
		if(obj==null){
			//没有登录,重定向到登录页面
			System.out.println("没有登录");
			response.sendRedirect("toLogin.do");
			return false;
		}
		//登陆过,则允许访问
		System.out.println("登陆过");
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
	
}
