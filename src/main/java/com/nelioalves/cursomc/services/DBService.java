package com.nelioalves.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.ItemPedido;
import com.nelioalves.cursomc.domain.Pagamento;
import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import com.nelioalves.cursomc.domain.enums.Perfil;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ItemPedidoRepository;
import com.nelioalves.cursomc.repositories.PagamentoRepository;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
// @ConditionalOnExpression("!${spring.jpa.hibernate.ddl-auto}.equals('create')")
public class DBService {

	private EstadoRepository estadoRepository;
	private CidadeRepository cidadeRepository;
	private PedidoRepository pedidoRepository;
	private ClienteRepository clienteRepository;
	private ProdutoRepository produtoRepository;
	private EnderecoRepository enderecoRepository;
	private CategoriaRepository categoriaRepository;
	private PagamentoRepository pagamentoRepository;
	private ItemPedidoRepository itemPedidoRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// @PostConstruct
	public void instantiateTestDatabase() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática", new ArrayList<Produto>());
		Categoria cat2 = new Categoria(null, "Escritório", new ArrayList<Produto>());
		Categoria cat3 = new Categoria(null, "Cama mesa e banho", new ArrayList<Produto>());
		Categoria cat4 = new Categoria(null, "Eletrônicos", new ArrayList<Produto>());
		Categoria cat5 = new Categoria(null, "Jardinagem", new ArrayList<Produto>());
		Categoria cat6 = new Categoria(null, "Decoração", new ArrayList<Produto>());
		Categoria cat7 = new Categoria(null, "Perfumaria", new ArrayList<Produto>());

		Produto p1 = new Produto(null, "Computador", 2000.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p2 = new Produto(null, "Impressora", 800.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p3 = new Produto(null, "Mouse", 80.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p5 = new Produto(null, "Toalha", 50.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p6 = new Produto(null, "Colcha", 200.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p7 = new Produto(null, "TV true color", 1200.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p8 = new Produto(null, "Roçadeira", 800.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p9 = new Produto(null, "Abajour", 100.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p10 = new Produto(null, "Pendente", 180.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p11 = new Produto(null, "Shampoo", 90.00, new ArrayList<Categoria>(), new HashSet<>());

		Produto p12 = new Produto(null, "Produto 12", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p13 = new Produto(null, "Produto 13", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p14 = new Produto(null, "Produto 14", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p15 = new Produto(null, "Produto 15", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p16 = new Produto(null, "Produto 16", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p17 = new Produto(null, "Produto 17", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p18 = new Produto(null, "Produto 18", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p19 = new Produto(null, "Produto 19", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p20 = new Produto(null, "Produto 20", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p21 = new Produto(null, "Produto 21", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p22 = new Produto(null, "Produto 22", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p23 = new Produto(null, "Produto 23", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p24 = new Produto(null, "Produto 24", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p25 = new Produto(null, "Produto 25", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p26 = new Produto(null, "Produto 26", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p27 = new Produto(null, "Produto 27", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p28 = new Produto(null, "Produto 28", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p29 = new Produto(null, "Produto 29", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p30 = new Produto(null, "Produto 30", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p31 = new Produto(null, "Produto 31", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p32 = new Produto(null, "Produto 32", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p33 = new Produto(null, "Produto 33", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p34 = new Produto(null, "Produto 34", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p35 = new Produto(null, "Produto 35", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p36 = new Produto(null, "Produto 36", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p37 = new Produto(null, "Produto 37", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p38 = new Produto(null, "Produto 38", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p39 = new Produto(null, "Produto 39", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p40 = new Produto(null, "Produto 40", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p41 = new Produto(null, "Produto 41", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p42 = new Produto(null, "Produto 42", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p43 = new Produto(null, "Produto 43", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p44 = new Produto(null, "Produto 44", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p45 = new Produto(null, "Produto 45", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p46 = new Produto(null, "Produto 46", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p47 = new Produto(null, "Produto 47", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p48 = new Produto(null, "Produto 48", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p49 = new Produto(null, "Produto 49", 90.00, new ArrayList<Categoria>(), new HashSet<>());
		Produto p50 = new Produto(null, "Produto 50", 90.00, new ArrayList<Categoria>(), new HashSet<>());

		cat1.getProdutos()
				.addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27,
						p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46,
						p47, p48, p49, p50));

		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25,
				p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40, p41, p42, p43, p44, p45, p46,
				p47, p48, p49, p50));

		Estado est1 = new Estado(null, "Minas Gerais", new ArrayList<Cidade>());
		Estado est2 = new Estado(null, "São Paulo", new ArrayList<Cidade>());

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "nitaicharan@gmail.com", "36378912377",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Cliente cli2 = new Cliente(null, "Ana Costa", "nitaicharan@hotmail.com", "31628382740",
				TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
		cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
		cli2.addPerfil(Perfil.ADMIN);

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		var simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, simpleDateFormat.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, simpleDateFormat.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,
				simpleDateFormat.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}