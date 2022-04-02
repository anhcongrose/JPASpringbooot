package fis.java.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fis.java.com.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
