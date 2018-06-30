package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application implements CommandLineRunner {
	@Autowired //permet d'instancier l'objet
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Doucouré", "Abdietou", df.parse("31/10/1988"), "abdietou@gmail.com", 650038588, "abdi.jpeg"));
		contactRepository.save(new Contact("Doucouré", "Ali", df.parse("09/03/1996"), "ali@gmail.com", 650038588, "abdi.jpeg"));
		contactRepository.save(new Contact("Doucouré", "Maudi", df.parse("10/03/2004"), "maudi@gmail.com", 650038588, "abdi.jpeg"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
		
	}
}
