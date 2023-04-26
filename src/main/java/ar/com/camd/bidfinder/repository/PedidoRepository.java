package ar.com.camd.bidfinder.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.camd.bidfinder.model.Pedido;
import ar.com.camd.bidfinder.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByEstado(StatusPedido status, Pageable pagination);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
	List<Pedido> findAllByUser(@Param("username") String username);

	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username AND p.estado = :status")
	List<Pedido> findByEstadoAndUser(@Param("status") StatusPedido status, @Param("username") String username);
}