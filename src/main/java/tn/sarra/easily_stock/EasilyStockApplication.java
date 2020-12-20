package tn.sarra.easily_stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.sarra.easily_stock.business.EntrepotServices;
import tn.sarra.easily_stock.data.repositories.AdresseRepository;
import tn.sarra.easily_stock.data.repositories.EntrepotRepository;


@SpringBootApplication
public class EasilyStockApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EasilyStockApplication.class, args);
	}

		@Autowired
		private EntrepotRepository er;
		
		@Autowired
		private AdresseRepository ar;
		
		@Autowired
		private EntrepotServices es;
		
		@Override
		public void run(String... args) throws Exception {
//			Entrepot en = new Entrepot();
//			Entrepot en2 = new Entrepot();
//			Address adr = new Address();
//			
//			adr.setNumber(02);
//			adr.setRue("rue elyassamine");
//			adr.setVille("Tunis");
//			adr.setPays("Tunisie");
//			adr.setCp("1002");
//			en.setNom("entrepot 1 elyassamine Tunis");
//			en.setAdresse(adr);
//			adr.setEntrepot(en);
////			ar.save(adr);
//			es.createEntrepot(en);
//			
//			en2.setNom("entrepot 2 elyassamine");
//			en2.setAdresse(adr);
////			adr.setEntrepot(en2);
//			es.createEntrepot(en2);
		}
		
	}


