package com.jadson.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jadson.cursomc.domain.Categoria;
import com.jadson.cursomc.domain.Cidade;
import com.jadson.cursomc.domain.Cliente;
import com.jadson.cursomc.domain.Endereco;
import com.jadson.cursomc.domain.Estado;
import com.jadson.cursomc.domain.Produto;
import com.jadson.cursomc.domain.enums.TipoCliente;
import com.jadson.cursomc.repository.CategoriaRepository;
import com.jadson.cursomc.repository.CidadeRepository;
import com.jadson.cursomc.repository.ClienteRepository;
import com.jadson.cursomc.repository.EnderecoRepository;
import com.jadson.cursomc.repository.EstadoRepository;
import com.jadson.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository; 
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository; 
	

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Rio de Janeiro");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null,"Mage",est1);
		Cidade cid2 = new Cidade(null,"Campinas",est2);
		Cidade cid3 = new Cidade(null,"Guararapes",est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","3637812377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua 2 ", "20", "Casa 23", "Iraja", "23252-300", cli1,cid1);
		Endereco e2 = new Endereco(null, "Rua Magnolias ", "7", "Casa 2", "Jardim Primavera", "20252-100", cli1,cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est1.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
	}
	
	

}
