<p align="center">
  João Guilherme Faber // RA: 24.124.060-5
</p>

<h1 align="center">🎧 Spotifei: Sua Central de Informações Musicais 🎶</h1>

<p align="center">
  Um projeto Java Swing que te permite explorar e interagir com informações sobre suas músicas e podcasts favoritos, inspirado na lógica do Spotify.
</p>

<p align="center">
  <a href="https://github.com/SEU_USUARIO/SEU_REPOSITORIO/issues">
    <img src="https://img.shields.io/badge/contribu%C3%A7%C3%B5es-bemvindas-brightgreen.svg?style=flat-square" alt="Contribuições são bem-vindas">
  </a>
  <a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square" alt="Licença MIT">
  </a>
  <a href="https://github.com/SEU_USUARIO/SEU_REPOSITORIO/releases">
    <img src="https://img.shields.io/github/v/release/SEU_USUARIO/SEU_REPOSITORIO?style=flat-square" alt="Última versão">
  </a>
</p>

---

## ✨ Apresentando o Spotifei!

O **Spotifei** é uma plataforma desktop construída com **Java Swing**, **JDBC PostgreSQL** e seguindo o padrão **MVC (Model, View, Controller)**. Nosso objetivo é fornecer uma experiência intuitiva para você descobrir e organizar informações sobre o vasto universo de áudios digitais, desde suas músicas prediletas até os podcasts mais interessantes.

**Importante:** O Spotifei foca no **compartilhamento de informações** sobre as mídias. **Não realizamos a reprodução** dos áudios, mas oferecemos as ferramentas para você se manter organizado e informado!

## 🚀 Funcionalidades que Você Vai Adorar!

Explore um mundo de possibilidades com o Spotifei:

### 👤 Gerenciamento de Usuário

* **Cadastrar novo usuário:** Junte-se à nossa comunidade! Crie sua conta de forma rápida e fácil.
* **Login de usuário:** Acesse sua conta e personalize sua experiência.

### 🔎 Busca Inteligente

* **Buscar músicas por nome, artista ou gênero:** Encontre exatamente o que procura com nossa busca poderosa.
* **Listar informações de músicas buscadas:** Visualize detalhes importantes sobre as músicas encontradas.

### ❤️ Interação Musical

* **Curtir e descurtir músicas:** Mostre seu apreço pelas suas faixas favoritas!

### 💽 Gerenciamento de Playlists

* **Criar, editar, excluir playlists:** Organize suas músicas por humor, gênero ou como preferir.
* **Adicionar/remover músicas de playlists:** Mantenha suas playlists sempre atualizadas.

### 📜 Histórico Detalhado

* **Visualizar últimas 10 músicas buscadas:** Revise suas últimas descobertas musicais.
* **Visualizar lista de músicas curtidas:** Acesse rapidamente suas músicas favoritas.
* **Visualizar lista de músicas descurtidas:** Uma forma de lembrar o que não te agradou tanto.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

* **Linguagem de Programação:**Java
* **Banco de Dados:**PostgreSQL


## ⚙️ Como Executar o Projeto

Siga estes passos para rodar o Spotifei na sua máquina:

1.  **Pré-requisitos:**
    * Java Development Kit (JDK) instalado.
    * PostgreSQL instalado e configurado.
    * Algum ambiente de desenvolvimento integrado (IDE) para Java como IntelliJ IDEA, Eclipse ou NetBeans (opcional, mas recomendado).

2.  **Clonar o Repositório:**
    ```bash
    git clone [https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git](https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git)
    cd SEU_REPOSITORIO
    ```

3.  **Configurar o Banco de Dados:**
    * Crie um banco de dados chamado `spotifei` no seu PostgreSQL.
    * Configure as credenciais de acesso ao banco de dados no arquivo de configuração do projeto (geralmente em algum lugar dentro da pasta `src/main/resources`).

4.  **Executar o Projeto:**
    * **Via IDE:** Abra o projeto na sua IDE Java e execute a classe principal (geralmente localizada no pacote `main` e com um nome como `Main.java` ou `SpotifeiApp.java`).
    * **Via Maven (se aplicável):** No terminal, dentro da pasta do projeto, execute o comando:
        ```bash
        mvn clean javafx:run
        ```
        (Este comando pode variar dependendo da configuração do seu `pom.xml`).

## 🤝 Contribuições

Contribuições são sempre bem-vindas! Se você tem ideias para melhorar o Spotifei, encontrou algum bug ou quer adicionar novas funcionalidades, siga estas etapas:

1.  Faça um fork do repositório.
2.  Crie uma branch para sua feature (`git checkout -b feature/sua-nova-feature`).
3.  Faça seus commits (`git commit -am 'Adiciona uma nova feature incrível'`).
4.  Faça o push para a branch (`git push origin feature/sua-nova-feature`).
5.  Abra um Pull Request para que sua contribuição seja avaliada.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
