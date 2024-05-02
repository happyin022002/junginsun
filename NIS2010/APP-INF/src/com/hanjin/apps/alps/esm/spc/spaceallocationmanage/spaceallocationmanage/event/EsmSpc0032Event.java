/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmSpc0032Event.java
*@FileTitle : Status by Load Office
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.01
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.02.01 진마리아
* 1.0 Creation
* 2013.02.01 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	public EsmSpc0032Event(){}

}