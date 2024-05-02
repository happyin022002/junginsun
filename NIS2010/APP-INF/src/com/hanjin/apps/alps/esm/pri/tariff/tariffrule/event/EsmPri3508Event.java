/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3508Event.java
*@FileTitle : Tariff Rule Summary Print
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.21 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfRuleVO;


/**
 * ESM_PRI_3508 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3508HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_PRI_3508HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3508Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfRuleVO priTrfRuleVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfRuleVO[] priTrfRuleVOs = null;

	public EsmPri3508Event(){}
	
	public void setPriTrfRuleVO(PriTrfRuleVO priTrfRuleVO){
		this. priTrfRuleVO = priTrfRuleVO;
	}

	public void setPriTrfRuleVOS(PriTrfRuleVO[] priTrfRuleVOs){
		this. priTrfRuleVOs = priTrfRuleVOs;
	}

	public PriTrfRuleVO getPriTrfRuleVO(){
		return priTrfRuleVO;
	}

	public PriTrfRuleVO[] getPriTrfRuleVOS(){
		return priTrfRuleVOs;
	}

}