package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.BookThinkComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookThinkCommentRepository extends JpaRepository<BookThinkComment,Integer> {
}
