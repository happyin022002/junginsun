/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EstimateUploadVO.java
*@FileTitle : EstimateUploadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.19
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.19 장준우
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.30 김상수 [CHM-201215889-01] Repair SPP Upload 화면 로직 변경 요청
*                                      - 엑셀로 업로드 받은 Hour와 Material은 Qty가 1이상일 경우 Hour*Qty, Material*Qty로 계산해서 업로드
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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

public class EstimateUploadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstimateUploadVO> models = new ArrayList<EstimateUploadVO>();
	
	/* Column Info */
	private String eqLocCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String eqDmgDt = null;
	/* Column Info */
	private String ediErrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqDmgCd = null;
	/* Column Info */
	private String rprSzNo = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String rprOffhFlg = null;
	/* Column Info */
	private String dispRprLbrHrs = null;
	/* Column Info */
	private String volTpCd = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String complexPk = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String ediErrNm = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String dispMtrlCostAmt = null;
	/* Column Info */
	private String rprLbrRt = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String rprLbrHrs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstimateUploadVO() {}

	public EstimateUploadVO(String ibflag, String pagerows, String complexPk, String eqLocCd, String trfDivCd, String currCd, String rqstRefNo, String eqDmgDt, String eqRprCd, String ediId, String lbrCostAmt, String rprLbrRt, String eqDmgCd, String rprSzNo, String rqstEqNo, String mnrWrkAmt, String rprQty, String rprOffhFlg, String dispRprLbrHrs, String rprLbrHrs, String volTpCd, String dispMtrlCostAmt, String mtrlCostAmt, String eqCmpoCd, String ediErrCd, String ediErrNm) {
		this.eqLocCd = eqLocCd;
		this.currCd = currCd;
		this.rqstRefNo = rqstRefNo;
		this.eqDmgDt = eqDmgDt;
		this.ediErrCd = ediErrCd;
		this.pagerows = pagerows;
		this.lbrCostAmt = lbrCostAmt;
		this.ibflag = ibflag;
		this.eqDmgCd = eqDmgCd;
		this.rprSzNo = rprSzNo;
		this.rqstEqNo = rqstEqNo;
		this.mnrWrkAmt = mnrWrkAmt;
		this.rprQty = rprQty;
		this.rprOffhFlg = rprOffhFlg;
		this.dispRprLbrHrs = dispRprLbrHrs;
		this.volTpCd = volTpCd;
		this.eqCmpoCd = eqCmpoCd;
		this.complexPk = complexPk;
		this.trfDivCd = trfDivCd;
		this.ediErrNm = ediErrNm;
		this.eqRprCd = eqRprCd;
		this.ediId = ediId;
		this.dispMtrlCostAmt = dispMtrlCostAmt;
		this.rprLbrRt = rprLbrRt;
		this.mtrlCostAmt = mtrlCostAmt;
		this.rprLbrHrs = rprLbrHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("eq_dmg_dt", getEqDmgDt());
		this.hashColumns.put("edi_err_cd", getEdiErrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_dmg_cd", getEqDmgCd());
		this.hashColumns.put("rpr_sz_no", getRprSzNo());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("rpr_offh_flg", getRprOffhFlg());
		this.hashColumns.put("disp_rpr_lbr_hrs", getDispRprLbrHrs());
		this.hashColumns.put("vol_tp_cd", getVolTpCd());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("complex_pk", getComplexPk());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("edi_err_nm", getEdiErrNm());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("disp_mtrl_cost_amt", getDispMtrlCostAmt());
		this.hashColumns.put("rpr_lbr_rt", getRprLbrRt());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("eq_dmg_dt", "eqDmgDt");
		this.hashFields.put("edi_err_cd", "ediErrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_dmg_cd", "eqDmgCd");
		this.hashFields.put("rpr_sz_no", "rprSzNo");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("rpr_offh_flg", "rprOffhFlg");
		this.hashFields.put("disp_rpr_lbr_hrs", "dispRprLbrHrs");
		this.hashFields.put("vol_tp_cd", "volTpCd");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("complex_pk", "complexPk");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("edi_err_nm", "ediErrNm");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("disp_mtrl_cost_amt", "dispMtrlCostAmt");
		this.hashFields.put("rpr_lbr_rt", "rprLbrRt");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqLocCd
	 */
	public String getEqLocCd() {
		return this.eqLocCd;
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
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @return eqDmgDt
	 */
	public String getEqDmgDt() {
		return this.eqDmgDt;
	}
	
	/**
	 * Column Info
	 * @return ediErrCd
	 */
	public String getEdiErrCd() {
		return this.ediErrCd;
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
	 * @return lbrCostAmt
	 */
	public String getLbrCostAmt() {
		return this.lbrCostAmt;
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
	 * @return eqDmgCd
	 */
	public String getEqDmgCd() {
		return this.eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @return rprSzNo
	 */
	public String getRprSzNo() {
		return this.rprSzNo;
	}
	
	/**
	 * Column Info
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return mnrWrkAmt
	 */
	public String getMnrWrkAmt() {
		return this.mnrWrkAmt;
	}
	
	/**
	 * Column Info
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
	}
	
	/**
	 * Column Info
	 * @return rprOffhFlg
	 */
	public String getRprOffhFlg() {
		return this.rprOffhFlg;
	}
	
	/**
	 * Column Info
	 * @return dispRprLbrHrs
	 */
	public String getDispRprLbrHrs() {
		return this.dispRprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @return volTpCd
	 */
	public String getVolTpCd() {
		return this.volTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @return complexPk
	 */
	public String getComplexPk() {
		return this.complexPk;
	}
	
	/**
	 * Column Info
	 * @return trfDivCd
	 */
	public String getTrfDivCd() {
		return this.trfDivCd;
	}
	
	/**
	 * Column Info
	 * @return ediErrNm
	 */
	public String getEdiErrNm() {
		return this.ediErrNm;
	}
	
	/**
	 * Column Info
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return dispMtrlCostAmt
	 */
	public String getDispMtrlCostAmt() {
		return this.dispMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rprLbrRt
	 */
	public String getRprLbrRt() {
		return this.rprLbrRt;
	}
	
	/**
	 * Column Info
	 * @return mtrlCostAmt
	 */
	public String getMtrlCostAmt() {
		return this.mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rprLbrHrs
	 */
	public String getRprLbrHrs() {
		return this.rprLbrHrs;
	}
	

	/**
	 * Column Info
	 * @param eqLocCd
	 */
	public void setEqLocCd(String eqLocCd) {
		this.eqLocCd = eqLocCd;
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
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
	}
	
	/**
	 * Column Info
	 * @param eqDmgDt
	 */
	public void setEqDmgDt(String eqDmgDt) {
		this.eqDmgDt = eqDmgDt;
	}
	
	/**
	 * Column Info
	 * @param ediErrCd
	 */
	public void setEdiErrCd(String ediErrCd) {
		this.ediErrCd = ediErrCd;
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
	 * @param lbrCostAmt
	 */
	public void setLbrCostAmt(String lbrCostAmt) {
		this.lbrCostAmt = lbrCostAmt;
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
	 * @param eqDmgCd
	 */
	public void setEqDmgCd(String eqDmgCd) {
		this.eqDmgCd = eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @param rprSzNo
	 */
	public void setRprSzNo(String rprSzNo) {
		this.rprSzNo = rprSzNo;
	}
	
	/**
	 * Column Info
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param mnrWrkAmt
	 */
	public void setMnrWrkAmt(String mnrWrkAmt) {
		this.mnrWrkAmt = mnrWrkAmt;
	}
	
	/**
	 * Column Info
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
	}
	
	/**
	 * Column Info
	 * @param rprOffhFlg
	 */
	public void setRprOffhFlg(String rprOffhFlg) {
		this.rprOffhFlg = rprOffhFlg;
	}
	
	/**
	 * Column Info
	 * @param dispRprLbrHrs
	 */
	public void setDispRprLbrHrs(String dispRprLbrHrs) {
		this.dispRprLbrHrs = dispRprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @param volTpCd
	 */
	public void setVolTpCd(String volTpCd) {
		this.volTpCd = volTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * Column Info
	 * @param complexPk
	 */
	public void setComplexPk(String complexPk) {
		this.complexPk = complexPk;
	}
	
	/**
	 * Column Info
	 * @param trfDivCd
	 */
	public void setTrfDivCd(String trfDivCd) {
		this.trfDivCd = trfDivCd;
	}
	
	/**
	 * Column Info
	 * @param ediErrNm
	 */
	public void setEdiErrNm(String ediErrNm) {
		this.ediErrNm = ediErrNm;
	}
	
	/**
	 * Column Info
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param dispMtrlCostAmt
	 */
	public void setDispMtrlCostAmt(String dispMtrlCostAmt) {
		this.dispMtrlCostAmt = dispMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rprLbrRt
	 */
	public void setRprLbrRt(String rprLbrRt) {
		this.rprLbrRt = rprLbrRt;
	}
	
	/**
	 * Column Info
	 * @param mtrlCostAmt
	 */
	public void setMtrlCostAmt(String mtrlCostAmt) {
		this.mtrlCostAmt = mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rprLbrHrs
	 */
	public void setRprLbrHrs(String rprLbrHrs) {
		this.rprLbrHrs = rprLbrHrs;
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
		setEqLocCd(JSPUtil.getParameter(request, prefix + "eq_loc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setEqDmgDt(JSPUtil.getParameter(request, prefix + "eq_dmg_dt", ""));
		setEdiErrCd(JSPUtil.getParameter(request, prefix + "edi_err_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, prefix + "lbr_cost_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqDmgCd(JSPUtil.getParameter(request, prefix + "eq_dmg_cd", ""));
		setRprSzNo(JSPUtil.getParameter(request, prefix + "rpr_sz_no", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, prefix + "mnr_wrk_amt", ""));
		setRprQty(JSPUtil.getParameter(request, prefix + "rpr_qty", ""));
		setRprOffhFlg(JSPUtil.getParameter(request, prefix + "rpr_offh_flg", ""));
		setDispRprLbrHrs(JSPUtil.getParameter(request, prefix + "disp_rpr_lbr_hrs", ""));
		setVolTpCd(JSPUtil.getParameter(request, prefix + "vol_tp_cd", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
		setComplexPk(JSPUtil.getParameter(request, prefix + "complex_pk", ""));
		setTrfDivCd(JSPUtil.getParameter(request, prefix + "trf_div_cd", ""));
		setEdiErrNm(JSPUtil.getParameter(request, prefix + "edi_err_nm", ""));
		setEqRprCd(JSPUtil.getParameter(request, prefix + "eq_rpr_cd", ""));
		setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
		setDispMtrlCostAmt(JSPUtil.getParameter(request, prefix + "disp_mtrl_cost_amt", ""));
		setRprLbrRt(JSPUtil.getParameter(request, prefix + "rpr_lbr_rt", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, prefix + "mtrl_cost_amt", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, prefix + "rpr_lbr_hrs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstimateUploadVO[]
	 */
	public EstimateUploadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstimateUploadVO[]
	 */
	public EstimateUploadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstimateUploadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] eqDmgDt = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_dt", length));
			String[] ediErrCd = (JSPUtil.getParameter(request, prefix	+ "edi_err_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqDmgCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			String[] rprSzNo = (JSPUtil.getParameter(request, prefix	+ "rpr_sz_no", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] rprOffhFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_offh_flg", length));
			String[] dispRprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "disp_rpr_lbr_hrs", length));
			String[] volTpCd = (JSPUtil.getParameter(request, prefix	+ "vol_tp_cd", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] complexPk = (JSPUtil.getParameter(request, prefix	+ "complex_pk", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] ediErrNm = (JSPUtil.getParameter(request, prefix	+ "edi_err_nm", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] dispMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "disp_mtrl_cost_amt", length));
			String[] rprLbrRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_rt", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstimateUploadVO();
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (eqDmgDt[i] != null)
					model.setEqDmgDt(eqDmgDt[i]);
				if (ediErrCd[i] != null)
					model.setEdiErrCd(ediErrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqDmgCd[i] != null)
					model.setEqDmgCd(eqDmgCd[i]);
				if (rprSzNo[i] != null)
					model.setRprSzNo(rprSzNo[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (rprOffhFlg[i] != null)
					model.setRprOffhFlg(rprOffhFlg[i]);
				if (dispRprLbrHrs[i] != null)
					model.setDispRprLbrHrs(dispRprLbrHrs[i]);
				if (volTpCd[i] != null)
					model.setVolTpCd(volTpCd[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (complexPk[i] != null)
					model.setComplexPk(complexPk[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (ediErrNm[i] != null)
					model.setEdiErrNm(ediErrNm[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (dispMtrlCostAmt[i] != null)
					model.setDispMtrlCostAmt(dispMtrlCostAmt[i]);
				if (rprLbrRt[i] != null)
					model.setRprLbrRt(rprLbrRt[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstimateUploadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstimateUploadVO[]
	 */
	public EstimateUploadVO[] getEstimateUploadVOs(){
		EstimateUploadVO[] vos = (EstimateUploadVO[])models.toArray(new EstimateUploadVO[models.size()]);
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
		this.eqLocCd = this.eqLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgDt = this.eqDmgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediErrCd = this.ediErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCd = this.eqDmgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprSzNo = this.rprSzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprOffhFlg = this.rprOffhFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRprLbrHrs = this.dispRprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTpCd = this.volTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk = this.complexPk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediErrNm = this.ediErrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispMtrlCostAmt = this.dispMtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrRt = this.rprLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * EstimateUploadVO 객체정보에서 Header 정보 만을 재구성하여 반환한다.
	 * @return String
	 */
	public String getEstimateTmpHeaderPK() {
		StringBuilder pkString = new StringBuilder();
		pkString.append(this.rqstEqNo);
		pkString.append(this.rqstRefNo);
		pkString.append(this.eqDmgDt);
		pkString.append(this.currCd);
		pkString.append(this.ediId);
		pkString.append(this.rprOffhFlg);
		return pkString.toString();
	}
}
