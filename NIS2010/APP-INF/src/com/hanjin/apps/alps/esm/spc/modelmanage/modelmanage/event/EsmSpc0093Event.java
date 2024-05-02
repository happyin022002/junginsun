/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmSpc0093Event.java
*@FileTitle : Report by Loading
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.18 진마리아
* 1.0 Creation
* 2013.02.18 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0093HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0093Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSpc0093Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}