package com.openshop.product.exception;

/**
 * Exception to mark failure operation made on a component.
 *
 * @author Laszlo_Sisa
 */
public class ComponentOperationFailedException extends RuntimeException {

    public ComponentOperationFailedException(final Throwable cause) {
        super(cause);
    }
}
