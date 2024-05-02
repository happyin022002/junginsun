/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVendorCustomerVO.java
*@FileTitle : SearchVendorCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.17 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo;

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
 * @author 윤세영
 * @since J2EE 1.5
 * @see ESM_FMS_0004HTMLAction
 */

public class SearchVendorCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVendorCustomerVO> models = new ArrayList<SearchVendorCustomerVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String cdSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String cdName = null;
	/* 而щ읆 �ㅻ챸 */
	private String cdCnt = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String custSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String vndrSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String custLglEngNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String vndrLglEngNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String ownrNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String updUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String custCntCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletMgmtOwnrVndrSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletMgmtOwnrCustSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String taxRequired = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletOwnrTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchVendorCustomerVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String vndrSeq, String vndrLglEngNm, String cdSeq, String cdName, String cdCnt, String custSeq, String custLglEngNm, String fletMgmtOwnrCustSeq, String custCntCd, String fletMgmtOwnrVndrSeq, String ownrNm, String fletOwnrTpCd, String taxRequired, String updUsrId
	 * @return 
	 */
	public SearchVendorCustomerVO(String ibflag, String pagerows, String vndrSeq, String vndrLglEngNm, String cdSeq, String cdName, String cdCnt, String custSeq, String custLglEngNm, String fletMgmtOwnrCustSeq, String custCntCd, String fletMgmtOwnrVndrSeq, String ownrNm, String fletOwnrTpCd, String taxRequired, String updUsrId) {
		this.cdSeq = cdSeq;
		this.cdName = cdName;
		this.cdCnt = cdCnt;
		this.ibflag = ibflag;
		this.custSeq = custSeq;
		this.vndrSeq = vndrSeq;
		this.custLglEngNm = custLglEngNm;
		this.vndrLglEngNm = vndrLglEngNm;
		this.ownrNm = ownrNm;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
		this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
		this.taxRequired = taxRequired;
		this.fletOwnrTpCd = fletOwnrTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cd_seq", getCdSeq());
		this.hashColumns.put("cd_name", getCdName());
		this.hashColumns.put("cd_cnt", getCdCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("flet_mgmt_ownr_vndr_seq", getFletMgmtOwnrVndrSeq());
		this.hashColumns.put("flet_mgmt_ownr_cust_seq", getFletMgmtOwnrCustSeq());
		this.hashColumns.put("tax_required", getTaxRequired());
		this.hashColumns.put("flet_ownr_tp_cd", getFletOwnrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cd_seq", "cdSeq");
		this.hashFields.put("cd_name", "cdName");
		this.hashFields.put("cd_cnt", "cdCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("flet_mgmt_ownr_vndr_seq", "fletMgmtOwnrVndrSeq");
		this.hashFields.put("flet_mgmt_ownr_cust_seq", "fletMgmtOwnrCustSeq");
		this.hashFields.put("tax_required", "taxRequired");
		this.hashFields.put("flet_ownr_tp_cd", "fletOwnrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getCdSeq() {
		return this.cdSeq;
	}
	public String getCdName() {
		return this.cdName;
	}
	public String getCdCnt() {
		return this.cdCnt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	public String getOwnrNm() {
		return this.ownrNm;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getCustCntCd() {
		return this.custCntCd;
	}
	public String getFletMgmtOwnrVndrSeq() {
		return this.fletMgmtOwnrVndrSeq;
	}
	public String getFletMgmtOwnrCustSeq() {
		return this.fletMgmtOwnrCustSeq;
	}
	public String getTaxRequired() {
		return this.taxRequired;
	}
	public String getFletOwnrTpCd() {
		return this.fletOwnrTpCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setCdSeq(String cdSeq) {
		this.cdSeq = cdSeq;
		//this.cdSeq=true;
	}
	public void setCdName(String cdName) {
		this.cdName = cdName;
		//this.cdName=true;
	}
	public void setCdCnt(String cdCnt) {
		this.cdCnt = cdCnt;
		//this.cdCnt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
		//this.vndrSeq=true;
	}
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
		//this.custLglEngNm=true;
	}
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
		//this.vndrLglEngNm=true;
	}
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
		//this.ownrNm=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
		//this.custCntCd=true;
	}
	public void setFletMgmtOwnrVndrSeq(String fletMgmtOwnrVndrSeq) {
		this.fletMgmtOwnrVndrSeq = fletMgmtOwnrVndrSeq;
		//this.fletMgmtOwnrVndrSeq=true;
	}
	public void setFletMgmtOwnrCustSeq(String fletMgmtOwnrCustSeq) {
		this.fletMgmtOwnrCustSeq = fletMgmtOwnrCustSeq;
		//this.fletMgmtOwnrCustSeq=true;
	}
	public void setTaxRequired(String taxRequired) {
		this.taxRequired = taxRequired;
		//this.taxRequired=true;
	}
	public void setFletOwnrTpCd(String fletOwnrTpCd) {
		this.fletOwnrTpCd = fletOwnrTpCd;
		//this.fletOwnrTpCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setCdSeq(JSPUtil.getParameter(request, "cd_seq", ""));
		setCdName(JSPUtil.getParameter(request, "cd_name", ""));
		setCdCnt(JSPUtil.getParameter(request, "cd_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setFletMgmtOwnrVndrSeq(JSPUtil.getParameter(request, "flet_mgmt_ownr_vndr_seq", ""));
		setFletMgmtOwnrCustSeq(JSPUtil.getParameter(request, "flet_mgmt_ownr_cust_seq", ""));
		setTaxRequired(JSPUtil.getParameter(request, "tax_required", ""));
		setFletOwnrTpCd(JSPUtil.getParameter(request, "flet_ownr_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchVendorCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchVendorCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVendorCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cdSeq = (JSPUtil.getParameter(request, prefix	+ "cd_seq".trim(), length));
			String[] cdName = (JSPUtil.getParameter(request, prefix	+ "cd_name".trim(), length));
			String[] cdCnt = (JSPUtil.getParameter(request, prefix	+ "cd_cnt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] fletMgmtOwnrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "flet_mgmt_ownr_vndr_seq".trim(), length));
			String[] fletMgmtOwnrCustSeq = (JSPUtil.getParameter(request, prefix	+ "flet_mgmt_ownr_cust_seq".trim(), length));
			String[] taxRequired = (JSPUtil.getParameter(request, prefix	+ "tax_required".trim(), length));
			String[] fletOwnrTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ownr_tp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVendorCustomerVO();
				if (cdSeq[i] != null)
					model.setCdSeq(cdSeq[i]);
				if (cdName[i] != null)
					model.setCdName(cdName[i]);
				if (cdCnt[i] != null)
					model.setCdCnt(cdCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fletMgmtOwnrVndrSeq[i] != null)
					model.setFletMgmtOwnrVndrSeq(fletMgmtOwnrVndrSeq[i]);
				if (fletMgmtOwnrCustSeq[i] != null)
					model.setFletMgmtOwnrCustSeq(fletMgmtOwnrCustSeq[i]);
				if (taxRequired[i] != null)
					model.setTaxRequired(taxRequired[i]);
				if (fletOwnrTpCd[i] != null)
					model.setFletOwnrTpCd(fletOwnrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchVendorCustomerVOs();
	}

	public SearchVendorCustomerVO[] getSearchVendorCustomerVOs(){
		SearchVendorCustomerVO[] vos = (SearchVendorCustomerVO[])models.toArray(new SearchVendorCustomerVO[models.size()]);
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
		this.cdSeq = this.cdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdName = this.cdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdCnt = this.cdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMgmtOwnrVndrSeq = this.fletMgmtOwnrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMgmtOwnrCustSeq = this.fletMgmtOwnrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRequired = this.taxRequired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOwnrTpCd = this.fletOwnrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
