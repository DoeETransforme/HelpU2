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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.senac.helpu.modelo.entidade.item.Item;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;
import br.senac.helpu.modelo.enumeracao.statuspedido.StatusPedido;
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
	
	@Column(name = "data_pedido_doacao")
	@Temporal(TemporalType.DATE)
	private LocalDate data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ong")
	private Ong ong;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "pedido_doacao_tem_item", joinColumns = @JoinColumn(name = "id_pedido_doacao"), inverseJoinColumns = @JoinColumn(name = "id_item"))
	private List<Item> itens;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "cadastrar_pedido_doacao", joinColumns = @JoinColumn(name ="id_pedido_doacao"), inverseJoinColumns = @JoinColumn(name = "id_proposta_doacao"))
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
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

	public void addItem(Item item) {
		itens.add(item);
	}

	public void removeItem(Item item) {
		itens.remove(item);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
