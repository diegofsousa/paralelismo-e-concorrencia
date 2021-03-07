# Uso básico de executores

- Uma forma mais sofisticada e atual para trabalhar com threads no Java é usando Executors.
- Usando o `newSingleThreadExecutor`, conseguimos executar mais de um Runnable, o que não é permitido usando a classe Thread.
- Ao startar a thread, podemos usar o `execute` e o `submit`. A diferença é que o `submit` nos retorna um objeto do tipo Future.
- Com esse objeto Future é possível saber se a thread já terminou, forçar o desligamento da thread, e aguardar o termino com base em um tempo estabelecido. 
- Ao invés de usarmos o Runneble, podemos usar o Callable. Com o Callable é possível recuperar um valor que está retornando dentro de um thread assim que ela termina com o `get()`.