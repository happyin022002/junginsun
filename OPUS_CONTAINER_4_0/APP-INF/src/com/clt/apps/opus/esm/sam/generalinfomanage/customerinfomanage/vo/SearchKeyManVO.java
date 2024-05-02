/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchKeyManVO.java
*@FileTitle : SearchKeyManVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.02
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.03.02 서미진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchKeyManVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchKeyManVO> models = new ArrayList<SearchKeyManVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String kmanOfcPhnNo = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String jbTitRmk = null;
	/* Column Info */
	private String kmanGndCd = null;
	/* Column Info */
	private String kmanN1stNm = null;
	/* Column Info */
	private String kmanEml = null;
	/* Column Info */
	private String kmanOfcFaxNo = null;
	/* Column Info */
	private String custKmanSeq = null;
	/* Column Info */
	private String kmanLstNm = null;
	/* Column Info */
	private String intlPhnNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchKeyManVO() {}

	public SearchKeyManVO(String ibflag, String pagerows, String custKmanSeq, String kmanN1stNm, String kmanLstNm, String kmanGndCd, String jbTitRmk, String intlPhnNo, String kmanOfcPhnNo, String kmanOfcFaxNo, String kmanEml, String customerCode) {
		this.ibflag = ibflag;
		this.kmanOfcPhnNo = kmanOfcPhnNo;
		this.customerCode = customerCode;
		this.jbTitRmk = jbTitRmk;
		this.kmanGndCd = kmanGndCd;
		this.kmanN1stNm = kmanN1stNm;
		this.kmanEml = kmanEml;
		this.kmanOfcFaxNo = kmanOfcFaxNo;
		this.custKmanSeq = custKmanSeq;
		this.kmanLstNm = kmanLstNm;
		this.intlPhnNo = intlPhnNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kman_ofc_phn_no", getKmanOfcPhnNo());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("jb_tit_rmk", getJbTitRmk());
		this.hashColumns.put("kman_gnd_cd", getKmanGndCd());
		this.hashColumns.put("kman_n1st_nm", getKmanN1stNm());
		this.hashColumns.put("kman_eml", getKmanEml());
		this.hashColumns.put("kman_ofc_fax_no", getKmanOfcFaxNo());
		this.hashColumns.put("cust_kman_seq", getCustKmanSeq());
		this.hashColumns.put("kman_lst_nm", getKmanLstNm());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kman_ofc_phn_no", "kmanOfcPhnNo");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("jb_tit_rmk", "jbTitRmk");
		this.hashFields.put("kman_gnd_cd", "kmanGndCd");
		this.hashFields.put("kman_n1st_nm", "kmanN1stNm");
		this.hashFields.put("kman_eml", "kmanEml");
		this.hashFields.put("kman_ofc_fax_no", "kmanOfcFaxNo");
		this.hashFields.put("cust_kman_seq", "custKmanSeq");
		this.hashFields.put("kman_lst_nm", "kmanLstNm");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return kmanOfcPhnNo
	 */
	public String getKmanOfcPhnNo() {
		return this.kmanOfcPhnNo;
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
	 * @return jbTitRmk
	 */
	public String getJbTitRmk() {
		return this.jbTitRmk;
	}
	
	/**
	 * Column Info
	 * @return kmanGndCd
	 */
	public String getKmanGndCd() {
		return this.kmanGndCd;
	}
	
	/**
	 * Column Info
	 * @return kmanN1stNm
	 */
	public String getKmanN1stNm() {
		return this.kmanN1stNm;
	}
	
	/**
	 * Column Info
	 * @return kmanEml
	 */
	public String getKmanEml() {
		return this.kmanEml;
	}
	
	/**
	 * Column Info
	 * @return kmanOfcFaxNo
	 */
	public String getKmanOfcFaxNo() {
		return this.kmanOfcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return custKmanSeq
	 */
	public String getCustKmanSeq() {
		return this.custKmanSeq;
	}
	
	/**
	 * Column Info
	 * @return kmanLstNm
	 */
	public String getKmanLstNm() {
		return this.kmanLstNm;
	}
	
	/**
	 * Column Info
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param kmanOfcPhnNo
	 */
	public void setKmanOfcPhnNo(String kmanOfcPhnNo) {
		this.kmanOfcPhnNo = kmanOfcPhnNo;
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
	 * @param jbTitRmk
	 */
	public void setJbTitRmk(String jbTitRmk) {
		this.jbTitRmk = jbTitRmk;
	}
	
	/**
	 * Column Info
	 * @param kmanGndCd
	 */
	public void setKmanGndCd(String kmanGndCd) {
		this.kmanGndCd = kmanGndCd;
	}
	
	/**
	 * Column Info
	 * @param kmanN1stNm
	 */
	public void setKmanN1stNm(String kmanN1stNm) {
		this.kmanN1stNm = kmanN1stNm;
	}
	
	/**
	 * Column Info
	 * @param kmanEml
	 */
	public void setKmanEml(String kmanEml) {
		this.kmanEml = kmanEml;
	}
	
	/**
	 * Column Info
	 * @param kmanOfcFaxNo
	 */
	public void setKmanOfcFaxNo(String kmanOfcFaxNo) {
		this.kmanOfcFaxNo = kmanOfcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param custKmanSeq
	 */
	public void setCustKmanSeq(String custKmanSeq) {
		this.custKmanSeq = custKmanSeq;
	}
	
	/**
	 * Column Info
	 * @param kmanLstNm
	 */
	public void setKmanLstNm(String kmanLstNm) {
		this.kmanLstNm = kmanLstNm;
	}
	
	/**
	 * Column Info
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setKmanOfcPhnNo(JSPUtil.getParameter(request, prefix + "kman_ofc_phn_no", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setJbTitRmk(JSPUtil.getParameter(request, prefix + "jb_tit_rmk", ""));
		setKmanGndCd(JSPUtil.getParameter(request, prefix + "kman_gnd_cd", ""));
		setKmanN1stNm(JSPUtil.getParameter(request, prefix + "kman_n1st_nm", ""));
		setKmanEml(JSPUtil.getParameter(request, prefix + "kman_eml", ""));
		setKmanOfcFaxNo(JSPUtil.getParameter(request, prefix + "kman_ofc_fax_no", ""));
		setCustKmanSeq(JSPUtil.getParameter(request, prefix + "cust_kman_seq", ""));
		setKmanLstNm(JSPUtil.getParameter(request, prefix + "kman_lst_nm", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchKeyManVO[]
	 */
	public SearchKeyManVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchKeyManVO[]
	 */
	public SearchKeyManVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchKeyManVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] kmanOfcPhnNo = (JSPUtil.getParameter(request, prefix	+ "kman_ofc_phn_no", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] jbTitRmk = (JSPUtil.getParameter(request, prefix	+ "jb_tit_rmk", length));
			String[] kmanGndCd = (JSPUtil.getParameter(request, prefix	+ "kman_gnd_cd", length));
			String[] kmanN1stNm = (JSPUtil.getParameter(request, prefix	+ "kman_n1st_nm", length));
			String[] kmanEml = (JSPUtil.getParameter(request, prefix	+ "kman_eml", length));
			String[] kmanOfcFaxNo = (JSPUtil.getParameter(request, prefix	+ "kman_ofc_fax_no", length));
			String[] custKmanSeq = (JSPUtil.getParameter(request, prefix	+ "cust_kman_seq", length));
			String[] kmanLstNm = (JSPUtil.getParameter(request, prefix	+ "kman_lst_nm", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchKeyManVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (kmanOfcPhnNo[i] != null)
					model.setKmanOfcPhnNo(kmanOfcPhnNo[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (jbTitRmk[i] != null)
					model.setJbTitRmk(jbTitRmk[i]);
				if (kmanGndCd[i] != null)
					model.setKmanGndCd(kmanGndCd[i]);
				if (kmanN1stNm[i] != null)
					model.setKmanN1stNm(kmanN1stNm[i]);
				if (kmanEml[i] != null)
					model.setKmanEml(kmanEml[i]);
				if (kmanOfcFaxNo[i] != null)
					model.setKmanOfcFaxNo(kmanOfcFaxNo[i]);
				if (custKmanSeq[i] != null)
					model.setCustKmanSeq(custKmanSeq[i]);
				if (kmanLstNm[i] != null)
					model.setKmanLstNm(kmanLstNm[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchKeyManVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchKeyManVO[]
	 */
	public SearchKeyManVO[] getSearchKeyManVOs(){
		SearchKeyManVO[] vos = (SearchKeyManVO[])models.toArray(new SearchKeyManVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanOfcPhnNo = this.kmanOfcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbTitRmk = this.jbTitRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanGndCd = this.kmanGndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanN1stNm = this.kmanN1stNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanEml = this.kmanEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanOfcFaxNo = this.kmanOfcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custKmanSeq = this.custKmanSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanLstNm = this.kmanLstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
