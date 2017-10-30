package com.atg.assingment.datacollector.exception;

/**
 * Generic Exception to be used in controller for sending exception to rest api users.
 *
 * @author sakshi
 */
public class ServerException extends Exception {

    public static final String GENERIC_ERROR_MESSAGE = "Something went wrong. Please contact system administrator.";
    private static final long serialVersionUID = -4317904140762138515L;

    /**
     * Constructs a {@code ServerException} with no detail message.
     */
    public ServerException() {
        super(GENERIC_ERROR_MESSAGE);
    }

    /**
     * Constructs a {@code ServerException} with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ServerException(String msg) {
        super(msg);
    }


    /**
     * Creates a new instance of {@code ServerException} from an existed Exception
     *
     * @param ex existing exception
     */
    public ServerException(Exception ex) {
        super(ex);
    }

}
