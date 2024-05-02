/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExCntrTransmitCntrSpecialInfoVO.java
*@FileTitle : ExCntrTransmitCntrSpecialInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExCntrTransmitCntrSpecialInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExCntrTransmitCntrSpecialInfoVO> models = new ArrayList<ExCntrTransmitCntrSpecialInfoVO>();
	
	/* Column Info */
	private String bkh = null;
	/* Column Info */
	private String cntrown = null;
	/* Column Info */
	private String measureUnit = null;
	/* Column Info */
	private String cntrtrm = null;
	/* Column Info */
	private String bkwgt = null;
	/* Column Info */
	private String ovrw = null;
	/* Column Info */
	private String measure = null;
	/* Column Info */
	private String tunit = null;
	/* Column Info */
	private String sealnbr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovh = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dgInd = null;
	/* Column Info */
	private String cntrtrw = null;
	/* Column Info */
	private String ovwgt = null;
	/* Column Info */
	private String ovr = null;
	/* Column Info */
	private String akInd = null;
	/* Column Info */
	private String ovwgtUnit = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String rfdryInd = null;
	/* Column Info */
	private String stwgReq = null;
	/* Column Info */
	private String voidSlot = null;
	/* Column Info */
	private String ovlw = null;
	/* Column Info */
	private String fmInd = null;
	/* Column Info */
	private String cntrgwgt = null;
	/* Column Info */
	private String socind = null;
	/* Column Info */
	private String vent = null;
	/* Column Info */
	private String rfRemark = null;
	/* Column Info */
	private String cntrnbr = null;
	/* Column Info */
	private String pkg = null;
	/* Column Info */
	private String bkInd = null;
	/* Column Info */
	private String bkwgtu = null;
	/* Column Info */
	private String ovf = null;
	/* Column Info */
	private String cntrwgt = null;
	/* Column Info */
	private String cntrtype = null;
	/* Column Info */
	private String rfInd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkw = null;
	/* Column Info */
	private String punit = null;
	/* Column Info */
	private String cntrWgtUnit = null;
	/* Column Info */
	private String haulage = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String bkl = null;
	/* Column Info */
	private String cmdtcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExCntrTransmitCntrSpecialInfoVO() {}

	public ExCntrTransmitCntrSpecialInfoVO(String ibflag, String pagerows, String cntrnbr, String punit, String pkg, String cntrwgt, String cntrgwgt, String cntrWgtUnit, String cntrtrw, String cntrtype, String sealnbr, String fmInd, String rfInd, String dgInd, String akInd, String bkInd, String temp, String tunit, String vent, String measure, String measureUnit, String rdtype, String cmdtDesc, String cmdtcd, String rfRemark, String rfdryInd, String ovf, String ovr, String ovh, String ovlw, String ovrw, String ovwgt, String ovwgtUnit, String voidSlot, String stwgReq, String socind, String haulage, String bkwgt, String bkwgtu, String bkw, String bkh, String bkl, String cntrown, String cntrtrm, String cntrNo) {
		this.bkh = bkh;
		this.cntrown = cntrown;
		this.measureUnit = measureUnit;
		this.cntrtrm = cntrtrm;
		this.bkwgt = bkwgt;
		this.ovrw = ovrw;
		this.measure = measure;
		this.tunit = tunit;
		this.sealnbr = sealnbr;
		this.pagerows = pagerows;
		this.ovh = ovh;
		this.ibflag = ibflag;
		this.dgInd = dgInd;
		this.cntrtrw = cntrtrw;
		this.ovwgt = ovwgt;
		this.ovr = ovr;
		this.akInd = akInd;
		this.ovwgtUnit = ovwgtUnit;
		this.rdtype = rdtype;
		this.rfdryInd = rfdryInd;
		this.stwgReq = stwgReq;
		this.voidSlot = voidSlot;
		this.ovlw = ovlw;
		this.fmInd = fmInd;
		this.cntrgwgt = cntrgwgt;
		this.socind = socind;
		this.vent = vent;
		this.rfRemark = rfRemark;
		this.cntrnbr = cntrnbr;
		this.pkg = pkg;
		this.bkInd = bkInd;
		this.bkwgtu = bkwgtu;
		this.ovf = ovf;
		this.cntrwgt = cntrwgt;
		this.cntrtype = cntrtype;
		this.rfInd = rfInd;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.bkw = bkw;
		this.punit = punit;
		this.cntrWgtUnit = cntrWgtUnit;
		this.haulage = haulage;
		this.temp = temp;
		this.bkl = bkl;
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkh", getBkh());
		this.hashColumns.put("cntrown", getCntrown());
		this.hashColumns.put("measure_unit", getMeasureUnit());
		this.hashColumns.put("cntrtrm", getCntrtrm());
		this.hashColumns.put("bkwgt", getBkwgt());
		this.hashColumns.put("ovrw", getOvrw());
		this.hashColumns.put("measure", getMeasure());
		this.hashColumns.put("tunit", getTunit());
		this.hashColumns.put("sealnbr", getSealnbr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovh", getOvh());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg_ind", getDgInd());
		this.hashColumns.put("cntrtrw", getCntrtrw());
		this.hashColumns.put("ovwgt", getOvwgt());
		this.hashColumns.put("ovr", getOvr());
		this.hashColumns.put("ak_ind", getAkInd());
		this.hashColumns.put("ovwgt_unit", getOvwgtUnit());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("rfdry_ind", getRfdryInd());
		this.hashColumns.put("stwg_req", getStwgReq());
		this.hashColumns.put("void_slot", getVoidSlot());
		this.hashColumns.put("ovlw", getOvlw());
		this.hashColumns.put("fm_ind", getFmInd());
		this.hashColumns.put("cntrgwgt", getCntrgwgt());
		this.hashColumns.put("socind", getSocind());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("rf_remark", getRfRemark());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("pkg", getPkg());
		this.hashColumns.put("bk_ind", getBkInd());
		this.hashColumns.put("bkwgtu", getBkwgtu());
		this.hashColumns.put("ovf", getOvf());
		this.hashColumns.put("cntrwgt", getCntrwgt());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("rf_ind", getRfInd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkw", getBkw());
		this.hashColumns.put("punit", getPunit());
		this.hashColumns.put("cntr_wgt_unit", getCntrWgtUnit());
		this.hashColumns.put("haulage", getHaulage());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("bkl", getBkl());
		this.hashColumns.put("cmdtcd", getCmdtcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkh", "bkh");
		this.hashFields.put("cntrown", "cntrown");
		this.hashFields.put("measure_unit", "measureUnit");
		this.hashFields.put("cntrtrm", "cntrtrm");
		this.hashFields.put("bkwgt", "bkwgt");
		this.hashFields.put("ovrw", "ovrw");
		this.hashFields.put("measure", "measure");
		this.hashFields.put("tunit", "tunit");
		this.hashFields.put("sealnbr", "sealnbr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovh", "ovh");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg_ind", "dgInd");
		this.hashFields.put("cntrtrw", "cntrtrw");
		this.hashFields.put("ovwgt", "ovwgt");
		this.hashFields.put("ovr", "ovr");
		this.hashFields.put("ak_ind", "akInd");
		this.hashFields.put("ovwgt_unit", "ovwgtUnit");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("rfdry_ind", "rfdryInd");
		this.hashFields.put("stwg_req", "stwgReq");
		this.hashFields.put("void_slot", "voidSlot");
		this.hashFields.put("ovlw", "ovlw");
		this.hashFields.put("fm_ind", "fmInd");
		this.hashFields.put("cntrgwgt", "cntrgwgt");
		this.hashFields.put("socind", "socind");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("rf_remark", "rfRemark");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("pkg", "pkg");
		this.hashFields.put("bk_ind", "bkInd");
		this.hashFields.put("bkwgtu", "bkwgtu");
		this.hashFields.put("ovf", "ovf");
		this.hashFields.put("cntrwgt", "cntrwgt");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("rf_ind", "rfInd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkw", "bkw");
		this.hashFields.put("punit", "punit");
		this.hashFields.put("cntr_wgt_unit", "cntrWgtUnit");
		this.hashFields.put("haulage", "haulage");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("bkl", "bkl");
		this.hashFields.put("cmdtcd", "cmdtcd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkh
	 */
	public String getBkh() {
		return this.bkh;
	}
	
	/**
	 * Column Info
	 * @return cntrown
	 */
	public String getCntrown() {
		return this.cntrown;
	}
	
	/**
	 * Column Info
	 * @return measureUnit
	 */
	public String getMeasureUnit() {
		return this.measureUnit;
	}
	
	/**
	 * Column Info
	 * @return cntrtrm
	 */
	public String getCntrtrm() {
		return this.cntrtrm;
	}
	
	/**
	 * Column Info
	 * @return bkwgt
	 */
	public String getBkwgt() {
		return this.bkwgt;
	}
	
	/**
	 * Column Info
	 * @return ovrw
	 */
	public String getOvrw() {
		return this.ovrw;
	}
	
	/**
	 * Column Info
	 * @return measure
	 */
	public String getMeasure() {
		return this.measure;
	}
	
	/**
	 * Column Info
	 * @return tunit
	 */
	public String getTunit() {
		return this.tunit;
	}
	
	/**
	 * Column Info
	 * @return sealnbr
	 */
	public String getSealnbr() {
		return this.sealnbr;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ovh
	 */
	public String getOvh() {
		return this.ovh;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return dgInd
	 */
	public String getDgInd() {
		return this.dgInd;
	}
	
	/**
	 * Column Info
	 * @return cntrtrw
	 */
	public String getCntrtrw() {
		return this.cntrtrw;
	}
	
	/**
	 * Column Info
	 * @return ovwgt
	 */
	public String getOvwgt() {
		return this.ovwgt;
	}
	
	/**
	 * Column Info
	 * @return ovr
	 */
	public String getOvr() {
		return this.ovr;
	}
	
	/**
	 * Column Info
	 * @return akInd
	 */
	public String getAkInd() {
		return this.akInd;
	}
	
	/**
	 * Column Info
	 * @return ovwgtUnit
	 */
	public String getOvwgtUnit() {
		return this.ovwgtUnit;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return rfdryInd
	 */
	public String getRfdryInd() {
		return this.rfdryInd;
	}
	
	/**
	 * Column Info
	 * @return stwgReq
	 */
	public String getStwgReq() {
		return this.stwgReq;
	}
	
	/**
	 * Column Info
	 * @return voidSlot
	 */
	public String getVoidSlot() {
		return this.voidSlot;
	}
	
	/**
	 * Column Info
	 * @return ovlw
	 */
	public String getOvlw() {
		return this.ovlw;
	}
	
	/**
	 * Column Info
	 * @return fmInd
	 */
	public String getFmInd() {
		return this.fmInd;
	}
	
	/**
	 * Column Info
	 * @return cntrgwgt
	 */
	public String getCntrgwgt() {
		return this.cntrgwgt;
	}
	
	/**
	 * Column Info
	 * @return socind
	 */
	public String getSocind() {
		return this.socind;
	}
	
	/**
	 * Column Info
	 * @return vent
	 */
	public String getVent() {
		return this.vent;
	}
	
	/**
	 * Column Info
	 * @return rfRemark
	 */
	public String getRfRemark() {
		return this.rfRemark;
	}
	
	/**
	 * Column Info
	 * @return cntrnbr
	 */
	public String getCntrnbr() {
		return this.cntrnbr;
	}
	
	/**
	 * Column Info
	 * @return pkg
	 */
	public String getPkg() {
		return this.pkg;
	}
	
	/**
	 * Column Info
	 * @return bkInd
	 */
	public String getBkInd() {
		return this.bkInd;
	}
	
	/**
	 * Column Info
	 * @return bkwgtu
	 */
	public String getBkwgtu() {
		return this.bkwgtu;
	}
	
	/**
	 * Column Info
	 * @return ovf
	 */
	public String getOvf() {
		return this.ovf;
	}
	
	/**
	 * Column Info
	 * @return cntrwgt
	 */
	public String getCntrwgt() {
		return this.cntrwgt;
	}
	
	/**
	 * Column Info
	 * @return cntrtype
	 */
	public String getCntrtype() {
		return this.cntrtype;
	}
	
	/**
	 * Column Info
	 * @return rfInd
	 */
	public String getRfInd() {
		return this.rfInd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkw
	 */
	public String getBkw() {
		return this.bkw;
	}
	
	/**
	 * Column Info
	 * @return punit
	 */
	public String getPunit() {
		return this.punit;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtUnit
	 */
	public String getCntrWgtUnit() {
		return this.cntrWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return haulage
	 */
	public String getHaulage() {
		return this.haulage;
	}
	
	/**
	 * Column Info
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
	}
	
	/**
	 * Column Info
	 * @return bkl
	 */
	public String getBkl() {
		return this.bkl;
	}
	
	/**
	 * Column Info
	 * @return cmdtcd
	 */
	public String getCmdtcd() {
		return this.cmdtcd;
	}
	

	/**
	 * Column Info
	 * @param bkh
	 */
	public void setBkh(String bkh) {
		this.bkh = bkh;
	}
	
	/**
	 * Column Info
	 * @param cntrown
	 */
	public void setCntrown(String cntrown) {
		this.cntrown = cntrown;
	}
	
	/**
	 * Column Info
	 * @param measureUnit
	 */
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	
	/**
	 * Column Info
	 * @param cntrtrm
	 */
	public void setCntrtrm(String cntrtrm) {
		this.cntrtrm = cntrtrm;
	}
	
	/**
	 * Column Info
	 * @param bkwgt
	 */
	public void setBkwgt(String bkwgt) {
		this.bkwgt = bkwgt;
	}
	
	/**
	 * Column Info
	 * @param ovrw
	 */
	public void setOvrw(String ovrw) {
		this.ovrw = ovrw;
	}
	
	/**
	 * Column Info
	 * @param measure
	 */
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	/**
	 * Column Info
	 * @param tunit
	 */
	public void setTunit(String tunit) {
		this.tunit = tunit;
	}
	
	/**
	 * Column Info
	 * @param sealnbr
	 */
	public void setSealnbr(String sealnbr) {
		this.sealnbr = sealnbr;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ovh
	 */
	public void setOvh(String ovh) {
		this.ovh = ovh;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param dgInd
	 */
	public void setDgInd(String dgInd) {
		this.dgInd = dgInd;
	}
	
	/**
	 * Column Info
	 * @param cntrtrw
	 */
	public void setCntrtrw(String cntrtrw) {
		this.cntrtrw = cntrtrw;
	}
	
	/**
	 * Column Info
	 * @param ovwgt
	 */
	public void setOvwgt(String ovwgt) {
		this.ovwgt = ovwgt;
	}
	
	/**
	 * Column Info
	 * @param ovr
	 */
	public void setOvr(String ovr) {
		this.ovr = ovr;
	}
	
	/**
	 * Column Info
	 * @param akInd
	 */
	public void setAkInd(String akInd) {
		this.akInd = akInd;
	}
	
	/**
	 * Column Info
	 * @param ovwgtUnit
	 */
	public void setOvwgtUnit(String ovwgtUnit) {
		this.ovwgtUnit = ovwgtUnit;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param rfdryInd
	 */
	public void setRfdryInd(String rfdryInd) {
		this.rfdryInd = rfdryInd;
	}
	
	/**
	 * Column Info
	 * @param stwgReq
	 */
	public void setStwgReq(String stwgReq) {
		this.stwgReq = stwgReq;
	}
	
	/**
	 * Column Info
	 * @param voidSlot
	 */
	public void setVoidSlot(String voidSlot) {
		this.voidSlot = voidSlot;
	}
	
	/**
	 * Column Info
	 * @param ovlw
	 */
	public void setOvlw(String ovlw) {
		this.ovlw = ovlw;
	}
	
	/**
	 * Column Info
	 * @param fmInd
	 */
	public void setFmInd(String fmInd) {
		this.fmInd = fmInd;
	}
	
	/**
	 * Column Info
	 * @param cntrgwgt
	 */
	public void setCntrgwgt(String cntrgwgt) {
		this.cntrgwgt = cntrgwgt;
	}
	
	/**
	 * Column Info
	 * @param socind
	 */
	public void setSocind(String socind) {
		this.socind = socind;
	}
	
	/**
	 * Column Info
	 * @param vent
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}
	
	/**
	 * Column Info
	 * @param rfRemark
	 */
	public void setRfRemark(String rfRemark) {
		this.rfRemark = rfRemark;
	}
	
	/**
	 * Column Info
	 * @param cntrnbr
	 */
	public void setCntrnbr(String cntrnbr) {
		this.cntrnbr = cntrnbr;
	}
	
	/**
	 * Column Info
	 * @param pkg
	 */
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
	/**
	 * Column Info
	 * @param bkInd
	 */
	public void setBkInd(String bkInd) {
		this.bkInd = bkInd;
	}
	
	/**
	 * Column Info
	 * @param bkwgtu
	 */
	public void setBkwgtu(String bkwgtu) {
		this.bkwgtu = bkwgtu;
	}
	
	/**
	 * Column Info
	 * @param ovf
	 */
	public void setOvf(String ovf) {
		this.ovf = ovf;
	}
	
	/**
	 * Column Info
	 * @param cntrwgt
	 */
	public void setCntrwgt(String cntrwgt) {
		this.cntrwgt = cntrwgt;
	}
	
	/**
	 * Column Info
	 * @param cntrtype
	 */
	public void setCntrtype(String cntrtype) {
		this.cntrtype = cntrtype;
	}
	
	/**
	 * Column Info
	 * @param rfInd
	 */
	public void setRfInd(String rfInd) {
		this.rfInd = rfInd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkw
	 */
	public void setBkw(String bkw) {
		this.bkw = bkw;
	}
	
	/**
	 * Column Info
	 * @param punit
	 */
	public void setPunit(String punit) {
		this.punit = punit;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtUnit
	 */
	public void setCntrWgtUnit(String cntrWgtUnit) {
		this.cntrWgtUnit = cntrWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param haulage
	 */
	public void setHaulage(String haulage) {
		this.haulage = haulage;
	}
	
	/**
	 * Column Info
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	/**
	 * Column Info
	 * @param bkl
	 */
	public void setBkl(String bkl) {
		this.bkl = bkl;
	}
	
	/**
	 * Column Info
	 * @param cmdtcd
	 */
	public void setCmdtcd(String cmdtcd) {
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkh(JSPUtil.getParameter(request, "bkh", ""));
		setCntrown(JSPUtil.getParameter(request, "cntrown", ""));
		setMeasureUnit(JSPUtil.getParameter(request, "measure_unit", ""));
		setCntrtrm(JSPUtil.getParameter(request, "cntrtrm", ""));
		setBkwgt(JSPUtil.getParameter(request, "bkwgt", ""));
		setOvrw(JSPUtil.getParameter(request, "ovrw", ""));
		setMeasure(JSPUtil.getParameter(request, "measure", ""));
		setTunit(JSPUtil.getParameter(request, "tunit", ""));
		setSealnbr(JSPUtil.getParameter(request, "sealnbr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOvh(JSPUtil.getParameter(request, "ovh", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDgInd(JSPUtil.getParameter(request, "dg_ind", ""));
		setCntrtrw(JSPUtil.getParameter(request, "cntrtrw", ""));
		setOvwgt(JSPUtil.getParameter(request, "ovwgt", ""));
		setOvr(JSPUtil.getParameter(request, "ovr", ""));
		setAkInd(JSPUtil.getParameter(request, "ak_ind", ""));
		setOvwgtUnit(JSPUtil.getParameter(request, "ovwgt_unit", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setRfdryInd(JSPUtil.getParameter(request, "rfdry_ind", ""));
		setStwgReq(JSPUtil.getParameter(request, "stwg_req", ""));
		setVoidSlot(JSPUtil.getParameter(request, "void_slot", ""));
		setOvlw(JSPUtil.getParameter(request, "ovlw", ""));
		setFmInd(JSPUtil.getParameter(request, "fm_ind", ""));
		setCntrgwgt(JSPUtil.getParameter(request, "cntrgwgt", ""));
		setSocind(JSPUtil.getParameter(request, "socind", ""));
		setVent(JSPUtil.getParameter(request, "vent", ""));
		setRfRemark(JSPUtil.getParameter(request, "rf_remark", ""));
		setCntrnbr(JSPUtil.getParameter(request, "cntrnbr", ""));
		setPkg(JSPUtil.getParameter(request, "pkg", ""));
		setBkInd(JSPUtil.getParameter(request, "bk_ind", ""));
		setBkwgtu(JSPUtil.getParameter(request, "bkwgtu", ""));
		setOvf(JSPUtil.getParameter(request, "ovf", ""));
		setCntrwgt(JSPUtil.getParameter(request, "cntrwgt", ""));
		setCntrtype(JSPUtil.getParameter(request, "cntrtype", ""));
		setRfInd(JSPUtil.getParameter(request, "rf_ind", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBkw(JSPUtil.getParameter(request, "bkw", ""));
		setPunit(JSPUtil.getParameter(request, "punit", ""));
		setCntrWgtUnit(JSPUtil.getParameter(request, "cntr_wgt_unit", ""));
		setHaulage(JSPUtil.getParameter(request, "haulage", ""));
		setTemp(JSPUtil.getParameter(request, "temp", ""));
		setBkl(JSPUtil.getParameter(request, "bkl", ""));
		setCmdtcd(JSPUtil.getParameter(request, "cmdtcd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExCntrTransmitCntrSpecialInfoVO[]
	 */
	public ExCntrTransmitCntrSpecialInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExCntrTransmitCntrSpecialInfoVO[]
	 */
	public ExCntrTransmitCntrSpecialInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExCntrTransmitCntrSpecialInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkh = (JSPUtil.getParameter(request, prefix	+ "bkh", length));
			String[] cntrown = (JSPUtil.getParameter(request, prefix	+ "cntrown", length));
			String[] measureUnit = (JSPUtil.getParameter(request, prefix	+ "measure_unit", length));
			String[] cntrtrm = (JSPUtil.getParameter(request, prefix	+ "cntrtrm", length));
			String[] bkwgt = (JSPUtil.getParameter(request, prefix	+ "bkwgt", length));
			String[] ovrw = (JSPUtil.getParameter(request, prefix	+ "ovrw", length));
			String[] measure = (JSPUtil.getParameter(request, prefix	+ "measure", length));
			String[] tunit = (JSPUtil.getParameter(request, prefix	+ "tunit", length));
			String[] sealnbr = (JSPUtil.getParameter(request, prefix	+ "sealnbr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovh = (JSPUtil.getParameter(request, prefix	+ "ovh", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dgInd = (JSPUtil.getParameter(request, prefix	+ "dg_ind", length));
			String[] cntrtrw = (JSPUtil.getParameter(request, prefix	+ "cntrtrw", length));
			String[] ovwgt = (JSPUtil.getParameter(request, prefix	+ "ovwgt", length));
			String[] ovr = (JSPUtil.getParameter(request, prefix	+ "ovr", length));
			String[] akInd = (JSPUtil.getParameter(request, prefix	+ "ak_ind", length));
			String[] ovwgtUnit = (JSPUtil.getParameter(request, prefix	+ "ovwgt_unit", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] rfdryInd = (JSPUtil.getParameter(request, prefix	+ "rfdry_ind", length));
			String[] stwgReq = (JSPUtil.getParameter(request, prefix	+ "stwg_req", length));
			String[] voidSlot = (JSPUtil.getParameter(request, prefix	+ "void_slot", length));
			String[] ovlw = (JSPUtil.getParameter(request, prefix	+ "ovlw", length));
			String[] fmInd = (JSPUtil.getParameter(request, prefix	+ "fm_ind", length));
			String[] cntrgwgt = (JSPUtil.getParameter(request, prefix	+ "cntrgwgt", length));
			String[] socind = (JSPUtil.getParameter(request, prefix	+ "socind", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] rfRemark = (JSPUtil.getParameter(request, prefix	+ "rf_remark", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] pkg = (JSPUtil.getParameter(request, prefix	+ "pkg", length));
			String[] bkInd = (JSPUtil.getParameter(request, prefix	+ "bk_ind", length));
			String[] bkwgtu = (JSPUtil.getParameter(request, prefix	+ "bkwgtu", length));
			String[] ovf = (JSPUtil.getParameter(request, prefix	+ "ovf", length));
			String[] cntrwgt = (JSPUtil.getParameter(request, prefix	+ "cntrwgt", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] rfInd = (JSPUtil.getParameter(request, prefix	+ "rf_ind", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkw = (JSPUtil.getParameter(request, prefix	+ "bkw", length));
			String[] punit = (JSPUtil.getParameter(request, prefix	+ "punit", length));
			String[] cntrWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_unit", length));
			String[] haulage = (JSPUtil.getParameter(request, prefix	+ "haulage", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] bkl = (JSPUtil.getParameter(request, prefix	+ "bkl", length));
			String[] cmdtcd = (JSPUtil.getParameter(request, prefix	+ "cmdtcd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExCntrTransmitCntrSpecialInfoVO();
				if (bkh[i] != null)
					model.setBkh(bkh[i]);
				if (cntrown[i] != null)
					model.setCntrown(cntrown[i]);
				if (measureUnit[i] != null)
					model.setMeasureUnit(measureUnit[i]);
				if (cntrtrm[i] != null)
					model.setCntrtrm(cntrtrm[i]);
				if (bkwgt[i] != null)
					model.setBkwgt(bkwgt[i]);
				if (ovrw[i] != null)
					model.setOvrw(ovrw[i]);
				if (measure[i] != null)
					model.setMeasure(measure[i]);
				if (tunit[i] != null)
					model.setTunit(tunit[i]);
				if (sealnbr[i] != null)
					model.setSealnbr(sealnbr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovh[i] != null)
					model.setOvh(ovh[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dgInd[i] != null)
					model.setDgInd(dgInd[i]);
				if (cntrtrw[i] != null)
					model.setCntrtrw(cntrtrw[i]);
				if (ovwgt[i] != null)
					model.setOvwgt(ovwgt[i]);
				if (ovr[i] != null)
					model.setOvr(ovr[i]);
				if (akInd[i] != null)
					model.setAkInd(akInd[i]);
				if (ovwgtUnit[i] != null)
					model.setOvwgtUnit(ovwgtUnit[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (rfdryInd[i] != null)
					model.setRfdryInd(rfdryInd[i]);
				if (stwgReq[i] != null)
					model.setStwgReq(stwgReq[i]);
				if (voidSlot[i] != null)
					model.setVoidSlot(voidSlot[i]);
				if (ovlw[i] != null)
					model.setOvlw(ovlw[i]);
				if (fmInd[i] != null)
					model.setFmInd(fmInd[i]);
				if (cntrgwgt[i] != null)
					model.setCntrgwgt(cntrgwgt[i]);
				if (socind[i] != null)
					model.setSocind(socind[i]);
				if (vent[i] != null)
					model.setVent(vent[i]);
				if (rfRemark[i] != null)
					model.setRfRemark(rfRemark[i]);
				if (cntrnbr[i] != null)
					model.setCntrnbr(cntrnbr[i]);
				if (pkg[i] != null)
					model.setPkg(pkg[i]);
				if (bkInd[i] != null)
					model.setBkInd(bkInd[i]);
				if (bkwgtu[i] != null)
					model.setBkwgtu(bkwgtu[i]);
				if (ovf[i] != null)
					model.setOvf(ovf[i]);
				if (cntrwgt[i] != null)
					model.setCntrwgt(cntrwgt[i]);
				if (cntrtype[i] != null)
					model.setCntrtype(cntrtype[i]);
				if (rfInd[i] != null)
					model.setRfInd(rfInd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkw[i] != null)
					model.setBkw(bkw[i]);
				if (punit[i] != null)
					model.setPunit(punit[i]);
				if (cntrWgtUnit[i] != null)
					model.setCntrWgtUnit(cntrWgtUnit[i]);
				if (haulage[i] != null)
					model.setHaulage(haulage[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (bkl[i] != null)
					model.setBkl(bkl[i]);
				if (cmdtcd[i] != null)
					model.setCmdtcd(cmdtcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExCntrTransmitCntrSpecialInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExCntrTransmitCntrSpecialInfoVO[]
	 */
	public ExCntrTransmitCntrSpecialInfoVO[] getExCntrTransmitCntrSpecialInfoVOs(){
		ExCntrTransmitCntrSpecialInfoVO[] vos = (ExCntrTransmitCntrSpecialInfoVO[])models.toArray(new ExCntrTransmitCntrSpecialInfoVO[models.size()]);
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
		this.bkh = this.bkh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrown = this.cntrown .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measureUnit = this.measureUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtrm = this.cntrtrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwgt = this.bkwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrw = this.ovrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measure = this.measure .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tunit = this.tunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealnbr = this.sealnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovh = this.ovh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgInd = this.dgInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtrw = this.cntrtrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwgt = this.ovwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovr = this.ovr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akInd = this.akInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovwgtUnit = this.ovwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfdryInd = this.rfdryInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgReq = this.stwgReq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidSlot = this.voidSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovlw = this.ovlw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInd = this.fmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrgwgt = this.cntrgwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socind = this.socind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRemark = this.rfRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg = this.pkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkInd = this.bkInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwgtu = this.bkwgtu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovf = this.ovf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrwgt = this.cntrwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfInd = this.rfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkw = this.bkw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.punit = this.punit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUnit = this.cntrWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulage = this.haulage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkl = this.bkl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtcd = this.cmdtcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
