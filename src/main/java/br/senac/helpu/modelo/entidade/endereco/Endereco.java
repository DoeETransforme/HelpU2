package br.senac.helpu.modelo.entidade.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.Ong.Ong;

@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = -7731215238349813452L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "logadouro", length = 30, nullable = true)
	private String logradouro;

	@Column(name = "bairro", length = 30, nullable = true)
	private String bairro;

	@Column(name = "complemento", length = 30, nullable = false)
	private String complemento;

	@Column(name = "numero", nullable = true)
	private int numero;

	@Column(name = "cidade", length = 30, nullable = true)
	private String cidade;
	
	@Column(name= "unidadeFederativa", length = 2, nullable = true)
	private String unidadeFederativa;
	
	@Column(name= "cep", length = 9, nullable= false)
	private String cep;
	
	@ManyToOne (fetch = FetchType.LAZY)
			@MapsId
			@JoinColumn(name= "id")
	private Ong ong;

	public Endereco(Long id, String logradouro, String bairro, String complemento, int numero, String cidade,
			String unidadeFederativa, String cep) {
		setId(id);
		setLogradouro(logradouro);
		setBairro(bairro);
		setComplemento(complemento);
		setNumero(numero);
		setCidade(cidade);
		setUnidadeFederativa(unidadeFederativa);
		setCep(cep);
	}

	public Endereco(String logradouro, String bairro, String complemento, int numero, String cidade,
			String unidadeFederativa, String cep) {
		setLogradouro(logradouro);
		setBairro(bairro);
		setComplemento(complemento);
		setNumero(numero);
		setCidade(cidade);
		setUnidadeFederativa(unidadeFederativa);
		setCep(cep);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(String unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
