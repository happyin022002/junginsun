/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCLMInfoVO.java
*@FileTitle : SearchCLMInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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

public class SearchCLMInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCLMInfoVO> models = new ArrayList<SearchCLMInfoVO>();
	
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String pStatus = null;
	/* Column Info */
	private String checkDigit = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String pDate0 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mvmtEvntDt = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String prevStsCd = null;
	/* Column Info */
	private String cnmvEvntDt = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pPol = null;
	/* Column Info */
	private String pType2 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String pType1 = null;
	/* Column Info */
	private String pPod = null;
	/* Column Info */
	private String crntVslCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCLMInfoVO() {}

	public SearchCLMInfoVO(String ibflag, String pagerows, String cntrNo, String checkDigit, String cntrTpszCd, String prevStsCd, String orgYdCd, String bkgNo, String rcvTermCd, String mvmtEvntDt, String mvmtStsCd, String crntVslCd, String crntSkdVoyNo, String crntSkdDirCd, String polCd, String podCd, String cnmvEvntDt, String pStatus, String pYard1, String pYard2, String pDate0, String pVvd, String pPol, String pPod, String pType1, String pType2) {
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.pStatus = pStatus;
		this.checkDigit = checkDigit;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.pDate0 = pDate0;
		this.cntrTpszCd = cntrTpszCd;
		this.mvmtEvntDt = mvmtEvntDt;
		this.rcvTermCd = rcvTermCd;
		this.pVvd = pVvd;
		this.prevStsCd = prevStsCd;
		this.cnmvEvntDt = cnmvEvntDt;
		this.crntSkdDirCd = crntSkdDirCd;
		this.orgYdCd = orgYdCd;
		this.podCd = podCd;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.pPol = pPol;
		this.pType2 = pType2;
		this.cntrNo = cntrNo;
		this.pYard2 = pYard2;
		this.pYard1 = pYard1;
		this.pType1 = pType1;
		this.pPod = pPod;
		this.crntVslCd = crntVslCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("p_status", getPStatus());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("p_date0", getPDate0());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mvmt_evnt_dt", getMvmtEvntDt());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("prev_sts_cd", getPrevStsCd());
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("p_pol", getPPol());
		this.hashColumns.put("p_type2", getPType2());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("p_type1", getPType1());
		this.hashColumns.put("p_pod", getPPod());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("p_status", "pStatus");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("p_date0", "pDate0");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mvmt_evnt_dt", "mvmtEvntDt");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("prev_sts_cd", "prevStsCd");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("p_pol", "pPol");
		this.hashFields.put("p_type2", "pType2");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("p_type1", "pType1");
		this.hashFields.put("p_pod", "pPod");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return pStatus
	 */
	public String getPStatus() {
		return this.pStatus;
	}
	
	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
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
	 * @return pDate0
	 */
	public String getPDate0() {
		return this.pDate0;
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
	 * @return mvmtEvntDt
	 */
	public String getMvmtEvntDt() {
		return this.mvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return pVvd
	 */
	public String getPVvd() {
		return this.pVvd;
	}
	
	/**
	 * Column Info
	 * @return prevStsCd
	 */
	public String getPrevStsCd() {
		return this.prevStsCd;
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
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return pPol
	 */
	public String getPPol() {
		return this.pPol;
	}
	
	/**
	 * Column Info
	 * @return pType2
	 */
	public String getPType2() {
		return this.pType2;
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
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}
	
	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	
	/**
	 * Column Info
	 * @return pType1
	 */
	public String getPType1() {
		return this.pType1;
	}
	
	/**
	 * Column Info
	 * @return pPod
	 */
	public String getPPod() {
		return this.pPod;
	}
	
	/**
	 * Column Info
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
	}
	

	/**
	 * Column Info
	 * @param crntSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param pStatus
	 */
	public void setPStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	
	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
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
	 * @param pDate0
	 */
	public void setPDate0(String pDate0) {
		this.pDate0 = pDate0;
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
	 * @param mvmtEvntDt
	 */
	public void setMvmtEvntDt(String mvmtEvntDt) {
		this.mvmtEvntDt = mvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param pVvd
	 */
	public void setPVvd(String pVvd) {
		this.pVvd = pVvd;
	}
	
	/**
	 * Column Info
	 * @param prevStsCd
	 */
	public void setPrevStsCd(String prevStsCd) {
		this.prevStsCd = prevStsCd;
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
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param pPol
	 */
	public void setPPol(String pPol) {
		this.pPol = pPol;
	}
	
	/**
	 * Column Info
	 * @param pType2
	 */
	public void setPType2(String pType2) {
		this.pType2 = pType2;
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
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}
	
	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Column Info
	 * @param pType1
	 */
	public void setPType1(String pType1) {
		this.pType1 = pType1;
	}
	
	/**
	 * Column Info
	 * @param pPod
	 */
	public void setPPod(String pPod) {
		this.pPod = pPod;
	}
	
	/**
	 * Column Info
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCrntSkdVoyNo(JSPUtil.getParameter(request, "crnt_skd_voy_no", ""));
		setPStatus(JSPUtil.getParameter(request, "p_status", ""));
		setCheckDigit(JSPUtil.getParameter(request, "check_digit", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPDate0(JSPUtil.getParameter(request, "p_date0", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setMvmtEvntDt(JSPUtil.getParameter(request, "mvmt_evnt_dt", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setPVvd(JSPUtil.getParameter(request, "p_vvd", ""));
		setPrevStsCd(JSPUtil.getParameter(request, "prev_sts_cd", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request, "cnmv_evnt_dt", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, "crnt_skd_dir_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPPol(JSPUtil.getParameter(request, "p_pol", ""));
		setPType2(JSPUtil.getParameter(request, "p_type2", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPYard2(JSPUtil.getParameter(request, "p_yard2", ""));
		setPYard1(JSPUtil.getParameter(request, "p_yard1", ""));
		setPType1(JSPUtil.getParameter(request, "p_type1", ""));
		setPPod(JSPUtil.getParameter(request, "p_pod", ""));
		setCrntVslCd(JSPUtil.getParameter(request, "crnt_vsl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCLMInfoVO[]
	 */
	public SearchCLMInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCLMInfoVO[]
	 */
	public SearchCLMInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCLMInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] pStatus = (JSPUtil.getParameter(request, prefix	+ "p_status", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] pDate0 = (JSPUtil.getParameter(request, prefix	+ "p_date0", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] mvmtEvntDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_evnt_dt", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] prevStsCd = (JSPUtil.getParameter(request, prefix	+ "prev_sts_cd", length));
			String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_evnt_dt", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] pPol = (JSPUtil.getParameter(request, prefix	+ "p_pol", length));
			String[] pType2 = (JSPUtil.getParameter(request, prefix	+ "p_type2", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] pType1 = (JSPUtil.getParameter(request, prefix	+ "p_type1", length));
			String[] pPod = (JSPUtil.getParameter(request, prefix	+ "p_pod", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCLMInfoVO();
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (pStatus[i] != null)
					model.setPStatus(pStatus[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (pDate0[i] != null)
					model.setPDate0(pDate0[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (mvmtEvntDt[i] != null)
					model.setMvmtEvntDt(mvmtEvntDt[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (prevStsCd[i] != null)
					model.setPrevStsCd(prevStsCd[i]);
				if (cnmvEvntDt[i] != null)
					model.setCnmvEvntDt(cnmvEvntDt[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pPol[i] != null)
					model.setPPol(pPol[i]);
				if (pType2[i] != null)
					model.setPType2(pType2[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (pType1[i] != null)
					model.setPType1(pType1[i]);
				if (pPod[i] != null)
					model.setPPod(pPod[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCLMInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCLMInfoVO[]
	 */
	public SearchCLMInfoVO[] getSearchCLMInfoVOs(){
		SearchCLMInfoVO[] vos = (SearchCLMInfoVO[])models.toArray(new SearchCLMInfoVO[models.size()]);
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
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStatus = this.pStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate0 = this.pDate0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEvntDt = this.mvmtEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevStsCd = this.prevStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt = this.cnmvEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPol = this.pPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType2 = this.pType2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pType1 = this.pType1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPod = this.pPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
