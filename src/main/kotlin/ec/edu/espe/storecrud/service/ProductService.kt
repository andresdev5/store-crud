package ec.edu.espe.storecrud.service

import ec.edu.espe.storecrud.config.toUser
import ec.edu.espe.storecrud.dto.ProductDto
import ec.edu.espe.storecrud.dto.toEntity
import ec.edu.espe.storecrud.entity.Product
import ec.edu.espe.storecrud.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun getProducts(): List<Product> {
        return productRepository.findAll().toList();
    }

    fun getProduct(id: Long): Product {
        return productRepository.findById(id).get();
    }

    fun saveProduct(product: ProductDto): Product {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val user = authentication.toUser()
        return productRepository.save(product.toEntity(user));
    }

    fun updateProduct(product: ProductDto, id: Long): Product {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val user = authentication.toUser()
        val newProduct = product.toEntity(user)
        val oldProduct = productRepository.findById(id).orElse(null)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")
        val allowedToUpdate = oldProduct.user.id == user.id || user.role.name == "ADMIN"

        if (!allowedToUpdate) {
            throw ResponseStatusException(HttpStatus.FORBIDDEN, "You are not allowed to update this product")
        }

        newProduct.id = id
        newProduct.user = oldProduct.user
        newProduct.name = product.name ?: oldProduct.name
        newProduct.description = product.description ?: oldProduct.description
        newProduct.price = product.price ?: oldProduct.price
        newProduct.stock = product.stock ?: oldProduct.stock
        newProduct.createdAt = oldProduct.createdAt
        newProduct.updatedAt = LocalDateTime.now()

        return productRepository.save(newProduct);
    }

    fun deleteProduct(id: Long) {
        productRepository.deleteById(id);
    }
}