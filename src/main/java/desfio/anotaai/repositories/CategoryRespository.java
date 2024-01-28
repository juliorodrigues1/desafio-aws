package desfio.anotaai.repositories;

import desfio.anotaai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends MongoRepository<Category, String> {

}
