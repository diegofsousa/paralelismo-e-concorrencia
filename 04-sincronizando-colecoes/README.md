# Sincronizando coleções

- Se estivermos usando programação paralela devemos ter cuidado com listas.
- As principais opções de collections (List, ArrayList, Map) não são thread-safes.
- Uma forma simples de tratarmos isso é usando o synchronized no momento de usar o `add()`.
- No entanto a melhor maneira de fazer isso é usando o synchronizedList, synchronizedMap e etc.