package de.esports.aeq.ts3.bot.restservice.feature.api;

import de.esports.aeq.ts3.bot.TS3Bot;
import de.esports.aeq.ts3.bot.restservice.feature.api.domain.FeatureConfTa;

/**
 * This interface maps configurations to existing bot functions.
 * <p>
 * Each feature binder can map either one concrete configuration or a superclass of multiple
 * configurations. Please note that there can only exist one feature binder per concrete
 *
 * @param <T> the feature configuration type
 * @since 1.0
 */
public interface FeatureBinder<T extends FeatureConfTa> {

    /**
     * Binds a particular configuration to a bot instance.
     * <p>
     * This method is executed each time a feature configuration of the given <code>type</code>
     * should be bound to the particular <code>bot</code> instance.
     *
     * @param bot    the bot instance, not <code>null</code>
     * @param config the configuration, not <code>null</code>
     * @throws FeatureBindException if the feature cannot be bound
     * @implSpec Any implementation should ensure that a feature which reflects the given
     * configuration is added to the bot instance. If the feature cannot be added, a {@link
     * FeatureBindException} must be thrown.
     */
    void bind(TS3Bot bot, T config) throws FeatureBindException;

    /**
     * Unbinds a particular configuration from a bot instance.
     * <p>
     * This method is executed each time a feature configuration of the particular
     * <code>bot</code> instance and the given <code>type</code> should be unbound.
     * <p>
     * The default implementation of this method acts as a <i>no-operation</i> and should be
     * overridden if needed.
     *
     * @param bot    the bot instance, not <code>null</code>
     * @param config the configuration, not <code>null</code>
     * @throws FeatureBindException if the feature cannot be unbound
     * @implSpec Any implementation should ensure that the feature which reflects the given
     * configuration is removed from the bot instance. If the feature cannot be removed, a {@link
     * FeatureBindException} must be thrown.
     */
    @SuppressWarnings("unused")
    void unbind(TS3Bot bot, T config) throws FeatureBindException;

    /**
     * Updates a particular configuration bound to a bot instance.
     * <p>
     * This method is executed each time a feature configuration of the particular
     * <code>bot</code> instance and the given <code>type</code> should be updated.
     * <p>
     * By default this method calls {@link #unbind(TS3Bot, FeatureConfTa)} followed by {@link
     * #bind(TS3Bot, FeatureConfTa)}.
     *
     * @param bot       the bot instance, not <code>null</code>
     * @param oldConfig the old configuration, not <code>null</code>
     * @param newConfig the new configuration, not <code>null</code>
     * @throws FeatureBindException if the feature cannot be updated
     * @implSpec Any implementation should ensure that the feature which reflects the old
     * configuration of the bot instance is updated to match the requirements specified by the new
     * configuration. If the feature cannot be updated, a {@link FeatureBindException} must be
     * thrown.
     */
    @SuppressWarnings("unused")
    default void update(TS3Bot bot, T oldConfig, T newConfig) throws FeatureBindException {
        unbind(bot, oldConfig);
        bind(bot, newConfig);
    }
}
