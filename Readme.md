##Projet de Gestion de Bibliothèque
Description
Ce projet est une application Java développée sur l'IDE Eclipse, utilisant une base de données MySQL pour la gestion des données. L'application permet de gérer les différentes opérations d'une bibliothèque, telles que l'ajout, la suppression, la modification et la consultation des livres, commandes de fournisseurs, etc.

Versions
IDE : Eclipse Version 2024-06 (4.32.0)
Java : Java version "22.0.1" (2024-04-16)
Structure du Projet
Le projet est organisé en trois packages principaux :

1. Package connection
Ce package contient la classe SingletonConnectionBDD, qui est responsable de la gestion de la connexion à la base de données. Cette classe utilise le pattern Singleton pour s'assurer qu'une seule connexion est ouverte et partagée tout au long de l'application, évitant ainsi les problèmes liés à la gestion multiple des connexions.

2. Package model
Le package model contient trois classes principales qui représentent les tables de la base de données :

Commande : Représente la table des commandes passées par la bibliothèque. Cette classe contient les méthodes nécessaires pour gérer toutes les opérations liées à cette table, telles que l'ajout, la suppression et la mise à jour des commandes.

Fournisseur : Représente la table des fournisseurs. Cette classe permet de gérer les informations relatives aux fournisseurs de la bibliothèque.

Livre : Représente la table des livres de la bibliothèque. Elle contient les méthodes pour gérer les livres (ajout, suppression, mise à jour, etc.).

3. Package main
Ce package contient les classes principales pour l'exécution de l'application :

Main : Cette classe contient un jeu de menus permettant à l'utilisateur de choisir les actions à effectuer, telles que l'ajout d'un nouveau livre, la consultation des commandes, la gestion des fournisseurs, etc.

Application : La classe qui sert de point d'entrée pour exécuter l'application. Elle initialise les composants nécessaires et lance le menu principal pour l'interaction utilisateur.

Fonctionnalités
Gestion des Livres : Ajouter, modifier, supprimer et consulter les livres disponibles dans la bibliothèque.
Gestion des Commandes : Suivre et gérer les commandes passées par la bibliothèque.
Gestion des Fournisseurs : Gérer les informations relatives aux fournisseurs de livres et autres produits.
Configuration et Installation
Prérequis
Java JDK 22.0.1 ou supérieur
Eclipse IDE (Version 2024-06 ou plus récente)
MySQL (version 5.x ou supérieure)
Cloner le projet
bash
Copier le code
git clone https://github.com/votre-repository.git
Configuration de la base de données
Créez une base de données MySQL.
Importez le fichier SQL fourni dans le dossier DataBase du projet pour créer les tables nécessaires.
Mettez à jour les informations de connexion dans la classe SingletonConnectionBDD.
Exécution du projet
Importez le projet dans Eclipse.
Exécutez la classe Application depuis le package main.
Auteurs
Votre Nom - Développeur principal
