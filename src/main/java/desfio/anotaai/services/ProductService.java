package desfio.anotaai.services;

import desfio.anotaai.domain.category.Category;
import desfio.anotaai.domain.category.excpetions.CategoryNotFoundException;
import desfio.anotaai.domain.product.Product;
import desfio.anotaai.domain.product.ProductDTO;
import desfio.anotaai.domain.product.excptions.ProductNotFoundExcption;
import desfio.anotaai.mapper.ProductMapper;
import desfio.anotaai.repositories.ProductRepository;
import desfio.anotaai.services.aws.AwsSnsService;
import desfio.anotaai.services.aws.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;
    private CategoryService categoryService;
    private AwsSnsService awsSnsService;

    public ProductService(ProductRepository repository, CategoryService categoryService, AwsSnsService awsSnsService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.awsSnsService = awsSnsService;
    }


    public Product create(ProductDTO productDTO){
        this.categoryService.findById(productDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);
        var product = ProductMapper.productDTOToModel(productDTO);

        this.repository.save(product);
        this.awsSnsService.publish(new MessageDTO(product.toString()));

        return product;
    }

    public List<Product> getAll() {
        return this.repository.findAll();
    }

    public Product update(String id, ProductDTO productDTO) {
        var product = this.repository.findById(id).orElseThrow(ProductNotFoundExcption::new);

        if (productDTO.categoryId() != null){
            this.categoryService.findById(productDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);
            product.setCategory(productDTO.categoryId());
        }
        ProductMapper.updateProductFromDTO(productDTO, product);

        this.repository.save(product);
        this.awsSnsService.publish(new MessageDTO(product.toString()));

        return product;
    }

    public void delete(String id) {
        var category = this.repository.findById(id).orElseThrow(ProductNotFoundExcption::new);
        this.repository.delete(category);
    }
}
