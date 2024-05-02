/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaxVO.java
*@FileTitle : TaxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.18 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박희동
 * @since J2EE 1.5
 */

public class TaxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaxVO> models = new ArrayList<TaxVO>();
	
	/* Column Info */
	private String taxVatTpCd = null;
	/* Column Info */
	private String taxPlCd = null;
	/* Column Info */
	private String splAmt = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String slpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String issDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String taxAmt = null;
	/* Column Info */
	private String taxSerNo = null;
	/* Column Info */
	private String taxInvYrmon = null;
	/* Column Info */
	private String splRgstNo = null;
	/* Column Info */
	private String itmNm = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaxVO() {}

	public TaxVO(String ibflag, String pagerows, String taxInvYrmon, String ofcCd, String taxSerNo, String splRgstNo, String coNm, String issDt, String itmNm, String taxVatTpCd, String taxPlCd, String slpNo, String splAmt, String taxAmt) {
		this.taxVatTpCd = taxVatTpCd;
		this.taxPlCd = taxPlCd;
		this.splAmt = splAmt;
		this.coNm = coNm;
		this.slpNo = slpNo;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.taxSerNo = taxSerNo;
		this.taxInvYrmon = taxInvYrmon;
		this.splRgstNo = splRgstNo;
		this.itmNm = itmNm;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tax_vat_tp_cd", getTaxVatTpCd());
		this.hashColumns.put("tax_pl_cd", getTaxPlCd());
		this.hashColumns.put("spl_amt", getSplAmt());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("slp_no", getSlpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("tax_ser_no", getTaxSerNo());
		this.hashColumns.put("tax_inv_yrmon", getTaxInvYrmon());
		this.hashColumns.put("spl_rgst_no", getSplRgstNo());
		this.hashColumns.put("itm_nm", getItmNm());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tax_vat_tp_cd", "taxVatTpCd");
		this.hashFields.put("tax_pl_cd", "taxPlCd");
		this.hashFields.put("spl_amt", "splAmt");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("slp_no", "slpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("tax_ser_no", "taxSerNo");
		this.hashFields.put("tax_inv_yrmon", "taxInvYrmon");
		this.hashFields.put("spl_rgst_no", "splRgstNo");
		this.hashFields.put("itm_nm", "itmNm");
		return this.hashFields;
	}
	
	public String getTaxVatTpCd() {
		return this.taxVatTpCd;
	}
	public String getTaxPlCd() {
		return this.taxPlCd;
	}
	public String getSplAmt() {
		return this.splAmt;
	}
	public String getCoNm() {
		return this.coNm;
	}
	public String getSlpNo() {
		return this.slpNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getIssDt() {
		return this.issDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getTaxAmt() {
		return this.taxAmt;
	}
	public String getTaxSerNo() {
		return this.taxSerNo;
	}
	public String getTaxInvYrmon() {
		return this.taxInvYrmon;
	}
	public String getSplRgstNo() {
		return this.splRgstNo;
	}
	public String getItmNm() {
		return this.itmNm;
	}

	public void setTaxVatTpCd(String taxVatTpCd) {
		this.taxVatTpCd = taxVatTpCd;
		//this.taxVatTpCd=true;
	}
	public void setTaxPlCd(String taxPlCd) {
		this.taxPlCd = taxPlCd;
		//this.taxPlCd=true;
	}
	public void setSplAmt(String splAmt) {
		this.splAmt = splAmt;
		//this.splAmt=true;
	}
	public void setCoNm(String coNm) {
		this.coNm = coNm;
		//this.coNm=true;
	}
	public void setSlpNo(String slpNo) {
		this.slpNo = slpNo;
		//this.slpNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
		//this.issDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
		//this.taxAmt=true;
	}
	public void setTaxSerNo(String taxSerNo) {
		this.taxSerNo = taxSerNo;
		//this.taxSerNo=true;
	}
	public void setTaxInvYrmon(String taxInvYrmon) {
		this.taxInvYrmon = taxInvYrmon;
		//this.taxInvYrmon=true;
	}
	public void setSplRgstNo(String splRgstNo) {
		this.splRgstNo = splRgstNo;
		//this.splRgstNo=true;
	}
	public void setItmNm(String itmNm) {
		this.itmNm = itmNm;
		//this.itmNm=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setTaxVatTpCd(JSPUtil.getParameter(request, "tax_vat_tp_cd", ""));
		setTaxPlCd(JSPUtil.getParameter(request, "tax_pl_cd", ""));
		setSplAmt(JSPUtil.getParameter(request, "spl_amt", ""));
		setCoNm(JSPUtil.getParameter(request, "co_nm", ""));
		setSlpNo(JSPUtil.getParameter(request, "slp_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setTaxSerNo(JSPUtil.getParameter(request, "tax_ser_no", ""));
		setTaxInvYrmon(JSPUtil.getParameter(request, "tax_inv_yrmon", ""));
		setSplRgstNo(JSPUtil.getParameter(request, "spl_rgst_no", ""));
		setItmNm(JSPUtil.getParameter(request, "itm_nm", ""));
	}

	public TaxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public TaxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] taxVatTpCd = (JSPUtil.getParameter(request, prefix	+ "tax_vat_tp_cd".trim(), length));
			String[] taxPlCd = (JSPUtil.getParameter(request, prefix	+ "tax_pl_cd".trim(), length));
			String[] splAmt = (JSPUtil.getParameter(request, prefix	+ "spl_amt".trim(), length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm".trim(), length));
			String[] slpNo = (JSPUtil.getParameter(request, prefix	+ "slp_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt".trim(), length));
			String[] taxSerNo = (JSPUtil.getParameter(request, prefix	+ "tax_ser_no".trim(), length));
			String[] taxInvYrmon = (JSPUtil.getParameter(request, prefix	+ "tax_inv_yrmon".trim(), length));
			String[] splRgstNo = (JSPUtil.getParameter(request, prefix	+ "spl_rgst_no".trim(), length));
			String[] itmNm = (JSPUtil.getParameter(request, prefix	+ "itm_nm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TaxVO();
				if (taxVatTpCd[i] != null)
					model.setTaxVatTpCd(taxVatTpCd[i]);
				if (taxPlCd[i] != null)
					model.setTaxPlCd(taxPlCd[i]);
				if (splAmt[i] != null)
					model.setSplAmt(splAmt[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (slpNo[i] != null)
					model.setSlpNo(slpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxAmt[i] != null)
					model.setTaxAmt(taxAmt[i]);
				if (taxSerNo[i] != null)
					model.setTaxSerNo(taxSerNo[i]);
				if (taxInvYrmon[i] != null)
					model.setTaxInvYrmon(taxInvYrmon[i]);
				if (splRgstNo[i] != null)
					model.setSplRgstNo(splRgstNo[i]);
				if (itmNm[i] != null)
					model.setItmNm(itmNm[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getTaxVOs();
	}

	public TaxVO[] getTaxVOs(){
		TaxVO[] vos = (TaxVO[])models.toArray(new TaxVO[models.size()]);
		return vos;
	}
	
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.taxVatTpCd = this.taxVatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxPlCd = this.taxPlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAmt = this.splAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpNo = this.slpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxSerNo = this.taxSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvYrmon = this.taxInvYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splRgstNo = this.splRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNm = this.itmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
