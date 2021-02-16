package com.lototarget.cursoUml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lototarget.cursoUml.domain.Categoria;
import com.lototarget.cursoUml.domain.Produto;
import com.lototarget.cursoUml.repositories.CategoriaRepository;
import com.lototarget.cursoUml.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoUmlApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoUmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "jardim");
		Categoria cat3 = new Categoria(null, "Bugingangas");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 1000.00);
		Produto p3 = new Produto(null, "Mouse", 130.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
