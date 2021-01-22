package com.devsuperior.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.DataBaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> listCategory = categoryRepository.findAll();
		return listCategory.stream().map( x -> new CategoryDTO(x)).collect(Collectors.toList());
	
		/*
			//
			Another way:
			------------
			List<CategoryDTO> listCategoryDto = listCategory
												.stream()
												.map( x -> new CategoryDTO(x))
												.collect(Collectors.toList());
			return listCategoryDto;
			\\
			*
			//
			Another way:
			------------
			List<CategoryDTO> listCategoryDto = new ArrayList<>();
			for(Category x : listCategory) {
				listCategoryDto.add(new CategoryDTO(x));
			}
			return listCategoryDto;
			\\
		*/				
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> object = categoryRepository.findById(id);
		Category entityCategory = object.orElseThrow(
									()-> new ResourceNotFoundException("Entity not Found"));
		return new CategoryDTO(entityCategory);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO categoryDto) {
		Category entityCategory = new Category();
		entityCategory.setName(categoryDto.getName());
		entityCategory = categoryRepository.save(entityCategory);
		return new CategoryDTO(entityCategory);
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryDTO categoryDto) {
		try {
			Category entityCategory = categoryRepository.getOne(id);
			entityCategory.setName(categoryDto.getName());
			entityCategory = categoryRepository.save(entityCategory);
			return new CategoryDTO(entityCategory);		
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+ id);
		}
	}

	public void destroy(Long id) {
		try {
			categoryRepository.deleteById(id);			
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found");
		}
		catch (DataIntegrityViolationException e){
			throw new DataBaseException("Integrity violation");
		}
	}
}



