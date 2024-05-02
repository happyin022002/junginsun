/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PaymentVO.java
*@FileTitle : PaymentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.03.11 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PaymentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentVO> models = new ArrayList<PaymentVO>();
	
	/* Column Info */
	private String netPaidAmount = null;
	/* Column Info */
	private String cgoClmStlXchRt = null;
	/* Column Info */
	private String clmtLoclXchRt = null;
	/* Column Info */
	private String insurRcvrUsdAmt = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String recoveredAmount = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String defenseRatioOnSettlement = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String payRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclAmt = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String cgoClmStlLoclAmt = null;
	/* Column Info */
	private String clmtLoclCurrCd = null;
	/* Column Info */
	private String insurRcvrAmt = null;
	/* Column Info */
	private String insurRcvrLoclCurrCd = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String clmMiscNm = null;
	/* Column Info */
	private String insurRcvrXchRt = null;
	/* Column Info */
	private String cgoClmStlLoclCurrCd = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String lablPtyRcvrLoclCurrCd = null;
	/* Column Info */
	private String onNetPayment = null;
	/* Column Info */
	private String insurRcvrDt = null;
	/* Column Info */
	private String cgoClmClzCd = null;
	/* Column Info */
	private String lablPtyRcvrLoclXchRt = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmAreaCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PaymentVO() {}

	public PaymentVO(String ibflag, String pagerows, String cgoClmNo, String clmAreaCd, String clmMiscNm, String cgoClmStlTpCd, String csClzDt, String ptyNm, String clmtLoclAmt, String clmtLoclCurrCd, String clmtLoclXchRt, String clmtUsdAmt, String cgoClmStlLoclAmt, String cgoClmStlLoclCurrCd, String cgoClmStlXchRt, String cgoClmStlUsdAmt, String recoveredAmount, String lablPtyRcvrLoclAmt, String lablPtyRcvrLoclCurrCd, String lablPtyRcvrLoclXchRt, String lablPtyRcvrUsdAmt, String insurRcvrAmt, String insurRcvrLoclCurrCd, String insurRcvrXchRt, String insurRcvrUsdAmt, String fmalClmRcvDt, String cgoClmStlDt, String lablPtyRcvrDt, String insurRcvrDt, String netPaidAmount, String defenseRatioOnSettlement, String onNetPayment, String invUsdAmt, String payRmk, String cgoClmStsCd, String cgoClmClzCd, String updUsrId, String hdlrUsrId, String hdlrOfcCd) {
		this.netPaidAmount = netPaidAmount;
		this.cgoClmStlXchRt = cgoClmStlXchRt;
		this.clmtLoclXchRt = clmtLoclXchRt;
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
		this.clmtLoclAmt = clmtLoclAmt;
		this.csClzDt = csClzDt;
		this.recoveredAmount = recoveredAmount;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.ptyNm = ptyNm;
		this.defenseRatioOnSettlement = defenseRatioOnSettlement;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cgoClmStsCd = cgoClmStsCd;
		this.cgoClmNo = cgoClmNo;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.payRmk = payRmk;
		this.updUsrId = updUsrId;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
		this.invUsdAmt = invUsdAmt;
		this.cgoClmStlDt = cgoClmStlDt;
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
		this.clmtLoclCurrCd = clmtLoclCurrCd;
		this.insurRcvrAmt = insurRcvrAmt;
		this.insurRcvrLoclCurrCd = insurRcvrLoclCurrCd;
		this.hdlrUsrId = hdlrUsrId;
		this.clmMiscNm = clmMiscNm;
		this.insurRcvrXchRt = insurRcvrXchRt;
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
		this.onNetPayment = onNetPayment;
		this.insurRcvrDt = insurRcvrDt;
		this.cgoClmClzCd = cgoClmClzCd;
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("net_paid_amount", getNetPaidAmount());
		this.hashColumns.put("cgo_clm_stl_xch_rt", getCgoClmStlXchRt());
		this.hashColumns.put("clmt_locl_xch_rt", getClmtLoclXchRt());
		this.hashColumns.put("insur_rcvr_usd_amt", getInsurRcvrUsdAmt());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("recovered_amount", getRecoveredAmount());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("defense_ratio_on_settlement", getDefenseRatioOnSettlement());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("pay_rmk", getPayRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("labl_pty_rcvr_locl_amt", getLablPtyRcvrLoclAmt());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("cgo_clm_stl_locl_amt", getCgoClmStlLoclAmt());
		this.hashColumns.put("clmt_locl_curr_cd", getClmtLoclCurrCd());
		this.hashColumns.put("insur_rcvr_amt", getInsurRcvrAmt());
		this.hashColumns.put("insur_rcvr_locl_curr_cd", getInsurRcvrLoclCurrCd());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("clm_misc_nm", getClmMiscNm());
		this.hashColumns.put("insur_rcvr_xch_rt", getInsurRcvrXchRt());
		this.hashColumns.put("cgo_clm_stl_locl_curr_cd", getCgoClmStlLoclCurrCd());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("labl_pty_rcvr_locl_curr_cd", getLablPtyRcvrLoclCurrCd());
		this.hashColumns.put("on_net_payment", getOnNetPayment());
		this.hashColumns.put("insur_rcvr_dt", getInsurRcvrDt());
		this.hashColumns.put("cgo_clm_clz_cd", getCgoClmClzCd());
		this.hashColumns.put("labl_pty_rcvr_locl_xch_rt", getLablPtyRcvrLoclXchRt());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("net_paid_amount", "netPaidAmount");
		this.hashFields.put("cgo_clm_stl_xch_rt", "cgoClmStlXchRt");
		this.hashFields.put("clmt_locl_xch_rt", "clmtLoclXchRt");
		this.hashFields.put("insur_rcvr_usd_amt", "insurRcvrUsdAmt");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("recovered_amount", "recoveredAmount");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("defense_ratio_on_settlement", "defenseRatioOnSettlement");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("pay_rmk", "payRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("labl_pty_rcvr_locl_amt", "lablPtyRcvrLoclAmt");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("cgo_clm_stl_locl_amt", "cgoClmStlLoclAmt");
		this.hashFields.put("clmt_locl_curr_cd", "clmtLoclCurrCd");
		this.hashFields.put("insur_rcvr_amt", "insurRcvrAmt");
		this.hashFields.put("insur_rcvr_locl_curr_cd", "insurRcvrLoclCurrCd");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("clm_misc_nm", "clmMiscNm");
		this.hashFields.put("insur_rcvr_xch_rt", "insurRcvrXchRt");
		this.hashFields.put("cgo_clm_stl_locl_curr_cd", "cgoClmStlLoclCurrCd");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("labl_pty_rcvr_locl_curr_cd", "lablPtyRcvrLoclCurrCd");
		this.hashFields.put("on_net_payment", "onNetPayment");
		this.hashFields.put("insur_rcvr_dt", "insurRcvrDt");
		this.hashFields.put("cgo_clm_clz_cd", "cgoClmClzCd");
		this.hashFields.put("labl_pty_rcvr_locl_xch_rt", "lablPtyRcvrLoclXchRt");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return netPaidAmount
	 */
	public String getNetPaidAmount() {
		return this.netPaidAmount;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlXchRt
	 */
	public String getCgoClmStlXchRt() {
		return this.cgoClmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @return clmtLoclXchRt
	 */
	public String getClmtLoclXchRt() {
		return this.clmtLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrUsdAmt
	 */
	public String getInsurRcvrUsdAmt() {
		return this.insurRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return clmtLoclAmt
	 */
	public String getClmtLoclAmt() {
		return this.clmtLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return csClzDt
	 */
	public String getCsClzDt() {
		return this.csClzDt;
	}
	
	/**
	 * Column Info
	 * @return recoveredAmount
	 */
	public String getRecoveredAmount() {
		return this.recoveredAmount;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrUsdAmt
	 */
	public String getLablPtyRcvrUsdAmt() {
		return this.lablPtyRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvDt
	 */
	public String getFmalClmRcvDt() {
		return this.fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
	}
	
	/**
	 * Column Info
	 * @return defenseRatioOnSettlement
	 */
	public String getDefenseRatioOnSettlement() {
		return this.defenseRatioOnSettlement;
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
	 * @return cgoClmStsCd
	 */
	public String getCgoClmStsCd() {
		return this.cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlUsdAmt
	 */
	public String getCgoClmStlUsdAmt() {
		return this.cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return payRmk
	 */
	public String getPayRmk() {
		return this.payRmk;
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
	 * @return lablPtyRcvrDt
	 */
	public String getLablPtyRcvrDt() {
		return this.lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclAmt
	 */
	public String getLablPtyRcvrLoclAmt() {
		return this.lablPtyRcvrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlLoclAmt
	 */
	public String getCgoClmStlLoclAmt() {
		return this.cgoClmStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return clmtLoclCurrCd
	 */
	public String getClmtLoclCurrCd() {
		return this.clmtLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrAmt
	 */
	public String getInsurRcvrAmt() {
		return this.insurRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrLoclCurrCd
	 */
	public String getInsurRcvrLoclCurrCd() {
		return this.insurRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @return clmMiscNm
	 */
	public String getClmMiscNm() {
		return this.clmMiscNm;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrXchRt
	 */
	public String getInsurRcvrXchRt() {
		return this.insurRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlLoclCurrCd
	 */
	public String getCgoClmStlLoclCurrCd() {
		return this.cgoClmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlTpCd
	 */
	public String getCgoClmStlTpCd() {
		return this.cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return clmtUsdAmt
	 */
	public String getClmtUsdAmt() {
		return this.clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclCurrCd
	 */
	public String getLablPtyRcvrLoclCurrCd() {
		return this.lablPtyRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return onNetPayment
	 */
	public String getOnNetPayment() {
		return this.onNetPayment;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrDt
	 */
	public String getInsurRcvrDt() {
		return this.insurRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmClzCd
	 */
	public String getCgoClmClzCd() {
		return this.cgoClmClzCd;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclXchRt
	 */
	public String getLablPtyRcvrLoclXchRt() {
		return this.lablPtyRcvrLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	

	/**
	 * Column Info
	 * @param netPaidAmount
	 */
	public void setNetPaidAmount(String netPaidAmount) {
		this.netPaidAmount = netPaidAmount;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlXchRt
	 */
	public void setCgoClmStlXchRt(String cgoClmStlXchRt) {
		this.cgoClmStlXchRt = cgoClmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @param clmtLoclXchRt
	 */
	public void setClmtLoclXchRt(String clmtLoclXchRt) {
		this.clmtLoclXchRt = clmtLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrUsdAmt
	 */
	public void setInsurRcvrUsdAmt(String insurRcvrUsdAmt) {
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param clmtLoclAmt
	 */
	public void setClmtLoclAmt(String clmtLoclAmt) {
		this.clmtLoclAmt = clmtLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param csClzDt
	 */
	public void setCsClzDt(String csClzDt) {
		this.csClzDt = csClzDt;
	}
	
	/**
	 * Column Info
	 * @param recoveredAmount
	 */
	public void setRecoveredAmount(String recoveredAmount) {
		this.recoveredAmount = recoveredAmount;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrUsdAmt
	 */
	public void setLablPtyRcvrUsdAmt(String lablPtyRcvrUsdAmt) {
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvDt
	 */
	public void setFmalClmRcvDt(String fmalClmRcvDt) {
		this.fmalClmRcvDt = fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
	}
	
	/**
	 * Column Info
	 * @param defenseRatioOnSettlement
	 */
	public void setDefenseRatioOnSettlement(String defenseRatioOnSettlement) {
		this.defenseRatioOnSettlement = defenseRatioOnSettlement;
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
	 * @param cgoClmStsCd
	 */
	public void setCgoClmStsCd(String cgoClmStsCd) {
		this.cgoClmStsCd = cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlUsdAmt
	 */
	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param payRmk
	 */
	public void setPayRmk(String payRmk) {
		this.payRmk = payRmk;
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
	 * @param lablPtyRcvrDt
	 */
	public void setLablPtyRcvrDt(String lablPtyRcvrDt) {
		this.lablPtyRcvrDt = lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclAmt
	 */
	public void setLablPtyRcvrLoclAmt(String lablPtyRcvrLoclAmt) {
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlLoclAmt
	 */
	public void setCgoClmStlLoclAmt(String cgoClmStlLoclAmt) {
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param clmtLoclCurrCd
	 */
	public void setClmtLoclCurrCd(String clmtLoclCurrCd) {
		this.clmtLoclCurrCd = clmtLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrAmt
	 */
	public void setInsurRcvrAmt(String insurRcvrAmt) {
		this.insurRcvrAmt = insurRcvrAmt;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrLoclCurrCd
	 */
	public void setInsurRcvrLoclCurrCd(String insurRcvrLoclCurrCd) {
		this.insurRcvrLoclCurrCd = insurRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param clmMiscNm
	 */
	public void setClmMiscNm(String clmMiscNm) {
		this.clmMiscNm = clmMiscNm;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrXchRt
	 */
	public void setInsurRcvrXchRt(String insurRcvrXchRt) {
		this.insurRcvrXchRt = insurRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlLoclCurrCd
	 */
	public void setCgoClmStlLoclCurrCd(String cgoClmStlLoclCurrCd) {
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlTpCd
	 */
	public void setCgoClmStlTpCd(String cgoClmStlTpCd) {
		this.cgoClmStlTpCd = cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param clmtUsdAmt
	 */
	public void setClmtUsdAmt(String clmtUsdAmt) {
		this.clmtUsdAmt = clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclCurrCd
	 */
	public void setLablPtyRcvrLoclCurrCd(String lablPtyRcvrLoclCurrCd) {
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param onNetPayment
	 */
	public void setOnNetPayment(String onNetPayment) {
		this.onNetPayment = onNetPayment;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrDt
	 */
	public void setInsurRcvrDt(String insurRcvrDt) {
		this.insurRcvrDt = insurRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmClzCd
	 */
	public void setCgoClmClzCd(String cgoClmClzCd) {
		this.cgoClmClzCd = cgoClmClzCd;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclXchRt
	 */
	public void setLablPtyRcvrLoclXchRt(String lablPtyRcvrLoclXchRt) {
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
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
		setNetPaidAmount(JSPUtil.getParameter(request, prefix + "net_paid_amount", ""));
		setCgoClmStlXchRt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_xch_rt", ""));
		setClmtLoclXchRt(JSPUtil.getParameter(request, prefix + "clmt_locl_xch_rt", ""));
		setInsurRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_usd_amt", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, prefix + "clmt_locl_amt", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setRecoveredAmount(JSPUtil.getParameter(request, prefix + "recovered_amount", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setPtyNm(JSPUtil.getParameter(request, prefix + "pty_nm", ""));
		setDefenseRatioOnSettlement(JSPUtil.getParameter(request, prefix + "defense_ratio_on_settlement", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_cd", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_usd_amt", ""));
		setPayRmk(JSPUtil.getParameter(request, prefix + "pay_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setLablPtyRcvrLoclAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_amt", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_dt", ""));
		setCgoClmStlLoclAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_amt", ""));
		setClmtLoclCurrCd(JSPUtil.getParameter(request, prefix + "clmt_locl_curr_cd", ""));
		setInsurRcvrAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_amt", ""));
		setInsurRcvrLoclCurrCd(JSPUtil.getParameter(request, prefix + "insur_rcvr_locl_curr_cd", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setClmMiscNm(JSPUtil.getParameter(request, prefix + "clm_misc_nm", ""));
		setInsurRcvrXchRt(JSPUtil.getParameter(request, prefix + "insur_rcvr_xch_rt", ""));
		setCgoClmStlLoclCurrCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_curr_cd", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_tp_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setLablPtyRcvrLoclCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_curr_cd", ""));
		setOnNetPayment(JSPUtil.getParameter(request, prefix + "on_net_payment", ""));
		setInsurRcvrDt(JSPUtil.getParameter(request, prefix + "insur_rcvr_dt", ""));
		setCgoClmClzCd(JSPUtil.getParameter(request, prefix + "cgo_clm_clz_cd", ""));
		setLablPtyRcvrLoclXchRt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_xch_rt", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentVO[]
	 */
	public PaymentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentVO[]
	 */
	public PaymentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] netPaidAmount = (JSPUtil.getParameter(request, prefix	+ "net_paid_amount", length));
			String[] cgoClmStlXchRt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_xch_rt", length));
			String[] clmtLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_xch_rt", length));
			String[] insurRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_usd_amt", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] recoveredAmount = (JSPUtil.getParameter(request, prefix	+ "recovered_amount", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] defenseRatioOnSettlement = (JSPUtil.getParameter(request, prefix	+ "defense_ratio_on_settlement", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] payRmk = (JSPUtil.getParameter(request, prefix	+ "pay_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] lablPtyRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_amt", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] cgoClmStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_amt", length));
			String[] clmtLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_curr_cd", length));
			String[] insurRcvrAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_amt", length));
			String[] insurRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_locl_curr_cd", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] clmMiscNm = (JSPUtil.getParameter(request, prefix	+ "clm_misc_nm", length));
			String[] insurRcvrXchRt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_xch_rt", length));
			String[] cgoClmStlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_curr_cd", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] lablPtyRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_curr_cd", length));
			String[] onNetPayment = (JSPUtil.getParameter(request, prefix	+ "on_net_payment", length));
			String[] insurRcvrDt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_dt", length));
			String[] cgoClmClzCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_clz_cd", length));
			String[] lablPtyRcvrLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_xch_rt", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentVO();
				if (netPaidAmount[i] != null)
					model.setNetPaidAmount(netPaidAmount[i]);
				if (cgoClmStlXchRt[i] != null)
					model.setCgoClmStlXchRt(cgoClmStlXchRt[i]);
				if (clmtLoclXchRt[i] != null)
					model.setClmtLoclXchRt(clmtLoclXchRt[i]);
				if (insurRcvrUsdAmt[i] != null)
					model.setInsurRcvrUsdAmt(insurRcvrUsdAmt[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (recoveredAmount[i] != null)
					model.setRecoveredAmount(recoveredAmount[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (defenseRatioOnSettlement[i] != null)
					model.setDefenseRatioOnSettlement(defenseRatioOnSettlement[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (payRmk[i] != null)
					model.setPayRmk(payRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (lablPtyRcvrLoclAmt[i] != null)
					model.setLablPtyRcvrLoclAmt(lablPtyRcvrLoclAmt[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (cgoClmStlLoclAmt[i] != null)
					model.setCgoClmStlLoclAmt(cgoClmStlLoclAmt[i]);
				if (clmtLoclCurrCd[i] != null)
					model.setClmtLoclCurrCd(clmtLoclCurrCd[i]);
				if (insurRcvrAmt[i] != null)
					model.setInsurRcvrAmt(insurRcvrAmt[i]);
				if (insurRcvrLoclCurrCd[i] != null)
					model.setInsurRcvrLoclCurrCd(insurRcvrLoclCurrCd[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (clmMiscNm[i] != null)
					model.setClmMiscNm(clmMiscNm[i]);
				if (insurRcvrXchRt[i] != null)
					model.setInsurRcvrXchRt(insurRcvrXchRt[i]);
				if (cgoClmStlLoclCurrCd[i] != null)
					model.setCgoClmStlLoclCurrCd(cgoClmStlLoclCurrCd[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (lablPtyRcvrLoclCurrCd[i] != null)
					model.setLablPtyRcvrLoclCurrCd(lablPtyRcvrLoclCurrCd[i]);
				if (onNetPayment[i] != null)
					model.setOnNetPayment(onNetPayment[i]);
				if (insurRcvrDt[i] != null)
					model.setInsurRcvrDt(insurRcvrDt[i]);
				if (cgoClmClzCd[i] != null)
					model.setCgoClmClzCd(cgoClmClzCd[i]);
				if (lablPtyRcvrLoclXchRt[i] != null)
					model.setLablPtyRcvrLoclXchRt(lablPtyRcvrLoclXchRt[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentVO[]
	 */
	public PaymentVO[] getPaymentVOs(){
		PaymentVO[] vos = (PaymentVO[])models.toArray(new PaymentVO[models.size()]);
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
		this.netPaidAmount = this.netPaidAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlXchRt = this.cgoClmStlXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclXchRt = this.clmtLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrUsdAmt = this.insurRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recoveredAmount = this.recoveredAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.defenseRatioOnSettlement = this.defenseRatioOnSettlement .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRmk = this.payRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclAmt = this.lablPtyRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclAmt = this.cgoClmStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclCurrCd = this.clmtLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrAmt = this.insurRcvrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrLoclCurrCd = this.insurRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscNm = this.clmMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrXchRt = this.insurRcvrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclCurrCd = this.cgoClmStlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclCurrCd = this.lablPtyRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onNetPayment = this.onNetPayment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrDt = this.insurRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmClzCd = this.cgoClmClzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclXchRt = this.lablPtyRcvrLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
