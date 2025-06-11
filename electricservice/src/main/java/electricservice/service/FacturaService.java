package electricservice.service;

import electricservice.model.Factura;
import electricservice.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
   @Autowired
    FacturaRepository facturaRepository;
    private static final double IVA = 0.13;

    public double calcularMonto(int consumoEnergia) {
        double monto = 0;

        if (consumoEnergia > 350) {
            monto += (consumoEnergia - 350) * 1750;
            consumoEnergia = 350;
        }
        if (consumoEnergia > 200) {
            monto += (consumoEnergia - 200) * 1500;
            consumoEnergia = 200;
        }
        if (consumoEnergia > 100) {
            monto += (consumoEnergia - 100) * 1250;
            consumoEnergia = 100;
        }
        monto += consumoEnergia * 900;

        return monto * (1 + IVA);
    }

    public Factura guardarFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    public Factura buscarPorNumero(String numeroFactura){
        return facturaRepository.findByNumeroFactura(numeroFactura).get();
    }
}

