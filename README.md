# Projeto-Automato-Deterministico

Implementação de automato deterministico

Projeto criado na Ide eclipse, para executar basta apenas F5.
Na classe main é chamado o metodo DefineAutomato, que tem como parametros: alfabeto e palavra
Este método ja esta com os parametros ("ab", "aababb")

A implementação é feita usando uma matriz para armazenar as transições
Assim que rodar o projeto vai ser pedido a quantidade de transições (necessario informar apenas a quantidade de linhas)
Logo em seguida irá pedir a primeira regra da primeira transicao e a segunda regra da primeira transicao, e assim por diante.

Por exemplo: "Estado inicial q0 esta na iminencia de ler um 'a' e ir para o estado q1", então informa-se: q0,a,q1
             "Estado inicial q0 esta na iminencia de ler um 'b' e permanece no mesmo estado", então informa-se: q0,b,q0
             Entao é criado a transição 1 e transição 2 e formar uma matriz
             
             Se o estado for um estao final, isto é, uma transição para um estado final, ou ate mesmo a permanencia em
             um estado que seja final deve-se informar.
             Exemplo: q0,a,q1,final ou q0,b,q0,final
             
             Exemplo: [q0,a,q1][q0,b,q0]
                      [transicao1][transicao2]
                      [transicao1][transicao2]
                      
             Apos inserido todas as transições é retornado se a palavra é aceita ou não.
Para alterar o alfabeto e a palavra, é necessario apenas alterar os parametros do método chamado no main.
