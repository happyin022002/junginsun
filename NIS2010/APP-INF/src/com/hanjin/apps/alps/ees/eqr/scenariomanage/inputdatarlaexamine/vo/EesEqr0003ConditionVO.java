/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDqr0001ConditionVO.java
*@FileTitle : EesDqr0001ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 운영2팀 정은호
*@LastVersion : 1.0
* 2009.07.22 운영2팀 정은호 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.framework.component.util.JSPUtil;

public class EesEqr0003ConditionVO{
	
	private String yyyyww		= "";
	private String seq			= "";
	
	private String scnrPlanId 	= "";
	
	private String fmtoat 		= "";
	private String fromStatus 	= "";
	private String toStatus 	= "";
	private String atStatus 	= "";
	private String fromLocation = "";
	private String toLocation 	= "";
	private String atLocation 	= "";

	private String fmSFcastYr 	= "";
	private String fmSFcastWk 	= "";
	private String fmEFcastYr 	= "";
	private String fmEFcastWk 	= "";

	private String atSFcastYr 	= "";
	private String atSFcastWk 	= "";
	private String atEFcastYr 	= "";
	private String atEFcastWk 	= "";

	private String fmTypeBy     = "";
	private String toTypeBy     = "";
	private String atTypeBy     = "";
	
	private String tpsz 		= "";
	private String tpsztype 	= "";

	private String datatype = "";
	

	private List<String[]> volTpszArr = null;
	private List<String[]> volFlagTpszArr = null;
	private List<String[]> amtTpszArr = null;
	private List<String[]> amtFlagTpszArr = null;
	
	

	public String getYyyyww() {
		return yyyyww;
	}

	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getScnrPlanId() {
		this.scnrPlanId = Constants.SCNR_WORD + yyyyww + Constants.SCNR_WEEK + seq; // REPO PLAN ID;
		return this.scnrPlanId;
	}

	public void setScnrPlanId(String scnrPlanId) {
		this.scnrPlanId = scnrPlanId;
	}

	public String getFmtoat() {
		return fmtoat;
	}

	public void setFmtoat(String fmtoat) {
		this.fmtoat = fmtoat;
	}

	public String getFromStatus() {
		return fromStatus;
	}

	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	public String getToStatus() {
		return toStatus;
	}

	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	public String getAtStatus() {
		return atStatus;
	}

	public void setAtStatus(String atStatus) {
		this.atStatus = atStatus;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getAtLocation() {
		return atLocation;
	}

	public void setAtLocation(String atLocation) {
		this.atLocation = atLocation;
	}

	public String getFmSFcastYr() {
		return fmSFcastYr;
	}

	public void setFmSFcastYr(String fmSFcastYr) {
		this.fmSFcastYr = fmSFcastYr;
	}

	public String getFmSFcastWk() {
		return fmSFcastWk;
	}

	public void setFmSFcastWk(String fmSFcastWk) {
		this.fmSFcastWk = fmSFcastWk;
	}

	public String getFmEFcastYr() {
		return fmEFcastYr;
	}

	public void setFmEFcastYr(String fmEFcastYr) {
		this.fmEFcastYr = fmEFcastYr;
	}

	public String getFmEFcastWk() {
		return fmEFcastWk;
	}

	public void setFmEFcastWk(String fmEFcastWk) {
		this.fmEFcastWk = fmEFcastWk;
	}

	public String getAtSFcastYr() {
		return atSFcastYr;
	}

	public void setAtSFcastYr(String atSFcastYr) {
		this.atSFcastYr = atSFcastYr;
	}

	public String getAtSFcastWk() {
		return atSFcastWk;
	}

	public void setAtSFcastWk(String atSFcastWk) {
		this.atSFcastWk = atSFcastWk;
	}

	public String getAtEFcastYr() {
		return atEFcastYr;
	}

	public void setAtEFcastYr(String atEFcastYr) {
		this.atEFcastYr = atEFcastYr;
	}

	public String getAtEFcastWk() {
		return atEFcastWk;
	}

	public void setAtEFcastWk(String atEFcastWk) {
		this.atEFcastWk = atEFcastWk;
	}

	public String getFmTypeBy() {
		return fmTypeBy;
	}

	public void setFmTypeBy(String fmTypeBy) {
		this.fmTypeBy = fmTypeBy;
	}

	public String getToTypeBy() {
		return toTypeBy;
	}

	public void setToTypeBy(String toTypeBy) {
		this.toTypeBy = toTypeBy;
	}

	public String getAtTypeBy() {
		return atTypeBy;
	}

	public void setAtTypeBy(String atTypeBy) {
		this.atTypeBy = atTypeBy;
	}

	public String getTpsz() {
		return tpsz;
	}

	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}

