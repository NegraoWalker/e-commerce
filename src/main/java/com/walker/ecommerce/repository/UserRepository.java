package com.walker.ecommerce.repository;

import com.walker.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.login = ?")
    User findUserByLogin(String login); //Procurar o user registrado no banco de dados pelo login fornecido
}
