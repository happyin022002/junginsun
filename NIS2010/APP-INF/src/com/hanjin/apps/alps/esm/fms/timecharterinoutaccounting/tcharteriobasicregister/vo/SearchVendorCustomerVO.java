/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchVendorCustomerVO.java
*@FileTitle : SearchVendorCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.17
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.11.17 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVendorCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVendorCustomerVO> models = new ArrayList<SearchVendorCustomerVO>();
	
	/* Column Info */
	private String cdCnt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String cdSeq = null;
	/* Column Info */
	private String cdName = null;
	/* Column Info */
	private String taxRequired = null;
	/* Column Info */
	private String custSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String fletMgmtOwnrCustSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ownrSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fletMgmtOwnrVndrSeq = null;
	/* Column Info */
	private String fletOwnrTpCd = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVendorCustomerVO() {}

	public SearchVendorCustomerVO(String ibflag, String pagerows, String cdSeq, String cdName, String cdCnt, String custSeq, String vndrSeq, String custLglEngNm, String vndrLglEngNm, String ownrNm, String updUsrId, String custCntCd, String fletMgmtOwnrVndrSeq, String fletMgmtOwnrCustSeq, String taxRequired, String fletOwnrTpCd, String ownrSeq) {
		this.cdCnt = cdCnt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.cdSeq = cdSeq;
		this.cdName = cdName;
		this.taxRequired = taxRequired;
		this.custSeq = custSeq;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
		this.ibflag = ibflag;
		this.ownrSeq = ownrSeq;
		this.vndrSeq = vndrSeq;
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
		this.fletOwnrTpCd = fletOwnrTpCd;
		this.ownrNm = ownrNm;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cd_cnt", getCdCnt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cd_seq", getCdSeq());
		this.hashColumns.put("cd_name", getCdName());
		this.hashColumns.put("tax_required", getTaxRequired());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("flet_mgmt_ownr_cust_seq", getFletMgmtOwnrCustSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ownr_seq", getOwnrSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("flet_mgmt_ownr_vndr_seq", getFletMgmtOwnrVndrSeq());
		this.hashColumns.put("flet_ownr_tp_cd", getFletOwnrTpCd());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cd_cnt", "cdCnt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cd_seq", "cdSeq");
		this.hashFields.put("cd_name", "cdName");
		this.hashFields.put("tax_required", "taxRequired");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("flet_mgmt_ownr_cust_seq", "fletMgmtOwnrCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ownr_seq", "ownrSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("flet_mgmt_ownr_vndr_seq", "fletMgmtOwnrVndrSeq");
		this.hashFields.put("flet_ownr_tp_cd", "fletOwnrTpCd");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cdCnt
	 */
	public String getCdCnt() {
		return this.cdCnt;
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
	 * @return cdSeq
	 */
	public String getCdSeq() {
		return this.cdSeq;
	}
	
	/**
	 * Column Info
	 * @return cdName
	 */
	public String getCdName() {
		return this.cdName;
	}
	
	/**
	 * Column Info
	 * @return taxRequired
	 */
	public String getTaxRequired() {
		return this.taxRequired;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return fletMgmtOwnrCustSeq
	 */
	public String getFletMgmtOwnrCustSeq() {
		return this.fletMgmtOwnrCustSeq;
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
	 * @return ownrSeq
	 */
	public String getOwnrSeq() {
		return this.ownrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return fletMgmtOwnrVndrSeq
	 */
	public String getFletMgmtOwnrVndrSeq() {
		return this.fletMgmtOwnrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return fletOwnrTpCd
	 */
	public String getFletOwnrTpCd() {
		return this.fletOwnrTpCd;
	}
	
	/**
	 * Column Info
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param cdCnt
	 */
	public void setCdCnt(String cdCnt) {
		this.cdCnt = cdCnt;
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
	 * @param cdSeq
	 */
	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
	}
	
	/**
	 * Column Info
	 * @param cdName
	 */
	public void setCdName(String cdName) {
		this.cdName = cdName;
	}
	
	/**
	 * Column Info
	 * @param taxRequired
	 */
	public void setTaxRequired(String taxRequired) {
		this.taxRequired = taxRequired;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param fletMgmtOwnrCustSeq
	 */
	public void setFletMgmtOwnrCustSeq(String fletMgmtOwnrCustSeq) {
		this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
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
	 * @param ownrSeq
	 */
	public void setOwnrSeq(String ownrSeq) {
		this.ownrSeq = ownrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param fletMgmtOwnrVndrSeq
	 */
	public void setFletMgmtOwnrVndrSeq(String fletMgmtOwnrVndrSeq) {
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param fletOwnrTpCd
	 */
	public void setFletOwnrTpCd(String fletOwnrTpCd) {
		this.fletOwnrTpCd = fletOwnrTpCd;
	}
	
	/**
	 * Column Info
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
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
		setCdCnt(JSPUtil.getParameter(request, prefix + "cd_cnt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCdSeq(JSPUtil.getParameter(request, prefix + "cd_seq", ""));
		setCdName(JSPUtil.getParameter(request, prefix + "cd_name", ""));
		setTaxRequired(JSPUtil.getParameter(request, prefix + "tax_required", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setFletMgmtOwnrCustSeq(JSPUtil.getParameter(request, prefix + "flet_mgmt_ownr_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOwnrSeq(JSPUtil.getParameter(request, prefix + "ownr_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFletMgmtOwnrVndrSeq(JSPUtil.getParameter(request, prefix + "flet_mgmt_ownr_vndr_seq", ""));
		setFletOwnrTpCd(JSPUtil.getParameter(request, prefix + "flet_ownr_tp_cd", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVendorCustomerVO[]
	 */
	public SearchVendorCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVendorCustomerVO[]
	 */
	public SearchVendorCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVendorCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cdCnt = (JSPUtil.getParameter(request, prefix	+ "cd_cnt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] cdSeq = (JSPUtil.getParameter(request, prefix	+ "cd_seq", length));
			String[] cdName = (JSPUtil.getParameter(request, prefix	+ "cd_name", length));
			String[] taxRequired = (JSPUtil.getParameter(request, prefix	+ "tax_required", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] fletMgmtOwnrCustSeq = (JSPUtil.getParameter(request, prefix	+ "flet_mgmt_ownr_cust_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ownrSeq = (JSPUtil.getParameter(request, prefix	+ "ownr_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fletMgmtOwnrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "flet_mgmt_ownr_vndr_seq", length));
			String[] fletOwnrTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ownr_tp_cd", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVendorCustomerVO();
				if (cdCnt[i] != null)
					model.setCdCnt(cdCnt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (cdSeq[i] != null)
					model.setCdSeq(cdSeq[i]);
				if (cdName[i] != null)
					model.setCdName(cdName[i]);
				if (taxRequired[i] != null)
					model.setTaxRequired(taxRequired[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (fletMgmtOwnrCustSeq[i] != null)
					model.setFletMgmtOwnrCustSeq(fletMgmtOwnrCustSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ownrSeq[i] != null)
					model.setOwnrSeq(ownrSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fletMgmtOwnrVndrSeq[i] != null)
					model.setFletMgmtOwnrVndrSeq(fletMgmtOwnrVndrSeq[i]);
				if (fletOwnrTpCd[i] != null)
					model.setFletOwnrTpCd(fletOwnrTpCd[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVendorCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVendorCustomerVO[]
	 */
	public SearchVendorCustomerVO[] getSearchVendorCustomerVOs(){
		SearchVendorCustomerVO[] vos = (SearchVendorCustomerVO[])models.toArray(new SearchVendorCustomerVO[models.size()]);
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
		this.cdCnt = this.cdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdSeq = this.cdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdName = this.cdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRequired = this.taxRequired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMgmtOwnrCustSeq = this.fletMgmtOwnrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrSeq = this.ownrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMgmtOwnrVndrSeq = this.fletMgmtOwnrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOwnrTpCd = this.fletOwnrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
