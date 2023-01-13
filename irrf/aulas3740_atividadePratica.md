### INF0303_2022/2 - Semana 10 - Dia 11/01/2023 - Encontro 10 - Aulas 37a40 - Atividade Pratica

1. Considere a implementação do cálculo do Imposto de Renda Retido na Fonte, constante do arquivo irrf.zip;
2. Os valores atuais para cálculo do Imposto de Renda estão descrito na tabela a seguir:

|Salário|Percentual|Parcela Dedutível|
|---|---|---|
|Até R$ 1.903,98|0%|R$ 0,00|
|De R$ 1.903,99 a R$ 2.826,65|7,5%|R$ 142,80|
|De R$ 2.826,66 a R$ 3.751,05|15,0%|R$ 354,80|
|De R$ 3.751,06 a R$ 4.664,68|22,5%|R$ 636,13|
|Acima R$ 4.664,68|27,5%|R$ 869,36|

* O Desconto por dependente é de R$ 189,59
* A contribuição previdenciária está convencionada, neste trabalho em 10% do valor do Salário do trabalhador.

3. A Fórmula para se calcular o imposto de renda retido na fonte é a seguinte:

  1. Obtém-se o salário bruto;
  2. Desconta-se o valor da contribuição previdenciária;
  3. Desconta-se o valor de dedução por dependente multiplicado pela quantidade de dependentes;
  4. Considere que o resultado destas operações anteriores como o valorTributável;
  5. Aplica-se o percentual correspondente à faixa de valor em que o valorTributável se encaixa;
  6. Subtrai a parcela a deduzir. O Resultado é o valor do imposto a ser retido.

4. Este cálculo já está implementado no arquivo referenciado. Que possui o método calcularIRRF, que recebe como parâmetro o valor do salário bruto e a quantidade de dependentes.
5. Pede-se:

  5.1 A elaboração de Casos de teste para exercitar diversos cenários possíveis para o cálculo do IRRF.
  5.2 O que deve ser validado é o valor do IRRF calculado. Sugestão use o seguinte comando para validação:
  ~~~java
  assertTrue(valor1 == valor2);

  ~~~
  onde valor1 é o valor esperado e valor2 o valor calculado;

  5.3 Esta tarefa para conseguir alcançar a nota máxima 10, deverá possuir pelo menos 20 casos de testes que obtenha sucesso na sua execução.
