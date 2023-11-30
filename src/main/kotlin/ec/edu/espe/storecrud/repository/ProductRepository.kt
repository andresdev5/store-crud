package ec.edu.espe.storecrud.repository

import ec.edu.espe.storecrud.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long> {}