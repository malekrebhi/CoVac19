package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Service.AdminService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService AdminService;

	//SELECT
	@GetMapping("/Select")
	public List<Administrateur> SelectAdmin(){
		return AdminService.SelectAdmin();
		
	}
	
	//DELETE
	@DeleteMapping( "/Delete/{id}")
	public void DeleteAdmin(@PathVariable int id) {
		AdminService.DeleteAdmin(id);
		System.out.println("Admin supprimé !");
	}
	
	//UPDATE
	@PutMapping("/Update")
	public void UpdateAdmin(@RequestBody Administrateur admin) {
		AdminService.UpdateAdmin(admin);
		System.out.println("Admin modifié !");

	}
	
	//ADD
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({EmptyInputException.class})
	@PostMapping("/Add")
	public void AddAdmin(@RequestBody Administrateur admin) {
		AdminService.AddAdmin(admin);
		System.out.println("Admin ajouté !");

	}

//*

}