	public String getTpsztype() {
		return tpsztype;
	}

	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	

	public List<String[]> getVolTpszArr() {
		return volTpszArr;
	}

	public void setVolTpszArr(List<String[]> volTpszArr) {
		this.volTpszArr = volTpszArr;
	}

	public List<String[]> getVolFlagTpszArr() {
		return volFlagTpszArr;
	}

	public void setVolFlagTpszArr(List<String[]> volFlagTpszArr) {
		this.volFlagTpszArr = volFlagTpszArr;
	}

	public List<String[]> getAmtTpszArr() {
		return amtTpszArr;
	}

	public void setAmtTpszArr(List<String[]> amtTpszArr) {
		this.amtTpszArr = amtTpszArr;
	}

	public List<String[]> getAmtFlagTpszArr() {
		return amtFlagTpszArr;
	}

	public void setAmtFlagTpszArr(List<String[]> amtFlagTpszArr) {
		this.amtFlagTpszArr = amtFlagTpszArr;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		// SCNR PLAN ID
    	// 화면에서 입력한 YYYY, SEQ 정보 --> 조회시 SCNR ID로 사용됨
		setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
    	setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));	

    	// FROM, TO, AT LOCATION
    	setFmtoat(JSPUtil.getParameter(request, "fmToAt".trim(), ""));    // FROM TO, AT : 1,2
    	setFromStatus(JSPUtil.getParameter(request, "fmType".trim(), ""));   	// fmType
    	setToStatus(JSPUtil.getParameter(request, "toType".trim(), ""));    // toType
    	setAtStatus(JSPUtil.getParameter(request, "atType".trim(), ""));    // atType
    	setFromLocation(JSPUtil.getParameter(request, "fmEccCd".trim(), "")); 	// fmEccCd
    	setToLocation(JSPUtil.getParameter(request, "toEccCd".trim(), ""));   // toEccCd
    	setAtLocation(JSPUtil.getParameter(request, "atEccCd".trim(), ""));   // atEccCd

    	// PERIOD - FROM,TO WEEK
    	setFmSFcastYr(JSPUtil.getParameter(request, "fmSFcastYr".trim(), ""));  // fmPlnYr
    	setFmSFcastWk(JSPUtil.getParameter(request, "fmSFcastWk".trim(), ""));  // fmSFcastWk
    	setFmEFcastYr( JSPUtil.getParameter(request, "fmEFcastYr".trim(), ""));  // fmEFcastYr
    	setFmEFcastWk(JSPUtil.getParameter(request, "fmEFcastWk".trim(), ""));  // fmEFcastWk

    	// PERIOD - AT WEEK
    	setAtSFcastYr(JSPUtil.getParameter(request, "atSFcastYr".trim(), ""));  // atSFcastYr
    	setAtSFcastWk(JSPUtil.getParameter(request, "atSFcastWk".trim(), ""));  // atSFcastWk
    	setAtEFcastYr(JSPUtil.getParameter(request, "atEFcastYr".trim(), ""));  // atEFcastYr
    	setAtEFcastWk(JSPUtil.getParameter(request, "atEFcastWk".trim(), ""));  // atEFcastWk

    	// TYPE
    	setFmTypeBy(JSPUtil.getParameter(request, "fmTypeBy".trim(), ""));  // fmTypeBy
    	setToTypeBy(JSPUtil.getParameter(request, "toTypeBy".trim(), ""));  // toTypeBy
    	setAtTypeBy(JSPUtil.getParameter(request, "atTypeBy".trim(), ""));  // atTypeBy
    	
    	// TYPE SIZE
    	setTpsz(JSPUtil.getParameter(request, "tpsz".trim(), ""));  	// tpsztype
    	setTpsztype(JSPUtil.getParameter(request, "tpsztype".trim(), "")); // tpsz value
    
    	
    	// DATA TYPE
    	setDatatype(JSPUtil.getParameter(request, "datatype".trim(), ""));  	// datatype
	}
}