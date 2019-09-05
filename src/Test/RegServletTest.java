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

import org.apache.log4j.Logger;
import org.junit.Test;

import Classes.RegServlet;

public class RegServletTest {

	static Logger logger = Logger.getLogger(RegServlet.class);
	
	@Test
	public void test() throws ServletException, IOException {
		logger.info("Test all right");
		
		RegServlet servlet = new RegServlet();
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		
		when(request.getParameter("name")).thenReturn("name");
		when(request.getRequestDispatcher("login.jsp")).thenReturn(dispatcher);
		
		servlet.doPost(request, response);
		
		verify(request, times(1)).getParameter("name");
		verify(request, times(1)).getRequestDispatcher("login.jsp");
		verify(dispatcher).forward(request, response);
		
	}

}
