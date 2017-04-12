package com.founder.geode.client.listener;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.asyncqueue.AsyncEvent;
import org.apache.geode.cache.asyncqueue.AsyncEventListener;
import org.apache.geode.pdx.PdxInstance;

import java.util.List;
import java.util.Properties;

/**
 * Created by tiger on 2017/2/7.
 */
public class MyAsyncListener2 implements AsyncEventListener,Declarable {

    @Override
    public void init(Properties props) {

    }

    @Override
    public boolean processEvents(List<AsyncEvent> events) {
        for (AsyncEvent event : events) {
            final Operation op = event.getOperation();
            Object value = event.getDeserializedValue();
            if (!(value instanceof PdxInstance)) {
                continue;
            }
            if (op.isCreate()) {
                System.out.println("isCreate");
            } else if (op.isUpdate()) {
                System.out.println("isCreate");
            }
        }
        return true;
    }

    @Override
    public void close() {

    }
}
