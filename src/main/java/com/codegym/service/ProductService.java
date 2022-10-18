package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "apple",10, "good", "HaNoi"));
        products.put(2, new Product(2,"orange",12, "good", "DaNang"));
        products.put(3, new Product(3,"banana",34, "good", "DaNang"));
        products.put(4, new Product(4,"food",43, "good", "DaNang"));
        products.put(5, new Product(5,"meet",21, "good", "DaNang"));
        products.put(6, new Product(6,"drink",62, "good", "DaNang"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList1=new ArrayList<>(products.values());
        List<Product> productList =new ArrayList<>();
        for (Product product: productList1) {
            if(product.getName().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }
}