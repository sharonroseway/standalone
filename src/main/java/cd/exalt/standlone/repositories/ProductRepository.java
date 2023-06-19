package cd.exalt.standlone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cd.exalt.standlone.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findByUuid(String uuid);
}
