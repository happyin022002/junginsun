/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0004Event.java
*@FileTitle      : Basic Data Creation Popup
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.15
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.15 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0004Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	public EsmSqm0004Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
}