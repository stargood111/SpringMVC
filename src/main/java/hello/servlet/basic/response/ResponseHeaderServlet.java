package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responserHeaderServlet", urlPatterns = "/reponse-header")
public class ResponseHeaderServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		// [status-line]
		response.setStatus(HttpServletResponse.SC_OK);
		//response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		
		// [response-headers]
		response.setHeader("Content-Type", "test/plain;charset=utf-8");
		response.setHeader("Content-Controller", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-header", "hello");
		
		// [Header 편의 메서드]
		//content(response);
		//cookie(response);
		redirect(response);
		
		// [messege body]
		PrintWriter writer = response.getWriter();
		writer.println("ok");
	}
	private void content(HttpServletResponse response){
		// [status-line]
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
//		// [response-headers]
//		response.setHeader("Content-Type", "test/plain;charset=utf-u");
//		response.setHeader("Content-Controller", "no-cache, no-store, must-revalidate");
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("my-header", "hello");
	}
	private void cookie(HttpServletResponse response){
		
		Cookie cookie = new Cookie("MyCookie","good");
		cookie.setMaxAge(600);//600초
		response.addCookie(cookie);
	}
	private void redirect(HttpServletResponse response) throws IOException{
		
		//response.setStatus(HttpServletResponse.SC_FOUND); //302 
		//response.setHeader("Location", "/basic/hello-form.html");//600초
		response.sendRedirect("/basic/hello-form.html");
	}	
}
