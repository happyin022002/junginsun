/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6026Event.java
*@FileTitle : CM/OP Summary & Simulation - Contract Approval Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryDownExcelVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentCmSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6026HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO = null;
	private InPrsAmendmentCmSummaryDownExcelVO inPrsAmendmentCmSummaryDownExcelVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPrsAmendmentCmSummaryVO rsltPrsAmendmentCmSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPrsAmendmentCmSummaryVO[] rsltPrsAmendmentCmSummaryVOs = null;

	public EsmPri6026Event(){}
	
	public void setInPrsAmendmentCmSummaryVO(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO){
		this. inPrsAmendmentCmSummaryVO = inPrsAmendmentCmSummaryVO;
	}
	public void setInPrsAmendmentCmSummaryDownExcelVO(InPrsAmendmentCmSummaryDownExcelVO inPrsAmendmentCmSummaryDownExcelVO){
		this. inPrsAmendmentCmSummaryDownExcelVO = inPrsAmendmentCmSummaryDownExcelVO;
	}
	
	
	public void setRsltPrsAmendmentCmSummaryVO(RsltPrsAmendmentCmSummaryVO rsltPrsAmendmentCmSummaryVO){
		this. rsltPrsAmendmentCmSummaryVO = rsltPrsAmendmentCmSummaryVO;
	}

	public void setRsltPrsAmendmentCmSummaryVOS(RsltPrsAmendmentCmSummaryVO[] rsltPrsAmendmentCmSummaryVOs){
		this. rsltPrsAmendmentCmSummaryVOs = rsltPrsAmendmentCmSummaryVOs;
	}
	public InPrsAmendmentCmSummaryVO getInPrsAmendmentCmSummaryVO(){
		return inPrsAmendmentCmSummaryVO;
	}
	
	public InPrsAmendmentCmSummaryDownExcelVO getInPrsAmendmentCmSummaryDownExcelVO(){
		return inPrsAmendmentCmSummaryDownExcelVO;
	}	
	
	public RsltPrsAmendmentCmSummaryVO getRsltPrsAmendmentCmSummaryVO(){
		return rsltPrsAmendmentCmSummaryVO;
	}

	public RsltPrsAmendmentCmSummaryVO[] getRsltPrsAmendmentCmSummaryVOS(){
		return rsltPrsAmendmentCmSummaryVOs;
	}

}