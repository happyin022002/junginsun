/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0059ViewAdapter.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.09.28 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0112ConditionVO;


/**
 * EES_EQR_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0112HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0112ConditionVO eesEqr0112ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0112ConditionVO[] eesEqr0112ConditionVOs = null;

	public EesEqr0112Event(){}
	
	public void setEesEqr0112ConditionVO(EesEqr0112ConditionVO eesEqr0112ConditionVO){
		this. eesEqr0112ConditionVO = eesEqr0112ConditionVO;
	}

	public void setEesEqr0112ConditionVOS(EesEqr0112ConditionVO[] eesEqr0112ConditionVOs){
		this. eesEqr0112ConditionVOs = eesEqr0112ConditionVOs;
	}

	public EesEqr0112ConditionVO getEesEqr0112ConditionVO(){
		return eesEqr0112ConditionVO;
	}

	public EesEqr0112ConditionVO[] getEesEqr0112ConditionVOS(){
		return eesEqr0112ConditionVOs;
	}

}