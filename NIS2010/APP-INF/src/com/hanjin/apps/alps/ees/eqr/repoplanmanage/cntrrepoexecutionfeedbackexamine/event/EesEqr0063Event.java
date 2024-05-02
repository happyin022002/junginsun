/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0063Event.java
*@FileTitle : 컨테이너 이송실행 실적 및 Feedback 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		ChangHoChae					2006-10-24		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.09.23		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.23
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0063HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0063ConditionVO eesEqr0063ConditionVO = null;

	public EesEqr0063Event(){}

	/**
	 * @return the eesEqr0063ConditionVO
	 */
	public EesEqr0063ConditionVO getEesEqr0063ConditionVO() {
		return eesEqr0063ConditionVO;
	}

	/**
	 * @param eesEqr0063ConditionVO the eesEqr0063ConditionVO to set
	 */
	public void setEesEqr0063ConditionVO(EesEqr0063ConditionVO eesEqr0063ConditionVO) {
		this.eesEqr0063ConditionVO = eesEqr0063ConditionVO;
	}

}