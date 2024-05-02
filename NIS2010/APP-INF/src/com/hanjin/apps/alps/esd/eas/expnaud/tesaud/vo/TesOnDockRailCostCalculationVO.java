/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesOnDockRailCostCalculationVO.java
*@FileTitle : TesOnDockRailCostCalculationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo;

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

public class TesOnDockRailCostCalculationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesOnDockRailCostCalculationVO> models = new ArrayList<TesOnDockRailCostCalculationVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String rowCount = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String volTrUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String manualCheck = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String calcVolQty = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String rvisVolQty = null;
	/* Column Info */
	private String ctrtRt = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String invDateType = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String dcgoIndCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tmlInvStsCd = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String tmlWrkDyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesOnDockRailCostCalculationVO() {}

	public TesOnDockRailCostCalculationVO(String ibflag, String pagerows, String pageNo, String rowCount, String currCd, String vndrLglEngNm, String calcTpCd, String volTrUtCd, String cntrTpszCd, String invAmt, String manualCheck, String fmPrdDt, String invOfcCd, String calcVolQty, String invXchRt, String rhq, String n3ptyFlg, String costOfcCd, String rvisVolQty, String ctrtRt, String calcRmk, String invDateType, String toPrdDt, String dcgoIndCd, String invNo, String ydCd, String tmlInvStsCd, String vndrSeq, String lgsCostCd, String tmlWrkDyCd, String creUsrNm) {
		this.currCd = currCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.rowCount = rowCount;
		this.pagerows = pagerows;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.volTrUtCd = volTrUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.invAmt = invAmt;
		this.manualCheck = manualCheck;
		this.fmPrdDt = fmPrdDt;
		this.invOfcCd = invOfcCd;
		this.calcVolQty = calcVolQty;
		this.invXchRt = invXchRt;
		this.rhq = rhq;
		this.n3ptyFlg = n3ptyFlg;
		this.costOfcCd = costOfcCd;
		this.rvisVolQty = rvisVolQty;
		this.ctrtRt = ctrtRt;
		this.calcRmk = calcRmk;
		this.invDateType = invDateType;
		this.toPrdDt = toPrdDt;
		this.creUsrNm = creUsrNm;
		this.dcgoIndCd = dcgoIndCd;
		this.invNo = invNo;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.tmlInvStsCd = tmlInvStsCd;
		this.pageNo = pageNo;
		this.lgsCostCd = lgsCostCd;
		this.tmlWrkDyCd = tmlWrkDyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("manual_check", getManualCheck());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("calc_vol_qty", getCalcVolQty());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("rvis_vol_qty", getRvisVolQty());
		this.hashColumns.put("ctrt_rt", getCtrtRt());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("inv_date_type", getInvDateType());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("dcgo_ind_cd", getDcgoIndCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tml_inv_sts_cd", getTmlInvStsCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("tml_wrk_dy_cd", getTmlWrkDyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("manual_check", "manualCheck");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("calc_vol_qty", "calcVolQty");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("rvis_vol_qty", "rvisVolQty");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("inv_date_type", "invDateType");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("dcgo_ind_cd", "dcgoIndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tml_inv_sts_cd", "tmlInvStsCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("tml_wrk_dy_cd", "tmlWrkDyCd");
		return this.hashFields;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
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
	 * @return calcTpCd
	 */
	public String getCalcTpCd() {
		return this.calcTpCd;
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
	 * @return volTrUtCd
	 */
	public String getVolTrUtCd() {
		return this.volTrUtCd;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return manualCheck
	 */
	public String getManualCheck() {
		return this.manualCheck;
	}
	
	/**
	 * Column Info
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return calcVolQty
	 */
	public String getCalcVolQty() {
		return this.calcVolQty;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rvisVolQty
	 */
	public String getRvisVolQty() {
		return this.rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtRt
	 */
	public String getCtrtRt() {
		return this.ctrtRt;
	}
	
	/**
	 * Column Info
	 * @return calcRmk
	 */
	public String getCalcRmk() {
		return this.calcRmk;
	}
	
	/**
	 * Column Info
	 * @return invDateType
	 */
	public String getInvDateType() {
		return this.invDateType;
	}
	
	/**
	 * Column Info
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return dcgoIndCd
	 */
	public String getDcgoIndCd() {
		return this.dcgoIndCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return tmlInvStsCd
	 */
	public String getTmlInvStsCd() {
		return this.tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return tmlWrkDyCd
	 */
	public String getTmlWrkDyCd() {
		return this.tmlWrkDyCd;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
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
	 * @param calcTpCd
	 */
	public void setCalcTpCd(String calcTpCd) {
		this.calcTpCd = calcTpCd;
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
	 * @param volTrUtCd
	 */
	public void setVolTrUtCd(String volTrUtCd) {
		this.volTrUtCd = volTrUtCd;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param manualCheck
	 */
	public void setManualCheck(String manualCheck) {
		this.manualCheck = manualCheck;
	}
	
	/**
	 * Column Info
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param calcVolQty
	 */
	public void setCalcVolQty(String calcVolQty) {
		this.calcVolQty = calcVolQty;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rvisVolQty
	 */
	public void setRvisVolQty(String rvisVolQty) {
		this.rvisVolQty = rvisVolQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtRt
	 */
	public void setCtrtRt(String ctrtRt) {
		this.ctrtRt = ctrtRt;
	}
	
	/**
	 * Column Info
	 * @param calcRmk
	 */
	public void setCalcRmk(String calcRmk) {
		this.calcRmk = calcRmk;
	}
	
	/**
	 * Column Info
	 * @param invDateType
	 */
	public void setInvDateType(String invDateType) {
		this.invDateType = invDateType;
	}
	
	/**
	 * Column Info
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param dcgoIndCd
	 */
	public void setDcgoIndCd(String dcgoIndCd) {
		this.dcgoIndCd = dcgoIndCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param tmlInvStsCd
	 */
	public void setTmlInvStsCd(String tmlInvStsCd) {
		this.tmlInvStsCd = tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param tmlWrkDyCd
	 */
	public void setTmlWrkDyCd(String tmlWrkDyCd) {
		this.tmlWrkDyCd = tmlWrkDyCd;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVolTrUtCd(JSPUtil.getParameter(request, prefix + "vol_tr_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setManualCheck(JSPUtil.getParameter(request, prefix + "manual_check", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setCalcVolQty(JSPUtil.getParameter(request, prefix + "calc_vol_qty", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setRvisVolQty(JSPUtil.getParameter(request, prefix + "rvis_vol_qty", ""));
		setCtrtRt(JSPUtil.getParameter(request, prefix + "ctrt_rt", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setInvDateType(JSPUtil.getParameter(request, prefix + "inv_date_type", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setDcgoIndCd(JSPUtil.getParameter(request, prefix + "dcgo_ind_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTmlInvStsCd(JSPUtil.getParameter(request, prefix + "tml_inv_sts_cd", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setTmlWrkDyCd(JSPUtil.getParameter(request, prefix + "tml_wrk_dy_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesOnDockRailCostCalculationVO[]
	 */
	public TesOnDockRailCostCalculationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesOnDockRailCostCalculationVO[]
	 */
	public TesOnDockRailCostCalculationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesOnDockRailCostCalculationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] volTrUtCd = (JSPUtil.getParameter(request, prefix	+ "vol_tr_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] manualCheck = (JSPUtil.getParameter(request, prefix	+ "manual_check", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] calcVolQty = (JSPUtil.getParameter(request, prefix	+ "calc_vol_qty", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] rvisVolQty = (JSPUtil.getParameter(request, prefix	+ "rvis_vol_qty", length));
			String[] ctrtRt = (JSPUtil.getParameter(request, prefix	+ "ctrt_rt", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] invDateType = (JSPUtil.getParameter(request, prefix	+ "inv_date_type", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] dcgoIndCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_ind_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tmlInvStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_sts_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] tmlWrkDyCd = (JSPUtil.getParameter(request, prefix	+ "tml_wrk_dy_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesOnDockRailCostCalculationVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (volTrUtCd[i] != null)
					model.setVolTrUtCd(volTrUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (manualCheck[i] != null)
					model.setManualCheck(manualCheck[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (calcVolQty[i] != null)
					model.setCalcVolQty(calcVolQty[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (rvisVolQty[i] != null)
					model.setRvisVolQty(rvisVolQty[i]);
				if (ctrtRt[i] != null)
					model.setCtrtRt(ctrtRt[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (invDateType[i] != null)
					model.setInvDateType(invDateType[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (dcgoIndCd[i] != null)
					model.setDcgoIndCd(dcgoIndCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tmlInvStsCd[i] != null)
					model.setTmlInvStsCd(tmlInvStsCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (tmlWrkDyCd[i] != null)
					model.setTmlWrkDyCd(tmlWrkDyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesOnDockRailCostCalculationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesOnDockRailCostCalculationVO[]
	 */
	public TesOnDockRailCostCalculationVO[] getTesOnDockRailCostCalculationVOs(){
		TesOnDockRailCostCalculationVO[] vos = (TesOnDockRailCostCalculationVO[])models.toArray(new TesOnDockRailCostCalculationVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd = this.volTrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manualCheck = this.manualCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVolQty = this.calcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVolQty = this.rvisVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt = this.ctrtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateType = this.invDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoIndCd = this.dcgoIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvStsCd = this.tmlInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlWrkDyCd = this.tmlWrkDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
