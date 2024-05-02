/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0138Event.java
*@FileTitle : Constraint by Lane/ECC
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Chae Chang-Ho	2008-03-10		1.0 최초 생성
* 2		1.0      	Lee Byoung Hun	2009.08.12		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.12
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.repoconstraint.vo.EesEqr0138ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrPortDchgCnstVO;


/**
 * EES_EQR_0138 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0138HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0138HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0138Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0138ConditionVO eesEqr0138ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrPortDchgCnstVO[] eqrScnrPortDchgCnstVOS = null;

	public EesEqr0138Event(){}

	/**
	 * @return the eesEqr0138ConditionVO
	 */
	public EesEqr0138ConditionVO getEesEqr0138ConditionVO() {
		return eesEqr0138ConditionVO;
	}

	/**
	 * @param eesEqr0138ConditionVO the eesEqr0138ConditionVO to set
	 */
	public void setEesEqr0138ConditionVO(EesEqr0138ConditionVO eesEqr0138ConditionVO) {
		this.eesEqr0138ConditionVO = eesEqr0138ConditionVO;
	}

	/**
	 * @return the eqrScnrPortDchgCnstVOS
	 */
	public EqrScnrPortDchgCnstVO[] getEqrScnrPortDchgCnstVOS() {
		return eqrScnrPortDchgCnstVOS;
	}

	/**
	 * @param eqrScnrPortDchgCnstVOS the eqrScnrPortDchgCnstVOS to set
	 */
	public void setEqrScnrPortDchgCnstVOS(
			EqrScnrPortDchgCnstVO[] eqrScnrPortDchgCnstVOS) {
		this.eqrScnrPortDchgCnstVOS = eqrScnrPortDchgCnstVOS;
	}

}