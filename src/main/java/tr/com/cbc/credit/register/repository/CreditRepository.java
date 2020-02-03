package tr.com.cbc.credit.register.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.com.cbc.credit.register.domain.Credit;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {

	
    
   
}