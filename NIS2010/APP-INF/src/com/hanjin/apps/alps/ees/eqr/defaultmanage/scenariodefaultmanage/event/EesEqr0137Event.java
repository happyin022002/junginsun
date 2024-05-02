/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0137Event.java
*@FileTitle : Constraint by Lane/POD
*Open Issues :
*Change history :
* No.    Ver.   Modifier         modifier date    explanation
* 1      1.0    ChangHoChae      2008-03-07       1.0 최초 생성
* 1      1.0    ChangHoChae      2008-03-24       N200802260006
*@LastModifyDate : 2009.07.21
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.21 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0137ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrPortDchgCnstVO;


/**
 * EES_EQR_0137 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0137HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0137HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0137Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrPortDchgCnstVO eqrPortDchgCnstVO = null;
	private EesEqr0137ConditionVO eesEqr0137ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrPortDchgCnstVO[] eqrPortDchgCnstVOs = null;
	
	public EesEqr0137Event(){}
	
	public void setEqrPortDchgCnstVO(EqrPortDchgCnstVO eqrPortDchgCnstVO){
		this. eqrPortDchgCnstVO = eqrPortDchgCnstVO;
	}

	public void setEqrPortDchgCnstVOS(EqrPortDchgCnstVO[] eqrPortDchgCnstVOs){
		this. eqrPortDchgCnstVOs = eqrPortDchgCnstVOs;
	}

	public EqrPortDchgCnstVO getEqrPortDchgCnstVO(){
		return eqrPortDchgCnstVO;
	}

	public EqrPortDchgCnstVO[] getEqrPortDchgCnstVOS(){
		return eqrPortDchgCnstVOs;
	}
	
	public void setEesEqr0137ConditionVO(EesEqr0137ConditionVO eesEqr0137ConditionVO) {
		this.eesEqr0137ConditionVO = eesEqr0137ConditionVO;
	}

	public EesEqr0137ConditionVO getEesEqr0137ConditionVO() {
		return eesEqr0137ConditionVO;
	}

}