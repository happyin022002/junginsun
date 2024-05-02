/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0067Event.java
*@FileTitle : Pre-Allocation Creation
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
import com.hanjin.apps.alps.esm.spc.common.common.vo.SaqPreAlocVO;


/**
 * ESM_SPC_0067 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0067HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ju Sun Young
 * @see ESM_SPC_0067HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0067Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqPreAlocVO saqPreAlocVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqPreAlocVO[] saqPreAlocVOs = null;

	private ConditionVO conditionVO = null;
	
	private ConditionVO[] conditionVOs = null;	
	

	public EsmSpc0067Event(){}
	
	public void setSaqPreAlocVO(SaqPreAlocVO saqPreAlocVO){
		this.saqPreAlocVO = saqPreAlocVO;
	}

	public void setSaqPreAlocVOS(SaqPreAlocVO[] saqPreAlocVOs){
		this.saqPreAlocVOs = saqPreAlocVOs;
	}

	public SaqPreAlocVO getSaqPreAlocVO(){
		return saqPreAlocVO;
	}

	public SaqPreAlocVO[] getSaqPreAlocVOS(){
		return saqPreAlocVOs;
	}

	
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