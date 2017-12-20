package cn.tedu.login.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * ����session��֤��������
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//���session
		HttpSession session=request.getSession();
		//ͨ��session�����ȡ����
		Object obj=session.getAttribute("user");
		if(obj==null){
			//û�е�¼,�ض��򵽵�¼ҳ��
			System.out.println("û�е�¼");
			response.sendRedirect("toLogin.do");
			return false;
		}
		//��½��,���������
		System.out.println("��½��");
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
	
}
