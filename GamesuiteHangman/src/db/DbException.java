package db;

public class DbException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DbException(String message){
		super(message);
	}
	
	public DbException(String message, Exception exception){
		super(message, exception);
	}
}
