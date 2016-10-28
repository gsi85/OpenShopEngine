package com.openshop.dao;

import java.util.List;

import com.openshop.domain.IdentifiableEntity;
import com.openshop.product.service.retrieve.RetrieveEntityRequestContext;

/**
 * @author Laszlo_Sisa
 */
public interface EntityDao<TYPE extends IdentifiableEntity> {

    TYPE upsertEntity(final TYPE entity, final Class<TYPE> entityTypeClass);

    List<TYPE> retrieveEntities(final RetrieveEntityRequestContext context, final Class<TYPE> entityTypeClass);

    boolean deleteEntity(final TYPE entity, final Class<TYPE> entityTypeClass);

}
