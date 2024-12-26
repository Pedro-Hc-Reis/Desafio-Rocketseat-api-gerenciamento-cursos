# API de Gerenciamento de Cursos 🎓

Bem-vindo à **API de Gerenciamento de Cursos**! Este projeto foi desenvolvido como parte de um desafio da trilha de Java do **Ignite Rocketseat**, com o objetivo de praticar conceitos fundamentais de Java e Spring Boot, como criação de APIs RESTful, validações, tratamento de exceções e persistência de dados.

---

## 🚀 Funcionalidades

### **Gerenciamento de Cursos**
- **Criar um curso**: Adiciona um novo curso ao sistema com os dados fornecidos.
- **Listar todos os cursos**: Retorna todos os cursos cadastrados.
- **Buscar cursos por nome ou categoria**: Permite filtrar os cursos pelo nome ou categoria.
- **Atualizar um curso**: Altera os dados de um curso existente pelo seu ID.
- **Deletar um curso**: Remove um curso existente pelo seu ID.
- **Alternar status ativo/inativo**: Alterna entre os estados `ATIVO` e `INATIVO` para os cursos.

---

## 🛠️ Estrutura do Projeto

O projeto foi construído com base no framework **Spring Boot**, utilizando as melhores práticas para organização de código. Abaixo, segue a descrição das principais classes e funcionalidades:

### **1. Curso**
Representa a entidade principal do sistema, com os seguintes atributos:
- `id`: Identificador único do curso.
- `name`: Nome do curso.
- `category`: Categoria do curso.
- `status`: Status do curso (`ATIVO` ou `INATIVO`).
- `createdAt`: Data de criação do curso.
- `updatedAt`: Última data de atualização do curso.

### **2. CursoDTO**
Uma classe simples para transferência de dados (Data Transfer Object), usada para capturar e validar as informações fornecidas pelo cliente.

### **3. CursoService**
Contém a lógica de negócios para gerenciar os cursos, com métodos para criar, buscar, atualizar, deletar e alternar o status dos cursos.

### **4. CursoRepository**
Interface que interage diretamente com o banco de dados, utilizando o **Spring Data JPA** para operações CRUD e consultas customizadas.

### **5. CursoNotFoundException**
Uma exceção personalizada para lidar com cenários em que um curso não é encontrado no sistema.

### **6. GlobalExceptionHandler**
Classe para tratamento global de erros, garantindo respostas claras e padronizadas em caso de falhas.

---

## 🏃‍♂️ Como Usar

### **Endpoints da API**

1. **Criar um curso**
   - **URL**: `POST /cursos`
   - Corpo da requisição:
     ```json
     {
       "name": "Java Avançado",
       "category": "Programação"
     }
     ```

2. **Listar todos os cursos**
   - **URL**: `GET /cursos`

3. **Buscar cursos por nome ou categoria**
   - **URL**: `GET /cursos/search`
   - Parâmetros:
     - `name` (opcional): Filtra pelo nome.
     - `category` (opcional): Filtra pela categoria.

4. **Atualizar um curso**
   - **URL**: `PUT /cursos/{id}`
   - Corpo da requisição:
     ```json
     {
       "name": "Spring Boot Essentials",
       "category": "Desenvolvimento"
     }
     ```

5. **Deletar um curso**
   - **URL**: `DELETE /cursos/{id}`

6. **Alternar o status ativo/inativo**
   - **URL**: `PATCH /cursos/{id}/active`

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória para desenvolvimento)
- **Jakarta Validation** (para validações de dados)
- **Lombok** (para reduzir código boilerplate)
- **Maven** (gerenciador de dependências)

---

## 📦 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/api-gerenciamento-cursos.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd api-gerenciamento-cursos
   ```
3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a API em: [http://localhost:8080](http://localhost:8080)

---

## 🙌 Contribuição

Fique à vontade para contribuir com melhorias ou sugestões. Para isso:
1. Faça um fork do repositório.
2. Crie uma nova branch para sua funcionalidade (`git checkout -b feature/nova-funcionalidade`).
3. Envie um Pull Request com as mudanças propostas.

---

### Obrigado por conferir a API de Gerenciamento de Cursos! 🚀
