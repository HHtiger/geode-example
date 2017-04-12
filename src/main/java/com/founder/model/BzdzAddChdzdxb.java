package com.founder.model;

import org.apache.geode.cache.Declarable;
import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

import java.util.Properties;

//@DBInfoAnnotation(tableName = "BZDZ_ADD_CHDZDXB", pk = "id")
public class BzdzAddChdzdxb implements PdxSerializable, Declarable {

	//chdzid")
	//层户地址ID")
	private String chdzid;
	
	//mldzid")
	//门楼地址ID")
	private String mldzid;
	
	//dyh")
	//单元号")
	private String dyh;
	
	//dyhlx")
	//单元号类型")
	private String dyhlx;
	
	//lch")
	//楼层号")
	private String lch;
	
	//fjh")
	//房间号")
	private String fjh;
	
	//fjhmc")
	//房间号名称")
	private String fjhmc;
	
	//fjhbs")
	//房间号标识")
	private String fjhbs;
	
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
	
	//sjdm")
	//市局代码")
	private String sjdm;
	
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
	
	//dzjb")
	//地址级别")
	private String dzjb;
	
	//lpzbx")
	//楼牌坐标X")
	private String lpzbx;
	
	//lpzby")
	//楼牌坐标Y")
	private String lpzby;
	
	//xt_hssj")
	//核实时间")
	private String xt_hssj;
	
	//xt_lrbz")
	//录入标识")
	private String xt_lrbz;
	
	//bz")
	//备注")
	private String bz;
	
	//lphdm")
	//楼牌号代码")
	private String lphdm;
	
	//lphmc")
	//楼牌号名称")
	private String lphmc;
	
	//lphpy")
	//楼牌号拼音")
	private String lphpy;
	
	//lphhz")
	//楼牌号后缀")
	private String lphhz;
	
	//lphhzhfh")
	//楼牌号后缀号附号")
	private String lphhzhfh;
	
	//dyhhz")
	//单元号后缀")
	private String dyhhz;
	
	//lchhz")
	//楼层号后缀")
	private String lchhz;
	
	//fjhhz")
	//房间号后缀")
	private String fjhhz;
	
	//fjhhzhfh")
	//房间号后缀号附号")
	private String fjhhzhfh;
	
	//fjhsc")
	//房间号俗称")
	private String fjhsc;
	
	//lphsc")
	//楼牌号俗称")
	private String lphsc;
	
	//dyhsc")
	//单元号俗称")
	private String dyhsc;
	
	//lchsc")
	//楼层号俗称")
	private String lchsc;
	
	//lplx")
	//楼牌类型")
	private String lplx;
	
	//lph")
	//楼牌号")
	private String lph;
	
	//dyzbx")
	//单元坐标X")
	private String dyzbx;
	
	//dyzby")
	//单元坐标Y")
	private String dyzby;
	
	//dyhdm")
	//单元号代码")
	private String dyhdm;
	
	//dyhmc")
	//单元号名称")
	private String dyhmc;
	
	//lchdm")
	//楼层号代码")
	private String lchdm;
	
	//lchlx")
	//楼层号类型")
	private String lchlx;
	
	//lchmc")
	//楼层号名称")
	private String lchmc;
	
	//fjhdm")
	//房间号代码")
	private String fjhdm;
	
	//fjhlx")
	//房间号类型")
	private String fjhlx;
	
	//jzwbm")
	//建筑物别名")
	private String jzwbm;
	
	//sflj")
	//是否临建")
	private String sflj;
	
	//jzwmj")
	//建筑物面积")
	private String jzwmj;
	
	//sfxzfw")
	//是否新增房屋")	
	private String sfxzfw;
	
	//lcwz")
	//楼层位置")	
	private String lcwz;
	
	//parenttreepath")
	//父节点id路径")	
	private String parenttreepath;
	
	//sftxjzwxx")
	//是否填写建筑物信息")
	private String sftxjzwxx;
	
	//旧地址信息")
	private String old_chdzid;
	
	private String jlxdm;//街路巷代码
	
	private String xqmc;//小区名称
	
	private String sfbc;
	
