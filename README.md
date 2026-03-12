# 📝 To-Do List API (Java + Spring Boot)

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de tarefas (To-Do List), utilizando **PostgreSQL** como banco de dados.
Este projeto foi desenvolvido com o objetivo de praticar conceitos de **desenvolvimento de APIs REST**, arquitetura em camadas e integração com banco de dados relacional.

---

# 🚀 Tecnologias Utilizadas

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL**
* **Maven**
* **Lombok**
* **Swagger / OpenAPI**

---

# 📂 Estrutura do Projeto

O projeto segue uma arquitetura em camadas comum em aplicações Spring Boot.

```
src/main/java/com/.../toDoList

config        → configurações da aplicação
controller    → endpoints da API
dto           → objetos de transferência de dados (DTOs)
mapper        → conversão entre Entity e DTO
model         → entidades JPA
repository    → acesso ao banco de dados
service       → regras de negócio
```

Essa estrutura ajuda a manter o código **organizado, desacoplado e fácil de manter**.

---

# 🗄 Banco de Dados

Banco utilizado:

```
PostgreSQL
```

Tabela principal:

```
tarefas
```

A persistência é realizada utilizando **Spring Data JPA**.

---

# 🔗 Endpoints da API

### Criar tarefas

```
POST /tarefas
```

Cria uma nova tarefa.

Exemplo de JSON:

```json
{
  "nome": "Estudar Spring Boot",
  "descricao": "Desenvolver API ToDoList",
  "status": false,
  "dataCriacao": "2026-03-12"
}
```

---

### Criar múltiplas tarefas

```
POST /tarefas/lista
```

Cria várias tarefas em uma única requisição.

---

### Listar todas as tarefas

```
GET /tarefas
```

Retorna todas as tarefas cadastradas.

---

### Buscar tarefa por ID

```
GET /tarefas/{id}
```

Retorna uma tarefa específica.

---

### Buscar tarefas por status

```
GET /tarefas/status?status=true
```

ou

```
GET /tarefas/status?status=false
```

---

### Buscar tarefas por nome

```
GET /tarefas/nome?nome=texto
```

Retorna tarefas contendo o texto informado no nome.

---

### Atualizar status da tarefa

```
PUT /tarefas/{id}/status?status=true
```

Altera o status de uma tarefa.

---

### Atualizar conteúdo da tarefa

```
PUT /tarefas/{id}
```

Atualiza as informações de uma tarefa existente.

---

### Contar tarefas

```
GET /tarefas/count
```

Retorna o número total de tarefas cadastradas.

---

### Deletar tarefa por ID

```
DELETE /tarefas/{id}
```

Remove uma tarefa específica.

---

### Deletar todas as tarefas

```
DELETE /tarefas
```

Remove todas as tarefas do banco de dados.

---

# 📑 Documentação da API

A API possui documentação automática utilizando **Swagger / OpenAPI**.
Após iniciar a aplicação, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

---

# ⚙️ Como Executar o Projeto

### 1️⃣ Clonar o repositório

```
git clone https://github.com/Luizpk22/to-do-list.git
```

---

### 2️⃣ Entrar na pasta do projeto

```
cd toDoList
```

---

### 3️⃣ Executar a aplicação

Usando Maven:

```
mvn spring-boot:run
```

Ou executando a classe principal do projeto.

---

# 📌 Funcionalidades

✔ Criar tarefas
✔ Criar múltiplas tarefas
✔ Listar tarefas
✔ Buscar por ID
✔ Buscar por nome
✔ Buscar por status
✔ Atualizar tarefa
✔ Atualizar status da tarefa
✔ Contar tarefas
✔ Remover tarefas

---

# 📚 Conceitos Aplicados

* API REST
* Arquitetura em camadas
* DTO (Data Transfer Object)
* Mapper para conversão Entity ↔ DTO
* Spring Data JPA
* Integração com PostgreSQL
* Documentação com Swagger

---

# 👨‍💻 Autor

**Luiz Henrique da Silva**
Projeto desenvolvido para estudo de **Java e Spring Boot no desenvolvimento de APIs REST**.
