package com.company.logistics.service;

import com.company.logistics.domain.Entrega;
import com.company.logistics.frete.CalculadoraFrete;
import com.company.logistics.frete.FreteRegistry;
import com.company.logistics.util.MoneyFormatter;

import java.util.Objects;

/**
 * Serviço responsavel por gerar etiquetas e resumos.
 * Recebe FreteRegistry por injeção (manual aqui).
 */
public class EtiquetaService {

    private final FreteRegistry freteRegistry;

    public EtiquetaService(FreteRegistry freteRegistry) {
        this.freteRegistry = Objects.requireNonNull(freteRegistry, "freteRegistry obrigatório");
    }

    public String gerarEtiqueta(Entrega entrega) {
        Objects.requireNonNull(entrega, "entrega não pode ser null");
        CalculadoraFrete calc = freteRegistry.get(entrega.getFreteType());
        double valorFrete = calc.calcular(entrega);
        return String.format("Destinatário: %s%nEndereço: %s%nValor do Frete: %s",
                entrega.getDestinatario(),
                entrega.getEndereco(),
                MoneyFormatter.format(valorFrete));
    }

    public String gerarResumo(Entrega entrega) {
        Objects.requireNonNull(entrega, "entrega não pode ser null");
        CalculadoraFrete calc = freteRegistry.get(entrega.getFreteType());
        double valorFrete = calc.calcular(entrega);
        return String.format("Pedido para %s com frete tipo %s no valor de %s",
                entrega.getDestinatario(),
                entrega.getFreteType().name(),
                MoneyFormatter.format(valorFrete));
    }
}
