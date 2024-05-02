/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0113Event.java
*@FileTitle : EES_EQR_0113
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.19 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0113ConditionVO;


/**
 * EES_EQR_0113 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0113HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0113HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0113Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0113ConditionVO eesEqr0113ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0113ConditionVO[] eesEqr0113ConditionVOs = null;

	public EesEqr0113Event(){}
	
	public void setEesEqr0113ConditionVO(EesEqr0113ConditionVO eesEqr0113ConditionVO){
		this. eesEqr0113ConditionVO = eesEqr0113ConditionVO;
	}

	public void setEesEqr0113ConditionVOS(EesEqr0113ConditionVO[] eesEqr0113ConditionVOs){
		this. eesEqr0113ConditionVOs = eesEqr0113ConditionVOs;
	}

	public EesEqr0113ConditionVO getEesEqr0113ConditionVO(){
		return eesEqr0113ConditionVO;
	}

	public EesEqr0113ConditionVO[] getEesEqr0113ConditionVOS(){
		return eesEqr0113ConditionVOs;
	}

}