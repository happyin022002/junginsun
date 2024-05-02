/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInvoiceSettingVO.java
*@FileTitle : SearchInvoiceSettingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.10 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInvoiceSettingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInvoiceSettingVO> models = new ArrayList<SearchInvoiceSettingVO>();
	
	/* Column Info */
	private String sInvIssOfcCd = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String invRmk2 = null;
	/* Column Info */
	private String invRmk1 = null;
	/* Column Info */
	private String vatXchRtDiv = null;
	/* Column Info */
	private String invIssOfcCd = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vatXchRt = null;
	/* Column Info */
	private String ofcPhnNo = null;
	/* Column Info */
	private String ofcAddr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ofcFaxNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInvoiceSettingVO() {}

	public SearchInvoiceSettingVO(String ibflag, String pagerows, String sInvIssOfcCd, String coNm, String invRmk2, String invRmk1, String vatXchRtDiv, String invIssOfcCd, String bilToLocDivCd, String vatXchRt, String ofcPhnNo, String ofcAddr, String ofcFaxNo, String creUsrId, String updUsrId) {
		this.sInvIssOfcCd = sInvIssOfcCd;
		this.coNm = coNm;
		this.invRmk2 = invRmk2;
		this.invRmk1 = invRmk1;
		this.vatXchRtDiv = vatXchRtDiv;
		this.invIssOfcCd = invIssOfcCd;
		this.bilToLocDivCd = bilToLocDivCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vatXchRt = vatXchRt;
		this.ofcPhnNo = ofcPhnNo;
		this.ofcAddr = ofcAddr;
		this.updUsrId = updUsrId;
		this.ofcFaxNo = ofcFaxNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_inv_iss_ofc_cd", getSInvIssOfcCd());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("inv_rmk2", getInvRmk2());
		this.hashColumns.put("inv_rmk1", getInvRmk1());
		this.hashColumns.put("vat_xch_rt_div", getVatXchRtDiv());
		this.hashColumns.put("inv_iss_ofc_cd", getInvIssOfcCd());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vat_xch_rt", getVatXchRt());
		this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_inv_iss_ofc_cd", "sInvIssOfcCd");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("inv_rmk2", "invRmk2");
		this.hashFields.put("inv_rmk1", "invRmk1");
		this.hashFields.put("vat_xch_rt_div", "vatXchRtDiv");
		this.hashFields.put("inv_iss_ofc_cd", "invIssOfcCd");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vat_xch_rt", "vatXchRt");
		this.hashFields.put("ofc_phn_no", "ofcPhnNo");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ofc_fax_no", "ofcFaxNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sInvIssOfcCd
	 */
	public String getSInvIssOfcCd() {
		return this.sInvIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return coNm
	 */
	public String getCoNm() {
		return this.coNm;
	}
	
	/**
	 * Column Info
	 * @return invRmk2
	 */
	public String getInvRmk2() {
		return this.invRmk2;
	}
	
	/**
	 * Column Info
	 * @return invRmk1
	 */
	public String getInvRmk1() {
		return this.invRmk1;
	}
	
	/**
	 * Column Info
	 * @return vatXchRtDiv
	 */
	public String getVatXchRtDiv() {
		return this.vatXchRtDiv;
	}
	
	/**
	 * Column Info
	 * @return invIssOfcCd
	 */
	public String getInvIssOfcCd() {
		return this.invIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bilToLocDivCd
	 */
	public String getBilToLocDivCd() {
		return this.bilToLocDivCd;
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
	 * @return vatXchRt
	 */
	public String getVatXchRt() {
		return this.vatXchRt;
	}
	
	/**
	 * Column Info
	 * @return ofcPhnNo
	 */
	public String getOfcPhnNo() {
		return this.ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return ofcAddr
	 */
	public String getOfcAddr() {
		return this.ofcAddr;
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
	 * @return ofcFaxNo
	 */
	public String getOfcFaxNo() {
		return this.ofcFaxNo;
	}
	

	/**
	 * Column Info
	 * @param sInvIssOfcCd
	 */
	public void setSInvIssOfcCd(String sInvIssOfcCd) {
		this.sInvIssOfcCd = sInvIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param coNm
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	
	/**
	 * Column Info
	 * @param invRmk2
	 */
	public void setInvRmk2(String invRmk2) {
		this.invRmk2 = invRmk2;
	}
	
	/**
	 * Column Info
	 * @param invRmk1
	 */
	public void setInvRmk1(String invRmk1) {
		this.invRmk1 = invRmk1;
	}
	
	/**
	 * Column Info
	 * @param vatXchRtDiv
	 */
	public void setVatXchRtDiv(String vatXchRtDiv) {
		this.vatXchRtDiv = vatXchRtDiv;
	}
	
	/**
	 * Column Info
	 * @param invIssOfcCd
	 */
	public void setInvIssOfcCd(String invIssOfcCd) {
		this.invIssOfcCd = invIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bilToLocDivCd
	 */
	public void setBilToLocDivCd(String bilToLocDivCd) {
		this.bilToLocDivCd = bilToLocDivCd;
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
	 * @param vatXchRt
	 */
	public void setVatXchRt(String vatXchRt) {
		this.vatXchRt = vatXchRt;
	}
	
	/**
	 * Column Info
	 * @param ofcPhnNo
	 */
	public void setOfcPhnNo(String ofcPhnNo) {
		this.ofcPhnNo = ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param ofcAddr
	 */
	public void setOfcAddr(String ofcAddr) {
		this.ofcAddr = ofcAddr;
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
	 * @param ofcFaxNo
	 */
	public void setOfcFaxNo(String ofcFaxNo) {
		this.ofcFaxNo = ofcFaxNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSInvIssOfcCd(JSPUtil.getParameter(request, "s_inv_iss_ofc_cd", ""));
		setCoNm(JSPUtil.getParameter(request, "co_nm", ""));
		setInvRmk2(JSPUtil.getParameter(request, "inv_rmk2", ""));
		setInvRmk1(JSPUtil.getParameter(request, "inv_rmk1", ""));
		setVatXchRtDiv(JSPUtil.getParameter(request, "vat_xch_rt_div", ""));
		setInvIssOfcCd(JSPUtil.getParameter(request, "inv_iss_ofc_cd", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVatXchRt(JSPUtil.getParameter(request, "vat_xch_rt", ""));
		setOfcPhnNo(JSPUtil.getParameter(request, "ofc_phn_no", ""));
		setOfcAddr(JSPUtil.getParameter(request, "ofc_addr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOfcFaxNo(JSPUtil.getParameter(request, "ofc_fax_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoiceSettingVO[]
	 */
	public SearchInvoiceSettingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoiceSettingVO[]
	 */
	public SearchInvoiceSettingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInvoiceSettingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sInvIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_inv_iss_ofc_cd", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] invRmk2 = (JSPUtil.getParameter(request, prefix	+ "inv_rmk2", length));
			String[] invRmk1 = (JSPUtil.getParameter(request, prefix	+ "inv_rmk1", length));
			String[] vatXchRtDiv = (JSPUtil.getParameter(request, prefix	+ "vat_xch_rt_div", length));
			String[] invIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_ofc_cd", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vatXchRt = (JSPUtil.getParameter(request, prefix	+ "vat_xch_rt", length));
			String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ofc_phn_no", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ofc_fax_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInvoiceSettingVO();
				if (sInvIssOfcCd[i] != null)
					model.setSInvIssOfcCd(sInvIssOfcCd[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (invRmk2[i] != null)
					model.setInvRmk2(invRmk2[i]);
				if (invRmk1[i] != null)
					model.setInvRmk1(invRmk1[i]);
				if (vatXchRtDiv[i] != null)
					model.setVatXchRtDiv(vatXchRtDiv[i]);
				if (invIssOfcCd[i] != null)
					model.setInvIssOfcCd(invIssOfcCd[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vatXchRt[i] != null)
					model.setVatXchRt(vatXchRt[i]);
				if (ofcPhnNo[i] != null)
					model.setOfcPhnNo(ofcPhnNo[i]);
				if (ofcAddr[i] != null)
					model.setOfcAddr(ofcAddr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ofcFaxNo[i] != null)
					model.setOfcFaxNo(ofcFaxNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInvoiceSettingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInvoiceSettingVO[]
	 */
	public SearchInvoiceSettingVO[] getSearchInvoiceSettingVOs(){
		SearchInvoiceSettingVO[] vos = (SearchInvoiceSettingVO[])models.toArray(new SearchInvoiceSettingVO[models.size()]);
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
		this.sInvIssOfcCd = this.sInvIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk2 = this.invRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk1 = this.invRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRtDiv = this.vatXchRtDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssOfcCd = this.invIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRt = this.vatXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcPhnNo = this.ofcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFaxNo = this.ofcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
