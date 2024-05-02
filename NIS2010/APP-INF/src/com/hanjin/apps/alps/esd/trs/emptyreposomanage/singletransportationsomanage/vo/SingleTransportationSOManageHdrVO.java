/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SingleTransportationSOManageHdrVO.java
*@FileTitle : SingleTransportationSOManageHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SingleTransportationSOManageHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SingleTransportationSOManageHdrVO> models = new ArrayList<SingleTransportationSOManageHdrVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String soIfDivCd = null;
	/* Column Info */
	private String cretQty = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String remaingQty = null;
	/* Column Info */
	private String allocated = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String requestedDate = null;
	/* Column Info */
	private String woQty = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String soRqstDt = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String chk1 = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String trspCostDtlModName = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String repoPurpRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SingleTransportationSOManageHdrVO() {}

	public SingleTransportationSOManageHdrVO(String ibflag, String pagerows, String repoPlnId, String plnYrwk, String plnSeq, String refId, String toNodCd, String soIfDivCd, String cretQty, String remaingQty, String allocated, String woQty, String requestedDate, String trspModCd, String trspCostDtlModCd, String vvdCd, String fmLocCd, String soRqstDt, String trspCrrModCd, String fmDt, String chk1, String toLocCd, String eqTpszCd, String fmNodCd, String toDt, String slanCd, String trspCostDtlModName, String repoPurpRmk) {
		this.toNodCd = toNodCd;
		this.soIfDivCd = soIfDivCd;
		this.cretQty = cretQty;
		this.refId = refId;
		this.remaingQty = remaingQty;
		this.allocated = allocated;
		this.plnYrwk = plnYrwk;
		this.requestedDate = requestedDate;
		this.woQty = woQty;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.vvdCd = vvdCd;
		this.fmLocCd = fmLocCd;
		this.soRqstDt = soRqstDt;
		this.trspCrrModCd = trspCrrModCd;
		this.fmDt = fmDt;
		this.chk1 = chk1;
		this.toLocCd = toLocCd;
		this.plnSeq = plnSeq;
		this.eqTpszCd = eqTpszCd;
		this.repoPlnId = repoPlnId;
		this.fmNodCd = fmNodCd;
		this.toDt = toDt;
		this.trspCostDtlModName = trspCostDtlModName;
		this.slanCd = slanCd;
		this.repoPurpRmk = repoPurpRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("so_if_div_cd", getSoIfDivCd());
		this.hashColumns.put("cret_qty", getCretQty());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("remaing_qty", getRemaingQty());
		this.hashColumns.put("allocated", getAllocated());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("requested_date", getRequestedDate());
		this.hashColumns.put("wo_qty", getWoQty());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("so_rqst_dt", getSoRqstDt());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("chk1", getChk1());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("trsp_cost_dtl_mod_name", getTrspCostDtlModName());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("repo_purp_rmk", getRepoPurpRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("so_if_div_cd", "soIfDivCd");
		this.hashFields.put("cret_qty", "cretQty");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("remaing_qty", "remaingQty");
		this.hashFields.put("allocated", "allocated");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("requested_date", "requestedDate");
		this.hashFields.put("wo_qty", "woQty");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("so_rqst_dt", "soRqstDt");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("chk1", "chk1");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("trsp_cost_dtl_mod_name", "trspCostDtlModName");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("repo_purp_rmk", "repoPurpRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return soIfDivCd
	 */
	public String getSoIfDivCd() {
		return this.soIfDivCd;
	}
	
	/**
	 * Column Info
	 * @return cretQty
	 */
	public String getCretQty() {
		return this.cretQty;
	}
	
	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return remaingQty
	 */
	public String getRemaingQty() {
		return this.remaingQty;
	}
	
	/**
	 * Column Info
	 * @return allocated
	 */
	public String getAllocated() {
		return this.allocated;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return requestedDate
	 */
	public String getRequestedDate() {
		return this.requestedDate;
	}
	
	/**
	 * Column Info
	 * @return woQty
	 */
	public String getWoQty() {
		return this.woQty;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
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
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
	}
	
	/**
	 * Column Info
	 * @return soRqstDt
	 */
	public String getSoRqstDt() {
		return this.soRqstDt;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
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
	 * @return chk1
	 */
	public String getChk1() {
		return this.chk1;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
	}
	
	/**
	 * Column Info
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
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
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return trspCostDtlModName
	 */
	public String getTrspCostDtlModName() {
		return this.trspCostDtlModName;
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
	 * @return repoPurpRmk
	 */
	public String getRepoPurpRmk() {
		return this.repoPurpRmk;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param soIfDivCd
	 */
	public void setSoIfDivCd(String soIfDivCd) {
		this.soIfDivCd = soIfDivCd;
	}
	
	/**
	 * Column Info
	 * @param cretQty
	 */
	public void setCretQty(String cretQty) {
		this.cretQty = cretQty;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param remaingQty
	 */
	public void setRemaingQty(String remaingQty) {
		this.remaingQty = remaingQty;
	}
	
	/**
	 * Column Info
	 * @param allocated
	 */
	public void setAllocated(String allocated) {
		this.allocated = allocated;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param requestedDate
	 */
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	
	/**
	 * Column Info
	 * @param woQty
	 */
	public void setWoQty(String woQty) {
		this.woQty = woQty;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
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
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}
	
	/**
	 * Column Info
	 * @param soRqstDt
	 */
	public void setSoRqstDt(String soRqstDt) {
		this.soRqstDt = soRqstDt;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
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
	 * @param chk1
	 */
	public void setChk1(String chk1) {
		this.chk1 = chk1;
	}
	
	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
	}
	
	/**
	 * Column Info
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param trspCostDtlModName
	 */
	public void setTrspCostDtlModName(String trspCostDtlModName) {
		this.trspCostDtlModName = trspCostDtlModName;
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
	 * @param repoPurpRmk
	 */
	public void setRepoPurpRmk(String repoPurpRmk) {
		this.repoPurpRmk = repoPurpRmk;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setSoIfDivCd(JSPUtil.getParameter(request, prefix + "so_if_div_cd", ""));
		setCretQty(JSPUtil.getParameter(request, prefix + "cret_qty", ""));
		setRefId(JSPUtil.getParameter(request, prefix + "ref_id", ""));
		setRemaingQty(JSPUtil.getParameter(request, prefix + "remaing_qty", ""));
		setAllocated(JSPUtil.getParameter(request, prefix + "allocated", ""));
		setPlnYrwk(JSPUtil.getParameter(request, prefix + "pln_yrwk", ""));
		setRequestedDate(JSPUtil.getParameter(request, prefix + "requested_date", ""));
		setWoQty(JSPUtil.getParameter(request, prefix + "wo_qty", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setSoRqstDt(JSPUtil.getParameter(request, prefix + "so_rqst_dt", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setChk1(JSPUtil.getParameter(request, prefix + "chk1", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setPlnSeq(JSPUtil.getParameter(request, prefix + "pln_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setRepoPlnId(JSPUtil.getParameter(request, prefix + "repo_pln_id", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setTrspCostDtlModName(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_name", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setRepoPurpRmk(JSPUtil.getParameter(request, prefix + "repo_purp_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SingleTransportationSOManageHdrVO[]
	 */
	public SingleTransportationSOManageHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SingleTransportationSOManageHdrVO[]
	 */
	public SingleTransportationSOManageHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SingleTransportationSOManageHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] soIfDivCd = (JSPUtil.getParameter(request, prefix	+ "so_if_div_cd", length));
			String[] cretQty = (JSPUtil.getParameter(request, prefix	+ "cret_qty", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] remaingQty = (JSPUtil.getParameter(request, prefix	+ "remaing_qty", length));
			String[] allocated = (JSPUtil.getParameter(request, prefix	+ "allocated", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] requestedDate = (JSPUtil.getParameter(request, prefix	+ "requested_date", length));
			String[] woQty = (JSPUtil.getParameter(request, prefix	+ "wo_qty", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] soRqstDt = (JSPUtil.getParameter(request, prefix	+ "so_rqst_dt", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] chk1 = (JSPUtil.getParameter(request, prefix	+ "chk1", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] trspCostDtlModName = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_name", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] repoPurpRmk = (JSPUtil.getParameter(request, prefix	+ "repo_purp_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SingleTransportationSOManageHdrVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (soIfDivCd[i] != null)
					model.setSoIfDivCd(soIfDivCd[i]);
				if (cretQty[i] != null)
					model.setCretQty(cretQty[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (remaingQty[i] != null)
					model.setRemaingQty(remaingQty[i]);
				if (allocated[i] != null)
					model.setAllocated(allocated[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (requestedDate[i] != null)
					model.setRequestedDate(requestedDate[i]);
				if (woQty[i] != null)
					model.setWoQty(woQty[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (soRqstDt[i] != null)
					model.setSoRqstDt(soRqstDt[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (chk1[i] != null)
					model.setChk1(chk1[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (trspCostDtlModName[i] != null)
					model.setTrspCostDtlModName(trspCostDtlModName[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (repoPurpRmk[i] != null)
					model.setRepoPurpRmk(repoPurpRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSingleTransportationSOManageHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SingleTransportationSOManageHdrVO[]
	 */
	public SingleTransportationSOManageHdrVO[] getSingleTransportationSOManageHdrVOs(){
		SingleTransportationSOManageHdrVO[] vos = (SingleTransportationSOManageHdrVO[])models.toArray(new SingleTransportationSOManageHdrVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soIfDivCd = this.soIfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cretQty = this.cretQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remaingQty = this.remaingQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allocated = this.allocated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.requestedDate = this.requestedDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woQty = this.woQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRqstDt = this.soRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk1 = this.chk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModName = this.trspCostDtlModName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPurpRmk = this.repoPurpRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
