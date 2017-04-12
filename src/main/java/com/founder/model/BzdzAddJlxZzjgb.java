package com.founder.model;

import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import java.util.Properties;

/**
 * 街路巷区县管辖信息表
 * @author congrihong
 *
 */
//@DBInfoAnnotation(tableName = "BZDZ_ADD_JLXZZJGB", pk = "id")
public class BzdzAddJlxZzjgb implements PdxSerializable, Declarable {

	//街路巷组织机构ID")
	private String jlxzzjgid;
	
	//街路巷代码")
	private String jlxdm;
	
	//责任区代码")
	private String zrqdm;
	
	//派出所代码")
	private String pcsdm;
	
	//分县局代码")
	private String fxjdm;
	
	//市局代码")
	private String sjdm;
	
	//业务调整编码")
	private String ywtzxxbm;
	
	public String getYwtzxxbm() {
		return ywtzxxbm;
	}
	public void setYwtzxxbm(String ywtzxxbm) {
		this.ywtzxxbm = ywtzxxbm;
	}
	private String orgLevel;//组织机构等级，新建门牌号的时候复用查询街路巷的公安管辖信息用
	
	
	
	public String getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getSjdm() {
		return sjdm;
	}
	public void setSjdm(String sjdm) {
		this.sjdm = sjdm;
	}
	public String getJlxzzjgid() {
		return jlxzzjgid;
	}
	public void setJlxzzjgid(String jlxzzjgid) {
		this.jlxzzjgid = jlxzzjgid;
	}
	public String getJlxdm() {
		return jlxdm;
	}
	public void setJlxdm(String jlxdm) {
		this.jlxdm = jlxdm;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getPcsdm() {
		return pcsdm;
	}
	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}
	public String getFxjdm() {
		return fxjdm;
	}
	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof BzdzAddJlxZzjgb)){
			return false;
		}else{
			BzdzAddJlxZzjgb entity=(BzdzAddJlxZzjgb)obj;
			if(entity.getFxjdm().equals(this.fxjdm)){
				return true;
			}else{
				return false;
			}
			
		}
	}


	@Override
	public void init(Properties props) {

	}

	@Override
	public void toData(PdxWriter writer) {

		writer.writeString("JLXZZJGID",jlxzzjgid);
		writer.writeString("JLXDM",jlxdm);
		writer.writeString("ZRQDM",zrqdm);
		writer.writeString("PCSDM",pcsdm);
		writer.writeString("FXJDM",fxjdm);
		writer.writeString("SJDM",sjdm);

	}

	@Override
	public void fromData(PdxReader reader) {

        jlxzzjgid = reader.readString("JLXZZJGID");
        jlxdm = reader.readString("JLXDM");
        zrqdm = reader.readString("ZRQDM");
        pcsdm = reader.readString("PCSDM");
        fxjdm = reader.readString("FXJDM");
        sjdm = reader.readString("SJDM");

	}
}
