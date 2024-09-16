package org.login.authjwt.repositories;

import org.login.authjwt.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//<User> entidad sobre la que el repositorio acturara
//<Integer> tipo de dato del identificador de la entidad que operarara
public interface UserRepository extends CrudRepository<User, Integer> {
    //Optional, un tipo de dato de retorno para manejar valores que pueden retornar o no
    //En caso que email no exista no retornaria nada, sin opcional obtendriamos error
    Optional<User> findByEmail(String email);
}