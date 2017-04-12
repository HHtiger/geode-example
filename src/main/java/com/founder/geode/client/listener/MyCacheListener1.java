package com.founder.geode.client.listener;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by tiger on 2017/2/7.
 */
public class MyCacheListener1 extends CacheListenerAdapter implements Declarable {

    private static Logger logger = LoggerFactory.getLogger(MyCacheListener1.class);

    @Override
    public void init(Properties props) {

    }

    @Override
    public void afterCreate(EntryEvent event) {
        logger.debug("MyCacheListener1 afterCreate , class : {} , key : {}.",event.getNewValue().getClass(),event.getKey());
    }
}
