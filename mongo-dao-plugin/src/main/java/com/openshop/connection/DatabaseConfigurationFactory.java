package com.openshop.connection;

/**
 * Factory for creating a {@link DatabaseConfiguration}.
 *
 * @author Laszlo_Sisa
 */
public class DatabaseConfigurationFactory {

    private final String databaseName;
    private final String hostName;
    private final int connectionPort;

    /**
     * DI constructor.
     *
     * @param databaseName database name
     * @param hostName host name
     * @param connectionPort connection port
     */
    public DatabaseConfigurationFactory(final String databaseName, final String hostName, final int connectionPort) {
        this.databaseName = databaseName;
        this.hostName = hostName;
        this.connectionPort = connectionPort;
    }

    /**
     * Creates a new {@link DatabaseConfiguration} instance.
     *
     * @return {@link DatabaseConfiguration}
     */
    public DatabaseConfiguration createConfiguration() {
        return new DatabaseConfiguration.Builder().withDatabaseName(databaseName).withHostName(hostName).withConnectionPort(connectionPort).build();
    }
}
