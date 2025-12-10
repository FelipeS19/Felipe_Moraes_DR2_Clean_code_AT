package com.company.logistics.frete;

import com.company.logistics.domain.Entrega;
import com.company.logistics.domain.FreteType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraFreteTest {

    @Test
    void freteExpressoCalculaCorreto() {
        Entrega e = new Entrega("isabelle souza", "Rua jardim botanico", 5.0, FreteType.EXPRESSO);
        CalculadoraFrete calc = new FreteExpresso();
        double valor = calc.calcular(e);
        assertEquals(5.0 * 1.5 + 10.0, valor);
    }

    @Test
    void freteEconomicoNuncaNegativo() {
        Entrega e = new Entrega("felipe moraes", "Rua carlos dos santos", 1.0, FreteType.ECONOMICO);
        CalculadoraFrete calc = new FreteEconomico();
        double valor = calc.calcular(e);
        assertEquals(0.0, valor);
    }
}
