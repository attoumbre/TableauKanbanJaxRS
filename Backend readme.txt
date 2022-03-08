*****
* ARCHITECTURE
*****
Les différents packages sont:
    - les dao		fr.istic.taa.jaxrs.dao.generic
    - les domaines	fr.istic.taa.jaxrs.domain
    - les ressources	fr.istic.taa.jaxrs.rest
    - les dto 		fr.istic.taa.jaxrs.dto
    - le serveur 	fr.istic.taa.jaxrs	RestServer.java

*****
* BASE DE DONNÉE 
*****
Nous avons travailler sous mysql. avant de démarrer le serveur il est primordial
 de créer la base de donnée appeler "kanban" dans le SGBD phpmyadmin.

*****
* DEPLOIEMENT
*****

Sous Eclipse, le projet peut être importé
en utilisant la fonction "Importer -> Projet Maven existant" et en choisissant
le répertoire jaxr-example qui contient le fichier "pom.xml" .Vous pouvez
démarrer le serveur en exécutant le fichier "RestServer.java".

*****
* API
*****
Dans postman, faire pour toutes requêtes:
Accept			: application/json
Content-TypeContent-Type: application/json

http://localhost:8080 doit précéder les URI suivants:

URI                     | commande   | description
--------------------------------------------------------------------
/user                   | POST       | enregistre un utilisateur
/user/{user}            | GET        | retourne la description de l'utilisateur {user}
/user/{user}            | DELETE     | supprime l'utilisateur {user}
/users/all              | GET        | retourne la liste des utilisateurs
/user                   | PUT        | modifie l'utilisateur
/users/login            | POST       | permet à l'utlisateur de se connecter
/tags                   | POST       | enregistre un tag
/tags/{f}               | GET        | retourne la description d'un tag {f}
/tags/{f}               | DELETE     | supprime un tag {f}
/tags/all               | GET        | retourne la liste des tags
/tags                   | PUT        | modifie un tag
/tableau                | POST       | enregistre un tableau
/tableau/{f}            | GET        | retourne la description d'un tableau {f}
/tableau/{f}            | DELETE     | supprime un tableau {f}
/tableau/all            | GET        | retourne la liste des tableau
/tableau                | PUT        | modifie un tableau
/sections               | POST       | enregistre une section
/sections/{s}           | GET        | retourne la description d'une sections {s}
/sections/{s}           | DELETE     | supprime une sections {s}
/sections/all           | GET        | retourne la liste des sections
/sections               | PUT        | modifie une section
/fiches                 | POST       | enregistre une fiche
/fiches/{f}             | GET        | retourne la description d'une fiche {f}
/fiches/{f}             | DELETE     | supprime une fiche {f}
/fiches/all             | GET        | retourne la liste des fiches
/fiches                 | PUT        | modifie une fiche
/fichegit               | POST       | enregistre une fiche git
/fichegit/{f}           | GET        | retourne la description d'une fiche git {f}
/fichegit/{f}           | DELETE     | supprime une fiche git {f}
/fichegit/all           | GET        | retourne la liste des fiches git
/fichegit               | PUT        | modifie une fiche git
/fichebug               | POST       | enregistre une fiche bug
/fichebug/{f}           | GET        | retourne la description d'une fiche bug {f}
/fichebug/{f}           | DELETE     | supprime une fiche bug {f}
/fichebug/all           | GET        | retourne la liste des fiches bug
/fichebug               | PUT        | modifie une fiche bug


*****
* QUELQUES SCENARIOS
*****

*ajout d'un utilisateur 
 
POST
http://localhost:8080/user
{
    "mail" : "aaa@fr",
    "nom" : "drogba",
    "prenom" : "didier"
}

*ajout d'une fiche
POST
http://localhost:8080/fiches

{
    "date" : "2022-01-01",
     "lieu" : "rennes",
     "section": {
          "id": 5
           },
      "user": {
          "id": 8
           }
}


*ajout d'une fiche Git
POST
http://localhost:8080/fichegit

{
    "date" : "2019-09-27",
     "lieu" : "rennes",
     "lib": "paire",
     "section": {
          "id": 6
           },
      "user": {
          "id": 2
           }
}



*affichage d'un tableau
GET
http://localhost:8080/tableau/15



*affichage de toutes les sections
GET
http://localhost:8080/sections/all



*suppression d'une fiche
DELETE
http://localhost:8080/fiches/12



*suppression d'une utilisateur
DELETE
http://localhost:8080/user/1



*modification d'un utilisateur
PUT
http://localhost:8080/user
{  "id" : 1,
    "prenom" : "fabrice"}



*modification d'une fiche
PUT
http://localhost:8080/fiches
{  "id" : 4,
    "section": {
          "id": 3
           }
}



*affichage d'un utilisateur
GET
http://localhost:8080/user/2