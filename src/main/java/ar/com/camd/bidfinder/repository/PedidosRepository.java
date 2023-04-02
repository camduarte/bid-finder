package ar.com.camd.bidfinder.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.com.camd.bidfinder.model.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PedidosRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Pedido> findAll() {
		Query query = entityManager.createNativeQuery("SELECT * FROM bidfinder.pedido", Pedido.class);
		return query.getResultList();
	}
}
