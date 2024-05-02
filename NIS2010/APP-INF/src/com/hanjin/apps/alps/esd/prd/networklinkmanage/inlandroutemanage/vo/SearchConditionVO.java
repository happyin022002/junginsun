/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchConditionVO.java
*@FileTitle : SearchConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.21 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchConditionVO> models = new ArrayList<SearchConditionVO>();
	
	/* Column Info */
	private String detailOrgIWrsFlCd = null;
	/* Column Info */
	private String prioSeqCombo = null;
	/* Column Info */
	private String toCd = null;
	/* Column Info */
	private String detailOrgIBkgFlg = null;
	/* Column Info */
	private String iRoutDestNodCd = null;
	/* Column Info */
	private String wrsFlg = null;
	/* Column Info */
	private String detailOrgIInv = null;
	/* Column Info */
	private String iMcntrRoutFlg = null;
	/* Column Info */
	private String rBtnNodTyCd = null;
	/* Column Info */
	private String detailOrgIWrsMtCd = null;
	/* Column Info */
	private String iRoutOrgNodCd = null;
	/* Column Info */
	private String iHubSearchGb = null;
	/* Column Info */
	private String iFrontGb = null;
	/* Column Info */
	private String iSelrow = null;
	/* Column Info */
	private String iDelFlg = null;
	/* Column Info */
	private String iUndefineNod = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String iRoutSeq = null;
	/* Column Info */
	private String disableBkgFlg = null;
	/* Column Info */
	private String fromCd = null;
	/* Column Info */
	private String detailOrgIRoutPlnCd = null;
	/* Column Info */
	private String iNewroutecd = null;
	
	private String nodTpCd1 = null;
	
	private String iOrgCd = null;
	
	private String schOptmFlg = null;
	
	public String getRInbound() {
		return rInbound;
	}

	public void setRInbound(String inbound) {
		rInbound = inbound;
	}

	private String iDestCd = null;
	
	private String rInbound = null;
	

	public String getIOrgCd() {
		return iOrgCd;
	}

	public void setIOrgCd(String orgCd) {
		iOrgCd = orgCd;
	}

	public String getIDestCd() {
		return iDestCd;
	}

	public void setIDestCd(String destCd) {
		iDestCd = destCd;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchConditionVO() {}

	public SearchConditionVO(String ibflag, String pagerows, String iRoutOrgNodCd, String iRoutDestNodCd, String iRoutSeq, String iHubSearchGb, String iFrontGb, String iUndefineNod, String iNewroutecd, String iSelrow, String disableBkgFlg, String prioSeqCombo, String detailOrgIInv, String detailOrgIRoutPlnCd, String detailOrgIBkgFlg, String iMcntrRoutFlg, String detailOrgIWrsFlCd, String detailOrgIWrsMtCd, String rBtnNodTyCd, String fromCd, String toCd, String wrsFlg, String iDelFlg,String nodTpCd1,String iOrgCd,String iDestCd,String rInbound, String schOptmFlg) {
		this.detailOrgIWrsFlCd = detailOrgIWrsFlCd;
		this.prioSeqCombo = prioSeqCombo;
		this.toCd = toCd;
		this.detailOrgIBkgFlg = detailOrgIBkgFlg;
		this.iRoutDestNodCd = iRoutDestNodCd;
		this.wrsFlg = wrsFlg;
		this.detailOrgIInv = detailOrgIInv;
		this.iMcntrRoutFlg = iMcntrRoutFlg;
		this.rBtnNodTyCd = rBtnNodTyCd;
		this.detailOrgIWrsMtCd = detailOrgIWrsMtCd;
		this.iRoutOrgNodCd = iRoutOrgNodCd;
		this.iHubSearchGb = iHubSearchGb;
		this.iFrontGb = iFrontGb;
		this.iSelrow = iSelrow;
		this.iDelFlg = iDelFlg;
		this.iUndefineNod = iUndefineNod;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.iRoutSeq = iRoutSeq;
		this.disableBkgFlg = disableBkgFlg;
		this.fromCd = fromCd;
		this.detailOrgIRoutPlnCd = detailOrgIRoutPlnCd;
		this.iNewroutecd = iNewroutecd;
		
		this.nodTpCd1 = nodTpCd1;
		this.iOrgCd = iOrgCd;
		this.iDestCd = iDestCd;
		this.rInbound = rInbound;
		
		this.schOptmFlg = schOptmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("detail_org_i_wrs_fl_cd", getDetailOrgIWrsFlCd());
		this.hashColumns.put("prio_seq_combo", getPrioSeqCombo());
		this.hashColumns.put("to_cd", getToCd());
		this.hashColumns.put("detail_org_i_bkg_flg", getDetailOrgIBkgFlg());
		this.hashColumns.put("i_rout_dest_nod_cd", getIRoutDestNodCd());
		this.hashColumns.put("wrs_flg", getWrsFlg());
		this.hashColumns.put("detail_org_i_inv", getDetailOrgIInv());
		this.hashColumns.put("i_mcntr_rout_flg", getIMcntrRoutFlg());
		this.hashColumns.put("r_btn_nod_ty_cd", getRBtnNodTyCd());
		this.hashColumns.put("detail_org_i_wrs_mt_cd", getDetailOrgIWrsMtCd());
		this.hashColumns.put("i_rout_org_nod_cd", getIRoutOrgNodCd());
		this.hashColumns.put("i_hub_search_gb", getIHubSearchGb());
		this.hashColumns.put("i_front_gb", getIFrontGb());
		this.hashColumns.put("i_selrow", getISelrow());
		this.hashColumns.put("i_del_flg", getIDelFlg());
		this.hashColumns.put("i_undefine_nod", getIUndefineNod());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("i_rout_seq", getIRoutSeq());
		this.hashColumns.put("disable_bkg_flg", getDisableBkgFlg());
		this.hashColumns.put("from_cd", getFromCd());
		this.hashColumns.put("detail_org_i_rout_pln_cd", getDetailOrgIRoutPlnCd());
		this.hashColumns.put("i_newroutecd", getINewroutecd());
		
		this.hashColumns.put("nod_tp_cd1", getNodTpCd1());
		this.hashColumns.put("i_org_cd", getIOrgCd());
		this.hashColumns.put("i_dest_cd", getIDestCd());
		this.hashColumns.put("r_inbound", getRInbound());
		
		this.hashColumns.put("sch_optm_flg", getSchOptmFlg());
		
		return this.hashColumns;
	}
	
	public String getNodTpCd1() {
		return nodTpCd1;
	}

	public void setNodTpCd1(String nodTpCd1) {
		this.nodTpCd1 = nodTpCd1;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("detail_org_i_wrs_fl_cd", "detailOrgIWrsFlCd");
		this.hashFields.put("prio_seq_combo", "prioSeqCombo");
		this.hashFields.put("to_cd", "toCd");
		this.hashFields.put("detail_org_i_bkg_flg", "detailOrgIBkgFlg");
		this.hashFields.put("i_rout_dest_nod_cd", "iRoutDestNodCd");
		this.hashFields.put("wrs_flg", "wrsFlg");
		this.hashFields.put("detail_org_i_inv", "detailOrgIInv");
		this.hashFields.put("i_mcntr_rout_flg", "iMcntrRoutFlg");
		this.hashFields.put("r_btn_nod_ty_cd", "rBtnNodTyCd");
		this.hashFields.put("detail_org_i_wrs_mt_cd", "detailOrgIWrsMtCd");
		this.hashFields.put("i_rout_org_nod_cd", "iRoutOrgNodCd");
		this.hashFields.put("i_hub_search_gb", "iHubSearchGb");
		this.hashFields.put("i_front_gb", "iFrontGb");
		this.hashFields.put("i_selrow", "iSelrow");
		this.hashFields.put("i_del_flg", "iDelFlg");
		this.hashFields.put("i_undefine_nod", "iUndefineNod");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("i_rout_seq", "iRoutSeq");
		this.hashFields.put("disable_bkg_flg", "disableBkgFlg");
		this.hashFields.put("from_cd", "fromCd");
		this.hashFields.put("detail_org_i_rout_pln_cd", "detailOrgIRoutPlnCd");
		this.hashFields.put("i_newroutecd", "iNewroutecd");
		
		this.hashFields.put("nod_tp_cd1", "nodTpCd1");
		this.hashFields.put("i_org_cd", "iOrgCd");
		this.hashFields.put("i_dest_cd", "iDestCd");
		this.hashFields.put("r_inbound", "rInbound");
		
		this.hashFields.put("sch_optm_flg", "schOptmFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIWrsFlCd
	 */
	public String getDetailOrgIWrsFlCd() {
		return this.detailOrgIWrsFlCd;
	}
	
	/**
	 * Column Info
	 * @return prioSeqCombo
	 */
	public String getPrioSeqCombo() {
		return this.prioSeqCombo;
	}
	
	/**
	 * Column Info
	 * @return toCd
	 */
	public String getToCd() {
		return this.toCd;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIBkgFlg
	 */
	public String getDetailOrgIBkgFlg() {
		return this.detailOrgIBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return iRoutDestNodCd
	 */
	public String getIRoutDestNodCd() {
		return this.iRoutDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return wrsFlg
	 */
	public String getWrsFlg() {
		return this.wrsFlg;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIInv
	 */
	public String getDetailOrgIInv() {
		return this.detailOrgIInv;
	}
	
	/**
	 * Column Info
	 * @return iMcntrRoutFlg
	 */
	public String getIMcntrRoutFlg() {
		return this.iMcntrRoutFlg;
	}
	
	/**
	 * Column Info
	 * @return rBtnNodTyCd
	 */
	public String getRBtnNodTyCd() {
		return this.rBtnNodTyCd;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIWrsMtCd
	 */
	public String getDetailOrgIWrsMtCd() {
		return this.detailOrgIWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @return iRoutOrgNodCd
	 */
	public String getIRoutOrgNodCd() {
		return this.iRoutOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return iHubSearchGb
	 */
	public String getIHubSearchGb() {
		return this.iHubSearchGb;
	}
	
	/**
	 * Column Info
	 * @return iFrontGb
	 */
	public String getIFrontGb() {
		return this.iFrontGb;
	}
	
	/**
	 * Column Info
	 * @return iSelrow
	 */
	public String getISelrow() {
		return this.iSelrow;
	}
	
	/**
	 * Column Info
	 * @return iDelFlg
	 */
	public String getIDelFlg() {
		return this.iDelFlg;
	}
	
	/**
	 * Column Info
	 * @return iUndefineNod
	 */
	public String getIUndefineNod() {
		return this.iUndefineNod;
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
	 * @return iRoutSeq
	 */
	public String getIRoutSeq() {
		return this.iRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return disableBkgFlg
	 */
	public String getDisableBkgFlg() {
		return this.disableBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return fromCd
	 */
	public String getFromCd() {
		return this.fromCd;
	}
	
	/**
	 * Column Info
	 * @return detailOrgIRoutPlnCd
	 */
	public String getDetailOrgIRoutPlnCd() {
		return this.detailOrgIRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @return iNewroutecd
	 */
	public String getINewroutecd() {
		return this.iNewroutecd;
	}
	
	/**
	 * Column Info
	 * @return schOptmFlg
	 */
	public String getSchOptmFlg() {
		return this.schOptmFlg;
	}

	/**
	 * Column Info
	 * @param detailOrgIWrsFlCd
	 */
	public void setDetailOrgIWrsFlCd(String detailOrgIWrsFlCd) {
		this.detailOrgIWrsFlCd = detailOrgIWrsFlCd;
	}
	
	/**
	 * Column Info
	 * @param prioSeqCombo
	 */
	public void setPrioSeqCombo(String prioSeqCombo) {
		this.prioSeqCombo = prioSeqCombo;
	}
	
	/**
	 * Column Info
	 * @param toCd
	 */
	public void setToCd(String toCd) {
		this.toCd = toCd;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIBkgFlg
	 */
	public void setDetailOrgIBkgFlg(String detailOrgIBkgFlg) {
		this.detailOrgIBkgFlg = detailOrgIBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param iRoutDestNodCd
	 */
	public void setIRoutDestNodCd(String iRoutDestNodCd) {
		this.iRoutDestNodCd = iRoutDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param wrsFlg
	 */
	public void setWrsFlg(String wrsFlg) {
		this.wrsFlg = wrsFlg;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIInv
	 */
	public void setDetailOrgIInv(String detailOrgIInv) {
		this.detailOrgIInv = detailOrgIInv;
	}
	
	/**
	 * Column Info
	 * @param iMcntrRoutFlg
	 */
	public void setIMcntrRoutFlg(String iMcntrRoutFlg) {
		this.iMcntrRoutFlg = iMcntrRoutFlg;
	}
	
	/**
	 * Column Info
	 * @param rBtnNodTyCd
	 */
	public void setRBtnNodTyCd(String rBtnNodTyCd) {
		this.rBtnNodTyCd = rBtnNodTyCd;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIWrsMtCd
	 */
	public void setDetailOrgIWrsMtCd(String detailOrgIWrsMtCd) {
		this.detailOrgIWrsMtCd = detailOrgIWrsMtCd;
	}
	
	/**
	 * Column Info
	 * @param iRoutOrgNodCd
	 */
	public void setIRoutOrgNodCd(String iRoutOrgNodCd) {
		this.iRoutOrgNodCd = iRoutOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param iHubSearchGb
	 */
	public void setIHubSearchGb(String iHubSearchGb) {
		this.iHubSearchGb = iHubSearchGb;
	}
	
	/**
	 * Column Info
	 * @param iFrontGb
	 */
	public void setIFrontGb(String iFrontGb) {
		this.iFrontGb = iFrontGb;
	}
	
	/**
	 * Column Info
	 * @param iSelrow
	 */
	public void setISelrow(String iSelrow) {
		this.iSelrow = iSelrow;
	}
	
	/**
	 * Column Info
	 * @param iDelFlg
	 */
	public void setIDelFlg(String iDelFlg) {
		this.iDelFlg = iDelFlg;
	}
	
	/**
	 * Column Info
	 * @param iUndefineNod
	 */
	public void setIUndefineNod(String iUndefineNod) {
		this.iUndefineNod = iUndefineNod;
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
	 * @param iRoutSeq
	 */
	public void setIRoutSeq(String iRoutSeq) {
		this.iRoutSeq = iRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param disableBkgFlg
	 */
	public void setDisableBkgFlg(String disableBkgFlg) {
		this.disableBkgFlg = disableBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param fromCd
	 */
	public void setFromCd(String fromCd) {
		this.fromCd = fromCd;
	}
	
	/**
	 * Column Info
	 * @param detailOrgIRoutPlnCd
	 */
	public void setDetailOrgIRoutPlnCd(String detailOrgIRoutPlnCd) {
		this.detailOrgIRoutPlnCd = detailOrgIRoutPlnCd;
	}
	
	/**
	 * Column Info
	 * @param iNewroutecd
	 */
	public void setINewroutecd(String iNewroutecd) {
		this.iNewroutecd = iNewroutecd;
	}
	
	/**
	 * Column Info
	 * @param iNewroutecd
	 */
	public void setSchOptmFlg(String schOptmFlg) {
		this.schOptmFlg = schOptmFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDetailOrgIWrsFlCd(JSPUtil.getParameter(request, "detail_org_i_wrs_fl_cd", ""));
		setPrioSeqCombo(JSPUtil.getParameter(request, "prio_seq_combo", ""));
		setToCd(JSPUtil.getParameter(request, "to_cd", ""));
		setDetailOrgIBkgFlg(JSPUtil.getParameter(request, "detail_org_i_bkg_flg", ""));
		setIRoutDestNodCd(JSPUtil.getParameter(request, "i_rout_dest_nod_cd", ""));
		setWrsFlg(JSPUtil.getParameter(request, "wrs_flg", ""));
		setDetailOrgIInv(JSPUtil.getParameter(request, "detail_org_i_inv", ""));
		setIMcntrRoutFlg(JSPUtil.getParameter(request, "i_mcntr_rout_flg", ""));
		setRBtnNodTyCd(JSPUtil.getParameter(request, "r_btn_nod_ty_cd", ""));
		setDetailOrgIWrsMtCd(JSPUtil.getParameter(request, "detail_org_i_wrs_mt_cd", ""));
		setIRoutOrgNodCd(JSPUtil.getParameter(request, "i_rout_org_nod_cd", ""));
		setIHubSearchGb(JSPUtil.getParameter(request, "i_hub_search_gb", ""));
		setIFrontGb(JSPUtil.getParameter(request, "i_front_gb", ""));
		setISelrow(JSPUtil.getParameter(request, "i_selrow", ""));
		setIDelFlg(JSPUtil.getParameter(request, "i_del_flg", ""));
		setIUndefineNod(JSPUtil.getParameter(request, "i_undefine_nod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIRoutSeq(JSPUtil.getParameter(request, "i_rout_seq", ""));
		setDisableBkgFlg(JSPUtil.getParameter(request, "disable_bkg_flg", ""));
		setFromCd(JSPUtil.getParameter(request, "from_cd", ""));
		setDetailOrgIRoutPlnCd(JSPUtil.getParameter(request, "detail_org_i_rout_pln_cd", ""));
		setINewroutecd(JSPUtil.getParameter(request, "i_newroutecd", ""));
		setNodTpCd1(JSPUtil.getParameter(request,"nod_tp_cd1", ""));
		setIOrgCd(JSPUtil.getParameter(request,"i_org_cd", ""));
		setIDestCd(JSPUtil.getParameter(request,"i_dest_cd", ""));
		setRInbound(JSPUtil.getParameter(request,"r_inbound", ""));
		setSchOptmFlg(JSPUtil.getParameter(request,"sch_optm_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] detailOrgIWrsFlCd = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_wrs_fl_cd", length));
			String[] prioSeqCombo = (JSPUtil.getParameter(request, prefix	+ "prio_seq_combo", length));
			String[] toCd = (JSPUtil.getParameter(request, prefix	+ "to_cd", length));
			String[] detailOrgIBkgFlg = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_bkg_flg", length));
			String[] iRoutDestNodCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_dest_nod_cd", length));
			String[] wrsFlg = (JSPUtil.getParameter(request, prefix	+ "wrs_flg", length));
			String[] detailOrgIInv = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_inv", length));
			String[] iMcntrRoutFlg = (JSPUtil.getParameter(request, prefix	+ "i_mcntr_rout_flg", length));
			String[] rBtnNodTyCd = (JSPUtil.getParameter(request, prefix	+ "r_btn_nod_ty_cd", length));
			String[] detailOrgIWrsMtCd = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_wrs_mt_cd", length));
			String[] iRoutOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "i_rout_org_nod_cd", length));
			String[] iHubSearchGb = (JSPUtil.getParameter(request, prefix	+ "i_hub_search_gb", length));
			String[] iFrontGb = (JSPUtil.getParameter(request, prefix	+ "i_front_gb", length));
			String[] iSelrow = (JSPUtil.getParameter(request, prefix	+ "i_selrow", length));
			String[] iDelFlg = (JSPUtil.getParameter(request, prefix	+ "i_del_flg", length));
			String[] iUndefineNod = (JSPUtil.getParameter(request, prefix	+ "i_undefine_nod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] iRoutSeq = (JSPUtil.getParameter(request, prefix	+ "i_rout_seq", length));
			String[] disableBkgFlg = (JSPUtil.getParameter(request, prefix	+ "disable_bkg_flg", length));
			String[] fromCd = (JSPUtil.getParameter(request, prefix	+ "from_cd", length));
			String[] detailOrgIRoutPlnCd = (JSPUtil.getParameter(request, prefix	+ "detail_org_i_rout_pln_cd", length));
			String[] iNewroutecd = (JSPUtil.getParameter(request, prefix	+ "i_newroutecd", length));
			String[] nodTpCd1 = (JSPUtil.getParameter(request, prefix	+ "nod_tp_cd1", length));
			String[] iOrgCd = (JSPUtil.getParameter(request, prefix	+ "i_org_cd", length));
			String[] iDestCd = (JSPUtil.getParameter(request, prefix	+ "i_dest_cd", length));
			String[] rInbound = (JSPUtil.getParameter(request, prefix	+ "r_inbound", length));
			String[] schOptmFlg = (JSPUtil.getParameter(request, prefix	+ "sch_optm_flg", length));
			for (int i = 0; i < length; i++) {
				model = new SearchConditionVO();
				if (detailOrgIWrsFlCd[i] != null)
					model.setDetailOrgIWrsFlCd(detailOrgIWrsFlCd[i]);
				if (prioSeqCombo[i] != null)
					model.setPrioSeqCombo(prioSeqCombo[i]);
				if (toCd[i] != null)
					model.setToCd(toCd[i]);
				if (detailOrgIBkgFlg[i] != null)
					model.setDetailOrgIBkgFlg(detailOrgIBkgFlg[i]);
				if (iRoutDestNodCd[i] != null)
					model.setIRoutDestNodCd(iRoutDestNodCd[i]);
				if (wrsFlg[i] != null)
					model.setWrsFlg(wrsFlg[i]);
				if (detailOrgIInv[i] != null)
					model.setDetailOrgIInv(detailOrgIInv[i]);
				if (iMcntrRoutFlg[i] != null)
					model.setIMcntrRoutFlg(iMcntrRoutFlg[i]);
				if (rBtnNodTyCd[i] != null)
					model.setRBtnNodTyCd(rBtnNodTyCd[i]);
				if (detailOrgIWrsMtCd[i] != null)
					model.setDetailOrgIWrsMtCd(detailOrgIWrsMtCd[i]);
				if (iRoutOrgNodCd[i] != null)
					model.setIRoutOrgNodCd(iRoutOrgNodCd[i]);
				if (iHubSearchGb[i] != null)
					model.setIHubSearchGb(iHubSearchGb[i]);
				if (iFrontGb[i] != null)
					model.setIFrontGb(iFrontGb[i]);
				if (iSelrow[i] != null)
					model.setISelrow(iSelrow[i]);
				if (iDelFlg[i] != null)
					model.setIDelFlg(iDelFlg[i]);
				if (iUndefineNod[i] != null)
					model.setIUndefineNod(iUndefineNod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iRoutSeq[i] != null)
					model.setIRoutSeq(iRoutSeq[i]);
				if (disableBkgFlg[i] != null)
					model.setDisableBkgFlg(disableBkgFlg[i]);
				if (fromCd[i] != null)
					model.setFromCd(fromCd[i]);
				if (detailOrgIRoutPlnCd[i] != null)
					model.setDetailOrgIRoutPlnCd(detailOrgIRoutPlnCd[i]);
				if (iNewroutecd[i] != null)
					model.setINewroutecd(iNewroutecd[i]);
				if (nodTpCd1[i] != null)
					model.setNodTpCd1(nodTpCd1[i]);
				if (iOrgCd[i] != null)
					model.setIOrgCd(iOrgCd[i]);
				if (iDestCd[i] != null)
					model.setIDestCd(iDestCd[i]);
				if (rInbound[i] != null)
					model.setRInbound(rInbound[i]);
				if (schOptmFlg[i] != null)
					model.setSchOptmFlg(schOptmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchConditionVO[]
	 */
	public SearchConditionVO[] getSearchConditionVOs(){
		SearchConditionVO[] vos = (SearchConditionVO[])models.toArray(new SearchConditionVO[models.size()]);
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
		this.detailOrgIWrsFlCd = this.detailOrgIWrsFlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prioSeqCombo = this.prioSeqCombo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCd = this.toCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIBkgFlg = this.detailOrgIBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutDestNodCd = this.iRoutDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsFlg = this.wrsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIInv = this.detailOrgIInv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iMcntrRoutFlg = this.iMcntrRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBtnNodTyCd = this.rBtnNodTyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIWrsMtCd = this.detailOrgIWrsMtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutOrgNodCd = this.iRoutOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iHubSearchGb = this.iHubSearchGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iFrontGb = this.iFrontGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iSelrow = this.iSelrow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDelFlg = this.iDelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iUndefineNod = this.iUndefineNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iRoutSeq = this.iRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disableBkgFlg = this.disableBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromCd = this.fromCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailOrgIRoutPlnCd = this.detailOrgIRoutPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iNewroutecd = this.iNewroutecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTpCd1 = this.nodTpCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOrgCd = this.iOrgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDestCd = this.iDestCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rInbound = this.rInbound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schOptmFlg = this.schOptmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
