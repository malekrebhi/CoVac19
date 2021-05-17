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

import  Proj.Spring.AppCoVacc19.Entity.Rendez_vous;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import  Proj.Spring.AppCoVacc19.Service.RendezVousService;

@RestController
public class RendezVousController {
	
	@Autowired
	private RendezVousService RendezVousService;

	//SELECT
	@GetMapping("/RendezVous/Select")
	public List<Rendez_vous> SelectRendezVous() throws NoArgumentsFoundException{
	    return RendezVousService.SelectRendezVous();
		
	}
	
	//DELETE
	@DeleteMapping("/RendezVous/Delete/{id}")
	public void DeleteRDV(@PathVariable int id) {
		RendezVousService.DeleteRDV(id);
		System.out.println("RdV supprimé !");

	}
	
	//UPDATE
	@PutMapping("/RendezVous/Update")
	public void UpdateRDV(@RequestBody Rendez_vous rdv) {
		RendezVousService.UpdateRDV(rdv);
		System.out.println("RdV modifié !");

	}
	
	//ADD
	@PostMapping("/RendezVous/Add")
	public void AddRDV(@RequestBody Rendez_vous rdv) {
		RendezVousService.AddRDV(rdv);
		System.out.println("RdV ajouté !");

	}



//**
}
