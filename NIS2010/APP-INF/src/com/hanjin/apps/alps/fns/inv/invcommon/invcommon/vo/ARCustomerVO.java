/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARCustomerVO.java
*@FileTitle : ARCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.12.09 박정진 
* 1.0 Creation
* History
* -------------------------------------------------------- 
* 2011.12.05 권 민 [CHM-201114691] AR INV내  (Korea) Security Creation 기능 보완 요청
=========================================================*/

package com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARCustomerVO> models = new ArrayList<ARCustomerVO>();
	
	/* Column Info */
	private String indivCorpDivCd = null;
	/* Column Info */
	private String issDivCd = null;
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custEngNm = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String custRgstNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ibFaxNo = null;
	/* Column Info */
	private String obFaxNo = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String obCrTermDys = null;
	/* Column Info */
	private String crCltOfcCd = null;
	/* Column Info */
	private String loclAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibCrTermDys = null;
	/* Column Info */
	private String obPhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String ibPhnNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String crStDt = null;
	/* Column Info */
	private String crEndDt = null;
	/* Column Info */
	private String crFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARCustomerVO() {}

	public ARCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String crCurrCd, String crAmt, String ibCrTermDys, String obCrTermDys, String crCltOfcCd, String custNm, String custEngNm, String obPhnNo, String ibPhnNo, String obFaxNo, String ibFaxNo, String cntcPsonNm, String bzctNm, String bztpNm, String custRgstNo, String deltFlg, String loclAddr, String issDivCd, String indivCorpDivCd, String crStDt, String crEndDt, String crFlg) {
		this.indivCorpDivCd = indivCorpDivCd;
		this.issDivCd = issDivCd;
		this.bzctNm = bzctNm;
		this.custNm = custNm;
		this.deltFlg = deltFlg;
		this.custEngNm = custEngNm;
		this.bztpNm = bztpNm;
		this.custRgstNo = custRgstNo;
		this.custSeq = custSeq;
		this.ibFaxNo = ibFaxNo;
		this.obFaxNo = obFaxNo;
		this.crCurrCd = crCurrCd;
		this.obCrTermDys = obCrTermDys;
		this.crCltOfcCd = crCltOfcCd;
		this.loclAddr = loclAddr;
		this.pagerows = pagerows;
		this.ibCrTermDys = ibCrTermDys;
		this.obPhnNo = obPhnNo;
		this.ibflag = ibflag;
		this.crAmt = crAmt;
		this.cntcPsonNm = cntcPsonNm;
		this.ibPhnNo = ibPhnNo;
		this.custCntCd = custCntCd;
		this.crStDt = crStDt;
		this.crEndDt = crEndDt;
		this.crFlg = crFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("indiv_corp_div_cd", getIndivCorpDivCd());
		this.hashColumns.put("iss_div_cd", getIssDivCd());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_eng_nm", getCustEngNm());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ib_fax_no", getIbFaxNo());
		this.hashColumns.put("ob_fax_no", getObFaxNo());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());
		this.hashColumns.put("locl_addr", getLoclAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());
		this.hashColumns.put("ob_phn_no", getObPhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("ib_phn_no", getIbPhnNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cr_st_dt", getCrStDt());
		this.hashColumns.put("cr_end_dt", getCrEndDt());
		this.hashColumns.put("cr_flg", getCrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("indiv_corp_div_cd", "indivCorpDivCd");
		this.hashFields.put("iss_div_cd", "issDivCd");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_eng_nm", "custEngNm");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ib_fax_no", "ibFaxNo");
		this.hashFields.put("ob_fax_no", "obFaxNo");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("locl_addr", "loclAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("ob_phn_no", "obPhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("ib_phn_no", "ibPhnNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cr_st_dt", "crStDt");
		this.hashFields.put("cr_end_dt", "crEndDt");
		this.hashFields.put("cr_flg", "crFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return indivCorpDivCd
	 */
	public String getIndivCorpDivCd() {
		return this.indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @return issDivCd
	 */
	public String getIssDivCd() {
		return this.issDivCd;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return custEngNm
	 */
	public String getCustEngNm() {
		return this.custEngNm;
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
	 * @return custRgstNo
	 */
	public String getCustRgstNo() {
		return this.custRgstNo;
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
	 * @return ibFaxNo
	 */
	public String getIbFaxNo() {
		return this.ibFaxNo;
	}
	
	/**
	 * Column Info
	 * @return obFaxNo
	 */
	public String getObFaxNo() {
		return this.obFaxNo;
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
	 * @return obCrTermDys
	 */
	public String getObCrTermDys() {
		return this.obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return crCltOfcCd
	 */
	public String getCrCltOfcCd() {
		return this.crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return loclAddr
	 */
	public String getLoclAddr() {
		return this.loclAddr;
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
	 * @return ibCrTermDys
	 */
	public String getIbCrTermDys() {
		return this.ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @return obPhnNo
	 */
	public String getObPhnNo() {
		return this.obPhnNo;
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
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return ibPhnNo
	 */
	public String getIbPhnNo() {
		return this.ibPhnNo;
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
	 * @return crStDt
	 */
	public String getCrStDt() {
		return crStDt;
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
	 * @return crEndDt
	 */
	public String getCrEndDt() {
		return crEndDt;
	}
	
	/**
	 * Column Info
	 * @param crEndDt
	 */
	public void setCrEndDt(String crEndDt) {
		this.crEndDt = crEndDt;
	}
	
	/**
	 * Column Info
	 * @return crFlg
	 */
	public String getCrFlg() {
		return crFlg;
	}
	
	/**
	 * Column Info
	 * @param crFlg
	 */
	public void setCrFlg(String crFlg) {
		this.crFlg = crFlg;
	}

	/**
	 * Column Info
	 * @param indivCorpDivCd
	 */
	public void setIndivCorpDivCd(String indivCorpDivCd) {
		this.indivCorpDivCd = indivCorpDivCd;
	}
	
	/**
	 * Column Info
	 * @param issDivCd
	 */
	public void setIssDivCd(String issDivCd) {
		this.issDivCd = issDivCd;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param custEngNm
	 */
	public void setCustEngNm(String custEngNm) {
		this.custEngNm = custEngNm;
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
	 * @param custRgstNo
	 */
	public void setCustRgstNo(String custRgstNo) {
		this.custRgstNo = custRgstNo;
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
	 * @param ibFaxNo
	 */
	public void setIbFaxNo(String ibFaxNo) {
		this.ibFaxNo = ibFaxNo;
	}
	
	/**
	 * Column Info
	 * @param obFaxNo
	 */
	public void setObFaxNo(String obFaxNo) {
		this.obFaxNo = obFaxNo;
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
	 * @param obCrTermDys
	 */
	public void setObCrTermDys(String obCrTermDys) {
		this.obCrTermDys = obCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param crCltOfcCd
	 */
	public void setCrCltOfcCd(String crCltOfcCd) {
		this.crCltOfcCd = crCltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param loclAddr
	 */
	public void setLoclAddr(String loclAddr) {
		this.loclAddr = loclAddr;
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
	 * @param ibCrTermDys
	 */
	public void setIbCrTermDys(String ibCrTermDys) {
		this.ibCrTermDys = ibCrTermDys;
	}
	
	/**
	 * Column Info
	 * @param obPhnNo
	 */
	public void setObPhnNo(String obPhnNo) {
		this.obPhnNo = obPhnNo;
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
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param ibPhnNo
	 */
	public void setIbPhnNo(String ibPhnNo) {
		this.ibPhnNo = ibPhnNo;
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
		setIndivCorpDivCd(JSPUtil.getParameter(request, "indiv_corp_div_cd", ""));
		setIssDivCd(JSPUtil.getParameter(request, "iss_div_cd", ""));
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCustEngNm(JSPUtil.getParameter(request, "cust_eng_nm", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setCustRgstNo(JSPUtil.getParameter(request, "cust_rgst_no", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setIbFaxNo(JSPUtil.getParameter(request, "ib_fax_no", ""));
		setObFaxNo(JSPUtil.getParameter(request, "ob_fax_no", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setObCrTermDys(JSPUtil.getParameter(request, "ob_cr_term_dys", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request, "cr_clt_ofc_cd", ""));
		setLoclAddr(JSPUtil.getParameter(request, "locl_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbCrTermDys(JSPUtil.getParameter(request, "ib_cr_term_dys", ""));
		setObPhnNo(JSPUtil.getParameter(request, "ob_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setIbPhnNo(JSPUtil.getParameter(request, "ib_phn_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCrStDt(JSPUtil.getParameter(request, "cr_st_dt", ""));
		setCrEndDt(JSPUtil.getParameter(request, "cr_end_dt", ""));
		setCrFlg(JSPUtil.getParameter(request, "cr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARCustomerVO[]
	 */
	public ARCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARCustomerVO[]
	 */
	public ARCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] indivCorpDivCd = (JSPUtil.getParameter(request, prefix	+ "indiv_corp_div_cd", length));
			String[] issDivCd = (JSPUtil.getParameter(request, prefix	+ "iss_div_cd", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_eng_nm", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] custRgstNo = (JSPUtil.getParameter(request, prefix	+ "cust_rgst_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ibFaxNo = (JSPUtil.getParameter(request, prefix	+ "ib_fax_no", length));
			String[] obFaxNo = (JSPUtil.getParameter(request, prefix	+ "ob_fax_no", length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd", length));
			String[] obCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ob_cr_term_dys", length));
			String[] crCltOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_clt_ofc_cd", length));
			String[] loclAddr = (JSPUtil.getParameter(request, prefix	+ "locl_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibCrTermDys = (JSPUtil.getParameter(request, prefix	+ "ib_cr_term_dys", length));
			String[] obPhnNo = (JSPUtil.getParameter(request, prefix	+ "ob_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] ibPhnNo = (JSPUtil.getParameter(request, prefix	+ "ib_phn_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] crStDt = (JSPUtil.getParameter(request, prefix	+ "cr_st_dt", length));
			String[] crEndDt = (JSPUtil.getParameter(request, prefix	+ "cr_end_dt", length));
			String[] crFlg = (JSPUtil.getParameter(request, prefix	+ "cr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARCustomerVO();
				if (indivCorpDivCd[i] != null)
					model.setIndivCorpDivCd(indivCorpDivCd[i]);
				if (issDivCd[i] != null)
					model.setIssDivCd(issDivCd[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custEngNm[i] != null)
					model.setCustEngNm(custEngNm[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (custRgstNo[i] != null)
					model.setCustRgstNo(custRgstNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ibFaxNo[i] != null)
					model.setIbFaxNo(ibFaxNo[i]);
				if (obFaxNo[i] != null)
					model.setObFaxNo(obFaxNo[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (obCrTermDys[i] != null)
					model.setObCrTermDys(obCrTermDys[i]);
				if (crCltOfcCd[i] != null)
					model.setCrCltOfcCd(crCltOfcCd[i]);
				if (loclAddr[i] != null)
					model.setLoclAddr(loclAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibCrTermDys[i] != null)
					model.setIbCrTermDys(ibCrTermDys[i]);
				if (obPhnNo[i] != null)
					model.setObPhnNo(obPhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (ibPhnNo[i] != null)
					model.setIbPhnNo(ibPhnNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (crStDt[i] != null)
					model.setCrStDt(crStDt[i]);
				if (crEndDt[i] != null)
					model.setCrEndDt(crEndDt[i]);
				if (crFlg[i] != null)
					model.setCrFlg(crFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARCustomerVO[]
	 */
	public ARCustomerVO[] getARCustomerVOs(){
		ARCustomerVO[] vos = (ARCustomerVO[])models.toArray(new ARCustomerVO[models.size()]);
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
		this.indivCorpDivCd = this.indivCorpDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDivCd = this.issDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEngNm = this.custEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo = this.custRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFaxNo = this.ibFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obFaxNo = this.obFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys = this.obCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd = this.crCltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAddr = this.loclAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys = this.ibCrTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPhnNo = this.obPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPhnNo = this.ibPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crStDt = this.crStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crEndDt = this.crEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg = this.crFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
