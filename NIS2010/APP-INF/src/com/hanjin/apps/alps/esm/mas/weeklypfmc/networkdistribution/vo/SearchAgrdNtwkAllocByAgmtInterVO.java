/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchAgrdNtwkAllocByAgmtInterVO.java
*@FileTitle : SearchAgrdNtwkAllocByAgmtInterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.26 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAgrdNtwkAllocByAgmtInterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgrdNtwkAllocByAgmtInterVO> models = new ArrayList<SearchAgrdNtwkAllocByAgmtInterVO>();
	
	/* Column Info */
	private String tsExpnAmt = null;
	/* Column Info */
	private String fmIocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmSmlSlsAmt = null;
	/* Column Info */
	private String fmSkdVoyNo = null;
	/* Column Info */
	private String fmVvd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fmCostWk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fmCostYrmon = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fmTsUcAmt = null;
	/* Column Info */
	private String toRlaneCd = null;
	/* Column Info */
	private String toCostWk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmRlaneCd = null;
	/* Column Info */
	private String fmVslCd = null;
	/* Column Info */
	private String fmDirCd = null;
	/* Column Info */
	private String tsQty = null;
	/* Column Info */
	private String fmTrdCd = null;
	/* Column Info */
	private String loclTsStsCd = null;
	/* Column Info */
	private String toSkdVoyNo = null;
	/* Column Info */
	private String toCostYrmon = null;
	/* Column Info */
	private String toIocCd = null;
	/* Column Info */
	private String toVslCd = null;
	/* Column Info */
	private String toTrdCd = null;
	/* Column Info */
	private String tsQtyRto = null;
	/* Column Info */
	private String toDirCd = null;
	/* Column Info */
	private String toVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAgrdNtwkAllocByAgmtInterVO() {}

	public SearchAgrdNtwkAllocByAgmtInterVO(String ibflag, String pagerows, String fmCostYrmon, String fmCostWk, String fmTrdCd, String fmRlaneCd, String fmIocCd, String fmVslCd, String fmSkdVoyNo, String fmDirCd, String fmVvd, String fmTsUcAmt, String fmSmlSlsAmt, String toCostYrmon, String toCostWk, String toTrdCd, String toRlaneCd, String toIocCd, String toVslCd, String toSkdVoyNo, String toDirCd, String toVvd, String loclTsStsCd, String tsQty, String tsQtyRto, String tsExpnAmt, String creUsrId, String updUsrId, String costYrmon) {
		this.tsExpnAmt = tsExpnAmt;
		this.fmIocCd = fmIocCd;
		this.ibflag = ibflag;
		this.fmSmlSlsAmt = fmSmlSlsAmt;
		this.fmSkdVoyNo = fmSkdVoyNo;
		this.fmVvd = fmVvd;
		this.updUsrId = updUsrId;
		this.fmCostWk = fmCostWk;
		this.creUsrId = creUsrId;
		this.fmCostYrmon = fmCostYrmon;
		this.costYrmon = costYrmon;
		this.fmTsUcAmt = fmTsUcAmt;
		this.toRlaneCd = toRlaneCd;
		this.toCostWk = toCostWk;
		this.pagerows = pagerows;
		this.fmRlaneCd = fmRlaneCd;
		this.fmVslCd = fmVslCd;
		this.fmDirCd = fmDirCd;
		this.tsQty = tsQty;
		this.fmTrdCd = fmTrdCd;
		this.loclTsStsCd = loclTsStsCd;
		this.toSkdVoyNo = toSkdVoyNo;
		this.toCostYrmon = toCostYrmon;
		this.toIocCd = toIocCd;
		this.toVslCd = toVslCd;
		this.toTrdCd = toTrdCd;
		this.tsQtyRto = tsQtyRto;
		this.toDirCd = toDirCd;
		this.toVvd = toVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ts_expn_amt", getTsExpnAmt());
		this.hashColumns.put("fm_ioc_cd", getFmIocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_sml_sls_amt", getFmSmlSlsAmt());
		this.hashColumns.put("fm_skd_voy_no", getFmSkdVoyNo());
		this.hashColumns.put("fm_vvd", getFmVvd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fm_cost_wk", getFmCostWk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fm_cost_yrmon", getFmCostYrmon());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("fm_ts_uc_amt", getFmTsUcAmt());
		this.hashColumns.put("to_rlane_cd", getToRlaneCd());
		this.hashColumns.put("to_cost_wk", getToCostWk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_rlane_cd", getFmRlaneCd());
		this.hashColumns.put("fm_vsl_cd", getFmVslCd());
		this.hashColumns.put("fm_dir_cd", getFmDirCd());
		this.hashColumns.put("ts_qty", getTsQty());
		this.hashColumns.put("fm_trd_cd", getFmTrdCd());
		this.hashColumns.put("locl_ts_sts_cd", getLoclTsStsCd());
		this.hashColumns.put("to_skd_voy_no", getToSkdVoyNo());
		this.hashColumns.put("to_cost_yrmon", getToCostYrmon());
		this.hashColumns.put("to_ioc_cd", getToIocCd());
		this.hashColumns.put("to_vsl_cd", getToVslCd());
		this.hashColumns.put("to_trd_cd", getToTrdCd());
		this.hashColumns.put("ts_qty_rto", getTsQtyRto());
		this.hashColumns.put("to_dir_cd", getToDirCd());
		this.hashColumns.put("to_vvd", getToVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ts_expn_amt", "tsExpnAmt");
		this.hashFields.put("fm_ioc_cd", "fmIocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_sml_sls_amt", "fmSmlSlsAmt");
		this.hashFields.put("fm_skd_voy_no", "fmSkdVoyNo");
		this.hashFields.put("fm_vvd", "fmVvd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fm_cost_wk", "fmCostWk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fm_cost_yrmon", "fmCostYrmon");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("fm_ts_uc_amt", "fmTsUcAmt");
		this.hashFields.put("to_rlane_cd", "toRlaneCd");
		this.hashFields.put("to_cost_wk", "toCostWk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_rlane_cd", "fmRlaneCd");
		this.hashFields.put("fm_vsl_cd", "fmVslCd");
		this.hashFields.put("fm_dir_cd", "fmDirCd");
		this.hashFields.put("ts_qty", "tsQty");
		this.hashFields.put("fm_trd_cd", "fmTrdCd");
		this.hashFields.put("locl_ts_sts_cd", "loclTsStsCd");
		this.hashFields.put("to_skd_voy_no", "toSkdVoyNo");
		this.hashFields.put("to_cost_yrmon", "toCostYrmon");
		this.hashFields.put("to_ioc_cd", "toIocCd");
		this.hashFields.put("to_vsl_cd", "toVslCd");
		this.hashFields.put("to_trd_cd", "toTrdCd");
		this.hashFields.put("ts_qty_rto", "tsQtyRto");
		this.hashFields.put("to_dir_cd", "toDirCd");
		this.hashFields.put("to_vvd", "toVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tsExpnAmt
	 */
	public String getTsExpnAmt() {
		return this.tsExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return fmIocCd
	 */
	public String getFmIocCd() {
		return this.fmIocCd;
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
	 * @return fmSmlSlsAmt
	 */
	public String getFmSmlSlsAmt() {
		return this.fmSmlSlsAmt;
	}
	
	/**
	 * Column Info
	 * @return fmSkdVoyNo
	 */
	public String getFmSkdVoyNo() {
		return this.fmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return fmVvd
	 */
	public String getFmVvd() {
		return this.fmVvd;
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
	 * @return fmCostWk
	 */
	public String getFmCostWk() {
		return this.fmCostWk;
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
	 * @return fmCostYrmon
	 */
	public String getFmCostYrmon() {
		return this.fmCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return fmTsUcAmt
	 */
	public String getFmTsUcAmt() {
		return this.fmTsUcAmt;
	}
	
	/**
	 * Column Info
	 * @return toRlaneCd
	 */
	public String getToRlaneCd() {
		return this.toRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return toCostWk
	 */
	public String getToCostWk() {
		return this.toCostWk;
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
	 * @return fmRlaneCd
	 */
	public String getFmRlaneCd() {
		return this.fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fmVslCd
	 */
	public String getFmVslCd() {
		return this.fmVslCd;
	}
	
	/**
	 * Column Info
	 * @return fmDirCd
	 */
	public String getFmDirCd() {
		return this.fmDirCd;
	}
	
	/**
	 * Column Info
	 * @return tsQty
	 */
	public String getTsQty() {
		return this.tsQty;
	}
	
	/**
	 * Column Info
	 * @return fmTrdCd
	 */
	public String getFmTrdCd() {
		return this.fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @return loclTsStsCd
	 */
	public String getLoclTsStsCd() {
		return this.loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @return toSkdVoyNo
	 */
	public String getToSkdVoyNo() {
		return this.toSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return toCostYrmon
	 */
	public String getToCostYrmon() {
		return this.toCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return toIocCd
	 */
	public String getToIocCd() {
		return this.toIocCd;
	}
	
	/**
	 * Column Info
	 * @return toVslCd
	 */
	public String getToVslCd() {
		return this.toVslCd;
	}
	
	/**
	 * Column Info
	 * @return toTrdCd
	 */
	public String getToTrdCd() {
		return this.toTrdCd;
	}
	
	/**
	 * Column Info
	 * @return tsQtyRto
	 */
	public String getTsQtyRto() {
		return this.tsQtyRto;
	}
	
	/**
	 * Column Info
	 * @return toDirCd
	 */
	public String getToDirCd() {
		return this.toDirCd;
	}
	
	/**
	 * Column Info
	 * @return toVvd
	 */
	public String getToVvd() {
		return this.toVvd;
	}
	

	/**
	 * Column Info
	 * @param tsExpnAmt
	 */
	public void setTsExpnAmt(String tsExpnAmt) {
		this.tsExpnAmt = tsExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param fmIocCd
	 */
	public void setFmIocCd(String fmIocCd) {
		this.fmIocCd = fmIocCd;
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
	 * @param fmSmlSlsAmt
	 */
	public void setFmSmlSlsAmt(String fmSmlSlsAmt) {
		this.fmSmlSlsAmt = fmSmlSlsAmt;
	}
	
	/**
	 * Column Info
	 * @param fmSkdVoyNo
	 */
	public void setFmSkdVoyNo(String fmSkdVoyNo) {
		this.fmSkdVoyNo = fmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param fmVvd
	 */
	public void setFmVvd(String fmVvd) {
		this.fmVvd = fmVvd;
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
	 * @param fmCostWk
	 */
	public void setFmCostWk(String fmCostWk) {
		this.fmCostWk = fmCostWk;
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
	 * @param fmCostYrmon
	 */
	public void setFmCostYrmon(String fmCostYrmon) {
		this.fmCostYrmon = fmCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param fmTsUcAmt
	 */
	public void setFmTsUcAmt(String fmTsUcAmt) {
		this.fmTsUcAmt = fmTsUcAmt;
	}
	
	/**
	 * Column Info
	 * @param toRlaneCd
	 */
	public void setToRlaneCd(String toRlaneCd) {
		this.toRlaneCd = toRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param toCostWk
	 */
	public void setToCostWk(String toCostWk) {
		this.toCostWk = toCostWk;
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
	 * @param fmRlaneCd
	 */
	public void setFmRlaneCd(String fmRlaneCd) {
		this.fmRlaneCd = fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fmVslCd
	 */
	public void setFmVslCd(String fmVslCd) {
		this.fmVslCd = fmVslCd;
	}
	
	/**
	 * Column Info
	 * @param fmDirCd
	 */
	public void setFmDirCd(String fmDirCd) {
		this.fmDirCd = fmDirCd;
	}
	
	/**
	 * Column Info
	 * @param tsQty
	 */
	public void setTsQty(String tsQty) {
		this.tsQty = tsQty;
	}
	
	/**
	 * Column Info
	 * @param fmTrdCd
	 */
	public void setFmTrdCd(String fmTrdCd) {
		this.fmTrdCd = fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @param loclTsStsCd
	 */
	public void setLoclTsStsCd(String loclTsStsCd) {
		this.loclTsStsCd = loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @param toSkdVoyNo
	 */
	public void setToSkdVoyNo(String toSkdVoyNo) {
		this.toSkdVoyNo = toSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param toCostYrmon
	 */
	public void setToCostYrmon(String toCostYrmon) {
		this.toCostYrmon = toCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param toIocCd
	 */
	public void setToIocCd(String toIocCd) {
		this.toIocCd = toIocCd;
	}
	
	/**
	 * Column Info
	 * @param toVslCd
	 */
	public void setToVslCd(String toVslCd) {
		this.toVslCd = toVslCd;
	}
	
	/**
	 * Column Info
	 * @param toTrdCd
	 */
	public void setToTrdCd(String toTrdCd) {
		this.toTrdCd = toTrdCd;
	}
	
	/**
	 * Column Info
	 * @param tsQtyRto
	 */
	public void setTsQtyRto(String tsQtyRto) {
		this.tsQtyRto = tsQtyRto;
	}
	
	/**
	 * Column Info
	 * @param toDirCd
	 */
	public void setToDirCd(String toDirCd) {
		this.toDirCd = toDirCd;
	}
	
	/**
	 * Column Info
	 * @param toVvd
	 */
	public void setToVvd(String toVvd) {
		this.toVvd = toVvd;
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
		setTsExpnAmt(JSPUtil.getParameter(request, prefix + "ts_expn_amt", ""));
		setFmIocCd(JSPUtil.getParameter(request, prefix + "fm_ioc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmSmlSlsAmt(JSPUtil.getParameter(request, prefix + "fm_sml_sls_amt", ""));
		setFmSkdVoyNo(JSPUtil.getParameter(request, prefix + "fm_skd_voy_no", ""));
		setFmVvd(JSPUtil.getParameter(request, prefix + "fm_vvd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFmCostWk(JSPUtil.getParameter(request, prefix + "fm_cost_wk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFmCostYrmon(JSPUtil.getParameter(request, prefix + "fm_cost_yrmon", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFmTsUcAmt(JSPUtil.getParameter(request, prefix + "fm_ts_uc_amt", ""));
		setToRlaneCd(JSPUtil.getParameter(request, prefix + "to_rlane_cd", ""));
		setToCostWk(JSPUtil.getParameter(request, prefix + "to_cost_wk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmRlaneCd(JSPUtil.getParameter(request, prefix + "fm_rlane_cd", ""));
		setFmVslCd(JSPUtil.getParameter(request, prefix + "fm_vsl_cd", ""));
		setFmDirCd(JSPUtil.getParameter(request, prefix + "fm_dir_cd", ""));
		setTsQty(JSPUtil.getParameter(request, prefix + "ts_qty", ""));
		setFmTrdCd(JSPUtil.getParameter(request, prefix + "fm_trd_cd", ""));
		setLoclTsStsCd(JSPUtil.getParameter(request, prefix + "locl_ts_sts_cd", ""));
		setToSkdVoyNo(JSPUtil.getParameter(request, prefix + "to_skd_voy_no", ""));
		setToCostYrmon(JSPUtil.getParameter(request, prefix + "to_cost_yrmon", ""));
		setToIocCd(JSPUtil.getParameter(request, prefix + "to_ioc_cd", ""));
		setToVslCd(JSPUtil.getParameter(request, prefix + "to_vsl_cd", ""));
		setToTrdCd(JSPUtil.getParameter(request, prefix + "to_trd_cd", ""));
		setTsQtyRto(JSPUtil.getParameter(request, prefix + "ts_qty_rto", ""));
		setToDirCd(JSPUtil.getParameter(request, prefix + "to_dir_cd", ""));
		setToVvd(JSPUtil.getParameter(request, prefix + "to_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgrdNtwkAllocByAgmtInterVO[]
	 */
	public SearchAgrdNtwkAllocByAgmtInterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAgrdNtwkAllocByAgmtInterVO[]
	 */
	public SearchAgrdNtwkAllocByAgmtInterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgrdNtwkAllocByAgmtInterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tsExpnAmt = (JSPUtil.getParameter(request, prefix	+ "ts_expn_amt", length));
			String[] fmIocCd = (JSPUtil.getParameter(request, prefix	+ "fm_ioc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmSmlSlsAmt = (JSPUtil.getParameter(request, prefix	+ "fm_sml_sls_amt", length));
			String[] fmSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "fm_skd_voy_no", length));
			String[] fmVvd = (JSPUtil.getParameter(request, prefix	+ "fm_vvd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fmCostWk = (JSPUtil.getParameter(request, prefix	+ "fm_cost_wk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fmCostYrmon = (JSPUtil.getParameter(request, prefix	+ "fm_cost_yrmon", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fmTsUcAmt = (JSPUtil.getParameter(request, prefix	+ "fm_ts_uc_amt", length));
			String[] toRlaneCd = (JSPUtil.getParameter(request, prefix	+ "to_rlane_cd", length));
			String[] toCostWk = (JSPUtil.getParameter(request, prefix	+ "to_cost_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmRlaneCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlane_cd", length));
			String[] fmVslCd = (JSPUtil.getParameter(request, prefix	+ "fm_vsl_cd", length));
			String[] fmDirCd = (JSPUtil.getParameter(request, prefix	+ "fm_dir_cd", length));
			String[] tsQty = (JSPUtil.getParameter(request, prefix	+ "ts_qty", length));
			String[] fmTrdCd = (JSPUtil.getParameter(request, prefix	+ "fm_trd_cd", length));
			String[] loclTsStsCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_sts_cd", length));
			String[] toSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "to_skd_voy_no", length));
			String[] toCostYrmon = (JSPUtil.getParameter(request, prefix	+ "to_cost_yrmon", length));
			String[] toIocCd = (JSPUtil.getParameter(request, prefix	+ "to_ioc_cd", length));
			String[] toVslCd = (JSPUtil.getParameter(request, prefix	+ "to_vsl_cd", length));
			String[] toTrdCd = (JSPUtil.getParameter(request, prefix	+ "to_trd_cd", length));
			String[] tsQtyRto = (JSPUtil.getParameter(request, prefix	+ "ts_qty_rto", length));
			String[] toDirCd = (JSPUtil.getParameter(request, prefix	+ "to_dir_cd", length));
			String[] toVvd = (JSPUtil.getParameter(request, prefix	+ "to_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgrdNtwkAllocByAgmtInterVO();
				if (tsExpnAmt[i] != null)
					model.setTsExpnAmt(tsExpnAmt[i]);
				if (fmIocCd[i] != null)
					model.setFmIocCd(fmIocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmSmlSlsAmt[i] != null)
					model.setFmSmlSlsAmt(fmSmlSlsAmt[i]);
				if (fmSkdVoyNo[i] != null)
					model.setFmSkdVoyNo(fmSkdVoyNo[i]);
				if (fmVvd[i] != null)
					model.setFmVvd(fmVvd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fmCostWk[i] != null)
					model.setFmCostWk(fmCostWk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fmCostYrmon[i] != null)
					model.setFmCostYrmon(fmCostYrmon[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fmTsUcAmt[i] != null)
					model.setFmTsUcAmt(fmTsUcAmt[i]);
				if (toRlaneCd[i] != null)
					model.setToRlaneCd(toRlaneCd[i]);
				if (toCostWk[i] != null)
					model.setToCostWk(toCostWk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmRlaneCd[i] != null)
					model.setFmRlaneCd(fmRlaneCd[i]);
				if (fmVslCd[i] != null)
					model.setFmVslCd(fmVslCd[i]);
				if (fmDirCd[i] != null)
					model.setFmDirCd(fmDirCd[i]);
				if (tsQty[i] != null)
					model.setTsQty(tsQty[i]);
				if (fmTrdCd[i] != null)
					model.setFmTrdCd(fmTrdCd[i]);
				if (loclTsStsCd[i] != null)
					model.setLoclTsStsCd(loclTsStsCd[i]);
				if (toSkdVoyNo[i] != null)
					model.setToSkdVoyNo(toSkdVoyNo[i]);
				if (toCostYrmon[i] != null)
					model.setToCostYrmon(toCostYrmon[i]);
				if (toIocCd[i] != null)
					model.setToIocCd(toIocCd[i]);
				if (toVslCd[i] != null)
					model.setToVslCd(toVslCd[i]);
				if (toTrdCd[i] != null)
					model.setToTrdCd(toTrdCd[i]);
				if (tsQtyRto[i] != null)
					model.setTsQtyRto(tsQtyRto[i]);
				if (toDirCd[i] != null)
					model.setToDirCd(toDirCd[i]);
				if (toVvd[i] != null)
					model.setToVvd(toVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgrdNtwkAllocByAgmtInterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgrdNtwkAllocByAgmtInterVO[]
	 */
	public SearchAgrdNtwkAllocByAgmtInterVO[] getSearchAgrdNtwkAllocByAgmtInterVOs(){
		SearchAgrdNtwkAllocByAgmtInterVO[] vos = (SearchAgrdNtwkAllocByAgmtInterVO[])models.toArray(new SearchAgrdNtwkAllocByAgmtInterVO[models.size()]);
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
		this.tsExpnAmt = this.tsExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIocCd = this.fmIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSmlSlsAmt = this.fmSmlSlsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSkdVoyNo = this.fmSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmVvd = this.fmVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCostWk = this.fmCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCostYrmon = this.fmCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTsUcAmt = this.fmTsUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRlaneCd = this.toRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCostWk = this.toCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRlaneCd = this.fmRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmVslCd = this.fmVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDirCd = this.fmDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsQty = this.tsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrdCd = this.fmTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsStsCd = this.loclTsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSkdVoyNo = this.toSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCostYrmon = this.toCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toIocCd = this.toIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVslCd = this.toVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrdCd = this.toTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsQtyRto = this.tsQtyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDirCd = this.toDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVvd = this.toVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
