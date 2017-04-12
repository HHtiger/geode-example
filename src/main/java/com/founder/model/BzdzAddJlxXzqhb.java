package com.founder.model;

import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import java.util.Properties;

/**
 * 街路巷区县管辖信息表
 * 
 * @author congrihong
 *
 */
public class BzdzAddJlxXzqhb implements PdxSerializable, Declarable {

	//街路巷行政区划ID")
	private String jlxxzqhid;
	
	//街路巷代码")
	private String jlxdm;
	
	//行政区划代码")
	private String xzqhdm;
	
	private String xzqhmc;//行政区划名称 数据库没存这个字段

	public String getXzqhmc() {
		return xzqhmc;
	}

	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}

	public String getJlxxzqhid() {
		return jlxxzqhid;
	}

	public void setJlxxzqhid(String jlxxzqhid) {
		this.jlxxzqhid = jlxxzqhid;
	}

	public String getJlxdm() {
		return jlxdm;
	}

	public void setJlxdm(String jlxdm) {
		this.jlxdm = jlxdm;
	}

	public String getXzqhdm() {
		return xzqhdm;
	}

	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
	}

	@Override
	public void init(Properties props) {

	}

	@Override
	public void toData(PdxWriter writer) {
		writer.writeString("JLXDM",jlxdm);
		writer.writeString("JLXXZQHID",jlxxzqhid);
		writer.writeString("XZQHDM",xzqhdm);

	}

	@Override
	public void fromData(PdxReader reader) {
		jlxdm = reader.readString("JLXDM");
		jlxxzqhid = reader.readString("JLXXZQHID");
		xzqhdm = reader.readString("XZQHDM");

	}

}
