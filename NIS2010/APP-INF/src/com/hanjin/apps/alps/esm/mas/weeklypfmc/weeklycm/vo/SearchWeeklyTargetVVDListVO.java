/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchWeeklyTargetVVDListVO.java
*@FileTitle : SearchWeeklyTargetVVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchWeeklyTargetVVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchWeeklyTargetVVDListVO> models = new ArrayList<SearchWeeklyTargetVVDListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String oldBsaZrFlg = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String wkyTgtFlg = null;
	/* Column Info */
	private String oldCostWk = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String bsaZrFlg = null;
	/* Column Info */
	private String n1stLodgPortEtdDt = null;
	/* Column Info */
	private String wkyMnlFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String vslLaneTpCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String monTgtFlg = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchWeeklyTargetVVDListVO() {}

	public SearchWeeklyTargetVVDListVO(String ibflag, String pagerows, String bsaZrFlg, String costYrmon, String slsYrmon, String costWk, String trdCd, String subTrdCd, String slanCd, String rlaneCd, String vslLaneTpCd, String vslCd, String skdVoyNo, String dirCd, String hulBndCd, String iocCd, String lstLodgPortCd, String lstLodgPortEtdDt, String n1stLodgPortEtdDt, String wkyTgtFlg, String wkyMnlFlg, String monTgtFlg, String deltFlg, String vopCd, String oldCostWk, String oldBsaZrFlg) {
		this.vslCd = vslCd;
		this.deltFlg = deltFlg;
		this.oldBsaZrFlg = oldBsaZrFlg;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.wkyTgtFlg = wkyTgtFlg;
		this.oldCostWk = oldCostWk;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.bsaZrFlg = bsaZrFlg;
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
		this.wkyMnlFlg = wkyMnlFlg;
		this.dirCd = dirCd;
		this.lstLodgPortCd = lstLodgPortCd;
		this.vslLaneTpCd = vslLaneTpCd;
		this.iocCd = iocCd;
		this.monTgtFlg = monTgtFlg;
		this.hulBndCd = hulBndCd;
		this.vopCd = vopCd;
		this.skdVoyNo = skdVoyNo;
		this.slsYrmon = slsYrmon;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.slanCd = slanCd;
		this.costWk = costWk;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("old_bsa_zr_flg", getOldBsaZrFlg());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("wky_tgt_flg", getWkyTgtFlg());
		this.hashColumns.put("old_cost_wk", getOldCostWk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("bsa_zr_flg", getBsaZrFlg());
		this.hashColumns.put("n1st_lodg_port_etd_dt", getN1stLodgPortEtdDt());
		this.hashColumns.put("wky_mnl_flg", getWkyMnlFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("vsl_lane_tp_cd", getVslLaneTpCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("mon_tgt_flg", getMonTgtFlg());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("old_bsa_zr_flg", "oldBsaZrFlg");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("wky_tgt_flg", "wkyTgtFlg");
		this.hashFields.put("old_cost_wk", "oldCostWk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("bsa_zr_flg", "bsaZrFlg");
		this.hashFields.put("n1st_lodg_port_etd_dt", "n1stLodgPortEtdDt");
		this.hashFields.put("wky_mnl_flg", "wkyMnlFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("vsl_lane_tp_cd", "vslLaneTpCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("mon_tgt_flg", "monTgtFlg");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cost_wk", "costWk");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return oldBsaZrFlg
	 */
	public String getOldBsaZrFlg() {
		return this.oldBsaZrFlg;
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
	 * @return wkyTgtFlg
	 */
	public String getWkyTgtFlg() {
		return this.wkyTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return oldCostWk
	 */
	public String getOldCostWk() {
		return this.oldCostWk;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return bsaZrFlg
	 */
	public String getBsaZrFlg() {
		return this.bsaZrFlg;
	}
	
	/**
	 * Column Info
	 * @return n1stLodgPortEtdDt
	 */
	public String getN1stLodgPortEtdDt() {
		return this.n1stLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return wkyMnlFlg
	 */
	public String getWkyMnlFlg() {
		return this.wkyMnlFlg;
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
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @return vslLaneTpCd
	 */
	public String getVslLaneTpCd() {
		return this.vslLaneTpCd;
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
	 * @return monTgtFlg
	 */
	public String getMonTgtFlg() {
		return this.monTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
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
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortEtdDt
	 */
	public String getLstLodgPortEtdDt() {
		return this.lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param oldBsaZrFlg
	 */
	public void setOldBsaZrFlg(String oldBsaZrFlg) {
		this.oldBsaZrFlg = oldBsaZrFlg;
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
	 * @param wkyTgtFlg
	 */
	public void setWkyTgtFlg(String wkyTgtFlg) {
		this.wkyTgtFlg = wkyTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param oldCostWk
	 */
	public void setOldCostWk(String oldCostWk) {
		this.oldCostWk = oldCostWk;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param bsaZrFlg
	 */
	public void setBsaZrFlg(String bsaZrFlg) {
		this.bsaZrFlg = bsaZrFlg;
	}
	
	/**
	 * Column Info
	 * @param n1stLodgPortEtdDt
	 */
	public void setN1stLodgPortEtdDt(String n1stLodgPortEtdDt) {
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param wkyMnlFlg
	 */
	public void setWkyMnlFlg(String wkyMnlFlg) {
		this.wkyMnlFlg = wkyMnlFlg;
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
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @param vslLaneTpCd
	 */
	public void setVslLaneTpCd(String vslLaneTpCd) {
		this.vslLaneTpCd = vslLaneTpCd;
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
	 * @param monTgtFlg
	 */
	public void setMonTgtFlg(String monTgtFlg) {
		this.monTgtFlg = monTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
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
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortEtdDt
	 */
	public void setLstLodgPortEtdDt(String lstLodgPortEtdDt) {
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOldBsaZrFlg(JSPUtil.getParameter(request, prefix + "old_bsa_zr_flg", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setWkyTgtFlg(JSPUtil.getParameter(request, prefix + "wky_tgt_flg", ""));
		setOldCostWk(JSPUtil.getParameter(request, prefix + "old_cost_wk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setBsaZrFlg(JSPUtil.getParameter(request, prefix + "bsa_zr_flg", ""));
		setN1stLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "n1st_lodg_port_etd_dt", ""));
		setWkyMnlFlg(JSPUtil.getParameter(request, prefix + "wky_mnl_flg", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, prefix + "lst_lodg_port_cd", ""));
		setVslLaneTpCd(JSPUtil.getParameter(request, prefix + "vsl_lane_tp_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setMonTgtFlg(JSPUtil.getParameter(request, prefix + "mon_tgt_flg", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setVopCd(JSPUtil.getParameter(request, prefix + "vop_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, prefix + "lst_lodg_port_etd_dt", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchWeeklyTargetVVDListVO[]
	 */
	public SearchWeeklyTargetVVDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchWeeklyTargetVVDListVO[]
	 */
	public SearchWeeklyTargetVVDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchWeeklyTargetVVDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] oldBsaZrFlg = (JSPUtil.getParameter(request, prefix	+ "old_bsa_zr_flg", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] wkyTgtFlg = (JSPUtil.getParameter(request, prefix	+ "wky_tgt_flg", length));
			String[] oldCostWk = (JSPUtil.getParameter(request, prefix	+ "old_cost_wk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] bsaZrFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_zr_flg", length));
			String[] n1stLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n1st_lodg_port_etd_dt", length));
			String[] wkyMnlFlg = (JSPUtil.getParameter(request, prefix	+ "wky_mnl_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] vslLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_tp_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] monTgtFlg = (JSPUtil.getParameter(request, prefix	+ "mon_tgt_flg", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchWeeklyTargetVVDListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (oldBsaZrFlg[i] != null)
					model.setOldBsaZrFlg(oldBsaZrFlg[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (wkyTgtFlg[i] != null)
					model.setWkyTgtFlg(wkyTgtFlg[i]);
				if (oldCostWk[i] != null)
					model.setOldCostWk(oldCostWk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (bsaZrFlg[i] != null)
					model.setBsaZrFlg(bsaZrFlg[i]);
				if (n1stLodgPortEtdDt[i] != null)
					model.setN1stLodgPortEtdDt(n1stLodgPortEtdDt[i]);
				if (wkyMnlFlg[i] != null)
					model.setWkyMnlFlg(wkyMnlFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				if (vslLaneTpCd[i] != null)
					model.setVslLaneTpCd(vslLaneTpCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (monTgtFlg[i] != null)
					model.setMonTgtFlg(monTgtFlg[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchWeeklyTargetVVDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchWeeklyTargetVVDListVO[]
	 */
	public SearchWeeklyTargetVVDListVO[] getSearchWeeklyTargetVVDListVOs(){
		SearchWeeklyTargetVVDListVO[] vos = (SearchWeeklyTargetVVDListVO[])models.toArray(new SearchWeeklyTargetVVDListVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBsaZrFlg = this.oldBsaZrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkyTgtFlg = this.wkyTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCostWk = this.oldCostWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaZrFlg = this.bsaZrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLodgPortEtdDt = this.n1stLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkyMnlFlg = this.wkyMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneTpCd = this.vslLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monTgtFlg = this.monTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
