package br.senac.helpu;

import java.time.LocalDate;

import br.senac.helpu.modelo.dao.contato.ContatoDAO;
import br.senac.helpu.modelo.dao.contato.ContatoDAOImpl;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAO;
import br.senac.helpu.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAO;
import br.senac.helpu.modelo.dao.pedidodoacao.PedidoDoacaoDAOImpl;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAO;
import br.senac.helpu.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.helpu.modelo.entidade.contato.Contato;
import br.senac.helpu.modelo.entidade.endereco.Endereco;
import br.senac.helpu.modelo.entidade.ong.Ong;
import br.senac.helpu.modelo.entidade.pedidodoacao.PedidoDoacao;
import br.senac.helpu.modelo.enumeracao.pedido.StatusPedido;

public class Main {
	public static void main(String[] args) {
		

			
		Contato contato = new Contato("dCd", "Edmdo");
		ContatoDAO daoContato = new ContatoDAOImpl();
		Ong ong = new Ong("noaddboldo" , "sedda" , contato, "caddo");
		
		PedidoDoacao pedidoDoacao = new PedidoDoacao("pedidoBolado", "DescricaoBolada", StatusPedido.ATIVO,LocalDate.of(2022, 1,1), ong);
		PedidoDoacaoDAO daoPedido = new PedidoDoacaoDAOImpl();
		daoContato.inserirContato(contato);
		UsuarioDAO daoUsuario = new UsuarioDAOImpl();
		daoUsuario.inserirUsuario(ong);
		daoPedido.inserirPedidoDoacao(pedidoDoacao);
		
		Endereco endereco = new Endereco("logradourobolado","bairrobolado", 10 ,"cidadeBolada", "un", "cepbolado", ong);
		EnderecoDAO daoEndereco = new EnderecoDAOImpl();
		daoEndereco.inserirEndereco(endereco);
		
		
	}
}
