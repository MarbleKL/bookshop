package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.BookComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCommentRepository extends JpaRepository<BookComment,Integer> {
}
