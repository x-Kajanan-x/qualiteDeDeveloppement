# Qualité de développement

Le but de ce cours est de faire des tests d'intégration au fur et à mesure que des nouveaux composants sont intégrés dans une apllication 
tout en vérifiant que les tests précédents continuent de passer sans relever d'erreur. 
On appelle cela des tests de non regression.

# TD 1 (première séance)

Etude du framework de test inclus dans les projets Spring boot : https://github.com/charroux/springbootest

Etude du framework de test Mockito: https://github.com/charroux/mockito

# TP 1 (première séance)

## Présentation de l'application

L'application à développer contient : 

- une base de données.
- un service Web

L'application est programmée en Java avec le framework Spring Boot (pour faciliter l'accès à la base de données ainsi 
que le développement du service web).

Le but de l'application est de faire des statistiques sur des voitures.

## Récupération du projet
Si vous n'avez pas utilisé Github depuis un moment, il se peut que le Token qui vous permet d'accéder à Github soit périmé.
Dans ce cas, il faudra en génbérer un autre. La procédure est indiqué ici : https://docs.github.com/en/enterprise-server@3.4/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token
Il faudra alors utiliser ce token à la place de votre mot de passe quand vous ferrez des commandes git.

Démarrer le machine de l'école sous Linux.

Attention ! sur les machines de l'IUT il faut se placer sur /tmp car cela ne fonctionne pas sur les dossiers personnels.
```
git clone https://github.com/charroux/qualiteDeDeveloppement
```
Se placer ensuite dans le dossier du projet:
```
cd qualiteDeDeveloppement
```
## Copie du projet dans un dépôt git qui vous appartient

Durant les TP vous allez travailler en binôme. Créez un dépôt de code public mais vide dans Github (sans Readme, ni gitignore),
puis recopier ce projet dans votre dépôt git en prodédant comme suit :
```
rm -rf .git
git init
git add *
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/[adresse .git de votre projet]
git push -u origin main
```

## Edition du projet

### Avec Intellij
Lancer Intellij et ouvrir tout simplement le projet. 
Cependant, sur les machines de l'IUT, la compilation du projet ne fonctionnera pas. 
Ce n'est pas très génant pour compiler votre projet vous pourrez utiliser la commande: 
```
./gradlew build
```
Cette commande permet aussi de lancer les tests et génère aussi un rapport html: build/reports/tests/test/index.html

### Avec Eclipse 
La version Eclipse de l'IUT n'ayant pas le plugin gradle, il n'est pas recommandé ee l'utiliser.

## Codage des classes de données, accès à la base de données

### Codage d'une classe Voiture

Ajoutez dans le ficher existant Voiture.java (package com.example.demo.data) une classe appelée Voiture. Cette classe doit contenir :
 - une marque
 - un prix
 - un identifiant appelé id de type int (qui va servir de clef primaire à la table Voiture dans la base de doonées)

### Tests unitaires de la classe Voiture
Le dossier src/test/java contient déjà l'ébauche de la classe de test de la voiture. 
Cette classe de test est appelée VoitureTest. Ajoutez à cette classe autant de méthodes que vous jugez utile pour 
tester la classe Voiture. Vérifiez que les méthodes de la classe Voiture retournent les résultats attendus en utilisant la classe Assert du framework Spring dont voici la documentation :

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/Assert.html

Sous Linux :
```
./gradlew build
```
Vérifier le rapport de test: build/reports/tests/test/index.html

### Accès à la base de données
La base de données est HSQLDB. Elle s'exécute "En mémoire" pour ne pas avoir à démarrer un serveur de base de données tant qu'on est en mode développement.
En conséquence, les données sont perdues dès que l'application s'arrête.

Pour permettre d'accéder par programmation à la base de données vous devez simplement créer uns interface dans le même package que la classe Voiture : 

``` Java
package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

public interface VoitureRepository extends CrudRepository<Voiture, Integer> {
}
```

### Tests de l'accès à la base de données
Le dossier src/test/java (package data) contient aussi l'ébauche du programme de test de la base de données (BaseDeDonneesTests.java).
Ajoutez à cette classe autant de méthodes que vous jugez utile pour
tester l'accès à la base de données. Testez que la base de données contient bien les bons éléments en utilsant le framework Mockito dont voici l'aide :

https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html

# TP 2 (deuxième séance) : codage de la classe de service qui intègre la base de données
A suivre...
