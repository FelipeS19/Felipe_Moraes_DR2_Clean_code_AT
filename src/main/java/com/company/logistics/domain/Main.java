package com.company.logistics.domain;

import com.company.logistics.service.EtiquetaService;
import com.company.logistics.frete.FreteRegistry;
import com.company.logistics.frete.FreteExpresso;
import com.company.logistics.frete.FretePadrao;
import com.company.logistics.frete.FreteEconomico;

public class Main {
    public static void main(String[] args) {

        // Registrar fretes
        FreteRegistry registry = new FreteRegistry();
        registry.register(FreteType.EXPRESSO, new FreteExpresso());
        registry.register(FreteType.PADRAO, new FretePadrao());
        registry.register(FreteType.ECONOMICO, new FreteEconomico());

        // Criar entrega
        Entrega entrega = new Entrega(
                "Maria da Silva",
                "Rua das Flores, 123 - Centro",
                12.5,
                FreteType.EXPRESSO
        );

        EtiquetaService service = new EtiquetaService(registry);
        String etiqueta = service.gerarEtiqueta(entrega);

        // largura da "etiqueta"
        int largura = 40;
        String borda = "=".repeat(largura);

        System.out.println(borda);
        System.out.println(center("ETIQUETA DE ENTREGA", largura));
        System.out.println(borda);

        // imprimir linhas da etiqueta
        for (String linha : etiqueta.split("\n")) {
            System.out.println(linha);
        }

        System.out.println(borda);
    }

// centraliza texto simples
    private static String center(String s, int width) {
        int padding = (width - s.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + s;
    }
}
