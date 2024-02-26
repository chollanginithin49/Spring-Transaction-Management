package com.sprindatajpa.repository;

import com.sprindatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("P4");
        System.out.println(product);
    }


    @Test
    void findByIdMethod() {
        Long id = 4L;
        Product product = productRepository.findById(id).get();

        System.out.println(product);

    }


    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> productList = productRepository.findByNameOrDescription("P3", "Fourth Product");
        productList.forEach(System.out::println);
    }

    @Test
    void findByNameAndDescription() {
        List<Product> productList = productRepository.findByNameAndDescription("P4", "Fourth Product");
        productList.forEach(System.out::println);
    }


    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("P4");

        System.out.println(product);
    }


    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> productList = productRepository.findByPriceGreaterThan(new BigDecimal(100));

        productList.forEach(System.out::println);
    }

    @Test
    void findByPriceLessThanMethod() {
        List<Product> productList = productRepository.findByPriceLessThan(new BigDecimal(400));
        productList.forEach(System.out::println);
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("P4");

        products.forEach(System.out::println);
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> productList = productRepository.findByNameLike("P5");

        productList.forEach(System.out::println);
    }

    @Test
    void findByPriceBetween()
    {
        List<Product> productList = productRepository.findByPriceBetween(new BigDecimal(100),new BigDecimal(400));
        productList.forEach(System.out::println);
    }


    @Test
    void findByDateCreatedBetweenMethod()
    {
        LocalDateTime startDate = LocalDateTime.of(2024,02,25,21,37,49);
        LocalDateTime endDate = LocalDateTime.of(2024,02,25,21,37,49);

        List<Product> productList = productRepository.findByDateCreatedBetween(startDate,endDate);
        productList.forEach(System.out::println);
    }

    @Test
    void findByNameInMethod()
    {
        List<Product> productList = productRepository.findByNameIn(List.of("P4","P5"));
        productList.forEach(System.out::println);
    }

    @Test
    void findFirst2ByOrderByNameAscMethod()
    {
        List<Product> productList = productRepository.findFirst2ByOrderByNameAsc();

        productList.forEach(System.out::println);
    }


    @Test
    void findTop3ByOrderPriceDescMethod()
    {
        List<Product> productList = productRepository.findTop2ByOrderByPriceDesc();
        productList.forEach(System.out::println);
    }
}

