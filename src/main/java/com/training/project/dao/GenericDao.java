package com.training.project.dao;

import java.util.List;

/**
 * Generic DAO interface that provides standard CRUD operations for all Models
 * 
 * @param <T> Entity type
 * @param <ID> Primary key type (Integer, Long, String, etc.)
 */
public interface GenericDao<T, ID> {
    /**
     * Retrieve an entity by its ID
     * @param id Entity identifier
     * @return The entity or null if not found
     */
    T findById(ID id);
    
    /**
     * Retrieve all entities
     * @return List of all entities
     */
    List<T> findAll();
    
    /**
     * Save a new entity
     * @param entity Entity to save
     * @return True if successful, false otherwise
     */
    boolean create(T entity);
    
    /**
     * Update an existing entity
     * @param entity Entity to update
     * @return True if successful, false otherwise
     */
    boolean update(T entity);
    
    /**
     * Delete an entity by ID
     * @param id Entity identifier
     * @return True if successful, false otherwise
     */
    boolean deleteById(ID id);
    
    /**
     * Delete an entity
     * @param entity Entity to delete
     * @return True if successful, false otherwise
     */
    boolean delete(T entity);
    
    /**
     * Count total number of entities
     * @return Total count
     */
    long count();
    
    /**
     * Check if an entity with the given ID exists
     * @param id Entity identifier
     * @return True if entity exists, false otherwise
     */
    boolean exists(ID id);
}
