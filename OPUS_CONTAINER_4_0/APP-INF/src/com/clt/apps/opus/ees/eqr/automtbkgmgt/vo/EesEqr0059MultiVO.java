/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0059ConditionVO.java
*@FileTitle : EesEqr0059ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.17 이행지 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0059MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<EesEqr0059MultiVO> models = new ArrayList<EesEqr0059MultiVO>(); 
	

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	
	/* Column Info */
	private String repoPlnId = null;
	private String plnYrwk = null;
	private String plnSeq = null;
	private String refId = null;

	private String vslLaneCd = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;

	private String fmYdCd = null;
	private String fmEtdDt = null;
	private String toYdCd = null;
	private String toEtbDt = null;

	private String coCd = null;
	private String trspModCd = null;
	private String repoPlnFbRsnCd = null;
	private String eqRepoPurpCd = null;
	private String mtyBkgNo = null;
	private String repoPlnFbRmk = null;

	private String repoMtyBkgFlg = null;
	private String splitRepoPlnFlg = null;
	private String pastRepoPlnFlg = null;

	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;

	private String plnUcAmt = null;
	private String dchgPortUcAmt = null;
	private String lodgPortUcAmt = null;
	private String cntrTpszCd = null;
	private String cntrQty = null;
	private String lodgDchgCostAmt = null;
	
	private String cntrNo = null;
	private String tpszNo = null;
	private String cntrStatus = null;
	private String cntrDel = null;
	private String yardEccInfo = null;
	private String repobkgFlag = null;
	private String frlocRcc = null;
	private String frlocEcc = null;
	private String tolocEcc = null;
	private String vpsPort	= null;
	
	/* input Param */
	/*
	 * type size 순서대로 해당 value를 담기위한 변수
	 */
	private List<String> tpszList = null;
	private List<String> volList = null;
	private List<String> costList = null;
	private List<String> flagList = null;
	private List<String> unitcostList = null;
	private List<String> fromcostList = null;
	private List<String> tocostList = null;
	
	// Original Booking No.저장하기 위해 추가된 변수를 담기위한 변수.
	private String oldBkgGrpNo	= null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());

		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("ref_id", getRefId());

		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("fm_etd_dt", getFmEtdDt());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("to_etb_dt", getToEtbDt());

		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("repo_pln_fb_rsn_cd", getRepoPlnFbRsnCd());
		this.hashColumns.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashColumns.put("mty_bkg_no", getMtyBkgNo());
		this.hashColumns.put("repo_pln_fb_rmk", getRepoPlnFbRmk());

		this.hashColumns.put("repo_mty_bkg_flg", getRepoMtyBkgFlg());
		this.hashColumns.put("split_repo_pln_flg", getSplitRepoPlnFlg());
		this.hashColumns.put("past_repo_pln_flg", getPastRepoPlnFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());

		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("pln_uc_amt", getPlnUcAmt());
		this.hashColumns.put("dchg_port_uc_amt", getDchgPortUcAmt());
		this.hashColumns.put("lodg_port_uc_amt", getLodgPortUcAmt());
		this.hashColumns.put("lodg_dchg_cost_amt", getLodgDchgCostAmt());
		
		this.hashColumns.put("cntrNo", getCntrNo());
		this.hashColumns.put("tpszNo", getTpszNo());
		this.hashColumns.put("cntrStatus", getCntrStatus());
		this.hashColumns.put("cntrDel", getCntrDel());
		this.hashColumns.put("yardEccInfo", getYardEccInfo());
		this.hashColumns.put("repobkgFlag", getRepobkgFlag());
		this.hashColumns.put("frlocRcc", getFrlocRcc());
		this.hashColumns.put("frlocEcc", getFrlocEcc());
		this.hashColumns.put("tolocEcc", getTolocEcc());
		this.hashColumns.put("vpsPort", getVpsPort());
		
		this.hashColumns.put("old_bkg_grp_no", getOldBkgGrpNo());
		
		return this.hashColumns;
	}

	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("ref_id", "refId");

		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("fm_etd_dt", "fmEtdDt");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("to_etb_dt", "toEtbDt");

		this.hashFields.put("co_cd", "coCd");	
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("repo_pln_fb_rsn_cd", "repoPlnFbRsnCd");
		this.hashFields.put("eq_repo_purp_cd", "eqRepoPurpCd");	
		this.hashFields.put("mty_bkg_no", "mtyBkgNo");
		this.hashFields.put("repo_pln_fb_rmk", "repoPlnFbRmk");

		this.hashFields.put("repo_mty_bkg_flg", "repoMtyBkgFlg");
		this.hashFields.put("split_repo_pln_flg", "splitRepoPlnFlg");
		this.hashFields.put("past_repo_pln_flg", "pastRepoPlnFlg");
		
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");

		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("pln_uc_amt", "plnUcAmt");
		this.hashFields.put("dchg_port_uc_amt", "dchgPortUcAmt");
		this.hashFields.put("lodg_port_uc_amt", "lodgPortUcAmt");
		this.hashFields.put("lodg_dchg_cost_amt", "lodgDchgCostAmt");
		
		this.hashFields.put("cntrNo","cntrNo");
		this.hashFields.put("tpszNo","tpszNo");
		this.hashFields.put("cntrStatus","cntrStatus");
		this.hashFields.put("cntrDel","cntrDel");
		this.hashFields.put("yardEccInfo","yardEccInfo");
		this.hashFields.put("repobkgFlag","repobkgFlag");
		this.hashFields.put("frlocRcc","frlocRcc");
		this.hashFields.put("frlocEcc","frlocEcc");
		this.hashFields.put("tolocEcc","tolocEcc");
		this.hashFields.put("vpsPort","vpsPort");
		
		this.hashFields.put("old_bkg_grp_no","oldBkgGrpNo");
		
		return this.hashFields;
	}
	
	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public String getPagerows() {
		return pagerows;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getRepoPlnId() {
		return repoPlnId;
	}

	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}

	public String getPlnYrwk() {
		return plnYrwk;
	}

	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}

	public String getPlnSeq() {
		return plnSeq;
	}

	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getVslLaneCd() {
		return vslLaneCd;
	}

	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
	}

	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getFmYdCd() {
		return fmYdCd;
	}

	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}

	public String getToYdCd() {
		return toYdCd;
	}

	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
	}

	public String getFmEtdDt() {
		return fmEtdDt;
	}

	public void setFmEtdDt(String fmEtdDt) {
		this.fmEtdDt = fmEtdDt;
	}

	public String getToEtbDt() {
		return toEtbDt;
	}

	public void setToEtbDt(String toEtbDt) {
		this.toEtbDt = toEtbDt;
	}

	public String getRepoPlnFbRsnCd() {
		return repoPlnFbRsnCd;
	}

	public void setRepoPlnFbRsnCd(String repoPlnFbRsnCd) {
		this.repoPlnFbRsnCd = repoPlnFbRsnCd;
	}

	public String getEqRepoPurpCd() {
		return eqRepoPurpCd;
	}

	public void setEqRepoPurpCd(String eqRepoPurpCd) {
		this.eqRepoPurpCd = eqRepoPurpCd;
	}

	public String getCoCd() {
		return coCd;
	}

	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}

	public String getMtyBkgNo() {
		return mtyBkgNo;
	}

	public void setMtyBkgNo(String mtyBkgNo) {
		this.mtyBkgNo = mtyBkgNo;
	}

	public String getTrspModCd() {
		return trspModCd;
	}

	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}

	public String getRepoMtyBkgFlg() {
		return repoMtyBkgFlg;
	}

	public void setRepoMtyBkgFlg(String repoMtyBkgFlg) {
		this.repoMtyBkgFlg = repoMtyBkgFlg;
	}

	public String getSplitRepoPlnFlg() {
		return splitRepoPlnFlg;
	}

	public void setSplitRepoPlnFlg(String splitRepoPlnFlg) {
		this.splitRepoPlnFlg = splitRepoPlnFlg;
	}

	public String getPastRepoPlnFlg() {
		return pastRepoPlnFlg;
	}

	public void setPastRepoPlnFlg(String pastRepoPlnFlg) {
		this.pastRepoPlnFlg = pastRepoPlnFlg;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getRepoPlnFbRmk() {
		return repoPlnFbRmk;
	}

	public void setRepoPlnFbRmk(String repoPlnFbRmk) {
		this.repoPlnFbRmk = repoPlnFbRmk;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public String getPlnUcAmt() {
		return plnUcAmt;
	}

	public void setPlnUcAmt(String plnUcAmt) {
		this.plnUcAmt = plnUcAmt;
	}

	public String getDchgPortUcAmt() {
		return dchgPortUcAmt;
	}

	public void setDchgPortUcAmt(String dchgPortUcAmt) {
		this.dchgPortUcAmt = dchgPortUcAmt;
	}

	public String getLodgPortUcAmt() {
		return lodgPortUcAmt;
	}

	public void setLodgPortUcAmt(String lodgPortUcAmt) {
		this.lodgPortUcAmt = lodgPortUcAmt;
	}

	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	public String getCntrQty() {
		return cntrQty;
	}

	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	public String getLodgDchgCostAmt() {
		return lodgDchgCostAmt;
	}

	public void setLodgDchgCostAmt(String lodgDchgCostAmt) {
		this.lodgDchgCostAmt = lodgDchgCostAmt;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getTpszNo() {
		return tpszNo;
	}

	public void setTpszNo(String tpszNo) {
		this.tpszNo = tpszNo;
	}

	public String getCntrStatus() {
		return cntrStatus;
	}

	public void setCntrStatus(String cntrStatus) {
		this.cntrStatus = cntrStatus;
	}

	public String getCntrDel() {
		return cntrDel;
	}

	public void setCntrDel(String cntrDel) {
		this.cntrDel = cntrDel;
	}

	public String getYardEccInfo() {
		return yardEccInfo;
	}

	public void setYardEccInfo(String yardEccInfo) {
		this.yardEccInfo = yardEccInfo;
	}

	public String getRepobkgFlag() {
		return repobkgFlag;
	}

	public void setRepobkgFlag(String repobkgFlag) {
		this.repobkgFlag = repobkgFlag;
	}

	public String getFrlocRcc() {
		return frlocRcc;
	}

	public void setFrlocRcc(String frlocRcc) {
		this.frlocRcc = frlocRcc;
	}

	public String getFrlocEcc() {
		return frlocEcc;
	}

	public void setFrlocEcc(String frlocEcc) {
		this.frlocEcc = frlocEcc;
	}

	public String getTolocEcc() {
		return tolocEcc;
	}

	public void setTolocEcc(String tolocEcc) {
		this.tolocEcc = tolocEcc;
	}
	
	public String getVpsPort() {
		return vpsPort;
	}

	public void setVpsPort(String vpsPort) {
		this.vpsPort = vpsPort;
	}
	
	public List<String> getTpszList() {
		return tpszList;
	}

	public void setTpszList(List<String> tpszList) {
		this.tpszList = tpszList;
	}
	
	public List<String> getVolList() {
		return volList;
	}

	public void setVolList(List<String> volList) {
		this.volList = volList;
	}

	public List<String> getCostList() {
		return costList;
	}

	public void setCostList(List<String> costList) {
		this.costList = costList;
	}

	public List<String> getFlagList() {
		return flagList;
	}

	public void setFlagList(List<String> flagList) {
		this.flagList = flagList;
	}

	public List<String> getUnitcostList() {
		return unitcostList;
	}

	public void setUnitcostList(List<String> unitcostList) {
		this.unitcostList = unitcostList;
	}

	public List<String> getFromcostList() {
		return fromcostList;
	}

	public void setFromcostList(List<String> fromcostList) {
		this.fromcostList = fromcostList;
	}

	public List<String> getTocostList() {
		return tocostList;
	}

	public void setTocostList(List<String> tocostList) {
		this.tocostList = tocostList;
	}
	
	public String getOldBkgGrpNo() {
		return oldBkgGrpNo;
	}

	public void setOldBkgGrpNo(String oldBkgGrpNo) {
		this.oldBkgGrpNo = oldBkgGrpNo;
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrVslLodgDchgExePlnVO[]
	 */
	public EesEqr0059MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0059MultiVO model = null;	
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String tpsztype = JSPUtil.getParameter(request, "tpsztype".trim(), ""); // tpsz value
	    	String[] tpszArr = tpsztype.split(","); 
	    	
			String[] ibflag			= (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows		= (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			String[] repoPlnId		= (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] plnYrwk		= (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] plnSeq			= (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] refId			= (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			
			String[] vslLaneCd		= (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] vvd			= (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] fmYdCd			= (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] toYdCd			= (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] fmEtdDt		= (JSPUtil.getParameter(request, prefix	+ "fm_etd_dt", length));
			String[] toEtbDt		= (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));

			String[] coCd			= (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] trspModCd		= (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] eqRepoPurpCd	= (JSPUtil.getParameter(request, prefix	+ "eq_repo_purp_cd", length));
			String[] repoPlnFbRsnCd = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rsn_cd", length));
			String[] mtyBkgNo		= (JSPUtil.getParameter(request, prefix	+ "mty_bkg_no", length));
			String[] repoPlnFbRmk	= (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rmk", length));
			
			String[] pastRepoPlnFlg	= (JSPUtil.getParameter(request, prefix	+ "past_repo_pln_flg", length));
			String[] repoMtyBkgFlg	= (JSPUtil.getParameter(request, prefix	+ "repo_mty_bkg_flg", length));
			String[] splitRepoPlnFlg= (JSPUtil.getParameter(request, prefix	+ "split_repo_pln_flg", length));
						
			String[] cntrNo			= (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] tpszNo			= (JSPUtil.getParameter(request, prefix	+ "tpszno", length));
			String[] cntrStatus		= (JSPUtil.getParameter(request, prefix	+ "cntrstatus", length));
			String[] cntrDel		= (JSPUtil.getParameter(request, prefix	+ "cntrdel", length));
//			String[] yardEccInfo	= (JSPUtil.getParameter(request, prefix	+ "sort", length));
			String[] repobkgFlag	= (JSPUtil.getParameter(request, prefix	+ "repobkg_flag", length));
			String[] frlocRcc		= (JSPUtil.getParameter(request, prefix	+ "fm_rcc", length));
			String[] frlocEcc		= (JSPUtil.getParameter(request, prefix	+ "fm_ecc", length));
			String[] tolocEcc		= (JSPUtil.getParameter(request, prefix	+ "to_ecc", length));
						
			List<String[]> volListArr = new ArrayList<String[]>();
			List<String[]> costListArr = new ArrayList<String[]>();
			List<String[]> flagListArr = new ArrayList<String[]>();
			List<String[]> unitcostListArr = new ArrayList<String[]>();
			List<String[]> fromcostListArr = new ArrayList<String[]>();
			List<String[]> tocostListArr = new ArrayList<String[]>();
			for(int i=0; i<tpszArr.length; i++) {
				String[] volArr = (JSPUtil.getParameter(request, prefix	+ "vol"+tpszArr[i], length));
				String[] costArr = (JSPUtil.getParameter(request, prefix	+ "cost"+tpszArr[i], length));
				String[] flagArr = (JSPUtil.getParameter(request, prefix	+ "flag"+tpszArr[i], length));
				String[] unitcostArr = (JSPUtil.getParameter(request, prefix	+ "unitcost"+tpszArr[i], length));
				String[] fromcostArr = (JSPUtil.getParameter(request, prefix	+ "fromcost"+tpszArr[i], length));
				String[] tocostArr = (JSPUtil.getParameter(request, prefix	+ "tocost"+tpszArr[i], length));
				
				volListArr.add(volArr);
				costListArr.add(costArr);
				flagListArr.add(flagArr);
				unitcostListArr.add(unitcostArr);
				fromcostListArr.add(fromcostArr);
				tocostListArr.add(tocostArr);
			}
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0059MultiVO();
				
				List<String> tpszList = new ArrayList<String>();
				List<String> volList = new ArrayList<String>();
				List<String> costList = new ArrayList<String>();
				List<String> flagList = new ArrayList<String>();
				List<String> unitcostList = new ArrayList<String>();
				List<String> fromcostList = new ArrayList<String>();
				List<String> tocostList = new ArrayList<String>();
				for(int t=0; t<tpszArr.length; t++) {
					String[] volArr  = (String[])volListArr.get(t);
					String[] costArr = (String[])costListArr.get(t);
					String[] flagArr = (String[])flagListArr.get(t);
					String[] unitcostArr = (String[])unitcostListArr.get(t);
					String[] fromcostArr = (String[])fromcostListArr.get(t);
					String[] tocostArr = (String[])tocostListArr.get(t); 
					
					tpszList.add(tpszArr[t]);
					if(volArr[i] != null)
						volList.add(volArr[i]);
					if(costArr[i] != null)
						costList.add(costArr[i]);
					if(flagArr[i] != null)
						flagList.add(flagArr[i]);
					if(unitcostArr[i] != null)
						unitcostList.add(unitcostArr[i]);
					if(fromcostArr[i] != null)
						fromcostList.add(fromcostArr[i]);
					if(tocostArr[i] != null)
						tocostList.add(tocostArr[i]);
				}
				model.setTpszList(tpszList);
				model.setVolList(volList);
				model.setCostList(costList);
				model.setFlagList(flagList);
				model.setUnitcostList(unitcostList);
				model.setFromcostList(fromcostList);
				model.setTocostList(tocostList);

				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);				

				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);

				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				
				// VVD 분리
				if (vvd[i] != null && vvd[i].length() >= 9){
					model.setVslCd(vvd[i].substring(0,4));
					model.setSkdVoyNo(vvd[i].substring(4,8));
					model.setSkdDirCd(vvd[i].substring(8,9));
				}

				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (fmEtdDt[i] != null)
					model.setFmEtdDt(fmEtdDt[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (toEtbDt[i] != null)
					model.setToEtbDt(toEtbDt[i]);

				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (repoPlnFbRsnCd[i] != null)
					model.setRepoPlnFbRsnCd(repoPlnFbRsnCd[i]);
				if (eqRepoPurpCd[i] != null)
					model.setEqRepoPurpCd(eqRepoPurpCd[i]);
				if (mtyBkgNo[i] != null)
					model.setMtyBkgNo(mtyBkgNo[i]);
				if (repoPlnFbRmk[i] != null)
					model.setRepoPlnFbRmk(repoPlnFbRmk[i]);
				
				if (repoMtyBkgFlg[i] != null && repoMtyBkgFlg[i].equals("1")){
					model.setRepoMtyBkgFlg("Y");
				} else {
					model.setRepoMtyBkgFlg(null);
				}
				if (splitRepoPlnFlg [i] != null)
					model.setSplitRepoPlnFlg (splitRepoPlnFlg [i]);
				if (pastRepoPlnFlg[i] != null)
					model.setPastRepoPlnFlg(pastRepoPlnFlg[i]);

				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tpszNo[i] != null)
					model.setTpszNo(tpszNo[i]);
				if (cntrStatus[i] != null)
					model.setCntrStatus(cntrStatus[i]);
				if (frlocRcc[i] != null)
					model.setFrlocRcc(frlocRcc[i]);
				if (frlocEcc[i] != null)
					model.setFrlocEcc(frlocEcc[i]);
				if (tolocEcc[i] != null)
					model.setTolocEcc(tolocEcc[i]);
				if (repobkgFlag[i] != null)
					model.setRepobkgFlag(repobkgFlag[i]);
				if (cntrDel[i] != null)
					model.setCntrDel(cntrDel[i]);
				models.add(model);
			}
			
		} catch (Exception e) {
			return null;
		}
		
		return getEesEqr0059MultiVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return EesEqr0080MultiVO[]
	 */
	public EesEqr0059MultiVO[] getEesEqr0059MultiVOs(){
		EesEqr0059MultiVO[] vos = (EesEqr0059MultiVO[])models.toArray(new EesEqr0059MultiVO[models.size()]);
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
		this.repoMtyBkgFlg = this.repoMtyBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastRepoPlnFlg = this.pastRepoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtbDt = this.toEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDt = this.fmEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRsnCd = this.repoPlnFbRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoPurpCd = this.eqRepoPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frlocEcc = this.frlocEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frlocRcc = this.frlocRcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tolocEcc = this.tolocEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repobkgFlag = this.repobkgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDel = this.cntrDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszNo = this.tpszNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRmk = this.repoPlnFbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBkgGrpNo = this.oldBkgGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
