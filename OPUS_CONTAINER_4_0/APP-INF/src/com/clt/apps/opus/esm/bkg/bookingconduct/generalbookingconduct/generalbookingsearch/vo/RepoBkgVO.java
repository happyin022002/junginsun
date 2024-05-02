/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoBkgVO.java
*@FileTitle : RepoBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.22 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepoBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepoBkgVO> models = new ArrayList<RepoBkgVO>();
	
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String mtyBkgStsCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String cgoRcvDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String bkgTrunkVvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String polEtdDt = null;
	/* Column Info */
	private String polAtdDt = null;
	/* Column Info */
	private String podEtaDt = null;
	/* Column Info */
	private String podAtaDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepoBkgVO() {}

	public RepoBkgVO(String ibflag, String pagerows, String bkgNo, String blNo, String blNoTp, String blTpCd, String vslCd, String skdVoyNo, String skdDirCd, String bkgTrunkVvd, String slsRhqCd, String orgYdCd, String cgoRcvDt, String cnmvEvntDt, String bkgCreDt, String bkgPolCd, String bkgPodCd, String mtyBkgStsCd, String bkgStsCd, String polCd, String podCd, String splitFlg, String interRmk, String polEtdDt, String polAtdDt, String podEtaDt, String podAtaDt) {
		this.splitFlg = splitFlg;
		this.bkgPolCd = bkgPolCd;
		this.vslCd = vslCd;
		this.mtyBkgStsCd = mtyBkgStsCd;
		this.bkgStsCd = bkgStsCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.skdVoyNo = skdVoyNo;
		this.orgYdCd = orgYdCd;
		this.blNo = blNo;
		this.slsRhqCd = slsRhqCd;
		this.cgoRcvDt = cgoRcvDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.bkgTrunkVvd = bkgTrunkVvd;
		this.podCd = podCd;
		this.polCd = polCd;
		this.bkgPodCd = bkgPodCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.interRmk = interRmk;
		this.bkgCreDt = bkgCreDt;
		this.blNoTp = blNoTp;
		this.polEtdDt = polEtdDt;
		this.polAtdDt = polAtdDt;
		this.podEtaDt = podEtaDt;
		this.podAtaDt = podAtaDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("mty_bkg_sts_cd", getMtyBkgStsCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("bkg_trunk_vvd", getBkgTrunkVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());
		this.hashColumns.put("pol_atd_dt", getPolAtdDt());
		this.hashColumns.put("pod_eta_dt", getPodEtaDt());
		this.hashColumns.put("pod_ata_dt", getPodAtaDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("mty_bkg_sts_cd", "mtyBkgStsCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("bkg_trunk_vvd", "bkgTrunkVvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("pol_atd_dt", "polAtdDt");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("pod_ata_dt", "podAtaDt");
		return this.hashFields;
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
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
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
	 * @return mtyBkgStsCd
	 */
	public String getMtyBkgStsCd() {
		return this.mtyBkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvEvntDt
	 */
	public String getCnmvEvntDt() {
		return this.cnmvEvntDt;
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
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return this.cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTrunkVvd
	 */
	public String getBkgTrunkVvd() {
		return this.bkgTrunkVvd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return polEtdDt
	 */
	public String getPolEtdDt() {
		return this.polEtdDt;
	}
	
	/**
	 * Column Info
	 * @return polAtdDt
	 */
	public String getPolAtdDt() {
		return this.polAtdDt;
	}
	
	/**
	 * Column Info
	 * @return podEtaDt
	 */
	public String getPodEtaDt() {
		return this.podEtaDt;
	}
	
	/**
	 * Column Info
	 * @return podAtaDt
	 */
	public String getPodAtaDt() {
		return this.podAtaDt;
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
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
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
	 * @param mtyBkgStsCd
	 */
	public void setMtyBkgStsCd(String mtyBkgStsCd) {
		this.mtyBkgStsCd = mtyBkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvEvntDt
	 */
	public void setCnmvEvntDt(String cnmvEvntDt) {
		this.cnmvEvntDt = cnmvEvntDt;
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
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param cgoRcvDt
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTrunkVvd
	 */
	public void setBkgTrunkVvd(String bkgTrunkVvd) {
		this.bkgTrunkVvd = bkgTrunkVvd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param polEtdDt
	 */
	public void setPolEtdDt(String polEtdDt) {
		this.polEtdDt = polEtdDt;
	}
	
	/**
	 * Column Info
	 * @param polAtdDt
	 */
	public void setPolAtdDt(String polAtdDt) {
		this.polAtdDt = polAtdDt;
	}
	
	/**
	 * Column Info
	 * @param podEtaDt
	 */
	public void setPodEtaDt(String podEtaDt) {
		this.podEtaDt = podEtaDt;
	}
	
	/**
	 * Column Info
	 * @param podAtaDt
	 */
	public void setPodAtaDt(String podAtaDt) {
		this.podAtaDt = podAtaDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setMtyBkgStsCd(JSPUtil.getParameter(request, "mty_bkg_sts_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, "sls_rhq_cd", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, "cgo_rcv_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setBkgTrunkVvd(JSPUtil.getParameter(request, "bkg_trunk_vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, "bkg_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setBkgCreDt(JSPUtil.getParameter(request, "bkg_cre_dt", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setPolEtdDt(JSPUtil.getParameter(request, "pol_etd_dt", ""));
		setPolAtdDt(JSPUtil.getParameter(request, "pol_atd_dt", ""));
		setPodEtaDt(JSPUtil.getParameter(request, "pod_eta_dt", ""));
		setPodAtaDt(JSPUtil.getParameter(request, "pod_ata_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepoBkgVO[]
	 */
	public RepoBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepoBkgVO[]
	 */
	public RepoBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepoBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] mtyBkgStsCd = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_sts_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] bkgTrunkVvd = (JSPUtil.getParameter(request, prefix	+ "bkg_trunk_vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] polEtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_dt", length));
			String[] polAtdDt = (JSPUtil.getParameter(request, prefix	+ "pol_atd_dt", length));
			String[] podEtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_dt", length));
			String[] podAtaDt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RepoBkgVO();
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (mtyBkgStsCd[i] != null)
					model.setMtyBkgStsCd(mtyBkgStsCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (bkgTrunkVvd[i] != null)
					model.setBkgTrunkVvd(bkgTrunkVvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (polEtdDt[i] != null)
					model.setPolEtdDt(polEtdDt[i]);
				if (polAtdDt[i] != null)
					model.setPolAtdDt(polAtdDt[i]);
				if (podEtaDt[i] != null)
					model.setPodEtaDt(podEtaDt[i]);
				if (podAtaDt[i] != null)
					model.setPodAtaDt(podAtaDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepoBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepoBkgVO[]
	 */
	public RepoBkgVO[] getRepoBkgVOs(){
		RepoBkgVO[] vos = (RepoBkgVO[])models.toArray(new RepoBkgVO[models.size()]);
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
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgStsCd = this.mtyBkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrunkVvd = this.bkgTrunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt = this.polEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtdDt = this.polAtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaDt = this.podEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaDt = this.podAtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
