/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustDtlListVO.java
*@FileTitle : AdjustDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdjustDtlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdjustDtlListVO> models = new ArrayList<AdjustDtlListVO>();
	
	/* Column Info */
	private String otsAdjSeq = null;
	/* Column Info */
	private String loclXchRt = null;
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String otsAdjBalAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String adjCrsCurrAmt = null;
	/* Column Info */
	private String otsDtlKey = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String otsBalAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String currDpPrcsKnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adjCrsCurrCd = null;
	/* Column Info */
	private String legrXchRt = null;
	/* Column Info */
	private String ofcCurrCd = null;
	/* Column Info */
	private String adjXchRt = null;
	/* Column Info */
	private String adjTpCd = null;
	/* Column Info */
	private String invOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AdjustDtlListVO() {}

	public AdjustDtlListVO(String ibflag, String pagerows, String chgTpCd, String blCurrCd, String otsBalAmt, String otsAdjBalAmt, String adjXchRt, String adjCrsCurrCd, String adjCrsCurrAmt, String otsAdjSeq, String rhqCd, String invOfcCd, String blNo, String invNo, String otsDtlKey, String adjTpCd, String creUsrId, String legrXchRt, String dpPrcsKnt, String currDpPrcsKnt, String ofcCurrCd, String loclXchRt, String usdXchRt) {
		this.otsAdjSeq = otsAdjSeq;
		this.loclXchRt = loclXchRt;
		this.chgTpCd = chgTpCd;
		this.otsAdjBalAmt = otsAdjBalAmt;
		this.rhqCd = rhqCd;
		this.blCurrCd = blCurrCd;
		this.usdXchRt = usdXchRt;
		this.adjCrsCurrAmt = adjCrsCurrAmt;
		this.otsDtlKey = otsDtlKey;
		this.blNo = blNo;
		this.otsBalAmt = otsBalAmt;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.invNo = invNo;
		this.currDpPrcsKnt = currDpPrcsKnt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.adjCrsCurrCd = adjCrsCurrCd;
		this.legrXchRt = legrXchRt;
		this.ofcCurrCd = ofcCurrCd;
		this.adjXchRt = adjXchRt;
		this.adjTpCd = adjTpCd;
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ots_adj_seq", getOtsAdjSeq());
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("ots_adj_bal_amt", getOtsAdjBalAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("adj_crs_curr_amt", getAdjCrsCurrAmt());
		this.hashColumns.put("ots_dtl_key", getOtsDtlKey());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ots_bal_amt", getOtsBalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("curr_dp_prcs_knt", getCurrDpPrcsKnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adj_crs_curr_cd", getAdjCrsCurrCd());
		this.hashColumns.put("legr_xch_rt", getLegrXchRt());
		this.hashColumns.put("ofc_curr_cd", getOfcCurrCd());
		this.hashColumns.put("adj_xch_rt", getAdjXchRt());
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ots_adj_seq", "otsAdjSeq");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("ots_adj_bal_amt", "otsAdjBalAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("adj_crs_curr_amt", "adjCrsCurrAmt");
		this.hashFields.put("ots_dtl_key", "otsDtlKey");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ots_bal_amt", "otsBalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("curr_dp_prcs_knt", "currDpPrcsKnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adj_crs_curr_cd", "adjCrsCurrCd");
		this.hashFields.put("legr_xch_rt", "legrXchRt");
		this.hashFields.put("ofc_curr_cd", "ofcCurrCd");
		this.hashFields.put("adj_xch_rt", "adjXchRt");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return otsAdjSeq
	 */
	public String getOtsAdjSeq() {
		return this.otsAdjSeq;
	}
	
	/**
	 * Column Info
	 * @return loclXchRt
	 */
	public String getLoclXchRt() {
		return this.loclXchRt;
	}
	
	/**
	 * Column Info
	 * @return chgTpCd
	 */
	public String getChgTpCd() {
		return this.chgTpCd;
	}
	
	/**
	 * Column Info
	 * @return otsAdjBalAmt
	 */
	public String getOtsAdjBalAmt() {
		return this.otsAdjBalAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return blCurrCd
	 */
	public String getBlCurrCd() {
		return this.blCurrCd;
	}
	
	/**
	 * Column Info
	 * @return usdXchRt
	 */
	public String getUsdXchRt() {
		return this.usdXchRt;
	}
	
	/**
	 * Column Info
	 * @return adjCrsCurrAmt
	 */
	public String getAdjCrsCurrAmt() {
		return this.adjCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @return otsDtlKey
	 */
	public String getOtsDtlKey() {
		return this.otsDtlKey;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return otsBalAmt
	 */
	public String getOtsBalAmt() {
		return this.otsBalAmt;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return currDpPrcsKnt
	 */
	public String getCurrDpPrcsKnt() {
		return this.currDpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return adjCrsCurrCd
	 */
	public String getAdjCrsCurrCd() {
		return this.adjCrsCurrCd;
	}
	
	/**
	 * Column Info
	 * @return legrXchRt
	 */
	public String getLegrXchRt() {
		return this.legrXchRt;
	}
	
	/**
	 * Column Info
	 * @return ofcCurrCd
	 */
	public String getOfcCurrCd() {
		return this.ofcCurrCd;
	}
	
	/**
	 * Column Info
	 * @return adjXchRt
	 */
	public String getAdjXchRt() {
		return this.adjXchRt;
	}
	
	/**
	 * Column Info
	 * @return adjTpCd
	 */
	public String getAdjTpCd() {
		return this.adjTpCd;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	

	/**
	 * Column Info
	 * @param otsAdjSeq
	 */
	public void setOtsAdjSeq(String otsAdjSeq) {
		this.otsAdjSeq = otsAdjSeq;
	}
	
	/**
	 * Column Info
	 * @param loclXchRt
	 */
	public void setLoclXchRt(String loclXchRt) {
		this.loclXchRt = loclXchRt;
	}
	
	/**
	 * Column Info
	 * @param chgTpCd
	 */
	public void setChgTpCd(String chgTpCd) {
		this.chgTpCd = chgTpCd;
	}
	
	/**
	 * Column Info
	 * @param otsAdjBalAmt
	 */
	public void setOtsAdjBalAmt(String otsAdjBalAmt) {
		this.otsAdjBalAmt = otsAdjBalAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param blCurrCd
	 */
	public void setBlCurrCd(String blCurrCd) {
		this.blCurrCd = blCurrCd;
	}
	
	/**
	 * Column Info
	 * @param usdXchRt
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
	}
	
	/**
	 * Column Info
	 * @param adjCrsCurrAmt
	 */
	public void setAdjCrsCurrAmt(String adjCrsCurrAmt) {
		this.adjCrsCurrAmt = adjCrsCurrAmt;
	}
	
	/**
	 * Column Info
	 * @param otsDtlKey
	 */
	public void setOtsDtlKey(String otsDtlKey) {
		this.otsDtlKey = otsDtlKey;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param otsBalAmt
	 */
	public void setOtsBalAmt(String otsBalAmt) {
		this.otsBalAmt = otsBalAmt;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param currDpPrcsKnt
	 */
	public void setCurrDpPrcsKnt(String currDpPrcsKnt) {
		this.currDpPrcsKnt = currDpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param adjCrsCurrCd
	 */
	public void setAdjCrsCurrCd(String adjCrsCurrCd) {
		this.adjCrsCurrCd = adjCrsCurrCd;
	}
	
	/**
	 * Column Info
	 * @param legrXchRt
	 */
	public void setLegrXchRt(String legrXchRt) {
		this.legrXchRt = legrXchRt;
	}
	
	/**
	 * Column Info
	 * @param ofcCurrCd
	 */
	public void setOfcCurrCd(String ofcCurrCd) {
		this.ofcCurrCd = ofcCurrCd;
	}
	
	/**
	 * Column Info
	 * @param adjXchRt
	 */
	public void setAdjXchRt(String adjXchRt) {
		this.adjXchRt = adjXchRt;
	}
	
	/**
	 * Column Info
	 * @param adjTpCd
	 */
	public void setAdjTpCd(String adjTpCd) {
		this.adjTpCd = adjTpCd;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
		setOtsAdjSeq(JSPUtil.getParameter(request, prefix + "ots_adj_seq", ""));
		setLoclXchRt(JSPUtil.getParameter(request, prefix + "locl_xch_rt", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setOtsAdjBalAmt(JSPUtil.getParameter(request, prefix + "ots_adj_bal_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request, prefix + "usd_xch_rt", ""));
		setAdjCrsCurrAmt(JSPUtil.getParameter(request, prefix + "adj_crs_curr_amt", ""));
		setOtsDtlKey(JSPUtil.getParameter(request, prefix + "ots_dtl_key", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setOtsBalAmt(JSPUtil.getParameter(request, prefix + "ots_bal_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCurrDpPrcsKnt(JSPUtil.getParameter(request, prefix + "curr_dp_prcs_knt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAdjCrsCurrCd(JSPUtil.getParameter(request, prefix + "adj_crs_curr_cd", ""));
		setLegrXchRt(JSPUtil.getParameter(request, prefix + "legr_xch_rt", ""));
		setOfcCurrCd(JSPUtil.getParameter(request, prefix + "ofc_curr_cd", ""));
		setAdjXchRt(JSPUtil.getParameter(request, prefix + "adj_xch_rt", ""));
		setAdjTpCd(JSPUtil.getParameter(request, prefix + "adj_tp_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjustDtlListVO[]
	 */
	public AdjustDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjustDtlListVO[]
	 */
	public AdjustDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdjustDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] otsAdjSeq = (JSPUtil.getParameter(request, prefix	+ "ots_adj_seq", length));
			String[] loclXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] otsAdjBalAmt = (JSPUtil.getParameter(request, prefix	+ "ots_adj_bal_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] adjCrsCurrAmt = (JSPUtil.getParameter(request, prefix	+ "adj_crs_curr_amt", length));
			String[] otsDtlKey = (JSPUtil.getParameter(request, prefix	+ "ots_dtl_key", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] otsBalAmt = (JSPUtil.getParameter(request, prefix	+ "ots_bal_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] currDpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "curr_dp_prcs_knt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adjCrsCurrCd = (JSPUtil.getParameter(request, prefix	+ "adj_crs_curr_cd", length));
			String[] legrXchRt = (JSPUtil.getParameter(request, prefix	+ "legr_xch_rt", length));
			String[] ofcCurrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_curr_cd", length));
			String[] adjXchRt = (JSPUtil.getParameter(request, prefix	+ "adj_xch_rt", length));
			String[] adjTpCd = (JSPUtil.getParameter(request, prefix	+ "adj_tp_cd", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdjustDtlListVO();
				if (otsAdjSeq[i] != null)
					model.setOtsAdjSeq(otsAdjSeq[i]);
				if (loclXchRt[i] != null)
					model.setLoclXchRt(loclXchRt[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (otsAdjBalAmt[i] != null)
					model.setOtsAdjBalAmt(otsAdjBalAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (adjCrsCurrAmt[i] != null)
					model.setAdjCrsCurrAmt(adjCrsCurrAmt[i]);
				if (otsDtlKey[i] != null)
					model.setOtsDtlKey(otsDtlKey[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (otsBalAmt[i] != null)
					model.setOtsBalAmt(otsBalAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (currDpPrcsKnt[i] != null)
					model.setCurrDpPrcsKnt(currDpPrcsKnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adjCrsCurrCd[i] != null)
					model.setAdjCrsCurrCd(adjCrsCurrCd[i]);
				if (legrXchRt[i] != null)
					model.setLegrXchRt(legrXchRt[i]);
				if (ofcCurrCd[i] != null)
					model.setOfcCurrCd(ofcCurrCd[i]);
				if (adjXchRt[i] != null)
					model.setAdjXchRt(adjXchRt[i]);
				if (adjTpCd[i] != null)
					model.setAdjTpCd(adjTpCd[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdjustDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjustDtlListVO[]
	 */
	public AdjustDtlListVO[] getAdjustDtlListVOs(){
		AdjustDtlListVO[] vos = (AdjustDtlListVO[])models.toArray(new AdjustDtlListVO[models.size()]);
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
		this.otsAdjSeq = this.otsAdjSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt = this.loclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAdjBalAmt = this.otsAdjBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjCrsCurrAmt = this.adjCrsCurrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlKey = this.otsDtlKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalAmt = this.otsBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currDpPrcsKnt = this.currDpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjCrsCurrCd = this.adjCrsCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.legrXchRt = this.legrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCurrCd = this.ofcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjXchRt = this.adjXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd = this.adjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
