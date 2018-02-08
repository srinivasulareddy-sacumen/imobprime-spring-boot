
# iMobPrime - Backend implemented with Spring Boot

## Introduction

This is a `Java Maven` project that has backend features and the REST API for the iMobPrime application.

The backend was implemented with `Spring Boot`, the web server running is `Tomcat` and database runs on `MySQL`.

This project has all REST endpoints required for the frontend project [imobprime-react](https://github.com/jorgealmeidajr/imobprime-react) to run.

## Database

The image below represents the physical modeling for the iMobPrime database implemented in MySQL. 

For the purpose of learning and testing, some tables in the modeling image(they are in red) have JSON columns, this is a feature more recent for MySQL. JSON columns has been supported by MySQL since version 5.7.8 and it is not supported by previous versions.

![imobprime-db](https://user-images.githubusercontent.com/6424524/35780891-977ce99a-09c9-11e8-84a5-88e289785e34.png)

This project provides one zip file containing the dump for a test database. 

The most updated test database is located in **db/mysql/Dump20180202-imobprime.zip**.

## Features to implement

- Authentication(this feature afeccts the frontend project)

- Authorization

- For authentication and authorization it is necessary to use the table **users**. There is nothing implemented for those features.

- Internacionalization(this feature affects the frontend project)

- Most of the features to implement are mentioned in the frontend project.
