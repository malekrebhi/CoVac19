package Proj.Spring.AppCoVacc19.Exception;

@SuppressWarnings("serial")
public class CitoyenNotFoundException extends RuntimeException{
	public CitoyenNotFoundException(String message) {
		super(message);
	}

}
