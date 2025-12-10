package com.company.logistics.domain;

import com.company.logistics.domain.exception.InvalidEntregaException;
import java.util.Objects;


public final class Entrega {
    private final String destinatario;
    private final String endereco;
    private final double peso;
    private final FreteType freteType;

    public Entrega(String destinatario, String endereco, double peso, FreteType freteType) {
        if (destinatario == null || destinatario.isBlank()) {
            throw new InvalidEntregaException("Destinatário obrigatório.");
        }
        if (endereco == null || endereco.isBlank()) {
            throw new InvalidEntregaException("Endereço obrigatório.");
        }
        if (peso <= 0) {
            throw new InvalidEntregaException("Peso deve ser positivo.");
        }
        if (freteType == null) {
            throw new InvalidEntregaException("Tipo de frete obrigatório.");
        }
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.peso = peso;
        this.freteType = freteType;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getPeso() {
        return peso;
    }

    public FreteType getFreteType() {
        return freteType;
    }

   
    public Entrega withPeso(double novoPeso) {
        return new Entrega(this.destinatario, this.endereco, novoPeso, this.freteType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entrega entrega = (Entrega) o;
        return Double.compare(entrega.peso, peso) == 0 &&
               Objects.equals(destinatario, entrega.destinatario) &&
               Objects.equals(endereco, entrega.endereco) &&
               freteType == entrega.freteType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinatario, endereco, peso, freteType);
    }

    @Override
    public String toString() {
        return "Entrega{" +
               "destinatario='" + destinatario + '\'' +
               ", endereco='" + endereco + '\'' +
               ", peso=" + peso +
               ", freteType=" + freteType +
               '}';
    }
}
