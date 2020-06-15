package exception;

public class ObjectNotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotExistException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "Loi thay doi thong tin: " + super.getMessage();
	}
}
