package in.gokul.billingsoftware.service;

import in.gokul.billingsoftware.entity.CategoryEntity;
import in.gokul.billingsoftware.io.CategoryRequest;
import in.gokul.billingsoftware.io.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryResponse add(CategoryRequest categoryRequest);

    CategoryResponse findByName(String name);

    List<CategoryResponse> retrieve();

    void delete(String categoryId);




}
