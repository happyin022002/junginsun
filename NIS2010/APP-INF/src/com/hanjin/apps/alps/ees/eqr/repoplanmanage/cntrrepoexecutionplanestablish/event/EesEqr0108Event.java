/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0108Event.java
*@FileTitle : EES_EQR_0108
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.18 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108MultiVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0108Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0108MultiVO[] eesEqr0108MultiVOS = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0108ConditionVO conditionVO = null;

	public EesEqr0108Event(){}
	

	public EesEqr0108ConditionVO getConditionVO() {
		return conditionVO;
	}

	public void setConditionVO(EesEqr0108ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}


	public EesEqr0108MultiVO[] getEesEqr0108MultiVOS() {
		return eesEqr0108MultiVOS;
	}


	public void setEesEqr0108MultiVOS(EesEqr0108MultiVO[] eesEqr0108MultiVOS) {
		this.eesEqr0108MultiVOS = eesEqr0108MultiVOS;
	}


	
}