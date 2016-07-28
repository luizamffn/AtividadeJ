package br.ifpi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participante {
	
	@Id
	@GeneratedValue
	private int id;
	private String cpf;
	private String nome;
	private String fone;
	private String perfil;
	
	
	public Participante() {

	}

	public Participante(int id, String cpf, String nome, String fone, String perfil) {
		this.cpf = cpf;
		this.nome = nome;
		this.fone = fone;
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return "Participante [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", fone=" + fone + ", perfil=" + perfil
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
