package com.company.logistics.frete;

import com.company.logistics.domain.Entrega;


public class FretePadrao implements CalculadoraFrete {

    private static final double MULTIPLICADOR = 1.2;

    @Override
    public double calcular(Entrega entrega) {
        return entrega.getPeso() * MULTIPLICADOR;
    }
}
