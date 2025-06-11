package electricservice.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medidores", uniqueConstraints = @UniqueConstraint(columnNames = "numeroMedidor"))
public class Medidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroMedidor;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula",referencedColumnName = "cedula", nullable = false)
    @JsonBackReference
    private Cliente cliente;


    @JsonManagedReference
    @OneToMany(mappedBy = "medidor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> facturas;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMedidor() {
        return numeroMedidor;
    }

    public void setNumeroMedidor(String numeroMedidor) {
        this.numeroMedidor = numeroMedidor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
}

