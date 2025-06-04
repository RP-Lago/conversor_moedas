# 💰 Conversor de Moedas - Desafio Alura ONE

## 🚀 Sobre o Projeto

Este projeto é uma implementação de um **Conversor de Moedas** desenvolvido como parte do programa **Oracle Next Education (ONE)**, em parceria com a **Alura**. O objetivo principal é criar uma aplicação de console em Java capaz de realizar conversões de moedas em tempo real, utilizando uma API externa para obter as taxas de câmbio dinamicamente.[1]

Este desafio é uma oportunidade crucial para aplicar e consolidar conhecimentos em Java, especialmente em Orientação a Objetos, manipulação de listas, consumo de APIs e tratamento de erros.[1] Além de ser um exercício prático, o projeto serve como um "cartão de visitas" para o mercado de trabalho, demonstrando a capacidade de resolver problemas e construir soluções funcionais.[1]

## ✨ Funcionalidades

  * **Interação via Console:** Interface de usuário simples e intuitiva através do terminal.[1]
  * **Múltiplas Opções de Conversão:** Oferece um menu com, no mínimo, seis opções de conversão entre moedas populares (USD, BRL, EUR, GBP).[1]
  * **Taxas de Câmbio em Tempo Real:** As cotações são obtidas dinamicamente da **Exchange Rate API**, garantindo valores atualizados.[1]
  * **Processamento de JSON:** Utiliza a biblioteca **GSON** para desserializar as respostas JSON da API, transformando os dados em objetos Java manipuláveis.[1]
  * **Tratamento Básico de Erros:** Inclui tratamento para entradas inválidas do usuário e erros de comunicação com a API.

## 🛠️ Tecnologias Utilizadas

  * **Java 11+:** Linguagem de programação principal.
  * **Maven:** Ferramenta de automação de build e gerenciamento de dependências.
  * **Gson:** Biblioteca Java para serialização/desserialização de objetos Java para/de JSON.
  * **Exchange Rate API:** API gratuita para obter taxas de câmbio em tempo real.

## ⚙️ Pré-requisitos

Antes de começar, certifique-se de ter instalado:

  * **Java Development Kit (JDK) 11 ou superior.**
  * **Apache Maven** (se não estiver usando uma IDE que o integre, como IntelliJ IDEA).
  * Uma IDE como **IntelliJ IDEA** (recomendado) ou **VS Code** com as extensões Java.

## 🚀 Como Configurar e Rodar o Projeto

Siga os passos abaixo para configurar e executar o Conversor de Moedas em sua máquina.

### 1\. Obtenha sua Chave de API

