package com.founder.model;

import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import java.util.Properties;

//@DBInfoAnnotation(tableName = "BZDZ_ADD_MLDZDXB", pk = "id")
public class BzdzAddMldzdxb implements PdxSerializable, Declarable {

	//mldzid")
	//门楼地址ID")
	private String mldzid;

	//xzqhdm")
	//行政区划代码")
	private String xzqhdm;

	//jlxdm")
	//街路巷代码")
	private String jlxdm;

	//jlxmc")
	//街路巷名称")
	private String jlxmc;

	//sqdm")
	//社区代码")
	private String sqdm;

	//zrqdm")
	//责任区代码")
	private String zrqdm;

	//pcsdm")
	//派出所代码")
	private String pcsdm;

	//fxjdm")
	//分县局代码")
	private String fxjdm;

	//qxgxid")
	//区县管辖id")
	private String qxgxid;

	//xzjdbscid")
	//乡镇街道办事处id")
	private String xzjdbscid;

	//mplx")
	//门牌类型")
	private String mplx;

	//mph")
	//门牌号")
	private String mph;

	//mpmc")
	//门牌名称")
	private String mpmc;

	//mpsc")
	//门牌俗称")
	private String mpsc;

	//dzmc")
	//地址名称")
	private String dzmc;

	//dzmcpy")
	//地址名称拼音")
	private String dzmcpy;

	//dzmcpwd")
	//地址名称加密")
	private String dzmcpwd;

	//dzmcpypwd")
	//地址名称拼音加密")
	private String dzmcpypwd;

	//mpzbx")
	//门牌坐标X")
	private String mpzbx;

	//mpzby")
	//门牌坐标Y")
	private String mpzby;

	//bz")
	//备注")
	private String bz;

	//xt_hssj")
	//核实时间")
	private String xt_hssj;

	//xt_lrbz")
	//录入标识")
	private String xt_lrbz;

	//dtcwfk")
	//地址错误反馈")
	private String dtcwfk;

	//xzqhsc")
	//行政区划俗称")
	private String xzqhsc;

	//dzsjly")
	//地址数据来源")
	private String dzsjly;

	//mphbh")
	//门牌号编号")
	private String mphbh;

	//xqmc")
	//小区名称")
	private String xqmc;

	//mphhz")
	//门牌号后缀")
	private String mphhz;

	//sflj")
	//是否临建")
	private String sflj;

	//jzwbm")
	//建筑物别名")
	private String jzwbm;

	//jzwmj")
	//建筑物面积")
	private String jzwmj;

	//xqid")
	//小区id")
	private String xqid;

	//sfscfw")
	//是否生成房屋")
	private String sfscfw;

	//mphhz_hfh")
	//门牌号后缀号附号")
	private String mphhz_hfh;

	//sftxjzwxx")
	//是否填写建筑物信息")
	private String sftxjzwxx;

	//mphhz_zhfh")
	//门牌号后缀_组号附号")
	private String mphhz_zhfh;

	//shiid")
	//市管辖id")
	private String shiid;

	//sjdm")
	//市局代码")
	private String sjdm;
	
	private String old_mldzid;
	
	private String sfbc;
	
	private String fxjmc;//導出用
	
	private String pcsmc;//導出用
	
