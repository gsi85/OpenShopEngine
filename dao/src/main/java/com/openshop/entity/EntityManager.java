package com.openshop.entity;

import com.openshop.domain.IdentifiableEntity;

/**
 * Entity manager.
 *
 * @author Laszlo_Sisa
 */
public interface EntityManager<T extends IdentifiableEntity> {

    /**
     * Inserts a new entity.
     *
     * @param entityToInsert entity to persist
     * @param typeParameterClass type parameter class
     * @return persisted entity with it's id
     */
    T insertEntity(final T entityToInsert, final Class<T> typeParameterClass);

    /**
     * Finds an entity by it's unique id.
     *
     * @param id to find
     * @param typeParameterClass type parameter class
     * @return the entity if exists, null otherwise
     */
    T findById(final String id, final Class<T> typeParameterClass);

    /**
     * Updates an existing entity using it's id to identify.
     *
     * @param entity entity to update
     * @param typeParameterClass type parameter class
     * @return updated entity
     */
    T updateEntry(T entity, final Class<T> typeParameterClass);

    /**
     * Deletes an entity based on it's id.
     *
     * @param entity entity to delete
     * @param typeParameterClass type parameter class
     * @return true if deletion was successful
     */
    boolean deleteEntity(T entity, Class<T> typeParameterClass);
}
