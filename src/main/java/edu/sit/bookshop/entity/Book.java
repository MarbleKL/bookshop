package edu.sit.bookshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Book.class)
public class Book implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String isbn;

    private String name;

    private Integer depreciation;

    private Integer forSell;

    private Integer forChange;

    private Integer forGift;

    private Integer byCommerce;

    private String blurb;

    private String shortBlurb;

    private String author;

    private String introduction;

    private Integer price;

    @CreatedDate
    private Date createTime;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private Set<BookTag> bookTag;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private Set<BookRequest> bookRequest;

    @OneToOne
    private BookOrder bookOrder;

    @ManyToOne
    private BookList bookList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private Set<Score> score;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private List<BookComment> bookComment;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", depreciation=" + depreciation +
                ", forSell=" + forSell +
                ", forChange=" + forChange +
                ", forGift=" + forGift +
                ", byCommerce=" + byCommerce +
                ", blurb='" + blurb + '\'' +
                ", shortBlurb='" + shortBlurb + '\'' +
                ", author='" + author + '\'' +
                ", introduction='" + introduction + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                '}';
    }
}