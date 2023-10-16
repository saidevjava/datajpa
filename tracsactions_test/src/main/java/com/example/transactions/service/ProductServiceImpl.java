package com.example.transactions.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.transactions.entity.Product;
import com.example.transactions.exceptions.ProductNotFoundException;
import com.example.transactions.exceptions.ProductStockNotAvailableException;
import com.example.transactions.repository.ProductRepository;
import org.springframework.transaction.TransactionStatus;

//import jakarta.transaction.Transactional;
//import jakarta.transaction.Transactional.TxType;

@Service
public class ProductServiceImpl implements IProductService {

	private ProductRepository productRepository;
	
	  @Autowired
	  private PlatformTransactionManager transactionManager;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Product> fetchProductList() {
		return productRepository.findAll();
	}

	@Override
	//@Transactional(value = TxType.NEVER)
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.MANDATORY)
	public boolean updateProduct(String productId, int stock) {
		boolean isUpdated = false;
		Product product = productRepository.findByProductId(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product is not available"));
		if (product.getStockCount() < stock) {
			throw new ProductStockNotAvailableException("Out of stock");
		}
		product.setStockCount(product.getStockCount() - stock);
		productRepository.save(product);
		isUpdated = true;
		return isUpdated;
	}
	
	@Override
	 public void manuallyManageTransaction() {
	        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	        //def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
	        //def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

	        TransactionStatus status = transactionManager.getTransaction(def);

	        try {
	        	Product product = new Product();
	        	product.setProductId(UUID.randomUUID().toString());
	        	product.setProductName("Dell");
	        	productRepository.save(product);
	        	transactionManager.commit(status);
	        	
	        } catch (Exception e) {
	            transactionManager.rollback(status);
	        }
	    }

}