	private String zrqmc;//導出用
	
	
	
	
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
	public String getOld_mldzid() {
		return old_mldzid;
	}
	public void setOld_mldzid(String old_mldzid) {
		this.old_mldzid = old_mldzid;
	}
	public String getSfbc() {
		return sfbc;
	}
	public void setSfbc(String sfbc) {
		this.sfbc = sfbc;
	}
	public String getSjdm() {
		return sjdm;
	}
	public void setSjdm(String sjdm) {
		this.sjdm = sjdm;
	}
	public String getShiid() {
		return shiid;
	}
	public void setShiid(String shiid) {
		this.shiid = shiid;
	}
	public String getMphhz_zhfh() {
		return mphhz_zhfh;
	}
	public void setMphhz_zhfh(String mphhz_zhfh) {
		this.mphhz_zhfh = mphhz_zhfh;
	}
	public String getSftxjzwxx() {
		return sftxjzwxx;
	}
	public void setSftxjzwxx(String sftxjzwxx) {
		this.sftxjzwxx = sftxjzwxx;
	}
	public String getMphhz_hfh() {
		return mphhz_hfh;
	}
	public void setMphhz_hfh(String mphhz_hfh) {
		this.mphhz_hfh = mphhz_hfh;
	}
	public String getXqid() {
		return xqid;
	}
	public void setXqid(String xqid) {
		this.xqid = xqid;
	}
	public String getSfscfw() {
		return sfscfw;
	}
	public void setSfscfw(String sfscfw) {
		this.sfscfw = sfscfw;
	}
	public String getJzwbm() {
		return jzwbm;
	}
	public void setJzwbm(String jzwbm) {
		this.jzwbm = jzwbm;
	}
	public String getJzwmj() {
		return jzwmj;
	}
	public void setJzwmj(String jzwmj) {
		this.jzwmj = jzwmj;
	}
	public String getSflj() {
		return sflj;
	}
	public void setSflj(String sflj) {
		this.sflj = sflj;
	}
	public String getMphhz() {
		return mphhz;
	}
	public void setMphhz(String mphhz) {
		this.mphhz = mphhz;
	}

