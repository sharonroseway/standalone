package cd.exalt.standlone.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cd.exalt.standlone.models.Product;
import cd.exalt.standlone.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product){
		if(product.getUuid() == null) {
			product.setUuid(UUID.randomUUID().toString());
		}
		return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<Product> findNyUuid(@PathVariable("uuid")String uuid){
		System.out.println("UUID: " + uuid);
		return new ResponseEntity<Product>(productRepository.findByUuid(uuid), HttpStatus.OK);
	}
}
