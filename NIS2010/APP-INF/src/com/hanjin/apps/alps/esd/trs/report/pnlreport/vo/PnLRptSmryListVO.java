/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLRptSmryListVO.java
*@FileTitle : PnLRptSmryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.pnlreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PnLRptSmryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PnLRptSmryListVO> models = new ArrayList<PnLRptSmryListVO>();
	
	/* Column Info */
	private String glineFrtRtAmt = null;
	/* Column Info */
	private String inlndCostUsdAmt = null;
	/* Column Info */
	private String woUsdAmt = null;
	/* Column Info */
	private String plInlndCostUsdAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String inlndCostTrspUsdAmt = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String ioBndNm = null;
	/* Column Info */
	private String plWoUsdAmt = null;
	/* Column Info */
	private String plInlndCostTrspUsdAmt = null;
	/* Column Info */
	private String woCntrQty = null;
	/* Column Info */
	private String bkgInlndChgAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String inlndRevTpCd = null;
	/* Column Info */
	private String ttlNoOfBkg = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String woTeuQty = null;
	/* Column Info */
	private String plGlineFrtRtAmt = null;
	/* Column Info */
	private String prcCtrtCustTpNm = null;
	/* Column Info */
	private String grpNo = null;
	/* Column Info */
	private String inlndRevTpNm = null;
	/* Column Info */
	private String bkgCntrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PnLRptSmryListVO() {}

	public PnLRptSmryListVO(String ibflag, String pagerows, String div, String seq, String grpNo, String ctrtOfcCd, String svcScpCd, String ioBndCd, String ioBndNm, String woOfcCd, String prcCtrtCustTpCd, String prcCtrtCustTpNm, String inlndRevTpCd, String inlndRevTpNm, String ttlNoOfBkg, String bkgCntrQty, String woCntrQty, String woTeuQty, String bkgInlndChgAmt, String glineFrtRtAmt, String inlndCostUsdAmt, String inlndCostTrspUsdAmt, String woUsdAmt, String plGlineFrtRtAmt, String plInlndCostUsdAmt, String plInlndCostTrspUsdAmt, String plWoUsdAmt) {
		this.glineFrtRtAmt = glineFrtRtAmt;
		this.inlndCostUsdAmt = inlndCostUsdAmt;
		this.woUsdAmt = woUsdAmt;
		this.plInlndCostUsdAmt = plInlndCostUsdAmt;
		this.svcScpCd = svcScpCd;
		this.div = div;
		this.inlndCostTrspUsdAmt = inlndCostTrspUsdAmt;
		this.woOfcCd = woOfcCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ctrtOfcCd = ctrtOfcCd;
		this.ioBndNm = ioBndNm;
		this.plWoUsdAmt = plWoUsdAmt;
		this.plInlndCostTrspUsdAmt = plInlndCostTrspUsdAmt;
		this.woCntrQty = woCntrQty;
		this.bkgInlndChgAmt = bkgInlndChgAmt;
		this.ioBndCd = ioBndCd;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.inlndRevTpCd = inlndRevTpCd;
		this.ttlNoOfBkg = ttlNoOfBkg;
		this.seq = seq;
		this.woTeuQty = woTeuQty;
		this.plGlineFrtRtAmt = plGlineFrtRtAmt;
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
		this.grpNo = grpNo;
		this.inlndRevTpNm = inlndRevTpNm;
		this.bkgCntrQty = bkgCntrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gline_frt_rt_amt", getGlineFrtRtAmt());
		this.hashColumns.put("inlnd_cost_usd_amt", getInlndCostUsdAmt());
		this.hashColumns.put("wo_usd_amt", getWoUsdAmt());
		this.hashColumns.put("pl_inlnd_cost_usd_amt", getPlInlndCostUsdAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("inlnd_cost_trsp_usd_amt", getInlndCostTrspUsdAmt());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("io_bnd_nm", getIoBndNm());
		this.hashColumns.put("pl_wo_usd_amt", getPlWoUsdAmt());
		this.hashColumns.put("pl_inlnd_cost_trsp_usd_amt", getPlInlndCostTrspUsdAmt());
		this.hashColumns.put("wo_cntr_qty", getWoCntrQty());
		this.hashColumns.put("bkg_inlnd_chg_amt", getBkgInlndChgAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("inlnd_rev_tp_cd", getInlndRevTpCd());
		this.hashColumns.put("ttl_no_of_bkg", getTtlNoOfBkg());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("wo_teu_qty", getWoTeuQty());
		this.hashColumns.put("pl_gline_frt_rt_amt", getPlGlineFrtRtAmt());
		this.hashColumns.put("prc_ctrt_cust_tp_nm", getPrcCtrtCustTpNm());
		this.hashColumns.put("grp_no", getGrpNo());
		this.hashColumns.put("inlnd_rev_tp_nm", getInlndRevTpNm());
		this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gline_frt_rt_amt", "glineFrtRtAmt");
		this.hashFields.put("inlnd_cost_usd_amt", "inlndCostUsdAmt");
		this.hashFields.put("wo_usd_amt", "woUsdAmt");
		this.hashFields.put("pl_inlnd_cost_usd_amt", "plInlndCostUsdAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("div", "div");
		this.hashFields.put("inlnd_cost_trsp_usd_amt", "inlndCostTrspUsdAmt");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("io_bnd_nm", "ioBndNm");
		this.hashFields.put("pl_wo_usd_amt", "plWoUsdAmt");
		this.hashFields.put("pl_inlnd_cost_trsp_usd_amt", "plInlndCostTrspUsdAmt");
		this.hashFields.put("wo_cntr_qty", "woCntrQty");
		this.hashFields.put("bkg_inlnd_chg_amt", "bkgInlndChgAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("inlnd_rev_tp_cd", "inlndRevTpCd");
		this.hashFields.put("ttl_no_of_bkg", "ttlNoOfBkg");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("wo_teu_qty", "woTeuQty");
		this.hashFields.put("pl_gline_frt_rt_amt", "plGlineFrtRtAmt");
		this.hashFields.put("prc_ctrt_cust_tp_nm", "prcCtrtCustTpNm");
		this.hashFields.put("grp_no", "grpNo");
		this.hashFields.put("inlnd_rev_tp_nm", "inlndRevTpNm");
		this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return glineFrtRtAmt
	 */
	public String getGlineFrtRtAmt() {
		return this.glineFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndCostUsdAmt
	 */
	public String getInlndCostUsdAmt() {
		return this.inlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return woUsdAmt
	 */
	public String getWoUsdAmt() {
		return this.woUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return plInlndCostUsdAmt
	 */
	public String getPlInlndCostUsdAmt() {
		return this.plInlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return inlndCostTrspUsdAmt
	 */
	public String getInlndCostTrspUsdAmt() {
		return this.inlndCostTrspUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndNm
	 */
	public String getIoBndNm() {
		return this.ioBndNm;
	}
	
	/**
	 * Column Info
	 * @return plWoUsdAmt
	 */
	public String getPlWoUsdAmt() {
		return this.plWoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return plInlndCostTrspUsdAmt
	 */
	public String getPlInlndCostTrspUsdAmt() {
		return this.plInlndCostTrspUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return woCntrQty
	 */
	public String getWoCntrQty() {
		return this.woCntrQty;
	}
	
	/**
	 * Column Info
	 * @return bkgInlndChgAmt
	 */
	public String getBkgInlndChgAmt() {
		return this.bkgInlndChgAmt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRevTpCd
	 */
	public String getInlndRevTpCd() {
		return this.inlndRevTpCd;
	}
	
	/**
	 * Column Info
	 * @return ttlNoOfBkg
	 */
	public String getTtlNoOfBkg() {
		return this.ttlNoOfBkg;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return woTeuQty
	 */
	public String getWoTeuQty() {
		return this.woTeuQty;
	}
	
	/**
	 * Column Info
	 * @return plGlineFrtRtAmt
	 */
	public String getPlGlineFrtRtAmt() {
		return this.plGlineFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpNm
	 */
	public String getPrcCtrtCustTpNm() {
		return this.prcCtrtCustTpNm;
	}
	
	/**
	 * Column Info
	 * @return grpNo
	 */
	public String getGrpNo() {
		return this.grpNo;
	}
	
	/**
	 * Column Info
	 * @return inlndRevTpNm
	 */
	public String getInlndRevTpNm() {
		return this.inlndRevTpNm;
	}
	
	/**
	 * Column Info
	 * @return bkgCntrQty
	 */
	public String getBkgCntrQty() {
		return this.bkgCntrQty;
	}
	

	/**
	 * Column Info
	 * @param glineFrtRtAmt
	 */
	public void setGlineFrtRtAmt(String glineFrtRtAmt) {
		this.glineFrtRtAmt = glineFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndCostUsdAmt
	 */
	public void setInlndCostUsdAmt(String inlndCostUsdAmt) {
		this.inlndCostUsdAmt = inlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param woUsdAmt
	 */
	public void setWoUsdAmt(String woUsdAmt) {
		this.woUsdAmt = woUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param plInlndCostUsdAmt
	 */
	public void setPlInlndCostUsdAmt(String plInlndCostUsdAmt) {
		this.plInlndCostUsdAmt = plInlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param inlndCostTrspUsdAmt
	 */
	public void setInlndCostTrspUsdAmt(String inlndCostTrspUsdAmt) {
		this.inlndCostTrspUsdAmt = inlndCostTrspUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndNm
	 */
	public void setIoBndNm(String ioBndNm) {
		this.ioBndNm = ioBndNm;
	}
	
	/**
	 * Column Info
	 * @param plWoUsdAmt
	 */
	public void setPlWoUsdAmt(String plWoUsdAmt) {
		this.plWoUsdAmt = plWoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param plInlndCostTrspUsdAmt
	 */
	public void setPlInlndCostTrspUsdAmt(String plInlndCostTrspUsdAmt) {
		this.plInlndCostTrspUsdAmt = plInlndCostTrspUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param woCntrQty
	 */
	public void setWoCntrQty(String woCntrQty) {
		this.woCntrQty = woCntrQty;
	}
	
	/**
	 * Column Info
	 * @param bkgInlndChgAmt
	 */
	public void setBkgInlndChgAmt(String bkgInlndChgAmt) {
		this.bkgInlndChgAmt = bkgInlndChgAmt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRevTpCd
	 */
	public void setInlndRevTpCd(String inlndRevTpCd) {
		this.inlndRevTpCd = inlndRevTpCd;
	}
	
	/**
	 * Column Info
	 * @param ttlNoOfBkg
	 */
	public void setTtlNoOfBkg(String ttlNoOfBkg) {
		this.ttlNoOfBkg = ttlNoOfBkg;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param woTeuQty
	 */
	public void setWoTeuQty(String woTeuQty) {
		this.woTeuQty = woTeuQty;
	}
	
	/**
	 * Column Info
	 * @param plGlineFrtRtAmt
	 */
	public void setPlGlineFrtRtAmt(String plGlineFrtRtAmt) {
		this.plGlineFrtRtAmt = plGlineFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtCustTpNm
	 */
	public void setPrcCtrtCustTpNm(String prcCtrtCustTpNm) {
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
	}
	
	/**
	 * Column Info
	 * @param grpNo
	 */
	public void setGrpNo(String grpNo) {
		this.grpNo = grpNo;
	}
	
	/**
	 * Column Info
	 * @param inlndRevTpNm
	 */
	public void setInlndRevTpNm(String inlndRevTpNm) {
		this.inlndRevTpNm = inlndRevTpNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCntrQty
	 */
	public void setBkgCntrQty(String bkgCntrQty) {
		this.bkgCntrQty = bkgCntrQty;
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
		setGlineFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_frt_rt_amt", ""));
		setInlndCostUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_usd_amt", ""));
		setWoUsdAmt(JSPUtil.getParameter(request, prefix + "wo_usd_amt", ""));
		setPlInlndCostUsdAmt(JSPUtil.getParameter(request, prefix + "pl_inlnd_cost_usd_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDiv(JSPUtil.getParameter(request, prefix + "div", ""));
		setInlndCostTrspUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_trsp_usd_amt", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setIoBndNm(JSPUtil.getParameter(request, prefix + "io_bnd_nm", ""));
		setPlWoUsdAmt(JSPUtil.getParameter(request, prefix + "pl_wo_usd_amt", ""));
		setPlInlndCostTrspUsdAmt(JSPUtil.getParameter(request, prefix + "pl_inlnd_cost_trsp_usd_amt", ""));
		setWoCntrQty(JSPUtil.getParameter(request, prefix + "wo_cntr_qty", ""));
		setBkgInlndChgAmt(JSPUtil.getParameter(request, prefix + "bkg_inlnd_chg_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setInlndRevTpCd(JSPUtil.getParameter(request, prefix + "inlnd_rev_tp_cd", ""));
		setTtlNoOfBkg(JSPUtil.getParameter(request, prefix + "ttl_no_of_bkg", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setWoTeuQty(JSPUtil.getParameter(request, prefix + "wo_teu_qty", ""));
		setPlGlineFrtRtAmt(JSPUtil.getParameter(request, prefix + "pl_gline_frt_rt_amt", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_nm", ""));
		setGrpNo(JSPUtil.getParameter(request, prefix + "grp_no", ""));
		setInlndRevTpNm(JSPUtil.getParameter(request, prefix + "inlnd_rev_tp_nm", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "bkg_cntr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PnLRptSmryListVO[]
	 */
	public PnLRptSmryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PnLRptSmryListVO[]
	 */
	public PnLRptSmryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PnLRptSmryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] glineFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_frt_rt_amt", length));
			String[] inlndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_usd_amt", length));
			String[] woUsdAmt = (JSPUtil.getParameter(request, prefix	+ "wo_usd_amt", length));
			String[] plInlndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_inlnd_cost_usd_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] inlndCostTrspUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_trsp_usd_amt", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] ioBndNm = (JSPUtil.getParameter(request, prefix	+ "io_bnd_nm", length));
			String[] plWoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_wo_usd_amt", length));
			String[] plInlndCostTrspUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_inlnd_cost_trsp_usd_amt", length));
			String[] woCntrQty = (JSPUtil.getParameter(request, prefix	+ "wo_cntr_qty", length));
			String[] bkgInlndChgAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_inlnd_chg_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] inlndRevTpCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rev_tp_cd", length));
			String[] ttlNoOfBkg = (JSPUtil.getParameter(request, prefix	+ "ttl_no_of_bkg", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] woTeuQty = (JSPUtil.getParameter(request, prefix	+ "wo_teu_qty", length));
			String[] plGlineFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "pl_gline_frt_rt_amt", length));
			String[] prcCtrtCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_nm", length));
			String[] grpNo = (JSPUtil.getParameter(request, prefix	+ "grp_no", length));
			String[] inlndRevTpNm = (JSPUtil.getParameter(request, prefix	+ "inlnd_rev_tp_nm", length));
			String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new PnLRptSmryListVO();
				if (glineFrtRtAmt[i] != null)
					model.setGlineFrtRtAmt(glineFrtRtAmt[i]);
				if (inlndCostUsdAmt[i] != null)
					model.setInlndCostUsdAmt(inlndCostUsdAmt[i]);
				if (woUsdAmt[i] != null)
					model.setWoUsdAmt(woUsdAmt[i]);
				if (plInlndCostUsdAmt[i] != null)
					model.setPlInlndCostUsdAmt(plInlndCostUsdAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (inlndCostTrspUsdAmt[i] != null)
					model.setInlndCostTrspUsdAmt(inlndCostTrspUsdAmt[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (ioBndNm[i] != null)
					model.setIoBndNm(ioBndNm[i]);
				if (plWoUsdAmt[i] != null)
					model.setPlWoUsdAmt(plWoUsdAmt[i]);
				if (plInlndCostTrspUsdAmt[i] != null)
					model.setPlInlndCostTrspUsdAmt(plInlndCostTrspUsdAmt[i]);
				if (woCntrQty[i] != null)
					model.setWoCntrQty(woCntrQty[i]);
				if (bkgInlndChgAmt[i] != null)
					model.setBkgInlndChgAmt(bkgInlndChgAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (inlndRevTpCd[i] != null)
					model.setInlndRevTpCd(inlndRevTpCd[i]);
				if (ttlNoOfBkg[i] != null)
					model.setTtlNoOfBkg(ttlNoOfBkg[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (woTeuQty[i] != null)
					model.setWoTeuQty(woTeuQty[i]);
				if (plGlineFrtRtAmt[i] != null)
					model.setPlGlineFrtRtAmt(plGlineFrtRtAmt[i]);
				if (prcCtrtCustTpNm[i] != null)
					model.setPrcCtrtCustTpNm(prcCtrtCustTpNm[i]);
				if (grpNo[i] != null)
					model.setGrpNo(grpNo[i]);
				if (inlndRevTpNm[i] != null)
					model.setInlndRevTpNm(inlndRevTpNm[i]);
				if (bkgCntrQty[i] != null)
					model.setBkgCntrQty(bkgCntrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPnLRptSmryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PnLRptSmryListVO[]
	 */
	public PnLRptSmryListVO[] getPnLRptSmryListVOs(){
		PnLRptSmryListVO[] vos = (PnLRptSmryListVO[])models.toArray(new PnLRptSmryListVO[models.size()]);
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
		this.glineFrtRtAmt = this.glineFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostUsdAmt = this.inlndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woUsdAmt = this.woUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInlndCostUsdAmt = this.plInlndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostTrspUsdAmt = this.inlndCostTrspUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndNm = this.ioBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plWoUsdAmt = this.plWoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInlndCostTrspUsdAmt = this.plInlndCostTrspUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCntrQty = this.woCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgInlndChgAmt = this.bkgInlndChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRevTpCd = this.inlndRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlNoOfBkg = this.ttlNoOfBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTeuQty = this.woTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plGlineFrtRtAmt = this.plGlineFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm = this.prcCtrtCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpNo = this.grpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRevTpNm = this.inlndRevTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrQty = this.bkgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
