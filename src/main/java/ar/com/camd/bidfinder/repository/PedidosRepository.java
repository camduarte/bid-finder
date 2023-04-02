package ar.com.camd.bidfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.camd.bidfinder.model.Pedido;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long> {
}
