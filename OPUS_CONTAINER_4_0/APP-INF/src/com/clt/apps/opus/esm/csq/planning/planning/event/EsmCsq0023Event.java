/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmCsq0023Event.java
*@FileTitle      : RHQ QTA Summary
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_CSQ_0023 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_CSQ_0023HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_CSQ_0023HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0023Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmCsq0023Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}