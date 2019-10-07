package br.edu.ifba.web3j.pojo;

import java.math.BigInteger;

public class DadosMedico {
	
	private BigInteger id;
	private String doenca;
	private String dataNotificacao;
	private String localidade; 
	private String idade;
	private String sexo;
	
	public DadosMedico(BigInteger id, String doenca, String dataNotificacao, String localidade, String idade, String sexo) {
		super();
		this.id = id;
		this.doenca = doenca;
		this.dataNotificacao = dataNotificacao;
		this.localidade = localidade;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public DadosMedico() {
	
	}
	
	
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getDoenca() {
		return doenca;
	}
	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	public String getDataNotificacao() {
		return dataNotificacao;
	}
	public void setDataNotificacao(String dataNotificacao) {
		this.dataNotificacao = dataNotificacao;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}