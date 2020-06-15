package exception;

public class MissWrongInfoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MissWrongInfoException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "Loi nhap thong tin: " + super.getMessage();
	}
	
}
