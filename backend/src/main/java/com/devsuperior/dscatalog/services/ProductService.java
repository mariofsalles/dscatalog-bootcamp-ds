package com.devsuperior.dscatalog.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest){
		Page<Product> products = productRepository.findAll(pageRequest);
		return products.map( x -> new ProductDTO(x));
	
		/*
			//
			Another way:
			------------
			List<ProductDTO> listProductDto = listProduct
												.stream()
												.map( x -> new ProductDTO(x))
												.collect(Collectors.toList());
			return listProductDto;
			\\
			*
			//
			Another way:
			------------
			List<ProductDTO> listProductDto = new ArrayList<>();
			for(Product x : listProduct) {
				listProductDto.add(new ProductDTO(x));
			}
			return listProductDto;
			\\
		*/				
	}
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		Optional<Product> object = productRepository.findById(id);
		Product entityProduct = object.orElseThrow(
									()-> new ResourceNotFoundException("Entity not Found"));
		return new ProductDTO(entityProduct, entityProduct.getCategories());
	}

	@Transactional
	public ProductDTO insert(ProductDTO productDto) {
		Product entityProduct = new Product();
		copyDtoToEntity(productDto, entityProduct);
		entityProduct = productRepository.save(entityProduct);
		return new ProductDTO(entityProduct);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO productDto) {
		try {
			Product entityProduct = productRepository.getOne(id);
			copyDtoToEntity(productDto, entityProduct);
			entityProduct = productRepository.save(entityProduct);
			return new ProductDTO(entityProduct);		
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+ id);
		}
	}

	public void destroy(Long id) {
		try {
			productRepository.deleteById(id);			
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found");
		}
		catch (DataIntegrityViolationException e){
			throw new DataBaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(ProductDTO productDto, Product entityProduct) {
		entityProduct.setName(productDto.getName());
		entityProduct.setDescription(productDto.getDescription());
		entityProduct.setDate(productDto.getDate());
		entityProduct.setImgUrl(productDto.getImgUrl());
		entityProduct.setPrice(productDto.getPrice());
		
		entityProduct.getCategories().clear();
		for (CategoryDTO categoryDTO : productDto.getCategories()) {
			Category entityCategory = categoryRepository.getOne(categoryDTO.getId());
			entityProduct.getCategories().add(entityCategory);
		}
	}
}



