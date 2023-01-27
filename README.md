# Teste-semob

Projeto realizado como um teste para a semob

# Especificações

Projeto realizado com:

- Backend - Java versão 8, Spring-Boot versão 2.6.0, Maven
- Frontend - Angular 1
- Banco de Dados - PostgreSQL versão 9.6

- Dockerfile e Docker-Compose

# Execução

- Para inicializar o projeto, é necessário ter o docker instalado na máquina.
- Realizar o clone do projeto, após escolher a pasta de destino, abrir ela no cmd ou prompt.
- Clone: git clone https://github.com/bvalmeida/teste-semob.git
- Entrando no diretório raiz do projeto, onde se encontra o arquivo docker-compose, abrir o cmd ou prompt.
- Executar o comando: docker-compose build
- Para assim o projeto todo ser buildado, após finalização deste processo
- Executar o comando: docker-compose up, se não quiser ver os logs, utilizar: docker-compose up -d
- Realizando esses passos, a aplicação completa já estará online e podendo ser acessada.
- No navegador de internet: localhost:4200 e a aplicação irá abrir

- Se necessário conferir documentação ou realizar alguma solicitação para o backend, o projeto possui
o Swagger, podendo assim ser acessado através de: localhost:8080/swagger-ui.html
- Onde será mostrado todos os endpoints, possíveis requisições, responses e requests necessários

- Para acessar o backend de alguma IDE, instalar o jdk-8 
apartir de: https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html
configurando o JAVA_HOME nas variáveis de ambiente, apontando para onde foi instalado

- Para acessar o frontend de alguma IDE, basta na pasta raiz do front, abrir pelo cmd ou prompt
e instalar o angular apartir de: npm install, npm instal angular, npm install http-server
assim será instalado o angular e também o http-server para subir a aplicação frontend, por padrão o http-server
sobe em uma porta 8080, se ela estiver em uso ele irá subir na próxima livre, 8081.
- Se precisar subir em uma porta específica, basta utilizar: http-server -p 4200, por exemplo, ou substituir por
qualquer porta necessária.
