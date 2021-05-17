package Proj.Spring.AppCoVacc19.Controller;

import Proj.Spring.AppCoVacc19.Entity.Centre_Vaccination;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Service.CentreVaccService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CentreVaccController {
	
	@Autowired
	private CentreVaccService  CentreVaccService;
	

	//SELECT
	@GetMapping("/Centre/Select")
	public List<Centre_Vaccination> SelectCentre() throws NoArgumentsFoundException{
		return CentreVaccService.SelectCentre();
		
	}
	
	//DELETE
	@DeleteMapping("/Centre/Delete/{id}")
	public void DeleteCentre(@PathVariable int id) {
		CentreVaccService.DeleteCentre(id);
		System.out.println("Centre supprimé !");

	}
	
	//UPDATE
	@PutMapping("/Centre/Update")
    public void UpdateCentre(@RequestBody Centre_Vaccination centre) {
		CentreVaccService.UpdateCentre(centre);
		System.out.println("Centre modifié !");

	}

	
	//ADD
	@PostMapping("/Centre/Add")
    public void AddCentre(@RequestBody Centre_Vaccination centre) {
		CentreVaccService.AddCentre(centre);
		System.out.println("Centre ajouté !");

	}
//*
}
