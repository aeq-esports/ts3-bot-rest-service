package de.esports.aeq.ts3.bot.restservice.feature.api;

/**
 * Exception thrown to indicate that an operation on a feature configuration failed.
 */
public class FeatureException extends RuntimeException {

    public FeatureException() {

    }

    public FeatureException(String message) {
        super(message);
    }

    public FeatureException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeatureException(Throwable cause) {
        super(cause);
    }
}
