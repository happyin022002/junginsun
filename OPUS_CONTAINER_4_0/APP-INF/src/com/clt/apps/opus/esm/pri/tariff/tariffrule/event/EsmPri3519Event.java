/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3519Event.java
*@FileTitle : Tariff Rule Amend Request
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.12 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTrfRuleVO;


/**
 * ESM_PRI_3519 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3519HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_PRI_3519HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3519Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfRuleVO priTrfRuleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfRuleVO[] priTrfRuleVOs = null;

	public EsmPri3519Event(){}
	
	public void setPriTrfRuleVO(PriTrfRuleVO priTrfRuleVO){
		this. priTrfRuleVO = priTrfRuleVO;
	}

	public void setPriTrfRuleVOS(PriTrfRuleVO[] priTrfRuleVOs){
		if (priTrfRuleVOs != null) {
			PriTrfRuleVO[] tmpVOs = new PriTrfRuleVO[priTrfRuleVOs.length];
			System.arraycopy(priTrfRuleVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTrfRuleVOs = tmpVOs;
		}
	}

	public PriTrfRuleVO getPriTrfRuleVO(){
		return priTrfRuleVO;
	}

	public PriTrfRuleVO[] getPriTrfRuleVOS(){
		PriTrfRuleVO[] tmpVOs = null;
		if (this.priTrfRuleVOs != null) {
			tmpVOs = new PriTrfRuleVO[priTrfRuleVOs.length];
			System.arraycopy(priTrfRuleVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}