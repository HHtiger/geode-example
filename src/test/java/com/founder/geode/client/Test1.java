package com.founder.geode.client;

import com.founder.model.test1.TestObjA;
import com.founder.model.test1.TestObjB;
import com.founder.model.test1.TestObjC;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.cache.query.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class Test1 {

    private static Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void clear_data(){
        ClientCache clientCache = new ClientCacheFactory().create();
        Region<Integer, TestObjA> testObjA = clientCache.getRegion("TestObjA");
        if( testObjA == null){
            ClientRegionFactory<Integer,TestObjA> cRegionFactoryA = clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            testObjA = cRegionFactoryA.setPoolName("serverPool").create("TestObjA");
        }

        Region<Integer, TestObjB> testObjB = clientCache.getRegion("TestObjB");
        if( testObjB == null){
            ClientRegionFactory<Integer,TestObjB> cRegionFactoryB = clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            testObjB = cRegionFactoryB.setPoolName("serverPool").create("TestObjB");
        }

        Region<Integer, TestObjC> testObjC = clientCache.getRegion("TestObjC");
        if( testObjC == null){
            ClientRegionFactory<Integer,TestObjC> cRegionFactoryC = clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            testObjC = cRegionFactoryC.setPoolName("serverPool").create("TestObjC");
        }

        testObjA.clear();
        testObjB.clear();
        testObjC.clear();

    }


    /*
    * gfsh:
    * start locator --name=locator1
    * start server --name=server1 --server-port=40411
    *
    * create region --name=TestObjA --type=REPLICATE
    * create region --name=TestObjB --type=REPLICATE
    * create region --name=TestObjC --type=REPLICATE
    *
    * create index --name=KeyIndexA --expression=id --region=/TestObjA
    * create index --name=KeyIndexB --expression=id --region=/TestObjB
    * create index --name=KeyIndexC --expression=id --region=/TestObjC
    *
    * */
    @Test
    public void init_data(){
        ClientCache clientCache = new ClientCacheFactory().create();

        Region<Integer, TestObjA> regionA = clientCache.getRegion("TestObjA");
        if( regionA == null){
            ClientRegionFactory<Integer,TestObjA> cRegionFactoryA = clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            regionA = cRegionFactoryA.setPoolName("serverPool").create("TestObjA");
        }

        Region<Integer, TestObjB> regionB = clientCache.getRegion("TestObjB");
        if( regionB == null){
            ClientRegionFactory<Integer,TestObjB> cRegionFactoryB = clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            regionB = cRegionFactoryB.setPoolName("serverPool").create("TestObjB");
        }

        Region<Integer, TestObjC> regionC = clientCache.getRegion("TestObjC");
        if( regionC == null){
            ClientRegionFactory<Integer,TestObjC> cRegionFactoryC = clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            regionC = cRegionFactoryC.setPoolName("serverPool").create("TestObjC");
        }

        for(int i=0;i<10000;i++){
            TestObjA a = new TestObjA();
            a.setId(i);
            a.setNameA("a"+i);
            regionA.put(i,a);
            TestObjB b = new TestObjB();
            b.setId(i);
            b.setNameB("b"+i);
            regionB.put(i,b);
            TestObjC c = new TestObjC();
            c.setId(i);
            c.setNameC("c"+i);
            regionC.put(i,c);
        }

    }

    @Test
    public void test_Join() throws NameResolutionException, TypeMismatchException, QueryInvocationTargetException, FunctionDomainException, IndexNameConflictException, IndexExistsException {
        ClientCache clientCache = new ClientCacheFactory().create();

        // Identify your query string.
        String queryString = "SELECT * FROM /TestObjA a , /TestObjB b, /TestObjC c WHERE a.id = 2000 and a.id = b.id and a.id = c.id order by a.id";

        // Get QueryService from Cache.
        QueryService queryService = clientCache.getQueryService();

        // Create the Query Object.
        Query query = queryService.newQuery(queryString);

        // Execute Query locally. Returns results set.
        SelectResults results = (SelectResults)query.execute();

        // Find the Size of the ResultSet.
        int size = results.size();
        logger.debug("result size : {} ", size);

        Iterator it = results.iterator();
        logger.debug("a b c");
        while(it.hasNext()) {
            // Iterate through your ResultSet.
            Struct s = (Struct) it.next(); /* Region containing Portfolio object. */
            TestObjA a = (TestObjA)s.get("a");
            TestObjB b = (TestObjB)s.get("b");
            TestObjC c = (TestObjC)s.get("c");
            logger.debug("{} {} {}",a.getNameA(),b.getNameB(),c.getNameC());
        }

        clientCache.close(true);
    }
}