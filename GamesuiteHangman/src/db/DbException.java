package db;

public class DbException extends RuntimeException {
	
	public DbException(String message){
		super(message);
	}
	
	public DbException(String message, Exception exception){
		super(message, exception);
	}
}
