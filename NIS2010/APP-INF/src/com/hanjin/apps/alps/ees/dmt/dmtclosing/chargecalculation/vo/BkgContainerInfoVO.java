/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgContainerInfoVO.java
*@FileTitle : BkgContainerInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.16 황효근 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgContainerInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgContainerInfoVO> models = new ArrayList<BkgContainerInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vndrCntCd = null;
	/* Column Info */
	private String delRgnCd = null;
	/* Column Info */
	private String dmdtTrfAplyTpCd = null;
	/* Column Info */
	private String yrdCntCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String yrdRgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polSteCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String yrdSteCd = null;
	/* Column Info */
	private String polRgnCd = null;
	/* Column Info */
	private String yrdCd = null;
	/* Column Info */
	private String porCntCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String delSteCd = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String delCntCd = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String polCntCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String polContiCd = null;
	/* Column Info */
	private String porSteCd = null;
	/* Column Info */
	private String yrdContiCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String porRgnCd = null;
	/* Column Info */
	private String delContiCd = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String dmdtBkgCgoTpCd = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String porContiCd = null;
	/* Column Info */
	private String bkgCntrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgContainerInfoVO() {}

	public BkgContainerInfoVO(String ibflag, String pagerows, String blNo, String porCd, String porContiCd, String porCntCd, String porRgnCd, String porSteCd, String podCd, String polCd, String polContiCd, String polCntCd, String polRgnCd, String polSteCd, String delCd, String delContiCd, String delCntCd, String delRgnCd, String delSteCd, String yrdCd, String yrdContiCd, String yrdCntCd, String yrdRgnCd, String yrdSteCd, String dmdtCntrTpCd, String dmdtBkgCgoTpCd, String bkgCntrQty, String fmMvmtStsCd, String fmMvmtDt, String fmMvmtYdCd, String toMvmtStsCd, String toMvmtDt, String toMvmtYdCd, String dmdtChgLocDivCd, String dmdtTrfAplyTpCd, String ofcCd, String ofcRhqCd, String custCntCd, String custSeq, String actCntCd, String actCustSeq, String vndrCntCd, String vndrSeq) {
		this.porCd = porCd;
		this.vndrCntCd = vndrCntCd;
		this.delRgnCd = delRgnCd;
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
		this.yrdCntCd = yrdCntCd;
		this.blNo = blNo;
		this.yrdRgnCd = yrdRgnCd;
		this.pagerows = pagerows;
		this.polSteCd = polSteCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.actCntCd = actCntCd;
		this.yrdSteCd = yrdSteCd;
		this.polRgnCd = polRgnCd;
		this.yrdCd = yrdCd;
		this.porCntCd = porCntCd;
		this.custCntCd = custCntCd;
		this.toMvmtDt = toMvmtDt;
		this.delSteCd = delSteCd;
		this.ofcRhqCd = ofcRhqCd;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.toMvmtStsCd = toMvmtStsCd;
		this.delCntCd = delCntCd;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.actCustSeq = actCustSeq;
		this.delCd = delCd;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.custSeq = custSeq;
		this.polCntCd = polCntCd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.polContiCd = polContiCd;
		this.porSteCd = porSteCd;
		this.yrdContiCd = yrdContiCd;
		this.vndrSeq = vndrSeq;
		this.porRgnCd = porRgnCd;
		this.delContiCd = delContiCd;
		this.fmMvmtDt = fmMvmtDt;
		this.dmdtBkgCgoTpCd = dmdtBkgCgoTpCd;
		this.toMvmtYdCd = toMvmtYdCd;
		this.porContiCd = porContiCd;
		this.bkgCntrQty = bkgCntrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
		this.hashColumns.put("del_rgn_cd", getDelRgnCd());
		this.hashColumns.put("dmdt_trf_aply_tp_cd", getDmdtTrfAplyTpCd());
		this.hashColumns.put("yrd_cnt_cd", getYrdCntCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("yrd_rgn_cd", getYrdRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_ste_cd", getPolSteCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("yrd_ste_cd", getYrdSteCd());
		this.hashColumns.put("pol_rgn_cd", getPolRgnCd());
		this.hashColumns.put("yrd_cd", getYrdCd());
		this.hashColumns.put("por_cnt_cd", getPorCntCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("del_ste_cd", getDelSteCd());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("del_cnt_cd", getDelCntCd());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pol_cnt_cd", getPolCntCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pol_conti_cd", getPolContiCd());
		this.hashColumns.put("por_ste_cd", getPorSteCd());
		this.hashColumns.put("yrd_conti_cd", getYrdContiCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("por_rgn_cd", getPorRgnCd());
		this.hashColumns.put("del_conti_cd", getDelContiCd());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("dmdt_bkg_cgo_tp_cd", getDmdtBkgCgoTpCd());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("por_conti_cd", getPorContiCd());
		this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
		this.hashFields.put("del_rgn_cd", "delRgnCd");
		this.hashFields.put("dmdt_trf_aply_tp_cd", "dmdtTrfAplyTpCd");
		this.hashFields.put("yrd_cnt_cd", "yrdCntCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("yrd_rgn_cd", "yrdRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_ste_cd", "polSteCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("yrd_ste_cd", "yrdSteCd");
		this.hashFields.put("pol_rgn_cd", "polRgnCd");
		this.hashFields.put("yrd_cd", "yrdCd");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("del_ste_cd", "delSteCd");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pol_cnt_cd", "polCntCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pol_conti_cd", "polContiCd");
		this.hashFields.put("por_ste_cd", "porSteCd");
		this.hashFields.put("yrd_conti_cd", "yrdContiCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("por_rgn_cd", "porRgnCd");
		this.hashFields.put("del_conti_cd", "delContiCd");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("dmdt_bkg_cgo_tp_cd", "dmdtBkgCgoTpCd");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("por_conti_cd", "porContiCd");
		this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCntCd
	 */
	public String getVndrCntCd() {
		return this.vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return delRgnCd
	 */
	public String getDelRgnCd() {
		return this.delRgnCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfAplyTpCd
	 */
	public String getDmdtTrfAplyTpCd() {
		return this.dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return yrdCntCd
	 */
	public String getYrdCntCd() {
		return this.yrdCntCd;
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
	 * @return yrdRgnCd
	 */
	public String getYrdRgnCd() {
		return this.yrdRgnCd;
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
	 * @return polSteCd
	 */
	public String getPolSteCd() {
		return this.polSteCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
	}
	
	/**
	 * Column Info
	 * @return yrdSteCd
	 */
	public String getYrdSteCd() {
		return this.yrdSteCd;
	}
	
	/**
	 * Column Info
	 * @return polRgnCd
	 */
	public String getPolRgnCd() {
		return this.polRgnCd;
	}
	
	/**
	 * Column Info
	 * @return yrdCd
	 */
	public String getYrdCd() {
		return this.yrdCd;
	}
	
	/**
	 * Column Info
	 * @return porCntCd
	 */
	public String getPorCntCd() {
		return this.porCntCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtDt
	 */
	public String getToMvmtDt() {
		return this.toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return delSteCd
	 */
	public String getDelSteCd() {
		return this.delSteCd;
	}
	
	/**
	 * Column Info
	 * @return ofcRhqCd
	 */
	public String getOfcRhqCd() {
		return this.ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtYdCd
	 */
	public String getFmMvmtYdCd() {
		return this.fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtStsCd
	 */
	public String getToMvmtStsCd() {
		return this.toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return delCntCd
	 */
	public String getDelCntCd() {
		return this.delCntCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtStsCd
	 */
	public String getFmMvmtStsCd() {
		return this.fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return polCntCd
	 */
	public String getPolCntCd() {
		return this.polCntCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return polContiCd
	 */
	public String getPolContiCd() {
		return this.polContiCd;
	}
	
	/**
	 * Column Info
	 * @return porSteCd
	 */
	public String getPorSteCd() {
		return this.porSteCd;
	}
	
	/**
	 * Column Info
	 * @return yrdContiCd
	 */
	public String getYrdContiCd() {
		return this.yrdContiCd;
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
	 * @return porRgnCd
	 */
	public String getPorRgnCd() {
		return this.porRgnCd;
	}
	
	/**
	 * Column Info
	 * @return delContiCd
	 */
	public String getDelContiCd() {
		return this.delContiCd;
	}
	
	/**
	 * Column Info
	 * @return fmMvmtDt
	 */
	public String getFmMvmtDt() {
		return this.fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtBkgCgoTpCd
	 */
	public String getDmdtBkgCgoTpCd() {
		return this.dmdtBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return toMvmtYdCd
	 */
	public String getToMvmtYdCd() {
		return this.toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return porContiCd
	 */
	public String getPorContiCd() {
		return this.porContiCd;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCntCd
	 */
	public void setVndrCntCd(String vndrCntCd) {
		this.vndrCntCd = vndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param delRgnCd
	 */
	public void setDelRgnCd(String delRgnCd) {
		this.delRgnCd = delRgnCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfAplyTpCd
	 */
	public void setDmdtTrfAplyTpCd(String dmdtTrfAplyTpCd) {
		this.dmdtTrfAplyTpCd = dmdtTrfAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param yrdCntCd
	 */
	public void setYrdCntCd(String yrdCntCd) {
		this.yrdCntCd = yrdCntCd;
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
	 * @param yrdRgnCd
	 */
	public void setYrdRgnCd(String yrdRgnCd) {
		this.yrdRgnCd = yrdRgnCd;
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
	 * @param polSteCd
	 */
	public void setPolSteCd(String polSteCd) {
		this.polSteCd = polSteCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
	}
	
	/**
	 * Column Info
	 * @param yrdSteCd
	 */
	public void setYrdSteCd(String yrdSteCd) {
		this.yrdSteCd = yrdSteCd;
	}
	
	/**
	 * Column Info
	 * @param polRgnCd
	 */
	public void setPolRgnCd(String polRgnCd) {
		this.polRgnCd = polRgnCd;
	}
	
	/**
	 * Column Info
	 * @param yrdCd
	 */
	public void setYrdCd(String yrdCd) {
		this.yrdCd = yrdCd;
	}
	
	/**
	 * Column Info
	 * @param porCntCd
	 */
	public void setPorCntCd(String porCntCd) {
		this.porCntCd = porCntCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtDt
	 */
	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param delSteCd
	 */
	public void setDelSteCd(String delSteCd) {
		this.delSteCd = delSteCd;
	}
	
	/**
	 * Column Info
	 * @param ofcRhqCd
	 */
	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtYdCd
	 */
	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtStsCd
	 */
	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param delCntCd
	 */
	public void setDelCntCd(String delCntCd) {
		this.delCntCd = delCntCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtStsCd
	 */
	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param polCntCd
	 */
	public void setPolCntCd(String polCntCd) {
		this.polCntCd = polCntCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param polContiCd
	 */
	public void setPolContiCd(String polContiCd) {
		this.polContiCd = polContiCd;
	}
	
	/**
	 * Column Info
	 * @param porSteCd
	 */
	public void setPorSteCd(String porSteCd) {
		this.porSteCd = porSteCd;
	}
	
	/**
	 * Column Info
	 * @param yrdContiCd
	 */
	public void setYrdContiCd(String yrdContiCd) {
		this.yrdContiCd = yrdContiCd;
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
	 * @param porRgnCd
	 */
	public void setPorRgnCd(String porRgnCd) {
		this.porRgnCd = porRgnCd;
	}
	
	/**
	 * Column Info
	 * @param delContiCd
	 */
	public void setDelContiCd(String delContiCd) {
		this.delContiCd = delContiCd;
	}
	
	/**
	 * Column Info
	 * @param fmMvmtDt
	 */
	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtBkgCgoTpCd
	 */
	public void setDmdtBkgCgoTpCd(String dmdtBkgCgoTpCd) {
		this.dmdtBkgCgoTpCd = dmdtBkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param toMvmtYdCd
	 */
	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param porContiCd
	 */
	public void setPorContiCd(String porContiCd) {
		this.porContiCd = porContiCd;
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
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
		setDelRgnCd(JSPUtil.getParameter(request, "del_rgn_cd", ""));
		setDmdtTrfAplyTpCd(JSPUtil.getParameter(request, "dmdt_trf_aply_tp_cd", ""));
		setYrdCntCd(JSPUtil.getParameter(request, "yrd_cnt_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setYrdRgnCd(JSPUtil.getParameter(request, "yrd_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolSteCd(JSPUtil.getParameter(request, "pol_ste_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActCntCd(JSPUtil.getParameter(request, "act_cnt_cd", ""));
		setYrdSteCd(JSPUtil.getParameter(request, "yrd_ste_cd", ""));
		setPolRgnCd(JSPUtil.getParameter(request, "pol_rgn_cd", ""));
		setYrdCd(JSPUtil.getParameter(request, "yrd_cd", ""));
		setPorCntCd(JSPUtil.getParameter(request, "por_cnt_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setToMvmtDt(JSPUtil.getParameter(request, "to_mvmt_dt", ""));
		setDelSteCd(JSPUtil.getParameter(request, "del_ste_cd", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, "ofc_rhq_cd", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, "dmdt_chg_loc_div_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, "fm_mvmt_yd_cd", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, "to_mvmt_sts_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request, "del_cnt_cd", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, "fm_mvmt_sts_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPolCntCd(JSPUtil.getParameter(request, "pol_cnt_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setPolContiCd(JSPUtil.getParameter(request, "pol_conti_cd", ""));
		setPorSteCd(JSPUtil.getParameter(request, "por_ste_cd", ""));
		setYrdContiCd(JSPUtil.getParameter(request, "yrd_conti_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPorRgnCd(JSPUtil.getParameter(request, "por_rgn_cd", ""));
		setDelContiCd(JSPUtil.getParameter(request, "del_conti_cd", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, "fm_mvmt_dt", ""));
		setDmdtBkgCgoTpCd(JSPUtil.getParameter(request, "dmdt_bkg_cgo_tp_cd", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, "to_mvmt_yd_cd", ""));
		setPorContiCd(JSPUtil.getParameter(request, "por_conti_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, "bkg_cntr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgContainerInfoVO[]
	 */
	public BkgContainerInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgContainerInfoVO[]
	 */
	public BkgContainerInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgContainerInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vndrCntCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cnt_cd", length));
			String[] delRgnCd = (JSPUtil.getParameter(request, prefix	+ "del_rgn_cd", length));
			String[] dmdtTrfAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_aply_tp_cd", length));
			String[] yrdCntCd = (JSPUtil.getParameter(request, prefix	+ "yrd_cnt_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] yrdRgnCd = (JSPUtil.getParameter(request, prefix	+ "yrd_rgn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polSteCd = (JSPUtil.getParameter(request, prefix	+ "pol_ste_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] yrdSteCd = (JSPUtil.getParameter(request, prefix	+ "yrd_ste_cd", length));
			String[] polRgnCd = (JSPUtil.getParameter(request, prefix	+ "pol_rgn_cd", length));
			String[] yrdCd = (JSPUtil.getParameter(request, prefix	+ "yrd_cd", length));
			String[] porCntCd = (JSPUtil.getParameter(request, prefix	+ "por_cnt_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] delSteCd = (JSPUtil.getParameter(request, prefix	+ "del_ste_cd", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] delCntCd = (JSPUtil.getParameter(request, prefix	+ "del_cnt_cd", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] polCntCd = (JSPUtil.getParameter(request, prefix	+ "pol_cnt_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] polContiCd = (JSPUtil.getParameter(request, prefix	+ "pol_conti_cd", length));
			String[] porSteCd = (JSPUtil.getParameter(request, prefix	+ "por_ste_cd", length));
			String[] yrdContiCd = (JSPUtil.getParameter(request, prefix	+ "yrd_conti_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] porRgnCd = (JSPUtil.getParameter(request, prefix	+ "por_rgn_cd", length));
			String[] delContiCd = (JSPUtil.getParameter(request, prefix	+ "del_conti_cd", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] dmdtBkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_bkg_cgo_tp_cd", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] porContiCd = (JSPUtil.getParameter(request, prefix	+ "por_conti_cd", length));
			String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgContainerInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vndrCntCd[i] != null)
					model.setVndrCntCd(vndrCntCd[i]);
				if (delRgnCd[i] != null)
					model.setDelRgnCd(delRgnCd[i]);
				if (dmdtTrfAplyTpCd[i] != null)
					model.setDmdtTrfAplyTpCd(dmdtTrfAplyTpCd[i]);
				if (yrdCntCd[i] != null)
					model.setYrdCntCd(yrdCntCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (yrdRgnCd[i] != null)
					model.setYrdRgnCd(yrdRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polSteCd[i] != null)
					model.setPolSteCd(polSteCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (yrdSteCd[i] != null)
					model.setYrdSteCd(yrdSteCd[i]);
				if (polRgnCd[i] != null)
					model.setPolRgnCd(polRgnCd[i]);
				if (yrdCd[i] != null)
					model.setYrdCd(yrdCd[i]);
				if (porCntCd[i] != null)
					model.setPorCntCd(porCntCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (delSteCd[i] != null)
					model.setDelSteCd(delSteCd[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setFmMvmtYdCd(fmMvmtYdCd[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (delCntCd[i] != null)
					model.setDelCntCd(delCntCd[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (polCntCd[i] != null)
					model.setPolCntCd(polCntCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (polContiCd[i] != null)
					model.setPolContiCd(polContiCd[i]);
				if (porSteCd[i] != null)
					model.setPorSteCd(porSteCd[i]);
				if (yrdContiCd[i] != null)
					model.setYrdContiCd(yrdContiCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (porRgnCd[i] != null)
					model.setPorRgnCd(porRgnCd[i]);
				if (delContiCd[i] != null)
					model.setDelContiCd(delContiCd[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (dmdtBkgCgoTpCd[i] != null)
					model.setDmdtBkgCgoTpCd(dmdtBkgCgoTpCd[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtYdCd[i]);
				if (porContiCd[i] != null)
					model.setPorContiCd(porContiCd[i]);
				if (bkgCntrQty[i] != null)
					model.setBkgCntrQty(bkgCntrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgContainerInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgContainerInfoVO[]
	 */
	public BkgContainerInfoVO[] getBkgContainerInfoVOs(){
		BkgContainerInfoVO[] vos = (BkgContainerInfoVO[])models.toArray(new BkgContainerInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntCd = this.vndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRgnCd = this.delRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfAplyTpCd = this.dmdtTrfAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdCntCd = this.yrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdRgnCd = this.yrdRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSteCd = this.polSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdSteCd = this.yrdSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRgnCd = this.polRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdCd = this.yrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd = this.porCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSteCd = this.delSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd = this.delCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCntCd = this.polCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiCd = this.polContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porSteCd = this.porSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrdContiCd = this.yrdContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRgnCd = this.porRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delContiCd = this.delContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBkgCgoTpCd = this.dmdtBkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porContiCd = this.porContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrQty = this.bkgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
