package com.openshop.product.exception;

/**
 * Exception to mark a failure of an operation on with products.
 *
 * @author Laszlo_Sisa
 */
public class ProductOperationFailedException extends RuntimeException {

    public ProductOperationFailedException(final String message) {
        super(message);
    }

}
