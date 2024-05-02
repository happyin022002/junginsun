/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6032Event.java
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

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationSetVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalSummarySimulationVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalSummarySimulationListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPrsProposalSummarySimulationListVO rsltPrsProposalSummarySimulationListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPrsProposalSummarySimulationListVO[] rsltPrsProposalSummarySimulationListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsProposalSummarySimulationVO inPrsProposalSummarySimulationVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InPrsProposalSummarySimulationVO[] inPrsProposalSummarySimulationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsProposalSummarySimulationSetVO inPrsProposalSummarySimulationSetVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO = null;
	
	
	
	
	public EsmPri6032Event(){}
	
	public void setRsltPrsProposalSummarySimulationListVO(RsltPrsProposalSummarySimulationListVO rsltPrsProposalSummarySimulationListVO){
		this. rsltPrsProposalSummarySimulationListVO = rsltPrsProposalSummarySimulationListVO;
	}

	public void setRsltPrsProposalSummarySimulationListVOS(RsltPrsProposalSummarySimulationListVO[] rsltPrsProposalSummarySimulationListVOs){
		this. rsltPrsProposalSummarySimulationListVOs = rsltPrsProposalSummarySimulationListVOs;
	}

	public RsltPrsProposalSummarySimulationListVO getRsltPrsProposalSummarySimulationListVO(){
		return rsltPrsProposalSummarySimulationListVO;
	}

	public RsltPrsProposalSummarySimulationListVO[] getRsltPrsProposalSummarySimulationListVOS(){
		return rsltPrsProposalSummarySimulationListVOs;
	}
	
	
	public void setInPrsProposalSummarySimulationVO(InPrsProposalSummarySimulationVO inPrsProposalSummarySimulationVO){
		this. inPrsProposalSummarySimulationVO = inPrsProposalSummarySimulationVO;
	}

	public void setInPrsProposalSummarySimulationVOS(InPrsProposalSummarySimulationVO[] inPrsProposalSummarySimulationVOs){
		this. inPrsProposalSummarySimulationVOs = inPrsProposalSummarySimulationVOs;
	}

	public InPrsProposalSummarySimulationVO getInPrsProposalSummarySimulationVO(){
		return inPrsProposalSummarySimulationVO;
	}

	public InPrsProposalSummarySimulationVO[] getInPrsProposalSummarySimulationVOS(){
		return inPrsProposalSummarySimulationVOs;
	}

	public void setInPrsProposalSummarySimulationSetVO(InPrsProposalSummarySimulationSetVO inPrsProposalSummarySimulationSetVO){
		this. inPrsProposalSummarySimulationSetVO = inPrsProposalSummarySimulationSetVO;
	}
	public InPrsProposalSummarySimulationSetVO getInPrsProposalSummarySimulationSetVO(){
		return inPrsProposalSummarySimulationSetVO;
	}
	
	
	public void setInPrsProposalCmSummaryVO(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO){
		this. inPrsProposalCmSummaryVO = inPrsProposalCmSummaryVO;
	}
	public InPrsProposalCmSummaryVO getInPrsProposalCmSummaryVO(){
		return inPrsProposalCmSummaryVO;
	}
	
	
}