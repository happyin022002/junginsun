/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FrgnExchangeVO.java
*@FileTitle : FrgnExchangeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class FrgnExchangeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FrgnExchangeVO> models = new ArrayList<FrgnExchangeVO>();
	
	/* Column Info */
	private String aproStep = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String transactionCsrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ori1CsrNo = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String matchCsrUsdAmt = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String newCsrNo = null;
	/* Column Info */
	private String originCsrNo = null;
	/* Column Info */
	private String transactCd = null;
	/* Column Info */
	private String ori2CsrNo = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String supplierCd = null;
	/* Column Info */
	private String attachCnt = null;
	/* Column Info */
	private String selectCheck = null;
	/* Column Info */
	private String matchCsrNo = null;
	/* Column Info */
	private String attachLink = null;
	/* Column Info */
	private String apDesc = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String loclXchRtAmt = null;
	/* Column Info */
	private String glDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FrgnExchangeVO() {}

	public FrgnExchangeVO(String ibflag, String pagerows, String vslCd, String supplierCd, String originCsrNo, String matchCsrNo, String transactCd, String newCsrNo, String slpOfcCd, String csrNo, String effDt, String vvd, String apDesc, String attachLink, String attachCnt, String curr, String amt, String usdAmt, String glDate, String matchCsrUsdAmt, String loclXchRtAmt, String transactionCsrNo, String aproStep, String selectCheck, String ori1CsrNo, String ori2CsrNo) {
		this.aproStep = aproStep;
		this.vslCd = vslCd;
		this.transactionCsrNo = transactionCsrNo;
		this.pagerows = pagerows;
		this.ori1CsrNo = ori1CsrNo;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.matchCsrUsdAmt = matchCsrUsdAmt;
		this.curr = curr;
		this.newCsrNo = newCsrNo;
		this.originCsrNo = originCsrNo;
		this.transactCd = transactCd;
		this.ori2CsrNo = ori2CsrNo;
		this.csrNo = csrNo;
		this.supplierCd = supplierCd;
		this.attachCnt = attachCnt;
		this.selectCheck = selectCheck;
		this.matchCsrNo = matchCsrNo;
		this.attachLink = attachLink;
		this.apDesc = apDesc;
		this.slpOfcCd = slpOfcCd;
		this.vvd = vvd;
		this.amt = amt;
		this.usdAmt = usdAmt;
		this.loclXchRtAmt = loclXchRtAmt;
		this.glDate = glDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_step", getAproStep());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("transaction_csr_no", getTransactionCsrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ori1_csr_no", getOri1CsrNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("match_csr_usd_amt", getMatchCsrUsdAmt());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("new_csr_no", getNewCsrNo());
		this.hashColumns.put("origin_csr_no", getOriginCsrNo());
		this.hashColumns.put("transact_cd", getTransactCd());
		this.hashColumns.put("ori2_csr_no", getOri2CsrNo());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("supplier_cd", getSupplierCd());
		this.hashColumns.put("attach_cnt", getAttachCnt());
		this.hashColumns.put("select_check", getSelectCheck());
		this.hashColumns.put("match_csr_no", getMatchCsrNo());
		this.hashColumns.put("attach_link", getAttachLink());
		this.hashColumns.put("ap_desc", getApDesc());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("locl_xch_rt_amt", getLoclXchRtAmt());
		this.hashColumns.put("gl_date", getGlDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_step", "aproStep");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("transaction_csr_no", "transactionCsrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ori1_csr_no", "ori1CsrNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("match_csr_usd_amt", "matchCsrUsdAmt");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("new_csr_no", "newCsrNo");
		this.hashFields.put("origin_csr_no", "originCsrNo");
		this.hashFields.put("transact_cd", "transactCd");
		this.hashFields.put("ori2_csr_no", "ori2CsrNo");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("supplier_cd", "supplierCd");
		this.hashFields.put("attach_cnt", "attachCnt");
		this.hashFields.put("select_check", "selectCheck");
		this.hashFields.put("match_csr_no", "matchCsrNo");
		this.hashFields.put("attach_link", "attachLink");
		this.hashFields.put("ap_desc", "apDesc");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("locl_xch_rt_amt", "loclXchRtAmt");
		this.hashFields.put("gl_date", "glDate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproStep
	 */
	public String getAproStep() {
		return this.aproStep;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return transactionCsrNo
	 */
	public String getTransactionCsrNo() {
		return this.transactionCsrNo;
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
	 * @return ori1CsrNo
	 */
	public String getOri1CsrNo() {
		return this.ori1CsrNo;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return matchCsrUsdAmt
	 */
	public String getMatchCsrUsdAmt() {
		return this.matchCsrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return newCsrNo
	 */
	public String getNewCsrNo() {
		return this.newCsrNo;
	}
	
	/**
	 * Column Info
	 * @return originCsrNo
	 */
	public String getOriginCsrNo() {
		return this.originCsrNo;
	}
	
	/**
	 * Column Info
	 * @return transactCd
	 */
	public String getTransactCd() {
		return this.transactCd;
	}
	
	/**
	 * Column Info
	 * @return ori2CsrNo
	 */
	public String getOri2CsrNo() {
		return this.ori2CsrNo;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return supplierCd
	 */
	public String getSupplierCd() {
		return this.supplierCd;
	}
	
	/**
	 * Column Info
	 * @return attachCnt
	 */
	public String getAttachCnt() {
		return this.attachCnt;
	}
	
	/**
	 * Column Info
	 * @return selectCheck
	 */
	public String getSelectCheck() {
		return this.selectCheck;
	}
	
	/**
	 * Column Info
	 * @return matchCsrNo
	 */
	public String getMatchCsrNo() {
		return this.matchCsrNo;
	}
	
	/**
	 * Column Info
	 * @return attachLink
	 */
	public String getAttachLink() {
		return this.attachLink;
	}
	
	/**
	 * Column Info
	 * @return apDesc
	 */
	public String getApDesc() {
		return this.apDesc;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return loclXchRtAmt
	 */
	public String getLoclXchRtAmt() {
		return this.loclXchRtAmt;
	}
	
	/**
	 * Column Info
	 * @return glDate
	 */
	public String getGlDate() {
		return this.glDate;
	}
	

	/**
	 * Column Info
	 * @param aproStep
	 */
	public void setAproStep(String aproStep) {
		this.aproStep = aproStep;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param transactionCsrNo
	 */
	public void setTransactionCsrNo(String transactionCsrNo) {
		this.transactionCsrNo = transactionCsrNo;
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
	 * @param ori1CsrNo
	 */
	public void setOri1CsrNo(String ori1CsrNo) {
		this.ori1CsrNo = ori1CsrNo;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param matchCsrUsdAmt
	 */
	public void setMatchCsrUsdAmt(String matchCsrUsdAmt) {
		this.matchCsrUsdAmt = matchCsrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param newCsrNo
	 */
	public void setNewCsrNo(String newCsrNo) {
		this.newCsrNo = newCsrNo;
	}
	
	/**
	 * Column Info
	 * @param originCsrNo
	 */
	public void setOriginCsrNo(String originCsrNo) {
		this.originCsrNo = originCsrNo;
	}
	
	/**
	 * Column Info
	 * @param transactCd
	 */
	public void setTransactCd(String transactCd) {
		this.transactCd = transactCd;
	}
	
	/**
	 * Column Info
	 * @param ori2CsrNo
	 */
	public void setOri2CsrNo(String ori2CsrNo) {
		this.ori2CsrNo = ori2CsrNo;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param supplierCd
	 */
	public void setSupplierCd(String supplierCd) {
		this.supplierCd = supplierCd;
	}
	
	/**
	 * Column Info
	 * @param attachCnt
	 */
	public void setAttachCnt(String attachCnt) {
		this.attachCnt = attachCnt;
	}
	
	/**
	 * Column Info
	 * @param selectCheck
	 */
	public void setSelectCheck(String selectCheck) {
		this.selectCheck = selectCheck;
	}
	
	/**
	 * Column Info
	 * @param matchCsrNo
	 */
	public void setMatchCsrNo(String matchCsrNo) {
		this.matchCsrNo = matchCsrNo;
	}
	
	/**
	 * Column Info
	 * @param attachLink
	 */
	public void setAttachLink(String attachLink) {
		this.attachLink = attachLink;
	}
	
	/**
	 * Column Info
	 * @param apDesc
	 */
	public void setApDesc(String apDesc) {
		this.apDesc = apDesc;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param loclXchRtAmt
	 */
	public void setLoclXchRtAmt(String loclXchRtAmt) {
		this.loclXchRtAmt = loclXchRtAmt;
	}
	
	/**
	 * Column Info
	 * @param glDate
	 */
	public void setGlDate(String glDate) {
		this.glDate = glDate;
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
		setAproStep(JSPUtil.getParameter(request, prefix + "apro_step", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTransactionCsrNo(JSPUtil.getParameter(request, prefix + "transaction_csr_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOri1CsrNo(JSPUtil.getParameter(request, prefix + "ori1_csr_no", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMatchCsrUsdAmt(JSPUtil.getParameter(request, prefix + "match_csr_usd_amt", ""));
		setCurr(JSPUtil.getParameter(request, prefix + "curr", ""));
		setNewCsrNo(JSPUtil.getParameter(request, prefix + "new_csr_no", ""));
		setOriginCsrNo(JSPUtil.getParameter(request, prefix + "origin_csr_no", ""));
		setTransactCd(JSPUtil.getParameter(request, prefix + "transact_cd", ""));
		setOri2CsrNo(JSPUtil.getParameter(request, prefix + "ori2_csr_no", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setSupplierCd(JSPUtil.getParameter(request, prefix + "supplier_cd", ""));
		setAttachCnt(JSPUtil.getParameter(request, prefix + "attach_cnt", ""));
		setSelectCheck(JSPUtil.getParameter(request, prefix + "select_check", ""));
		setMatchCsrNo(JSPUtil.getParameter(request, prefix + "match_csr_no", ""));
		setAttachLink(JSPUtil.getParameter(request, prefix + "attach_link", ""));
		setApDesc(JSPUtil.getParameter(request, prefix + "ap_desc", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, prefix + "slp_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setAmt(JSPUtil.getParameter(request, prefix + "amt", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setLoclXchRtAmt(JSPUtil.getParameter(request, prefix + "locl_xch_rt_amt", ""));
		setGlDate(JSPUtil.getParameter(request, prefix + "gl_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FrgnExchangeVO[]
	 */
	public FrgnExchangeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FrgnExchangeVO[]
	 */
	public FrgnExchangeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FrgnExchangeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproStep = (JSPUtil.getParameter(request, prefix	+ "apro_step", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] transactionCsrNo = (JSPUtil.getParameter(request, prefix	+ "transaction_csr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ori1CsrNo = (JSPUtil.getParameter(request, prefix	+ "ori1_csr_no", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] matchCsrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "match_csr_usd_amt", length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr", length));
			String[] newCsrNo = (JSPUtil.getParameter(request, prefix	+ "new_csr_no", length));
			String[] originCsrNo = (JSPUtil.getParameter(request, prefix	+ "origin_csr_no", length));
			String[] transactCd = (JSPUtil.getParameter(request, prefix	+ "transact_cd", length));
			String[] ori2CsrNo = (JSPUtil.getParameter(request, prefix	+ "ori2_csr_no", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] supplierCd = (JSPUtil.getParameter(request, prefix	+ "supplier_cd", length));
			String[] attachCnt = (JSPUtil.getParameter(request, prefix	+ "attach_cnt", length));
			String[] selectCheck = (JSPUtil.getParameter(request, prefix	+ "select_check", length));
			String[] matchCsrNo = (JSPUtil.getParameter(request, prefix	+ "match_csr_no", length));
			String[] attachLink = (JSPUtil.getParameter(request, prefix	+ "attach_link", length));
			String[] apDesc = (JSPUtil.getParameter(request, prefix	+ "ap_desc", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] loclXchRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt_amt", length));
			String[] glDate = (JSPUtil.getParameter(request, prefix	+ "gl_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new FrgnExchangeVO();
				if (aproStep[i] != null)
					model.setAproStep(aproStep[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (transactionCsrNo[i] != null)
					model.setTransactionCsrNo(transactionCsrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ori1CsrNo[i] != null)
					model.setOri1CsrNo(ori1CsrNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (matchCsrUsdAmt[i] != null)
					model.setMatchCsrUsdAmt(matchCsrUsdAmt[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (newCsrNo[i] != null)
					model.setNewCsrNo(newCsrNo[i]);
				if (originCsrNo[i] != null)
					model.setOriginCsrNo(originCsrNo[i]);
				if (transactCd[i] != null)
					model.setTransactCd(transactCd[i]);
				if (ori2CsrNo[i] != null)
					model.setOri2CsrNo(ori2CsrNo[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (supplierCd[i] != null)
					model.setSupplierCd(supplierCd[i]);
				if (attachCnt[i] != null)
					model.setAttachCnt(attachCnt[i]);
				if (selectCheck[i] != null)
					model.setSelectCheck(selectCheck[i]);
				if (matchCsrNo[i] != null)
					model.setMatchCsrNo(matchCsrNo[i]);
				if (attachLink[i] != null)
					model.setAttachLink(attachLink[i]);
				if (apDesc[i] != null)
					model.setApDesc(apDesc[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (loclXchRtAmt[i] != null)
					model.setLoclXchRtAmt(loclXchRtAmt[i]);
				if (glDate[i] != null)
					model.setGlDate(glDate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFrgnExchangeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FrgnExchangeVO[]
	 */
	public FrgnExchangeVO[] getFrgnExchangeVOs(){
		FrgnExchangeVO[] vos = (FrgnExchangeVO[])models.toArray(new FrgnExchangeVO[models.size()]);
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
		this.aproStep = this.aproStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transactionCsrNo = this.transactionCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ori1CsrNo = this.ori1CsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchCsrUsdAmt = this.matchCsrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCsrNo = this.newCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originCsrNo = this.originCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transactCd = this.transactCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ori2CsrNo = this.ori2CsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supplierCd = this.supplierCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachCnt = this.attachCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectCheck = this.selectCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchCsrNo = this.matchCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachLink = this.attachLink .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc = this.apDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRtAmt = this.loclXchRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDate = this.glDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
