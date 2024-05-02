/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri6091Event.java
*@FileTitle : SC Proposal MQC estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.10 송민석
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.InPrsMQCEstimateVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;


/**
 * ESM_PRI_6091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6091HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPrsMQCEstimateVO inPrsMQCEstimateVO = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpMnVO priRpScpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpMnVO[] priRpScpMnVOs = null;

	public EsmPri6091Event(){}
	
	public void setInPrsMQCEstimateVO(InPrsMQCEstimateVO inPrsMQCEstimateVO){
		this. inPrsMQCEstimateVO = inPrsMQCEstimateVO;
	}
	
	
	public void setPriRpScpMnVO(PriRpScpMnVO priRpScpMnVO){
		this. priRpScpMnVO = priRpScpMnVO;
	}

	public void setPriRpScpMnVOS(PriRpScpMnVO[] priRpScpMnVOs){
		if(priRpScpMnVOs != null){
			PriRpScpMnVO[] tmpVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpMnVOs = tmpVOs;
		}
	}

	public InPrsMQCEstimateVO getInPrsMQCEstimateVO(){
		return inPrsMQCEstimateVO;
	}
	
	public PriRpScpMnVO getPriRpScpMnVO(){
		return priRpScpMnVO;
	}

	public PriRpScpMnVO[] getPriRpScpMnVOS(){
		PriRpScpMnVO[] rtnVOs = null;
		if (this.priRpScpMnVOs != null) {
			rtnVOs = new PriRpScpMnVO[priRpScpMnVOs.length];
			System.arraycopy(priRpScpMnVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}