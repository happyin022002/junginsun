/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChinaVATInvoiceCreationVO.java
*@FileTitle : ChinaVATInvoiceCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.30
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.30 임옥영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 임옥영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaVATInvoiceCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaVATInvoiceCreationVO> models = new ArrayList<ChinaVATInvoiceCreationVO>();
	
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String sailingDt = null;
	/* Column Info */
	private String cityCd = null;
	/* Column Info */
	private String lclVvd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String errorMsg = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revCoaAcctCd = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String xchRtUsdTpCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String invXchRtDt = null;
	/* Column Info */
	private String invCoaRgnCd = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String crTermDys = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String lclCurr = null;
	/* Column Info */
	private String xchRtN3rdTpCd = null;
	/* Column Info */
	private String invCustSeq = null;
	/* Column Info */
	private String invCoaCtrCd = null;
	/* Column Info */
	private String subsCoCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String custCrFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String acctXchRtYrmon = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String localTime = null;
	/* Column Info */
	private String ratAsCntrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChinaVATInvoiceCreationVO() {}

	public ChinaVATInvoiceCreationVO(String ibflag, String pagerows, String blNo, String arOfcCd, String custCode, String revTpCd, String revSrcCd, String lclVvd, String svcScpCd, String ioBndCd, String polCd, String podCd, String chgCd, String lclCurr, String trfRtAmt, String ratAsCntrQty, String perTpCd, String chgAmt, String errorMsg, String custCntCd, String custSeq, String userId, String userNm, String cityCd, String localTime, String svrId, String sailingDt, String sailArrDt, String effDt, String dueDt, String crTermDys, String custCrFlg, String invCustCntCd, String invCustSeq, String subsCoCd, String xchRtN3rdTpCd, String xchRtUsdTpCd, String xchRtDt, String usdXchRt, String invXchRt, String invXchRtDt, String acctXchRtYrmon, String invCoaRgnCd, String invCoaCtrCd, String revCoaAcctCd) {
		this.xchRtDt = xchRtDt;
		this.sailingDt = sailingDt;
		this.cityCd = cityCd;
		this.lclVvd = lclVvd;
		this.svcScpCd = svcScpCd;
		this.usdXchRt = usdXchRt;
		this.trfRtAmt = trfRtAmt;
		this.errorMsg = errorMsg;
		this.sailArrDt = sailArrDt;
		this.blNo = blNo;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.revCoaAcctCd = revCoaAcctCd;
		this.svrId = svrId;
		this.xchRtUsdTpCd = xchRtUsdTpCd;
		this.effDt = effDt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.invCustCntCd = invCustCntCd;
		this.revSrcCd = revSrcCd;
		this.chgAmt = chgAmt;
		this.userId = userId;
		this.invXchRtDt = invXchRtDt;
		this.invCoaRgnCd = invCoaRgnCd;
		this.dueDt = dueDt;
		this.invXchRt = invXchRt;
		this.custCntCd = custCntCd;
		this.crTermDys = crTermDys;
		this.perTpCd = perTpCd;
		this.lclCurr = lclCurr;
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
		this.invCustSeq = invCustSeq;
		this.invCoaCtrCd = invCoaCtrCd;
		this.subsCoCd = subsCoCd;
		this.ioBndCd = ioBndCd;
		this.custSeq = custSeq;
		this.revTpCd = revTpCd;
		this.arOfcCd = arOfcCd;
		this.custCrFlg = custCrFlg;
		this.podCd = podCd;
		this.userNm = userNm;
		this.acctXchRtYrmon = acctXchRtYrmon;
		this.custCode = custCode;
		this.localTime = localTime;
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("sailing_dt", getSailingDt());
		this.hashColumns.put("city_cd", getCityCd());
		this.hashColumns.put("lcl_vvd", getLclVvd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("error_msg", getErrorMsg());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_coa_acct_cd", getRevCoaAcctCd());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());
		this.hashColumns.put("inv_coa_rgn_cd", getInvCoaRgnCd());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cr_term_dys", getCrTermDys());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("lcl_curr", getLclCurr());
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		this.hashColumns.put("inv_coa_ctr_cd", getInvCoaCtrCd());
		this.hashColumns.put("subs_co_cd", getSubsCoCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("acct_xch_rt_yrmon", getAcctXchRtYrmon());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("local_time", getLocalTime());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("sailing_dt", "sailingDt");
		this.hashFields.put("city_cd", "cityCd");
		this.hashFields.put("lcl_vvd", "lclVvd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("error_msg", "errorMsg");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_coa_acct_cd", "revCoaAcctCd");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("inv_coa_rgn_cd", "invCoaRgnCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("inv_coa_ctr_cd", "invCoaCtrCd");
		this.hashFields.put("subs_co_cd", "subsCoCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("acct_xch_rt_yrmon", "acctXchRtYrmon");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("local_time", "localTime");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
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
	 * @return sailingDt
	 */
	public String getSailingDt() {
		return this.sailingDt;
	}
	
	/**
	 * Column Info
	 * @return cityCd
	 */
	public String getCityCd() {
		return this.cityCd;
	}
	
	/**
	 * Column Info
	 * @return lclVvd
	 */
	public String getLclVvd() {
		return this.lclVvd;
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
	 * @return usdXchRt
	 */
	public String getUsdXchRt() {
		return this.usdXchRt;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return revCoaAcctCd
	 */
	public String getRevCoaAcctCd() {
		return this.revCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return xchRtUsdTpCd
	 */
	public String getXchRtUsdTpCd() {
		return this.xchRtUsdTpCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return invCustCntCd
	 */
	public String getInvCustCntCd() {
		return this.invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return invXchRtDt
	 */
	public String getInvXchRtDt() {
		return this.invXchRtDt;
	}
	
	/**
	 * Column Info
	 * @return invCoaRgnCd
	 */
	public String getInvCoaRgnCd() {
		return this.invCoaRgnCd;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @return crTermDys
	 */
	public String getCrTermDys() {
		return this.crTermDys;
	}
	
	/**
	 * Column Info
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
	}
	
	/**
	 * Column Info
	 * @return lclCurr
	 */
	public String getLclCurr() {
		return this.lclCurr;
	}
	
	/**
	 * Column Info
	 * @return xchRtN3rdTpCd
	 */
	public String getXchRtN3rdTpCd() {
		return this.xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @return invCustSeq
	 */
	public String getInvCustSeq() {
		return this.invCustSeq;
	}
	
	/**
	 * Column Info
	 * @return invCoaCtrCd
	 */
	public String getInvCoaCtrCd() {
		return this.invCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @return subsCoCd
	 */
	public String getSubsCoCd() {
		return this.subsCoCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCrFlg
	 */
	public String getCustCrFlg() {
		return this.custCrFlg;
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
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return acctXchRtYrmon
	 */
	public String getAcctXchRtYrmon() {
		return this.acctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return localTime
	 */
	public String getLocalTime() {
		return this.localTime;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
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
	 * @param sailingDt
	 */
	public void setSailingDt(String sailingDt) {
		this.sailingDt = sailingDt;
	}
	
	/**
	 * Column Info
	 * @param cityCd
	 */
	public void setCityCd(String cityCd) {
		this.cityCd = cityCd;
	}
	
	/**
	 * Column Info
	 * @param lclVvd
	 */
	public void setLclVvd(String lclVvd) {
		this.lclVvd = lclVvd;
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
	 * @param usdXchRt
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param revCoaAcctCd
	 */
	public void setRevCoaAcctCd(String revCoaAcctCd) {
		this.revCoaAcctCd = revCoaAcctCd;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param xchRtUsdTpCd
	 */
	public void setXchRtUsdTpCd(String xchRtUsdTpCd) {
		this.xchRtUsdTpCd = xchRtUsdTpCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param invCustCntCd
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param invXchRtDt
	 */
	public void setInvXchRtDt(String invXchRtDt) {
		this.invXchRtDt = invXchRtDt;
	}
	
	/**
	 * Column Info
	 * @param invCoaRgnCd
	 */
	public void setInvCoaRgnCd(String invCoaRgnCd) {
		this.invCoaRgnCd = invCoaRgnCd;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
	 * @param crTermDys
	 */
	public void setCrTermDys(String crTermDys) {
		this.crTermDys = crTermDys;
	}
	
	/**
	 * Column Info
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
	}
	
	/**
	 * Column Info
	 * @param lclCurr
	 */
	public void setLclCurr(String lclCurr) {
		this.lclCurr = lclCurr;
	}
	
	/**
	 * Column Info
	 * @param xchRtN3rdTpCd
	 */
	public void setXchRtN3rdTpCd(String xchRtN3rdTpCd) {
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @param invCustSeq
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * Column Info
	 * @param invCoaCtrCd
	 */
	public void setInvCoaCtrCd(String invCoaCtrCd) {
		this.invCoaCtrCd = invCoaCtrCd;
	}
	
	/**
	 * Column Info
	 * @param subsCoCd
	 */
	public void setSubsCoCd(String subsCoCd) {
		this.subsCoCd = subsCoCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCrFlg
	 */
	public void setCustCrFlg(String custCrFlg) {
		this.custCrFlg = custCrFlg;
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
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	/**
	 * Column Info
	 * @param acctXchRtYrmon
	 */
	public void setAcctXchRtYrmon(String acctXchRtYrmon) {
		this.acctXchRtYrmon = acctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param localTime
	 */
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
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
		setSailingDt(JSPUtil.getParameter(request, prefix + "sailing_dt", ""));
		setCityCd(JSPUtil.getParameter(request, prefix + "city_cd", ""));
		setLclVvd(JSPUtil.getParameter(request, prefix + "lcl_vvd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request, prefix + "usd_xch_rt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, prefix + "trf_rt_amt", ""));
		setErrorMsg(JSPUtil.getParameter(request, prefix + "error_msg", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevCoaAcctCd(JSPUtil.getParameter(request, prefix + "rev_coa_acct_cd", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_usd_tp_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, prefix + "inv_cust_cnt_cd", ""));
		setRevSrcCd(JSPUtil.getParameter(request, prefix + "rev_src_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setInvXchRtDt(JSPUtil.getParameter(request, prefix + "inv_xch_rt_dt", ""));
		setInvCoaRgnCd(JSPUtil.getParameter(request, prefix + "inv_coa_rgn_cd", ""));
		setDueDt(JSPUtil.getParameter(request, prefix + "due_dt", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCrTermDys(JSPUtil.getParameter(request, prefix + "cr_term_dys", ""));
		setPerTpCd(JSPUtil.getParameter(request, prefix + "per_tp_cd", ""));
		setLclCurr(JSPUtil.getParameter(request, prefix + "lcl_curr", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_n3rd_tp_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request, prefix + "inv_cust_seq", ""));
		setInvCoaCtrCd(JSPUtil.getParameter(request, prefix + "inv_coa_ctr_cd", ""));
		setSubsCoCd(JSPUtil.getParameter(request, prefix + "subs_co_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setRevTpCd(JSPUtil.getParameter(request, prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCustCrFlg(JSPUtil.getParameter(request, prefix + "cust_cr_flg", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setAcctXchRtYrmon(JSPUtil.getParameter(request, prefix + "acct_xch_rt_yrmon", ""));
		setCustCode(JSPUtil.getParameter(request, prefix + "cust_code", ""));
		setLocalTime(JSPUtil.getParameter(request, prefix + "local_time", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, prefix + "rat_as_cntr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaVATInvoiceCreationVO[]
	 */
	public ChinaVATInvoiceCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaVATInvoiceCreationVO[]
	 */
	public ChinaVATInvoiceCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaVATInvoiceCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] sailingDt = (JSPUtil.getParameter(request, prefix	+ "sailing_dt", length));
			String[] cityCd = (JSPUtil.getParameter(request, prefix	+ "city_cd", length));
			String[] lclVvd = (JSPUtil.getParameter(request, prefix	+ "lcl_vvd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt", length));
			String[] errorMsg = (JSPUtil.getParameter(request, prefix	+ "error_msg", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_acct_cd", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] xchRtUsdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_usd_tp_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] invXchRtDt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt_dt", length));
			String[] invCoaRgnCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_rgn_cd", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] crTermDys = (JSPUtil.getParameter(request, prefix	+ "cr_term_dys", length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd", length));
			String[] lclCurr = (JSPUtil.getParameter(request, prefix	+ "lcl_curr", length));
			String[] xchRtN3rdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_n3rd_tp_cd", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			String[] invCoaCtrCd = (JSPUtil.getParameter(request, prefix	+ "inv_coa_ctr_cd", length));
			String[] subsCoCd = (JSPUtil.getParameter(request, prefix	+ "subs_co_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] custCrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_cr_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] acctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_yrmon", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] localTime = (JSPUtil.getParameter(request, prefix	+ "local_time", length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaVATInvoiceCreationVO();
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (sailingDt[i] != null)
					model.setSailingDt(sailingDt[i]);
				if (cityCd[i] != null)
					model.setCityCd(cityCd[i]);
				if (lclVvd[i] != null)
					model.setLclVvd(lclVvd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (errorMsg[i] != null)
					model.setErrorMsg(errorMsg[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revCoaAcctCd[i] != null)
					model.setRevCoaAcctCd(revCoaAcctCd[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (xchRtUsdTpCd[i] != null)
					model.setXchRtUsdTpCd(xchRtUsdTpCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (invXchRtDt[i] != null)
					model.setInvXchRtDt(invXchRtDt[i]);
				if (invCoaRgnCd[i] != null)
					model.setInvCoaRgnCd(invCoaRgnCd[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (crTermDys[i] != null)
					model.setCrTermDys(crTermDys[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (lclCurr[i] != null)
					model.setLclCurr(lclCurr[i]);
				if (xchRtN3rdTpCd[i] != null)
					model.setXchRtN3rdTpCd(xchRtN3rdTpCd[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				if (invCoaCtrCd[i] != null)
					model.setInvCoaCtrCd(invCoaCtrCd[i]);
				if (subsCoCd[i] != null)
					model.setSubsCoCd(subsCoCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (custCrFlg[i] != null)
					model.setCustCrFlg(custCrFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (acctXchRtYrmon[i] != null)
					model.setAcctXchRtYrmon(acctXchRtYrmon[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (localTime[i] != null)
					model.setLocalTime(localTime[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaVATInvoiceCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaVATInvoiceCreationVO[]
	 */
	public ChinaVATInvoiceCreationVO[] getChinaVATInvoiceCreationVOs(){
		ChinaVATInvoiceCreationVO[] vos = (ChinaVATInvoiceCreationVO[])models.toArray(new ChinaVATInvoiceCreationVO[models.size()]);
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
		this.sailingDt = this.sailingDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cityCd = this.cityCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclVvd = this.lclVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorMsg = this.errorMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaAcctCd = this.revCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd = this.xchRtUsdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt = this.invXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaRgnCd = this.invCoaRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTermDys = this.crTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr = this.lclCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd = this.xchRtN3rdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCoaCtrCd = this.invCoaCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoCd = this.subsCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg = this.custCrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtYrmon = this.acctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTime = this.localTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
