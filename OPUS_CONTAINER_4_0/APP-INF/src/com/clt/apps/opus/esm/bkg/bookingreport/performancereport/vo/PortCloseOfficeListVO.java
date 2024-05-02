/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortCloseOfficeListVO.java
*@FileTitle : PortCloseOfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.09.17 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortCloseOfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortCloseOfficeListVO> models = new ArrayList<PortCloseOfficeListVO>();
	
	/* Column Info */
	private String bkgRtStsCd = null;
	/* Column Info */
	private String bOfc = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String waitTtl = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String downTpB = null;
	/* Column Info */
	private String sNtfyTtl = null;
	/* Column Info */
	private String oNtfyTtl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dtType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cntrCfm = null;
	/* Column Info */
	private String cneeTtl = null;
	/* Column Info */
	private String sBlTtl = null;
	/* Column Info */
	private String downTpO = null;
	/* Column Info */
	private String blTtl = null;
	/* Column Info */
	private String cntrNoncfm = null;
	/* Column Info */
	private String downTpT = null;
	/* Column Info */
	private String rfirmTtl = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String gso = null;
	/* Column Info */
	private String sCneeTtl = null;
	/* Column Info */
	private String oCneeTtl = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ntfyTtl = null;
	/* Column Info */
	private String firmTtl = null;
	/* Column Info */
	private String revStatus = null;
	/* Column Info */
	private String oBlTtl = null;
	/* Column Info */
	private String bkgStaff = null;
	/* Column Info */
	private String nullTtl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortCloseOfficeListVO() {}

	public PortCloseOfficeListVO(String ibflag, String pagerows, String rhqCd, String bkgOfcCd, String bOfc, String ttl, String firmTtl, String waitTtl, String cneeTtl, String rfirmTtl, String nullTtl, String bkgStsCd, String bkgRtStsCd, String revStatus, String bkgStaff, String frDt, String toDt, String polCd, String vvdCd, String gso, String dtType, String sBlTtl, String oBlTtl, String sCneeTtl, String oCneeTtl, String sNtfyTtl, String oNtfyTtl, String blType, String blTtl, String ntfyTtl, String downTpO, String downTpB, String downTpT, String cntrCfm, String cntrNoncfm) {
		this.bkgRtStsCd = bkgRtStsCd;
		this.bOfc = bOfc;
		this.bkgStsCd = bkgStsCd;
		this.waitTtl = waitTtl;
		this.frDt = frDt;
		this.downTpB = downTpB;
		this.sNtfyTtl = sNtfyTtl;
		this.oNtfyTtl = oNtfyTtl;
		this.pagerows = pagerows;
		this.dtType = dtType;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.cntrCfm = cntrCfm;
		this.cneeTtl = cneeTtl;
		this.sBlTtl = sBlTtl;
		this.downTpO = downTpO;
		this.blTtl = blTtl;
		this.cntrNoncfm = cntrNoncfm;
		this.downTpT = downTpT;
		this.rfirmTtl = rfirmTtl;
		this.bkgOfcCd = bkgOfcCd;
		this.rhqCd = rhqCd;
		this.blType = blType;
		this.gso = gso;
		this.sCneeTtl = sCneeTtl;
		this.oCneeTtl = oCneeTtl;
		this.ttl = ttl;
		this.toDt = toDt;
		this.ntfyTtl = ntfyTtl;
		this.firmTtl = firmTtl;
		this.revStatus = revStatus;
		this.oBlTtl = oBlTtl;
		this.bkgStaff = bkgStaff;
		this.nullTtl = nullTtl;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_rt_sts_cd", getBkgRtStsCd());
		this.hashColumns.put("b_ofc", getBOfc());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("wait_ttl", getWaitTtl());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("down_tp_b", getDownTpB());
		this.hashColumns.put("s_ntfy_ttl", getSNtfyTtl());
		this.hashColumns.put("o_ntfy_ttl", getONtfyTtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dt_type", getDtType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_cfm", getCntrCfm());
		this.hashColumns.put("cnee_ttl", getCneeTtl());
		this.hashColumns.put("s_bl_ttl", getSBlTtl());
		this.hashColumns.put("down_tp_o", getDownTpO());
		this.hashColumns.put("bl_ttl", getBlTtl());
		this.hashColumns.put("cntr_noncfm", getCntrNoncfm());
		this.hashColumns.put("down_tp_t", getDownTpT());
		this.hashColumns.put("rfirm_ttl", getRfirmTtl());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("gso", getGso());
		this.hashColumns.put("s_cnee_ttl", getSCneeTtl());
		this.hashColumns.put("o_cnee_ttl", getOCneeTtl());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ntfy_ttl", getNtfyTtl());
		this.hashColumns.put("firm_ttl", getFirmTtl());
		this.hashColumns.put("rev_status", getRevStatus());
		this.hashColumns.put("o_bl_ttl", getOBlTtl());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		this.hashColumns.put("null_ttl", getNullTtl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_rt_sts_cd", "bkgRtStsCd");
		this.hashFields.put("b_ofc", "bOfc");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("wait_ttl", "waitTtl");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("down_tp_b", "downTpB");
		this.hashFields.put("s_ntfy_ttl", "sNtfyTtl");
		this.hashFields.put("o_ntfy_ttl", "oNtfyTtl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dt_type", "dtType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_cfm", "cntrCfm");
		this.hashFields.put("cnee_ttl", "cneeTtl");
		this.hashFields.put("s_bl_ttl", "sBlTtl");
		this.hashFields.put("down_tp_o", "downTpO");
		this.hashFields.put("bl_ttl", "blTtl");
		this.hashFields.put("cntr_noncfm", "cntrNoncfm");
		this.hashFields.put("down_tp_t", "downTpT");
		this.hashFields.put("rfirm_ttl", "rfirmTtl");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("gso", "gso");
		this.hashFields.put("s_cnee_ttl", "sCneeTtl");
		this.hashFields.put("o_cnee_ttl", "oCneeTtl");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ntfy_ttl", "ntfyTtl");
		this.hashFields.put("firm_ttl", "firmTtl");
		this.hashFields.put("rev_status", "revStatus");
		this.hashFields.put("o_bl_ttl", "oBlTtl");
		this.hashFields.put("bkg_staff", "bkgStaff");
		this.hashFields.put("null_ttl", "nullTtl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgRtStsCd
	 */
	public String getBkgRtStsCd() {
		return this.bkgRtStsCd;
	}
	
	/**
	 * Column Info
	 * @return bOfc
	 */
	public String getBOfc() {
		return this.bOfc;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return waitTtl
	 */
	public String getWaitTtl() {
		return this.waitTtl;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return downTpB
	 */
	public String getDownTpB() {
		return this.downTpB;
	}
	
	/**
	 * Column Info
	 * @return sNtfyTtl
	 */
	public String getSNtfyTtl() {
		return this.sNtfyTtl;
	}
	
	/**
	 * Column Info
	 * @return oNtfyTtl
	 */
	public String getONtfyTtl() {
		return this.oNtfyTtl;
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
	 * @return dtType
	 */
	public String getDtType() {
		return this.dtType;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCfm
	 */
	public String getCntrCfm() {
		return this.cntrCfm;
	}
	
	/**
	 * Column Info
	 * @return cneeTtl
	 */
	public String getCneeTtl() {
		return this.cneeTtl;
	}
	
	/**
	 * Column Info
	 * @return sBlTtl
	 */
	public String getSBlTtl() {
		return this.sBlTtl;
	}
	
	/**
	 * Column Info
	 * @return downTpO
	 */
	public String getDownTpO() {
		return this.downTpO;
	}
	
	/**
	 * Column Info
	 * @return blTtl
	 */
	public String getBlTtl() {
		return this.blTtl;
	}
	
	/**
	 * Column Info
	 * @return cntrNoncfm
	 */
	public String getCntrNoncfm() {
		return this.cntrNoncfm;
	}
	
	/**
	 * Column Info
	 * @return downTpT
	 */
	public String getDownTpT() {
		return this.downTpT;
	}
	
	/**
	 * Column Info
	 * @return rfirmTtl
	 */
	public String getRfirmTtl() {
		return this.rfirmTtl;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return blType
	 */
	public String getBlType() {
		return this.blType;
	}
	
	/**
	 * Column Info
	 * @return gso
	 */
	public String getGso() {
		return this.gso;
	}
	
	/**
	 * Column Info
	 * @return sCneeTtl
	 */
	public String getSCneeTtl() {
		return this.sCneeTtl;
	}
	
	/**
	 * Column Info
	 * @return oCneeTtl
	 */
	public String getOCneeTtl() {
		return this.oCneeTtl;
	}
	
	/**
	 * Column Info
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ntfyTtl
	 */
	public String getNtfyTtl() {
		return this.ntfyTtl;
	}
	
	/**
	 * Column Info
	 * @return firmTtl
	 */
	public String getFirmTtl() {
		return this.firmTtl;
	}
	
	/**
	 * Column Info
	 * @return revStatus
	 */
	public String getRevStatus() {
		return this.revStatus;
	}
	
	/**
	 * Column Info
	 * @return oBlTtl
	 */
	public String getOBlTtl() {
		return this.oBlTtl;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
	}
	
	/**
	 * Column Info
	 * @return nullTtl
	 */
	public String getNullTtl() {
		return this.nullTtl;
	}
	

	/**
	 * Column Info
	 * @param bkgRtStsCd
	 */
	public void setBkgRtStsCd(String bkgRtStsCd) {
		this.bkgRtStsCd = bkgRtStsCd;
	}
	
	/**
	 * Column Info
	 * @param bOfc
	 */
	public void setBOfc(String bOfc) {
		this.bOfc = bOfc;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param waitTtl
	 */
	public void setWaitTtl(String waitTtl) {
		this.waitTtl = waitTtl;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param downTpB
	 */
	public void setDownTpB(String downTpB) {
		this.downTpB = downTpB;
	}
	
	/**
	 * Column Info
	 * @param sNtfyTtl
	 */
	public void setSNtfyTtl(String sNtfyTtl) {
		this.sNtfyTtl = sNtfyTtl;
	}
	
	/**
	 * Column Info
	 * @param oNtfyTtl
	 */
	public void setONtfyTtl(String oNtfyTtl) {
		this.oNtfyTtl = oNtfyTtl;
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
	 * @param dtType
	 */
	public void setDtType(String dtType) {
		this.dtType = dtType;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCfm
	 */
	public void setCntrCfm(String cntrCfm) {
		this.cntrCfm = cntrCfm;
	}
	
	/**
	 * Column Info
	 * @param cneeTtl
	 */
	public void setCneeTtl(String cneeTtl) {
		this.cneeTtl = cneeTtl;
	}
	
	/**
	 * Column Info
	 * @param sBlTtl
	 */
	public void setSBlTtl(String sBlTtl) {
		this.sBlTtl = sBlTtl;
	}
	
	/**
	 * Column Info
	 * @param downTpO
	 */
	public void setDownTpO(String downTpO) {
		this.downTpO = downTpO;
	}
	
	/**
	 * Column Info
	 * @param blTtl
	 */
	public void setBlTtl(String blTtl) {
		this.blTtl = blTtl;
	}
	
	/**
	 * Column Info
	 * @param cntrNoncfm
	 */
	public void setCntrNoncfm(String cntrNoncfm) {
		this.cntrNoncfm = cntrNoncfm;
	}
	
	/**
	 * Column Info
	 * @param downTpT
	 */
	public void setDownTpT(String downTpT) {
		this.downTpT = downTpT;
	}
	
	/**
	 * Column Info
	 * @param rfirmTtl
	 */
	public void setRfirmTtl(String rfirmTtl) {
		this.rfirmTtl = rfirmTtl;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param blType
	 */
	public void setBlType(String blType) {
		this.blType = blType;
	}
	
	/**
	 * Column Info
	 * @param gso
	 */
	public void setGso(String gso) {
		this.gso = gso;
	}
	
	/**
	 * Column Info
	 * @param sCneeTtl
	 */
	public void setSCneeTtl(String sCneeTtl) {
		this.sCneeTtl = sCneeTtl;
	}
	
	/**
	 * Column Info
	 * @param oCneeTtl
	 */
	public void setOCneeTtl(String oCneeTtl) {
		this.oCneeTtl = oCneeTtl;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ntfyTtl
	 */
	public void setNtfyTtl(String ntfyTtl) {
		this.ntfyTtl = ntfyTtl;
	}
	
	/**
	 * Column Info
	 * @param firmTtl
	 */
	public void setFirmTtl(String firmTtl) {
		this.firmTtl = firmTtl;
	}
	
	/**
	 * Column Info
	 * @param revStatus
	 */
	public void setRevStatus(String revStatus) {
		this.revStatus = revStatus;
	}
	
	/**
	 * Column Info
	 * @param oBlTtl
	 */
	public void setOBlTtl(String oBlTtl) {
		this.oBlTtl = oBlTtl;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * Column Info
	 * @param nullTtl
	 */
	public void setNullTtl(String nullTtl) {
		this.nullTtl = nullTtl;
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
		setBkgRtStsCd(JSPUtil.getParameter(request, prefix + "bkg_rt_sts_cd", ""));
		setBOfc(JSPUtil.getParameter(request, prefix + "b_ofc", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setWaitTtl(JSPUtil.getParameter(request, prefix + "wait_ttl", ""));
		setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
		setDownTpB(JSPUtil.getParameter(request, prefix + "down_tp_b", ""));
		setSNtfyTtl(JSPUtil.getParameter(request, prefix + "s_ntfy_ttl", ""));
		setONtfyTtl(JSPUtil.getParameter(request, prefix + "o_ntfy_ttl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrCfm(JSPUtil.getParameter(request, prefix + "cntr_cfm", ""));
		setCneeTtl(JSPUtil.getParameter(request, prefix + "cnee_ttl", ""));
		setSBlTtl(JSPUtil.getParameter(request, prefix + "s_bl_ttl", ""));
		setDownTpO(JSPUtil.getParameter(request, prefix + "down_tp_o", ""));
		setBlTtl(JSPUtil.getParameter(request, prefix + "bl_ttl", ""));
		setCntrNoncfm(JSPUtil.getParameter(request, prefix + "cntr_noncfm", ""));
		setDownTpT(JSPUtil.getParameter(request, prefix + "down_tp_t", ""));
		setRfirmTtl(JSPUtil.getParameter(request, prefix + "rfirm_ttl", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBlType(JSPUtil.getParameter(request, prefix + "bl_type", ""));
		setGso(JSPUtil.getParameter(request, prefix + "gso", ""));
		setSCneeTtl(JSPUtil.getParameter(request, prefix + "s_cnee_ttl", ""));
		setOCneeTtl(JSPUtil.getParameter(request, prefix + "o_cnee_ttl", ""));
		setTtl(JSPUtil.getParameter(request, prefix + "ttl", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setNtfyTtl(JSPUtil.getParameter(request, prefix + "ntfy_ttl", ""));
		setFirmTtl(JSPUtil.getParameter(request, prefix + "firm_ttl", ""));
		setRevStatus(JSPUtil.getParameter(request, prefix + "rev_status", ""));
		setOBlTtl(JSPUtil.getParameter(request, prefix + "o_bl_ttl", ""));
		setBkgStaff(JSPUtil.getParameter(request, prefix + "bkg_staff", ""));
		setNullTtl(JSPUtil.getParameter(request, prefix + "null_ttl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortCloseOfficeListVO[]
	 */
	public PortCloseOfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortCloseOfficeListVO[]
	 */
	public PortCloseOfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortCloseOfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgRtStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rt_sts_cd", length));
			String[] bOfc = (JSPUtil.getParameter(request, prefix	+ "b_ofc", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] waitTtl = (JSPUtil.getParameter(request, prefix	+ "wait_ttl", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] downTpB = (JSPUtil.getParameter(request, prefix	+ "down_tp_b", length));
			String[] sNtfyTtl = (JSPUtil.getParameter(request, prefix	+ "s_ntfy_ttl", length));
			String[] oNtfyTtl = (JSPUtil.getParameter(request, prefix	+ "o_ntfy_ttl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrCfm = (JSPUtil.getParameter(request, prefix	+ "cntr_cfm", length));
			String[] cneeTtl = (JSPUtil.getParameter(request, prefix	+ "cnee_ttl", length));
			String[] sBlTtl = (JSPUtil.getParameter(request, prefix	+ "s_bl_ttl", length));
			String[] downTpO = (JSPUtil.getParameter(request, prefix	+ "down_tp_o", length));
			String[] blTtl = (JSPUtil.getParameter(request, prefix	+ "bl_ttl", length));
			String[] cntrNoncfm = (JSPUtil.getParameter(request, prefix	+ "cntr_noncfm", length));
			String[] downTpT = (JSPUtil.getParameter(request, prefix	+ "down_tp_t", length));
			String[] rfirmTtl = (JSPUtil.getParameter(request, prefix	+ "rfirm_ttl", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));
			String[] gso = (JSPUtil.getParameter(request, prefix	+ "gso", length));
			String[] sCneeTtl = (JSPUtil.getParameter(request, prefix	+ "s_cnee_ttl", length));
			String[] oCneeTtl = (JSPUtil.getParameter(request, prefix	+ "o_cnee_ttl", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ntfyTtl = (JSPUtil.getParameter(request, prefix	+ "ntfy_ttl", length));
			String[] firmTtl = (JSPUtil.getParameter(request, prefix	+ "firm_ttl", length));
			String[] revStatus = (JSPUtil.getParameter(request, prefix	+ "rev_status", length));
			String[] oBlTtl = (JSPUtil.getParameter(request, prefix	+ "o_bl_ttl", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			String[] nullTtl = (JSPUtil.getParameter(request, prefix	+ "null_ttl", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortCloseOfficeListVO();
				if (bkgRtStsCd[i] != null)
					model.setBkgRtStsCd(bkgRtStsCd[i]);
				if (bOfc[i] != null)
					model.setBOfc(bOfc[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (waitTtl[i] != null)
					model.setWaitTtl(waitTtl[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (downTpB[i] != null)
					model.setDownTpB(downTpB[i]);
				if (sNtfyTtl[i] != null)
					model.setSNtfyTtl(sNtfyTtl[i]);
				if (oNtfyTtl[i] != null)
					model.setONtfyTtl(oNtfyTtl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrCfm[i] != null)
					model.setCntrCfm(cntrCfm[i]);
				if (cneeTtl[i] != null)
					model.setCneeTtl(cneeTtl[i]);
				if (sBlTtl[i] != null)
					model.setSBlTtl(sBlTtl[i]);
				if (downTpO[i] != null)
					model.setDownTpO(downTpO[i]);
				if (blTtl[i] != null)
					model.setBlTtl(blTtl[i]);
				if (cntrNoncfm[i] != null)
					model.setCntrNoncfm(cntrNoncfm[i]);
				if (downTpT[i] != null)
					model.setDownTpT(downTpT[i]);
				if (rfirmTtl[i] != null)
					model.setRfirmTtl(rfirmTtl[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (gso[i] != null)
					model.setGso(gso[i]);
				if (sCneeTtl[i] != null)
					model.setSCneeTtl(sCneeTtl[i]);
				if (oCneeTtl[i] != null)
					model.setOCneeTtl(oCneeTtl[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ntfyTtl[i] != null)
					model.setNtfyTtl(ntfyTtl[i]);
				if (firmTtl[i] != null)
					model.setFirmTtl(firmTtl[i]);
				if (revStatus[i] != null)
					model.setRevStatus(revStatus[i]);
				if (oBlTtl[i] != null)
					model.setOBlTtl(oBlTtl[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (nullTtl[i] != null)
					model.setNullTtl(nullTtl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortCloseOfficeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortCloseOfficeListVO[]
	 */
	public PortCloseOfficeListVO[] getPortCloseOfficeListVOs(){
		PortCloseOfficeListVO[] vos = (PortCloseOfficeListVO[])models.toArray(new PortCloseOfficeListVO[models.size()]);
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
		this.bkgRtStsCd = this.bkgRtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfc = this.bOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitTtl = this.waitTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downTpB = this.downTpB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNtfyTtl = this.sNtfyTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oNtfyTtl = this.oNtfyTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCfm = this.cntrCfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeTtl = this.cneeTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlTtl = this.sBlTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downTpO = this.downTpO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTtl = this.blTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoncfm = this.cntrNoncfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downTpT = this.downTpT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfirmTtl = this.rfirmTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gso = this.gso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCneeTtl = this.sCneeTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oCneeTtl = this.oCneeTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyTtl = this.ntfyTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firmTtl = this.firmTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revStatus = this.revStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oBlTtl = this.oBlTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nullTtl = this.nullTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
