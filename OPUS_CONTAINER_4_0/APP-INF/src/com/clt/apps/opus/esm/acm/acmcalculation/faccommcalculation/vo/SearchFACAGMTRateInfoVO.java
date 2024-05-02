/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchFACAGMTRateInfoVO.java
*@FileTitle : SearchFACAGMTRateInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.29
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.29
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFACAGMTRateInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchFACAGMTRateInfoVO> models = new ArrayList<SearchFACAGMTRateInfoVO>();

	/* Column Info */
	private String facBxAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String facOfcCd = null;
	/* Column Info */
	private String facAgmtSeq = null;
	/* Column Info */
	private String grsNetDivCd = null;
	/* Column Info */
	private String ffCustSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String facSpclFeuAmt = null;
	/* Column Info */
	private String ofcOdr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String facSglFlg = null;
	/* Column Info */
	private String facDryFeuAmt = null;
	/* Column Info */
	private String facDivCd = null;
	/* Column Info */
	private String facBkgAmt = null;
	/* Column Info */
	private String facSpclCntrRt2 = null;
	/* Column Info */
	private String facSpclCntrTpCtnt1 = null;
	/* Column Info */
	private String facSpclCntrRt1 = null;
	/* Column Info */
	private String facRfTeuAmt = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String facRfFeuAmt = null;
	/* Column Info */
	private String facSpclCntrTpCtnt2 = null;
	/* Column Info */
	private String routCd = null;
	/* Column Info */
	private String odr = null;
	/* Column Info */
	private String facRtOfcCd = null;
	/* Column Info */
	private String facSpclTeuAmt = null;
	/* Column Info */
	private String facDryTeuAmt = null;
	/* Column Info */
	private String facChgCtnt = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String shprCustSeq = null;
	/* Column Info */
	private String facBkgRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchFACAGMTRateInfoVO() {}

	public SearchFACAGMTRateInfoVO(String ibflag, String pagerows, String facBxAmt, String currCd, String facOfcCd, String facAgmtSeq, String ffCustSeq, String ofcOdr, String facSpclFeuAmt, String facSglFlg, String facDryFeuAmt, String facDivCd, String facBkgAmt, String facSpclCntrRt2, String facSpclCntrTpCtnt1, String facSpclCntrRt1, String facRfTeuAmt, String shprCntCd, String facRfFeuAmt, String facSpclCntrTpCtnt2, String routCd, String odr, String facSpclTeuAmt, String facDryTeuAmt, String facChgCtnt, String shprCustSeq, String ffCntCd, String facBkgRt, String grsNetDivCd, String facRtOfcCd) {
		this.facBxAmt = facBxAmt;
		this.currCd = currCd;
		this.facOfcCd = facOfcCd;
		this.facAgmtSeq = facAgmtSeq;
		this.grsNetDivCd = grsNetDivCd;
		this.ffCustSeq = ffCustSeq;
		this.pagerows = pagerows;
		this.facSpclFeuAmt = facSpclFeuAmt;
		this.ofcOdr = ofcOdr;
		this.ibflag = ibflag;
		this.facSglFlg = facSglFlg;
		this.facDryFeuAmt = facDryFeuAmt;
		this.facDivCd = facDivCd;
		this.facBkgAmt = facBkgAmt;
		this.facSpclCntrRt2 = facSpclCntrRt2;
		this.facSpclCntrTpCtnt1 = facSpclCntrTpCtnt1;
		this.facSpclCntrRt1 = facSpclCntrRt1;
		this.facRfTeuAmt = facRfTeuAmt;
		this.shprCntCd = shprCntCd;
		this.facRfFeuAmt = facRfFeuAmt;
		this.facSpclCntrTpCtnt2 = facSpclCntrTpCtnt2;
		this.routCd = routCd;
		this.odr = odr;
		this.facRtOfcCd = facRtOfcCd;
		this.facSpclTeuAmt = facSpclTeuAmt;
		this.facDryTeuAmt = facDryTeuAmt;
		this.facChgCtnt = facChgCtnt;
		this.ffCntCd = ffCntCd;
		this.shprCustSeq = shprCustSeq;
		this.facBkgRt = facBkgRt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fac_bx_amt", getFacBxAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fac_ofc_cd", getFacOfcCd());
		this.hashColumns.put("fac_agmt_seq", getFacAgmtSeq());
		this.hashColumns.put("grs_net_div_cd", getGrsNetDivCd());
		this.hashColumns.put("ff_cust_seq", getFfCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fac_spcl_feu_amt", getFacSpclFeuAmt());
		this.hashColumns.put("ofc_odr", getOfcOdr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fac_sgl_flg", getFacSglFlg());
		this.hashColumns.put("fac_dry_feu_amt", getFacDryFeuAmt());
		this.hashColumns.put("fac_div_cd", getFacDivCd());
		this.hashColumns.put("fac_bkg_amt", getFacBkgAmt());
		this.hashColumns.put("fac_spcl_cntr_rt2", getFacSpclCntrRt2());
		this.hashColumns.put("fac_spcl_cntr_tp_ctnt1", getFacSpclCntrTpCtnt1());
		this.hashColumns.put("fac_spcl_cntr_rt1", getFacSpclCntrRt1());
		this.hashColumns.put("fac_rf_teu_amt", getFacRfTeuAmt());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("fac_rf_feu_amt", getFacRfFeuAmt());
		this.hashColumns.put("fac_spcl_cntr_tp_ctnt2", getFacSpclCntrTpCtnt2());
		this.hashColumns.put("rout_cd", getRoutCd());
		this.hashColumns.put("odr", getOdr());
		this.hashColumns.put("fac_rt_ofc_cd", getFacRtOfcCd());
		this.hashColumns.put("fac_spcl_teu_amt", getFacSpclTeuAmt());
		this.hashColumns.put("fac_dry_teu_amt", getFacDryTeuAmt());
		this.hashColumns.put("fac_chg_ctnt", getFacChgCtnt());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("shpr_cust_seq", getShprCustSeq());
		this.hashColumns.put("fac_bkg_rt", getFacBkgRt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fac_bx_amt", "facBxAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fac_ofc_cd", "facOfcCd");
		this.hashFields.put("fac_agmt_seq", "facAgmtSeq");
		this.hashFields.put("grs_net_div_cd", "grsNetDivCd");
		this.hashFields.put("ff_cust_seq", "ffCustSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fac_spcl_feu_amt", "facSpclFeuAmt");
		this.hashFields.put("ofc_odr", "ofcOdr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fac_sgl_flg", "facSglFlg");
		this.hashFields.put("fac_dry_feu_amt", "facDryFeuAmt");
		this.hashFields.put("fac_div_cd", "facDivCd");
		this.hashFields.put("fac_bkg_amt", "facBkgAmt");
		this.hashFields.put("fac_spcl_cntr_rt2", "facSpclCntrRt2");
		this.hashFields.put("fac_spcl_cntr_tp_ctnt1", "facSpclCntrTpCtnt1");
		this.hashFields.put("fac_spcl_cntr_rt1", "facSpclCntrRt1");
		this.hashFields.put("fac_rf_teu_amt", "facRfTeuAmt");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("fac_rf_feu_amt", "facRfFeuAmt");
		this.hashFields.put("fac_spcl_cntr_tp_ctnt2", "facSpclCntrTpCtnt2");
		this.hashFields.put("rout_cd", "routCd");
		this.hashFields.put("odr", "odr");
		this.hashFields.put("fac_rt_ofc_cd", "facRtOfcCd");
		this.hashFields.put("fac_spcl_teu_amt", "facSpclTeuAmt");
		this.hashFields.put("fac_dry_teu_amt", "facDryTeuAmt");
		this.hashFields.put("fac_chg_ctnt", "facChgCtnt");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("shpr_cust_seq", "shprCustSeq");
		this.hashFields.put("fac_bkg_rt", "facBkgRt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return facBxAmt
	 */
	public String getFacBxAmt() {
		return this.facBxAmt;
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
	 * @return facOfcCd
	 */
	public String getFacOfcCd() {
		return this.facOfcCd;
	}

	/**
	 * Column Info
	 * @return facAgmtSeq
	 */
	public String getFacAgmtSeq() {
		return this.facAgmtSeq;
	}

	/**
	 * Column Info
	 * @return grsNetDivCd
	 */
	public String getGrsNetDivCd() {
		return this.grsNetDivCd;
	}

	/**
	 * Column Info
	 * @return ffCustSeq
	 */
	public String getFfCustSeq() {
		return this.ffCustSeq;
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
	 * @return facSpclFeuAmt
	 */
	public String getFacSpclFeuAmt() {
		return this.facSpclFeuAmt;
	}

	/**
	 * Column Info
	 * @return ofcOdr
	 */
	public String getOfcOdr() {
		return this.ofcOdr;
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
	 * @return facSglFlg
	 */
	public String getFacSglFlg() {
		return this.facSglFlg;
	}

	/**
	 * Column Info
	 * @return facDryFeuAmt
	 */
	public String getFacDryFeuAmt() {
		return this.facDryFeuAmt;
	}

	/**
	 * Column Info
	 * @return facDivCd
	 */
	public String getFacDivCd() {
		return this.facDivCd;
	}

	/**
	 * Column Info
	 * @return facBkgAmt
	 */
	public String getFacBkgAmt() {
		return this.facBkgAmt;
	}

	/**
	 * Column Info
	 * @return facSpclCntrRt2
	 */
	public String getFacSpclCntrRt2() {
		return this.facSpclCntrRt2;
	}

	/**
	 * Column Info
	 * @return facSpclCntrTpCtnt1
	 */
	public String getFacSpclCntrTpCtnt1() {
		return this.facSpclCntrTpCtnt1;
	}

	/**
	 * Column Info
	 * @return facSpclCntrRt1
	 */
	public String getFacSpclCntrRt1() {
		return this.facSpclCntrRt1;
	}

	/**
	 * Column Info
	 * @return facRfTeuAmt
	 */
	public String getFacRfTeuAmt() {
		return this.facRfTeuAmt;
	}

	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}

	/**
	 * Column Info
	 * @return facRfFeuAmt
	 */
	public String getFacRfFeuAmt() {
		return this.facRfFeuAmt;
	}

	/**
	 * Column Info
	 * @return facSpclCntrTpCtnt2
	 */
	public String getFacSpclCntrTpCtnt2() {
		return this.facSpclCntrTpCtnt2;
	}

	/**
	 * Column Info
	 * @return routCd
	 */
	public String getRoutCd() {
		return this.routCd;
	}

	/**
	 * Column Info
	 * @return odr
	 */
	public String getOdr() {
		return this.odr;
	}

	/**
	 * Column Info
	 * @return facRtOfcCd
	 */
	public String getFacRtOfcCd() {
		return this.facRtOfcCd;
	}

	/**
	 * Column Info
	 * @return facSpclTeuAmt
	 */
	public String getFacSpclTeuAmt() {
		return this.facSpclTeuAmt;
	}

	/**
	 * Column Info
	 * @return facDryTeuAmt
	 */
	public String getFacDryTeuAmt() {
		return this.facDryTeuAmt;
	}

	/**
	 * Column Info
	 * @return facChgCtnt
	 */
	public String getFacChgCtnt() {
		return this.facChgCtnt;
	}

	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}

	/**
	 * Column Info
	 * @return shprCustSeq
	 */
	public String getShprCustSeq() {
		return this.shprCustSeq;
	}

	/**
	 * Column Info
	 * @return facBkgRt
	 */
	public String getFacBkgRt() {
		return this.facBkgRt;
	}


	/**
	 * Column Info
	 * @param facBxAmt
	 */
	public void setFacBxAmt(String facBxAmt) {
		this.facBxAmt = facBxAmt;
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
	 * @param facOfcCd
	 */
	public void setFacOfcCd(String facOfcCd) {
		this.facOfcCd = facOfcCd;
	}

	/**
	 * Column Info
	 * @param facAgmtSeq
	 */
	public void setFacAgmtSeq(String facAgmtSeq) {
		this.facAgmtSeq = facAgmtSeq;
	}

	/**
	 * Column Info
	 * @param grsNetDivCd
	 */
	public void setGrsNetDivCd(String grsNetDivCd) {
		this.grsNetDivCd = grsNetDivCd;
	}

	/**
	 * Column Info
	 * @param ffCustSeq
	 */
	public void setFfCustSeq(String ffCustSeq) {
		this.ffCustSeq = ffCustSeq;
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
	 * @param facSpclFeuAmt
	 */
	public void setFacSpclFeuAmt(String facSpclFeuAmt) {
		this.facSpclFeuAmt = facSpclFeuAmt;
	}

	/**
	 * Column Info
	 * @param ofcOdr
	 */
	public void setOfcOdr(String ofcOdr) {
		this.ofcOdr = ofcOdr;
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
	 * @param facSglFlg
	 */
	public void setFacSglFlg(String facSglFlg) {
		this.facSglFlg = facSglFlg;
	}

	/**
	 * Column Info
	 * @param facDryFeuAmt
	 */
	public void setFacDryFeuAmt(String facDryFeuAmt) {
		this.facDryFeuAmt = facDryFeuAmt;
	}

	/**
	 * Column Info
	 * @param facDivCd
	 */
	public void setFacDivCd(String facDivCd) {
		this.facDivCd = facDivCd;
	}

	/**
	 * Column Info
	 * @param facBkgAmt
	 */
	public void setFacBkgAmt(String facBkgAmt) {
		this.facBkgAmt = facBkgAmt;
	}

	/**
	 * Column Info
	 * @param facSpclCntrRt2
	 */
	public void setFacSpclCntrRt2(String facSpclCntrRt2) {
		this.facSpclCntrRt2 = facSpclCntrRt2;
	}

	/**
	 * Column Info
	 * @param facSpclCntrTpCtnt1
	 */
	public void setFacSpclCntrTpCtnt1(String facSpclCntrTpCtnt1) {
		this.facSpclCntrTpCtnt1 = facSpclCntrTpCtnt1;
	}

	/**
	 * Column Info
	 * @param facSpclCntrRt1
	 */
	public void setFacSpclCntrRt1(String facSpclCntrRt1) {
		this.facSpclCntrRt1 = facSpclCntrRt1;
	}

	/**
	 * Column Info
	 * @param facRfTeuAmt
	 */
	public void setFacRfTeuAmt(String facRfTeuAmt) {
		this.facRfTeuAmt = facRfTeuAmt;
	}

	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}

	/**
	 * Column Info
	 * @param facRfFeuAmt
	 */
	public void setFacRfFeuAmt(String facRfFeuAmt) {
		this.facRfFeuAmt = facRfFeuAmt;
	}

	/**
	 * Column Info
	 * @param facSpclCntrTpCtnt2
	 */
	public void setFacSpclCntrTpCtnt2(String facSpclCntrTpCtnt2) {
		this.facSpclCntrTpCtnt2 = facSpclCntrTpCtnt2;
	}

	/**
	 * Column Info
	 * @param routCd
	 */
	public void setRoutCd(String routCd) {
		this.routCd = routCd;
	}

	/**
	 * Column Info
	 * @param odr
	 */
	public void setOdr(String odr) {
		this.odr = odr;
	}

	/**
	 * Column Info
	 * @param facRtOfcCd
	 */
	public void setFacRtOfcCd(String facRtOfcCd) {
		this.facRtOfcCd = facRtOfcCd;
	}

	/**
	 * Column Info
	 * @param facSpclTeuAmt
	 */
	public void setFacSpclTeuAmt(String facSpclTeuAmt) {
		this.facSpclTeuAmt = facSpclTeuAmt;
	}

	/**
	 * Column Info
	 * @param facDryTeuAmt
	 */
	public void setFacDryTeuAmt(String facDryTeuAmt) {
		this.facDryTeuAmt = facDryTeuAmt;
	}

	/**
	 * Column Info
	 * @param facChgCtnt
	 */
	public void setFacChgCtnt(String facChgCtnt) {
		this.facChgCtnt = facChgCtnt;
	}

	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}

	/**
	 * Column Info
	 * @param shprCustSeq
	 */
	public void setShprCustSeq(String shprCustSeq) {
		this.shprCustSeq = shprCustSeq;
	}

	/**
	 * Column Info
	 * @param facBkgRt
	 */
	public void setFacBkgRt(String facBkgRt) {
		this.facBkgRt = facBkgRt;
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
		setFacBxAmt(JSPUtil.getParameter(request, prefix + "fac_bx_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFacOfcCd(JSPUtil.getParameter(request, prefix + "fac_ofc_cd", ""));
		setFacAgmtSeq(JSPUtil.getParameter(request, prefix + "fac_agmt_seq", ""));
		setGrsNetDivCd(JSPUtil.getParameter(request, prefix + "grs_net_div_cd", ""));
		setFfCustSeq(JSPUtil.getParameter(request, prefix + "ff_cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFacSpclFeuAmt(JSPUtil.getParameter(request, prefix + "fac_spcl_feu_amt", ""));
		setOfcOdr(JSPUtil.getParameter(request, prefix + "ofc_odr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFacSglFlg(JSPUtil.getParameter(request, prefix + "fac_sgl_flg", ""));
		setFacDryFeuAmt(JSPUtil.getParameter(request, prefix + "fac_dry_feu_amt", ""));
		setFacDivCd(JSPUtil.getParameter(request, prefix + "fac_div_cd", ""));
		setFacBkgAmt(JSPUtil.getParameter(request, prefix + "fac_bkg_amt", ""));
		setFacSpclCntrRt2(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_rt2", ""));
		setFacSpclCntrTpCtnt1(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_tp_ctnt1", ""));
		setFacSpclCntrRt1(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_rt1", ""));
		setFacRfTeuAmt(JSPUtil.getParameter(request, prefix + "fac_rf_teu_amt", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setFacRfFeuAmt(JSPUtil.getParameter(request, prefix + "fac_rf_feu_amt", ""));
		setFacSpclCntrTpCtnt2(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_tp_ctnt2", ""));
		setRoutCd(JSPUtil.getParameter(request, prefix + "rout_cd", ""));
		setOdr(JSPUtil.getParameter(request, prefix + "odr", ""));
		setFacRtOfcCd(JSPUtil.getParameter(request, prefix + "fac_rt_ofc_cd", ""));
		setFacSpclTeuAmt(JSPUtil.getParameter(request, prefix + "fac_spcl_teu_amt", ""));
		setFacDryTeuAmt(JSPUtil.getParameter(request, prefix + "fac_dry_teu_amt", ""));
		setFacChgCtnt(JSPUtil.getParameter(request, prefix + "fac_chg_ctnt", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setShprCustSeq(JSPUtil.getParameter(request, prefix + "shpr_cust_seq", ""));
		setFacBkgRt(JSPUtil.getParameter(request, prefix + "fac_bkg_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFACAGMTRateInfoVO[]
	 */
	public SearchFACAGMTRateInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchFACAGMTRateInfoVO[]
	 */
	public SearchFACAGMTRateInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFACAGMTRateInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] facBxAmt = (JSPUtil.getParameter(request, prefix	+ "fac_bx_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] facOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_ofc_cd", length));
			String[] facAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "fac_agmt_seq", length));
			String[] grsNetDivCd = (JSPUtil.getParameter(request, prefix	+ "grs_net_div_cd", length));
			String[] ffCustSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] facSpclFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_feu_amt", length));
			String[] ofcOdr = (JSPUtil.getParameter(request, prefix	+ "ofc_odr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] facSglFlg = (JSPUtil.getParameter(request, prefix	+ "fac_sgl_flg", length));
			String[] facDryFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_dry_feu_amt", length));
			String[] facDivCd = (JSPUtil.getParameter(request, prefix	+ "fac_div_cd", length));
			String[] facBkgAmt = (JSPUtil.getParameter(request, prefix	+ "fac_bkg_amt", length));
			String[] facSpclCntrRt2 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_rt2", length));
			String[] facSpclCntrTpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_tp_ctnt1", length));
			String[] facSpclCntrRt1 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_rt1", length));
			String[] facRfTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_teu_amt", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] facRfFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_feu_amt", length));
			String[] facSpclCntrTpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_tp_ctnt2", length));
			String[] routCd = (JSPUtil.getParameter(request, prefix	+ "rout_cd", length));
			String[] odr = (JSPUtil.getParameter(request, prefix	+ "odr", length));
			String[] facRtOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_rt_ofc_cd", length));
			String[] facSpclTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_teu_amt", length));
			String[] facDryTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_dry_teu_amt", length));
			String[] facChgCtnt = (JSPUtil.getParameter(request, prefix	+ "fac_chg_ctnt", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] shprCustSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_seq", length));
			String[] facBkgRt = (JSPUtil.getParameter(request, prefix	+ "fac_bkg_rt", length));

			for (int i = 0; i < length; i++) {
				model = new SearchFACAGMTRateInfoVO();
				if (facBxAmt[i] != null)
					model.setFacBxAmt(facBxAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (facOfcCd[i] != null)
					model.setFacOfcCd(facOfcCd[i]);
				if (facAgmtSeq[i] != null)
					model.setFacAgmtSeq(facAgmtSeq[i]);
				if (grsNetDivCd[i] != null)
					model.setGrsNetDivCd(grsNetDivCd[i]);
				if (ffCustSeq[i] != null)
					model.setFfCustSeq(ffCustSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (facSpclFeuAmt[i] != null)
					model.setFacSpclFeuAmt(facSpclFeuAmt[i]);
				if (ofcOdr[i] != null)
					model.setOfcOdr(ofcOdr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (facSglFlg[i] != null)
					model.setFacSglFlg(facSglFlg[i]);
				if (facDryFeuAmt[i] != null)
					model.setFacDryFeuAmt(facDryFeuAmt[i]);
				if (facDivCd[i] != null)
					model.setFacDivCd(facDivCd[i]);
				if (facBkgAmt[i] != null)
					model.setFacBkgAmt(facBkgAmt[i]);
				if (facSpclCntrRt2[i] != null)
					model.setFacSpclCntrRt2(facSpclCntrRt2[i]);
				if (facSpclCntrTpCtnt1[i] != null)
					model.setFacSpclCntrTpCtnt1(facSpclCntrTpCtnt1[i]);
				if (facSpclCntrRt1[i] != null)
					model.setFacSpclCntrRt1(facSpclCntrRt1[i]);
				if (facRfTeuAmt[i] != null)
					model.setFacRfTeuAmt(facRfTeuAmt[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (facRfFeuAmt[i] != null)
					model.setFacRfFeuAmt(facRfFeuAmt[i]);
				if (facSpclCntrTpCtnt2[i] != null)
					model.setFacSpclCntrTpCtnt2(facSpclCntrTpCtnt2[i]);
				if (routCd[i] != null)
					model.setRoutCd(routCd[i]);
				if (odr[i] != null)
					model.setOdr(odr[i]);
				if (facRtOfcCd[i] != null)
					model.setFacRtOfcCd(facRtOfcCd[i]);
				if (facSpclTeuAmt[i] != null)
					model.setFacSpclTeuAmt(facSpclTeuAmt[i]);
				if (facDryTeuAmt[i] != null)
					model.setFacDryTeuAmt(facDryTeuAmt[i]);
				if (facChgCtnt[i] != null)
					model.setFacChgCtnt(facChgCtnt[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (shprCustSeq[i] != null)
					model.setShprCustSeq(shprCustSeq[i]);
				if (facBkgRt[i] != null)
					model.setFacBkgRt(facBkgRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFACAGMTRateInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFACAGMTRateInfoVO[]
	 */
	public SearchFACAGMTRateInfoVO[] getSearchFACAGMTRateInfoVOs(){
		SearchFACAGMTRateInfoVO[] vos = (SearchFACAGMTRateInfoVO[])models.toArray(new SearchFACAGMTRateInfoVO[models.size()]);
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
		this.facBxAmt = this.facBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facOfcCd = this.facOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facAgmtSeq = this.facAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsNetDivCd = this.grsNetDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCustSeq = this.ffCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclFeuAmt = this.facSpclFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcOdr = this.ofcOdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSglFlg = this.facSglFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDryFeuAmt = this.facDryFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDivCd = this.facDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facBkgAmt = this.facBkgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrRt2 = this.facSpclCntrRt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrTpCtnt1 = this.facSpclCntrTpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrRt1 = this.facSpclCntrRt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfTeuAmt = this.facRfTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfFeuAmt = this.facRfFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrTpCtnt2 = this.facSpclCntrTpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCd = this.routCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odr = this.odr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRtOfcCd = this.facRtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclTeuAmt = this.facSpclTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDryTeuAmt = this.facDryTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facChgCtnt = this.facChgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustSeq = this.shprCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facBkgRt = this.facBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
