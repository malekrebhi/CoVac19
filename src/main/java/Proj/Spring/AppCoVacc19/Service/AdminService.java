package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository AdminRepository;
	
	//SELECT
	public List<Administrateur> SelectAdmin(){
		List<Administrateur> admins=new ArrayList<>();
		AdminRepository.findAll().forEach(admins::add);
		return admins;
	}
	
	//ADD
	public void AddAdmin(Administrateur admin) {
		/*if(admin.getNom_A().isEmpty() ||admin.getPrenom_A().isEmpty() ||admin.getAdresse_A().isEmpty() ) {
			throw new EmptyInputException("601");
		}*/
		AdminRepository.save(admin);
	}

	//UPDATE
	public Administrateur UpdateAdmin(Administrateur admin) {
		Administrateur existingAdministrateur= AdminRepository.findById(admin.getCIN_A()).orElse(null);
		existingAdministrateur.setCIN_A(admin.getCIN_A());
		existingAdministrateur.setNom_A(admin.getNom_A());
		existingAdministrateur.setPrenom_A(admin.getPrenom_A());
		existingAdministrateur.setAdresse_A(admin.getAdresse_A());
		existingAdministrateur.setDateNaiss_A(admin.getDateNaiss_A());
		existingAdministrateur.setTel_A(admin.getTel_A());
		existingAdministrateur.setMatricule(admin.getMatricule());
		return AdminRepository.save(existingAdministrateur);
	}

	//DELETE
	public void DeleteAdmin(int id) {
		AdminRepository.deleteById(id);		
		System.out.println("Admin removed "+id);
	}
	
	
} 

