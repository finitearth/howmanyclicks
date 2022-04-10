package de.me.howmanyclicks.repository;

import de.me.howmanyclicks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
