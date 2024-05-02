/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0037Event.java
*@FileTitle      : QTA Inquiry_Yearly Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.29
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.29 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planninginquiry.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_CSQ_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmCsq0037Event(){}

	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}