package edu.sit.bookshop.service;

import edu.sit.bookshop.entity.*;
import edu.sit.bookshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookTagRepository bookTagRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookThinkRepository bookThinkRepository;
    public Set<Book> getBookListByTag(List<BookTag> bookTagSet)
    {
        Iterator<BookTag> iterator = bookTagSet.iterator();
        Set<Book> result;
        BookTag byId = bookTagRepository.findById(iterator.next().getId()).get();
        result=byId.getBook();
        while(iterator.hasNext())
        {
            BookTag bookTag = bookTagRepository.findById(iterator.next().getId()).get();
            result.retainAll(bookTag.getBook());
        }
        System.out.println(byId.toString());
        return result;
    }

    public String saveBook(Book book)
    {
        bookRepository.save(book);
        return "success";
    }

    public String saveUser(User user)
    {
        userRepository.save(user);
        return "success";
    }

    public String saveBookThink(BookThink bookThink)
    {
        bookThinkRepository.save(bookThink);
        return "success";
    }

}
