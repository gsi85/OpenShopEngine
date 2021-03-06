package com.openshop.product.service;

import java.util.List;

import com.openshop.filer.EntityFilter;
import com.openshop.product.domain.Component;
import com.openshop.product.exception.ComponentOperationFailedException;

/**
 * Service for manipulating components.
 *
 * @author Laszlo_Sisa
 */
public interface ComponentService {

    Component upsertComponent(final Component component) throws ComponentOperationFailedException, IllegalArgumentException;

    List<Component> findComponents(final EntityFilter filter) throws ComponentOperationFailedException, IllegalArgumentException;

    boolean deleteComponent(final Component component) throws ComponentOperationFailedException, IllegalArgumentException;

}
