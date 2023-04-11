package ar.com.camd.bidfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByEstado(StatusPedido valueOf);
}