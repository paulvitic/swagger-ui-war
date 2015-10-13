package net.vitic.swagger;

public class SwaggerUiException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of VdriveException with an exception message.
     *
     * @param aMessage String describing this exception.
     */
    public SwaggerUiException(String aMessage) {
        super(aMessage);
    }

    /**
     * Creates a new instance of VdriveException with the specified message and
     * cause.
     *
     * @param aMessage String describing this exception.
     * @param aCause   Throwable which represents an underlying problem (or null).
     */
    public SwaggerUiException(String aMessage, Throwable aCause) {
        super(aMessage, aCause);
    }

    /**
     * Creates a new instance of VdriveException with the specified cause.
     *
     * @param aCause Throwable which represents an underlying problem (or null).
     */
    public SwaggerUiException(Throwable aCause) {
        super(aCause);
    }

}
