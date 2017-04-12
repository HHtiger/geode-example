package com.founder.geode.server;

import jline.console.ConsoleReader;
import org.apache.geode.distributed.LocatorLauncher;
import org.apache.geode.distributed.ServerLauncher;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TestGeodeServer {

    private static Logger logger = LoggerFactory.getLogger(TestGeodeServer.class);

    @Test
    public void startLocator() throws InterruptedException, IOException {
        LocatorLauncher locatorLauncher = new LocatorLauncher.Builder()
                .setMemberName("locator1")
                .setPort(10334)
                .build();

        locatorLauncher.start();

        ConsoleReader reader = new ConsoleReader();

        reader.readLine("waiting for test");

    }

    @Test
    public void startServer() throws InterruptedException, IOException {
        System.setProperty("gemfirePropertyFile", "gfserver.properties");
        ServerLauncher serverLauncher  = new ServerLauncher.Builder()
                .setMemberName("server1")
                .set("jmx-manager", "true")
                .set("jmx-manager-start", "true")
                .build();

        serverLauncher.start();

        ConsoleReader reader = new ConsoleReader();

        reader.readLine("waiting for test");
    }
}