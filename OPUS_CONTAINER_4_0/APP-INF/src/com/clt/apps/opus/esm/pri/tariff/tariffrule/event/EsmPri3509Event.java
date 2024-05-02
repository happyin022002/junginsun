/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3509Event.java
*@FileTitle : Tariff Rule History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.25 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.event;

import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTrfRuleVO;


/**
 * ESM_PRI_3509 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3509HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_PRI_3509HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3509Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfRuleHistoryVO priTrfRuleHistoryVO = null;
	
	public EsmPri3509Event(){}
	
	public void setPriTrfRuleHistoryVO(PriTrfRuleHistoryVO priTrfRuleHistoryVO){
		this. priTrfRuleHistoryVO = priTrfRuleHistoryVO;
	}

	public PriTrfRuleHistoryVO getPriTrfRuleHistoryVO(){
		return priTrfRuleHistoryVO;
	}

}