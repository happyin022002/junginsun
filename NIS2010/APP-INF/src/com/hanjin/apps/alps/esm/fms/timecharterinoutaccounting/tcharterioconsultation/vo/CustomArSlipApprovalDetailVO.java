/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomArSlipApprovalDetailVO.java
*@FileTitle : CustomArSlipApprovalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.09.16 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomArSlipApprovalDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomArSlipApprovalDetailVO> models = new ArrayList<CustomArSlipApprovalDetailVO>();
	
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String revCoaDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revCoaAcctCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String joRevTpCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String revCoaCtrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String revCoaCoCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sobId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String revCoaVslCd = null;
	/* Column Info */
	private String chgFullNm = null;
	/* Column Info */
	private String revCoaRgnCd = null;
	/* Column Info */
	private String revCoaSkdDirCd = null;
	/* Column Info */
	private String revCoaVoyNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String revCoaInterCoCd = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String arIfSerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomArSlipApprovalDetailVO() {}

	public CustomArSlipApprovalDetailVO(String ibflag, String pagerows, String arIfNo, String arIfSerNo, String chgSeq, String chgCd, String repChgCd, String chgAmt, String trfRtAmt, String ratAsCntrQty, String sobId, String chgFullNm, String currCd, String taxAmt, String revCoaCoCd, String revCoaRgnCd, String revCoaCtrCd, String revCoaAcctCd, String revCoaInterCoCd, String revCoaVslCd, String revCoaVoyNo, String revCoaSkdDirCd, String revCoaDirCd, String acctCd, String creUsrId, String creDt, String updUsrId, String updDt, String joRevTpCd) {
		this.repChgCd = repChgCd;
		this.currCd = currCd;
		this.revCoaDirCd = revCoaDirCd;
		this.creDt = creDt;
		this.trfRtAmt = trfRtAmt;
		this.chgSeq = chgSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.revCoaAcctCd = revCoaAcctCd;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.arIfNo = arIfNo;
		this.joRevTpCd = joRevTpCd;
		this.chgAmt = chgAmt;
		this.revCoaCtrCd = revCoaCtrCd;
		this.acctCd = acctCd;
		this.revCoaCoCd = revCoaCoCd;
		this.updUsrId = updUsrId;
		this.sobId = sobId;
		this.updDt = updDt;
		this.revCoaVslCd = revCoaVslCd;
		this.chgFullNm = chgFullNm;
		this.revCoaRgnCd = revCoaRgnCd;
		this.revCoaSkdDirCd = revCoaSkdDirCd;
		this.revCoaVoyNo = revCoaVoyNo;
		this.creUsrId = creUsrId;
		this.revCoaInterCoCd = revCoaInterCoCd;
		this.ratAsCntrQty = ratAsCntrQty;
		this.arIfSerNo = arIfSerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rev_coa_dir_cd", getRevCoaDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_coa_acct_cd", getRevCoaAcctCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("jo_rev_tp_cd", getJoRevTpCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rev_coa_ctr_cd", getRevCoaCtrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("rev_coa_co_cd", getRevCoaCoCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sob_id", getSobId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rev_coa_vsl_cd", getRevCoaVslCd());
		this.hashColumns.put("chg_full_nm", getChgFullNm());
		this.hashColumns.put("rev_coa_rgn_cd", getRevCoaRgnCd());
		this.hashColumns.put("rev_coa_skd_dir_cd", getRevCoaSkdDirCd());
		this.hashColumns.put("rev_coa_voy_no", getRevCoaVoyNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rev_coa_inter_co_cd", getRevCoaInterCoCd());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rev_coa_dir_cd", "revCoaDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_coa_acct_cd", "revCoaAcctCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("jo_rev_tp_cd", "joRevTpCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rev_coa_ctr_cd", "revCoaCtrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("rev_coa_co_cd", "revCoaCoCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sob_id", "sobId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rev_coa_vsl_cd", "revCoaVslCd");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("rev_coa_rgn_cd", "revCoaRgnCd");
		this.hashFields.put("rev_coa_skd_dir_cd", "revCoaSkdDirCd");
		this.hashFields.put("rev_coa_voy_no", "revCoaVoyNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rev_coa_inter_co_cd", "revCoaInterCoCd");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
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
	 * @return revCoaDirCd
	 */
	public String getRevCoaDirCd() {
		return this.revCoaDirCd;
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
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return revCoaAcctCd
	 */
	public String getRevCoaAcctCd() {
		return this.revCoaAcctCd;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return joRevTpCd
	 */
	public String getJoRevTpCd() {
		return this.joRevTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return revCoaCtrCd
	 */
	public String getRevCoaCtrCd() {
		return this.revCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaCoCd
	 */
	public String getRevCoaCoCd() {
		return this.revCoaCoCd;
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
	 * @return sobId
	 */
	public String getSobId() {
		return this.sobId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return revCoaVslCd
	 */
	public String getRevCoaVslCd() {
		return this.revCoaVslCd;
	}
	
	/**
	 * Column Info
	 * @return chgFullNm
	 */
	public String getChgFullNm() {
		return this.chgFullNm;
	}
	
	/**
	 * Column Info
	 * @return revCoaRgnCd
	 */
	public String getRevCoaRgnCd() {
		return this.revCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaSkdDirCd
	 */
	public String getRevCoaSkdDirCd() {
		return this.revCoaSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return revCoaVoyNo
	 */
	public String getRevCoaVoyNo() {
		return this.revCoaVoyNo;
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
	 * @return revCoaInterCoCd
	 */
	public String getRevCoaInterCoCd() {
		return this.revCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @return arIfSerNo
	 */
	public String getArIfSerNo() {
		return this.arIfSerNo;
	}
	

	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
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
	 * @param revCoaDirCd
	 */
	public void setRevCoaDirCd(String revCoaDirCd) {
		this.revCoaDirCd = revCoaDirCd;
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
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param revCoaAcctCd
	 */
	public void setRevCoaAcctCd(String revCoaAcctCd) {
		this.revCoaAcctCd = revCoaAcctCd;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param joRevTpCd
	 */
	public void setJoRevTpCd(String joRevTpCd) {
		this.joRevTpCd = joRevTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param revCoaCtrCd
	 */
	public void setRevCoaCtrCd(String revCoaCtrCd) {
		this.revCoaCtrCd = revCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaCoCd
	 */
	public void setRevCoaCoCd(String revCoaCoCd) {
		this.revCoaCoCd = revCoaCoCd;
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
	 * @param sobId
	 */
	public void setSobId(String sobId) {
		this.sobId = sobId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param revCoaVslCd
	 */
	public void setRevCoaVslCd(String revCoaVslCd) {
		this.revCoaVslCd = revCoaVslCd;
	}
	
	/**
	 * Column Info
	 * @param chgFullNm
	 */
	public void setChgFullNm(String chgFullNm) {
		this.chgFullNm = chgFullNm;
	}
	
	/**
	 * Column Info
	 * @param revCoaRgnCd
	 */
	public void setRevCoaRgnCd(String revCoaRgnCd) {
		this.revCoaRgnCd = revCoaRgnCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaSkdDirCd
	 */
	public void setRevCoaSkdDirCd(String revCoaSkdDirCd) {
		this.revCoaSkdDirCd = revCoaSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param revCoaVoyNo
	 */
	public void setRevCoaVoyNo(String revCoaVoyNo) {
		this.revCoaVoyNo = revCoaVoyNo;
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
	 * @param revCoaInterCoCd
	 */
	public void setRevCoaInterCoCd(String revCoaInterCoCd) {
		this.revCoaInterCoCd = revCoaInterCoCd;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @param arIfSerNo
	 */
	public void setArIfSerNo(String arIfSerNo) {
		this.arIfSerNo = arIfSerNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepChgCd(JSPUtil.getParameter(request, "rep_chg_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setRevCoaDirCd(JSPUtil.getParameter(request, "rev_coa_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRevCoaAcctCd(JSPUtil.getParameter(request, "rev_coa_acct_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setJoRevTpCd(JSPUtil.getParameter(request, "jo_rev_tp_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setRevCoaCtrCd(JSPUtil.getParameter(request, "rev_coa_ctr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setRevCoaCoCd(JSPUtil.getParameter(request, "rev_coa_co_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSobId(JSPUtil.getParameter(request, "sob_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRevCoaVslCd(JSPUtil.getParameter(request, "rev_coa_vsl_cd", ""));
		setChgFullNm(JSPUtil.getParameter(request, "chg_full_nm", ""));
		setRevCoaRgnCd(JSPUtil.getParameter(request, "rev_coa_rgn_cd", ""));
		setRevCoaSkdDirCd(JSPUtil.getParameter(request, "rev_coa_skd_dir_cd", ""));
		setRevCoaVoyNo(JSPUtil.getParameter(request, "rev_coa_voy_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRevCoaInterCoCd(JSPUtil.getParameter(request, "rev_coa_inter_co_cd", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, "rat_as_cntr_qty", ""));
		setArIfSerNo(JSPUtil.getParameter(request, "ar_if_ser_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomArSlipApprovalDetailVO[]
	 */
	public CustomArSlipApprovalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomArSlipApprovalDetailVO[]
	 */
	public CustomArSlipApprovalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomArSlipApprovalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] revCoaDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_acct_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] joRevTpCd = (JSPUtil.getParameter(request, prefix	+ "jo_rev_tp_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] revCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_ctr_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] revCoaCoCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_co_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sobId = (JSPUtil.getParameter(request, prefix	+ "sob_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] revCoaVslCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_vsl_cd", length));
			String[] chgFullNm = (JSPUtil.getParameter(request, prefix	+ "chg_full_nm", length));
			String[] revCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_rgn_cd", length));
			String[] revCoaSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_skd_dir_cd", length));
			String[] revCoaVoyNo = (JSPUtil.getParameter(request, prefix	+ "rev_coa_voy_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] revCoaInterCoCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_inter_co_cd", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			String[] arIfSerNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_ser_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomArSlipApprovalDetailVO();
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (revCoaDirCd[i] != null)
					model.setRevCoaDirCd(revCoaDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revCoaAcctCd[i] != null)
					model.setRevCoaAcctCd(revCoaAcctCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (joRevTpCd[i] != null)
					model.setJoRevTpCd(joRevTpCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (revCoaCtrCd[i] != null)
					model.setRevCoaCtrCd(revCoaCtrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (revCoaCoCd[i] != null)
					model.setRevCoaCoCd(revCoaCoCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sobId[i] != null)
					model.setSobId(sobId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (revCoaVslCd[i] != null)
					model.setRevCoaVslCd(revCoaVslCd[i]);
				if (chgFullNm[i] != null)
					model.setChgFullNm(chgFullNm[i]);
				if (revCoaRgnCd[i] != null)
					model.setRevCoaRgnCd(revCoaRgnCd[i]);
				if (revCoaSkdDirCd[i] != null)
					model.setRevCoaSkdDirCd(revCoaSkdDirCd[i]);
				if (revCoaVoyNo[i] != null)
					model.setRevCoaVoyNo(revCoaVoyNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (revCoaInterCoCd[i] != null)
					model.setRevCoaInterCoCd(revCoaInterCoCd[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (arIfSerNo[i] != null)
					model.setArIfSerNo(arIfSerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomArSlipApprovalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomArSlipApprovalDetailVO[]
	 */
	public CustomArSlipApprovalDetailVO[] getCustomArSlipApprovalDetailVOs(){
		CustomArSlipApprovalDetailVO[] vos = (CustomArSlipApprovalDetailVO[])models.toArray(new CustomArSlipApprovalDetailVO[models.size()]);
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
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaDirCd = this.revCoaDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaAcctCd = this.revCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRevTpCd = this.joRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCtrCd = this.revCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCoCd = this.revCoaCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sobId = this.sobId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaVslCd = this.revCoaVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm = this.chgFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaRgnCd = this.revCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaSkdDirCd = this.revCoaSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaVoyNo = this.revCoaVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaInterCoCd = this.revCoaInterCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo = this.arIfSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
