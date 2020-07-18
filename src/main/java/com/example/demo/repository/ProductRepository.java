package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findByAvailable(boolean asdf);
    List<Product> findAllByAvailableTrue();
    List<Product> findAllByNameStartingWith(String start);
    List<Product> findAllByNameStartingWithIgnoreCase(String start);
    List<Product> findAllByPriceIsBetweenAndNameContaining(double first, double second, String like);
    List<Product> findAllByPriceIn(Collection<Double> prices);

    @Transactional
    void deleteByName(String name);

    @Query("SELECT p FROM Product p " +
            "WHERE p.name LIKE CONCAT(:starting, '%') " +
            "AND p.price = :price")
    List<Product> getProductsLikeWithPrice(@Param("starting") String string, @Param("price") Double price);

    @Query(value = "SELECT * FROM product " +
            "WHERE name LIKE :starting% " +
            "AND price = :price", nativeQuery = true)
    List<Product> getProductLikeWithPriceNative(@Param("starting") String string, @Param("price") Double price);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product WHERE name = :name", nativeQuery = true)
    void deleteByNameNative(@Param("name") String name);
}
