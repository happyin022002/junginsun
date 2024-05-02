/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeReqVO.java
*@FileTitle : EqInterchangeReqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.27  
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo;

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

public class EqInterchangeReqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqInterchangeReqVO> models = new ArrayList<EqInterchangeReqVO>();
	
	/* Column Info */
	private String authSeq = null;
	/* Column Info */
	private String delCost = null;
	/* Column Info */
	private String porCost = null;
	/* Column Info */
	private String locFm = null;
	/* Column Info */
	private String locTo = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String addCost = null;
	/* Column Info */
	private String reqSeq = null;
	/* Column Info */
	private String authNo = null;
	/* Column Info */
	private String pucAmt = null;
	/* Column Info */
	private String reqNo = null;
	/* Column Info */
	private String tpszCd = null;
	/* Column Info */
	private String rqstQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sbiCost = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String freeDay = null;
	/* Column Info */
	private String ttlSav = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String gtoAmt = null;
	/* Column Info */
	private String locGrp = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String pcrCredit = null;
	/* Column Info */
	private String sboCost = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String comboReqNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String authVol = null;
	/* Column Info */
	private String freeDd = null;
	/* Column Info */
	private String pucCost = null;
	/* Column Info */
	private String pcrCost = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqInterchangeReqVO() {}

	public EqInterchangeReqVO(String ibflag, String pagerows, String reqNo, String reqSeq, String lstmCd, String vndrSeq, String locFm, String tpszCd, String locGrp, String locTo, String locCd, String porCost, String sboCost, String delCost, String sbiCost, String rqstQty, String freeDay, String pucAmt, String gtoAmt, String addCost, String pcrCredit, String ttlSav, String authNo, String authSeq, String updUsrId, String comboReqNo, String agmtSeq, String authVol, String freeDd, String pucCost , String pcrCost) {
		this.authSeq = authSeq;
		this.delCost = delCost;
		this.porCost = porCost;
		this.locFm = locFm;
		this.locTo = locTo;
		this.locCd = locCd;
		this.addCost = addCost;
		this.reqSeq = reqSeq;
		this.authNo = authNo;
		this.pucAmt = pucAmt;
		this.reqNo = reqNo;
		this.tpszCd = tpszCd;
		this.rqstQty = rqstQty;
		this.pagerows = pagerows;
		this.sbiCost = sbiCost;
		this.ibflag = ibflag;
		this.freeDay = freeDay;
		this.ttlSav = ttlSav;
		this.vndrSeq = vndrSeq;
		this.gtoAmt = gtoAmt;
		this.locGrp = locGrp;
		this.lstmCd = lstmCd;
		this.pcrCredit = pcrCredit;
		this.sboCost = sboCost;
		this.updUsrId = updUsrId;
		this.comboReqNo = comboReqNo;
		this.agmtSeq = agmtSeq;
		this.authVol = authVol;
		this.freeDd = freeDd;
		this.pucCost = pucCost;
		this.pcrCost = pcrCost;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_seq", getAuthSeq());
		this.hashColumns.put("del_cost", getDelCost());
		this.hashColumns.put("por_cost", getPorCost());
		this.hashColumns.put("loc_fm", getLocFm());
		this.hashColumns.put("loc_to", getLocTo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("add_cost", getAddCost());
		this.hashColumns.put("req_seq", getReqSeq());
		this.hashColumns.put("auth_no", getAuthNo());
		this.hashColumns.put("puc_amt", getPucAmt());
		this.hashColumns.put("req_no", getReqNo());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("rqst_qty", getRqstQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sbi_cost", getSbiCost());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("free_day", getFreeDay());
		this.hashColumns.put("ttl_sav", getTtlSav());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("gto_amt", getGtoAmt());
		this.hashColumns.put("loc_grp", getLocGrp());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("pcr_credit", getPcrCredit());
		this.hashColumns.put("sbo_cost", getSboCost());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("combo_req_no", getComboReqNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("auth_vol", getAuthVol());
		this.hashColumns.put("free_dd", getFreeDd());
		this.hashColumns.put("puc_cost", getPucCost());
		this.hashColumns.put("pcr_cost", getPcrCost());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_seq", "authSeq");
		this.hashFields.put("del_cost", "delCost");
		this.hashFields.put("por_cost", "porCost");
		this.hashFields.put("loc_fm", "locFm");
		this.hashFields.put("loc_to", "locTo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("add_cost", "addCost");
		this.hashFields.put("req_seq", "reqSeq");
		this.hashFields.put("auth_no", "authNo");
		this.hashFields.put("puc_amt", "pucAmt");
		this.hashFields.put("req_no", "reqNo");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("rqst_qty", "rqstQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sbi_cost", "sbiCost");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("free_day", "freeDay");
		this.hashFields.put("ttl_sav", "ttlSav");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("gto_amt", "gtoAmt");
		this.hashFields.put("loc_grp", "locGrp");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("pcr_credit", "pcrCredit");
		this.hashFields.put("sbo_cost", "sboCost");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("combo_req_no", "comboReqNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("auth_vol", "authVol");
		this.hashFields.put("free_dd", "freeDd");
		this.hashFields.put("puc_cost", "pucCost");
		this.hashFields.put("pcr_cost", "pcrCost");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authSeq
	 */
	public String getAuthSeq() {
		return this.authSeq;
	}
	
	/**
	 * Column Info
	 * @return delCost
	 */
	public String getDelCost() {
		return this.delCost;
	}
	
	/**
	 * Column Info
	 * @return porCost
	 */
	public String getPorCost() {
		return this.porCost;
	}
	
	/**
	 * Column Info
	 * @return locFm
	 */
	public String getLocFm() {
		return this.locFm;
	}
	
	/**
	 * Column Info
	 * @return locTo
	 */
	public String getLocTo() {
		return this.locTo;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return addCost
	 */
	public String getAddCost() {
		return this.addCost;
	}
	
	/**
	 * Column Info
	 * @return reqSeq
	 */
	public String getReqSeq() {
		return this.reqSeq;
	}
	
	/**
	 * Column Info
	 * @return authNo
	 */
	public String getAuthNo() {
		return this.authNo;
	}
	
	/**
	 * Column Info
	 * @return pucAmt
	 */
	public String getPucAmt() {
		return this.pucAmt;
	}
	
	/**
	 * Column Info
	 * @return reqNo
	 */
	public String getReqNo() {
		return this.reqNo;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
	}
	
	/**
	 * Column Info
	 * @return rqstQty
	 */
	public String getRqstQty() {
		return this.rqstQty;
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
	 * @return sbiCost
	 */
	public String getSbiCost() {
		return this.sbiCost;
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
	 * @return freeDay
	 */
	public String getFreeDay() {
		return this.freeDay;
	}
	
	/**
	 * Column Info
	 * @return ttlSav
	 */
	public String getTtlSav() {
		return this.ttlSav;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return gtoAmt
	 */
	public String getGtoAmt() {
		return this.gtoAmt;
	}
	
	/**
	 * Column Info
	 * @return locGrp
	 */
	public String getLocGrp() {
		return this.locGrp;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return pcrCredit
	 */
	public String getPcrCredit() {
		return this.pcrCredit;
	}
	
	/**
	 * Column Info
	 * @return sboCost
	 */
	public String getSboCost() {
		return this.sboCost;
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
	 * @return comboReqNo
	 */
	public String getComboReqNo() {
		return this.comboReqNo;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}

	/**
	 * Column Info
	 * @return authVol
	 */
	public String getAuthVol() {
		return this.authVol;
	}
	
	/**
	 * Column Info
	 * @return freeDd
	 */
	public String getFreeDd() {
		return this.freeDd;
	}
	
	/**
	 * Column Info
	 * @return pucCost
	 */
	public String getPucCost() {
		return this.pucCost;
	}
	
	/**
	 * Column Info
	 * @return pcrCost
	 */
	public String getPcrCost() {
		return this.pcrCost;
	}
			
	/**
	 * Column Info
	 * @param authSeq
	 */
	public void setAuthSeq(String authSeq) {
		this.authSeq = authSeq;
	}
	
	/**
	 * Column Info
	 * @param delCost
	 */
	public void setDelCost(String delCost) {
		this.delCost = delCost;
	}
	
	/**
	 * Column Info
	 * @param porCost
	 */
	public void setPorCost(String porCost) {
		this.porCost = porCost;
	}
	
	/**
	 * Column Info
	 * @param locFm
	 */
	public void setLocFm(String locFm) {
		this.locFm = locFm;
	}
	
	/**
	 * Column Info
	 * @param locTo
	 */
	public void setLocTo(String locTo) {
		this.locTo = locTo;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param addCost
	 */
	public void setAddCost(String addCost) {
		this.addCost = addCost;
	}
	
	/**
	 * Column Info
	 * @param reqSeq
	 */
	public void setReqSeq(String reqSeq) {
		this.reqSeq = reqSeq;
	}
	
	/**
	 * Column Info
	 * @param authNo
	 */
	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}
	
	/**
	 * Column Info
	 * @param pucAmt
	 */
	public void setPucAmt(String pucAmt) {
		this.pucAmt = pucAmt;
	}
	
	/**
	 * Column Info
	 * @param reqNo
	 */
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
	}
	
	/**
	 * Column Info
	 * @param rqstQty
	 */
	public void setRqstQty(String rqstQty) {
		this.rqstQty = rqstQty;
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
	 * @param sbiCost
	 */
	public void setSbiCost(String sbiCost) {
		this.sbiCost = sbiCost;
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
	 * @param freeDay
	 */
	public void setFreeDay(String freeDay) {
		this.freeDay = freeDay;
	}
	
	/**
	 * Column Info
	 * @param ttlSav
	 */
	public void setTtlSav(String ttlSav) {
		this.ttlSav = ttlSav;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param gtoAmt
	 */
	public void setGtoAmt(String gtoAmt) {
		this.gtoAmt = gtoAmt;
	}
	
	/**
	 * Column Info
	 * @param locGrp
	 */
	public void setLocGrp(String locGrp) {
		this.locGrp = locGrp;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param pcrCredit
	 */
	public void setPcrCredit(String pcrCredit) {
		this.pcrCredit = pcrCredit;
	}
	
	/**
	 * Column Info
	 * @param sboCost
	 */
	public void setSboCost(String sboCost) {
		this.sboCost = sboCost;
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
	 * @param comboReqNo
	 */
	public void setComboReqNo(String comboReqNo) {
		this.comboReqNo = comboReqNo;
	}

	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}					

	/**
	 * Column Info
	 * @param authVol
	 */
	public void setAuthVol(String authVol) {
		this.authVol = authVol;
	}

	/**
	 * Column Info
	 * @param freeDd
	 */
	public void setFreeDd(String freeDd) {
		this.freeDd = freeDd;
	}

	/**
	 * Column Info
	 * @param pucCost
	 */
	public void setPucCost(String pucCost) {
		this.pucCost = pucCost;
	}					

	/**
	 * Column Info
	 * @param pcrCost
	 */
	public void setPcrCost(String pcrCost) {
		this.pcrCost = pcrCost;
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
		setAuthSeq(JSPUtil.getParameter(request, prefix + "auth_seq", ""));
		setDelCost(JSPUtil.getParameter(request, prefix + "del_cost", ""));
		setPorCost(JSPUtil.getParameter(request, prefix + "por_cost", ""));
		setLocFm(JSPUtil.getParameter(request, prefix + "loc_fm", ""));
		setLocTo(JSPUtil.getParameter(request, prefix + "loc_to", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setAddCost(JSPUtil.getParameter(request, prefix + "add_cost", ""));
		setReqSeq(JSPUtil.getParameter(request, prefix + "req_seq", ""));
		setAuthNo(JSPUtil.getParameter(request, prefix + "auth_no", ""));
		setPucAmt(JSPUtil.getParameter(request, prefix + "puc_amt", ""));
		setReqNo(JSPUtil.getParameter(request, prefix + "req_no", ""));
		setTpszCd(JSPUtil.getParameter(request, prefix + "tpsz_cd", ""));
		setRqstQty(JSPUtil.getParameter(request, prefix + "rqst_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSbiCost(JSPUtil.getParameter(request, prefix + "sbi_cost", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFreeDay(JSPUtil.getParameter(request, prefix + "free_day", ""));
		setTtlSav(JSPUtil.getParameter(request, prefix + "ttl_sav", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setGtoAmt(JSPUtil.getParameter(request, prefix + "gto_amt", ""));
		setLocGrp(JSPUtil.getParameter(request, prefix + "loc_grp", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setPcrCredit(JSPUtil.getParameter(request, prefix + "pcr_credit", ""));
		setSboCost(JSPUtil.getParameter(request, prefix + "sbo_cost", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setComboReqNo(JSPUtil.getParameter(request, prefix + "combo_req_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setAuthVol(JSPUtil.getParameter(request, prefix + "auth_vol", ""));
		setFreeDd(JSPUtil.getParameter(request, prefix + "free_dd", ""));
		setPucCost(JSPUtil.getParameter(request, prefix + "puc_cost", ""));
		setPcrCost(JSPUtil.getParameter(request, prefix + "pcr_cost", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqInterchangeReqVO[]
	 */
	public EqInterchangeReqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqInterchangeReqVO[]
	 */
	public EqInterchangeReqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqInterchangeReqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authSeq = (JSPUtil.getParameter(request, prefix	+ "auth_seq", length));
			String[] delCost = (JSPUtil.getParameter(request, prefix	+ "del_cost", length));
			String[] porCost = (JSPUtil.getParameter(request, prefix	+ "por_cost", length));
			String[] locFm = (JSPUtil.getParameter(request, prefix	+ "loc_fm", length));
			String[] locTo = (JSPUtil.getParameter(request, prefix	+ "loc_to", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] addCost = (JSPUtil.getParameter(request, prefix	+ "add_cost", length));
			String[] reqSeq = (JSPUtil.getParameter(request, prefix	+ "req_seq", length));
			String[] authNo = (JSPUtil.getParameter(request, prefix	+ "auth_no", length));
			String[] pucAmt = (JSPUtil.getParameter(request, prefix	+ "puc_amt", length));
			String[] reqNo = (JSPUtil.getParameter(request, prefix	+ "req_no", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] rqstQty = (JSPUtil.getParameter(request, prefix	+ "rqst_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sbiCost = (JSPUtil.getParameter(request, prefix	+ "sbi_cost", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] freeDay = (JSPUtil.getParameter(request, prefix	+ "free_day", length));
			String[] ttlSav = (JSPUtil.getParameter(request, prefix	+ "ttl_sav", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] gtoAmt = (JSPUtil.getParameter(request, prefix	+ "gto_amt", length));
			String[] locGrp = (JSPUtil.getParameter(request, prefix	+ "loc_grp", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] pcrCredit = (JSPUtil.getParameter(request, prefix	+ "pcr_credit", length));
			String[] sboCost = (JSPUtil.getParameter(request, prefix	+ "sbo_cost", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] comboReqNo = (JSPUtil.getParameter(request, prefix	+ "combo_req_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] authVol = (JSPUtil.getParameter(request, prefix	+ "auth_vol", length));
			String[] freeDd = (JSPUtil.getParameter(request, prefix	+ "free_dd", length));
			String[] pucCost = (JSPUtil.getParameter(request, prefix	+ "puc_cost", length));
			String[] pcrCost = (JSPUtil.getParameter(request, prefix	+ "pcr_cost", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqInterchangeReqVO();
				if (authSeq[i] != null)
					model.setAuthSeq(authSeq[i]);
				if (delCost[i] != null)
					model.setDelCost(delCost[i]);
				if (porCost[i] != null)
					model.setPorCost(porCost[i]);
				if (locFm[i] != null)
					model.setLocFm(locFm[i]);
				if (locTo[i] != null)
					model.setLocTo(locTo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (addCost[i] != null)
					model.setAddCost(addCost[i]);
				if (reqSeq[i] != null)
					model.setReqSeq(reqSeq[i]);
				if (authNo[i] != null)
					model.setAuthNo(authNo[i]);
				if (pucAmt[i] != null)
					model.setPucAmt(pucAmt[i]);
				if (reqNo[i] != null)
					model.setReqNo(reqNo[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (rqstQty[i] != null)
					model.setRqstQty(rqstQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sbiCost[i] != null)
					model.setSbiCost(sbiCost[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (freeDay[i] != null)
					model.setFreeDay(freeDay[i]);
				if (ttlSav[i] != null)
					model.setTtlSav(ttlSav[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (gtoAmt[i] != null)
					model.setGtoAmt(gtoAmt[i]);
				if (locGrp[i] != null)
					model.setLocGrp(locGrp[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (pcrCredit[i] != null)
					model.setPcrCredit(pcrCredit[i]);
				if (sboCost[i] != null)
					model.setSboCost(sboCost[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (comboReqNo[i] != null)
					model.setComboReqNo(comboReqNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (authVol[i] != null)
					model.setAuthVol(authVol[i]);
				if (freeDd[i] != null)
					model.setFreeDd(freeDd[i]);
				if (pucCost[i] != null)
					model.setPucCost(pucCost[i]);
				if (pcrCost[i] != null)
					model.setPcrCost(pcrCost[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqInterchangeReqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqInterchangeReqVO[]
	 */
	public EqInterchangeReqVO[] getEqInterchangeReqVOs(){
		EqInterchangeReqVO[] vos = (EqInterchangeReqVO[])models.toArray(new EqInterchangeReqVO[models.size()]);
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
		this.authSeq = this.authSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCost = this.delCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCost = this.porCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locFm = this.locFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTo = this.locTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addCost = this.addCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqSeq = this.reqSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authNo = this.authNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucAmt = this.pucAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqNo = this.reqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstQty = this.rqstQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbiCost = this.sbiCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDay = this.freeDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlSav = this.ttlSav .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtoAmt = this.gtoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrp = this.locGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcrCredit = this.pcrCredit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sboCost = this.sboCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboReqNo = this.comboReqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authVol = this.authVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDd = this.freeDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucCost = this.pucCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcrCost = this.pcrCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
