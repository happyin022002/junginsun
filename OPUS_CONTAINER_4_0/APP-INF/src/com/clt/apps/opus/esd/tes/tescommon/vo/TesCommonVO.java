/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesCommonVO.java
*@FileTitle : TesCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.tescommon.vo;

import java.lang.reflect.Field;
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

public class TesCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesCommonVO> models = new ArrayList<TesCommonVO>();
	
	/* Column Info */
	private String errInvNo = null;
	/* Column Info */
	private String agmtFtrInvTpCd = null;
	/* Column Info */
	private String noYdCd = null;
	/* Column Info */
	private String noOfcCd = null;
	/* Column Info */
	private String tmlInvTpCd = null;
	/* Column Info */
	private String calcCostGrpCd = null;
	/* Column Info */
	private String atbDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String maxWrkDt = null;
	/* Column Info */
	private String text = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String minWrkDt = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String actTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesCommonVO() {}

	public TesCommonVO(String ibflag, String pagerows, String invNo, String ofcCd, String calcCostGrpCd, String vndrSeq, String tmlInvTpCd, String ydCd, String errInvNo, String code, String text, String flag, String atbDt, String agmtFtrInvTpCd, String fmPrdDt, String toPrdDt, String minWrkDt, String vvd, String costOfcCd, String fromDate, String toDate, String maxWrkDt, String eqNo, String actTp, String noOfcCd, String noYdCd, String creOfcCd, String invOfcCd, String locCd, String cntrNo) {
		this.errInvNo = errInvNo;
		this.agmtFtrInvTpCd = agmtFtrInvTpCd;
		this.noYdCd = noYdCd;
		this.noOfcCd = noOfcCd;
		this.tmlInvTpCd = tmlInvTpCd;
		this.calcCostGrpCd = calcCostGrpCd;
		this.atbDt = atbDt;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.creOfcCd = creOfcCd;
		this.fmPrdDt = fmPrdDt;
		this.invOfcCd = invOfcCd;
		this.maxWrkDt = maxWrkDt;
		this.text = text;
		this.costOfcCd = costOfcCd;
		this.toPrdDt = toPrdDt;
		this.code = code;
		this.toDate = toDate;
		this.invNo = invNo;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.flag = flag;
		this.minWrkDt = minWrkDt;
		this.fromDate = fromDate;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.actTp = actTp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("err_inv_no", getErrInvNo());
		this.hashColumns.put("agmt_ftr_inv_tp_cd", getAgmtFtrInvTpCd());
		this.hashColumns.put("no_yd_cd", getNoYdCd());
		this.hashColumns.put("no_ofc_cd", getNoOfcCd());
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());
		this.hashColumns.put("atb_dt", getAtbDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("max_wrk_dt", getMaxWrkDt());
		this.hashColumns.put("text", getText());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("min_wrk_dt", getMinWrkDt());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("act_tp", getActTp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("err_inv_no", "errInvNo");
		this.hashFields.put("agmt_ftr_inv_tp_cd", "agmtFtrInvTpCd");
		this.hashFields.put("no_yd_cd", "noYdCd");
		this.hashFields.put("no_ofc_cd", "noOfcCd");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("max_wrk_dt", "maxWrkDt");
		this.hashFields.put("text", "text");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("code", "code");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("min_wrk_dt", "minWrkDt");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("act_tp", "actTp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return errInvNo
	 */
	public String getErrInvNo() {
		return this.errInvNo;
	}
	
	/**
	 * Column Info
	 * @return agmtFtrInvTpCd
	 */
	public String getAgmtFtrInvTpCd() {
		return this.agmtFtrInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return noYdCd
	 */
	public String getNoYdCd() {
		return this.noYdCd;
	}
	
	/**
	 * Column Info
	 * @return noOfcCd
	 */
	public String getNoOfcCd() {
		return this.noOfcCd;
	}
	
	/**
	 * Column Info
	 * @return tmlInvTpCd
	 */
	public String getTmlInvTpCd() {
		return this.tmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @return calcCostGrpCd
	 */
	public String getCalcCostGrpCd() {
		return this.calcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return atbDt
	 */
	public String getAtbDt() {
		return this.atbDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return maxWrkDt
	 */
	public String getMaxWrkDt() {
		return this.maxWrkDt;
	}
	
	/**
	 * Column Info
	 * @return text
	 */
	public String getText() {
		return this.text;
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
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return minWrkDt
	 */
	public String getMinWrkDt() {
		return this.minWrkDt;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return actTp
	 */
	public String getActTp() {
		return this.actTp;
	}
	

	/**
	 * Column Info
	 * @param errInvNo
	 */
	public void setErrInvNo(String errInvNo) {
		this.errInvNo = errInvNo;
	}
	
	/**
	 * Column Info
	 * @param agmtFtrInvTpCd
	 */
	public void setAgmtFtrInvTpCd(String agmtFtrInvTpCd) {
		this.agmtFtrInvTpCd = agmtFtrInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param noYdCd
	 */
	public void setNoYdCd(String noYdCd) {
		this.noYdCd = noYdCd;
	}
	
	/**
	 * Column Info
	 * @param noOfcCd
	 */
	public void setNoOfcCd(String noOfcCd) {
		this.noOfcCd = noOfcCd;
	}
	
	/**
	 * Column Info
	 * @param tmlInvTpCd
	 */
	public void setTmlInvTpCd(String tmlInvTpCd) {
		this.tmlInvTpCd = tmlInvTpCd;
	}
	
	/**
	 * Column Info
	 * @param calcCostGrpCd
	 */
	public void setCalcCostGrpCd(String calcCostGrpCd) {
		this.calcCostGrpCd = calcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param atbDt
	 */
	public void setAtbDt(String atbDt) {
		this.atbDt = atbDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param maxWrkDt
	 */
	public void setMaxWrkDt(String maxWrkDt) {
		this.maxWrkDt = maxWrkDt;
	}
	
	/**
	 * Column Info
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
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
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param minWrkDt
	 */
	public void setMinWrkDt(String minWrkDt) {
		this.minWrkDt = minWrkDt;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param actTp
	 */
	public void setActTp(String actTp) {
		this.actTp = actTp;
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
		setErrInvNo(JSPUtil.getParameter(request, prefix + "err_inv_no", ""));
		setAgmtFtrInvTpCd(JSPUtil.getParameter(request, prefix + "agmt_ftr_inv_tp_cd", ""));
		setNoYdCd(JSPUtil.getParameter(request, prefix + "no_yd_cd", ""));
		setNoOfcCd(JSPUtil.getParameter(request, prefix + "no_ofc_cd", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request, prefix + "tml_inv_tp_cd", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "calc_cost_grp_cd", ""));
		setAtbDt(JSPUtil.getParameter(request, prefix + "atb_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setMaxWrkDt(JSPUtil.getParameter(request, prefix + "max_wrk_dt", ""));
		setText(JSPUtil.getParameter(request, prefix + "text", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFlag(JSPUtil.getParameter(request, prefix + "flag", ""));
		setMinWrkDt(JSPUtil.getParameter(request, prefix + "min_wrk_dt", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setActTp(JSPUtil.getParameter(request, prefix + "act_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesCommonVO[]
	 */
	public TesCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesCommonVO[]
	 */
	public TesCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] errInvNo = (JSPUtil.getParameter(request, prefix	+ "err_inv_no", length));
			String[] agmtFtrInvTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ftr_inv_tp_cd", length));
			String[] noYdCd = (JSPUtil.getParameter(request, prefix	+ "no_yd_cd", length));
			String[] noOfcCd = (JSPUtil.getParameter(request, prefix	+ "no_ofc_cd", length));
			String[] tmlInvTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_tp_cd", length));
			String[] calcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "calc_cost_grp_cd", length));
			String[] atbDt = (JSPUtil.getParameter(request, prefix	+ "atb_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] maxWrkDt = (JSPUtil.getParameter(request, prefix	+ "max_wrk_dt", length));
			String[] text = (JSPUtil.getParameter(request, prefix	+ "text", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] minWrkDt = (JSPUtil.getParameter(request, prefix	+ "min_wrk_dt", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] actTp = (JSPUtil.getParameter(request, prefix	+ "act_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesCommonVO();
				if (errInvNo[i] != null)
					model.setErrInvNo(errInvNo[i]);
				if (agmtFtrInvTpCd[i] != null)
					model.setAgmtFtrInvTpCd(agmtFtrInvTpCd[i]);
				if (noYdCd[i] != null)
					model.setNoYdCd(noYdCd[i]);
				if (noOfcCd[i] != null)
					model.setNoOfcCd(noOfcCd[i]);
				if (tmlInvTpCd[i] != null)
					model.setTmlInvTpCd(tmlInvTpCd[i]);
				if (calcCostGrpCd[i] != null)
					model.setCalcCostGrpCd(calcCostGrpCd[i]);
				if (atbDt[i] != null)
					model.setAtbDt(atbDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (maxWrkDt[i] != null)
					model.setMaxWrkDt(maxWrkDt[i]);
				if (text[i] != null)
					model.setText(text[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (minWrkDt[i] != null)
					model.setMinWrkDt(minWrkDt[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (actTp[i] != null)
					model.setActTp(actTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesCommonVO[]
	 */
	public TesCommonVO[] getTesCommonVOs(){
		TesCommonVO[] vos = (TesCommonVO[])models.toArray(new TesCommonVO[models.size()]);
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
		this.errInvNo = this.errInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFtrInvTpCd = this.agmtFtrInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noYdCd = this.noYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfcCd = this.noOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd = this.tmlInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd = this.calcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt = this.atbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxWrkDt = this.maxWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.text = this.text .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minWrkDt = this.minWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTp = this.actTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
