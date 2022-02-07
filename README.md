# ApiCalculaFrete

<h3 align="center">Objetivo</h3>
Api com o objetivo de fazer o processamento do calculo e previsão dos fretes da empresa SigaBem.

<h3 align="center">Detalhamento</h3>
A api contém um endPoint, onde é necessário passa no body da requisição as informações necessárias para processamento.
Após processamento, é retornado um objeto com todos os campos detalhados referente ao frete solicitado.
O consumo da mesma esta liberado para todos os tipos de CORS.

<h3 align="center">Requisitos</h3>
Entrada de dados precisa conter:
  -nomeDestinatario: String
  -cepOrigem: String
  -cepDestino: String
  -peso: double
  
Retorno de dados contém:
  -nomeDestinatario: String
  -cepOrigem: String
  -cepDestino: String
  -peso: double
  -vlTotalFrete: BigDecimal
  -dataPrevistaEntrega: LocalDate
  -dataConsulta: LocalDate
  
  <h3 align="center">Criador</h3>
  Daniel Moreira - danieljt84@gmail.com
  
  <h3 align="center">Status do projeto</h3>
  <h4 align="center"> 
	 🚀 Concluído
</h4>

