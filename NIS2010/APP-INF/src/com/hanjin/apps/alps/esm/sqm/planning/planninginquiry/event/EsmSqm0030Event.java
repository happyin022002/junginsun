/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0030Event.java
*@FileTitle      : QTA Inquiry_Quarterly Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.30
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.30 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0030HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmSqm0030Event(){}

	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}