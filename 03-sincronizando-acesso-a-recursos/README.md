# Sincronizando acesso a recursos

- Quando temos algum recurso e várias threads alterando este recurso podemos ter dores de cabeça. Para evitar isso foi criado o synchronized.
- O synchronized pode ser usado na assinatura do metodo `run()` da interface runnable.
- Podemos ter mais de um synchronizeds com barreiras dististas usando objetos burros `Object`.
- O side-effect dessa abordagem é que isso mata o paralelismo. Pois se temos um mecanismo que organiza as threads para consumir um recurso, qual a razão de usarmos programação paralela?
- Então a melhor abordades de usar o synchronized é isolá-lo apenas no trecho de código que deve ser organiizado para consumo de threads.