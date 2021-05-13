package Proj.Spring.AppCoVacc19.Exception;

@SuppressWarnings("serial")
public class EmptyInputException  extends RuntimeException{
	public EmptyInputException(String message) {
		super(message);
	}

}
