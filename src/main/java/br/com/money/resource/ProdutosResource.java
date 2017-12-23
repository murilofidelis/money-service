package br.com.money.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.money.model.Produto;
import br.com.money.repository.ProdutoRepositoey;

@RestController
@RequestMapping("/produtos")
@CrossOrigin
public class ProdutosResource {

	@Autowired
	private ProdutoRepositoey repository;

	@GetMapping
	public Page<Produto> pesquisar(@RequestParam(defaultValue = "0") int pagina,
			@RequestParam(defaultValue = "2") int porPagina, @RequestParam(defaultValue = "nome") String ordenacao,
			@RequestParam(defaultValue = "ASC") Sort.Direction direcao) {
		return repository.findAll(new PageRequest(pagina, porPagina, new Sort(direcao, ordenacao)));
	}

	// http://localhost:8080/produtos?ordenacao=nome&direcao=DESC
	@GetMapping("/filter")
	public List<Produto> pesquisarFiltrada(@RequestParam(defaultValue = "nome") String ordenacao,
			@RequestParam(defaultValue = "ASC") Sort.Direction direcao) {
		return repository.findAll(new Sort(direcao, ordenacao));
	}

	@GetMapping("/pesquisa")
	public List<Produto> pesquisarProdutos() {
		return repository.findAll();
	}

	@GetMapping("/buscaPorNome/{nome}")
	public Produto buscaporNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}

	@GetMapping("/{id}")
	public Produto buscar(@PathVariable Long id) {
		return repository.findOne(id);
	}

	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return repository.save(produto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repository.delete(id);
	}

}
