/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchLaneConnectionVO.java
*@FileTitle : SearchLaneConnectionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.18 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchLaneConnectionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchLaneConnectionVO> models = new ArrayList<SearchLaneConnectionVO>();
	
	/* Column Info */
	private String iLaneFrom = null;
	/* Column Info */
	private String toTmlNm = null;
	/* Column Info */
	private String conType = null;
	/* Column Info */
	private String iCostYrmon = null;
	/* Column Info */
	private String stlGrp = null;
	/* Column Info */
	private String toDir = null;
	/* Column Info */
	private String toLane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmCrr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String iPortCd = null;
	/* Column Info */
	private String toTml = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String fmTmlNm = null;
	/* Column Info */
	private String iLaneTo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fmDir = null;
	/* Column Info */
	private String stTime = null;
	/* Column Info */
	private String stlAmtD5 = null;
	/* Column Info */
	private String stlAmtD4 = null;
	/* Column Info */
	private String stlAmtD2 = null;
	/* Column Info */
	private String toStl = null;
	/* Column Info */
	private String stlCostCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fmTml = null;
	/* Column Info */
	private String fmStl = null;
	/* Column Info */
	private String fmLane = null;
	/* Column Info */
	private String stdPort = null;
	/* Column Info */
	private String toCrr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchLaneConnectionVO() {}

	public SearchLaneConnectionVO(String ibflag, String pagerows, String stdPort, String fmLane, String fmCrr, String fmDir, String fmTml, String fmTmlNm, String toLane, String toCrr, String toDir, String toTml, String toTmlNm, String stTime, String fmStl, String toStl, String stlCostCd, String stlGrp, String stlAmtD2, String stlAmtD4, String stlAmtD5, String iPortCd, String iLaneFrom, String iLaneTo, String conType, String iCostYrmon, String creOfcCd, String creUsrId, String updUsrId) {
		this.iLaneFrom = iLaneFrom;
		this.toTmlNm = toTmlNm;
		this.conType = conType;
		this.iCostYrmon = iCostYrmon;
		this.stlGrp = stlGrp;
		this.toDir = toDir;
		this.toLane = toLane;
		this.pagerows = pagerows;
		this.fmCrr = fmCrr;
		this.ibflag = ibflag;
		this.iPortCd = iPortCd;
		this.toTml = toTml;
		this.creOfcCd = creOfcCd;
		this.fmTmlNm = fmTmlNm;
		this.iLaneTo = iLaneTo;
		this.updUsrId = updUsrId;
		this.fmDir = fmDir;
		this.stTime = stTime;
		this.stlAmtD5 = stlAmtD5;
		this.stlAmtD4 = stlAmtD4;
		this.stlAmtD2 = stlAmtD2;
		this.toStl = toStl;
		this.stlCostCd = stlCostCd;
		this.creUsrId = creUsrId;
		this.fmTml = fmTml;
		this.fmStl = fmStl;
		this.fmLane = fmLane;
		this.stdPort = stdPort;
		this.toCrr = toCrr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("i_lane_from", getILaneFrom());
		this.hashColumns.put("to_tml_nm", getToTmlNm());
		this.hashColumns.put("con_type", getConType());
		this.hashColumns.put("i_cost_yrmon", getICostYrmon());
		this.hashColumns.put("stl_grp", getStlGrp());
		this.hashColumns.put("to_dir", getToDir());
		this.hashColumns.put("to_lane", getToLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_crr", getFmCrr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("i_port_cd", getIPortCd());
		this.hashColumns.put("to_tml", getToTml());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("fm_tml_nm", getFmTmlNm());
		this.hashColumns.put("i_lane_to", getILaneTo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fm_dir", getFmDir());
		this.hashColumns.put("st_time", getStTime());
		this.hashColumns.put("stl_amt_d5", getStlAmtD5());
		this.hashColumns.put("stl_amt_d4", getStlAmtD4());
		this.hashColumns.put("stl_amt_d2", getStlAmtD2());
		this.hashColumns.put("to_stl", getToStl());
		this.hashColumns.put("stl_cost_cd", getStlCostCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fm_tml", getFmTml());
		this.hashColumns.put("fm_stl", getFmStl());
		this.hashColumns.put("fm_lane", getFmLane());
		this.hashColumns.put("std_port", getStdPort());
		this.hashColumns.put("to_crr", getToCrr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("i_lane_from", "iLaneFrom");
		this.hashFields.put("to_tml_nm", "toTmlNm");
		this.hashFields.put("con_type", "conType");
		this.hashFields.put("i_cost_yrmon", "iCostYrmon");
		this.hashFields.put("stl_grp", "stlGrp");
		this.hashFields.put("to_dir", "toDir");
		this.hashFields.put("to_lane", "toLane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_crr", "fmCrr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("i_port_cd", "iPortCd");
		this.hashFields.put("to_tml", "toTml");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("fm_tml_nm", "fmTmlNm");
		this.hashFields.put("i_lane_to", "iLaneTo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fm_dir", "fmDir");
		this.hashFields.put("st_time", "stTime");
		this.hashFields.put("stl_amt_d5", "stlAmtD5");
		this.hashFields.put("stl_amt_d4", "stlAmtD4");
		this.hashFields.put("stl_amt_d2", "stlAmtD2");
		this.hashFields.put("to_stl", "toStl");
		this.hashFields.put("stl_cost_cd", "stlCostCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fm_tml", "fmTml");
		this.hashFields.put("fm_stl", "fmStl");
		this.hashFields.put("fm_lane", "fmLane");
		this.hashFields.put("std_port", "stdPort");
		this.hashFields.put("to_crr", "toCrr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iLaneFrom
	 */
	public String getILaneFrom() {
		return this.iLaneFrom;
	}
	
	/**
	 * Column Info
	 * @return toTmlNm
	 */
	public String getToTmlNm() {
		return this.toTmlNm;
	}
	
	/**
	 * Column Info
	 * @return conType
	 */
	public String getConType() {
		return this.conType;
	}
	
	/**
	 * Column Info
	 * @return iCostYrmon
	 */
	public String getICostYrmon() {
		return this.iCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return stlGrp
	 */
	public String getStlGrp() {
		return this.stlGrp;
	}
	
	/**
	 * Column Info
	 * @return toDir
	 */
	public String getToDir() {
		return this.toDir;
	}
	
	/**
	 * Column Info
	 * @return toLane
	 */
	public String getToLane() {
		return this.toLane;
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
	 * @return fmCrr
	 */
	public String getFmCrr() {
		return this.fmCrr;
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
	 * @return iPortCd
	 */
	public String getIPortCd() {
		return this.iPortCd;
	}
	
	/**
	 * Column Info
	 * @return toTml
	 */
	public String getToTml() {
		return this.toTml;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmTmlNm
	 */
	public String getFmTmlNm() {
		return this.fmTmlNm;
	}
	
	/**
	 * Column Info
	 * @return iLaneTo
	 */
	public String getILaneTo() {
		return this.iLaneTo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return fmDir
	 */
	public String getFmDir() {
		return this.fmDir;
	}
	
	/**
	 * Column Info
	 * @return stTime
	 */
	public String getStTime() {
		return this.stTime;
	}
	
	/**
	 * Column Info
	 * @return stlAmtD5
	 */
	public String getStlAmtD5() {
		return this.stlAmtD5;
	}
	
	/**
	 * Column Info
	 * @return stlAmtD4
	 */
	public String getStlAmtD4() {
		return this.stlAmtD4;
	}
	
	/**
	 * Column Info
	 * @return stlAmtD2
	 */
	public String getStlAmtD2() {
		return this.stlAmtD2;
	}
	
	/**
	 * Column Info
	 * @return toStl
	 */
	public String getToStl() {
		return this.toStl;
	}
	
	/**
	 * Column Info
	 * @return stlCostCd
	 */
	public String getStlCostCd() {
		return this.stlCostCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fmTml
	 */
	public String getFmTml() {
		return this.fmTml;
	}
	
	/**
	 * Column Info
	 * @return fmStl
	 */
	public String getFmStl() {
		return this.fmStl;
	}
	
	/**
	 * Column Info
	 * @return fmLane
	 */
	public String getFmLane() {
		return this.fmLane;
	}
	
	/**
	 * Column Info
	 * @return stdPort
	 */
	public String getStdPort() {
		return this.stdPort;
	}
	
	/**
	 * Column Info
	 * @return toCrr
	 */
	public String getToCrr() {
		return this.toCrr;
	}
	

	/**
	 * Column Info
	 * @param iLaneFrom
	 */
	public void setILaneFrom(String iLaneFrom) {
		this.iLaneFrom = iLaneFrom;
	}
	
	/**
	 * Column Info
	 * @param toTmlNm
	 */
	public void setToTmlNm(String toTmlNm) {
		this.toTmlNm = toTmlNm;
	}
	
	/**
	 * Column Info
	 * @param conType
	 */
	public void setConType(String conType) {
		this.conType = conType;
	}
	
	/**
	 * Column Info
	 * @param iCostYrmon
	 */
	public void setICostYrmon(String iCostYrmon) {
		this.iCostYrmon = iCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param stlGrp
	 */
	public void setStlGrp(String stlGrp) {
		this.stlGrp = stlGrp;
	}
	
	/**
	 * Column Info
	 * @param toDir
	 */
	public void setToDir(String toDir) {
		this.toDir = toDir;
	}
	
	/**
	 * Column Info
	 * @param toLane
	 */
	public void setToLane(String toLane) {
		this.toLane = toLane;
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
	 * @param fmCrr
	 */
	public void setFmCrr(String fmCrr) {
		this.fmCrr = fmCrr;
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
	 * @param iPortCd
	 */
	public void setIPortCd(String iPortCd) {
		this.iPortCd = iPortCd;
	}
	
	/**
	 * Column Info
	 * @param toTml
	 */
	public void setToTml(String toTml) {
		this.toTml = toTml;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmTmlNm
	 */
	public void setFmTmlNm(String fmTmlNm) {
		this.fmTmlNm = fmTmlNm;
	}
	
	/**
	 * Column Info
	 * @param iLaneTo
	 */
	public void setILaneTo(String iLaneTo) {
		this.iLaneTo = iLaneTo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param fmDir
	 */
	public void setFmDir(String fmDir) {
		this.fmDir = fmDir;
	}
	
	/**
	 * Column Info
	 * @param stTime
	 */
	public void setStTime(String stTime) {
		this.stTime = stTime;
	}
	
	/**
	 * Column Info
	 * @param stlAmtD5
	 */
	public void setStlAmtD5(String stlAmtD5) {
		this.stlAmtD5 = stlAmtD5;
	}
	
	/**
	 * Column Info
	 * @param stlAmtD4
	 */
	public void setStlAmtD4(String stlAmtD4) {
		this.stlAmtD4 = stlAmtD4;
	}
	
	/**
	 * Column Info
	 * @param stlAmtD2
	 */
	public void setStlAmtD2(String stlAmtD2) {
		this.stlAmtD2 = stlAmtD2;
	}
	
	/**
	 * Column Info
	 * @param toStl
	 */
	public void setToStl(String toStl) {
		this.toStl = toStl;
	}
	
	/**
	 * Column Info
	 * @param stlCostCd
	 */
	public void setStlCostCd(String stlCostCd) {
		this.stlCostCd = stlCostCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param fmTml
	 */
	public void setFmTml(String fmTml) {
		this.fmTml = fmTml;
	}
	
	/**
	 * Column Info
	 * @param fmStl
	 */
	public void setFmStl(String fmStl) {
		this.fmStl = fmStl;
	}
	
	/**
	 * Column Info
	 * @param fmLane
	 */
	public void setFmLane(String fmLane) {
		this.fmLane = fmLane;
	}
	
	/**
	 * Column Info
	 * @param stdPort
	 */
	public void setStdPort(String stdPort) {
		this.stdPort = stdPort;
	}
	
	/**
	 * Column Info
	 * @param toCrr
	 */
	public void setToCrr(String toCrr) {
		this.toCrr = toCrr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setILaneFrom(JSPUtil.getParameter(request, "i_lane_from", ""));
		setToTmlNm(JSPUtil.getParameter(request, "to_tml_nm", ""));
		setConType(JSPUtil.getParameter(request, "con_type", ""));
		setICostYrmon(JSPUtil.getParameter(request, "i_cost_yrmon", ""));
		setStlGrp(JSPUtil.getParameter(request, "stl_grp", ""));
		setToDir(JSPUtil.getParameter(request, "to_dir", ""));
		setToLane(JSPUtil.getParameter(request, "to_lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmCrr(JSPUtil.getParameter(request, "fm_crr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIPortCd(JSPUtil.getParameter(request, "i_port_cd", ""));
		setToTml(JSPUtil.getParameter(request, "to_tml", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setFmTmlNm(JSPUtil.getParameter(request, "fm_tml_nm", ""));
		setILaneTo(JSPUtil.getParameter(request, "i_lane_to", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFmDir(JSPUtil.getParameter(request, "fm_dir", ""));
		setStTime(JSPUtil.getParameter(request, "st_time", ""));
		setStlAmtD5(JSPUtil.getParameter(request, "stl_amt_d5", ""));
		setStlAmtD4(JSPUtil.getParameter(request, "stl_amt_d4", ""));
		setStlAmtD2(JSPUtil.getParameter(request, "stl_amt_d2", ""));
		setToStl(JSPUtil.getParameter(request, "to_stl", ""));
		setStlCostCd(JSPUtil.getParameter(request, "stl_cost_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFmTml(JSPUtil.getParameter(request, "fm_tml", ""));
		setFmStl(JSPUtil.getParameter(request, "fm_stl", ""));
		setFmLane(JSPUtil.getParameter(request, "fm_lane", ""));
		setStdPort(JSPUtil.getParameter(request, "std_port", ""));
		setToCrr(JSPUtil.getParameter(request, "to_crr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchLaneConnectionVO[]
	 */
	public SearchLaneConnectionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchLaneConnectionVO[]
	 */
	public SearchLaneConnectionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchLaneConnectionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iLaneFrom = (JSPUtil.getParameter(request, prefix	+ "i_lane_from", length));
			String[] toTmlNm = (JSPUtil.getParameter(request, prefix	+ "to_tml_nm", length));
			String[] conType = (JSPUtil.getParameter(request, prefix	+ "con_type", length));
			String[] iCostYrmon = (JSPUtil.getParameter(request, prefix	+ "i_cost_yrmon", length));
			String[] stlGrp = (JSPUtil.getParameter(request, prefix	+ "stl_grp", length));
			String[] toDir = (JSPUtil.getParameter(request, prefix	+ "to_dir", length));
			String[] toLane = (JSPUtil.getParameter(request, prefix	+ "to_lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmCrr = (JSPUtil.getParameter(request, prefix	+ "fm_crr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] iPortCd = (JSPUtil.getParameter(request, prefix	+ "i_port_cd", length));
			String[] toTml = (JSPUtil.getParameter(request, prefix	+ "to_tml", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] fmTmlNm = (JSPUtil.getParameter(request, prefix	+ "fm_tml_nm", length));
			String[] iLaneTo = (JSPUtil.getParameter(request, prefix	+ "i_lane_to", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fmDir = (JSPUtil.getParameter(request, prefix	+ "fm_dir", length));
			String[] stTime = (JSPUtil.getParameter(request, prefix	+ "st_time", length));
			String[] stlAmtD5 = (JSPUtil.getParameter(request, prefix	+ "stl_amt_d5", length));
			String[] stlAmtD4 = (JSPUtil.getParameter(request, prefix	+ "stl_amt_d4", length));
			String[] stlAmtD2 = (JSPUtil.getParameter(request, prefix	+ "stl_amt_d2", length));
			String[] toStl = (JSPUtil.getParameter(request, prefix	+ "to_stl", length));
			String[] stlCostCd = (JSPUtil.getParameter(request, prefix	+ "stl_cost_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fmTml = (JSPUtil.getParameter(request, prefix	+ "fm_tml", length));
			String[] fmStl = (JSPUtil.getParameter(request, prefix	+ "fm_stl", length));
			String[] fmLane = (JSPUtil.getParameter(request, prefix	+ "fm_lane", length));
			String[] stdPort = (JSPUtil.getParameter(request, prefix	+ "std_port", length));
			String[] toCrr = (JSPUtil.getParameter(request, prefix	+ "to_crr", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchLaneConnectionVO();
				if (iLaneFrom[i] != null)
					model.setILaneFrom(iLaneFrom[i]);
				if (toTmlNm[i] != null)
					model.setToTmlNm(toTmlNm[i]);
				if (conType[i] != null)
					model.setConType(conType[i]);
				if (iCostYrmon[i] != null)
					model.setICostYrmon(iCostYrmon[i]);
				if (stlGrp[i] != null)
					model.setStlGrp(stlGrp[i]);
				if (toDir[i] != null)
					model.setToDir(toDir[i]);
				if (toLane[i] != null)
					model.setToLane(toLane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmCrr[i] != null)
					model.setFmCrr(fmCrr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iPortCd[i] != null)
					model.setIPortCd(iPortCd[i]);
				if (toTml[i] != null)
					model.setToTml(toTml[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (fmTmlNm[i] != null)
					model.setFmTmlNm(fmTmlNm[i]);
				if (iLaneTo[i] != null)
					model.setILaneTo(iLaneTo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fmDir[i] != null)
					model.setFmDir(fmDir[i]);
				if (stTime[i] != null)
					model.setStTime(stTime[i]);
				if (stlAmtD5[i] != null)
					model.setStlAmtD5(stlAmtD5[i]);
				if (stlAmtD4[i] != null)
					model.setStlAmtD4(stlAmtD4[i]);
				if (stlAmtD2[i] != null)
					model.setStlAmtD2(stlAmtD2[i]);
				if (toStl[i] != null)
					model.setToStl(toStl[i]);
				if (stlCostCd[i] != null)
					model.setStlCostCd(stlCostCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fmTml[i] != null)
					model.setFmTml(fmTml[i]);
				if (fmStl[i] != null)
					model.setFmStl(fmStl[i]);
				if (fmLane[i] != null)
					model.setFmLane(fmLane[i]);
				if (stdPort[i] != null)
					model.setStdPort(stdPort[i]);
				if (toCrr[i] != null)
					model.setToCrr(toCrr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchLaneConnectionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchLaneConnectionVO[]
	 */
	public SearchLaneConnectionVO[] getSearchLaneConnectionVOs(){
		SearchLaneConnectionVO[] vos = (SearchLaneConnectionVO[])models.toArray(new SearchLaneConnectionVO[models.size()]);
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
		this.iLaneFrom = this.iLaneFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTmlNm = this.toTmlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conType = this.conType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iCostYrmon = this.iCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlGrp = this.stlGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDir = this.toDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLane = this.toLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCrr = this.fmCrr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPortCd = this.iPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTml = this.toTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTmlNm = this.fmTmlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iLaneTo = this.iLaneTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDir = this.fmDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stTime = this.stTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAmtD5 = this.stlAmtD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAmtD4 = this.stlAmtD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAmtD2 = this.stlAmtD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toStl = this.toStl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCostCd = this.stlCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTml = this.fmTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmStl = this.fmStl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLane = this.fmLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stdPort = this.stdPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCrr = this.toCrr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
