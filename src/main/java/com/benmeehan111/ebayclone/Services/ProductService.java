package com.benmeehan111.ebayclone.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benmeehan111.ebayclone.Models.Product;
import com.benmeehan111.ebayclone.Models.ProductCategory;
import com.benmeehan111.ebayclone.Repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductInfoByProductType(Product.ProductType productType) {
        List<Object[]> productInfoList = productRepository.findProductInfoByProductType(productType);
        return mapToProductList(productInfoList);
    }

    private List<Product> mapToProductList(List<Object[]> productInfoList) {
        List<Product> productList = new ArrayList<>();

        for (Object[] productInfo : productInfoList) {
            UUID productId = (UUID) productInfo[0];
            String productName = (String) productInfo[1];
            BigDecimal price = (BigDecimal) productInfo[2];
            Long categoryId = (Long) productInfo[3];
            String categoryName = (String) productInfo[4];

            Product product = new Product();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setPrice(price);
            
            ProductCategory category = new ProductCategory();
            category.setCategoryId(categoryId);
            category.setCategoryName(categoryName);
            product.setCategory(category);

            List<String> productImages = (List<String>) productInfo[5];
            product.setProductImages(productImages);

            productList.add(product);
        }

        return productList;
    }
}
