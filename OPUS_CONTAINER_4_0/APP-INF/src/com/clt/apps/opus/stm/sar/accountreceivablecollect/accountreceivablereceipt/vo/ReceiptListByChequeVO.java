/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptListByChequeVO.java
*@FileTitle : ReceiptListByChequeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.29  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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

public class ReceiptListByChequeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptListByChequeVO> models = new ArrayList<ReceiptListByChequeVO>();
	
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String rfdAmt = null;
	/* Column Info */
	private String rctCxlRsnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctCurrCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String rctCustCd = null;
	/* Column Info */
	private String rctDpsDt = null;
	/* Column Info */
	private String bankAcctNm = null;
	/* Column Info */
	private String bankAcctSeq = null;
	/* Column Info */
	private String chqNo = null;
	/* Column Info */
	private String rctAmt = null;
	/* Column Info */
	private String rctRmk = null;
	/* Column Info */
	private String rctCustNm = null;
	/* Column Info */
	private String unidAmt = null;
	/* Column Info */
	private String unappAmt = null;
	/* Column Info */
	private String rctCxlDt = null;
	/* Column Info */
	private String usrOfc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rctTpCd = null;
	/* Column Info */
	private String rctDt = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String bankChgAmt = null;
	/* Column Info */
	private String rctNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptListByChequeVO() {}

	public ReceiptListByChequeVO(String ibflag, String pagerows, String chqNo, String rctNo, String asaNo, String rctOfcCd, String rctCustCd, String rctCustNm, String rctDt, String rctDpsDt, String bankAcctSeq, String bankAcctNm, String rctCxlRsnCd, String rctCxlDt, String rctCurrCd, String rctAmt, String rctTpCd, String unidAmt, String unappAmt, String bankChgAmt, String rfdAmt, String rctRmk, String creUsrId, String usrNm, String usrOfc) {
		this.rctOfcCd = rctOfcCd;
		this.rfdAmt = rfdAmt;
		this.rctCxlRsnCd = rctCxlRsnCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rctCurrCd = rctCurrCd;
		this.usrNm = usrNm;
		this.rctCustCd = rctCustCd;
		this.rctDpsDt = rctDpsDt;
		this.bankAcctNm = bankAcctNm;
		this.bankAcctSeq = bankAcctSeq;
		this.chqNo = chqNo;
		this.rctAmt = rctAmt;
		this.rctRmk = rctRmk;
		this.rctCustNm = rctCustNm;
		this.unidAmt = unidAmt;
		this.unappAmt = unappAmt;
		this.rctCxlDt = rctCxlDt;
		this.usrOfc = usrOfc;
		this.creUsrId = creUsrId;
		this.rctTpCd = rctTpCd;
		this.rctDt = rctDt;
		this.asaNo = asaNo;
		this.bankChgAmt = bankChgAmt;
		this.rctNo = rctNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("rfd_amt", getRfdAmt());
		this.hashColumns.put("rct_cxl_rsn_cd", getRctCxlRsnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("rct_cust_cd", getRctCustCd());
		this.hashColumns.put("rct_dps_dt", getRctDpsDt());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());
		this.hashColumns.put("chq_no", getChqNo());
		this.hashColumns.put("rct_amt", getRctAmt());
		this.hashColumns.put("rct_rmk", getRctRmk());
		this.hashColumns.put("rct_cust_nm", getRctCustNm());
		this.hashColumns.put("unid_amt", getUnidAmt());
		this.hashColumns.put("unapp_amt", getUnappAmt());
		this.hashColumns.put("rct_cxl_dt", getRctCxlDt());
		this.hashColumns.put("usr_ofc", getUsrOfc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rct_tp_cd", getRctTpCd());
		this.hashColumns.put("rct_dt", getRctDt());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("bank_chg_amt", getBankChgAmt());
		this.hashColumns.put("rct_no", getRctNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("rfd_amt", "rfdAmt");
		this.hashFields.put("rct_cxl_rsn_cd", "rctCxlRsnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("rct_cust_cd", "rctCustCd");
		this.hashFields.put("rct_dps_dt", "rctDpsDt");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("chq_no", "chqNo");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("rct_rmk", "rctRmk");
		this.hashFields.put("rct_cust_nm", "rctCustNm");
		this.hashFields.put("unid_amt", "unidAmt");
		this.hashFields.put("unapp_amt", "unappAmt");
		this.hashFields.put("rct_cxl_dt", "rctCxlDt");
		this.hashFields.put("usr_ofc", "usrOfc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("bank_chg_amt", "bankChgAmt");
		this.hashFields.put("rct_no", "rctNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rfdAmt
	 */
	public String getRfdAmt() {
		return this.rfdAmt;
	}
	
	/**
	 * Column Info
	 * @return rctCxlRsnCd
	 */
	public String getRctCxlRsnCd() {
		return this.rctCxlRsnCd;
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
	 * @return rctCurrCd
	 */
	public String getRctCurrCd() {
		return this.rctCurrCd;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return rctCustCd
	 */
	public String getRctCustCd() {
		return this.rctCustCd;
	}
	
	/**
	 * Column Info
	 * @return rctDpsDt
	 */
	public String getRctDpsDt() {
		return this.rctDpsDt;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNm
	 */
	public String getBankAcctNm() {
		return this.bankAcctNm;
	}
	
	/**
	 * Column Info
	 * @return bankAcctSeq
	 */
	public String getBankAcctSeq() {
		return this.bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @return chqNo
	 */
	public String getChqNo() {
		return this.chqNo;
	}
	
	/**
	 * Column Info
	 * @return rctAmt
	 */
	public String getRctAmt() {
		return this.rctAmt;
	}
	
	/**
	 * Column Info
	 * @return rctRmk
	 */
	public String getRctRmk() {
		return this.rctRmk;
	}
	
	/**
	 * Column Info
	 * @return rctCustNm
	 */
	public String getRctCustNm() {
		return this.rctCustNm;
	}
	
	/**
	 * Column Info
	 * @return unidAmt
	 */
	public String getUnidAmt() {
		return this.unidAmt;
	}
	
	/**
	 * Column Info
	 * @return unappAmt
	 */
	public String getUnappAmt() {
		return this.unappAmt;
	}
	
	/**
	 * Column Info
	 * @return rctCxlDt
	 */
	public String getRctCxlDt() {
		return this.rctCxlDt;
	}
	
	/**
	 * Column Info
	 * @return usrOfc
	 */
	public String getUsrOfc() {
		return this.usrOfc;
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
	 * @return rctTpCd
	 */
	public String getRctTpCd() {
		return this.rctTpCd;
	}
	
	/**
	 * Column Info
	 * @return rctDt
	 */
	public String getRctDt() {
		return this.rctDt;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return bankChgAmt
	 */
	public String getBankChgAmt() {
		return this.bankChgAmt;
	}
	
	/**
	 * Column Info
	 * @return rctNo
	 */
	public String getRctNo() {
		return this.rctNo;
	}
	

	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rfdAmt
	 */
	public void setRfdAmt(String rfdAmt) {
		this.rfdAmt = rfdAmt;
	}
	
	/**
	 * Column Info
	 * @param rctCxlRsnCd
	 */
	public void setRctCxlRsnCd(String rctCxlRsnCd) {
		this.rctCxlRsnCd = rctCxlRsnCd;
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
	 * @param rctCurrCd
	 */
	public void setRctCurrCd(String rctCurrCd) {
		this.rctCurrCd = rctCurrCd;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param rctCustCd
	 */
	public void setRctCustCd(String rctCustCd) {
		this.rctCustCd = rctCustCd;
	}
	
	/**
	 * Column Info
	 * @param rctDpsDt
	 */
	public void setRctDpsDt(String rctDpsDt) {
		this.rctDpsDt = rctDpsDt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNm
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
	}
	
	/**
	 * Column Info
	 * @param bankAcctSeq
	 */
	public void setBankAcctSeq(String bankAcctSeq) {
		this.bankAcctSeq = bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @param chqNo
	 */
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	
	/**
	 * Column Info
	 * @param rctAmt
	 */
	public void setRctAmt(String rctAmt) {
		this.rctAmt = rctAmt;
	}
	
	/**
	 * Column Info
	 * @param rctRmk
	 */
	public void setRctRmk(String rctRmk) {
		this.rctRmk = rctRmk;
	}
	
	/**
	 * Column Info
	 * @param rctCustNm
	 */
	public void setRctCustNm(String rctCustNm) {
		this.rctCustNm = rctCustNm;
	}
	
	/**
	 * Column Info
	 * @param unidAmt
	 */
	public void setUnidAmt(String unidAmt) {
		this.unidAmt = unidAmt;
	}
	
	/**
	 * Column Info
	 * @param unappAmt
	 */
	public void setUnappAmt(String unappAmt) {
		this.unappAmt = unappAmt;
	}
	
	/**
	 * Column Info
	 * @param rctCxlDt
	 */
	public void setRctCxlDt(String rctCxlDt) {
		this.rctCxlDt = rctCxlDt;
	}
	
	/**
	 * Column Info
	 * @param usrOfc
	 */
	public void setUsrOfc(String usrOfc) {
		this.usrOfc = usrOfc;
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
	 * @param rctTpCd
	 */
	public void setRctTpCd(String rctTpCd) {
		this.rctTpCd = rctTpCd;
	}
	
	/**
	 * Column Info
	 * @param rctDt
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param bankChgAmt
	 */
	public void setBankChgAmt(String bankChgAmt) {
		this.bankChgAmt = bankChgAmt;
	}
	
	/**
	 * Column Info
	 * @param rctNo
	 */
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
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
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setRfdAmt(JSPUtil.getParameter(request, prefix + "rfd_amt", ""));
		setRctCxlRsnCd(JSPUtil.getParameter(request, prefix + "rct_cxl_rsn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctCurrCd(JSPUtil.getParameter(request, prefix + "rct_curr_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setRctCustCd(JSPUtil.getParameter(request, prefix + "rct_cust_cd", ""));
		setRctDpsDt(JSPUtil.getParameter(request, prefix + "rct_dps_dt", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
		setBankAcctSeq(JSPUtil.getParameter(request, prefix + "bank_acct_seq", ""));
		setChqNo(JSPUtil.getParameter(request, prefix + "chq_no", ""));
		setRctAmt(JSPUtil.getParameter(request, prefix + "rct_amt", ""));
		setRctRmk(JSPUtil.getParameter(request, prefix + "rct_rmk", ""));
		setRctCustNm(JSPUtil.getParameter(request, prefix + "rct_cust_nm", ""));
		setUnidAmt(JSPUtil.getParameter(request, prefix + "unid_amt", ""));
		setUnappAmt(JSPUtil.getParameter(request, prefix + "unapp_amt", ""));
		setRctCxlDt(JSPUtil.getParameter(request, prefix + "rct_cxl_dt", ""));
		setUsrOfc(JSPUtil.getParameter(request, prefix + "usr_ofc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRctTpCd(JSPUtil.getParameter(request, prefix + "rct_tp_cd", ""));
		setRctDt(JSPUtil.getParameter(request, prefix + "rct_dt", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setBankChgAmt(JSPUtil.getParameter(request, prefix + "bank_chg_amt", ""));
		setRctNo(JSPUtil.getParameter(request, prefix + "rct_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptListByChequeVO[]
	 */
	public ReceiptListByChequeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptListByChequeVO[]
	 */
	public ReceiptListByChequeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptListByChequeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] rfdAmt = (JSPUtil.getParameter(request, prefix	+ "rfd_amt", length));
			String[] rctCxlRsnCd = (JSPUtil.getParameter(request, prefix	+ "rct_cxl_rsn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctCurrCd = (JSPUtil.getParameter(request, prefix	+ "rct_curr_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] rctCustCd = (JSPUtil.getParameter(request, prefix	+ "rct_cust_cd", length));
			String[] rctDpsDt = (JSPUtil.getParameter(request, prefix	+ "rct_dps_dt", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			String[] bankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_seq", length));
			String[] chqNo = (JSPUtil.getParameter(request, prefix	+ "chq_no", length));
			String[] rctAmt = (JSPUtil.getParameter(request, prefix	+ "rct_amt", length));
			String[] rctRmk = (JSPUtil.getParameter(request, prefix	+ "rct_rmk", length));
			String[] rctCustNm = (JSPUtil.getParameter(request, prefix	+ "rct_cust_nm", length));
			String[] unidAmt = (JSPUtil.getParameter(request, prefix	+ "unid_amt", length));
			String[] unappAmt = (JSPUtil.getParameter(request, prefix	+ "unapp_amt", length));
			String[] rctCxlDt = (JSPUtil.getParameter(request, prefix	+ "rct_cxl_dt", length));
			String[] usrOfc = (JSPUtil.getParameter(request, prefix	+ "usr_ofc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rctTpCd = (JSPUtil.getParameter(request, prefix	+ "rct_tp_cd", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] bankChgAmt = (JSPUtil.getParameter(request, prefix	+ "bank_chg_amt", length));
			String[] rctNo = (JSPUtil.getParameter(request, prefix	+ "rct_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptListByChequeVO();
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (rfdAmt[i] != null)
					model.setRfdAmt(rfdAmt[i]);
				if (rctCxlRsnCd[i] != null)
					model.setRctCxlRsnCd(rctCxlRsnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctCurrCd[i] != null)
					model.setRctCurrCd(rctCurrCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (rctCustCd[i] != null)
					model.setRctCustCd(rctCustCd[i]);
				if (rctDpsDt[i] != null)
					model.setRctDpsDt(rctDpsDt[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				if (bankAcctSeq[i] != null)
					model.setBankAcctSeq(bankAcctSeq[i]);
				if (chqNo[i] != null)
					model.setChqNo(chqNo[i]);
				if (rctAmt[i] != null)
					model.setRctAmt(rctAmt[i]);
				if (rctRmk[i] != null)
					model.setRctRmk(rctRmk[i]);
				if (rctCustNm[i] != null)
					model.setRctCustNm(rctCustNm[i]);
				if (unidAmt[i] != null)
					model.setUnidAmt(unidAmt[i]);
				if (unappAmt[i] != null)
					model.setUnappAmt(unappAmt[i]);
				if (rctCxlDt[i] != null)
					model.setRctCxlDt(rctCxlDt[i]);
				if (usrOfc[i] != null)
					model.setUsrOfc(usrOfc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rctTpCd[i] != null)
					model.setRctTpCd(rctTpCd[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (bankChgAmt[i] != null)
					model.setBankChgAmt(bankChgAmt[i]);
				if (rctNo[i] != null)
					model.setRctNo(rctNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptListByChequeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptListByChequeVO[]
	 */
	public ReceiptListByChequeVO[] getReceiptListByChequeVOs(){
		ReceiptListByChequeVO[] vos = (ReceiptListByChequeVO[])models.toArray(new ReceiptListByChequeVO[models.size()]);
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
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfdAmt = this.rfdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlRsnCd = this.rctCxlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd = this.rctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCd = this.rctCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDt = this.rctDpsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctSeq = this.bankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chqNo = this.chqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt = this.rctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRmk = this.rctRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustNm = this.rctCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unidAmt = this.unidAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unappAmt = this.unappAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlDt = this.rctCxlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfc = this.usrOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd = this.rctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankChgAmt = this.bankChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo = this.rctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
