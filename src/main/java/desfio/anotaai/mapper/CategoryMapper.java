package desfio.anotaai.mapper;

import desfio.anotaai.domain.category.Category;
import desfio.anotaai.domain.category.CategoryDTO;

public class CategoryMapper{

    public static Category categoryDTOToModel(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setDescription(categoryDTO.description());
        category.setTitle(categoryDTO.title());
        category.setOwnerId(categoryDTO.ownerId());

        return category;
    }

    public static void updateCategoryFromDTO(CategoryDTO categoryDTO, Category category) {
        category.setDescription(categoryDTO.description());
        category.setTitle(categoryDTO.title());
        category.setOwnerId(categoryDTO.ownerId());

    }
}
