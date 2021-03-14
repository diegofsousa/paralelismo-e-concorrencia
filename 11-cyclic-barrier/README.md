# Cyclic Barrier

- Existem situações em que executamos várias threads, e em algum momento uma(s) devem esperar outra(s). Para ajudar nesse processo, existe o Cyclic Barrier.
- `new CyclicBarrier(3)` define a quantidade de participantes da "barreira".
- Dentro da(s) threads deve ser acionado o Cyclic Barrier através do método `.await()`.
- `new CyclicBarrier(3, runnable);` permite passar um Runnable finalizador. Ele será executado ao fim da execução das 3 threads.
- O Cyclic Barrier é cíclico. Então podemos retrabalhar seus atuadores pelo código.