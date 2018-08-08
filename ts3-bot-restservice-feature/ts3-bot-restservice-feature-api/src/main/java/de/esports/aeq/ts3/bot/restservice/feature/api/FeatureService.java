package de.esports.aeq.ts3.bot.restservice.feature.api;

import de.esports.aeq.ts3.bot.TS3Bot;
import de.esports.aeq.ts3.bot.restservice.feature.api.domain.FeatureConfTa;

/**
 * @author Lukas Kannenberg
 */
public interface FeatureService {

    /**
     * Registers a new feature binder for the specified class.
     * <p>
     * If a feature binder with the same class is already present, the mapping for that class will
     * be replaced.
     *
     * @param binder      the binder to register
     * @param configClass the class of the feature
     */
    <T extends FeatureConfTa> void registerFeatureBinder(FeatureBinder<T> binder,
            Class<T> configClass);

    <T extends FeatureConfTa> FeatureBinder<T> getFeatureBinder(Class<T> configClass);

    /**
     * Binds all active features to the specified bot instance.
     *
     * @param bot the bot instance, not <code>null</code>
     */
    void bindActiveFeatures(TS3Bot bot);

    /**
     * Persists a new feature configuration.
     * <p>
     * If the feature is marked as <i>active</i> and a corresponding bot instance is running, the
     * feature will be registered using a target feature binder.
     *
     * @param confTa the feature configuration, not <code>null</code>
     * @throws FeatureException if the feature configuration is invalid or no particular feature
     *                          binder is present
     */
    void addFeature(FeatureConfTa confTa) throws FeatureException;
}
