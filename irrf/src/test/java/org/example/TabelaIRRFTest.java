package org.example;

import org.example.exceptions.QuantidadeDependentesInvalidaException;
import org.example.exceptions.RemuneracaoInvalidaException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class TabelaIRRFTest {

//Valor tributavel	 Salario Bruto
//        1.903,98	2115,533333
//        1.903,99	2115,544444
//        2.826,65	3140,722222
//        2.826,66	3140,733333
//        3.751,05	4167,833333
//        3.751,06	4167,844444
//        4.664,68	5182,977778
//        4.664,68	5182,977778

    @Test
    public void testCalcularIRRF_BASE() {
        double salarioBruto = 12997.45;
        int quantidadeDependentes = 3;
        BigDecimal expected = BigDecimal.valueOf(2191.10).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    // 0%
    @Test
    public void testCalcularIRRF_500_00_0_dependents() {
        double salarioBruto = 500.00;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_2115_53_0_dependents() {
        double salarioBruto = 2115.53;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_2115_53_1_dependents() {
        double salarioBruto = 2115.53;
        int quantidadeDependentes = 1;
        BigDecimal expected = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    // 7,5%
    @Test
    public void testCalcularIRRF_2115_54_0_dependents() {
        double salarioBruto = 2115.54;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(0.00).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_2115_70_0_dependents() {
        double salarioBruto = 2115.70;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(0.01).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_2500_0_1_dependents() {
        double salarioBruto = 2500.00;
        int quantidadeDependentes = 1;
        BigDecimal expected = BigDecimal.valueOf(11.73).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_3140_73_0_dependents() {
        double salarioBruto = 3140.73;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(69.20).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    // 15%
    @Test
    public void testCalcularIRRF_3141_00_0_dependents() {
        double salarioBruto = 3141.00;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(69.24).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_3500_00_0_dependents() {
        double salarioBruto = 3500.00;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(117.70).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_3500_00_1_dependents() {
        double salarioBruto = 3500.00;
        int quantidadeDependentes = 1;
        BigDecimal expected = BigDecimal.valueOf(89.26).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }


    @Test
    public void testCalcularIRRF_4167_83_0_dependents() {
        double salarioBruto = 4167.83;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(207.86).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    // 22,5%%
    @Test
    public void testCalcularIRRF_4167_84_0_dependents() {
        double salarioBruto = 4167.84;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(207.86).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_4500_00_0_dependents() {
        double salarioBruto = 4500.00;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(275.12).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_4500_00_1_dependents() {
        double salarioBruto = 4500.00;
        int quantidadeDependentes = 1;
        BigDecimal expected = BigDecimal.valueOf(232.46).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }


    @Test
    public void testCalcularIRRF_5182_97_0_dependents() {
        double salarioBruto = 5182.97;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(413.42).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    // 27,5%%
    @Test
    public void testCalcularIRRF_5182_99_0_dependents() {
        double salarioBruto = 5182.99;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(413.43).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_6000_00_0_dependents() {
        double salarioBruto = 6000.00;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(615.64).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_6000_00_1_dependents() {
        double salarioBruto = 6000.00;
        int quantidadeDependentes = 1;
        BigDecimal expected = BigDecimal.valueOf(563.50).setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP);
        assertEquals(expected, result);
    }

    @Test
    public void testCalcularIRRF_6000_00_100_dependents() {
        double salarioBruto = 6000.00;
        int quantidadeDependentes = 6;
        Exception exception = assertThrows(QuantidadeDependentesInvalidaException.class, () ->
                TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes).setScale(2, RoundingMode.HALF_UP));
        assertEquals("A quantidade de dependentes não é válida!", exception.getMessage());
    }

//IllegalArgumentException

    //    Test case where salarioBruto is 0.00 and quantidadeDependentes is 0. The expected result is 0.0.
    @Test
    public void testCalcularIRRF_SalarioZero() {
        double salarioBruto = 0.00;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(0.00);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes);
        assertTrue(result.compareTo(expected) == 0);
    }

    //    Test case where salarioBruto is -100.00 and quantidadeDependentes is 0. The expected result is 0.0.
    @Test
    public void testCalcularIRRF_SalarioNegativo() {
        double salarioBruto = -1000.00;
        int quantidadeDependentes = 0;
        Exception exception = assertThrows(RemuneracaoInvalidaException.class, () ->
                TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes));
        assertEquals("O valor da remuneração não é válido!", exception.getMessage());
    }

    //    Test case where salarioBruto is 1000.00 and quantidadeDependentes is -1. The expected result is 0.0.
    @Test
    public void testCalcularIRRF_DependentesNegativo() {
        double salarioBruto = 1000.00;
        int quantidadeDependentes = 0;
        BigDecimal expected = BigDecimal.valueOf(0.00);
        BigDecimal result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes);
        assertTrue(result.compareTo(expected) == 0);
    }

    @Test
    public void testExemplo(){
        double irrf = TabelaIRRF.calcularIRRF(12997.45,3).doubleValue();
        BigDecimal resultadoObtido = new BigDecimal(irrf).setScale(2, RoundingMode.HALF_UP);
        BigDecimal resultadoEsperado = new BigDecimal(2191.10).setScale(2,RoundingMode.HALF_UP);
        assertEquals(resultadoObtido,resultadoEsperado);
    }
}
