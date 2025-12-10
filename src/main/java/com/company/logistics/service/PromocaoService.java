package com.company.logistics.service;

import com.company.logistics.domain.Entrega;


public class PromocaoService {


    public Entrega aplicarPromocaoPeso(Entrega entrega) {
        if (entrega.getPeso() > 10) {
            double novoPeso = entrega.getPeso() - 1.0;
            return entrega.withPeso(novoPeso);
        }
        return entrega;
    }


    public boolean isFreteGratis(Entrega entrega) {
        return entrega.getFreteType() == com.company.logistics.domain.FreteType.ECONOMICO
               && entrega.getPeso() < 2.0;
    }
}

