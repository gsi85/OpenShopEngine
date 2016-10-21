package com.openshop.product.alter;

import com.openshop.product.domain.Component;

/**
 * Context object containing information necessary to alter components.
 *
 * @author Laszlo_Sisa
 */
public final class AlterComponentRequestContext {

    private final Component componentToAlter;

    public AlterComponentRequestContext(final Component componentToAlter) {
        this.componentToAlter = componentToAlter;
    }

    public Component getComponentToAlter() {
        return componentToAlter;
    }
}
