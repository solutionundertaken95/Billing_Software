package in.gokul.billingsoftware.service.impl;

import in.gokul.billingsoftware.entity.CategoryEntity;
import in.gokul.billingsoftware.io.CategoryRequest;
import in.gokul.billingsoftware.io.CategoryResponse;
import in.gokul.billingsoftware.repository.CategoryRepository;
import in.gokul.billingsoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse add(CategoryRequest request) {
        CategoryEntity newCategory = convertToEntity(request);
        CategoryEntity categoryEntity = categoryRepository.save(newCategory);
        return convertToResponse(categoryEntity);

    }

    @Override
    public CategoryResponse findByName(String name) {

        CategoryEntity categoryEntity = categoryRepository.findByName(name);
        CategoryResponse response = convertToResponse(categoryEntity);
        return response;
    }

    @Override
    public List<CategoryResponse> retrieve() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> convertToResponse(categoryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {

        CategoryEntity categoryEntity= categoryRepository.findByCategoryId(categoryId).orElseThrow(() -> new RuntimeException("Category Id not found"));
        categoryRepository.delete(categoryEntity);

    }


    private CategoryResponse convertToResponse(CategoryEntity categoryEntity) {

        return CategoryResponse.builder()
                .categoryId(categoryEntity.getCategoryId())
                .name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .bgColor(categoryEntity.getBgColor())
                .imgUrl(categoryEntity.getImgUrl())
                .createdAt(categoryEntity.getCreatedAt())
                .updatedAt(categoryEntity.getUpdatedAt())
                .build();
    }


    private CategoryEntity convertToEntity(CategoryRequest request) {

        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description((request.getDescription()))
                .bgColor(request.getBgColor())
                .build();
    }

}
