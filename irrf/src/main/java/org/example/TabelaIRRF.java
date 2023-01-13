package org.example;

import java.text.DecimalFormat;

public class TabelaIRRF {
    public static final double valorIsencao = 1903.98;
    public static final double valorInferiorFaixa1 = 1903.99;
    public static final double valorSuperiorFaixa1 = 2826.65;
    public static final double aliquotaFaixa1 = 0.075;
    public static final double parcelaDeduzirFaixa1 = 142.80;
    public static final double valorInferiorFaixa2 = 2826.66;
    public static final double valorSuperiorFaixa2 = 3751.05;
    public static final double aliquotaFaixa2 = 0.15;
    public static final double parcelaDeduzirFaixa2 = 354.80;
    public static final double valorInferiorFaixa3 = 3751.06;
    public static final double valorSuperiorFaixa3 = 4664.68;
    public static final double aliquotaFaixa3 = 0.225;
    public static final double parcelaDeduzirFaixa3 = 636.13;

    public static final double valorFaixa4 = 4664.69;
    public static final double aliquotaFaixa4 = 0.275;
    public static final double parcelaDeduzirFaixa4 = 869.36;
    public static final double descontoPorDependente = 189.59;


    public static double calcularIRRF(double salarioBruto, int quantidadeDependentes) {
        double descontoPrevidenciario = salarioBruto * 0.1425;
        double descontoDependentes = descontoPorDependente * quantidadeDependentes;
        double valorTributavel = salarioBruto - descontoPrevidenciario - descontoDependentes;
        double valorIrrf = 0.0;

        if (valorTributavel <= valorIsencao) {
            valorIrrf = 0.0;
        } else if (salarioBruto >= valorInferiorFaixa1 && valorTributavel <= valorSuperiorFaixa1) {
            valorIrrf = (valorTributavel * aliquotaFaixa1) - parcelaDeduzirFaixa1;
        } else if (valorTributavel >= valorInferiorFaixa2 && valorTributavel <= valorSuperiorFaixa2) {
            valorIrrf = (valorTributavel * aliquotaFaixa2) - parcelaDeduzirFaixa2;
        } else if (valorTributavel >= valorInferiorFaixa3 && valorTributavel <= valorSuperiorFaixa3) {
            valorIrrf = (valorTributavel * aliquotaFaixa3) - parcelaDeduzirFaixa3;
        } else {
            valorIrrf = (valorTributavel * aliquotaFaixa4) - parcelaDeduzirFaixa4;
        }

        return valorIrrf;
    }

    public static void main(String[] args) {
        double irrf = TabelaIRRF.calcularIRRF(30000.00, 3);
        //String resultado = String.format("%.2f",irrf);
        System.out.printf("%.2f", irrf);
    }


}
