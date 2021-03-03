# Coleções thread-safes

- Existem coleções próprias para lidarmos com programação paralela.
- CopyOnWriteArrayList é uma alternativa para o List menos performática, pois sempre faz uma cópia de si mesma em operações para garantir sua integridade.
- ConcurrentHashMap é um HashMap thread-safe. Também mais pesado, mas com synchronized embutido.
- LinkedBlockingQueue é uma fila thread-safe, que pode ser bastante útil em cenários de add e remove com várias threads.
- Também temos LinkedBlockingDeque, que faz o mesmo papel do LinkedBlockingQueue, porém funciona como uma fila com operações dos dois lados: esquerdo e direito.