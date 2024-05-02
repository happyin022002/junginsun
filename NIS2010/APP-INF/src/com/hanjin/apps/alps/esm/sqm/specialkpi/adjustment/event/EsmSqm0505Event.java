/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0505Event.java
*@FileTitle      : KPI Creation & Edit_New Lane Add Pop up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.15
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.15 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0505 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0505HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0505HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0505Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0505Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}