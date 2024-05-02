/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OffsetARPopupListVO.java
*@FileTitle : OffsetARPopupListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.24  
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

public class OffsetARPopupListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OffsetARPopupListVO> models = new ArrayList<OffsetARPopupListVO>();
	
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String xchRtTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String chgTpCd = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String balUsdAmt = null;
	/* Column Info */
	private String bilToCustNum = null;
	/* Column Info */
	private String balLoclAmt = null;
	/* Column Info */
	private String bilToCustCntCd = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String otsTpCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String offstTpCd = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String bkgIoBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String balAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String loclXchRt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String blCurrCd = null;
	/* Column Info */
	private String arXchRt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bilToCustSeq = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String arXchAmt = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String maxArIfNo = null;
	/* Column Info */
	private String offstCurrCd = null;
	/* Column Info */
	private String blInvNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OffsetARPopupListVO() {}

	public OffsetARPopupListVO(String ibflag, String pagerows, String xchRtDt, String vslCd, String xchRtTpCd, String glDt, String chgTpCd, String balUsdAmt, String balLoclAmt, String bilToCustNum, String stlFlg, String bilToCustCntCd, String otsTpCd, String svcScpCd, String offstTpCd, String usdXchRt, String bkgIoBndCd, String blNo, String balAmt, String polCd, String vvdCd, String invAmt, String dirCd, String invOfcCd, String loclXchRt, String rhqCd, String arXchRt, String blCurrCd, String adjAmt, String bilToCustSeq, String skdVoyNo, String custLglEngNm, String arXchAmt, String podCd, String invNo, String maxArIfNo, String otsOfcCd, String offstCurrCd, String blInvNo, String dpPrcsKnt) {
		this.xchRtDt = xchRtDt;
		this.xchRtTpCd = xchRtTpCd;
		this.vslCd = vslCd;
		this.chgTpCd = chgTpCd;
		this.glDt = glDt;
		this.balUsdAmt = balUsdAmt;
		this.bilToCustNum = bilToCustNum;
		this.balLoclAmt = balLoclAmt;
		this.bilToCustCntCd = bilToCustCntCd;
		this.stlFlg = stlFlg;
		this.otsTpCd = otsTpCd;
		this.svcScpCd = svcScpCd;
		this.offstTpCd = offstTpCd;
		this.usdXchRt = usdXchRt;
		this.bkgIoBndCd = bkgIoBndCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.balAmt = balAmt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.invAmt = invAmt;
		this.dirCd = dirCd;
		this.invOfcCd = invOfcCd;
		this.loclXchRt = loclXchRt;
		this.rhqCd = rhqCd;
		this.blCurrCd = blCurrCd;
		this.arXchRt = arXchRt;
		this.skdVoyNo = skdVoyNo;
		this.bilToCustSeq = bilToCustSeq;
		this.adjAmt = adjAmt;
		this.custLglEngNm = custLglEngNm;
		this.invNo = invNo;
		this.podCd = podCd;
		this.arXchAmt = arXchAmt;
		this.otsOfcCd = otsOfcCd;
		this.maxArIfNo = maxArIfNo;
		this.offstCurrCd = offstCurrCd;
		this.blInvNo = blInvNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("chg_tp_cd", getChgTpCd());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("bal_usd_amt", getBalUsdAmt());
		this.hashColumns.put("bil_to_cust_num", getBilToCustNum());
		this.hashColumns.put("bal_locl_amt", getBalLoclAmt());
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("ots_tp_cd", getOtsTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("offst_tp_cd", getOffstTpCd());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("bkg_io_bnd_cd", getBkgIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("bal_amt", getBalAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());
		this.hashColumns.put("ar_xch_rt", getArXchRt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ar_xch_amt", getArXchAmt());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("max_ar_if_no", getMaxArIfNo());
		this.hashColumns.put("offst_curr_cd", getOffstCurrCd());
		this.hashColumns.put("bl_inv_no", getBlInvNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("bal_usd_amt", "balUsdAmt");
		this.hashFields.put("bil_to_cust_num", "bilToCustNum");
		this.hashFields.put("bal_locl_amt", "balLoclAmt");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("ots_tp_cd", "otsTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("offst_tp_cd", "offstTpCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("bkg_io_bnd_cd", "bkgIoBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("ar_xch_rt", "arXchRt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ar_xch_amt", "arXchAmt");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("max_ar_if_no", "maxArIfNo");
		this.hashFields.put("offst_curr_cd", "offstCurrCd");
		this.hashFields.put("bl_inv_no", "blInvNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xchRtDt
	 */
	public String getXchRtDt() {
		return this.xchRtDt;
	}
	
	/**
	 * Column Info
	 * @return xchRtTpCd
	 */
	public String getXchRtTpCd() {
		return this.xchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return bilToCustNum
	 */
	public String getBilToCustNum() {
		return this.bilToCustNum;
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
	 * @return bilToCustCntCd
	 */
	public String getBilToCustCntCd() {
		return this.bilToCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
	}
	
	/**
	 * Column Info
	 * @return otsTpCd
	 */
	public String getOtsTpCd() {
		return this.otsTpCd;
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
	 * @return offstTpCd
	 */
	public String getOffstTpCd() {
		return this.offstTpCd;
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
	 * @return bkgIoBndCd
	 */
	public String getBkgIoBndCd() {
		return this.bkgIoBndCd;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return balAmt
	 */
	public String getBalAmt() {
		return this.balAmt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return arXchRt
	 */
	public String getArXchRt() {
		return this.arXchRt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bilToCustSeq
	 */
	public String getBilToCustSeq() {
		return this.bilToCustSeq;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return arXchAmt
	 */
	public String getArXchAmt() {
		return this.arXchAmt;
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
	 * @return maxArIfNo
	 */
	public String getMaxArIfNo() {
		return this.maxArIfNo;
	}
	
	/**
	 * Column Info
	 * @return offstCurrCd
	 */
	public String getOffstCurrCd() {
		return this.offstCurrCd;
	}
	
	/**
	 * Column Info
	 * @return blInvNo
	 */
	public String getBlInvNo() {
		return this.blInvNo;
	}
	

	/**
	 * Column Info
	 * @param xchRtDt
	 */
	public void setXchRtDt(String xchRtDt) {
		this.xchRtDt = xchRtDt;
	}
	
	/**
	 * Column Info
	 * @param xchRtTpCd
	 */
	public void setXchRtTpCd(String xchRtTpCd) {
		this.xchRtTpCd = xchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param bilToCustNum
	 */
	public void setBilToCustNum(String bilToCustNum) {
		this.bilToCustNum = bilToCustNum;
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
	 * @param bilToCustCntCd
	 */
	public void setBilToCustCntCd(String bilToCustCntCd) {
		this.bilToCustCntCd = bilToCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
	}
	
	/**
	 * Column Info
	 * @param otsTpCd
	 */
	public void setOtsTpCd(String otsTpCd) {
		this.otsTpCd = otsTpCd;
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
	 * @param offstTpCd
	 */
	public void setOffstTpCd(String offstTpCd) {
		this.offstTpCd = offstTpCd;
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
	 * @param bkgIoBndCd
	 */
	public void setBkgIoBndCd(String bkgIoBndCd) {
		this.bkgIoBndCd = bkgIoBndCd;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param balAmt
	 */
	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param arXchRt
	 */
	public void setArXchRt(String arXchRt) {
		this.arXchRt = arXchRt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bilToCustSeq
	 */
	public void setBilToCustSeq(String bilToCustSeq) {
		this.bilToCustSeq = bilToCustSeq;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param arXchAmt
	 */
	public void setArXchAmt(String arXchAmt) {
		this.arXchAmt = arXchAmt;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param maxArIfNo
	 */
	public void setMaxArIfNo(String maxArIfNo) {
		this.maxArIfNo = maxArIfNo;
	}
	
	/**
	 * Column Info
	 * @param offstCurrCd
	 */
	public void setOffstCurrCd(String offstCurrCd) {
		this.offstCurrCd = offstCurrCd;
	}
	
	/**
	 * Column Info
	 * @param blInvNo
	 */
	public void setBlInvNo(String blInvNo) {
		this.blInvNo = blInvNo;
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
		setXchRtDt(JSPUtil.getParameter(request, prefix + "xch_rt_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setChgTpCd(JSPUtil.getParameter(request, prefix + "chg_tp_cd", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setBalUsdAmt(JSPUtil.getParameter(request, prefix + "bal_usd_amt", ""));
		setBilToCustNum(JSPUtil.getParameter(request, prefix + "bil_to_cust_num", ""));
		setBalLoclAmt(JSPUtil.getParameter(request, prefix + "bal_locl_amt", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request, prefix + "bil_to_cust_cnt_cd", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setOtsTpCd(JSPUtil.getParameter(request, prefix + "ots_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setOffstTpCd(JSPUtil.getParameter(request, prefix + "offst_tp_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request, prefix + "usd_xch_rt", ""));
		setBkgIoBndCd(JSPUtil.getParameter(request, prefix + "bkg_io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setBalAmt(JSPUtil.getParameter(request, prefix + "bal_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setLoclXchRt(JSPUtil.getParameter(request, prefix + "locl_xch_rt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request, prefix + "bl_curr_cd", ""));
		setArXchRt(JSPUtil.getParameter(request, prefix + "ar_xch_rt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBilToCustSeq(JSPUtil.getParameter(request, prefix + "bil_to_cust_seq", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setArXchAmt(JSPUtil.getParameter(request, prefix + "ar_xch_amt", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setMaxArIfNo(JSPUtil.getParameter(request, prefix + "max_ar_if_no", ""));
		setOffstCurrCd(JSPUtil.getParameter(request, prefix + "offst_curr_cd", ""));
		setBlInvNo(JSPUtil.getParameter(request, prefix + "bl_inv_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OffsetARPopupListVO[]
	 */
	public OffsetARPopupListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OffsetARPopupListVO[]
	 */
	public OffsetARPopupListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OffsetARPopupListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] xchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] chgTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_tp_cd", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] balUsdAmt = (JSPUtil.getParameter(request, prefix	+ "bal_usd_amt", length));
			String[] bilToCustNum = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_num", length));
			String[] balLoclAmt = (JSPUtil.getParameter(request, prefix	+ "bal_locl_amt", length));
			String[] bilToCustCntCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_cnt_cd", length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg", length));
			String[] otsTpCd = (JSPUtil.getParameter(request, prefix	+ "ots_tp_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] offstTpCd = (JSPUtil.getParameter(request, prefix	+ "offst_tp_cd", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] bkgIoBndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] balAmt = (JSPUtil.getParameter(request, prefix	+ "bal_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] loclXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_xch_rt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] blCurrCd = (JSPUtil.getParameter(request, prefix	+ "bl_curr_cd", length));
			String[] arXchRt = (JSPUtil.getParameter(request, prefix	+ "ar_xch_rt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bilToCustSeq = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_seq", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] arXchAmt = (JSPUtil.getParameter(request, prefix	+ "ar_xch_amt", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] maxArIfNo = (JSPUtil.getParameter(request, prefix	+ "max_ar_if_no", length));
			String[] offstCurrCd = (JSPUtil.getParameter(request, prefix	+ "offst_curr_cd", length));
			String[] blInvNo = (JSPUtil.getParameter(request, prefix	+ "bl_inv_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new OffsetARPopupListVO();
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (xchRtTpCd[i] != null)
					model.setXchRtTpCd(xchRtTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (chgTpCd[i] != null)
					model.setChgTpCd(chgTpCd[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (balUsdAmt[i] != null)
					model.setBalUsdAmt(balUsdAmt[i]);
				if (bilToCustNum[i] != null)
					model.setBilToCustNum(bilToCustNum[i]);
				if (balLoclAmt[i] != null)
					model.setBalLoclAmt(balLoclAmt[i]);
				if (bilToCustCntCd[i] != null)
					model.setBilToCustCntCd(bilToCustCntCd[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (otsTpCd[i] != null)
					model.setOtsTpCd(otsTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (offstTpCd[i] != null)
					model.setOffstTpCd(offstTpCd[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (bkgIoBndCd[i] != null)
					model.setBkgIoBndCd(bkgIoBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (balAmt[i] != null)
					model.setBalAmt(balAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (loclXchRt[i] != null)
					model.setLoclXchRt(loclXchRt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (blCurrCd[i] != null)
					model.setBlCurrCd(blCurrCd[i]);
				if (arXchRt[i] != null)
					model.setArXchRt(arXchRt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bilToCustSeq[i] != null)
					model.setBilToCustSeq(bilToCustSeq[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (arXchAmt[i] != null)
					model.setArXchAmt(arXchAmt[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (maxArIfNo[i] != null)
					model.setMaxArIfNo(maxArIfNo[i]);
				if (offstCurrCd[i] != null)
					model.setOffstCurrCd(offstCurrCd[i]);
				if (blInvNo[i] != null)
					model.setBlInvNo(blInvNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOffsetARPopupListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OffsetARPopupListVO[]
	 */
	public OffsetARPopupListVO[] getOffsetARPopupListVOs(){
		OffsetARPopupListVO[] vos = (OffsetARPopupListVO[])models.toArray(new OffsetARPopupListVO[models.size()]);
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
		this.xchRtDt = this.xchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd = this.xchRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd = this.chgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balUsdAmt = this.balUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustNum = this.bilToCustNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balLoclAmt = this.balLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd = this.bilToCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsTpCd = this.otsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offstTpCd = this.offstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoBndCd = this.bkgIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt = this.balAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt = this.loclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd = this.blCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arXchRt = this.arXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq = this.bilToCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arXchAmt = this.arXchAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxArIfNo = this.maxArIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offstCurrCd = this.offstCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvNo = this.blInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
