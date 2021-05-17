package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proj.Spring.AppCoVacc19.Entity.Rendez_vous;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Exception.RendezVousNotFoundException;
import Proj.Spring.AppCoVacc19.Repository.RendezVousRepository;

@Service
public class RendezVousService {
	
	@Autowired
	private RendezVousRepository RendezVousRepository;
	
	//SELECT
	public List<Rendez_vous> SelectRendezVous(){
		List<Rendez_vous> rdvs=new ArrayList<>();
		RendezVousRepository.findAll().forEach(rdvs::add);
		if (rdvs.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return rdvs;
	}


	//ADD
	public void AddRDV(Rendez_vous rdv) {
		RendezVousRepository.save(rdv);
	}


	//UPDATE
	public Rendez_vous UpdateRDV(Rendez_vous rdv) {
		Rendez_vous existingrdv= RendezVousRepository.findById(rdv.getIdRDV()).orElse(null);
		existingrdv.setDateRDV(rdv.getDateRDV());
		existingrdv.setCitoyen(rdv.getCitoyen());
		return RendezVousRepository.save(existingrdv);
	}


	//DELETE
	public void DeleteRDV(int id){
		if (RendezVousRepository.findById(id) == null) {
			throw new RendezVousNotFoundException("602");
		}
		RendezVousRepository.deleteById(id);		

	}

}
