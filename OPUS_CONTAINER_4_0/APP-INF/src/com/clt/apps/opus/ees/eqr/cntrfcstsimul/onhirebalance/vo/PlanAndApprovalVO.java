/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PlanAndApprovalVO.java
*@FileTitle : PlanAndApprovalVO
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PlanAndApprovalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PlanAndApprovalVO> models = new ArrayList<PlanAndApprovalVO>();
	
	/* Column Info */
	private String f2Qty = null;
	/* Column Info */
	private String cntrOnhAuthNo = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String s2Qty = null;
	/* Column Info */
	private String f5Qty = null;
	/* Column Info */
	private String stsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String d2Qty = null;
	/* Column Info */
	private String onhPlnYrwk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lsePlnSeq = null;
	/* Column Info */
	private String o4Qty = null;
	/* Column Info */
	private String o5Qty = null;
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String a4Qty = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String a2Qty = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String stsNm = null;
	/* Column Info */
	private String lseRqstNo = null;
	/* Column Info */
	private String d7Qty = null;
	/* Column Info */
	private String s4Qty = null;
	/* Column Info */
	private String r2Qty = null;
	/* Column Info */
	private String onhLocCd = null;
	/* Column Info */
	private String eqLstmCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String o2Qty = null;
	/* Column Info */
	private String d4Qty = null;
	/* Column Info */
	private String r9Qty = null;
	/* Column Info */
	private String r5Qty = null;
	/* Column Info */
	private String d5Qty = null;
	/* Column Info */
	private String mftYr = null;
	/* Column Info */
	private String f4Qty = null;
	
	/* Column Info */
	private String onhPkupYrwk = null; // onh_pkup_yrwk	
	/* Column Info */
	private String onhOrdYr = null;	   // onh_ord_yr

	/*	Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PlanAndApprovalVO() {}

	public PlanAndApprovalVO(String ibflag, String pagerows, String onhPlnYrwk, String lccCd, String eqLstmCd, String lsePlnSeq, String lseRqstNo, String rccCd, String aproRmk
			, String d2Qty, String d4Qty, String d5Qty, String d7Qty, String r2Qty, String r5Qty, String r9Qty, String o2Qty, String o4Qty, String o5Qty, String s2Qty, String s4Qty
			, String f2Qty, String f4Qty, String f5Qty, String a2Qty, String a4Qty, String creUsrId, String creDt, String updUsrId, String updDt, String cntrOnhAuthNo, String mftYr
			, String agmtNo, String onhLocCd, String stsCd, String stsNm, String onhPkupYrwk, String onhOrdYr) {
		this.f2Qty = f2Qty;
		this.cntrOnhAuthNo = cntrOnhAuthNo;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.s2Qty = s2Qty;
		this.f5Qty = f5Qty;
		this.stsCd = stsCd;
		this.ibflag = ibflag;
		this.d2Qty = d2Qty;
		this.onhPlnYrwk = onhPlnYrwk;
		this.updUsrId = updUsrId;
		this.lsePlnSeq = lsePlnSeq;
		this.o4Qty = o4Qty;
		this.o5Qty = o5Qty;		
		this.updDt = updDt;
		this.aproRmk = aproRmk;
		this.a4Qty = a4Qty;
		this.agmtNo = agmtNo;
		this.a2Qty = a2Qty;
		this.rccCd = rccCd;
		this.stsNm = stsNm;
		this.lseRqstNo = lseRqstNo;
		this.d7Qty = d7Qty;
		this.s4Qty = s4Qty;
		this.r2Qty = r2Qty;
		this.onhLocCd = onhLocCd;
		this.eqLstmCd = eqLstmCd;
		this.lccCd = lccCd;
		this.creUsrId = creUsrId;
		this.o2Qty = o2Qty;
		this.d4Qty = d4Qty;
		this.r9Qty = r9Qty;
		this.r5Qty = r5Qty;
		this.d5Qty = d5Qty;
		this.mftYr = mftYr;
		this.f4Qty = f4Qty;
		
		this.onhPkupYrwk = onhPkupYrwk;
		this.onhOrdYr = onhOrdYr;
	}
	
	/**
	 * Hashtable<"column_name", "value">
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f2_qty", getF2Qty());
		this.hashColumns.put("cntr_onh_auth_no", getCntrOnhAuthNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s2_qty", getS2Qty());
		this.hashColumns.put("f5_qty", getF5Qty());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d2_qty", getD2Qty());
		this.hashColumns.put("onh_pln_yrwk", getOnhPlnYrwk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lse_pln_seq", getLsePlnSeq());
		this.hashColumns.put("o4_qty", getO4Qty());
		this.hashColumns.put("o5_qty", getO5Qty());		
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("a4_qty", getA4Qty());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("a2_qty", getA2Qty());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("sts_nm", getStsNm());
		this.hashColumns.put("lse_rqst_no", getLseRqstNo());
		this.hashColumns.put("d7_qty", getD7Qty());
		this.hashColumns.put("s4_qty", getS4Qty());
		this.hashColumns.put("r2_qty", getR2Qty());
		this.hashColumns.put("onh_loc_cd", getOnhLocCd());
		this.hashColumns.put("eq_lstm_cd", getEqLstmCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("o2_qty", getO2Qty());
		this.hashColumns.put("d4_qty", getD4Qty());
		this.hashColumns.put("r9_qty", getR9Qty());
		this.hashColumns.put("r5_qty", getR5Qty());
		this.hashColumns.put("d5_qty", getD5Qty());
		this.hashColumns.put("mft_yr", getMftYr());
		this.hashColumns.put("f4_qty", getF4Qty());
		
		this.hashColumns.put("onh_ord_yr", 	  getOnhOrdYr());
		this.hashColumns.put("onh_pkup_yrwk", getOnhPkupYrwk());	
		
		return this.hashColumns;
	}
	
	/**
	 * Hashtable<"column_name", "variable">   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f2_qty", "f2Qty");
		this.hashFields.put("cntr_onh_auth_no", "cntrOnhAuthNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s2_qty", "s2Qty");
		this.hashFields.put("f5_qty", "f5Qty");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d2_qty", "d2Qty");
		this.hashFields.put("onh_pln_yrwk", "onhPlnYrwk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lse_pln_seq", "lsePlnSeq");
		this.hashFields.put("o4_qty", "o4Qty");
		this.hashFields.put("o5_qty", "o5Qty");		
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("a4_qty", "a4Qty");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("a2_qty", "a2Qty");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("sts_nm", "stsNm");
		this.hashFields.put("lse_rqst_no", "lseRqstNo");
		this.hashFields.put("d7_qty", "d7Qty");
		this.hashFields.put("s4_qty", "s4Qty");
		this.hashFields.put("r2_qty", "r2Qty");
		this.hashFields.put("onh_loc_cd", "onhLocCd");
		this.hashFields.put("eq_lstm_cd", "eqLstmCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("o2_qty", "o2Qty");
		this.hashFields.put("d4_qty", "d4Qty");
		this.hashFields.put("r9_qty", "r9Qty");
		this.hashFields.put("r5_qty", "r5Qty");
		this.hashFields.put("d5_qty", "d5Qty");
		this.hashFields.put("mft_yr", "mftYr");
		this.hashFields.put("f4_qty", "f4Qty");
		
		this.hashFields.put("onh_ord_yr", 	 "onhOrdYr");
		this.hashFields.put("onh_pkup_yrwk", "onhPkupYrwk");	
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return f2Qty
	 */
	public String getF2Qty() {
		return this.f2Qty;
	}
	
	/**
	 * Column Info
	 * @return cntrOnhAuthNo
	 */
	public String getCntrOnhAuthNo() {
		return this.cntrOnhAuthNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return s2Qty
	 */
	public String getS2Qty() {
		return this.s2Qty;
	}
	
	/**
	 * Column Info
	 * @return f5Qty
	 */
	public String getF5Qty() {
		return this.f5Qty;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * @return d2Qty
	 */
	public String getD2Qty() {
		return this.d2Qty;
	}
	
	/**
	 * Column Info
	 * @return onhPlnYrwk
	 */
	public String getOnhPlnYrwk() {
		return this.onhPlnYrwk;
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
	 * @return lsePlnSeq
	 */
	public String getLsePlnSeq() {
		return this.lsePlnSeq;
	}
	
	/**
	 * Column Info
	 * @return o4Qty
	 */
	public String getO4Qty() {
		return this.o4Qty;
	}
	
	/**
	 * Column Info
	 * @return o5Qty
	 */
	public String getO5Qty() {
		return this.o5Qty;
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
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return a4Qty
	 */
	public String getA4Qty() {
		return this.a4Qty;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return a2Qty
	 */
	public String getA2Qty() {
		return this.a2Qty;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return stsNm
	 */
	public String getStsNm() {
		return this.stsNm;
	}
	
	/**
	 * Column Info
	 * @return lseRqstNo
	 */
	public String getLseRqstNo() {
		return this.lseRqstNo;
	}
	
	/**
	 * Column Info
	 * @return d7Qty
	 */
	public String getD7Qty() {
		return this.d7Qty;
	}
	
	/**
	 * Column Info
	 * @return s4Qty
	 */
	public String getS4Qty() {
		return this.s4Qty;
	}
	
	/**
	 * Column Info
	 * @return r2Qty
	 */
	public String getR2Qty() {
		return this.r2Qty;
	}
	
	/**
	 * Column Info
	 * @return onhLocCd
	 */
	public String getOnhLocCd() {
		return this.onhLocCd;
	}
	
	/**
	 * Column Info
	 * @return eqLstmCd
	 */
	public String getEqLstmCd() {
		return this.eqLstmCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return o2Qty
	 */
	public String getO2Qty() {
		return this.o2Qty;
	}
	
	/**
	 * Column Info
	 * @return d4Qty
	 */
	public String getD4Qty() {
		return this.d4Qty;
	}
	
	/**
	 * Column Info
	 * @return r9Qty
	 */
	public String getR9Qty() {
		return this.r9Qty;
	}
	
	/**
	 * Column Info
	 * @return r5Qty
	 */
	public String getR5Qty() {
		return this.r5Qty;
	}
	
	/**
	 * Column Info
	 * @return d5Qty
	 */
	public String getD5Qty() {
		return this.d5Qty;
	}
	
	/**
	 * Column Info
	 * @return mftYr
	 */
	public String getMftYr() {
		return this.mftYr;
	}
	
	/**
	 * Column Info
	 * @return f4Qty
	 */
	public String getF4Qty() {
		return this.f4Qty;
	}
	
	/**
	 * Column Info
	 * @return onhOrdYr
	 */
	public String getOnhOrdYr() {
		return this.onhOrdYr;
	}	
	
	/**
	 * Column Info
	 * @return onhPkupYrwk
	 */
	public String getOnhPkupYrwk() {
		return this.onhPkupYrwk;
	}		
	
	/**
	 * Column Info
	 * @param f2Qty
	 */
	public void setF2Qty(String f2Qty) {
		this.f2Qty = f2Qty;
	}
	
	/**
	 * Column Info
	 * @param cntrOnhAuthNo
	 */
	public void setCntrOnhAuthNo(String cntrOnhAuthNo) {
		this.cntrOnhAuthNo = cntrOnhAuthNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param s2Qty
	 */
	public void setS2Qty(String s2Qty) {
		this.s2Qty = s2Qty;
	}
	
	/**
	 * Column Info
	 * @param f5Qty
	 */
	public void setF5Qty(String f5Qty) {
		this.f5Qty = f5Qty;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * @param d2Qty
	 */
	public void setD2Qty(String d2Qty) {
		this.d2Qty = d2Qty;
	}
	
	/**
	 * Column Info
	 * @param onhPlnYrwk
	 */
	public void setOnhPlnYrwk(String onhPlnYrwk) {
		this.onhPlnYrwk = onhPlnYrwk;
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
	 * @param lsePlnSeq
	 */
	public void setLsePlnSeq(String lsePlnSeq) {
		this.lsePlnSeq = lsePlnSeq;
	}
	
	/**
	 * Column Info
	 * @param o4Qty
	 */
	public void setO4Qty(String o4Qty) {
		this.o4Qty = o4Qty;
	}
	
	/**
	 * Column Info
	 * @param o5Qty
	 */
	public void setO5Qty(String o5Qty) {
		this.o5Qty = o5Qty;
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
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param a4Qty
	 */
	public void setA4Qty(String a4Qty) {
		this.a4Qty = a4Qty;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param a2Qty
	 */
	public void setA2Qty(String a2Qty) {
		this.a2Qty = a2Qty;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param stsNm
	 */
	public void setStsNm(String stsNm) {
		this.stsNm = stsNm;
	}
	
	/**
	 * Column Info
	 * @param lseRqstNo
	 */
	public void setLseRqstNo(String lseRqstNo) {
		this.lseRqstNo = lseRqstNo;
	}
	
	/**
	 * Column Info
	 * @param d7Qty
	 */
	public void setD7Qty(String d7Qty) {
		this.d7Qty = d7Qty;
	}
	
	/**
	 * Column Info
	 * @param s4Qty
	 */
	public void setS4Qty(String s4Qty) {
		this.s4Qty = s4Qty;
	}
	
	/**
	 * Column Info
	 * @param r2Qty
	 */
	public void setR2Qty(String r2Qty) {
		this.r2Qty = r2Qty;
	}
	
	/**
	 * Column Info
	 * @param onhLocCd
	 */
	public void setOnhLocCd(String onhLocCd) {
		this.onhLocCd = onhLocCd;
	}
	
	/**
	 * Column Info
	 * @param eqLstmCd
	 */
	public void setEqLstmCd(String eqLstmCd) {
		this.eqLstmCd = eqLstmCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param o2Qty
	 */
	public void setO2Qty(String o2Qty) {
		this.o2Qty = o2Qty;
	}
	
	/**
	 * Column Info
	 * @param d4Qty
	 */
	public void setD4Qty(String d4Qty) {
		this.d4Qty = d4Qty;
	}
	
	/**
	 * Column Info
	 * @param r9Qty
	 */
	public void setR9Qty(String r9Qty) {
		this.r9Qty = r9Qty;
	}
	
	/**
	 * Column Info
	 * @param r5Qty
	 */
	public void setR5Qty(String r5Qty) {
		this.r5Qty = r5Qty;
	}
	
	/**
	 * Column Info
	 * @param d5Qty
	 */
	public void setD5Qty(String d5Qty) {
		this.d5Qty = d5Qty;
	}
	
	/**
	 * Column Info
	 * @param mftYr
	 */
	public void setMftYr(String mftYr) {
		this.mftYr = mftYr;
	}
	
	/**
	 * Column Info
	 * @param f4Qty
	 */
	public void setF4Qty(String f4Qty) {
		this.f4Qty = f4Qty;
	}
	
	/**
	 * Column Info
	 * @return onhOrdYr
	 */
	public void setOnhOrdYr(String onhOrdYr) {
		this.onhOrdYr = onhOrdYr;
	}	
	
	/**
	 * Column Info
	 * @return onhPkupYrwk
	 */
	public void setOnhPkupYrwk(String onhPkupYrwk) {
		this.onhPkupYrwk = onhPkupYrwk;
	}	
	
/**
	 * Request - VO 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request - VO
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setF2Qty(JSPUtil.getParameter(request, prefix + "f2_qty", ""));
		setCntrOnhAuthNo(JSPUtil.getParameter(request, prefix + "cntr_onh_auth_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setS2Qty(JSPUtil.getParameter(request, prefix + "s2_qty", ""));
		setF5Qty(JSPUtil.getParameter(request, prefix + "f5_qty", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setD2Qty(JSPUtil.getParameter(request, prefix + "d2_qty", ""));
		setOnhPlnYrwk(JSPUtil.getParameter(request, prefix + "onh_pln_yrwk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLsePlnSeq(JSPUtil.getParameter(request, prefix + "lse_pln_seq", ""));
		setO4Qty(JSPUtil.getParameter(request, prefix + "o4_qty", ""));
		setO5Qty(JSPUtil.getParameter(request, prefix + "o5_qty", ""));		
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setA4Qty(JSPUtil.getParameter(request, prefix + "a4_qty", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setA2Qty(JSPUtil.getParameter(request, prefix + "a2_qty", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setStsNm(JSPUtil.getParameter(request, prefix + "sts_nm", ""));
		setLseRqstNo(JSPUtil.getParameter(request, prefix + "lse_rqst_no", ""));
		setD7Qty(JSPUtil.getParameter(request, prefix + "d7_qty", ""));
		setS4Qty(JSPUtil.getParameter(request, prefix + "s4_qty", ""));
		setR2Qty(JSPUtil.getParameter(request, prefix + "r2_qty", ""));
		setOnhLocCd(JSPUtil.getParameter(request, prefix + "onh_loc_cd", ""));
		setEqLstmCd(JSPUtil.getParameter(request, prefix + "eq_lstm_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setO2Qty(JSPUtil.getParameter(request, prefix + "o2_qty", ""));
		setD4Qty(JSPUtil.getParameter(request, prefix + "d4_qty", ""));
		setR9Qty(JSPUtil.getParameter(request, prefix + "r9_qty", ""));
		setR5Qty(JSPUtil.getParameter(request, prefix + "r5_qty", ""));
		setD5Qty(JSPUtil.getParameter(request, prefix + "d5_qty", ""));
		setMftYr(JSPUtil.getParameter(request, prefix + "mft_yr", ""));
		setF4Qty(JSPUtil.getParameter(request, prefix + "f4_qty", ""));
		
		setOnhOrdYr(JSPUtil.getParameter(request, prefix + "onh_ord_yr", ""));
		setOnhPkupYrwk(JSPUtil.getParameter(request, prefix + "onh_pkup_yrwk", ""));		
	}

	/**
	 * @param request
	 * @return PlanAndApprovalVO[]
	 */
	public PlanAndApprovalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * @param request
	 * @param prefix
	 * @return PlanAndApprovalVO[]
	 */
	public PlanAndApprovalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PlanAndApprovalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] f2Qty = (JSPUtil.getParameter(request, prefix	+ "f2_qty", length));
			String[] cntrOnhAuthNo = (JSPUtil.getParameter(request, prefix	+ "cntr_onh_auth_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s2Qty = (JSPUtil.getParameter(request, prefix	+ "s2_qty", length));
			String[] f5Qty = (JSPUtil.getParameter(request, prefix	+ "f5_qty", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] d2Qty = (JSPUtil.getParameter(request, prefix	+ "d2_qty", length));
			String[] onhPlnYrwk = (JSPUtil.getParameter(request, prefix	+ "onh_pln_yrwk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lsePlnSeq = (JSPUtil.getParameter(request, prefix	+ "lse_pln_seq", length));
			String[] o4Qty = (JSPUtil.getParameter(request, prefix	+ "o4_qty", length));
			String[] o5Qty = (JSPUtil.getParameter(request, prefix	+ "o5_qty", length));			
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] a4Qty = (JSPUtil.getParameter(request, prefix	+ "a4_qty", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] a2Qty = (JSPUtil.getParameter(request, prefix	+ "a2_qty", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] stsNm = (JSPUtil.getParameter(request, prefix	+ "sts_nm", length));
			String[] lseRqstNo = (JSPUtil.getParameter(request, prefix	+ "lse_rqst_no", length));
			String[] d7Qty = (JSPUtil.getParameter(request, prefix	+ "d7_qty", length));
			String[] s4Qty = (JSPUtil.getParameter(request, prefix	+ "s4_qty", length));
			String[] r2Qty = (JSPUtil.getParameter(request, prefix	+ "r2_qty", length));
			String[] onhLocCd = (JSPUtil.getParameter(request, prefix	+ "onh_loc_cd", length));
			String[] eqLstmCd = (JSPUtil.getParameter(request, prefix	+ "eq_lstm_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] o2Qty = (JSPUtil.getParameter(request, prefix	+ "o2_qty", length));
			String[] d4Qty = (JSPUtil.getParameter(request, prefix	+ "d4_qty", length));
			String[] r9Qty = (JSPUtil.getParameter(request, prefix	+ "r9_qty", length));
			String[] r5Qty = (JSPUtil.getParameter(request, prefix	+ "r5_qty", length));
			String[] d5Qty = (JSPUtil.getParameter(request, prefix	+ "d5_qty", length));
			String[] mftYr = (JSPUtil.getParameter(request, prefix	+ "mft_yr", length));
			String[] f4Qty = (JSPUtil.getParameter(request, prefix	+ "f4_qty", length));
			
			String[] onhOrdYr    = (JSPUtil.getParameter(request, prefix	+ "onh_ord_yr", length));
			String[] onhPkupYrwk = (JSPUtil.getParameter(request, prefix	+ "onh_pkup_yrwk", length));			
			
			for (int i = 0; i < length; i++) {
				model = new PlanAndApprovalVO();
				if (f2Qty[i] != null)
					model.setF2Qty(f2Qty[i]);
				if (cntrOnhAuthNo[i] != null)
					model.setCntrOnhAuthNo(cntrOnhAuthNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (s2Qty[i] != null)
					model.setS2Qty(s2Qty[i]);
				if (f5Qty[i] != null)
					model.setF5Qty(f5Qty[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (d2Qty[i] != null)
					model.setD2Qty(d2Qty[i]);
				if (onhPlnYrwk[i] != null)
					model.setOnhPlnYrwk(onhPlnYrwk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lsePlnSeq[i] != null)
					model.setLsePlnSeq(lsePlnSeq[i]);
				if (o4Qty[i] != null)
					model.setO4Qty(o4Qty[i]);
				if (o5Qty[i] != null)
					model.setO5Qty(o5Qty[i]);				
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (a4Qty[i] != null)
					model.setA4Qty(a4Qty[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (a2Qty[i] != null)
					model.setA2Qty(a2Qty[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (stsNm[i] != null)
					model.setStsNm(stsNm[i]);
				if (lseRqstNo[i] != null)
					model.setLseRqstNo(lseRqstNo[i]);
				if (d7Qty[i] != null)
					model.setD7Qty(d7Qty[i]);
				if (s4Qty[i] != null)
					model.setS4Qty(s4Qty[i]);
				if (r2Qty[i] != null)
					model.setR2Qty(r2Qty[i]);
				if (onhLocCd[i] != null)
					model.setOnhLocCd(onhLocCd[i]);
				if (eqLstmCd[i] != null)
					model.setEqLstmCd(eqLstmCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (o2Qty[i] != null)
					model.setO2Qty(o2Qty[i]);
				if (d4Qty[i] != null)
					model.setD4Qty(d4Qty[i]);
				if (r9Qty[i] != null)
					model.setR9Qty(r9Qty[i]);
				if (r5Qty[i] != null)
					model.setR5Qty(r5Qty[i]);
				if (d5Qty[i] != null)
					model.setD5Qty(d5Qty[i]);
				if (mftYr[i] != null)
					model.setMftYr(mftYr[i]);
				if (f4Qty[i] != null)
					model.setF4Qty(f4Qty[i]);
				if (onhOrdYr[i] != null)
					model.setOnhOrdYr(onhOrdYr[i]);
				if (onhPkupYrwk[i] != null)
					model.setOnhPkupYrwk(onhPkupYrwk[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPlanAndApprovalVOs();
	}

	/**
	 * @return PlanAndApprovalVO[]
	 */
	public PlanAndApprovalVO[] getPlanAndApprovalVOs(){
		PlanAndApprovalVO[] vos = (PlanAndApprovalVO[])models.toArray(new PlanAndApprovalVO[models.size()]);
		return vos;
	}
	
	/**
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	*/
	public void unDataFormat(){
		this.f2Qty = this.f2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhAuthNo = this.cntrOnhAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2Qty = this.s2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5Qty = this.f5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Qty = this.d2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhPlnYrwk = this.onhPlnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePlnSeq = this.lsePlnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Qty = this.o4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5Qty = this.o5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Qty = this.a4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Qty = this.a2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsNm = this.stsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRqstNo = this.lseRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Qty = this.d7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4Qty = this.s4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Qty = this.r2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhLocCd = this.onhLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLstmCd = this.eqLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Qty = this.o2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Qty = this.d4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9Qty = this.r9Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5Qty = this.r5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Qty = this.d5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftYr = this.mftYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4Qty = this.f4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.onhOrdYr 	 = this.onhOrdYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhPkupYrwk = this.onhPkupYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
