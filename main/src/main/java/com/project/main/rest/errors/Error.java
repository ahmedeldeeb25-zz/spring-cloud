

import java.util.Date;

class Error {

	private String message;
	private String status;
	private Date date;
	
	
	public Error(String message, String status) {
		super();
		this.message = message;
		this.status = status;
		this.date = new Date();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
