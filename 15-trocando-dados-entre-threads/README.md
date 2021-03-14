# Trocando dados entre threads

- Bom, não tem muito o que explicar. O título é auto-explicativo.
- Temos duas formas para fazer isso: Pelo SynchronousQueue e pelo Exchanger.
- SynchronousQueue é uma fila em que uma thread envia informações para outra. Porém se uma adicionar e não tiver outra pra receber, o programa não encerra. O contrário também acontece o mesmo comportamento.
- Exchanger funciona como uma troca de informações. Mão dupla. Então uma thread envia e recebe informações de outra thread.