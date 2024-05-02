/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchUSIORInfoVO.java
*@FileTitle : SearchUSIORInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.12.15 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUSIORInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUSIORInfoVO> models = new ArrayList<SearchUSIORInfoVO>();
	
	/* Column Info */
	private String tTruckSts = null;
	/* Column Info */
	private String tPupSts = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sLane = null;
	/* Column Info */
	private String costDiv = null;
	/* Column Info */
	private String sNeweqOffice = null;
	/* Column Info */
	private String sRailDest = null;
	/* Column Info */
	private String eqmtOfc = null;
	/* Column Info */
	private String ediStatus = null;
	/* Column Info */
	private String tCostMode = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sPupOffice = null;
	/* Column Info */
	private String mstBkgSts = null;
	/* Column Info */
	private String sScNo = null;
	/* Column Info */
	private String sEqOffice = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String sCLoc = null;
	/* Column Info */
	private String tEndSts = null;
	/* Column Info */
	private String tPNo = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String tRailBillingSts = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sDel = null;
	/* Column Info */
	private String dateselect = null;
	/* Column Info */
	private String sPolPod = null;
	/* Column Info */
	private String vndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchUSIORInfoVO() {}

	public SearchUSIORInfoVO(String ibflag, String pagerows, String tPupSts, String tTruckSts, String tPNo, String fmDt, String sLane, String tRailBillingSts, String sNeweqOffice, String eqmtOfc, String sVvd, String sRailDest, String ediStatus, String tCostMode, String toDt, String ofcCd, String sDel, String costDiv, String dateselect, String sPupOffice, String sPolPod, String vndrSeq, String sScNo, String sEqOffice, String tEndSts, String sCLoc, String portCd, String sBkgNo, String sCntrNo, String mstBkgSts) {
		this.tTruckSts = tTruckSts;
		this.tPupSts = tPupSts;
		this.sBkgNo = sBkgNo;
		this.sLane = sLane;
		this.costDiv = costDiv;
		this.sNeweqOffice = sNeweqOffice;
		this.sRailDest = sRailDest;
		this.eqmtOfc = eqmtOfc;
		this.ediStatus = ediStatus;
		this.tCostMode = tCostMode;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sPupOffice = sPupOffice;
		this.mstBkgSts = mstBkgSts;
		this.sScNo = sScNo;
		this.sEqOffice = sEqOffice;
		this.portCd = portCd;
		this.sCLoc = sCLoc;
		this.tEndSts = tEndSts;
		this.tPNo = tPNo;
		this.fmDt = fmDt;
		this.tRailBillingSts = tRailBillingSts;
		this.sCntrNo = sCntrNo;
		this.sVvd = sVvd;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.sDel = sDel;
		this.dateselect = dateselect;
		this.sPolPod = sPolPod;
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t_truck_sts", getTTruckSts());
		this.hashColumns.put("t_pup_sts", getTPupSts());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_lane", getSLane());
		this.hashColumns.put("cost_div", getCostDiv());
		this.hashColumns.put("s_neweq_office", getSNeweqOffice());
		this.hashColumns.put("s_rail_dest", getSRailDest());
		this.hashColumns.put("eqmt_ofc", getEqmtOfc());
		this.hashColumns.put("edi_status", getEdiStatus());
		this.hashColumns.put("t_cost_mode", getTCostMode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_pup_office", getSPupOffice());
		this.hashColumns.put("mst_bkg_sts", getMstBkgSts());
		this.hashColumns.put("s_sc_no", getSScNo());
		this.hashColumns.put("s_eq_office", getSEqOffice());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("s_c_loc", getSCLoc());
		this.hashColumns.put("t_end_sts", getTEndSts());
		this.hashColumns.put("t_p_no", getTPNo());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("t_rail_billing_sts", getTRailBillingSts());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_del", getSDel());
		this.hashColumns.put("dateselect", getDateselect());
		this.hashColumns.put("s_pol_pod", getSPolPod());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t_truck_sts", "tTruckSts");
		this.hashFields.put("t_pup_sts", "tPupSts");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_lane", "sLane");
		this.hashFields.put("cost_div", "costDiv");
		this.hashFields.put("s_neweq_office", "sNeweqOffice");
		this.hashFields.put("s_rail_dest", "sRailDest");
		this.hashFields.put("eqmt_ofc", "eqmtOfc");
		this.hashFields.put("edi_status", "ediStatus");
		this.hashFields.put("t_cost_mode", "tCostMode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_pup_office", "sPupOffice");
		this.hashFields.put("mst_bkg_sts", "mstBkgSts");
		this.hashFields.put("s_sc_no", "sScNo");
		this.hashFields.put("s_eq_office", "sEqOffice");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("s_c_loc", "sCLoc");
		this.hashFields.put("t_end_sts", "tEndSts");
		this.hashFields.put("t_p_no", "tPNo");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("t_rail_billing_sts", "tRailBillingSts");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_del", "sDel");
		this.hashFields.put("dateselect", "dateselect");
		this.hashFields.put("s_pol_pod", "sPolPod");
		this.hashFields.put("vndr_seq", "vndrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tTruckSts
	 */
	public String getTTruckSts() {
		return this.tTruckSts;
	}
	
	/**
	 * Column Info
	 * @return tPupSts
	 */
	public String getTPupSts() {
		return this.tPupSts;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return sLane
	 */
	public String getSLane() {
		return this.sLane;
	}
	
	/**
	 * Column Info
	 * @return costDiv
	 */
	public String getCostDiv() {
		return this.costDiv;
	}
	
	/**
	 * Column Info
	 * @return sNeweqOffice
	 */
	public String getSNeweqOffice() {
		return this.sNeweqOffice;
	}
	
	/**
	 * Column Info
	 * @return sRailDest
	 */
	public String getSRailDest() {
		return this.sRailDest;
	}
	
	/**
	 * Column Info
	 * @return eqmtOfc
	 */
	public String getEqmtOfc() {
		return this.eqmtOfc;
	}
	
	/**
	 * Column Info
	 * @return ediStatus
	 */
	public String getEdiStatus() {
		return this.ediStatus;
	}
	
	/**
	 * Column Info
	 * @return tCostMode
	 */
	public String getTCostMode() {
		return this.tCostMode;
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
	 * @return sPupOffice
	 */
	public String getSPupOffice() {
		return this.sPupOffice;
	}
	
	/**
	 * Column Info
	 * @return mstBkgSts
	 */
	public String getMstBkgSts() {
		return this.mstBkgSts;
	}
	
	/**
	 * Column Info
	 * @return sScNo
	 */
	public String getSScNo() {
		return this.sScNo;
	}
	
	/**
	 * Column Info
	 * @return sEqOffice
	 */
	public String getSEqOffice() {
		return this.sEqOffice;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return sCLoc
	 */
	public String getSCLoc() {
		return this.sCLoc;
	}
	
	/**
	 * Column Info
	 * @return tEndSts
	 */
	public String getTEndSts() {
		return this.tEndSts;
	}
	
	/**
	 * Column Info
	 * @return tPNo
	 */
	public String getTPNo() {
		return this.tPNo;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return tRailBillingSts
	 */
	public String getTRailBillingSts() {
		return this.tRailBillingSts;
	}
	
	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public String getSCntrNo() {
		return this.sCntrNo;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sDel
	 */
	public String getSDel() {
		return this.sDel;
	}
	
	/**
	 * Column Info
	 * @return dateselect
	 */
	public String getDateselect() {
		return this.dateselect;
	}
	
	/**
	 * Column Info
	 * @return sPolPod
	 */
	public String getSPolPod() {
		return this.sPolPod;
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
	 * @param tTruckSts
	 */
	public void setTTruckSts(String tTruckSts) {
		this.tTruckSts = tTruckSts;
	}
	
	/**
	 * Column Info
	 * @param tPupSts
	 */
	public void setTPupSts(String tPupSts) {
		this.tPupSts = tPupSts;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param sLane
	 */
	public void setSLane(String sLane) {
		this.sLane = sLane;
	}
	
	/**
	 * Column Info
	 * @param costDiv
	 */
	public void setCostDiv(String costDiv) {
		this.costDiv = costDiv;
	}
	
	/**
	 * Column Info
	 * @param sNeweqOffice
	 */
	public void setSNeweqOffice(String sNeweqOffice) {
		this.sNeweqOffice = sNeweqOffice;
	}
	
	/**
	 * Column Info
	 * @param sRailDest
	 */
	public void setSRailDest(String sRailDest) {
		this.sRailDest = sRailDest;
	}
	
	/**
	 * Column Info
	 * @param eqmtOfc
	 */
	public void setEqmtOfc(String eqmtOfc) {
		this.eqmtOfc = eqmtOfc;
	}
	
	/**
	 * Column Info
	 * @param ediStatus
	 */
	public void setEdiStatus(String ediStatus) {
		this.ediStatus = ediStatus;
	}
	
	/**
	 * Column Info
	 * @param tCostMode
	 */
	public void setTCostMode(String tCostMode) {
		this.tCostMode = tCostMode;
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
	 * @param sPupOffice
	 */
	public void setSPupOffice(String sPupOffice) {
		this.sPupOffice = sPupOffice;
	}
	
	/**
	 * Column Info
	 * @param mstBkgSts
	 */
	public void setMstBkgSts(String mstBkgSts) {
		this.mstBkgSts = mstBkgSts;
	}
	
	/**
	 * Column Info
	 * @param sScNo
	 */
	public void setSScNo(String sScNo) {
		this.sScNo = sScNo;
	}
	
	/**
	 * Column Info
	 * @param sEqOffice
	 */
	public void setSEqOffice(String sEqOffice) {
		this.sEqOffice = sEqOffice;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param sCLoc
	 */
	public void setSCLoc(String sCLoc) {
		this.sCLoc = sCLoc;
	}
	
	/**
	 * Column Info
	 * @param tEndSts
	 */
	public void setTEndSts(String tEndSts) {
		this.tEndSts = tEndSts;
	}
	
	/**
	 * Column Info
	 * @param tPNo
	 */
	public void setTPNo(String tPNo) {
		this.tPNo = tPNo;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param tRailBillingSts
	 */
	public void setTRailBillingSts(String tRailBillingSts) {
		this.tRailBillingSts = tRailBillingSts;
	}
	
	/**
	 * Column Info
	 * @param sCntrNo
	 */
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param sDel
	 */
	public void setSDel(String sDel) {
		this.sDel = sDel;
	}
	
	/**
	 * Column Info
	 * @param dateselect
	 */
	public void setDateselect(String dateselect) {
		this.dateselect = dateselect;
	}
	
	/**
	 * Column Info
	 * @param sPolPod
	 */
	public void setSPolPod(String sPolPod) {
		this.sPolPod = sPolPod;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
		setTTruckSts(JSPUtil.getParameter(request, prefix + "t_truck_sts", ""));
		setTPupSts(JSPUtil.getParameter(request, prefix + "t_pup_sts", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setSLane(JSPUtil.getParameter(request, prefix + "s_lane", ""));
		setCostDiv(JSPUtil.getParameter(request, prefix + "cost_div", ""));
		setSNeweqOffice(JSPUtil.getParameter(request, prefix + "s_neweq_office", ""));
		setSRailDest(JSPUtil.getParameter(request, prefix + "s_rail_dest", ""));
		setEqmtOfc(JSPUtil.getParameter(request, prefix + "eqmt_ofc", ""));
		setEdiStatus(JSPUtil.getParameter(request, prefix + "edi_status", ""));
		setTCostMode(JSPUtil.getParameter(request, prefix + "t_cost_mode", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSPupOffice(JSPUtil.getParameter(request, prefix + "s_pup_office", ""));
		setMstBkgSts(JSPUtil.getParameter(request, prefix + "mst_bkg_sts", ""));
		setSScNo(JSPUtil.getParameter(request, prefix + "s_sc_no", ""));
		setSEqOffice(JSPUtil.getParameter(request, prefix + "s_eq_office", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSCLoc(JSPUtil.getParameter(request, prefix + "s_c_loc", ""));
		setTEndSts(JSPUtil.getParameter(request, prefix + "t_end_sts", ""));
		setTPNo(JSPUtil.getParameter(request, prefix + "t_p_no", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setTRailBillingSts(JSPUtil.getParameter(request, prefix + "t_rail_billing_sts", ""));
		setSCntrNo(JSPUtil.getParameter(request, prefix + "s_cntr_no", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSDel(JSPUtil.getParameter(request, prefix + "s_del", ""));
		setDateselect(JSPUtil.getParameter(request, prefix + "dateselect", ""));
		setSPolPod(JSPUtil.getParameter(request, prefix + "s_pol_pod", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUSIORInfoVO[]
	 */
	public SearchUSIORInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUSIORInfoVO[]
	 */
	public SearchUSIORInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUSIORInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tTruckSts = (JSPUtil.getParameter(request, prefix	+ "t_truck_sts", length));
			String[] tPupSts = (JSPUtil.getParameter(request, prefix	+ "t_pup_sts", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sLane = (JSPUtil.getParameter(request, prefix	+ "s_lane", length));
			String[] costDiv = (JSPUtil.getParameter(request, prefix	+ "cost_div", length));
			String[] sNeweqOffice = (JSPUtil.getParameter(request, prefix	+ "s_neweq_office", length));
			String[] sRailDest = (JSPUtil.getParameter(request, prefix	+ "s_rail_dest", length));
			String[] eqmtOfc = (JSPUtil.getParameter(request, prefix	+ "eqmt_ofc", length));
			String[] ediStatus = (JSPUtil.getParameter(request, prefix	+ "edi_status", length));
			String[] tCostMode = (JSPUtil.getParameter(request, prefix	+ "t_cost_mode", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sPupOffice = (JSPUtil.getParameter(request, prefix	+ "s_pup_office", length));
			String[] mstBkgSts = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_sts", length));
			String[] sScNo = (JSPUtil.getParameter(request, prefix	+ "s_sc_no", length));
			String[] sEqOffice = (JSPUtil.getParameter(request, prefix	+ "s_eq_office", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] sCLoc = (JSPUtil.getParameter(request, prefix	+ "s_c_loc", length));
			String[] tEndSts = (JSPUtil.getParameter(request, prefix	+ "t_end_sts", length));
			String[] tPNo = (JSPUtil.getParameter(request, prefix	+ "t_p_no", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] tRailBillingSts = (JSPUtil.getParameter(request, prefix	+ "t_rail_billing_sts", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sDel = (JSPUtil.getParameter(request, prefix	+ "s_del", length));
			String[] dateselect = (JSPUtil.getParameter(request, prefix	+ "dateselect", length));
			String[] sPolPod = (JSPUtil.getParameter(request, prefix	+ "s_pol_pod", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUSIORInfoVO();
				if (tTruckSts[i] != null)
					model.setTTruckSts(tTruckSts[i]);
				if (tPupSts[i] != null)
					model.setTPupSts(tPupSts[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sLane[i] != null)
					model.setSLane(sLane[i]);
				if (costDiv[i] != null)
					model.setCostDiv(costDiv[i]);
				if (sNeweqOffice[i] != null)
					model.setSNeweqOffice(sNeweqOffice[i]);
				if (sRailDest[i] != null)
					model.setSRailDest(sRailDest[i]);
				if (eqmtOfc[i] != null)
					model.setEqmtOfc(eqmtOfc[i]);
				if (ediStatus[i] != null)
					model.setEdiStatus(ediStatus[i]);
				if (tCostMode[i] != null)
					model.setTCostMode(tCostMode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sPupOffice[i] != null)
					model.setSPupOffice(sPupOffice[i]);
				if (mstBkgSts[i] != null)
					model.setMstBkgSts(mstBkgSts[i]);
				if (sScNo[i] != null)
					model.setSScNo(sScNo[i]);
				if (sEqOffice[i] != null)
					model.setSEqOffice(sEqOffice[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (sCLoc[i] != null)
					model.setSCLoc(sCLoc[i]);
				if (tEndSts[i] != null)
					model.setTEndSts(tEndSts[i]);
				if (tPNo[i] != null)
					model.setTPNo(tPNo[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (tRailBillingSts[i] != null)
					model.setTRailBillingSts(tRailBillingSts[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sDel[i] != null)
					model.setSDel(sDel[i]);
				if (dateselect[i] != null)
					model.setDateselect(dateselect[i]);
				if (sPolPod[i] != null)
					model.setSPolPod(sPolPod[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUSIORInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUSIORInfoVO[]
	 */
	public SearchUSIORInfoVO[] getSearchUSIORInfoVOs(){
		SearchUSIORInfoVO[] vos = (SearchUSIORInfoVO[])models.toArray(new SearchUSIORInfoVO[models.size()]);
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
		this.tTruckSts = this.tTruckSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPupSts = this.tPupSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLane = this.sLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDiv = this.costDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNeweqOffice = this.sNeweqOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRailDest = this.sRailDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqmtOfc = this.eqmtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStatus = this.ediStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCostMode = this.tCostMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPupOffice = this.sPupOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgSts = this.mstBkgSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sScNo = this.sScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEqOffice = this.sEqOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCLoc = this.sCLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tEndSts = this.tEndSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPNo = this.tPNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tRailBillingSts = this.tRailBillingSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDel = this.sDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateselect = this.dateselect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolPod = this.sPolPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
