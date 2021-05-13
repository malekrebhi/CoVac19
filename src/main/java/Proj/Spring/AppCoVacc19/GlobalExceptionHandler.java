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
import Proj.Spring.AppCoVacc19.Exception.PersonnelNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.RendezVousNotFoundException;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{ 
	
	@ExceptionHandler(AdminNotFoundException.class)
	public void handleAdminNotFoundException(AdminNotFoundException e) {
		
	}
	@ExceptionHandler(CentreVaccNotFoundException.class)
	public void handleCentreVaccNotFoundException(CentreVaccNotFoundException e) {
		
	}
	@ExceptionHandler(CitoyenNotFoundException.class)
	public void handleCitoyenNotFoundException(CitoyenNotFoundException e) {
		
	}
	@ExceptionHandler(PersonnelNotFoundException.class)
	public void handlePersonnelNotFoundException(PersonnelNotFoundException e) {
		
	}
	@ExceptionHandler(RendezVousNotFoundException.class)
	public void handleRendezVousNotFoundException(RendezVousNotFoundException e) {
		
	}
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException e) {
		return new ResponseEntity<String>("Input field is empty",HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpHeaders headers, HttpStatus s, WebRequest r){
		return new ResponseEntity<Object>("Change the Http method type !!",HttpStatus.NOT_FOUND);
		
	}
}
