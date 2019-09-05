package Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.junit.Test;

import Classes.HomeServlet;

public class HomeServletTest {

	Logger logger = Logger.getLogger(HomeServlet.class); 
	
	@Test
	public void test() throws ServletException, IOException {		
		logger.info("Test all right");
		
		HomeServlet servlet = new HomeServlet();
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);
		
		when(request.getParameter("logout")).thenReturn("logout");
		when(request.getRequestDispatcher("default.jsp")).thenReturn(dispatcher);
		when(request.getSession()).thenReturn(session);
		
		servlet.doPost(request, response);
		
		verify(request, times(1)).getParameter("logout");
		verify(request, times(1)).getRequestDispatcher("default.jsp");
		verify(dispatcher).include(request, response);
		verify(session).invalidate();
		
	}

}
