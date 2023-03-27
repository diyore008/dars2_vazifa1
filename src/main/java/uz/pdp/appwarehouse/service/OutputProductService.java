package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.entity.OutputProduct;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.OutputProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.OutputProductRepository;
import uz.pdp.appwarehouse.repository.OutputRepository;
import uz.pdp.appwarehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {

    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;
    public Result add(OutputProductDto outputProductDto){
        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found", false);
        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent())
            return new Result("Output not found", false);

        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProduct.setOutput(optionalOutput.get());
        outputProductRepository.save(outputProduct);
        return new Result("Saved output product", true);
    }

    public List<OutputProduct> getAll(){
        List<OutputProduct> allOutputProduct = outputProductRepository.findAll();
        return allOutputProduct;
    }

    public Result update(Integer id, OutputProductDto outputProductDto){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent())
            return new Result("Output Product not found", false);
        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProductId());
        if (!optionalProduct.isPresent())
            return new Result("Product not found", false);
        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutputId());
        if (!optionalOutput.isPresent())
            return new Result("Output not found", false);

        OutputProduct outputProduct = optionalOutputProduct.get();
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProduct.setOutput(optionalOutput.get());
        outputProductRepository.save(outputProduct);
        return new Result("Save output product", true);
    }

    public Result delete(Integer id){
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (optionalOutputProduct.isPresent()){
            outputProductRepository.deleteById(id);
            return new Result("Deleted output product", true);
        }
        return new Result("Output product not found", false);
    }

}
