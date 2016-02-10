package com.chalienko.hr.dao;

/**
 * Created by Chalienko on 08.02.2016.
 */
public class DAOException extends Exception {
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException() {
    }
}
