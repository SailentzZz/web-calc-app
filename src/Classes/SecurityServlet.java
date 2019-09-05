package Classes;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/Security")
public class SecurityServlet extends HttpServlet{

	static Logger logger = Logger.getLogger(RegServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("security.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = req.getParameter("email");
		email = email == null ? "" : email.replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();       
		User user = new User(1, "wwww", "hgjhg", "hhfhf", email);
		
		if(validate(user, validator, req, resp)) {
			DBModel model = new DBModel();
        	String[] answer = model.emailVerification(email);
        	
			if(answer != null) {
				SSLEmail message = new SSLEmail();
				message.sendOrder(email, answer[0], answer[1]);
				alert("Security email send", req, resp);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				
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
	    String msgEmail = "";
	    logger.info(String.format("Errors: %d", constraintViolations.size()));
	    
	    if(constraintViolations.size() == 0) {
	    	logger.info("Validation complete");
	    	return true;
	    	
	    } else {
	    	Map<String, String> err = new HashMap<>();
		    for (ConstraintViolation<Object> cv : constraintViolations) {	
		    	if (cv.getPropertyPath().toString().equals("email")) {
		    		msgEmail += cv.getMessage() + "<br>";
		    		err.put("EmailErr", msgEmail);		    		
		    		logger.info(err.get("EmailErr"));
		    	}
		    }
		    req.setAttribute("Errors", err);
		    
		    return false;
	    }
	}
	
	public static void alert(String message, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher rDispatcher = req.getRequestDispatcher("security.jsp");
		PrintWriter writer = resp.getWriter();
		writer.println("<script>alert('" + message + "')</script>");
		rDispatcher.include(req, resp);
	}
	
}