	private String parentid;//上级id
	
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getJlxdm() {
		return jlxdm;
	}
	public void setJlxdm(String jlxdm) {
		this.jlxdm = jlxdm;
	}
	public String getSfbc() {
		return sfbc;
	}
	public void setSfbc(String sfbc) {
		this.sfbc = sfbc;
	}
	
	public String getXqmc() {
		return xqmc;
	}
	public void setXqmc(String xqmc) {
		this.xqmc = xqmc;
	}
	public String getSftxjzwxx() {
		return sftxjzwxx;
	}
	public void setSftxjzwxx(String sftxjzwxx) {
		this.sftxjzwxx = sftxjzwxx;
	}
	public String getFjhhzhfh() {
		return fjhhzhfh;
	}
	public void setFjhhzhfh(String fjhhzhfh) {
		this.fjhhzhfh = fjhhzhfh;
	}
	public String getLcwz() {
		return lcwz;
	}
	public void setLcwz(String lcwz) {
		this.lcwz = lcwz;
	}
	public String getJzwmj() {
		return jzwmj;
	}
	public void setJzwmj(String jzwmj) {
		this.jzwmj = jzwmj;
	}
	public String getSfxzfw() {
		return sfxzfw;
	}
	public void setSfxzfw(String sfxzfw) {
		this.sfxzfw = sfxzfw;
	}
	public String getJzwbm() {
		return jzwbm;
	}
	public void setJzwbm(String jzwbm) {
		this.jzwbm = jzwbm;
	}
	public String getSflj() {
		return sflj;
	}
	public void setSflj(String sflj) {
		this.sflj = sflj;
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
	public String getLphhzhfh() {
		return lphhzhfh;
	}
	public void setLphhzhfh(String lphhzhfh) {
		this.lphhzhfh = lphhzhfh;
	}

	public void setChdzid(String chdzid) {
		this.chdzid = chdzid;
	}
	public String getMldzid() {
		return mldzid;
	}
	public void setMldzid(String mldzid) {
		this.mldzid = mldzid;
	}
	public String getDyh() {
		return dyh;
	}
	public void setDyh(String dyh) {
		this.dyh = dyh;
	}
	public String getDyhlx() {
		return dyhlx;
	}
	public void setDyhlx(String dyhlx) {
		this.dyhlx = dyhlx;
	}

	
	public String getLch() {
		return lch;
	}
	public void setLch(String lch) {
		this.lch = lch;
	}
	public String getFjh() {
		return fjh;
	}
	public void setFjh(String fjh) {
		this.fjh = fjh;
	}
	public String getFjhmc() {
		return fjhmc;
	}
	public void setFjhmc(String fjhmc) {
		this.fjhmc = fjhmc;
	}
	public String getFjhbs() {
		return fjhbs;
	}
	public void setFjhbs(String fjhbs) {
		this.fjhbs = fjhbs;
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
	public String getDzjb() {
		return dzjb;
	}
	public void setDzjb(String dzjb) {
		this.dzjb = dzjb;
	}
	public String getLpzbx() {
		return lpzbx;
	}
	public void setLpzbx(String lpzbx) {
		this.lpzbx = lpzbx;
	}
	public String getLpzby() {
		return lpzby;
	}
	public void setLpzby(String lpzby) {
		this.lpzby = lpzby;
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getLphdm() {
		return lphdm;
	}
	public void setLphdm(String lphdm) {
		this.lphdm = lphdm;
	}
	public String getLphmc() {
		return lphmc;
	}
	public void setLphmc(String lphmc) {
		this.lphmc = lphmc;
	}
	public String getLphpy() {
		return lphpy;
	}
	public void setLphpy(String lphpy) {
		this.lphpy = lphpy;
	}
	public String getLphhz() {
		return lphhz;
	}
	public void setLphhz(String lphhz) {
		this.lphhz = lphhz;
	}
	public String getDyhhz() {
		return dyhhz;
	}
	public void setDyhhz(String dyhhz) {
		this.dyhhz = dyhhz;
	}
	public String getLchhz() {
		return lchhz;
	}
	public void setLchhz(String lchhz) {
		this.lchhz = lchhz;
	}
	public String getFjhhz() {
		return fjhhz;
	}
	public void setFjhhz(String fjhhz) {
		this.fjhhz = fjhhz;
	}
	public String getFjhsc() {
		return fjhsc;
	}
	public void setFjhsc(String fjhsc) {
		this.fjhsc = fjhsc;
	}
	public String getLphsc() {
		return lphsc;
	}
	public void setLphsc(String lphsc) {
		this.lphsc = lphsc;
	}
	public String getDyhsc() {
		return dyhsc;
	}
	public void setDyhsc(String dyhsc) {
		this.dyhsc = dyhsc;
	}
	public String getLchsc() {
		return lchsc;
	}
	public void setLchsc(String lchsc) {
		this.lchsc = lchsc;
	}
	public String getLplx() {
		return lplx;
	}
	public void setLplx(String lplx) {
		this.lplx = lplx;
	}
	public String getLph() {
		return lph;
	}
	public void setLph(String lph) {
		this.lph = lph;
	}
	public String getDyzbx() {
		return dyzbx;
	}
	public void setDyzbx(String dyzbx) {
		this.dyzbx = dyzbx;
	}
	public String getDyzby() {
		return dyzby;
	}
	public void setDyzby(String dyzby) {
		this.dyzby = dyzby;
	}
	public String getDyhdm() {
		return dyhdm;
	}
	public void setDyhdm(String dyhdm) {
		this.dyhdm = dyhdm;
	}
	public String getDyhmc() {
		return dyhmc;
	}
	public void setDyhmc(String dyhmc) {
		this.dyhmc = dyhmc;
	}
	public String getLchdm() {
		return lchdm;
	}
	public void setLchdm(String lchdm) {
		this.lchdm = lchdm;
	}
	public String getLchlx() {
		return lchlx;
	}
	public void setLchlx(String lchlx) {
		this.lchlx = lchlx;
	}
	public String getLchmc() {
		return lchmc;
	}
	public void setLchmc(String lchmc) {
		this.lchmc = lchmc;
	}
	public String getFjhdm() {
		return fjhdm;
	}
	public void setFjhdm(String fjhdm) {
		this.fjhdm = fjhdm;
	}
	public String getFjhlx() {
		return fjhlx;
	}
	public void setFjhlx(String fjhlx) {
		this.fjhlx = fjhlx;
	}
	public String getParenttreepath() {
		return parenttreepath;
	}
	public void setParenttreepath(String parenttreepath) {
		this.parenttreepath = parenttreepath;
	}
	public String getChdzid() {
		return chdzid;
	}
	public String getOld_chdzid() {
		return old_chdzid;
	}
	public void setOld_chdzid(String old_chdzid) {
		this.old_chdzid = old_chdzid;
	}
	public String getSjdm() {
		return sjdm;
	}
	public void setSjdm(String sjdm) {
		this.sjdm = sjdm;
	}

	@Override
	public void init(Properties props) {

	}

	@Override
	public void toData(PdxWriter writer) {

		writer.writeString("CHDZID",chdzid);
		writer.writeString("MLDZID",mldzid);
		writer.writeString("DZJB",dzjb);
		writer.writeString("DYH",dyh);
		writer.writeString("DYHLX",dyhlx);
		writer.writeString("DYHHZ",dyhhz);
		writer.writeString("DYHSC",dyhsc);
		writer.writeString("DYZBX",dyzbx);
		writer.writeString("DYZBY",dyzby);
		writer.writeString("DYHDM",dyhdm);
		writer.writeString("DYHMC",dyhmc);
		writer.writeString("LCHHZ",lchhz);
		writer.writeString("LPHSC",lphsc);
		writer.writeString("LCHSC",lchsc);
		writer.writeString("LPLX",lplx);
		writer.writeString("LPH",lph);
		writer.writeString("LCH",lch);
		writer.writeString("LPHDM",lphdm);
		writer.writeString("LPHMC",lphmc);
		writer.writeString("LPHPY",lphpy);
		writer.writeString("LPHHZ",lphhz);
		writer.writeString("LPZBX",lpzbx);
		writer.writeString("LPZBY",lpzby);
		writer.writeString("LCHDM",lchdm);
		writer.writeString("LCHLX",lchlx);
		writer.writeString("LCHMC",lchmc);
		writer.writeString("FJHHZ",fjhhz);
		writer.writeString("FJHSC",fjhsc);
		writer.writeString("FJHDM",fjhdm);
		writer.writeString("FJHLX",fjhlx);
		writer.writeString("FJH",fjh);
		writer.writeString("FJHMC",fjhmc);
		writer.writeString("FJHBS",fjhbs);
		writer.writeString("DZMC",dzmc);
		writer.writeString("DZMCPY",dzmcpy);
		writer.writeString("DZMCPWD",dzmcpwd);
		writer.writeString("DZMCPYPWD",dzmcpypwd);
		writer.writeString("BZ",bz);
		writer.writeString("SQDM",sqdm);
		writer.writeString("ZRQDM",zrqdm);
		writer.writeString("PCSDM",pcsdm);
		writer.writeString("FXJDM",fxjdm);
		writer.writeString("LPHHZHFH",lphhzhfh);
		writer.writeString("JZWBM",jzwbm);
		writer.writeString("SFLJ",sflj);
		writer.writeString("SFXZFW",sfxzfw);
		writer.writeString("JZWMJ",jzwmj);
		writer.writeString("FJHHZHFH",fjhhzhfh);
		writer.writeString("LCWZ",lcwz);
		writer.writeString("PARENTTREEPATH",parenttreepath);
		writer.writeString("SFTXJZWXX",sftxjzwxx);
		writer.writeString("OLD_CHDZID",old_chdzid);
		writer.writeString("SJDM",sjdm);
		
	}

	@Override
	public void fromData(PdxReader reader) {

		chdzid = reader.readString("CHDZID");
		mldzid = reader.readString("MLDZID");
		dzjb = reader.readString("DZJB");
		dyh = reader.readString("DYH");
		dyhlx = reader.readString("DYHLX");
		dyhhz = reader.readString("DYHHZ");
		dyhsc = reader.readString("DYHSC");
		dyzbx = reader.readString("DYZBX");
		dyzby = reader.readString("DYZBY");
		dyhdm = reader.readString("DYHDM");
		dyhmc = reader.readString("DYHMC");
		lchhz = reader.readString("LCHHZ");
		lphsc = reader.readString("LPHSC");
		lchsc = reader.readString("LCHSC");
		lplx = reader.readString("LPLX");
		lph = reader.readString("LPH");
		lch = reader.readString("LCH");
		lphdm = reader.readString("LPHDM");
		lphmc = reader.readString("LPHMC");
		lphpy = reader.readString("LPHPY");
		lphhz = reader.readString("LPHHZ");
		lpzbx = reader.readString("LPZBX");
		lpzby = reader.readString("LPZBY");
		lchdm = reader.readString("LCHDM");
		lchlx = reader.readString("LCHLX");
		lchmc = reader.readString("LCHMC");
		fjhhz = reader.readString("FJHHZ");
		fjhsc = reader.readString("FJHSC");
		fjhdm = reader.readString("FJHDM");
		fjhlx = reader.readString("FJHLX");
		fjh = reader.readString("FJH");
		fjhmc = reader.readString("FJHMC");
		fjhbs = reader.readString("FJHBS");
		dzmc = reader.readString("DZMC");
		dzmcpy = reader.readString("DZMCPY");
		dzmcpwd = reader.readString("DZMCPWD");
		dzmcpypwd = reader.readString("DZMCPYPWD");
		bz = reader.readString("BZ");
		sqdm = reader.readString("SQDM");
		zrqdm = reader.readString("ZRQDM");
		pcsdm = reader.readString("PCSDM");
		fxjdm = reader.readString("FXJDM");
		lphhzhfh = reader.readString("LPHHZHFH");
		jzwbm = reader.readString("JZWBM");
		sflj = reader.readString("SFLJ");
		sfxzfw = reader.readString("SFXZFW");
		jzwmj = reader.readString("JZWMJ");
		fjhhzhfh = reader.readString("FJHHZHFH");
		lcwz = reader.readString("LCWZ");
		parenttreepath = reader.readString("PARENTTREEPATH");
		sftxjzwxx = reader.readString("SFTXJZWXX");
		old_chdzid = reader.readString("OLD_CHDZID");
		sjdm = reader.readString("SJDM");
		
	}
}
