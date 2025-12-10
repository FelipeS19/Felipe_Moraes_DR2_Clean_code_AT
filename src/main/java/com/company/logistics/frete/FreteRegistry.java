package com.company.logistics.frete;

import com.company.logistics.domain.FreteType;
import com.company.logistics.domain.exception.FreteNotFoundException;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;


public class FreteRegistry {

    private final Map<FreteType, CalculadoraFrete> registry = new EnumMap<>(FreteType.class);

    public void register(FreteType tipo, CalculadoraFrete calculadora) {
        Objects.requireNonNull(tipo, "tipo não pode ser null");
        Objects.requireNonNull(calculadora, "calculadora não pode ser null");
        registry.put(tipo, calculadora);
    }

    public CalculadoraFrete get(FreteType tipo) {
        CalculadoraFrete calc = registry.get(tipo);
        if (calc == null) {
            throw new FreteNotFoundException("Não há calculadora para o tipo de frete: " + tipo);
        }
        return calc;
    }
}
