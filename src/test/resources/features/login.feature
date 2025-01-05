#language:pt

Funcionalidade: Login

  Contexto:
    Dado que a modal esteja sendo exibida

  @fecharModal
  Cenário: Fechar a modal ao clicar fora da mesma
    Quando for realizado um clique fora da modal
    Então a janela modal deve ser fechada

  @fecharModalIcone
  Cenário: Fechar a modal ao clicar no icone fechar
    Quando for realizado em clique no icone de fechar a modal
    Então a janela modal deve ser fechada

  @createNewAccount
  Cenário: Link Create New Account
    Quando for realizado um clique no link create new account
    Então a pagina create new account deve ser exibida

  Esquema do Cenario: Realizar login <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Então deve ser possivel logar no sistema

    Exemplos:
      | identificacao       | login   | password | remember |
      | campos obrigatorios | chronos | senha    | false    |
      | todos os campos     | chronos | senha    | true     |


  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Então o sistema devera exibir uma mensagem de erro

    Exemplos:
      | identificacao    | login    | password | remember |
      | usuario invalido | invalido | senha    | false    |
      | senha invalida   | chrome   | invalida | false    |

  @dadosEmBranco
  Esquema do Cenario: Realizar o login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | login    | <login>    |
      | password | <password> |
      | remember | <remember> |
    Então o botao sign in deve permanecer desabilitado

    Exemplos:
      | identificacao     | login   | password | remember |
      | usuario em branco |         | senha    | false    |
      | senha em branco   | chronos |          | false    |
