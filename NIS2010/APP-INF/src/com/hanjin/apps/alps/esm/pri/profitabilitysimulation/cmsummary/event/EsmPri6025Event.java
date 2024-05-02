/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6025Event.java
*@FileTitle : CM/OP Summary And Simulation - Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.22 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsProposalSummaryRevenueDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPrsProposalSummaryRevenueDetailVO rsltPrsProposalSummaryRevenueDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPrsProposalSummaryRevenueDetailVO[] rsltPrsProposalSummaryRevenueDetailVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO = null;
	
	 
	
	
	public EsmPri6025Event(){}
	
	public void setRsltPrsProposalSummaryRevenueDetailVO(RsltPrsProposalSummaryRevenueDetailVO rsltPrsProposalSummaryRevenueDetailVO){
		this. rsltPrsProposalSummaryRevenueDetailVO = rsltPrsProposalSummaryRevenueDetailVO;
	}

	public void setRsltPrsProposalSummaryRevenueDetailVOS(RsltPrsProposalSummaryRevenueDetailVO[] rsltPrsProposalSummaryRevenueDetailVOs){
		this. rsltPrsProposalSummaryRevenueDetailVOs = rsltPrsProposalSummaryRevenueDetailVOs;
	}

	public RsltPrsProposalSummaryRevenueDetailVO getRsltPrsProposalSummaryRevenueDetailVO(){
		return rsltPrsProposalSummaryRevenueDetailVO;
	}

	public RsltPrsProposalSummaryRevenueDetailVO[] getRsltPrsProposalSummaryRevenueDetailVOS(){
		return rsltPrsProposalSummaryRevenueDetailVOs;
	}
	
	public InPrsProposalCmSummaryVO getInPrsProposalCmSummaryVO(){
		return inPrsProposalCmSummaryVO;
	}
	
	public void setInPrsProposalCmSummaryVO(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO){
		this. inPrsProposalCmSummaryVO = inPrsProposalCmSummaryVO;
	}

}