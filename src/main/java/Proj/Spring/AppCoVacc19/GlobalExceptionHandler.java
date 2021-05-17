package Proj.Spring.AppCoVacc19;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import Proj.Spring.AppCoVacc19.Exception.AdminNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.CentreVaccNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.CitoyenNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Exception.PersonnelNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.RendezVousNotFoundException;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{ 
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> handleAdminNotFoundException(AdminNotFoundException e) {
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CentreVaccNotFoundException.class)
	public ResponseEntity<String> handleCentreVaccNotFoundException(CentreVaccNotFoundException e) {
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CitoyenNotFoundException.class)
	public ResponseEntity<String> handleCitoyenNotFoundException(CitoyenNotFoundException e) {
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PersonnelNotFoundException.class)
	public ResponseEntity<String> handlePersonnelNotFoundException(PersonnelNotFoundException e) {
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RendezVousNotFoundException.class)
	public ResponseEntity<String> handleRendezVousNotFoundException(RendezVousNotFoundException e) {
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : id doesn't exist",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException e) {
		return new ResponseEntity<String>("ERROR: "+e.getMessage()+" : Input field is empty",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoArgumentsFoundException.class)
	public ResponseEntity<String> hendleNoArgumentsFoundException(NoArgumentsFoundException e) {
		return new ResponseEntity<String>("WARNING: "+e.getMessage()+" : No Arguments",HttpStatus.FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpHeaders headers, HttpStatus s, WebRequest r){
		return new ResponseEntity<Object>("ERROR: "+e.getMessage()+" : Change the Http method type !!",HttpStatus.CONFLICT);
		
	}
}
