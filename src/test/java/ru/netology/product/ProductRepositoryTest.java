package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    Product book_1 = new Book(111, "Harry Potter_I", 10, "Joan Rowling");
    Product book_2 = new Book(222, "Harry Potter_II", 25, "Joan Rowling");
    Product book_3 = new Book(333, "Lord of the Rings", 35, "John Ronald");
    Product smartphone_1 = new Smartphone(444, "Redmi_13", 10_000, "Xiaomi");
    Product smartphone_2 = new Smartphone(555, "iPhone_13", 50_000, "Apple");

    @Test
    public void saveNull() {
        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveOne() {
        repository.save(book_3);

        Product[] expected = {book_3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveMore() {
        repository.save(book_1);
        repository.save(book_2);
        repository.save(book_3);
        repository.save(smartphone_1);
        repository.save(smartphone_2);

        Product[] expected = {book_1, book_2, book_3, smartphone_1, smartphone_2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdOne() {
        repository.save(book_1);
        repository.save(book_2);
        repository.save(book_3);
        repository.save(smartphone_1);
        repository.save(smartphone_2);

        repository.removeById(111);

        Product[] expected = {book_2, book_3, smartphone_1, smartphone_2};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdFew() {
        repository.save(book_1);
        repository.save(book_2);
        repository.save(book_3);
        repository.save(smartphone_1);
        repository.save(smartphone_2);

        repository.removeById(111);
        repository.removeById(333);
        repository.removeById(555);

        Product[] expected = {book_2, smartphone_1};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdAll() {
        repository.save(book_1);
        repository.save(book_2);
        repository.save(book_3);
        repository.save(smartphone_1);
        repository.save(smartphone_2);

        repository.removeById(111);
        repository.removeById(222);
        repository.removeById(333);
        repository.removeById(444);
        repository.removeById(555);

        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
