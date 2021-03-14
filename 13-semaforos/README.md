# Semáforos

- O conceito de semáforos para threads se assemelha ao seu sentido literal. Com ele conseguimos limitas a quantidade de tarefas a serem executadas de acordo com as vagas definidas em `new Semaphore(3)`.
- Para adiquirir uma vaga, a thread deve chamar `acquire()` e para notificar que liberou a vaga a thread deve chamar `.release()`.
- O `tryAcquire()` possibilita verificar se há vagas para execução dentro do semáforo e retornar esta consulta para a thread.