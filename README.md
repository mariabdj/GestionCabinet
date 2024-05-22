# Gestion du Cabinet Médical

## Description

Ce projet est une application de gestion de cabinet médical développée en Java. Elle permet de gérer les patients, les rendez-vous, les médecins, et les consultations. L'application offre une interface utilisateur intuitive et des fonctionnalités robustes pour faciliter la gestion quotidienne du cabinet.

## Fonctionnalités

- **Gestion des patients** : ajout, modification, suppression, et recherche de patients.
- **Gestion des médecins** : ajout, modification, suppression, et recherche de médecins.
- **Gestion des rendez-vous** : planification, modification, annulation et consultation des rendez-vous.
- **Gestion des consultations** : enregistrement des détails de la consultation, prescriptions, et suivi médical.

## Prérequis

- Java Development Kit (JDK) 17
- IDE Java (Eclipse)
- Base de données Oracle ou autre compatible JDBC

## Installation

1. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/votre-utilisateur/gestion-cabinet.git
   cd gestion-cabinet
   ```

2. **Configurer la base de données :**
   - Créer une base de données MySQL nommée `gestion_cabinet`.
   - Importer le fichier `schema.sql` pour créer les tables nécessaires.
   - Mettre à jour le fichier `application.properties` avec les informations de connexion à la base de données.

## Utilisation

- Lancer l'application.
- Se connecter avec un compte administrateur pour gérer les utilisateurs.
- Ajouter des médecins et des patients via le menu de gestion.


## Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.
