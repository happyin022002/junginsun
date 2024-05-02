/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchWeeklyTargetVVDListVO.java
*@FileTitle : SearchWeeklyTargetVVDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.14 김기대 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchWeeklyTargetVVDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchWeeklyTargetVVDListVO> models = new ArrayList<SearchWeeklyTargetVVDListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslLaneTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String monTgtFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String wkyTgtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lstLodgPortEtdDt = null;
	/* Column Info */
	private String slsYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String bsaZrFlg = null;
	/* Column Info */
	private String wkyMnlFlg = null;
	/* Column Info */
	private String n1stLodgPortEtdDt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchWeeklyTargetVVDListVO() {}

	public SearchWeeklyTargetVVDListVO(String ibflag, String pagerows, String bsaZrFlg, String costYrmon, String slsYrmon, String costWk, String trdCd, String subTrdCd, String slanCd, String rlaneCd, String vslLaneTpCd, String vslCd, String skdVoyNo, String dirCd, String iocCd, String lstLodgPortCd, String lstLodgPortEtdDt, String n1stLodgPortEtdDt, String wkyTgtFlg, String wkyMnlFlg, String monTgtFlg, String deltFlg) {
		this.iocCd = iocCd;
		this.vslLaneTpCd = vslLaneTpCd;
		this.vslCd = vslCd;
		this.monTgtFlg = monTgtFlg;
		this.deltFlg = deltFlg;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.wkyTgtFlg = wkyTgtFlg;
		this.pagerows = pagerows;
		this.lstLodgPortEtdDt = lstLodgPortEtdDt;
		this.slsYrmon = slsYrmon;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.slanCd = slanCd;
		this.costWk = costWk;
		this.bsaZrFlg = bsaZrFlg;
		this.wkyMnlFlg = wkyMnlFlg;
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
		this.dirCd = dirCd;
		this.lstLodgPortCd = lstLodgPortCd;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_lane_tp_cd", getVslLaneTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("mon_tgt_flg", getMonTgtFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("wky_tgt_flg", getWkyTgtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lst_lodg_port_etd_dt", getLstLodgPortEtdDt());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("bsa_zr_flg", getBsaZrFlg());
		this.hashColumns.put("wky_mnl_flg", getWkyMnlFlg());
		this.hashColumns.put("n1st_lodg_port_etd_dt", getN1stLodgPortEtdDt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_lane_tp_cd", "vslLaneTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("mon_tgt_flg", "monTgtFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("wky_tgt_flg", "wkyTgtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lst_lodg_port_etd_dt", "lstLodgPortEtdDt");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("bsa_zr_flg", "bsaZrFlg");
		this.hashFields.put("wky_mnl_flg", "wkyMnlFlg");
		this.hashFields.put("n1st_lodg_port_etd_dt", "n1stLodgPortEtdDt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
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
	 * @return vslLaneTpCd
	 */
	public String getVslLaneTpCd() {
		return this.vslLaneTpCd;
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
	 * @return monTgtFlg
	 */
	public String getMonTgtFlg() {
		return this.monTgtFlg;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
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
	 * @return bsaZrFlg
	 */
	public String getBsaZrFlg() {
		return this.bsaZrFlg;
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
	 * @return n1stLodgPortEtdDt
	 */
	public String getN1stLodgPortEtdDt() {
		return this.n1stLodgPortEtdDt;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param vslLaneTpCd
	 */
	public void setVslLaneTpCd(String vslLaneTpCd) {
		this.vslLaneTpCd = vslLaneTpCd;
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
	 * @param monTgtFlg
	 */
	public void setMonTgtFlg(String monTgtFlg) {
		this.monTgtFlg = monTgtFlg;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
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
	 * @param bsaZrFlg
	 */
	public void setBsaZrFlg(String bsaZrFlg) {
		this.bsaZrFlg = bsaZrFlg;
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
	 * @param n1stLodgPortEtdDt
	 */
	public void setN1stLodgPortEtdDt(String n1stLodgPortEtdDt) {
		this.n1stLodgPortEtdDt = n1stLodgPortEtdDt;
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
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslLaneTpCd(JSPUtil.getParameter(request, "vsl_lane_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setMonTgtFlg(JSPUtil.getParameter(request, "mon_tgt_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setWkyTgtFlg(JSPUtil.getParameter(request, "wky_tgt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLstLodgPortEtdDt(JSPUtil.getParameter(request, "lst_lodg_port_etd_dt", ""));
		setSlsYrmon(JSPUtil.getParameter(request, "sls_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setBsaZrFlg(JSPUtil.getParameter(request, "bsa_zr_flg", ""));
		setWkyMnlFlg(JSPUtil.getParameter(request, "wky_mnl_flg", ""));
		setN1stLodgPortEtdDt(JSPUtil.getParameter(request, "n1st_lodg_port_etd_dt", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, "lst_lodg_port_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
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
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] monTgtFlg = (JSPUtil.getParameter(request, prefix	+ "mon_tgt_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] wkyTgtFlg = (JSPUtil.getParameter(request, prefix	+ "wky_tgt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lstLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_etd_dt", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] bsaZrFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_zr_flg", length));
			String[] wkyMnlFlg = (JSPUtil.getParameter(request, prefix	+ "wky_mnl_flg", length));
			String[] n1stLodgPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "n1st_lodg_port_etd_dt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchWeeklyTargetVVDListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslLaneTpCd[i] != null)
					model.setVslLaneTpCd(vslLaneTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (monTgtFlg[i] != null)
					model.setMonTgtFlg(monTgtFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (wkyTgtFlg[i] != null)
					model.setWkyTgtFlg(wkyTgtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lstLodgPortEtdDt[i] != null)
					model.setLstLodgPortEtdDt(lstLodgPortEtdDt[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (bsaZrFlg[i] != null)
					model.setBsaZrFlg(bsaZrFlg[i]);
				if (wkyMnlFlg[i] != null)
					model.setWkyMnlFlg(wkyMnlFlg[i]);
				if (n1stLodgPortEtdDt[i] != null)
					model.setN1stLodgPortEtdDt(n1stLodgPortEtdDt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneTpCd = this.vslLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monTgtFlg = this.monTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkyTgtFlg = this.wkyTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortEtdDt = this.lstLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaZrFlg = this.bsaZrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkyMnlFlg = this.wkyMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLodgPortEtdDt = this.n1stLodgPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
