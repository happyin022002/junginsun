/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0112Event.java
*@FileTitle : VSL Voyage Check Pop-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.14 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0211 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0211HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see VOP_VSK_0112HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SimulationVvdCheckVO simulationVvdCheckVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SimulationVvdCheckVO[] simulationVvdCheckVOs = null;

	public VopVsk0112Event(){}
	
	public void setSimulationVvdCheckVO(SimulationVvdCheckVO simulationVvdCheckVO){
		this.simulationVvdCheckVO = simulationVvdCheckVO;
	}

	public void setSimulationVvdCheckVOS(SimulationVvdCheckVO[] simulationVvdCheckVOs){
		if(simulationVvdCheckVOs != null){
			SimulationVvdCheckVO[] tmpVOs = new SimulationVvdCheckVO[simulationVvdCheckVOs.length];
			System.arraycopy(simulationVvdCheckVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.simulationVvdCheckVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.simulationVvdCheckVOs = simulationVvdCheckVOs;
	}

	public SimulationVvdCheckVO getSimulationVvdCheckVO(){
		return simulationVvdCheckVO;
	}

	public SimulationVvdCheckVO[] getSimulationVvdCheckVOS(){
		SimulationVvdCheckVO[] rtnVOs =  null;
		if(this.simulationVvdCheckVOs != null){
			rtnVOs = new SimulationVvdCheckVO[simulationVvdCheckVOs.length];
			System.arraycopy(simulationVvdCheckVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return simulationVvdCheckVOs;
	}

}