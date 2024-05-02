/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim5010Event.java
*@FileTitle : MTY Weekly Simulation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.05.18 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.event;

import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_5010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_5010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author la sangbo
 * @see EES_CIM_5010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr5010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyWeeklySimulationOptionVO[] mtyWeeklySimulationOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyWeeklySimulationVO mtyWeeklySimulationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MtyWeeklySimulationVO[] mtyWeeklySimulationVOs = null;

	public EesEqr5010Event(){}
	
	public void setMtyWeeklySimulationOptionVO(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO){
		this. mtyWeeklySimulationOptionVO = mtyWeeklySimulationOptionVO;
	}

	public void setMtyWeeklySimulationOptionVOS(MtyWeeklySimulationOptionVO[] mtyWeeklySimulationOptionVOs){
		this. mtyWeeklySimulationOptionVOs = mtyWeeklySimulationOptionVOs;
	}
	public MtyWeeklySimulationOptionVO getMtyWeeklySimulationOptionVO(){
		return mtyWeeklySimulationOptionVO;
	}

	public MtyWeeklySimulationOptionVO[] getMtyWeeklySimulationOptionVOS(){
		return mtyWeeklySimulationOptionVOs;
	}
	
	
	public void setMtyWeeklySimulationVO(MtyWeeklySimulationVO mtyWeeklySimulationVO){
		this. mtyWeeklySimulationVO = mtyWeeklySimulationVO;
	}

	public void setMtyWeeklySimulationVOS(MtyWeeklySimulationVO[] mtyWeeklySimulationVOs){
		this. mtyWeeklySimulationVOs = mtyWeeklySimulationVOs;
	}
	public MtyWeeklySimulationVO getMtyWeeklySimulationVO(){
		return mtyWeeklySimulationVO;
	}

	public MtyWeeklySimulationVO[] getMtyWeeklySimulationVOS(){
		return mtyWeeklySimulationVOs;
	}	
}