package in.gokul.billingsoftware.controller;

import in.gokul.billingsoftware.io.CategoryRequest;
import in.gokul.billingsoftware.io.CategoryResponse;
import in.gokul.billingsoftware.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import software.amazon.awssdk.thirdparty.jackson.core.JsonProcessingException;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestPart("category") String categoryString,
                                        @RequestPart("file")MultipartFile file) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CategoryRequest request = null;

        request = objectMapper.readValue(categoryString,CategoryRequest.class);
        return categoryService.add(request,file);
    }

    @GetMapping("/{name}")
    public CategoryResponse retrieveCategory(@PathVariable String name){
        return categoryService.findByName(name);
    }

    @GetMapping
    public List<CategoryResponse> retrieveCategory(){
        return categoryService.retrieve();
    }

    @DeleteMapping("/{categoryid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable String categoryid){
        try {
            categoryService.delete(categoryid);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }

    }
}
