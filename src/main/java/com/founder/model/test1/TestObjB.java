package com.founder.model.test1;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

/**
 * Created by tiger on 2017/2/7.
 */
public class TestObjB implements PdxSerializable {

    private int id;
    private String nameB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeInt("id",id).writeString("nameB", nameB);
    }

    @Override
    public void fromData(PdxReader reader) {
        id = reader.readInt("id");
        nameB = reader.readString("nameB");
    }
}
