package fis.java.com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fis.java.com.Entity.Oder;

public interface OderRepository extends JpaRepository<Oder, Long> {

	boolean existsByOderNumber(String oderNumber);

}
