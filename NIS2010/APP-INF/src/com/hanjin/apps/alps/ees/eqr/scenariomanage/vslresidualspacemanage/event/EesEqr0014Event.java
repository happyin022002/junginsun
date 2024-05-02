/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0014Event.java
*@FileTitle : BSA 조회 / 수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.11 정은호 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.vslresidualspacemanage.vo.EesEqr0014ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrBsaPortVO;
import com.hanjin.syscommon.common.table.EqrScnrBsaVvdVO;



/**
 * EES_EQR_014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChangHoChae
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesEqr0014Event extends EventSupport {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EesEqr0014ConditionVO conditionVO = null;
	public EesEqr0014ConditionVO[] conditionVOS = null;
	private EqrScnrBsaVvdVO eqrScnrBsaVvdVO = null;
	public EqrScnrBsaVvdVO[] eqrScnrBsaVvdVOS = null;
	private EqrScnrBsaPortVO eqrScnrBsaPortVO = null;
	public EqrScnrBsaPortVO[] eqrScnrBsaPortVOS = null;
	public EesEqr0014ConditionVO getConditionVO() {
		return conditionVO;
	}
	public void setConditionVO(EesEqr0014ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	public EesEqr0014ConditionVO[] getConditionVOS() {
		return conditionVOS;
	}
	public void setConditionVOS(EesEqr0014ConditionVO[] conditionVOS) {
		this.conditionVOS = conditionVOS;
	}
	public EqrScnrBsaVvdVO getEqrScnrBsaVvdVO() {
		return eqrScnrBsaVvdVO;
	}
	public void setEqrScnrBsaVvdVO(EqrScnrBsaVvdVO eqrScnrBsaVvdVO) {
		this.eqrScnrBsaVvdVO = eqrScnrBsaVvdVO;
	}
	public EqrScnrBsaVvdVO[] getEqrScnrBsaVvdVOS() {
		return eqrScnrBsaVvdVOS;
	}
	public void setEqrScnrBsaVvdVOS(EqrScnrBsaVvdVO[] eqrScnrBsaVvdVOS) {
		this.eqrScnrBsaVvdVOS = eqrScnrBsaVvdVOS;
	}
	public EqrScnrBsaPortVO getEqrScnrBsaPortVO() {
		return eqrScnrBsaPortVO;
	}
	public void setEqrScnrBsaPortVO(EqrScnrBsaPortVO eqrScnrBsaPortVO) {
		this.eqrScnrBsaPortVO = eqrScnrBsaPortVO;
	}
	public EqrScnrBsaPortVO[] getEqrScnrBsaPortVOS() {
		return eqrScnrBsaPortVOS;
	}
	public void setEqrScnrBsaPortVOS(EqrScnrBsaPortVO[] eqrScnrBsaPortVOS) {
		this.eqrScnrBsaPortVOS = eqrScnrBsaPortVOS;
	}
	
	
}

