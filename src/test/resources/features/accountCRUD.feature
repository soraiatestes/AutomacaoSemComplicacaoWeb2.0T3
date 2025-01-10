#language:pt
Funcionalidade: Account CRUD

  @cadastroConta
  Cenario: Cadastro nova conta
    Dado que a pagina new account esteja sendo exibida
    Quando os campos de cadastros estiverem preenchidos com
      | username | chronosTeste1              |
      | email    | chronosteste1@email.com.br |
      | password | Senha123                   |
      | country  | Brazil                     |
    Entao deve ser possivel logar no sistema apos o cadastro

  @loginCRUD
  Cenario: Realizar login crud
    Dado que a modal esteja sendo exibida
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | chronosTeste1 |
      | password | Senha123      |
      | remember | false         |
    Quando for realizado o clique no botao sign in
    Então deve ser possivel logar no sistema

  @alterarCRUD
  Cenario: Realizar alteracao conta
    Dado que esteja logado no sisttema com
      | login    | chronosTeste1 |
      | password | Senha123      |
      | remember | false         |


