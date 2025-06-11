package electricservice.controller;

import electricservice.model.Factura;
import electricservice.service.FacturaService;
import electricservice.service.MedidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private MedidorService medidorService;

    @PostMapping
    public ResponseEntity<Factura> generarFactura(@RequestBody Factura factura) {
        // Se calcula el total a pagar basado en el consumo
        factura.setTotalPagar(facturaService.calcularMonto(factura.getConsumoEnergia()));
        // Se asocia y guarda la factura
        return ResponseEntity.ok(facturaService.guardarFactura(factura));
    }

    @GetMapping("/{numeroFactura}")
    public ResponseEntity<Factura> obtenerFactura(@PathVariable String numeroFactura) {
        return ResponseEntity.ok(facturaService.buscarPorNumero(numeroFactura));
    }
}

