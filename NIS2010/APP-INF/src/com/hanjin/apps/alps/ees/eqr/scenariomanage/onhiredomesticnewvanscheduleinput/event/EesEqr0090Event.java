/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EesEqr0090Event.java
*@FileTitle : US Domestic 물량 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-10
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-08-10 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0090ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrSlseVO;


/**
 * EES_EQR_0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_0090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0090Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EesEqr0090ConditionVO conditionVO = null;
	public EesEqr0090ConditionVO[] conditionVOS = null;

	private EqrScnrSlseVO eqrScnrSlseVO = null;
	public EqrScnrSlseVO[] eqrScnrSlseVOS = null;
	public EesEqr0090ConditionVO getConditionVO() {
		return conditionVO;
	}
	public void setConditionVO(EesEqr0090ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	public EesEqr0090ConditionVO[] getConditionVOS() {
		return conditionVOS;
	}
	public void setConditionVOS(EesEqr0090ConditionVO[] conditionVOS) {
		this.conditionVOS = conditionVOS;
	}
	public EqrScnrSlseVO getEqrScnrSlseVO() {
		return eqrScnrSlseVO;
	}
	public void setEqrScnrSlseVO(EqrScnrSlseVO eqrScnrSlseVO) {
		this.eqrScnrSlseVO = eqrScnrSlseVO;
	}
	public EqrScnrSlseVO[] getEqrScnrSlseVOS() {
		return eqrScnrSlseVOS;
	}
	public void setEqrScnrSlseVOS(EqrScnrSlseVO[] eqrScnrSlseVOS) {
		this.eqrScnrSlseVOS = eqrScnrSlseVOS;
	}
	
	
	
}
