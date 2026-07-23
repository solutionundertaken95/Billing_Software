package in.gokul.billingsoftware.service;

import in.gokul.billingsoftware.entity.CategoryEntity;
import in.gokul.billingsoftware.io.CategoryRequest;
import in.gokul.billingsoftware.io.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryResponse add(CategoryRequest categoryRequest, MultipartFile file);

    CategoryResponse findByName(String name);

    List<CategoryResponse> retrieve();

    void delete(String categoryId);




}
