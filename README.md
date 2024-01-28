# Projeto Exemplo com AWS SNS, SQS, MongoDB, Amazon S3 e AWS Lambda

## Visão Geral

O projeto utiliza várias tecnologias da AWS para construir uma solução escalável e resiliente. Ele consiste em mensageria assíncrona, armazenamento de dados, processamento de dados e armazenamento de objetos.

## Tecnologias Utilizadas

- **AWS SNS (Simple Notification Service):** Para a publicação de mensagens e notificações.
- **AWS SQS (Simple Queue Service):** Para a fila de mensagens que armazenará as mensagens enviadas pelo SNS.
- **MongoDB:** Como banco de dados para armazenamento persistente.
- **Amazon S3:** Para armazenamento de objetos e gerenciamento de arquivos.
- **AWS Lambda:** Para processamento de eventos.


## Componentes do Projeto

### 1. SNS e SQS

- Configure um tópico no SNS para a publicação de mensagens.
- Configure uma fila SQS que será assinada para receber mensagens do tópico SNS.

### 2. MongoDB

- Configure e inicie uma instância MongoDB para armazenamento de dados.

### 3. Amazon S3

- Crie um bucket S3 para armazenamento de objetos.

### 4. AWS Lambda

- Implemente funções Lambda para processar eventos e interagir com outros serviços.

## Configuração do Ambiente de Desenvolvimento

1. **Configuração AWS:**
   - Configure suas credenciais AWS localmente para autenticação.
   - Crie os tópicos SNS, filas SQS e bucket S3 usando o console AWS ou AWS CLI.

2. **Configuração do Projeto:**
   - Clone o repositório do projeto.
   - Configure as variáveis de ambiente necessárias, como credenciais, URLs do MongoDB, etc.

## Executando o Projeto

1. **Instale Dependências:**
   - Execute `mvn install` para instalar as dependências do projeto.

2. **Execute o Projeto:**
   - Execute a aplicação localmente com `mvn spring-boot:run`.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas ou enviar solicitações pull.


