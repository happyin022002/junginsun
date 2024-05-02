/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem000103Event.java
 *@FileTitle : Expense Request adjustment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusVO;
import com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *[CPS_GEM_0101] Expense Request adjustment

 * @author choijungmi
 * @see CPS_GEM_0001_03HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem000103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String plnYrmon = "";
	private  String genExpnRqstNo = "";
	private  String ofcCd = "";
	private  String genExpnCd = "";
	private String genExpnRqstSeq = "";
	
    public String getGenExpnRqstSeq() {
		return genExpnRqstSeq;
	}

	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}

	private PlanningVO planningVO ;

    private PlanningStatusCondVO planningStatusCondVO;
    
    private PlanningStatusVO planningStatusVO;
    
	public PlanningStatusVO getPlanningStatusVO() {
		return planningStatusVO;
	}

	public void setPlanningStatusVO(PlanningStatusVO planningStatusVO) {
		this.planningStatusVO = planningStatusVO;
	}

	public PlanningStatusCondVO getPlanningStatusCondVO() {
		return planningStatusCondVO;
	}

	public void setPlanningStatusCondVO(PlanningStatusCondVO planningStatusCondVO) {
		this.planningStatusCondVO = planningStatusCondVO;
	}

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