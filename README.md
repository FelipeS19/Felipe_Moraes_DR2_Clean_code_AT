# **Sistema de Logística – Cálculo de Frete e Geração de Etiquetas**

Este projeto é uma pequena aplicação Java que simula parte de um sistema de logística.
A ideia principal é trabalhar com entregas, cálculo de frete, promoções e geração de etiquetas, usando boas práticas como Padrão Strategy, Registry, Imutabilidade, e Domain-Driven Design (DDD) básico.

Foi desenvolvido como exercício de prática em Eng. de Software sobre organização, clean code e testes em java.
## ✨ **Funcionalidades**

* 📦 Criar entregas com destinatário, endereço, peso e tipo de frete
* 🚚 Calcular frete usando diferentes estratégias:

  * **Expresso**
  * **Padrão**
  * **Econômico**
* 🏷 Gerar etiqueta formatada em texto
* 🎉 Aplicar promoção automática de peso
* 💸 Verificar se o frete é grátis
* 🇧🇷 Formatar valores em Real (R$)

---

## 🧠 **Conceitos Utilizados**

| Conceito                    | Explicação                                   |
| --------------------------- | -------------------------------------------- |
| **Strategy Pattern**        | Cada tipo de frete tem sua lógica separada   |
| **Registry Pattern**        | Controla quais estratégias estão disponíveis |
| **Classe Imutável**         | `Entrega` é final e só cria novos objetos    |
| **Validação de Domínio**    | Não deixa criar entregas inválidas           |
| **Clean Code / DDD Básico** | Código organizado por responsabilidade       |

---

## 📁 **Estrutura do Projeto**



4. A saída será algo assim:


      ETIQUETA DE ENTREGA

=========================

Destinatário: Maria da Silva

Endereço: Rua das Flores, 123 - Centro

Valor do Frete: R$ 28,75

===========================


