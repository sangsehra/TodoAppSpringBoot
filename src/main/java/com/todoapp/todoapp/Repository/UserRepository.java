package com.todoapp.todoapp.Repository;

import com.todoapp.todoapp.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("select u from Users u where u.name = :namee")
    Users getUsersBytttName(@Param("namee") String name);
Optional<Users> findByName(String name);
}
