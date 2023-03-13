package com.academy.main;

import com.academy.Book;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 1.uloha:
        System.out.println(
                Stream
                        .iterate(1, A -> A + 1)
                        .limit(10000)
                        .filter(A -> A % 3 == 0 && A % 5 == 0 && A % 7 != 0)
                        .mapToInt(A->A)
                        .sum()
        );
        // 2.uloha:
        Stream
                .iterate(1,A->A+1)
                .filter(A->A%2==0 && A%8!=0)
                .limit(100)
                .forEach(A-> System.out.print(A+", "));

        // 3.1 Using Java Stream API print names (in alphabetic order) of all books that have price smaller than 100.
        Stream<Book> books = Stream.of(
                new Book("Lord of the Rings",110),
                new Book("Hobbit",105),
                new Book("Old man and sea",95),
                new Book("Harry Potter",70),
                new Book("Ok",115),
                new Book("Witcher",80));
        books
                .filter(A -> A.getPrice()<100)
                .sorted(Comparator.comparing(Book::getName))
                .forEach(A -> System.out.print("\n"+A.getName()));
        // 3.2 Using Java stream API find out how many books have name shorter than 5 characters.
        books = Stream.of(
                new Book("Lord of the Rings",110),
                new Book("Hobbit",105),
                new Book("Old man and sea",95),
                new Book("Harry Potter",70),
                new Book("Ok",115),
                new Book("Witcher",80));

        System.out.println("\nPocet knih s menom kratsim ako 5 znakov: "+
                books.filter(A->A.getName().length()<5).count());

        //3.3 Using Java stream API find out what is the average price of the book in the list
        books = Stream.of(
                new Book("Lord of the Rings",110),
                new Book("Hobbit",105),
                new Book("Old man and sea",95),
                new Book("Harry Potter",70),
                new Book("Ok",115),
                new Book("Witcher",80));
        System.out.println("Average price:"+books.mapToInt(Book::getPrice).average().getAsDouble());

        //3.4 Using Java stream API find out if all books in list are cheaper than 500
        books = Stream.of(
                new Book("Lord of the Rings",110),
                new Book("Hobbit",105),
                new Book("Old man and sea",95),
                new Book("Harry Potter",70),
                new Book("Ok",115),
                new Book("Witcher",80));
        System.out.println("Su vsetky knihy lacnejsie ako 500? Odpoved: "+books.allMatch(A->A.getPrice()<500));
    }
}