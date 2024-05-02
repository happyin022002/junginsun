/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DisposalResultEquipmentVO.java
*@FileTitle : DisposalResultEquipmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.23 장준우
* 1.0 Creation
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
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalResultEquipmentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<DisposalResultEquipmentVO> models = new ArrayList<DisposalResultEquipmentVO>();

	/* Column Info */
	private String rprCostAmt = null;
	/* Column Info */
	private String dispSoldDt = null;
	/* Column Info */
	private String manuDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String pEqTpszCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String pEndEvntDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String pOfcCd = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String dispRsnCd = null;
	/* Column Info */
	private String pRhqCd = null;
	/* Column Info */
	private String dispTrfUtPrc = null;
	/* Column Info */
	private String dispTpCd = null;
	/* Column Info */
	private String calPartAmt = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String pStrEvntDt = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String eqKndCd = null;
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
	private String dispYdCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String pEqKndCd = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String pCurrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public DisposalResultEquipmentVO() {}

	public DisposalResultEquipmentVO(String ibflag, String pagerows, String pCurrCd, String rhqCd, String rqstOfcCd, String aproOfcCd, String eqKndCd, String eqNo, String eqTpszCd, String manuDt, String dispTpCd, String dispNo, String dispDtlSeq, String dispSoldDt, String custCd, String custNm, String rccCd, String lccCd, String sccCd, String locCd, String dispYdCd, String dispRsnCd, String currCd, String partAmt, String calPartAmt, String dispTrfUtPrc, String dispVrfyTpCd, String rprCostAmt, String pStrEvntDt, String pEndEvntDt, String pDispTpCd, String pEqKndCd, String pDispRsnCd, String pRhqCd, String pOfcCd, String pCustCd, String pEqTpszCd) {
		this.rprCostAmt = rprCostAmt;
		this.dispSoldDt = dispSoldDt;
		this.manuDt = manuDt;
		this.currCd = currCd;
		this.pEqTpszCd = pEqTpszCd;
		this.custNm = custNm;
		this.pEndEvntDt = pEndEvntDt;
		this.aproOfcCd = aproOfcCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.eqNo = eqNo;
		this.pOfcCd = pOfcCd;
		this.partAmt = partAmt;
		this.dispRsnCd = dispRsnCd;
		this.pRhqCd = pRhqCd;
		this.dispTrfUtPrc = dispTrfUtPrc;
		this.dispTpCd = dispTpCd;
		this.calPartAmt = calPartAmt;
		this.dispNo = dispNo;
		this.rhqCd = rhqCd;
		this.pStrEvntDt = pStrEvntDt;
		this.rccCd = rccCd;
		this.dispDtlSeq = dispDtlSeq;
		this.eqKndCd = eqKndCd;
		this.pDispRsnCd = pDispRsnCd;
		this.pDispTpCd = pDispTpCd;
		this.eqTpszCd = eqTpszCd;
		this.pCustCd = pCustCd;
		this.dispVrfyTpCd = dispVrfyTpCd;
		this.lccCd = lccCd;
		this.sccCd = sccCd;
		this.dispYdCd = dispYdCd;
		this.custCd = custCd;
		this.pEqKndCd = pEqKndCd;
		this.rqstOfcCd = rqstOfcCd;
		this.pCurrCd = pCurrCd;
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
		this.hashColumns.put("p_eq_tpsz_cd", getPEqTpszCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("p_end_evnt_dt", getPEndEvntDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("p_ofc_cd", getPOfcCd());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());
		this.hashColumns.put("p_rhq_cd", getPRhqCd());
		this.hashColumns.put("disp_trf_ut_prc", getDispTrfUtPrc());
		this.hashColumns.put("disp_tp_cd", getDispTpCd());
		this.hashColumns.put("cal_part_amt", getCalPartAmt());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("p_str_evnt_dt", getPStrEvntDt());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("p_disp_rsn_cd", getPDispRsnCd());
		this.hashColumns.put("p_disp_tp_cd", getPDispTpCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("p_cust_cd", getPCustCd());
		this.hashColumns.put("disp_vrfy_tp_cd", getDispVrfyTpCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("disp_yd_cd", getDispYdCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("p_eq_knd_cd", getPEqKndCd());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("p_curr_cd", getPCurrCd());
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
		this.hashFields.put("p_eq_tpsz_cd", "pEqTpszCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("p_end_evnt_dt", "pEndEvntDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("p_ofc_cd", "pOfcCd");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("p_rhq_cd", "pRhqCd");
		this.hashFields.put("disp_trf_ut_prc", "dispTrfUtPrc");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("cal_part_amt", "calPartAmt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("p_str_evnt_dt", "pStrEvntDt");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("p_disp_rsn_cd", "pDispRsnCd");
		this.hashFields.put("p_disp_tp_cd", "pDispTpCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("p_cust_cd", "pCustCd");
		this.hashFields.put("disp_vrfy_tp_cd", "dispVrfyTpCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("p_eq_knd_cd", "pEqKndCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("p_curr_cd", "pCurrCd");
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
	 * @return pEqTpszCd
	 */
	public String getPEqTpszCd() {
		return this.pEqTpszCd;
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
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}

	/**
	 * Column Info
	 * @return pOfcCd
	 */
	public String getPOfcCd() {
		return this.pOfcCd;
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
	 * @return dispRsnCd
	 */
	public String getDispRsnCd() {
		return this.dispRsnCd;
	}

	/**
	 * Column Info
	 * @return pRhqCd
	 */
	public String getPRhqCd() {
		return this.pRhqCd;
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
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
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
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
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
	 * @param pEqTpszCd
	 */
	public void setPEqTpszCd(String pEqTpszCd) {
		this.pEqTpszCd = pEqTpszCd;
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
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}

	/**
	 * Column Info
	 * @param pOfcCd
	 */
	public void setPOfcCd(String pOfcCd) {
		this.pOfcCd = pOfcCd;
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
	 * @param dispRsnCd
	 */
	public void setDispRsnCd(String dispRsnCd) {
		this.dispRsnCd = dispRsnCd;
	}

	/**
	 * Column Info
	 * @param pRhqCd
	 */
	public void setPRhqCd(String pRhqCd) {
		this.pRhqCd = pRhqCd;
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
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
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
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
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
	 * @return the pCurrCd
	 */
	public String getPCurrCd() {
		return pCurrCd;
	}

	/**
	 * @param currCd the pCurrCd to set
	 */
	public void setPCurrCd(String currCd) {
		pCurrCd = currCd;
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
		setPEqTpszCd(JSPUtil.getParameter(request, prefix + "p_eq_tpsz_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPEndEvntDt(JSPUtil.getParameter(request, prefix + "p_end_evnt_dt", "").replaceAll("-", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setPOfcCd(JSPUtil.getParameter(request, prefix + "p_ofc_cd", ""));
		setPartAmt(JSPUtil.getParameter(request, prefix + "part_amt", ""));
		setDispRsnCd(JSPUtil.getParameter(request, prefix + "disp_rsn_cd", ""));
		setPRhqCd(JSPUtil.getParameter(request, prefix + "p_rhq_cd", ""));
		setDispTrfUtPrc(JSPUtil.getParameter(request, prefix + "disp_trf_ut_prc", ""));
		setDispTpCd(JSPUtil.getParameter(request, prefix + "disp_tp_cd", ""));
		setCalPartAmt(JSPUtil.getParameter(request, prefix + "cal_part_amt", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setPStrEvntDt(JSPUtil.getParameter(request, prefix + "p_str_evnt_dt", "").replaceAll("-", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, prefix + "disp_dtl_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setPDispRsnCd(JSPUtil.getParameter(request, prefix + "p_disp_rsn_cd", ""));
		setPDispTpCd(JSPUtil.getParameter(request, prefix + "p_disp_tp_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPCustCd(JSPUtil.getParameter(request, prefix + "p_cust_cd", ""));
		setDispVrfyTpCd(JSPUtil.getParameter(request, prefix + "disp_vrfy_tp_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setDispYdCd(JSPUtil.getParameter(request, prefix + "disp_yd_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setPEqKndCd(JSPUtil.getParameter(request, prefix + "p_eq_knd_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setPCurrCd(JSPUtil.getParameter(request, prefix + "p_curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalResultEquipmentVO[]
	 */
	public DisposalResultEquipmentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DisposalResultEquipmentVO[]
	 */
	public DisposalResultEquipmentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalResultEquipmentVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rprCostAmt = (JSPUtil.getParameter(request, prefix	+ "rpr_cost_amt", length));
			String[] dispSoldDt = (JSPUtil.getParameter(request, prefix	+ "disp_sold_dt", length));
			String[] manuDt = (JSPUtil.getParameter(request, prefix	+ "manu_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] pEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_tpsz_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] pEndEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_end_evnt_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] pOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_ofc_cd", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] dispRsnCd = (JSPUtil.getParameter(request, prefix	+ "disp_rsn_cd", length));
			String[] pRhqCd = (JSPUtil.getParameter(request, prefix	+ "p_rhq_cd", length));
			String[] dispTrfUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_trf_ut_prc", length));
			String[] dispTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_tp_cd", length));
			String[] calPartAmt = (JSPUtil.getParameter(request, prefix	+ "cal_part_amt", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] pStrEvntDt = (JSPUtil.getParameter(request, prefix	+ "p_str_evnt_dt", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pDispRsnCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_rsn_cd", length));
			String[] pDispTpCd = (JSPUtil.getParameter(request, prefix	+ "p_disp_tp_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pCustCd = (JSPUtil.getParameter(request, prefix	+ "p_cust_cd", length));
			String[] dispVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_vrfy_tp_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] dispYdCd = (JSPUtil.getParameter(request, prefix	+ "disp_yd_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] pEqKndCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_knd_cd", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] pCurrCd = (JSPUtil.getParameter(request, prefix	+ "p_curr_cd", length));

			for (int i = 0; i < length; i++) {
				model = new DisposalResultEquipmentVO();
				if (rprCostAmt[i] != null)
					model.setRprCostAmt(rprCostAmt[i]);
				if (dispSoldDt[i] != null)
					model.setDispSoldDt(dispSoldDt[i]);
				if (manuDt[i] != null)
					model.setManuDt(manuDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (pEqTpszCd[i] != null)
					model.setPEqTpszCd(pEqTpszCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (pEndEvntDt[i] != null)
					model.setPEndEvntDt(pEndEvntDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (pOfcCd[i] != null)
					model.setPOfcCd(pOfcCd[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (dispRsnCd[i] != null)
					model.setDispRsnCd(dispRsnCd[i]);
				if (pRhqCd[i] != null)
					model.setPRhqCd(pRhqCd[i]);
				if (dispTrfUtPrc[i] != null)
					model.setDispTrfUtPrc(dispTrfUtPrc[i]);
				if (dispTpCd[i] != null)
					model.setDispTpCd(dispTpCd[i]);
				if (calPartAmt[i] != null)
					model.setCalPartAmt(calPartAmt[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (pStrEvntDt[i] != null)
					model.setPStrEvntDt(pStrEvntDt[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
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
				if (dispYdCd[i] != null)
					model.setDispYdCd(dispYdCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (pEqKndCd[i] != null)
					model.setPEqKndCd(pEqKndCd[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (pCurrCd[i] != null)
					model.setPCurrCd(pCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalResultEquipmentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalResultEquipmentVO[]
	 */
	public DisposalResultEquipmentVO[] getDisposalResultEquipmentVOs(){
		DisposalResultEquipmentVO[] vos = (DisposalResultEquipmentVO[])models.toArray(new DisposalResultEquipmentVO[models.size()]);
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
		this.pEqTpszCd = this.pEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEndEvntDt = this.pEndEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOfcCd = this.pOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd = this.dispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRhqCd = this.pRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrfUtPrc = this.dispTrfUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd = this.dispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calPartAmt = this.calPartAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStrEvntDt = this.pStrEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispRsnCd = this.pDispRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispTpCd = this.pDispTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustCd = this.pCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispVrfyTpCd = this.dispVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd = this.dispYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqKndCd = this.pEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCurrCd = this.pCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
