/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchAdjCostDtlListVO.java
*@FileTitle : SearchAdjCostDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.multidimensionrpt.vo;

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

public class SearchAdjCostDtlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAdjCostDtlListVO> models = new ArrayList<SearchAdjCostDtlListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String mtyCntrStvgRt = null;
	/* Column Info */
	private String mtyCntrStvgFnlAmt = null;
	/* Column Info */
	private String mtyCntrTrspAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String usaDmstSavCrAmt2 = null;
	/* Column Info */
	private String bizActAmt = null;
	/* Column Info */
	private String usaDmstSavCrAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyCntrTrspInclCrAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String usaDmstRepoAmt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bizActFnlAmt = null;
	/* Column Info */
	private String usaDmstRepoAmt2 = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String mtyCntrStvgAmt = null;
	/* Column Info */
	private String mtyCntrTrspRt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bizActAdjAmt = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String mtyCntrTrspFnlAmt = null;
	/* Column Info */
	private String mtyCntrTrspAdjAmt = null;
	/* Column Info */
	private String trspXcldCrFnlAmt = null;
	/* Column Info */
	private String bizActRt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String mtyCntrStvgAdjAmt = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAdjCostDtlListVO() {}

	public SearchAdjCostDtlListVO(String ibflag, String pagerows, String vslCd, String mtyCntrStvgRt, String mtyCntrTrspAmt, String mtyCntrStvgFnlAmt, String trdCd, String rlaneCd, String usaDmstSavCrAmt, String usaDmstSavCrAmt2, String usaDmstRepoAmt, String usaDmstRepoAmt2, String bizActAmt, String mtyCntrTrspInclCrAmt, String costYrmon, String dirCd, String bizActFnlAmt, String iocCd, String mtyCntrStvgAmt, String mtyCntrTrspRt, String skdVoyNo, String bizActAdjAmt, String slsYrmon, String mtyCntrTrspFnlAmt, String trspXcldCrFnlAmt, String mtyCntrTrspAdjAmt, String bizActRt, String costWk, String subTrdCd, String mtyCntrStvgAdjAmt) {
		this.vslCd = vslCd;
		this.mtyCntrStvgRt = mtyCntrStvgRt;
		this.mtyCntrStvgFnlAmt = mtyCntrStvgFnlAmt;
		this.mtyCntrTrspAmt = mtyCntrTrspAmt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.usaDmstSavCrAmt2 = usaDmstSavCrAmt2;
		this.bizActAmt = bizActAmt;
		this.usaDmstSavCrAmt = usaDmstSavCrAmt;
		this.pagerows = pagerows;
		this.mtyCntrTrspInclCrAmt = mtyCntrTrspInclCrAmt;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.usaDmstRepoAmt = usaDmstRepoAmt;
		this.dirCd = dirCd;
		this.bizActFnlAmt = bizActFnlAmt;
		this.usaDmstRepoAmt2 = usaDmstRepoAmt2;
		this.iocCd = iocCd;
		this.mtyCntrStvgAmt = mtyCntrStvgAmt;
		this.mtyCntrTrspRt = mtyCntrTrspRt;
		this.skdVoyNo = skdVoyNo;
		this.bizActAdjAmt = bizActAdjAmt;
		this.slsYrmon = slsYrmon;
		this.mtyCntrTrspFnlAmt = mtyCntrTrspFnlAmt;
		this.mtyCntrTrspAdjAmt = mtyCntrTrspAdjAmt;
		this.trspXcldCrFnlAmt = trspXcldCrFnlAmt;
		this.bizActRt = bizActRt;
		this.costWk = costWk;
		this.mtyCntrStvgAdjAmt = mtyCntrStvgAdjAmt;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("mty_cntr_stvg_rt", getMtyCntrStvgRt());
		this.hashColumns.put("mty_cntr_stvg_fnl_amt", getMtyCntrStvgFnlAmt());
		this.hashColumns.put("mty_cntr_trsp_amt", getMtyCntrTrspAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("usa_dmst_sav_cr_amt2", getUsaDmstSavCrAmt2());
		this.hashColumns.put("biz_act_amt", getBizActAmt());
		this.hashColumns.put("usa_dmst_sav_cr_amt", getUsaDmstSavCrAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mty_cntr_trsp_incl_cr_amt", getMtyCntrTrspInclCrAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("usa_dmst_repo_amt", getUsaDmstRepoAmt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("biz_act_fnl_amt", getBizActFnlAmt());
		this.hashColumns.put("usa_dmst_repo_amt2", getUsaDmstRepoAmt2());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("mty_cntr_stvg_amt", getMtyCntrStvgAmt());
		this.hashColumns.put("mty_cntr_trsp_rt", getMtyCntrTrspRt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("biz_act_adj_amt", getBizActAdjAmt());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("mty_cntr_trsp_fnl_amt", getMtyCntrTrspFnlAmt());
		this.hashColumns.put("mty_cntr_trsp_adj_amt", getMtyCntrTrspAdjAmt());
		this.hashColumns.put("trsp_xcld_cr_fnl_amt", getTrspXcldCrFnlAmt());
		this.hashColumns.put("biz_act_rt", getBizActRt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("mty_cntr_stvg_adj_amt", getMtyCntrStvgAdjAmt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("mty_cntr_stvg_rt", "mtyCntrStvgRt");
		this.hashFields.put("mty_cntr_stvg_fnl_amt", "mtyCntrStvgFnlAmt");
		this.hashFields.put("mty_cntr_trsp_amt", "mtyCntrTrspAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("usa_dmst_sav_cr_amt2", "usaDmstSavCrAmt2");
		this.hashFields.put("biz_act_amt", "bizActAmt");
		this.hashFields.put("usa_dmst_sav_cr_amt", "usaDmstSavCrAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mty_cntr_trsp_incl_cr_amt", "mtyCntrTrspInclCrAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("usa_dmst_repo_amt", "usaDmstRepoAmt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("biz_act_fnl_amt", "bizActFnlAmt");
		this.hashFields.put("usa_dmst_repo_amt2", "usaDmstRepoAmt2");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("mty_cntr_stvg_amt", "mtyCntrStvgAmt");
		this.hashFields.put("mty_cntr_trsp_rt", "mtyCntrTrspRt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("biz_act_adj_amt", "bizActAdjAmt");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("mty_cntr_trsp_fnl_amt", "mtyCntrTrspFnlAmt");
		this.hashFields.put("mty_cntr_trsp_adj_amt", "mtyCntrTrspAdjAmt");
		this.hashFields.put("trsp_xcld_cr_fnl_amt", "trspXcldCrFnlAmt");
		this.hashFields.put("biz_act_rt", "bizActRt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("mty_cntr_stvg_adj_amt", "mtyCntrStvgAdjAmt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrStvgRt
	 */
	public String getMtyCntrStvgRt() {
		return this.mtyCntrStvgRt;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrStvgFnlAmt
	 */
	public String getMtyCntrStvgFnlAmt() {
		return this.mtyCntrStvgFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrTrspAmt
	 */
	public String getMtyCntrTrspAmt() {
		return this.mtyCntrTrspAmt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return usaDmstSavCrAmt2
	 */
	public String getUsaDmstSavCrAmt2() {
		return this.usaDmstSavCrAmt2;
	}
	
	/**
	 * Column Info
	 * @return bizActAmt
	 */
	public String getBizActAmt() {
		return this.bizActAmt;
	}
	
	/**
	 * Column Info
	 * @return usaDmstSavCrAmt
	 */
	public String getUsaDmstSavCrAmt() {
		return this.usaDmstSavCrAmt;
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
	 * @return mtyCntrTrspInclCrAmt
	 */
	public String getMtyCntrTrspInclCrAmt() {
		return this.mtyCntrTrspInclCrAmt;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return usaDmstRepoAmt
	 */
	public String getUsaDmstRepoAmt() {
		return this.usaDmstRepoAmt;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return bizActFnlAmt
	 */
	public String getBizActFnlAmt() {
		return this.bizActFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return usaDmstRepoAmt2
	 */
	public String getUsaDmstRepoAmt2() {
		return this.usaDmstRepoAmt2;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrStvgAmt
	 */
	public String getMtyCntrStvgAmt() {
		return this.mtyCntrStvgAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrTrspRt
	 */
	public String getMtyCntrTrspRt() {
		return this.mtyCntrTrspRt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bizActAdjAmt
	 */
	public String getBizActAdjAmt() {
		return this.bizActAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrTrspFnlAmt
	 */
	public String getMtyCntrTrspFnlAmt() {
		return this.mtyCntrTrspFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrTrspAdjAmt
	 */
	public String getMtyCntrTrspAdjAmt() {
		return this.mtyCntrTrspAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return trspXcldCrFnlAmt
	 */
	public String getTrspXcldCrFnlAmt() {
		return this.trspXcldCrFnlAmt;
	}
	
	/**
	 * Column Info
	 * @return bizActRt
	 */
	public String getBizActRt() {
		return this.bizActRt;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return mtyCntrStvgAdjAmt
	 */
	public String getMtyCntrStvgAdjAmt() {
		return this.mtyCntrStvgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrStvgRt
	 */
	public void setMtyCntrStvgRt(String mtyCntrStvgRt) {
		this.mtyCntrStvgRt = mtyCntrStvgRt;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrStvgFnlAmt
	 */
	public void setMtyCntrStvgFnlAmt(String mtyCntrStvgFnlAmt) {
		this.mtyCntrStvgFnlAmt = mtyCntrStvgFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrTrspAmt
	 */
	public void setMtyCntrTrspAmt(String mtyCntrTrspAmt) {
		this.mtyCntrTrspAmt = mtyCntrTrspAmt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param usaDmstSavCrAmt2
	 */
	public void setUsaDmstSavCrAmt2(String usaDmstSavCrAmt2) {
		this.usaDmstSavCrAmt2 = usaDmstSavCrAmt2;
	}
	
	/**
	 * Column Info
	 * @param bizActAmt
	 */
	public void setBizActAmt(String bizActAmt) {
		this.bizActAmt = bizActAmt;
	}
	
	/**
	 * Column Info
	 * @param usaDmstSavCrAmt
	 */
	public void setUsaDmstSavCrAmt(String usaDmstSavCrAmt) {
		this.usaDmstSavCrAmt = usaDmstSavCrAmt;
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
	 * @param mtyCntrTrspInclCrAmt
	 */
	public void setMtyCntrTrspInclCrAmt(String mtyCntrTrspInclCrAmt) {
		this.mtyCntrTrspInclCrAmt = mtyCntrTrspInclCrAmt;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param usaDmstRepoAmt
	 */
	public void setUsaDmstRepoAmt(String usaDmstRepoAmt) {
		this.usaDmstRepoAmt = usaDmstRepoAmt;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param bizActFnlAmt
	 */
	public void setBizActFnlAmt(String bizActFnlAmt) {
		this.bizActFnlAmt = bizActFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param usaDmstRepoAmt2
	 */
	public void setUsaDmstRepoAmt2(String usaDmstRepoAmt2) {
		this.usaDmstRepoAmt2 = usaDmstRepoAmt2;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrStvgAmt
	 */
	public void setMtyCntrStvgAmt(String mtyCntrStvgAmt) {
		this.mtyCntrStvgAmt = mtyCntrStvgAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrTrspRt
	 */
	public void setMtyCntrTrspRt(String mtyCntrTrspRt) {
		this.mtyCntrTrspRt = mtyCntrTrspRt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bizActAdjAmt
	 */
	public void setBizActAdjAmt(String bizActAdjAmt) {
		this.bizActAdjAmt = bizActAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrTrspFnlAmt
	 */
	public void setMtyCntrTrspFnlAmt(String mtyCntrTrspFnlAmt) {
		this.mtyCntrTrspFnlAmt = mtyCntrTrspFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrTrspAdjAmt
	 */
	public void setMtyCntrTrspAdjAmt(String mtyCntrTrspAdjAmt) {
		this.mtyCntrTrspAdjAmt = mtyCntrTrspAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param trspXcldCrFnlAmt
	 */
	public void setTrspXcldCrFnlAmt(String trspXcldCrFnlAmt) {
		this.trspXcldCrFnlAmt = trspXcldCrFnlAmt;
	}
	
	/**
	 * Column Info
	 * @param bizActRt
	 */
	public void setBizActRt(String bizActRt) {
		this.bizActRt = bizActRt;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param mtyCntrStvgAdjAmt
	 */
	public void setMtyCntrStvgAdjAmt(String mtyCntrStvgAdjAmt) {
		this.mtyCntrStvgAdjAmt = mtyCntrStvgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setMtyCntrStvgRt(JSPUtil.getParameter(request, prefix + "mty_cntr_stvg_rt", ""));
		setMtyCntrStvgFnlAmt(JSPUtil.getParameter(request, prefix + "mty_cntr_stvg_fnl_amt", ""));
		setMtyCntrTrspAmt(JSPUtil.getParameter(request, prefix + "mty_cntr_trsp_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setUsaDmstSavCrAmt2(JSPUtil.getParameter(request, prefix + "usa_dmst_sav_cr_amt2", ""));
		setBizActAmt(JSPUtil.getParameter(request, prefix + "biz_act_amt", ""));
		setUsaDmstSavCrAmt(JSPUtil.getParameter(request, prefix + "usa_dmst_sav_cr_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMtyCntrTrspInclCrAmt(JSPUtil.getParameter(request, prefix + "mty_cntr_trsp_incl_cr_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setUsaDmstRepoAmt(JSPUtil.getParameter(request, prefix + "usa_dmst_repo_amt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBizActFnlAmt(JSPUtil.getParameter(request, prefix + "biz_act_fnl_amt", ""));
		setUsaDmstRepoAmt2(JSPUtil.getParameter(request, prefix + "usa_dmst_repo_amt2", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setMtyCntrStvgAmt(JSPUtil.getParameter(request, prefix + "mty_cntr_stvg_amt", ""));
		setMtyCntrTrspRt(JSPUtil.getParameter(request, prefix + "mty_cntr_trsp_rt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setBizActAdjAmt(JSPUtil.getParameter(request, prefix + "biz_act_adj_amt", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setMtyCntrTrspFnlAmt(JSPUtil.getParameter(request, prefix + "mty_cntr_trsp_fnl_amt", ""));
		setMtyCntrTrspAdjAmt(JSPUtil.getParameter(request, prefix + "mty_cntr_trsp_adj_amt", ""));
		setTrspXcldCrFnlAmt(JSPUtil.getParameter(request, prefix + "trsp_xcld_cr_fnl_amt", ""));
		setBizActRt(JSPUtil.getParameter(request, prefix + "biz_act_rt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setMtyCntrStvgAdjAmt(JSPUtil.getParameter(request, prefix + "mty_cntr_stvg_adj_amt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAdjCostDtlListVO[]
	 */
	public SearchAdjCostDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAdjCostDtlListVO[]
	 */
	public SearchAdjCostDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAdjCostDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] mtyCntrStvgRt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_stvg_rt", length));
			String[] mtyCntrStvgFnlAmt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_stvg_fnl_amt", length));
			String[] mtyCntrTrspAmt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_trsp_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] usaDmstSavCrAmt2 = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_sav_cr_amt2", length));
			String[] bizActAmt = (JSPUtil.getParameter(request, prefix	+ "biz_act_amt", length));
			String[] usaDmstSavCrAmt = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_sav_cr_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtyCntrTrspInclCrAmt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_trsp_incl_cr_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] usaDmstRepoAmt = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_repo_amt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bizActFnlAmt = (JSPUtil.getParameter(request, prefix	+ "biz_act_fnl_amt", length));
			String[] usaDmstRepoAmt2 = (JSPUtil.getParameter(request, prefix	+ "usa_dmst_repo_amt2", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] mtyCntrStvgAmt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_stvg_amt", length));
			String[] mtyCntrTrspRt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_trsp_rt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bizActAdjAmt = (JSPUtil.getParameter(request, prefix	+ "biz_act_adj_amt", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] mtyCntrTrspFnlAmt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_trsp_fnl_amt", length));
			String[] mtyCntrTrspAdjAmt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_trsp_adj_amt", length));
			String[] trspXcldCrFnlAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_xcld_cr_fnl_amt", length));
			String[] bizActRt = (JSPUtil.getParameter(request, prefix	+ "biz_act_rt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] mtyCntrStvgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "mty_cntr_stvg_adj_amt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAdjCostDtlListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (mtyCntrStvgRt[i] != null)
					model.setMtyCntrStvgRt(mtyCntrStvgRt[i]);
				if (mtyCntrStvgFnlAmt[i] != null)
					model.setMtyCntrStvgFnlAmt(mtyCntrStvgFnlAmt[i]);
				if (mtyCntrTrspAmt[i] != null)
					model.setMtyCntrTrspAmt(mtyCntrTrspAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (usaDmstSavCrAmt2[i] != null)
					model.setUsaDmstSavCrAmt2(usaDmstSavCrAmt2[i]);
				if (bizActAmt[i] != null)
					model.setBizActAmt(bizActAmt[i]);
				if (usaDmstSavCrAmt[i] != null)
					model.setUsaDmstSavCrAmt(usaDmstSavCrAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtyCntrTrspInclCrAmt[i] != null)
					model.setMtyCntrTrspInclCrAmt(mtyCntrTrspInclCrAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (usaDmstRepoAmt[i] != null)
					model.setUsaDmstRepoAmt(usaDmstRepoAmt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bizActFnlAmt[i] != null)
					model.setBizActFnlAmt(bizActFnlAmt[i]);
				if (usaDmstRepoAmt2[i] != null)
					model.setUsaDmstRepoAmt2(usaDmstRepoAmt2[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (mtyCntrStvgAmt[i] != null)
					model.setMtyCntrStvgAmt(mtyCntrStvgAmt[i]);
				if (mtyCntrTrspRt[i] != null)
					model.setMtyCntrTrspRt(mtyCntrTrspRt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bizActAdjAmt[i] != null)
					model.setBizActAdjAmt(bizActAdjAmt[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (mtyCntrTrspFnlAmt[i] != null)
					model.setMtyCntrTrspFnlAmt(mtyCntrTrspFnlAmt[i]);
				if (mtyCntrTrspAdjAmt[i] != null)
					model.setMtyCntrTrspAdjAmt(mtyCntrTrspAdjAmt[i]);
				if (trspXcldCrFnlAmt[i] != null)
					model.setTrspXcldCrFnlAmt(trspXcldCrFnlAmt[i]);
				if (bizActRt[i] != null)
					model.setBizActRt(bizActRt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (mtyCntrStvgAdjAmt[i] != null)
					model.setMtyCntrStvgAdjAmt(mtyCntrStvgAdjAmt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAdjCostDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAdjCostDtlListVO[]
	 */
	public SearchAdjCostDtlListVO[] getSearchAdjCostDtlListVOs(){
		SearchAdjCostDtlListVO[] vos = (SearchAdjCostDtlListVO[])models.toArray(new SearchAdjCostDtlListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrStvgRt = this.mtyCntrStvgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrStvgFnlAmt = this.mtyCntrStvgFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrTrspAmt = this.mtyCntrTrspAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstSavCrAmt2 = this.usaDmstSavCrAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActAmt = this.bizActAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstSavCrAmt = this.usaDmstSavCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrTrspInclCrAmt = this.mtyCntrTrspInclCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstRepoAmt = this.usaDmstRepoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActFnlAmt = this.bizActFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaDmstRepoAmt2 = this.usaDmstRepoAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrStvgAmt = this.mtyCntrStvgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrTrspRt = this.mtyCntrTrspRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActAdjAmt = this.bizActAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrTrspFnlAmt = this.mtyCntrTrspFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrTrspAdjAmt = this.mtyCntrTrspAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspXcldCrFnlAmt = this.trspXcldCrFnlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizActRt = this.bizActRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCntrStvgAdjAmt = this.mtyCntrStvgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
