/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0003Event.java
 *@FileTitle : Approval of Requested expense
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusCondVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningStatusVO;
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *[UI_GEM-0003] Approval of Requested expense

 * @author choijungmi
 * @see CPS_GEM_0003HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String plnYrmon = "";
	private  String genExpnRqstNo = "";
	private  String ofcCd = "";
	private  String genExpnCd = "";
	private String authFlg = "";
	
	public String getAuthFlg() {
		return authFlg;
	}

	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}

	private PlanningVO[]  planningVOs ;
	
    public PlanningVO[] getPlanningVOs() {
		return planningVOs;
	}

	public void setPlanningVOs(PlanningVO[] planningVOs) {
		this.planningVOs = planningVOs;
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