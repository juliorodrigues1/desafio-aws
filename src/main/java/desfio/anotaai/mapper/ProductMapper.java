package desfio.anotaai.mapper;

import desfio.anotaai.domain.product.Product;
import desfio.anotaai.domain.product.ProductDTO;

public class ProductMapper {


    public static Product productDTOToModel(ProductDTO productDTO){
        Product product = new Product();
        product.setTitle(productDTO.title());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        product.setOwnerId(productDTO.ownerId());
        product.setCategory(productDTO.categoryId());

        return product;
    }

    public static void updateProductFromDTO(ProductDTO productDto, Product product) {

        product.setDescription(productDto.description());
        product.setPrice(productDto.price());
        product.setOwnerId(productDto.ownerId());
    }
}
