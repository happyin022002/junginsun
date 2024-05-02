/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ApplyHeaderVO.java
*@FileTitle : ApplyHeaderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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

public class ApplyHeaderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApplyHeaderVO> models = new ArrayList<ApplyHeaderVO>();
	
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String xchRtTpCd = null;
	/* Column Info */
	private String arTaxIndCd = null;
	/* Column Info */
	private String bilToCustCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String arFincSrcCd = null;
	/* Column Info */
	private String tjSrcNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctAplyAmt = null;
	/* Column Info */
	private String rctSeq = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String rvsFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String loclVvdCd = null;
	/* Column Info */
	private String trnkVvdCd = null;
	/* Column Info */
	private String bilToCustSeq = null;
	/* Column Info */
	private String rctAplyHdrSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String crFlg = null;
	/* Column Info */
	private String bilToCustCd = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String obrdDt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String otsRmk = null;
	/* Column Info */
	private String xchRtTpNm = null;
	/* Column Info */
	private String maxArIfNo = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String rctAplyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ApplyHeaderVO() {}

	public ApplyHeaderVO(String ibflag, String pagerows, String rctAplyHdrSeq, String rctSeq, String blNo, String bkgNo, String invNo, String otsOfcCd, String bilToCustCntCd, String bilToCustSeq, String loclVvdCd, String trnkVvdCd, String sailDt, String sailArrDt, String obrdDt, String ioBndCd, String dueDt, String srepCd, String otsRmk, String xchRtTpCd, String xchRtDt, String crFlg, String arTaxIndCd, String tjSrcNm, String arFincSrcCd, String rvsFlg, String rctAplyAmt, String rctAplyFlg, String maxArIfNo, String creUsrId, String creDt, String updUsrId, String updDt, String invDt, String bilToCustCd, String xchRtTpNm, String rhqCd, String ofcCd) {
		this.xchRtDt = xchRtDt;
		this.xchRtTpCd = xchRtTpCd;
		this.arTaxIndCd = arTaxIndCd;
		this.bilToCustCntCd = bilToCustCntCd;
		this.creDt = creDt;
		this.arFincSrcCd = arFincSrcCd;
		this.tjSrcNm = tjSrcNm;
		this.blNo = blNo;
		this.sailArrDt = sailArrDt;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rctAplyAmt = rctAplyAmt;
		this.rctSeq = rctSeq;
		this.dueDt = dueDt;
		this.rvsFlg = rvsFlg;
		this.updUsrId = updUsrId;
		this.invDt = invDt;
		this.updDt = updDt;
		this.rhqCd = rhqCd;
		this.loclVvdCd = loclVvdCd;
		this.trnkVvdCd = trnkVvdCd;
		this.bilToCustSeq = bilToCustSeq;
		this.rctAplyHdrSeq = rctAplyHdrSeq;
		this.ioBndCd = ioBndCd;
		this.crFlg = crFlg;
		this.bilToCustCd = bilToCustCd;
		this.sailDt = sailDt;
		this.obrdDt = obrdDt;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.otsRmk = otsRmk;
		this.xchRtTpNm = xchRtTpNm;
		this.maxArIfNo = maxArIfNo;
		this.otsOfcCd = otsOfcCd;
		this.rctAplyFlg = rctAplyFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());
		this.hashColumns.put("ar_tax_ind_cd", getArTaxIndCd());
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ar_finc_src_cd", getArFincSrcCd());
		this.hashColumns.put("tj_src_nm", getTjSrcNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_aply_amt", getRctAplyAmt());
		this.hashColumns.put("rct_seq", getRctSeq());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("rvs_flg", getRvsFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("locl_vvd_cd", getLoclVvdCd());
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());
		this.hashColumns.put("rct_aply_hdr_seq", getRctAplyHdrSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cr_flg", getCrFlg());
		this.hashColumns.put("bil_to_cust_cd", getBilToCustCd());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("obrd_dt", getObrdDt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ots_rmk", getOtsRmk());
		this.hashColumns.put("xch_rt_tp_nm", getXchRtTpNm());
		this.hashColumns.put("max_ar_if_no", getMaxArIfNo());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("rct_aply_flg", getRctAplyFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("ar_tax_ind_cd", "arTaxIndCd");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ar_finc_src_cd", "arFincSrcCd");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_aply_amt", "rctAplyAmt");
		this.hashFields.put("rct_seq", "rctSeq");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("rvs_flg", "rvsFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("locl_vvd_cd", "loclVvdCd");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("rct_aply_hdr_seq", "rctAplyHdrSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("bil_to_cust_cd", "bilToCustCd");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("obrd_dt", "obrdDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("xch_rt_tp_nm", "xchRtTpNm");
		this.hashFields.put("max_ar_if_no", "maxArIfNo");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rct_aply_flg", "rctAplyFlg");
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
	 * @return arTaxIndCd
	 */
	public String getArTaxIndCd() {
		return this.arTaxIndCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return arFincSrcCd
	 */
	public String getArFincSrcCd() {
		return this.arFincSrcCd;
	}
	
	/**
	 * Column Info
	 * @return tjSrcNm
	 */
	public String getTjSrcNm() {
		return this.tjSrcNm;
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
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return rctAplyAmt
	 */
	public String getRctAplyAmt() {
		return this.rctAplyAmt;
	}
	
	/**
	 * Column Info
	 * @return rctSeq
	 */
	public String getRctSeq() {
		return this.rctSeq;
	}
	
	/**
	 * Column Info
	 * @return dueDt
	 */
	public String getDueDt() {
		return this.dueDt;
	}
	
	/**
	 * Column Info
	 * @return rvsFlg
	 */
	public String getRvsFlg() {
		return this.rvsFlg;
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
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return loclVvdCd
	 */
	public String getLoclVvdCd() {
		return this.loclVvdCd;
	}
	
	/**
	 * Column Info
	 * @return trnkVvdCd
	 */
	public String getTrnkVvdCd() {
		return this.trnkVvdCd;
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
	 * @return rctAplyHdrSeq
	 */
	public String getRctAplyHdrSeq() {
		return this.rctAplyHdrSeq;
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
	 * @return crFlg
	 */
	public String getCrFlg() {
		return this.crFlg;
	}
	
	/**
	 * Column Info
	 * @return bilToCustCd
	 */
	public String getBilToCustCd() {
		return this.bilToCustCd;
	}
	
	/**
	 * Column Info
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
	}
	
	/**
	 * Column Info
	 * @return obrdDt
	 */
	public String getObrdDt() {
		return this.obrdDt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return otsRmk
	 */
	public String getOtsRmk() {
		return this.otsRmk;
	}
	
	/**
	 * Column Info
	 * @return xchRtTpNm
	 */
	public String getXchRtTpNm() {
		return this.xchRtTpNm;
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
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rctAplyFlg
	 */
	public String getRctAplyFlg() {
		return this.rctAplyFlg;
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
	 * @param arTaxIndCd
	 */
	public void setArTaxIndCd(String arTaxIndCd) {
		this.arTaxIndCd = arTaxIndCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param arFincSrcCd
	 */
	public void setArFincSrcCd(String arFincSrcCd) {
		this.arFincSrcCd = arFincSrcCd;
	}
	
	/**
	 * Column Info
	 * @param tjSrcNm
	 */
	public void setTjSrcNm(String tjSrcNm) {
		this.tjSrcNm = tjSrcNm;
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
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param rctAplyAmt
	 */
	public void setRctAplyAmt(String rctAplyAmt) {
		this.rctAplyAmt = rctAplyAmt;
	}
	
	/**
	 * Column Info
	 * @param rctSeq
	 */
	public void setRctSeq(String rctSeq) {
		this.rctSeq = rctSeq;
	}
	
	/**
	 * Column Info
	 * @param dueDt
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}
	
	/**
	 * Column Info
	 * @param rvsFlg
	 */
	public void setRvsFlg(String rvsFlg) {
		this.rvsFlg = rvsFlg;
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
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param loclVvdCd
	 */
	public void setLoclVvdCd(String loclVvdCd) {
		this.loclVvdCd = loclVvdCd;
	}
	
	/**
	 * Column Info
	 * @param trnkVvdCd
	 */
	public void setTrnkVvdCd(String trnkVvdCd) {
		this.trnkVvdCd = trnkVvdCd;
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
	 * @param rctAplyHdrSeq
	 */
	public void setRctAplyHdrSeq(String rctAplyHdrSeq) {
		this.rctAplyHdrSeq = rctAplyHdrSeq;
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
	 * @param crFlg
	 */
	public void setCrFlg(String crFlg) {
		this.crFlg = crFlg;
	}
	
	/**
	 * Column Info
	 * @param bilToCustCd
	 */
	public void setBilToCustCd(String bilToCustCd) {
		this.bilToCustCd = bilToCustCd;
	}
	
	/**
	 * Column Info
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}
	
	/**
	 * Column Info
	 * @param obrdDt
	 */
	public void setObrdDt(String obrdDt) {
		this.obrdDt = obrdDt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param otsRmk
	 */
	public void setOtsRmk(String otsRmk) {
		this.otsRmk = otsRmk;
	}
	
	/**
	 * Column Info
	 * @param xchRtTpNm
	 */
	public void setXchRtTpNm(String xchRtTpNm) {
		this.xchRtTpNm = xchRtTpNm;
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
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rctAplyFlg
	 */
	public void setRctAplyFlg(String rctAplyFlg) {
		this.rctAplyFlg = rctAplyFlg;
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
		setArTaxIndCd(JSPUtil.getParameter(request, prefix + "ar_tax_ind_cd", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request, prefix + "bil_to_cust_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setArFincSrcCd(JSPUtil.getParameter(request, prefix + "ar_finc_src_cd", ""));
		setTjSrcNm(JSPUtil.getParameter(request, prefix + "tj_src_nm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctAplyAmt(JSPUtil.getParameter(request, prefix + "rct_aply_amt", ""));
		setRctSeq(JSPUtil.getParameter(request, prefix + "rct_seq", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setRvsFlg(JSPUtil.getParameter(request, prefix + "rvs_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setLoclVvdCd(JSPUtil.getParameter(request, prefix + "locl_vvd_cd", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request, prefix + "trnk_vvd_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request, prefix + "bil_to_cust_seq", ""));
		setRctAplyHdrSeq(JSPUtil.getParameter(request, prefix + "rct_aply_hdr_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCrFlg(JSPUtil.getParameter(request, prefix + "cr_flg", ""));
		setBilToCustCd(JSPUtil.getParameter(request, prefix + "bil_to_cust_cd", ""));
		setSailDt(JSPUtil.getParameter(request, prefix + "sail_dt", ""));
		setObrdDt(JSPUtil.getParameter(request, prefix + "obrd_dt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOtsRmk(JSPUtil.getParameter(request, prefix + "ots_rmk", ""));
		setXchRtTpNm(JSPUtil.getParameter(request, prefix + "xch_rt_tp_nm", ""));
		setMaxArIfNo(JSPUtil.getParameter(request, prefix + "max_ar_if_no", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setRctAplyFlg(JSPUtil.getParameter(request, prefix + "rct_aply_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApplyHeaderVO[]
	 */
	public ApplyHeaderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApplyHeaderVO[]
	 */
	public ApplyHeaderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApplyHeaderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] xchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_tp_cd", length));
			String[] arTaxIndCd = (JSPUtil.getParameter(request, prefix	+ "ar_tax_ind_cd", length));
			String[] bilToCustCntCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] arFincSrcCd = (JSPUtil.getParameter(request, prefix	+ "ar_finc_src_cd", length));
			String[] tjSrcNm = (JSPUtil.getParameter(request, prefix	+ "tj_src_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctAplyAmt = (JSPUtil.getParameter(request, prefix	+ "rct_aply_amt", length));
			String[] rctSeq = (JSPUtil.getParameter(request, prefix	+ "rct_seq", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] rvsFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] loclVvdCd = (JSPUtil.getParameter(request, prefix	+ "locl_vvd_cd", length));
			String[] trnkVvdCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd_cd", length));
			String[] bilToCustSeq = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_seq", length));
			String[] rctAplyHdrSeq = (JSPUtil.getParameter(request, prefix	+ "rct_aply_hdr_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] crFlg = (JSPUtil.getParameter(request, prefix	+ "cr_flg", length));
			String[] bilToCustCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_cust_cd", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] obrdDt = (JSPUtil.getParameter(request, prefix	+ "obrd_dt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] otsRmk = (JSPUtil.getParameter(request, prefix	+ "ots_rmk", length));
			String[] xchRtTpNm = (JSPUtil.getParameter(request, prefix	+ "xch_rt_tp_nm", length));
			String[] maxArIfNo = (JSPUtil.getParameter(request, prefix	+ "max_ar_if_no", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] rctAplyFlg = (JSPUtil.getParameter(request, prefix	+ "rct_aply_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApplyHeaderVO();
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (xchRtTpCd[i] != null)
					model.setXchRtTpCd(xchRtTpCd[i]);
				if (arTaxIndCd[i] != null)
					model.setArTaxIndCd(arTaxIndCd[i]);
				if (bilToCustCntCd[i] != null)
					model.setBilToCustCntCd(bilToCustCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (arFincSrcCd[i] != null)
					model.setArFincSrcCd(arFincSrcCd[i]);
				if (tjSrcNm[i] != null)
					model.setTjSrcNm(tjSrcNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctAplyAmt[i] != null)
					model.setRctAplyAmt(rctAplyAmt[i]);
				if (rctSeq[i] != null)
					model.setRctSeq(rctSeq[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (rvsFlg[i] != null)
					model.setRvsFlg(rvsFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (loclVvdCd[i] != null)
					model.setLoclVvdCd(loclVvdCd[i]);
				if (trnkVvdCd[i] != null)
					model.setTrnkVvdCd(trnkVvdCd[i]);
				if (bilToCustSeq[i] != null)
					model.setBilToCustSeq(bilToCustSeq[i]);
				if (rctAplyHdrSeq[i] != null)
					model.setRctAplyHdrSeq(rctAplyHdrSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (crFlg[i] != null)
					model.setCrFlg(crFlg[i]);
				if (bilToCustCd[i] != null)
					model.setBilToCustCd(bilToCustCd[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (obrdDt[i] != null)
					model.setObrdDt(obrdDt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (otsRmk[i] != null)
					model.setOtsRmk(otsRmk[i]);
				if (xchRtTpNm[i] != null)
					model.setXchRtTpNm(xchRtTpNm[i]);
				if (maxArIfNo[i] != null)
					model.setMaxArIfNo(maxArIfNo[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (rctAplyFlg[i] != null)
					model.setRctAplyFlg(rctAplyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApplyHeaderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApplyHeaderVO[]
	 */
	public ApplyHeaderVO[] getApplyHeaderVOs(){
		ApplyHeaderVO[] vos = (ApplyHeaderVO[])models.toArray(new ApplyHeaderVO[models.size()]);
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
		this.arTaxIndCd = this.arTaxIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd = this.bilToCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arFincSrcCd = this.arFincSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm = this.tjSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyAmt = this.rctAplyAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctSeq = this.rctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg = this.rvsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVvdCd = this.loclVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd = this.trnkVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq = this.bilToCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyHdrSeq = this.rctAplyHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg = this.crFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCd = this.bilToCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt = this.obrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk = this.otsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpNm = this.xchRtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxArIfNo = this.maxArIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyFlg = this.rctAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
