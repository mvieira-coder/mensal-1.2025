# Totem de Locação — Esqueleto Compartilhado (MySQL)
Contrato único do time — **não mudar nomes/assinaturas**.

## Como rodar
1) MySQL Workbench → criar schema:
   CREATE DATABASE IF NOT EXISTS totemlocadora;
2) Editar src/main/resources/application.properties com sua senha.
3) IntelliJ → rodar TotemLocadoraApplication.
4) Importar a coleção Postman em /postman.

## Ordem de PRs
Infra → Domínio/Repos → Services → Controllers.
