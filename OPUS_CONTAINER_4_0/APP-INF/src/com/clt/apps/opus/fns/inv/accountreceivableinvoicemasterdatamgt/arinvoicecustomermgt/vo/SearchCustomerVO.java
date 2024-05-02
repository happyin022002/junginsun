/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCustomerVO.java
*@FileTitle : SearchCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.13 김세일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

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
 * @author 김세일
 * @since J2EE 1.5
 */

public class SearchCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCustomerVO> models = new ArrayList<SearchCustomerVO>();
	
	/* Column Info */
	private String custLoclLangNm = null;
	/* Column Info */
	private String loclNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private int iPage = 1;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String actPayer = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custType = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String crFlg = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String loclZipCd = null;
	/* Column Info */
	private String creditType = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String crAmt2 = null;
	/* Column Info */
	private String krIbOfcCd = null;
	/* Column Info */
	private String ownrNm = null;	
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String chkNm = null;
	/* Column Info */
	private String addr = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCustomerVO() {}

	public SearchCustomerVO(String ibflag, String pagerows, String custCd, String custCntCd, String custSeq, String custLglEngNm, String custLoclLangNm, String ofcCd, String custRgstNo, String crAmt, String crAmt2, String crCltOfcCd, String actPayer, String actCustCntCd, String actCustSeq, String ownrNm, String crCurrCd, String ibCrTermDys, String obCrTermDys, String krIbOfcCd, String loclZipCd, String crFlg, String loclNm, String custType, String custNm, String creditType, String chkNm, String addr) {
		this.custLoclLangNm = custLoclLangNm;
		this.loclNm = loclNm;
		this.custNm = custNm;
		this.custRgstNo = custRgstNo;
		this.crCltOfcCd = crCltOfcCd;
		this.obCrTermDys = obCrTermDys;
		this.pagerows = pagerows;
		this.ibCrTermDys = ibCrTermDys;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.actCustCntCd = actCustCntCd;
		this.actPayer = actPayer;
		this.custCntCd = custCntCd;
		this.custType = custType;
		this.actCustSeq = actCustSeq;
		this.custSeq = custSeq;
		this.crFlg = crFlg;
		this.custLglEngNm = custLglEngNm;
		this.ofcCd = ofcCd;
		this.loclZipCd = loclZipCd;
		this.creditType = creditType;
		this.custCd = custCd;
		this.crAmt2 = crAmt2;
		this.krIbOfcCd = krIbOfcCd;
		this.ownrNm = ownrNm;
		this.crCurrCd = crCurrCd;
		this.chkNm = chkNm;
		this.addr = addr;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
		this.hashColumns.put("locl_nm", getLoclNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("act_payer", getActPayer());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_type", getCustType());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cr_flg", getCrFlg());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("locl_zip_cd", getLoclZipCd());
		this.hashColumns.put("credit_type", getCreditType());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cr_amt2", getCrAmt2());
		this.hashColumns.put("kr_ib_ofc_cd", getKrIbOfcCd());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("chk_nm", getChkNm());
		this.hashColumns.put("addr", getAddr());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("locl_nm", "loclNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("act_payer", "actPayer");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_type", "custType");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("locl_zip_cd", "loclZipCd");
		this.hashFields.put("credit_type", "creditType");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cr_amt2", "crAmt2");
		this.hashFields.put("kr_ib_ofc_cd", "krIbOfcCd");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("chk_nm", "chkNm");
		this.hashFields.put("addr", "addr");
		return this.hashFields;
	}
	
	public String getCustLoclLangNm() {
		return this.custLoclLangNm;
	}
	public String getLoclNm() {
		return this.loclNm;
	}
	public String getCustNm() {
		return this.custNm;
	}
	public int getIPage() {
		return this.iPage;
	}
	public String getCustRgstNo() {
		return this.custRgstNo;
	}
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCrAmt() {
		return this.crAmt;
	}
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	public String getActPayer() {
		return this.actPayer;
	}
	public String getCustCntCd() {
		return this.custCntCd;
	}
	public String getCustType() {
		return this.custType;
	}
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getCrFlg() {
		return this.crFlg;
	}
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getLoclZipCd() {
		return this.loclZipCd;
	}
	public String getCreditType() {
		return this.creditType;
	}
	public String getCustCd() {
		return this.custCd;
	}
	public String getCrAmt2() {
		return this.crAmt2;
	}
	public String getKrIbOfcCd() {
		return this.krIbOfcCd;
	}
	public String getOwnrNm() {
		return this.ownrNm;
	}

	public void setCustLoclLangNm(String custLoclLangNm) {
		this.custLoclLangNm = custLoclLangNm;
		//this.custLoclLangNm=true;
	}
	public void setLoclNm(String loclNm) {
		this.loclNm = loclNm;
		//this.loclNm=true;
	}
	public void setCustNm(String custNm) {
		this.custNm = custNm;
		//this.custNm=true;
	}
	public void setIPage(int iPage) {
		this.iPage = iPage;
		//this.ipage=true;
	}
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
		//this.custRgstNo=true;
	}
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
		//this.crCltOfcCd=true;
	}
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
		//this.obCrTermDys=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
		//this.ibCrTermDys=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
		//this.crAmt=true;
	}
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
		//this.actCustCntCd=true;
	}
	public void setActPayer(String actPayer) {
		this.actPayer = actPayer;
		//this.actPayer=true;
	}
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
		//this.custCntCd=true;
	}
	public void setCustType(String custType) {
		this.custType = custType;
		//this.custType=true;
	}
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
		//this.actCustSeq=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setCrFlg(String crFlg) {
		this.crFlg = crFlg;
		//this.crFlg=true;
	}
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
		//this.custLglEngNm=true;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setLoclZipCd(String loclZipCd) {
		this.loclZipCd = loclZipCd;
		//this.loclZipCd=true;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
		//this.creditType=true;
	}
	public void setCustCd(String custCd) {
		this.custCd = custCd;
		//this.custCd=true;
	}
	public void setCrAmt2(String crAmt2) {
		this.crAmt2 = crAmt2;
		//this.crAmt2=true;
	}
	public void setKrIbOfcCd(String krIbOfcCd) {
		this.krIbOfcCd = krIbOfcCd;
		//this.krIbOfcCd=true;
	}
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
		//this.ownrNm=true;
	}
	
	
	public String getCrCurrCd() {
		return crCurrCd;
	}

	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	public String getChkNm() {
		return chkNm;
	}

	public void setChkNm(String chkNm) {
		this.chkNm = chkNm;
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void fromRequest(HttpServletRequest request) {
		setCustLoclLangNm(JSPUtil.getParameter(request, "cust_locl_lang_nm", ""));
		setLoclNm(JSPUtil.getParameter(request, "locl_nm", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setActPayer(JSPUtil.getParameter(request, "act_payer", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustType(JSPUtil.getParameter(request, "cust_type", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCrFlg(JSPUtil.getParameter(request, "cr_flg", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setLoclZipCd(JSPUtil.getParameter(request, "locl_zip_cd", ""));
		setCreditType(JSPUtil.getParameter(request, "credit_type", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCrAmt2(JSPUtil.getParameter(request, "cr_amt2", ""));
		setKrIbOfcCd(JSPUtil.getParameter(request, "kr_ib_ofc_cd", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setChkNm(JSPUtil.getParameter(request, "chk_nm", ""));
		setAddr(JSPUtil.getParameter(request, "addr", ""));
	}

	public SearchCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "cust_locl_lang_nm".trim(), length));
			String[] loclNm = (JSPUtil.getParameter(request, prefix	+ "locl_nm".trim(), length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm".trim(), length));
//			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "iPage".trim(), length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no".trim(), length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd".trim(), length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt".trim(), length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd".trim(), length));
			String[] actPayer = (JSPUtil.getParameter(request, prefix	+ "act_payer".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type".trim(), length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] crFlg = (JSPUtil.getParameter(request, prefix	+ "cr_flg".trim(), length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] loclZipCd = (JSPUtil.getParameter(request, prefix	+ "locl_zip_cd".trim(), length));
			String[] creditType = (JSPUtil.getParameter(request, prefix	+ "credit_type".trim(), length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd".trim(), length));
			String[] crAmt2 = (JSPUtil.getParameter(request, prefix	+ "cr_amt2".trim(), length));
			String[] krIbOfcCd = (JSPUtil.getParameter(request, prefix	+ "kr_ib_ofc_cd".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd".trim(), length));
			String[] chkNm = (JSPUtil.getParameter(request, prefix	+ "chk_nm".trim(), length));
			String[] addr = (JSPUtil.getParameter(request, prefix	+ "addr".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCustomerVO();
				if (custLoclLangNm[i] != null)
					model.setCustLoclLangNm(custLoclLangNm[i]);
				if (loclNm[i] != null)
					model.setLoclNm(loclNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
//				if (ipage[i] != null)
//					model.setIPage(iPage[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (actPayer[i] != null)
					model.setActPayer(actPayer[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (crFlg[i] != null)
					model.setCrFlg(crFlg[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (loclZipCd[i] != null)
					model.setLoclZipCd(loclZipCd[i]);
				if (creditType[i] != null)
					model.setCreditType(creditType[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (crAmt2[i] != null)
					model.setCrAmt2(crAmt2[i]);
				if (krIbOfcCd[i] != null)
					model.setKrIbOfcCd(krIbOfcCd[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (chkNm[i] != null)
					model.setCrCurrCd(chkNm[i]);
				if (addr[i] != null)
					model.setAddr(addr[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchCustomerVOs();
	}

	public SearchCustomerVO[] getSearchCustomerVOs(){
		SearchCustomerVO[] vos = (SearchCustomerVO[])models.toArray(new SearchCustomerVO[models.size()]);
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
	 * @exception IllegalAccessException
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
		this.custLoclLangNm = this.custLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclNm = this.loclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPayer = this.actPayer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg = this.crFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclZipCd = this.loclZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditType = this.creditType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt2 = this.crAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krIbOfcCd = this.krIbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkNm = this.chkNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addr = this.addr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
