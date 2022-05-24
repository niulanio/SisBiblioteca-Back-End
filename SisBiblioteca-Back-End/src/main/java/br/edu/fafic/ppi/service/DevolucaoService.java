package br.edu.fafic.ppi.service;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fafic.ppi.domain.Devolucao;
import br.edu.fafic.ppi.domain.Emprestimo;
import br.edu.fafic.ppi.repository.DevolucaoRepository;
import br.edu.fafic.ppi.repository.EmprestimoRepository;

@Service
public class DevolucaoService {

	@Autowired
	DevolucaoRepository dr;

	@Autowired
	EmprestimoRepository er;

	public Devolucao save(Devolucao dev) {

		Devolucao d = dr.save(dev);

		return d;
	}

	public Devolucao findByDevolucaoByNome(String nome) throws Exception {

		Optional<Devolucao> d = dr.findByDevolucaoByName(nome);

		return d.orElseThrow(() -> new Exception("Erro ao buscar Devolucao"));
	}

	public void deletById(Long id) {

		dr.deleteById(id);

	}

	public double findyByCalculoAtraso(Devolucao devolucao) {
		double multa = 0.0;
//		Optional<Devolucao> d = dr.findById(devolucao.getId());
		Optional<Emprestimo> e = er.findById(devolucao.getEmprestimo().getId());
		Emprestimo es = e.get();
		
		
		LocalDate dd= LocalDate.now();
		LocalDate de = LocalDate.parse(es.getDataEmprestimo().toString());
		

		
		int diasAtrasados = (int) ChronoUnit.DAYS.between(de,dd);
				

		if (diasAtrasados > 3) {
			diasAtrasados -= 3;
			multa = diasAtrasados * 2;
		}
		
		System.out.println("Multa: " +multa);

		//devolucao.setMulta(multa);

		return multa;
	}

}
