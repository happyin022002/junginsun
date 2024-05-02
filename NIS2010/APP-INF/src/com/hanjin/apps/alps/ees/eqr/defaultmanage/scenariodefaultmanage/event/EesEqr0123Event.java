/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0123Event.java
*@FileTitle : Sublease 물량 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.10		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.10
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0123ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrSubleaseVO;


/**
 * EES_EQR_0123 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0123HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0123HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0123Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0123ConditionVO eesEqr123ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrSubleaseVO[] eqrSubleaseVOs = null;

	/**
	 * Default Constructor
	 */
	public EesEqr0123Event(){}
	
	public void setEesEqr123ConditionVO(EesEqr0123ConditionVO eesEqr123ConditionVO){
		this. eesEqr123ConditionVO = eesEqr123ConditionVO;
	}

	public EesEqr0123ConditionVO getEesEqr123ConditionVO(){
		return eesEqr123ConditionVO;
	}

	/**
	 * @return the eqrSubleaseVOs
	 */
	public EqrSubleaseVO[] getEqrSubleaseVOS() {
		return eqrSubleaseVOs;
	}

	/**
	 * @param eqrSubleaseVOs the eqrSubleaseVOs to set
	 */
	public void setEqrSubleaseVOS(EqrSubleaseVO[] eqrSubleaseVOs) {
		this.eqrSubleaseVOs = eqrSubleaseVOs;
	}

}