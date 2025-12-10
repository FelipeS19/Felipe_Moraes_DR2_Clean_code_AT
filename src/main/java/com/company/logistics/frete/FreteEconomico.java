package com.company.logistics.frete;

import com.company.logistics.domain.Entrega;


public class FreteEconomico implements CalculadoraFrete {

    private static final double MULTIPLICADOR = 1.1;
    private static final double DESCONTO = 5.0;

    @Override
    public double calcular(Entrega entrega) {
        double valor = entrega.getPeso() * MULTIPLICADOR - DESCONTO;
        return Math.max(0.0, valor);
    }
}
