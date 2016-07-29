package br.ifpi.repository;

import java.util.List;

import br.ifpi.entity.Participante;

public interface ParticipanteRepository {
	public Participante findByCpf(String cpf);
	public List<Participante> findByNome(String str);	
}
