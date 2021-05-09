package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService AdminService;

	//SELECT
	@GetMapping("/Admin")
	public List<Administrateur> SelectAdmin(){
		return AdminService.SelectAdmin();
		
	}
	
	//DELETE
	@DeleteMapping( "/Admin/{id}")
	public void DeleteAdmin(@PathVariable int id) {
		AdminService.DeleteAdmin(id);
		System.out.println("Admin supprimé !");
	}
	
	//UPDATE
	@PutMapping("/Admin")
	public void UpdateAdmin(@RequestBody Administrateur admin) {
		AdminService.UpdateAdmin(admin);
		System.out.println("Admin modifié !");

	}
	
	//ADD
	@PostMapping("/Admin")
	public void AddAdmin(@RequestBody Administrateur admin) {
		AdminService.AddAdmin(admin);
		System.out.println("Admin ajouté !");

	}

//*

}
