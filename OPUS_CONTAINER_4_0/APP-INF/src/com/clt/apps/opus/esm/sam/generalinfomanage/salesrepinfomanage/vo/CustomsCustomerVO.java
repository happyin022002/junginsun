/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomsCustomerVO.java
*@FileTitle : CustomsCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.21 이창원 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이창원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomsCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomsCustomerVO> models = new ArrayList<CustomsCustomerVO>();
	
	/* Column Info */
	private String indivCorpDivCd = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String primarySrepCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String srepPrmryFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomsCustomerVO() {}

	public CustomsCustomerVO(String ibflag, String pagerows, String primarySrepCd, String customerCode, String custCd, String custLglEngNm, String locCd, String phnNo, String indivCorpDivCd, String srepPrmryFlg, String srepCd, String ofcCd, String custCntCd, String custSeq, String srepNm, String usrId, String userId) {
		this.indivCorpDivCd = indivCorpDivCd;
		this.phnNo = phnNo;
		this.primarySrepCd = primarySrepCd;
		this.custSeq = custSeq;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.srepPrmryFlg = srepPrmryFlg;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.usrId = usrId;
		this.srepNm = srepNm;
		this.custCd = custCd;
		this.userId = userId;
		this.customerCode = customerCode;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("primary_srep_cd", getPrimarySrepCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("srep_prmry_flg", getSrepPrmryFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("primary_srep_cd", "primarySrepCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("srep_prmry_flg", "srepPrmryFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return indivCorpDivCd
	 */
	public String getIndivCorpDivCd() {
		return this.indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return primarySrepCd
	 */
	public String getPrimarySrepCd() {
		return this.primarySrepCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return srepPrmryFlg
	 */
	public String getSrepPrmryFlg() {
		return this.srepPrmryFlg;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param indivCorpDivCd
	 */
	public void setIndivCorpDivCd(String indivCorpDivCd) {
		this.indivCorpDivCd = indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param primarySrepCd
	 */
	public void setPrimarySrepCd(String primarySrepCd) {
		this.primarySrepCd = primarySrepCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param srepPrmryFlg
	 */
	public void setSrepPrmryFlg(String srepPrmryFlg) {
		this.srepPrmryFlg = srepPrmryFlg;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setIndivCorpDivCd(JSPUtil.getParameter(request, prefix + "indiv_corp_div_cd", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setPrimarySrepCd(JSPUtil.getParameter(request, prefix + "primary_srep_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setSrepPrmryFlg(JSPUtil.getParameter(request, prefix + "srep_prmry_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomsCustomerVO[]
	 */
	public CustomsCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomsCustomerVO[]
	 */
	public CustomsCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomsCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] primarySrepCd = (JSPUtil.getParameter(request, prefix	+ "primary_srep_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] srepPrmryFlg = (JSPUtil.getParameter(request, prefix	+ "srep_prmry_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomsCustomerVO();
				if (indivCorpDivCd[i] != null)
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (primarySrepCd[i] != null)
					model.setPrimarySrepCd(primarySrepCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (srepPrmryFlg[i] != null)
					model.setSrepPrmryFlg(srepPrmryFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomsCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomsCustomerVO[]
	 */
	public CustomsCustomerVO[] getCustomsCustomerVOs(){
		CustomsCustomerVO[] vos = (CustomsCustomerVO[])models.toArray(new CustomsCustomerVO[models.size()]);
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
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.primarySrepCd = this.primarySrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepPrmryFlg = this.srepPrmryFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
