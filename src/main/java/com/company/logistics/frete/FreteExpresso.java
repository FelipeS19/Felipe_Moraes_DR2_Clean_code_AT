package com.company.logistics.frete;

import com.company.logistics.domain.Entrega;


public class FreteExpresso implements CalculadoraFrete {

    private static final double MULTIPLICADOR = 1.5;
    private static final double TAXA_FIXA = 10.0;

    @Override
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * MULTIPLICADOR + TAXA_FIXA;
    }
}
