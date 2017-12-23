package br.com.money.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.money.model.Lancamento;
import br.com.money.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {



}