	public void setMldzid(String mldzid) {
		this.mldzid = mldzid;
	}
	public String getXzqhdm() {
		return xzqhdm;
	}
	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
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
	public String getSqdm() {
		return sqdm;
	}
	public void setSqdm(String sqdm) {
		this.sqdm = sqdm;
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
	public String getMplx() {
		return mplx;
	}
	public void setMplx(String mplx) {
		this.mplx = mplx;
	}
	public String getMph() {
		return mph;
	}
	public void setMph(String mph) {
		this.mph = mph;
	}
	public String getMpmc() {
		return mpmc;
	}
	public void setMpmc(String mpmc) {
		this.mpmc = mpmc;
	}
	public String getMpsc() {
		return mpsc;
	}
	public void setMpsc(String mpsc) {
		this.mpsc = mpsc;
	}
	public String getDzmc() {
		return dzmc;
	}
	public void setDzmc(String dzmc) {
		this.dzmc = dzmc;
	}
	public String getDzmcpy() {
		return dzmcpy;
	}
	public void setDzmcpy(String dzmcpy) {
		this.dzmcpy = dzmcpy;
	}
	public String getDzmcpwd() {
		return dzmcpwd;
	}
	public void setDzmcpwd(String dzmcpwd) {
		this.dzmcpwd = dzmcpwd;
	}
	public String getDzmcpypwd() {
		return dzmcpypwd;
	}
	public void setDzmcpypwd(String dzmcpypwd) {
		this.dzmcpypwd = dzmcpypwd;
	}
	public String getMpzbx() {
		return mpzbx;
	}
	public void setMpzbx(String mpzbx) {
		this.mpzbx = mpzbx;
	}
	public String getMpzby() {
		return mpzby;
	}
	public void setMpzby(String mpzby) {
		this.mpzby = mpzby;
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
	public String getDtcwfk() {
		return dtcwfk;
	}
	public void setDtcwfk(String dtcwfk) {
		this.dtcwfk = dtcwfk;
	}
	public String getXzqhsc() {
		return xzqhsc;
	}
	public void setXzqhsc(String xzqhsc) {
		this.xzqhsc = xzqhsc;
	}
	public String getDzsjly() {
		return dzsjly;
	}
	public void setDzsjly(String dzsjly) {
		this.dzsjly = dzsjly;
	}
	public String getMphbh() {
		return mphbh;
	}
	public void setMphbh(String mphbh) {
		this.mphbh = mphbh;
	}
	public String getXqmc() {
		return xqmc;
	}
	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}
	public String getQxgxid() {
		return qxgxid;
	}
	public void setQxgxid(String qxgxid) {
		this.qxgxid = qxgxid;
	}
	public String getXzjdbscid() {
		return xzjdbscid;
	}
	public void setXzjdbscid(String xzjdbscid) {
		this.xzjdbscid = xzjdbscid;
	}
	public String getMldzid() {
		return mldzid;
	}


	@Override
	public void init(Properties props) {

	}

	@Override
	public void toData(PdxWriter writer) {

		writer.writeString("MLDZID",mldzid);
		writer.writeString("XZQHDM",xzqhdm);
		writer.writeString("JLXDM",jlxdm);
		writer.writeString("JLXMC",jlxmc);
		writer.writeString("SQDM",sqdm);
		writer.writeString("XQMC",xqmc);
		writer.writeString("ZRQDM",zrqdm);
		writer.writeString("PCSDM",pcsdm);
		writer.writeString("FXJDM",fxjdm);
		writer.writeString("MPLX",mplx);
		writer.writeString("MPMC",mpmc);
		writer.writeString("MPSC",mpsc);
		writer.writeString("MPHBH",mphbh);
		writer.writeString("DZMC",dzmc);
		writer.writeString("DZMCPY",dzmcpy);
		writer.writeString("DZMCPWD",dzmcpwd);
		writer.writeString("DZMCPYPWD",dzmcpypwd);
		writer.writeString("MPZBX",mpzbx);
		writer.writeString("MPZBY",mpzby);
		writer.writeString("DTCWFK",dtcwfk);
		writer.writeString("XZQHSC",xzqhsc);
		writer.writeString("DZSJLY",dzsjly);
		writer.writeString("BZ",bz);
		writer.writeString("QXGXID",qxgxid);
		writer.writeString("XZJDBSCID",xzjdbscid);
		writer.writeString("SFLJ",sflj);
		writer.writeString("JZWBM",jzwbm);
		writer.writeString("JZWMJ",jzwmj);
		writer.writeString("SFSCFW",sfscfw);
		writer.writeString("XQID",xqid);
		writer.writeString("MPHHZ_HFH",mphhz_hfh);
		writer.writeString("SFTXJZWXX",sftxjzwxx);
		writer.writeString("MPHHZ",mphhz);
		writer.writeString("MPHHZ_ZHFH",mphhz_zhfh);
		writer.writeString("SHIID",shiid);
		writer.writeString("SJDM",sjdm);
		writer.writeString("MPH",mph);
		writer.writeString("OLD_MLDZID",old_mldzid);
	}

	@Override
	public void fromData(PdxReader reader) {
		mldzid = reader.readString("MLDZID");
		xzqhdm = reader.readString("XZQHDM");
		jlxdm = reader.readString("JLXDM");
		jlxmc = reader.readString("JLXMC");
		sqdm = reader.readString("SQDM");
		xqmc = reader.readString("XQMC");
		zrqdm = reader.readString("ZRQDM");
		pcsdm = reader.readString("PCSDM");
		fxjdm = reader.readString("FXJDM");
		mplx = reader.readString("MPLX");
		mpmc = reader.readString("MPMC");
		mpsc = reader.readString("MPSC");
		mphbh = reader.readString("MPHBH");
		dzmc = reader.readString("DZMC");
		dzmcpy = reader.readString("DZMCPY");
		dzmcpwd = reader.readString("DZMCPWD");
		dzmcpypwd = reader.readString("DZMCPYPWD");
		mpzbx = reader.readString("MPZBX");
		mpzby = reader.readString("MPZBY");
		dtcwfk = reader.readString("DTCWFK");
		xzqhsc = reader.readString("XZQHSC");
		dzsjly = reader.readString("DZSJLY");
		bz = reader.readString("BZ");
		qxgxid = reader.readString("QXGXID");
		xzjdbscid = reader.readString("XZJDBSCID");
		sflj = reader.readString("SFLJ");
		jzwbm = reader.readString("JZWBM");
		jzwmj = reader.readString("JZWMJ");
		sfscfw = reader.readString("SFSCFW");
		xqid = reader.readString("XQID");
		mphhz_hfh = reader.readString("MPHHZ_HFH");
		sftxjzwxx = reader.readString("SFTXJZWXX");
		mphhz = reader.readString("MPHHZ");
		mphhz_zhfh = reader.readString("MPHHZ_ZHFH");
		shiid = reader.readString("SHIID");
		sjdm = reader.readString("SJDM");
		mph = reader.readString("MPH");
		old_mldzid = reader.readString("OLD_MLDZID");
	}
}
