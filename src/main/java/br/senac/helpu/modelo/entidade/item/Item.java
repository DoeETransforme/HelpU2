package br.senac.helpu.modelo.entidade.item;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.alimento.Alimento;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.propostadoacao.PropostaDoacao;


@Entity
@Table(name = "item")
public class Item implements Serializable {

	private static final long serialVersionUID = -4650927518777774993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;

	@Column(name = "quantidade_pedido", nullable = false)
	private int quantidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido_doacao", insertable = false, updatable = false)
	private PedidoDoacao pedidoDoacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proposta_doacao", insertable = false, updatable = false)
	private PropostaDoacao propostaDoacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alimento", insertable = false, updatable = false)
	private Alimento alimento;
	

	public Item() {}

	public Item(Long id, int quantidade, Alimento alimento) {
		setId(id);
		setQuantidade(quantidade);
		setAlimento(alimento);
	}
	
	public Item(Long id, int quantidade) {
		setId(id);
		setQuantidade(quantidade);
	}

	public Item(int quantidade, Alimento alimento) {
		setQuantidade(quantidade);
		setAlimento(alimento);
	}
	
	public Item(int quantidade) {
		setQuantidade(quantidade);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public PedidoDoacao getPedidoDoacao() {
		return pedidoDoacao;
	}

	public void setPedidoDoacao(PedidoDoacao pedidoDoacao) {
		this.pedidoDoacao = pedidoDoacao;
	}

	public PropostaDoacao getPropostaDoacao() {
		return propostaDoacao;
	}

	public void setPropostaDoacao(PropostaDoacao propostaDoacao) {
		this.propostaDoacao = propostaDoacao;
	}
	
}


