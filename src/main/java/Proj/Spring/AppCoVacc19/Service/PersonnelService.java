package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proj.Spring.AppCoVacc19.Entity.Personnel;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Exception.PersonnelNotFoundException;
import Proj.Spring.AppCoVacc19.Repository.PersonnelRepository;

@Service
public class PersonnelService {

	@Autowired
	private PersonnelRepository PersonnelRepository;
	
	//SELECT
	public List<Personnel> SelectPersonnel() throws NoArgumentsFoundException{
		List<Personnel> personnels=new ArrayList<>();
		PersonnelRepository.findAll().forEach(personnels::add);
		if (personnels.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return personnels;
	}

	//ADD
	public void AddPersonnel(Personnel personnel) {
		if(personnel.getAdresse_P().isEmpty() || personnel.getCentre().equals(null) || personnel.getDateNaiss_P().equals(null) || personnel.getNom_P().isEmpty() || personnel.getPrenom_P().isEmpty()) {
			throw new EmptyInputException("601");}
		PersonnelRepository.save(personnel);
	}

	//UPDATE
	public Personnel UpdatePersonnel(Personnel personnel) {
		Personnel existingPersonnel= PersonnelRepository.findById(personnel.getCIN_P()).orElse(null);
		existingPersonnel.setCIN_P(personnel.getCIN_P());
		existingPersonnel.setNom_P(personnel.getNom_P());
		existingPersonnel.setPrenom_P(personnel.getPrenom_P());
		existingPersonnel.setAdresse_P(personnel.getAdresse_P());
		existingPersonnel.setDateNaiss_P(personnel.getDateNaiss_P());
		existingPersonnel.setTel_P(personnel.getTel_P());
		existingPersonnel.setHoraire_P(personnel.getHoraire_P());
		existingPersonnel.setSalaire_P(personnel.getSalaire_P());
		return PersonnelRepository.save(existingPersonnel);
	}

	//DELETE
	public void DeletePersonnel(int id) {
		if (PersonnelRepository.findById(id) == null) {
			throw new PersonnelNotFoundException("602");
		}
		PersonnelRepository.deleteById(id);		
	}
}
