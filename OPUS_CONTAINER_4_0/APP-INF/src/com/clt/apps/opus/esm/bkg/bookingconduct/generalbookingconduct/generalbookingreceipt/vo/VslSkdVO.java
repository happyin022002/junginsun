/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslSkdVO.java
*@FileTitle : VslSkdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.28 김병규
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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

public class VslSkdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<VslSkdVO> models = new ArrayList<VslSkdVO>();

	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String etaDay = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String etaTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String etdDay = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String polClptIndSeqList = null;
	/* Column Info */
	private String podClptIndSeqList = null;

	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String bkgVvdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String etdTime = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String befVvd = null;
	/* Column Info */
	private String befPodCd = null;
	/* Column Info */
	private String befClptIndSeq = null;
	/* Column Info */
	private String curVvd = null;
	/* Column Info */
	private String curPolCd = null;
	/* Column Info */
	private String curClptIndSeq = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public VslSkdVO() {}

	public VslSkdVO(String ibflag, String pagerows, String slanCd, String etd, String eta, String etdDay, String etdTime, String etaDay, String etaTime, String polCd, String polYdCd, String podCd, String podYdCd, String bkgVvdCd, String polClptIndSeq, String podClptIndSeq, String polClptIndSeqList, String podClptIndSeqList, String vslPrePstCd, String vslSeq, String befVvd, String befPodCd, String befClptIndSeq, String curVvd, String curPolCd, String curClptIndSeq) {
		this.eta = eta;
		this.etd = etd;
		this.etaDay = etaDay;
		this.pagerows = pagerows;
		this.etaTime = etaTime;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.etdDay = etdDay;
		this.polYdCd = polYdCd;
		this.polClptIndSeq = polClptIndSeq;
		this.podClptIndSeq = podClptIndSeq;
		this.polClptIndSeqList = polClptIndSeqList;
		this.podClptIndSeqList = podClptIndSeqList;
		this.vslPrePstCd = vslPrePstCd;
		this.podYdCd = podYdCd;
		this.bkgVvdCd = bkgVvdCd;
		this.podCd = podCd;
		this.etdTime = etdTime;
		this.vslSeq = vslSeq;
		this.befVvd = befVvd;
		this.befPodCd = befPodCd;
		this.befClptIndSeq = befClptIndSeq;
		this.curVvd = curVvd;
		this.curPolCd = curPolCd;
		this.curClptIndSeq = curClptIndSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("eta_day", getEtaDay());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eta_time", getEtaTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("etd_day", getEtdDay());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("pol_clpt_ind_seq_list", getPolClptIndSeqList());
		this.hashColumns.put("pod_clpt_ind_seq_list", getPodClptIndSeqList());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("etd_time", getEtdTime());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("bef_vvd", getBefVvd());
		this.hashColumns.put("bef_pod_cd", getBefPodCd());
		this.hashColumns.put("bef_clpt_ind_seq", getBefClptIndSeq());
		this.hashColumns.put("cur_vvd", getCurVvd());
		this.hashColumns.put("cur_pol_cd", getCurPolCd());
		this.hashColumns.put("cur_clpt_ind_seq", getCurClptIndSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("eta_day", "etaDay");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eta_time", "etaTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("etd_day", "etdDay");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("pol_clpt_ind_seq_list", "polClptIndSeqList");
		this.hashFields.put("pod_clpt_ind_seq_list", "podClptIndSeqList");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("etd_time", "etdTime");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("bef_vvd", "befVvd");
		this.hashFields.put("bef_pod_cd", "befPodCd");
		this.hashFields.put("bef_clpt_ind_seq", "befClptIndSeq");
		this.hashFields.put("cur_vvd", "curVvd");
		this.hashFields.put("cur_pol_cd", "curPolCd");
		this.hashFields.put("cur_clpt_ind_seq", "curClptIndSeq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}

	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}

	/**
	 * Column Info
	 * @return etaDay
	 */
	public String getEtaDay() {
		return this.etaDay;
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
	 * @return etaTime
	 */
	public String getEtaTime() {
		return this.etaTime;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}

	/**
	 * Column Info
	 * @return etdDay
	 */
	public String getEtdDay() {
		return this.etdDay;
	}

	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}

	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}
	/**
	 * Column Info
	 * @return podClptIndSeqList
	 */
	public String getPolClptIndSeqList() {
		return polClptIndSeqList;
	}
	/**
	 * Column Info
	 * @return podClptIndSeqList
	 */
	public String getPodClptIndSeqList() {
		return podClptIndSeqList;
	}
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}

	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}

	/**
	 * Column Info
	 * @return bkgVvdCd
	 */
	public String getBkgVvdCd() {
		return this.bkgVvdCd;
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
	 * @return etdTime
	 */
	public String getEtdTime() {
		return this.etdTime;
	}

	/**
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}

	/**
	 * Column Info
	 * @return befVvd
	 */
	public String getBefVvd() {
		return this.befVvd;
	}

	/**
	 * Column Info
	 * @return befPodCd
	 */
	public String getBefPodCd() {
		return this.befPodCd;
	}

	/**
	 * Column Info
	 * @return befClptIndSeq
	 */
	public String getBefClptIndSeq() {
		return this.befClptIndSeq;
	}

	/**
	 * Column Info
	 * @return curVvd
	 */
	public String getCurVvd() {
		return this.curVvd;
	}

	/**
	 * Column Info
	 * @return curPolCd
	 */
	public String getCurPolCd() {
		return this.curPolCd;
	}

	/**
	 * Column Info
	 * @return curClptIndSeq
	 */
	public String getCurClptIndSeq() {
		return this.curClptIndSeq;
	}

	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}

	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}

	/**
	 * Column Info
	 * @param etaDay
	 */
	public void setEtaDay(String etaDay) {
		this.etaDay = etaDay;
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
	 * @param etaTime
	 */
	public void setEtaTime(String etaTime) {
		this.etaTime = etaTime;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Column Info
	 * @param etdDay
	 */
	public void setEtdDay(String etdDay) {
		this.etdDay = etdDay;
	}

	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}

	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}

	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}

	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}

	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}

	/**
	 * Column Info
	 * @param bkgVvdCd
	 */
	public void setBkgVvdCd(String bkgVvdCd) {
		this.bkgVvdCd = bkgVvdCd;
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
	 * @param etdTime
	 */
	public void setEtdTime(String etdTime) {
		this.etdTime = etdTime;
	}

	/**
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}

	/**
	 * Column Info
	 * @param befVvd
	 */
	public void setBefVvd(String befVvd) {
		this.befVvd = befVvd;
	}

	/**
	 * Column Info
	 * @param befPodCd
	 */
	public void setBefPodCd(String befPodCd) {
		this.befPodCd = befPodCd;
	}

	/**
	 * Column Info
	 * @param befClptIndSeq
	 */
	public void setBefClptIndSeq(String befClptIndSeq) {
		this.befClptIndSeq = befClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param befClptIndSeqList
	 */

	public void setPolClptIndSeqList(String polClptIndSeqList) {
		this.polClptIndSeqList = polClptIndSeqList;
	}
	
	/**
	 * Column Info
	 * @param befClptIndSeqList
	 */
	public void setPodClptIndSeqList(String podClptIndSeqList) {
		this.podClptIndSeqList = podClptIndSeqList;
	}

	/**
	 * Column Info
	 * @param curVvd
	 */
	public void setCurVvd(String curVvd) {
		this.curVvd = curVvd;
	}

	/**
	 * Column Info
	 * @param curPolCd
	 */
	public void setCurPolCd(String curPolCd) {
		this.curPolCd = curPolCd;
	}

	/**
	 * Column Info
	 * @param curClptIndSeq
	 */
	public void setCurClptIndSeq(String curClptIndSeq) {
		this.curClptIndSeq = curClptIndSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setEtaDay(JSPUtil.getParameter(request, "eta_day", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEtaTime(JSPUtil.getParameter(request, "eta_time", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setEtdDay(JSPUtil.getParameter(request, "etd_day", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, "pol_clpt_ind_seq", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
		setPolClptIndSeqList(JSPUtil.getParameter(request, "pol_clpt_ind_seq_list", ""));
		setPodClptIndSeqList(JSPUtil.getParameter(request, "pod_clpt_ind_seq_list", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, "bkg_vvd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setEtdTime(JSPUtil.getParameter(request, "etd_time", ""));
		setVslSeq(JSPUtil.getParameter(request, "vsl_seq", ""));
		setBefVvd(JSPUtil.getParameter(request, "bef_vvd", ""));
		setBefPodCd(JSPUtil.getParameter(request, "bef_pod_cd", ""));
		setBefClptIndSeq(JSPUtil.getParameter(request, "bef_clpt_ind_seq", ""));
		setCurVvd(JSPUtil.getParameter(request, "cur_vvd", ""));
		setCurPolCd(JSPUtil.getParameter(request, "cur_pol_cd", ""));
		setCurClptIndSeq(JSPUtil.getParameter(request, "cur_clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdVO[]
	 */
	public VslSkdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return VslSkdVO[]
	 */
	public VslSkdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta".trim(), length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd".trim(), length));
			String[] etaDay = (JSPUtil.getParameter(request, prefix	+ "eta_day".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] etaTime = (JSPUtil.getParameter(request, prefix	+ "eta_time".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] etdDay = (JSPUtil.getParameter(request, prefix	+ "etd_day".trim(), length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd".trim(), length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq".trim(), length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq".trim(), length));
			String[] polClptIndSeqList = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq_list".trim(), length));
			String[] podClptIndSeqList = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq_list".trim(), length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd".trim(), length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd".trim(), length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] etdTime = (JSPUtil.getParameter(request, prefix	+ "etd_time".trim(), length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq".trim(), length));
			String[] befVvd = (JSPUtil.getParameter(request, prefix	+ "bef_vvd".trim(), length));
			String[] befPodCd = (JSPUtil.getParameter(request, prefix	+ "bef_pod_cd".trim(), length));
			String[] befClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "bef_clpt_ind_seq".trim(), length));
			String[] curVvd = (JSPUtil.getParameter(request, prefix	+ "cur_vvd".trim(), length));
			String[] curPolCd = (JSPUtil.getParameter(request, prefix	+ "cur_pol_cd".trim(), length));
			String[] curClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "cur_clpt_ind_seq".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new VslSkdVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (etaDay[i] != null)
					model.setEtaDay(etaDay[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (etaTime[i] != null)
					model.setEtaTime(etaTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (etdDay[i] != null)
					model.setEtdDay(etdDay[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (polClptIndSeqList[i] != null)
					model.setPolClptIndSeqList(polClptIndSeqList[i]);
				if (podClptIndSeqList[i] != null)
					model.setPodClptIndSeqList(podClptIndSeqList[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (etdTime[i] != null)
					model.setEtdTime(etdTime[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (befVvd[i] != null)
					model.setBefVvd(befVvd[i]);
				if (befPodCd[i] != null)
					model.setBefPodCd(befPodCd[i]);
				if (befClptIndSeq[i] != null)
					model.setBefClptIndSeq(befClptIndSeq[i]);
				if (curVvd[i] != null)
					model.setCurVvd(curVvd[i]);
				if (curPolCd[i] != null)
					model.setCurPolCd(curPolCd[i]);
				if (curClptIndSeq[i] != null)
					model.setCurClptIndSeq(curClptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdVO[]
	 */
	public VslSkdVO[] getVslSkdVOs(){
		VslSkdVO[] vos = (VslSkdVO[])models.toArray(new VslSkdVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDay = this.etaDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTime = this.etaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDay = this.etdDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeqList = this.polClptIndSeqList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeqList = this.podClptIndSeqList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTime = this.etdTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befVvd = this.befVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befPodCd = this.befPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befClptIndSeq = this.befClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curVvd = this.curVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curPolCd = this.curPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curClptIndSeq = this.curClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
