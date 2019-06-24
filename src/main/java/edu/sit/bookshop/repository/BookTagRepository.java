package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.Book;
import edu.sit.bookshop.entity.BookTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookTagRepository extends JpaRepository<BookTag,Integer> {
}
