# SQL Datasource Backend

A Java based Grafana Datasource Backend.

## Why Java?

To take advantage of JDBC.  Golang supports ODBC, but it has dependencies that are painful to manage/support as a plugin.  Namely, it requires CGO and an ODBC Manager.  Those who don't know ODBC run into issues with setup.  

Some JDBC drivers are free to distrubute/embed, while ODBC drivers don't exhist or are not free.

Also, most of the code here is generated.  Java has some libs to generate code from protobuf, and convert a JDBC response to Arrow (Dataframe) in one line of code.

But wait, don't we need a JRE to run the java app?  No, we can use GraalVM to create native executables.

## Running in VS Code

### Install VSCode Extensions

* Extension Pack for Java
* Spring Initializr Java Support

### Build the Java Backend

After installing the extensions you will see a MAVEN option appear on the left nav accordion.

### Install

```
brew install maven
```

```
brew install openjdk
```

#### Build 

MAVEN > sql-datasource > Lifecycle > install

The jar will be built under the `target` folder.

This jar can be copied to the pkg folder of the sql-datasource.

#### Debug locally ( testing )
Use the vscode launch config:  `Spring Boot-App<sql-datasource>`

#### Run locally ( testing ) using MAVEN extension

MAVEN > sql-datasource > Plugins > spring-boot > run

You can use Postman etc to test the grpc calls.

Example: [Postman](https://sql-datasource.postman.co/workspace/sql-datasource~3828ec51-8c66-4349-9973-a15ffe8ec9b7/collection/6744d3e91b8ea0b69345acb2?action=share&creator=24818991)

You can also call/test this directly from the sql-datasource plugin.