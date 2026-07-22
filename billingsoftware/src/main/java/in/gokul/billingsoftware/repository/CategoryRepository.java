package in.gokul.billingsoftware.repository;

import in.gokul.billingsoftware.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    CategoryEntity findByName(String name);

    Optional<CategoryEntity> findByCategoryId(String categoryId);
}
