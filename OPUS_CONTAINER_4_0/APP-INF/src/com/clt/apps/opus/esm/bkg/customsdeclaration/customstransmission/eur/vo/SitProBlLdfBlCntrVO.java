/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlCntrVO.java
*@FileTitle : SitProBlLdfBlCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SitProBlLdfBlCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlCntrVO> models = new ArrayList<SitProBlLdfBlCntrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vvd = null;

	/* Column Info */
	private String ibConVvd = null;

	/* Column Info */
	private String obConVvd = null;

	/* Column Info */
	private String port = null;

	/* Column Info */
	private String blnbr = null;

	/* Column Info */
	private String cntrnbr = null;

	/* Column Info */
	private String punit = null;

	/* Column Info */
	private String pkg = null;

	/* Column Info */
	private String cntrwgt = null;

	/* Column Info */
	private String cntrgwgt = null;

	/* Column Info */
	private String cntrWgtUnit = null;

	/* Column Info */
	private String cntrtrw = null;

	/* Column Info */
	private String cntrtype = null;

	/* Column Info */
	private String sealnbr = null;

	/* Column Info */
	private String fmInd = null;

	/* Column Info */
	private String rfInd = null;

	/* Column Info */
	private String dgInd = null;

	/* Column Info */
	private String akInd = null;

	/* Column Info */
	private String bkInd = null;

	/* Column Info */
	private String plInd = null;

	/* Column Info */
	private String temp = null;

	/* Column Info */
	private String tunit = null;

	/* Column Info */
	private String vent = null;

	/* Column Info */
	private String measure = null;

	/* Column Info */
	private String measureUnit = null;

	/* Column Info */
	private String rdtype = null;

	/* Column Info */
	private String cmdtDesc = null;

	/* Column Info */
	private String cmdtcd = null;

	/* Column Info */
	private String rfRemark = null;

	/* Column Info */
	private String rfdryInd = null;

	/* Column Info */
	private String ovf = null;

	/* Column Info */
	private String ovr = null;

	/* Column Info */
	private String ovh = null;

	/* Column Info */
	private String ovlw = null;

	/* Column Info */
	private String ovrw = null;

	/* Column Info */
	private String ovwgt = null;

	/* Column Info */
	private String ovwgtUnit = null;

	/* Column Info */
	private String voidSlot = null;

	/* Column Info */
	private String stwgReq = null;

	/* Column Info */
	private String socind = null;

	/* Column Info */
	private String haulage = null;

	/* Column Info */
	private String bkwgt = null;

	/* Column Info */
	private String bkwgtu = null;

	/* Column Info */
	private String bkw = null;

	/* Column Info */
	private String bkh = null;

	/* Column Info */
	private String bkl = null;

	/* Column Info */
	private String cntrown = null;

	/* Column Info */
	private String cntrtrm = null;

	/* Column Info */
	private String nodDemurrageFreetime = null;

	/* Column Info */
	private String sealseq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlCntrVO() {}

	public SitProBlLdfBlCntrVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String port, String blnbr, String cntrnbr, String punit, String pkg, String cntrwgt, String cntrgwgt, String cntrWgtUnit, String cntrtrw, String cntrtype, String sealnbr, String fmInd, String rfInd, String dgInd, String akInd, String bkInd, String plInd, String temp, String tunit, String vent, String measure, String measureUnit, String rdtype, String cmdtDesc, String cmdtcd, String rfRemark, String rfdryInd, String ovf, String ovr, String ovh, String ovlw, String ovrw, String ovwgt, String ovwgtUnit, String voidSlot, String stwgReq, String socind, String haulage, String bkwgt, String bkwgtu, String bkw, String bkh, String bkl, String cntrown, String cntrtrm, String nodDemurrageFreetime, String sealseq) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.port = port;
		this.blnbr = blnbr;
		this.cntrnbr = cntrnbr;
		this.punit = punit;
		this.pkg = pkg;
		this.cntrwgt = cntrwgt;
		this.cntrgwgt = cntrgwgt;
		this.cntrWgtUnit = cntrWgtUnit;
		this.cntrtrw = cntrtrw;
		this.cntrtype = cntrtype;
		this.sealnbr = sealnbr;
		this.fmInd = fmInd;
		this.rfInd = rfInd;
		this.dgInd = dgInd;
		this.akInd = akInd;
		this.bkInd = bkInd;
		this.plInd = plInd;
		this.temp = temp;
		this.tunit = tunit;
		this.vent = vent;
		this.measure = measure;
		this.measureUnit = measureUnit;
		this.rdtype = rdtype;
		this.cmdtDesc = cmdtDesc;
		this.cmdtcd = cmdtcd;
		this.rfRemark = rfRemark;
		this.rfdryInd = rfdryInd;
		this.ovf = ovf;
		this.ovr = ovr;
		this.ovh = ovh;
		this.ovlw = ovlw;
		this.ovrw = ovrw;
		this.ovwgt = ovwgt;
		this.ovwgtUnit = ovwgtUnit;
		this.voidSlot = voidSlot;
		this.stwgReq = stwgReq;
		this.socind = socind;
		this.haulage = haulage;
		this.bkwgt = bkwgt;
		this.bkwgtu = bkwgtu;
		this.bkw = bkw;
		this.bkh = bkh;
		this.bkl = bkl;
		this.cntrown = cntrown;
		this.cntrtrm = cntrtrm;
		this.nodDemurrageFreetime = nodDemurrageFreetime;
		this.sealseq = sealseq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ib_con_vvd", getIbConVvd());
		this.hashColumns.put("ob_con_vvd", getObConVvd());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("punit", getPunit());
		this.hashColumns.put("pkg", getPkg());
		this.hashColumns.put("cntrwgt", getCntrwgt());
		this.hashColumns.put("cntrgwgt", getCntrgwgt());
		this.hashColumns.put("cntr_wgt_unit", getCntrWgtUnit());
		this.hashColumns.put("cntrtrw", getCntrtrw());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("sealnbr", getSealnbr());
		this.hashColumns.put("fm_ind", getFmInd());
		this.hashColumns.put("rf_ind", getRfInd());
		this.hashColumns.put("dg_ind", getDgInd());
		this.hashColumns.put("ak_ind", getAkInd());
		this.hashColumns.put("bk_ind", getBkInd());
		this.hashColumns.put("pl_ind", getPlInd());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("tunit", getTunit());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("measure", getMeasure());
		this.hashColumns.put("measure_unit", getMeasureUnit());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cmdtcd", getCmdtcd());
		this.hashColumns.put("rf_remark", getRfRemark());
		this.hashColumns.put("rfdry_ind", getRfdryInd());
		this.hashColumns.put("ovf", getOvf());
		this.hashColumns.put("ovr", getOvr());
		this.hashColumns.put("ovh", getOvh());
		this.hashColumns.put("ovlw", getOvlw());
		this.hashColumns.put("ovrw", getOvrw());
		this.hashColumns.put("ovwgt", getOvwgt());
		this.hashColumns.put("ovwgt_unit", getOvwgtUnit());
		this.hashColumns.put("void_slot", getVoidSlot());
		this.hashColumns.put("stwg_req", getStwgReq());
		this.hashColumns.put("socind", getSocind());
		this.hashColumns.put("haulage", getHaulage());
		this.hashColumns.put("bkwgt", getBkwgt());
		this.hashColumns.put("bkwgtu", getBkwgtu());
		this.hashColumns.put("bkw", getBkw());
		this.hashColumns.put("bkh", getBkh());
		this.hashColumns.put("bkl", getBkl());
		this.hashColumns.put("cntrown", getCntrown());
		this.hashColumns.put("cntrtrm", getCntrtrm());
		this.hashColumns.put("nod_demurrage_freetime", getNodDemurrageFreetime());
		this.hashColumns.put("sealseq", getSealseq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ib_con_vvd", "ibConVvd");
		this.hashFields.put("ob_con_vvd", "obConVvd");
		this.hashFields.put("port", "port");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("punit", "punit");
		this.hashFields.put("pkg", "pkg");
		this.hashFields.put("cntrwgt", "cntrwgt");
		this.hashFields.put("cntrgwgt", "cntrgwgt");
		this.hashFields.put("cntr_wgt_unit", "cntrWgtUnit");
		this.hashFields.put("cntrtrw", "cntrtrw");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("sealnbr", "sealnbr");
		this.hashFields.put("fm_ind", "fmInd");
		this.hashFields.put("rf_ind", "rfInd");
		this.hashFields.put("dg_ind", "dgInd");
		this.hashFields.put("ak_ind", "akInd");
		this.hashFields.put("bk_ind", "bkInd");
		this.hashFields.put("pl_ind", "plInd");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("tunit", "tunit");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("measure", "measure");
		this.hashFields.put("measure_unit", "measureUnit");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cmdtcd", "cmdtcd");
		this.hashFields.put("rf_remark", "rfRemark");
		this.hashFields.put("rfdry_ind", "rfdryInd");
		this.hashFields.put("ovf", "ovf");
		this.hashFields.put("ovr", "ovr");
		this.hashFields.put("ovh", "ovh");
		this.hashFields.put("ovlw", "ovlw");
		this.hashFields.put("ovrw", "ovrw");
		this.hashFields.put("ovwgt", "ovwgt");
		this.hashFields.put("ovwgt_unit", "ovwgtUnit");
		this.hashFields.put("void_slot", "voidSlot");
		this.hashFields.put("stwg_req", "stwgReq");
		this.hashFields.put("socind", "socind");
		this.hashFields.put("haulage", "haulage");
		this.hashFields.put("bkwgt", "bkwgt");
		this.hashFields.put("bkwgtu", "bkwgtu");
		this.hashFields.put("bkw", "bkw");
		this.hashFields.put("bkh", "bkh");
		this.hashFields.put("bkl", "bkl");
		this.hashFields.put("cntrown", "cntrown");
		this.hashFields.put("cntrtrm", "cntrtrm");
		this.hashFields.put("nod_demurrage_freetime", "nodDemurrageFreetime");
		this.hashFields.put("sealseq", "sealseq");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * 
	 * @return String vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 *
	 * @param String ibConVvd
	 */
	public void setIbConVvd(String ibConVvd) {
		this.ibConVvd = ibConVvd;
	}
	
	/**
	 * 
	 * @return String ibConVvd
	 */
	public String getIbConVvd() {
		return this.ibConVvd;
	}
	
	/**
	 *
	 * @param String obConVvd
	 */
	public void setObConVvd(String obConVvd) {
		this.obConVvd = obConVvd;
	}
	
	/**
	 * 
	 * @return String obConVvd
	 */
	public String getObConVvd() {
		return this.obConVvd;
	}
	
	/**
	 *
	 * @param String port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * 
	 * @return String port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 *
	 * @param String blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * 
	 * @return String blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 *
	 * @param String cntrnbr
	 */
	public void setCntrnbr(String cntrnbr) {
		this.cntrnbr = cntrnbr;
	}
	
	/**
	 * 
	 * @return String cntrnbr
	 */
	public String getCntrnbr() {
		return this.cntrnbr;
	}
	
	/**
	 *
	 * @param String punit
	 */
	public void setPunit(String punit) {
		this.punit = punit;
	}
	
	/**
	 * 
	 * @return String punit
	 */
	public String getPunit() {
		return this.punit;
	}
	
	/**
	 *
	 * @param String pkg
	 */
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
	/**
	 * 
	 * @return String pkg
	 */
	public String getPkg() {
		return this.pkg;
	}
	
	/**
	 *
	 * @param String cntrwgt
	 */
	public void setCntrwgt(String cntrwgt) {
		this.cntrwgt = cntrwgt;
	}
	
	/**
	 * 
	 * @return String cntrwgt
	 */
	public String getCntrwgt() {
		return this.cntrwgt;
	}
	
	/**
	 *
	 * @param String cntrgwgt
	 */
	public void setCntrgwgt(String cntrgwgt) {
		this.cntrgwgt = cntrgwgt;
	}
	
	/**
	 * 
	 * @return String cntrgwgt
	 */
	public String getCntrgwgt() {
		return this.cntrgwgt;
	}
	
	/**
	 *
	 * @param String cntrWgtUnit
	 */
	public void setCntrWgtUnit(String cntrWgtUnit) {
		this.cntrWgtUnit = cntrWgtUnit;
	}
	
	/**
	 * 
	 * @return String cntrWgtUnit
	 */
	public String getCntrWgtUnit() {
		return this.cntrWgtUnit;
	}
	
	/**
	 *
	 * @param String cntrtrw
	 */
	public void setCntrtrw(String cntrtrw) {
		this.cntrtrw = cntrtrw;
	}
	
	/**
	 * 
	 * @return String cntrtrw
	 */
	public String getCntrtrw() {
		return this.cntrtrw;
	}
	
	/**
	 *
	 * @param String cntrtype
	 */
	public void setCntrtype(String cntrtype) {
		this.cntrtype = cntrtype;
	}
	
	/**
	 * 
	 * @return String cntrtype
	 */
	public String getCntrtype() {
		return this.cntrtype;
	}
	
	/**
	 *
	 * @param String sealnbr
	 */
	public void setSealnbr(String sealnbr) {
		this.sealnbr = sealnbr;
	}
	
	/**
	 * 
	 * @return String sealnbr
	 */
	public String getSealnbr() {
		return this.sealnbr;
	}
	
	/**
	 *
	 * @param String fmInd
	 */
	public void setFmInd(String fmInd) {
		this.fmInd = fmInd;
	}
	
	/**
	 * 
	 * @return String fmInd
	 */
	public String getFmInd() {
		return this.fmInd;
	}
	
	/**
	 *
	 * @param String rfInd
	 */
	public void setRfInd(String rfInd) {
		this.rfInd = rfInd;
	}
	
	/**
	 * 
	 * @return String rfInd
	 */
	public String getRfInd() {
		return this.rfInd;
	}
	
	/**
	 *
	 * @param String dgInd
	 */
	public void setDgInd(String dgInd) {
		this.dgInd = dgInd;
	}
	
	/**
	 * 
	 * @return String dgInd
	 */
	public String getDgInd() {
		return this.dgInd;
	}
	
	/**
	 *
	 * @param String akInd
	 */
	public void setAkInd(String akInd) {
		this.akInd = akInd;
	}
	
	/**
	 * 
	 * @return String akInd
	 */
	public String getAkInd() {
		return this.akInd;
	}
	
	/**
	 *
	 * @param String bkInd
	 */
	public void setBkInd(String bkInd) {
		this.bkInd = bkInd;
	}
	
	/**
	 * 
	 * @return String bkInd
	 */
	public String getBkInd() {
		return this.bkInd;
	}
	
	/**
	 *
	 * @param String plInd
	 */
	public void setPlInd(String plInd) {
		this.plInd = plInd;
	}
	
	/**
	 * 
	 * @return String plInd
	 */
	public String getPlInd() {
		return this.plInd;
	}
	
	/**
	 *
	 * @param String temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	/**
	 * 
	 * @return String temp
	 */
	public String getTemp() {
		return this.temp;
	}
	
	/**
	 *
	 * @param String tunit
	 */
	public void setTunit(String tunit) {
		this.tunit = tunit;
	}
	
	/**
	 * 
	 * @return String tunit
	 */
	public String getTunit() {
		return this.tunit;
	}
	
	/**
	 *
	 * @param String vent
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}
	
	/**
	 * 
	 * @return String vent
	 */
	public String getVent() {
		return this.vent;
	}
	
	/**
	 *
	 * @param String measure
	 */
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	/**
	 * 
	 * @return String measure
	 */
	public String getMeasure() {
		return this.measure;
	}
	
	/**
	 *
	 * @param String measureUnit
	 */
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	
	/**
	 * 
	 * @return String measureUnit
	 */
	public String getMeasureUnit() {
		return this.measureUnit;
	}
	
	/**
	 *
	 * @param String rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * 
	 * @return String rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 *
	 * @param String cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * 
	 * @return String cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 *
	 * @param String cmdtcd
	 */
	public void setCmdtcd(String cmdtcd) {
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * 
	 * @return String cmdtcd
	 */
	public String getCmdtcd() {
		return this.cmdtcd;
	}
	
	/**
	 *
	 * @param String rfRemark
	 */
	public void setRfRemark(String rfRemark) {
		this.rfRemark = rfRemark;
	}
	
	/**
	 * 
	 * @return String rfRemark
	 */
	public String getRfRemark() {
		return this.rfRemark;
	}
	
	/**
	 *
	 * @param String rfdryInd
	 */
	public void setRfdryInd(String rfdryInd) {
		this.rfdryInd = rfdryInd;
	}
	
	/**
	 * 
	 * @return String rfdryInd
	 */
	public String getRfdryInd() {
		return this.rfdryInd;
	}
	
	/**
	 *
	 * @param String ovf
	 */
	public void setOvf(String ovf) {
		this.ovf = ovf;
	}
	
	/**
	 * 
	 * @return String ovf
	 */
	public String getOvf() {
		return this.ovf;
	}
	
	/**
	 *
	 * @param String ovr
	 */
	public void setOvr(String ovr) {
		this.ovr = ovr;
	}
	
	/**
	 * 
	 * @return String ovr
	 */
	public String getOvr() {
		return this.ovr;
	}
	
	/**
	 *
	 * @param String ovh
	 */
	public void setOvh(String ovh) {
		this.ovh = ovh;
	}
	
	/**
	 * 
	 * @return String ovh
	 */
	public String getOvh() {
		return this.ovh;
	}
	
	/**
	 *
	 * @param String ovlw
	 */
	public void setOvlw(String ovlw) {
		this.ovlw = ovlw;
	}
	
	/**
	 * 
	 * @return String ovlw
	 */
	public String getOvlw() {
		return this.ovlw;
	}
	
	/**
	 *
	 * @param String ovrw
	 */
	public void setOvrw(String ovrw) {
		this.ovrw = ovrw;
	}
	
	/**
	 * 
	 * @return String ovrw
	 */
	public String getOvrw() {
		return this.ovrw;
	}
	
	/**
	 *
	 * @param String ovwgt
	 */
	public void setOvwgt(String ovwgt) {
		this.ovwgt = ovwgt;
	}
	
	/**
	 * 
	 * @return String ovwgt
	 */
	public String getOvwgt() {
		return this.ovwgt;
	}
	
	/**
	 *
	 * @param String ovwgtUnit
	 */
	public void setOvwgtUnit(String ovwgtUnit) {
		this.ovwgtUnit = ovwgtUnit;
	}
	
	/**
	 * 
	 * @return String ovwgtUnit
	 */
	public String getOvwgtUnit() {
		return this.ovwgtUnit;
	}
	
	/**
	 *
	 * @param String voidSlot
	 */
	public void setVoidSlot(String voidSlot) {
		this.voidSlot = voidSlot;
	}
	
	/**
	 * 
	 * @return String voidSlot
	 */
	public String getVoidSlot() {
		return this.voidSlot;
	}
	
	/**
	 *
	 * @param String stwgReq
	 */
	public void setStwgReq(String stwgReq) {
		this.stwgReq = stwgReq;
	}
	
	/**
	 * 
	 * @return String stwgReq
	 */
	public String getStwgReq() {
		return this.stwgReq;
	}
	
	/**
	 *
	 * @param String socind
	 */
	public void setSocind(String socind) {
		this.socind = socind;
	}
	
	/**
	 * 
	 * @return String socind
	 */
	public String getSocind() {
		return this.socind;
	}
	
	/**
	 *
	 * @param String haulage
	 */
	public void setHaulage(String haulage) {
		this.haulage = haulage;
	}
	
	/**
	 * 
	 * @return String haulage
	 */
	public String getHaulage() {
		return this.haulage;
	}
	
	/**
	 *
	 * @param String bkwgt
	 */
	public void setBkwgt(String bkwgt) {
		this.bkwgt = bkwgt;
	}
	
	/**
	 * 
	 * @return String bkwgt
	 */
	public String getBkwgt() {
		return this.bkwgt;
	}
	
	/**
	 *
	 * @param String bkwgtu
	 */
	public void setBkwgtu(String bkwgtu) {
		this.bkwgtu = bkwgtu;
	}
	
	/**
	 * 
	 * @return String bkwgtu
	 */
	public String getBkwgtu() {
		return this.bkwgtu;
	}
	
	/**
	 *
	 * @param String bkw
	 */
	public void setBkw(String bkw) {
		this.bkw = bkw;
	}
	
	/**
	 * 
	 * @return String bkw
	 */
	public String getBkw() {
		return this.bkw;
	}
	
	/**
	 *
	 * @param String bkh
	 */
	public void setBkh(String bkh) {
		this.bkh = bkh;
	}
	
	/**
	 * 
	 * @return String bkh
	 */
	public String getBkh() {
		return this.bkh;
	}
	
	/**
	 *
	 * @param String bkl
	 */
	public void setBkl(String bkl) {
		this.bkl = bkl;
	}
	
	/**
	 * 
	 * @return String bkl
	 */
	public String getBkl() {
		return this.bkl;
	}
	
	/**
	 *
	 * @param String cntrown
	 */
	public void setCntrown(String cntrown) {
		this.cntrown = cntrown;
	}
	
	/**
	 * 
	 * @return String cntrown
	 */
	public String getCntrown() {
		return this.cntrown;
	}
	
	/**
	 *
	 * @param String cntrtrm
	 */
	public void setCntrtrm(String cntrtrm) {
		this.cntrtrm = cntrtrm;
	}
	
	/**
	 * 
	 * @return String cntrtrm
	 */
	public String getCntrtrm() {
		return this.cntrtrm;
	}
	
	/**
	 *
	 * @param String nodDemurrageFreetime
	 */
	public void setNodDemurrageFreetime(String nodDemurrageFreetime) {
		this.nodDemurrageFreetime = nodDemurrageFreetime;
	}
	
	/**
	 * 
	 * @return String nodDemurrageFreetime
	 */
	public String getNodDemurrageFreetime() {
		return this.nodDemurrageFreetime;
	}
	
	/**
	 *
	 * @param String sealseq
	 */
	public void setSealseq(String sealseq) {
		this.sealseq = sealseq;
	}
	
	/**
	 * 
	 * @return String sealseq
	 */
	public String getSealseq() {
		return this.sealseq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbConVvd(JSPUtil.getParameter(request, prefix + "ib_con_vvd", ""));
		setObConVvd(JSPUtil.getParameter(request, prefix + "ob_con_vvd", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setCntrnbr(JSPUtil.getParameter(request, prefix + "cntrnbr", ""));
		setPunit(JSPUtil.getParameter(request, prefix + "punit", ""));
		setPkg(JSPUtil.getParameter(request, prefix + "pkg", ""));
		setCntrwgt(JSPUtil.getParameter(request, prefix + "cntrwgt", ""));
		setCntrgwgt(JSPUtil.getParameter(request, prefix + "cntrgwgt", ""));
		setCntrWgtUnit(JSPUtil.getParameter(request, prefix + "cntr_wgt_unit", ""));
		setCntrtrw(JSPUtil.getParameter(request, prefix + "cntrtrw", ""));
		setCntrtype(JSPUtil.getParameter(request, prefix + "cntrtype", ""));
		setSealnbr(JSPUtil.getParameter(request, prefix + "sealnbr", ""));
		setFmInd(JSPUtil.getParameter(request, prefix + "fm_ind", ""));
		setRfInd(JSPUtil.getParameter(request, prefix + "rf_ind", ""));
		setDgInd(JSPUtil.getParameter(request, prefix + "dg_ind", ""));
		setAkInd(JSPUtil.getParameter(request, prefix + "ak_ind", ""));
		setBkInd(JSPUtil.getParameter(request, prefix + "bk_ind", ""));
		setPlInd(JSPUtil.getParameter(request, prefix + "pl_ind", ""));
		setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
		setTunit(JSPUtil.getParameter(request, prefix + "tunit", ""));
		setVent(JSPUtil.getParameter(request, prefix + "vent", ""));
		setMeasure(JSPUtil.getParameter(request, prefix + "measure", ""));
		setMeasureUnit(JSPUtil.getParameter(request, prefix + "measure_unit", ""));
		setRdtype(JSPUtil.getParameter(request, prefix + "rdtype", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCmdtcd(JSPUtil.getParameter(request, prefix + "cmdtcd", ""));
		setRfRemark(JSPUtil.getParameter(request, prefix + "rf_remark", ""));
		setRfdryInd(JSPUtil.getParameter(request, prefix + "rfdry_ind", ""));
		setOvf(JSPUtil.getParameter(request, prefix + "ovf", ""));
		setOvr(JSPUtil.getParameter(request, prefix + "ovr", ""));
		setOvh(JSPUtil.getParameter(request, prefix + "ovh", ""));
		setOvlw(JSPUtil.getParameter(request, prefix + "ovlw", ""));
		setOvrw(JSPUtil.getParameter(request, prefix + "ovrw", ""));
		setOvwgt(JSPUtil.getParameter(request, prefix + "ovwgt", ""));
		setOvwgtUnit(JSPUtil.getParameter(request, prefix + "ovwgt_unit", ""));
		setVoidSlot(JSPUtil.getParameter(request, prefix + "void_slot", ""));
		setStwgReq(JSPUtil.getParameter(request, prefix + "stwg_req", ""));
		setSocind(JSPUtil.getParameter(request, prefix + "socind", ""));
		setHaulage(JSPUtil.getParameter(request, prefix + "haulage", ""));
		setBkwgt(JSPUtil.getParameter(request, prefix + "bkwgt", ""));
		setBkwgtu(JSPUtil.getParameter(request, prefix + "bkwgtu", ""));
		setBkw(JSPUtil.getParameter(request, prefix + "bkw", ""));
		setBkh(JSPUtil.getParameter(request, prefix + "bkh", ""));
		setBkl(JSPUtil.getParameter(request, prefix + "bkl", ""));
		setCntrown(JSPUtil.getParameter(request, prefix + "cntrown", ""));
		setCntrtrm(JSPUtil.getParameter(request, prefix + "cntrtrm", ""));
		setNodDemurrageFreetime(JSPUtil.getParameter(request, prefix + "nod_demurrage_freetime", ""));
		setSealseq(JSPUtil.getParameter(request, prefix + "sealseq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlCntrVO[]
	 */
	public SitProBlLdfBlCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlCntrVO[]
	 */
	public SitProBlLdfBlCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibConVvd = (JSPUtil.getParameter(request, prefix	+ "ib_con_vvd", length));
			String[] obConVvd = (JSPUtil.getParameter(request, prefix	+ "ob_con_vvd", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] punit = (JSPUtil.getParameter(request, prefix	+ "punit", length));
			String[] pkg = (JSPUtil.getParameter(request, prefix	+ "pkg", length));
			String[] cntrwgt = (JSPUtil.getParameter(request, prefix	+ "cntrwgt", length));
			String[] cntrgwgt = (JSPUtil.getParameter(request, prefix	+ "cntrgwgt", length));
			String[] cntrWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_unit", length));
			String[] cntrtrw = (JSPUtil.getParameter(request, prefix	+ "cntrtrw", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] sealnbr = (JSPUtil.getParameter(request, prefix	+ "sealnbr", length));
			String[] fmInd = (JSPUtil.getParameter(request, prefix	+ "fm_ind", length));
			String[] rfInd = (JSPUtil.getParameter(request, prefix	+ "rf_ind", length));
			String[] dgInd = (JSPUtil.getParameter(request, prefix	+ "dg_ind", length));
			String[] akInd = (JSPUtil.getParameter(request, prefix	+ "ak_ind", length));
			String[] bkInd = (JSPUtil.getParameter(request, prefix	+ "bk_ind", length));
			String[] plInd = (JSPUtil.getParameter(request, prefix	+ "pl_ind", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] tunit = (JSPUtil.getParameter(request, prefix	+ "tunit", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] measure = (JSPUtil.getParameter(request, prefix	+ "measure", length));
			String[] measureUnit = (JSPUtil.getParameter(request, prefix	+ "measure_unit", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cmdtcd = (JSPUtil.getParameter(request, prefix	+ "cmdtcd", length));
			String[] rfRemark = (JSPUtil.getParameter(request, prefix	+ "rf_remark", length));
			String[] rfdryInd = (JSPUtil.getParameter(request, prefix	+ "rfdry_ind", length));
			String[] ovf = (JSPUtil.getParameter(request, prefix	+ "ovf", length));
			String[] ovr = (JSPUtil.getParameter(request, prefix	+ "ovr", length));
			String[] ovh = (JSPUtil.getParameter(request, prefix	+ "ovh", length));
			String[] ovlw = (JSPUtil.getParameter(request, prefix	+ "ovlw", length));
			String[] ovrw = (JSPUtil.getParameter(request, prefix	+ "ovrw", length));
			String[] ovwgt = (JSPUtil.getParameter(request, prefix	+ "ovwgt", length));
			String[] ovwgtUnit = (JSPUtil.getParameter(request, prefix	+ "ovwgt_unit", length));
			String[] voidSlot = (JSPUtil.getParameter(request, prefix	+ "void_slot", length));
			String[] stwgReq = (JSPUtil.getParameter(request, prefix	+ "stwg_req", length));
			String[] socind = (JSPUtil.getParameter(request, prefix	+ "socind", length));
			String[] haulage = (JSPUtil.getParameter(request, prefix	+ "haulage", length));
			String[] bkwgt = (JSPUtil.getParameter(request, prefix	+ "bkwgt", length));
			String[] bkwgtu = (JSPUtil.getParameter(request, prefix	+ "bkwgtu", length));
			String[] bkw = (JSPUtil.getParameter(request, prefix	+ "bkw", length));
			String[] bkh = (JSPUtil.getParameter(request, prefix	+ "bkh", length));
			String[] bkl = (JSPUtil.getParameter(request, prefix	+ "bkl", length));
			String[] cntrown = (JSPUtil.getParameter(request, prefix	+ "cntrown", length));
			String[] cntrtrm = (JSPUtil.getParameter(request, prefix	+ "cntrtrm", length));
			String[] nodDemurrageFreetime = (JSPUtil.getParameter(request, prefix	+ "nod_demurrage_freetime", length));
			String[] sealseq = (JSPUtil.getParameter(request, prefix	+ "sealseq", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlCntrVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null) 
					model.setVvd(vvd[i]);
				if (ibConVvd[i] != null) 
					model.setIbConVvd(ibConVvd[i]);
				if (obConVvd[i] != null) 
					model.setObConVvd(obConVvd[i]);
				if (port[i] != null) 
					model.setPort(port[i]);
				if (blnbr[i] != null) 
					model.setBlnbr(blnbr[i]);
				if (cntrnbr[i] != null) 
					model.setCntrnbr(cntrnbr[i]);
				if (punit[i] != null) 
					model.setPunit(punit[i]);
				if (pkg[i] != null) 
					model.setPkg(pkg[i]);
				if (cntrwgt[i] != null) 
					model.setCntrwgt(cntrwgt[i]);
				if (cntrgwgt[i] != null) 
					model.setCntrgwgt(cntrgwgt[i]);
				if (cntrWgtUnit[i] != null) 
					model.setCntrWgtUnit(cntrWgtUnit[i]);
				if (cntrtrw[i] != null) 
					model.setCntrtrw(cntrtrw[i]);
				if (cntrtype[i] != null) 
					model.setCntrtype(cntrtype[i]);
				if (sealnbr[i] != null) 
					model.setSealnbr(sealnbr[i]);
				if (fmInd[i] != null) 
					model.setFmInd(fmInd[i]);
				if (rfInd[i] != null) 
					model.setRfInd(rfInd[i]);
				if (dgInd[i] != null) 
					model.setDgInd(dgInd[i]);
				if (akInd[i] != null) 
					model.setAkInd(akInd[i]);
				if (bkInd[i] != null) 
					model.setBkInd(bkInd[i]);
				if (plInd[i] != null) 
					model.setPlInd(plInd[i]);
				if (temp[i] != null) 
					model.setTemp(temp[i]);
				if (tunit[i] != null) 
					model.setTunit(tunit[i]);
				if (vent[i] != null) 
					model.setVent(vent[i]);
				if (measure[i] != null) 
					model.setMeasure(measure[i]);
				if (measureUnit[i] != null) 
					model.setMeasureUnit(measureUnit[i]);
				if (rdtype[i] != null) 
					model.setRdtype(rdtype[i]);
				if (cmdtDesc[i] != null) 
					model.setCmdtDesc(cmdtDesc[i]);
				if (cmdtcd[i] != null) 
					model.setCmdtcd(cmdtcd[i]);
				if (rfRemark[i] != null) 
					model.setRfRemark(rfRemark[i]);
				if (rfdryInd[i] != null) 
					model.setRfdryInd(rfdryInd[i]);
				if (ovf[i] != null) 
					model.setOvf(ovf[i]);
				if (ovr[i] != null) 
					model.setOvr(ovr[i]);
				if (ovh[i] != null) 
					model.setOvh(ovh[i]);
				if (ovlw[i] != null) 
					model.setOvlw(ovlw[i]);
				if (ovrw[i] != null) 
					model.setOvrw(ovrw[i]);
				if (ovwgt[i] != null) 
					model.setOvwgt(ovwgt[i]);
				if (ovwgtUnit[i] != null) 
					model.setOvwgtUnit(ovwgtUnit[i]);
				if (voidSlot[i] != null) 
					model.setVoidSlot(voidSlot[i]);
				if (stwgReq[i] != null) 
					model.setStwgReq(stwgReq[i]);
				if (socind[i] != null) 
					model.setSocind(socind[i]);
				if (haulage[i] != null) 
					model.setHaulage(haulage[i]);
				if (bkwgt[i] != null) 
					model.setBkwgt(bkwgt[i]);
				if (bkwgtu[i] != null) 
					model.setBkwgtu(bkwgtu[i]);
				if (bkw[i] != null) 
					model.setBkw(bkw[i]);
				if (bkh[i] != null) 
					model.setBkh(bkh[i]);
				if (bkl[i] != null) 
					model.setBkl(bkl[i]);
				if (cntrown[i] != null) 
					model.setCntrown(cntrown[i]);
				if (cntrtrm[i] != null) 
					model.setCntrtrm(cntrtrm[i]);
				if (nodDemurrageFreetime[i] != null) 
					model.setNodDemurrageFreetime(nodDemurrageFreetime[i]);
				if (sealseq[i] != null) 
					model.setSealseq(sealseq[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlCntrVO[]
	 */
	public SitProBlLdfBlCntrVO[] getSitProBlLdfBlCntrVOs(){
		SitProBlLdfBlCntrVO[] vos = (SitProBlLdfBlCntrVO[])models.toArray(new SitProBlLdfBlCntrVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibConVvd = this.ibConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obConVvd = this.obConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.punit = this.punit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg = this.pkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrwgt = this.cntrwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrgwgt = this.cntrgwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUnit = this.cntrWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtrw = this.cntrtrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealnbr = this.sealnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInd = this.fmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfInd = this.rfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgInd = this.dgInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akInd = this.akInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkInd = this.bkInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInd = this.plInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tunit = this.tunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measure = this.measure .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measureUnit = this.measureUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtcd = this.cmdtcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRemark = this.rfRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfdryInd = this.rfdryInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovf = this.ovf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovr = this.ovr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovh = this.ovh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovlw = this.ovlw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrw = this.ovrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwgt = this.ovwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwgtUnit = this.ovwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidSlot = this.voidSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgReq = this.stwgReq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socind = this.socind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulage = this.haulage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwgt = this.bkwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwgtu = this.bkwgtu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkw = this.bkw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkh = this.bkh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkl = this.bkl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrown = this.cntrown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtrm = this.cntrtrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodDemurrageFreetime = this.nodDemurrageFreetime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealseq = this.sealseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}