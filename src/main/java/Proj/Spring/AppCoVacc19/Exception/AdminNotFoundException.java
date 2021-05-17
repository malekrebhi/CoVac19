package Proj.Spring.AppCoVacc19.Exception;

@SuppressWarnings("serial")
public class AdminNotFoundException extends RuntimeException{
	public AdminNotFoundException(String message) {
		super(message);
	}

}
