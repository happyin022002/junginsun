/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0021Event.java
*@FileTitle : US Domestic 물량 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1		1.0		jungran yang		2006-09-20		1.0 최초 생성
* 2		1.0		Lee Byoung Hun	2009.08.04		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.04
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0021ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrDmstVO;


/**
 * EES_EQR_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0021ConditionVO eesEqr0021ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrDmstVO[] eqrScnrDmstVOS = null;

	public EesEqr0021Event(){}

	/**
	 * @return the eesEqr0021ConditionVO
	 */
	public EesEqr0021ConditionVO getEesEqr0021ConditionVO() {
		return eesEqr0021ConditionVO;
	}

	/**
	 * @param eesEqr0021ConditionVO the eesEqr0021ConditionVO to set
	 */
	public void setEesEqr0021ConditionVO(EesEqr0021ConditionVO eesEqr0021ConditionVO) {
		this.eesEqr0021ConditionVO = eesEqr0021ConditionVO;
	}

	/**
	 * @return the eqrScnrDmstVOS
	 */
	public EqrScnrDmstVO[] getEqrScnrDmstVOS() {
		return eqrScnrDmstVOS;
	}

	/**
	 * @param eqrScnrDmstVOS the eqrScnrDmstVOS to set
	 */
	public void setEqrScnrDmstVOS(EqrScnrDmstVO[] eqrScnrDmstVOS) {
		this.eqrScnrDmstVOS = eqrScnrDmstVOS;
	}

}