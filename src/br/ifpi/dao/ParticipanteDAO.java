package br.ifpi.dao;

import java.util.List;

import br.ifpi.entity.Participante;

public interface ParticipanteDAO {
	public Participante findByCpf(String cpf);
	public List<Participante> findByNome(String str);	
}
