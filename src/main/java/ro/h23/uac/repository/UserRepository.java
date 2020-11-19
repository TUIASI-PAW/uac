package ro.h23.uac.repository;

import org.springframework.data.repository.CrudRepository;

import ro.h23.uac.model.User;

// https://spring.io/guides/gs/accessing-data-mysql/
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface UserRepository extends CrudRepository<User, Integer> {

}
