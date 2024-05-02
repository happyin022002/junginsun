/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0017Event.java
*@FileTitle      : RHQ Distribute Result
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_SQM_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0017Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}