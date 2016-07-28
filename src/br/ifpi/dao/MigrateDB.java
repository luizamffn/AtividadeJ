package br.ifpi.dao;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MigrateDB {
	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put("hibernate.hbm2ddl.auto", "update");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("evento", prop);
		EntityManager em = emf.createEntityManager();
		System.out.println("Banco de dados Criado/Atualizado.");
		em.close();
		emf.close();
	}
}
