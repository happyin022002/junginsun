/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchResultContainerTPSZListVO.java
*@FileTitle : SearchAccrualBatchResultContainerTPSZListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchResultContainerTPSZListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchResultContainerTPSZListVO> models = new ArrayList<SearchAccrualBatchResultContainerTPSZListVO>();
	
	/* Column Info */
	private String actCntrCostAmt = null;
	/* Column Info */
	private String acclLgcTpCd = null;
	/* Column Info */
	private String actComVvdCostAmt = null;
	/* Column Info */
	private String actInvKnt = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actEtcCostAmt = null;
	/* Column Info */
	private String frmVvdNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtRtnFlg = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String aaaa = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String confirmedCostAmt = null;
	/* Column Info */
	private String actRevVvdCostAmt = null;
	/* Column Info */
	private String costAssBseCd = null;
	/* Column Info */
	private String n2ndNodCd = null;
	/* Column Info */
	private String acclCostAmt = null;
	/* Column Info */
	private String frmBkgNo = null;
	/* Column Info */
	private String ttlInvKnt = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String frmRevYrmon = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String frmAcctCd = null;
	/* Column Info */
	private String actBkgCostAmt = null;
	/* Column Info */
	private String actCostAmt = null;
	/* Column Info */
	private String costDiffAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchResultContainerTPSZListVO() {}

	public SearchAccrualBatchResultContainerTPSZListVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String aaaa, String costActGrpSeq, String n1stNodCd, String n2ndNodCd, String acctCd, String lgsCostCd, String acclLgcTpCd, String costAssBseCd, String ctrtRtnFlg, String estmCostAmt, String actCntrCostAmt, String actBkgCostAmt, String actRevVvdCostAmt, String actComVvdCostAmt, String actEtcCostAmt, String actCostAmt, String acclCostAmt, String actInvKnt, String ttlInvKnt, String confirmedCostAmt, String costDiffAmt, String frmRevYrmon, String frmAcctCd, String frmVvdNo, String frmBkgNo) {
		this.actCntrCostAmt = actCntrCostAmt;
		this.acclLgcTpCd = acclLgcTpCd;
		this.actComVvdCostAmt = actComVvdCostAmt;
		this.actInvKnt = actInvKnt;
		this.estmCostAmt = estmCostAmt;
		this.pagerows = pagerows;
		this.actEtcCostAmt = actEtcCostAmt;
		this.frmVvdNo = frmVvdNo;
		this.ibflag = ibflag;
		this.ctrtRtnFlg = ctrtRtnFlg;
		this.acctCd = acctCd;
		this.aaaa = aaaa;
		this.cntrTpszCd = cntrTpszCd;
		this.confirmedCostAmt = confirmedCostAmt;
		this.actRevVvdCostAmt = actRevVvdCostAmt;
		this.costAssBseCd = costAssBseCd;
		this.n2ndNodCd = n2ndNodCd;
		this.acclCostAmt = acclCostAmt;
		this.frmBkgNo = frmBkgNo;
		this.ttlInvKnt = ttlInvKnt;
		this.n1stNodCd = n1stNodCd;
		this.costActGrpSeq = costActGrpSeq;
		this.frmRevYrmon = frmRevYrmon;
		this.cntrNo = cntrNo;
		this.lgsCostCd = lgsCostCd;
		this.frmAcctCd = frmAcctCd;
		this.actBkgCostAmt = actBkgCostAmt;
		this.actCostAmt = actCostAmt;
		this.costDiffAmt = costDiffAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_cntr_cost_amt", getActCntrCostAmt());
		this.hashColumns.put("accl_lgc_tp_cd", getAcclLgcTpCd());
		this.hashColumns.put("act_com_vvd_cost_amt", getActComVvdCostAmt());
		this.hashColumns.put("act_inv_knt", getActInvKnt());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_etc_cost_amt", getActEtcCostAmt());
		this.hashColumns.put("frm_vvd_no", getFrmVvdNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_rtn_flg", getCtrtRtnFlg());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("aaaa", getAaaa());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("confirmed_cost_amt", getConfirmedCostAmt());
		this.hashColumns.put("act_rev_vvd_cost_amt", getActRevVvdCostAmt());
		this.hashColumns.put("cost_ass_bse_cd", getCostAssBseCd());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("accl_cost_amt", getAcclCostAmt());
		this.hashColumns.put("frm_bkg_no", getFrmBkgNo());
		this.hashColumns.put("ttl_inv_knt", getTtlInvKnt());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("frm_rev_yrmon", getFrmRevYrmon());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("frm_acct_cd", getFrmAcctCd());
		this.hashColumns.put("act_bkg_cost_amt", getActBkgCostAmt());
		this.hashColumns.put("act_cost_amt", getActCostAmt());
		this.hashColumns.put("cost_diff_amt", getCostDiffAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_cntr_cost_amt", "actCntrCostAmt");
		this.hashFields.put("accl_lgc_tp_cd", "acclLgcTpCd");
		this.hashFields.put("act_com_vvd_cost_amt", "actComVvdCostAmt");
		this.hashFields.put("act_inv_knt", "actInvKnt");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_etc_cost_amt", "actEtcCostAmt");
		this.hashFields.put("frm_vvd_no", "frmVvdNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_rtn_flg", "ctrtRtnFlg");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("aaaa", "aaaa");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("confirmed_cost_amt", "confirmedCostAmt");
		this.hashFields.put("act_rev_vvd_cost_amt", "actRevVvdCostAmt");
		this.hashFields.put("cost_ass_bse_cd", "costAssBseCd");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("accl_cost_amt", "acclCostAmt");
		this.hashFields.put("frm_bkg_no", "frmBkgNo");
		this.hashFields.put("ttl_inv_knt", "ttlInvKnt");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("frm_rev_yrmon", "frmRevYrmon");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("frm_acct_cd", "frmAcctCd");
		this.hashFields.put("act_bkg_cost_amt", "actBkgCostAmt");
		this.hashFields.put("act_cost_amt", "actCostAmt");
		this.hashFields.put("cost_diff_amt", "costDiffAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actCntrCostAmt
	 */
	public String getActCntrCostAmt() {
		return this.actCntrCostAmt;
	}
	
	/**
	 * Column Info
	 * @return acclLgcTpCd
	 */
	public String getAcclLgcTpCd() {
		return this.acclLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @return actComVvdCostAmt
	 */
	public String getActComVvdCostAmt() {
		return this.actComVvdCostAmt;
	}
	
	/**
	 * Column Info
	 * @return actInvKnt
	 */
	public String getActInvKnt() {
		return this.actInvKnt;
	}
	
	/**
	 * Column Info
	 * @return estmCostAmt
	 */
	public String getEstmCostAmt() {
		return this.estmCostAmt;
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
	 * @return actEtcCostAmt
	 */
	public String getActEtcCostAmt() {
		return this.actEtcCostAmt;
	}
	
	/**
	 * Column Info
	 * @return frmVvdNo
	 */
	public String getFrmVvdNo() {
		return this.frmVvdNo;
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
	 * @return ctrtRtnFlg
	 */
	public String getCtrtRtnFlg() {
		return this.ctrtRtnFlg;
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
	 * @return aaaa
	 */
	public String getAaaa() {
		return this.aaaa;
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
	 * @return confirmedCostAmt
	 */
	public String getConfirmedCostAmt() {
		return this.confirmedCostAmt;
	}
	
	/**
	 * Column Info
	 * @return actRevVvdCostAmt
	 */
	public String getActRevVvdCostAmt() {
		return this.actRevVvdCostAmt;
	}
	
	/**
	 * Column Info
	 * @return costAssBseCd
	 */
	public String getCostAssBseCd() {
		return this.costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndNodCd
	 */
	public String getN2ndNodCd() {
		return this.n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @return acclCostAmt
	 */
	public String getAcclCostAmt() {
		return this.acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @return frmBkgNo
	 */
	public String getFrmBkgNo() {
		return this.frmBkgNo;
	}
	
	/**
	 * Column Info
	 * @return ttlInvKnt
	 */
	public String getTtlInvKnt() {
		return this.ttlInvKnt;
	}
	
	/**
	 * Column Info
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return frmRevYrmon
	 */
	public String getFrmRevYrmon() {
		return this.frmRevYrmon;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return frmAcctCd
	 */
	public String getFrmAcctCd() {
		return this.frmAcctCd;
	}
	
	/**
	 * Column Info
	 * @return actBkgCostAmt
	 */
	public String getActBkgCostAmt() {
		return this.actBkgCostAmt;
	}
	
	/**
	 * Column Info
	 * @return actCostAmt
	 */
	public String getActCostAmt() {
		return this.actCostAmt;
	}
	
	/**
	 * Column Info
	 * @return costDiffAmt
	 */
	public String getCostDiffAmt() {
		return this.costDiffAmt;
	}
	

	/**
	 * Column Info
	 * @param actCntrCostAmt
	 */
	public void setActCntrCostAmt(String actCntrCostAmt) {
		this.actCntrCostAmt = actCntrCostAmt;
	}
	
	/**
	 * Column Info
	 * @param acclLgcTpCd
	 */
	public void setAcclLgcTpCd(String acclLgcTpCd) {
		this.acclLgcTpCd = acclLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @param actComVvdCostAmt
	 */
	public void setActComVvdCostAmt(String actComVvdCostAmt) {
		this.actComVvdCostAmt = actComVvdCostAmt;
	}
	
	/**
	 * Column Info
	 * @param actInvKnt
	 */
	public void setActInvKnt(String actInvKnt) {
		this.actInvKnt = actInvKnt;
	}
	
	/**
	 * Column Info
	 * @param estmCostAmt
	 */
	public void setEstmCostAmt(String estmCostAmt) {
		this.estmCostAmt = estmCostAmt;
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
	 * @param actEtcCostAmt
	 */
	public void setActEtcCostAmt(String actEtcCostAmt) {
		this.actEtcCostAmt = actEtcCostAmt;
	}
	
	/**
	 * Column Info
	 * @param frmVvdNo
	 */
	public void setFrmVvdNo(String frmVvdNo) {
		this.frmVvdNo = frmVvdNo;
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
	 * @param ctrtRtnFlg
	 */
	public void setCtrtRtnFlg(String ctrtRtnFlg) {
		this.ctrtRtnFlg = ctrtRtnFlg;
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
	 * @param aaaa
	 */
	public void setAaaa(String aaaa) {
		this.aaaa = aaaa;
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
	 * @param confirmedCostAmt
	 */
	public void setConfirmedCostAmt(String confirmedCostAmt) {
		this.confirmedCostAmt = confirmedCostAmt;
	}
	
	/**
	 * Column Info
	 * @param actRevVvdCostAmt
	 */
	public void setActRevVvdCostAmt(String actRevVvdCostAmt) {
		this.actRevVvdCostAmt = actRevVvdCostAmt;
	}
	
	/**
	 * Column Info
	 * @param costAssBseCd
	 */
	public void setCostAssBseCd(String costAssBseCd) {
		this.costAssBseCd = costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndNodCd
	 */
	public void setN2ndNodCd(String n2ndNodCd) {
		this.n2ndNodCd = n2ndNodCd;
	}
	
	/**
	 * Column Info
	 * @param acclCostAmt
	 */
	public void setAcclCostAmt(String acclCostAmt) {
		this.acclCostAmt = acclCostAmt;
	}
	
	/**
	 * Column Info
	 * @param frmBkgNo
	 */
	public void setFrmBkgNo(String frmBkgNo) {
		this.frmBkgNo = frmBkgNo;
	}
	
	/**
	 * Column Info
	 * @param ttlInvKnt
	 */
	public void setTtlInvKnt(String ttlInvKnt) {
		this.ttlInvKnt = ttlInvKnt;
	}
	
	/**
	 * Column Info
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
	}
	
	/**
	 * Column Info
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param frmRevYrmon
	 */
	public void setFrmRevYrmon(String frmRevYrmon) {
		this.frmRevYrmon = frmRevYrmon;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param frmAcctCd
	 */
	public void setFrmAcctCd(String frmAcctCd) {
		this.frmAcctCd = frmAcctCd;
	}
	
	/**
	 * Column Info
	 * @param actBkgCostAmt
	 */
	public void setActBkgCostAmt(String actBkgCostAmt) {
		this.actBkgCostAmt = actBkgCostAmt;
	}
	
	/**
	 * Column Info
	 * @param actCostAmt
	 */
	public void setActCostAmt(String actCostAmt) {
		this.actCostAmt = actCostAmt;
	}
	
	/**
	 * Column Info
	 * @param costDiffAmt
	 */
	public void setCostDiffAmt(String costDiffAmt) {
		this.costDiffAmt = costDiffAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActCntrCostAmt(JSPUtil.getParameter(request, "act_cntr_cost_amt", ""));
		setAcclLgcTpCd(JSPUtil.getParameter(request, "accl_lgc_tp_cd", ""));
		setActComVvdCostAmt(JSPUtil.getParameter(request, "act_com_vvd_cost_amt", ""));
		setActInvKnt(JSPUtil.getParameter(request, "act_inv_knt", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, "estm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActEtcCostAmt(JSPUtil.getParameter(request, "act_etc_cost_amt", ""));
		setFrmVvdNo(JSPUtil.getParameter(request, "frm_vvd_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtRtnFlg(JSPUtil.getParameter(request, "ctrt_rtn_flg", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setAaaa(JSPUtil.getParameter(request, "aaaa", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setConfirmedCostAmt(JSPUtil.getParameter(request, "confirmed_cost_amt", ""));
		setActRevVvdCostAmt(JSPUtil.getParameter(request, "act_rev_vvd_cost_amt", ""));
		setCostAssBseCd(JSPUtil.getParameter(request, "cost_ass_bse_cd", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, "n2nd_nod_cd", ""));
		setAcclCostAmt(JSPUtil.getParameter(request, "accl_cost_amt", ""));
		setFrmBkgNo(JSPUtil.getParameter(request, "frm_bkg_no", ""));
		setTtlInvKnt(JSPUtil.getParameter(request, "ttl_inv_knt", ""));
		setN1stNodCd(JSPUtil.getParameter(request, "n1st_nod_cd", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, "cost_act_grp_seq", ""));
		setFrmRevYrmon(JSPUtil.getParameter(request, "frm_rev_yrmon", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setFrmAcctCd(JSPUtil.getParameter(request, "frm_acct_cd", ""));
		setActBkgCostAmt(JSPUtil.getParameter(request, "act_bkg_cost_amt", ""));
		setActCostAmt(JSPUtil.getParameter(request, "act_cost_amt", ""));
		setCostDiffAmt(JSPUtil.getParameter(request, "cost_diff_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchResultContainerTPSZListVO[]
	 */
	public SearchAccrualBatchResultContainerTPSZListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchResultContainerTPSZListVO[]
	 */
	public SearchAccrualBatchResultContainerTPSZListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchResultContainerTPSZListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actCntrCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_cntr_cost_amt", length));
			String[] acclLgcTpCd = (JSPUtil.getParameter(request, prefix	+ "accl_lgc_tp_cd", length));
			String[] actComVvdCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_com_vvd_cost_amt", length));
			String[] actInvKnt = (JSPUtil.getParameter(request, prefix	+ "act_inv_knt", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actEtcCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_etc_cost_amt", length));
			String[] frmVvdNo = (JSPUtil.getParameter(request, prefix	+ "frm_vvd_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtRtnFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_rtn_flg", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] aaaa = (JSPUtil.getParameter(request, prefix	+ "aaaa", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] confirmedCostAmt = (JSPUtil.getParameter(request, prefix	+ "confirmed_cost_amt", length));
			String[] actRevVvdCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_rev_vvd_cost_amt", length));
			String[] costAssBseCd = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_cd", length));
			String[] n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] acclCostAmt = (JSPUtil.getParameter(request, prefix	+ "accl_cost_amt", length));
			String[] frmBkgNo = (JSPUtil.getParameter(request, prefix	+ "frm_bkg_no", length));
			String[] ttlInvKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_inv_knt", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] frmRevYrmon = (JSPUtil.getParameter(request, prefix	+ "frm_rev_yrmon", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] frmAcctCd = (JSPUtil.getParameter(request, prefix	+ "frm_acct_cd", length));
			String[] actBkgCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_bkg_cost_amt", length));
			String[] actCostAmt = (JSPUtil.getParameter(request, prefix	+ "act_cost_amt", length));
			String[] costDiffAmt = (JSPUtil.getParameter(request, prefix	+ "cost_diff_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchResultContainerTPSZListVO();
				if (actCntrCostAmt[i] != null)
					model.setActCntrCostAmt(actCntrCostAmt[i]);
				if (acclLgcTpCd[i] != null)
					model.setAcclLgcTpCd(acclLgcTpCd[i]);
				if (actComVvdCostAmt[i] != null)
					model.setActComVvdCostAmt(actComVvdCostAmt[i]);
				if (actInvKnt[i] != null)
					model.setActInvKnt(actInvKnt[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actEtcCostAmt[i] != null)
					model.setActEtcCostAmt(actEtcCostAmt[i]);
				if (frmVvdNo[i] != null)
					model.setFrmVvdNo(frmVvdNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtRtnFlg[i] != null)
					model.setCtrtRtnFlg(ctrtRtnFlg[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (aaaa[i] != null)
					model.setAaaa(aaaa[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (confirmedCostAmt[i] != null)
					model.setConfirmedCostAmt(confirmedCostAmt[i]);
				if (actRevVvdCostAmt[i] != null)
					model.setActRevVvdCostAmt(actRevVvdCostAmt[i]);
				if (costAssBseCd[i] != null)
					model.setCostAssBseCd(costAssBseCd[i]);
				if (n2ndNodCd[i] != null)
					model.setN2ndNodCd(n2ndNodCd[i]);
				if (acclCostAmt[i] != null)
					model.setAcclCostAmt(acclCostAmt[i]);
				if (frmBkgNo[i] != null)
					model.setFrmBkgNo(frmBkgNo[i]);
				if (ttlInvKnt[i] != null)
					model.setTtlInvKnt(ttlInvKnt[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (frmRevYrmon[i] != null)
					model.setFrmRevYrmon(frmRevYrmon[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (frmAcctCd[i] != null)
					model.setFrmAcctCd(frmAcctCd[i]);
				if (actBkgCostAmt[i] != null)
					model.setActBkgCostAmt(actBkgCostAmt[i]);
				if (actCostAmt[i] != null)
					model.setActCostAmt(actCostAmt[i]);
				if (costDiffAmt[i] != null)
					model.setCostDiffAmt(costDiffAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchResultContainerTPSZListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchResultContainerTPSZListVO[]
	 */
	public SearchAccrualBatchResultContainerTPSZListVO[] getSearchAccrualBatchResultContainerTPSZListVOs(){
		SearchAccrualBatchResultContainerTPSZListVO[] vos = (SearchAccrualBatchResultContainerTPSZListVO[])models.toArray(new SearchAccrualBatchResultContainerTPSZListVO[models.size()]);
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
		this.actCntrCostAmt = this.actCntrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclLgcTpCd = this.acclLgcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actComVvdCostAmt = this.actComVvdCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvKnt = this.actInvKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actEtcCostAmt = this.actEtcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmVvdNo = this.frmVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRtnFlg = this.ctrtRtnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aaaa = this.aaaa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.confirmedCostAmt = this.confirmedCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRevVvdCostAmt = this.actRevVvdCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseCd = this.costAssBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclCostAmt = this.acclCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmBkgNo = this.frmBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlInvKnt = this.ttlInvKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRevYrmon = this.frmRevYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmAcctCd = this.frmAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBkgCostAmt = this.actBkgCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCostAmt = this.actCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDiffAmt = this.costDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
