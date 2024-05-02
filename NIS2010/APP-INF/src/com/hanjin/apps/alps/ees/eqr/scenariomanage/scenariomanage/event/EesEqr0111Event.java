/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0111Event.java
*@FileTitle : Vessel Schedule 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-05
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-08-05 정은호
* 1.0 최초 생성
*
 * =======================================================
 *  CSRNO : N200811110008
 *  CSR NAME : EQR에서 Vessel SKD 업데이트  
 *  Change history : User 가 Vessel SKD 업데이트 할 수 있도록 시스템 보완. 
 *  LastModifier : chae chang ho
 *  LastModifyDate :2008.11.12 
 *  -> 프레임워크 변경으로 인해 업데이트 모델을 해당 VO 로 전환함 ( 2009.08.04)
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0111ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;



/**
 * EES_EQR_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 정은호
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0111Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EesEqr0111ConditionVO conditionVO = null;
	public EesEqr0111ConditionVO[] conditionVOS = null;

	private EqrScnrVslSkdVO eqrScnrVslSkdVO = null;
	public EqrScnrVslSkdVO[] eqrScnrVslSkdVOS = null;
	
	public EesEqr0111ConditionVO getConditionVO() {
		return conditionVO;
	}
	public void setConditionVO(EesEqr0111ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	public EesEqr0111ConditionVO[] getConditionVOS() {
		return conditionVOS;
	}
	public void setConditionVOS(EesEqr0111ConditionVO[] conditionVOS) {
		this.conditionVOS = conditionVOS;
	}
	public EqrScnrVslSkdVO getEqrScnrVslSkdVO() {
		return eqrScnrVslSkdVO;
	}
	public void setEqrScnrVslSkdVO(EqrScnrVslSkdVO eqrScnrVslSkdVO) {
		this.eqrScnrVslSkdVO = eqrScnrVslSkdVO;
	}
	public EqrScnrVslSkdVO[] getEqrScnrVslSkdVOS() {
		return eqrScnrVslSkdVOS;
	}
	public void setEqrScnrVslSkdVOS(EqrScnrVslSkdVO[] eqrScnrVslSkdVOS) {
		this.eqrScnrVslSkdVOS = eqrScnrVslSkdVOS;
	}
	
}
