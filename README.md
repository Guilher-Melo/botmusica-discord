<h1 align = "center">Bot de música</h1>

<p align = "center">Bot de música do Discord feito em Java</p>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-como-executar-o-projeto">Como executar</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-licença">Licença</a>
</p>

<p align="center">
  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=49AA26&labelColor=000000">
</p>

<br>


## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Java
- JDA
- Gradle
- lavaplayer

## 💻 Projeto

É possível utilizar apenas músicas do Youtube nesse bot. Pode ser colocando a url do vídeo desejado, ou apenas digitando o nome, o bot irá tocar o primeiro resultado da pesquisa no Youtube. Ainda, é possível ver a música que está tocando no momento, adicionar várias músicas na fila e verificar quais são essas músicas, pular uma música e parar de tocar.

## 👨‍💻 Como executar o projeto

É necessário ter <br/>
   - Java 17 ou superior<br/>
   - Gradle

Construa o projeto usando o Gradle
```java

./gradlew shadowJar
```
Execute o JAR gerado

```java
java -jar build/libs/botdependecies.jar
```

## :memo: Licença

Esse projeto está sob a licença MIT.

---
