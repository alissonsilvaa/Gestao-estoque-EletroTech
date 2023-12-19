![logo](https://github.com/alissonsilvaa/Gestao-estoque-EletroTech/blob/main/logo2.png)
# Gestao-estoque-EletroTech

# Sistema de Gestão de Estoque EletroTech
O principal objetivo deste projeto é criar um sistema que permita à EletroTech monitorar e gerenciar seu estoque de forma eficaz, garantindo que haja sempre um equilíbrio adequado entre a oferta e a demanda.

### Índice

Uma seção de índice que lista e fornece links rápidos para as diferentes seções
do README.
Sobre o Projeto

Uma breve descrição do projeto, explicando o que é o Sistema de Gestão de
Estoque EletroTech e seus objetivos principais.
### Características

Uma lista das principais funcionalidades do sistema, como gestão de produtos,
controle de estoque, rastreamento de movimentações de estoque, e
administração de fornecedores.
Tecnologias Utilizadas

Uma seção detalhando as tecnologias e ferramentas utilizadas no
desenvolvimento do projeto, como Java, SQLite.
### Estrutura do Banco de Dados

O Sistema de Gestão de Estoque EletroTech foi desenvolvido para gerenciar de forma eficiente o estoque de produtos e a relação com os fornecedores, permitindo às empresas manter um controle preciso sobre o fluxo de produtos, desde o recebimento e a movimentação de saída.

**Componentes:**

* **Cadastro de Fornecedores**: Mantém um registro detalhado de todos os fornecedores, incluindo informações fiscais e comerciais. Isso permite à empresa rastrear e gerenciar suas relações comerciais com informações atualizadas e acessíveis.

* **Registro de Produtos**: Uma base de dados completa dos produtos, categorizando-os e descrevendo-os para facilitar a identificação, seleção e gestão de estoque.

* **Controle de Movimentação de Estoque**: Registra todas as movimentações de entrada e saída do estoque, fornecendo dados em tempo real sobre a disponibilidade de produtos, custos associados e datas de validade, o que é crucial para manter a integridade do inventário e evitar desperdícios.

* **Associação Fornecedor-Produto**: Uma tabela de associação que conecta produtos aos seus respectivos fornecedores, permitindo à empresa identificar rapidamente de onde os produtos estão vindo e para onde estão indo, o que é essencial para a gestão da cadeia de suprimentos e para negociações de compra.


<img src=https://github.com/leoarcabold/Sistema_de_Gestao_de_Estoque_EletroTech/blob/main/img/database.jpg width=100%>

O projeto descrito é um sistema de banco de dados relacional projetado para gerenciar as operações de inventário e as relações com fornecedores de uma empresa. A seguir, detalho a estrutura do banco de dados e a finalidade de cada uma das tabelas propostas:

```
-- Criação da tabela de Fornecedores
CREATE TABLE FORNECEDOR (
    Id INT PRIMARY KEY,
    CNPJ_CPF VARCHAR(18),
    Razao_Social VARCHAR(50),
    Nome VARCHAR(50)
);

-- Criação da tabela de Produtos
CREATE TABLE PRODUTOS (
    Id INT PRIMARY KEY,
    Nome VARCHAR(30),
    Descricao VARCHAR(100),
    Categoria VARCHAR(50)
);

-- Criação da tabela de Movimentação de Estoque
CREATE TABLE MOVIMENTACAO_ESTOQUE (
    Id INT PRIMARY KEY,
    Produto_Id INT,
    Data DATE,
    Quantidade REAL,
    Tipo_Movimentacao VARCHAR(30),
    Custo REAL,
    Lote INT,
    Validade DATE,
    FOREIGN KEY (Produto_Id) REFERENCES PRODUTO(Id)
);

-- Criação da tabela de associação entre Fornecedores e Produtos
CREATE TABLE FORNECEDOR_PRODUTO (
    Id INT PRIMARY KEY,
    Produto_Id INT,
    Fornecedor_Id INT,
    FOREIGN KEY (Produto_Id) REFERENCES PRODUTO(Id),
    FOREIGN KEY (Fornecedor_Id) REFERENCES FORNECEDOR(Id)
);
```
### Configuração do Projeto

Instruções sobre como configurar e iniciar o projeto. Esta seção é dividida em
duas subseções:

**Pré-Requisitos**: Lista de tudo que é necessário antes de começar a
instalação, como Java JDK, SQLitee uma IDE apropriada.

**Instalação e Execução**: Um passo a passo detalhando como clonar o
repositório, configurar o ambiente e executar o projeto.

### Uso

Uma explicação de como usar o sistema uma vez que esteja em funcionamento,
descrevendo as operações de CRUD e outras funcionalidades.
### Contribuições

Diretrizes sobre como contribuir para o projeto, incluindo como fazer fork, criar
branches, fazer commits, e abrir Pull Requests.
### Licença

Informações sobre a licença sob a qual o projeto é distribuído, geralmente a
licença MIT para projetos de código aberto.
### Contato

Detalhes de contato do autor ou mantenedor do projeto, incluindo nome, e-mail,
e link para o repositório do projeto no GitHub.
