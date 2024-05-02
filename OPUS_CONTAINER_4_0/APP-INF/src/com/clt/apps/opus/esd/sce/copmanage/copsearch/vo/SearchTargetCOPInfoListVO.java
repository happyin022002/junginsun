/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTargetCOPInfoListVO.java
*@FileTitle : SearchTargetCOPInfoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.12.07 오현경 
* 1.0 Creation
* -------------------------------------------------------
* history
* 2010.12.15 김영철 [] IRG상 BKG&Temp Flag 적용
=========================================================*/

package com.clt.apps.opus.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTargetCOPInfoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTargetCOPInfoListVO> models = new ArrayList<SearchTargetCOPInfoListVO>();
	
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String estTotCost = null;
	/* Column Info */
	private String estDlvTm = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actStsCd = null;
	/* Column Info */
	private String itemMaxCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String copSubStsCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String planedDt = null;
	/* Column Info */
	private String inlndRoutCmbFlg = null;
	/* Column Info */
	private String bndVskdSeqCd = null;
	/* Column Info */
	private String estDt = null;
	/* Column Info */
	private String estmCost = null;
	/* Column Info */
	private String maxDtlSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String itemCnt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String orgNodCdVal = null;
	/* Column Info */
	private String inlndRoutTmpFlg = null;
	/* Column Info */
	private String routPlnCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTargetCOPInfoListVO() {}

	public SearchTargetCOPInfoListVO(String ibflag, String pagerows, String copNo, String cntrNo, String actNm, String nodCd, String actDt, String planedDt, String estDt, String estmCost, String bndVskdSeqCd, String pctlNo, String copSubStsCd, String maxDtlSeq, String orgNodCdVal, String estDlvTm, String estTotCost, String itemCnt, String itemMaxCnt, String ioBndCd, String inlndRoutCmbFlg, String location, String actStsCd, String bkgNo, String copStsCd, String inlndRoutTmpFlg, String routPlnCd) {
		this.location = location;
		this.copNo = copNo;
		this.estTotCost = estTotCost;
		this.estDlvTm = estDlvTm;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.actStsCd = actStsCd;
		this.itemMaxCnt = itemMaxCnt;
		this.ibflag = ibflag;
		this.actNm = actNm;
		this.copSubStsCd = copSubStsCd;
		this.copStsCd = copStsCd;
		this.planedDt = planedDt;
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
		this.bndVskdSeqCd = bndVskdSeqCd;
		this.estDt = estDt;
		this.estmCost = estmCost;
		this.maxDtlSeq = maxDtlSeq;
		this.ioBndCd = ioBndCd;
		this.itemCnt = itemCnt;
		this.bkgNo = bkgNo;
		this.actDt = actDt;
		this.cntrNo = cntrNo;
		this.nodCd = nodCd;
		this.orgNodCdVal = orgNodCdVal;
		this.inlndRoutTmpFlg = inlndRoutTmpFlg;
		this.routPlnCd = routPlnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("est_tot_cost", getEstTotCost());
		this.hashColumns.put("est_dlv_tm", getEstDlvTm());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_sts_cd", getActStsCd());
		this.hashColumns.put("item_max_cnt", getItemMaxCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("cop_sub_sts_cd", getCopSubStsCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("planed_dt", getPlanedDt());
		this.hashColumns.put("inlnd_rout_cmb_flg", getInlndRoutCmbFlg());
		this.hashColumns.put("bnd_vskd_seq_cd", getBndVskdSeqCd());
		this.hashColumns.put("est_dt", getEstDt());
		this.hashColumns.put("estm_cost", getEstmCost());
		this.hashColumns.put("max_dtl_seq", getMaxDtlSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("item_cnt", getItemCnt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("org_nod_cd_val", getOrgNodCdVal());
		this.hashColumns.put("inlnd_rout_tmp_flg", getInlndRoutTmpFlg());
		this.hashColumns.put("rout_pln_cd", getRoutPlnCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("location", "location");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("est_tot_cost", "estTotCost");
		this.hashFields.put("est_dlv_tm", "estDlvTm");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_sts_cd", "actStsCd");
		this.hashFields.put("item_max_cnt", "itemMaxCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("cop_sub_sts_cd", "copSubStsCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("planed_dt", "planedDt");
		this.hashFields.put("inlnd_rout_cmb_flg", "inlndRoutCmbFlg");
		this.hashFields.put("bnd_vskd_seq_cd", "bndVskdSeqCd");
		this.hashFields.put("est_dt", "estDt");
		this.hashFields.put("estm_cost", "estmCost");
		this.hashFields.put("max_dtl_seq", "maxDtlSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("item_cnt", "itemCnt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("org_nod_cd_val", "orgNodCdVal");
		this.hashFields.put("inlnd_rout_tmp_flg", "inlndRoutTmpFlg");
		this.hashFields.put("rout_pln_cd", "routPlnCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return estTotCost
	 */
	public String getEstTotCost() {
		return this.estTotCost;
	}
	
	/**
	 * Column Info
	 * @return estDlvTm
	 */
	public String getEstDlvTm() {
		return this.estDlvTm;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return actStsCd
	 */
	public String getActStsCd() {
		return this.actStsCd;
	}
	
	/**
	 * Column Info
	 * @return itemMaxCnt
	 */
	public String getItemMaxCnt() {
		return this.itemMaxCnt;
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
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return copSubStsCd
	 */
	public String getCopSubStsCd() {
		return this.copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return planedDt
	 */
	public String getPlanedDt() {
		return this.planedDt;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutCmbFlg
	 */
	public String getInlndRoutCmbFlg() {
		return this.inlndRoutCmbFlg;
	}
	
	/**
	 * Column Info
	 * @return bndVskdSeqCd
	 */
	public String getBndVskdSeqCd() {
		return this.bndVskdSeqCd;
	}
	
	/**
	 * Column Info
	 * @return estDt
	 */
	public String getEstDt() {
		return this.estDt;
	}
	
	/**
	 * Column Info
	 * @return estmCost
	 */
	public String getEstmCost() {
		return this.estmCost;
	}
	
	/**
	 * Column Info
	 * @return maxDtlSeq
	 */
	public String getMaxDtlSeq() {
		return this.maxDtlSeq;
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
	 * @return itemCnt
	 */
	public String getItemCnt() {
		return this.itemCnt;
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
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
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
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return orgNodCdVal
	 */
	public String getOrgNodCdVal() {
		return this.orgNodCdVal;
	}
	

	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param estTotCost
	 */
	public void setEstTotCost(String estTotCost) {
		this.estTotCost = estTotCost;
	}
	
	/**
	 * Column Info
	 * @param estDlvTm
	 */
	public void setEstDlvTm(String estDlvTm) {
		this.estDlvTm = estDlvTm;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param actStsCd
	 */
	public void setActStsCd(String actStsCd) {
		this.actStsCd = actStsCd;
	}
	
	/**
	 * Column Info
	 * @param itemMaxCnt
	 */
	public void setItemMaxCnt(String itemMaxCnt) {
		this.itemMaxCnt = itemMaxCnt;
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
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param copSubStsCd
	 */
	public void setCopSubStsCd(String copSubStsCd) {
		this.copSubStsCd = copSubStsCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param planedDt
	 */
	public void setPlanedDt(String planedDt) {
		this.planedDt = planedDt;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutCmbFlg
	 */
	public void setInlndRoutCmbFlg(String inlndRoutCmbFlg) {
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
	}
	
	/**
	 * Column Info
	 * @param bndVskdSeqCd
	 */
	public void setBndVskdSeqCd(String bndVskdSeqCd) {
		this.bndVskdSeqCd = bndVskdSeqCd;
	}
	
	/**
	 * Column Info
	 * @param estDt
	 */
	public void setEstDt(String estDt) {
		this.estDt = estDt;
	}
	
	/**
	 * Column Info
	 * @param estmCost
	 */
	public void setEstmCost(String estmCost) {
		this.estmCost = estmCost;
	}
	
	/**
	 * Column Info
	 * @param maxDtlSeq
	 */
	public void setMaxDtlSeq(String maxDtlSeq) {
		this.maxDtlSeq = maxDtlSeq;
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
	 * @param itemCnt
	 */
	public void setItemCnt(String itemCnt) {
		this.itemCnt = itemCnt;
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
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
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
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param orgNodCdVal
	 */
	public void setOrgNodCdVal(String orgNodCdVal) {
		this.orgNodCdVal = orgNodCdVal;
	}

	public String getInlndRoutTmpFlg() {
		return inlndRoutTmpFlg;
	}

	public void setInlndRoutTmpFlg(String inlndRoutTmpFlg) {
		this.inlndRoutTmpFlg = inlndRoutTmpFlg;
	}

	public String getRoutPlnCd() {
		return routPlnCd;
	}

	public void setRoutPlnCd(String routPlnCd) {
		this.routPlnCd = routPlnCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLocation(JSPUtil.getParameter(request, "location", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setEstTotCost(JSPUtil.getParameter(request, "est_tot_cost", ""));
		setEstDlvTm(JSPUtil.getParameter(request, "est_dlv_tm", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActStsCd(JSPUtil.getParameter(request, "act_sts_cd", ""));
		setItemMaxCnt(JSPUtil.getParameter(request, "item_max_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setActNm(JSPUtil.getParameter(request, "act_nm", ""));
		setCopSubStsCd(JSPUtil.getParameter(request, "cop_sub_sts_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setPlanedDt(JSPUtil.getParameter(request, "planed_dt", ""));
		setInlndRoutCmbFlg(JSPUtil.getParameter(request, "inlnd_rout_cmb_flg", ""));
		setBndVskdSeqCd(JSPUtil.getParameter(request, "bnd_vskd_seq_cd", ""));
		setEstDt(JSPUtil.getParameter(request, "est_dt", ""));
		setEstmCost(JSPUtil.getParameter(request, "estm_cost", ""));
		setMaxDtlSeq(JSPUtil.getParameter(request, "max_dtl_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setItemCnt(JSPUtil.getParameter(request, "item_cnt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setOrgNodCdVal(JSPUtil.getParameter(request, "org_nod_cd_val", ""));
		setInlndRoutTmpFlg(JSPUtil.getParameter(request, "inlnd_rout_tmp_flg", ""));
		setRoutPlnCd(JSPUtil.getParameter(request, "rout_pln_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTargetCOPInfoListVO[]
	 */
	public SearchTargetCOPInfoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTargetCOPInfoListVO[]
	 */
	public SearchTargetCOPInfoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTargetCOPInfoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] estTotCost = (JSPUtil.getParameter(request, prefix	+ "est_tot_cost", length));
			String[] estDlvTm = (JSPUtil.getParameter(request, prefix	+ "est_dlv_tm", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actStsCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_cd", length));
			String[] itemMaxCnt = (JSPUtil.getParameter(request, prefix	+ "item_max_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] copSubStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sub_sts_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] planedDt = (JSPUtil.getParameter(request, prefix	+ "planed_dt", length));
			String[] inlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_cmb_flg", length));
			String[] bndVskdSeqCd = (JSPUtil.getParameter(request, prefix	+ "bnd_vskd_seq_cd", length));
			String[] estDt = (JSPUtil.getParameter(request, prefix	+ "est_dt", length));
			String[] estmCost = (JSPUtil.getParameter(request, prefix	+ "estm_cost", length));
			String[] maxDtlSeq = (JSPUtil.getParameter(request, prefix	+ "max_dtl_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] itemCnt = (JSPUtil.getParameter(request, prefix	+ "item_cnt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] orgNodCdVal = (JSPUtil.getParameter(request, prefix	+ "org_nod_cd_val", length));
			String[] inlndRoutTmpFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_tmp_flg", length));
			String[] routPlnCd = (JSPUtil.getParameter(request, prefix	+ "rout_pln_cd", length));			
			
			for (int i = 0; i < length; i++) {
				model = new SearchTargetCOPInfoListVO();
				if (location[i] != null)
					model.setLocation(location[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (estTotCost[i] != null)
					model.setEstTotCost(estTotCost[i]);
				if (estDlvTm[i] != null)
					model.setEstDlvTm(estDlvTm[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actStsCd[i] != null)
					model.setActStsCd(actStsCd[i]);
				if (itemMaxCnt[i] != null)
					model.setItemMaxCnt(itemMaxCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (copSubStsCd[i] != null)
					model.setCopSubStsCd(copSubStsCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (planedDt[i] != null)
					model.setPlanedDt(planedDt[i]);
				if (inlndRoutCmbFlg[i] != null)
					model.setInlndRoutCmbFlg(inlndRoutCmbFlg[i]);
				if (bndVskdSeqCd[i] != null)
					model.setBndVskdSeqCd(bndVskdSeqCd[i]);
				if (estDt[i] != null)
					model.setEstDt(estDt[i]);
				if (estmCost[i] != null)
					model.setEstmCost(estmCost[i]);
				if (maxDtlSeq[i] != null)
					model.setMaxDtlSeq(maxDtlSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (itemCnt[i] != null)
					model.setItemCnt(itemCnt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (orgNodCdVal[i] != null)
					model.setOrgNodCdVal(orgNodCdVal[i]);
				if (inlndRoutTmpFlg[i] != null)
					model.setInlndRoutTmpFlg(inlndRoutTmpFlg[i]);
				if (routPlnCd[i] != null)
					model.setRoutPlnCd(routPlnCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTargetCOPInfoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTargetCOPInfoListVO[]
	 */
	public SearchTargetCOPInfoListVO[] getSearchTargetCOPInfoListVOs(){
		SearchTargetCOPInfoListVO[] vos = (SearchTargetCOPInfoListVO[])models.toArray(new SearchTargetCOPInfoListVO[models.size()]);
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
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estTotCost = this.estTotCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estDlvTm = this.estDlvTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsCd = this.actStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemMaxCnt = this.itemMaxCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSubStsCd = this.copSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planedDt = this.planedDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutCmbFlg = this.inlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndVskdSeqCd = this.bndVskdSeqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estDt = this.estDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCost = this.estmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDtlSeq = this.maxDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemCnt = this.itemCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgNodCdVal = this.orgNodCdVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutTmpFlg = this.inlndRoutTmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPlnCd = this.routPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
