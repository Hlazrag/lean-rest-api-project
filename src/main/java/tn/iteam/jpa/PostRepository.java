package tn.iteam.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

