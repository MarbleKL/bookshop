package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepository extends JpaRepository<BookList,Integer> {
}
