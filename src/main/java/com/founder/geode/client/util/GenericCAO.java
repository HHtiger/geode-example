package com.founder.geode.client.util;
/*
<cache>
<cache-server>
	<client-subscription eviction-policy="mem" capacity="1"/>
</cache-server>
</cache>

<cache-server port="40404">
<client-subscription eviction-policy="entry"
capacity="10000" disk-store-name="queueOverflow2"/>
<client-subscription eviction-policy="entry" capacity="10000"/>
</cache-server>

Bulk loading during registration 
You can request an initial bulk load for your interest registration using the InterestResultPolicy parameter. If a bulk load is requested, all available entries that satisfy the interest registered are immediately sent from the server to the client region before control is returned to the calling method. If the server region is partitioned, the entire partitioned region is used in the bulk load. If the server region is distributed, only the server��s local cache region is used. The interest results policy options are: 
��  KEYS��The client receives a bulk load of all available keys matching the interest registration criteria.  
��  KEYS_VALUES��The client receives a bulk load of all available keys and values matching the interest registration criteria. This is the default interest result policy.  
��  NONE��The client does not receive any immediate bulk loading.  

 	<gfe:client-region id="CustomerRegion" shortcut="PROXY">
		<gfe:cache-listener>
			<bean class="com.gfdemo.listener.DemoCacheListener"/>
		</gfe:cache-listener>
<!--
key_ref="ALL_KEYS" receive-values="true"

        <gfe:key-interest durable="false" result-policy="KEYS">
            <bean id="key" class="java.lang.String">
                 <constructor-arg value="someKey" /> 
            </bean>
        </gfe:key-interest>
        <gfe:regex-interest pattern=".*" receive-values="true" result-policy="NONE"/>
--> 		
 	</gfe:client-region>
 */

