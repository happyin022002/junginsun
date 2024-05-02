/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FACCommDetailHistorybyBLVO.java
*@FileTitle : FACCommDetailHistorybyBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.09 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FACCommDetailHistorybyBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FACCommDetailHistorybyBLVO> models = new ArrayList<FACCommDetailHistorybyBLVO>();
	
	/* Column Info */
	private String facSeq = null;
	/* Column Info */
	private String facRmk = null;
	/* Column Info */
	private String commProcStsCd = null;
	/* Column Info */
	private String facFeuRt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String agmtCustSeq = null;
	/* Column Info */
	private String facOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String facBxRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String facTeuRt = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String agmtRtSeq = null;
	/* Column Info */
	private String facRfTeuRt = null;
	/* Column Info */
	private String cntrCommAmt = null;
	/* Column Info */
	private String facIfDt = null;
	/* Column Info */
	private String blCommAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String agmtCntCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String bkgRfTeuQty = null;
	/* Column Info */
	private String bkgRfFeuQty = null;
	/* Column Info */
	private String actPreCommAmt = null;
	/* Column Info */
	private String facRfFeuRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FACCommDetailHistorybyBLVO() {}

	public FACCommDetailHistorybyBLVO(String ibflag, String pagerows, String facSeq, String blCommAmt, String actCommAmt, String bkgBxQty, String facBxRt, String bkgTeuQty, String facTeuRt, String bkgFeuQty, String facFeuRt, String bkgRfTeuQty, String facRfTeuRt, String bkgRfFeuQty, String facRfFeuRt, String cntrCommAmt, String actPreCommAmt, String creDt, String facRmk, String commProcStsCd, String commProcRsltRsn, String facIfDt, String facOfcCd, String agmtCntCd, String agmtCustSeq, String agmtRtSeq, String blNo, String bkgNo) {
		this.facSeq = facSeq;
		this.facRmk = facRmk;
		this.commProcStsCd = commProcStsCd;
		this.facFeuRt = facFeuRt;
		this.creDt = creDt;
		this.agmtCustSeq = agmtCustSeq;
		this.facOfcCd = facOfcCd;
		this.blNo = blNo;
		this.facBxRt = facBxRt;
		this.pagerows = pagerows;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.actCommAmt = actCommAmt;
		this.bkgBxQty = bkgBxQty;
		this.facTeuRt = facTeuRt;
		this.commProcRsltRsn = commProcRsltRsn;
		this.agmtRtSeq = agmtRtSeq;
		this.facRfTeuRt = facRfTeuRt;
		this.cntrCommAmt = cntrCommAmt;
		this.facIfDt = facIfDt;
		this.blCommAmt = blCommAmt;
		this.bkgNo = bkgNo;
		this.agmtCntCd = agmtCntCd;
		this.bkgTeuQty = bkgTeuQty;
		this.bkgRfTeuQty = bkgRfTeuQty;
		this.bkgRfFeuQty = bkgRfFeuQty;
		this.actPreCommAmt = actPreCommAmt;
		this.facRfFeuRt = facRfFeuRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fac_seq", getFacSeq());
		this.hashColumns.put("fac_rmk", getFacRmk());
		this.hashColumns.put("comm_proc_sts_cd", getCommProcStsCd());
		this.hashColumns.put("fac_feu_rt", getFacFeuRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_cust_seq", getAgmtCustSeq());
		this.hashColumns.put("fac_ofc_cd", getFacOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("fac_bx_rt", getFacBxRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("fac_teu_rt", getFacTeuRt());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("agmt_rt_seq", getAgmtRtSeq());
		this.hashColumns.put("fac_rf_teu_rt", getFacRfTeuRt());
		this.hashColumns.put("cntr_comm_amt", getCntrCommAmt());
		this.hashColumns.put("fac_if_dt", getFacIfDt());
		this.hashColumns.put("bl_comm_amt", getBlCommAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("agmt_cnt_cd", getAgmtCntCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("bkg_rf_teu_qty", getBkgRfTeuQty());
		this.hashColumns.put("bkg_rf_feu_qty", getBkgRfFeuQty());
		this.hashColumns.put("act_pre_comm_amt", getActPreCommAmt());
		this.hashColumns.put("fac_rf_feu_rt", getFacRfFeuRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fac_seq", "facSeq");
		this.hashFields.put("fac_rmk", "facRmk");
		this.hashFields.put("comm_proc_sts_cd", "commProcStsCd");
		this.hashFields.put("fac_feu_rt", "facFeuRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_cust_seq", "agmtCustSeq");
		this.hashFields.put("fac_ofc_cd", "facOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("fac_bx_rt", "facBxRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("fac_teu_rt", "facTeuRt");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("agmt_rt_seq", "agmtRtSeq");
		this.hashFields.put("fac_rf_teu_rt", "facRfTeuRt");
		this.hashFields.put("cntr_comm_amt", "cntrCommAmt");
		this.hashFields.put("fac_if_dt", "facIfDt");
		this.hashFields.put("bl_comm_amt", "blCommAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("agmt_cnt_cd", "agmtCntCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("bkg_rf_teu_qty", "bkgRfTeuQty");
		this.hashFields.put("bkg_rf_feu_qty", "bkgRfFeuQty");
		this.hashFields.put("act_pre_comm_amt", "actPreCommAmt");
		this.hashFields.put("fac_rf_feu_rt", "facRfFeuRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return facSeq
	 */
	public String getFacSeq() {
		return this.facSeq;
	}
	
	/**
	 * Column Info
	 * @return facRmk
	 */
	public String getFacRmk() {
		return this.facRmk;
	}
	
	/**
	 * Column Info
	 * @return commProcStsCd
	 */
	public String getCommProcStsCd() {
		return this.commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return facFeuRt
	 */
	public String getFacFeuRt() {
		return this.facFeuRt;
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
	 * @return agmtCustSeq
	 */
	public String getAgmtCustSeq() {
		return this.agmtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return facOfcCd
	 */
	public String getFacOfcCd() {
		return this.facOfcCd;
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
	 * @return facBxRt
	 */
	public String getFacBxRt() {
		return this.facBxRt;
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
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return actCommAmt
	 */
	public String getActCommAmt() {
		return this.actCommAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @return facTeuRt
	 */
	public String getFacTeuRt() {
		return this.facTeuRt;
	}
	
	/**
	 * Column Info
	 * @return commProcRsltRsn
	 */
	public String getCommProcRsltRsn() {
		return this.commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @return agmtRtSeq
	 */
	public String getAgmtRtSeq() {
		return this.agmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @return facRfTeuRt
	 */
	public String getFacRfTeuRt() {
		return this.facRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @return cntrCommAmt
	 */
	public String getCntrCommAmt() {
		return this.cntrCommAmt;
	}
	
	/**
	 * Column Info
	 * @return facIfDt
	 */
	public String getFacIfDt() {
		return this.facIfDt;
	}
	
	/**
	 * Column Info
	 * @return blCommAmt
	 */
	public String getBlCommAmt() {
		return this.blCommAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return agmtCntCd
	 */
	public String getAgmtCntCd() {
		return this.agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRfTeuQty
	 */
	public String getBkgRfTeuQty() {
		return this.bkgRfTeuQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRfFeuQty
	 */
	public String getBkgRfFeuQty() {
		return this.bkgRfFeuQty;
	}
	
	/**
	 * Column Info
	 * @return actPreCommAmt
	 */
	public String getActPreCommAmt() {
		return this.actPreCommAmt;
	}
	
	/**
	 * Column Info
	 * @return facRfFeuRt
	 */
	public String getFacRfFeuRt() {
		return this.facRfFeuRt;
	}
	

	/**
	 * Column Info
	 * @param facSeq
	 */
	public void setFacSeq(String facSeq) {
		this.facSeq = facSeq;
	}
	
	/**
	 * Column Info
	 * @param facRmk
	 */
	public void setFacRmk(String facRmk) {
		this.facRmk = facRmk;
	}
	
	/**
	 * Column Info
	 * @param commProcStsCd
	 */
	public void setCommProcStsCd(String commProcStsCd) {
		this.commProcStsCd = commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param facFeuRt
	 */
	public void setFacFeuRt(String facFeuRt) {
		this.facFeuRt = facFeuRt;
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
	 * @param agmtCustSeq
	 */
	public void setAgmtCustSeq(String agmtCustSeq) {
		this.agmtCustSeq = agmtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param facOfcCd
	 */
	public void setFacOfcCd(String facOfcCd) {
		this.facOfcCd = facOfcCd;
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
	 * @param facBxRt
	 */
	public void setFacBxRt(String facBxRt) {
		this.facBxRt = facBxRt;
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
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param actCommAmt
	 */
	public void setActCommAmt(String actCommAmt) {
		this.actCommAmt = actCommAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @param facTeuRt
	 */
	public void setFacTeuRt(String facTeuRt) {
		this.facTeuRt = facTeuRt;
	}
	
	/**
	 * Column Info
	 * @param commProcRsltRsn
	 */
	public void setCommProcRsltRsn(String commProcRsltRsn) {
		this.commProcRsltRsn = commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @param agmtRtSeq
	 */
	public void setAgmtRtSeq(String agmtRtSeq) {
		this.agmtRtSeq = agmtRtSeq;
	}
	
	/**
	 * Column Info
	 * @param facRfTeuRt
	 */
	public void setFacRfTeuRt(String facRfTeuRt) {
		this.facRfTeuRt = facRfTeuRt;
	}
	
	/**
	 * Column Info
	 * @param cntrCommAmt
	 */
	public void setCntrCommAmt(String cntrCommAmt) {
		this.cntrCommAmt = cntrCommAmt;
	}
	
	/**
	 * Column Info
	 * @param facIfDt
	 */
	public void setFacIfDt(String facIfDt) {
		this.facIfDt = facIfDt;
	}
	
	/**
	 * Column Info
	 * @param blCommAmt
	 */
	public void setBlCommAmt(String blCommAmt) {
		this.blCommAmt = blCommAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param agmtCntCd
	 */
	public void setAgmtCntCd(String agmtCntCd) {
		this.agmtCntCd = agmtCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRfTeuQty
	 */
	public void setBkgRfTeuQty(String bkgRfTeuQty) {
		this.bkgRfTeuQty = bkgRfTeuQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRfFeuQty
	 */
	public void setBkgRfFeuQty(String bkgRfFeuQty) {
		this.bkgRfFeuQty = bkgRfFeuQty;
	}
	
	/**
	 * Column Info
	 * @param actPreCommAmt
	 */
	public void setActPreCommAmt(String actPreCommAmt) {
		this.actPreCommAmt = actPreCommAmt;
	}
	
	/**
	 * Column Info
	 * @param facRfFeuRt
	 */
	public void setFacRfFeuRt(String facRfFeuRt) {
		this.facRfFeuRt = facRfFeuRt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFacSeq(JSPUtil.getParameter(request, "fac_seq", ""));
		setFacRmk(JSPUtil.getParameter(request, "fac_rmk", ""));
		setCommProcStsCd(JSPUtil.getParameter(request, "comm_proc_sts_cd", ""));
		setFacFeuRt(JSPUtil.getParameter(request, "fac_feu_rt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAgmtCustSeq(JSPUtil.getParameter(request, "agmt_cust_seq", ""));
		setFacOfcCd(JSPUtil.getParameter(request, "fac_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setFacBxRt(JSPUtil.getParameter(request, "fac_bx_rt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActCommAmt(JSPUtil.getParameter(request, "act_comm_amt", ""));
		setBkgBxQty(JSPUtil.getParameter(request, "bkg_bx_qty", ""));
		setFacTeuRt(JSPUtil.getParameter(request, "fac_teu_rt", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, "comm_proc_rslt_rsn", ""));
		setAgmtRtSeq(JSPUtil.getParameter(request, "agmt_rt_seq", ""));
		setFacRfTeuRt(JSPUtil.getParameter(request, "fac_rf_teu_rt", ""));
		setCntrCommAmt(JSPUtil.getParameter(request, "cntr_comm_amt", ""));
		setFacIfDt(JSPUtil.getParameter(request, "fac_if_dt", ""));
		setBlCommAmt(JSPUtil.getParameter(request, "bl_comm_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setAgmtCntCd(JSPUtil.getParameter(request, "agmt_cnt_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, "bkg_teu_qty", ""));
		setBkgRfTeuQty(JSPUtil.getParameter(request, "bkg_rf_teu_qty", ""));
		setBkgRfFeuQty(JSPUtil.getParameter(request, "bkg_rf_feu_qty", ""));
		setActPreCommAmt(JSPUtil.getParameter(request, "act_pre_comm_amt", ""));
		setFacRfFeuRt(JSPUtil.getParameter(request, "fac_rf_feu_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FACCommDetailHistorybyBLVO[]
	 */
	public FACCommDetailHistorybyBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FACCommDetailHistorybyBLVO[]
	 */
	public FACCommDetailHistorybyBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FACCommDetailHistorybyBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] facSeq = (JSPUtil.getParameter(request, prefix	+ "fac_seq", length));
			String[] facRmk = (JSPUtil.getParameter(request, prefix	+ "fac_rmk", length));
			String[] commProcStsCd = (JSPUtil.getParameter(request, prefix	+ "comm_proc_sts_cd", length));
			String[] facFeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_feu_rt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtCustSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_cust_seq", length));
			String[] facOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] facBxRt = (JSPUtil.getParameter(request, prefix	+ "fac_bx_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] facTeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_teu_rt", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] agmtRtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_rt_seq", length));
			String[] facRfTeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_teu_rt", length));
			String[] cntrCommAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_comm_amt", length));
			String[] facIfDt = (JSPUtil.getParameter(request, prefix	+ "fac_if_dt", length));
			String[] blCommAmt = (JSPUtil.getParameter(request, prefix	+ "bl_comm_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] agmtCntCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cnt_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] bkgRfTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_teu_qty", length));
			String[] bkgRfFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_feu_qty", length));
			String[] actPreCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_pre_comm_amt", length));
			String[] facRfFeuRt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_feu_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new FACCommDetailHistorybyBLVO();
				if (facSeq[i] != null)
					model.setFacSeq(facSeq[i]);
				if (facRmk[i] != null)
					model.setFacRmk(facRmk[i]);
				if (commProcStsCd[i] != null)
					model.setCommProcStsCd(commProcStsCd[i]);
				if (facFeuRt[i] != null)
					model.setFacFeuRt(facFeuRt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (agmtCustSeq[i] != null)
					model.setAgmtCustSeq(agmtCustSeq[i]);
				if (facOfcCd[i] != null)
					model.setFacOfcCd(facOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (facBxRt[i] != null)
					model.setFacBxRt(facBxRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (facTeuRt[i] != null)
					model.setFacTeuRt(facTeuRt[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (agmtRtSeq[i] != null)
					model.setAgmtRtSeq(agmtRtSeq[i]);
				if (facRfTeuRt[i] != null)
					model.setFacRfTeuRt(facRfTeuRt[i]);
				if (cntrCommAmt[i] != null)
					model.setCntrCommAmt(cntrCommAmt[i]);
				if (facIfDt[i] != null)
					model.setFacIfDt(facIfDt[i]);
				if (blCommAmt[i] != null)
					model.setBlCommAmt(blCommAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (agmtCntCd[i] != null)
					model.setAgmtCntCd(agmtCntCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (bkgRfTeuQty[i] != null)
					model.setBkgRfTeuQty(bkgRfTeuQty[i]);
				if (bkgRfFeuQty[i] != null)
					model.setBkgRfFeuQty(bkgRfFeuQty[i]);
				if (actPreCommAmt[i] != null)
					model.setActPreCommAmt(actPreCommAmt[i]);
				if (facRfFeuRt[i] != null)
					model.setFacRfFeuRt(facRfFeuRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFACCommDetailHistorybyBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FACCommDetailHistorybyBLVO[]
	 */
	public FACCommDetailHistorybyBLVO[] getFACCommDetailHistorybyBLVOs(){
		FACCommDetailHistorybyBLVO[] vos = (FACCommDetailHistorybyBLVO[])models.toArray(new FACCommDetailHistorybyBLVO[models.size()]);
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
		this.facSeq = this.facSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRmk = this.facRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcStsCd = this.commProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facFeuRt = this.facFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCustSeq = this.agmtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facOfcCd = this.facOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facBxRt = this.facBxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facTeuRt = this.facTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRtSeq = this.agmtRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfTeuRt = this.facRfTeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCommAmt = this.cntrCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facIfDt = this.facIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCommAmt = this.blCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCntCd = this.agmtCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfTeuQty = this.bkgRfTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfFeuQty = this.bkgRfFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPreCommAmt = this.actPreCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfFeuRt = this.facRfFeuRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
