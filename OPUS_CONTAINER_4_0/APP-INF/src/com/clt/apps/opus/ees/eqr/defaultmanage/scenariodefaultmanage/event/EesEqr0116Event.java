/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_116Event.java
*@FileTitle : Link information search/modify
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.EqrEccLnkVO;

/**
 * EES_EQR_0116 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0116HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0116HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0116Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrEccLnkVO eqrEccLnkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EqrEccLnkVO[] eqrEccLnkVOs = null;

	/*
	 * search Condition 조건 단건처리
	 */
	
	private EesEqr0116ConditionVO conditionVO = null;
	/*
	 * search Condition 조건 Multi Data 처리
	 */
	
	private EesEqr0116ConditionVO[] conditionVOs = null;
	
	/**
	 * @return the conditionVO
	 */
	public EesEqr0116ConditionVO getConditionVO() {
		return conditionVO;
	}

	/**
	 * @param conditionVO the conditionVO to set
	 */
	public void setConditionVO(EesEqr0116ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

	/**
	 * @return the conditionVOs
	 */
	public EesEqr0116ConditionVO[] getConditionVOs() {
		EesEqr0116ConditionVO[] tmpVOs = null;
		if (this.conditionVOs != null) {
			tmpVOs = new EesEqr0116ConditionVO[conditionVOs.length];
			System.arraycopy(conditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param conditionVOs the conditionVOs to set
	 */
	public void setConditionVOs(EesEqr0116ConditionVO[] conditionVOs) {
		if (conditionVOs != null) {
			EesEqr0116ConditionVO[] tmpVOs = new EesEqr0116ConditionVO[conditionVOs.length];
			System.arraycopy(conditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.conditionVOs = tmpVOs;
		}
	}

	public EesEqr0116Event(){}
	
	public void setEqrEccLnkVO(EqrEccLnkVO eqrEccLnkVO){
		this. eqrEccLnkVO = eqrEccLnkVO;
	}

	public void setEqrEccLnkVOS(EqrEccLnkVO[] eqrEccLnkVOs){
		if (eqrEccLnkVOs != null) {
			EqrEccLnkVO[] tmpVOs = new EqrEccLnkVO[eqrEccLnkVOs.length];
			System.arraycopy(eqrEccLnkVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrEccLnkVOs = tmpVOs;
		}
	}

	public EqrEccLnkVO getEqrEccLnkVO(){
		return eqrEccLnkVO;
	}

	public EqrEccLnkVO[] getEqrEccLnkVOS(){
		EqrEccLnkVO[] tmpVOs = null;
		if (this.eqrEccLnkVOs != null) {
			tmpVOs = new EqrEccLnkVO[eqrEccLnkVOs.length];
			System.arraycopy(eqrEccLnkVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}
