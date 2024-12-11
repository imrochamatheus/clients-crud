# Clients CRUD

Projeto focado na construção de uma REST API para a realização de operações básicas de inserção, busca, atualização e deleção em um banco de dados.

## Funcionalidades 

- **Criação de tabelas**: Gera tabelas em um banco de dados H2 com base nas entidades (models) definidas no projeto.
- **Validação de estruturas**: Insere registros nas tabelas criadas através de um script sql, para validar sua estrutura
- **Busca por clientes** : Retorna listagem de clientes através de uma rota paginada, ou um único cliente à partir de um id fornecido
- **Inserção de novo cliente**: Realiza a inserção de um novo registro, com base nas informações fornecidas
- **Atualização de cliente**: Permite a atualização de um registro de cliente, à partir de um id fornecido
- **Deleção de um cliente**: Realiza a deleção de um cliente, à partir de um id fornecido
- **Tratamento de erros**: Realiza o tratamento de erros, fornecendo um feedback claro e intuitivo ao usuário
- **Validação de dados**: Verifica a correspondência das informações recebidas com o que é esperado pela aplicação
