/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0126Event.java
*@FileTitle : 컨테이너 Turn - Time 조회 / 수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.13 정은호 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0126ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccTurnTmVO;


/**
 * EES_EQR_0126 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_0126HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChangHoChae
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0126Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0126ConditionVO conditionVO = null;	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrEccTurnTmVO[] eqrScnrEccTurnTmVOS = null;
	
	public EesEqr0126Event() {}
	
	public EesEqr0126ConditionVO getConditionVO() {
		return conditionVO;
	}
	public void setConditionVO(EesEqr0126ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	public EqrScnrEccTurnTmVO[] getEqrScnrEccTurnTmVOS() {
		return eqrScnrEccTurnTmVOS;
	}
	public void setEqrScnrEccTurnTmVOS(EqrScnrEccTurnTmVO[] eqrScnrEccTurnTmVOS) {
		this.eqrScnrEccTurnTmVOS = eqrScnrEccTurnTmVOS;
	}
	
	
	


}
