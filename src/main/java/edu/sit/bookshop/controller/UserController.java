package edu.sit.bookshop.controller;

import edu.sit.bookshop.entity.Book;
import edu.sit.bookshop.entity.BookTag;
import edu.sit.bookshop.entity.User;
import edu.sit.bookshop.entity.WxUser;
import edu.sit.bookshop.repository.BookRepository;
import edu.sit.bookshop.repository.WxUserRepository;
import edu.sit.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    WxUserRepository wxUserRepository;
    @Autowired
    BookRepository bookRepository;
    @RequestMapping(value ="/booklist",method = RequestMethod.GET)
    public Set<Book> getBookListByTag(@RequestBody List<BookTag> bookTagList)
    {
        System.out.println(bookTagList.toString());
        Set<Book> bookSet = userService.getBookListByTag(bookTagList);
        return bookSet;
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String saveBook(@RequestBody Book book)
    {
        System.out.println(book.toString());
         String result= userService.saveBook(book);
         return result;
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public Book get_book(@PathVariable Integer id)
    {
        Book book = bookRepository.findById(id).get();
        return book;
    }


    @RequestMapping(value = "/user/{openid}",method = RequestMethod.POST)
    public String saveUser(@RequestBody User user,@PathVariable String openid)
    {
        WxUser wxUser = wxUserRepository.findByOpenid(openid);
        wxUser.setUser(user);
        wxUser=wxUserRepository.save(wxUser);
        if(wxUser.getUser()!=null)
        {
            return "success";
        }
        else
        {
            return "fail";
        }
    }

}
