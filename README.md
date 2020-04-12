# GameOfLifeKata

## Description

Le jeu de la vie est un automate cellulaire créé par John Horton Conway.
Un automate cellulaire est un ensemble de cellules représenté par une grille (2D) qui peut évoluer au cours du temps en fonction de règles basiques.
Par défaut le jeu de la vie selon Conway suit les règles suivantes :
  - Les voisines d'une cellule sont les 8 cellules autour de celle-ci
  - Une cellule morte possédant exactement trois voisines vivantes devient vivante.
  - Une cellule vivante possédant deux ou trois voisines vivantes reste vivante, sinon elle meurt.

L'objectif de ce kata est d'implémenter les classes permettant de créer un jeu de la vie fonctionnel sur vos machines.

## Setup
  - Forker le projet
  - Importer le projet forké dans IntelliJ Idea : File > New > Project from Version Control > Git > Rentrer l'url du dépôt
  - Clic droit sur le dossier java > Mark Directory as Root Source
  - File > Project Structure > renseigner votre jdk et votre fichier de sortie <VOTRE_WORKING_DIR/out>
  - Run > Edit Configuration > ajouter une Application > Renseigner votre jdk si ce n'est pas déjà fait
  - Pour ajouter JUnit, la façon la plus simple est la suivante : allez dans le fichier java > test > RollTest > alt-Enter sur un @Test rouge > add JUnit to classpath
  - Pour runner votre classe Main depuis le terminal (Mac/Linux) : compiler puis entrer dans votre onglet terminal > ``java -classpath out/production/GameOfLifeKata java/Main.java``
  - A la fin de votre développement, poussez votre pull request sur le dépôt, mettez votre nom et prénom dans le nom de la branche
