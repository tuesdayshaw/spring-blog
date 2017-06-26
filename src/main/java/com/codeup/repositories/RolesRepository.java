package com.codeup.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.management.relation.Role;
import java.util.List;

/**
 * Created by canidmars on 6/23/17.
 */
public interface RolesRepository extends CrudRepository<Role, Long> {
    @Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
    public List<String> ofUserWith(String username);
}
