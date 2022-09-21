# Ambiente e ferramentas
1. Os projetos devem ser desenvolvidos em JAVA, Spring Boot, JPA/Hibernate e
TDD com JUnit, de preferência se utilizando o Eclipse STS.
2. Os projetos devem ter builds construídos com MAVEN, e seus fontes
hospedados em repositórios no GIT Hub.
3. Os projetos devem acessar banco de dados MySQL para armazenar seus dados
em ambiente de produção.
4. Os projetos devem usar banco de dados H2 em tempo de desenvolvimento
para que seja viável a implementação de TDD.
Requisitos, testes e critérios de pontuação
1. Os projetos devem ser implementados em duplas. Cada dupla pega um projeto
diferente, já escolhido por sorteio (ver tabela de nome x projeto).
2. Há 5 projetos e 10 duplas, portanto, haverá mais de uma dupla com o mesmo
projeto. Embora isso seja permitido, e as duplas possam se ajudar, a entrega
deve ser feita POR DUPLA. Se a dupla X pegou o projeto A e a dupla Y pegou o
projeto A, a dupla X realiza uma entrega e a dupla Y OUTRA entrega DIFERENTE
da dupla X.
3. Os requisitos a serem implementados estão nos arquivos que especificam as
regras de negócio e as funcionalidades de cada projeto.
4. A avaliação para pontuação será feita por item, tendo como fração mínima de
pontuação 0.5. Um item, para pontuar, deve estar FUNCIONANDO
CORRETAMENTE, e deve estar COMPLETO. Itens implementados pela metade
ou sem funcionar NÃO PONTUAM.
5. Os critérios de pontuação são os seguintes:
a. O projeto vale DE ZERO A SEIS PONTOS.
b. As partes de TDD e de regras de negócios valem até 3 pontos. Os
projetos têm a mesma quantidade de TDD ́s previstos para serem
entregues (ver tabela TDD com os casos previstos), portanto, cada linha
de TDDs entregue corresponde a um ITEM DE PONTUAÇÃO.
c. A parte de persistência vale até 1,5 pontos, tendo os seguintes ITENS:
i. 0.5 para as operações do CRUD (0.1 para cada funcionalidade)
ii. 0.5 para a inclusão do cadastro funcional.
iii. 0.5 para a busca do cadastro funcional.
d. A API RESTFul funcional vale até 1,5 pontos, tendo os seguintes ITENS:
i. 0.5 para o CRUD (0.1 para cada funcionalidade).
ii. 0.5 para inclusão do cadastro funcional.
iii. 0.5 para busca do cadastro funcional.

## Tabela TDD
| ITEM DO PROJETO | CASOS DE TESES                      | QUANTIDADE |
| --------------- | ----------------------------------- | ---------- |
| 1.1.1           | Obrigatoriedade                     | 02         |
| 1.1.2           | Obrigatoriedade, por nulo ou branco | 03         |
| 1.1.3           | Obrigatoriedade e domínio           | 03         |
| 1.1.4           | Obrigatoriedade e domínio           | 04 ou 06   |
| Data            | Obrigatoriedade e domínio           | 03         |
| CPF ou CNPJ     | Domínio e validação de DV           | 04         |

# Projeto 5 – Competidor e aposta

1. CRUD de Competidor – incluir, alterar, excluir, buscar por código e buscar
todos
1.1 Atributos de competidor:
1. Matrícula, inteiro, obrigatório
2. Nome, alfa de até 60 caracteres, obrigatório (diferente de nulo e de branco)
3. Índice de performance, número decimal, obrigatório
4. Referência padrão, número decimal, obrigatório
1.2 Validações:
1. Índice de performance, tem que ser maior que zero e menor que 1.
2. Referência padrão, tem que ser maior do que zero.
2. Inclusão de aposta
Uma aposta possui um ou mais bilhetes.
1.3 Atributos e requisitos da aposta:
1. CNPJ do negociador, alfa de 14 caracteres, tem que ser um CNPJ válido (só
composto por dígitos decimais, algoritmo de cálculo de dígito verificador válido).
2. Data da aposta, obrigatória, não pode menor do que a data atual.
3. Número da aposta, inteiro longo, único, gerado automaticamente pelo sistema.
1.4 Atributos e requisitos de um bilhete:
1. Competidor (na requisição REST vem a matrícula do competidor), tem que ser um
existente no cadastro de competidores.
2. Valor base, número decimal, obrigatório, maior que zero.
3. Comissão, número decimal, calculado. A comissão é igual ao valor base vezes 0.04
vezes (1 – índice de performance).
4. Valor pago, número decimal, calculado. É igual ao valor base vezes a referência
padrão dividido pelo índice de performance.
3. Busca de aposta
Atributos e retorno:
• Número da aposta, inteiro longo, obrigatório.
• Se a aposta for encontrada, retornar a mesma e seus bilhetes. Caso contrário,
retornar sinalização de busca não encontrada conforme padrão RESTFul.

