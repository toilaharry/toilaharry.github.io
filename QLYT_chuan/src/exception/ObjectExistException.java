package exception;

public class ObjectExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectExistException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "Loi them thong tin: " + super.getMessage();
	}
}
