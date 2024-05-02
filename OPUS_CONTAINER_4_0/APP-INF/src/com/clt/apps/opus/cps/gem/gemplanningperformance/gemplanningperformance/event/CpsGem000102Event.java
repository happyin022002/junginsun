/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem000102Event.java
 *@FileTitle : Request - Transfer
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM_0001_02] Request - Transfer

 * @author choijungmi
 * @see CPS_GEM_0001_02HTMLAction
 * @since J2EE 1.5
 */
public class CpsGem000102Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String plnYrmon = "";
	private  String genExpnRqstNo = "";
	private  String ofcCd = "";
	private  String genExpnCd = "";

	//===============================
	// TO Office 가져오기
	//===============================
	private String toSlsOfcDivCd = "";
	private String toOfcLvl1 = "";
	private String toOfcLvl2 = "";
	private String fmOfcLvl2 = "";
	private String fmOfcLvl3 = "";
	
	


	public String getToSlsOfcDivCd() {
		return toSlsOfcDivCd;
	}

	public void setToSlsOfcDivCd(String toSlsOfcDivCd) {
		this.toSlsOfcDivCd = toSlsOfcDivCd;
	}

	public String getToOfcLvl1() {
		return toOfcLvl1;
	}

	public void setToOfcLvl1(String toOfcLvl1) {
		this.toOfcLvl1 = toOfcLvl1;
	}

	public String getToOfcLvl2() {
		return toOfcLvl2;
	}

	public void setToOfcLvl2(String toOfcLvl2) {
		this.toOfcLvl2 = toOfcLvl2;
	}

	public String getFmOfcLvl2() {
		return fmOfcLvl2;
	}

	public void setFmOfcLvl2(String fmOfcLvl2) {
		this.fmOfcLvl2 = fmOfcLvl2;
	}

	public String getFmOfcLvl3() {
		return fmOfcLvl3;
	}

	public void setFmOfcLvl3(String fmOfcLvl3) {
		this.fmOfcLvl3 = fmOfcLvl3;
	}

	private PlanningVO planningVO ;

	public PlanningVO getPlanningVO() {
		return planningVO;
	}

	public void setPlanningVO(PlanningVO planningVO) {
		this.planningVO = planningVO;
	}

	public String getPlnYrmon() {
		return plnYrmon;
	}

	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}

	public String getGenExpnRqstNo() {
		return genExpnRqstNo;
	}

	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getGenExpnCd() {
		return genExpnCd;
	}

	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}

}