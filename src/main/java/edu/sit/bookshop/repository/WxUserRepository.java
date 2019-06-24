package edu.sit.bookshop.repository;

import edu.sit.bookshop.entity.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WxUserRepository extends JpaRepository<WxUser,String> {
    WxUser findByOpenid(String openid);
}
