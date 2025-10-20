🚗 Sistema de Gestão de Veículos — README

Projeto Java (Spring Boot) para cadastro de veículos, proprietários e autuações, com status do veículo controlado por StatusVeiculo.

✨ Visão geral

Este serviço expõe uma API REST para:

Cadastrar e consultar Veículo (com marca, modelo, placa, datas e status).

Vincular Proprietário a um Veículo (1:1).

Registrar Autuações de um Veículo (0..*), com valor e data de ocorrência.

A modelagem segue a imagem do diagrama de classes (UML). Sugestão: salve o arquivo do diagrama em docs/diagrama-classes.jpg e referencie no projeto.

🧠 Modelo de domínio

Entidades e atributos principais

Veiculo

marca:String

modelo:String

placa:String (única)

dataCadastro:LocalDateTime

dataApreensao:LocalDateTime (opcional; usado quando status = APREENDIDO)

status:StatusVeiculo (enum: REGULAR, APREENDIDO)

Relacionamentos:

proprietario: Proprietario (1:1 obrigatório)

autuacoes: List<Autuacao> (0..)*

Proprietario

nome:String

email:String

telefone:String

Autuacao

descricao:String

valorMulta:BigDecimal

dataOcorrencia:LocalDateTime

vinculada a: veiculo (muitos-para-um obrigatório)

StatusVeiculo (enum)

REGULAR, APREENDIDO
