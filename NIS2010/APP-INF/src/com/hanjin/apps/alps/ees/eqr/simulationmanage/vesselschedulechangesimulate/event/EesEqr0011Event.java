/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0011HTMLAction.java
*@FileTitle : Vessel Schedule 변경 Simulation 조회/수정 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-08-04 정은호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.event;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.SearchVesselPlanCompareVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;


/**
 * EES_EQR_011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sangyool pak
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesEqr0011Event extends EventSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchVesselPlanCompareVO searchVesselPlanCompareVO = null; 
	public SearchVesselPlanCompareVO[] searchVesselPlanCompareVOS = null; 
	private EesEqr0011ConditionVO conditionVO = null;
	public EesEqr0011ConditionVO[] conditionVOS = null;
	private EqrScnrVslSkdVO eqrScnrVslSkdVO = null;
	public EqrScnrVslSkdVO[] eqrScnrVslSkdVOS = null;
	
	public EesEqr0011Event(){}

	public SearchVesselPlanCompareVO getSearchVesselPlanCompareVO() {
		return searchVesselPlanCompareVO;
	}

	public void setSearchVesselPlanCompareVO(
			SearchVesselPlanCompareVO searchVesselPlanCompareVO) {
		this.searchVesselPlanCompareVO = searchVesselPlanCompareVO;
	}

	public SearchVesselPlanCompareVO[] getSearchVesselPlanCompareVOS() {
		return searchVesselPlanCompareVOS;
	}

	public void setSearchVesselPlanCompareVOS(
			SearchVesselPlanCompareVO[] searchVesselPlanCompareVOS) {
		this.searchVesselPlanCompareVOS = searchVesselPlanCompareVOS;
	}

	public EesEqr0011ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(EesEqr0011ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	public EesEqr0011ConditionVO[] getConditionVOS() {
		return conditionVOS;
	}

	public void setConditionVOS(EesEqr0011ConditionVO[] conditionVOS) {
		this.conditionVOS = conditionVOS;
	}

	public EqrScnrVslSkdVO getEqrScnrVslSkdVO() {
		return eqrScnrVslSkdVO;
	}

	public void setEqrScnrVslSkdVO(EqrScnrVslSkdVO eqrScnrVslSkdVO) {
		this.eqrScnrVslSkdVO = eqrScnrVslSkdVO;
	}

	public EqrScnrVslSkdVO[] getEqrScnrVslSkdVOS() {
		return eqrScnrVslSkdVOS;
	}

	public void setEqrScnrVslSkdVOS(EqrScnrVslSkdVO[] eqrScnrVslSkdVOS) {
		this.eqrScnrVslSkdVOS = eqrScnrVslSkdVOS;
	}
	
	

}
