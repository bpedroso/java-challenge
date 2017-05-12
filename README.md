## FindVowel

- Método que resulta o primeiro caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita no resto da stream.
- Método que recebe a interface Stream proprietária com os métodos next() e hasNext()  

Maven 3
Java 8
Junit 4.12

### Desenvolvimento:
 - O algorítmo para buscar a primeira vogal foi o Linear Search O(n), guardando os valores do último e penúltimo caractere.
 - Os valores são armazenados em um LinkedHashMap que mantém a ordem de inserção.
 - No retorno, pega-se o primeiro valor inserido que não se repete ou lança uma exception.

### Testes:

```mvn test```

 - Cenário 1 (aAbBABacafj): String que não contém o caractere que atendam as regras especificadas. Neste cenário é validado se o método lança a exception.

 - Cenário 2 (aAbBABacafe): String que contém um caractere que atende as regras especificadas. Neste cenário é validado que a vogal esperada é a vogal encontrada.

 - Cenário 3 (aAbBABadicafe): String que contém mais de um caractere que atende as regras especificadas. Neste cenário é validado que a vogal esperada é a primeira vogal encontrada.


## O que é Deadlock? Detalhe um pouco sobre o caso e como você poderia resolver isso

O deadlock ocorre quando serviços que executam processos paralelos consomem recursos compartilhados e estes não foram projetados para isto. Quando estas multi tarefas tentam acessar este mesmo recurso, um processo precisa aguardar o outro finalizar para consumir o mesmo recurso.

Quando trabalhamos com serviços de alta audiência esta concorrência de recursos podem derrubar estes gerando uma exception.

Com o avanço da arquitetura de microserviços, temos mais pontos de falhas de deadlock, visto que multiplos microserviços podem ser escaláveis facilmente então comumente existem chamadas em paralelo para algum outro microserviço.

Neste cenário, uma boa solução seria implementar soluções que consomem e respondem para recuros de forma assíncrona com a utilização de mensageria e streaming de dados. 
Outra solução quando trabalhamos com auto recover e que os dados podem ser recebidos novamente semq ue haja impacto no negócio, seria trabalhar com multithread de forma assíncrona dentro do serviço e caso este exceda o número de threads ou de recursos alocados para aquele serviço, restartado para que o processo seja reiniciado (isto não deveria ser utilizado por exemplo quando o deadlock ocorre por chamadas circular).


## Descreva com suas palavras quando qual é a diferença entre Stream e ParallelStream os dois e quando devemos utilizar cada um deles

A diferença principal entre as duas formas de navegarmos em uma Stream seja para fazer um mapeamento, aplicar um filtro, uma redução ou executar alguma função, é que o Stream funciona de forma serial, e o ParallelStream funciona de forma paralela, ou seja abre várias threads para executar a função.

Para que possamos utilizar o parallel stream, é importante que a coleção seja ordenada ou que não dependamos desta ordem para obter o resultado esperado. Mesmo que a chamada tenha característica em que permita executar um parallelstrem, isto não é garantia de melhoria de performance, visto que também dependerá dos recursos alocados para o serviço que está executando, ou seja, o número de CPUs.

Devemos utilizar o Stream para coleções em que a característica do serviço já é exerce paralelismo (como recebimento de requests assíncronos de um rest service) e a coleção não tem um tamanho muito grande.

O ParallelStream deve ser utilizado quando tempos problemas de performance e trabalhamos com coleções muito grandes.
