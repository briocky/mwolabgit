package pl.edu.pw.ee.mwo_l5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.ee.mwo_l5.model.Product;
import pl.edu.pw.ee.mwo_l5.repository.ProductRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.getAllProducts();

        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        product.setId(System.currentTimeMillis());
        productRepository.addProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product productToEdit = productRepository.getAllProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("product", productToEdit);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product updatedProduct) {
        productRepository.updateProduct(updatedProduct);
        return "redirect:/products/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.removeProduct(id);
        return "redirect:/products/all";
    }
}
