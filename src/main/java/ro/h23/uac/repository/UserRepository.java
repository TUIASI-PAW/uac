package ro.h23.uac.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ro.h23.uac.model.User;

/*
 * The @Repository annotation is a marker for any class that fulfills the role or stereotype of a
 * repository (also known as Data Access Object or DAO). Among the uses of this marker is the
 * automatic translation of exceptions, as described in Exception Translation.
 * 
 * Spring Data repositories usually extend from the Repository or CrudRepository interfaces. If you
 * use auto-configuration, repositories are searched from the package containing your main
 * configuration class (the one annotated with @EnableAutoConfiguration or @SpringBootApplication)
 * down.
 * 
 * If you were not using Spring Boot, or the repository was in a child package it would need to be
 * annotated and the package scanned, or a bean created.
 * 
 * All exceptions thrown by the JPA persistence providers are converted into Spring's
 * DataAccessException - for all beans annotated with @Repository (or configured).
 * 
 * There are four main groups -
 * 
 * NonTransientDataAccessException - these are the exceptions where a retry of the same operation
 * would fail unless the cause of the Exception is corrected. So if you pass non existing id for
 * example, it will fail unless the id exists in the database.
 * 
 * RecoverableDataAccessException - these are the "opposite" of the previous one - exceptions which
 * are recoverable - after some recovery steps. More details in the API docs
 * 
 * ScriptException - SQL related exceptions, when trying to process not well-formed script for
 * example.
 * 
 * TransientDataAccessException - these are the exception when recovery is possible without any
 * explicit step, e.g. when there is a timeout to the database, you are retrying after few seconds.
 */

// https://spring.io/guides/gs/accessing-data-mysql/
@Repository
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface UserRepository extends CrudRepository<User, Integer> {

	// SELECT * FROM user WHERE username = :username
	@Query("SELECT u FROM User u WHERE u.username = :username")
	Iterable<User> findAllByUsername(@Param("username") String username);

}
