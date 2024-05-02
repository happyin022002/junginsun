/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmPri3555Event.java
*@FileTitle : Tariff Rule Publish Revise
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.03
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.05.03 이행지
* 1.0 Creation
=========================================================
* History
* 2011.05.16 이행지 [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfRuleVO;


/**
 * ESM_PRI_3523 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3523HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_PRI_3523HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3523Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfRuleVO priTrfRuleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfRuleVO[] priTrfRuleVOs = null;

	public EsmPri3523Event(){}

	public PriTrfRuleVO getPriTrfRuleVO() {
		return priTrfRuleVO;
	}

	public void setPriTrfRuleVO(PriTrfRuleVO priTrfRuleVO) {
		this.priTrfRuleVO = priTrfRuleVO;
	}

	public PriTrfRuleVO[] getPriTrfRuleVOs() {
		return priTrfRuleVOs;
	}

	public void setPriTrfRuleVOs(PriTrfRuleVO[] priTrfRuleVOs) {
		this.priTrfRuleVOs = priTrfRuleVOs;
	}
}