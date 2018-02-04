
# iMobPrime - Backend implemented with Spring Boot

## Introduction

This is a `Java Maven` project that has backend functions for the iMobPrime application.
The backend was implemented with Spring Boot, the web server is Tomcat and runs on MySQL database.

Esse projeto contem todos os endpoints rest necessarios para o projeto frontend [imobprime-react](https://github.com/jorgealmeidajr/imobprime-react) funcionar.

## Database

The image below represents the physical modeling for the iMobPrime database implemented in MySQL. Para fins de aprendizado e testes, algumas tabelas(em vermelho) possuem colunas JSON um recurso mais atual do MySQL nao suportado em versoes muito antigas.

![imobprime-db](https://user-images.githubusercontent.com/6424524/35780891-977ce99a-09c9-11e8-84a5-88e289785e34.png)

O projeto disponibiliza um arquivo contendo um Dump para um banco de dados de teste.
O banco de teste mais atualizado esta localizado em **db/mysql/Dump20180202-imobprime.zip**.

## Features to implement

	- Authentication(afeta o frontend)
	- Authorization
	- Internacionalization(afeta o frontend)
