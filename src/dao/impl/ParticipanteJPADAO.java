package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ifpi.dao.GenericDAO;
import br.ifpi.dao.JPAUtil;
import br.ifpi.dao.ParticipanteDAO;
import br.ifpi.entity.Participante;

public class ParticipanteJPADAO implements ParticipanteDAO {
	private GenericDAO<Participante> dao;
	
	public ParticipanteJPADAO(){
		this.dao = new GenericDAOImpl<Participante>(Participante.class);
	}
	
	@Override
	public Participante save(Participante p) {
		return dao.save(p);
	}

	@Override
	public void delete(Participante p ) {
		dao.delete(p);
		
	}

	@Override
	public Participante find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Participante> findAll() {
		return dao.findAll();
	}

	@Override
	public Participante findByCpf(String cpf) {
		return JPAUtil.getCurrentEntityManager().createQuery("SELECT p FROM " + Participante.class.getSimpleName() + " p WHERE cpf = '" + cpf + "'", Participante.class).setMaxResults(1).getSingleResult();
	}

	@Override
	public List<Participante> findByNome(String nome) {
		return JPAUtil.getCurrentEntityManager().createQuery("SELECT p FROM " + Participante.class.getSimpleName() + " p WHERE nome = '" + nome + "'", Participante.class).getResultList(); 
	}

}
