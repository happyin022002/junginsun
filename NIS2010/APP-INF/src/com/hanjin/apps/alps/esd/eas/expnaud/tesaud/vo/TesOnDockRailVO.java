/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesOnDockRailVO.java
*@FileTitle : TesOnDockRailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo;

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

public class TesOnDockRailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesOnDockRailVO> models = new ArrayList<TesOnDockRailVO>();
	
	/* Column Info */
	private String vrfyRsltIndCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String cntrDtc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String manualCheck = null;
	/* Column Info */
	private String wrkDt = null;
	/* Column Info */
	private String fmPrdDt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String dcgoClssCd = null;
	/* Column Info */
	private String invDateType = null;
	/* Column Info */
	private String toPrdDt = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String clmDt = null;
	/* Column Info */
	private String dscrIndCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrStyCd = null;
	/* Column Info */
	private String tmlInvStsCd = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String railBilDt = null;
	/* Column Info */
	private String cntrRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesOnDockRailVO() {}

	public TesOnDockRailVO(String ibflag, String pagerows, String dscrIndCd, String rowCount, String vrfyRsltIndCd, String vndrLglEngNm, String cntrDtc, String cntrTpszCd, String manualCheck, String wrkDt, String fmPrdDt, String invOfcCd, String rhq, String costOfcCd, String dcgoClssCd, String invDateType, String toPrdDt, String clmDt, String invNo, String ydCd, String cntrStyCd, String pageNo, String cntrNo, String vndrSeq, String railBilDt, String tmlInvStsCd, String cntrRmk, String creUsrNm) {
		this.vrfyRsltIndCd = vrfyRsltIndCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.rowCount = rowCount;
		this.cntrDtc = cntrDtc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrTpszCd = cntrTpszCd;
		this.manualCheck = manualCheck;
		this.wrkDt = wrkDt;
		this.fmPrdDt = fmPrdDt;
		this.invOfcCd = invOfcCd;
		this.rhq = rhq;
		this.costOfcCd = costOfcCd;
		this.dcgoClssCd = dcgoClssCd;
		this.invDateType = invDateType;
		this.toPrdDt = toPrdDt;
		this.creUsrNm = creUsrNm;
		this.clmDt = clmDt;
		this.dscrIndCd = dscrIndCd;
		this.invNo = invNo;
		this.ydCd = ydCd;
		this.cntrStyCd = cntrStyCd;
		this.tmlInvStsCd = tmlInvStsCd;
		this.pageNo = pageNo;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.railBilDt = railBilDt;
		this.cntrRmk = cntrRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vrfy_rslt_ind_cd", getVrfyRsltIndCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("cntr_dtc", getCntrDtc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("manual_check", getManualCheck());
		this.hashColumns.put("wrk_dt", getWrkDt());
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("dcgo_clss_cd", getDcgoClssCd());
		this.hashColumns.put("inv_date_type", getInvDateType());
		this.hashColumns.put("to_prd_dt", getToPrdDt());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("clm_dt", getClmDt());
		this.hashColumns.put("dscr_ind_cd", getDscrIndCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_sty_cd", getCntrStyCd());
		this.hashColumns.put("tml_inv_sts_cd", getTmlInvStsCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rail_bil_dt", getRailBilDt());
		this.hashColumns.put("cntr_rmk", getCntrRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vrfy_rslt_ind_cd", "vrfyRsltIndCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("cntr_dtc", "cntrDtc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("manual_check", "manualCheck");
		this.hashFields.put("wrk_dt", "wrkDt");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("dcgo_clss_cd", "dcgoClssCd");
		this.hashFields.put("inv_date_type", "invDateType");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("clm_dt", "clmDt");
		this.hashFields.put("dscr_ind_cd", "dscrIndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_sty_cd", "cntrStyCd");
		this.hashFields.put("tml_inv_sts_cd", "tmlInvStsCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rail_bil_dt", "railBilDt");
		this.hashFields.put("cntr_rmk", "cntrRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vrfyRsltIndCd
	 */
	public String getVrfyRsltIndCd() {
		return this.vrfyRsltIndCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return cntrDtc
	 */
	public String getCntrDtc() {
		return this.cntrDtc;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return manualCheck
	 */
	public String getManualCheck() {
		return this.manualCheck;
	}
	
	/**
	 * Column Info
	 * @return wrkDt
	 */
	public String getWrkDt() {
		return this.wrkDt;
	}
	
	/**
	 * Column Info
	 * @return fmPrdDt
	 */
	public String getFmPrdDt() {
		return this.fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoClssCd
	 */
	public String getDcgoClssCd() {
		return this.dcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @return invDateType
	 */
	public String getInvDateType() {
		return this.invDateType;
	}
	
	/**
	 * Column Info
	 * @return toPrdDt
	 */
	public String getToPrdDt() {
		return this.toPrdDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return clmDt
	 */
	public String getClmDt() {
		return this.clmDt;
	}
	
	/**
	 * Column Info
	 * @return dscrIndCd
	 */
	public String getDscrIndCd() {
		return this.dscrIndCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStyCd
	 */
	public String getCntrStyCd() {
		return this.cntrStyCd;
	}
	
	/**
	 * Column Info
	 * @return tmlInvStsCd
	 */
	public String getTmlInvStsCd() {
		return this.tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return railBilDt
	 */
	public String getRailBilDt() {
		return this.railBilDt;
	}
	
	/**
	 * Column Info
	 * @return cntrRmk
	 */
	public String getCntrRmk() {
		return this.cntrRmk;
	}
	

	/**
	 * Column Info
	 * @param vrfyRsltIndCd
	 */
	public void setVrfyRsltIndCd(String vrfyRsltIndCd) {
		this.vrfyRsltIndCd = vrfyRsltIndCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param cntrDtc
	 */
	public void setCntrDtc(String cntrDtc) {
		this.cntrDtc = cntrDtc;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param manualCheck
	 */
	public void setManualCheck(String manualCheck) {
		this.manualCheck = manualCheck;
	}
	
	/**
	 * Column Info
	 * @param wrkDt
	 */
	public void setWrkDt(String wrkDt) {
		this.wrkDt = wrkDt;
	}
	
	/**
	 * Column Info
	 * @param fmPrdDt
	 */
	public void setFmPrdDt(String fmPrdDt) {
		this.fmPrdDt = fmPrdDt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoClssCd
	 */
	public void setDcgoClssCd(String dcgoClssCd) {
		this.dcgoClssCd = dcgoClssCd;
	}
	
	/**
	 * Column Info
	 * @param invDateType
	 */
	public void setInvDateType(String invDateType) {
		this.invDateType = invDateType;
	}
	
	/**
	 * Column Info
	 * @param toPrdDt
	 */
	public void setToPrdDt(String toPrdDt) {
		this.toPrdDt = toPrdDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param clmDt
	 */
	public void setClmDt(String clmDt) {
		this.clmDt = clmDt;
	}
	
	/**
	 * Column Info
	 * @param dscrIndCd
	 */
	public void setDscrIndCd(String dscrIndCd) {
		this.dscrIndCd = dscrIndCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStyCd
	 */
	public void setCntrStyCd(String cntrStyCd) {
		this.cntrStyCd = cntrStyCd;
	}
	
	/**
	 * Column Info
	 * @param tmlInvStsCd
	 */
	public void setTmlInvStsCd(String tmlInvStsCd) {
		this.tmlInvStsCd = tmlInvStsCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param railBilDt
	 */
	public void setRailBilDt(String railBilDt) {
		this.railBilDt = railBilDt;
	}
	
	/**
	 * Column Info
	 * @param cntrRmk
	 */
	public void setCntrRmk(String cntrRmk) {
		this.cntrRmk = cntrRmk;
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
		setVrfyRsltIndCd(JSPUtil.getParameter(request, prefix + "vrfy_rslt_ind_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setCntrDtc(JSPUtil.getParameter(request, prefix + "cntr_dtc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setManualCheck(JSPUtil.getParameter(request, prefix + "manual_check", ""));
		setWrkDt(JSPUtil.getParameter(request, prefix + "wrk_dt", ""));
		setFmPrdDt(JSPUtil.getParameter(request, prefix + "fm_prd_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setDcgoClssCd(JSPUtil.getParameter(request, prefix + "dcgo_clss_cd", ""));
		setInvDateType(JSPUtil.getParameter(request, prefix + "inv_date_type", ""));
		setToPrdDt(JSPUtil.getParameter(request, prefix + "to_prd_dt", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setClmDt(JSPUtil.getParameter(request, prefix + "clm_dt", ""));
		setDscrIndCd(JSPUtil.getParameter(request, prefix + "dscr_ind_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrStyCd(JSPUtil.getParameter(request, prefix + "cntr_sty_cd", ""));
		setTmlInvStsCd(JSPUtil.getParameter(request, prefix + "tml_inv_sts_cd", ""));
		setPageNo(JSPUtil.getParameter(request, prefix + "page_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setRailBilDt(JSPUtil.getParameter(request, prefix + "rail_bil_dt", ""));
		setCntrRmk(JSPUtil.getParameter(request, prefix + "cntr_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesOnDockRailVO[]
	 */
	public TesOnDockRailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesOnDockRailVO[]
	 */
	public TesOnDockRailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesOnDockRailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vrfyRsltIndCd = (JSPUtil.getParameter(request, prefix	+ "vrfy_rslt_ind_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] cntrDtc = (JSPUtil.getParameter(request, prefix	+ "cntr_dtc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] manualCheck = (JSPUtil.getParameter(request, prefix	+ "manual_check", length));
			String[] wrkDt = (JSPUtil.getParameter(request, prefix	+ "wrk_dt", length));
			String[] fmPrdDt = (JSPUtil.getParameter(request, prefix	+ "fm_prd_dt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] dcgoClssCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_clss_cd", length));
			String[] invDateType = (JSPUtil.getParameter(request, prefix	+ "inv_date_type", length));
			String[] toPrdDt = (JSPUtil.getParameter(request, prefix	+ "to_prd_dt", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] clmDt = (JSPUtil.getParameter(request, prefix	+ "clm_dt", length));
			String[] dscrIndCd = (JSPUtil.getParameter(request, prefix	+ "dscr_ind_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrStyCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sty_cd", length));
			String[] tmlInvStsCd = (JSPUtil.getParameter(request, prefix	+ "tml_inv_sts_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] railBilDt = (JSPUtil.getParameter(request, prefix	+ "rail_bil_dt", length));
			String[] cntrRmk = (JSPUtil.getParameter(request, prefix	+ "cntr_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesOnDockRailVO();
				if (vrfyRsltIndCd[i] != null)
					model.setVrfyRsltIndCd(vrfyRsltIndCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (cntrDtc[i] != null)
					model.setCntrDtc(cntrDtc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (manualCheck[i] != null)
					model.setManualCheck(manualCheck[i]);
				if (wrkDt[i] != null)
					model.setWrkDt(wrkDt[i]);
				if (fmPrdDt[i] != null)
					model.setFmPrdDt(fmPrdDt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (dcgoClssCd[i] != null)
					model.setDcgoClssCd(dcgoClssCd[i]);
				if (invDateType[i] != null)
					model.setInvDateType(invDateType[i]);
				if (toPrdDt[i] != null)
					model.setToPrdDt(toPrdDt[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (clmDt[i] != null)
					model.setClmDt(clmDt[i]);
				if (dscrIndCd[i] != null)
					model.setDscrIndCd(dscrIndCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrStyCd[i] != null)
					model.setCntrStyCd(cntrStyCd[i]);
				if (tmlInvStsCd[i] != null)
					model.setTmlInvStsCd(tmlInvStsCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (railBilDt[i] != null)
					model.setRailBilDt(railBilDt[i]);
				if (cntrRmk[i] != null)
					model.setCntrRmk(cntrRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesOnDockRailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesOnDockRailVO[]
	 */
	public TesOnDockRailVO[] getTesOnDockRailVOs(){
		TesOnDockRailVO[] vos = (TesOnDockRailVO[])models.toArray(new TesOnDockRailVO[models.size()]);
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
		this.vrfyRsltIndCd = this.vrfyRsltIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDtc = this.cntrDtc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manualCheck = this.manualCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkDt = this.wrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt = this.fmPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoClssCd = this.dcgoClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDateType = this.invDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt = this.toPrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmDt = this.clmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrIndCd = this.dscrIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStyCd = this.cntrStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvStsCd = this.tmlInvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railBilDt = this.railBilDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRmk = this.cntrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
