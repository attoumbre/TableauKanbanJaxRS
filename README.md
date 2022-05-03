<div align="center" id="top"> 
  <img src="./.github/app.gif" alt="Backend Dashboard" />

  &#xa0;

  <!-- <a href="https://exogen.netlify.app">Demo</a> -->
</div>

<h1 align="center">Backend Dashboard</h1>

<p align="center">
  <img alt="Github top language" src="https://img.shields.io/github/languages/top/attoumbre/TableauKanbanJaxRS?color=56BEB8">

  <img alt="Github language count" src="https://img.shields.io/github/languages/count/attoumbre/TableauKanbanJaxRS?color=56BEB8">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/attoumbre/TableauKanbanJaxRS?color=56BEB8">

  <img alt="License" src="https://img.shields.io/github/license/attoumbre/TableauKanbanJaxRS?color=56BEB8">

  <!-- <img alt="Github issues" src="https://img.shields.io/github/issues/{{YOUR_GITHUB_USERNAME}}/exogen?color=56BEB8" /> -->

  <!-- <img alt="Github forks" src="https://img.shields.io/github/forks/{{YOUR_GITHUB_USERNAME}}/exogen?color=56BEB8" /> -->

  <!-- <img alt="Github stars" src="https://img.shields.io/github/stars/{{YOUR_GITHUB_USERNAME}}/exogen?color=56BEB8" /> -->
</p>

<!-- Status -->

<!-- <h4 align="center"> 
	🚧  Exogen 🚀 Under construction...  🚧
</h4> 

<hr> -->

<p align="center">
  <a href="#dart-about">About</a> &#xa0; | &#xa0; 
  <a href="#sparkles-features">Features</a> &#xa0; | &#xa0;
  <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-starting">Starting</a> &#xa0; | &#xa0;
  <a href="#memo-license">License</a> &#xa0; | &#xa0;
  <a href="https://github.com/attoumbre" target="_blank">Author</a>
</p>

<br>

## About ##
Création d'une api rest de gestion de tableau kanban

## Technologies ##

Les outils suivants ont été utilisés dans le cadre de ce projet:

- La **base de données** utilisée est **MySQL**.

- [Java](https://www.oracle.com/fr/java/)
- [JaxRs](https://www.oracle.com/technical-resources/articles/java/jax-rs.html)
- [JPA](https://www.oracle.com/technical-resources/articles/java/jpa.html)


## Pré-requis ##

- Version du jdk : Ce projet a été testé avec la version **17 du JDK (Java JDK 17)**. Certains réglages mineurs
  pourraient s'avérés nécessaires pour la compatibilité avec des versions antérieures du JDK.

## Versions

**Dernière version stable :** Sur la branche **Master**

## Démarrage

- Pour lancer le serveur :
  Exécuter le fichier **RestServer** se trouvant à la racine du package _**java**_ du projet.
  The server est initialisé sur <http://localhost:8080>

## Test

* Le projet peut être testé, en local, via **Swagger** (Cliquer **[ICI](http://localhost:8080/api/)** après avoir lancé
  le server en local).

## Postman
Ajout d'un utilisateur: (URL) http://localhost:8080/user/signup

```
Body
{
    "nom" : "juvenal",
    "email" : "aaa@fr"
}
```
Ajout d'une fiche sur une section d'un utilisateur : (URL) http://localhost:8080/fiches/create

```
Body
{
"description": "gestion logOut", 
"section": {
    "id" : "3"
    }, 
"user": {
    "id" :"1" 
    }, 
"date": "06-05-2022T00:00:00", 
"temps": "10"
}
```

... Veuillez vous référer au swagger pour avoir le format Json des différent endpoints.

## Licence ##
Ce projet est sous licence MIT. Pour plus de détails, voir le fichier [LICENSE](LICENSE.md).

## Auteurs ##
Fais avec :heart: par <a href="https://github.com/attoumbre" target="_blank">Juvenal ATTOUMBRE && Nadège Yeo</a>

&#xa0;

<a href="#top">Back to top</a>
