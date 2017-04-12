package com.founder.geode.client.initializer;

import com.founder.geode.client.listener.MyCacheListener1;
import org.apache.geode.cache.Declarable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by tiger on 2017/2/7.
 */
public class MyInitializer implements Declarable {

    private static Logger logger = LoggerFactory.getLogger(MyInitializer.class);

    public void init(Properties properties) {
        logger.debug(properties.getProperty("members"));
    }
}
