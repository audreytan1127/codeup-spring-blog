package edu.codeup.codeupspringblog.repositories;

import edu.codeup.codeupspringblog.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    Object getByTitle(String title);
}
