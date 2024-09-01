
# Projet de Gestion de Bibliothèque

## Description

Ce projet est une application Java développée sur l'IDE Eclipse, utilisant une base de données MySQL pour gérer les données d'une bibliothèque. L'application permet d'effectuer diverses opérations, telles que l'ajout, la suppression, la modification et la consultation de livres, ainsi que la gestion des commandes et des fournisseurs.

## Versions

- **IDE** : Eclipse Version 2024-06 (4.32.0)
- **Java** : Java version "22.0.1" (2024-04-16)

## Structure du Projet

Le projet est organisé en trois packages principaux :

### 1. Package `connection`

Ce package contient la classe **`SingletonConnectionBDD`**. Cette classe gère la connexion à la base de données en utilisant le pattern Singleton, garantissant ainsi qu'une seule connexion reste ouverte pour toutes les opérations de l'application.

### 2. Package `model`

Ce package contient trois classes principales, chacune représentant une table de la base de données :

- **`Commande`** : Gère les commandes passées par la bibliothèque.
- **`Fournisseur`** : Gère les informations des fournisseurs de la bibliothèque.
- **`Livre`** : Gère les informations des livres disponibles dans la bibliothèque.

### 3. Package `main`

Ce package contient les classes responsables de l'exécution de l'application :

- **`Main`** : Cette classe propose un menu interactif permettant à l'utilisateur de choisir les actions à effectuer (ajout, consultation, suppression, etc.).
- **`Application`** : Point d'entrée de l'application, elle initialise et exécute le menu principal.

## Fonctionnalités

- **Gestion des Livres** : Ajouter, modifier, supprimer et consulter les livres disponibles dans la bibliothèque.
- **Gestion des Commandes** : Suivre et gérer les commandes passées par la bibliothèque.
- **Gestion des Fournisseurs** : Gérer les informations relatives aux fournisseurs de livres et autres produits.

## Configuration et Installation

### Prérequis

- Java JDK 22.0.1 ou supérieur
- Eclipse IDE (Version 2024-06 ou plus récente)
- MySQL (version 5.x ou supérieure)

### Cloner le projet

```bash
git clone https://github.com/votre-repository.git

### Configuration de la base de données
- Créez une base de données MySQL.
- Importez le fichier SQL fourni dans le dossier DataBase du projet pour créer les tables nécessaires.

### Exécution du projet
- Importez le projet dans Eclipse.
- Exécutez la classe Application depuis le package main.
## Auteurs
Sayed Mejbri- Développeur principal

