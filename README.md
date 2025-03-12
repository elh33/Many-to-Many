# Projet de Relation Many-to-Many avec JPA

## Description
Ce projet démontre l'implémentation d'une relation many-to-many (plusieurs à plusieurs) entre deux entités - `Student` (Étudiant) et `Course` (Cours) - en utilisant JPA (Jakarta Persistence API) avec un fournisseur EclipseLink.

## Structure du Projet
```
src/main/java/
├── dao/
│   ├── CourseDao.java
│   └── StudentDao.java
├── daoImpl/
│   ├── CourseDaoImpl.java
│   └── StudentDaoImpl.java
├── models/
│   ├── Course.java
│   └── Student.java
└── MainClass.java
```

## Conception de la Relation
- Un étudiant peut s'inscrire à plusieurs cours
- Un cours peut avoir plusieurs étudiants inscrits
- La relation est gérée par une table de jointure nommée `student_courses`

## Technologies Utilisées
- Java 23
- Jakarta Persistence API (JPA) 3.0
- EclipseLink (Fournisseur JPA)
- MySQL
- Maven

## Configuration
1. Créer une base de données MySQL nommée `entity2`
2. Utilisateur: `root`, mot de passe: `0000` (modifiable dans `persistence.xml`)

## Entités
- **Student**: Entité principale (côté propriétaire) qui définit la table de jointure
- **Course**: Entité secondaire (côté inverse) qui référence l'entité propriétaire

## Points Importants
- La relation bidirectionnelle est gérée par `@JoinTable` côté Student (propriétaire)
- Le côté Course (inverse) utilise `mappedBy="courses"` pour référencer le champ dans Student
- Des méthodes utilitaires (`addCourse`, `removeCourse`) maintiennent la cohérence bidirectionnelle
- Les opérations de cascade sont configurées pour propager les actions de persistance et de fusion

## Exécution du Projet
1. Importer le projet dans IntelliJ IDEA
2. Vérifier la connexion à la base de données
3. Exécuter la classe `MainClass`

## Exemple de Fonctionnement
La classe `MainClass` démontre:
1. La création d'étudiants et de cours
2. L'établissement de relations entre étudiants et cours
3. La sauvegarde des données dans la base de données
4. La récupération et l'affichage des relations

## Dépannage
Si vous rencontrez des erreurs:
1. Vérifiez la connexion à la base de données
2. Assurez-vous que les entités sont persistées avant d'établir des relations
3. Consultez les logs pour identifier les problèmes spécifiques

## Note sur les Annotations JPA
- `@ManyToMany`: Définit la relation plusieurs à plusieurs
- `@JoinTable`: Spécifie la table de jointure (côté propriétaire)
- `mappedBy`: Indique le côté inverse de la relation (non-propriétaire)
