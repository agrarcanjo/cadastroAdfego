
<h1 align="center">
    Cadastro de pessoas
</h1>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Projeto</a>
</p>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=PRs&message=welcome&color=15C3D6&labelColor=000000" alt="PRs welcome!" />

  <img alt="License" src="https://img.shields.io/static/v1?label=license&message=MIT&color=15C3D6&labelColor=000000">
</p>

<br>

## 💻  Tecnologias

Para executar esse projeto, será necessário as tecnologias: 

- [Java](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [Maven](https://maven.apache.org/download.cgi)
- [Postman](https://www.postman.com/downloads/)
- [MySql](https://www.mysql.com/downloads/)

## 💻 Projeto

Configurar o MySql com o usuário root e senha vazia como o padrão

Inserir valores iniciais conforme: [Adfego.sql](cadastro/src/main/java/br/org/adfego/cadastro/database/adfego.sql)


Para gerar o executável da aplicação, após instalar e configurar o java e o maven, junto com suas
variáveis ambiente, executar o comando no diretório da aplicação:



```bash
> mvn  clean package spring-boot:repackage
```

No diretório target:

```bash
> java -jar cadastro-0.0.1-SNAPSHOT.jar
```

Para realizar as requisições segue o arquivo postman: [Requisições](Cadastro.postman_collection.json)

 ## Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE.md) para mais detalhes.

---

by agrarcanjo 