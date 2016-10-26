package com.openshop.entity;

/**
 * Entity manager.
 *
 * @author Laszlo_Sisa
 */
public interface EntityManager<T> {

    /**
     * Inserts a new entity.
     *
     * @param entityToInsert entity to persist
     * @return id of newly created entity
     */
    String insertEntity(final T entityToInsert, final Class<T> typeParameterClass);

}