1.  Acesse o site da([https://www.exchangerate-api.com/](https://www.exchangerate-api.com/)).
2.  Faça um registro inicial com seu e-mail para obter sua **chave de API (API Key)**. Esta chave será sua "string de conexão" para autenticar suas requisições.[1]

### 2\. Clone o Repositóriobash

git clone [https://github.com/SEU\_USUARIO\_GITHUB/SEU\_REPOSITORIO.git](https://www.google.com/search?q=https://github.com/SEU_USUARIO_GITHUB/SEU_REPOSITORIO.git)
cd SEU\_REPOSITORIO

````

### 3. Adicione a Dependência GSON

Se você estiver usando Maven (o que é recomendado e o projeto foi estruturado para isso), adicione a seguinte dependência ao seu arquivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>
````

Após adicionar, salve o `pom.xml`. Sua IDE (IntelliJ ou VS Code) deve sincronizar automaticamente as dependências. Se não, force a sincronização Maven.

### 4\. Configure sua Chave de API no Código

1.  Abra o arquivo `src/main/java/com/seunome/conversor/CurrencyConverterAPI.java` (ajuste o caminho do pacote conforme o seu projeto).

2.  Localize a linha:

    ```java
    private static final String API_KEY = "SUA_API_KEY_AQUI";
    ```

3.  Substitua `"SUA_API_KEY_AQUI"` pela sua chave de API real obtida no passo 1.

    **⚠️ Importante:** Em um projeto de produção, **nunca** deixe sua chave de API diretamente no código. Considere usar variáveis de ambiente ou um arquivo de configuração `.env` que seja adicionado ao `.gitignore` para maior segurança.

### 5\. Execute o Projeto

#### Usando IntelliJ IDEA (Recomendado)

1.  Abra o projeto no IntelliJ IDEA.
2.  Navegue até `src/main/java/com/seunome/conversor/Main.java`.
3.  Clique no botão "Run" (triângulo verde) ao lado do método `main` ou clique com o botão direito no arquivo `Main.java` e selecione `Run 'Main.main()'`.

#### Usando VS Code

1.  Abra a pasta do projeto no VS Code.
2.  Certifique-se de ter o "Extension Pack for Java" instalado.
3.  Navegue até `src/main/java/com/seunome/conversor/Main.java`.
4.  Clique no botão "Run" (triângulo verde) no canto superior direito ou clique com o botão direito no arquivo `Main.java` e selecione "Run Java".

#### Via Terminal (Maven)

1.  Abra o terminal na raiz do seu projeto.
2.  Compile e execute o projeto com o Maven:
    ```bash
    mvn clean install
    mvn exec:java -Dexec.mainClass="com.seunome.conversor.Main"
    ```
    (Ajuste `com.seunome.conversor.Main` para o caminho completo da sua classe `Main` se for diferente).

### 6\. Interaja com o Conversor

Após executar, o programa exibirá um menu no console. Siga as instruções para escolher a opção de conversão e digitar o valor.

## 📂 Estrutura do Projeto

  * `src/main/java/com/seunome/conversor/Main.java`: Ponto de entrada da aplicação, gerencia a interação com o usuário e o fluxo principal.
  * `src/main/java/com/seunome/conversor/CurrencyConverterAPI.java`: Responsável por fazer as requisições HTTP para a Exchange Rate API e obter as taxas de câmbio.
  * `src/main/java/com/seunome/conversor/ExchangeRateResponse.java`: Classe POJO (Plain Old Java Object) que mapeia a estrutura da resposta JSON da API para objetos Java.
  * `src/main/java/com/seunome/conversor/CurrencyOption.java`: Enum que define as opções de conversão de moedas disponíveis no menu.
  * `pom.xml`: Arquivo de configuração do Maven, gerencia as dependências do projeto (como o GSON).

## 💡 Próximos Passos e Melhorias (Tornando-o "Incrível")

Este projeto pode ser expandido para se tornar ainda mais robusto e completo. Algumas ideias para ir além dos requisitos básicos incluem [1]:

  * **Loop de Execução Contínuo:** Permitir que o usuário faça múltiplas conversões sem reiniciar o programa, adicionando uma opção para sair.
  * **Histórico de Conversões:** Implementar uma funcionalidade para registrar e exibir as conversões realizadas, talvez salvando-as em um arquivo de texto simples ou em memória.
  * **Mais Opções de Moeda:** Expandir o `CurrencyOption` para incluir mais pares de moedas ou permitir que o usuário digite os códigos das moedas.
  * **Tratamento de Erros Avançado:** Adicionar validações mais específicas para a entrada do usuário e lidar com diferentes códigos de erro da API de forma mais granular.
  * **Interface Gráfica (GUI):** Explorar a criação de uma interface gráfica de usuário (usando Swing, JavaFX ou até mesmo uma interface web básica com Spring Boot/Spark) para uma experiência mais amigável.
  * **Testes Unitários:** Escrever testes para as classes de lógica de conversão e interação com a API.

## 🤝 Contribuição

Sinta-se à vontade para fazer um fork deste repositório, propor melhorias e enviar Pull Requests. Toda contribuição é bem-vinda\!

## 📄 Licença

Este projeto está licenciado sob a licença MIT.

## 🙌 Agradecimentos

  * À **Alura** e ao programa **Oracle Next Education (ONE)** pela oportunidade de aprendizado e pelo desafio prático.[1]
  * À **Exchange Rate API** por fornecer um serviço de taxas de câmbio gratuito e fácil de usar.
  cd my-project
```
    

![Badge-Conversor](https://github.com/user-attachments/assets/a5b8cfef-6ad3-4387-bbd8-2f50a935a358)

