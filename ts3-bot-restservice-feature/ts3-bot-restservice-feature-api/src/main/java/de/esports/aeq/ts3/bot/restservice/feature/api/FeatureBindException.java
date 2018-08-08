package de.esports.aeq.ts3.bot.restservice.feature.api;

/**
 * Signals that a feature cannot be bound to an existing bot instance.
 */
public class FeatureBindException extends FeatureException {

    public FeatureBindException() {
        super();
    }

    public FeatureBindException(String message) {
        super(message);
    }

    public FeatureBindException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeatureBindException(Throwable cause) {
        super(cause);
    }
}
