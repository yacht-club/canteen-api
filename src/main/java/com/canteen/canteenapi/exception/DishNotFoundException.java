package com.canteen.canteenapi.exception;

public class DishNotFoundException extends RuntimeException {

    public DishNotFoundException() {
    }

    public DishNotFoundException(String message) {
        super(message);
    }

    public DishNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DishNotFoundException(Throwable cause) {
        super(cause);
    }

    public DishNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
