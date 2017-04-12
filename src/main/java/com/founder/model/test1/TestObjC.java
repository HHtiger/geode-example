package com.founder.model.test1;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

/**
 * Created by tiger on 2017/2/7.
 */
public class TestObjC implements PdxSerializable {

    private int id;
    private String nameC;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeInt("id",id).writeString("nameC", nameC);
    }

    @Override
    public void fromData(PdxReader reader) {
        id = reader.readInt("id");
        nameC = reader.readString("nameC");
    }
}
