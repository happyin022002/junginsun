/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0009Event.java
*@FileTitle      : Lane-Office Relation Setting_New Lane Add Pop-up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.20
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.20 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0009Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}