package br.senac.helpu.modelo.entidade.pedidodoacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;

@Entity
@Table(name = "pedido_doacao")
public class PedidoDoacao implements Serializable {

	private static final long serialVersionUID = 5828763779674937613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_doacao")
	private Long id;
	
	@Column(name = "titulo_pedido_doacao", length = 45, nullable = false, unique = false)
	private String titulo;
	
	@Column(name = "descricao_pedido_doacao", length = 150, nullable = false, unique = false)
	private String descricao;
	
	@Enumerated ( EnumType.STRING)
	private StatusPedido statuspedido;
	
	@Column(name = "data_pedido_doacao", length = 10, nullable = false, unique = false)
	private LocalDate data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong", nullable = false, unique = true)
	private Ong ong;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> itens;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedidoDoacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PropostaDoacao> propostasDoacao;
	
	public PedidoDoacao() {}
	
	public PedidoDoacao(Long id, String titulo, String descricao, StatusPedido statusPedido) {
		setId(id);
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		itens = new ArrayList<>();
	}

	public PedidoDoacao(String titulo, String descricao, StatusPedido statusPedido) {
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		itens = new ArrayList<>();
	}
	
	public PedidoDoacao(String titulo, String descricao, StatusPedido statusPedido, LocalDate data) {
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		this.data = data;
		itens = new ArrayList<>();
	}
	public PedidoDoacao(String titulo, String descricao, StatusPedido statusPedido, LocalDate data, Ong ong) {
		setTitulo(titulo);
		setDescricao(descricao);
		setStatusPedido(statusPedido);
		this.data = data;
		this.ong = ong;
		itens = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusPedido getStatusPedido() {
		return this.statuspedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statuspedido = statusPedido;
	}

}
