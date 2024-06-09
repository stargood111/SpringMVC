package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-string")
public class RequestBodyJsonServlet extends HttpServlet{
	
	private ObjectMapper objectMapper = new ObjectMapper();
	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		
		   
		ServletInputStream inputStream = request.getInputStream();
		String messgeBoddy = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		System.out.println(messgeBoddy);
		HelloData helloData = objectMapper.readValue(messgeBoddy, HelloData.class);
		System.out.println("helloData.username = " + helloData.getUsername());
		System.out.println("helloData.age = " + helloData.getAge());
		
		response.getWriter().write("ok");
	}
}
