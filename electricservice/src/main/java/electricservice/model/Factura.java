package electricservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "facturas", uniqueConstraints = @UniqueConstraint(columnNames = "numeroFactura"))
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroFactura;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "medidor_id", nullable = false)
    private Medidor medidor;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    @Column(nullable = false)
    private Integer consumoEnergia; // En kWh

    @Column(nullable = false)
    private Double totalPagar;

    // Getters and Setters



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(Integer consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
}

