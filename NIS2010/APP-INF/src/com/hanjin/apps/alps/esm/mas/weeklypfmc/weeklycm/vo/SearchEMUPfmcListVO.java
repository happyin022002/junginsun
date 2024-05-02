/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchEMUPfmcListVO.java
*@FileTitle : SearchEMUPfmcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.04.13 최성민 
* 1.0 Creation
* 2013.09.04 김수정 [CHM-201326480] EMU_RA 화면 MB Data 없는 경우 Pre Simulation 화면과 동일 조건으로 Data 조회하도록 변경
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEMUPfmcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEMUPfmcListVO> models = new ArrayList<SearchEMUPfmcListVO>();
	
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String delEqRepoCrRto = null;
	/* Column Info */
	private String podEccCd = null;
	/* Column Info */
	private String porRto = null;
	/* Column Info */
	private String simMtyCostAmtPod = null;
	/* Column Info */
	private String opEqRepoCrRto = null;
	/* Column Info */
	private String delSts = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String delStg = null;
	/* Column Info */
	private String delRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String opStg = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bseUtAmt = null;
	/* Column Info */
	private String simMtyCostAmtPor = null;
	/* Column Info */
	private String porSts = null;
	/* Column Info */
	private String costLocGrpCd = null;
	/* Column Info */
	private String repoUtAmtDel = null;
	/* Column Info */
	private String simMtyCostAmtTtl = null;
	/* Column Info */
	private String repoUtAmtPor = null;
	/* Column Info */
	private String emuAdjMtyCostAmtTtl = null;
	/* Column Info */
	private String mnlRqstFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEMUPfmcListVO() {}

	public SearchEMUPfmcListVO(String ibflag, String pagerows, String costYrmon, String orgLocCd, String podEccCd, String destLocCd, String cntrTpszCd, String repoUtAmtPor, String repoUtAmtDel, String bseUtAmt, String simMtyCostAmtPor, String simMtyCostAmtPod, String simMtyCostAmtTtl, String costLocGrpCd, String opStg, String delStg, String opEqRepoCrRto, String delEqRepoCrRto, String porSts, String porRto, String delSts, String delRto, String emuAdjMtyCostAmtTtl, String mnlRqstFlg) {
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.delEqRepoCrRto = delEqRepoCrRto;
		this.podEccCd = podEccCd;
		this.porRto = porRto;
		this.simMtyCostAmtPod = simMtyCostAmtPod;
		this.opEqRepoCrRto = opEqRepoCrRto;
		this.delSts = delSts;
		this.pagerows = pagerows;
		this.delStg = delStg;
		this.delRto = delRto;
		this.ibflag = ibflag;
		this.opStg = opStg;
		this.costYrmon = costYrmon;
		this.cntrTpszCd = cntrTpszCd;
		this.bseUtAmt = bseUtAmt;
		this.simMtyCostAmtPor = simMtyCostAmtPor;
		this.porSts = porSts;
		this.costLocGrpCd = costLocGrpCd;
		this.repoUtAmtDel = repoUtAmtDel;
		this.simMtyCostAmtTtl = simMtyCostAmtTtl;
		this.repoUtAmtPor = repoUtAmtPor;
		this.emuAdjMtyCostAmtTtl = emuAdjMtyCostAmtTtl;
		this.mnlRqstFlg = mnlRqstFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("del_eq_repo_cr_rto", getDelEqRepoCrRto());
		this.hashColumns.put("pod_ecc_cd", getPodEccCd());
		this.hashColumns.put("por_rto", getPorRto());
		this.hashColumns.put("sim_mty_cost_amt_pod", getSimMtyCostAmtPod());
		this.hashColumns.put("op_eq_repo_cr_rto", getOpEqRepoCrRto());
		this.hashColumns.put("del_sts", getDelSts());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("del_stg", getDelStg());
		this.hashColumns.put("del_rto", getDelRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("op_stg", getOpStg());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bse_ut_amt", getBseUtAmt());
		this.hashColumns.put("sim_mty_cost_amt_por", getSimMtyCostAmtPor());
		this.hashColumns.put("por_sts", getPorSts());
		this.hashColumns.put("cost_loc_grp_cd", getCostLocGrpCd());
		this.hashColumns.put("repo_ut_amt_del", getRepoUtAmtDel());
		this.hashColumns.put("sim_mty_cost_amt_ttl", getSimMtyCostAmtTtl());
		this.hashColumns.put("repo_ut_amt_por", getRepoUtAmtPor());
		this.hashColumns.put("emu_adj_mty_cost_amt_ttl", getEmuAdjMtyCostAmtTtl());
		this.hashColumns.put("mnl_rqst_flg", getMnlRqstFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("del_eq_repo_cr_rto", "delEqRepoCrRto");
		this.hashFields.put("pod_ecc_cd", "podEccCd");
		this.hashFields.put("por_rto", "porRto");
		this.hashFields.put("sim_mty_cost_amt_pod", "simMtyCostAmtPod");
		this.hashFields.put("op_eq_repo_cr_rto", "opEqRepoCrRto");
		this.hashFields.put("del_sts", "delSts");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("del_stg", "delStg");
		this.hashFields.put("del_rto", "delRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("op_stg", "opStg");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bse_ut_amt", "bseUtAmt");
		this.hashFields.put("sim_mty_cost_amt_por", "simMtyCostAmtPor");
		this.hashFields.put("por_sts", "porSts");
		this.hashFields.put("cost_loc_grp_cd", "costLocGrpCd");
		this.hashFields.put("repo_ut_amt_del", "repoUtAmtDel");
		this.hashFields.put("sim_mty_cost_amt_ttl", "simMtyCostAmtTtl");
		this.hashFields.put("repo_ut_amt_por", "repoUtAmtPor");
		this.hashFields.put("emu_adj_mty_cost_amt_ttl", "emuAdjMtyCostAmtTtl");
		this.hashFields.put("mnl_rqst_flg", "mnlRqstFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}
	
	/**
	 * Column Info
	 * @return delEqRepoCrRto
	 */
	public String getDelEqRepoCrRto() {
		return this.delEqRepoCrRto;
	}
	
	/**
	 * Column Info
	 * @return podEccCd
	 */
	public String getPodEccCd() {
		return this.podEccCd;
	}
	
	/**
	 * Column Info
	 * @return porRto
	 */
	public String getPorRto() {
		return this.porRto;
	}
	
	/**
	 * Column Info
	 * @return simMtyCostAmtPod
	 */
	public String getSimMtyCostAmtPod() {
		return this.simMtyCostAmtPod;
	}
	
	/**
	 * Column Info
	 * @return opEqRepoCrRto
	 */
	public String getOpEqRepoCrRto() {
		return this.opEqRepoCrRto;
	}
	
	/**
	 * Column Info
	 * @return delSts
	 */
	public String getDelSts() {
		return this.delSts;
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
	 * @return delStg
	 */
	public String getDelStg() {
		return this.delStg;
	}
	
	/**
	 * Column Info
	 * @return delRto
	 */
	public String getDelRto() {
		return this.delRto;
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
	 * @return opStg
	 */
	public String getOpStg() {
		return this.opStg;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
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
	 * @return bseUtAmt
	 */
	public String getBseUtAmt() {
		return this.bseUtAmt;
	}
	
	/**
	 * Column Info
	 * @return simMtyCostAmtPor
	 */
	public String getSimMtyCostAmtPor() {
		return this.simMtyCostAmtPor;
	}
	
	/**
	 * Column Info
	 * @return porSts
	 */
	public String getPorSts() {
		return this.porSts;
	}
	
	/**
	 * Column Info
	 * @return costLocGrpCd
	 */
	public String getCostLocGrpCd() {
		return this.costLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @return repoUtAmtDel
	 */
	public String getRepoUtAmtDel() {
		return this.repoUtAmtDel;
	}
	
	/**
	 * Column Info
	 * @return simMtyCostAmtTtl
	 */
	public String getSimMtyCostAmtTtl() {
		return this.simMtyCostAmtTtl;
	}
	
	/**
	 * Column Info
	 * @return repoUtAmtPor
	 */
	public String getRepoUtAmtPor() {
		return this.repoUtAmtPor;
	}
	
	/**
	 * Column Info
	 * @return emuAdjMtyCostAmtTtl
	 */
	public String getEmuAdjMtyCostAmtTtl() {
		return this.emuAdjMtyCostAmtTtl;
	}
	
	/**
	 * Column Info
	 * @return mnlRqstFlg
	 */
	public String getMnlRqstFlg() {
		return this.mnlRqstFlg;
	}
	

	/**
	 * Column Info
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}
	
	/**
	 * Column Info
	 * @param delEqRepoCrRto
	 */
	public void setDelEqRepoCrRto(String delEqRepoCrRto) {
		this.delEqRepoCrRto = delEqRepoCrRto;
	}
	
	/**
	 * Column Info
	 * @param podEccCd
	 */
	public void setPodEccCd(String podEccCd) {
		this.podEccCd = podEccCd;
	}
	
	/**
	 * Column Info
	 * @param porRto
	 */
	public void setPorRto(String porRto) {
		this.porRto = porRto;
	}
	
	/**
	 * Column Info
	 * @param simMtyCostAmtPod
	 */
	public void setSimMtyCostAmtPod(String simMtyCostAmtPod) {
		this.simMtyCostAmtPod = simMtyCostAmtPod;
	}
	
	/**
	 * Column Info
	 * @param opEqRepoCrRto
	 */
	public void setOpEqRepoCrRto(String opEqRepoCrRto) {
		this.opEqRepoCrRto = opEqRepoCrRto;
	}
	
	/**
	 * Column Info
	 * @param delSts
	 */
	public void setDelSts(String delSts) {
		this.delSts = delSts;
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
	 * @param delStg
	 */
	public void setDelStg(String delStg) {
		this.delStg = delStg;
	}
	
	/**
	 * Column Info
	 * @param delRto
	 */
	public void setDelRto(String delRto) {
		this.delRto = delRto;
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
	 * @param opStg
	 */
	public void setOpStg(String opStg) {
		this.opStg = opStg;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	 * @param bseUtAmt
	 */
	public void setBseUtAmt(String bseUtAmt) {
		this.bseUtAmt = bseUtAmt;
	}
	
	/**
	 * Column Info
	 * @param simMtyCostAmtPor
	 */
	public void setSimMtyCostAmtPor(String simMtyCostAmtPor) {
		this.simMtyCostAmtPor = simMtyCostAmtPor;
	}
	
	/**
	 * Column Info
	 * @param porSts
	 */
	public void setPorSts(String porSts) {
		this.porSts = porSts;
	}
	
	/**
	 * Column Info
	 * @param costLocGrpCd
	 */
	public void setCostLocGrpCd(String costLocGrpCd) {
		this.costLocGrpCd = costLocGrpCd;
	}
	
	/**
	 * Column Info
	 * @param repoUtAmtDel
	 */
	public void setRepoUtAmtDel(String repoUtAmtDel) {
		this.repoUtAmtDel = repoUtAmtDel;
	}
	
	/**
	 * Column Info
	 * @param simMtyCostAmtTtl
	 */
	public void setSimMtyCostAmtTtl(String simMtyCostAmtTtl) {
		this.simMtyCostAmtTtl = simMtyCostAmtTtl;
	}
	
	/**
	 * Column Info
	 * @param repoUtAmtPor
	 */
	public void setRepoUtAmtPor(String repoUtAmtPor) {
		this.repoUtAmtPor = repoUtAmtPor;
	}
	
	/**
	 * Column Info
	 * @param emuAdjMtyCostAmtTtl
	 */
	public void setEmuAdjMtyCostAmtTtl(String emuAdjMtyCostAmtTtl) {
		this.emuAdjMtyCostAmtTtl = emuAdjMtyCostAmtTtl;
	}
	
	/**
	 * Column Info
	 * @param mnlRqstFlg
	 */
	public void setMnlRqstFlg(String mnlRqstFlg) {
		this.mnlRqstFlg = mnlRqstFlg;
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
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setDelEqRepoCrRto(JSPUtil.getParameter(request, prefix + "del_eq_repo_cr_rto", ""));
		setPodEccCd(JSPUtil.getParameter(request, prefix + "pod_ecc_cd", ""));
		setPorRto(JSPUtil.getParameter(request, prefix + "por_rto", ""));
		setSimMtyCostAmtPod(JSPUtil.getParameter(request, prefix + "sim_mty_cost_amt_pod", ""));
		setOpEqRepoCrRto(JSPUtil.getParameter(request, prefix + "op_eq_repo_cr_rto", ""));
		setDelSts(JSPUtil.getParameter(request, prefix + "del_sts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDelStg(JSPUtil.getParameter(request, prefix + "del_stg", ""));
		setDelRto(JSPUtil.getParameter(request, prefix + "del_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOpStg(JSPUtil.getParameter(request, prefix + "op_stg", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setBseUtAmt(JSPUtil.getParameter(request, prefix + "bse_ut_amt", ""));
		setSimMtyCostAmtPor(JSPUtil.getParameter(request, prefix + "sim_mty_cost_amt_por", ""));
		setPorSts(JSPUtil.getParameter(request, prefix + "por_sts", ""));
		setCostLocGrpCd(JSPUtil.getParameter(request, prefix + "cost_loc_grp_cd", ""));
		setRepoUtAmtDel(JSPUtil.getParameter(request, prefix + "repo_ut_amt_del", ""));
		setSimMtyCostAmtTtl(JSPUtil.getParameter(request, prefix + "sim_mty_cost_amt_ttl", ""));
		setRepoUtAmtPor(JSPUtil.getParameter(request, prefix + "repo_ut_amt_por", ""));
		setEmuAdjMtyCostAmtTtl(JSPUtil.getParameter(request, prefix + "emu_adj_mty_cost_amt_ttl", ""));
		setMnlRqstFlg(JSPUtil.getParameter(request, prefix + "mnl_rqst_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEMUPfmcListVO[]
	 */
	public SearchEMUPfmcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEMUPfmcListVO[]
	 */
	public SearchEMUPfmcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEMUPfmcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix	+ "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] delEqRepoCrRto = (JSPUtil.getParameter(request, prefix	+ "del_eq_repo_cr_rto", length));
			String[] podEccCd = (JSPUtil.getParameter(request, prefix	+ "pod_ecc_cd", length));
			String[] porRto = (JSPUtil.getParameter(request, prefix	+ "por_rto", length));
			String[] simMtyCostAmtPod = (JSPUtil.getParameter(request, prefix	+ "sim_mty_cost_amt_pod", length));
			String[] opEqRepoCrRto = (JSPUtil.getParameter(request, prefix	+ "op_eq_repo_cr_rto", length));
			String[] delSts = (JSPUtil.getParameter(request, prefix	+ "del_sts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] delStg = (JSPUtil.getParameter(request, prefix	+ "del_stg", length));
			String[] delRto = (JSPUtil.getParameter(request, prefix	+ "del_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] opStg = (JSPUtil.getParameter(request, prefix	+ "op_stg", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bseUtAmt = (JSPUtil.getParameter(request, prefix	+ "bse_ut_amt", length));
			String[] simMtyCostAmtPor = (JSPUtil.getParameter(request, prefix	+ "sim_mty_cost_amt_por", length));
			String[] porSts = (JSPUtil.getParameter(request, prefix	+ "por_sts", length));
			String[] costLocGrpCd = (JSPUtil.getParameter(request, prefix	+ "cost_loc_grp_cd", length));
			String[] repoUtAmtDel = (JSPUtil.getParameter(request, prefix	+ "repo_ut_amt_del", length));
			String[] simMtyCostAmtTtl = (JSPUtil.getParameter(request, prefix	+ "sim_mty_cost_amt_ttl", length));
			String[] repoUtAmtPor = (JSPUtil.getParameter(request, prefix	+ "repo_ut_amt_por", length));
			String[] emuAdjMtyCostAmtTtl = (JSPUtil.getParameter(request, prefix	+ "emu_adj_mty_cost_amt_ttl", length));
			String[] mnlRqstFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_rqst_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEMUPfmcListVO();
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (delEqRepoCrRto[i] != null)
					model.setDelEqRepoCrRto(delEqRepoCrRto[i]);
				if (podEccCd[i] != null)
					model.setPodEccCd(podEccCd[i]);
				if (porRto[i] != null)
					model.setPorRto(porRto[i]);
				if (simMtyCostAmtPod[i] != null)
					model.setSimMtyCostAmtPod(simMtyCostAmtPod[i]);
				if (opEqRepoCrRto[i] != null)
					model.setOpEqRepoCrRto(opEqRepoCrRto[i]);
				if (delSts[i] != null)
					model.setDelSts(delSts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (delStg[i] != null)
					model.setDelStg(delStg[i]);
				if (delRto[i] != null)
					model.setDelRto(delRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (opStg[i] != null)
					model.setOpStg(opStg[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bseUtAmt[i] != null)
					model.setBseUtAmt(bseUtAmt[i]);
				if (simMtyCostAmtPor[i] != null)
					model.setSimMtyCostAmtPor(simMtyCostAmtPor[i]);
				if (porSts[i] != null)
					model.setPorSts(porSts[i]);
				if (costLocGrpCd[i] != null)
					model.setCostLocGrpCd(costLocGrpCd[i]);
				if (repoUtAmtDel[i] != null)
					model.setRepoUtAmtDel(repoUtAmtDel[i]);
				if (simMtyCostAmtTtl[i] != null)
					model.setSimMtyCostAmtTtl(simMtyCostAmtTtl[i]);
				if (repoUtAmtPor[i] != null)
					model.setRepoUtAmtPor(repoUtAmtPor[i]);
				if (emuAdjMtyCostAmtTtl[i] != null)
					model.setEmuAdjMtyCostAmtTtl(emuAdjMtyCostAmtTtl[i]);
				if (mnlRqstFlg[i] != null)
					model.setMnlRqstFlg(mnlRqstFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEMUPfmcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEMUPfmcListVO[]
	 */
	public SearchEMUPfmcListVO[] getSearchEMUPfmcListVOs(){
		SearchEMUPfmcListVO[] vos = (SearchEMUPfmcListVO[])models.toArray(new SearchEMUPfmcListVO[models.size()]);
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
		this.orgLocCd = this.orgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEqRepoCrRto = this.delEqRepoCrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEccCd = this.podEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRto = this.porRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simMtyCostAmtPod = this.simMtyCostAmtPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opEqRepoCrRto = this.opEqRepoCrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSts = this.delSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delStg = this.delStg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRto = this.delRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opStg = this.opStg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseUtAmt = this.bseUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simMtyCostAmtPor = this.simMtyCostAmtPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porSts = this.porSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costLocGrpCd = this.costLocGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoUtAmtDel = this.repoUtAmtDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simMtyCostAmtTtl = this.simMtyCostAmtTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoUtAmtPor = this.repoUtAmtPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emuAdjMtyCostAmtTtl = this.emuAdjMtyCostAmtTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlRqstFlg = this.mnlRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
