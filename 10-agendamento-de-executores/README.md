# Agendamento de executores

- Quando usamos o `schedule`, agendamos a tarefa para ser executada daqui a um tempo, porém uma única vez.
- Quando usamos o `scheduleAtFixedRate`, ele vai executar de forma periódica com intervalo entre execuções igual ao maior tempo dado, sendo no comando dado ou no tempo de execução do Runnable.
- Quando usamos o `scheduleWithFixedDelay` ele vai fazer a mesma coisa que o `scheduleAtFixedRate`, porém o tempo de intervalo entre as execuções será a soma entre o tempo definido na instrução e o tempo de espera na execução do Runnable.