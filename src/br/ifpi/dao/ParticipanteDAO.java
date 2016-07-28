package br.ifpi.dao;

import java.util.List;

import br.ifpi.entity.Participante;

public interface ParticipanteDAO {
	public Participante save(Participante entity);
	public void delete(Participante p);
	public Participante find(int id);
	public List<Participante> findAll();
	public Participante findByCpf(String cpf);
	public List<Participante> findByNome(String str);	
}
