# Padrão Composite

Exemplo do padrão estrutural **Composite** aplicado ao organograma de uma empresa.
Um funcionário (folha) e um departamento (composto) compartilham o mesmo tipo e são
tratados da mesma forma. Um departamento pode conter funcionários e outros
departamentos, e calcula o seu custo (soma dos salários) e o número de pessoas
somando recursivamente tudo que há dentro dele, sem o cliente precisar saber se
está lidando com uma pessoa ou com uma hierarquia inteira.

## Conteúdo do repositório

- **Código-fonte** do exemplo implementando o padrão Composite (organograma de empresa).
- **Casos de teste** (JUnit) cobrindo o custo e a contagem de pessoas em folhas e departamentos, a soma recursiva em departamentos aninhados, a listagem indentada e o tratamento uniforme de folha e composto.
- **Diagrama UML** das classes, em formato de imagem.
