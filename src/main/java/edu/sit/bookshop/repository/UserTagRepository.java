package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTagRepository extends JpaRepository<UserTag,Integer> {
}
