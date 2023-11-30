package ec.edu.espe.storecrud.controller

import ec.edu.espe.storecrud.dto.ProductDto
import ec.edu.espe.storecrud.entity.Product
import ec.edu.espe.storecrud.service.ProductService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ProductsController(private val productService: ProductService) {
    @GetMapping("/products")
    fun getProducts(): List<Product> {
        return productService.getProducts()
    }

    @GetMapping("/products/{id}")
    fun getProduct(@PathVariable id: Long): Product {
        return productService.getProduct(id)
    }

    @PostMapping("/products")
    fun saveProduct(@RequestBody @Valid product: ProductDto): Product {
        return productService.saveProduct(product)
    }

    @PutMapping("/product/{id}")
    fun updateProduct(@RequestBody product: ProductDto, @PathVariable id: Long): Product {
        return productService.updateProduct(product, id)
    }

    @DeleteMapping("/admin/products/{id}")
    fun deleteProduct(@PathVariable id: Long) {
        productService.deleteProduct(id)
    }
}