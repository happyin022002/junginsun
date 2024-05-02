/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaxInquiryVO.java
*@FileTitle : TaxInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.09.17 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaxInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaxInquiryVO> models = new ArrayList<TaxInquiryVO>();
	
	/* Column Info */
	private String custLoclLangNm = null;
	/* Column Info */
	private String taxInvNoStart = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String loclCurrAmt = null;
	/* Column Info */
	private String taxInvNo = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String taxInvCxlRmk = null;
	/* Column Info */
	private String taxInvCxlFlg = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issCurrCd = null;
	/* Column Info */
	private String issDtEnd = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxChgRmk = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String taxChgLoclNm = null;
	/* Column Info */
	private String taxInvNoEnd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String issDtStart = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaxInquiryVO() {}

	public TaxInquiryVO(String ibflag, String pagerows, String issDt, String taxInvNo, String blSrcNo, String custCode, String custLoclLangNm, String taxChgLoclNm, String issCurrCd, String chgAmt, String invXchRt, String loclCurrAmt, String taxChgRmk, String taxInvCxlFlg, String taxInvCxlRmk, String arOfcCd, String actCustCntCd, String actCustSeq, String issDtStart, String issDtEnd, String taxInvNoStart, String taxInvNoEnd) {
		this.custLoclLangNm = custLoclLangNm;
		this.taxInvNoStart = taxInvNoStart;
		this.blSrcNo = blSrcNo;
		this.loclCurrAmt = loclCurrAmt;
		this.taxInvNo = taxInvNo;
		this.actCustSeq = actCustSeq;
		this.taxInvCxlRmk = taxInvCxlRmk;
		this.taxInvCxlFlg = taxInvCxlFlg;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.issCurrCd = issCurrCd;
		this.issDtEnd = issDtEnd;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.taxChgRmk = taxChgRmk;
		this.custCode = custCode;
		this.chgAmt = chgAmt;
		this.actCustCntCd = actCustCntCd;
		this.taxChgLoclNm = taxChgLoclNm;
		this.taxInvNoEnd = taxInvNoEnd;
		this.invXchRt = invXchRt;
		this.issDtStart = issDtStart;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_locl_lang_nm", getCustLoclLangNm());
		this.hashColumns.put("tax_inv_no_start", getTaxInvNoStart());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("locl_curr_amt", getLoclCurrAmt());
		this.hashColumns.put("tax_inv_no", getTaxInvNo());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("tax_inv_cxl_rmk", getTaxInvCxlRmk());
		this.hashColumns.put("tax_inv_cxl_flg", getTaxInvCxlFlg());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_curr_cd", getIssCurrCd());
		this.hashColumns.put("iss_dt_end", getIssDtEnd());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_chg_rmk", getTaxChgRmk());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("tax_chg_locl_nm", getTaxChgLoclNm());
		this.hashColumns.put("tax_inv_no_end", getTaxInvNoEnd());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("iss_dt_start", getIssDtStart());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_locl_lang_nm", "custLoclLangNm");
		this.hashFields.put("tax_inv_no_start", "taxInvNoStart");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("locl_curr_amt", "loclCurrAmt");
		this.hashFields.put("tax_inv_no", "taxInvNo");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("tax_inv_cxl_rmk", "taxInvCxlRmk");
		this.hashFields.put("tax_inv_cxl_flg", "taxInvCxlFlg");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_curr_cd", "issCurrCd");
		this.hashFields.put("iss_dt_end", "issDtEnd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_chg_rmk", "taxChgRmk");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("tax_chg_locl_nm", "taxChgLoclNm");
		this.hashFields.put("tax_inv_no_end", "taxInvNoEnd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("iss_dt_start", "issDtStart");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custLoclLangNm
	 */
	public String getCustLoclLangNm() {
		return this.custLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @return taxInvNoStart
	 */
	public String getTaxInvNoStart() {
		return this.taxInvNoStart;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return loclCurrAmt
	 */
	public String getLoclCurrAmt() {
		return this.loclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return taxInvNo
	 */
	public String getTaxInvNo() {
		return this.taxInvNo;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return taxInvCxlRmk
	 */
	public String getTaxInvCxlRmk() {
		return this.taxInvCxlRmk;
	}
	
	/**
	 * Column Info
	 * @return taxInvCxlFlg
	 */
	public String getTaxInvCxlFlg() {
		return this.taxInvCxlFlg;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return issCurrCd
	 */
	public String getIssCurrCd() {
		return this.issCurrCd;
	}
	
	/**
	 * Column Info
	 * @return issDtEnd
	 */
	public String getIssDtEnd() {
		return this.issDtEnd;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return taxChgRmk
	 */
	public String getTaxChgRmk() {
		return this.taxChgRmk;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return taxChgLoclNm
	 */
	public String getTaxChgLoclNm() {
		return this.taxChgLoclNm;
	}
	
	/**
	 * Column Info
	 * @return taxInvNoEnd
	 */
	public String getTaxInvNoEnd() {
		return this.taxInvNoEnd;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return issDtStart
	 */
	public String getIssDtStart() {
		return this.issDtStart;
	}
	

	/**
	 * Column Info
	 * @param custLoclLangNm
	 */
	public void setCustLoclLangNm(String custLoclLangNm) {
		this.custLoclLangNm = custLoclLangNm;
	}
	
	/**
	 * Column Info
	 * @param taxInvNoStart
	 */
	public void setTaxInvNoStart(String taxInvNoStart) {
		this.taxInvNoStart = taxInvNoStart;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param loclCurrAmt
	 */
	public void setLoclCurrAmt(String loclCurrAmt) {
		this.loclCurrAmt = loclCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param taxInvNo
	 */
	public void setTaxInvNo(String taxInvNo) {
		this.taxInvNo = taxInvNo;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param taxInvCxlRmk
	 */
	public void setTaxInvCxlRmk(String taxInvCxlRmk) {
		this.taxInvCxlRmk = taxInvCxlRmk;
	}
	
	/**
	 * Column Info
	 * @param taxInvCxlFlg
	 */
	public void setTaxInvCxlFlg(String taxInvCxlFlg) {
		this.taxInvCxlFlg = taxInvCxlFlg;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param issCurrCd
	 */
	public void setIssCurrCd(String issCurrCd) {
		this.issCurrCd = issCurrCd;
	}
	
	/**
	 * Column Info
	 * @param issDtEnd
	 */
	public void setIssDtEnd(String issDtEnd) {
		this.issDtEnd = issDtEnd;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param taxChgRmk
	 */
	public void setTaxChgRmk(String taxChgRmk) {
		this.taxChgRmk = taxChgRmk;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param taxChgLoclNm
	 */
	public void setTaxChgLoclNm(String taxChgLoclNm) {
		this.taxChgLoclNm = taxChgLoclNm;
	}
	
	/**
	 * Column Info
	 * @param taxInvNoEnd
	 */
	public void setTaxInvNoEnd(String taxInvNoEnd) {
		this.taxInvNoEnd = taxInvNoEnd;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param issDtStart
	 */
	public void setIssDtStart(String issDtStart) {
		this.issDtStart = issDtStart;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustLoclLangNm(JSPUtil.getParameter(request, "cust_locl_lang_nm", ""));
		setTaxInvNoStart(JSPUtil.getParameter(request, "tax_inv_no_start", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setLoclCurrAmt(JSPUtil.getParameter(request, "locl_curr_amt", ""));
		setTaxInvNo(JSPUtil.getParameter(request, "tax_inv_no", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setTaxInvCxlRmk(JSPUtil.getParameter(request, "tax_inv_cxl_rmk", ""));
		setTaxInvCxlFlg(JSPUtil.getParameter(request, "tax_inv_cxl_flg", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIssCurrCd(JSPUtil.getParameter(request, "iss_curr_cd", ""));
		setIssDtEnd(JSPUtil.getParameter(request, "iss_dt_end", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxChgRmk(JSPUtil.getParameter(request, "tax_chg_rmk", ""));
		setCustCode(JSPUtil.getParameter(request, "cust_code", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setTaxChgLoclNm(JSPUtil.getParameter(request, "tax_chg_locl_nm", ""));
		setTaxInvNoEnd(JSPUtil.getParameter(request, "tax_inv_no_end", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setIssDtStart(JSPUtil.getParameter(request, "iss_dt_start", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaxInquiryVO[]
	 */
	public TaxInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaxInquiryVO[]
	 */
	public TaxInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaxInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custLoclLangNm = (JSPUtil.getParameter(request, prefix	+ "cust_locl_lang_nm", length));
			String[] taxInvNoStart = (JSPUtil.getParameter(request, prefix	+ "tax_inv_no_start", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] loclCurrAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_amt", length));
			String[] taxInvNo = (JSPUtil.getParameter(request, prefix	+ "tax_inv_no", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] taxInvCxlRmk = (JSPUtil.getParameter(request, prefix	+ "tax_inv_cxl_rmk", length));
			String[] taxInvCxlFlg = (JSPUtil.getParameter(request, prefix	+ "tax_inv_cxl_flg", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issCurrCd = (JSPUtil.getParameter(request, prefix	+ "iss_curr_cd", length));
			String[] issDtEnd = (JSPUtil.getParameter(request, prefix	+ "iss_dt_end", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxChgRmk = (JSPUtil.getParameter(request, prefix	+ "tax_chg_rmk", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] taxChgLoclNm = (JSPUtil.getParameter(request, prefix	+ "tax_chg_locl_nm", length));
			String[] taxInvNoEnd = (JSPUtil.getParameter(request, prefix	+ "tax_inv_no_end", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] issDtStart = (JSPUtil.getParameter(request, prefix	+ "iss_dt_start", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaxInquiryVO();
				if (custLoclLangNm[i] != null)
					model.setCustLoclLangNm(custLoclLangNm[i]);
				if (taxInvNoStart[i] != null)
					model.setTaxInvNoStart(taxInvNoStart[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (loclCurrAmt[i] != null)
					model.setLoclCurrAmt(loclCurrAmt[i]);
				if (taxInvNo[i] != null)
					model.setTaxInvNo(taxInvNo[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (taxInvCxlRmk[i] != null)
					model.setTaxInvCxlRmk(taxInvCxlRmk[i]);
				if (taxInvCxlFlg[i] != null)
					model.setTaxInvCxlFlg(taxInvCxlFlg[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issCurrCd[i] != null)
					model.setIssCurrCd(issCurrCd[i]);
				if (issDtEnd[i] != null)
					model.setIssDtEnd(issDtEnd[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxChgRmk[i] != null)
					model.setTaxChgRmk(taxChgRmk[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (taxChgLoclNm[i] != null)
					model.setTaxChgLoclNm(taxChgLoclNm[i]);
				if (taxInvNoEnd[i] != null)
					model.setTaxInvNoEnd(taxInvNoEnd[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (issDtStart[i] != null)
					model.setIssDtStart(issDtStart[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaxInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaxInquiryVO[]
	 */
	public TaxInquiryVO[] getTaxInquiryVOs(){
		TaxInquiryVO[] vos = (TaxInquiryVO[])models.toArray(new TaxInquiryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
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
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.custLoclLangNm = this.custLoclLangNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvNoStart = this.taxInvNoStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrAmt = this.loclCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvNo = this.taxInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvCxlRmk = this.taxInvCxlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvCxlFlg = this.taxInvCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCurrCd = this.issCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDtEnd = this.issDtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxChgRmk = this.taxChgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxChgLoclNm = this.taxChgLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvNoEnd = this.taxInvNoEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDtStart = this.issDtStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
