package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

import Classes.DBModel;
import Classes.Operation;
import Classes.User;

public class DBModelTest {
	
	final static Logger logger = Logger.getLogger(DBModelTest.class); 

	@Test
	public void test() {
		logger.info("Test all right");
		DBModel model = new DBModel();
		boolean flag = model.putUserDB("fsgdfgdfg", "sdfdsfds", "sdfsfs", "fsdgsgdsfds");
		assertFalse("Good", flag);
	}
	
	@Test
	public void test2() {
		logger.info("Test all right");
		DBModel model = new DBModel();
		User user = new User();
		User flag = model.getUserValidation("sdfsfs", "sdfsfs");
		assertNull("Method ", flag);
	}
	
	@Test
	public void test3() {
		logger.info("Test all right");
		DBModel model = new DBModel();
		User user = new User();
		Date utilDate = new Date();
		User flag = model.getUserValidation("sdfsfs", "sdfsfs");
		logger.info(utilDate);
		boolean rec = model.putOperation(flag, "41412 rewre432rwer", utilDate);
		assertTrue("Inp ", rec);
	}
	
	@Test
	public void test4() {
		logger.info("Test all right");
		DBModel model = new DBModel();
		String[] flag = model.emailVerification("kghfhfthftfthf");
		logger.info(flag[0] + " " + flag[1]);
		assertNotNull(flag);
	}
	
	@Test
	public void test5() {
		logger.info("Test all right");
		DBModel model = new DBModel();
		User user = model.getUserValidation("sdfsfs", "sdfsfs");
		ArrayList<Operation> flag = model.getOperations(user);
		for (Operation operation : flag) {
			logger.info(operation.getOperation() + " : " + operation.getDate());
		}
		assertNotNull(flag);
	}

}
