/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AROutstandingDtlVO.java
*@FileTitle : AROutstandingDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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

public class AROutstandingDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AROutstandingDtlVO> models = new ArrayList<AROutstandingDtlVO>();
	
	/* Column Info */
	private String wrtfAmt = null;
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String balUsdAmt = null;
	/* Column Info */
	private String balLoclAmt = null;
	/* Column Info */
	private String invUpdDt = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String balUpdDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String balAmt = null;
	/* Column Info */
	private String adjUpdDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctUpdDt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String ofcCurrCd = null;
	/* Column Info */
	private String wrtfUpdDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loclXchRt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String rctAmt = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String otsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AROutstandingDtlVO() {}

	public AROutstandingDtlVO(String ibflag, String pagerows, String rhqCd, String otsOfcCd, String blNo, String invNo, String blCurrCd, String invAmt, String invUpdDt, String rctAmt, String rctUpdDt, String adjAmt, String adjUpdDt, String balAmt, String balUpdDt, String wrtfAmt, String wrtfUpdDt, String loclXchRt, String usdXchRt, String balLoclAmt, String balUsdAmt, String creUsrId, String creDt, String updUsrId, String updDt, String chgTpCd, String ofcCurrCd) {
		this.wrtfAmt = wrtfAmt;
		this.chgTpCd = chgTpCd;
		this.balUsdAmt = balUsdAmt;
		this.balLoclAmt = balLoclAmt;
		this.invUpdDt = invUpdDt;
		this.usdXchRt = usdXchRt;
		this.creDt = creDt;
		this.balUpdDt = balUpdDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.balAmt = balAmt;
		this.adjUpdDt = adjUpdDt;
		this.ibflag = ibflag;
		this.rctUpdDt = rctUpdDt;
		this.invAmt = invAmt;
		this.ofcCurrCd = ofcCurrCd;
		this.wrtfUpdDt = wrtfUpdDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.loclXchRt = loclXchRt;
		this.rhqCd = rhqCd;
		this.blCurrCd = blCurrCd;
		this.rctAmt = rctAmt;
		this.adjAmt = adjAmt;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wrtf_amt", getWrtfAmt());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("bal_usd_amt", getBalUsdAmt());
		this.hashColumns.put("bal_locl_amt", getBalLoclAmt());
		this.hashColumns.put("inv_upd_dt", getInvUpdDt());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bal_upd_dt", getBalUpdDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("adj_upd_dt", getAdjUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_upd_dt", getRctUpdDt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("ofc_curr_cd", getOfcCurrCd());
		this.hashColumns.put("wrtf_upd_dt", getWrtfUpdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("rct_amt", getRctAmt());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wrtf_amt", "wrtfAmt");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("bal_usd_amt", "balUsdAmt");
		this.hashFields.put("bal_locl_amt", "balLoclAmt");
		this.hashFields.put("inv_upd_dt", "invUpdDt");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bal_upd_dt", "balUpdDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("adj_upd_dt", "adjUpdDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_upd_dt", "rctUpdDt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("ofc_curr_cd", "ofcCurrCd");
		this.hashFields.put("wrtf_upd_dt", "wrtfUpdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return wrtfAmt
	 */
	public String getWrtfAmt() {
		return this.wrtfAmt;
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
	 * @return balUsdAmt
	 */
	public String getBalUsdAmt() {
		return this.balUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return balLoclAmt
	 */
	public String getBalLoclAmt() {
		return this.balLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return invUpdDt
	 */
	public String getInvUpdDt() {
		return this.invUpdDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return balUpdDt
	 */
	public String getBalUpdDt() {
		return this.balUpdDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
	}
	
	/**
	 * Column Info
	 * @return adjUpdDt
	 */
	public String getAdjUpdDt() {
		return this.adjUpdDt;
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
	 * @return rctUpdDt
	 */
	public String getRctUpdDt() {
		return this.rctUpdDt;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return wrtfUpdDt
	 */
	public String getWrtfUpdDt() {
		return this.wrtfUpdDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return rctAmt
	 */
	public String getRctAmt() {
		return this.rctAmt;
	}
	
	/**
	 * Column Info
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	

	/**
	 * Column Info
	 * @param wrtfAmt
	 */
	public void setWrtfAmt(String wrtfAmt) {
		this.wrtfAmt = wrtfAmt;
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
	 * @param balUsdAmt
	 */
	public void setBalUsdAmt(String balUsdAmt) {
		this.balUsdAmt = balUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param balLoclAmt
	 */
	public void setBalLoclAmt(String balLoclAmt) {
		this.balLoclAmt = balLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param invUpdDt
	 */
	public void setInvUpdDt(String invUpdDt) {
		this.invUpdDt = invUpdDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param balUpdDt
	 */
	public void setBalUpdDt(String balUpdDt) {
		this.balUpdDt = balUpdDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}
	
	/**
	 * Column Info
	 * @param adjUpdDt
	 */
	public void setAdjUpdDt(String adjUpdDt) {
		this.adjUpdDt = adjUpdDt;
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
	 * @param rctUpdDt
	 */
	public void setRctUpdDt(String rctUpdDt) {
		this.rctUpdDt = rctUpdDt;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param wrtfUpdDt
	 */
	public void setWrtfUpdDt(String wrtfUpdDt) {
		this.wrtfUpdDt = wrtfUpdDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param rctAmt
	 */
	public void setRctAmt(String rctAmt) {
		this.rctAmt = rctAmt;
	}
	
	/**
	 * Column Info
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
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
		setWrtfAmt(JSPUtil.getParameter(request, prefix + "wrtf_amt", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setBalUsdAmt(JSPUtil.getParameter(request, prefix + "bal_usd_amt", ""));
		setBalLoclAmt(JSPUtil.getParameter(request, prefix + "bal_locl_amt", ""));
		setInvUpdDt(JSPUtil.getParameter(request, prefix + "inv_upd_dt", ""));
		setUsdXchRt(JSPUtil.getParameter(request, prefix + "usd_xch_rt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBalUpdDt(JSPUtil.getParameter(request, prefix + "bal_upd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
		setAdjUpdDt(JSPUtil.getParameter(request, prefix + "adj_upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctUpdDt(JSPUtil.getParameter(request, prefix + "rct_upd_dt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setOfcCurrCd(JSPUtil.getParameter(request, prefix + "ofc_curr_cd", ""));
		setWrtfUpdDt(JSPUtil.getParameter(request, prefix + "wrtf_upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLoclXchRt(JSPUtil.getParameter(request, prefix + "locl_xch_rt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setRctAmt(JSPUtil.getParameter(request, prefix + "rct_amt", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AROutstandingDtlVO[]
	 */
	public AROutstandingDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AROutstandingDtlVO[]
	 */
	public AROutstandingDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AROutstandingDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] wrtfAmt = (JSPUtil.getParameter(request, prefix	+ "wrtf_amt", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] balUsdAmt = (JSPUtil.getParameter(request, prefix	+ "bal_usd_amt", length));
			String[] balLoclAmt = (JSPUtil.getParameter(request, prefix	+ "bal_locl_amt", length));
			String[] invUpdDt = (JSPUtil.getParameter(request, prefix	+ "inv_upd_dt", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] balUpdDt = (JSPUtil.getParameter(request, prefix	+ "bal_upd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] adjUpdDt = (JSPUtil.getParameter(request, prefix	+ "adj_upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctUpdDt = (JSPUtil.getParameter(request, prefix	+ "rct_upd_dt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] ofcCurrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_curr_cd", length));
			String[] wrtfUpdDt = (JSPUtil.getParameter(request, prefix	+ "wrtf_upd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loclXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] rctAmt = (JSPUtil.getParameter(request, prefix	+ "rct_amt", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AROutstandingDtlVO();
				if (wrtfAmt[i] != null)
					model.setWrtfAmt(wrtfAmt[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (balUsdAmt[i] != null)
					model.setBalUsdAmt(balUsdAmt[i]);
				if (balLoclAmt[i] != null)
					model.setBalLoclAmt(balLoclAmt[i]);
				if (invUpdDt[i] != null)
					model.setInvUpdDt(invUpdDt[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (balUpdDt[i] != null)
					model.setBalUpdDt(balUpdDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (adjUpdDt[i] != null)
					model.setAdjUpdDt(adjUpdDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctUpdDt[i] != null)
					model.setRctUpdDt(rctUpdDt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (ofcCurrCd[i] != null)
					model.setOfcCurrCd(ofcCurrCd[i]);
				if (wrtfUpdDt[i] != null)
					model.setWrtfUpdDt(wrtfUpdDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loclXchRt[i] != null)
					model.setLoclXchRt(loclXchRt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (rctAmt[i] != null)
					model.setRctAmt(rctAmt[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAROutstandingDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AROutstandingDtlVO[]
	 */
	public AROutstandingDtlVO[] getAROutstandingDtlVOs(){
		AROutstandingDtlVO[] vos = (AROutstandingDtlVO[])models.toArray(new AROutstandingDtlVO[models.size()]);
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
		this.wrtfAmt = this.wrtfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balUsdAmt = this.balUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balLoclAmt = this.balLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUpdDt = this.invUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balUpdDt = this.balUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjUpdDt = this.adjUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUpdDt = this.rctUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCurrCd = this.ofcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfUpdDt = this.wrtfUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt = this.loclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt = this.rctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
