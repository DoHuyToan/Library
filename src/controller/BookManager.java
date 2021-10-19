package controller;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements GeneralManager<Book> {
    ArrayList<Book> bookArrayList = new ArrayList<>();

    private BookManager() {
    }

    private static class BookManagerHelper{
        private static final BookManager INSTANCE = new BookManager();
    }

    public static BookManager getInstance() {
        return BookManager.BookManagerHelper.INSTANCE;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    @Override
    public List<Book> findAll() {
        return bookArrayList;
    }

    @Override
    public void add(Book book) {
        bookArrayList.add(book);
    }

    @Override
    public void editByCode(String code, Book book) {
        for (int i=0; i<bookArrayList.size(); i++){
            if(bookArrayList.get(i).getCode().equals(code)){
                bookArrayList.set(i, book);
            }
            else System.out.println("Mã sách cần sửa ko đúng");
        }
    }

    @Override
    public void removeByCode(String code) {
        for (int i=0; i<bookArrayList.size(); i++){
            if(bookArrayList.get(i).getCode().equals(code)){
                bookArrayList.remove(i);
            }
            else System.out.println("Mã sách cần xóa ko đúng");
        }
    }

    @Override
    public void showAll() {
        for (Book b:bookArrayList) {
            System.out.println(b);
        }
    }

    @Override
    public Book searchByCode(String code) {
        Book book = null;
        for (int i=0; i<bookArrayList.size(); i++){
            if(bookArrayList.get(i).getCode().equals(code)){
                book = bookArrayList.get(i);
            }
        }
        return book;
    }
}