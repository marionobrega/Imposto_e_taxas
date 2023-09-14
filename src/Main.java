// Classe para representar uma operação comercial
class OperacaoComercial {
    private String tipo; // Pode ser "produto" ou "servico"
    private double valor;

    public OperacaoComercial(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}

// Interface para impostos/taxas
interface ImpostoTaxa {
    double calcular(OperacaoComercial operacao);
}

// Implementação do ISS
class ISS implements ImpostoTaxa {
    private static final double ALIQUOTA = 0.046;

    public double calcular(OperacaoComercial operacao) {
        if (operacao.getTipo().equals("servico")) {
            return operacao.getValor() * ALIQUOTA;
        }
        return 0;
    }
}

// Implementação do ICMS
class ICMS implements ImpostoTaxa {
    private static final double ALIQUOTA = 0.17;

    public double calcular(OperacaoComercial operacao) {
        return operacao.getValor() * ALIQUOTA;
    }
}

// Implementação do IPI
class IPI implements ImpostoTaxa {
    private static final double ALIQUOTA = 0.25;

    public double calcular(OperacaoComercial operacao) {
        if (operacao.getTipo().equals("produto")) {
            return operacao.getValor() * ALIQUOTA;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        // Massa de dados fixa (hard-coded)
        OperacaoComercial operacao1 = new OperacaoComercial("produto", 100);
        OperacaoComercial operacao2 = new OperacaoComercial("servico", 200);

        // Criação dos objetos de impostos/taxas
        ImpostoTaxa iss = new ISS();
        ImpostoTaxa icms = new ICMS();
        ImpostoTaxa ipi = new IPI();

        // Cálculo dos impostos/taxas
        double valorISS = iss.calcular(operacao2);
        double valorICMS = icms.calcular(operacao1);
        double valorIPI = ipi.calcular(operacao1);

        // Impressão dos resultados
        System.out.println("Detalhes da Operação 1:");
        System.out.println("Valor original do item: R$" + operacao1.getValor());
        System.out.println("Valor do ICMS: R$" + valorICMS);
        System.out.println("Valor do IPI: R$" + valorIPI);
        System.out.println("Valor total: R$" + (operacao1.getValor() + valorICMS + valorIPI));

        System.out.println("\nDetalhes da Operação 2:");
        System.out.println("Valor original do item: R$" + operacao2.getValor());
        System.out.println("Valor do ISS: R$" + valorISS);
        System.out.println("Valor total: R$" + (operacao2.getValor() + valorISS));
    }
}
git