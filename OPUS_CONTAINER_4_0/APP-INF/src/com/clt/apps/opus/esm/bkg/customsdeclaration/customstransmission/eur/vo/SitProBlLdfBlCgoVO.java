/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlCgoVO.java
*@FileTitle : SitProBlLdfBlCgoVO
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
public class SitProBlLdfBlCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlCgoVO> models = new ArrayList<SitProBlLdfBlCgoVO>();
	
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
	private String scno = null;

	/* Column Info */
	private String rfano = null;

	/* Column Info */
	private String cntrnbr = null;

	/* Column Info */
	private String unnbr = null;

	/* Column Info */
	private String class1 = null;

	/* Column Info */
	private String dgDesc = null;

	/* Column Info */
	private String contactNm = null;

	/* Column Info */
	private String phone = null;

	/* Column Info */
	private String page = null;

	/* Column Info */
	private String flshTemp = null;

	/* Column Info */
	private String flshUnit = null;

	/* Column Info */
	private String dgRemark = null;

	/* Column Info */
	private String emsno = null;

	/* Column Info */
	private String psacls = null;

	/* Column Info */
	private String pkggrp = null;

	/* Column Info */
	private String mfag1 = null;

	/* Column Info */
	private String mfag2 = null;

	/* Column Info */
	private String marPoll = null;

	/* Column Info */
	private String labelCd = null;

	/* Column Info */
	private String labelDesc = null;

	/* Column Info */
	private String dPkg = null;

	/* Column Info */
	private String dPkgunit = null;

	/* Column Info */
	private String nwgt = null;

	/* Column Info */
	private String nwgtUnit = null;

	/* Column Info */
	private String gwgt = null;

	/* Column Info */
	private String gwgtUnit = null;

	/* Column Info */
	private String mea = null;

	/* Column Info */
	private String meaUnit = null;

	/* Column Info */
	private String hazCont = null;

	/* Column Info */
	private String stwg = null;

	/* Column Info */
	private String label = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlCgoVO() {}

	public SitProBlLdfBlCgoVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String port, String blnbr, String scno, String rfano, String cntrnbr, String unnbr, String class1, String dgDesc, String contactNm, String phone, String page, String flshTemp, String flshUnit, String dgRemark, String emsno, String psacls, String pkggrp, String mfag1, String mfag2, String marPoll, String labelCd, String labelDesc, String dPkg, String dPkgunit, String nwgt, String nwgtUnit, String gwgt, String gwgtUnit, String mea, String meaUnit, String hazCont, String stwg, String label) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.port = port;
		this.blnbr = blnbr;
		this.scno = scno;
		this.rfano = rfano;
		this.cntrnbr = cntrnbr;
		this.unnbr = unnbr;
		this.class1 = class1;
		this.dgDesc = dgDesc;
		this.contactNm = contactNm;
		this.phone = phone;
		this.page = page;
		this.flshTemp = flshTemp;
		this.flshUnit = flshUnit;
		this.dgRemark = dgRemark;
		this.emsno = emsno;
		this.psacls = psacls;
		this.pkggrp = pkggrp;
		this.mfag1 = mfag1;
		this.mfag2 = mfag2;
		this.marPoll = marPoll;
		this.labelCd = labelCd;
		this.labelDesc = labelDesc;
		this.dPkg = dPkg;
		this.dPkgunit = dPkgunit;
		this.nwgt = nwgt;
		this.nwgtUnit = nwgtUnit;
		this.gwgt = gwgt;
		this.gwgtUnit = gwgtUnit;
		this.mea = mea;
		this.meaUnit = meaUnit;
		this.hazCont = hazCont;
		this.stwg = stwg;
		this.label = label;
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
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("rfano", getRfano());
		this.hashColumns.put("cntrnbr", getCntrnbr());
		this.hashColumns.put("unnbr", getUnnbr());
		this.hashColumns.put("class1", getClass1());
		this.hashColumns.put("dg_desc", getDgDesc());
		this.hashColumns.put("contact_nm", getContactNm());
		this.hashColumns.put("phone", getPhone());
		this.hashColumns.put("page", getPage());
		this.hashColumns.put("flsh_temp", getFlshTemp());
		this.hashColumns.put("flsh_unit", getFlshUnit());
		this.hashColumns.put("dg_remark", getDgRemark());
		this.hashColumns.put("emsno", getEmsno());
		this.hashColumns.put("psacls", getPsacls());
		this.hashColumns.put("pkggrp", getPkggrp());
		this.hashColumns.put("mfag1", getMfag1());
		this.hashColumns.put("mfag2", getMfag2());
		this.hashColumns.put("mar_poll", getMarPoll());
		this.hashColumns.put("label_cd", getLabelCd());
		this.hashColumns.put("label_desc", getLabelDesc());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("d_pkgunit", getDPkgunit());
		this.hashColumns.put("nwgt", getNwgt());
		this.hashColumns.put("nwgt_unit", getNwgtUnit());
		this.hashColumns.put("gwgt", getGwgt());
		this.hashColumns.put("gwgt_unit", getGwgtUnit());
		this.hashColumns.put("mea", getMea());
		this.hashColumns.put("mea_unit", getMeaUnit());
		this.hashColumns.put("haz_cont", getHazCont());
		this.hashColumns.put("stwg", getStwg());
		this.hashColumns.put("label", getLabel());
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
		this.hashFields.put("scno", "scno");
		this.hashFields.put("rfano", "rfano");
		this.hashFields.put("cntrnbr", "cntrnbr");
		this.hashFields.put("unnbr", "unnbr");
		this.hashFields.put("class1", "class1");
		this.hashFields.put("dg_desc", "dgDesc");
		this.hashFields.put("contact_nm", "contactNm");
		this.hashFields.put("phone", "phone");
		this.hashFields.put("page", "page");
		this.hashFields.put("flsh_temp", "flshTemp");
		this.hashFields.put("flsh_unit", "flshUnit");
		this.hashFields.put("dg_remark", "dgRemark");
		this.hashFields.put("emsno", "emsno");
		this.hashFields.put("psacls", "psacls");
		this.hashFields.put("pkggrp", "pkggrp");
		this.hashFields.put("mfag1", "mfag1");
		this.hashFields.put("mfag2", "mfag2");
		this.hashFields.put("mar_poll", "marPoll");
		this.hashFields.put("label_cd", "labelCd");
		this.hashFields.put("label_desc", "labelDesc");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("d_pkgunit", "dPkgunit");
		this.hashFields.put("nwgt", "nwgt");
		this.hashFields.put("nwgt_unit", "nwgtUnit");
		this.hashFields.put("gwgt", "gwgt");
		this.hashFields.put("gwgt_unit", "gwgtUnit");
		this.hashFields.put("mea", "mea");
		this.hashFields.put("mea_unit", "meaUnit");
		this.hashFields.put("haz_cont", "hazCont");
		this.hashFields.put("stwg", "stwg");
		this.hashFields.put("label", "label");
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
	 * @param String scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * 
	 * @return String scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 *
	 * @param String rfano
	 */
	public void setRfano(String rfano) {
		this.rfano = rfano;
	}
	
	/**
	 * 
	 * @return String rfano
	 */
	public String getRfano() {
		return this.rfano;
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
	 * @param String unnbr
	 */
	public void setUnnbr(String unnbr) {
		this.unnbr = unnbr;
	}
	
	/**
	 * 
	 * @return String unnbr
	 */
	public String getUnnbr() {
		return this.unnbr;
	}
	
	/**
	 *
	 * @param String class1
	 */
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	
	/**
	 * 
	 * @return String class1
	 */
	public String getClass1() {
		return this.class1;
	}
	
	/**
	 *
	 * @param String dgDesc
	 */
	public void setDgDesc(String dgDesc) {
		this.dgDesc = dgDesc;
	}
	
	/**
	 * 
	 * @return String dgDesc
	 */
	public String getDgDesc() {
		return this.dgDesc;
	}
	
	/**
	 *
	 * @param String contactNm
	 */
	public void setContactNm(String contactNm) {
		this.contactNm = contactNm;
	}
	
	/**
	 * 
	 * @return String contactNm
	 */
	public String getContactNm() {
		return this.contactNm;
	}
	
	/**
	 *
	 * @param String phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 
	 * @return String phone
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 *
	 * @param String page
	 */
	public void setPage(String page) {
		this.page = page;
	}
	
	/**
	 * 
	 * @return String page
	 */
	public String getPage() {
		return this.page;
	}
	
	/**
	 *
	 * @param String flshTemp
	 */
	public void setFlshTemp(String flshTemp) {
		this.flshTemp = flshTemp;
	}
	
	/**
	 * 
	 * @return String flshTemp
	 */
	public String getFlshTemp() {
		return this.flshTemp;
	}
	
	/**
	 *
	 * @param String flshUnit
	 */
	public void setFlshUnit(String flshUnit) {
		this.flshUnit = flshUnit;
	}
	
	/**
	 * 
	 * @return String flshUnit
	 */
	public String getFlshUnit() {
		return this.flshUnit;
	}
	
	/**
	 *
	 * @param String dgRemark
	 */
	public void setDgRemark(String dgRemark) {
		this.dgRemark = dgRemark;
	}
	
	/**
	 * 
	 * @return String dgRemark
	 */
	public String getDgRemark() {
		return this.dgRemark;
	}
	
	/**
	 *
	 * @param String emsno
	 */
	public void setEmsno(String emsno) {
		this.emsno = emsno;
	}
	
	/**
	 * 
	 * @return String emsno
	 */
	public String getEmsno() {
		return this.emsno;
	}
	
	/**
	 *
	 * @param String psacls
	 */
	public void setPsacls(String psacls) {
		this.psacls = psacls;
	}
	
	/**
	 * 
	 * @return String psacls
	 */
	public String getPsacls() {
		return this.psacls;
	}
	
	/**
	 *
	 * @param String pkggrp
	 */
	public void setPkggrp(String pkggrp) {
		this.pkggrp = pkggrp;
	}
	
	/**
	 * 
	 * @return String pkggrp
	 */
	public String getPkggrp() {
		return this.pkggrp;
	}
	
	/**
	 *
	 * @param String mfag1
	 */
	public void setMfag1(String mfag1) {
		this.mfag1 = mfag1;
	}
	
	/**
	 * 
	 * @return String mfag1
	 */
	public String getMfag1() {
		return this.mfag1;
	}
	
	/**
	 *
	 * @param String mfag2
	 */
	public void setMfag2(String mfag2) {
		this.mfag2 = mfag2;
	}
	
	/**
	 * 
	 * @return String mfag2
	 */
	public String getMfag2() {
		return this.mfag2;
	}
	
	/**
	 *
	 * @param String marPoll
	 */
	public void setMarPoll(String marPoll) {
		this.marPoll = marPoll;
	}
	
	/**
	 * 
	 * @return String marPoll
	 */
	public String getMarPoll() {
		return this.marPoll;
	}
	
	/**
	 *
	 * @param String labelCd
	 */
	public void setLabelCd(String labelCd) {
		this.labelCd = labelCd;
	}
	
	/**
	 * 
	 * @return String labelCd
	 */
	public String getLabelCd() {
		return this.labelCd;
	}
	
	/**
	 *
	 * @param String labelDesc
	 */
	public void setLabelDesc(String labelDesc) {
		this.labelDesc = labelDesc;
	}
	
	/**
	 * 
	 * @return String labelDesc
	 */
	public String getLabelDesc() {
		return this.labelDesc;
	}
	
	/**
	 *
	 * @param String dPkg
	 */
	public void setDPkg(String dPkg) {
		this.dPkg = dPkg;
	}
	
	/**
	 * 
	 * @return String dPkg
	 */
	public String getDPkg() {
		return this.dPkg;
	}
	
	/**
	 *
	 * @param String dPkgunit
	 */
	public void setDPkgunit(String dPkgunit) {
		this.dPkgunit = dPkgunit;
	}
	
	/**
	 * 
	 * @return String dPkgunit
	 */
	public String getDPkgunit() {
		return this.dPkgunit;
	}
	
	/**
	 *
	 * @param String nwgt
	 */
	public void setNwgt(String nwgt) {
		this.nwgt = nwgt;
	}
	
	/**
	 * 
	 * @return String nwgt
	 */
	public String getNwgt() {
		return this.nwgt;
	}
	
	/**
	 *
	 * @param String nwgtUnit
	 */
	public void setNwgtUnit(String nwgtUnit) {
		this.nwgtUnit = nwgtUnit;
	}
	
	/**
	 * 
	 * @return String nwgtUnit
	 */
	public String getNwgtUnit() {
		return this.nwgtUnit;
	}
	
	/**
	 *
	 * @param String gwgt
	 */
	public void setGwgt(String gwgt) {
		this.gwgt = gwgt;
	}
	
	/**
	 * 
	 * @return String gwgt
	 */
	public String getGwgt() {
		return this.gwgt;
	}
	
	/**
	 *
	 * @param String gwgtUnit
	 */
	public void setGwgtUnit(String gwgtUnit) {
		this.gwgtUnit = gwgtUnit;
	}
	
	/**
	 * 
	 * @return String gwgtUnit
	 */
	public String getGwgtUnit() {
		return this.gwgtUnit;
	}
	
	/**
	 *
	 * @param String mea
	 */
	public void setMea(String mea) {
		this.mea = mea;
	}
	
	/**
	 * 
	 * @return String mea
	 */
	public String getMea() {
		return this.mea;
	}
	
	/**
	 *
	 * @param String meaUnit
	 */
	public void setMeaUnit(String meaUnit) {
		this.meaUnit = meaUnit;
	}
	
	/**
	 * 
	 * @return String meaUnit
	 */
	public String getMeaUnit() {
		return this.meaUnit;
	}
	
	/**
	 *
	 * @param String hazCont
	 */
	public void setHazCont(String hazCont) {
		this.hazCont = hazCont;
	}
	
	/**
	 * 
	 * @return String hazCont
	 */
	public String getHazCont() {
		return this.hazCont;
	}
	
	/**
	 *
	 * @param String stwg
	 */
	public void setStwg(String stwg) {
		this.stwg = stwg;
	}
	
	/**
	 * 
	 * @return String stwg
	 */
	public String getStwg() {
		return this.stwg;
	}
	
	/**
	 *
	 * @param String label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * 
	 * @return String label
	 */
	public String getLabel() {
		return this.label;
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
		setScno(JSPUtil.getParameter(request, prefix + "scno", ""));
		setRfano(JSPUtil.getParameter(request, prefix + "rfano", ""));
		setCntrnbr(JSPUtil.getParameter(request, prefix + "cntrnbr", ""));
		setUnnbr(JSPUtil.getParameter(request, prefix + "unnbr", ""));
		setClass1(JSPUtil.getParameter(request, prefix + "class1", ""));
		setDgDesc(JSPUtil.getParameter(request, prefix + "dg_desc", ""));
		setContactNm(JSPUtil.getParameter(request, prefix + "contact_nm", ""));
		setPhone(JSPUtil.getParameter(request, prefix + "phone", ""));
		setPage(JSPUtil.getParameter(request, prefix + "page", ""));
		setFlshTemp(JSPUtil.getParameter(request, prefix + "flsh_temp", ""));
		setFlshUnit(JSPUtil.getParameter(request, prefix + "flsh_unit", ""));
		setDgRemark(JSPUtil.getParameter(request, prefix + "dg_remark", ""));
		setEmsno(JSPUtil.getParameter(request, prefix + "emsno", ""));
		setPsacls(JSPUtil.getParameter(request, prefix + "psacls", ""));
		setPkggrp(JSPUtil.getParameter(request, prefix + "pkggrp", ""));
		setMfag1(JSPUtil.getParameter(request, prefix + "mfag1", ""));
		setMfag2(JSPUtil.getParameter(request, prefix + "mfag2", ""));
		setMarPoll(JSPUtil.getParameter(request, prefix + "mar_poll", ""));
		setLabelCd(JSPUtil.getParameter(request, prefix + "label_cd", ""));
		setLabelDesc(JSPUtil.getParameter(request, prefix + "label_desc", ""));
		setDPkg(JSPUtil.getParameter(request, prefix + "d_pkg", ""));
		setDPkgunit(JSPUtil.getParameter(request, prefix + "d_pkgunit", ""));
		setNwgt(JSPUtil.getParameter(request, prefix + "nwgt", ""));
		setNwgtUnit(JSPUtil.getParameter(request, prefix + "nwgt_unit", ""));
		setGwgt(JSPUtil.getParameter(request, prefix + "gwgt", ""));
		setGwgtUnit(JSPUtil.getParameter(request, prefix + "gwgt_unit", ""));
		setMea(JSPUtil.getParameter(request, prefix + "mea", ""));
		setMeaUnit(JSPUtil.getParameter(request, prefix + "mea_unit", ""));
		setHazCont(JSPUtil.getParameter(request, prefix + "haz_cont", ""));
		setStwg(JSPUtil.getParameter(request, prefix + "stwg", ""));
		setLabel(JSPUtil.getParameter(request, prefix + "label", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlCgoVO[]
	 */
	public SitProBlLdfBlCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class1 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlCgoVO[]
	 */
	public SitProBlLdfBlCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlCgoVO model = null;
		
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
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] rfano = (JSPUtil.getParameter(request, prefix	+ "rfano", length));
			String[] cntrnbr = (JSPUtil.getParameter(request, prefix	+ "cntrnbr", length));
			String[] unnbr = (JSPUtil.getParameter(request, prefix	+ "unnbr", length));
			String[] class1 = (JSPUtil.getParameter(request, prefix	+ "class1", length));
			String[] dgDesc = (JSPUtil.getParameter(request, prefix	+ "dg_desc", length));
			String[] contactNm = (JSPUtil.getParameter(request, prefix	+ "contact_nm", length));
			String[] phone = (JSPUtil.getParameter(request, prefix	+ "phone", length));
			String[] page = (JSPUtil.getParameter(request, prefix	+ "page", length));
			String[] flshTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_temp", length));
			String[] flshUnit = (JSPUtil.getParameter(request, prefix	+ "flsh_unit", length));
			String[] dgRemark = (JSPUtil.getParameter(request, prefix	+ "dg_remark", length));
			String[] emsno = (JSPUtil.getParameter(request, prefix	+ "emsno", length));
			String[] psacls = (JSPUtil.getParameter(request, prefix	+ "psacls", length));
			String[] pkggrp = (JSPUtil.getParameter(request, prefix	+ "pkggrp", length));
			String[] mfag1 = (JSPUtil.getParameter(request, prefix	+ "mfag1", length));
			String[] mfag2 = (JSPUtil.getParameter(request, prefix	+ "mfag2", length));
			String[] marPoll = (JSPUtil.getParameter(request, prefix	+ "mar_poll", length));
			String[] labelCd = (JSPUtil.getParameter(request, prefix	+ "label_cd", length));
			String[] labelDesc = (JSPUtil.getParameter(request, prefix	+ "label_desc", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] dPkgunit = (JSPUtil.getParameter(request, prefix	+ "d_pkgunit", length));
			String[] nwgt = (JSPUtil.getParameter(request, prefix	+ "nwgt", length));
			String[] nwgtUnit = (JSPUtil.getParameter(request, prefix	+ "nwgt_unit", length));
			String[] gwgt = (JSPUtil.getParameter(request, prefix	+ "gwgt", length));
			String[] gwgtUnit = (JSPUtil.getParameter(request, prefix	+ "gwgt_unit", length));
			String[] mea = (JSPUtil.getParameter(request, prefix	+ "mea", length));
			String[] meaUnit = (JSPUtil.getParameter(request, prefix	+ "mea_unit", length));
			String[] hazCont = (JSPUtil.getParameter(request, prefix	+ "haz_cont", length));
			String[] stwg = (JSPUtil.getParameter(request, prefix	+ "stwg", length));
			String[] label = (JSPUtil.getParameter(request, prefix	+ "label", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlCgoVO();
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
				if (scno[i] != null) 
					model.setScno(scno[i]);
				if (rfano[i] != null) 
					model.setRfano(rfano[i]);
				if (cntrnbr[i] != null) 
					model.setCntrnbr(cntrnbr[i]);
				if (unnbr[i] != null) 
					model.setUnnbr(unnbr[i]);
				if (class1[i] != null) 
					model.setClass1(class1[i]);
				if (dgDesc[i] != null) 
					model.setDgDesc(dgDesc[i]);
				if (contactNm[i] != null) 
					model.setContactNm(contactNm[i]);
				if (phone[i] != null) 
					model.setPhone(phone[i]);
				if (page[i] != null) 
					model.setPage(page[i]);
				if (flshTemp[i] != null) 
					model.setFlshTemp(flshTemp[i]);
				if (flshUnit[i] != null) 
					model.setFlshUnit(flshUnit[i]);
				if (dgRemark[i] != null) 
					model.setDgRemark(dgRemark[i]);
				if (emsno[i] != null) 
					model.setEmsno(emsno[i]);
				if (psacls[i] != null) 
					model.setPsacls(psacls[i]);
				if (pkggrp[i] != null) 
					model.setPkggrp(pkggrp[i]);
				if (mfag1[i] != null) 
					model.setMfag1(mfag1[i]);
				if (mfag2[i] != null) 
					model.setMfag2(mfag2[i]);
				if (marPoll[i] != null) 
					model.setMarPoll(marPoll[i]);
				if (labelCd[i] != null) 
					model.setLabelCd(labelCd[i]);
				if (labelDesc[i] != null) 
					model.setLabelDesc(labelDesc[i]);
				if (dPkg[i] != null) 
					model.setDPkg(dPkg[i]);
				if (dPkgunit[i] != null) 
					model.setDPkgunit(dPkgunit[i]);
				if (nwgt[i] != null) 
					model.setNwgt(nwgt[i]);
				if (nwgtUnit[i] != null) 
					model.setNwgtUnit(nwgtUnit[i]);
				if (gwgt[i] != null) 
					model.setGwgt(gwgt[i]);
				if (gwgtUnit[i] != null) 
					model.setGwgtUnit(gwgtUnit[i]);
				if (mea[i] != null) 
					model.setMea(mea[i]);
				if (meaUnit[i] != null) 
					model.setMeaUnit(meaUnit[i]);
				if (hazCont[i] != null) 
					model.setHazCont(hazCont[i]);
				if (stwg[i] != null) 
					model.setStwg(stwg[i]);
				if (label[i] != null) 
					model.setLabel(label[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlCgoVO[]
	 */
	public SitProBlLdfBlCgoVO[] getSitProBlLdfBlCgoVOs(){
		SitProBlLdfBlCgoVO[] vos = (SitProBlLdfBlCgoVO[])models.toArray(new SitProBlLdfBlCgoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class1의 내용을 String으로 변환
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
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfano = this.rfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrnbr = this.cntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unnbr = this.unnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.class1 = this.class1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgDesc = this.dgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactNm = this.contactNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phone = this.phone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.page = this.page .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshTemp = this.flshTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshUnit = this.flshUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRemark = this.dgRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsno = this.emsno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psacls = this.psacls .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkggrp = this.pkggrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag1 = this.mfag1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag2 = this.mfag2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marPoll = this.marPoll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.labelCd = this.labelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.labelDesc = this.labelDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkgunit = this.dPkgunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nwgt = this.nwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nwgtUnit = this.nwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwgt = this.gwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwgtUnit = this.gwgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mea = this.mea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meaUnit = this.meaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazCont = this.hazCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg = this.stwg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.label = this.label .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}