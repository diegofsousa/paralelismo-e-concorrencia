# Operações atômicas

- Para evitar que um objeto tenha um comportamento indesejado quando duas ou mais threads o consomem ao mesmo tempo, é importante sincronizá-lo.
- Para isso temos os objetos atômicos.
- Eles garantes que a mudança do objeto seja concluida pela thread que pegá-lo primeiro.
- Temos AtomicInteger, AtomicLong, AtomicFalse, AtomicReference, etc.