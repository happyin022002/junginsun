/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0508Event.java
*@FileTitle      : Current KPI Report
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.25
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.25 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0508 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0508HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 이혜민
 * @see ESM_SQM_0508HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0508Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0508Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	
}