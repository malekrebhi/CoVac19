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
import Proj.Spring.AppCoVacc19.Entity.Personnel;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Service.PersonnelService;

@RestController
public class PersonnelController {

	@Autowired
	private PersonnelService PersonnelService;

	//SELECT
	@GetMapping("/Personnel/Select")
	public List<Personnel> SelectPersonnel() throws NoArgumentsFoundException{
		return PersonnelService.SelectPersonnel();
		
	}
	
	//DELETE
	@DeleteMapping("/Personnel/Delete/{id}")
	public void DeletePersonnel(@PathVariable int id) {
		PersonnelService.DeletePersonnel(id);
		System.out.println("Personnel supprimé !");

	}
	
	//UPDATE
	@PutMapping("/Personnel/Update")
	public void UpdatePersonnel(@RequestBody Personnel personnel) {
			PersonnelService.UpdatePersonnel(personnel);
			System.out.println("Personnel modifié !");

	}
	
	//ADD
	@PostMapping("/Personnel/Add")
	public void AddPersonnel(@RequestBody Personnel personnel) {
			PersonnelService.AddPersonnel(personnel);
			System.out.println("Personnel ajouté !");

	}
	
	//*

}
