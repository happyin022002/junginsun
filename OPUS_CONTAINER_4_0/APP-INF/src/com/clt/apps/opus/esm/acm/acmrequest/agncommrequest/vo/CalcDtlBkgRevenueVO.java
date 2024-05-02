/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CalcDtlBkgRevenueVO.java
*@FileTitle : CalcDtlBkgRevenueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.10 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CalcDtlBkgRevenueVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CalcDtlBkgRevenueVO> models = new ArrayList<CalcDtlBkgRevenueVO>();

	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String usdChgAmt = null;
	/* Column Info */
	private String pstPortCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String usdUcAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String chgDdctAmt = null;
	/* Column Info */
	private String payIfAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String prePortCd = null;
	/* Column Info */
	private String crntRevAmt = null;
	/* Column Info */
	private String commRt = null;
	/* Column Info */
	private String commFxAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String chgDdctPayAmt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String acSeq = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String cntrTpszQty = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String rtFxFlg = null;
	/* Column Info */
	private String revDivCd = null;
	/* Column Info */
	private String commRevAmt = null;
	/* Column Info */
	private String commRtAmt = null;
	/* Column Info */
	private String commTpszCd = null;
	/* Column Info */
	private String bkgVolQty = null;
	/* Column Info */
	private String crntAmt = null;
	/* Column Info */
	private String ppdAmt = null;
	/* Column Info */
	private String rmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CalcDtlBkgRevenueVO() {}

	public CalcDtlBkgRevenueVO(String ibflag, String pagerows, String acSeq, String acTpCd, String agnCd, String bkgNo, String chgAmt, String chgCd, String chgDdctAmt, String chgDdctPayAmt, String cntrTpszCd, String cntrTpszQty, String commFxAmt, String commRt, String crntRevAmt, String currCd, String delCd, String ifAmt, String ioBndCd, String nodCd, String opCntrQty, String payIfAmt, String podCd, String polCd, String porCd, String prePortCd, String pstPortCd, String rcvDeTermCd, String stndCostNm, String toNodCd, String usdChgAmt, String usdUcAmt, String acctCd, String rtFxFlg, String revDivCd, String commRevAmt, String commRtAmt, String commTpszCd, String bkgVolQty, String crntAmt, String ppdAmt, String rmk) {
		this.toNodCd = toNodCd;
		this.porCd = porCd;
		this.currCd = currCd;
		this.usdChgAmt = usdChgAmt;
		this.pstPortCd = pstPortCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.usdUcAmt = usdUcAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.chgAmt = chgAmt;
		this.chgDdctAmt = chgDdctAmt;
		this.payIfAmt = payIfAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.acTpCd = acTpCd;
		this.prePortCd = prePortCd;
		this.crntRevAmt = crntRevAmt;
		this.commRt = commRt;
		this.commFxAmt = commFxAmt;
		this.delCd = delCd;
		this.stndCostNm = stndCostNm;
		this.ioBndCd = ioBndCd;
		this.chgDdctPayAmt = chgDdctPayAmt;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.acSeq = acSeq;
		this.ifAmt = ifAmt;
		this.opCntrQty = opCntrQty;
		this.nodCd = nodCd;
		this.cntrTpszQty = cntrTpszQty;
		this.acctCd = acctCd;
		this.rtFxFlg = rtFxFlg;
		this.revDivCd = revDivCd;
		this.commRevAmt = commRevAmt;
		this.commRtAmt = commRtAmt;
		this.commTpszCd = commTpszCd;
		this.bkgVolQty = bkgVolQty;
		this.crntAmt = crntAmt;
		this.ppdAmt = ppdAmt;
		this.rmk = rmk;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("usd_chg_amt", getUsdChgAmt());
		this.hashColumns.put("pst_port_cd", getPstPortCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("usd_uc_amt", getUsdUcAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("chg_ddct_amt", getChgDdctAmt());
		this.hashColumns.put("pay_if_amt", getPayIfAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("pre_port_cd", getPrePortCd());
		this.hashColumns.put("crnt_rev_amt", getCrntRevAmt());
		this.hashColumns.put("comm_rt", getCommRt());
		this.hashColumns.put("comm_fx_amt", getCommFxAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("chg_ddct_pay_amt", getChgDdctPayAmt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ac_seq", getAcSeq());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("cntr_tpsz_qty", getCntrTpszQty());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("rt_fx_flg", getRtFxFlg());
		this.hashColumns.put("rev_div_cd", getRevDivCd());
		this.hashColumns.put("comm_rev_amt", getCommRevAmt());
		this.hashColumns.put("comm_rt_amt", getCommRtAmt());
		this.hashColumns.put("comm_tpsz_cd", getCommTpszCd());
		this.hashColumns.put("bkg_vol_qty", getBkgVolQty());
		this.hashColumns.put("crnt_amt", getCrntAmt());
		this.hashColumns.put("ppd_amt", getPpdAmt());
		this.hashColumns.put("rmk", getRmk());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("usd_chg_amt", "usdChgAmt");
		this.hashFields.put("pst_port_cd", "pstPortCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usd_uc_amt", "usdUcAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("chg_ddct_amt", "chgDdctAmt");
		this.hashFields.put("pay_if_amt", "payIfAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("pre_port_cd", "prePortCd");
		this.hashFields.put("crnt_rev_amt", "crntRevAmt");
		this.hashFields.put("comm_rt", "commRt");
		this.hashFields.put("comm_fx_amt", "commFxAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("chg_ddct_pay_amt", "chgDdctPayAmt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("cntr_tpsz_qty", "cntrTpszQty");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("rt_fx_flg", "rtFxFlg");
		this.hashFields.put("rev_div_cd", "revDivCd");
		this.hashFields.put("comm_rev_amt", "commRevAmt");
		this.hashFields.put("comm_rt_amt", "commRtAmt");
		this.hashFields.put("comm_tpsz_cd", "commTpszCd");
		this.hashFields.put("bkg_vol_qty", "bkgVolQty");
		this.hashFields.put("crnt_amt", "crntAmt");
		this.hashFields.put("ppd_amt", "ppdAmt");
		this.hashFields.put("rmk", "rmk");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return usdChgAmt
	 */
	public String getUsdChgAmt() {
		return this.usdChgAmt;
	}

	/**
	 * Column Info
	 * @return pstPortCd
	 */
	public String getPstPortCd() {
		return this.pstPortCd;
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
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return usdUcAmt
	 */
	public String getUsdUcAmt() {
		return this.usdUcAmt;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return chgDdctAmt
	 */
	public String getChgDdctAmt() {
		return this.chgDdctAmt;
	}

	/**
	 * Column Info
	 * @return payIfAmt
	 */
	public String getPayIfAmt() {
		return this.payIfAmt;
	}

	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}

	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}

	/**
	 * Column Info
	 * @return prePortCd
	 */
	public String getPrePortCd() {
		return this.prePortCd;
	}

	/**
	 * Column Info
	 * @return crntRevAmt
	 */
	public String getCrntRevAmt() {
		return this.crntRevAmt;
	}

	/**
	 * Column Info
	 * @return commRt
	 */
	public String getCommRt() {
		return this.commRt;
	}

	/**
	 * Column Info
	 * @return commFxAmt
	 */
	public String getCommFxAmt() {
		return this.commFxAmt;
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
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
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
	 * @return chgDdctPayAmt
	 */
	public String getChgDdctPayAmt() {
		return this.chgDdctPayAmt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return acSeq
	 */
	public String getAcSeq() {
		return this.acSeq;
	}

	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}

	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}

	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}

	/**
	 * Column Info
	 * @return cntrTpszQty
	 */
	public String getCntrTpszQty() {
		return this.cntrTpszQty;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return rtFxFlg
	 */
	public String getRtFxFlg() {
		return this.rtFxFlg;
	}
	
	/**
	 * Column Info
	 * @return revDivCd
	 */
	public String getRevDivCd() {
		return this.revDivCd;
	}
	
	/**
	 * Column Info
	 * @return commRevAmt
	 */
	public String getCommRevAmt() {
		return this.commRevAmt;
	}
	
	/**
	 * Column Info
	 * @return commRtAmt
	 */
	public String getCommRtAmt() {
		return this.commRtAmt;
	}
	
	/**
	 * Column Info
	 * @return commTpszCd
	 */
	public String getCommTpszCd() {
		return this.commTpszCd;
	}
	
	/**
	 * Column Info
	 * @return bkgVolQty
	 */
	public String getBkgVolQty() {
		return this.bkgVolQty;
	}
	
	/**
	 * Column Info
	 * @return crntAmt
	 */
	public String getCrntAmt() {
		return this.crntAmt;
	}
	
	/**
	 * Column Info
	 * @return ppdAmt
	 */
	public String getPpdAmt() {
		return this.ppdAmt;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}


	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param usdChgAmt
	 */
	public void setUsdChgAmt(String usdChgAmt) {
		this.usdChgAmt = usdChgAmt;
	}

	/**
	 * Column Info
	 * @param pstPortCd
	 */
	public void setPstPortCd(String pstPortCd) {
		this.pstPortCd = pstPortCd;
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
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param usdUcAmt
	 */
	public void setUsdUcAmt(String usdUcAmt) {
		this.usdUcAmt = usdUcAmt;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param chgDdctAmt
	 */
	public void setChgDdctAmt(String chgDdctAmt) {
		this.chgDdctAmt = chgDdctAmt;
	}

	/**
	 * Column Info
	 * @param payIfAmt
	 */
	public void setPayIfAmt(String payIfAmt) {
		this.payIfAmt = payIfAmt;
	}

	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}

	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
	}

	/**
	 * Column Info
	 * @param prePortCd
	 */
	public void setPrePortCd(String prePortCd) {
		this.prePortCd = prePortCd;
	}

	/**
	 * Column Info
	 * @param crntRevAmt
	 */
	public void setCrntRevAmt(String crntRevAmt) {
		this.crntRevAmt = crntRevAmt;
	}

	/**
	 * Column Info
	 * @param commRt
	 */
	public void setCommRt(String commRt) {
		this.commRt = commRt;
	}

	/**
	 * Column Info
	 * @param commFxAmt
	 */
	public void setCommFxAmt(String commFxAmt) {
		this.commFxAmt = commFxAmt;
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
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
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
	 * @param chgDdctPayAmt
	 */
	public void setChgDdctPayAmt(String chgDdctPayAmt) {
		this.chgDdctPayAmt = chgDdctPayAmt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param acSeq
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq = acSeq;
	}

	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}

	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}

	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}

	/**
	 * Column Info
	 * @param cntrTpszQty
	 */
	public void setCntrTpszQty(String cntrTpszQty) {
		this.cntrTpszQty = cntrTpszQty;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param rtFxFlg
	 */
	public void setRtFxFlg(String rtFxFlg) {
		this.rtFxFlg = rtFxFlg;
	}
	
	/**
	 * Column Info
	 * @param revDivCd
	 */
	public void setRevDivCd(String revDivCd) {
		this.revDivCd = revDivCd;
	}
	
	/**
	 * Column Info
	 * @param commRevAmt
	 */
	public void setCommRevAmt(String commRevAmt) {
		this.commRevAmt = commRevAmt;
	}
	
	/**
	 * Column Info
	 * @param commRtAmt
	 */
	public void setCommRtAmt(String commRtAmt) {
		this.commRtAmt = commRtAmt;
	}
	
	/**
	 * Column Info
	 * @param commTpszCd
	 */
	public void setCommTpszCd(String commTpszCd) {
		this.commTpszCd = commTpszCd;
	}
	
	/**
	 * Column Info
	 * @param bkgVolQty
	 */
	public void setBkgVolQty(String bkgVolQty) {
		this.bkgVolQty = bkgVolQty;
	}
	
	/**
	 * Column Info
	 * @param crntAmt
	 */
	public void setCrntAmt(String crntAmt) {
		this.crntAmt = crntAmt;
	}
	
	/**
	 * Column Info
	 * @param ppdAmt
	 */
	public void setPpdAmt(String ppdAmt) {
		this.ppdAmt = ppdAmt;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setUsdChgAmt(JSPUtil.getParameter(request, prefix + "usd_chg_amt", ""));
		setPstPortCd(JSPUtil.getParameter(request, prefix + "pst_port_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setUsdUcAmt(JSPUtil.getParameter(request, prefix + "usd_uc_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setChgDdctAmt(JSPUtil.getParameter(request, prefix + "chg_ddct_amt", ""));
		setPayIfAmt(JSPUtil.getParameter(request, prefix + "pay_if_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
		setPrePortCd(JSPUtil.getParameter(request, prefix + "pre_port_cd", ""));
		setCrntRevAmt(JSPUtil.getParameter(request, prefix + "crnt_rev_amt", ""));
		setCommRt(JSPUtil.getParameter(request, prefix + "comm_rt", ""));
		setCommFxAmt(JSPUtil.getParameter(request, prefix + "comm_fx_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setChgDdctPayAmt(JSPUtil.getParameter(request, prefix + "chg_ddct_pay_amt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAcSeq(JSPUtil.getParameter(request, prefix + "ac_seq", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setCntrTpszQty(JSPUtil.getParameter(request, prefix + "cntr_tpsz_qty", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setRtFxFlg(JSPUtil.getParameter(request, prefix + "rt_fx_flg", ""));
		setRevDivCd(JSPUtil.getParameter(request, prefix + "rev_div_cd", ""));
		setCommRevAmt(JSPUtil.getParameter(request, prefix + "comm_rev_amt", ""));
		setCommRtAmt(JSPUtil.getParameter(request, prefix + "comm_rt_amt", ""));
		setCommTpszCd(JSPUtil.getParameter(request, prefix + "comm_tpsz_cd", ""));
		setBkgVolQty(JSPUtil.getParameter(request, prefix + "bkg_vol_qty", ""));
		setCrntAmt(JSPUtil.getParameter(request, prefix + "crnt_amt", ""));
		setPpdAmt(JSPUtil.getParameter(request, prefix + "ppd_amt", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CalcDtlBkgRevenueVO[]
	 */
	public CalcDtlBkgRevenueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CalcDtlBkgRevenueVO[]
	 */
	public CalcDtlBkgRevenueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CalcDtlBkgRevenueVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] usdChgAmt = (JSPUtil.getParameter(request, prefix	+ "usd_chg_amt", length));
			String[] pstPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_port_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] usdUcAmt = (JSPUtil.getParameter(request, prefix	+ "usd_uc_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] chgDdctAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ddct_amt", length));
			String[] payIfAmt = (JSPUtil.getParameter(request, prefix	+ "pay_if_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] prePortCd = (JSPUtil.getParameter(request, prefix	+ "pre_port_cd", length));
			String[] crntRevAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_rev_amt", length));
			String[] commRt = (JSPUtil.getParameter(request, prefix	+ "comm_rt", length));
			String[] commFxAmt = (JSPUtil.getParameter(request, prefix	+ "comm_fx_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] chgDdctPayAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ddct_pay_amt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] acSeq = (JSPUtil.getParameter(request, prefix	+ "ac_seq", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] cntrTpszQty = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_qty", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] rtFxFlg = (JSPUtil.getParameter(request, prefix	+ "rt_fx_flg", length));
			String[] revDivCd = (JSPUtil.getParameter(request, prefix	+ "rev_div_cd", length));
			String[] commRevAmt = (JSPUtil.getParameter(request, prefix	+ "comm_rev_amt", length));
			String[] commRtAmt = (JSPUtil.getParameter(request, prefix	+ "comm_rt_amt", length));
			String[] commTpszCd = (JSPUtil.getParameter(request, prefix	+ "comm_tpsz_cd", length));
			String[] bkgVolQty = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_qty", length));
			String[] crntAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_amt", length));
			String[] ppdAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_amt", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));

			for (int i = 0; i < length; i++) {
				model = new CalcDtlBkgRevenueVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (usdChgAmt[i] != null)
					model.setUsdChgAmt(usdChgAmt[i]);
				if (pstPortCd[i] != null)
					model.setPstPortCd(pstPortCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (usdUcAmt[i] != null)
					model.setUsdUcAmt(usdUcAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (chgDdctAmt[i] != null)
					model.setChgDdctAmt(chgDdctAmt[i]);
				if (payIfAmt[i] != null)
					model.setPayIfAmt(payIfAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (prePortCd[i] != null)
					model.setPrePortCd(prePortCd[i]);
				if (crntRevAmt[i] != null)
					model.setCrntRevAmt(crntRevAmt[i]);
				if (commRt[i] != null)
					model.setCommRt(commRt[i]);
				if (commFxAmt[i] != null)
					model.setCommFxAmt(commFxAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (chgDdctPayAmt[i] != null)
					model.setChgDdctPayAmt(chgDdctPayAmt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (acSeq[i] != null)
					model.setAcSeq(acSeq[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (cntrTpszQty[i] != null)
					model.setCntrTpszQty(cntrTpszQty[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (rtFxFlg[i] != null)
					model.setRtFxFlg(rtFxFlg[i]);
				if (revDivCd[i] != null)
					model.setRevDivCd(revDivCd[i]);
				if (commRevAmt[i] != null)
					model.setCommRevAmt(commRevAmt[i]);
				if (commRtAmt[i] != null)
					model.setCommRtAmt(commRtAmt[i]);
				if (commTpszCd[i] != null)
					model.setCommTpszCd(commTpszCd[i]);
				if (bkgVolQty[i] != null)
					model.setBkgVolQty(bkgVolQty[i]);
				if (crntAmt[i] != null)
					model.setCrntAmt(crntAmt[i]);
				if (ppdAmt[i] != null)
					model.setPpdAmt(ppdAmt[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCalcDtlBkgRevenueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CalcDtlBkgRevenueVO[]
	 */
	public CalcDtlBkgRevenueVO[] getCalcDtlBkgRevenueVOs(){
		CalcDtlBkgRevenueVO[] vos = (CalcDtlBkgRevenueVO[])models.toArray(new CalcDtlBkgRevenueVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdChgAmt = this.usdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstPortCd = this.pstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdUcAmt = this.usdUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctAmt = this.chgDdctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfAmt = this.payIfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePortCd = this.prePortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRevAmt = this.crntRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRt = this.commRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commFxAmt = this.commFxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctPayAmt = this.chgDdctPayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq = this.acSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszQty = this.cntrTpszQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtFxFlg = this.rtFxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDivCd = this.revDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRevAmt = this.commRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRtAmt = this.commRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commTpszCd = this.commTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVolQty = this.bkgVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAmt = this.crntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAmt = this.ppdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
