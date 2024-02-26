package com.sprindatajpa.repository;

import com.sprindatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod()
    {
        Product product = new Product();
        product.setName("P1");
        product.setDescription("First Product");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        Product product1 = productRepository.save(product);

        System.out.println(product1.getId());
        System.out.println(product1.toString());
    }

    @Test
    void updateUsingSaveMethod()
    {
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        product.setName("Update First Product");
        product.setDescription("Updated Product 1 description");

        productRepository.save(product);
    }


    @Test
    void findByIdMethod()
    {
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        System.out.println(product);
    }


    @Test
    void saveAllMethod()
    {
        Product product2 = new Product();
        product2.setName("P2");
        product2.setDescription("Second Product");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");


        Product product3 = new Product();
        product3.setName("P3");
        product3.setDescription("Third Product");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");


        Product product4 = new Product();
        product4.setName("P4");
        product4.setDescription("Fourth Product");
        product4.setSku("400ABC");
        product4.setPrice(new BigDecimal(400));
        product4.setActive(true);
        product4.setImageUrl("product4.png");


        Product product5 = new Product();
        product5.setName("P5");
        product5.setDescription("Fifth Product");
        product5.setSku("500ABC");
        product5.setPrice(new BigDecimal(500));
        product5.setActive(true);
        product5.setImageUrl("product5.png");


        Product product6 = new Product();
        product6.setName("P6");
        product6.setDescription("Sixth Product");
        product6.setSku("600ABC");
        product6.setPrice(new BigDecimal(600));
        product6.setActive(true);
        product6.setImageUrl("product6.png");

        productRepository.saveAll(List.of(product2,product3,product4,product5,product6));
    }


    @Test
    void findAllMethod()
    {
        List<Product> productsList = productRepository.findAll();

        productsList.forEach(System.out::println);
    }

    @Test
    void deleteByIdMethod()
    {
        Long id = 2L;

        productRepository.deleteById(id);
    }

    @Test
    void deleteByEntityMethod()
    {
        Long id = 5L;
        Product product = productRepository.findById(id).get();

        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod()
    {
        productRepository.deleteAll();
    }


    @Test
    void deleteAllMethodforAGroupOfEntities()
    {
        Product p1 = productRepository.findById(1L).get();

        Product p2 = productRepository.findById(2L).get();

        productRepository.deleteAll(List.of(p1,p2));
    }


    @Test
    void countMethod()
    {
        long count = productRepository.count();

        System.out.println("No of records in a database "+count);
    }

    @Test
    void ExistsByIdMethod()
    {
        Long id = 4L;
        boolean result = productRepository.existsById(id);

        System.out.println(result);
    }





}