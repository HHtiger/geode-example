package com.founder.model.test1;

import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import java.util.Properties;

/**
 * Created by tiger on 2017/2/7.
 */
public class TestObjA implements PdxSerializable , Declarable{

    private int id;
    private String nameA;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeInt("id",id).writeString("nameA", nameA);
    }

    @Override
    public void fromData(PdxReader reader) {
        id = reader.readInt("id");
        nameA = reader.readString("nameA");
    }

    @Override
    public void init(Properties props) {

    }
}
