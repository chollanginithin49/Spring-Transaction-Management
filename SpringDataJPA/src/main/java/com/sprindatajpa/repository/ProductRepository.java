package com.sprindatajpa.repository;

import com.sprindatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    /**
     * Returns the found product entry by using its name as search criteria .
     * If no product entry is found ,this method returns null
    */
    public Product findByName(String name);

    /**
     * Returns an Optional which contains the found product
     * entry by using which its id as search criteria.
     * If no product entry is found,this method returns an empty Optional.
    * */
    Optional<Product> findById(Long id);


    /**
     *Returns the found list of product entries whose title or description is given
     * as a method parameter. If no product entries is found,this method returns an empty list.
     */
    List<Product> findByNameOrDescription(String name, String description);

    /*
    * Returns the found list of product entries whose name and description is given as a method parameters.
    * If no product entries is found ,this method returns an empty list
    * */
    List<Product> findByNameAndDescription(String name,String description);


    /*
    * Return the distinct product entry whose name is given as a method parameter
    * If no product entry is found , this method returns null.
     */
    Product findDistinctByName(String name);


    /*
    *Return the products whose price is greater than given price as a method parameter
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);


    /*
    * Return the products whose price is less than given price as a method parameter.
     */
    List<Product> findByPriceLessThan(BigDecimal price);


    /*
    * Return the filtered the products records that match with given text
     */
    List<Product> findByNameContaining(String name);

    /*
    * Return products based on the SQL like condition
     */
    List<Product> findByNameLike(String name);

    /*
    * Returns a products whose price between start price and end price
     */
    List<Product> findByPriceBetween(BigDecimal startPrice , BigDecimal endPrice);

    /*
    * Returns a products whose dateCreated between start date and end date
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate,LocalDateTime endDate);

    /*
    *  Returns list of products based on multiple values
     */
    List<Product> findByNameIn(List<String> names);

    /*
    *
     */
    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop2ByOrderByPriceDesc();



}
