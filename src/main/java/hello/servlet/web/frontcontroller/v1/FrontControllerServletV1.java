package hello.servlet.web.frontcontroller.v1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormContorllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet{

	private Map<String,ControllerV1> controllerMap = new HashMap<>();
	
	
		public FrontControllerServletV1() {
		controllerMap.put("/front-controller/v1/members/new-form", new MemberFormContorllerV1());
		controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
		controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
	}

		@Override
		protected void service(HttpServletRequest request 	, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("FrontContorllerServletV1.service");
		
		String reqeustURI= request.getRequestURI();
		
		ControllerV1 controller =  controllerMap.get(reqeustURI);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		controller.process(request, response);
	}
}
