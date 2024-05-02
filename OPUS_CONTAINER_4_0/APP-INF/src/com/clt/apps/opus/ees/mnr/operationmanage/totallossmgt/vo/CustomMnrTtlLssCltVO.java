/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomMnrTtlLssCltVO.java
*@FileTitle : CustomMnrTtlLssCltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo;

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

public class CustomMnrTtlLssCltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrTtlLssCltVO> models = new ArrayList<CustomMnrTtlLssCltVO>();
	
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cltAmt = null;
	/* Column Info */
	private String ttlLssNo = null;
	/* Column Info */
	private String invPayMzdCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String ttlLssCltSeq = null;
	/* Column Info */
	private String ttlLssCltTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String arChkNo = null;
	/* Column Info */
	private String evidNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ttlLssDtlSeq = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String ttlLssCltRmk = null;
	/* Column Info */
	private String cltDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cltStlFlg = null;
	/* Column Info */
	private String chkTrnsNo = null;
	/* Column Info */
	private String mnrBilToNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrTtlLssCltVO() {}

	public CustomMnrTtlLssCltVO(String ibflag, String pagerows, String ttlLssNo, String ttlLssDtlSeq, String ttlLssCltSeq, String type, String cltDt, String ttlLssCltTpCd, String cltOfcCd, String cltStlFlg, String currCd, String cltAmt, String invPayMzdCd, String bankNm, String bankAcctNo, String mnrBilToNm, String csrNo, String arChkNo, String chkTrnsNo, String ttlLssCltRmk, String creUsrId, String creDt, String updUsrId, String updDt, String invNo, String rqstEqNo, String evidNo) {
		this.bankAcctNo = bankAcctNo;
		this.currCd = currCd;
		this.cltAmt = cltAmt;
		this.ttlLssNo = ttlLssNo;
		this.invPayMzdCd = invPayMzdCd;
		this.cltOfcCd = cltOfcCd;
		this.creDt = creDt;
		this.type = type;
		this.ttlLssCltSeq = ttlLssCltSeq;
		this.ttlLssCltTpCd = ttlLssCltTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rqstEqNo = rqstEqNo;
		this.bankNm = bankNm;
		this.arChkNo = arChkNo;
		this.evidNo = evidNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ttlLssDtlSeq = ttlLssDtlSeq;
		this.csrNo = csrNo;
		this.ttlLssCltRmk = ttlLssCltRmk;
		this.cltDt = cltDt;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.cltStlFlg = cltStlFlg;
		this.chkTrnsNo = chkTrnsNo;
		this.mnrBilToNm = mnrBilToNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("clt_amt", getCltAmt());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("inv_pay_mzd_cd", getInvPayMzdCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("ttl_lss_clt_seq", getTtlLssCltSeq());
		this.hashColumns.put("ttl_lss_clt_tp_cd", getTtlLssCltTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("ar_chk_no", getArChkNo());
		this.hashColumns.put("evid_no", getEvidNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_lss_dtl_seq", getTtlLssDtlSeq());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ttl_lss_clt_rmk", getTtlLssCltRmk());
		this.hashColumns.put("clt_dt", getCltDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clt_stl_flg", getCltStlFlg());
		this.hashColumns.put("chk_trns_no", getChkTrnsNo());
		this.hashColumns.put("mnr_bil_to_nm", getMnrBilToNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("inv_pay_mzd_cd", "invPayMzdCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("type", "type");
		this.hashFields.put("ttl_lss_clt_seq", "ttlLssCltSeq");
		this.hashFields.put("ttl_lss_clt_tp_cd", "ttlLssCltTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("ar_chk_no", "arChkNo");
		this.hashFields.put("evid_no", "evidNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_lss_dtl_seq", "ttlLssDtlSeq");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ttl_lss_clt_rmk", "ttlLssCltRmk");
		this.hashFields.put("clt_dt", "cltDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clt_stl_flg", "cltStlFlg");
		this.hashFields.put("chk_trns_no", "chkTrnsNo");
		this.hashFields.put("mnr_bil_to_nm", "mnrBilToNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
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
	 * @return cltAmt
	 */
	public String getCltAmt() {
		return this.cltAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlLssNo
	 */
	public String getTtlLssNo() {
		return this.ttlLssNo;
	}
	
	/**
	 * Column Info
	 * @return invPayMzdCd
	 */
	public String getInvPayMzdCd() {
		return this.invPayMzdCd;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
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
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return ttlLssCltSeq
	 */
	public String getTtlLssCltSeq() {
		return this.ttlLssCltSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlLssCltTpCd
	 */
	public String getTtlLssCltTpCd() {
		return this.ttlLssCltTpCd;
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
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return arChkNo
	 */
	public String getArChkNo() {
		return this.arChkNo;
	}
	
	/**
	 * Column Info
	 * @return evidNo
	 */
	public String getEvidNo() {
		return this.evidNo;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ttlLssDtlSeq
	 */
	public String getTtlLssDtlSeq() {
		return this.ttlLssDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return ttlLssCltRmk
	 */
	public String getTtlLssCltRmk() {
		return this.ttlLssCltRmk;
	}
	
	/**
	 * Column Info
	 * @return cltDt
	 */
	public String getCltDt() {
		return this.cltDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cltStlFlg
	 */
	public String getCltStlFlg() {
		return this.cltStlFlg;
	}
	
	/**
	 * Column Info
	 * @return chkTrnsNo
	 */
	public String getChkTrnsNo() {
		return this.chkTrnsNo;
	}
	
	/**
	 * Column Info
	 * @return mnrBilToNm
	 */
	public String getMnrBilToNm() {
		return this.mnrBilToNm;
	}
	

	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
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
	 * @param cltAmt
	 */
	public void setCltAmt(String cltAmt) {
		this.cltAmt = cltAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlLssNo
	 */
	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
	}
	
	/**
	 * Column Info
	 * @param invPayMzdCd
	 */
	public void setInvPayMzdCd(String invPayMzdCd) {
		this.invPayMzdCd = invPayMzdCd;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
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
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param ttlLssCltSeq
	 */
	public void setTtlLssCltSeq(String ttlLssCltSeq) {
		this.ttlLssCltSeq = ttlLssCltSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlLssCltTpCd
	 */
	public void setTtlLssCltTpCd(String ttlLssCltTpCd) {
		this.ttlLssCltTpCd = ttlLssCltTpCd;
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
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param arChkNo
	 */
	public void setArChkNo(String arChkNo) {
		this.arChkNo = arChkNo;
	}
	
	/**
	 * Column Info
	 * @param evidNo
	 */
	public void setEvidNo(String evidNo) {
		this.evidNo = evidNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ttlLssDtlSeq
	 */
	public void setTtlLssDtlSeq(String ttlLssDtlSeq) {
		this.ttlLssDtlSeq = ttlLssDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param ttlLssCltRmk
	 */
	public void setTtlLssCltRmk(String ttlLssCltRmk) {
		this.ttlLssCltRmk = ttlLssCltRmk;
	}
	
	/**
	 * Column Info
	 * @param cltDt
	 */
	public void setCltDt(String cltDt) {
		this.cltDt = cltDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cltStlFlg
	 */
	public void setCltStlFlg(String cltStlFlg) {
		this.cltStlFlg = cltStlFlg;
	}
	
	/**
	 * Column Info
	 * @param chkTrnsNo
	 */
	public void setChkTrnsNo(String chkTrnsNo) {
		this.chkTrnsNo = chkTrnsNo;
	}
	
	/**
	 * Column Info
	 * @param mnrBilToNm
	 */
	public void setMnrBilToNm(String mnrBilToNm) {
		this.mnrBilToNm = mnrBilToNm;
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
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCltAmt(JSPUtil.getParameter(request, prefix + "clt_amt", ""));
		setTtlLssNo(JSPUtil.getParameter(request, prefix + "ttl_lss_no", ""));
		setInvPayMzdCd(JSPUtil.getParameter(request, prefix + "inv_pay_mzd_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setTtlLssCltSeq(JSPUtil.getParameter(request, prefix + "ttl_lss_clt_seq", ""));
		setTtlLssCltTpCd(JSPUtil.getParameter(request, prefix + "ttl_lss_clt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setArChkNo(JSPUtil.getParameter(request, prefix + "ar_chk_no", ""));
		setEvidNo(JSPUtil.getParameter(request, prefix + "evid_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlLssDtlSeq(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_seq", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setTtlLssCltRmk(JSPUtil.getParameter(request, prefix + "ttl_lss_clt_rmk", ""));
		setCltDt(JSPUtil.getParameter(request, prefix + "clt_dt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCltStlFlg(JSPUtil.getParameter(request, prefix + "clt_stl_flg", ""));
		setChkTrnsNo(JSPUtil.getParameter(request, prefix + "chk_trns_no", ""));
		setMnrBilToNm(JSPUtil.getParameter(request, prefix + "mnr_bil_to_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrTtlLssCltVO[]
	 */
	public CustomMnrTtlLssCltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrTtlLssCltVO[]
	 */
	public CustomMnrTtlLssCltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrTtlLssCltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cltAmt = (JSPUtil.getParameter(request, prefix	+ "clt_amt", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] invPayMzdCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_mzd_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] ttlLssCltSeq = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_clt_seq", length));
			String[] ttlLssCltTpCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_clt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] arChkNo = (JSPUtil.getParameter(request, prefix	+ "ar_chk_no", length));
			String[] evidNo = (JSPUtil.getParameter(request, prefix	+ "evid_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlLssDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_seq", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ttlLssCltRmk = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_clt_rmk", length));
			String[] cltDt = (JSPUtil.getParameter(request, prefix	+ "clt_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cltStlFlg = (JSPUtil.getParameter(request, prefix	+ "clt_stl_flg", length));
			String[] chkTrnsNo = (JSPUtil.getParameter(request, prefix	+ "chk_trns_no", length));
			String[] mnrBilToNm = (JSPUtil.getParameter(request, prefix	+ "mnr_bil_to_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrTtlLssCltVO();
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cltAmt[i] != null)
					model.setCltAmt(cltAmt[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (invPayMzdCd[i] != null)
					model.setInvPayMzdCd(invPayMzdCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (ttlLssCltSeq[i] != null)
					model.setTtlLssCltSeq(ttlLssCltSeq[i]);
				if (ttlLssCltTpCd[i] != null)
					model.setTtlLssCltTpCd(ttlLssCltTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (arChkNo[i] != null)
					model.setArChkNo(arChkNo[i]);
				if (evidNo[i] != null)
					model.setEvidNo(evidNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlLssDtlSeq[i] != null)
					model.setTtlLssDtlSeq(ttlLssDtlSeq[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ttlLssCltRmk[i] != null)
					model.setTtlLssCltRmk(ttlLssCltRmk[i]);
				if (cltDt[i] != null)
					model.setCltDt(cltDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cltStlFlg[i] != null)
					model.setCltStlFlg(cltStlFlg[i]);
				if (chkTrnsNo[i] != null)
					model.setChkTrnsNo(chkTrnsNo[i]);
				if (mnrBilToNm[i] != null)
					model.setMnrBilToNm(mnrBilToNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrTtlLssCltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrTtlLssCltVO[]
	 */
	public CustomMnrTtlLssCltVO[] getCustomMnrTtlLssCltVOs(){
		CustomMnrTtlLssCltVO[] vos = (CustomMnrTtlLssCltVO[])models.toArray(new CustomMnrTtlLssCltVO[models.size()]);
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
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt = this.cltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayMzdCd = this.invPayMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCltSeq = this.ttlLssCltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCltTpCd = this.ttlLssCltTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arChkNo = this.arChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evidNo = this.evidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlSeq = this.ttlLssDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCltRmk = this.ttlLssCltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltDt = this.cltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltStlFlg = this.cltStlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTrnsNo = this.chkTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrBilToNm = this.mnrBilToNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
