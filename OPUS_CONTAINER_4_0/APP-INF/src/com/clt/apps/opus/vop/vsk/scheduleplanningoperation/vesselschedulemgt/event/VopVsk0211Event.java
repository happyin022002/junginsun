/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0211Event.java
*@FileTitle : VSL Voyage Check Pop-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.31
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.01 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0211 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0211HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0211HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0211Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SimulationVvdCheckVO simulationVvdCheckVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SimulationVvdCheckVO[] simulationVvdCheckVOs = null;

	public VopVsk0211Event(){}
	
	public void setSimulationVvdCheckVO(SimulationVvdCheckVO simulationVvdCheckVO){
		this.simulationVvdCheckVO = simulationVvdCheckVO;
	}

	public void setSimulationVvdCheckVOS(SimulationVvdCheckVO[] simulationVvdCheckVOs){
		if (simulationVvdCheckVOs != null) {
			SimulationVvdCheckVO[] tmpVOs = Arrays.copyOf(simulationVvdCheckVOs, simulationVvdCheckVOs.length);
			this.simulationVvdCheckVOs = tmpVOs;
		} // end if
	}

	public SimulationVvdCheckVO getSimulationVvdCheckVO(){
		return simulationVvdCheckVO;
	}

	public SimulationVvdCheckVO[] getSimulationVvdCheckVOS(){
		SimulationVvdCheckVO[] rtnVOs = null;
		if (this.simulationVvdCheckVOs != null) {
			rtnVOs = Arrays.copyOf(this.simulationVvdCheckVOs, this.simulationVvdCheckVOs.length);
		} // end if
		return rtnVOs;
	}

}