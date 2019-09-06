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

@WebServlet("/Registration")
public class RegServlet extends HttpServlet{
	
	static Logger logger = Logger.getLogger(RegServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("registration.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		name = name == null ? "" : name.replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		String login = req.getParameter("login");
		login = login == null ? "" : login.replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		String password = req.getParameter("password");
		password = password == null ? "" : password.replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		String email = req.getParameter("email");
		email = email == null ? "" : email.replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		User user = new User(1, name, login, password, email);
		logger.info(user);
		PrintWriter writer = resp.getWriter();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
		
		if(validate(user, validator, req, resp)) {
			DBModel model = new DBModel();				
			if(model.putUserDB(name, login, password, email)) {
				SSLEmail msg = new SSLEmail();
				msg.sendProps(email);
				alert("Security email send", req, resp);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} else {		
				alert("This login/username or email is already taken", req, resp);
			}
			
		} else {	
			alert("Incorrect input", req, resp);
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Default
	public static boolean validate(Object object, Validator validator, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
	    String msgName = "";
	    String msgLogin = "";
	    String msgPass = "";
	    String msgEmail = "";
	    logger.info(String.format("Errors: %d", constraintViolations.size()));
	    
	    if(constraintViolations.size() == 0) {
	    	logger.info("Validation complete");
	    	return true;
	    	
	    } else {
	    	Map<String, String> err = new HashMap<>();
		    for (ConstraintViolation<Object> cv : constraintViolations) {	
		    	if (cv.getPropertyPath().toString().equals("name")) {
		    		msgName += cv.getMessage() + "<br>";
		    		err.put("nameErr", msgName);		    		
		    		logger.info(err.get("nameErr"));	 
		    	}
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
		RequestDispatcher rDispatcher = req.getRequestDispatcher("registration.jsp");
		PrintWriter writer = resp.getWriter();
		writer.println("<script>alert('" + message + "')</script>");
		rDispatcher.include(req, resp);
	}

}
