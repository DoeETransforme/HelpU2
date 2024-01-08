package br.senac.helpu.modelo.entidade.contato;
 
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.usuario.Usuario;
 
@Entity
@Table(name = "contato")
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 8094576640471907006L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Long id;
	
	@Column(name = "email_contato", length = 65, unique = true, nullable = false)
	private String email;
	
	@Column(name = "celular_contato", length = 16, unique = true, nullable = false)
	private String celular;
 
 
	@OneToOne(mappedBy = "contato", cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	
	public Contato() {}
	
	public Contato(String celular, String email) {
		setCelular(celular);
		setEmail(email);
	}
		
	public Contato(Long id, String celular, String email) {
		setId(id);
		setCelular(celular);
		setEmail(email);
		
	}
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getCelular() {
		return celular;
	}
 
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Usuario getUsuario() {
		return usuario;
	}
 
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}