/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopPso0038Event.java
*@FileTitle : Port Charge Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2010.01.14 정명훈
* 1.0 Creation
* 
* History
* 2010.11.22 진마리아 CHM-201006692-01 Port charge simulation 이 터미널별로 한번에 계산이 될수 있도록 멀티 기능 추가
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Myounghun
 * @see VOP_PSO_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SimulationConditionVO simulationConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SimulationConditionVO[] simulationConditionVOs = null;

	/** menual ObjectVOs*/
	private SimulationObjectListVO[] menualObjectVOs = null;

	/** Automatic ObjectVos */
	private SimulationObjectListVO[] simulationObjectListVOs;

	private String portCd = "";
	private String issueDate = "";
	
	public SimulationObjectListVO[] getSimulationObjectListVOs() {
		SimulationObjectListVO[] tmpVOs = null;
		if (this.simulationObjectListVOs != null) {
			tmpVOs = new SimulationObjectListVO[simulationObjectListVOs.length];
			System.arraycopy(simulationObjectListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public SimulationObjectListVO[] getMenualObjectVOs() {
		SimulationObjectListVO[] tmpVOs = null;
		if (this.menualObjectVOs != null) {
			tmpVOs = new SimulationObjectListVO[menualObjectVOs.length];
			System.arraycopy(menualObjectVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public VopPso0038Event(){}

	/**
	 * @return the simulationConditionVO
	 */
	public SimulationConditionVO getSimulationConditionVO() {
		return simulationConditionVO;
	}

	/**
	 * @param simulationConditionVO the simulationConditionVO to set
	 */
	public void setSimulationConditionVO(SimulationConditionVO simulationConditionVO) {
		this.simulationConditionVO = simulationConditionVO;
	}

	/**
	 * @return the simulationConditionVOs
	 */
	public SimulationConditionVO[] getSimulationConditionVOs() {
		SimulationConditionVO[] tmpVOs = null;
		if (this.simulationConditionVOs != null) {
			tmpVOs = new SimulationConditionVO[simulationConditionVOs.length];
			System.arraycopy(simulationConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param simulationConditionVOs the simulationConditionVOs to set
	 */
	public void setSimulationConditionVOs(SimulationConditionVO[] simulationConditionVOs) {
		if (simulationConditionVOs != null) {
			SimulationConditionVO[] tmpVOs = new SimulationConditionVO[simulationConditionVOs.length];
			System.arraycopy(simulationConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.simulationConditionVOs = tmpVOs;
		}
	}

	public void setMenualObjectVOs(SimulationObjectListVO[] menualObjectVOs) {
		if (menualObjectVOs != null) {
			SimulationObjectListVO[] tmpVOs = new SimulationObjectListVO[menualObjectVOs.length];
			System.arraycopy(menualObjectVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.menualObjectVOs = tmpVOs;
		}		
	}

	public void setSimulationObjectListVOs(SimulationObjectListVO[] simulationObjectListVOs) {
		if (simulationObjectListVOs != null) {
			SimulationObjectListVO[] tmpVOs = new SimulationObjectListVO[simulationObjectListVOs.length];
			System.arraycopy(simulationObjectListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.simulationObjectListVOs = tmpVOs;
		}
	}

	public String getPortCd() {
		return portCd;
	}

	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


}