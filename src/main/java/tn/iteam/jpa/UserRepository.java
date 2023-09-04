package tn.iteam.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
