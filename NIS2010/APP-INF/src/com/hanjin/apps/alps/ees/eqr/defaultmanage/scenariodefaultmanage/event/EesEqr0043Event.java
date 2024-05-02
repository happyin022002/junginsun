/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0043Event.java
*@FileTitle : 컨테이너 Turn-Time 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.01 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0043ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrEccTurnTmVO;


/**
 * EES_EQR_0043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0043HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0043Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0043ConditionVO eesEqr0043ConditionVO = null;
	private EqrEccTurnTmVO eqrEccTurnTmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0043ConditionVO[] eesEqr0043ConditionVOs = null;
	public EqrEccTurnTmVO[] eqrEccTurnTmVOs = null;

	public EesEqr0043Event(){}
	
	public void setEesEqr0043ConditionVO(EesEqr0043ConditionVO eesEqr043ConditionVO){
		this.eesEqr0043ConditionVO = eesEqr043ConditionVO;
	}
	public EesEqr0043ConditionVO getEesEqr0043ConditionVO(){
		return eesEqr0043ConditionVO;
	}
	public EqrEccTurnTmVO getEqrEccTurnTmVO(){
		return eqrEccTurnTmVO;
	}
	public void setEesEqr0043ConditionVOS(EesEqr0043ConditionVO[] eesEqr0043ConditionVOs){
		this.eesEqr0043ConditionVOs = eesEqr0043ConditionVOs;
	}
	public EesEqr0043ConditionVO[] getEesEqr0043ConditionVOS(){
		return eesEqr0043ConditionVOs;
	}
	public EqrEccTurnTmVO[] getEqrEccTurnTmVOS(){
		return eqrEccTurnTmVOs;
	}
	
	public void setEqrEccTurnTmVOS(EqrEccTurnTmVO[] eqrEccTurnTmVOs){
		this. eqrEccTurnTmVOs = eqrEccTurnTmVOs;
	}

}