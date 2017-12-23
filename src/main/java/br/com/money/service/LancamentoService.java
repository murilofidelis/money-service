package br.com.money.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.money.model.Lancamento;
import br.com.money.model.Pessoa;
import br.com.money.repository.LancamentoRepository;
import br.com.money.repository.PessoaRepository;
import br.com.money.service.exeption.PessoaInexistenteOuInativa;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if (pessoa == null || pessoa.isInativo()) {
			throw new PessoaInexistenteOuInativa();
		}
		return lancamentoRepository.save(lancamento);
	}
}
