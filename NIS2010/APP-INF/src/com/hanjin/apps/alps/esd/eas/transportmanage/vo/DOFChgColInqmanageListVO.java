/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DOFChgColInqmanageListVO.java
*@FileTitle : DOFChgColInqmanageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 최진오
*@LastVersion : 1.0
* 2009.10.21 최진오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.transportmanage.vo;

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
 * @author 최진오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DOFChgColInqmanageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DOFChgColInqmanageListVO> models = new ArrayList<DOFChgColInqmanageListVO>();
	
	/* Column Info */
	private String searchChoice = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String merCd = null;
	/* Column Info */
	private String haulCd = null;
	/* Column Info */
	private String oldOfcCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String fromtrodate = null;
	/* Column Info */
	private String totrodate = null;
	/* Column Info */
	private String tromonth = null;
	/* Column Info */
	private String ctrlUserId = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String returnCy = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String srcOfc = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String mtRtnMth = null;
	/* Column Info */
	private String fmMtRtnPrd = null;
	/* Column Info */
	private String toMtRtnPrd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String scRfaTaa = null;
	/* Column Info */
	private String mtAppliedDt = null;
	/* Column Info */
	private String rtaRt = null;
	/* Column Info */
	private String selTpCd = null;
	/* Column Info */
	private String rfaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DOFChgColInqmanageListVO() {}

	public DOFChgColInqmanageListVO(String ibflag, String pagerows, String ctrlOfcCd, String searchChoice, String tromonth, String fromtrodate, String totrodate, String returnCy, String custCd, String custNm, String custTp, String merCd, String haulCd, String ctrlUserId, String oldOfcCd, String srcOfc,String bkgNo,String refNo,String mtRtnMth,String fmMtRtnPrd,String toMtRtnPrd,String deTermCd,String bkgQty,String scRfaTaa,String mtAppliedDt,String rtaRt, String selTpCd, String rfaNo) {
		this.searchChoice = searchChoice;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.custTp = custTp;
		this.merCd = merCd;
		this.haulCd = haulCd;
		this.oldOfcCd = oldOfcCd;
		this.custCd = custCd;
		this.fromtrodate = fromtrodate;
		this.totrodate = totrodate;
		this.tromonth = tromonth;
		this.ctrlUserId = ctrlUserId;
		this.ctrlOfcCd = ctrlOfcCd;
		this.returnCy = returnCy;
		this.pagerows = pagerows;
		this.srcOfc = srcOfc;
		
		this.bkgNo = bkgNo;
		this.refNo = refNo;
		this.mtRtnMth = mtRtnMth;
		this.fmMtRtnPrd = fmMtRtnPrd;
		this.toMtRtnPrd = toMtRtnPrd;
		this.deTermCd = deTermCd;
		this.bkgQty = bkgQty;
		this.scRfaTaa = scRfaTaa;
		this.mtAppliedDt = mtAppliedDt;
		this.rtaRt = rtaRt;
		this.selTpCd = selTpCd;
		this.rfaNo = rfaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_choice", getSearchChoice());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("mer_cd", getMerCd());
		this.hashColumns.put("haul_cd", getHaulCd());
		this.hashColumns.put("old_ofc_cd", getOldOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("fromtrodate", getFromtrodate());
		this.hashColumns.put("totrodate", getTotrodate());
		this.hashColumns.put("tromonth", getTromonth());
		this.hashColumns.put("ctrl_user_id", getCtrlUserId());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("return_cy", getReturnCy());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("src_ofc", getSrcOfc());
		
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("mt_rtn_mth", getMtRtnMth());
		this.hashColumns.put("fm_mt_rtn_prd", getFmMtRtnPrd());
		this.hashColumns.put("to_mt_rtn_prd", getToMtRtnPrd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("sc_rfa_taa", getScRfaTaa());
		this.hashColumns.put("mt_applied_dt", getMtAppliedDt());
		this.hashColumns.put("rta_rt", getRtaRt());
		this.hashColumns.put("sel_tp_cd", getSelTpCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_choice", "searchChoice");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("mer_cd", "merCd");
		this.hashFields.put("haul_cd", "haulCd");
		this.hashFields.put("old_ofc_cd", "oldOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("fromtrodate", "fromtrodate");
		this.hashFields.put("totrodate", "totrodate");
		this.hashFields.put("tromonth", "tromonth");
		this.hashFields.put("ctrl_user_id", "ctrlUserId");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("return_cy", "returnCy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("src_ofc", "srcOfc");
		
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("mt_rtn_mth", "mtRtnMth");
		this.hashFields.put("fm_mt_rtn_prd", "fmMtRtnPrd");
		this.hashFields.put("to_mt_rtn_prd", "toMtRtnPrd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("sc_rfa_taa", "scRfaTaa");
		this.hashFields.put("mt_applied_dt", "mtAppliedDt");
		this.hashFields.put("rta_rt", "rtaRt");
		this.hashFields.put("sel_tp_cd", "selTpCd");
		this.hashFields.put("rfa_no", "rfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchChoice
	 */
	public String getSearchChoice() {
		return this.searchChoice;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
	}
	
	/**
	 * Column Info
	 * @return merCd
	 */
	public String getMerCd() {
		return this.merCd;
	}
	
	/**
	 * Column Info
	 * @return haulCd
	 */
	public String getHaulCd() {
		return this.haulCd;
	}
	
	/**
	 * Column Info
	 * @return oldOfcCd
	 */
	public String getOldOfcCd() {
		return this.oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return fromtrodate
	 */
	public String getFromtrodate() {
		return this.fromtrodate;
	}
	
	/**
	 * Column Info
	 * @return totrodate
	 */
	public String getTotrodate() {
		return this.totrodate;
	}
	
	/**
	 * Column Info
	 * @return tromonth
	 */
	public String getTromonth() {
		return this.tromonth;
	}
	
	/**
	 * Column Info
	 * @return ctrlUserId
	 */
	public String getCtrlUserId() {
		return this.ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return returnCy
	 */
	public String getReturnCy() {
		return this.returnCy;
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
	 * @return srcOfc
	 */
	public String getSrcOfc() {
		return this.srcOfc;
	}

	/**
	 * Column Info
	 * @param searchChoice
	 */
	public void setSearchChoice(String searchChoice) {
		this.searchChoice = searchChoice;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
	}
	
	/**
	 * Column Info
	 * @param merCd
	 */
	public void setMerCd(String merCd) {
		this.merCd = merCd;
	}
	
	/**
	 * Column Info
	 * @param haulCd
	 */
	public void setHaulCd(String haulCd) {
		this.haulCd = haulCd;
	}
	
	/**
	 * Column Info
	 * @param oldOfcCd
	 */
	public void setOldOfcCd(String oldOfcCd) {
		this.oldOfcCd = oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param fromtrodate
	 */
	public void setFromtrodate(String fromtrodate) {
		this.fromtrodate = fromtrodate;
	}
	
	/**
	 * Column Info
	 * @param totrodate
	 */
	public void setTotrodate(String totrodate) {
		this.totrodate = totrodate;
	}
	
	/**
	 * Column Info
	 * @param tromonth
	 */
	public void setTromonth(String tromonth) {
		this.tromonth = tromonth;
	}
	
	/**
	 * Column Info
	 * @param ctrlUserId
	 */
	public void setCtrlUserId(String ctrlUserId) {
		this.ctrlUserId = ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param returnCy
	 */
	public void setReturnCy(String returnCy) {
		this.returnCy = returnCy;
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
	 * @param srcOfc
	 */
	public void setSrcOfc(String srcOfc) {
		this.srcOfc = srcOfc;
	}
		
		
	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the mtRtnMth
	 */
	public String getMtRtnMth() {
		return mtRtnMth;
	}

	/**
	 * @param mtRtnMth the mtRtnMth to set
	 */
	public void setMtRtnMth(String mtRtnMth) {
		this.mtRtnMth = mtRtnMth;
	}

	/**
	 * @return the fmMtRtnPrd
	 */
	public String getFmMtRtnPrd() {
		return fmMtRtnPrd;
	}

	/**
	 * @param fmMtRtnPrd the fmMtRtnPrd to set
	 */
	public void setFmMtRtnPrd(String fmMtRtnPrd) {
		this.fmMtRtnPrd = fmMtRtnPrd;
	}

	/**
	 * @return the toMtRtnPrd
	 */
	public String getToMtRtnPrd() {
		return toMtRtnPrd;
	}

	/**
	 * @param toMtRtnPrd the toMtRtnPrd to set
	 */
	public void setToMtRtnPrd(String toMtRtnPrd) {
		this.toMtRtnPrd = toMtRtnPrd;
	}

	/**
	 * @return the deTermCd
	 */
	public String getDeTermCd() {
		return deTermCd;
	}

	/**
	 * @param deTermCd the deTermCd to set
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}

	/**
	 * @return the bkgQty
	 */
	public String getBkgQty() {
		return bkgQty;
	}

	/**
	 * @param bkgQty the bkgQty to set
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}

	/**
	 * @return the scRfaTaa
	 */
	public String getScRfaTaa() {
		return scRfaTaa;
	}

	/**
	 * @param scRfaTaa the scRfaTaa to set
	 */
	public void setScRfaTaa(String scRfaTaa) {
		this.scRfaTaa = scRfaTaa;
	}

	/**
	 * @return the mtAppliedDt
	 */
	public String getMtAppliedDt() {
		return mtAppliedDt;
	}

	/**
	 * @param mtAppliedDt the mtAppliedDt to set
	 */
	public void setMtAppliedDt(String mtAppliedDt) {
		this.mtAppliedDt = mtAppliedDt;
	}

	/**
	 * @return the rtaRt
	 */
	public String getRtaRt() {
		return rtaRt;
	}

	/**
	 * @param rtaRt the rtaRt to set
	 */
	public void setRtaRt(String rtaRt) {
		this.rtaRt = rtaRt;
	}
	
	/**
	 * @return the selTpCd
	 */
	public String getSelTpCd() {
		return selTpCd;
	}

	/**
	 * @param selTpCd the selTpCd to set
	 */
	public void setSelTpCd(String selTpCd) {
		this.selTpCd = selTpCd;
	}

	
	/**
	 * @return the rfaNo
	 */
	public String getRfaNo() {
		return rfaNo;
	}

	/**
	 * @param rfaNo the rfaNo to set
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSearchChoice(JSPUtil.getParameter(request, "search_choice", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setCustTp(JSPUtil.getParameter(request, "cust_tp", ""));
		setMerCd(JSPUtil.getParameter(request, "mer_cd", ""));
		setHaulCd(JSPUtil.getParameter(request, "haul_cd", ""));
		setOldOfcCd(JSPUtil.getParameter(request, "old_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setFromtrodate(JSPUtil.getParameter(request, "fromtrodate", ""));
		setTotrodate(JSPUtil.getParameter(request, "totrodate", ""));
		setTromonth(JSPUtil.getParameter(request, "tromonth", ""));
		setCtrlUserId(JSPUtil.getParameter(request, "ctrl_user_id", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setReturnCy(JSPUtil.getParameter(request, "return_cy", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSrcOfc(JSPUtil.getParameter(request, "src_ofc", ""));
		
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setMtRtnMth(JSPUtil.getParameter(request, "mt_rtn_mth", ""));
		setFmMtRtnPrd(JSPUtil.getParameter(request, "fm_mt_rtn_prd", ""));
		setToMtRtnPrd(JSPUtil.getParameter(request, "to_mt_rtn_prd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgQty(JSPUtil.getParameter(request, "bkg_qty", ""));
		setScRfaTaa(JSPUtil.getParameter(request, "sc_rfa_taa", ""));
		setMtAppliedDt(JSPUtil.getParameter(request, "mt_applied_dt", ""));
		setRtaRt(JSPUtil.getParameter(request, "rta_rt", ""));
		setSelTpCd(JSPUtil.getParameter(request, "sel_tp_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DOFChgColInqmanageListVO[]
	 */
	public DOFChgColInqmanageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DOFChgColInqmanageListVO[]
	 */
	public DOFChgColInqmanageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DOFChgColInqmanageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchChoice = (JSPUtil.getParameter(request, prefix	+ "search_choice", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] merCd = (JSPUtil.getParameter(request, prefix	+ "mer_cd", length));
			String[] haulCd = (JSPUtil.getParameter(request, prefix	+ "haul_cd", length));
			String[] oldOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] fromtrodate = (JSPUtil.getParameter(request, prefix	+ "fromtrodate", length));
			String[] totrodate = (JSPUtil.getParameter(request, prefix	+ "totrodate", length));
			String[] tromonth = (JSPUtil.getParameter(request, prefix	+ "tromonth", length));
			String[] ctrlUserId = (JSPUtil.getParameter(request, prefix	+ "ctrl_user_id", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] returnCy = (JSPUtil.getParameter(request, prefix	+ "return_cy", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srcOfc = (JSPUtil.getParameter(request, prefix	+ "src_ofc", length));
			
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] mtRtnMth = (JSPUtil.getParameter(request, prefix	+ "mt_rtn_mth", length));
			String[] fmMtRtnPrd = (JSPUtil.getParameter(request, prefix	+ "fm_mt_rtn_prd", length));
			String[] toMtRtnPrd = (JSPUtil.getParameter(request, prefix	+ "to_mt_rtn_prd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] scRfaTaa = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_taa", length));
			String[] mtAppliedDt = (JSPUtil.getParameter(request, prefix	+ "mt_applied_dt", length));
			String[] rtaRt = (JSPUtil.getParameter(request, prefix	+ "rta_rt", length));
			String[] selTpCd = (JSPUtil.getParameter(request, prefix	+ "sel_tp_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DOFChgColInqmanageListVO();
				if (searchChoice[i] != null)
					model.setSearchChoice(searchChoice[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (merCd[i] != null)
					model.setMerCd(merCd[i]);
				if (haulCd[i] != null)
					model.setHaulCd(haulCd[i]);
				if (oldOfcCd[i] != null)
					model.setOldOfcCd(oldOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (fromtrodate[i] != null)
					model.setFromtrodate(fromtrodate[i]);
				if (totrodate[i] != null)
					model.setTotrodate(totrodate[i]);
				if (tromonth[i] != null)
					model.setTromonth(tromonth[i]);
				if (ctrlUserId[i] != null)
					model.setCtrlUserId(ctrlUserId[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (returnCy[i] != null)
					model.setReturnCy(returnCy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (srcOfc[i] != null)
					model.setSrcOfc(srcOfc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (mtRtnMth[i] != null)
					model.setMtRtnMth(mtRtnMth[i]);
				if (fmMtRtnPrd[i] != null)
					model.setFmMtRtnPrd(fmMtRtnPrd[i]);
				if (toMtRtnPrd[i] != null)
					model.setToMtRtnPrd(toMtRtnPrd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (scRfaTaa[i] != null)
					model.setScRfaTaa(scRfaTaa[i]);
				if (mtAppliedDt[i] != null)
					model.setMtAppliedDt(mtAppliedDt[i]);
				if (rtaRt[i] != null)
					model.setRtaRt(rtaRt[i]);
				if (selTpCd[i] != null)
					model.setSelTpCd(selTpCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDOFChgColInqmanageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DOFChgColInqmanageListVO[]
	 */
	public DOFChgColInqmanageListVO[] getDOFChgColInqmanageListVOs(){
		DOFChgColInqmanageListVO[] vos = (DOFChgColInqmanageListVO[])models.toArray(new DOFChgColInqmanageListVO[models.size()]);
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
		this.searchChoice = this.searchChoice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.merCd = this.merCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulCd = this.haulCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOfcCd = this.oldOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromtrodate = this.fromtrodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totrodate = this.totrodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tromonth = this.tromonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUserId = this.ctrlUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCy = this.returnCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcOfc = this.srcOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRtnMth = this.mtRtnMth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMtRtnPrd = this.fmMtRtnPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMtRtnPrd = this.toMtRtnPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaTaa = this.scRfaTaa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtAppliedDt = this.mtAppliedDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtaRt = this.rtaRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selTpCd = this.selTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
