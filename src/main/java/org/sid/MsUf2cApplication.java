package org.sid;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MsUf2cApplication implements CommandLineRunner {

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(MsUf2cApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(Formation.class, Etudiant.class);
		repositoryRestConfiguration.getCorsRegistry()
		.addMapping("/**")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");
		
		Formation f1 =formationRepository.save(new Formation(null,"PHP",30,null));
		Formation f2= formationRepository.save(new Formation(null,"JAVA",30,null));
		Formation f3=formationRepository.save(new Formation(null,"ANGULAR 6",30,null));
		
		etudiantRepository.save(new Etudiant(null,"Abdallah","Jouili", new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"Kamel","Jouili", new Date(),f1));
		etudiantRepository.save(new Etudiant(null,"Mohamed","Jouili", new Date(),f3));
		etudiantRepository.save(new Etudiant(null,"ALi","Jouili", new Date(),f2));
		etudiantRepository.save(new Etudiant(null,"Belgacem","Jouili", new Date(),f3));
	}

}
