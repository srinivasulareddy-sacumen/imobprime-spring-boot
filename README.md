
# iMobPrime - Backend for a Real Estate Management App

This is a `Java Maven` project that has backend features and the REST API for the iMobPrime, an application for Real Estate Management. 

This project was developed with **Java v1.8** features.

The backend was implemented with `Spring Boot`, the web server running is `Tomcat` and database runs on `MySQL`.

This project has all REST endpoints required for the frontend project [imobprime-react](https://github.com/jorgealmeidajr/imobprime-react) to run.


## Table of Contents

- [Introduction](#introduction)
- [Basic Usage](#basic-usage)
- [What was learned or used in this project](#what-was-learned-or-used-in-this-project)
- [Folder Structure](#folder-structure)
- [Features](#features)
- [Missing Features to implement](#missing-features-to-implement)


## Introduction

This project was created to be a proof of concept for a prototype application. The purpose of this application is to manage real estates.

This project was created to be used by `Real Estate Agents or Brokers` that have to manage many properties for their clients. Those `Real Estate Agents or Brokers` are associated and work with a `Real Estates Agency`. The last mentioned relationship is optional.

For this application there are `Clients` and their data are managed by `Real Estate Agents or Brokers`. There are potential clients and clients who own properties managed by an agent. Those properties are available to sell or rent, and there are clients interested in a `Property` to buy or rent.

This project is focusing in the `Real Estate Agents or Brokers` necessities, they are going to be the main actor for this project. This application will provide an easy and fast way for clients interested in searching properties available for sale or rent.

The image below represents the UML diagram of classes in the analysis phase:

<img 
	src="doc/UML class diagram v01.png" 
	alt="Markdown Monster icon" 
	style="display: block; margin-left: auto; margin-right: auto; width: 95%;" 
/>


## Basic Usage

This project requires the database to be running. The database used for this project is **MySQL v5.7**.

For the purpose of learning and testing, some tables have JSON columns, this is a feature more recent for MySQL. JSON columns has been supported by MySQL since version 5.7.8 and it is not supported by previous versions.

This project provides one zip file containing the dump for a test database.

The most updated test database is located in **db/mysql/Dump20180202-imobprime.zip**.

You can start the server running the class **org.imobprime.IMobPrimeApplication** with the main method.


## What was learned or used in this project

- Java v1.8 features.
- Spring Boot v1.5 features.
- REST implementation with Spring.
- Database calls with JdbcTemplate from Spring and JPA.
- Entities with JPA annotations. 
- Java v1.8 with Maven.
- Usage of JSON columns in MySQL v5.7.


## Folder Structure

The folder structure of the project looks like this:

```
imobprime-spring-boot/
  db/   -> dump files to create the database
  doc/  -> files used for documentation
  src/
    main/java/
	  org/imobprime/controller   -> classes with REST endpoints
	  org/imobprime/dao          -> classes for database access with JPA
	  org/imobprime/model        -> JPA entities
	  org/imobprime/repository
	  org/imobprime/service
	  IMobPrimeApplication.java  -> class with the main method
```


## Features

- API REST endpoints in **org.imobprime.controller** package.


## Missing Features to implement

- Authentication (this feature affects the frontend project).
- Authorization with `'admin'` and `'corretor'` profiles.
- For authentication and authorization it is necessary to use the table **users**. There is nothing implemented for those features.
- Internationalization / i18n (this feature affects the frontend project).
- Some features to implement are mentioned in the frontend project.
