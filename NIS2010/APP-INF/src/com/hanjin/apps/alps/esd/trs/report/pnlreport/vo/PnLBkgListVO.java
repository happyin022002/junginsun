/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLBkgListVO.java
*@FileTitle : PnLBkgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.24  
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

public class PnLBkgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PnLBkgListVO> models = new ArrayList<PnLBkgListVO>();
	
	/* Column Info */
	private String totKnt = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String inlndCostTrspUsdAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String costMonth = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String ioBndNm = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String woPlRsltCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgInlndChgAmt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String wo20ftCntrQty = null;
	/* Column Info */
	private String wo40ftCntrQty = null;
	/* Column Info */
	private String costFullPlRsltNm = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String costTtlPlRsltNm = null;
	/* Column Info */
	private String woTeuQty = null;
	/* Column Info */
	private String plGlineFrtRtAmt = null;
	/* Column Info */
	private String bkg20ftCntrQty = null;
	/* Column Info */
	private String prcCtrtCustTpNm = null;
	/* Column Info */
	private String costFullPlRsltCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String glineFrtRtAmt = null;
	/* Column Info */
	private String inlndCostUsdAmt = null;
	/* Column Info */
	private String woUsdAmt = null;
	/* Column Info */
	private String plInlndCostUsdAmt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String plWoUsdAmt = null;
	/* Column Info */
	private String ihcPlRsltNm = null;
	/* Column Info */
	private String bkg40ftCntrQty = null;
	/* Column Info */
	private String woPlRsltNm = null;
	/* Column Info */
	private String costYear = null;
	/* Column Info */
	private String ihcPlRsltCd = null;
	/* Column Info */
	private String plInlndCostTrspUsdAmt = null;
	/* Column Info */
	private String costTtlPlRsltCd = null;
	/* Column Info */
	private String woCntrQty = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String inlndRevTpCd = null;
	/* Column Info */
	private String bkgMrgFlg = null;
	/* Column Info */
	private String costWeek = null;
	/* Column Info */
	private String inlndRevTpNm = null;
	/* Column Info */
	private String bkgCntrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PnLBkgListVO() {}

	public PnLBkgListVO(String ibflag, String pagerows, String costYear, String costMonth, String costWeek, String bkgNo, String splitFlg, String bkgMrgFlg, String ctrtOfcCd, String rhqCd, String svcScpCd, String woOfcCd, String ioBndCd, String ioBndNm, String porCd, String polCd, String podCd, String delCd, String rcvDeTermCd, String rfaNo, String rtAplyDt, String prcCtrtCustTpCd, String prcCtrtCustTpNm, String custCd, String custNm, String inlndRevTpCd, String inlndRevTpNm, String bkgCntrQty, String bkg20ftCntrQty, String bkg40ftCntrQty, String woCntrQty, String wo20ftCntrQty, String wo40ftCntrQty, String bkgTeuQty, String woTeuQty, String bkgInlndChgAmt, String glineFrtRtAmt, String inlndCostUsdAmt, String inlndCostTrspUsdAmt, String woUsdAmt, String plGlineFrtRtAmt, String plInlndCostUsdAmt, String plInlndCostTrspUsdAmt, String plWoUsdAmt, String cmdtCd, String cmdtNm, String ihcPlRsltCd, String ihcPlRsltNm, String costTtlPlRsltCd, String costTtlPlRsltNm, String costFullPlRsltCd, String costFullPlRsltNm, String woPlRsltCd, String woPlRsltNm, String totKnt) {
		this.totKnt = totKnt;
		this.rtAplyDt = rtAplyDt;
		this.svcScpCd = svcScpCd;
		this.inlndCostTrspUsdAmt = inlndCostTrspUsdAmt;
		this.pagerows = pagerows;
		this.costMonth = costMonth;
		this.polCd = polCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.ioBndNm = ioBndNm;
		this.rhqCd = rhqCd;
		this.woPlRsltCd = woPlRsltCd;
		this.delCd = delCd;
		this.bkgInlndChgAmt = bkgInlndChgAmt;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.wo20ftCntrQty = wo20ftCntrQty;
		this.wo40ftCntrQty = wo40ftCntrQty;
		this.costFullPlRsltNm = costFullPlRsltNm;
		this.custCd = custCd;
		this.bkgTeuQty = bkgTeuQty;
		this.costTtlPlRsltNm = costTtlPlRsltNm;
		this.woTeuQty = woTeuQty;
		this.plGlineFrtRtAmt = plGlineFrtRtAmt;
		this.bkg20ftCntrQty = bkg20ftCntrQty;
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
		this.costFullPlRsltCd = costFullPlRsltCd;
		this.porCd = porCd;
		this.splitFlg = splitFlg;
		this.glineFrtRtAmt = glineFrtRtAmt;
		this.inlndCostUsdAmt = inlndCostUsdAmt;
		this.woUsdAmt = woUsdAmt;
		this.plInlndCostUsdAmt = plInlndCostUsdAmt;
		this.custNm = custNm;
		this.woOfcCd = woOfcCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.plWoUsdAmt = plWoUsdAmt;
		this.ihcPlRsltNm = ihcPlRsltNm;
		this.bkg40ftCntrQty = bkg40ftCntrQty;
		this.woPlRsltNm = woPlRsltNm;
		this.costYear = costYear;
		this.ihcPlRsltCd = ihcPlRsltCd;
		this.plInlndCostTrspUsdAmt = plInlndCostTrspUsdAmt;
		this.costTtlPlRsltCd = costTtlPlRsltCd;
		this.woCntrQty = woCntrQty;
		this.ioBndCd = ioBndCd;
		this.cmdtNm = cmdtNm;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.inlndRevTpCd = inlndRevTpCd;
		this.bkgMrgFlg = bkgMrgFlg;
		this.costWeek = costWeek;
		this.inlndRevTpNm = inlndRevTpNm;
		this.bkgCntrQty = bkgCntrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_knt", getTotKnt());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("inlnd_cost_trsp_usd_amt", getInlndCostTrspUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_month", getCostMonth());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("io_bnd_nm", getIoBndNm());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("wo_pl_rslt_cd", getWoPlRsltCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_inlnd_chg_amt", getBkgInlndChgAmt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("wo_20ft_cntr_qty", getWo20ftCntrQty());
		this.hashColumns.put("wo_40ft_cntr_qty", getWo40ftCntrQty());
		this.hashColumns.put("cost_full_pl_rslt_nm", getCostFullPlRsltNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("cost_ttl_pl_rslt_nm", getCostTtlPlRsltNm());
		this.hashColumns.put("wo_teu_qty", getWoTeuQty());
		this.hashColumns.put("pl_gline_frt_rt_amt", getPlGlineFrtRtAmt());
		this.hashColumns.put("bkg_20ft_cntr_qty", getBkg20ftCntrQty());
		this.hashColumns.put("prc_ctrt_cust_tp_nm", getPrcCtrtCustTpNm());
		this.hashColumns.put("cost_full_pl_rslt_cd", getCostFullPlRsltCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("gline_frt_rt_amt", getGlineFrtRtAmt());
		this.hashColumns.put("inlnd_cost_usd_amt", getInlndCostUsdAmt());
		this.hashColumns.put("wo_usd_amt", getWoUsdAmt());
		this.hashColumns.put("pl_inlnd_cost_usd_amt", getPlInlndCostUsdAmt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("pl_wo_usd_amt", getPlWoUsdAmt());
		this.hashColumns.put("ihc_pl_rslt_nm", getIhcPlRsltNm());
		this.hashColumns.put("bkg_40ft_cntr_qty", getBkg40ftCntrQty());
		this.hashColumns.put("wo_pl_rslt_nm", getWoPlRsltNm());
		this.hashColumns.put("cost_year", getCostYear());
		this.hashColumns.put("ihc_pl_rslt_cd", getIhcPlRsltCd());
		this.hashColumns.put("pl_inlnd_cost_trsp_usd_amt", getPlInlndCostTrspUsdAmt());
		this.hashColumns.put("cost_ttl_pl_rslt_cd", getCostTtlPlRsltCd());
		this.hashColumns.put("wo_cntr_qty", getWoCntrQty());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("inlnd_rev_tp_cd", getInlndRevTpCd());
		this.hashColumns.put("bkg_mrg_flg", getBkgMrgFlg());
		this.hashColumns.put("cost_week", getCostWeek());
		this.hashColumns.put("inlnd_rev_tp_nm", getInlndRevTpNm());
		this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_knt", "totKnt");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("inlnd_cost_trsp_usd_amt", "inlndCostTrspUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_month", "costMonth");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("io_bnd_nm", "ioBndNm");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("wo_pl_rslt_cd", "woPlRsltCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_inlnd_chg_amt", "bkgInlndChgAmt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("wo_20ft_cntr_qty", "wo20ftCntrQty");
		this.hashFields.put("wo_40ft_cntr_qty", "wo40ftCntrQty");
		this.hashFields.put("cost_full_pl_rslt_nm", "costFullPlRsltNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("cost_ttl_pl_rslt_nm", "costTtlPlRsltNm");
		this.hashFields.put("wo_teu_qty", "woTeuQty");
		this.hashFields.put("pl_gline_frt_rt_amt", "plGlineFrtRtAmt");
		this.hashFields.put("bkg_20ft_cntr_qty", "bkg20ftCntrQty");
		this.hashFields.put("prc_ctrt_cust_tp_nm", "prcCtrtCustTpNm");
		this.hashFields.put("cost_full_pl_rslt_cd", "costFullPlRsltCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("gline_frt_rt_amt", "glineFrtRtAmt");
		this.hashFields.put("inlnd_cost_usd_amt", "inlndCostUsdAmt");
		this.hashFields.put("wo_usd_amt", "woUsdAmt");
		this.hashFields.put("pl_inlnd_cost_usd_amt", "plInlndCostUsdAmt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("pl_wo_usd_amt", "plWoUsdAmt");
		this.hashFields.put("ihc_pl_rslt_nm", "ihcPlRsltNm");
		this.hashFields.put("bkg_40ft_cntr_qty", "bkg40ftCntrQty");
		this.hashFields.put("wo_pl_rslt_nm", "woPlRsltNm");
		this.hashFields.put("cost_year", "costYear");
		this.hashFields.put("ihc_pl_rslt_cd", "ihcPlRsltCd");
		this.hashFields.put("pl_inlnd_cost_trsp_usd_amt", "plInlndCostTrspUsdAmt");
		this.hashFields.put("cost_ttl_pl_rslt_cd", "costTtlPlRsltCd");
		this.hashFields.put("wo_cntr_qty", "woCntrQty");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("inlnd_rev_tp_cd", "inlndRevTpCd");
		this.hashFields.put("bkg_mrg_flg", "bkgMrgFlg");
		this.hashFields.put("cost_week", "costWeek");
		this.hashFields.put("inlnd_rev_tp_nm", "inlndRevTpNm");
		this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totKnt
	 */
	public String getTotKnt() {
		return this.totKnt;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
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
	 * @return inlndCostTrspUsdAmt
	 */
	public String getInlndCostTrspUsdAmt() {
		return this.inlndCostTrspUsdAmt;
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
	 * @return costMonth
	 */
	public String getCostMonth() {
		return this.costMonth;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
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
	 * @return ioBndNm
	 */
	public String getIoBndNm() {
		return this.ioBndNm;
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
	 * @return woPlRsltCd
	 */
	public String getWoPlRsltCd() {
		return this.woPlRsltCd;
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
	 * @return bkgInlndChgAmt
	 */
	public String getBkgInlndChgAmt() {
		return this.bkgInlndChgAmt;
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
	 * @return wo20ftCntrQty
	 */
	public String getWo20ftCntrQty() {
		return this.wo20ftCntrQty;
	}
	
	/**
	 * Column Info
	 * @return wo40ftCntrQty
	 */
	public String getWo40ftCntrQty() {
		return this.wo40ftCntrQty;
	}
	
	/**
	 * Column Info
	 * @return costFullPlRsltNm
	 */
	public String getCostFullPlRsltNm() {
		return this.costFullPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
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
	 * @return costTtlPlRsltNm
	 */
	public String getCostTtlPlRsltNm() {
		return this.costTtlPlRsltNm;
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
	 * @return bkg20ftCntrQty
	 */
	public String getBkg20ftCntrQty() {
		return this.bkg20ftCntrQty;
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
	 * @return costFullPlRsltCd
	 */
	public String getCostFullPlRsltCd() {
		return this.costFullPlRsltCd;
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
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return ihcPlRsltNm
	 */
	public String getIhcPlRsltNm() {
		return this.ihcPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @return bkg40ftCntrQty
	 */
	public String getBkg40ftCntrQty() {
		return this.bkg40ftCntrQty;
	}
	
	/**
	 * Column Info
	 * @return woPlRsltNm
	 */
	public String getWoPlRsltNm() {
		return this.woPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @return costYear
	 */
	public String getCostYear() {
		return this.costYear;
	}
	
	/**
	 * Column Info
	 * @return ihcPlRsltCd
	 */
	public String getIhcPlRsltCd() {
		return this.ihcPlRsltCd;
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
	 * @return costTtlPlRsltCd
	 */
	public String getCostTtlPlRsltCd() {
		return this.costTtlPlRsltCd;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return bkgMrgFlg
	 */
	public String getBkgMrgFlg() {
		return this.bkgMrgFlg;
	}
	
	/**
	 * Column Info
	 * @return costWeek
	 */
	public String getCostWeek() {
		return this.costWeek;
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
	 * @param totKnt
	 */
	public void setTotKnt(String totKnt) {
		this.totKnt = totKnt;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
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
	 * @param inlndCostTrspUsdAmt
	 */
	public void setInlndCostTrspUsdAmt(String inlndCostTrspUsdAmt) {
		this.inlndCostTrspUsdAmt = inlndCostTrspUsdAmt;
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
	 * @param costMonth
	 */
	public void setCostMonth(String costMonth) {
		this.costMonth = costMonth;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
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
	 * @param ioBndNm
	 */
	public void setIoBndNm(String ioBndNm) {
		this.ioBndNm = ioBndNm;
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
	 * @param woPlRsltCd
	 */
	public void setWoPlRsltCd(String woPlRsltCd) {
		this.woPlRsltCd = woPlRsltCd;
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
	 * @param bkgInlndChgAmt
	 */
	public void setBkgInlndChgAmt(String bkgInlndChgAmt) {
		this.bkgInlndChgAmt = bkgInlndChgAmt;
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
	 * @param wo20ftCntrQty
	 */
	public void setWo20ftCntrQty(String wo20ftCntrQty) {
		this.wo20ftCntrQty = wo20ftCntrQty;
	}
	
	/**
	 * Column Info
	 * @param wo40ftCntrQty
	 */
	public void setWo40ftCntrQty(String wo40ftCntrQty) {
		this.wo40ftCntrQty = wo40ftCntrQty;
	}
	
	/**
	 * Column Info
	 * @param costFullPlRsltNm
	 */
	public void setCostFullPlRsltNm(String costFullPlRsltNm) {
		this.costFullPlRsltNm = costFullPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
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
	 * @param costTtlPlRsltNm
	 */
	public void setCostTtlPlRsltNm(String costTtlPlRsltNm) {
		this.costTtlPlRsltNm = costTtlPlRsltNm;
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
	 * @param bkg20ftCntrQty
	 */
	public void setBkg20ftCntrQty(String bkg20ftCntrQty) {
		this.bkg20ftCntrQty = bkg20ftCntrQty;
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
	 * @param costFullPlRsltCd
	 */
	public void setCostFullPlRsltCd(String costFullPlRsltCd) {
		this.costFullPlRsltCd = costFullPlRsltCd;
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
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param ihcPlRsltNm
	 */
	public void setIhcPlRsltNm(String ihcPlRsltNm) {
		this.ihcPlRsltNm = ihcPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @param bkg40ftCntrQty
	 */
	public void setBkg40ftCntrQty(String bkg40ftCntrQty) {
		this.bkg40ftCntrQty = bkg40ftCntrQty;
	}
	
	/**
	 * Column Info
	 * @param woPlRsltNm
	 */
	public void setWoPlRsltNm(String woPlRsltNm) {
		this.woPlRsltNm = woPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @param costYear
	 */
	public void setCostYear(String costYear) {
		this.costYear = costYear;
	}
	
	/**
	 * Column Info
	 * @param ihcPlRsltCd
	 */
	public void setIhcPlRsltCd(String ihcPlRsltCd) {
		this.ihcPlRsltCd = ihcPlRsltCd;
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
	 * @param costTtlPlRsltCd
	 */
	public void setCostTtlPlRsltCd(String costTtlPlRsltCd) {
		this.costTtlPlRsltCd = costTtlPlRsltCd;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param bkgMrgFlg
	 */
	public void setBkgMrgFlg(String bkgMrgFlg) {
		this.bkgMrgFlg = bkgMrgFlg;
	}
	
	/**
	 * Column Info
	 * @param costWeek
	 */
	public void setCostWeek(String costWeek) {
		this.costWeek = costWeek;
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
		setTotKnt(JSPUtil.getParameter(request, prefix + "tot_knt", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setInlndCostTrspUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_trsp_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostMonth(JSPUtil.getParameter(request, prefix + "cost_month", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setIoBndNm(JSPUtil.getParameter(request, prefix + "io_bnd_nm", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setWoPlRsltCd(JSPUtil.getParameter(request, prefix + "wo_pl_rslt_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgInlndChgAmt(JSPUtil.getParameter(request, prefix + "bkg_inlnd_chg_amt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setWo20ftCntrQty(JSPUtil.getParameter(request, prefix + "wo_20ft_cntr_qty", ""));
		setWo40ftCntrQty(JSPUtil.getParameter(request, prefix + "wo_40ft_cntr_qty", ""));
		setCostFullPlRsltNm(JSPUtil.getParameter(request, prefix + "cost_full_pl_rslt_nm", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setCostTtlPlRsltNm(JSPUtil.getParameter(request, prefix + "cost_ttl_pl_rslt_nm", ""));
		setWoTeuQty(JSPUtil.getParameter(request, prefix + "wo_teu_qty", ""));
		setPlGlineFrtRtAmt(JSPUtil.getParameter(request, prefix + "pl_gline_frt_rt_amt", ""));
		setBkg20ftCntrQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_cntr_qty", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_nm", ""));
		setCostFullPlRsltCd(JSPUtil.getParameter(request, prefix + "cost_full_pl_rslt_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setGlineFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_frt_rt_amt", ""));
		setInlndCostUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_usd_amt", ""));
		setWoUsdAmt(JSPUtil.getParameter(request, prefix + "wo_usd_amt", ""));
		setPlInlndCostUsdAmt(JSPUtil.getParameter(request, prefix + "pl_inlnd_cost_usd_amt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setPlWoUsdAmt(JSPUtil.getParameter(request, prefix + "pl_wo_usd_amt", ""));
		setIhcPlRsltNm(JSPUtil.getParameter(request, prefix + "ihc_pl_rslt_nm", ""));
		setBkg40ftCntrQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_cntr_qty", ""));
		setWoPlRsltNm(JSPUtil.getParameter(request, prefix + "wo_pl_rslt_nm", ""));
		setCostYear(JSPUtil.getParameter(request, prefix + "cost_year", ""));
		setIhcPlRsltCd(JSPUtil.getParameter(request, prefix + "ihc_pl_rslt_cd", ""));
		setPlInlndCostTrspUsdAmt(JSPUtil.getParameter(request, prefix + "pl_inlnd_cost_trsp_usd_amt", ""));
		setCostTtlPlRsltCd(JSPUtil.getParameter(request, prefix + "cost_ttl_pl_rslt_cd", ""));
		setWoCntrQty(JSPUtil.getParameter(request, prefix + "wo_cntr_qty", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setInlndRevTpCd(JSPUtil.getParameter(request, prefix + "inlnd_rev_tp_cd", ""));
		setBkgMrgFlg(JSPUtil.getParameter(request, prefix + "bkg_mrg_flg", ""));
		setCostWeek(JSPUtil.getParameter(request, prefix + "cost_week", ""));
		setInlndRevTpNm(JSPUtil.getParameter(request, prefix + "inlnd_rev_tp_nm", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "bkg_cntr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PnLBkgListVO[]
	 */
	public PnLBkgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PnLBkgListVO[]
	 */
	public PnLBkgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PnLBkgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totKnt = (JSPUtil.getParameter(request, prefix	+ "tot_knt", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] inlndCostTrspUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_trsp_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costMonth = (JSPUtil.getParameter(request, prefix	+ "cost_month", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] ioBndNm = (JSPUtil.getParameter(request, prefix	+ "io_bnd_nm", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] woPlRsltCd = (JSPUtil.getParameter(request, prefix	+ "wo_pl_rslt_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgInlndChgAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_inlnd_chg_amt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] wo20ftCntrQty = (JSPUtil.getParameter(request, prefix	+ "wo_20ft_cntr_qty", length));
			String[] wo40ftCntrQty = (JSPUtil.getParameter(request, prefix	+ "wo_40ft_cntr_qty", length));
			String[] costFullPlRsltNm = (JSPUtil.getParameter(request, prefix	+ "cost_full_pl_rslt_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] costTtlPlRsltNm = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_pl_rslt_nm", length));
			String[] woTeuQty = (JSPUtil.getParameter(request, prefix	+ "wo_teu_qty", length));
			String[] plGlineFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "pl_gline_frt_rt_amt", length));
			String[] bkg20ftCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_cntr_qty", length));
			String[] prcCtrtCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_nm", length));
			String[] costFullPlRsltCd = (JSPUtil.getParameter(request, prefix	+ "cost_full_pl_rslt_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] glineFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_frt_rt_amt", length));
			String[] inlndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_usd_amt", length));
			String[] woUsdAmt = (JSPUtil.getParameter(request, prefix	+ "wo_usd_amt", length));
			String[] plInlndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_inlnd_cost_usd_amt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] plWoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_wo_usd_amt", length));
			String[] ihcPlRsltNm = (JSPUtil.getParameter(request, prefix	+ "ihc_pl_rslt_nm", length));
			String[] bkg40ftCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_cntr_qty", length));
			String[] woPlRsltNm = (JSPUtil.getParameter(request, prefix	+ "wo_pl_rslt_nm", length));
			String[] costYear = (JSPUtil.getParameter(request, prefix	+ "cost_year", length));
			String[] ihcPlRsltCd = (JSPUtil.getParameter(request, prefix	+ "ihc_pl_rslt_cd", length));
			String[] plInlndCostTrspUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_inlnd_cost_trsp_usd_amt", length));
			String[] costTtlPlRsltCd = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_pl_rslt_cd", length));
			String[] woCntrQty = (JSPUtil.getParameter(request, prefix	+ "wo_cntr_qty", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] inlndRevTpCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rev_tp_cd", length));
			String[] bkgMrgFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_mrg_flg", length));
			String[] costWeek = (JSPUtil.getParameter(request, prefix	+ "cost_week", length));
			String[] inlndRevTpNm = (JSPUtil.getParameter(request, prefix	+ "inlnd_rev_tp_nm", length));
			String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new PnLBkgListVO();
				if (totKnt[i] != null)
					model.setTotKnt(totKnt[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (inlndCostTrspUsdAmt[i] != null)
					model.setInlndCostTrspUsdAmt(inlndCostTrspUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costMonth[i] != null)
					model.setCostMonth(costMonth[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (ioBndNm[i] != null)
					model.setIoBndNm(ioBndNm[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (woPlRsltCd[i] != null)
					model.setWoPlRsltCd(woPlRsltCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgInlndChgAmt[i] != null)
					model.setBkgInlndChgAmt(bkgInlndChgAmt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (wo20ftCntrQty[i] != null)
					model.setWo20ftCntrQty(wo20ftCntrQty[i]);
				if (wo40ftCntrQty[i] != null)
					model.setWo40ftCntrQty(wo40ftCntrQty[i]);
				if (costFullPlRsltNm[i] != null)
					model.setCostFullPlRsltNm(costFullPlRsltNm[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (costTtlPlRsltNm[i] != null)
					model.setCostTtlPlRsltNm(costTtlPlRsltNm[i]);
				if (woTeuQty[i] != null)
					model.setWoTeuQty(woTeuQty[i]);
				if (plGlineFrtRtAmt[i] != null)
					model.setPlGlineFrtRtAmt(plGlineFrtRtAmt[i]);
				if (bkg20ftCntrQty[i] != null)
					model.setBkg20ftCntrQty(bkg20ftCntrQty[i]);
				if (prcCtrtCustTpNm[i] != null)
					model.setPrcCtrtCustTpNm(prcCtrtCustTpNm[i]);
				if (costFullPlRsltCd[i] != null)
					model.setCostFullPlRsltCd(costFullPlRsltCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (glineFrtRtAmt[i] != null)
					model.setGlineFrtRtAmt(glineFrtRtAmt[i]);
				if (inlndCostUsdAmt[i] != null)
					model.setInlndCostUsdAmt(inlndCostUsdAmt[i]);
				if (woUsdAmt[i] != null)
					model.setWoUsdAmt(woUsdAmt[i]);
				if (plInlndCostUsdAmt[i] != null)
					model.setPlInlndCostUsdAmt(plInlndCostUsdAmt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (plWoUsdAmt[i] != null)
					model.setPlWoUsdAmt(plWoUsdAmt[i]);
				if (ihcPlRsltNm[i] != null)
					model.setIhcPlRsltNm(ihcPlRsltNm[i]);
				if (bkg40ftCntrQty[i] != null)
					model.setBkg40ftCntrQty(bkg40ftCntrQty[i]);
				if (woPlRsltNm[i] != null)
					model.setWoPlRsltNm(woPlRsltNm[i]);
				if (costYear[i] != null)
					model.setCostYear(costYear[i]);
				if (ihcPlRsltCd[i] != null)
					model.setIhcPlRsltCd(ihcPlRsltCd[i]);
				if (plInlndCostTrspUsdAmt[i] != null)
					model.setPlInlndCostTrspUsdAmt(plInlndCostTrspUsdAmt[i]);
				if (costTtlPlRsltCd[i] != null)
					model.setCostTtlPlRsltCd(costTtlPlRsltCd[i]);
				if (woCntrQty[i] != null)
					model.setWoCntrQty(woCntrQty[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (inlndRevTpCd[i] != null)
					model.setInlndRevTpCd(inlndRevTpCd[i]);
				if (bkgMrgFlg[i] != null)
					model.setBkgMrgFlg(bkgMrgFlg[i]);
				if (costWeek[i] != null)
					model.setCostWeek(costWeek[i]);
				if (inlndRevTpNm[i] != null)
					model.setInlndRevTpNm(inlndRevTpNm[i]);
				if (bkgCntrQty[i] != null)
					model.setBkgCntrQty(bkgCntrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPnLBkgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PnLBkgListVO[]
	 */
	public PnLBkgListVO[] getPnLBkgListVOs(){
		PnLBkgListVO[] vos = (PnLBkgListVO[])models.toArray(new PnLBkgListVO[models.size()]);
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
		this.totKnt = this.totKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostTrspUsdAmt = this.inlndCostTrspUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMonth = this.costMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndNm = this.ioBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woPlRsltCd = this.woPlRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgInlndChgAmt = this.bkgInlndChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo20ftCntrQty = this.wo20ftCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wo40ftCntrQty = this.wo40ftCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costFullPlRsltNm = this.costFullPlRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlPlRsltNm = this.costTtlPlRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTeuQty = this.woTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plGlineFrtRtAmt = this.plGlineFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftCntrQty = this.bkg20ftCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm = this.prcCtrtCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costFullPlRsltCd = this.costFullPlRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineFrtRtAmt = this.glineFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostUsdAmt = this.inlndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woUsdAmt = this.woUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInlndCostUsdAmt = this.plInlndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plWoUsdAmt = this.plWoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcPlRsltNm = this.ihcPlRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftCntrQty = this.bkg40ftCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woPlRsltNm = this.woPlRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYear = this.costYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcPlRsltCd = this.ihcPlRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInlndCostTrspUsdAmt = this.plInlndCostTrspUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlPlRsltCd = this.costTtlPlRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCntrQty = this.woCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRevTpCd = this.inlndRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMrgFlg = this.bkgMrgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWeek = this.costWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRevTpNm = this.inlndRevTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrQty = this.bkgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
