# Lock
- As interfaces Lock tem o mesmo objetivo do synchronized de bloquear o uso de recursos. Porém, estas interfaces são mais flexíveis.
- Elas permitem o bloqueio de um ou mais recursos em qualquer parte do programa. (bloquear em uma parte e desbloquear em outra complatamente diferente).
- A interface ReadWriteLock separa as responsabilidades de leitura e escrita. Enquando a escrita não pode ocorrer interferências no meio do caminho, a leitura consegue fazer este procedimento sem problemas, desde que não interfira dentro de um intervalo de lock do read.