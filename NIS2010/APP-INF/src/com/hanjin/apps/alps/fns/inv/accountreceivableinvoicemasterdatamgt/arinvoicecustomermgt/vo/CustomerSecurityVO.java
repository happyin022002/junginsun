/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerSecurityVO.java
*@FileTitle : CustomerSecurityVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.09 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomerSecurityVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerSecurityVO> models = new ArrayList<CustomerSecurityVO>();
	
	/* Column Info */
	private String scrEndDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String scrSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custScrDivCd = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String custScrKrwAmt = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String custScrUsdAmt = null;
	/* Column Info */
	private String crCurr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scrStDt = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String custScrAmt = null;
	/* Column Info */
	private String scrRmk = null;
	/* Column Info */
	private String crStDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String crEndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomerSecurityVO() {}

	public CustomerSecurityVO(String ibflag, String pagerows, String scrSeq, String custScrDivCd, String custScrAmt, String custScrUsdAmt, String custScrKrwAmt, String crCurrCd, String scrStDt, String scrEndDt, String scrRmk, String crStDt, String crEndDt, String crAmt, String crCurr, String obCrTermDys, String ibCrTermDys, String custCntCd, String custSeq, String arOfcCd, String custNm) {
		this.scrEndDt = scrEndDt;
		this.custNm = custNm;
		this.scrSeq = scrSeq;
		this.custSeq = custSeq;
		this.custScrDivCd = custScrDivCd;
		this.obCrTermDys = obCrTermDys;
		this.custScrKrwAmt = custScrKrwAmt;
		this.crCurrCd = crCurrCd;
		this.arOfcCd = arOfcCd;
		this.custScrUsdAmt = custScrUsdAmt;
		this.crCurr = crCurr;
		this.pagerows = pagerows;
		this.scrStDt = scrStDt;
		this.ibCrTermDys = ibCrTermDys;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.custScrAmt = custScrAmt;
		this.scrRmk = scrRmk;
		this.crStDt = crStDt;
		this.custCntCd = custCntCd;
		this.crEndDt = crEndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scr_end_dt", getScrEndDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("scr_seq", getScrSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_scr_div_cd", getCustScrDivCd());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("cust_scr_krw_amt", getCustScrKrwAmt());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cust_scr_usd_amt", getCustScrUsdAmt());
		this.hashColumns.put("cr_curr", getCrCurr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scr_st_dt", getScrStDt());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cust_scr_amt", getCustScrAmt());
		this.hashColumns.put("scr_rmk", getScrRmk());
		this.hashColumns.put("cr_st_dt", getCrStDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cr_end_dt", getCrEndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scr_end_dt", "scrEndDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("scr_seq", "scrSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_scr_div_cd", "custScrDivCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("cust_scr_krw_amt", "custScrKrwAmt");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_scr_usd_amt", "custScrUsdAmt");
		this.hashFields.put("cr_curr", "crCurr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scr_st_dt", "scrStDt");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cust_scr_amt", "custScrAmt");
		this.hashFields.put("scr_rmk", "scrRmk");
		this.hashFields.put("cr_st_dt", "crStDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cr_end_dt", "crEndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scrEndDt
	 */
	public String getScrEndDt() {
		return this.scrEndDt;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return scrSeq
	 */
	public String getScrSeq() {
		return this.scrSeq;
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
	 * @return custScrDivCd
	 */
	public String getCustScrDivCd() {
		return this.custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return custScrKrwAmt
	 */
	public String getCustScrKrwAmt() {
		return this.custScrKrwAmt;
	}
	
	/**
	 * Column Info
	 * @return crCurrCd
	 */
	public String getCrCurrCd() {
		return this.crCurrCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custScrUsdAmt
	 */
	public String getCustScrUsdAmt() {
		return this.custScrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return crCurr
	 */
	public String getCrCurr() {
		return this.crCurr;
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
	 * @return scrStDt
	 */
	public String getScrStDt() {
		return this.scrStDt;
	}
	
	/**
	 * Column Info
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
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
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return custScrAmt
	 */
	public String getCustScrAmt() {
		return this.custScrAmt;
	}
	
	/**
	 * Column Info
	 * @return scrRmk
	 */
	public String getScrRmk() {
		return this.scrRmk;
	}
	
	/**
	 * Column Info
	 * @return crStDt
	 */
	public String getCrStDt() {
		return this.crStDt;
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
	 * @return crEndDt
	 */
	public String getCrEndDt() {
		return this.crEndDt;
	}
	

	/**
	 * Column Info
	 * @param scrEndDt
	 */
	public void setScrEndDt(String scrEndDt) {
		this.scrEndDt = scrEndDt;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param scrSeq
	 */
	public void setScrSeq(String scrSeq) {
		this.scrSeq = scrSeq;
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
	 * @param custScrDivCd
	 */
	public void setCustScrDivCd(String custScrDivCd) {
		this.custScrDivCd = custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param custScrKrwAmt
	 */
	public void setCustScrKrwAmt(String custScrKrwAmt) {
		this.custScrKrwAmt = custScrKrwAmt;
	}
	
	/**
	 * Column Info
	 * @param crCurrCd
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custScrUsdAmt
	 */
	public void setCustScrUsdAmt(String custScrUsdAmt) {
		this.custScrUsdAmt = custScrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param crCurr
	 */
	public void setCrCurr(String crCurr) {
		this.crCurr = crCurr;
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
	 * @param scrStDt
	 */
	public void setScrStDt(String scrStDt) {
		this.scrStDt = scrStDt;
	}
	
	/**
	 * Column Info
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
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
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param custScrAmt
	 */
	public void setCustScrAmt(String custScrAmt) {
		this.custScrAmt = custScrAmt;
	}
	
	/**
	 * Column Info
	 * @param scrRmk
	 */
	public void setScrRmk(String scrRmk) {
		this.scrRmk = scrRmk;
	}
	
	/**
	 * Column Info
	 * @param crStDt
	 */
	public void setCrStDt(String crStDt) {
		this.crStDt = crStDt;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param crEndDt
	 */
	public void setCrEndDt(String crEndDt) {
		this.crEndDt = crEndDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScrEndDt(JSPUtil.getParameter(request, "scr_end_dt", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setScrSeq(JSPUtil.getParameter(request, "scr_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustScrDivCd(JSPUtil.getParameter(request, "cust_scr_div_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setCustScrKrwAmt(JSPUtil.getParameter(request, "cust_scr_krw_amt", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setCustScrUsdAmt(JSPUtil.getParameter(request, "cust_scr_usd_amt", ""));
		setCrCurr(JSPUtil.getParameter(request, "cr_curr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setScrStDt(JSPUtil.getParameter(request, "scr_st_dt", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCustScrAmt(JSPUtil.getParameter(request, "cust_scr_amt", ""));
		setScrRmk(JSPUtil.getParameter(request, "scr_rmk", ""));
		setCrStDt(JSPUtil.getParameter(request, "cr_st_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCrEndDt(JSPUtil.getParameter(request, "cr_end_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomerSecurityVO[]
	 */
	public CustomerSecurityVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomerSecurityVO[]
	 */
	public CustomerSecurityVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerSecurityVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scrEndDt = (JSPUtil.getParameter(request, prefix	+ "scr_end_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] scrSeq = (JSPUtil.getParameter(request, prefix	+ "scr_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custScrDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_scr_div_cd", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] custScrKrwAmt = (JSPUtil.getParameter(request, prefix	+ "cust_scr_krw_amt", length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] custScrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cust_scr_usd_amt", length));
			String[] crCurr = (JSPUtil.getParameter(request, prefix	+ "cr_curr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scrStDt = (JSPUtil.getParameter(request, prefix	+ "scr_st_dt", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] custScrAmt = (JSPUtil.getParameter(request, prefix	+ "cust_scr_amt", length));
			String[] scrRmk = (JSPUtil.getParameter(request, prefix	+ "scr_rmk", length));
			String[] crStDt = (JSPUtil.getParameter(request, prefix	+ "cr_st_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] crEndDt = (JSPUtil.getParameter(request, prefix	+ "cr_end_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomerSecurityVO();
				if (scrEndDt[i] != null)
					model.setScrEndDt(scrEndDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (scrSeq[i] != null)
					model.setScrSeq(scrSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custScrDivCd[i] != null)
					model.setCustScrDivCd(custScrDivCd[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (custScrKrwAmt[i] != null)
					model.setCustScrKrwAmt(custScrKrwAmt[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (custScrUsdAmt[i] != null)
					model.setCustScrUsdAmt(custScrUsdAmt[i]);
				if (crCurr[i] != null)
					model.setCrCurr(crCurr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scrStDt[i] != null)
					model.setScrStDt(scrStDt[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (custScrAmt[i] != null)
					model.setCustScrAmt(custScrAmt[i]);
				if (scrRmk[i] != null)
					model.setScrRmk(scrRmk[i]);
				if (crStDt[i] != null)
					model.setCrStDt(crStDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (crEndDt[i] != null)
					model.setCrEndDt(crEndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomerSecurityVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomerSecurityVO[]
	 */
	public CustomerSecurityVO[] getCustomerSecurityVOs(){
		CustomerSecurityVO[] vos = (CustomerSecurityVO[])models.toArray(new CustomerSecurityVO[models.size()]);
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
		this.scrEndDt = this.scrEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrSeq = this.scrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrDivCd = this.custScrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrKrwAmt = this.custScrKrwAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrUsdAmt = this.custScrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurr = this.crCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrStDt = this.scrStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrAmt = this.custScrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrRmk = this.scrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crStDt = this.crStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crEndDt = this.crEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
