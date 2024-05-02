/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0085Event.java
*@FileTitle : S/T off-Hire 정보 조회/ 수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-07
*@LastModifier : ChungEunHo
*@LastVersion : 1.0
* 2009-08-07 ChungEunHo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0085ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrMstVO;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOffhCondVO;


/**
 * EES_EQR_0085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_0085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0085Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrMstVO eqrScnrMstVO = null;
	/** Table Value Object Multi Data 처리 */
	public EqrScnrMstVO[] eqrScnrMstVOS = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrShrtTermOffhCondVO eqrScnrShrtTermOffhCondVO = null;
	/** Table Value Object Multi Data 처리 */
	public EqrScnrShrtTermOffhCondVO[] eqrScnrShrtTermOffhCondVOS = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0085ConditionVO conditionVO = null;
	/** Table Value Object Multi Data 처리 */
	public EesEqr0085ConditionVO[] conditionVOS = null;
	
	public EqrScnrMstVO getEqrScnrMstVO() {
		return eqrScnrMstVO;
	}
	public void setEqrScnrMstVO(EqrScnrMstVO eqrScnrMstVO) {
		this.eqrScnrMstVO = eqrScnrMstVO;
	}
	public EqrScnrMstVO[] getEqrScnrMstVOS() {
		return eqrScnrMstVOS;
	}
	public void setEqrScnrMstVOS(EqrScnrMstVO[] eqrScnrMstVOS) {
		this.eqrScnrMstVOS = eqrScnrMstVOS;
	}	
	public EqrScnrShrtTermOffhCondVO getEqrScnrShrtTermOffhCondVO() {
		return eqrScnrShrtTermOffhCondVO;
	}
	public void setEqrScnrShrtTermOffhCondVO(
			EqrScnrShrtTermOffhCondVO eqrScnrShrtTermOffhCondVO) {
		this.eqrScnrShrtTermOffhCondVO = eqrScnrShrtTermOffhCondVO;
	}
	public EqrScnrShrtTermOffhCondVO[] getEqrScnrShrtTermOffhCondVOS() {
		return eqrScnrShrtTermOffhCondVOS;
	}
	public void setEqrScnrShrtTermOffhCondVOS(
			EqrScnrShrtTermOffhCondVO[] eqrScnrShrtTermOffhCondVOS) {
		this.eqrScnrShrtTermOffhCondVOS = eqrScnrShrtTermOffhCondVOS;
	}
	public EesEqr0085ConditionVO getConditionVO() {
		return conditionVO;
	}
	public void setConditionVO(EesEqr0085ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	public EesEqr0085ConditionVO[] getConditionVOS() {
		return conditionVOS;
	}
	public void setConditionVOS(EesEqr0085ConditionVO[] conditionVOS) {
		this.conditionVOS = conditionVOS;
	}
	
	

}
