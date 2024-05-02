/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchNewOwnerAccountListVO.java
*@FileTitle : SearchNewOwnerAccountListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.09  
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

public class SearchNewOwnerAccountListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNewOwnerAccountListVO> models = new ArrayList<SearchNewOwnerAccountListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ppayHirNo = null;
	/* Column Info */
	private String oaStlStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String lcl = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String internalMemo = null;
	/* Column Info */
	private String condCsrSlipNo = null;
	/* Column Info */
	private String acctItmNm = null;
	/* Column Info */
	private String matchingCsrSlipNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String oaLocCd = null;
	/* Column Info */
	private String apDesc = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String csrSlipNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String acctItmSeq = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String attach = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchNewOwnerAccountListVO() {}

	public SearchNewOwnerAccountListVO(String ibflag, String pagerows, String oaStlStsCd, String attach, String acctItmNm, String acctCd, String oaLocCd, String acctItmSeq, String apDesc, String vvd, String usdAmt, String lcl, String amount, String csrSlipNo, String condCsrSlipNo, String effDt, String exRate, String matchingCsrSlipNo, String internalMemo, String ppayHirNo, String usrId, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd) {
		this.vslCd = vslCd;
		this.ppayHirNo = ppayHirNo;
		this.oaStlStsCd = oaStlStsCd;
		this.pagerows = pagerows;
		this.amount = amount;
		this.lcl = lcl;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.usrId = usrId;
		this.acctCd = acctCd;
		this.exRate = exRate;
		this.internalMemo = internalMemo;
		this.condCsrSlipNo = condCsrSlipNo;
		this.acctItmNm = acctItmNm;
		this.matchingCsrSlipNo = matchingCsrSlipNo;
		this.skdVoyNo = skdVoyNo;
		this.oaLocCd = oaLocCd;
		this.apDesc = apDesc;
		this.skdDirCd = skdDirCd;
		this.csrSlipNo = csrSlipNo;
		this.vvd = vvd;
		this.acctItmSeq = acctItmSeq;
		this.usdAmt = usdAmt;
		this.attach = attach;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ppay_hir_no", getPpayHirNo());
		this.hashColumns.put("oa_stl_sts_cd", getOaStlStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("lcl", getLcl());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("internal_memo", getInternalMemo());
		this.hashColumns.put("cond_csr_slip_no", getCondCsrSlipNo());
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("matching_csr_slip_no", getMatchingCsrSlipNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("oa_loc_cd", getOaLocCd());
		this.hashColumns.put("ap_desc", getApDesc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("csr_slip_no", getCsrSlipNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("attach", getAttach());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		this.hashFields.put("oa_stl_sts_cd", "oaStlStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("lcl", "lcl");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("internal_memo", "internalMemo");
		this.hashFields.put("cond_csr_slip_no", "condCsrSlipNo");
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("matching_csr_slip_no", "matchingCsrSlipNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("oa_loc_cd", "oaLocCd");
		this.hashFields.put("ap_desc", "apDesc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("csr_slip_no", "csrSlipNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("attach", "attach");
		return this.hashFields;
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
	 * @return ppayHirNo
	 */
	public String getPpayHirNo() {
		return this.ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @return oaStlStsCd
	 */
	public String getOaStlStsCd() {
		return this.oaStlStsCd;
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
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return lcl
	 */
	public String getLcl() {
		return this.lcl;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
	}
	
	/**
	 * Column Info
	 * @return internalMemo
	 */
	public String getInternalMemo() {
		return this.internalMemo;
	}
	
	/**
	 * Column Info
	 * @return condCsrSlipNo
	 */
	public String getCondCsrSlipNo() {
		return this.condCsrSlipNo;
	}
	
	/**
	 * Column Info
	 * @return acctItmNm
	 */
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	
	/**
	 * Column Info
	 * @return matchingCsrSlipNo
	 */
	public String getMatchingCsrSlipNo() {
		return this.matchingCsrSlipNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return oaLocCd
	 */
	public String getOaLocCd() {
		return this.oaLocCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return csrSlipNo
	 */
	public String getCsrSlipNo() {
		return this.csrSlipNo;
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
	 * @return acctItmSeq
	 */
	public String getAcctItmSeq() {
		return this.acctItmSeq;
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
	 * @return attach
	 */
	public String getAttach() {
		return this.attach;
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
	 * @param ppayHirNo
	 */
	public void setPpayHirNo(String ppayHirNo) {
		this.ppayHirNo = ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @param oaStlStsCd
	 */
	public void setOaStlStsCd(String oaStlStsCd) {
		this.oaStlStsCd = oaStlStsCd;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param lcl
	 */
	public void setLcl(String lcl) {
		this.lcl = lcl;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
	}
	
	/**
	 * Column Info
	 * @param internalMemo
	 */
	public void setInternalMemo(String internalMemo) {
		this.internalMemo = internalMemo;
	}
	
	/**
	 * Column Info
	 * @param condCsrSlipNo
	 */
	public void setCondCsrSlipNo(String condCsrSlipNo) {
		this.condCsrSlipNo = condCsrSlipNo;
	}
	
	/**
	 * Column Info
	 * @param acctItmNm
	 */
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
	}
	
	/**
	 * Column Info
	 * @param matchingCsrSlipNo
	 */
	public void setMatchingCsrSlipNo(String matchingCsrSlipNo) {
		this.matchingCsrSlipNo = matchingCsrSlipNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param oaLocCd
	 */
	public void setOaLocCd(String oaLocCd) {
		this.oaLocCd = oaLocCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param csrSlipNo
	 */
	public void setCsrSlipNo(String csrSlipNo) {
		this.csrSlipNo = csrSlipNo;
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
	 * @param acctItmSeq
	 */
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
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
	 * @param attach
	 */
	public void setAttach(String attach) {
		this.attach = attach;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setPpayHirNo(JSPUtil.getParameter(request, prefix + "ppay_hir_no", ""));
		setOaStlStsCd(JSPUtil.getParameter(request, prefix + "oa_stl_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmount(JSPUtil.getParameter(request, prefix + "amount", ""));
		setLcl(JSPUtil.getParameter(request, prefix + "lcl", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setExRate(JSPUtil.getParameter(request, prefix + "ex_rate", ""));
		setInternalMemo(JSPUtil.getParameter(request, prefix + "internal_memo", ""));
		setCondCsrSlipNo(JSPUtil.getParameter(request, prefix + "cond_csr_slip_no", ""));
		setAcctItmNm(JSPUtil.getParameter(request, prefix + "acct_itm_nm", ""));
		setMatchingCsrSlipNo(JSPUtil.getParameter(request, prefix + "matching_csr_slip_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setOaLocCd(JSPUtil.getParameter(request, prefix + "oa_loc_cd", ""));
		setApDesc(JSPUtil.getParameter(request, prefix + "ap_desc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCsrSlipNo(JSPUtil.getParameter(request, prefix + "csr_slip_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, prefix + "acct_itm_seq", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setAttach(JSPUtil.getParameter(request, prefix + "attach", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNewOwnerAccountListVO[]
	 */
	public SearchNewOwnerAccountListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNewOwnerAccountListVO[]
	 */
	public SearchNewOwnerAccountListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNewOwnerAccountListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no", length));
			String[] oaStlStsCd = (JSPUtil.getParameter(request, prefix	+ "oa_stl_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] lcl = (JSPUtil.getParameter(request, prefix	+ "lcl", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate", length));
			String[] internalMemo = (JSPUtil.getParameter(request, prefix	+ "internal_memo", length));
			String[] condCsrSlipNo = (JSPUtil.getParameter(request, prefix	+ "cond_csr_slip_no", length));
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm", length));
			String[] matchingCsrSlipNo = (JSPUtil.getParameter(request, prefix	+ "matching_csr_slip_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] oaLocCd = (JSPUtil.getParameter(request, prefix	+ "oa_loc_cd", length));
			String[] apDesc = (JSPUtil.getParameter(request, prefix	+ "ap_desc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] csrSlipNo = (JSPUtil.getParameter(request, prefix	+ "csr_slip_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] attach = (JSPUtil.getParameter(request, prefix	+ "attach", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNewOwnerAccountListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ppayHirNo[i] != null)
					model.setPpayHirNo(ppayHirNo[i]);
				if (oaStlStsCd[i] != null)
					model.setOaStlStsCd(oaStlStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (lcl[i] != null)
					model.setLcl(lcl[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (internalMemo[i] != null)
					model.setInternalMemo(internalMemo[i]);
				if (condCsrSlipNo[i] != null)
					model.setCondCsrSlipNo(condCsrSlipNo[i]);
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (matchingCsrSlipNo[i] != null)
					model.setMatchingCsrSlipNo(matchingCsrSlipNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (oaLocCd[i] != null)
					model.setOaLocCd(oaLocCd[i]);
				if (apDesc[i] != null)
					model.setApDesc(apDesc[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (csrSlipNo[i] != null)
					model.setCsrSlipNo(csrSlipNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (attach[i] != null)
					model.setAttach(attach[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNewOwnerAccountListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNewOwnerAccountListVO[]
	 */
	public SearchNewOwnerAccountListVO[] getSearchNewOwnerAccountListVOs(){
		SearchNewOwnerAccountListVO[] vos = (SearchNewOwnerAccountListVO[])models.toArray(new SearchNewOwnerAccountListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaStlStsCd = this.oaStlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcl = this.lcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internalMemo = this.internalMemo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condCsrSlipNo = this.condCsrSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matchingCsrSlipNo = this.matchingCsrSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaLocCd = this.oaLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc = this.apDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrSlipNo = this.csrSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attach = this.attach .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
