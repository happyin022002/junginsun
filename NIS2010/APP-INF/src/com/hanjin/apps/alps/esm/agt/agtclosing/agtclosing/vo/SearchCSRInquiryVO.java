/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchCSRInquiryVO.java
*@FileTitle : SearchCSRInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.09
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.11.09 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo;

import java.lang.reflect.Field;
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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCSRInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCSRInquiryVO> models = new ArrayList<SearchCSRInquiryVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String localAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String invDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String commStndCostCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String sRVvd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String xchRt = null;
	/* Column Info */
	private String sStsCd = null;
	/* Column Info */
	private String agnOfcCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String revVvdCd = null;
	/* Column Info */
	private String sCsrNo = null;
	/* Column Info */
	private String multiCsrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCSRInquiryVO() {}

	public SearchCSRInquiryVO(String ibflag, String pagerows, String agnOfcCd, String csrNo, String invDesc, String commStndCostCd, String usdAmt, String localAmt, String revVvdCd, String xchRt, String currCd, String status, String creDt, String ifDt, String payDt, String creUsrId, String aproUsrId, String sCsrNo, String arOfcCd, String agnCd, String sRVvd, String sStsCd, String dateOption, String searchDtTo, String searchDtFr, String multiCsrNo) {
		this.ifDt = ifDt;
		this.payDt = payDt;
		this.currCd = currCd;
		this.creDt = creDt;
		this.searchDtTo = searchDtTo;
		this.localAmt = localAmt;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.invDesc = invDesc;
		this.ibflag = ibflag;
		this.dateOption = dateOption;
		this.searchDtFr = searchDtFr;
		this.commStndCostCd = commStndCostCd;
		this.csrNo = csrNo;
		this.sRVvd = sRVvd;
		this.status = status;
		this.xchRt = xchRt;
		this.sStsCd = sStsCd;
		this.agnOfcCd = agnOfcCd;
		this.arOfcCd = arOfcCd;
		this.usdAmt = usdAmt;
		this.creUsrId = creUsrId;
		this.aproUsrId = aproUsrId;
		this.revVvdCd = revVvdCd;
		this.sCsrNo = sCsrNo;
		this.multiCsrNo = multiCsrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("local_amt", getLocalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("comm_stnd_cost_cd", getCommStndCostCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("s_r_vvd", getSRVvd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("xch_rt", getXchRt());
		this.hashColumns.put("s_sts_cd", getSStsCd());
		this.hashColumns.put("agn_ofc_cd", getAgnOfcCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());
		this.hashColumns.put("s_csr_no", getSCsrNo());
		this.hashColumns.put("multi_csr_no", getMultiCsrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("local_amt", "localAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("comm_stnd_cost_cd", "commStndCostCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("s_r_vvd", "sRVvd");
		this.hashFields.put("status", "status");
		this.hashFields.put("xch_rt", "xchRt");
		this.hashFields.put("s_sts_cd", "sStsCd");
		this.hashFields.put("agn_ofc_cd", "agnOfcCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("s_csr_no", "sCsrNo");
		this.hashFields.put("multi_csr_no", "multiCsrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return localAmt
	 */
	public String getLocalAmt() {
		return this.localAmt;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
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
	 * @return dateOption
	 */
	public String getDateOption() {
		return this.dateOption;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
	}
	
	/**
	 * Column Info
	 * @return commStndCostCd
	 */
	public String getCommStndCostCd() {
		return this.commStndCostCd;
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
	 * @return sRVvd
	 */
	public String getSRVvd() {
		return this.sRVvd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return xchRt
	 */
	public String getXchRt() {
		return this.xchRt;
	}
	
	/**
	 * Column Info
	 * @return sStsCd
	 */
	public String getSStsCd() {
		return this.sStsCd;
	}
	
	/**
	 * Column Info
	 * @return agnOfcCd
	 */
	public String getAgnOfcCd() {
		return this.agnOfcCd;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return revVvdCd
	 */
	public String getRevVvdCd() {
		return this.revVvdCd;
	}
	
	/**
	 * Column Info
	 * @return sCsrNo
	 */
	public String getSCsrNo() {
		return this.sCsrNo;
	}
	
	/**
	 * Column Info
	 * @return multiCsrNo
	 */
	public String getMultiCsrNo() {
		return this.multiCsrNo;
	}
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param localAmt
	 */
	public void setLocalAmt(String localAmt) {
		this.localAmt = localAmt;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
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
	 * @param dateOption
	 */
	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Column Info
	 * @param commStndCostCd
	 */
	public void setCommStndCostCd(String commStndCostCd) {
		this.commStndCostCd = commStndCostCd;
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
	 * @param sRVvd
	 */
	public void setSRVvd(String sRVvd) {
		this.sRVvd = sRVvd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param xchRt
	 */
	public void setXchRt(String xchRt) {
		this.xchRt = xchRt;
	}
	
	/**
	 * Column Info
	 * @param sStsCd
	 */
	public void setSStsCd(String sStsCd) {
		this.sStsCd = sStsCd;
	}
	
	/**
	 * Column Info
	 * @param agnOfcCd
	 */
	public void setAgnOfcCd(String agnOfcCd) {
		this.agnOfcCd = agnOfcCd;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param revVvdCd
	 */
	public void setRevVvdCd(String revVvdCd) {
		this.revVvdCd = revVvdCd;
	}
	
	/**
	 * Column Info
	 * @param sCsrNo
	 */
	public void setSCsrNo(String sCsrNo) {
		this.sCsrNo = sCsrNo;
	}
	
	/**
	 * Column Info
	 * @param multiCsrNo
	 */
	public void setMultiCsrNo(String multiCsrNo) {
		this.multiCsrNo = multiCsrNo;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setLocalAmt(JSPUtil.getParameter(request, prefix + "local_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDateOption(JSPUtil.getParameter(request, prefix + "date_option", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setCommStndCostCd(JSPUtil.getParameter(request, prefix + "comm_stnd_cost_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setSRVvd(JSPUtil.getParameter(request, prefix + "s_r_vvd", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setXchRt(JSPUtil.getParameter(request, prefix + "xch_rt", ""));
		setSStsCd(JSPUtil.getParameter(request, prefix + "s_sts_cd", ""));
		setAgnOfcCd(JSPUtil.getParameter(request, prefix + "agn_ofc_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setRevVvdCd(JSPUtil.getParameter(request, prefix + "rev_vvd_cd", ""));
		setSCsrNo(JSPUtil.getParameter(request, prefix + "s_csr_no", ""));
		setMultiCsrNo(JSPUtil.getParameter(request, prefix + "multi_csr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCSRInquiryVO[]
	 */
	public SearchCSRInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCSRInquiryVO[]
	 */
	public SearchCSRInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCSRInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] localAmt = (JSPUtil.getParameter(request, prefix	+ "local_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] commStndCostCd = (JSPUtil.getParameter(request, prefix	+ "comm_stnd_cost_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] sRVvd = (JSPUtil.getParameter(request, prefix	+ "s_r_vvd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] xchRt = (JSPUtil.getParameter(request, prefix	+ "xch_rt", length));
			String[] sStsCd = (JSPUtil.getParameter(request, prefix	+ "s_sts_cd", length));
			String[] agnOfcCd = (JSPUtil.getParameter(request, prefix	+ "agn_ofc_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] revVvdCd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_cd", length));
			String[] sCsrNo = (JSPUtil.getParameter(request, prefix	+ "s_csr_no", length));
			String[] multiCsrNo = (JSPUtil.getParameter(request, prefix	+ "multi_csr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCSRInquiryVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (localAmt[i] != null)
					model.setLocalAmt(localAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (commStndCostCd[i] != null)
					model.setCommStndCostCd(commStndCostCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (sRVvd[i] != null)
					model.setSRVvd(sRVvd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (xchRt[i] != null)
					model.setXchRt(xchRt[i]);
				if (sStsCd[i] != null)
					model.setSStsCd(sStsCd[i]);
				if (agnOfcCd[i] != null)
					model.setAgnOfcCd(agnOfcCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (revVvdCd[i] != null)
					model.setRevVvdCd(revVvdCd[i]);
				if (sCsrNo[i] != null)
					model.setSCsrNo(sCsrNo[i]);
				if (multiCsrNo[i] != null)
					model.setMultiCsrNo(multiCsrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCSRInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCSRInquiryVO[]
	 */
	public SearchCSRInquiryVO[] getSearchCSRInquiryVOs(){
		SearchCSRInquiryVO[] vos = (SearchCSRInquiryVO[])models.toArray(new SearchCSRInquiryVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localAmt = this.localAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commStndCostCd = this.commStndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRVvd = this.sRVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRt = this.xchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStsCd = this.sStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnOfcCd = this.agnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd = this.revVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCsrNo = this.sCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiCsrNo = this.multiCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
