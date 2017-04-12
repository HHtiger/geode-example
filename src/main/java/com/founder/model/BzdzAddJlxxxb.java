package com.founder.model;

import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import java.util.Properties;

/**
 * 街路巷信息表
 * @author cmd
 *
 */
public class BzdzAddJlxxxb implements PdxSerializable, Declarable {

	//街路巷ID")
	private String jlxid;
	
	//街路巷代码")
	private String jlxdm;
	
	//街路巷名称")
	private String jlxmc;
	
	//街路巷类型")
	private String jlxlx;
	
	//地理实体")
	private String dlst;
	
	//街路巷拼音")
	private String jlxpy;
	
	//街路巷五笔")
	private String jlxwb;
	
	//备注")
	private String bz;
	
	//核实时间")
	private String xt_hssj;
	
	//录入标识")
	private String xt_lrbz;
	
	//俗称")
	private String sc;
	
	//民政部门命名情况")
	private String mzbmmmqk;
	
	//街路巷起点坐标")
	private String qdzb;
	
	//街路巷终点坐标")
	private String zdzb;
	
	//是否保存")
	private String sfbc;
	 
	public String getSfbc() {
		return sfbc;
	}
	public void setSfbc(String sfbc) {
		this.sfbc = sfbc;
	}
	private String xzqhdms;
	
	private String sssjdms;

    private String ssfxjdms;
	
	private String  sspcsdms;
	
	private  String sszrqdms;
	
	private String fxjmc;//導出用
	
	private String pcsmc;//導出用
	
	private String zrqmc;//導出用
	
	private  String qxgxids;
	
	private  String xzjdbscids;
	
	private String[] shiids=new String[0];//市管辖id
	
	private String[] shimcs=new String[0];
	
	private String[] xianids=new String[0];//县id
	private String[] xianmcs=new String[0];
	
	private String[] xiangids=new String[0];//乡镇id
	private String[] xiangmcs=new String[0];
	
	
	
