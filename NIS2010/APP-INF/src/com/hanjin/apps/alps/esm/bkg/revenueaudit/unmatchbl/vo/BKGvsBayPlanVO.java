/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BKGvsBayPlanVO.java
*@FileTitle : BKGvsBayPlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BKGvsBayPlanVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BKGvsBayPlanVO> models = new ArrayList<BKGvsBayPlanVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String position = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String searchDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String voidDiff = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String voidVol = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String voidSltQty = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String chargeFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sztp = null;
	
	/* Column Info */
	private String rdrVvd = null;
	/* Column Info */
	private String rdrPol = null;
	/* Column Info */
	private String rdrPod = null;
	/* Column Info */
	private String rdrSztp = null;
	/* Column Info */
	private String rdrPosition = null;
	/* Column Info */
	private String rdrVoidVol = null;
	/* Column Info */
	private String rdrVoidDiff = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BKGvsBayPlanVO() {}

	public BKGvsBayPlanVO(String ibflag, String pagerows, String bkgRhqCd, String bkgOfcCd, String bkgNo, String bkgCtrtTpCd, String ctrtNo, String porCd, String polCd, String podCd, String delCd, String cntrNo, String cntrTpszCd, String voidSltQty, String vvd, String pol, String pod, String sztp, String position, String voidVol, String voidDiff, String searchDate, String fmDt, String toDt, String svcScpCd, String tVvd, String bdrFlg, String chargeFlg,String rdrVoidDiff,String rdrVoidVol,String rdrPosition,String rdrSztp,String rdrPod,String rdrPol,String rdrVvd) {
		this.porCd = porCd;
		this.position = position;
		this.bdrFlg = bdrFlg;
		this.svcScpCd = svcScpCd;
		this.bkgRhqCd = bkgRhqCd;
		this.searchDate = searchDate;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.tVvd = tVvd;
		this.cntrTpszCd = cntrTpszCd;
		this.pol = pol;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.pod = pod;
		this.voidDiff = voidDiff;
		this.bkgOfcCd = bkgOfcCd;
		this.fmDt = fmDt;
		this.voidVol = voidVol;
		this.delCd = delCd;
		this.voidSltQty = voidSltQty;
		this.podCd = podCd;
		this.vvd = vvd;
		this.toDt = toDt;
		this.chargeFlg = chargeFlg;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.sztp = sztp;
		
		this.rdrVvd = rdrVvd;
		this.rdrPol = rdrPol;
		this.rdrPod = rdrPod;
		this.rdrSztp = rdrSztp;
		this.rdrPosition = rdrPosition;
		this.rdrVoidVol = rdrVoidVol;
		this.rdrVoidDiff = rdrVoidDiff;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("position", getPosition());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("search_date", getSearchDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("void_diff", getVoidDiff());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("void_vol", getVoidVol());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("void_slt_qty", getVoidSltQty());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("charge_flg", getChargeFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sztp", getSztp());
		
		this.hashColumns.put("rdr_vvd", getRdrVvd());
		this.hashColumns.put("rdr_pol", getRdrPol());
		this.hashColumns.put("rdr_pod", getRdrPod());
		this.hashColumns.put("rdr_sztp", getRdrSztp());
		this.hashColumns.put("rdr_position", getRdrPosition());
		this.hashColumns.put("rdr_void_vol", getRdrVoidVol());
		this.hashColumns.put("rdr_void_diff", getRdrVoidDiff());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("position", "position");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("search_date", "searchDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("void_diff", "voidDiff");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("void_vol", "voidVol");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("void_slt_qty", "voidSltQty");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("charge_flg", "chargeFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sztp", "sztp");
		
		this.hashFields.put("rdr_vvd", "rdrVvd");
		this.hashFields.put("rdr_pol", "rdrPol");
		this.hashFields.put("rdr_pod", "rdrPod");
		this.hashFields.put("rdr_sztp", "rdrSztp");
		this.hashFields.put("rdr_position", "rdrPosition");
		this.hashFields.put("rdr_void_vol", "rdrVoidVol");
		this.hashFields.put("rdr_void_diff", "rdrVoidDiff");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return position
	 */
	public String getPosition() {
		return this.position;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRhqCd
	 */
	public String getBkgRhqCd() {
		return this.bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return searchDate
	 */
	public String getSearchDate() {
		return this.searchDate;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return voidDiff
	 */
	public String getVoidDiff() {
		return this.voidDiff;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return voidVol
	 */
	public String getVoidVol() {
		return this.voidVol;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return voidSltQty
	 */
	public String getVoidSltQty() {
		return this.voidSltQty;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return chargeFlg
	 */
	public String getChargeFlg() {
		return this.chargeFlg;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return sztp
	 */
	public String getSztp() {
		return this.sztp;
	}
	
	
	/**
	 * Column Info
	 * @return rdrVvd
	 */
	public String getRdrVvd() {
		return this.rdrVvd;
	}
	/**
	 * Column Info
	 * @return rdrPol
	 */
	public String getRdrPol() {
		return this.rdrPol;
	}
	/**
	 * Column Info
	 * @return rdrPod
	 */
	public String getRdrPod() {
		return this.rdrPod;
	}
	/**
	 * Column Info
	 * @return rdrSztp
	 */
	public String getRdrSztp() {
		return this.rdrSztp;
	}
	/**
	 * Column Info
	 * @return rdrPosition
	 */
	public String getRdrPosition() {
		return this.rdrPosition;
	}
	/**
	 * Column Info
	 * @return rdrVoidVol
	 */
	public String getRdrVoidVol() {
		return this.rdrVoidVol;
	}
	/**
	 * Column Info
	 * @return rdrVoidDiff
	 */
	public String getRdrVoidDiff() {
		return this.rdrVoidDiff;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRhqCd
	 */
	public void setBkgRhqCd(String bkgRhqCd) {
		this.bkgRhqCd = bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param searchDate
	 */
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param voidDiff
	 */
	public void setVoidDiff(String voidDiff) {
		this.voidDiff = voidDiff;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param voidVol
	 */
	public void setVoidVol(String voidVol) {
		this.voidVol = voidVol;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param voidSltQty
	 */
	public void setVoidSltQty(String voidSltQty) {
		this.voidSltQty = voidSltQty;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param chargeFlg
	 */
	public void setChargeFlg(String chargeFlg) {
		this.chargeFlg = chargeFlg;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param sztp
	 */
	public void setSztp(String sztp) {
		this.sztp = sztp;
	}
	
	
	
	
	/**
	 * Column Info
	 * @param rdrVvd
	 */
	public void setRdrVvd(String rdrVvd) {
		this.rdrVvd = rdrVvd;
	}
	/**
	 * Column Info
	 * @param rdrPol
	 */
	public void setRdrPol(String rdrPol) {
		this.rdrPol = rdrPol;
	}
	/**
	 * Column Info
	 * @param rdrPod
	 */
	public void setRdrPod(String rdrPod) {
		this.rdrPod = rdrPod;
	}
	/**
	 * Column Info
	 * @param rdrSztp
	 */
	public void setRdrSztp(String rdrSztp) {
		this.rdrSztp = rdrSztp;
	}
	/**
	 * Column Info
	 * @param rdrPosition
	 */
	public void setRdrPosition(String rdrPosition) {
		this.rdrPosition = rdrPosition;
	}
	/**
	 * Column Info
	 * @param rdrVoidVol
	 */
	public void setRdrVoidVol(String rdrVoidVol) {
		this.rdrVoidVol = rdrVoidVol;
	}
	/**
	 * Column Info
	 * @param rdrVoidDiff
	 */
	public void setRdrVoidDiff(String rdrVoidDiff) {
		this.rdrVoidDiff = rdrVoidDiff;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPosition(JSPUtil.getParameter(request, prefix + "position", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setSearchDate(JSPUtil.getParameter(request, prefix + "search_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setVoidDiff(JSPUtil.getParameter(request, prefix + "void_diff", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setVoidVol(JSPUtil.getParameter(request, prefix + "void_vol", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setVoidSltQty(JSPUtil.getParameter(request, prefix + "void_slt_qty", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setChargeFlg(JSPUtil.getParameter(request, prefix + "charge_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSztp(JSPUtil.getParameter(request, prefix + "sztp", ""));
		
		setRdrVvd(JSPUtil.getParameter(request, prefix + "rdr_vvd", ""));
		setRdrPol(JSPUtil.getParameter(request, prefix + "rdr_pol", ""));
		setRdrPod(JSPUtil.getParameter(request, prefix + "rdr_pod", ""));
		setRdrSztp(JSPUtil.getParameter(request, prefix + "rdr_sztp", ""));
		setRdrPosition(JSPUtil.getParameter(request, prefix + "rdr_position", ""));
		setRdrVoidVol(JSPUtil.getParameter(request, prefix + "rdr_void_vol", ""));
		setRdrVoidDiff(JSPUtil.getParameter(request, prefix + "rdr_void_diff", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BKGvsBayPlanVO[]
	 */
	public BKGvsBayPlanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BKGvsBayPlanVO[]
	 */
	public BKGvsBayPlanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BKGvsBayPlanVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] position = (JSPUtil.getParameter(request, prefix	+ "position", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] searchDate = (JSPUtil.getParameter(request, prefix	+ "search_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] voidDiff = (JSPUtil.getParameter(request, prefix	+ "void_diff", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] voidVol = (JSPUtil.getParameter(request, prefix	+ "void_vol", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] voidSltQty = (JSPUtil.getParameter(request, prefix	+ "void_slt_qty", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] chargeFlg = (JSPUtil.getParameter(request, prefix	+ "charge_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sztp = (JSPUtil.getParameter(request, prefix	+ "sztp", length));
			
			String[] rdrVvd = (JSPUtil.getParameter(request, prefix	+ "rdr_vvd", length));
			String[] rdrPol = (JSPUtil.getParameter(request, prefix	+ "rdr_pol", length));
			String[] rdrPod = (JSPUtil.getParameter(request, prefix	+ "rdr_pod", length));
			String[] rdrSztp = (JSPUtil.getParameter(request, prefix	+ "rdr_sztp", length));
			String[] rdrPosition = (JSPUtil.getParameter(request, prefix	+ "rdr_position", length));
			String[] rdrVoidVol = (JSPUtil.getParameter(request, prefix	+ "rdr_void_vol", length));
			String[] rdrVoidDiff = (JSPUtil.getParameter(request, prefix	+ "rdr_void_diff", length));
			
			for (int i = 0; i < length; i++) {
				model = new BKGvsBayPlanVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (position[i] != null)
					model.setPosition(position[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (searchDate[i] != null)
					model.setSearchDate(searchDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (voidDiff[i] != null)
					model.setVoidDiff(voidDiff[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (voidVol[i] != null)
					model.setVoidVol(voidVol[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (voidSltQty[i] != null)
					model.setVoidSltQty(voidSltQty[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (chargeFlg[i] != null)
					model.setChargeFlg(chargeFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sztp[i] != null)
					model.setSztp(sztp[i]);
				
				if (rdrVvd[i] != null)
					model.setRdrVvd(rdrVvd[i]);
				if (rdrPol[i] != null)
					model.setRdrPol(rdrPol[i]);
				if (rdrPod[i] != null)
					model.setRdrPod(rdrPod[i]);
				if (rdrSztp[i] != null)
					model.setRdrSztp(rdrSztp[i]);
				if (rdrPosition[i] != null)
					model.setRdrPosition(rdrPosition[i]);
				if (rdrVoidVol[i] != null)
					model.setRdrVoidVol(rdrVoidVol[i]);
				if (rdrVoidDiff[i] != null)
					model.setRdrVoidDiff(rdrVoidDiff[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBKGvsBayPlanVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BKGvsBayPlanVO[]
	 */
	public BKGvsBayPlanVO[] getBKGvsBayPlanVOs(){
		BKGvsBayPlanVO[] vos = (BKGvsBayPlanVO[])models.toArray(new BKGvsBayPlanVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.position = this.position .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDate = this.searchDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidDiff = this.voidDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidVol = this.voidVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voidSltQty = this.voidSltQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeFlg = this.chargeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sztp = this.sztp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.rdrVvd = this.rdrVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrPol = this.rdrPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrPod = this.rdrPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrSztp = this.rdrSztp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrPosition = this.rdrPosition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrVoidVol = this.rdrVoidVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrVoidDiff = this.rdrVoidDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
