package pl.edu.pw.ee.mwo_l5.repository;

import org.springframework.stereotype.Repository;
import pl.edu.pw.ee.mwo_l5.exception.ProductNotFoundException;
import pl.edu.pw.ee.mwo_l5.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1L, "Laptop", "Great laptop with top performance", 4400),
        new Product(2L, "Smartphone", "Great smartphone with top performance", 2200),
        new Product(3L, "Keyboard", "Amazing keyboard that will give you insane feeling", 100)
    ));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product updateProduct(Product product) {
        Product toUpdate = products.stream()
                .filter((prod) -> prod.getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        toUpdate.setName(product.getName());
        toUpdate.setDescription(product.getDescription());
        toUpdate.setPrice(product.getPrice());

        return toUpdate;
    }

    public void removeProduct(Long id) {
        products.remove(
                products.stream()
                        .filter((prod)-> prod.getId().equals(id))
                        .findFirst()
                        .orElseThrow(()->new ProductNotFoundException("Product not found"))
        );
    }
}