	public String getFxjmc() {
		return fxjmc;
	}
	public void setFxjmc(String fxjmc) {
		this.fxjmc = fxjmc;
	}
	public String getPcsmc() {
		return pcsmc;
	}
	public void setPcsmc(String pcsmc) {
		this.pcsmc = pcsmc;
	}
	public String getZrqmc() {
		return zrqmc;
	}
	public void setZrqmc(String zrqmc) {
		this.zrqmc = zrqmc;
	}
	public String[] getShimcs() {
		return shimcs;
	}
	public void setShimcs(String[] shimcs) {
		this.shimcs = shimcs;
	}
	public String[] getXianmcs() {
		return xianmcs;
	}
	public void setXianmcs(String[] xianmcs) {
		this.xianmcs = xianmcs;
	}
	public String[] getXiangmcs() {
		return xiangmcs;
	}
	public void setXiangmcs(String[] xiangmcs) {
		this.xiangmcs = xiangmcs;
	}
	public String getJlxid() {
		return jlxid;
	}
	public void setJlxid(String jlxid) {
		this.jlxid = jlxid;
	}
	public String getJlxdm() {
		return jlxdm;
	}
	public void setJlxdm(String jlxdm) {
		this.jlxdm = jlxdm;
	}
	public String getJlxmc() {
		return jlxmc;
	}
	public void setJlxmc(String jlxmc) {
		this.jlxmc = jlxmc;
	}
	public String getJlxlx() {
		return jlxlx;
	}
	public void setJlxlx(String jlxlx) {
		this.jlxlx = jlxlx;
	}
	public String getDlst() {
		return dlst;
	}
	public void setDlst(String dlst) {
		this.dlst = dlst;
	}
	public String getJlxpy() {
		return jlxpy;
	}
	public void setJlxpy(String jlxpy) {
		this.jlxpy = jlxpy;
	}
	public String getJlxwb() {
		return jlxwb;
	}
	public void setJlxwb(String jlxwb) {
		this.jlxwb = jlxwb;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXt_hssj() {
		return xt_hssj;
	}
	public void setXt_hssj(String xt_hssj) {
		this.xt_hssj = xt_hssj;
	}
	public String getXt_lrbz() {
		return xt_lrbz;
	}
	public void setXt_lrbz(String xt_lrbz) {
		this.xt_lrbz = xt_lrbz;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	public String getMzbmmmqk() {
		return mzbmmmqk;
	}
	public void setMzbmmmqk(String mzbmmmqk) {
		this.mzbmmmqk = mzbmmmqk;
	}
	public String getQdzb() {
		return qdzb;
	}
	public void setQdzb(String qdzb) {
		this.qdzb = qdzb;
	}
	public String getZdzb() {
		return zdzb;
	}
	public void setZdzb(String zdzb) {
		this.zdzb = zdzb;
	}

	public String getXzqhdms() {
		return xzqhdms;
	}
	public void setXzqhdms(String xzqhdms) {
		this.xzqhdms = xzqhdms;
	}
	public String getSsfxjdms() {
		return ssfxjdms;
	}
	public void setSsfxjdms(String ssfxjdms) {
		this.ssfxjdms = ssfxjdms;
	}
	public String getSspcsdms() {
		return sspcsdms;
	}
	public void setSspcsdms(String sspcsdms) {
		this.sspcsdms = sspcsdms;
	}
	public String getSszrqdms() {
		return sszrqdms;
	}
	public void setSszrqdms(String sszrqdms) {
		this.sszrqdms = sszrqdms;
	}
	
	public String[] getShiids() {
		return shiids;
	}
	public void setShiids(String[] shiids) {
		this.shiids = shiids;
	}
	public String getQxgxids() {
		return qxgxids;
	}
	public void setQxgxids(String qxgxids) {
		this.qxgxids = qxgxids;
	}
	public String getXzjdbscids() {
		return xzjdbscids;
	}
	public void setXzjdbscids(String xzjdbscids) {
		this.xzjdbscids = xzjdbscids;
	}
	public String[] getXianids() {
		return xianids;
	}
	public void setXianids(String[] xianids) {
		this.xianids = xianids;
	}
	public String[] getXiangids() {
		return xiangids;
	}
	public void setXiangids(String[] xiangids) {
		this.xiangids = xiangids;
	}
	public String getSssjdms() {
		return sssjdms;
	}
	public void setSssjdms(String sssjdms) {
		this.sssjdms = sssjdms;
	}


    @Override
    public void init(Properties props) {

    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeString("JLXID",jlxid);
        writer.writeString("JLXDM",jlxdm);
        writer.writeString("JLXMC",jlxmc);
        writer.writeString("JLXLX",jlxlx);
        writer.writeString("DLST",dlst);
        writer.writeString("JLXPY",jlxpy);
        writer.writeString("JLXWB",jlxwb);
        writer.writeString("BZ",bz);
        writer.writeString("SC",sc);
        writer.writeString("MZBMMMQK",mzbmmmqk);
        writer.writeString("QDZB",qdzb);
        writer.writeString("ZDZB",zdzb);
        writer.writeString("XT_HSSJ",xt_hssj);
    }

    @Override
    public void fromData(PdxReader reader) {
        jlxid = reader.readString("JLXID");
        jlxdm = reader.readString("JLXDM");
        jlxmc = reader.readString("JLXMC");
        jlxlx = reader.readString("JLXLX");
        dlst = reader.readString("DLST");
        jlxpy = reader.readString("JLXPY");
        jlxwb = reader.readString("JLXWB");
        bz = reader.readString("BZ");
        sc = reader.readString("SC");
        mzbmmmqk = reader.readString("MZBMMMQK");
        qdzb = reader.readString("QDZB");
        zdzb = reader.readString("ZDZB");
        xt_hssj = reader.readString("XT_HSSJ");
    }
}
