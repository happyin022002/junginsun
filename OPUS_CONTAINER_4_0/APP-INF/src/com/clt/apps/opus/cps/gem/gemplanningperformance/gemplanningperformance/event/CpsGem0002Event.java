/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem0002Event.java
 *@FileTitle : Processing Status
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
import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.SearchProcessingStatusVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * [CpsGem0002Event] Processing Status
 * @author choijungmi
 * @see CPS_GEM_0002HTMLAction
 * @since J2EE 1.4
 */

public class CpsGem0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String plnYrmon = "";
	private  String genExpnRqstNo = "";
	private  String ofcCd = "";
	private  String genExpnCd = "";

    private PlanningStatusCondVO planningStatusCondVO;
    
    private SearchProcessingStatusVO searchProcessingStatusVO;
    

	public SearchProcessingStatusVO getSearchProcessingStatusVO() {
		return searchProcessingStatusVO;
	}

	public void setSearchProcessingStatusVO(
			SearchProcessingStatusVO searchProcessingStatusVO) {
		this.searchProcessingStatusVO = searchProcessingStatusVO;
	}

	public PlanningStatusCondVO getPlanningStatusCondVO() {
		return planningStatusCondVO;
	}

	public void setPlanningStatusCondVO(PlanningStatusCondVO planningStatusCondVO) {
		this.planningStatusCondVO = planningStatusCondVO;
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