/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0081Event.java
*@FileTitle : 컨테이너 이송 실행 계획 조회/수정 On-Hire & Off-Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.09.10 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0081MultiVO;


/**
 * EES_EQR_0081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0081HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0059ConditionVO eesEqr0059ConditionVO = null;


	/** Table Value Object Multi Data 처리 */
	public EesEqr0081MultiVO[] eesEqr0081MultiVOS = null;

	public EesEqr0081Event(){}
	
	public void setEesEqr0059ConditionVO(EesEqr0059ConditionVO eesEqr0059ConditionVO){
		this. eesEqr0059ConditionVO = eesEqr0059ConditionVO;
	}

	public EesEqr0059ConditionVO getEesEqr0059ConditionVO(){
		return eesEqr0059ConditionVO;
	}

	public EesEqr0081MultiVO[] getEesEqr0081MultiVOS() {
		return eesEqr0081MultiVOS;
	}

	public void setEesEqr0081MultiVOS(EesEqr0081MultiVO[] eesEqr0081MultiVOS) {
		this.eesEqr0081MultiVOS = eesEqr0081MultiVOS;
	}
}