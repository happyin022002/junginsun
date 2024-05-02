/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalPFMCByEqDetailVO.java
*@FileTitle : DisposalPFMCByEqDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.03
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2011.11.21 김상수 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.21 김상수 [CHM-201114548-01] sheet에 새로 추가된 DB컬럼 Book Vale 조회 추가
* 2013.01.03 조경완 [CHM-201222150-01] inv_no, iss_dt 컬럼 추가 
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPFMCByEqDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalPFMCByEqDetailVO> models = new ArrayList<DisposalPFMCByEqDetailVO>();
	
	/* Column Info */
	private String rprCostAmt = null;
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String manuDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String pEndEvntDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pLocCd = null;
	/* Column Info */
	private String pEndCreDt = null;
	/* Column Info */
	private String pStrCreDt = null;
	/* Column Info */
	private String dispPkupEndDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String bkValAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String overDate = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String pLocTp = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String dispUtPrc = null;
	/* Column Info */
	private String pChkUsd = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String dispTrfUtPrc = null;
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String calPartAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String dispPkupStDt = null;
	/* Column Info */
	private String pStrEvntDt = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String pDispRsnCd = null;
	/* Column Info */
	private String pDispTpCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String pCustCd = null;
	/* Column Info */
	private String dispVrfyTpCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String pVndrNm = null;
	/* Column Info */
	private String dispYdCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String pEqKndCd = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String dispVrfyTpNm = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String issDt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalPFMCByEqDetailVO() {}

	public DisposalPFMCByEqDetailVO(String ibflag, String pagerows, String rprCostAmt, String manuDt, String dispSoldDt, String currCd, String custNm, String creDt, String pEndEvntDt, String pEndCreDt, String pLocCd, String pStrCreDt, String dispPkupEndDt, String aproOfcCd, String locCd, String overDate, String eqNo, String pLocTp, String partAmt, String dispUtPrc, String pChkUsd, String dispRsnCd, String dispTrfUtPrc, String dispTpCd, String calPartAmt, String dispPkupStDt, String dispNo, String rhqCd, String pStrEvntDt, String rccCd, String dispDtlSeq, String eqKndCd, String pDispTpCd, String pDispRsnCd, String eqTpszCd, String dispVrfyTpCd, String pCustCd, String lccCd, String sccCd, String dispYdCd, String pVndrNm, String custCd, String pEqKndCd, String rqstOfcCd, String dispVrfyTpNm, String bkValAmt, String invNo, String issDt) {
		this.rprCostAmt = rprCostAmt;
		this.dispSoldDt = dispSoldDt;
		this.manuDt = manuDt;
		this.currCd = currCd;
		this.custNm = custNm;
		this.pEndEvntDt = pEndEvntDt;
		this.creDt = creDt;
		this.pLocCd = pLocCd;
		this.pEndCreDt = pEndCreDt;
		this.pStrCreDt = pStrCreDt;
		this.dispPkupEndDt = dispPkupEndDt;
		this.aproOfcCd = aproOfcCd;
		this.bkValAmt = bkValAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.overDate = overDate;
		this.eqNo = eqNo;
		this.pLocTp = pLocTp;
		this.partAmt = partAmt;
		this.dispUtPrc = dispUtPrc;
		this.pChkUsd = pChkUsd;
		this.dispRsnCd = dispRsnCd;
		this.dispTrfUtPrc = dispTrfUtPrc;
		this.dispTpCd = dispTpCd;
		this.calPartAmt = calPartAmt;
		this.rhqCd = rhqCd;
		this.dispNo = dispNo;
		this.dispPkupStDt = dispPkupStDt;
		this.pStrEvntDt = pStrEvntDt;
		this.rccCd = rccCd;
		this.eqKndCd = eqKndCd;
		this.dispDtlSeq = dispDtlSeq;
		this.pDispRsnCd = pDispRsnCd;
		this.pDispTpCd = pDispTpCd;
		this.eqTpszCd = eqTpszCd;
		this.pCustCd = pCustCd;
		this.dispVrfyTpCd = dispVrfyTpCd;
		this.lccCd = lccCd;
		this.sccCd = sccCd;
		this.pVndrNm = pVndrNm;
		this.dispYdCd = dispYdCd;
		this.custCd = custCd;
		this.pEqKndCd = pEqKndCd;
		this.rqstOfcCd = rqstOfcCd;
		this.dispVrfyTpNm = dispVrfyTpNm;
		this.invNo = invNo;
		this.issDt = issDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rpr_cost_amt", getRprCostAmt());
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());
		this.hashColumns.put("manu_dt", getManuDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("p_end_evnt_dt", getPEndEvntDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("p_loc_cd", getPLocCd());
		this.hashColumns.put("p_end_cre_dt", getPEndCreDt());
		this.hashColumns.put("p_str_cre_dt", getPStrCreDt());
		this.hashColumns.put("disp_pkup_end_dt", getDispPkupEndDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("bk_val_amt", getBkValAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("over_date", getOverDate());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("p_loc_tp", getPLocTp());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("disp_ut_prc", getDispUtPrc());
		this.hashColumns.put("p_chk_usd", getPChkUsd());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("disp_trf_ut_prc", getDispTrfUtPrc());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("cal_part_amt", getCalPartAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("disp_pkup_st_dt", getDispPkupStDt());
		this.hashColumns.put("p_str_evnt_dt", getPStrEvntDt());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("p_disp_rsn_cd", getPDispRsnCd());
		this.hashColumns.put("p_disp_tp_cd", getPDispTpCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("p_cust_cd", getPCustCd());
		this.hashColumns.put("disp_vrfy_tp_cd", getDispVrfyTpCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("p_vndr_nm", getPVndrNm());
		this.hashColumns.put("disp_yd_cd", getDispYdCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("p_eq_knd_cd", getPEqKndCd());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("disp_vrfy_tp_nm", getDispVrfyTpNm());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("iss_dt", getIssDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rpr_cost_amt", "rprCostAmt");
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("manu_dt", "manuDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("p_end_evnt_dt", "pEndEvntDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("p_loc_cd", "pLocCd");
		this.hashFields.put("p_end_cre_dt", "pEndCreDt");
		this.hashFields.put("p_str_cre_dt", "pStrCreDt");
		this.hashFields.put("disp_pkup_end_dt", "dispPkupEndDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("bk_val_amt", "bkValAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("over_date", "overDate");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("p_loc_tp", "pLocTp");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("disp_ut_prc", "dispUtPrc");
		this.hashFields.put("p_chk_usd", "pChkUsd");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("disp_trf_ut_prc", "dispTrfUtPrc");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("cal_part_amt", "calPartAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("disp_pkup_st_dt", "dispPkupStDt");
		this.hashFields.put("p_str_evnt_dt", "pStrEvntDt");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("p_disp_rsn_cd", "pDispRsnCd");
		this.hashFields.put("p_disp_tp_cd", "pDispTpCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("p_cust_cd", "pCustCd");
		this.hashFields.put("disp_vrfy_tp_cd", "dispVrfyTpCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("p_vndr_nm", "pVndrNm");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("p_eq_knd_cd", "pEqKndCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("disp_vrfy_tp_nm", "dispVrfyTpNm");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("iss_dt", "issDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rprCostAmt
	 */
	public String getRprCostAmt() {
		return this.rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @return dispSoldDt
	 */
	public String getDispSoldDt() {
		return this.dispSoldDt;
	}
	
	/**
	 * Column Info
	 * @return manuDt
	 */
	public String getManuDt() {
		return this.manuDt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return pEndEvntDt
	 */
	public String getPEndEvntDt() {
		return this.pEndEvntDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return pLocCd
	 */
	public String getPLocCd() {
		return this.pLocCd;
	}
	
	/**
	 * Column Info
	 * @return pEndCreDt
	 */
	public String getPEndCreDt() {
		return this.pEndCreDt;
	}
	
	/**
	 * Column Info
	 * @return pStrCreDt
	 */
	public String getPStrCreDt() {
		return this.pStrCreDt;
	}
	
	/**
	 * Column Info
	 * @return dispPkupEndDt
	 */
	public String getDispPkupEndDt() {
		return this.dispPkupEndDt;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkValAmt
	 */
	public String getBkValAmt() {
		return this.bkValAmt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return overDate
	 */
	public String getOverDate() {
		return this.overDate;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return pLocTp
	 */
	public String getPLocTp() {
		return this.pLocTp;
	}
	
	/**
	 * Column Info
	 * @return partAmt
	 */
	public String getPartAmt() {
		return this.partAmt;
	}
	
	/**
	 * Column Info
	 * @return dispUtPrc
	 */
	public String getDispUtPrc() {
		return this.dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @return pChkUsd
	 */
	public String getPChkUsd() {
		return this.pChkUsd;
	}
	
	/**
	 * Column Info
	 * @return dispRsnCd
	 */
	public String getDispRsnCd() {
		return this.dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @return dispTrfUtPrc
	 */
	public String getDispTrfUtPrc() {
		return this.dispTrfUtPrc;
	}
	
	/**
	 * Column Info
	 * @return dispTpCd
	 */
	public String getDispTpCd() {
		return this.dispTpCd;
	}
	
	/**
	 * Column Info
	 * @return calPartAmt
	 */
	public String getCalPartAmt() {
		return this.calPartAmt;
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
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return dispPkupStDt
	 */
	public String getDispPkupStDt() {
		return this.dispPkupStDt;
	}
	
	/**
	 * Column Info
	 * @return pStrEvntDt
	 */
	public String getPStrEvntDt() {
		return this.pStrEvntDt;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return pDispRsnCd
	 */
	public String getPDispRsnCd() {
		return this.pDispRsnCd;
	}
	
	/**
	 * Column Info
	 * @return pDispTpCd
	 */
	public String getPDispTpCd() {
		return this.pDispTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return pCustCd
	 */
	public String getPCustCd() {
		return this.pCustCd;
	}
	
	/**
	 * Column Info
	 * @return dispVrfyTpCd
	 */
	public String getDispVrfyTpCd() {
		return this.dispVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return pVndrNm
	 */
	public String getPVndrNm() {
		return this.pVndrNm;
	}
	
	/**
	 * Column Info
	 * @return dispYdCd
	 */
	public String getDispYdCd() {
		return this.dispYdCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return pEqKndCd
	 */
	public String getPEqKndCd() {
		return this.pEqKndCd;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dispVrfyTpNm
	 */
	public String getDispVrfyTpNm() {
		return this.dispVrfyTpNm;
	}
	

	/**
	 * Column Info
	 * @param rprCostAmt
	 */
	public void setRprCostAmt(String rprCostAmt) {
		this.rprCostAmt = rprCostAmt;
	}
	
	/**
	 * Column Info
	 * @param dispSoldDt
	 */
	public void setDispSoldDt(String dispSoldDt) {
		this.dispSoldDt = dispSoldDt;
	}
	
	/**
	 * Column Info
	 * @param manuDt
	 */
	public void setManuDt(String manuDt) {
		this.manuDt = manuDt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param pEndEvntDt
	 */
	public void setPEndEvntDt(String pEndEvntDt) {
		this.pEndEvntDt = pEndEvntDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param pLocCd
	 */
	public void setPLocCd(String pLocCd) {
		this.pLocCd = pLocCd;
	}
	
	/**
	 * Column Info
	 * @param pEndCreDt
	 */
	public void setPEndCreDt(String pEndCreDt) {
		this.pEndCreDt = pEndCreDt;
	}
	
	/**
	 * Column Info
	 * @param pStrCreDt
	 */
	public void setPStrCreDt(String pStrCreDt) {
		this.pStrCreDt = pStrCreDt;
	}
	
	/**
	 * Column Info
	 * @param dispPkupEndDt
	 */
	public void setDispPkupEndDt(String dispPkupEndDt) {
		this.dispPkupEndDt = dispPkupEndDt;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkValAmt
	 */
	public void setBkValAmt(String bkValAmt) {
		this.bkValAmt = bkValAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param overDate
	 */
	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param pLocTp
	 */
	public void setPLocTp(String pLocTp) {
		this.pLocTp = pLocTp;
	}
	
	/**
	 * Column Info
	 * @param partAmt
	 */
	public void setPartAmt(String partAmt) {
		this.partAmt = partAmt;
	}
	
	/**
	 * Column Info
	 * @param dispUtPrc
	 */
	public void setDispUtPrc(String dispUtPrc) {
		this.dispUtPrc = dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @param pChkUsd
	 */
	public void setPChkUsd(String pChkUsd) {
		this.pChkUsd = pChkUsd;
	}
	
	/**
	 * Column Info
	 * @param dispRsnCd
	 */
	public void setDispRsnCd(String dispRsnCd) {
		this.dispRsnCd = dispRsnCd;
	}
	
	/**
	 * Column Info
	 * @param dispTrfUtPrc
	 */
	public void setDispTrfUtPrc(String dispTrfUtPrc) {
		this.dispTrfUtPrc = dispTrfUtPrc;
	}
	
	/**
	 * Column Info
	 * @param dispTpCd
	 */
	public void setDispTpCd(String dispTpCd) {
		this.dispTpCd = dispTpCd;
	}
	
	/**
	 * Column Info
	 * @param calPartAmt
	 */
	public void setCalPartAmt(String calPartAmt) {
		this.calPartAmt = calPartAmt;
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
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param dispPkupStDt
	 */
	public void setDispPkupStDt(String dispPkupStDt) {
		this.dispPkupStDt = dispPkupStDt;
	}
	
	/**
	 * Column Info
	 * @param pStrEvntDt
	 */
	public void setPStrEvntDt(String pStrEvntDt) {
		this.pStrEvntDt = pStrEvntDt;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param pDispRsnCd
	 */
	public void setPDispRsnCd(String pDispRsnCd) {
		this.pDispRsnCd = pDispRsnCd;
	}
	
	/**
	 * Column Info
	 * @param pDispTpCd
	 */
	public void setPDispTpCd(String pDispTpCd) {
		this.pDispTpCd = pDispTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param pCustCd
	 */
	public void setPCustCd(String pCustCd) {
		this.pCustCd = pCustCd;
	}
	
	/**
	 * Column Info
	 * @param dispVrfyTpCd
	 */
	public void setDispVrfyTpCd(String dispVrfyTpCd) {
		this.dispVrfyTpCd = dispVrfyTpCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param pVndrNm
	 */
	public void setPVndrNm(String pVndrNm) {
		this.pVndrNm = pVndrNm;
	}
	
	/**
	 * Column Info
	 * @param dispYdCd
	 */
	public void setDispYdCd(String dispYdCd) {
		this.dispYdCd = dispYdCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param pEqKndCd
	 */
	public void setPEqKndCd(String pEqKndCd) {
		this.pEqKndCd = pEqKndCd;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dispVrfyTpNm
	 */
	public void setDispVrfyTpNm(String dispVrfyTpNm) {
		this.dispVrfyTpNm = dispVrfyTpNm;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return invNo;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return issDt;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
		setRprCostAmt(JSPUtil.getParameter(request, prefix + "rpr_cost_amt", ""));
		setDispSoldDt(JSPUtil.getParameter(request, prefix + "disp_sold_dt", ""));
		setManuDt(JSPUtil.getParameter(request, prefix + "manu_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPEndEvntDt(JSPUtil.getParameter(request, prefix + "p_end_evnt_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPLocCd(JSPUtil.getParameter(request, prefix + "p_loc_cd", ""));
		setPEndCreDt(JSPUtil.getParameter(request, prefix + "p_end_cre_dt", ""));
		setPStrCreDt(JSPUtil.getParameter(request, prefix + "p_str_cre_dt", ""));
		setDispPkupEndDt(JSPUtil.getParameter(request, prefix + "disp_pkup_end_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setBkValAmt(JSPUtil.getParameter(request, prefix + "bk_val_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setOverDate(JSPUtil.getParameter(request, prefix + "over_date", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setPLocTp(JSPUtil.getParameter(request, prefix + "p_loc_tp", ""));
		setPartAmt(JSPUtil.getParameter(request, prefix + "part_amt", ""));
		setDispUtPrc(JSPUtil.getParameter(request, prefix + "disp_ut_prc", ""));
		setPChkUsd(JSPUtil.getParameter(request, prefix + "p_chk_usd", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setDispTrfUtPrc(JSPUtil.getParameter(request, prefix + "disp_trf_ut_prc", ""));
		setDispTpCd(JSPUtil.getParameter(request, prefix + "disp_tp_cd", ""));
		setCalPartAmt(JSPUtil.getParameter(request, prefix + "cal_part_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setDispPkupStDt(JSPUtil.getParameter(request, prefix + "disp_pkup_st_dt", ""));
		setPStrEvntDt(JSPUtil.getParameter(request, prefix + "p_str_evnt_dt", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, prefix + "disp_dtl_seq", ""));
		setPDispRsnCd(JSPUtil.getParameter(request, prefix + "p_disp_rsn_cd", ""));
		setPDispTpCd(JSPUtil.getParameter(request, prefix + "p_disp_tp_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPCustCd(JSPUtil.getParameter(request, prefix + "p_cust_cd", ""));
		setDispVrfyTpCd(JSPUtil.getParameter(request, prefix + "disp_vrfy_tp_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setPVndrNm(JSPUtil.getParameter(request, prefix + "p_vndr_nm", ""));
		setDispYdCd(JSPUtil.getParameter(request, prefix + "disp_yd_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setPEqKndCd(JSPUtil.getParameter(request, prefix + "p_eq_knd_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setDispVrfyTpNm(JSPUtil.getParameter(request, prefix + "disp_vrfy_tp_nm", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByEqDetailVO[]
	 */
	public DisposalPFMCByEqDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByEqDetailVO[]
	 */
	public DisposalPFMCByEqDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPFMCByEqDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rprCostAmt = (JSPUtil.getParameter(request, prefix	+ "rpr_cost_amt", length));
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] manuDt = (JSPUtil.getParameter(request, prefix	+ "manu_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] pEndEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_end_evnt_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pLocCd = (JSPUtil.getParameter(request, prefix	+ "p_loc_cd", length));
			String[] pEndCreDt = (JSPUtil.getParameter(request, prefix	+ "p_end_cre_dt", length));
			String[] pStrCreDt = (JSPUtil.getParameter(request, prefix	+ "p_str_cre_dt", length));
			String[] dispPkupEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_end_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] bkValAmt = (JSPUtil.getParameter(request, prefix	+ "bk_val_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] overDate = (JSPUtil.getParameter(request, prefix	+ "over_date", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] pLocTp = (JSPUtil.getParameter(request, prefix	+ "p_loc_tp", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] dispUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_ut_prc", length));
			String[] pChkUsd = (JSPUtil.getParameter(request, prefix	+ "p_chk_usd", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] dispTrfUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_trf_ut_prc", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] calPartAmt = (JSPUtil.getParameter(request, prefix	+ "cal_part_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] dispPkupStDt = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_st_dt", length));
			String[] pStrEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_str_evnt_dt", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] pDispRsnCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_rsn_cd", length));
			String[] pDispTpCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_tp_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pCustCd = (JSPUtil.getParameter(request, prefix	+ "p_cust_cd", length));
			String[] dispVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_vrfy_tp_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] pVndrNm = (JSPUtil.getParameter(request, prefix	+ "p_vndr_nm", length));
			String[] dispYdCd = (JSPUtil.getParameter(request, prefix	+ "disp_yd_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] pEqKndCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_knd_cd", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] dispVrfyTpNm = (JSPUtil.getParameter(request, prefix	+ "disp_vrfy_tp_nm", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalPFMCByEqDetailVO();
				if (rprCostAmt[i] != null)
					model.setRprCostAmt(rprCostAmt[i]);
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (manuDt[i] != null)
					model.setManuDt(manuDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (pEndEvntDt[i] != null)
					model.setPEndEvntDt(pEndEvntDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pLocCd[i] != null)
					model.setPLocCd(pLocCd[i]);
				if (pEndCreDt[i] != null)
					model.setPEndCreDt(pEndCreDt[i]);
				if (pStrCreDt[i] != null)
					model.setPStrCreDt(pStrCreDt[i]);
				if (dispPkupEndDt[i] != null)
					model.setDispPkupEndDt(dispPkupEndDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (bkValAmt[i] != null)
					model.setBkValAmt(bkValAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (overDate[i] != null)
					model.setOverDate(overDate[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (pLocTp[i] != null)
					model.setPLocTp(pLocTp[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (dispUtPrc[i] != null)
					model.setDispUtPrc(dispUtPrc[i]);
				if (pChkUsd[i] != null)
					model.setPChkUsd(pChkUsd[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (dispTrfUtPrc[i] != null)
					model.setDispTrfUtPrc(dispTrfUtPrc[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (calPartAmt[i] != null)
					model.setCalPartAmt(calPartAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (dispPkupStDt[i] != null)
					model.setDispPkupStDt(dispPkupStDt[i]);
				if (pStrEvntDt[i] != null)
					model.setPStrEvntDt(pStrEvntDt[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (pDispRsnCd[i] != null)
					model.setPDispRsnCd(pDispRsnCd[i]);
				if (pDispTpCd[i] != null)
					model.setPDispTpCd(pDispTpCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pCustCd[i] != null)
					model.setPCustCd(pCustCd[i]);
				if (dispVrfyTpCd[i] != null)
					model.setDispVrfyTpCd(dispVrfyTpCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (pVndrNm[i] != null)
					model.setPVndrNm(pVndrNm[i]);
				if (dispYdCd[i] != null)
					model.setDispYdCd(dispYdCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (pEqKndCd[i] != null)
					model.setPEqKndCd(pEqKndCd[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (dispVrfyTpNm[i] != null)
					model.setDispVrfyTpNm(dispVrfyTpNm[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPFMCByEqDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPFMCByEqDetailVO[]
	 */
	public DisposalPFMCByEqDetailVO[] getDisposalPFMCByEqDetailVOs(){
		DisposalPFMCByEqDetailVO[] vos = (DisposalPFMCByEqDetailVO[])models.toArray(new DisposalPFMCByEqDetailVO[models.size()]);
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
		this.rprCostAmt = this.rprCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDt = this.dispSoldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuDt = this.manuDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEndEvntDt = this.pEndEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocCd = this.pLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEndCreDt = this.pEndCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStrCreDt = this.pStrCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupEndDt = this.dispPkupEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkValAmt = this.bkValAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDate = this.overDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocTp = this.pLocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtPrc = this.dispUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pChkUsd = this.pChkUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrfUtPrc = this.dispTrfUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calPartAmt = this.calPartAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupStDt = this.dispPkupStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStrEvntDt = this.pStrEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispRsnCd = this.pDispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispTpCd = this.pDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustCd = this.pCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispVrfyTpCd = this.dispVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVndrNm = this.pVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd = this.dispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqKndCd = this.pEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispVrfyTpNm = this.dispVrfyTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
