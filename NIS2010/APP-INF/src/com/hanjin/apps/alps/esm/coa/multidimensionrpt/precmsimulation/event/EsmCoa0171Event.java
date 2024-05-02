/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0171Event.java
*@FileTitle : Temp T/S Route
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.29 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.precmsimulation.vo.PreCMSimulationCostVO;


/**
 * ESM_COA_0171 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0171HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_COA_0171HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0171Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PreCMSimulationCostVO preCMSimulationCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PreCMSimulationCostVO[] preCMSimulationCostVOs = null;

	public EsmCoa0171Event(){}
	
	public void setPreCMSimulationCostVO(PreCMSimulationCostVO preCMSimulationCostVO){
		this. preCMSimulationCostVO = preCMSimulationCostVO;
	}

	public void setPreCMSimulationCostVOS(PreCMSimulationCostVO[] preCMSimulationCostVOs){
		this. preCMSimulationCostVOs = preCMSimulationCostVOs;
	}

	public PreCMSimulationCostVO getPreCMSimulationCostVO(){
		return preCMSimulationCostVO;
	}

	public PreCMSimulationCostVO[] getPreCMSimulationCostVOS(){
		return preCMSimulationCostVOs;
	}

}