/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APBankAccountByOfficeCondVO.java
*@FileTitle : APBankAccountByOfficeCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.01  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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

public class APBankAccountByOfficeCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APBankAccountByOfficeCondVO> models = new ArrayList<APBankAccountByOfficeCondVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bankAcctTp = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String inactFlag = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APBankAccountByOfficeCondVO() {}

	public APBankAccountByOfficeCondVO(String ibflag, String pagerows, String ofcCd, String ctrlOfcCd, String bankNm, String bankAcctTp, String inactFlag) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bankAcctTp = bankAcctTp;
		this.bankNm = bankNm;
		this.inactFlag = inactFlag;
		this.ctrlOfcCd = ctrlOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bank_acct_tp", getBankAcctTp());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("inact_flag", getInactFlag());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bank_acct_tp", "bankAcctTp");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("inact_flag", "inactFlag");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bankAcctTp
	 */
	public String getBankAcctTp() {
		return this.bankAcctTp;
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
	 * @return inactFlag
	 */
	public String getInactFlag() {
		return this.inactFlag;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bankAcctTp
	 */
	public void setBankAcctTp(String bankAcctTp) {
		this.bankAcctTp = bankAcctTp;
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
	 * @param inactFlag
	 */
	public void setInactFlag(String inactFlag) {
		this.inactFlag = inactFlag;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBankAcctTp(JSPUtil.getParameter(request, prefix + "bank_acct_tp", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setInactFlag(JSPUtil.getParameter(request, prefix + "inact_flag", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APBankAccountByOfficeCondVO[]
	 */
	public APBankAccountByOfficeCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APBankAccountByOfficeCondVO[]
	 */
	public APBankAccountByOfficeCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APBankAccountByOfficeCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bankAcctTp = (JSPUtil.getParameter(request, prefix	+ "bank_acct_tp", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] inactFlag = (JSPUtil.getParameter(request, prefix	+ "inact_flag", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new APBankAccountByOfficeCondVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bankAcctTp[i] != null)
					model.setBankAcctTp(bankAcctTp[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (inactFlag[i] != null)
					model.setInactFlag(inactFlag[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPBankAccountByOfficeCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APBankAccountByOfficeCondVO[]
	 */
	public APBankAccountByOfficeCondVO[] getAPBankAccountByOfficeCondVOs(){
		APBankAccountByOfficeCondVO[] vos = (APBankAccountByOfficeCondVO[])models.toArray(new APBankAccountByOfficeCondVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctTp = this.bankAcctTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactFlag = this.inactFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
