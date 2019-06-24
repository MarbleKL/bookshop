package edu.sit.bookshop.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String phone_number;

    private String email;

    private Integer like_count;

    private Integer followed_count;

    private String code;

    private String school;

    private Integer credit_points;

    @OneToOne
    private WxUser wxuser;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<User> followed_list;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<User> follow_list;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Book> book = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "fromUser")
    private Set<Message> send_message = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "toUser")
    private Set<Message> receive_message = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<BookRequest> book_request = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<UserTag> user_tag = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Complaint> complaint = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<BookComment> book_comment = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<BookThink> book_think = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<BookThinkComment> book_think_comment = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private Set<Score> score = new HashSet<>();

}