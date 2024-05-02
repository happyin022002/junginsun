/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MtyWeeklySimulationOptionVO.java
*@FileTitle : MtyWeeklySimulationOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.13
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.09.13 나상보 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo;

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
 * @author 나상보
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ForecastReportOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ForecastReportOptionVO> models = new ArrayList<ForecastReportOptionVO>();
	
	/* Column Info */
	private String cntrTpsz = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String oriLocCd = null;
	/* Column Info */
	private String levelCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String headWeek = null;
	/* Column Info */
	private String simTpCd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String oriOriLocCd = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String fmdate = null;
	/* Column Info */
	private String todate = null;
	/* Column Info */
	private String locTypeCode = null;
	/* Column Info */
	private String subLocCd = null;
	/* Column Info */
	private String locTpCdSecond = null;	
	/* Column Info */
	private String locCdSecond = null;
	/* Column Info */
	private String divFlag = null;	
	/* presenation Info*/
	private String presentFlag = null;	
	/* where condition Info*/
	private String conditionFlag = null;	
	/* where condition value Info*/
	private String conditionValue = null;	
	/* Column Info */
	private String fcastYrwk = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ForecastReportOptionVO() {}

	public ForecastReportOptionVO(String fcastYrwk, String ibflag, String pagerows, String ofcCd, String locCd, String levelCd, String headWeek, String locGrpCd, String oriLocCd, String week, String cntrTpsz, String simTpCd, String cntrQty, String usrId, String oriOriLocCd, String period, String fmdate, String todate, String locTypeCode, String subLocCd, String locTpCdSecond, String locCdSecond, String divFlag, String presentFlag, String conditionFlag, String conditionValue) {
		this.cntrTpsz = cntrTpsz;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.oriLocCd = oriLocCd;
		this.levelCd = levelCd;
		this.usrId = usrId;
		this.headWeek = headWeek;
		this.simTpCd = simTpCd;
		this.cntrQty = cntrQty;
		this.locGrpCd = locGrpCd;
		this.week = week;
		this.oriOriLocCd = oriOriLocCd;
		this.period = period;
		this.fmdate = fmdate;
		this.todate = todate;
		this.locTypeCode = locTypeCode;
		this.subLocCd = subLocCd;
		this.locTpCdSecond = locTpCdSecond;
		this.locCdSecond = locCdSecond;
		this.divFlag = divFlag;
		this.presentFlag = presentFlag;
		this.conditionFlag = conditionFlag;	
		this.conditionValue = conditionValue;		
		this.fcastYrwk = fcastYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz", getCntrTpsz());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ori_loc_cd", getOriLocCd());
		this.hashColumns.put("level_cd", getLevelCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("head_week", getHeadWeek());
		this.hashColumns.put("sim_tp_cd", getSimTpCd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("ori_ori_loc_cd", getOriOriLocCd());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("fmdate", getFmdate());
		this.hashColumns.put("todate", getTodate());
		this.hashColumns.put("loc_type_code", getLocTypeCode());
		this.hashColumns.put("sub_loc_cd", getSubLocCd());
		this.hashColumns.put("loc_tp_cd_second", getLocTpCdSecond());		
		this.hashColumns.put("loc_cd_second", getLocCdSecond());
		this.hashColumns.put("div_flag", getDivFlag());	
		
		this.hashColumns.put("present_flag", getPresentFlag());	
		this.hashColumns.put("condition_flag", getConditionFlag());		
		this.hashColumns.put("condition_value", getConditionValue());		
		
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_tpsz", "cntrTpsz");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ori_loc_cd", "oriLocCd");
		this.hashFields.put("level_cd", "levelCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("head_week", "headWeek");
		this.hashFields.put("sim_tp_cd", "simTpCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("week", "week");
		this.hashFields.put("ori_ori_loc_cd", "oriOriLocCd");
		this.hashFields.put("period", "period");
		this.hashFields.put("fmdate", "fmdate");
		this.hashFields.put("todate", "todate");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("loc_tp_cd_second", "locTpCdSecond");		
		this.hashFields.put("loc_cd_second", "locCdSecond");
		this.hashFields.put("div_flag", "divFlag");		
		
		this.hashFields.put("present_flag", "presentFlag");	
		this.hashFields.put("condition_flag", "conditionFlag");		
		this.hashFields.put("condition_value", "conditionValue");	
		
		this.hashFields.put("fcast_yrwk", "fcastYrwk");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrTpsz
	 */
	public String getCntrTpsz() {
		return this.cntrTpsz;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return oriLocCd
	 */
	public String getOriLocCd() {
		return this.oriLocCd;
	}
	
	/**
	 * Column Info
	 * @return levelCd
	 */
	public String getLevelCd() {
		return this.levelCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return headWeek
	 */
	public String getHeadWeek() {
		return this.headWeek;
	}
	
	/**
	 * Column Info
	 * @return simTpCd
	 */
	public String getSimTpCd() {
		return this.simTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return locGrpCd
	 */
	public String getLocGrpCd() {
		return this.locGrpCd;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	
	/**
	 * Column Info
	 * @return oriOriLocCd
	 */
	public String getOriOriLocCd() {
		return this.oriOriLocCd;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return fmdate
	 */
	public String getFmdate() {
		return this.fmdate;
	}
	
	/**
	 * Column Info
	 * @return todate
	 */
	public String getTodate() {
		return this.todate;
	}
	
	/**
	 * Column Info
	 * @return locTypeCode
	 */
	public String getLocTypeCode() {
		return this.locTypeCode;
	}
	
	/**
	 * Column Info
	 * @return subLocCd
	 */
	public String getSubLocCd() {
		return this.subLocCd;
	}

	/**
	 * Column Info
	 * @return locCdSecond
	 */
	public String getLocTpCdSecond() {
		return this.locTpCdSecond;
	}
	
	/**
	 * Column Info
	 * @return locCdSecond
	 */
	public String getLocCdSecond() {
		return this.locCdSecond;
	}	
	
	/**
	 * Column Info
	 * @return divFlag
	 */
	public String getDivFlag() {
		return this.divFlag;
	}	
	
	/**
	 * Column Info
	 * @return presentFlag
	 */
	public String getPresentFlag() {
		return this.presentFlag;
	}		
	
	/**
	 * Column Info
	 * @return conditionFlag
	 */
	public String getConditionFlag() {
		return this.conditionFlag;
	}		
	
	/**
	 * Column Info
	 * @return conditionValue
	 */
	public String getConditionValue() {
		return this.conditionValue;
	}		
	
	/**
	 * Column Info
	 * @return fcastYrwk
	 */
	public String getFcastYrwk() {
		return this.fcastYrwk;
	}

	/**
	 * Column Info
	 * @param cntrTpsz
	 */
	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param oriLocCd
	 */
	public void setOriLocCd(String oriLocCd) {
		this.oriLocCd = oriLocCd;
	}
	
	/**
	 * Column Info
	 * @param levelCd
	 */
	public void setLevelCd(String levelCd) {
		this.levelCd = levelCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param headWeek
	 */
	public void setHeadWeek(String headWeek) {
		this.headWeek = headWeek;
	}
	
	/**
	 * Column Info
	 * @param simTpCd
	 */
	public void setSimTpCd(String simTpCd) {
		this.simTpCd = simTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param locGrpCd
	 */
	public void setLocGrpCd(String locGrpCd) {
		this.locGrpCd = locGrpCd;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Column Info
	 * @param oriOriLocCd
	 */
	public void setOriOriLocCd(String oriOriLocCd) {
		this.oriOriLocCd = oriOriLocCd;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param fmdate
	 */
	public void setFmdate(String fmdate) {
		this.fmdate = fmdate;
	}
	
	/**
	 * Column Info
	 * @param todate
	 */
	public void setTodate(String todate) {
		this.todate = todate;
	}
	
	/**
	 * Column Info
	 * @param locTypeCode
	 */
	public void setLocTypeCode(String locTypeCode) {
		this.locTypeCode = locTypeCode;
	}

	/**
	 * Column Info
	 * @param locTpCdSecond
	 */
	public void setLocTpCdSecond(String locTpCdSecond) {
		this.locTpCdSecond = locTpCdSecond;
	}
	
	/**
	 * Column Info
	 * @param locCdSecond
	 */
	public void setLocCdSecond(String locCdSecond) {
		this.locCdSecond = locCdSecond;
	}
	
	/**
	 * Column Info
	 * @param divFlag
	 */
	public void setDivFlag(String divFlag) {
		this.divFlag = divFlag;
	}
	
	/**
	 * Column Info
	 * @param subLocCd
	 */
	public void setSubLocCd(String subLocCd) {
		this.subLocCd = subLocCd;
	}	
	
	/**
	 * Column Info
	 * @param presentFlag
	 */
	public void setPresentFlag(String presentFlag) {
		this.presentFlag = presentFlag;
	}		
	
	/**
	 * Column Info
	 * @param conditionFlag
	 */
	public void setConditionFlag(String conditionFlag) {
		this.conditionFlag = conditionFlag;
	}	
	
	/**
	 * Column Info
	 * @param conditionValue
	 */
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}	
	
	/**
	 * Column Info
	 * @param fcastYrwk
	 */
	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
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
		setCntrTpsz(JSPUtil.getParameter(request, prefix + "cntr_tpsz", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setOriLocCd(JSPUtil.getParameter(request, prefix + "ori_loc_cd", ""));
		setLevelCd(JSPUtil.getParameter(request, prefix + "level_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setHeadWeek(JSPUtil.getParameter(request, prefix + "head_week", ""));
		setSimTpCd(JSPUtil.getParameter(request, prefix + "sim_tp_cd", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
		setOriOriLocCd(JSPUtil.getParameter(request, prefix + "ori_ori_loc_cd", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setFmdate(JSPUtil.getParameter(request, prefix + "fmdate", ""));
		setTodate(JSPUtil.getParameter(request, prefix + "todate", ""));
		setLocTypeCode(JSPUtil.getParameter(request, prefix + "loc_type_code", ""));
		setSubLocCd(JSPUtil.getParameter(request, prefix + "sub_loc_cd", ""));

		setLocTpCdSecond(JSPUtil.getParameter(request, prefix + "loc_tp_cd_second", ""));
		setLocCdSecond(JSPUtil.getParameter(request, prefix + "loc_cd_second", ""));
		setDivFlag(JSPUtil.getParameter(request, prefix + "div_flag", ""));	
		
		setPresentFlag(JSPUtil.getParameter(request, prefix + "present_flag", ""));	
		setConditionFlag(JSPUtil.getParameter(request, prefix + "condition_flag", ""));			
		setConditionValue(JSPUtil.getParameter(request, prefix + "condition_value", ""));		
		
		setFcastYrwk(JSPUtil.getParameter(request, prefix + "fcast_yrwk", ""));			
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyWeeklySimulationOptionVO[]
	 */
	public ForecastReportOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyWeeklySimulationOptionVO[]
	 */
	public ForecastReportOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ForecastReportOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrTpsz = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] oriLocCd = (JSPUtil.getParameter(request, prefix	+ "ori_loc_cd", length));
			String[] levelCd = (JSPUtil.getParameter(request, prefix	+ "level_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] headWeek = (JSPUtil.getParameter(request, prefix	+ "head_week", length));
			String[] simTpCd = (JSPUtil.getParameter(request, prefix	+ "sim_tp_cd", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] oriOriLocCd = (JSPUtil.getParameter(request, prefix	+ "ori_ori_loc_cd", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] fmdate = (JSPUtil.getParameter(request, prefix	+ "fmdate", length));
			String[] todate = (JSPUtil.getParameter(request, prefix	+ "todate", length));
			String[] locTypeCode = (JSPUtil.getParameter(request, prefix	+ "loc_type_code", length));
			String[] subLocCd = (JSPUtil.getParameter(request, prefix	+ "sub_loc_cd", length));
			
			String[] locTpCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_second", length));
			String[] locCdSecond = (JSPUtil.getParameter(request, prefix	+ "loc_cd_second", length));
			String[] divFlag = (JSPUtil.getParameter(request, prefix	+ "div_flag", length));

			String[] presentFlag = (JSPUtil.getParameter(request, prefix	+ "present_flag", length));
			String[] conditionFlag = (JSPUtil.getParameter(request, prefix	+ "condition_flag", length));
			String[] conditionValue = (JSPUtil.getParameter(request, prefix	+ "condition_value", length));
			
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new ForecastReportOptionVO();
				if (cntrTpsz[i] != null)
					model.setCntrTpsz(cntrTpsz[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (oriLocCd[i] != null)
					model.setOriLocCd(oriLocCd[i]);
				if (levelCd[i] != null)
					model.setLevelCd(levelCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (headWeek[i] != null)
					model.setHeadWeek(headWeek[i]);
				if (simTpCd[i] != null)
					model.setSimTpCd(simTpCd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (oriOriLocCd[i] != null)
					model.setOriOriLocCd(oriOriLocCd[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (fmdate[i] != null)
					model.setFmdate(fmdate[i]);
				if (todate[i] != null)
					model.setTodate(todate[i]);
				if (locTypeCode[i] != null)
					model.setLocTypeCode(locTypeCode[i]);
				if (subLocCd[i] != null)
					model.setSubLocCd(subLocCd[i]);
				if (locTpCdSecond[i] != null)
					model.setLocTpCdSecond(locTpCdSecond[i]);				
				if (locCdSecond[i] != null)
					model.setLocCdSecond(locCdSecond[i]);
				if (divFlag[i] != null)
					model.setDivFlag(divFlag[i]);	
				
				if (presentFlag[i] != null)
					model.setPresentFlag(presentFlag[i]);		
				if (conditionFlag[i] != null)
					model.setConditionFlag(conditionFlag[i]);			
				if (conditionValue[i] != null)
					model.setConditionValue(conditionValue[i]);					
				
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);		
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyWeeklySimulationOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyWeeklySimulationOptionVO[]
	 */
	public ForecastReportOptionVO[] getMtyWeeklySimulationOptionVOs(){
		ForecastReportOptionVO[] vos = (ForecastReportOptionVO[])models.toArray(new ForecastReportOptionVO[models.size()]);
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
		this.cntrTpsz = this.cntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriLocCd = this.oriLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.levelCd = this.levelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headWeek = this.headWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simTpCd = this.simTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriOriLocCd = this.oriOriLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmdate = this.fmdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todate = this.todate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode = this.locTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd = this.subLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdSecond = this.locTpCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdSecond = this.locCdSecond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divFlag = this.divFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.presentFlag = this.presentFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conditionFlag = this.conditionFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.conditionValue = this.conditionValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