import com.founder.geode.client.exception.GeodeServiceException;
import org.apache.geode.cache.AttributesMutator;
import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.InterestResultPolicy;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;
import org.apache.geode.cache.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericCAO {

    // 501053004:注册主键失败。Region：{0}
    // 501053005:注销主键失败。Region：{0}
    // 501053006:注册连续查询失败。CqName:{0}
    // 501053007:注销连续查询失败。CqName:{0}
    // 501053008:调用函数失败。Function:{0}
    // 501053009:执行OQL语句失败。OQL:{0}

    private static Logger log = LoggerFactory.getLogger(GenericCAO.class);
    public static boolean traceFlg = false;

    // Using 'ALL_KEYS' is the same as calling registerInterestRegex(String)
    // with ".*" as the argument.
    // This means that all keys any type are pushed to the client and inserted
    // into the local cache.
    public static void registerInterest(String regionName, String regex,
                                        List keyList, CacheListener mylistner) {
        boolean isDurable = false;
        boolean receiveValues = true;
        try {
            ClientCache cache = ClientCacheFactory.getAnyInstance();
            Region region = cache.getRegion(regionName);
            if (region == null) {
                region = cache.createClientRegionFactory(
                        ClientRegionShortcut.PROXY).create(regionName);
            }
            if (mylistner != null) {
                AttributesMutator mutator = region.getAttributesMutator();
                mutator.addCacheListener(mylistner);
            }

            if (regex != null) {
                region.registerInterestRegex(regex, isDurable, receiveValues);
            } else if (keyList != null) {
                for (Object key : keyList)
                    region.registerInterest(key,
                            InterestResultPolicy.KEYS_VALUES, isDurable,
                            receiveValues);
            }
            // cache.readyForEvents();
        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = regionName + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("501053004", msg);
        }

    }

    public static void unRegisterInterest(String regionName, String regex,
                                          List keyList) {
        try {
            ClientCache cache = ClientCacheFactory.getAnyInstance();
            Region region = cache.getRegion(regionName);
            if (region == null) {
                region = cache.createClientRegionFactory(
                        ClientRegionShortcut.PROXY).create(regionName);
            }
            if (regex != null) {
                region.unregisterInterestRegex(regex);
            } else if (keyList != null) {
                for (Object key : keyList)
                    region.unregisterInterest(key);
            }
        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = regionName + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("501053005", msg);
        }

    }

    // CqListener
    public static void registerCq(String cqName, String oqlclause,
                                  CqListener mylistner) {
        try {
            ClientCache cache = ClientCacheFactory.getAnyInstance();
            QueryService queryService = cache.getQueryService();

            CqAttributesFactory cqf = new CqAttributesFactory();
            if (mylistner != null) {

                // cqf.addCqListener(mylistner);

                CqListener[] cqListeners = {mylistner};
                cqf.initCqListeners(cqListeners);
            }

            CqAttributes cqa = cqf.create();

            CqQuery cq = queryService.newCq(cqName, oqlclause, cqa);
            // cache.readyForEvents();

            cq.executeWithInitialResults();// executeWithInitialResults
            // //execute

        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = cqName + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("501053006", msg);
        }
    }

    public static void unRegisterCq(String cqName) {
        try {
            ClientCache cache = ClientCacheFactory.getAnyInstance();
            QueryService queryService = cache.getQueryService();
            CqQuery cq = queryService.getCq(cqName);
            if (cq == null)
                return;
            cq.close();
        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = cqName + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("501053007", msg);
        }
    }

    public static List<Map> callFunction(String funcName, Map inputParam,
                                         boolean isOnServers) {
        try {
            ClientCache cache = ClientCacheFactory.getAnyInstance();
            Execution ext;
            if (isOnServers) {
                ext = FunctionService.onServers(cache.getDefaultPool());
            } else {
                ext = FunctionService.onServer(cache.getDefaultPool());
            }
            if (inputParam != null) {
                ext = ext.withArgs(inputParam);
            }

            ResultCollector rc = ext.execute(funcName);
            List<Map> result_list = (List<Map>) rc.getResult();
            return result_list;
        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = funcName + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("501053008", msg);
        }
    }

    public static <T> List<T> execQuery(String queryString, Object... params) {
        log.info("gemfire oql:" + queryString);
        try {
            ClientCache cache = ClientCacheFactory.getAnyInstance();
            QueryService queryService = cache.getQueryService();
            Query query;
            if (traceFlg) {
                query = queryService.newQuery("<trace> " + queryString);
            } else {
                query = queryService.newQuery(queryString);
            }
            SelectResults<T> result = null;
            if (params == null) {
                result = (SelectResults<T>) query.execute();
            } else {
                result = (SelectResults<T>) query.execute(params);
            }
            return result.asList();
        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = queryString + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("501053009", msg);
        }

    }

    public static List<Map> execQueryStruct(String queryString,
                                            Object... params) {
        log.info("gemfire oql:" + queryString);
        try {
            ClientCache cache = ClientCacheFactory.getAnyInstance();
            QueryService queryService = cache.getQueryService();
            Query query;
            if (traceFlg) {
                query = queryService.newQuery("<trace> " + queryString);
            } else {
                query = queryService.newQuery(queryString);
            }

            SelectResults<Struct> result = null;
            result = (SelectResults<Struct>) query.execute(params);
            List<Map> listt = new ArrayList<Map>();
            HashMap map;
            for (Struct struct : result) {
                map = new HashMap();
                String[] names = struct.getStructType().getFieldNames();
                for (String name : names) {
                    map.put(name, struct.get(name));
                }
                listt.add(map);
            }// for()
            return listt;
        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = queryString + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("50105309", msg);
        }
    }

    public static Map callFunctionOnRegion(String funcName, Map inputParam, Region region,
                                           ResultCollector<?, ?> resultCollector) {
        try {
            Execution ext;
            ext = FunctionService.onRegion(region);
            if (resultCollector != null) {
                ext = ext.withCollector(resultCollector);
            }
            if (inputParam != null) {
                ext = ext.withArgs(inputParam);
            }

            ResultCollector rc = ext.execute(funcName);
            Map resultMap = (Map) rc.getResult();
            return resultMap;
        } catch (Exception e) {
            log.error("Exception:", e);
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String msg = funcName + "\r\n" + writer.getBuffer().toString();
            throw new GeodeServiceException("501053008", msg);
        }
    }
}// class

