# Clean Architecture

A Clean Architecture é um princípio de design de software avançado que defende a separação de responsabilidades no sistema de software. A ideia principal por trás da Clean Architecture é a independência do código-fonte em relação aos detalhes. Essas dependências são extraídas para as camadas externas do sistema por meio de abstrações e inversão de controle.

A estrutura de Clean Architecture é geralmente dividida em quatro camadas diferentes:

1. **Camada de Entidades**: Esta é a camada mais interna do círculo da Clean Architecture. Ela contém entidades de negócios que são as representações de alto nível das regras de negócios.

2. **Camada de Casos de Uso**: Esta camada contém lógica de negócios específica. É onde as regras de negócios são aplicadas.

3. **Camada de Interface do Usuário**: Esta camada é responsável por lidar com a lógica relacionada à apresentação da interface do usuário e interfaces de usuário.

4. **Camada de Infraestrutura**: Esta é a camada mais externa do círculo da Clean Architecture. Contém detalhes que são específicos para a infraestrutura, como bancos de dados, frameworks da web e etc.

A ideia principal da Clean Architecture é que as camadas internas não devem saber nada sobre as camadas externas. Em outras palavras, as dependências devem sempre apontar para dentro. Essa regra permite um design de sistema altamente decoplado e testável, promovendo a separação de interesses e tornando o sistema mais fácil de manter e estender.

Além disso, a Clean Architecture facilita a substituição de componentes individuais sem afetar o resto do sistema, pois cada componente é menos dependente de implementações específicas e mais dependente de abstrações.

---

## Docker Compose
O Docker Compose é uma ferramenta útil que nos ajuda a definir e gerenciar múltiplos containers Docker juntos. Aqui está uma descrição passo a passo de como criar e executar o Docker Compose fornecido, usando a nova sintaxe que não requer a especificação de uma versão.

### Pré-requisitos

- Instalar o [Docker](https://docs.docker.com/get-docker/)
- Instalar o [Docker Compose](https://docs.docker.com/compose/install/) (versão 1.27.0 ou superior)

### Passos

1. Crie um arquivo chamado `docker-compose.yml` no diretório raiz do projeto.
   1. compose:
```yaml
services:
  database:
    image: "postgres:latest"
    container_name: clean_postgres_db
    environment:
      - POSTGRES_DB=${DB_NAME}
      - POSTGRES_USER=${DB_USERNAME}
      - POSTGRES_PASSWORD=${DB_PASSWORD}
    ports:
      - "5432:5432"
    volumes:
      - db-postgres-clean:/var/lib/postgresql/data

  clean-app:
    image: diegoneves/clean-architecture:latest
    container_name: clean_architecture_demo
    ports:
      - "8080:8080"
    depends_on:
      - database
    environment:
      - DB_HOST=clean_postgres_db
      - DB_PORT=5432
    entrypoint: sh -c "dockerize -wait tcp://clean_postgres_db:5432 -timeout 60s && java -jar target/clean-architecture.jar"

volumes:
  db-postgres-clean:
```

2. Copie e cole o conteúdo do arquivo fornecido para o `docker-compose.yml` que você acabou de criar.

3. Crie um arquivo `.env` no mesmo diretório que o seu arquivo `docker-compose.yml`. Este arquivo será usado para definir as variáveis de ambiente necessárias. Adicione as seguintes linhas ao arquivo `.env`:
    1. Arquivo `.env`
```dotenv
DB_USERNAME=locar_user
DB_PASSWORD=local_password
DB_NAME=local_db
```
4. Agora você pode rodar o Docker Compose usando o seguinte comando:
```shell
docker-compose up
```
5. O Docker Compose irá criar e iniciar os serviços database e clean-app.
   - O serviço database utiliza a imagem postgres:latest, expõe a porta 5432 e armazena dados no volume chamado db-postgres-clean.
   - O serviço clean-app depende da disponibilidade do serviço database e usa a imagem diegoneves/clean-architecture:latest.
6. Quando precisar parar e remover todos os containers do serviço, use o seguinte comando:
```shell
docker-compose down
```