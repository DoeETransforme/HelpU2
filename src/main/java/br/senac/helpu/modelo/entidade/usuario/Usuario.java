	package br.senac.helpu.modelo.entidade.usuario;
 
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.contato.Contato;
 
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
 
	private static final long serialVersionUID = -8566282827144097443L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	@Column(name = "nome_usuario", length = 30, nullable = false, unique = true)
	private String nome;
	@Column(name = "senha_usuario", length = 15, nullable = false)
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contato") 
	Contato contato;
 
	public Usuario() {
	}
 
	public Usuario(Long id, String nome, String senha, Contato contato) {
		setId(id);
		setNome(nome);
		setSenha(senha);
		setContato(contato);
	}
 
	public Usuario(String nome, String senha, Contato contato) {
		setNome(nome);
		setSenha(senha);
		setContato(contato);
	}
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public String getSenha() {
		return senha;
	}
 
	public void setSenha(String senha) {
		this.senha = senha;
	}
 
	public Contato getContato() {
		return contato;
	}
 
	public void setContato(Contato contato) {
		this.contato = contato;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}