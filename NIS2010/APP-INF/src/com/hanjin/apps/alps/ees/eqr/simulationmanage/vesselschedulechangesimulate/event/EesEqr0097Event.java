/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0097Event.java
*@FileTitle : Vessel Schedule Change Simulation Analysis
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.08 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.EesEqr0011ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo.SearchVesselPlanCompareVO;


/**
 * EES_EQR_0097 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0097HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0097HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0097Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchVesselPlanCompareVO searchVesselPlanCompareVO = null; 
	public SearchVesselPlanCompareVO[] searchVesselPlanCompareVOS = null; 
	
	/**011 화면의 조건절 사용*/
	private EesEqr0011ConditionVO  eesEqr0011ConditionVO = null;
	
	public EesEqr0097Event(){}

	/**
	 * @return the searchVesselPlanCompareVO
	 */
	public SearchVesselPlanCompareVO getSearchVesselPlanCompareVO() {
		return searchVesselPlanCompareVO;
	}

	/**
	 * @param searchVesselPlanCompareVO the searchVesselPlanCompareVO to set
	 */
	public void setSearchVesselPlanCompareVO(
			SearchVesselPlanCompareVO searchVesselPlanCompareVO) {
		this.searchVesselPlanCompareVO = searchVesselPlanCompareVO;
	}

	/**
	 * @return the searchVesselPlanCompareVOS
	 */
	public SearchVesselPlanCompareVO[] getSearchVesselPlanCompareVOS() {
		return searchVesselPlanCompareVOS;
	}

	/**
	 * @param searchVesselPlanCompareVOS the searchVesselPlanCompareVOS to set
	 */
	public void setSearchVesselPlanCompareVOS(
			SearchVesselPlanCompareVO[] searchVesselPlanCompareVOS) {
		this.searchVesselPlanCompareVOS = searchVesselPlanCompareVOS;
	}

	/**
	 * @return the eesEqr0011ConditionVO
	 */
	public EesEqr0011ConditionVO getEesEqr0011ConditionVO() {
		return eesEqr0011ConditionVO;
	}

	/**
	 * @param eesEqr0011ConditionVO the eesEqr0011ConditionVO to set
	 */
	public void setEesEqr0011ConditionVO(EesEqr0011ConditionVO eesEqr0011ConditionVO) {
		this.eesEqr0011ConditionVO = eesEqr0011ConditionVO;
	}
	
	

}