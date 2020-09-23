package be.intecbrussel.banking_app_spring.repository;

import be.intecbrussel.banking_app_spring.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
