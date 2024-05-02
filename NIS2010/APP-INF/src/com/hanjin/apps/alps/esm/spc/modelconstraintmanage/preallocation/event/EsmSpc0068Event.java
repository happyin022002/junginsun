/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0068Event.java
*@FileTitle : Pre-Allocation Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.07 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0068 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0068HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ju Sun Young
 * @see ESM_SPC_0068HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0068Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ConditionVO[] conditionVOs = null;

	public EsmSpc0068Event(){}
	
	public void setConditionVO(ConditionVO conditionVO){
		this.conditionVO = conditionVO;
	}

	public void setConditionVOS(ConditionVO[] conditionVOs){
		this.conditionVOs = conditionVOs;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	public ConditionVO[] getConditionVOS(){
		return conditionVOs;
	}
	

}