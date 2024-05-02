/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6024Event.java
*@FileTitle : CM/OP Summary & Simulation - Contract Proposal Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalCmSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPrsProposalCmSummaryVO rsltPrsProposalCmSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPrsProposalCmSummaryVO[] rsltPrsProposalCmSummaryVOs = null;

	public EsmPri6024Event(){}
	
	public void setInPrsProposalCmSummaryVO(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO){
		this. inPrsProposalCmSummaryVO = inPrsProposalCmSummaryVO;
	}
	
	public void setRsltPrsProposalCmSummaryVO(RsltPrsProposalCmSummaryVO rsltPrsProposalCmSummaryVO){
		this. rsltPrsProposalCmSummaryVO = rsltPrsProposalCmSummaryVO;
	}

	public void setRsltPrsProposalCmSummaryVOS(RsltPrsProposalCmSummaryVO[] rsltPrsProposalCmSummaryVOs){
		this. rsltPrsProposalCmSummaryVOs = rsltPrsProposalCmSummaryVOs;
	}
	public InPrsProposalCmSummaryVO getInPrsProposalCmSummaryVO(){
		return inPrsProposalCmSummaryVO;
	}
	
	public RsltPrsProposalCmSummaryVO getRsltPrsProposalCmSummaryVO(){
		return rsltPrsProposalCmSummaryVO;
	}

	public RsltPrsProposalCmSummaryVO[] getRsltPrsProposalCmSummaryVOS(){
		return rsltPrsProposalCmSummaryVOs;
	}

}