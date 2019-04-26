package om.springframework5.recipeapp.repositories;

import om.springframework5.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {


}
