/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3599Event.java
*@FileTitle : Tariff Rule Publish
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.19
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.19 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.event;

import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.InPriTrfRuleDiffVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_3599 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3599HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_PRI_3599HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3599Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InPriTrfRuleDiffVO inPriTrfRuleDiffVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InPriTrfRuleDiffVO[] inPriTrfRuleDiffVOs = null;

	public EsmPri3599Event(){}
	
	public void setInPriTrfRuleDiffVO(InPriTrfRuleDiffVO inPriTrfRuleDiffVO){
		this. inPriTrfRuleDiffVO = inPriTrfRuleDiffVO;
	}

	public void setInPriTrfRuleDiffVOs(InPriTrfRuleDiffVO[] inPriTrfRuleDiffVOs){
		if (inPriTrfRuleDiffVOs != null) {
			InPriTrfRuleDiffVO[] tmpVOs = new InPriTrfRuleDiffVO[inPriTrfRuleDiffVOs.length];
			System.arraycopy(inPriTrfRuleDiffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.inPriTrfRuleDiffVOs = tmpVOs;
		}
	}

	public InPriTrfRuleDiffVO getInPriTrfRuleDiffVO(){
		return inPriTrfRuleDiffVO;
	}

	public InPriTrfRuleDiffVO[] getInPriTrfRuleDiffVOs(){
		InPriTrfRuleDiffVO[] tmpVOs = null;
		if (this.inPriTrfRuleDiffVOs != null) {
			tmpVOs = new InPriTrfRuleDiffVO[inPriTrfRuleDiffVOs.length];
			System.arraycopy(inPriTrfRuleDiffVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}