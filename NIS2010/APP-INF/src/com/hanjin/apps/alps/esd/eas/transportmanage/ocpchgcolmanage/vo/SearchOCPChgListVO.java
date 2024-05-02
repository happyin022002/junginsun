/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchOCPChgListVO.java
*@FileTitle : SearchOCPChgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.16
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.09.16 이정수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.transportmanage.ocpchgcolmanage.vo;

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
 * @author 이정수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOCPChgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOCPChgListVO> models = new ArrayList<SearchOCPChgListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String sCneeNo = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String tsCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String mtRtnDt = null;
	/* Column Info */
	private String rmkCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibRlseCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String shprNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String rcvTm = null;
	/* Column Info */
	private String bkgOcpTp = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ibRlseDt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String delTm = null;
	/* Column Info */
	private String bkgOcpAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String scRfaCd = null;
	/* Column Info */
	private String ibRlseCnt = null;
	/* Column Info */
	private String easExpnTpCd = null;
	/* Column Info */
	private String tpbCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sCtrlOfcCd = null;
	/* Column Info */
	private String cneeNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sMtRtnCd = null;
	/* Column Info */
	private String mtRtnCd = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String inquiryLevel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOCPChgListVO() {}

	public SearchOCPChgListVO(String ibflag, String pagerows, String sCtrlOfcCd, String sMtRtnCd, String sBkgNo, String sCneeNo, String fmDt, String toDt, String ctrlOfcCd, String bkgStsCd, String bkgNo, String cntrNo, String tsCd, String rcvTm, String delTm, String shprNo, String cneeNo, String porCd, String polCd, String podCd, String delCd, String scRfaCd, String ibRlseCd, String ibRlseDt, String ibRlseCnt, String mtRtnCd, String mtRtnDt, String bkgOcpTp, String bkgOcpAmt, String tpbCd, String rmkCtnt, String updUsrId, String creUsrId, String creOfcCd, String easExpnTpCd, String location, String inquiryLevel) {
		this.porCd = porCd;
		this.sCneeNo = sCneeNo;
		this.sBkgNo = sBkgNo;
		this.tsCd = tsCd;
		this.bkgStsCd = bkgStsCd;
		this.mtRtnDt = mtRtnDt;
		this.rmkCtnt = rmkCtnt;
		this.pagerows = pagerows;
		this.ibRlseCd = ibRlseCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.shprNo = shprNo;
		this.creOfcCd = creOfcCd;
		this.rcvTm = rcvTm;
		this.bkgOcpTp = bkgOcpTp;
		this.updUsrId = updUsrId;
		this.ibRlseDt = ibRlseDt;
		this.fmDt = fmDt;
		this.delTm = delTm;
		this.bkgOcpAmt = bkgOcpAmt;
		this.delCd = delCd;
		this.scRfaCd = scRfaCd;
		this.ibRlseCnt = ibRlseCnt;
		this.easExpnTpCd = easExpnTpCd;
		this.tpbCd = tpbCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.toDt = toDt;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.sCtrlOfcCd = sCtrlOfcCd;
		this.cneeNo = cneeNo;
		this.cntrNo = cntrNo;
		this.sMtRtnCd = sMtRtnCd;
		this.mtRtnCd = mtRtnCd;
		this.location = location;
		this.inquiryLevel = inquiryLevel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("s_cnee_no", getSCneeNo());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("ts_cd", getTsCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("mt_rtn_dt", getMtRtnDt());
		this.hashColumns.put("rmk_ctnt", getRmkCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ib_rlse_cd", getIbRlseCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("shpr_no", getShprNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("rcv_tm", getRcvTm());
		this.hashColumns.put("bkg_ocp_tp", getBkgOcpTp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ib_rlse_dt", getIbRlseDt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("del_tm", getDelTm());
		this.hashColumns.put("bkg_ocp_amt", getBkgOcpAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("sc_rfa_cd", getScRfaCd());
		this.hashColumns.put("ib_rlse_cnt", getIbRlseCnt());
		this.hashColumns.put("eas_expn_tp_cd", getEasExpnTpCd());
		this.hashColumns.put("tpb_cd", getTpbCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("s_ctrl_ofc_cd", getSCtrlOfcCd());
		this.hashColumns.put("cnee_no", getCneeNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("s_mt_rtn_cd", getSMtRtnCd());
		this.hashColumns.put("mt_rtn_cd", getMtRtnCd());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("inquiryLevel", getInquiryLevel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("s_cnee_no", "sCneeNo");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("ts_cd", "tsCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("mt_rtn_dt", "mtRtnDt");
		this.hashFields.put("rmk_ctnt", "rmkCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_rlse_cd", "ibRlseCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("shpr_no", "shprNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("rcv_tm", "rcvTm");
		this.hashFields.put("bkg_ocp_tp", "bkgOcpTp");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ib_rlse_dt", "ibRlseDt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("del_tm", "delTm");
		this.hashFields.put("bkg_ocp_amt", "bkgOcpAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("sc_rfa_cd", "scRfaCd");
		this.hashFields.put("ib_rlse_cnt", "ibRlseCnt");
		this.hashFields.put("eas_expn_tp_cd", "easExpnTpCd");
		this.hashFields.put("tpb_cd", "tpbCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("s_ctrl_ofc_cd", "sCtrlOfcCd");
		this.hashFields.put("cnee_no", "cneeNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("s_mt_rtn_cd", "sMtRtnCd");
		this.hashFields.put("mt_rtn_cd", "mtRtnCd");
		this.hashFields.put("location", "location");
		this.hashFields.put("inquiryLevel", "inquiryLevel");
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
	 * @return sCneeNo
	 */
	public String getSCneeNo() {
		return this.sCneeNo;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return tsCd
	 */
	public String getTsCd() {
		return this.tsCd;
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
	 * @return mtRtnDt
	 */
	public String getMtRtnDt() {
		return this.mtRtnDt;
	}
	
	/**
	 * Column Info
	 * @return rmkCtnt
	 */
	public String getRmkCtnt() {
		return this.rmkCtnt;
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
	 * @return ibRlseCd
	 */
	public String getIbRlseCd() {
		return this.ibRlseCd;
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
	 * @return shprNo
	 */
	public String getShprNo() {
		return this.shprNo;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTm
	 */
	public String getRcvTm() {
		return this.rcvTm;
	}
	
	/**
	 * Column Info
	 * @return bkgOcpTp
	 */
	public String getBkgOcpTp() {
		return this.bkgOcpTp;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ibRlseDt
	 */
	public String getIbRlseDt() {
		return this.ibRlseDt;
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
	 * @return delTm
	 */
	public String getDelTm() {
		return this.delTm;
	}
	
	/**
	 * Column Info
	 * @return bkgOcpAmt
	 */
	public String getBkgOcpAmt() {
		return this.bkgOcpAmt;
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
	 * @return ibRlseCnt
	 */
	public String getIbRlseCnt() {
		return this.ibRlseCnt;
	}
	
	/**
	 * Column Info
	 * @return easExpnTpCd
	 */
	public String getEasExpnTpCd() {
		return this.easExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return tpbCd
	 */
	public String getTpbCd() {
		return this.tpbCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sCtrlOfcCd
	 */
	public String getSCtrlOfcCd() {
		return this.sCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNo
	 */
	public String getCneeNo() {
		return this.cneeNo;
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
	 * @return sMtRtnCd
	 */
	public String getSMtRtnCd() {
		return this.sMtRtnCd;
	}
	
	/**
	 * Column Info
	 * @return mtRtnCd
	 */
	public String getMtRtnCd() {
		return this.mtRtnCd;
	}
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInquiryLevel() {
		return inquiryLevel;
	}

	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
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
	 * @param sCneeNo
	 */
	public void setSCneeNo(String sCneeNo) {
		this.sCneeNo = sCneeNo;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param tsCd
	 */
	public void setTsCd(String tsCd) {
		this.tsCd = tsCd;
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
	 * @param mtRtnDt
	 */
	public void setMtRtnDt(String mtRtnDt) {
		this.mtRtnDt = mtRtnDt;
	}
	
	/**
	 * Column Info
	 * @param rmkCtnt
	 */
	public void setRmkCtnt(String rmkCtnt) {
		this.rmkCtnt = rmkCtnt;
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
	 * @param ibRlseCd
	 */
	public void setIbRlseCd(String ibRlseCd) {
		this.ibRlseCd = ibRlseCd;
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
	 * @param shprNo
	 */
	public void setShprNo(String shprNo) {
		this.shprNo = shprNo;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTm
	 */
	public void setRcvTm(String rcvTm) {
		this.rcvTm = rcvTm;
	}
	
	/**
	 * Column Info
	 * @param bkgOcpTp
	 */
	public void setBkgOcpTp(String bkgOcpTp) {
		this.bkgOcpTp = bkgOcpTp;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ibRlseDt
	 */
	public void setIbRlseDt(String ibRlseDt) {
		this.ibRlseDt = ibRlseDt;
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
	 * @param delTm
	 */
	public void setDelTm(String delTm) {
		this.delTm = delTm;
	}
	
	/**
	 * Column Info
	 * @param bkgOcpAmt
	 */
	public void setBkgOcpAmt(String bkgOcpAmt) {
		this.bkgOcpAmt = bkgOcpAmt;
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
	 * @param ibRlseCnt
	 */
	public void setIbRlseCnt(String ibRlseCnt) {
		this.ibRlseCnt = ibRlseCnt;
	}
	
	/**
	 * Column Info
	 * @param easExpnTpCd
	 */
	public void setEasExpnTpCd(String easExpnTpCd) {
		this.easExpnTpCd = easExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param tpbCd
	 */
	public void setTpbCd(String tpbCd) {
		this.tpbCd = tpbCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sCtrlOfcCd
	 */
	public void setSCtrlOfcCd(String sCtrlOfcCd) {
		this.sCtrlOfcCd = sCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cneeNo
	 */
	public void setCneeNo(String cneeNo) {
		this.cneeNo = cneeNo;
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
	 * @param sMtRtnCd
	 */
	public void setSMtRtnCd(String sMtRtnCd) {
		this.sMtRtnCd = sMtRtnCd;
	}
	
	/**
	 * Column Info
	 * @param mtRtnCd
	 */
	public void setMtRtnCd(String mtRtnCd) {
		this.mtRtnCd = mtRtnCd;
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
		setSCneeNo(JSPUtil.getParameter(request, prefix + "s_cnee_no", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setTsCd(JSPUtil.getParameter(request, prefix + "ts_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setMtRtnDt(JSPUtil.getParameter(request, prefix + "mt_rtn_dt", ""));
		setRmkCtnt(JSPUtil.getParameter(request, prefix + "rmk_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbRlseCd(JSPUtil.getParameter(request, prefix + "ib_rlse_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setShprNo(JSPUtil.getParameter(request, prefix + "shpr_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setRcvTm(JSPUtil.getParameter(request, prefix + "rcv_tm", ""));
		setBkgOcpTp(JSPUtil.getParameter(request, prefix + "bkg_ocp_tp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIbRlseDt(JSPUtil.getParameter(request, prefix + "ib_rlse_dt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setDelTm(JSPUtil.getParameter(request, prefix + "del_tm", ""));
		setBkgOcpAmt(JSPUtil.getParameter(request, prefix + "bkg_ocp_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setScRfaCd(JSPUtil.getParameter(request, prefix + "sc_rfa_cd", ""));
		setIbRlseCnt(JSPUtil.getParameter(request, prefix + "ib_rlse_cnt", ""));
		setEasExpnTpCd(JSPUtil.getParameter(request, prefix + "eas_expn_tp_cd", ""));
		setTpbCd(JSPUtil.getParameter(request, prefix + "tpb_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSCtrlOfcCd(JSPUtil.getParameter(request, prefix + "s_ctrl_ofc_cd", ""));
		setCneeNo(JSPUtil.getParameter(request, prefix + "cnee_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSMtRtnCd(JSPUtil.getParameter(request, prefix + "s_mt_rtn_cd", ""));
		setMtRtnCd(JSPUtil.getParameter(request, prefix + "mt_rtn_cd", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setInquiryLevel(JSPUtil.getParameter(request, prefix + "inquiryLevel", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOCPChgListVO[]
	 */
	public SearchOCPChgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOCPChgListVO[]
	 */
	public SearchOCPChgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOCPChgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] sCneeNo = (JSPUtil.getParameter(request, prefix	+ "s_cnee_no", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] tsCd = (JSPUtil.getParameter(request, prefix	+ "ts_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] mtRtnDt = (JSPUtil.getParameter(request, prefix	+ "mt_rtn_dt", length));
			String[] rmkCtnt = (JSPUtil.getParameter(request, prefix	+ "rmk_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibRlseCd = (JSPUtil.getParameter(request, prefix	+ "ib_rlse_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] shprNo = (JSPUtil.getParameter(request, prefix	+ "shpr_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] rcvTm = (JSPUtil.getParameter(request, prefix	+ "rcv_tm", length));
			String[] bkgOcpTp = (JSPUtil.getParameter(request, prefix	+ "bkg_ocp_tp", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ibRlseDt = (JSPUtil.getParameter(request, prefix	+ "ib_rlse_dt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] delTm = (JSPUtil.getParameter(request, prefix	+ "del_tm", length));
			String[] bkgOcpAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_ocp_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] scRfaCd = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_cd", length));
			String[] ibRlseCnt = (JSPUtil.getParameter(request, prefix	+ "ib_rlse_cnt", length));
			String[] easExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "eas_expn_tp_cd", length));
			String[] tpbCd = (JSPUtil.getParameter(request, prefix	+ "tpb_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ctrl_ofc_cd", length));
			String[] cneeNo = (JSPUtil.getParameter(request, prefix	+ "cnee_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sMtRtnCd = (JSPUtil.getParameter(request, prefix	+ "s_mt_rtn_cd", length));
			String[] mtRtnCd = (JSPUtil.getParameter(request, prefix	+ "mt_rtn_cd", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] inquiryLevel = (JSPUtil.getParameter(request, prefix	+ "inquiryLevel", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOCPChgListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (sCneeNo[i] != null)
					model.setSCneeNo(sCneeNo[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (tsCd[i] != null)
					model.setTsCd(tsCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (mtRtnDt[i] != null)
					model.setMtRtnDt(mtRtnDt[i]);
				if (rmkCtnt[i] != null)
					model.setRmkCtnt(rmkCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibRlseCd[i] != null)
					model.setIbRlseCd(ibRlseCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (shprNo[i] != null)
					model.setShprNo(shprNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (rcvTm[i] != null)
					model.setRcvTm(rcvTm[i]);
				if (bkgOcpTp[i] != null)
					model.setBkgOcpTp(bkgOcpTp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ibRlseDt[i] != null)
					model.setIbRlseDt(ibRlseDt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (delTm[i] != null)
					model.setDelTm(delTm[i]);
				if (bkgOcpAmt[i] != null)
					model.setBkgOcpAmt(bkgOcpAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (scRfaCd[i] != null)
					model.setScRfaCd(scRfaCd[i]);
				if (ibRlseCnt[i] != null)
					model.setIbRlseCnt(ibRlseCnt[i]);
				if (easExpnTpCd[i] != null)
					model.setEasExpnTpCd(easExpnTpCd[i]);
				if (tpbCd[i] != null)
					model.setTpbCd(tpbCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sCtrlOfcCd[i] != null)
					model.setSCtrlOfcCd(sCtrlOfcCd[i]);
				if (cneeNo[i] != null)
					model.setCneeNo(cneeNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sMtRtnCd[i] != null)
					model.setSMtRtnCd(sMtRtnCd[i]);
				if (mtRtnCd[i] != null)
					model.setMtRtnCd(mtRtnCd[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (inquiryLevel[i] != null)
					model.setInquiryLevel(inquiryLevel[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOCPChgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOCPChgListVO[]
	 */
	public SearchOCPChgListVO[] getSearchOCPChgListVOs(){
		SearchOCPChgListVO[] vos = (SearchOCPChgListVO[])models.toArray(new SearchOCPChgListVO[models.size()]);
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
		this.sCneeNo = this.sCneeNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsCd = this.tsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRtnDt = this.mtRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkCtnt = this.rmkCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRlseCd = this.ibRlseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNo = this.shprNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTm = this.rcvTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOcpTp = this.bkgOcpTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRlseDt = this.ibRlseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTm = this.delTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOcpAmt = this.bkgOcpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaCd = this.scRfaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRlseCnt = this.ibRlseCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.easExpnTpCd = this.easExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbCd = this.tpbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCtrlOfcCd = this.sCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNo = this.cneeNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMtRtnCd = this.sMtRtnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRtnCd = this.mtRtnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryLevel = this.inquiryLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
