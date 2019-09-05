package Classes;

public class Operation {

	private String Operation;
	private String Date;
	
	public Operation() {}

	public Operation(String operation, String date) {
		Operation = operation;
		Date = date;
	}

	public String getOperation() {
		return this.Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public String getDate() {
		return this.Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	
}
