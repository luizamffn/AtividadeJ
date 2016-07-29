package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ifpi.dao.GenericDAO;
import br.ifpi.dao.JPAUtil;
import br.ifpi.dao.ParticipanteDAO;
import br.ifpi.entity.Participante;

public class ParticipanteRepository {
	private GenericDAO<Participante> dao;
	
	public ParticipanteRepository(){
		this.dao = new GenericDAOImpl<Participante>(Participante.class);
	}
	
	public Participante save(Participante p) {
		return dao.save(p);
	}

	public void delete(Participante p ) {
		dao.delete(p);
		
	}

	public Participante findId(int id) {
		return dao.findByID(id);
	}

	public List<Participante> findAll() {
		return dao.findAll();
	}

	public Participante findByCpf(String cpf) {
		return JPAUtil.getCurrentEntityManager().createQuery("SELECT p FROM " + Participante.class.getSimpleName() + " p WHERE cpf = '" + cpf + "'", Participante.class).setMaxResults(1).getSingleResult();
	}

	public List<Participante> findByNome(String nome) {
		return JPAUtil.getCurrentEntityManager().createQuery("SELECT p FROM " + Participante.class.getSimpleName() + " p WHERE UPPER(nome) like '%" + nome.toUpperCase() + "%'", Participante.class).getResultList(); 
	}

}
