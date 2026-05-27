# AgroID - Monitoramento Agrícola Inteligente

![GitHub repo size](https://img.shields.io/github/repo-size/Gabriel-Maciel06/GSJava?style=for-the-badge&color=brightgreen)
![GitHub language count](https://img.shields.io/github/languages/count/Gabriel-Maciel06/GSJava?style=for-the-badge&color=blue)
![GitHub forks](https://img.shields.io/github/forks/Gabriel-Maciel06/GSJava?style=for-the-badge&color=orange)
![GitHub open issues](https://img.shields.io/github/issues/Gabriel-Maciel06/GSJava?style=for-the-badge&color=red)
![GitHub open pull requests](https://img.shields.io/github/issues-pr/Gabriel-Maciel06/GSJava?style=for-the-badge&color=purple)

> O AgroID é uma API REST desenvolvida em Spring Boot e integrada ao banco Oracle que serve como a camada inteligente de orquestração entre dispositivos IoT (ESP32) e o aplicativo mobile (React Native) para controle de irrigação.

---

## 🛠️ Ajustes e melhorias

O projeto está com a base consolidada e as próximas atualizações serão voltadas para as seguintes tarefas:

- [ ] Integração em tempo real de atuadores físicos de irrigação (retransmissão de comandos da API para o ESP32)
- [ ] Envio de notificações push para o aplicativo mobile quando alertas críticos forem gerados
- [ ] Implementação de dashboards gráficos adicionais de telemetria no painel do usuário
- [ ] Otimização dos algoritmos de IA preditivos para análise climática por satélite
- [ ] Criação de testes automatizados ponta a ponta (E2E) para toda a esteira de endpoints

---

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você instalou a versão mais recente do **Java 21 ou superior** (necessário para rodar o Spring Boot).
* Você possui o gerenciador de dependências **Maven 3.8+** instalado.
* Você possui uma máquina **Windows, macOS ou Linux** compatível com a execução de ambientes Java.
* Você configurou uma instância local ou remota de banco de dados **Oracle SQL** ativa.

---

## 🚀 Instalando o AgroID

Para instalar e configurar o projeto localmente, siga estas etapas:

### Linux, macOS e Windows:

1. Clone o repositório utilizando a sua chave/token de acesso:
   ```bash
   git clone https://github.com/Gabriel-Maciel06/GSJava.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd GSJava
   ```
3. Instale as dependências e compile o projeto:
   ```bash
   mvn clean install
   ```

---

## ☕ Usando o AgroID

Para usar a aplicação e iniciar os serviços locais:

1. Certifique-se de configurar as credenciais do seu banco Oracle no arquivo `src/main/resources/application.properties`.
2. Rode a aplicação utilizando o comando Maven:
   ```bash
   mvn spring-boot:run
   ```
3. A API estará acessível em `http://localhost:8080`.
4. Você pode visualizar a documentação interativa do Swagger acessando `http://localhost:8080/swagger-ui.html`.

---

## 📫 Contribuindo para o AgroID

Para contribuir com o AgroID, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch com sua funcionalidade: `git checkout -b minha-nova-funcionalidade`.
3. Faça suas alterações e confirme-as com mensagens claras: `git commit -m "feat: adicionar nova funcionalidade"`.
4. Envie para o branch original: `git push origin minha-nova-funcionalidade`.
5. Crie a solicitação de pull (Pull Request) no GitHub.

---

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto acadêmico:

| [<img src="https://github.com/Gabriel-Maciel06.png" width="100px;" alt="Foto do Gabriel Maciel"/><br><sub><b>Gabriel Maciel</b></sub>](https://github.com/Gabriel-Maciel06) | [<img src="https://avatars.githubusercontent.com/u/14902636?v=4" width="100px;" alt="Foto da Vitória Rodrigues"/><br><sub><b>Vitória Rodrigues</b></sub>](#) | [<img src="https://avatars.githubusercontent.com/u/1903332?v=4" width="100px;" alt="Foto do Augusto Bonomo"/><br><sub><b>Augusto Bonomo</b></sub>](#) |
| :---: | :---: | :---: |
| **RM562795** | **RM565160** | **RM565155** |

| [<img src="https://avatars.githubusercontent.com/u/120023?v=4" width="100px;" alt="Foto do Thomas Fontes"/><br><sub><b>Thomas Fontes</b></sub>](#) | [<img src="https://avatars.githubusercontent.com/u/104104?v=4" width="100px;" alt="Foto do Matheus Molina"/><br><sub><b>Matheus Molina</b></sub>](#) |
| :---: | :---: |
| **RM562254** | **RM563399** |

---

## 📝 Licença

Este projeto está sob licença acadêmica da FIAP. Veja o arquivo de licença para mais detalhes.
