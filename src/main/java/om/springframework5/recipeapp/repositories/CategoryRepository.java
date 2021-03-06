package om.springframework5.recipeapp.repositories;

import om.springframework5.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);

}
