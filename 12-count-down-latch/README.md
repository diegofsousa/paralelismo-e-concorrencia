# Count Down Latch

- As vezes queremos adicionar um comportamento a alguma váriavel dentro de uma thread mas apenas em um período específico, mas descobrimos que não há precisão de tempo, pois threads são incertas quanto a este fator. O mais seguro a se fazer é adicionar comportamentos a variáveis em função de chamadas das próprias threads ou um objeto em comum.
- Para esta finalidade existe o Count Down Latch.
- Declaramos como `private static CountDownLatch latch = new CountDownLatch(3);` passando o valor que queremos que vá decrementando. Quando este chega a 0, o método `await()` é validado para que estanque a mudança de variável no contexto. Assim que é retornado, o valor é alterado em tempo de execução.
- Count Down Latch não é cíclico, mas substitui o `Thread.sleep`.