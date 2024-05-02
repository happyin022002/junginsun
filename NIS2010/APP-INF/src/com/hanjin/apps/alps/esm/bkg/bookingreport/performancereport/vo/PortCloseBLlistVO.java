/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortCloseBLlistVO.java
*@FileTitle : PortCloseBLlistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.09.17 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortCloseBLlistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortCloseBLlistVO> models = new ArrayList<PortCloseBLlistVO>();
	
	/* Column Info */
	private String bkgRtStsCd = null;
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String downTpB = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dtType = null;
	/* Column Info */
	private String bkgStf = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String downTpO = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String siFlg = null;
	/* Column Info */
	private String downTpT = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgPctDt = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String gso = null;
	/* Column Info */
	private String cntrCfm = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String revStatus = null;
	/* Column Info */
	private String bkgStaff = null;
	/* Column Info */
	private String selBkgOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortCloseBLlistVO() {}

	public PortCloseBLlistVO(String ibflag, String pagerows, String bkgNo, String blNo, String shprCd, String shprNm, String polCd, String bkgRtStsCd, String atd, String etd, String vvdCd, String slanCd, String revStatus, String bkgStsCd, String siFlg, String cneeCd, String cneeNm, String bkgOfcCd, String bkgStf, String blType, String ntfyCd, String ntfyNm, String bkgPctDt, String scNo, String rfaNo, String bkgStaff, String frDt, String toDt, String gso, String dtType, String selBkgOfcCd, String downTpO, String downTpB, String downTpT, String cntrCfm) {
		this.bkgRtStsCd = bkgRtStsCd;
		this.cneeCd = cneeCd;
		this.etd = etd;
		this.bkgStsCd = bkgStsCd;
		this.frDt = frDt;
		this.blNo = blNo;
		this.downTpB = downTpB;
		this.pagerows = pagerows;
		this.dtType = dtType;
		this.bkgStf = bkgStf;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.scNo = scNo;
		this.downTpO = downTpO;
		this.atd = atd;
		this.shprNm = shprNm;
		this.siFlg = siFlg;
		this.downTpT = downTpT;
		this.shprCd = shprCd;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgPctDt = bkgPctDt;
		this.blType = blType;
		this.gso = gso;
		this.cntrCfm = cntrCfm;
		this.ntfyNm = ntfyNm;
		this.ntfyCd = ntfyCd;
		this.toDt = toDt;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.slanCd = slanCd;
		this.revStatus = revStatus;
		this.bkgStaff = bkgStaff;
		this.selBkgOfcCd = selBkgOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_rt_sts_cd", getBkgRtStsCd());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("down_tp_b", getDownTpB());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dt_type", getDtType());
		this.hashColumns.put("bkg_stf", getBkgStf());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("down_tp_o", getDownTpO());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("si_flg", getSiFlg());
		this.hashColumns.put("down_tp_t", getDownTpT());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bkg_pct_dt", getBkgPctDt());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("gso", getGso());
		this.hashColumns.put("cntr_cfm", getCntrCfm());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rev_status", getRevStatus());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		this.hashColumns.put("sel_bkg_ofc_cd", getSelBkgOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_rt_sts_cd", "bkgRtStsCd");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("down_tp_b", "downTpB");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dt_type", "dtType");
		this.hashFields.put("bkg_stf", "bkgStf");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("down_tp_o", "downTpO");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("si_flg", "siFlg");
		this.hashFields.put("down_tp_t", "downTpT");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_pct_dt", "bkgPctDt");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("gso", "gso");
		this.hashFields.put("cntr_cfm", "cntrCfm");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rev_status", "revStatus");
		this.hashFields.put("bkg_staff", "bkgStaff");
		this.hashFields.put("sel_bkg_ofc_cd", "selBkgOfcCd");
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
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
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
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return downTpB
	 */
	public String getDownTpB() {
		return this.downTpB;
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
	 * Column Info
	 * @return bkgStf
	 */
	public String getBkgStf() {
		return this.bkgStf;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return siFlg
	 */
	public String getSiFlg() {
		return this.siFlg;
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
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
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
	 * @return bkgPctDt
	 */
	public String getBkgPctDt() {
		return this.bkgPctDt;
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
	 * @return cntrCfm
	 */
	public String getCntrCfm() {
		return this.cntrCfm;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return ntfyCd
	 */
	public String getNtfyCd() {
		return this.ntfyCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
	}
	
	/**
	 * Column Info
	 * @return selBkgOfcCd
	 */
	public String getSelBkgOfcCd() {
		return this.selBkgOfcCd;
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
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
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
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param downTpB
	 */
	public void setDownTpB(String downTpB) {
		this.downTpB = downTpB;
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
	 * Column Info
	 * @param bkgStf
	 */
	public void setBkgStf(String bkgStf) {
		this.bkgStf = bkgStf;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param siFlg
	 */
	public void setSiFlg(String siFlg) {
		this.siFlg = siFlg;
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
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
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
	 * @param bkgPctDt
	 */
	public void setBkgPctDt(String bkgPctDt) {
		this.bkgPctDt = bkgPctDt;
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
	 * @param cntrCfm
	 */
	public void setCntrCfm(String cntrCfm) {
		this.cntrCfm = cntrCfm;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param ntfyCd
	 */
	public void setNtfyCd(String ntfyCd) {
		this.ntfyCd = ntfyCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * Column Info
	 * @param selBkgOfcCd
	 */
	public void setSelBkgOfcCd(String selBkgOfcCd) {
		this.selBkgOfcCd = selBkgOfcCd;
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
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setFrDt(JSPUtil.getParameter(request, prefix + "fr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setDownTpB(JSPUtil.getParameter(request, prefix + "down_tp_b", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		setBkgStf(JSPUtil.getParameter(request, prefix + "bkg_stf", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setDownTpO(JSPUtil.getParameter(request, prefix + "down_tp_o", ""));
		setAtd(JSPUtil.getParameter(request, prefix + "atd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setSiFlg(JSPUtil.getParameter(request, prefix + "si_flg", ""));
		setDownTpT(JSPUtil.getParameter(request, prefix + "down_tp_t", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBkgPctDt(JSPUtil.getParameter(request, prefix + "bkg_pct_dt", ""));
		setBlType(JSPUtil.getParameter(request, prefix + "bl_type", ""));
		setGso(JSPUtil.getParameter(request, prefix + "gso", ""));
		setCntrCfm(JSPUtil.getParameter(request, prefix + "cntr_cfm", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setNtfyCd(JSPUtil.getParameter(request, prefix + "ntfy_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setRevStatus(JSPUtil.getParameter(request, prefix + "rev_status", ""));
		setBkgStaff(JSPUtil.getParameter(request, prefix + "bkg_staff", ""));
		setSelBkgOfcCd(JSPUtil.getParameter(request, prefix + "sel_bkg_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortCloseBLlistVO[]
	 */
	public PortCloseBLlistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortCloseBLlistVO[]
	 */
	public PortCloseBLlistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortCloseBLlistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgRtStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rt_sts_cd", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] downTpB = (JSPUtil.getParameter(request, prefix	+ "down_tp_b", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			String[] bkgStf = (JSPUtil.getParameter(request, prefix	+ "bkg_stf", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] downTpO = (JSPUtil.getParameter(request, prefix	+ "down_tp_o", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] siFlg = (JSPUtil.getParameter(request, prefix	+ "si_flg", length));
			String[] downTpT = (JSPUtil.getParameter(request, prefix	+ "down_tp_t", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgPctDt = (JSPUtil.getParameter(request, prefix	+ "bkg_pct_dt", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));
			String[] gso = (JSPUtil.getParameter(request, prefix	+ "gso", length));
			String[] cntrCfm = (JSPUtil.getParameter(request, prefix	+ "cntr_cfm", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] revStatus = (JSPUtil.getParameter(request, prefix	+ "rev_status", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			String[] selBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "sel_bkg_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortCloseBLlistVO();
				if (bkgRtStsCd[i] != null)
					model.setBkgRtStsCd(bkgRtStsCd[i]);
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (downTpB[i] != null)
					model.setDownTpB(downTpB[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				if (bkgStf[i] != null)
					model.setBkgStf(bkgStf[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (downTpO[i] != null)
					model.setDownTpO(downTpO[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (siFlg[i] != null)
					model.setSiFlg(siFlg[i]);
				if (downTpT[i] != null)
					model.setDownTpT(downTpT[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgPctDt[i] != null)
					model.setBkgPctDt(bkgPctDt[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (gso[i] != null)
					model.setGso(gso[i]);
				if (cntrCfm[i] != null)
					model.setCntrCfm(cntrCfm[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (revStatus[i] != null)
					model.setRevStatus(revStatus[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (selBkgOfcCd[i] != null)
					model.setSelBkgOfcCd(selBkgOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortCloseBLlistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortCloseBLlistVO[]
	 */
	public PortCloseBLlistVO[] getPortCloseBLlistVOs(){
		PortCloseBLlistVO[] vos = (PortCloseBLlistVO[])models.toArray(new PortCloseBLlistVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downTpB = this.downTpB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStf = this.bkgStf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downTpO = this.downTpO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siFlg = this.siFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downTpT = this.downTpT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPctDt = this.bkgPctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gso = this.gso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCfm = this.cntrCfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revStatus = this.revStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selBkgOfcCd = this.selBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
