# Programação paralela vs programação concorrente

## Execução monothread e execução multithread

Execução monothread é o que conhecemos como programação iniciante. Uma sequencia de passos é executada ordenadamente um após o outro:

```
1. Linha 1
2. Linha 2
3. Linha 3
```

Na execução multithread um recurso é dividido entre duas ou mais partes de código de forma que a ordenação seja feita por este recurso:

```
1. Linha 1 da execução 1
2. Linha 2 da execução 2
3. Linha 1 da execução 2
4. Linha 2 da execução 1
...
```

## Paralelismo e concorrência

Paralelismo: execução de vários trechos de código no mesmo instante. Isso só é possível quando temos um processador com mais de um núcleo.

Concorrência: várias execuções de código concorrendo pelo mesmo recurso.

> Disclaimer: Aplicações Web

Geralmente os frameworks Web tem maneiras próprias de abordar programação paralela e concorrente. Por isso devemos tomar cuidado ao implementar este tipo de programação com Java puro em frameworks da moda hahahah.

## Quando que usamos isso?

- Processos em batch (em lote);
- Aplicações que executam no cliente.