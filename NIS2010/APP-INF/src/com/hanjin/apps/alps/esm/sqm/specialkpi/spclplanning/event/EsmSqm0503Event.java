/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0503Event.java
*@FileTitle      : Basic CMCB (CM Cost Per Box) New Lane Add
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.11
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.11 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0503 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0503HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0503HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0503Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0503Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}