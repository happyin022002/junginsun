/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BankBalanceByOfficeVO.java
*@FileTitle : BankBalanceByOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

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

public class BankBalanceByOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BankBalanceByOfficeVO> models = new ArrayList<BankBalanceByOfficeVO>();
	
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String bankAcctTpSubNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String bankStmtDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String difference = null;
	/* Column Info */
	private String bgnBalAmt = null;
	/* Column Info */
	private String ctrlTtlRctAmt = null;
	/* Column Info */
	private String ctrlTtlPayAmt = null;
	/* Column Info */
	private String bankBrncNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String ttlRctAmt = null;
	/* Column Info */
	private String bankAcctTpMnNm = null;
	/* Column Info */
	private String ctrlEndgBalAmt = null;
	/* Column Info */
	private String ttlPayAmt = null;
	/* Column Info */
	private String endgBalAmt = null;
	/* Column Info */
	private String ctrlBgnBalAmt = null;
	/* Column Info */
	private String bankAcctNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BankBalanceByOfficeVO() {}

	public BankBalanceByOfficeVO(String ibflag, String pagerows, String bankNm, String bankBrncNm, String bankAcctNo, String bankAcctNm, String currCd, String bgnBalAmt, String ttlRctAmt, String ttlPayAmt, String endgBalAmt, String ctrlBgnBalAmt, String ctrlTtlRctAmt, String ctrlTtlPayAmt, String ctrlEndgBalAmt, String difference, String bankStmtDesc, String bankAcctTpMnNm, String bankAcctTpSubNm) {
		this.bankAcctNo = bankAcctNo;
		this.bankAcctTpSubNm = bankAcctTpSubNm;
		this.currCd = currCd;
		this.bankStmtDesc = bankStmtDesc;
		this.pagerows = pagerows;
		this.difference = difference;
		this.bgnBalAmt = bgnBalAmt;
		this.ctrlTtlRctAmt = ctrlTtlRctAmt;
		this.ctrlTtlPayAmt = ctrlTtlPayAmt;
		this.bankBrncNm = bankBrncNm;
		this.ibflag = ibflag;
		this.bankNm = bankNm;
		this.ttlRctAmt = ttlRctAmt;
		this.bankAcctTpMnNm = bankAcctTpMnNm;
		this.ctrlEndgBalAmt = ctrlEndgBalAmt;
		this.ttlPayAmt = ttlPayAmt;
		this.endgBalAmt = endgBalAmt;
		this.ctrlBgnBalAmt = ctrlBgnBalAmt;
		this.bankAcctNm = bankAcctNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("bank_acct_tp_sub_nm", getBankAcctTpSubNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bank_stmt_desc", getBankStmtDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("difference", getDifference());
		this.hashColumns.put("bgn_bal_amt", getBgnBalAmt());
		this.hashColumns.put("ctrl_ttl_rct_amt", getCtrlTtlRctAmt());
		this.hashColumns.put("ctrl_ttl_pay_amt", getCtrlTtlPayAmt());
		this.hashColumns.put("bank_brnc_nm", getBankBrncNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("ttl_rct_amt", getTtlRctAmt());
		this.hashColumns.put("bank_acct_tp_mn_nm", getBankAcctTpMnNm());
		this.hashColumns.put("ctrl_endg_bal_amt", getCtrlEndgBalAmt());
		this.hashColumns.put("ttl_pay_amt", getTtlPayAmt());
		this.hashColumns.put("endg_bal_amt", getEndgBalAmt());
		this.hashColumns.put("ctrl_bgn_bal_amt", getCtrlBgnBalAmt());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("bank_acct_tp_sub_nm", "bankAcctTpSubNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bank_stmt_desc", "bankStmtDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("difference", "difference");
		this.hashFields.put("bgn_bal_amt", "bgnBalAmt");
		this.hashFields.put("ctrl_ttl_rct_amt", "ctrlTtlRctAmt");
		this.hashFields.put("ctrl_ttl_pay_amt", "ctrlTtlPayAmt");
		this.hashFields.put("bank_brnc_nm", "bankBrncNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("ttl_rct_amt", "ttlRctAmt");
		this.hashFields.put("bank_acct_tp_mn_nm", "bankAcctTpMnNm");
		this.hashFields.put("ctrl_endg_bal_amt", "ctrlEndgBalAmt");
		this.hashFields.put("ttl_pay_amt", "ttlPayAmt");
		this.hashFields.put("endg_bal_amt", "endgBalAmt");
		this.hashFields.put("ctrl_bgn_bal_amt", "ctrlBgnBalAmt");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
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
	 * @return bankAcctTpSubNm
	 */
	public String getBankAcctTpSubNm() {
		return this.bankAcctTpSubNm;
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
	 * @return bankStmtDesc
	 */
	public String getBankStmtDesc() {
		return this.bankStmtDesc;
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
	 * @return difference
	 */
	public String getDifference() {
		return this.difference;
	}
	
	/**
	 * Column Info
	 * @return bgnBalAmt
	 */
	public String getBgnBalAmt() {
		return this.bgnBalAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrlTtlRctAmt
	 */
	public String getCtrlTtlRctAmt() {
		return this.ctrlTtlRctAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrlTtlPayAmt
	 */
	public String getCtrlTtlPayAmt() {
		return this.ctrlTtlPayAmt;
	}
	
	/**
	 * Column Info
	 * @return bankBrncNm
	 */
	public String getBankBrncNm() {
		return this.bankBrncNm;
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
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}
	
	/**
	 * Column Info
	 * @return ttlRctAmt
	 */
	public String getTtlRctAmt() {
		return this.ttlRctAmt;
	}
	
	/**
	 * Column Info
	 * @return bankAcctTpMnNm
	 */
	public String getBankAcctTpMnNm() {
		return this.bankAcctTpMnNm;
	}
	
	/**
	 * Column Info
	 * @return ctrlEndgBalAmt
	 */
	public String getCtrlEndgBalAmt() {
		return this.ctrlEndgBalAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlPayAmt
	 */
	public String getTtlPayAmt() {
		return this.ttlPayAmt;
	}
	
	/**
	 * Column Info
	 * @return endgBalAmt
	 */
	public String getEndgBalAmt() {
		return this.endgBalAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrlBgnBalAmt
	 */
	public String getCtrlBgnBalAmt() {
		return this.ctrlBgnBalAmt;
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
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpSubNm
	 */
	public void setBankAcctTpSubNm(String bankAcctTpSubNm) {
		this.bankAcctTpSubNm = bankAcctTpSubNm;
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
	 * @param bankStmtDesc
	 */
	public void setBankStmtDesc(String bankStmtDesc) {
		this.bankStmtDesc = bankStmtDesc;
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
	 * @param difference
	 */
	public void setDifference(String difference) {
		this.difference = difference;
	}
	
	/**
	 * Column Info
	 * @param bgnBalAmt
	 */
	public void setBgnBalAmt(String bgnBalAmt) {
		this.bgnBalAmt = bgnBalAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrlTtlRctAmt
	 */
	public void setCtrlTtlRctAmt(String ctrlTtlRctAmt) {
		this.ctrlTtlRctAmt = ctrlTtlRctAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrlTtlPayAmt
	 */
	public void setCtrlTtlPayAmt(String ctrlTtlPayAmt) {
		this.ctrlTtlPayAmt = ctrlTtlPayAmt;
	}
	
	/**
	 * Column Info
	 * @param bankBrncNm
	 */
	public void setBankBrncNm(String bankBrncNm) {
		this.bankBrncNm = bankBrncNm;
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
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}
	
	/**
	 * Column Info
	 * @param ttlRctAmt
	 */
	public void setTtlRctAmt(String ttlRctAmt) {
		this.ttlRctAmt = ttlRctAmt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctTpMnNm
	 */
	public void setBankAcctTpMnNm(String bankAcctTpMnNm) {
		this.bankAcctTpMnNm = bankAcctTpMnNm;
	}
	
	/**
	 * Column Info
	 * @param ctrlEndgBalAmt
	 */
	public void setCtrlEndgBalAmt(String ctrlEndgBalAmt) {
		this.ctrlEndgBalAmt = ctrlEndgBalAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlPayAmt
	 */
	public void setTtlPayAmt(String ttlPayAmt) {
		this.ttlPayAmt = ttlPayAmt;
	}
	
	/**
	 * Column Info
	 * @param endgBalAmt
	 */
	public void setEndgBalAmt(String endgBalAmt) {
		this.endgBalAmt = endgBalAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrlBgnBalAmt
	 */
	public void setCtrlBgnBalAmt(String ctrlBgnBalAmt) {
		this.ctrlBgnBalAmt = ctrlBgnBalAmt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNm
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
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
		setBankAcctTpSubNm(JSPUtil.getParameter(request, prefix + "bank_acct_tp_sub_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setBankStmtDesc(JSPUtil.getParameter(request, prefix + "bank_stmt_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDifference(JSPUtil.getParameter(request, prefix + "difference", ""));
		setBgnBalAmt(JSPUtil.getParameter(request, prefix + "bgn_bal_amt", ""));
		setCtrlTtlRctAmt(JSPUtil.getParameter(request, prefix + "ctrl_ttl_rct_amt", ""));
		setCtrlTtlPayAmt(JSPUtil.getParameter(request, prefix + "ctrl_ttl_pay_amt", ""));
		setBankBrncNm(JSPUtil.getParameter(request, prefix + "bank_brnc_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setTtlRctAmt(JSPUtil.getParameter(request, prefix + "ttl_rct_amt", ""));
		setBankAcctTpMnNm(JSPUtil.getParameter(request, prefix + "bank_acct_tp_mn_nm", ""));
		setCtrlEndgBalAmt(JSPUtil.getParameter(request, prefix + "ctrl_endg_bal_amt", ""));
		setTtlPayAmt(JSPUtil.getParameter(request, prefix + "ttl_pay_amt", ""));
		setEndgBalAmt(JSPUtil.getParameter(request, prefix + "endg_bal_amt", ""));
		setCtrlBgnBalAmt(JSPUtil.getParameter(request, prefix + "ctrl_bgn_bal_amt", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankBalanceByOfficeVO[]
	 */
	public BankBalanceByOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BankBalanceByOfficeVO[]
	 */
	public BankBalanceByOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BankBalanceByOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] bankAcctTpSubNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_sub_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] bankStmtDesc = (JSPUtil.getParameter(request, prefix	+ "bank_stmt_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] difference = (JSPUtil.getParameter(request, prefix	+ "difference", length));
			String[] bgnBalAmt = (JSPUtil.getParameter(request, prefix	+ "bgn_bal_amt", length));
			String[] ctrlTtlRctAmt = (JSPUtil.getParameter(request, prefix	+ "ctrl_ttl_rct_amt", length));
			String[] ctrlTtlPayAmt = (JSPUtil.getParameter(request, prefix	+ "ctrl_ttl_pay_amt", length));
			String[] bankBrncNm = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] ttlRctAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_rct_amt", length));
			String[] bankAcctTpMnNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp_mn_nm", length));
			String[] ctrlEndgBalAmt = (JSPUtil.getParameter(request, prefix	+ "ctrl_endg_bal_amt", length));
			String[] ttlPayAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_pay_amt", length));
			String[] endgBalAmt = (JSPUtil.getParameter(request, prefix	+ "endg_bal_amt", length));
			String[] ctrlBgnBalAmt = (JSPUtil.getParameter(request, prefix	+ "ctrl_bgn_bal_amt", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BankBalanceByOfficeVO();
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (bankAcctTpSubNm[i] != null)
					model.setBankAcctTpSubNm(bankAcctTpSubNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (bankStmtDesc[i] != null)
					model.setBankStmtDesc(bankStmtDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (difference[i] != null)
					model.setDifference(difference[i]);
				if (bgnBalAmt[i] != null)
					model.setBgnBalAmt(bgnBalAmt[i]);
				if (ctrlTtlRctAmt[i] != null)
					model.setCtrlTtlRctAmt(ctrlTtlRctAmt[i]);
				if (ctrlTtlPayAmt[i] != null)
					model.setCtrlTtlPayAmt(ctrlTtlPayAmt[i]);
				if (bankBrncNm[i] != null)
					model.setBankBrncNm(bankBrncNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (ttlRctAmt[i] != null)
					model.setTtlRctAmt(ttlRctAmt[i]);
				if (bankAcctTpMnNm[i] != null)
					model.setBankAcctTpMnNm(bankAcctTpMnNm[i]);
				if (ctrlEndgBalAmt[i] != null)
					model.setCtrlEndgBalAmt(ctrlEndgBalAmt[i]);
				if (ttlPayAmt[i] != null)
					model.setTtlPayAmt(ttlPayAmt[i]);
				if (endgBalAmt[i] != null)
					model.setEndgBalAmt(endgBalAmt[i]);
				if (ctrlBgnBalAmt[i] != null)
					model.setCtrlBgnBalAmt(ctrlBgnBalAmt[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBankBalanceByOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BankBalanceByOfficeVO[]
	 */
	public BankBalanceByOfficeVO[] getBankBalanceByOfficeVOs(){
		BankBalanceByOfficeVO[] vos = (BankBalanceByOfficeVO[])models.toArray(new BankBalanceByOfficeVO[models.size()]);
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
		this.bankAcctTpSubNm = this.bankAcctTpSubNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankStmtDesc = this.bankStmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difference = this.difference .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bgnBalAmt = this.bgnBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlTtlRctAmt = this.ctrlTtlRctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlTtlPayAmt = this.ctrlTtlPayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncNm = this.bankBrncNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRctAmt = this.ttlRctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTpMnNm = this.bankAcctTpMnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlEndgBalAmt = this.ctrlEndgBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPayAmt = this.ttlPayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endgBalAmt = this.endgBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlBgnBalAmt = this.ctrlBgnBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
