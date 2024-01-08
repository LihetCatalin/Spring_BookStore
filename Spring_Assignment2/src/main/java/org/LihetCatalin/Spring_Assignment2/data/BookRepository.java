package org.LihetCatalin.Spring_Assignment2.data;

import org.LihetCatalin.Spring_Assignment2.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
