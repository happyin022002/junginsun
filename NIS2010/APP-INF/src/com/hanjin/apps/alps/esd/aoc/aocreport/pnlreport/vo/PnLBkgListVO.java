/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PnLBkgListVO.java
*@FileTitle : PnLBkgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.01
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.10.01 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PnLBkgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PnLBkgListVO> models = new ArrayList<PnLBkgListVO>();
	
	/* Column Info */
	private String ctrtTpNm = null;
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
	private String ctrtNo = null;
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
	private String invUsdAmt = null;
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
	private String rfaAmdtCreDt = null;
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
	private String plInlndCostUsdAmt = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String xInvUsdAmt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String custSegmCd = null;
	/* Column Info */
	private String plInvUsdAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String ihcPlRsltNm = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String bkg40ftCntrQty = null;
	/* Column Info */
	private String woPlRsltNm = null;
	/* Column Info */
	private String costYear = null;
	/* Column Info */
	private String yInvUsdAmt = null;
	/* Column Info */
	private String ihcPlRsltCd = null;
	/* Column Info */
	private String costTtlPlRsltCd = null;
	/* Column Info */
	private String plInlndCostTrspUsdAmt = null;
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
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String ttlDist = null;
	/* Column Info */
	private String lnkDistDivCd = null;
	/* Column Info */
	private String ttlPvndrSeq = null;
	/* Column Info */
	private String ttlPvndrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PnLBkgListVO() {}

	public PnLBkgListVO(String ibflag, String pagerows, String costYear, String costMonth, String costWeek, String bkgNo, String splitFlg, String bkgMrgFlg, String ctrtOfcCd, String rhqCd, String svcScpCd, String woOfcCd, String ioBndCd, String ioBndNm, String porCd, String polCd, String podCd, String delCd, String rcvDeTermCd, String ctrtTpNm, String ctrtNo, String rtAplyDt, String prcCtrtCustTpCd, String prcCtrtCustTpNm, String custSegmCd, String custCd, String custNm, String inlndRevTpCd, String inlndRevTpNm, String bkgCntrQty, String bkg20ftCntrQty, String bkg40ftCntrQty, String woCntrQty, String wo20ftCntrQty, String wo40ftCntrQty, String bkgTeuQty, String woTeuQty, String bkgInlndChgAmt, String glineFrtRtAmt, String inlndCostUsdAmt, String inlndCostTrspUsdAmt, String invUsdAmt, String yInvUsdAmt, String xInvUsdAmt, String plGlineFrtRtAmt, String plInlndCostUsdAmt, String plInlndCostTrspUsdAmt, String plInvUsdAmt, String cmdtCd, String cmdtNm, String ihcPlRsltCd, String ihcPlRsltNm, String costTtlPlRsltCd, String costTtlPlRsltNm, String costFullPlRsltCd, String costFullPlRsltNm, String woPlRsltCd, String woPlRsltNm, String totKnt, String vslSlanCd, String ctrtEffDt, String ctrtExpDt, String rfaAmdtCreDt, String fmNodCd, String toNodCd, String viaNodCd, String dorNodCd, String ttlDist, String lnkDistDivCd, String ttlPvndrSeq, String ttlPvndrNm) {
		this.ctrtTpNm = ctrtTpNm;
		this.totKnt = totKnt;
		this.rtAplyDt = rtAplyDt;
		this.svcScpCd = svcScpCd;
		this.inlndCostTrspUsdAmt = inlndCostTrspUsdAmt;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.costMonth = costMonth;
		this.polCd = polCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.ioBndNm = ioBndNm;
		this.invUsdAmt = invUsdAmt;
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
		this.rfaAmdtCreDt = rfaAmdtCreDt;
		this.bkg20ftCntrQty = bkg20ftCntrQty;
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
		this.costFullPlRsltCd = costFullPlRsltCd;
		this.porCd = porCd;
		this.splitFlg = splitFlg;
		this.glineFrtRtAmt = glineFrtRtAmt;
		this.inlndCostUsdAmt = inlndCostUsdAmt;
		this.plInlndCostUsdAmt = plInlndCostUsdAmt;
		this.ctrtEffDt = ctrtEffDt;
		this.custNm = custNm;
		this.xInvUsdAmt = xInvUsdAmt;
		this.vslSlanCd = vslSlanCd;
		this.woOfcCd = woOfcCd;
		this.custSegmCd = custSegmCd;
		this.plInvUsdAmt = plInvUsdAmt;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.ihcPlRsltNm = ihcPlRsltNm;
		this.ctrtExpDt = ctrtExpDt;
		this.bkg40ftCntrQty = bkg40ftCntrQty;
		this.woPlRsltNm = woPlRsltNm;
		this.costYear = costYear;
		this.yInvUsdAmt = yInvUsdAmt;
		this.ihcPlRsltCd = ihcPlRsltCd;
		this.costTtlPlRsltCd = costTtlPlRsltCd;
		this.plInlndCostTrspUsdAmt = plInlndCostTrspUsdAmt;
		this.woCntrQty = woCntrQty;
		this.ioBndCd = ioBndCd;
		this.cmdtNm = cmdtNm;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.inlndRevTpCd = inlndRevTpCd;
		this.bkgMrgFlg = bkgMrgFlg;
		this.costWeek = costWeek;
		this.inlndRevTpNm = inlndRevTpNm;
		this.bkgCntrQty = bkgCntrQty;
		this.fmNodCd = fmNodCd;
		this.toNodCd = toNodCd;
		this.viaNodCd = viaNodCd;
		this.dorNodCd = dorNodCd;
		this.ttlDist = ttlDist;
		this.lnkDistDivCd = lnkDistDivCd;
		this.ttlPvndrSeq = ttlPvndrSeq;
		this.ttlPvndrNm = ttlPvndrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_tp_nm", getCtrtTpNm());
		this.hashColumns.put("tot_knt", getTotKnt());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("inlnd_cost_trsp_usd_amt", getInlndCostTrspUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("cost_month", getCostMonth());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("io_bnd_nm", getIoBndNm());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
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
		this.hashColumns.put("rfa_amdt_cre_dt", getRfaAmdtCreDt());
		this.hashColumns.put("bkg_20ft_cntr_qty", getBkg20ftCntrQty());
		this.hashColumns.put("prc_ctrt_cust_tp_nm", getPrcCtrtCustTpNm());
		this.hashColumns.put("cost_full_pl_rslt_cd", getCostFullPlRsltCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("gline_frt_rt_amt", getGlineFrtRtAmt());
		this.hashColumns.put("inlnd_cost_usd_amt", getInlndCostUsdAmt());
		this.hashColumns.put("pl_inlnd_cost_usd_amt", getPlInlndCostUsdAmt());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("x_inv_usd_amt", getXInvUsdAmt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("cust_segm_cd", getCustSegmCd());
		this.hashColumns.put("pl_inv_usd_amt", getPlInvUsdAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("ihc_pl_rslt_nm", getIhcPlRsltNm());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("bkg_40ft_cntr_qty", getBkg40ftCntrQty());
		this.hashColumns.put("wo_pl_rslt_nm", getWoPlRsltNm());
		this.hashColumns.put("cost_year", getCostYear());
		this.hashColumns.put("y_inv_usd_amt", getYInvUsdAmt());
		this.hashColumns.put("ihc_pl_rslt_cd", getIhcPlRsltCd());
		this.hashColumns.put("cost_ttl_pl_rslt_cd", getCostTtlPlRsltCd());
		this.hashColumns.put("pl_inlnd_cost_trsp_usd_amt", getPlInlndCostTrspUsdAmt());
		this.hashColumns.put("wo_cntr_qty", getWoCntrQty());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("inlnd_rev_tp_cd", getInlndRevTpCd());
		this.hashColumns.put("bkg_mrg_flg", getBkgMrgFlg());
		this.hashColumns.put("cost_week", getCostWeek());
		this.hashColumns.put("inlnd_rev_tp_nm", getInlndRevTpNm());
		this.hashColumns.put("bkg_cntr_qty", getBkgCntrQty());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("ttl_dist", getTtlDist());
		this.hashColumns.put("lnk_dist_div_cd", getLnkDistDivCd());
		this.hashColumns.put("ttl_pvndr_seq", getTtlPvndrSeq());
		this.hashColumns.put("ttl_pvndr_nm", getTtlPvndrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_tp_nm", "ctrtTpNm");
		this.hashFields.put("tot_knt", "totKnt");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("inlnd_cost_trsp_usd_amt", "inlndCostTrspUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("cost_month", "costMonth");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("io_bnd_nm", "ioBndNm");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
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
		this.hashFields.put("rfa_amdt_cre_dt", "rfaAmdtCreDt");
		this.hashFields.put("bkg_20ft_cntr_qty", "bkg20ftCntrQty");
		this.hashFields.put("prc_ctrt_cust_tp_nm", "prcCtrtCustTpNm");
		this.hashFields.put("cost_full_pl_rslt_cd", "costFullPlRsltCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("gline_frt_rt_amt", "glineFrtRtAmt");
		this.hashFields.put("inlnd_cost_usd_amt", "inlndCostUsdAmt");
		this.hashFields.put("pl_inlnd_cost_usd_amt", "plInlndCostUsdAmt");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("x_inv_usd_amt", "xInvUsdAmt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("cust_segm_cd", "custSegmCd");
		this.hashFields.put("pl_inv_usd_amt", "plInvUsdAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("ihc_pl_rslt_nm", "ihcPlRsltNm");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("bkg_40ft_cntr_qty", "bkg40ftCntrQty");
		this.hashFields.put("wo_pl_rslt_nm", "woPlRsltNm");
		this.hashFields.put("cost_year", "costYear");
		this.hashFields.put("y_inv_usd_amt", "yInvUsdAmt");
		this.hashFields.put("ihc_pl_rslt_cd", "ihcPlRsltCd");
		this.hashFields.put("cost_ttl_pl_rslt_cd", "costTtlPlRsltCd");
		this.hashFields.put("pl_inlnd_cost_trsp_usd_amt", "plInlndCostTrspUsdAmt");
		this.hashFields.put("wo_cntr_qty", "woCntrQty");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("inlnd_rev_tp_cd", "inlndRevTpCd");
		this.hashFields.put("bkg_mrg_flg", "bkgMrgFlg");
		this.hashFields.put("cost_week", "costWeek");
		this.hashFields.put("inlnd_rev_tp_nm", "inlndRevTpNm");
		this.hashFields.put("bkg_cntr_qty", "bkgCntrQty");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("ttl_dist", "ttlDist");
		this.hashFields.put("lnk_dist_div_cd", "lnkDistDivCd");
		this.hashFields.put("ttl_pvndr_seq", "ttlPvndrSeq");
		this.hashFields.put("ttl_pvndr_nm", "ttlPvndrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtTpNm
	 */
	public String getCtrtTpNm() {
		return this.ctrtTpNm;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
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
	 * @return rfaAmdtCreDt
	 */
	public String getRfaAmdtCreDt() {
		return this.rfaAmdtCreDt;
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
	 * @return plInlndCostUsdAmt
	 */
	public String getPlInlndCostUsdAmt() {
		return this.plInlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
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
	 * @return xInvUsdAmt
	 */
	public String getXInvUsdAmt() {
		return this.xInvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return custSegmCd
	 */
	public String getCustSegmCd() {
		return this.custSegmCd;
	}
	
	/**
	 * Column Info
	 * @return plInvUsdAmt
	 */
	public String getPlInvUsdAmt() {
		return this.plInvUsdAmt;
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
	 * @return ihcPlRsltNm
	 */
	public String getIhcPlRsltNm() {
		return this.ihcPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
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
	 * @return yInvUsdAmt
	 */
	public String getYInvUsdAmt() {
		return this.yInvUsdAmt;
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
	 * @return costTtlPlRsltCd
	 */
	public String getCostTtlPlRsltCd() {
		return this.costTtlPlRsltCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return ttlDist
	 */
	public String getTtlDist() {
		return this.ttlDist;
	}
	
	/**
	 * Column Info
	 * @return lnkDistDivCd
	 */
	public String getLnkDistDivCd() {
		return this.lnkDistDivCd;
	}
	
	/**
	 * Column Info
	 * @return ttlPvndrSeq
	 */
	public String getTtlPvndrSeq() {
		return this.ttlPvndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlPvndrNm
	 */
	public String getTtlPvndrNm() {
		return this.ttlPvndrNm;
	}
	
	

	/**
	 * Column Info
	 * @param ctrtTpNm
	 */
	public void setCtrtTpNm(String ctrtTpNm) {
		this.ctrtTpNm = ctrtTpNm;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
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
	 * @param rfaAmdtCreDt
	 */
	public void setRfaAmdtCreDt(String rfaAmdtCreDt) {
		this.rfaAmdtCreDt = rfaAmdtCreDt;
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
	 * @param plInlndCostUsdAmt
	 */
	public void setPlInlndCostUsdAmt(String plInlndCostUsdAmt) {
		this.plInlndCostUsdAmt = plInlndCostUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
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
	 * @param xInvUsdAmt
	 */
	public void setXInvUsdAmt(String xInvUsdAmt) {
		this.xInvUsdAmt = xInvUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param custSegmCd
	 */
	public void setCustSegmCd(String custSegmCd) {
		this.custSegmCd = custSegmCd;
	}
	
	/**
	 * Column Info
	 * @param plInvUsdAmt
	 */
	public void setPlInvUsdAmt(String plInvUsdAmt) {
		this.plInvUsdAmt = plInvUsdAmt;
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
	 * @param ihcPlRsltNm
	 */
	public void setIhcPlRsltNm(String ihcPlRsltNm) {
		this.ihcPlRsltNm = ihcPlRsltNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
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
	 * @param yInvUsdAmt
	 */
	public void setYInvUsdAmt(String yInvUsdAmt) {
		this.yInvUsdAmt = yInvUsdAmt;
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
	 * @param costTtlPlRsltCd
	 */
	public void setCostTtlPlRsltCd(String costTtlPlRsltCd) {
		this.costTtlPlRsltCd = costTtlPlRsltCd;
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
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCntrQty
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param ttlDist
	 */
	public void setTtlDist(String ttlDist) {
		this.ttlDist = ttlDist;
	}
	
	/**
	 * Column Info
	 * @param bkgCntrQty
	 */
	public void setLnkDistDivCd(String lnkDistDivCd) {
		this.lnkDistDivCd = lnkDistDivCd;
	}
	
	/**
	 * Column Info
	 * @param ttlPvndrSeq
	 */
	public void setTtlPvndrSeq(String ttlPvndrSeq) {
		this.ttlPvndrSeq = ttlPvndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlPvndrNm
	 */
	public void setTtlPvndrNm(String ttlPvndrNm) {
		this.ttlPvndrNm = ttlPvndrNm;
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
		setCtrtTpNm(JSPUtil.getParameter(request, prefix + "ctrt_tp_nm", ""));
		setTotKnt(JSPUtil.getParameter(request, prefix + "tot_knt", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setInlndCostTrspUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_trsp_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setCostMonth(JSPUtil.getParameter(request, prefix + "cost_month", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setIoBndNm(JSPUtil.getParameter(request, prefix + "io_bnd_nm", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
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
		setRfaAmdtCreDt(JSPUtil.getParameter(request, prefix + "rfa_amdt_cre_dt", ""));
		setBkg20ftCntrQty(JSPUtil.getParameter(request, prefix + "bkg_20ft_cntr_qty", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_nm", ""));
		setCostFullPlRsltCd(JSPUtil.getParameter(request, prefix + "cost_full_pl_rslt_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setGlineFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_frt_rt_amt", ""));
		setInlndCostUsdAmt(JSPUtil.getParameter(request, prefix + "inlnd_cost_usd_amt", ""));
		setPlInlndCostUsdAmt(JSPUtil.getParameter(request, prefix + "pl_inlnd_cost_usd_amt", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setXInvUsdAmt(JSPUtil.getParameter(request, prefix + "x_inv_usd_amt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setCustSegmCd(JSPUtil.getParameter(request, prefix + "cust_segm_cd", ""));
		setPlInvUsdAmt(JSPUtil.getParameter(request, prefix + "pl_inv_usd_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setIhcPlRsltNm(JSPUtil.getParameter(request, prefix + "ihc_pl_rslt_nm", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setBkg40ftCntrQty(JSPUtil.getParameter(request, prefix + "bkg_40ft_cntr_qty", ""));
		setWoPlRsltNm(JSPUtil.getParameter(request, prefix + "wo_pl_rslt_nm", ""));
		setCostYear(JSPUtil.getParameter(request, prefix + "cost_year", ""));
		setYInvUsdAmt(JSPUtil.getParameter(request, prefix + "y_inv_usd_amt", ""));
		setIhcPlRsltCd(JSPUtil.getParameter(request, prefix + "ihc_pl_rslt_cd", ""));
		setCostTtlPlRsltCd(JSPUtil.getParameter(request, prefix + "cost_ttl_pl_rslt_cd", ""));
		setPlInlndCostTrspUsdAmt(JSPUtil.getParameter(request, prefix + "pl_inlnd_cost_trsp_usd_amt", ""));
		setWoCntrQty(JSPUtil.getParameter(request, prefix + "wo_cntr_qty", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setInlndRevTpCd(JSPUtil.getParameter(request, prefix + "inlnd_rev_tp_cd", ""));
		setBkgMrgFlg(JSPUtil.getParameter(request, prefix + "bkg_mrg_flg", ""));
		setCostWeek(JSPUtil.getParameter(request, prefix + "cost_week", ""));
		setInlndRevTpNm(JSPUtil.getParameter(request, prefix + "inlnd_rev_tp_nm", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "bkg_cntr_qty", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "ttl_dist", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "lnk_dist_div_cd", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "ttl_pvndr_seq", ""));
		setBkgCntrQty(JSPUtil.getParameter(request, prefix + "ttl_pvndr_nm", ""));
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
			String[] ctrtTpNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp_nm", length));
			String[] totKnt = (JSPUtil.getParameter(request, prefix	+ "tot_knt", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] inlndCostTrspUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_trsp_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] costMonth = (JSPUtil.getParameter(request, prefix	+ "cost_month", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] ioBndNm = (JSPUtil.getParameter(request, prefix	+ "io_bnd_nm", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
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
			String[] rfaAmdtCreDt = (JSPUtil.getParameter(request, prefix	+ "rfa_amdt_cre_dt", length));
			String[] bkg20ftCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_20ft_cntr_qty", length));
			String[] prcCtrtCustTpNm = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_nm", length));
			String[] costFullPlRsltCd = (JSPUtil.getParameter(request, prefix	+ "cost_full_pl_rslt_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] glineFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_frt_rt_amt", length));
			String[] inlndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_cost_usd_amt", length));
			String[] plInlndCostUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_inlnd_cost_usd_amt", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] xInvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "x_inv_usd_amt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] custSegmCd = (JSPUtil.getParameter(request, prefix	+ "cust_segm_cd", length));
			String[] plInvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_inv_usd_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] ihcPlRsltNm = (JSPUtil.getParameter(request, prefix	+ "ihc_pl_rslt_nm", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] bkg40ftCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_40ft_cntr_qty", length));
			String[] woPlRsltNm = (JSPUtil.getParameter(request, prefix	+ "wo_pl_rslt_nm", length));
			String[] costYear = (JSPUtil.getParameter(request, prefix	+ "cost_year", length));
			String[] yInvUsdAmt = (JSPUtil.getParameter(request, prefix	+ "y_inv_usd_amt", length));
			String[] ihcPlRsltCd = (JSPUtil.getParameter(request, prefix	+ "ihc_pl_rslt_cd", length));
			String[] costTtlPlRsltCd = (JSPUtil.getParameter(request, prefix	+ "cost_ttl_pl_rslt_cd", length));
			String[] plInlndCostTrspUsdAmt = (JSPUtil.getParameter(request, prefix	+ "pl_inlnd_cost_trsp_usd_amt", length));
			String[] woCntrQty = (JSPUtil.getParameter(request, prefix	+ "wo_cntr_qty", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] inlndRevTpCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rev_tp_cd", length));
			String[] bkgMrgFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_mrg_flg", length));
			String[] costWeek = (JSPUtil.getParameter(request, prefix	+ "cost_week", length));
			String[] inlndRevTpNm = (JSPUtil.getParameter(request, prefix	+ "inlnd_rev_tp_nm", length));
			String[] bkgCntrQty = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_qty", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] ttlDist = (JSPUtil.getParameter(request, prefix	+ "ttl_dist", length));
			String[] lnkDistDivCd = (JSPUtil.getParameter(request, prefix	+ "lnk_dist_div_cd", length));
			String[] ttlPvndrSeq = (JSPUtil.getParameter(request, prefix	+ "ttl_pvndr_seq", length));
			String[] ttlPvndrNm = (JSPUtil.getParameter(request, prefix	+ "ttl_pvndr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new PnLBkgListVO();
				if (ctrtTpNm[i] != null)
					model.setCtrtTpNm(ctrtTpNm[i]);
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
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
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
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
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
				if (rfaAmdtCreDt[i] != null)
					model.setRfaAmdtCreDt(rfaAmdtCreDt[i]);
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
				if (plInlndCostUsdAmt[i] != null)
					model.setPlInlndCostUsdAmt(plInlndCostUsdAmt[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (xInvUsdAmt[i] != null)
					model.setXInvUsdAmt(xInvUsdAmt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (custSegmCd[i] != null)
					model.setCustSegmCd(custSegmCd[i]);
				if (plInvUsdAmt[i] != null)
					model.setPlInvUsdAmt(plInvUsdAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (ihcPlRsltNm[i] != null)
					model.setIhcPlRsltNm(ihcPlRsltNm[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (bkg40ftCntrQty[i] != null)
					model.setBkg40ftCntrQty(bkg40ftCntrQty[i]);
				if (woPlRsltNm[i] != null)
					model.setWoPlRsltNm(woPlRsltNm[i]);
				if (costYear[i] != null)
					model.setCostYear(costYear[i]);
				if (yInvUsdAmt[i] != null)
					model.setYInvUsdAmt(yInvUsdAmt[i]);
				if (ihcPlRsltCd[i] != null)
					model.setIhcPlRsltCd(ihcPlRsltCd[i]);
				if (costTtlPlRsltCd[i] != null)
					model.setCostTtlPlRsltCd(costTtlPlRsltCd[i]);
				if (plInlndCostTrspUsdAmt[i] != null)
					model.setPlInlndCostTrspUsdAmt(plInlndCostTrspUsdAmt[i]);
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
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (ttlDist[i] != null)
					model.setTtlDist(ttlDist[i]);
				if (lnkDistDivCd[i] != null)
					model.setLnkDistDivCd(lnkDistDivCd[i]);
				if (ttlPvndrSeq[i] != null)
					model.setTtlPvndrSeq(ttlPvndrSeq[i]);
				if (ttlPvndrNm[i] != null)
					model.setTtlPvndrNm(ttlPvndrNm[i]);
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
		this.ctrtTpNm = this.ctrtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totKnt = this.totKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostTrspUsdAmt = this.inlndCostTrspUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMonth = this.costMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndNm = this.ioBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.rfaAmdtCreDt = this.rfaAmdtCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20ftCntrQty = this.bkg20ftCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm = this.prcCtrtCustTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costFullPlRsltCd = this.costFullPlRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineFrtRtAmt = this.glineFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndCostUsdAmt = this.inlndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInlndCostUsdAmt = this.plInlndCostUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xInvUsdAmt = this.xInvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSegmCd = this.custSegmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInvUsdAmt = this.plInvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcPlRsltNm = this.ihcPlRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40ftCntrQty = this.bkg40ftCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woPlRsltNm = this.woPlRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYear = this.costYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yInvUsdAmt = this.yInvUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcPlRsltCd = this.ihcPlRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTtlPlRsltCd = this.costTtlPlRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plInlndCostTrspUsdAmt = this.plInlndCostTrspUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCntrQty = this.woCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRevTpCd = this.inlndRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMrgFlg = this.bkgMrgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWeek = this.costWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRevTpNm = this.inlndRevTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrQty = this.bkgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDist = this.ttlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDistDivCd = this.lnkDistDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPvndrSeq = this.ttlPvndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPvndrNm = this.ttlPvndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
