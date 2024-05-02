/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0110Event.java
*@FileTitle : Agent Commission Simulation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.event;

import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimulationNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0110 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0110HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0110HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0110Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SimulationNoVO simulationNoVO = null;

	public EsmAcm0110Event() {}

	public SimulationNoVO getSimulationNoVO() {
		return simulationNoVO;
	}

	public void setSimulationNoVO(SimulationNoVO simulationNoVO) {
		this.simulationNoVO = simulationNoVO;
	}

	

}