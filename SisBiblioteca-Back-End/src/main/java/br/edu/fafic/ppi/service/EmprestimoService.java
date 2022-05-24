package br.edu.fafic.ppi.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fafic.ppi.domain.Emprestimo;
import br.edu.fafic.ppi.repository.EmprestimoRepository;


@Service
public class EmprestimoService {

	
	@Autowired
	private EmprestimoRepository er;
	
	
	
	
	public Emprestimo save(Emprestimo mov) {
		Emprestimo a = er.save(mov);
		
		return a;
		
	}
	
	public Emprestimo findById(Long id) throws Exception{
		
		Optional<Emprestimo> m = er.findById(id);
		
		return m.orElseThrow(()-> new Exception("Erro ao consultar a movimentacao"));
	}
	
	public List<Emprestimo> findByEmprestimoAluno(String nome) throws Exception {
		List<Emprestimo> m = er.findByEmprestimoAluno(nome);

		return m;
	}
	
	
	public void deletById(Long id) {
		er.deleteById(id);
	}
	
	
	public boolean verificaDevolucao(Long idEmprestimo) {
	
		
		return er.verificaDevolucao(idEmprestimo) !=null;
	}
	
	public List<Emprestimo> findByEmprestimoPendentes(String nome) throws Exception {
		List<Emprestimo> emprestTemp = new ArrayList<>();
		List<Emprestimo> m = er.findByEmprestimoAluno(nome);
		for(Emprestimo e: m) {
			if(!verificaDevolucao(e.getId())) {
				emprestTemp.add(e);
			}
		}
		return emprestTemp;
	}
	
	
	
	
	
	
}
