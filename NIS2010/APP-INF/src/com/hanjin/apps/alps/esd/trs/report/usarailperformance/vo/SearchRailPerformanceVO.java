/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRailPerformanceVO.java
*@FileTitle : SearchRailPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 김종호
*@LastVersion : 1.3
* 2009.10.06 최진오 
* 1.0 Creation
* 1.1 2011.02.18 손은주 [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청 - 
* 1.3 2011.05.27 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청 
* 2013.06.25 조인영 [CHM-201324798] [TRS] Report 메뉴 40ft CNTR 세분화 및 조회조건 추가
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.usarailperformance.vo;

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
 * @author 최진오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRailPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRailPerformanceVO> models = new ArrayList<SearchRailPerformanceVO>();
	
	/* Column Info */
	private String ctrlOfc = null;
	/* Column Info */
	private String frmYard = null;
	/* Column Info */
	private String currentOfcCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String toYard = null;
	/* Column Info */
	private String loginUsrId = null;
	/* Column Info */
	private String fmDate = null;
	/* Column Info */
	private String toNode = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String compCd = null;
	/* Column Info */
	private String loginOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ioBound = null;
	/* Column Info */
	private String frmNode = null;
	/* Column Info */
	private String loginDate = null;
	/* Column Info */
	private String railRoadName = null;
	/* Column Info */
	private String railRoadCode = null;
	/* Column Info */
	private String fChkprd = null;
	/* Column Info */
	private String fYear = null;
	/* Column Info */
	private String fFmMon = null;
	/* Column Info */
	private String fToMon = null;
	/* Column Info */
	private String fFmWk = null;
	/* Column Info */
	private String fToWk = null;
	/* Column Info */
	private String locOn = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String agmtChk = null;
	/* Column Info */
	private String cntrTpsz = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRailPerformanceVO() {}

	public SearchRailPerformanceVO(String ibflag, String pagerows, String dateType, String fmDate, String toDate, String railRoadCode, String railRoadName, String status, String ioBound, String compCd, String frmNode, String frmYard, String toNode, String toYard, String ctrlOfc, String loginOfcCd, String loginUsrId, String loginDate, String currentOfcCd, String fChkprd, String fYear, String fFmMon, String fToMon, String fFmWk, String fToWk, String locOn, String agmtRefNo, String agmtChk, String cntrTpsz) {
		this.ctrlOfc = ctrlOfc;
		this.frmYard = frmYard;
		this.currentOfcCd = currentOfcCd;
		this.status = status;
		this.toDate = toDate;
		this.dateType = dateType;
		this.toYard = toYard;
		this.loginUsrId = loginUsrId;
		this.fmDate = fmDate;
		this.toNode = toNode;
		this.pagerows = pagerows;
		this.compCd = compCd;
		this.loginOfcCd = loginOfcCd;
		this.ibflag = ibflag;
		this.ioBound = ioBound;
		this.frmNode = frmNode;
		this.loginDate = loginDate;
		this.railRoadName = railRoadName;
		this.railRoadCode = railRoadCode;
		this.frmYard = frmYard;
		this.fChkprd = fChkprd;
		this.fFmMon = fFmMon;
		this.fFmWk = fFmWk;
		this.fToWk = fToWk;
		this.fYear = fYear;
		this.locOn = locOn;
		this.agmtRefNo = agmtRefNo;
		this.agmtChk = agmtChk;
		this.cntrTpsz = cntrTpsz;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrl_ofc", getCtrlOfc());
		this.hashColumns.put("frm_yard", getFrmYard());
		this.hashColumns.put("current_ofc_cd", getCurrentOfcCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("to_yard", getToYard());
		this.hashColumns.put("login_usr_id", getLoginUsrId());
		this.hashColumns.put("fm_date", getFmDate());
		this.hashColumns.put("to_node", getToNode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("comp_cd", getCompCd());
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("io_bound", getIoBound());
		this.hashColumns.put("frm_node", getFrmNode());
		this.hashColumns.put("login_date", getLoginDate());
		this.hashColumns.put("rail_road_name", getRailRoadName());
		this.hashColumns.put("rail_road_code", getRailRoadCode());
		this.hashColumns.put("f_chkprd", getFChkprd());
		this.hashColumns.put("f_fm_mon", getFFmMon());
		this.hashColumns.put("f_to_mon", getFToMon());
		this.hashColumns.put("f_fm_wk", getFFmWk());
		this.hashColumns.put("f_to_wk", getFToWk());
		this.hashColumns.put("f_year", getFYear());
		this.hashColumns.put("loc_on", getLocOn());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("agmt_chk", getAgmtChk());
		this.hashColumns.put("cntr_tpsz", getCntrTpsz());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrl_ofc", "ctrlOfc");
		this.hashFields.put("frm_yard", "frmYard");
		this.hashFields.put("current_ofc_cd", "currentOfcCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("to_yard", "toYard");
		this.hashFields.put("login_usr_id", "loginUsrId");
		this.hashFields.put("fm_date", "fmDate");
		this.hashFields.put("to_node", "toNode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("comp_cd", "compCd");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("io_bound", "ioBound");
		this.hashFields.put("frm_node", "frmNode");
		this.hashFields.put("login_date", "loginDate");
		this.hashFields.put("rail_road_name", "railRoadName");
		this.hashFields.put("rail_road_code", "railRoadCode");
		this.hashFields.put("f_chkprd", "fChkprd");
		this.hashFields.put("f_fm_mon", "fFmMon");
		this.hashFields.put("f_to_mon", "fToMon");
		this.hashFields.put("f_fm_wk", "fFmWk");
		this.hashFields.put("f_to_wk", "fToWk");
		this.hashFields.put("f_year", "fYear");
		this.hashFields.put("loc_on", "locOn");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("agmt_chk", "agmtChk");
		this.hashFields.put("cntr_tpsz", "cntrTpsz");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfc
	 */
	public String getCtrlOfc() {
		return this.ctrlOfc;
	}
	
	/**
	 * Column Info
	 * @return frmYard
	 */
	public String getFrmYard() {
		return this.frmYard;
	}
	
	/**
	 * Column Info
	 * @return currentOfcCd
	 */
	public String getCurrentOfcCd() {
		return this.currentOfcCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return dateType
	 */
	public String getDateType() {
		return this.dateType;
	}
	
	/**
	 * Column Info
	 * @return toYard
	 */
	public String getToYard() {
		return this.toYard;
	}
	
	/**
	 * Column Info
	 * @return loginUsrId
	 */
	public String getLoginUsrId() {
		return this.loginUsrId;
	}
	
	/**
	 * Column Info
	 * @return fmDate
	 */
	public String getFmDate() {
		return this.fmDate;
	}
	
	/**
	 * Column Info
	 * @return toNode
	 */
	public String getToNode() {
		return this.toNode;
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
	 * @return compCd
	 */
	public String getCompCd() {
		return this.compCd;
	}
	
	/**
	 * Column Info
	 * @return loginOfcCd
	 */
	public String getLoginOfcCd() {
		return this.loginOfcCd;
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
	 * @return ioBound
	 */
	public String getIoBound() {
		return this.ioBound;
	}
	
	/**
	 * Column Info
	 * @return frmNode
	 */
	public String getFrmNode() {
		return this.frmNode;
	}
	
	/**
	 * Column Info
	 * @return loginDate
	 */
	public String getLoginDate() {
		return this.loginDate;
	}
	
	/**
	 * Column Info
	 * @return railRoadName
	 */
	public String getRailRoadName() {
		return this.railRoadName;
	}
	
	/**
	 * Column Info
	 * @return railRoadCode
	 */
	public String getRailRoadCode() {
		return this.railRoadCode;
	}
	
	/**
	 * Column Info
	 * @return fChkprd
	 */
	public String getFChkprd() {
		return this.fChkprd;
	}
	
	/**
	 * Column Info
	 * @return fFmMon
	 */
	public String getFFmMon() {
		return this.fFmMon;
	}
	
	/**
	 * Column Info
	 * @return fToMon
	 */
	public String getFToMon() {
		return this.fToMon;
	}	
	
	/**
	 * Column Info
	 * @return fFmWk
	 */
	public String getFFmWk() {
		return this.fFmWk;
	}

	
	/**
	 * Column Info
	 * @return fToWk
	 */
	public String getFToWk() {
		return this.fToWk;
	}
	
	/**
	 * Column Info
	 * @return fYear
	 */
	public String getFYear() {
		return this.fYear;
	}
	
	/**
	 * Column Info
	 * @return locOn
	 */
	public String getLocOn() {
		return this.locOn;
	}
	
	/**
	 * Column Info
	 * @return cntrTpsz
	 */
	public String getCntrTpsz() {
		return this.cntrTpsz;
	}

	
	/**
	 * Column Info
	 * @param fChkprd
	 */
	public void setFChkprd(String fChkprd) {
		this.fChkprd = fChkprd;
	}
	
	
	/**
	 * Column Info
	 * @param ctrlOfc
	 */
	public void setCtrlOfc(String ctrlOfc) {
		this.ctrlOfc = ctrlOfc;
	}
	
	/**
	 * Column Info
	 * @param frmYard
	 */
	public void setFrmYard(String frmYard) {
		this.frmYard = frmYard;
	}
	
	/**
	 * Column Info
	 * @param currentOfcCd
	 */
	public void setCurrentOfcCd(String currentOfcCd) {
		this.currentOfcCd = currentOfcCd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
	/**
	 * Column Info
	 * @param toYard
	 */
	public void setToYard(String toYard) {
		this.toYard = toYard;
	}
	
	/**
	 * Column Info
	 * @param loginUsrId
	 */
	public void setLoginUsrId(String loginUsrId) {
		this.loginUsrId = loginUsrId;
	}
	
	/**
	 * Column Info
	 * @param fmDate
	 */
	public void setFmDate(String fmDate) {
		this.fmDate = fmDate;
	}
	
	/**
	 * Column Info
	 * @param toNode
	 */
	public void setToNode(String toNode) {
		this.toNode = toNode;
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
	 * @param compCd
	 */
	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}
	
	/**
	 * Column Info
	 * @param loginOfcCd
	 */
	public void setLoginOfcCd(String loginOfcCd) {
		this.loginOfcCd = loginOfcCd;
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
	 * @param ioBound
	 */
	public void setIoBound(String ioBound) {
		this.ioBound = ioBound;
	}
	
	/**
	 * Column Info
	 * @param frmNode
	 */
	public void setFrmNode(String frmNode) {
		this.frmNode = frmNode;
	}
	
	/**
	 * Column Info
	 * @param loginDate
	 */
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	
	/**
	 * Column Info
	 * @param railRoadName
	 */
	public void setRailRoadName(String railRoadName) {
		this.railRoadName = railRoadName;
	}
	
	/**
	 * Column Info
	 * @param railRoadCode
	 */
	public void setRailRoadCode(String railRoadCode) {
		this.railRoadCode = railRoadCode;
	}
	
	/**
	 * Column Info
	 * @param fFmMon
	 */
	public void setFFmMon(String fFmMon) {
		this.fFmMon = fFmMon;
	}
	
	/**
	 * Column Info
	 * @param fToMon
	 */
	public void setFToMon(String fToMon) {
		this.fToMon = fToMon;
	}
	
	/**
	 * Column Info
	 * @param fFmWk
	 */
	public void setFFmWk(String fFmWk) {
		this.fFmWk = fFmWk;
	}
	
	/**
	 * Column Info
	 * @param fToWk
	 */
	public void setFToWk(String fToWk) {
		this.fToWk = fToWk;
	}
	
	/**
	 * Column Info
	 * @param fYear
	 */
	public void setFYear(String fYear) {
		this.fYear = fYear;
	}
	
	/**
	 * Column Info
	 * @param locOn
	 */
	public void setLocOn(String locOn) {
		this.locOn = locOn;
	}

	/**
	 * @return the agmtRefNo
	 */
	public String getAgmtRefNo() {
		return agmtRefNo;
	}

	/**
	 * @param agmtRefNo the agmtRefNo to set
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	

	/**
	 * @return the agmtChk
	 */
	public String getAgmtChk() {
		return agmtChk;
	}

	/**
	 * @param agmtChk the agmtChk to set
	 */
	public void setAgmtChk(String agmtChk) {
		this.agmtChk = agmtChk;
	}
	
	/**
	 * @param the cntrTpsz
	 */
	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCtrlOfc(JSPUtil.getParameter(request, "ctrl_ofc", ""));
		setFrmYard(JSPUtil.getParameter(request, "frm_yard", ""));
		setCurrentOfcCd(JSPUtil.getParameter(request, "current_ofc_cd", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
		setDateType(JSPUtil.getParameter(request, "date_type", ""));
		setToYard(JSPUtil.getParameter(request, "to_yard", ""));
		setLoginUsrId(JSPUtil.getParameter(request, "login_usr_id", ""));
		setFmDate(JSPUtil.getParameter(request, "fm_date", ""));
		setToNode(JSPUtil.getParameter(request, "to_node", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCompCd(JSPUtil.getParameter(request, "comp_cd", ""));
		setLoginOfcCd(JSPUtil.getParameter(request, "login_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIoBound(JSPUtil.getParameter(request, "io_bound", ""));
		setFrmNode(JSPUtil.getParameter(request, "frm_node", ""));
		setLoginDate(JSPUtil.getParameter(request, "login_date", ""));
		setRailRoadName(JSPUtil.getParameter(request, "rail_road_name", ""));
		setRailRoadCode(JSPUtil.getParameter(request, "rail_road_code", ""));
		setFChkprd(JSPUtil.getParameter(request, "f_chkprd", ""));
		setFFmMon(JSPUtil.getParameter(request, "f_fm_mon", ""));
		setFToMon(JSPUtil.getParameter(request, "f_to_mon", ""));
		setFFmWk(JSPUtil.getParameter(request, "f_fm_wk", ""));
		setFToWk(JSPUtil.getParameter(request, "f_to_wk", ""));
		setFYear(JSPUtil.getParameter(request, "f_year", ""));
		setLocOn(JSPUtil.getParameter(request, "loc_on", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setAgmtChk(JSPUtil.getParameter(request, "agmt_chk", ""));
		setCntrTpsz(JSPUtil.getParameter(request, "cntr_tpsz", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRailPerformanceVO[]
	 */
	public SearchRailPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRailPerformanceVO[]
	 */
	public SearchRailPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRailPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrlOfc = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc", length));
			String[] frmYard = (JSPUtil.getParameter(request, prefix	+ "frm_yard", length));
			String[] currentOfcCd = (JSPUtil.getParameter(request, prefix	+ "current_ofc_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] toYard = (JSPUtil.getParameter(request, prefix	+ "to_yard", length));
			String[] loginUsrId = (JSPUtil.getParameter(request, prefix	+ "login_usr_id", length));
			String[] fmDate = (JSPUtil.getParameter(request, prefix	+ "fm_date", length));
			String[] toNode = (JSPUtil.getParameter(request, prefix	+ "to_node", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] compCd = (JSPUtil.getParameter(request, prefix	+ "comp_cd", length));
			String[] loginOfcCd = (JSPUtil.getParameter(request, prefix	+ "login_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ioBound = (JSPUtil.getParameter(request, prefix	+ "io_bound", length));
			String[] frmNode = (JSPUtil.getParameter(request, prefix	+ "frm_node", length));
			String[] loginDate = (JSPUtil.getParameter(request, prefix	+ "login_date", length));
			String[] railRoadName = (JSPUtil.getParameter(request, prefix	+ "rail_road_name", length));
			String[] railRoadCode = (JSPUtil.getParameter(request, prefix	+ "rail_road_code", length));
			String[] fChkprd = (JSPUtil.getParameter(request, prefix	+ "f_chkprd", length));
			String[] fFmMon = (JSPUtil.getParameter(request, prefix	+ "f_fm_mon", length));
			String[] fToMon = (JSPUtil.getParameter(request, prefix	+ "f_to_mon", length));
			String[] fFmWk = (JSPUtil.getParameter(request, prefix	+ "f_fm_wk", length));
			String[] fToWk = (JSPUtil.getParameter(request, prefix	+ "f_to_wk", length));
			String[] fYear = (JSPUtil.getParameter(request, prefix	+ "f_year", length));
			String[] locOn = (JSPUtil.getParameter(request, prefix	+ "loc_on", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] agmtChk = (JSPUtil.getParameter(request, prefix	+ "agmt_chk", length));
			String[] cntrTpsz = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new SearchRailPerformanceVO();
				if (ctrlOfc[i] != null)
					model.setCtrlOfc(ctrlOfc[i]);
				if (frmYard[i] != null)
					model.setFrmYard(frmYard[i]);
				if (currentOfcCd[i] != null)
					model.setCurrentOfcCd(currentOfcCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (toYard[i] != null)
					model.setToYard(toYard[i]);
				if (loginUsrId[i] != null)
					model.setLoginUsrId(loginUsrId[i]);
				if (fmDate[i] != null)
					model.setFmDate(fmDate[i]);
				if (toNode[i] != null)
					model.setToNode(toNode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (compCd[i] != null)
					model.setCompCd(compCd[i]);
				if (loginOfcCd[i] != null)
					model.setLoginOfcCd(loginOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ioBound[i] != null)
					model.setIoBound(ioBound[i]);
				if (frmNode[i] != null)
					model.setFrmNode(frmNode[i]);
				if (loginDate[i] != null)
					model.setLoginDate(loginDate[i]);
				if (railRoadName[i] != null)
					model.setRailRoadName(railRoadName[i]);
				if (railRoadCode[i] != null)
					model.setRailRoadCode(railRoadCode[i]);
				if (fChkprd[i] != null)
					model.setFChkprd(fChkprd[i]);
				if (fFmMon[i] != null)
					model.setFFmMon(fFmMon[i]);
				if (fToMon[i] != null)
					model.setFToMon(fToMon[i]);
				if (fFmWk[i] != null)
					model.setFFmWk(fFmWk[i]);
				if (fToWk[i] != null)
					model.setFToWk(fToWk[i]);
				if (fYear[i] != null)
					model.setFYear(fYear[i]);
				if (locOn[i] != null)
					model.setLocOn(locOn[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (agmtChk[i] != null)
					model.setAgmtChk(agmtChk[i]);
				if (cntrTpsz[i] != null)
					model.setCntrTpsz(cntrTpsz[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRailPerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRailPerformanceVO[]
	 */
	public SearchRailPerformanceVO[] getSearchRailPerformanceVOs(){
		SearchRailPerformanceVO[] vos = (SearchRailPerformanceVO[])models.toArray(new SearchRailPerformanceVO[models.size()]);
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
		this.ctrlOfc = this.ctrlOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmYard = this.frmYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currentOfcCd = this.currentOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYard = this.toYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginUsrId = this.loginUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDate = this.fmDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNode = this.toNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compCd = this.compCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd = this.loginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBound = this.ioBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmNode = this.frmNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginDate = this.loginDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRoadName = this.railRoadName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRoadCode = this.railRoadCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChkprd = this.fChkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmMon = this.fFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToMon = this.fToMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmWk = this.fFmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToWk = this.fToWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYear = this.fYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locOn = this.locOn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtChk = this.agmtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpsz = this.cntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
