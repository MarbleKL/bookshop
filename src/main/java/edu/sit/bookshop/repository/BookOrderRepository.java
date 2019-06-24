package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder,Integer> {
}
