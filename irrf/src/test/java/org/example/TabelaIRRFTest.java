package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabelaIRRFTest {

    private static Double SALARIO_BRUTO = 1903.98;

    //Até R$ 1.903,98 | 0% | R$ 0,00
//    Test case with a salary of 1903.97 and no dependents. The expected result is 0.0.
//    Test case with a salary of 1903.98 and no dependents. The expected result is 0.0.

    //De R$ 1.903,99 a R$ 2.826,65	| 7,5% | R$ 142,80
//    Test case with a salary of 1903.99 and no dependents. The expected result is 142.80.
//    Test case with a salary of 1904.00 and no dependents. The expected result is 142.80.
//    Test case with a salary of 2826.65 and no dependents. The expected result is 354.80.

    //De R$ 2.826,66 a R$ 3.751,05	| 15,0%	| R$ 354,80
//    Test case with a salary of 2826.66 and no dependents. The expected result is 354.80.
//    Test case with a salary of 2826.67 and no dependents. The expected result is 354.80.
//    Test case with a salary of 3751.05 and no dependents. The expected result is 636.13.

    //De R$ 3.751,06 a R$ 4.664,68 | 22,5% | R$ 636,13
//    Test case with a salary of 3751.06 and no dependents. The expected result is 636.13.
//    Test case with a salary of 3751.07 and no dependents. The expected result is 636.13.
//    Test case with a salary of 4664.68 and no dependents. The expected result is 869.36.

    //Acima R$ 4.664,68 | 27,5% | R$ 869,36
//    Test case with a salary of 4664.69 and no dependents. The expected result is 869.36.
//    Test case with a salary of 4664.70 and no dependents. The expected result is 869.36.

//    Test case with a salary of 30000.00 and one dependent. The expected result is 2593.41.
//    Test case with a salary of 30000.00 and two dependents. The expected result is 2372.11.
//    Test case with a salary of 30000.00 and three dependents. The expected result is 2151.81.
//    Test case with a salary of 30000.00 and four dependents. The expected result is 193.51.
//    Test case with a salary of 30000.00 and five dependents. The expected result is 0.0.
//    Test case with a salary of 30000.00 and six dependents. The expected result is 0.0.
//    Test case with a salary of 30000.00 and seven dependents. The expected result is 0.0.
//    Test case with a salary of 20000.00 and no dependents. The expected result is 0.0.
//    Test case with a salary of 20000.00 and one dependent. The expected result is 0.0.
//    Test case with a salary of 50000.00 and no dependents. The expected result is 4221.75.
//    Test case with a salary of 50000.00 and one dependent. The expected result is 3900.45.
//    Test case with a salary of 50000.00 and five dependents. The expected result is 3410.86.

    @Test
    public void testCalcularIRRF_1903_98_0_dependents() {
        double salarioBruto = 1903.98;
        int quantidadeDependentes = 0;
        double expected = 0.0;
        double result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testCalcularIRRF_1903_99_0_dependents() {
        double salarioBruto = 1903.99;
        int quantidadeDependentes = 0;
        double expected = 142.80;
        double result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testCalcularIRRF_2826_65_0_dependents() {
        double salarioBruto = 2826.65;
        int quantidadeDependentes = 0;
        double expected = 354.80;
        double result = TabelaIRRF.calcularIRRF(salarioBruto, quantidadeDependentes);
        assertEquals(expected, result, 0.01);
    }
    //...and so on for the remaining test cases
}