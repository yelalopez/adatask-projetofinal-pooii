# AdaTaskApp - Aplicativo de Gerenciamento de Tarefas via Console

## Descrição Geral

O AdaTask é um aplicativo de console desenvolvido em Java para gerenciamento de tarefas pessoais e profissionais. Ele oferece funcionalidades como criação, edição, remoção e visualização de tarefas, utilizando listas em memória para simular um banco de dados.
O projeto foi desenvolvido como projeto final do Modulo 2, do Programa`<Dev>ª` da Ada Tech em parceria com a B3.

## Estrutura do Projeto

### Camada de Domain (Domínio):

- Classes: BaseTask, PersonalTask, WorkTask, StudyTask.
- Define a estrutura e as regras de negócios das tarefas.

### Camada de Repository (Repositório):

- Responsável pela "persistência" dos dados em listas.
- Métodos para adicionar, remover, atualizar e buscar tarefas.

### Camada de Service (Serviço):

- Lógica de aplicação, incluindo operações de manipulação de tarefas.
- Interação com a camada de Repository para realizar operações de dados.

### Camada de Controller (Controlador):

- Gerencia a interação do usuário com o sistema via console.
- Processa comandos do usuário e utiliza a camada de Service para executar operações.

## Principais Funcionalidades

1. **Criação de Tarefas:**
    - Adicionar novas tarefas com detalhes como título, descrição, prazo, etc.

2. **Edição de Tarefas:**
    - Atualizar detalhes de tarefas existentes.

3. **Remoção de Tarefas:**
    - Deletar tarefas existentes.

4. **Visualização de Tarefas:**
    - Listar todas as tarefas ou filtrar por critérios específicos.

## Implementação Técnica

- **Classes de Entidade:**
    - Utilização de BaseTask e subclasses para representar diferentes tipos de tarefas.

- **Classe Repository:**
    - Utilização de uma lista para simular o armazenamento de dados.

- **Classe Service:**
    - Implementação da lógica de negócios.

- **Classe Controller:**
    - Processamento da entrada do usuário e comandos correspondentes.

## Considerações Adicionais

- O projeto teve como objetivo seguir os princípios SOLID para um design limpo e extensível.
- Demonstração da aplicação de herança e generics nas estruturas de dados e operações de manipulação de tarefas.
- Desenvolvido em Java.

## Instruções de Uso

1. Certifique-se de ter o ambiente Java instalado.
2. Clone o repositório 
```
https://github.com/yelalopez/adatask-projetofinal-pooii.git
```
3. Compile e execute o programa 
```
     javac -cp . br/com/adatask/Main.java
     java br.com.adatask.Main
```     
4. Siga as instruções na interface de linha de comando para interagir com o AdaTaskApp.

## Contribuições

Divirta-se gerenciando suas tarefas com o AdaTaskApp! Caso tenha alguma dúvida ou sugestão, Sinta-se à vontade para abrir problemas (issues) ou enviar pull requests.

