/*-Installation de IntelliJ
-Configuration
-installer un plugin lombok(ça permet de réduire considérablement le code)
-Aller sur le site SpringInitializer pour générer un projet SpringBoot
-L'importer ensuite dans IntelliJ
-Télécharger des dépendances dans le pom.xml
-Vérifier les dépendances correspondantes

Quelques dépendances et rôles :

@RequiredArgsConstructor : permet de générer automatiquement les méthodes et constructeurs.
@Service : Mettre en oeuvre la logique du métier de l'application
@Transactional : Assure la cohérence des données dans la base donnée( unité logique du travail qui garantit que soit les instructions sont soit
exécutées en cas de succès soit annulées en cas d'échec).
@Slf4j : génère automatiquement logger slf4j qui sert à enregistrer les informations de journalisation courante.

Exemple de code*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MonService {

    public void faireQuelqueChose() {
        log.info("Ceci est un message de journalisation avec SLF4J.");
        // ...
    }
}

/*Pour utiliser Lombok, voici les étapes : */

//Ajouter la dépendance Lombok dans le pom.xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.20</version> // <!-- Assurez-vous d'utiliser la dernière version disponible -->
    <scope>provided</scope>
</dependency>

//Pour les projets sur GRaddle
dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.20' // Assurez-vous d'utiliser la dernière version disponible
    annotationProcessor 'org.projectlombok:lombok:1.18.20'
}

//Exemple de code
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class Exemple {
    private String nom;
    private int age;
}
// Utilisation dans le code
Exemple exemple = new Exemple("John Doe", 30);

/*Si on veut gérer les constructeurs avec tous les arguments, on utilise @AllArgsConstructor*/

/*JpaRepository est une méthode CRUD (Cretation, Lecture, Mise à jour, Suppression) sur des entités JPA généré
automatiquement par Spring Data JPA.

Une entité JPA est une classe Java liée à une table dans une base de donnée relationnelle. Ses caractériqtiques exigées :
-La classe doit être annotée par @Entity
-Doit avoir un attribut qui sert de clé primaire annoté par @Id

Exemple de code : */

import org.springframework.data.jpa.repository.JpaRepository;
  public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}//si vous avez une entité JPA nommée Utilisateur, vous pouvez créer un référentiel (repository) en étendant JpaRepository comme ceci

/*Dans cet exemple, Utilisateur est l'entité JPA, et Long est le type de données de la clé primaire de cette entité.
En étendant JpaRepository, on obtient automatiquement des méthodes telles que save(), findById(), findAll(), delete(), etc.,
sans avoir à les implémenter manuellement.*/

/*
JpaRepository est une interface générique fournie par Spring Data JPA qui définit un ensemble de méthodes pour effectuer des opérations CRUD et d'autres opérations courantes sur des entités JPA.

package org.springframework.data.jpa.repository; : Cette ligne définit le package dans lequel se trouve la classe JpaRepository.

public interface JpaRepository<T, ID> : C'est la déclaration de l'interface JpaRepository. Cette interface est générique, où T représente le type d'entité JPA géré (par exemple, une classe Utilisateur), et ID représente le type de la clé primaire de cette entité (par exemple, Long).

extends ListCrudRepository<T, ID>, ListPagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> : Cette interface étend plusieurs autres interfaces génériques fournies par Spring Data. Les interfaces ListCrudRepository et ListPagingAndSortingRepository définissent des méthodes pour effectuer des opérations CRUD (Création, Lecture, Mise à jour, Suppression) et de pagination sur des entités. QueryByExampleExecutor offre des méthodes pour exécuter des requêtes basées sur des exemples.

Les méthodes définies dans cette interface incluent :

flush(): Cette méthode permet de forcer l'écriture des modifications non persistées dans la base de données.
saveAndFlush(S entity): Elle permet de sauvegarder une entité et de forcer l'écriture de cette entité dans la base de données.
saveAllAndFlush(Iterable<S> entities): Cette méthode permet de sauvegarder une liste d'entités et de forcer l'écriture de ces entités dans la base de données.
deleteAllInBatch(Iterable<T> entities): Elle permet de supprimer un ensemble d'entités en une seule opération.
deleteAllByIdInBatch(Iterable<ID> ids): Elle permet de supprimer un ensemble d'entités par leurs identifiants en une seule opération.
deleteAllInBatch(): Cette méthode supprime toutes les entités en une seule opération.
getOne(ID id): Cette méthode est dépréciée et ne doit plus être utilisée. Utilisez plutôt getById(ID id) ou getReferenceById(ID id) pour obtenir une entité par son identifiant.
getById(ID id): Cette méthode permet d'obtenir une entité par son identifiant.
getReferenceById(ID id): Cette méthode permet d'obtenir une référence à une entité par son identifiant.
findAll(Example<S> example): Cette méthode permet de rechercher toutes les entités correspondant à un exemple donné.
findAll(Example<S> example, Sort sort): Cette méthode permet de rechercher toutes les entités correspondant à un exemple donné et de trier les résultats.
@NoRepositoryBean: Cette annotation indique que JpaRepository est une interface de base pour les autres interfaces de repository spécifiques à votre application. Elle n'est pas destinée à être utilisée directement comme un repository, mais plutôt à être étendue pour créer des interfaces de repository spécifiques.

*/
// Lundi 2 octobre 2023
//Notion de CRUD avec un exercice complet en SpringBoot
