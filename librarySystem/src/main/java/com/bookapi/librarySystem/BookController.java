package com.bookapi.librarySystem;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    ArrayList<Book> booksList = new ArrayList<>();

    @GetMapping
    public List<Book> getAllBooks(){
        return booksList;
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book newBook){
        booksList.add(newBook);
        return  newBook;
    }

    @PutMapping("/update")
    public String updateBooks(@RequestBody Book newDetails){
        for(Book ele:booksList){
            if(ele.getId()==(newDetails.getId())){
                ele.setId(newDetails.getId());
                ele.setAuthor(newDetails.getAuthor());
                ele.setId(newDetails.getId());

                return "Book details updated";
            }

        }
        return "enter a valid book id to update";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id){
        for(Book ele:booksList){
            if(ele.getId()==id){
                booksList.remove(ele);
                return "Book deleted";
            }
       }
        return "Book not found give a valid id";
    }
}
