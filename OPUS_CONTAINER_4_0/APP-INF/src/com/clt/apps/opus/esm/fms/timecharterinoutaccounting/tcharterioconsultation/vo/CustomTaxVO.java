/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomTaxVO.java
*@FileTitle : CustomTaxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.31 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomTaxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomTaxVO> models = new ArrayList<CustomTaxVO>();
	
	/* Column Info */
	private String taxVatTpCd = null;
	/* Column Info */
	private String bzctNm = null;
	/* Column Info */
	private String splAddr = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String bztpNm = null;
	/* Column Info */
	private String splAmt = null;
	/* Column Info */
	private String totalAmt = null;
	/* Column Info */
	private String taxDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
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
	private String slpTpCd = null;
	/* Column Info */
	private String taxNaidFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String taxPlCd = null;
	/* Column Info */
	private String taxNslFlg = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String faFlg = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ownrNm = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String taxIssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomTaxVO() {}

	public CustomTaxVO(String ibflag, String pagerows, String taxInvYrmon, String ofcCd, String taxSerNo, String taxVatTpCd, String taxNaidFlg, String taxDivCd, String faFlg, String taxPlCd, String taxNslFlg, String splRgstNo, String ownrNm, String coNm, String bzctNm, String bztpNm, String splAddr, String issDt, String splAmt, String taxAmt, String totalAmt, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String creUsrId, String updUsrId, String taxIssCd) {
		this.taxVatTpCd = taxVatTpCd;
		this.bzctNm = bzctNm;
		this.splAddr = splAddr;
		this.slpFuncCd = slpFuncCd;
		this.bztpNm = bztpNm;
		this.splAmt = splAmt;
		this.totalAmt = totalAmt;
		this.taxDivCd = taxDivCd;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.taxAmt = taxAmt;
		this.taxSerNo = taxSerNo;
		this.taxInvYrmon = taxInvYrmon;
		this.splRgstNo = splRgstNo;
		this.slpTpCd = slpTpCd;
		this.taxNaidFlg = taxNaidFlg;
		this.updUsrId = updUsrId;
		this.taxPlCd = taxPlCd;
		this.taxNslFlg = taxNslFlg;
		this.coNm = coNm;
		this.faFlg = faFlg;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ownrNm = ownrNm;
		this.slpSerNo = slpSerNo;
		this.taxIssCd = taxIssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tax_vat_tp_cd", getTaxVatTpCd());
		this.hashColumns.put("bzct_nm", getBzctNm());
		this.hashColumns.put("spl_addr", getSplAddr());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("bztp_nm", getBztpNm());
		this.hashColumns.put("spl_amt", getSplAmt());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("tax_div_cd", getTaxDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_amt", getTaxAmt());
		this.hashColumns.put("tax_ser_no", getTaxSerNo());
		this.hashColumns.put("tax_inv_yrmon", getTaxInvYrmon());
		this.hashColumns.put("spl_rgst_no", getSplRgstNo());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("tax_naid_flg", getTaxNaidFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tax_pl_cd", getTaxPlCd());
		this.hashColumns.put("tax_nsl_flg", getTaxNslFlg());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("fa_flg", getFaFlg());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("tax_iss_cd", getTaxIssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tax_vat_tp_cd", "taxVatTpCd");
		this.hashFields.put("bzct_nm", "bzctNm");
		this.hashFields.put("spl_addr", "splAddr");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("bztp_nm", "bztpNm");
		this.hashFields.put("spl_amt", "splAmt");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("tax_div_cd", "taxDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_amt", "taxAmt");
		this.hashFields.put("tax_ser_no", "taxSerNo");
		this.hashFields.put("tax_inv_yrmon", "taxInvYrmon");
		this.hashFields.put("spl_rgst_no", "splRgstNo");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("tax_naid_flg", "taxNaidFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tax_pl_cd", "taxPlCd");
		this.hashFields.put("tax_nsl_flg", "taxNslFlg");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("fa_flg", "faFlg");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("tax_iss_cd", "taxIssCd");
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
	 * @return bzctNm
	 */
	public String getBzctNm() {
		return this.bzctNm;
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
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
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
	 * @return taxSerNo
	 */
	public String getTaxSerNo() {
		return this.taxSerNo;
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
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return faFlg
	 */
	public String getFaFlg() {
		return this.faFlg;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return ownrNm
	 */
	public String getOwnrNm() {
		return this.ownrNm;
	}
	
	/**
	 * Column Info
	 * @return slpSerNo
	 */
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	
	/**
	 * Column Info
	 * @return taxIssCd
	 */
	public String getTaxIssCd() {
		return this.taxIssCd;
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
	 * @param bzctNm
	 */
	public void setBzctNm(String bzctNm) {
		this.bzctNm = bzctNm;
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
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
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
	 * @param taxSerNo
	 */
	public void setTaxSerNo(String taxSerNo) {
		this.taxSerNo = taxSerNo;
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
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param taxNaidFlg
	 */
	public void setTaxNaidFlg(String taxNaidFlg) {
		this.taxNaidFlg = taxNaidFlg;
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
	 * @param taxPlCd
	 */
	public void setTaxPlCd(String taxPlCd) {
		this.taxPlCd = taxPlCd;
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
	 * @param faFlg
	 */
	public void setFaFlg(String faFlg) {
		this.faFlg = faFlg;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param ownrNm
	 */
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
	}
	
	/**
	 * Column Info
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
	}
	
	/**
	 * Column Info
	 * @param taxIssCd
	 */
	public void setTaxIssCd(String taxIssCd) {
		this.taxIssCd = taxIssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTaxVatTpCd(JSPUtil.getParameter(request, "tax_vat_tp_cd", ""));
		setBzctNm(JSPUtil.getParameter(request, "bzct_nm", ""));
		setSplAddr(JSPUtil.getParameter(request, "spl_addr", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setBztpNm(JSPUtil.getParameter(request, "bztp_nm", ""));
		setSplAmt(JSPUtil.getParameter(request, "spl_amt", ""));
		setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
		setTaxDivCd(JSPUtil.getParameter(request, "tax_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxAmt(JSPUtil.getParameter(request, "tax_amt", ""));
		setTaxSerNo(JSPUtil.getParameter(request, "tax_ser_no", ""));
		setTaxInvYrmon(JSPUtil.getParameter(request, "tax_inv_yrmon", ""));
		setSplRgstNo(JSPUtil.getParameter(request, "spl_rgst_no", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setTaxNaidFlg(JSPUtil.getParameter(request, "tax_naid_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTaxPlCd(JSPUtil.getParameter(request, "tax_pl_cd", ""));
		setTaxNslFlg(JSPUtil.getParameter(request, "tax_nsl_flg", ""));
		setCoNm(JSPUtil.getParameter(request, "co_nm", ""));
		setFaFlg(JSPUtil.getParameter(request, "fa_flg", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setTaxIssCd(JSPUtil.getParameter(request, "tax_iss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomTaxVO[]
	 */
	public CustomTaxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomTaxVO[]
	 */
	public CustomTaxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomTaxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] taxVatTpCd = (JSPUtil.getParameter(request, prefix	+ "tax_vat_tp_cd", length));
			String[] bzctNm = (JSPUtil.getParameter(request, prefix	+ "bzct_nm", length));
			String[] splAddr = (JSPUtil.getParameter(request, prefix	+ "spl_addr", length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] bztpNm = (JSPUtil.getParameter(request, prefix	+ "bztp_nm", length));
			String[] splAmt = (JSPUtil.getParameter(request, prefix	+ "spl_amt", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] taxDivCd = (JSPUtil.getParameter(request, prefix	+ "tax_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxAmt = (JSPUtil.getParameter(request, prefix	+ "tax_amt", length));
			String[] taxSerNo = (JSPUtil.getParameter(request, prefix	+ "tax_ser_no", length));
			String[] taxInvYrmon = (JSPUtil.getParameter(request, prefix	+ "tax_inv_yrmon", length));
			String[] splRgstNo = (JSPUtil.getParameter(request, prefix	+ "spl_rgst_no", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] taxNaidFlg = (JSPUtil.getParameter(request, prefix	+ "tax_naid_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] taxPlCd = (JSPUtil.getParameter(request, prefix	+ "tax_pl_cd", length));
			String[] taxNslFlg = (JSPUtil.getParameter(request, prefix	+ "tax_nsl_flg", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] faFlg = (JSPUtil.getParameter(request, prefix	+ "fa_flg", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] taxIssCd = (JSPUtil.getParameter(request, prefix	+ "tax_iss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomTaxVO();
				if (taxVatTpCd[i] != null)
					model.setTaxVatTpCd(taxVatTpCd[i]);
				if (bzctNm[i] != null)
					model.setBzctNm(bzctNm[i]);
				if (splAddr[i] != null)
					model.setSplAddr(splAddr[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (bztpNm[i] != null)
					model.setBztpNm(bztpNm[i]);
				if (splAmt[i] != null)
					model.setSplAmt(splAmt[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (taxDivCd[i] != null)
					model.setTaxDivCd(taxDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
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
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (taxNaidFlg[i] != null)
					model.setTaxNaidFlg(taxNaidFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (taxPlCd[i] != null)
					model.setTaxPlCd(taxPlCd[i]);
				if (taxNslFlg[i] != null)
					model.setTaxNslFlg(taxNslFlg[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (faFlg[i] != null)
					model.setFaFlg(faFlg[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (taxIssCd[i] != null)
					model.setTaxIssCd(taxIssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomTaxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomTaxVO[]
	 */
	public CustomTaxVO[] getCustomTaxVOs(){
		CustomTaxVO[] vos = (CustomTaxVO[])models.toArray(new CustomTaxVO[models.size()]);
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
		this.taxVatTpCd = this.taxVatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzctNm = this.bzctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAddr = this.splAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bztpNm = this.bztpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splAmt = this.splAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxDivCd = this.taxDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmt = this.taxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxSerNo = this.taxSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvYrmon = this.taxInvYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splRgstNo = this.splRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxNaidFlg = this.taxNaidFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxPlCd = this.taxPlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxNslFlg = this.taxNslFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faFlg = this.faFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxIssCd = this.taxIssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
