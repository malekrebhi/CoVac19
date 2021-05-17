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

import Proj.Spring.AppCoVacc19.Entity.Citoyen;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Service.CitoyenService;

@RestController
public class CitoyenController {

	@Autowired
	private CitoyenService CitoyenService;

	//SELECT
	@GetMapping("/Citoyen/Select")
	public List<Citoyen> SelectCitoyen() throws NoArgumentsFoundException{
		return  CitoyenService.SelectCitoyen();
		
	}
	
	//DELETE
	@DeleteMapping("/Citoyen/Delete/{id}")
	public void DeleteCitoyen(@PathVariable int id) {
		CitoyenService.DeleteCitoyen(id);
		System.out.println("Citoyen supprimé !");
		
	}
	
	//UPDATE
	@PutMapping("/Citoyen/Update")
	public void UpdateCitoyen(@RequestBody Citoyen citoyen) {
		CitoyenService.UpdateCitoyen(citoyen);
		System.out.println("Citoyen modifié !");

	}
	
	//ADD
	@PostMapping("/Citoyen/Add")
	public void AddCitoyen(@RequestBody Citoyen citoyen) {
		CitoyenService.AddCitoyen(citoyen);
		System.out.println("Citoyen ajouté !");

	}
	//*
}
