package de.esports.aeq.ts3.bot.restservice.feature.api.domain;

import javax.persistence.*;

/**
 * Represents an abstract bot feature configuration that may be extended to provide additional
 * details for the concrete feature.
 *
 * @since 1.0
 */
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FeatureConfTa {

    @Id
    @GeneratedValue
    @Column(name = "bot_feature_conf_id")
    private long id;

    @Column
    private long botId;

    @Column
    private boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
