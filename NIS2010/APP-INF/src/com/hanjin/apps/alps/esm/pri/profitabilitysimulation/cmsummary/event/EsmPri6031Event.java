/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6031Event.java
*@FileTitle : CM,OP Summary And Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.10 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentSummarySimulationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6031HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6031Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsAmendmentSummarySimulationVO inPrsAmendmentSummarySimulationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InPrsAmendmentSummarySimulationVO[] inPrsAmendmentSummarySimulationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO = null;
	
	
	
	
	public EsmPri6031Event(){}
	 
	public void setInPrsAmendmentSummarySimulationVO(InPrsAmendmentSummarySimulationVO inPrsAmendmentSummarySimulationVO){
		this. inPrsAmendmentSummarySimulationVO = inPrsAmendmentSummarySimulationVO;
	}

	public void setInPrsAmendmentSummarySimulationVOS(InPrsAmendmentSummarySimulationVO[] inPrsAmendmentSummarySimulationVOs){
		this. inPrsAmendmentSummarySimulationVOs = inPrsAmendmentSummarySimulationVOs;
	}

	public InPrsAmendmentSummarySimulationVO getInPrsAmendmentSummarySimulationVO(){
		return inPrsAmendmentSummarySimulationVO;
	}

	public InPrsAmendmentSummarySimulationVO[] getInPrsAmendmentSummarySimulationVOS(){
		return inPrsAmendmentSummarySimulationVOs;
	}

	public void setInPrsAmendmentSummarySimulationSetVO(InPrsAmendmentSummarySimulationSetVO inPrsAmendmentSummarySimulationSetVO){
		this. inPrsAmendmentSummarySimulationSetVO = inPrsAmendmentSummarySimulationSetVO;
	}
	public InPrsAmendmentSummarySimulationSetVO getInPrsAmendmentSummarySimulationSetVO(){
		return inPrsAmendmentSummarySimulationSetVO;
	}
	
	
	public void setInPrsAmendmentCmSummaryVO(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO){
		this. inPrsAmendmentCmSummaryVO = inPrsAmendmentCmSummaryVO;
	}
	public InPrsAmendmentCmSummaryVO getInPrsAmendmentCmSummaryVO(){
		return inPrsAmendmentCmSummaryVO;
	}
	
	
}