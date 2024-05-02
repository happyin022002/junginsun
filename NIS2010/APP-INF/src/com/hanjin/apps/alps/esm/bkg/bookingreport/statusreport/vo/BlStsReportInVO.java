/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BlStsReportInVO.java
*@FileTitle : BlStsReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.21
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2012.11.21 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlStsReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlStsReportInVO> models = new ArrayList<BlStsReportInVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgBlCd = null;
	/* Column Info */
	private String blStsCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String blTypeOri = null;
	/* Column Info */
	private String bkgBlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTypeWay = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String byCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String blTypeWeb = null;
	/* Column Info */
	private String duraToDt = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String duraFromDt = null;
	/* Column Info */
	private String bOfcCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String blOfcCd = null;
	/* Column Info */
	private String staffId = null;
	/* Column Info */
	private String salOfcCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String scRfaCd = null;
	/* Column Info */
	private String duraOpt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String oblRcvOfcCd = null;
	/* Column Info */
	private String oblOfcCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String delOfcCd = null;
	/* Column Info */
	private String n3ptyOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlStsReportInVO() {}

	public BlStsReportInVO(String ibflag, String pagerows, String rowsPerPage, String currPage, String duraOpt, String duraFromDt, String duraToDt, String blTypeOri, String blTypeWay, String vvdCd, String polCd, String podCd, String porCd, String delCd, String delOfcCd, String oblOfcCd, String bkgOfcCd, String salOfcCd, String blOfcCd, String oblRcvOfcCd, String byCd, String staffId, String bkgBlCd, String bkgBlNo, String custTpCd, String custCntCd, String custSeq, String custNm, String blStsCd, String scRfaNo, String scRfaCd, String blTypeWeb, String bOfcCd, String n3ptyOfcCd) {
		this.porCd = porCd;
		this.bkgBlCd = bkgBlCd;
		this.blStsCd = blStsCd;
		this.custNm = custNm;
		this.blTypeOri = blTypeOri;
		this.bkgBlNo = bkgBlNo;
		this.pagerows = pagerows;
		this.blTypeWay = blTypeWay;
		this.polCd = polCd;
		this.rowsPerPage = rowsPerPage;
		this.ibflag = ibflag;
		this.currPage = currPage;
		this.byCd = byCd;
		this.vvdCd = vvdCd;
		this.blTypeWeb = blTypeWeb;
		this.duraToDt = duraToDt;
		this.custTpCd = custTpCd;
		this.custCntCd = custCntCd;
		this.duraFromDt = duraFromDt;
		this.bOfcCd = bOfcCd;
		this.bkgOfcCd = bkgOfcCd;
		this.blOfcCd = blOfcCd;
		this.staffId = staffId;
		this.salOfcCd = salOfcCd;
		this.delCd = delCd;
		this.scRfaCd = scRfaCd;
		this.duraOpt = duraOpt;
		this.custSeq = custSeq;
		this.oblRcvOfcCd = oblRcvOfcCd;
		this.oblOfcCd = oblOfcCd;
		this.podCd = podCd;
		this.scRfaNo = scRfaNo;
		this.delOfcCd = delOfcCd;
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_bl_cd", getBkgBlCd());
		this.hashColumns.put("bl_sts_cd", getBlStsCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_type_ori", getBlTypeOri());
		this.hashColumns.put("bkg_bl_no", getBkgBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_type_way", getBlTypeWay());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("by_cd", getByCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bl_type_web", getBlTypeWeb());
		this.hashColumns.put("dura_to_dt", getDuraToDt());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("dura_from_dt", getDuraFromDt());
		this.hashColumns.put("b_ofc_cd", getBOfcCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bl_ofc_cd", getBlOfcCd());
		this.hashColumns.put("staff_id", getStaffId());
		this.hashColumns.put("sal_ofc_cd", getSalOfcCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("sc_rfa_cd", getScRfaCd());
		this.hashColumns.put("dura_opt", getDuraOpt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("obl_rcv_ofc_cd", getOblRcvOfcCd());
		this.hashColumns.put("obl_ofc_cd", getOblOfcCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("del_ofc_cd", getDelOfcCd());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_bl_cd", "bkgBlCd");
		this.hashFields.put("bl_sts_cd", "blStsCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_type_ori", "blTypeOri");
		this.hashFields.put("bkg_bl_no", "bkgBlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_type_way", "blTypeWay");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("by_cd", "byCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bl_type_web", "blTypeWeb");
		this.hashFields.put("dura_to_dt", "duraToDt");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("dura_from_dt", "duraFromDt");
		this.hashFields.put("b_ofc_cd", "bOfcCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bl_ofc_cd", "blOfcCd");
		this.hashFields.put("staff_id", "staffId");
		this.hashFields.put("sal_ofc_cd", "salOfcCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("sc_rfa_cd", "scRfaCd");
		this.hashFields.put("dura_opt", "duraOpt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("obl_rcv_ofc_cd", "oblRcvOfcCd");
		this.hashFields.put("obl_ofc_cd", "oblOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("del_ofc_cd", "delOfcCd");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
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
	 * @return bkgBlCd
	 */
	public String getBkgBlCd() {
		return this.bkgBlCd;
	}
	
	/**
	 * Column Info
	 * @return blStsCd
	 */
	public String getBlStsCd() {
		return this.blStsCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return blTypeOri
	 */
	public String getBlTypeOri() {
		return this.blTypeOri;
	}
	
	/**
	 * Column Info
	 * @return bkgBlNo
	 */
	public String getBkgBlNo() {
		return this.bkgBlNo;
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
	 * @return blTypeWay
	 */
	public String getBlTypeWay() {
		return this.blTypeWay;
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
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
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
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return byCd
	 */
	public String getByCd() {
		return this.byCd;
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
	 * @return blTypeWeb
	 */
	public String getBlTypeWeb() {
		return this.blTypeWeb;
	}
	
	/**
	 * Column Info
	 * @return duraToDt
	 */
	public String getDuraToDt() {
		return this.duraToDt;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return duraFromDt
	 */
	public String getDuraFromDt() {
		return this.duraFromDt;
	}
	
	/**
	 * Column Info
	 * @return bOfcCd
	 */
	public String getBOfcCd() {
		return this.bOfcCd;
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
	 * @return blOfcCd
	 */
	public String getBlOfcCd() {
		return this.blOfcCd;
	}
	
	/**
	 * Column Info
	 * @return staffId
	 */
	public String getStaffId() {
		return this.staffId;
	}
	
	/**
	 * Column Info
	 * @return salOfcCd
	 */
	public String getSalOfcCd() {
		return this.salOfcCd;
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
	 * @return scRfaCd
	 */
	public String getScRfaCd() {
		return this.scRfaCd;
	}
	
	/**
	 * Column Info
	 * @return duraOpt
	 */
	public String getDuraOpt() {
		return this.duraOpt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return oblRcvOfcCd
	 */
	public String getOblRcvOfcCd() {
		return this.oblRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return oblOfcCd
	 */
	public String getOblOfcCd() {
		return this.oblOfcCd;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return delOfcCd
	 */
	public String getDelOfcCd() {
		return this.delOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
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
	 * @param bkgBlCd
	 */
	public void setBkgBlCd(String bkgBlCd) {
		this.bkgBlCd = bkgBlCd;
	}
	
	/**
	 * Column Info
	 * @param blStsCd
	 */
	public void setBlStsCd(String blStsCd) {
		this.blStsCd = blStsCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param blTypeOri
	 */
	public void setBlTypeOri(String blTypeOri) {
		this.blTypeOri = blTypeOri;
	}
	
	/**
	 * Column Info
	 * @param bkgBlNo
	 */
	public void setBkgBlNo(String bkgBlNo) {
		this.bkgBlNo = bkgBlNo;
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
	 * @param blTypeWay
	 */
	public void setBlTypeWay(String blTypeWay) {
		this.blTypeWay = blTypeWay;
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
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
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
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param byCd
	 */
	public void setByCd(String byCd) {
		this.byCd = byCd;
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
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	
	/**
	 * Column Info
	 * @param blTypeWeb
	 */
	public void setBlTypeWeb(String blTypeWeb) {
		this.blTypeWeb = blTypeWeb;
	}
	
	/**
	 * Column Info
	 * @param duraToDt
	 */
	public void setDuraToDt(String duraToDt) {
		this.duraToDt = duraToDt;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param duraFromDt
	 */
	public void setDuraFromDt(String duraFromDt) {
		this.duraFromDt = duraFromDt;
	}
	
	/**
	 * Column Info
	 * @param bOfcCd
	 */
	public void setBOfcCd(String bOfcCd) {
		this.bOfcCd = bOfcCd;
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
	 * @param blOfcCd
	 */
	public void setBlOfcCd(String blOfcCd) {
		this.blOfcCd = blOfcCd;
	}
	
	/**
	 * Column Info
	 * @param staffId
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	/**
	 * Column Info
	 * @param salOfcCd
	 */
	public void setSalOfcCd(String salOfcCd) {
		this.salOfcCd = salOfcCd;
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
	 * @param scRfaCd
	 */
	public void setScRfaCd(String scRfaCd) {
		this.scRfaCd = scRfaCd;
	}
	
	/**
	 * Column Info
	 * @param duraOpt
	 */
	public void setDuraOpt(String duraOpt) {
		this.duraOpt = duraOpt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param oblRcvOfcCd
	 */
	public void setOblRcvOfcCd(String oblRcvOfcCd) {
		this.oblRcvOfcCd = oblRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param oblOfcCd
	 */
	public void setOblOfcCd(String oblOfcCd) {
		this.oblOfcCd = oblOfcCd;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param delOfcCd
	 */
	public void setDelOfcCd(String delOfcCd) {
		this.delOfcCd = delOfcCd;
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
		setBkgBlCd(JSPUtil.getParameter(request, prefix + "bkg_bl_cd", ""));
		setBlStsCd(JSPUtil.getParameter(request, prefix + "bl_sts_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBlTypeOri(JSPUtil.getParameter(request, prefix + "bl_type_ori", ""));
		setBkgBlNo(JSPUtil.getParameter(request, prefix + "bkg_bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlTypeWay(JSPUtil.getParameter(request, prefix + "bl_type_way", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setByCd(JSPUtil.getParameter(request, prefix + "by_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBlTypeWeb(JSPUtil.getParameter(request, prefix + "bl_type_web", ""));
		setDuraToDt(JSPUtil.getParameter(request, prefix + "dura_to_dt", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setDuraFromDt(JSPUtil.getParameter(request, prefix + "dura_from_dt", ""));
		setBOfcCd(JSPUtil.getParameter(request, prefix + "b_ofc_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBlOfcCd(JSPUtil.getParameter(request, prefix + "bl_ofc_cd", ""));
		setStaffId(JSPUtil.getParameter(request, prefix + "staff_id", ""));
		setSalOfcCd(JSPUtil.getParameter(request, prefix + "sal_ofc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setScRfaCd(JSPUtil.getParameter(request, prefix + "sc_rfa_cd", ""));
		setDuraOpt(JSPUtil.getParameter(request, prefix + "dura_opt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOblRcvOfcCd(JSPUtil.getParameter(request, prefix + "obl_rcv_ofc_cd", ""));
		setOblOfcCd(JSPUtil.getParameter(request, prefix + "obl_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setDelOfcCd(JSPUtil.getParameter(request, prefix + "del_ofc_cd", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlStsReportInVO[]
	 */
	public BlStsReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlStsReportInVO[]
	 */
	public BlStsReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlStsReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgBlCd = (JSPUtil.getParameter(request, prefix	+ "bkg_bl_cd", length));
			String[] blStsCd = (JSPUtil.getParameter(request, prefix	+ "bl_sts_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] blTypeOri = (JSPUtil.getParameter(request, prefix	+ "bl_type_ori", length));
			String[] bkgBlNo = (JSPUtil.getParameter(request, prefix	+ "bkg_bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTypeWay = (JSPUtil.getParameter(request, prefix	+ "bl_type_way", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] byCd = (JSPUtil.getParameter(request, prefix	+ "by_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] blTypeWeb = (JSPUtil.getParameter(request, prefix	+ "bl_type_web", length));
			String[] duraToDt = (JSPUtil.getParameter(request, prefix	+ "dura_to_dt", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] duraFromDt = (JSPUtil.getParameter(request, prefix	+ "dura_from_dt", length));
			String[] bOfcCd = (JSPUtil.getParameter(request, prefix	+ "b_ofc_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] blOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_ofc_cd", length));
			String[] staffId = (JSPUtil.getParameter(request, prefix	+ "staff_id", length));
			String[] salOfcCd = (JSPUtil.getParameter(request, prefix	+ "sal_ofc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] scRfaCd = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_cd", length));
			String[] duraOpt = (JSPUtil.getParameter(request, prefix	+ "dura_opt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] oblRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rcv_ofc_cd", length));
			String[] oblOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_ofc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] delOfcCd = (JSPUtil.getParameter(request, prefix	+ "del_ofc_cd", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlStsReportInVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgBlCd[i] != null)
					model.setBkgBlCd(bkgBlCd[i]);
				if (blStsCd[i] != null)
					model.setBlStsCd(blStsCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (blTypeOri[i] != null)
					model.setBlTypeOri(blTypeOri[i]);
				if (bkgBlNo[i] != null)
					model.setBkgBlNo(bkgBlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTypeWay[i] != null)
					model.setBlTypeWay(blTypeWay[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (byCd[i] != null)
					model.setByCd(byCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (blTypeWeb[i] != null)
					model.setBlTypeWeb(blTypeWeb[i]);
				if (duraToDt[i] != null)
					model.setDuraToDt(duraToDt[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (duraFromDt[i] != null)
					model.setDuraFromDt(duraFromDt[i]);
				if (bOfcCd[i] != null)
					model.setBOfcCd(bOfcCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (blOfcCd[i] != null)
					model.setBlOfcCd(blOfcCd[i]);
				if (staffId[i] != null)
					model.setStaffId(staffId[i]);
				if (salOfcCd[i] != null)
					model.setSalOfcCd(salOfcCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (scRfaCd[i] != null)
					model.setScRfaCd(scRfaCd[i]);
				if (duraOpt[i] != null)
					model.setDuraOpt(duraOpt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (oblRcvOfcCd[i] != null)
					model.setOblRcvOfcCd(oblRcvOfcCd[i]);
				if (oblOfcCd[i] != null)
					model.setOblOfcCd(oblOfcCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (delOfcCd[i] != null)
					model.setDelOfcCd(delOfcCd[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlStsReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlStsReportInVO[]
	 */
	public BlStsReportInVO[] getBlStsReportInVOs(){
		BlStsReportInVO[] vos = (BlStsReportInVO[])models.toArray(new BlStsReportInVO[models.size()]);
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
		this.bkgBlCd = this.bkgBlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blStsCd = this.blStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTypeOri = this.blTypeOri .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBlNo = this.bkgBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTypeWay = this.blTypeWay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.byCd = this.byCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTypeWeb = this.blTypeWeb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraToDt = this.duraToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraFromDt = this.duraFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bOfcCd = this.bOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOfcCd = this.blOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.staffId = this.staffId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salOfcCd = this.salOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaCd = this.scRfaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duraOpt = this.duraOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRcvOfcCd = this.oblRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblOfcCd = this.oblOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delOfcCd = this.delOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
