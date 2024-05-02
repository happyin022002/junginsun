/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaPerformanceReportInVO.java
*@FileTitle : CaPerformanceReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.28 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaPerformanceReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaPerformanceReportInVO> models = new ArrayList<CaPerformanceReportInVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String reaVal = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String tabTp = null;
	/* Column Info */
	private String caKnd = null;
	/* Column Info */
	private String lanSkdDirCd = null;
	/* Column Info */
	private String choToDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String corrUsrId = null;
	/* Column Info */
	private String choFromDt = null;
	/* Column Info */
	private String ratFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String blObrdFromDt = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String choDt = null;
	/* Column Info */
	private String blObrdToDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaPerformanceReportInVO() {}

	public CaPerformanceReportInVO(String ibflag, String pagerows, String choDt, String choFromDt, String choToDt, String bkgOfcCd, String blObrdFromDt, String blObrdToDt, String corrUsrId, String slanCd, String lanSkdDirCd, String vslCd, String skdVoyNo, String skdDirCd, String porCd, String polCd, String podCd, String delCd, String caRsnCd, String ratFlg, String caKnd, String tabTp, String custTp, String custNm, String reaVal) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.custNm = custNm;
		this.reaVal = reaVal;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgOfcCd = bkgOfcCd;
		this.caRsnCd = caRsnCd;
		this.tabTp = tabTp;
		this.caKnd = caKnd;
		this.lanSkdDirCd = lanSkdDirCd;
		this.choToDt = choToDt;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.corrUsrId = corrUsrId;
		this.choFromDt = choFromDt;
		this.ratFlg = ratFlg;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.blObrdFromDt = blObrdFromDt;
		this.custTp = custTp;
		this.slanCd = slanCd;
		this.choDt = choDt;
		this.blObrdToDt = blObrdToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rea_val", getReaVal());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("tab_tp", getTabTp());
		this.hashColumns.put("ca_knd", getCaKnd());
		this.hashColumns.put("lan_skd_dir_cd", getLanSkdDirCd());
		this.hashColumns.put("cho_to_dt", getChoToDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("corr_usr_id", getCorrUsrId());
		this.hashColumns.put("cho_from_dt", getChoFromDt());
		this.hashColumns.put("rat_flg", getRatFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bl_obrd_from_dt", getBlObrdFromDt());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cho_dt", getChoDt());
		this.hashColumns.put("bl_obrd_to_dt", getBlObrdToDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rea_val", "reaVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("tab_tp", "tabTp");
		this.hashFields.put("ca_knd", "caKnd");
		this.hashFields.put("lan_skd_dir_cd", "lanSkdDirCd");
		this.hashFields.put("cho_to_dt", "choToDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("corr_usr_id", "corrUsrId");
		this.hashFields.put("cho_from_dt", "choFromDt");
		this.hashFields.put("rat_flg", "ratFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_obrd_from_dt", "blObrdFromDt");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cho_dt", "choDt");
		this.hashFields.put("bl_obrd_to_dt", "blObrdToDt");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return reaVal
	 */
	public String getReaVal() {
		return this.reaVal;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
	}
	
	/**
	 * Column Info
	 * @return tabTp
	 */
	public String getTabTp() {
		return this.tabTp;
	}
	
	/**
	 * Column Info
	 * @return caKnd
	 */
	public String getCaKnd() {
		return this.caKnd;
	}
	
	/**
	 * Column Info
	 * @return lanSkdDirCd
	 */
	public String getLanSkdDirCd() {
		return this.lanSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return choToDt
	 */
	public String getChoToDt() {
		return this.choToDt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return corrUsrId
	 */
	public String getCorrUsrId() {
		return this.corrUsrId;
	}
	
	/**
	 * Column Info
	 * @return choFromDt
	 */
	public String getChoFromDt() {
		return this.choFromDt;
	}
	
	/**
	 * Column Info
	 * @return ratFlg
	 */
	public String getRatFlg() {
		return this.ratFlg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return blObrdFromDt
	 */
	public String getBlObrdFromDt() {
		return this.blObrdFromDt;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
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
	 * @return choDt
	 */
	public String getChoDt() {
		return this.choDt;
	}
	
	/**
	 * Column Info
	 * @return blObrdToDt
	 */
	public String getBlObrdToDt() {
		return this.blObrdToDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param reaVal
	 */
	public void setReaVal(String reaVal) {
		this.reaVal = reaVal;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}
	
	/**
	 * Column Info
	 * @param tabTp
	 */
	public void setTabTp(String tabTp) {
		this.tabTp = tabTp;
	}
	
	/**
	 * Column Info
	 * @param caKnd
	 */
	public void setCaKnd(String caKnd) {
		this.caKnd = caKnd;
	}
	
	/**
	 * Column Info
	 * @param lanSkdDirCd
	 */
	public void setLanSkdDirCd(String lanSkdDirCd) {
		this.lanSkdDirCd = lanSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param choToDt
	 */
	public void setChoToDt(String choToDt) {
		this.choToDt = choToDt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param corrUsrId
	 */
	public void setCorrUsrId(String corrUsrId) {
		this.corrUsrId = corrUsrId;
	}
	
	/**
	 * Column Info
	 * @param choFromDt
	 */
	public void setChoFromDt(String choFromDt) {
		this.choFromDt = choFromDt;
	}
	
	/**
	 * Column Info
	 * @param ratFlg
	 */
	public void setRatFlg(String ratFlg) {
		this.ratFlg = ratFlg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param blObrdFromDt
	 */
	public void setBlObrdFromDt(String blObrdFromDt) {
		this.blObrdFromDt = blObrdFromDt;
	}
	
	/**
	 * Column Info
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
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
	 * @param choDt
	 */
	public void setChoDt(String choDt) {
		this.choDt = choDt;
	}
	
	/**
	 * Column Info
	 * @param blObrdToDt
	 */
	public void setBlObrdToDt(String blObrdToDt) {
		this.blObrdToDt = blObrdToDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setReaVal(JSPUtil.getParameter(request, "rea_val", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setCaRsnCd(JSPUtil.getParameter(request, "ca_rsn_cd", ""));
		setTabTp(JSPUtil.getParameter(request, "tab_tp", ""));
		setCaKnd(JSPUtil.getParameter(request, "ca_knd", ""));
		setLanSkdDirCd(JSPUtil.getParameter(request, "lan_skd_dir_cd", ""));
		setChoToDt(JSPUtil.getParameter(request, "cho_to_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCorrUsrId(JSPUtil.getParameter(request, "corr_usr_id", ""));
		setChoFromDt(JSPUtil.getParameter(request, "cho_from_dt", ""));
		setRatFlg(JSPUtil.getParameter(request, "rat_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBlObrdFromDt(JSPUtil.getParameter(request, "bl_obrd_from_dt", ""));
		setCustTp(JSPUtil.getParameter(request, "cust_tp", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setChoDt(JSPUtil.getParameter(request, "cho_dt", ""));
		setBlObrdToDt(JSPUtil.getParameter(request, "bl_obrd_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaPerformanceReportInVO[]
	 */
	public CaPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaPerformanceReportInVO[]
	 */
	public CaPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaPerformanceReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] reaVal = (JSPUtil.getParameter(request, prefix	+ "rea_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] tabTp = (JSPUtil.getParameter(request, prefix	+ "tab_tp", length));
			String[] caKnd = (JSPUtil.getParameter(request, prefix	+ "ca_knd", length));
			String[] lanSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "lan_skd_dir_cd", length));
			String[] choToDt = (JSPUtil.getParameter(request, prefix	+ "cho_to_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] corrUsrId = (JSPUtil.getParameter(request, prefix	+ "corr_usr_id", length));
			String[] choFromDt = (JSPUtil.getParameter(request, prefix	+ "cho_from_dt", length));
			String[] ratFlg = (JSPUtil.getParameter(request, prefix	+ "rat_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] blObrdFromDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_from_dt", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] choDt = (JSPUtil.getParameter(request, prefix	+ "cho_dt", length));
			String[] blObrdToDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaPerformanceReportInVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (reaVal[i] != null)
					model.setReaVal(reaVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (tabTp[i] != null)
					model.setTabTp(tabTp[i]);
				if (caKnd[i] != null)
					model.setCaKnd(caKnd[i]);
				if (lanSkdDirCd[i] != null)
					model.setLanSkdDirCd(lanSkdDirCd[i]);
				if (choToDt[i] != null)
					model.setChoToDt(choToDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (corrUsrId[i] != null)
					model.setCorrUsrId(corrUsrId[i]);
				if (choFromDt[i] != null)
					model.setChoFromDt(choFromDt[i]);
				if (ratFlg[i] != null)
					model.setRatFlg(ratFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (blObrdFromDt[i] != null)
					model.setBlObrdFromDt(blObrdFromDt[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (choDt[i] != null)
					model.setChoDt(choDt[i]);
				if (blObrdToDt[i] != null)
					model.setBlObrdToDt(blObrdToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaPerformanceReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaPerformanceReportInVO[]
	 */
	public CaPerformanceReportInVO[] getCaPerformanceReportInVOs(){
		CaPerformanceReportInVO[] vos = (CaPerformanceReportInVO[])models.toArray(new CaPerformanceReportInVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reaVal = this.reaVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabTp = this.tabTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caKnd = this.caKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lanSkdDirCd = this.lanSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.choToDt = this.choToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrUsrId = this.corrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.choFromDt = this.choFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratFlg = this.ratFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdFromDt = this.blObrdFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.choDt = this.choDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdToDt = this.blObrdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
