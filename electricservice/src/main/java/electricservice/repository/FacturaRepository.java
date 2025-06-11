package electricservice.repository;

import electricservice.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacturaRepository extends JpaRepository<Factura,Long> {

    Optional<Factura> findByNumeroFactura(String numeroFactura);
}
