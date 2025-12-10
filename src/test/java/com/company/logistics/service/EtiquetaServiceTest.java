package com.company.logistics.service;

import com.company.logistics.domain.Entrega;
import com.company.logistics.domain.FreteType;
import com.company.logistics.frete.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EtiquetaServiceTest {

    private FreteRegistry registry;
    private EtiquetaService etiquetaService;

    @BeforeEach
    void setup() {
        registry = new FreteRegistry();
        registry.register(FreteType.EXPRESSO, new FreteExpresso());
        registry.register(FreteType.PADRAO, new FretePadrao());
        registry.register(FreteType.ECONOMICO, new FreteEconomico());
        etiquetaService = new EtiquetaService(registry);
    }

    @Test
    void gerarEtiquetaContemDestinatarioEnderecoEFrete() {
        Entrega e = new Entrega("Maria", "Av. Brasil, 100", 3.0, FreteType.PADRAO);
        String etiqueta = etiquetaService.gerarEtiqueta(e);
        assertTrue(etiqueta.contains("Maria"));
        assertTrue(etiqueta.contains("Av. Brasil, 100"));
        assertTrue(etiqueta.contains("Valor do Frete"));
    }
}
