package Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet{
	
	Logger logger = Logger.getLogger(HomeServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("default.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("logout") != null) {
			req.getSession().invalidate();
			req.getRequestDispatcher("default.jsp").forward(req, resp);
			return;
		}
		
		String text = req.getParameter("Text").replaceAll("[\\s|\\u00A0]+", "");
		logger.info(text);
		
		DBModel model = new DBModel();
		User user = (User) req.getSession().getAttribute("User");
		
		if (user != null) {	
			model.putOperation(user, text, new Date());
			ArrayList<Operation> answer = model.getOperations(user);
			Collections.reverse(answer);
			req.setAttribute("value", 1);
			req.setAttribute("answer", answer);
			req.setAttribute("textValue", text);		
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		} else {
			req.setAttribute("textValue", text);
			req.getRequestDispatcher("default.jsp").forward(req, resp);
		}
		
	}
	
	
	
}