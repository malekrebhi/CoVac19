package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.List;

import Proj.Spring.AppCoVacc19.Entity.Citoyen;
import Proj.Spring.AppCoVacc19.Exception.CitoyenNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Repository.CitoyenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitoyenService {
	
	@Autowired
	private CitoyenRepository  CitoyenRepository;

	//SELECT
	public List<Citoyen> SelectCitoyen() throws NoArgumentsFoundException{
		List<Citoyen> citoyns=new ArrayList<>();
		CitoyenRepository.findAll().forEach(citoyns::add);
		if (citoyns.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return citoyns;
	}

	//ADD
	public void AddCitoyen(Citoyen citoyen) {
		if(citoyen.getNom_C().isEmpty() || citoyen.getPrenom_C().isEmpty() || citoyen.getDateNaiss_C().equals(null)) {
			throw new EmptyInputException("601");}
		CitoyenRepository.save(citoyen);
	}

	//UPDATE
	public Citoyen UpdateCitoyen(Citoyen citoyen) {
		Citoyen existingCentre= CitoyenRepository.findById(citoyen.getCIN_C()).orElse(null);
		existingCentre.setCIN_C(citoyen.getCIN_C());
		existingCentre.setNom_C(citoyen.getNom_C());
		existingCentre.setPrenom_C(citoyen.getPrenom_C());
		existingCentre.setDateNaiss_C(citoyen.getDateNaiss_C());
		existingCentre.setTel_C(citoyen.getTel_C());
		existingCentre.setEtat(citoyen.isEtat());
		return CitoyenRepository.save(existingCentre);
	}

	//DELETE
	public void DeleteCitoyen(int id) {
		if (CitoyenRepository.findById(id) == null) {
			throw new CitoyenNotFoundException("602");
		}
		CitoyenRepository.deleteById(id);	
		System.out.println("Citoyen removed "+id);

	}
}
