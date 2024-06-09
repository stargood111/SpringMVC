package hello.servlet.basic;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.server.ResponseStatusException;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name ="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("HelloServlet.service");
		System.out.println(request);
		System.out.println(request);
		
		String username = request.getParameter("username");
		System.out.println(username);

		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("hello " + username);
	}
}
