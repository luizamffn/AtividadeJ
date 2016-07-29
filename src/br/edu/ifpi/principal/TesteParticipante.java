package br.edu.ifpi.principal;

import java.util.List;

import br.ifpi.dao.ParticipanteDAO;
import br.ifpi.entity.Participante;
import dao.impl.ParticipanteRepository;

public class TesteParticipante {
	static ParticipanteRepository participanteDAO = new ParticipanteRepository();

	public static void main(String[] args) {
		salvarParticipante();	
		deletarParticipante();
		retornarPArticipantePorID();
		retonarParticipantesPorCpf();
		listarParticipantePorNome();
		
	}
	public static void salvarParticipante(){
		Participante p = new Participante("0074394353453", "Marcos", "632328", "Admin");
		p = participanteDAO.save(p);
		System.out.println(p.getId());
	}
	
	public static void deletarParticipante() {
		Participante p = new Participante("07687678", "Joao", "6328778328", "Palestrante");
		p = participanteDAO.save(p);
		int id = p.getId();
		participanteDAO.delete(p);
		p = participanteDAO.findId(id);
		if(p == null){
			System.out.println("Participante nao encontrado");
		}else{
			System.out.println("Participante encontrado");
		}
	}
	
	public static void retornarPArticipantePorID() {
		Participante p = new Participante("09789789", "Josefa", "8699999999", "Admin");
		p = participanteDAO.save(p);
		p = participanteDAO.findId(p.getId());
		if(p.getNome().equals("Josefa")){
			System.out.println("Certo!!");
		}
	}
	
	public static void retonarParticipantesPorCpf() {
		Participante p = new Participante("987239872", "Marivaldo", "8699999999", "Admin");
		participanteDAO.save(p);
		p = participanteDAO.findByCpf("987239872"); 
		if(p.getNome().equals("Marivaldo")){
			System.out.println("Certo!!");
		}
	}
	
	public static void listarParticipantePorNome() {
		List<Participante> lista = participanteDAO.findByNome("f");
		for (Participante participante : lista) {
			System.out.println(participante.getNome());
		}
	}
	
}
