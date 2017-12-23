package br.com.money.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.money.model.Pessoa;

public interface PessoaRepositoryQuery {
	// não usado
	public Page<Pessoa> filtar(String nome, Pageable pageable);

}
