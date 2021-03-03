# Volatile

- Em alguns momentos quando usamos paralelismo podemos nos surpreender com valores de variáveis que não estão devidamente atualizadas.
- Isso acontece pelo fato que antes de ir para a memória RAM, a variável é armazenada em um tipo de cache.
- Em algum momento ao recuperar o valor que está na memória, ao invés de buscar o valor mais atual, o sistema acaba recuperando o valor antigo.
- Para evitar que isso aconteça, usamos o `volatile`. Ele declara ao sistema para que verifique sempre no espaço em RAM para esta variável.
- O outro conceito, `yield()`, serve para notificar ao sistema que a thread está ociosa e que o sistema pode passar trabalho para as próximas. Em um momento oportuno, o sistema pode voltar a acionar a thread com `yield`.