/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocPFMCBLListVO.java
*@FileTitle : DocPFMCBLListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.26 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocPFMCBLListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocPFMCBLListVO> models = new ArrayList<DocPFMCBLListVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String eventDate = null;
	/* Column Info */
	private String bkgSts = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String classType = null;
	/* Column Info */
	private String frDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgStf = null;
	/* Column Info */
	private String regionCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String docpDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String porCd = null;	
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String selBkgOfcCd = null;
	/* Column Info */
	private String selGsoCd = null;	
	/* Column Info */
	private String bkgDt = null;
	/* Column Info */
	private String pctDate = null;
	/* Column Info */
	private String portClzDt = null;
	/* Column Info */
	private String dpcsSmryRmk = null;
	/* Column Info */
	private String batchDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocPFMCBLListVO() {}

	public DocPFMCBLListVO(String ibflag, String pagerows, String docpDt, String bkgOfcCd, String classType, String bkgNo, String blNo, String bkgDt, String bkgStf, String bkgSts, String obSlsOfcCd, String porCd, String polCd, String podCd, String slanCd, String vslCd, String skdVoyNo, String skdDirCd, String remark, String eventDate, String selBkgOfcCd, String selGsoCd, String frDt, String toDt, String regionCd, String vvdCd, String portClzDt, String dpcsSmryRmk, String batchDt) {
		this.bkgOfcCd = bkgOfcCd;
		this.vslCd = vslCd;
		this.eventDate = eventDate;
		this.bkgSts = bkgSts;
		this.remark = remark;
		this.skdVoyNo = skdVoyNo;
		this.classType = classType;
		this.frDt = frDt;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.podCd = podCd;
		this.bkgStf = bkgStf;
		this.regionCd = regionCd;
		this.ibflag = ibflag;
		this.docpDt = docpDt;
		this.bkgNo = bkgNo;
		this.porCd = porCd;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.vvdCd = vvdCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.selBkgOfcCd = selBkgOfcCd;
		this.selGsoCd = selGsoCd;
		this.bkgDt = bkgDt;
		this.portClzDt = portClzDt;
		this.dpcsSmryRmk = dpcsSmryRmk;
		this.batchDt = batchDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("event_date", getEventDate());
		this.hashColumns.put("bkg_sts", getBkgSts());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("class_type", getClassType());
		this.hashColumns.put("fr_dt", getFrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_stf", getBkgStf());
		this.hashColumns.put("region_cd", getRegionCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("docp_dt", getDocpDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("sel_bkg_ofc_cd", getSelBkgOfcCd());
		this.hashColumns.put("sel_gso_cd", getSelGsoCd());
		this.hashColumns.put("bkg_dt", getBkgDt());
		this.hashColumns.put("port_clz_dt", getPortClzDt());
		this.hashColumns.put("dpcs_smry_rmk", getDpcsSmryRmk());
		this.hashColumns.put("batch_dt", getBatchDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("event_date", "eventDate");
		this.hashFields.put("bkg_sts", "bkgSts");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("class_type", "classType");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_stf", "bkgStf");
		this.hashFields.put("region_cd", "regionCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("docp_dt", "docpDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("sel_bkg_ofc_cd", "selBkgOfcCd");
		this.hashFields.put("sel_gso_cd", "selGsoCd");
		this.hashFields.put("bkg_dt", "bkgDt");
		this.hashFields.put("port_clz_dt", "portClzDt");
		this.hashFields.put("dpcs_smry_rmk", "dpcsSmryRmk");
		this.hashFields.put("batch_dt", "batchDt");
		
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return eventDate
	 */
	public String getEventDate() {
		return this.eventDate;
	}
	
	/**
	 * Column Info
	 * @return bkgSts
	 */
	public String getBkgSts() {
		return this.bkgSts;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
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
	 * @return classType
	 */
	public String getClassType() {
		return this.classType;
	}
	
	/**
	 * Column Info
	 * @return frDt
	 */
	public String getFrDt() {
		return this.frDt;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return bkgStf
	 */
	public String getBkgStf() {
		return this.bkgStf;
	}
	
	/**
	 * Column Info
	 * @return regionCd
	 */
	public String getRegionCd() {
		return this.regionCd;
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
	 * @return docpDt
	 */
	public String getDocpDt() {
		return this.docpDt;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return selBkgOfcCd
	 */
	public String getSelBkgOfcCd() {
		return this.selBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return selGsoCd
	 */
	public String getSelGsoCd() {
		return this.selGsoCd;
	}	
	
	/**
	 * Column Info
	 * @return bkgDt
	 */
	public String getBkgDt() {
		return this.bkgDt;
	}
	
	/**
	 * Column Info
	 * @return pctDate
	 */
	public String getPctDate() {
		return this.pctDate;
	}
	
	/**
	 * Column Info
	 * @return portClzDt
	 */
	public String getPortClzDt() {
		return this.portClzDt;
	}
	
	/**
	 * Column Info
	 * @return dpcsSmryRmk
	 */
	public String getDpcsSmryRmk() {
		return this.dpcsSmryRmk;
	}
	
	/**
	 * Column Info
	 * @return batchDt
	 */
	public String getBatchDt() {
		return this.batchDt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param eventDate
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	/**
	 * Column Info
	 * @param bkgSts
	 */
	public void setBkgSts(String bkgSts) {
		this.bkgSts = bkgSts;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @param classType
	 */
	public void setClassType(String classType) {
		this.classType = classType;
	}
	
	/**
	 * Column Info
	 * @param frDt
	 */
	public void setFrDt(String frDt) {
		this.frDt = frDt;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param bkgStf
	 */
	public void setBkgStf(String bkgStf) {
		this.bkgStf = bkgStf;
	}
	
	/**
	 * Column Info
	 * @param regionCd
	 */
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
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
	 * @param docpDt
	 */
	public void setDocpDt(String docpDt) {
		this.docpDt = docpDt;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param selBkgOfcCd
	 */
	public void setSelBkgOfcCd(String selBkgOfcCd) {
		this.selBkgOfcCd = selBkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param selGsoCd
	 */
	public void setSelGsoCd(String selGsoCd) {
		this.selGsoCd = selGsoCd;
	}	
	
	/**
	 * Column Info
	 * @param bkgDt
	 */
	public void setBkgDt(String bkgDt) {
		this.bkgDt = bkgDt;
	}
	
	/**
	 * Column Info
	 * @param portClzDt
	 */
	public void setPortClzDt(String portClzDt) {
		this.portClzDt = portClzDt;
	}
	
	/**
	 * Column Info
	 * @param dpcsSmryRmk
	 */
	public void setDpcsSmryRmk(String dpcsSmryRmk) {
		this.dpcsSmryRmk = dpcsSmryRmk;
	}
	
	/**
	 * Column Info
	 * @param batchDt
	 */
	public void setBatchDt(String batchDt) {
		this.batchDt = batchDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEventDate(JSPUtil.getParameter(request, "event_date", ""));
		setBkgSts(JSPUtil.getParameter(request, "bkg_sts", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setClassType(JSPUtil.getParameter(request, "class_type", ""));
		setFrDt(JSPUtil.getParameter(request, "fr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgStf(JSPUtil.getParameter(request, "bkg_stf", ""));
		setRegionCd(JSPUtil.getParameter(request, "region_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDocpDt(JSPUtil.getParameter(request, "docp_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setSelBkgOfcCd(JSPUtil.getParameter(request, "sel_bkg_ofc_cd", ""));
		setSelGsoCd(JSPUtil.getParameter(request, "sel_gso_cd", ""));
		setBkgDt(JSPUtil.getParameter(request, "bkg_dt", ""));
		setPortClzDt(JSPUtil.getParameter(request, "port_clz_dt", ""));
		setDpcsSmryRmk(JSPUtil.getParameter(request, "dpcs_smry_rmk", ""));
		setBatchDt(JSPUtil.getParameter(request, "batch_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocPFMCBLListVO[]
	 */
	public DocPFMCBLListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocPFMCBLListVO[]
	 */
	public DocPFMCBLListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocPFMCBLListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] eventDate = (JSPUtil.getParameter(request, prefix	+ "event_date", length));
			String[] bkgSts = (JSPUtil.getParameter(request, prefix	+ "bkg_sts", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] classType = (JSPUtil.getParameter(request, prefix	+ "class_type", length));
			String[] frDt = (JSPUtil.getParameter(request, prefix	+ "fr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgStf = (JSPUtil.getParameter(request, prefix	+ "bkg_stf", length));
			String[] regionCd = (JSPUtil.getParameter(request, prefix	+ "region_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] docpDt = (JSPUtil.getParameter(request, prefix	+ "docp_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] selBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "sel_bkg_ofc_cd", length));
			String[] selGsoCd = (JSPUtil.getParameter(request, prefix	+ "sel_gso_cd", length));
			String[] bkgDt = (JSPUtil.getParameter(request, prefix	+ "bkg_dt", length));
			String[] portClzDt = (JSPUtil.getParameter(request, prefix	+ "port_clz_dt", length));
			String[] dpcsSmryRmk = (JSPUtil.getParameter(request, prefix	+ "dpcs_smry_rmk", length));
			String[] batchDt = (JSPUtil.getParameter(request, prefix	+ "batch_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocPFMCBLListVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (eventDate[i] != null)
					model.setEventDate(eventDate[i]);
				if (bkgSts[i] != null)
					model.setBkgSts(bkgSts[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (classType[i] != null)
					model.setClassType(classType[i]);
				if (frDt[i] != null)
					model.setFrDt(frDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgStf[i] != null)
					model.setBkgStf(bkgStf[i]);
				if (regionCd[i] != null)
					model.setRegionCd(regionCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (docpDt[i] != null)
					model.setDocpDt(docpDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (selBkgOfcCd[i] != null)
					model.setSelBkgOfcCd(selBkgOfcCd[i]);
				if (selGsoCd[i] != null)
					model.setSelGsoCd(selGsoCd[i]);
				if (bkgDt[i] != null)
					model.setBkgDt(bkgDt[i]);
				if (portClzDt[i] != null)
					model.setPortClzDt(portClzDt[i]);
				if (dpcsSmryRmk[i] != null)
					model.setDpcsSmryRmk(dpcsSmryRmk[i]);
				if (batchDt[i] != null)
					model.setBatchDt(batchDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocPFMCBLListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocPFMCBLListVO[]
	 */
	public DocPFMCBLListVO[] getDocPFMCBLListVOs(){
		DocPFMCBLListVO[] vos = (DocPFMCBLListVO[])models.toArray(new DocPFMCBLListVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDate = this.eventDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSts = this.bkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.classType = this.classType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt = this.frDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStf = this.bkgStf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionCd = this.regionCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docpDt = this.docpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selBkgOfcCd = this.selBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selGsoCd = this.selGsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDt = this.bkgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClzDt = this.portClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsSmryRmk = dpcsSmryRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchDt = this.batchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
