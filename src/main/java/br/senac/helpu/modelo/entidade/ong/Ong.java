package br.senac.helpu.modelo.entidade.ong;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "ong")
public class Ong extends Usuario implements Serializable {

	private static final long serialVersionUID = -2680258071107532867L;

	@Column(name = "cnpj_ong", length = 18, nullable = false, unique = true)
	private String cnpj;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ong", cascade = CascadeType.ALL)
	private List<PedidoDoacao> pedidosdoacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ong", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos;

	public Ong() {}

	public Ong(Long id, String nome, String senha, Contato contato, String cnpj) {
		super(id, nome, senha, contato);
		setCnpj(cnpj);
		pedidosdoacao = new ArrayList<>();
		enderecos = new ArrayList<>();
	}

	public Ong(String nome, String senha, Contato contato, String cnpj) {
		super(nome, senha, contato);
		setCnpj(cnpj);
		pedidosdoacao = new ArrayList<>();
		enderecos = new ArrayList<>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}

	public void removeEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}

	public void addPedido(PedidoDoacao pedido) {
		pedidosdoacao.add(pedido);
	}

	public void removePedido(PedidoDoacao pedido) {
		pedidosdoacao.remove(pedido);
	}

}