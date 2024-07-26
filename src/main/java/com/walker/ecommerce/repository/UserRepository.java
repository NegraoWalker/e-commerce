package com.walker.ecommerce.repository;

import com.walker.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = :login")
    User findUserByLogin(@Param("login") String login); //Procurar o user registrado no banco de dados pelo login fornecido
}
