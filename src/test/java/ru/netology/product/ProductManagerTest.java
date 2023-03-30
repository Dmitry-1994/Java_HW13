package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book_1 = new Book(111, "Harry Potter_I", 10, "Joan Rowling");
    Product book_2 = new Book(222, "Harry Potter_II", 25, "Joan Rowling");
    Product book_3 = new Book(333, "Lord of the Rings", 35, "John Ronald");
    Product smartphone_1 = new Smartphone(444, "Redmi_13", 10_000, "Xiaomi");
    Product smartphone_2 = new Smartphone(555, "iPhone_13", 50_000, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(book_1);
        manager.add(book_2);
        manager.add(book_3);
        manager.add(smartphone_1);
        manager.add(smartphone_2);
    }

    @Test
    public void searchByTextMore() {
        Product[] expected = {book_1, book_2};
        Product[] actual = manager.searchBy("Harry");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTextNull() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Hobbit");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTextOne() {
        Product[] expected = {smartphone_2};
        Product[] actual = manager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthor() {
        Product[] expected = {book_3};
        Product[] actual = manager.searchBy("John Ronald");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacturer() {
        Product[] expected = {smartphone_1};
        Product[] actual = manager.searchBy("Xiaomi");

        Assertions.assertArrayEquals(expected, actual);
    }


}
