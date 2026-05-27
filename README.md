# AgroID - API de Inteligência para Monitoramento Agrícola (GS Java Advanced)

Esta é a API principal do ecossistema AgroID, desenvolvida em **Spring Boot 3.2.5** com banco de dados **Oracle**. Ela atua como a camada de inteligência orquestradora entre os dispositivos físicos de medição IoT (ESP32) e o aplicativo móvel do usuário final (React Native).

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.2.5**
  - **Spring Web** & **Spring HATEOAS** (APIs RESTful com hipermídia)
  - **Spring Data JPA** (Persistência e modelagem avançada)
  - **Spring Security** (Autenticação e Autorização)
  - **Spring Boot Validation** (Validações via annotations)
- **Auth0 java-jwt** (Criação e decodificação de Tokens JWT)
- **Springdoc OpenAPI / Swagger** (Documentação interativa da API)
- **Oracle SQL & PL/SQL** (Estruturas relacionais e lógica de negócio em banco)

---

## 🗄️ Modelagem de Banco de Dados (Oracle)

O banco de dados é composto por **6 tabelas principais**, sequências e visões de relatórios, localizados em `db/db_setup.sql` e `db/db_procedures.sql`.

### Tabelas Físicas
1. **`TB_USUARIO`**: Armazena dados de perfis de acesso (`USER`, `ESP32`, `ADMIN`), nomes, e-mails e senhas criptografadas.
2. **`TB_PROPRIEDADE`**: Representa as áreas de plantio, contendo nome, localização e tamanho em hectares.
3. **`TB_SENSOR`**: Contém tipo (`UMIDADE` ou `LUMINOSIDADE`), modelo e status do sensor. Mapeia a hierarquia de herança no Java.
4. **`TB_LEITURA`**: Tabela de histórico bruto de medições enviadas pelo ESP32. Implementa chave primária composta `(id_sensor, data_leitura)`.
5. **`TB_ALERTA`**: Tabela de registro de alertas gerados pela API ou por procedimentos PL/SQL.
6. **`TB_SATELITE_DADOS`**: Armazena dados de clima e previsões coletadas remotamente por satélite.

---

## ⚙️ Regras de PL/SQL Implementadas

As seguintes lógicas foram portadas diretamente para o banco de dados Oracle para otimização analítica:
- **`PROC_RELATORIO_RISCO` (Cursor Explícito)**: Percorre todas as propriedades com umidade atual abaixo de 20% e gera logs automáticos na tabela `TB_ALERTA`.
- **`PROC_CALCULAR_MEDIA_24H` (Loop & Decisão)**: Procedure que calcula a umidade média das últimas 24 horas para cada propriedade. Caso o valor esteja abaixo de 40%, gera alertas preventivos.
- **`PROC_INSERIR_LEITURA` (Tratamento de Exceções)**: Garante a inserção segura de leituras de sensores no banco, tratando violações de integridade (`FOREIGN KEY` inválida ou chave primária duplicada) via blocos `EXCEPTION`.
- **Visões de Relatórios (JOINs)**:
  - **`VW_PERFORMANCE_PROPRIEDADE`**: Agrupa dados de usuários, propriedades e leituras trazendo a performance (média, máxima e mínima) das áreas.
  - **`VW_SENSORES_SEM_LEITURA_RECENTE`**: Identifica sensores inativos ou sem comunicação há mais de 1 hora via `LEFT JOIN`.

---

## 🔒 Segurança e Perfis de Acesso (Spring Security + JWT)

A API possui dois fluxos de autenticação independentes protegidos por JWT:
1. **ESP32 (Perfil `ESP32`)**: Endpoint de recebimento de leituras (`POST /api/leituras`) requer token JWT de longa duração associado à role `ROLE_ESP32`.
2. **Mobile App (Perfil `USER`)**: Endpoints de listagem, cadastro e relatórios (`/api/areas/**`, `/api/sensores/**`, etc.) requerem autenticação tradicional do usuário via JWT com role `ROLE_USER`.

---

## 🔗 HATEOAS (Hipermídia)

Ao listar ou consultar as Áreas de Plantio/Propriedades (`/api/areas`), o JSON de retorno inclui links hipermídia dinâmicos:
- **`self`**: Link direto para os detalhes da propriedade consultada.
- **`sensores`**: Link direto que direciona para a lista de sensores e histórico daquela área (`/api/areas/{id}/sensores`), permitindo navegação fluida pelo App Mobile.

---

## 🛑 Validação e Erros Globais

- Utilização de `@Valid` nos DTOs de entrada.
- Restrições físicas: Leituras de sensores de umidade menores que `0%` ou maiores que `100%` são interceptadas dinamicamente e bloqueadas.
- **`ControllerAdvice`**: Tratamento global de exceções, retornando respostas padronizadas em JSON contendo timestamp, código HTTP, tipo do erro, mensagem amigável e caminho da requisição.

---

## 🚀 Como Executar o Projeto

1. **Scripts SQL**: Execute os arquivos `db/db_setup.sql` e `db/db_procedures.sql` no seu console/IDE do banco Oracle.
2. **Configuração**: Atualize a conexão JDBC no arquivo `src/main/resources/application.properties` com suas credenciais.
3. **Build e Testes**:
   ```bash
   mvn clean compile
   mvn test
   ```
4. **Execução**:
   ```bash
   mvn spring-boot:run
   ```
   A API estará rodando por padrão na porta `8080`.
