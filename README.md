# ist_es_spring

Copia do repo de spirng e thymeleaf da aula laboratorial de ES

Testar usando o comando: 

`mvn clean spring-boot:run`

E depois, num browser, usar:

`http://localhost:8080/banks`


## Tarefas

- ~Alterar a vista bank.html de forma a que os clientes sejam apresentados numa tabela. Note que o controlador adiciona dois cliente para facilitar o desenvolvimento~

- ~Defina uma nova classe controlador que resolve os caminhos com prefixo /banks/bank/{code}/clients~

- ~Defina também os métodos que necessita no controlador, um GET e um POST para /banks/bank/{code}/clients, para criar um formulário de cliente e submeter um formulário de cliente, respetivamente~

- ~Adicionar à vista bank.html um formulário de criação de clientes~

- Criar um novo método no controlador de cliente para o caminho /banks/bank/{code}/clients/client/{id} que procura no banco com o código indicado o utilizador com o identificador id, e apresenta uma vista com toda a informação sobre esse cliente

- Alterar a vista bank.html para incluir os links para se aceder às vistas de cliente definidas no passo anterior

- Colocar uma validação na classe cliente que impede a existência de dois clientes com o mesmo id. Altere a interface, vista e controlador, de forma a que uma mensagem de erro seja apresentada ao utilizador
