/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchTaxMasterEvidenceVO.java
*@FileTitle : SearchTaxMasterEvidenceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTaxMasterEvidenceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTaxMasterEvidenceVO> models = new ArrayList<SearchTaxMasterEvidenceVO>();
	
	/* Column Info */
	private String taxVatTpCd = null;
	/* Column Info */
	private String splAddr = null;
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String docEvidTpCd = null;
	/* Column Info */
	private String taxPlCd = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String splAmt = null;
	/* Column Info */
	private String taxNslFlg = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String taxDivCd = null;
	/* Column Info */
	private String faFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String taxInvYrmon = null;
	/* Column Info */
	private String splRgstNo = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String taxNaidFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTaxMasterEvidenceVO() {}

	public SearchTaxMasterEvidenceVO(String ibflag, String pagerows, String taxInvYrmon, String ofcCd, String docEvidTpCd, String taxVatTpCd, String taxNaidFlg, String taxDivCd, String faFlg, String taxPlCd, String taxNslFlg, String splRgstNo, String ownrNm, String coNm, String bzctNm, String bztpNm, String splAddr, String issDt, String splAmt, String taxAmt, String totalAmt) {
		this.taxVatTpCd = taxVatTpCd;
		this.splAddr = splAddr;
		this.bzctNm = bzctNm;
		this.docEvidTpCd = docEvidTpCd;
		this.taxPlCd = taxPlCd;
		this.bztpNm = bztpNm;
		this.splAmt = splAmt;
		this.taxNslFlg = taxNslFlg;
		this.coNm = coNm;
		this.totalAmt = totalAmt;
		this.taxDivCd = taxDivCd;
		this.faFlg = faFlg;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.taxInvYrmon = taxInvYrmon;
		this.splRgstNo = splRgstNo;
		this.ownrNm = ownrNm;
		this.taxNaidFlg = taxNaidFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tax_vat_tp_cd", getTaxVatTpCd());
		this.hashColumns.put("spl_addr", getSplAddr());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("doc_evid_tp_cd", getDocEvidTpCd());
		this.hashColumns.put("tax_pl_cd", getTaxPlCd());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("spl_amt", getSplAmt());
		this.hashColumns.put("tax_nsl_flg", getTaxNslFlg());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("tax_div_cd", getTaxDivCd());
		this.hashColumns.put("fa_flg", getFaFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("tax_inv_yrmon", getTaxInvYrmon());
		this.hashColumns.put("spl_rgst_no", getSplRgstNo());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("tax_naid_flg", getTaxNaidFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tax_vat_tp_cd", "taxVatTpCd");
		this.hashFields.put("spl_addr", "splAddr");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("doc_evid_tp_cd", "docEvidTpCd");
		this.hashFields.put("tax_pl_cd", "taxPlCd");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("spl_amt", "splAmt");
		this.hashFields.put("tax_nsl_flg", "taxNslFlg");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("tax_div_cd", "taxDivCd");
		this.hashFields.put("fa_flg", "faFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("tax_inv_yrmon", "taxInvYrmon");
		this.hashFields.put("spl_rgst_no", "splRgstNo");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("tax_naid_flg", "taxNaidFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return taxVatTpCd
	 */
	public String getTaxVatTpCd() {
		return this.taxVatTpCd;
	}
	
	/**
	 * Column Info
	 * @return splAddr
	 */
	public String getSplAddr() {
		return this.splAddr;
	}
	
	/**
	 * Column Info
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
	}
	
	/**
	 * Column Info
	 * @return docEvidTpCd
	 */
	public String getDocEvidTpCd() {
		return this.docEvidTpCd;
	}
	
	/**
	 * Column Info
	 * @return taxPlCd
	 */
	public String getTaxPlCd() {
		return this.taxPlCd;
	}
	
	/**
	 * Column Info
	 * @return bztpNm
	 */
	public String getBztpNm() {
		return this.bztpNm;
	}
	
	/**
	 * Column Info
	 * @return splAmt
	 */
	public String getSplAmt() {
		return this.splAmt;
	}
	
	/**
	 * Column Info
	 * @return taxNslFlg
	 */
	public String getTaxNslFlg() {
		return this.taxNslFlg;
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
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
	}
	
	/**
	 * Column Info
	 * @return taxDivCd
	 */
	public String getTaxDivCd() {
		return this.taxDivCd;
	}
	
	/**
	 * Column Info
	 * @return faFlg
	 */
	public String getFaFlg() {
		return this.faFlg;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return taxAmt
	 */
	public String getTaxAmt() {
		return this.taxAmt;
	}
	
	/**
	 * Column Info
	 * @return taxInvYrmon
	 */
	public String getTaxInvYrmon() {
		return this.taxInvYrmon;
	}
	
	/**
	 * Column Info
	 * @return splRgstNo
	 */
	public String getSplRgstNo() {
		return this.splRgstNo;
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
	 * @return taxNaidFlg
	 */
	public String getTaxNaidFlg() {
		return this.taxNaidFlg;
	}
	

	/**
	 * Column Info
	 * @param taxVatTpCd
	 */
	public void setTaxVatTpCd(String taxVatTpCd) {
		this.taxVatTpCd = taxVatTpCd;
	}
	
	/**
	 * Column Info
	 * @param splAddr
	 */
	public void setSplAddr(String splAddr) {
		this.splAddr = splAddr;
	}
	
	/**
	 * Column Info
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
	}
	
	/**
	 * Column Info
	 * @param docEvidTpCd
	 */
	public void setDocEvidTpCd(String docEvidTpCd) {
		this.docEvidTpCd = docEvidTpCd;
	}
	
	/**
	 * Column Info
	 * @param taxPlCd
	 */
	public void setTaxPlCd(String taxPlCd) {
		this.taxPlCd = taxPlCd;
	}
	
	/**
	 * Column Info
	 * @param bztpNm
	 */
	public void setBztpNm(String bztpNm) {
		this.bztpNm = bztpNm;
	}
	
	/**
	 * Column Info
	 * @param splAmt
	 */
	public void setSplAmt(String splAmt) {
		this.splAmt = splAmt;
	}
	
	/**
	 * Column Info
	 * @param taxNslFlg
	 */
	public void setTaxNslFlg(String taxNslFlg) {
		this.taxNslFlg = taxNslFlg;
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
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	/**
	 * Column Info
	 * @param taxDivCd
	 */
	public void setTaxDivCd(String taxDivCd) {
		this.taxDivCd = taxDivCd;
	}
	
	/**
	 * Column Info
	 * @param faFlg
	 */
	public void setFaFlg(String faFlg) {
		this.faFlg = faFlg;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param taxAmt
	 */
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
	}
	
	/**
	 * Column Info
	 * @param taxInvYrmon
	 */
	public void setTaxInvYrmon(String taxInvYrmon) {
		this.taxInvYrmon = taxInvYrmon;
	}
	
	/**
	 * Column Info
	 * @param splRgstNo
	 */
	public void setSplRgstNo(String splRgstNo) {
		this.splRgstNo = splRgstNo;
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
	 * @param taxNaidFlg
	 */
	public void setTaxNaidFlg(String taxNaidFlg) {
		this.taxNaidFlg = taxNaidFlg;
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
		setTaxVatTpCd(JSPUtil.getParameter(request, prefix + "tax_vat_tp_cd", ""));
		setSplAddr(JSPUtil.getParameter(request, prefix + "spl_addr", ""));
		setBzctNm(JSPUtil.getParameter(request, prefix + "bzct_nm", ""));
		setDocEvidTpCd(JSPUtil.getParameter(request, prefix + "doc_evid_tp_cd", ""));
		setTaxPlCd(JSPUtil.getParameter(request, prefix + "tax_pl_cd", ""));
		setBztpNm(JSPUtil.getParameter(request, prefix + "bztp_nm", ""));
		setSplAmt(JSPUtil.getParameter(request, prefix + "spl_amt", ""));
		setTaxNslFlg(JSPUtil.getParameter(request, prefix + "tax_nsl_flg", ""));
		setCoNm(JSPUtil.getParameter(request, prefix + "co_nm", ""));
		setTotalAmt(JSPUtil.getParameter(request, prefix + "total_amt", ""));
		setTaxDivCd(JSPUtil.getParameter(request, prefix + "tax_div_cd", ""));
		setFaFlg(JSPUtil.getParameter(request, prefix + "fa_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, prefix + "tax_amt", ""));
		setTaxInvYrmon(JSPUtil.getParameter(request, prefix + "tax_inv_yrmon", ""));
		setSplRgstNo(JSPUtil.getParameter(request, prefix + "spl_rgst_no", ""));
		setOwnrNm(JSPUtil.getParameter(request, prefix + "ownr_nm", ""));
		setTaxNaidFlg(JSPUtil.getParameter(request, prefix + "tax_naid_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTaxMasterEvidenceVO[]
	 */
	public SearchTaxMasterEvidenceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTaxMasterEvidenceVO[]
	 */
	public SearchTaxMasterEvidenceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTaxMasterEvidenceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] taxVatTpCd = (JSPUtil.getParameter(request, prefix	+ "tax_vat_tp_cd", length));
			String[] splAddr = (JSPUtil.getParameter(request, prefix	+ "spl_addr", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] docEvidTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_evid_tp_cd", length));
			String[] taxPlCd = (JSPUtil.getParameter(request, prefix	+ "tax_pl_cd", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] splAmt = (JSPUtil.getParameter(request, prefix	+ "spl_amt", length));
			String[] taxNslFlg = (JSPUtil.getParameter(request, prefix	+ "tax_nsl_flg", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] taxDivCd = (JSPUtil.getParameter(request, prefix	+ "tax_div_cd", length));
			String[] faFlg = (JSPUtil.getParameter(request, prefix	+ "fa_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] taxInvYrmon = (JSPUtil.getParameter(request, prefix	+ "tax_inv_yrmon", length));
			String[] splRgstNo = (JSPUtil.getParameter(request, prefix	+ "spl_rgst_no", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] taxNaidFlg = (JSPUtil.getParameter(request, prefix	+ "tax_naid_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTaxMasterEvidenceVO();
				if (taxVatTpCd[i] != null)
					model.setTaxVatTpCd(taxVatTpCd[i]);
				if (splAddr[i] != null)
					model.setSplAddr(splAddr[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (docEvidTpCd[i] != null)
					model.setDocEvidTpCd(docEvidTpCd[i]);
				if (taxPlCd[i] != null)
					model.setTaxPlCd(taxPlCd[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (splAmt[i] != null)
					model.setSplAmt(splAmt[i]);
				if (taxNslFlg[i] != null)
					model.setTaxNslFlg(taxNslFlg[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (taxDivCd[i] != null)
					model.setTaxDivCd(taxDivCd[i]);
				if (faFlg[i] != null)
					model.setFaFlg(faFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (taxInvYrmon[i] != null)
					model.setTaxInvYrmon(taxInvYrmon[i]);
				if (splRgstNo[i] != null)
					model.setSplRgstNo(splRgstNo[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (taxNaidFlg[i] != null)
					model.setTaxNaidFlg(taxNaidFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTaxMasterEvidenceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTaxMasterEvidenceVO[]
	 */
	public SearchTaxMasterEvidenceVO[] getSearchTaxMasterEvidenceVOs(){
		SearchTaxMasterEvidenceVO[] vos = (SearchTaxMasterEvidenceVO[])models.toArray(new SearchTaxMasterEvidenceVO[models.size()]);
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
		this.taxVatTpCd = this.taxVatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAddr = this.splAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docEvidTpCd = this.docEvidTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxPlCd = this.taxPlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAmt = this.splAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxNslFlg = this.taxNslFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxDivCd = this.taxDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faFlg = this.faFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvYrmon = this.taxInvYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splRgstNo = this.splRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxNaidFlg = this.taxNaidFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
