package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.InputProduct;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.InputProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.InputProductRepository;
import uz.pdp.appwarehouse.repository.InputRepository;
import uz.pdp.appwarehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;
    public Result add(InputProductDto inputProductDto){
        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found", false);
        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (!optionalInput.isPresent())
            return new Result("Input not found",false);

        InputProduct inputProduct = new InputProduct();
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalInput.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());
        inputProductRepository.save(inputProduct);
        return new Result("Saved input product", true);
    }

    public List<InputProduct> getAll(){
        List<InputProduct> allInputProduct = inputProductRepository.findAll();
        return allInputProduct;
    }

    public Result update(Integer id, InputProductDto inputProductDto){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent())
            return new Result("Input product not found", false);
        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInputId());
        if (!optionalInput.isPresent())
            return new Result("Input not found", false);
        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found", false);

        InputProduct upInputProduct = optionalInputProduct.get();
        upInputProduct.setProduct(optionalProduct.get());
        upInputProduct.setInput(optionalInput.get());
        upInputProduct.setAmount(inputProductDto.getAmount());
        upInputProduct.setPrice(inputProductDto.getPrice());
        upInputProduct.setExpireDate(inputProductDto.getExpireDate());
        inputProductRepository.save(upInputProduct);
        return new Result("Updated input product", true);

    }

    public Result delete(Integer id){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isPresent()){
            inputProductRepository.deleteById(id);
            return new Result("Deleted input product", true);
        }
        return new Result("Input product not found", false);
    }
}
