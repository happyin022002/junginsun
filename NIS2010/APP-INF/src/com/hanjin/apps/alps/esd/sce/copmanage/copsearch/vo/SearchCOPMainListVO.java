/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCOPMainListVO.java
*@FileTitle : SearchCOPMainListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.11 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCOPMainListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCOPMainListVO> models = new ArrayList<SearchCOPMainListVO>();
	
	/* Column Info */
	private String copStsNm = null;
	/* Column Info */
	private String dlvPlnDate = null;
	/* Column Info */
	private String dlvEstmDate = null;
	/* Column Info */
	private String dlvPlnTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dueTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rCopNo = null;
	/* Column Info */
	private String copExtStsCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String copSubStsCd = null;
	/* Column Info */
	private String totcnt = null;
	/* Column Info */
	private String dueDate = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String plnTime = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String dlvEstmTime = null;
	/* Column Info */
	private String rBkgNo = null;
	/* Column Info */
	private String cntrNoV = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String dlvDts = null;
	/* Column Info */
	private String mstLclCd = null;
	/* Column Info */
	private String estmTime = null;
	/* Column Info */
	private String plnDate = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String estmDate = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String rCntrNo = null;
	private String rCopSubStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCOPMainListVO() {}

	public SearchCOPMainListVO(String ibflag, String pagerows, String totcnt, String rCopNo, String copDtlSeq, String cntrNoV, String cntrTpszCd, String cntrVolQty, String mstLclCd, String rBkgNo, String copStsCd, String copStsNm, String actCd, String actNm, String nodCd, String plnDate, String plnTime, String estmDate, String estmTime, String dueDate, String dueTime, String copExtStsCd, String copSubStsCd, String dlvDts, String rCntrNo, String dlvPlnDate, String dlvPlnTime, String dlvEstmDate, String dlvEstmTime, String creUsrId, String updUsrId, String rCopSubStsCd) {
		this.copStsNm = copStsNm;
		this.dlvPlnDate = dlvPlnDate;
		this.dlvEstmDate = dlvEstmDate;
		this.dlvPlnTime = dlvPlnTime;
		this.pagerows = pagerows;
		this.dueTime = dueTime;
		this.ibflag = ibflag;
		this.rCopNo = rCopNo;
		this.copExtStsCd = copExtStsCd;
		this.cntrTpszCd = cntrTpszCd;
		this.actNm = actNm;
		this.copStsCd = copStsCd;
		this.copSubStsCd = copSubStsCd;
		this.totcnt = totcnt;
		this.dueDate = dueDate;
		this.updUsrId = updUsrId;
		this.plnTime = plnTime;
		this.actCd = actCd;
		this.dlvEstmTime = dlvEstmTime;
		this.rBkgNo = rBkgNo;
		this.cntrNoV = cntrNoV;
		this.copDtlSeq = copDtlSeq;
		this.dlvDts = dlvDts;
		this.mstLclCd = mstLclCd;
		this.estmTime = estmTime;
		this.plnDate = plnDate;
		this.creUsrId = creUsrId;
		this.estmDate = estmDate;
		this.nodCd = nodCd;
		this.cntrVolQty = cntrVolQty;
		this.rCntrNo = rCntrNo;
		this.rCopSubStsCd = rCopSubStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cop_sts_nm", getCopStsNm());
		this.hashColumns.put("dlv_pln_date", getDlvPlnDate());
		this.hashColumns.put("dlv_estm_date", getDlvEstmDate());
		this.hashColumns.put("dlv_pln_time", getDlvPlnTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("due_time", getDueTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r_cop_no", getRCopNo());
		this.hashColumns.put("cop_ext_sts_cd", getCopExtStsCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("cop_sub_sts_cd", getCopSubStsCd());
		this.hashColumns.put("totcnt", getTotcnt());
		this.hashColumns.put("due_date", getDueDate());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pln_time", getPlnTime());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("dlv_estm_time", getDlvEstmTime());
		this.hashColumns.put("r_bkg_no", getRBkgNo());
		this.hashColumns.put("cntr_no_v", getCntrNoV());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("dlv_dts", getDlvDts());
		this.hashColumns.put("mst_lcl_cd", getMstLclCd());
		this.hashColumns.put("estm_time", getEstmTime());
		this.hashColumns.put("pln_date", getPlnDate());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("estm_date", getEstmDate());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("r_cntr_no", getRCntrNo());
		this.hashColumns.put("r_cop_sub_sts_cd", getRCopSubStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cop_sts_nm", "copStsNm");
		this.hashFields.put("dlv_pln_date", "dlvPlnDate");
		this.hashFields.put("dlv_estm_date", "dlvEstmDate");
		this.hashFields.put("dlv_pln_time", "dlvPlnTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("due_time", "dueTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r_cop_no", "rCopNo");
		this.hashFields.put("cop_ext_sts_cd", "copExtStsCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("cop_sub_sts_cd", "copSubStsCd");
		this.hashFields.put("totcnt", "totcnt");
		this.hashFields.put("due_date", "dueDate");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pln_time", "plnTime");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("dlv_estm_time", "dlvEstmTime");
		this.hashFields.put("r_bkg_no", "rBkgNo");
		this.hashFields.put("cntr_no_v", "cntrNoV");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("dlv_dts", "dlvDts");
		this.hashFields.put("mst_lcl_cd", "mstLclCd");
		this.hashFields.put("estm_time", "estmTime");
		this.hashFields.put("pln_date", "plnDate");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("estm_date", "estmDate");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("r_cntr_no", "rCntrNo");
		this.hashFields.put("r_cop_sub_sts_cd","rCopSubStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return copStsNm
	 */
	public String getCopStsNm() {
		return this.copStsNm;
	}
	
	/**
	 * Column Info
	 * @return dlvPlnDate
	 */
	public String getDlvPlnDate() {
		return this.dlvPlnDate;
	}
	
	/**
	 * Column Info
	 * @return dlvEstmDate
	 */
	public String getDlvEstmDate() {
		return this.dlvEstmDate;
	}
	
	/**
	 * Column Info
	 * @return dlvPlnTime
	 */
	public String getDlvPlnTime() {
		return this.dlvPlnTime;
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
	 * @return dueTime
	 */
	public String getDueTime() {
		return this.dueTime;
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
	 * @return rCopNo
	 */
	public String getRCopNo() {
		return this.rCopNo;
	}
	
	/**
	 * Column Info
	 * @return copExtStsCd
	 */
	public String getCopExtStsCd() {
		return this.copExtStsCd;
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
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return copSubStsCd
	 */
	public String getCopSubStsCd() {
		return this.copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @return totcnt
	 */
	public String getTotcnt() {
		return this.totcnt;
	}
	
	/**
	 * Column Info
	 * @return dueDate
	 */
	public String getDueDate() {
		return this.dueDate;
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
	 * @return plnTime
	 */
	public String getPlnTime() {
		return this.plnTime;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return dlvEstmTime
	 */
	public String getDlvEstmTime() {
		return this.dlvEstmTime;
	}
	
	/**
	 * Column Info
	 * @return rBkgNo
	 */
	public String getRBkgNo() {
		return this.rBkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNoV
	 */
	public String getCntrNoV() {
		return this.cntrNoV;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return dlvDts
	 */
	public String getDlvDts() {
		return this.dlvDts;
	}
	
	/**
	 * Column Info
	 * @return mstLclCd
	 */
	public String getMstLclCd() {
		return this.mstLclCd;
	}
	
	/**
	 * Column Info
	 * @return estmTime
	 */
	public String getEstmTime() {
		return this.estmTime;
	}
	
	/**
	 * Column Info
	 * @return plnDate
	 */
	public String getPlnDate() {
		return this.plnDate;
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
	 * @return estmDate
	 */
	public String getEstmDate() {
		return this.estmDate;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return rCntrNo
	 */
	public String getRCntrNo() {
		return this.rCntrNo;
	}
	
	public String getRCopSubStsCd(){
		return this.rCopSubStsCd;
	}
	/**
	 * Column Info
	 * @param copStsNm
	 */
	public void setCopStsNm(String copStsNm) {
		this.copStsNm = copStsNm;
	}
	
	/**
	 * Column Info
	 * @param dlvPlnDate
	 */
	public void setDlvPlnDate(String dlvPlnDate) {
		this.dlvPlnDate = dlvPlnDate;
	}
	
	/**
	 * Column Info
	 * @param dlvEstmDate
	 */
	public void setDlvEstmDate(String dlvEstmDate) {
		this.dlvEstmDate = dlvEstmDate;
	}
	
	/**
	 * Column Info
	 * @param dlvPlnTime
	 */
	public void setDlvPlnTime(String dlvPlnTime) {
		this.dlvPlnTime = dlvPlnTime;
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
	 * @param dueTime
	 */
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
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
	 * @param rCopNo
	 */
	public void setRCopNo(String rCopNo) {
		this.rCopNo = rCopNo;
	}
	
	/**
	 * Column Info
	 * @param copExtStsCd
	 */
	public void setCopExtStsCd(String copExtStsCd) {
		this.copExtStsCd = copExtStsCd;
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
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param copSubStsCd
	 */
	public void setCopSubStsCd(String copSubStsCd) {
		this.copSubStsCd = copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @param totcnt
	 */
	public void setTotcnt(String totcnt) {
		this.totcnt = totcnt;
	}
	
	/**
	 * Column Info
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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
	 * @param plnTime
	 */
	public void setPlnTime(String plnTime) {
		this.plnTime = plnTime;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param dlvEstmTime
	 */
	public void setDlvEstmTime(String dlvEstmTime) {
		this.dlvEstmTime = dlvEstmTime;
	}
	
	/**
	 * Column Info
	 * @param rBkgNo
	 */
	public void setRBkgNo(String rBkgNo) {
		this.rBkgNo = rBkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNoV
	 */
	public void setCntrNoV(String cntrNoV) {
		this.cntrNoV = cntrNoV;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param dlvDts
	 */
	public void setDlvDts(String dlvDts) {
		this.dlvDts = dlvDts;
	}
	
	/**
	 * Column Info
	 * @param mstLclCd
	 */
	public void setMstLclCd(String mstLclCd) {
		this.mstLclCd = mstLclCd;
	}
	
	/**
	 * Column Info
	 * @param estmTime
	 */
	public void setEstmTime(String estmTime) {
		this.estmTime = estmTime;
	}
	
	/**
	 * Column Info
	 * @param plnDate
	 */
	public void setPlnDate(String plnDate) {
		this.plnDate = plnDate;
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
	 * @param estmDate
	 */
	public void setEstmDate(String estmDate) {
		this.estmDate = estmDate;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param rCntrNo
	 */
	public void setRCntrNo(String rCntrNo) {
		this.rCntrNo = rCntrNo;
	}
	public void setRCopSubStsCd(String rCopSubStsCd){
		this.rCopSubStsCd = rCopSubStsCd;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCopStsNm(JSPUtil.getParameter(request, "cop_sts_nm", ""));
		setDlvPlnDate(JSPUtil.getParameter(request, "dlv_pln_date", ""));
		setDlvEstmDate(JSPUtil.getParameter(request, "dlv_estm_date", ""));
		setDlvPlnTime(JSPUtil.getParameter(request, "dlv_pln_time", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDueTime(JSPUtil.getParameter(request, "due_time", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRCopNo(JSPUtil.getParameter(request, "r_cop_no", ""));
		setCopExtStsCd(JSPUtil.getParameter(request, "cop_ext_sts_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setCopSubStsCd(JSPUtil.getParameter(request, "cop_sub_sts_cd", ""));
		setTotcnt(JSPUtil.getParameter(request, "totcnt", ""));
		setDueDate(JSPUtil.getParameter(request, "due_date", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPlnTime(JSPUtil.getParameter(request, "pln_time", ""));
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setDlvEstmTime(JSPUtil.getParameter(request, "dlv_estm_time", ""));
		setRBkgNo(JSPUtil.getParameter(request, "r_bkg_no", ""));
		setCntrNoV(JSPUtil.getParameter(request, "cntr_no_v", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setDlvDts(JSPUtil.getParameter(request, "dlv_dts", ""));
		setMstLclCd(JSPUtil.getParameter(request, "mst_lcl_cd", ""));
		setEstmTime(JSPUtil.getParameter(request, "estm_time", ""));
		setPlnDate(JSPUtil.getParameter(request, "pln_date", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEstmDate(JSPUtil.getParameter(request, "estm_date", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setCntrVolQty(JSPUtil.getParameter(request, "cntr_vol_qty", ""));
		setRCntrNo(JSPUtil.getParameter(request, "r_cntr_no", ""));
		setRCopSubStsCd(JSPUtil.getParameter(request, "r_cop_sub_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCOPMainListVO[]
	 */
	public SearchCOPMainListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCOPMainListVO[]
	 */
	public SearchCOPMainListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCOPMainListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] copStsNm = (JSPUtil.getParameter(request, prefix	+ "cop_sts_nm", length));
			String[] dlvPlnDate = (JSPUtil.getParameter(request, prefix	+ "dlv_pln_date", length));
			String[] dlvEstmDate = (JSPUtil.getParameter(request, prefix	+ "dlv_estm_date", length));
			String[] dlvPlnTime = (JSPUtil.getParameter(request, prefix	+ "dlv_pln_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dueTime = (JSPUtil.getParameter(request, prefix	+ "due_time", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rCopNo = (JSPUtil.getParameter(request, prefix	+ "r_cop_no", length));
			String[] copExtStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_ext_sts_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] copSubStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sub_sts_cd", length));
			String[] totcnt = (JSPUtil.getParameter(request, prefix	+ "totcnt", length));
			String[] dueDate = (JSPUtil.getParameter(request, prefix	+ "due_date", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] plnTime = (JSPUtil.getParameter(request, prefix	+ "pln_time", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] dlvEstmTime = (JSPUtil.getParameter(request, prefix	+ "dlv_estm_time", length));
			String[] rBkgNo = (JSPUtil.getParameter(request, prefix	+ "r_bkg_no", length));
			String[] cntrNoV = (JSPUtil.getParameter(request, prefix	+ "cntr_no_v", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] dlvDts = (JSPUtil.getParameter(request, prefix	+ "dlv_dts", length));
			String[] mstLclCd = (JSPUtil.getParameter(request, prefix	+ "mst_lcl_cd", length));
			String[] estmTime = (JSPUtil.getParameter(request, prefix	+ "estm_time", length));
			String[] plnDate = (JSPUtil.getParameter(request, prefix	+ "pln_date", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] estmDate = (JSPUtil.getParameter(request, prefix	+ "estm_date", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] rCntrNo = (JSPUtil.getParameter(request, prefix	+ "r_cntr_no", length));
			String[] rCopSubStsCd  = (JSPUtil.getParameter(request, prefix	+ "r_cop_sub_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCOPMainListVO();
				if (copStsNm[i] != null)
					model.setCopStsNm(copStsNm[i]);
				if (dlvPlnDate[i] != null)
					model.setDlvPlnDate(dlvPlnDate[i]);
				if (dlvEstmDate[i] != null)
					model.setDlvEstmDate(dlvEstmDate[i]);
				if (dlvPlnTime[i] != null)
					model.setDlvPlnTime(dlvPlnTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dueTime[i] != null)
					model.setDueTime(dueTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rCopNo[i] != null)
					model.setRCopNo(rCopNo[i]);
				if (copExtStsCd[i] != null)
					model.setCopExtStsCd(copExtStsCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (copSubStsCd[i] != null)
					model.setCopSubStsCd(copSubStsCd[i]);
				if (totcnt[i] != null)
					model.setTotcnt(totcnt[i]);
				if (dueDate[i] != null)
					model.setDueDate(dueDate[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (plnTime[i] != null)
					model.setPlnTime(plnTime[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (dlvEstmTime[i] != null)
					model.setDlvEstmTime(dlvEstmTime[i]);
				if (rBkgNo[i] != null)
					model.setRBkgNo(rBkgNo[i]);
				if (cntrNoV[i] != null)
					model.setCntrNoV(cntrNoV[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (dlvDts[i] != null)
					model.setDlvDts(dlvDts[i]);
				if (mstLclCd[i] != null)
					model.setMstLclCd(mstLclCd[i]);
				if (estmTime[i] != null)
					model.setEstmTime(estmTime[i]);
				if (plnDate[i] != null)
					model.setPlnDate(plnDate[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (estmDate[i] != null)
					model.setEstmDate(estmDate[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (rCntrNo[i] != null)
					model.setRCntrNo(rCntrNo[i]);
				if(rCopSubStsCd[i] != null)
					model.setRCopSubStsCd(rCopSubStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCOPMainListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCOPMainListVO[]
	 */
	public SearchCOPMainListVO[] getSearchCOPMainListVOs(){
		SearchCOPMainListVO[] vos = (SearchCOPMainListVO[])models.toArray(new SearchCOPMainListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.copStsNm = this.copStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvPlnDate = this.dlvPlnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvEstmDate = this.dlvEstmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvPlnTime = this.dlvPlnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueTime = this.dueTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCopNo = this.rCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExtStsCd = this.copExtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSubStsCd = this.copSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totcnt = this.totcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDate = this.dueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnTime = this.plnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvEstmTime = this.dlvEstmTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBkgNo = this.rBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoV = this.cntrNoV .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlvDts = this.dlvDts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstLclCd = this.mstLclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTime = this.estmTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDate = this.plnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDate = this.estmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCntrNo = this.rCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCopSubStsCd = this.rCopSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}
}
