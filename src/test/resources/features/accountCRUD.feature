#language:pt
@CRUD
Funcionalidade: Account CRUD

  @cadastroConta
  Cenario: Cadastro nova conta
    Dado que a pagina new account esteja sendo exibida
    Quando os campos de cadastros estiverem preenchidos com
      | username | chronosTeste2              |
      | email    | chronosteste2@email.com.br |
      | password | Senha123                   |
      | country  | Brazil                     |
    Entao deve ser possivel logar no sistema apos o cadastro

  @loginCRUD
  Cenario: Realizar login crud
    Dado que a modal esteja sendo exibida
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | chronosTeste2 |
      | password | Senha123      |
      | remember | false         |
    Quando for realizado o clique no botao sign in
    Então deve ser possivel logar no sistema

  @alterarCRUD
  Cenario: Realizar alteracao conta
    Dado que esteja logado no sisttema com
      | login    | chronosTeste2 |
      | password | Senha123      |
      | remember | false         |
    Dado que esteja na pagina de alteracao de conta
    Quando altero os valores dos seguintes campos
      | firstName | ChronosT1 |
      | lastName  | Teste     |
    Quando for realizado o clique am salvar
    Entao a alteeracao foi exibida na pagina myAccount

  @exclusaoCRUD
  Cenario: Deletar usuario
    Dado que esteja logado no sisttema com
      | login    | chronosTeste2 |
      | password | Senha123      |
      | remember | false         |
    Dado que esteja na pagina myAccount
    Quando for efetuado a acao do clique em delete e em yes
    Entao o usuario deve ser deletado



