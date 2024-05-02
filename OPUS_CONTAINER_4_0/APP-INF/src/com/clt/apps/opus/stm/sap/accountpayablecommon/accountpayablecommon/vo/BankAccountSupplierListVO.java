/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BankAccountSupplierListVO.java
*@FileTitle : BankAccountSupplierListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.12  
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

public class BankAccountSupplierListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BankAccountSupplierListVO> models = new ArrayList<BankAccountSupplierListVO>();
	
	/* Column Info */
	private String bankAcctSeq = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cntcAreaCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String ibanNo = null;
	/* Column Info */
	private String bankBrncSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inactDt = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bankAcctVndrSeq = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String attrCtnt6 = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String cntcAreaNm = null;
	/* Column Info */
	private String bankAcctNm = null;
	/* Column Info */
	private String bankAcctPrioCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BankAccountSupplierListVO() {}

	public BankAccountSupplierListVO(String ibflag, String pagerows, String bankAcctSeq, String bankAcctNo, String bankAcctNm, String bankBrncSeq, String currCd, String bankAcctVndrSeq, String vndrLglEngNm, String bankAcctPrioCd, String inactDt, String attrCtnt5, String attrCtnt6, String ibanNo, String attrCtnt2, String cntcAreaCd, String cntcAreaNm, String attrCtnt7, String usrId) {
		this.bankAcctSeq = bankAcctSeq;
		this.bankAcctNo = bankAcctNo;
		this.currCd = currCd;
		this.cntcAreaCd = cntcAreaCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.ibanNo = ibanNo;
		this.bankBrncSeq = bankBrncSeq;
		this.pagerows = pagerows;
		this.inactDt = inactDt;
		this.attrCtnt2 = attrCtnt2;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.bankAcctVndrSeq = bankAcctVndrSeq;
		this.attrCtnt5 = attrCtnt5;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
		this.cntcAreaNm = cntcAreaNm;
		this.bankAcctNm = bankAcctNm;
		this.bankAcctPrioCd = bankAcctPrioCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntc_area_cd", getCntcAreaCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("iban_no", getIbanNo());
		this.hashColumns.put("bank_brnc_seq", getBankBrncSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inact_dt", getInactDt());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bank_acct_vndr_seq", getBankAcctVndrSeq());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("cntc_area_nm", getCntcAreaNm());
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());
		this.hashColumns.put("bank_acct_prio_cd", getBankAcctPrioCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntc_area_cd", "cntcAreaCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("iban_no", "ibanNo");
		this.hashFields.put("bank_brnc_seq", "bankBrncSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inact_dt", "inactDt");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bank_acct_vndr_seq", "bankAcctVndrSeq");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("cntc_area_nm", "cntcAreaNm");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("bank_acct_prio_cd", "bankAcctPrioCd");
		return this.hashFields;
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
	 * @return cntcAreaCd
	 */
	public String getCntcAreaCd() {
		return this.cntcAreaCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return ibanNo
	 */
	public String getIbanNo() {
		return this.ibanNo;
	}
	
	/**
	 * Column Info
	 * @return bankBrncSeq
	 */
	public String getBankBrncSeq() {
		return this.bankBrncSeq;
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
	 * @return inactDt
	 */
	public String getInactDt() {
		return this.inactDt;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return bankAcctVndrSeq
	 */
	public String getBankAcctVndrSeq() {
		return this.bankAcctVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt5
	 */
	public String getAttrCtnt5() {
		return this.attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt6
	 */
	public String getAttrCtnt6() {
		return this.attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt7
	 */
	public String getAttrCtnt7() {
		return this.attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return cntcAreaNm
	 */
	public String getCntcAreaNm() {
		return this.cntcAreaNm;
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
	 * @return bankAcctPrioCd
	 */
	public String getBankAcctPrioCd() {
		return this.bankAcctPrioCd;
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
	 * @param cntcAreaCd
	 */
	public void setCntcAreaCd(String cntcAreaCd) {
		this.cntcAreaCd = cntcAreaCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param ibanNo
	 */
	public void setIbanNo(String ibanNo) {
		this.ibanNo = ibanNo;
	}
	
	/**
	 * Column Info
	 * @param bankBrncSeq
	 */
	public void setBankBrncSeq(String bankBrncSeq) {
		this.bankBrncSeq = bankBrncSeq;
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
	 * @param inactDt
	 */
	public void setInactDt(String inactDt) {
		this.inactDt = inactDt;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param bankAcctVndrSeq
	 */
	public void setBankAcctVndrSeq(String bankAcctVndrSeq) {
		this.bankAcctVndrSeq = bankAcctVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt5
	 */
	public void setAttrCtnt5(String attrCtnt5) {
		this.attrCtnt5 = attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt6
	 */
	public void setAttrCtnt6(String attrCtnt6) {
		this.attrCtnt6 = attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt7
	 */
	public void setAttrCtnt7(String attrCtnt7) {
		this.attrCtnt7 = attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param cntcAreaNm
	 */
	public void setCntcAreaNm(String cntcAreaNm) {
		this.cntcAreaNm = cntcAreaNm;
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
	 * @param bankAcctPrioCd
	 */
	public void setBankAcctPrioCd(String bankAcctPrioCd) {
		this.bankAcctPrioCd = bankAcctPrioCd;
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
		setBankAcctSeq(JSPUtil.getParameter(request, prefix + "bank_acct_seq", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCntcAreaCd(JSPUtil.getParameter(request, prefix + "cntc_area_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setIbanNo(JSPUtil.getParameter(request, prefix + "iban_no", ""));
		setBankBrncSeq(JSPUtil.getParameter(request, prefix + "bank_brnc_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInactDt(JSPUtil.getParameter(request, prefix + "inact_dt", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBankAcctVndrSeq(JSPUtil.getParameter(request, prefix + "bank_acct_vndr_seq", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request, prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setCntcAreaNm(JSPUtil.getParameter(request, prefix + "cntc_area_nm", ""));
		setBankAcctNm(JSPUtil.getParameter(request, prefix + "bank_acct_nm", ""));
		setBankAcctPrioCd(JSPUtil.getParameter(request, prefix + "bank_acct_prio_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankAccountSupplierListVO[]
	 */
	public BankAccountSupplierListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BankAccountSupplierListVO[]
	 */
	public BankAccountSupplierListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BankAccountSupplierListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_seq", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cntcAreaCd = (JSPUtil.getParameter(request, prefix	+ "cntc_area_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] ibanNo = (JSPUtil.getParameter(request, prefix	+ "iban_no", length));
			String[] bankBrncSeq = (JSPUtil.getParameter(request, prefix	+ "bank_brnc_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inactDt = (JSPUtil.getParameter(request, prefix	+ "inact_dt", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bankAcctVndrSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_vndr_seq", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] attrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt6", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] cntcAreaNm = (JSPUtil.getParameter(request, prefix	+ "cntc_area_nm", length));
			String[] bankAcctNm = (JSPUtil.getParameter(request, prefix	+ "bank_acct_nm", length));
			String[] bankAcctPrioCd = (JSPUtil.getParameter(request, prefix	+ "bank_acct_prio_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BankAccountSupplierListVO();
				if (bankAcctSeq[i] != null)
					model.setBankAcctSeq(bankAcctSeq[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cntcAreaCd[i] != null)
					model.setCntcAreaCd(cntcAreaCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (ibanNo[i] != null)
					model.setIbanNo(ibanNo[i]);
				if (bankBrncSeq[i] != null)
					model.setBankBrncSeq(bankBrncSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inactDt[i] != null)
					model.setInactDt(inactDt[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bankAcctVndrSeq[i] != null)
					model.setBankAcctVndrSeq(bankAcctVndrSeq[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (attrCtnt6[i] != null)
					model.setAttrCtnt6(attrCtnt6[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (cntcAreaNm[i] != null)
					model.setCntcAreaNm(cntcAreaNm[i]);
				if (bankAcctNm[i] != null)
					model.setBankAcctNm(bankAcctNm[i]);
				if (bankAcctPrioCd[i] != null)
					model.setBankAcctPrioCd(bankAcctPrioCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBankAccountSupplierListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BankAccountSupplierListVO[]
	 */
	public BankAccountSupplierListVO[] getBankAccountSupplierListVOs(){
		BankAccountSupplierListVO[] vos = (BankAccountSupplierListVO[])models.toArray(new BankAccountSupplierListVO[models.size()]);
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
		this.bankAcctSeq = this.bankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcAreaCd = this.cntcAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibanNo = this.ibanNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncSeq = this.bankBrncSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactDt = this.inactDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctVndrSeq = this.bankAcctVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 = this.attrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcAreaNm = this.cntcAreaNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm = this.bankAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctPrioCd = this.bankAcctPrioCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
