package desfio.anotaai.services;

import desfio.anotaai.domain.category.Category;
import desfio.anotaai.domain.category.CategoryDTO;
import desfio.anotaai.domain.category.excpetions.CategoryNotFoundException;
import desfio.anotaai.mapper.CategoryMapper;
import desfio.anotaai.repositories.CategoryRespository;
import desfio.anotaai.services.aws.AwsSnsService;
import desfio.anotaai.services.aws.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRespository respository;
    private AwsSnsService awsSnsService;

    public CategoryService(CategoryRespository respository, AwsSnsService awsSnsService) {
        this.respository = respository;
        this.awsSnsService = awsSnsService;
    }

    public Category create(CategoryDTO categoryDTO){
        var category = CategoryMapper.categoryDTOToModel(categoryDTO);
        category = this.respository.save(category);

        this.awsSnsService.publish(new MessageDTO(category.toString()));

        return category;
    }

    public List<Category> getAll() {
        return this.respository.findAll();
    }

    public Category update(String id, CategoryDTO categoryDTO) {
        var category = this.respository.findById(id).orElseThrow(CategoryNotFoundException::new);
        CategoryMapper.updateCategoryFromDTO(categoryDTO, category);
        category = this.respository.save(category);

        this.awsSnsService.publish(new MessageDTO(category.toString()));

        return category;
    }

    public void delete(String id) {
        var category = this.respository.findById(id).orElseThrow(CategoryNotFoundException::new);
        this.respository.delete(category);
    }

    public Optional<Category> findById(String id){
        return this.respository.findById(id);
    }
}
