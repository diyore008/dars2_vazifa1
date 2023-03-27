package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.AttachmentRepository;
import uz.pdp.appwarehouse.repository.CategoryRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;
import uz.pdp.appwarehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    public Result addProduct(ProductDto productDto){
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId)
            return new Result("This product already exists in this category", false);

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Category not found", false);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("Photo not found", false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Measurement not found", false);

        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode("1");
        product.setCategory(optionalCategory.get());
        product.setAttachment(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("Saved product", true);
    }

    public List<Product> getAll(){
        List<Product> allProduct = productRepository.findAll();
        return allProduct;
    }

    public Result update(Integer id, ProductDto productDto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("Product not found", false);

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new Result("Category not found", false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent())
            return new Result("Measurement not found", false);

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalAttachment.isPresent())
            return new Result("Attachment not found", false);
        String s = UUID.randomUUID().toString();
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setCode(s);
        product.setCategory(optionalCategory.get());
        product.setAttachment(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        productRepository.save(product);
        return new Result("Update product", true);
    }

    public Result delete(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return new Result("Deleted product",true );
        }
        return new Result("Product not found", false);
    }
}
