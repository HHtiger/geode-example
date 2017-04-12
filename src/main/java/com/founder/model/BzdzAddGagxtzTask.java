package com.founder.model;

import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import java.util.Properties;

public class BzdzAddGagxtzTask implements PdxSerializable, Declarable {

	//ID")
	private Long id;
	//业务调整编码")
	private String ywtzxxbm;
	//街路巷代码")
	private String jlxdm;
	//地址级别")
	private String dzjb;
	//市局代码")
	private String sjdm;
	//分县局代码")
	private String fxjdm;
	//派出所代码")
	private String pcsdm;
	//责任区代码")
	private String zrqdm;
	//调整类型（0建立管辖，1解除管辖）")
	private String tzlx;
	//序列号")
	private String sequence;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJlxdm() {
		return jlxdm;
	}
	public void setJlxdm(String jlxdm) {
		this.jlxdm = jlxdm;
	}
	public String getDzjb() {
		return dzjb;
	}
	public void setDzjb(String dzjb) {
		this.dzjb = dzjb;
	}
	public String getSjdm() {
		return sjdm;
	}
	public void setSjdm(String sjdm) {
		this.sjdm = sjdm;
	}
	public String getFxjdm() {
		return fxjdm;
	}
	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}
	public String getPcsdm() {
		return pcsdm;
	}
	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getTzlx() {
		return tzlx;
	}
	public void setTzlx(String tzlx) {
		this.tzlx = tzlx;
	}
	public String getYwtzxxbm() {
		return ywtzxxbm;
	}
	public void setYwtzxxbm(String ywtzxxbm) {
		this.ywtzxxbm = ywtzxxbm;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	@Override
	public void init(Properties props) {

	}

	@Override
	public void toData(PdxWriter writer) {
		writer.writeLong("ID",id);
		writer.writeString("YWTZXXBM",ywtzxxbm);
		writer.writeString("JLXDM",jlxdm);
		writer.writeString("DZJB",dzjb);
		writer.writeString("SJDM",sjdm);
		writer.writeString("FXJDM",fxjdm);
		writer.writeString("PCSDM",pcsdm);
		writer.writeString("ZRQDM",zrqdm);
		writer.writeString("TZLX",tzlx);
		writer.writeString("SEQUENCE",sequence);
	}

	@Override
	public void fromData(PdxReader reader) {
		id = reader.readLong("ID");
		ywtzxxbm = reader.readString("YWTZXXBM");
		jlxdm = reader.readString("JLXDM");
		dzjb = reader.readString("DZJB");
		sjdm = reader.readString("SJDM");
		fxjdm = reader.readString("FXJDM");
		pcsdm = reader.readString("PCSDM");
		zrqdm = reader.readString("ZRQDM");
		tzlx = reader.readString("TZLX");
		sequence = reader.readString("SEQUENCE");
	}
}
