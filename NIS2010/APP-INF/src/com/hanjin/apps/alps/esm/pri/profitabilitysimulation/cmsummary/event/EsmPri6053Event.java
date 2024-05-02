/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6053Event.java
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

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentSummaryRevenueDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6053HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6053Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPrsAmendmentSummaryRevenueDetailVO rsltPrsAmendmentSummaryRevenueDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPrsAmendmentSummaryRevenueDetailVO[] rsltPrsAmendmentSummaryRevenueDetailVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO = null;
	
	 
	
	
	public EsmPri6053Event(){}
	
	public void setRsltPrsAmendmentSummaryRevenueDetailVO(RsltPrsAmendmentSummaryRevenueDetailVO rsltPrsAmendmentSummaryRevenueDetailVO){
		this. rsltPrsAmendmentSummaryRevenueDetailVO = rsltPrsAmendmentSummaryRevenueDetailVO;
	}

	public void setRsltPrsAmendmentSummaryRevenueDetailVOS(RsltPrsAmendmentSummaryRevenueDetailVO[] rsltPrsAmendmentSummaryRevenueDetailVOs){
		this. rsltPrsAmendmentSummaryRevenueDetailVOs = rsltPrsAmendmentSummaryRevenueDetailVOs;
	}

	public RsltPrsAmendmentSummaryRevenueDetailVO getRsltPrsAmendmentSummaryRevenueDetailVO(){
		return rsltPrsAmendmentSummaryRevenueDetailVO;
	}

	public RsltPrsAmendmentSummaryRevenueDetailVO[] getRsltPrsAmendmentSummaryRevenueDetailVOS(){
		return rsltPrsAmendmentSummaryRevenueDetailVOs;
	}
	
	public InPrsAmendmentCmSummaryVO getInPrsAmendmentCmSummaryVO(){
		return inPrsAmendmentCmSummaryVO;
	}
	
	public void setInPrsAmendmentCmSummaryVO(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO){
		this. inPrsAmendmentCmSummaryVO = inPrsAmendmentCmSummaryVO;
	}

}