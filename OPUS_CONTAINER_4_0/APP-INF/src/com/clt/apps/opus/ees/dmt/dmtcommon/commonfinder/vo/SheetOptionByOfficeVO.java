/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SheetOptionByOfficeVO.java
*@FileTitle : SheetOptionByOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.12.21 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SheetOptionByOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SheetOptionByOfficeVO> models = new ArrayList<SheetOptionByOfficeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String taxAmtPrnFlg = null;
	/* Column Info */
	private String dcAmtFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String phnFaxPrnFlg = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custVatPrnFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String custRefPrnFlg = null;
	/* Column Info */
	private String dfltTaxRto = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SheetOptionByOfficeVO() {}

	public SheetOptionByOfficeVO(String ibflag, String pagerows, String dcAmtFlg, String ofcCd, String bilToLocDivCd, String custRefPrnFlg, String phnFaxPrnFlg, String custVatPrnFlg, String dfltTaxRto, String taxAmtPrnFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.taxAmtPrnFlg = taxAmtPrnFlg;
		this.dcAmtFlg = dcAmtFlg;
		this.creDt = creDt;
		this.phnFaxPrnFlg = phnFaxPrnFlg;
		this.bilToLocDivCd = bilToLocDivCd;
		this.pagerows = pagerows;
		this.custVatPrnFlg = custVatPrnFlg;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.custRefPrnFlg = custRefPrnFlg;
		this.dfltTaxRto = dfltTaxRto;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tax_amt_prn_flg", getTaxAmtPrnFlg());
		this.hashColumns.put("dc_amt_flg", getDcAmtFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("phn_fax_prn_flg", getPhnFaxPrnFlg());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_vat_prn_flg", getCustVatPrnFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cust_ref_prn_flg", getCustRefPrnFlg());
		this.hashColumns.put("dflt_tax_rto", getDfltTaxRto());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tax_amt_prn_flg", "taxAmtPrnFlg");
		this.hashFields.put("dc_amt_flg", "dcAmtFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("phn_fax_prn_flg", "phnFaxPrnFlg");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_vat_prn_flg", "custVatPrnFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cust_ref_prn_flg", "custRefPrnFlg");
		this.hashFields.put("dflt_tax_rto", "dfltTaxRto");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return taxAmtPrnFlg
	 */
	public String getTaxAmtPrnFlg() {
		return this.taxAmtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return dcAmtFlg
	 */
	public String getDcAmtFlg() {
		return this.dcAmtFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return phnFaxPrnFlg
	 */
	public String getPhnFaxPrnFlg() {
		return this.phnFaxPrnFlg;
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
	 * @return custVatPrnFlg
	 */
	public String getCustVatPrnFlg() {
		return this.custVatPrnFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return custRefPrnFlg
	 */
	public String getCustRefPrnFlg() {
		return this.custRefPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return dfltTaxRto
	 */
	public String getDfltTaxRto() {
		return this.dfltTaxRto;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param taxAmtPrnFlg
	 */
	public void setTaxAmtPrnFlg(String taxAmtPrnFlg) {
		this.taxAmtPrnFlg = taxAmtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param dcAmtFlg
	 */
	public void setDcAmtFlg(String dcAmtFlg) {
		this.dcAmtFlg = dcAmtFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param phnFaxPrnFlg
	 */
	public void setPhnFaxPrnFlg(String phnFaxPrnFlg) {
		this.phnFaxPrnFlg = phnFaxPrnFlg;
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
	 * @param custVatPrnFlg
	 */
	public void setCustVatPrnFlg(String custVatPrnFlg) {
		this.custVatPrnFlg = custVatPrnFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param custRefPrnFlg
	 */
	public void setCustRefPrnFlg(String custRefPrnFlg) {
		this.custRefPrnFlg = custRefPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param dfltTaxRto
	 */
	public void setDfltTaxRto(String dfltTaxRto) {
		this.dfltTaxRto = dfltTaxRto;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTaxAmtPrnFlg(JSPUtil.getParameter(request, "tax_amt_prn_flg", ""));
		setDcAmtFlg(JSPUtil.getParameter(request, "dc_amt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPhnFaxPrnFlg(JSPUtil.getParameter(request, "phn_fax_prn_flg", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, "bil_to_loc_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustVatPrnFlg(JSPUtil.getParameter(request, "cust_vat_prn_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCustRefPrnFlg(JSPUtil.getParameter(request, "cust_ref_prn_flg", ""));
		setDfltTaxRto(JSPUtil.getParameter(request, "dflt_tax_rto", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SheetOptionByOfficeVO[]
	 */
	public SheetOptionByOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SheetOptionByOfficeVO[]
	 */
	public SheetOptionByOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SheetOptionByOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] taxAmtPrnFlg = (JSPUtil.getParameter(request, prefix	+ "tax_amt_prn_flg", length));
			String[] dcAmtFlg = (JSPUtil.getParameter(request, prefix	+ "dc_amt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] phnFaxPrnFlg = (JSPUtil.getParameter(request, prefix	+ "phn_fax_prn_flg", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custVatPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cust_vat_prn_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] custRefPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cust_ref_prn_flg", length));
			String[] dfltTaxRto = (JSPUtil.getParameter(request, prefix	+ "dflt_tax_rto", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SheetOptionByOfficeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (taxAmtPrnFlg[i] != null)
					model.setTaxAmtPrnFlg(taxAmtPrnFlg[i]);
				if (dcAmtFlg[i] != null)
					model.setDcAmtFlg(dcAmtFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (phnFaxPrnFlg[i] != null)
					model.setPhnFaxPrnFlg(phnFaxPrnFlg[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custVatPrnFlg[i] != null)
					model.setCustVatPrnFlg(custVatPrnFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (custRefPrnFlg[i] != null)
					model.setCustRefPrnFlg(custRefPrnFlg[i]);
				if (dfltTaxRto[i] != null)
					model.setDfltTaxRto(dfltTaxRto[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSheetOptionByOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SheetOptionByOfficeVO[]
	 */
	public SheetOptionByOfficeVO[] getSheetOptionByOfficeVOs(){
		SheetOptionByOfficeVO[] vos = (SheetOptionByOfficeVO[])models.toArray(new SheetOptionByOfficeVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmtPrnFlg = this.taxAmtPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmtFlg = this.dcAmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnFaxPrnFlg = this.phnFaxPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVatPrnFlg = this.custVatPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefPrnFlg = this.custRefPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTaxRto = this.dfltTaxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
