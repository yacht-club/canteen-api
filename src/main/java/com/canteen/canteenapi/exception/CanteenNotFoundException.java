package com.canteen.canteenapi.exception;

public class CanteenNotFoundException extends RuntimeException {

    public CanteenNotFoundException() {
        super();
    }

    public CanteenNotFoundException(String message) {
        super(message);
    }
}
