/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0029Event.java
*@FileTitle      : QTA Inquiry_Yearly Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.29
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.29 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public EsmSqm0029Event(){}

	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}