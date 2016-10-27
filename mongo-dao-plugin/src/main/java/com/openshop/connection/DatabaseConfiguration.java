package com.openshop.connection;

import static com.openshop.validation.Validation.hasText;
import static com.openshop.validation.Validation.notNull;

/**
 * Encapsulating all required configuration data to connect to the database.
 *
 * @author Laszlo_Sisa
 */
public final class DatabaseConfiguration {

    private final String databaseName;
    private final String hostName;
    private final int connectionPort;

    private DatabaseConfiguration(final Builder builder) {
        databaseName = builder.databaseName;
        hostName = builder.hostName;
        connectionPort = builder.connectionPort;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getHostName() {
        return hostName;
    }

    public int getConnectionPort() {
        return connectionPort;
    }

    /**
     * Builder for {@link DatabaseConfiguration}.
     */
    public static class Builder {

        private String databaseName;
        private String hostName;
        private Integer connectionPort;

        public Builder withDatabaseName(final String databaseName) {
            this.databaseName = databaseName;
            return this;
        }

        public Builder withHostName(final String hostName) {
            this.hostName = hostName;
            return this;
        }

        public Builder withConnectionPort(final int connectionPort) {
            this.connectionPort = connectionPort;
            return this;
        }

        public DatabaseConfiguration build() {
            validate();
            return new DatabaseConfiguration(this);
        }

        private void validate() {
            hasText(databaseName, "databaseName can't be empty!");
            hasText(hostName, "hostname can't be empty!");
            notNull(connectionPort, "connectionPort can't be null!");
        }

    }

}
