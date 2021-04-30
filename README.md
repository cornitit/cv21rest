#CV21rest

Requêtes

{{url}} est une variable locale que nous avons définie dans Postman. Elle correspond dans notre cas à : http://localhost:6039

1 - Récupération de l’ensemble des CV

commande GET :  {{url}}/resume

2 - Créer un nouveau CV

commande POST :  {{url}}/insert
BODY XML  (exemple de body utilisé)
<?xml version="1.0" encoding="UTF-8"?>
<p:cv21 xmlns:p="http://univ.fr/cv21" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" >
  <p:identitie>
    <genre>M</genre>
    <nom>cornilleau</nom>
    <prenom>titouan</prenom>
    <tel>0123456789</tel>
    <mel>mail@mail.fr</mel>
  </p:identitie>
  <p:objectif emploi="" stage=""/>
  <p:prof>
    <expe>
      <datedeb>2001-01-01</datedeb>
      <datefin>2001-01-01</datefin>
      <titre>titre3</titre>
    </expe>
  </p:prof>
  <p:competences>
    <diplome niveau="">
      <date>2001-01-01</date>
      <titre>titre</titre>
      <etab>etab</etab>
    </diplome>
    <certif>
      <datedeb>2001-01-01</datedeb>
      <datefin>2001-01-01</datefin>
      <titre>titre</titre>
    </certif>
  </p:competences>
  <p:divers>
    <lv cert="" lang="" nivi="0" nivs=""/>
    <autre comment="" titre=""/>
  </p:divers>
</p:cv21>
 
3 - Affichage de la page d’accueil

commande GET : {{url}}/

4 - Affichage de la page d’aide 

commande GET : {{url}}/help

5 - Affichage d’un cv au format html

commande GET : {{url}}/htmlcv?id=608a9bab39938617a0ab45f7
608a9bab39938617a0ab45f7 est un exemple d’identifiant

Malheureusement cette fonctionnalité ne fonctionne pas.

6 - Affichage d’un cv au format xml

commande GET : {{url}}/cv?id=608a9e1a39938617a0ab45f9

Affichage du cv ayant pour identifiant : 608a9e1a39938617a0ab45f9

7 - Suppression d’un cv 

commande DELETE : {{url}}/delete?id=608b07719b7556072319af97

Dans l’exemple, nous supprimons le cv ayant pour identifiant : 608b07719b7556072319af97

8 - Mise à jour d’un cv

commande PUT :{{url}}/update?id=608b0912f4ca002265830841

Dans l’exemple, nous mettons à jour le cv ayant pour identifiant : 608b0912f4ca002265830841
