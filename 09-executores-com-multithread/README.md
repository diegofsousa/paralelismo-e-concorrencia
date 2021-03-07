# Executores com multithread

- Para adicionar mais threads ao mesmo pool, usamos o `newFixedThreadPool`. Com ele definimos uma quantidade máxima de threads para executar um conjunto de tarefas.
- Uma outra opção que pode ser usada é o `newCachedThreadPool`, que cria threads de acordo com a demanda. Quando uma thread é liberada e ainda há atividades a serem feitas, este método recicla esta thread para a nova atividade.
- O `invokeAll` seve para dar um submit em uma lista de Runnables ao mesmo tempo.