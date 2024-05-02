/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptListByBankVO.java
*@FileTitle : ReceiptListByBankVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.28  
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

public class ReceiptListByBankVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptListByBankVO> models = new ArrayList<ReceiptListByBankVO>();
	
	/* Column Info */
	private String uniAmt = null;
	/* Column Info */
	private String rctCurrCd = null;
	/* Column Info */
	private String rctOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String refAmt = null;
	/* Column Info */
	private String rctAmt = null;
	/* Column Info */
	private String bouAmt = null;
	/* Column Info */
	private String unaAmt = null;
	/* Column Info */
	private String bankAcctNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptListByBankVO() {}

	public ReceiptListByBankVO(String ibflag, String pagerows, String rctOfcCd, String bankAcctNm, String rctCurrCd, String rctAmt, String unaAmt, String uniAmt, String bouAmt, String refAmt) {
		this.uniAmt = uniAmt;
		this.rctCurrCd = rctCurrCd;
		this.rctOfcCd = rctOfcCd;
		this.ibflag = ibflag;
		this.refAmt = refAmt;
		this.rctAmt = rctAmt;
		this.bouAmt = bouAmt;
		this.unaAmt = unaAmt;
		this.bankAcctNm = bankAcctNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("uni_amt", getUniAmt());
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ref_amt", getRefAmt());
		this.hashColumns.put("rct_amt", getRctAmt());
		this.hashColumns.put("bou_amt", getBouAmt());
		this.hashColumns.put("una_amt", getUnaAmt());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("uni_amt", "uniAmt");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ref_amt", "refAmt");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("bou_amt", "bouAmt");
		this.hashFields.put("una_amt", "unaAmt");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return uniAmt
	 */
	public String getUniAmt() {
		return this.uniAmt;
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
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
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
	 * @return refAmt
	 */
	public String getRefAmt() {
		return this.refAmt;
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
	 * @return bouAmt
	 */
	public String getBouAmt() {
		return this.bouAmt;
	}
	
	/**
	 * Column Info
	 * @return unaAmt
	 */
	public String getUnaAmt() {
		return this.unaAmt;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNm
	 */
	public String getBankAcctNm() {
		return this.bankAcctNm;
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
	 * @param uniAmt
	 */
	public void setUniAmt(String uniAmt) {
		this.uniAmt = uniAmt;
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
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
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
	 * @param refAmt
	 */
	public void setRefAmt(String refAmt) {
		this.refAmt = refAmt;
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
	 * @param bouAmt
	 */
	public void setBouAmt(String bouAmt) {
		this.bouAmt = bouAmt;
	}
	
	/**
	 * Column Info
	 * @param unaAmt
	 */
	public void setUnaAmt(String unaAmt) {
		this.unaAmt = unaAmt;
	}
	
	/**
	 * Column Info
	 * @param bankAcctNm
	 */
	public void setBankAcctNm(String bankAcctNm) {
		this.bankAcctNm = bankAcctNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setUniAmt(JSPUtil.getParameter(request, prefix + "uni_amt", ""));
		setRctCurrCd(JSPUtil.getParameter(request, prefix + "rct_curr_cd", ""));
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRefAmt(JSPUtil.getParameter(request, prefix + "ref_amt", ""));
		setRctAmt(JSPUtil.getParameter(request, prefix + "rct_amt", ""));
		setBouAmt(JSPUtil.getParameter(request, prefix + "bou_amt", ""));
		setUnaAmt(JSPUtil.getParameter(request, prefix + "una_amt", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptListByBankVO[]
	 */
	public ReceiptListByBankVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptListByBankVO[]
	 */
	public ReceiptListByBankVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptListByBankVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] uniAmt = (JSPUtil.getParameter(request, prefix	+ "uni_amt", length));
			String[] rctCurrCd = (JSPUtil.getParameter(request, prefix	+ "rct_curr_cd", length));
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] refAmt = (JSPUtil.getParameter(request, prefix	+ "ref_amt", length));
			String[] rctAmt = (JSPUtil.getParameter(request, prefix	+ "rct_amt", length));
			String[] bouAmt = (JSPUtil.getParameter(request, prefix	+ "bou_amt", length));
			String[] unaAmt = (JSPUtil.getParameter(request, prefix	+ "una_amt", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptListByBankVO();
				if (uniAmt[i] != null)
					model.setUniAmt(uniAmt[i]);
				if (rctCurrCd[i] != null)
					model.setRctCurrCd(rctCurrCd[i]);
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (refAmt[i] != null)
					model.setRefAmt(refAmt[i]);
				if (rctAmt[i] != null)
					model.setRctAmt(rctAmt[i]);
				if (bouAmt[i] != null)
					model.setBouAmt(bouAmt[i]);
				if (unaAmt[i] != null)
					model.setUnaAmt(unaAmt[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptListByBankVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptListByBankVO[]
	 */
	public ReceiptListByBankVO[] getReceiptListByBankVOs(){
		ReceiptListByBankVO[] vos = (ReceiptListByBankVO[])models.toArray(new ReceiptListByBankVO[models.size()]);
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
		this.uniAmt = this.uniAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd = this.rctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refAmt = this.refAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt = this.rctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bouAmt = this.bouAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unaAmt = this.unaAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
