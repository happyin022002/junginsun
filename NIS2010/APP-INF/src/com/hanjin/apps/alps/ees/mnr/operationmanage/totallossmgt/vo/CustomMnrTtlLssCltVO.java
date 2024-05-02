/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrTtlLssCltVO.java
*@FileTitle : CustomMnrTtlLssCltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2010.01.11 권영법 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo;

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
 * @author 권영법
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrTtlLssCltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrTtlLssCltVO> models = new ArrayList<CustomMnrTtlLssCltVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String ttlLssDtlSeq = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cltAmt = null;
	/* Column Info */
	private String ttlLssNo = null;
	/* Column Info */
	private String ttlLssCltRmk = null;
	/* Column Info */
	private String invPayMzdCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String cltDt = null;
	/* Column Info */
	private String ttlLssCltSeq = null;
	/* Column Info */
	private String ttlLssCltTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cltStlFlg = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String arChkNo = null;
	/* Column Info */
	private String chkTrnsNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrBilToNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrTtlLssCltVO() {}

	public CustomMnrTtlLssCltVO(String ibflag, String pagerows, String updDt, String csrNo, String bankAcctNo, String ttlLssDtlSeq, String currCd, String cltAmt, String ttlLssNo, String ttlLssCltRmk, String invPayMzdCd, String creDt, String cltOfcCd, String cltDt, String ttlLssCltSeq, String ttlLssCltTpCd, String creUsrId, String cltStlFlg, String bankNm, String arChkNo, String updUsrId, String chkTrnsNo, String mnrBilToNm, String type) {
		this.updDt = updDt;
		this.csrNo = csrNo;
		this.bankAcctNo = bankAcctNo;
		this.ttlLssDtlSeq = ttlLssDtlSeq;
		this.currCd = currCd;
		this.cltAmt = cltAmt;
		this.ttlLssNo = ttlLssNo;
		this.ttlLssCltRmk = ttlLssCltRmk;
		this.invPayMzdCd = invPayMzdCd;
		this.creDt = creDt;
		this.cltOfcCd = cltOfcCd;
		this.type = type;
		this.cltDt = cltDt;
		this.ttlLssCltSeq = ttlLssCltSeq;
		this.ttlLssCltTpCd = ttlLssCltTpCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cltStlFlg = cltStlFlg;
		this.bankNm = bankNm;
		this.arChkNo = arChkNo;
		this.chkTrnsNo = chkTrnsNo;
		this.updUsrId = updUsrId;
		this.mnrBilToNm = mnrBilToNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("ttl_lss_dtl_seq", getTtlLssDtlSeq());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("clt_amt", getCltAmt());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("ttl_lss_clt_rmk", getTtlLssCltRmk());
		this.hashColumns.put("inv_pay_mzd_cd", getInvPayMzdCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("clt_dt", getCltDt());
		this.hashColumns.put("ttl_lss_clt_seq", getTtlLssCltSeq());
		this.hashColumns.put("ttl_lss_clt_tp_cd", getTtlLssCltTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clt_stl_flg", getCltStlFlg());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("ar_chk_no", getArChkNo());
		this.hashColumns.put("chk_trns_no", getChkTrnsNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_bil_to_nm", getMnrBilToNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("ttl_lss_dtl_seq", "ttlLssDtlSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("ttl_lss_clt_rmk", "ttlLssCltRmk");
		this.hashFields.put("inv_pay_mzd_cd", "invPayMzdCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("type", "type");
		this.hashFields.put("clt_dt", "cltDt");
		this.hashFields.put("ttl_lss_clt_seq", "ttlLssCltSeq");
		this.hashFields.put("ttl_lss_clt_tp_cd", "ttlLssCltTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clt_stl_flg", "cltStlFlg");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("ar_chk_no", "arChkNo");
		this.hashFields.put("chk_trns_no", "chkTrnsNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_bil_to_nm", "mnrBilToNm");
		return this.hashFields;
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
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return ttlLssDtlSeq
	 */
	public String getTtlLssDtlSeq() {
		return this.ttlLssDtlSeq;
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
	 * @return ttlLssCltRmk
	 */
	public String getTtlLssCltRmk() {
		return this.ttlLssCltRmk;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return type
	 */
	public String getType() {
		return this.type;
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
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cltStlFlg
	 */
	public String getCltStlFlg() {
		return this.cltStlFlg;
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
	 * @return chkTrnsNo
	 */
	public String getChkTrnsNo() {
		return this.chkTrnsNo;
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
	 * @return mnrBilToNm
	 */
	public String getMnrBilToNm() {
		return this.mnrBilToNm;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param ttlLssDtlSeq
	 */
	public void setTtlLssDtlSeq(String ttlLssDtlSeq) {
		this.ttlLssDtlSeq = ttlLssDtlSeq;
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
	 * @param ttlLssCltRmk
	 */
	public void setTtlLssCltRmk(String ttlLssCltRmk) {
		this.ttlLssCltRmk = ttlLssCltRmk;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cltStlFlg
	 */
	public void setCltStlFlg(String cltStlFlg) {
		this.cltStlFlg = cltStlFlg;
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
	 * @param chkTrnsNo
	 */
	public void setChkTrnsNo(String chkTrnsNo) {
		this.chkTrnsNo = chkTrnsNo;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setBankAcctNo(JSPUtil.getParameter(request, "bank_acct_no", ""));
		setTtlLssDtlSeq(JSPUtil.getParameter(request, "ttl_lss_dtl_seq", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCltAmt(JSPUtil.getParameter(request, "clt_amt", ""));
		setTtlLssNo(JSPUtil.getParameter(request, "ttl_lss_no", ""));
		setTtlLssCltRmk(JSPUtil.getParameter(request, "ttl_lss_clt_rmk", ""));
		setInvPayMzdCd(JSPUtil.getParameter(request, "inv_pay_mzd_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCltOfcCd(JSPUtil.getParameter(request, "clt_ofc_cd", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setCltDt(JSPUtil.getParameter(request, "clt_dt", ""));
		setTtlLssCltSeq(JSPUtil.getParameter(request, "ttl_lss_clt_seq", ""));
		setTtlLssCltTpCd(JSPUtil.getParameter(request, "ttl_lss_clt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCltStlFlg(JSPUtil.getParameter(request, "clt_stl_flg", ""));
		setBankNm(JSPUtil.getParameter(request, "bank_nm", ""));
		setArChkNo(JSPUtil.getParameter(request, "ar_chk_no", ""));
		setChkTrnsNo(JSPUtil.getParameter(request, "chk_trns_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMnrBilToNm(JSPUtil.getParameter(request, "mnr_bil_to_nm", ""));
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
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] ttlLssDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_seq", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cltAmt = (JSPUtil.getParameter(request, prefix	+ "clt_amt", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] ttlLssCltRmk = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_clt_rmk", length));
			String[] invPayMzdCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_mzd_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] cltDt = (JSPUtil.getParameter(request, prefix	+ "clt_dt", length));
			String[] ttlLssCltSeq = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_clt_seq", length));
			String[] ttlLssCltTpCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_clt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cltStlFlg = (JSPUtil.getParameter(request, prefix	+ "clt_stl_flg", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] arChkNo = (JSPUtil.getParameter(request, prefix	+ "ar_chk_no", length));
			String[] chkTrnsNo = (JSPUtil.getParameter(request, prefix	+ "chk_trns_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrBilToNm = (JSPUtil.getParameter(request, prefix	+ "mnr_bil_to_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrTtlLssCltVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (ttlLssDtlSeq[i] != null)
					model.setTtlLssDtlSeq(ttlLssDtlSeq[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cltAmt[i] != null)
					model.setCltAmt(cltAmt[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (ttlLssCltRmk[i] != null)
					model.setTtlLssCltRmk(ttlLssCltRmk[i]);
				if (invPayMzdCd[i] != null)
					model.setInvPayMzdCd(invPayMzdCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (cltDt[i] != null)
					model.setCltDt(cltDt[i]);
				if (ttlLssCltSeq[i] != null)
					model.setTtlLssCltSeq(ttlLssCltSeq[i]);
				if (ttlLssCltTpCd[i] != null)
					model.setTtlLssCltTpCd(ttlLssCltTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cltStlFlg[i] != null)
					model.setCltStlFlg(cltStlFlg[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (arChkNo[i] != null)
					model.setArChkNo(arChkNo[i]);
				if (chkTrnsNo[i] != null)
					model.setChkTrnsNo(chkTrnsNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlSeq = this.ttlLssDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt = this.cltAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCltRmk = this.ttlLssCltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayMzdCd = this.invPayMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltDt = this.cltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCltSeq = this.ttlLssCltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCltTpCd = this.ttlLssCltTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltStlFlg = this.cltStlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arChkNo = this.arChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTrnsNo = this.chkTrnsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrBilToNm = this.mnrBilToNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
