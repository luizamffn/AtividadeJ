package br.ifpi.repository.impl;

import java.util.List;

import br.ifpi.dao.JPAUtil;
import br.ifpi.entity.Participante;
import br.ifpi.repository.ParticipanteRepository;

public class ParticipanteRepositoryImpl implements ParticipanteRepository{
	
	public Participante findByCpf(String cpf) {
		return JPAUtil.getCurrentEntityManager().createQuery("SELECT p FROM " + Participante.class.getSimpleName() + " p WHERE cpf = '" + cpf + "'", Participante.class).setMaxResults(1).getSingleResult();
	}

	public List<Participante> findByNome(String nome) {
		return JPAUtil.getCurrentEntityManager().createQuery("SELECT p FROM " + Participante.class.getSimpleName() + " p WHERE UPPER(nome) like '%" + nome.toUpperCase() + "%'", Participante.class).getResultList(); 
	}

}
