package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Service.AdminService;
import Proj.Spring.AppCoVacc19.Service.EmailSenderService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
    public EmailSenderService emailSender;
	@Autowired
	private AdminService AdminService;

	//SELECT
	@GetMapping("/Select")
	public @ResponseBody List<Administrateur> SelectAdmin(){
		return AdminService.SelectAdmin();
		
	}
	
	//DELETE
	@DeleteMapping( "/Delete/{id}")
	public void DeleteAdmin(@PathVariable int id){
		AdminService.DeleteAdmin(id);
		System.out.println("Admin supprimé !");
	}
	
	//UPDATE
	@PutMapping("/Update")
	public void UpdateAdmin(@RequestBody Administrateur admin) {
		AdminService.UpdateAdmin(admin);


	}
	
	//ADD
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/Add")
	public void addAdmin(@RequestBody Administrateur admin) {
	    
		AdminService.AddAdmin(admin);
	}
	
	@ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
 
		emailSender.sendSimpleEmail("malekrebhi6@gmail.com ", "Test Simple Email", "Hello, Im testing Simple Email");
 
        return "Email Sent!";
    }
 
//*

	}
