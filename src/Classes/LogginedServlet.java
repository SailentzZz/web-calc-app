package Classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.enterprise.inject.Default;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;

@WebServlet("/Login")
public class LogginedServlet extends HttpServlet {
	
	static Logger logger = Logger.getLogger(RegServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = req.getParameter("login");
		login = login == null ? "" : login.replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		String password = req.getParameter("password");
		password = password == null ? "" : password.replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();       
		User user = new User(1, "wwww", login, password, "fsdfsdfsd@mail.com");
        
        if(validate(user, validator, req, resp)) {
			DBModel model = new DBModel();
        	user = model.getUserValidation(login, password);
        	
			if(user != null) {
				ArrayList<Operation> answer = model.getOperations(user);
				Collections.reverse(answer);
				req.getSession().setAttribute("User", user);
				req.getSession().setAttribute("answer", answer);
				req.getRequestDispatcher("home.jsp").forward(req, resp);
				
			} else {
				alert("User not exist", req, resp);
			}
        } else {
        	alert("Incorrect input", req, resp);
        }
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Default
	public static boolean validate(Object object, Validator validator, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
	    String msgLogin = "";
	    String msgPass = "";
	    logger.info(String.format("Errors: %d", constraintViolations.size()));
	    
	    if(constraintViolations.size() == 0) {
	    	logger.info("Validation complete");
	    	return true;
	    	
	    } else {
	    	Map<String, String> err = new HashMap<>();
		    for (ConstraintViolation<Object> cv : constraintViolations) {	
		    	if (cv.getPropertyPath().toString().equals("logging")) {
		    		msgLogin += cv.getMessage() + "<br>";
		    		err.put("loginErr", msgLogin);		    		
		    		logger.info(err.get("loginErr"));
		    	}
		    	if (cv.getPropertyPath().toString().equals("password")) {
		    		msgPass += cv.getMessage() + "<br>";
		    		err.put("passwordErr", msgPass);		    		
		    		logger.info(err.get("passwordErr"));
		    	}
		    }
		    req.setAttribute("Errors", err);
		    
		    return false;
	    }
	}
	
	public static void alert(String message, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher rDispatcher = req.getRequestDispatcher("login.jsp");
		PrintWriter writer = resp.getWriter();
		writer.println("<script>alert('" + message + "')</script>");
		rDispatcher.include(req, resp);
	}

}
