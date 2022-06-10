package br.com.fiap.carstation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.carstation.model.Estacao;;

public class EstacaoDao {
    EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("estacao");
	EntityManager manager = factory.createEntityManager();

    public void insert(Estacao estacao) {
		manager.getTransaction().begin();
		manager.persist(estacao);
		manager.getTransaction().commit();
	}

	public List<Estacao> showAll() {
		return manager
				.createQuery("SELECT e FROM Estacao e", Estacao.class)
				.getResultList();
	}

	public List<Estacao> orderByStates() {
		return manager
				.createQuery("SELECT e FROM Estacao e ORDER BY e.estado", Estacao.class)
				.getResultList();
	}
	
	public void delete(Long estacaoId) {
		Estacao estacao = manager.find(Estacao.class, estacaoId);
		manager.getTransaction().begin();
		manager.remove(estacao);
		manager.getTransaction().commit();
	}
}
