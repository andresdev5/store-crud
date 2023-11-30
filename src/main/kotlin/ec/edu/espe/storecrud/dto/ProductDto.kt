package ec.edu.espe.storecrud.dto

import ec.edu.espe.storecrud.entity.Product
import ec.edu.espe.storecrud.entity.User
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime

data class ProductDto(
    var id: Long? = null,

    @field:NotNull
    @field:NotBlank
    var name: String? = null,

    @field:NotNull
    @field:NotBlank
    var description: String? = null,

    @field:NotNull
    @field:Min(0)
    var price: Double? = 0.0,

    @field:NotNull
    @field:Min(0)
    var stock: Int? = 0,

    var createdAt: LocalDateTime? = LocalDateTime.now(),
    var updatedAt: LocalDateTime? = LocalDateTime.now(),
)

fun ProductDto.toEntity(user: User): Product {
    return Product(
        id = this.id ?: 0,
        name = this.name ?: "",
        description = this.description ?: "",
        price = this.price ?: 0.0,
        stock = this.stock ?: 0,
        createdAt = this.createdAt ?: LocalDateTime.now(),
        updatedAt = this.updatedAt ?: LocalDateTime.now(),
        user = user
    )
}