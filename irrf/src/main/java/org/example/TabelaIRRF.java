package org.example;

import org.example.exceptions.QuantidadeDependentesInvalidaException;
import org.example.exceptions.RemuneracaoInvalidaException;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public static boolean validaQuantidadeDependentes(int quant)
    {
        if(quant < 0 || quant > 5){
            throw new QuantidadeDependentesInvalidaException("A quantidade de dependentes não é válida!");
        }
        return true;
    }

    public static boolean validaRemuneracao(double remuneracao)
    {
        if(remuneracao < 0){
            throw new RemuneracaoInvalidaException("O valor da remuneração não é válido!");
        }
        return true;
    }

    public static BigDecimal calcularIRRF(double salarioBruto, int quantidadeDependentes){
        BigDecimal valorIrrf = new BigDecimal(0.00).setScale(2,RoundingMode.HALF_UP);
        if(validaRemuneracao(salarioBruto) && validaQuantidadeDependentes(quantidadeDependentes)){
            if(salarioBruto > 0.00  && quantidadeDependentes >= 0){
                double descontoPrevidenciario = salarioBruto * 0.10;
                double descontoDependentes = descontoPorDependente * quantidadeDependentes;
                BigDecimal valorTributavel = new BigDecimal(salarioBruto - descontoPrevidenciario - descontoDependentes).setScale(2,RoundingMode.HALF_UP);

                if(valorTributavel.doubleValue() <= valorIsencao){
                    valorIrrf = BigDecimal.valueOf(0.00);
                }else if(valorTributavel.doubleValue() >= valorInferiorFaixa1 && valorTributavel.doubleValue() <= valorSuperiorFaixa1){
                    valorIrrf =  valorTributavel.multiply(BigDecimal.valueOf(aliquotaFaixa1)).subtract(BigDecimal.valueOf(parcelaDeduzirFaixa1));
                }else if(valorTributavel.doubleValue() >= valorInferiorFaixa2 && valorTributavel.doubleValue() <= valorSuperiorFaixa2){
                    valorIrrf = valorTributavel.multiply(BigDecimal.valueOf(aliquotaFaixa2)).subtract(BigDecimal.valueOf(parcelaDeduzirFaixa2));
                }else if(valorTributavel.doubleValue() >= valorInferiorFaixa3 && valorTributavel.doubleValue() <= valorSuperiorFaixa3){
                    valorIrrf = valorTributavel.multiply(BigDecimal.valueOf(aliquotaFaixa3)).subtract(BigDecimal.valueOf(parcelaDeduzirFaixa3));
                }else{
                    valorIrrf = valorTributavel.multiply(BigDecimal.valueOf(aliquotaFaixa4)).subtract(BigDecimal.valueOf(parcelaDeduzirFaixa4));
                }
            }
        }

        return valorIrrf;
    }

    public static void main(String[] args) {
        double irrf = TabelaIRRF.calcularIRRF(12997.45,3).doubleValue();
        BigDecimal bdResult = new BigDecimal(irrf).setScale(2,RoundingMode.HALF_UP);
        BigDecimal bdExpected = new BigDecimal(2191.10).setScale(2,RoundingMode.HALF_UP);
        System.out.println(bdResult + ", " + bdExpected);
    }
}
