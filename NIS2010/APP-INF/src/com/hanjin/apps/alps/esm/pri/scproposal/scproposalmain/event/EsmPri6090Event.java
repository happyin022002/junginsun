/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri6090Event.java
*@FileTitle : SC Proposal MQC estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.10 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;


/**
 * ESM_PRI_6090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6090HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6090Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsMQCEstimateVO inPrsMQCEstimateVO = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMnVO priSpScpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpMnVO[] priSpScpMnVOs = null;

	public EsmPri6090Event(){}
	
	public void setInPrsMQCEstimateVO(InPrsMQCEstimateVO inPrsMQCEstimateVO){
		this. inPrsMQCEstimateVO = inPrsMQCEstimateVO;
	}
	
	
	public void setPriSpScpMnVO(PriSpScpMnVO priSpScpMnVO){
		this. priSpScpMnVO = priSpScpMnVO;
	}

	public void setPriSpScpMnVOS(PriSpScpMnVO[] priSpScpMnVOs){
		this. priSpScpMnVOs = priSpScpMnVOs;
	}

	public InPrsMQCEstimateVO getInPrsMQCEstimateVO(){
		return inPrsMQCEstimateVO;
	}
	
	public PriSpScpMnVO getPriSpScpMnVO(){
		return priSpScpMnVO;
	}

	public PriSpScpMnVO[] getPriSpScpMnVOS(){
		return priSpScpMnVOs;
	}

}