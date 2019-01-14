package com.walter.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.walter.cursomc.domain.Categoria;
import com.walter.cursomc.domain.Cidade;
import com.walter.cursomc.domain.Estado;
import com.walter.cursomc.domain.Produto;
import com.walter.cursomc.repository.CategoriaRepository;
import com.walter.cursomc.repository.CidadeRepository;
import com.walter.cursomc.repository.EstadoRepository;
import com.walter.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository prodRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		this.repo.saveAll(Arrays.asList(cat1, cat2 ));
		this.prodRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "São Paulo", est1);
		Cidade c2 = new Cidade(null, "Campinas", est1);
		Cidade c3 = new Cidade(null, "Uselandia", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1,c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		this.estadoRepository.saveAll(Arrays.asList(est1,est2));
		this.cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}

