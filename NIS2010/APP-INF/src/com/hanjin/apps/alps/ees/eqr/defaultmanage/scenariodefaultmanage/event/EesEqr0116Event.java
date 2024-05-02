/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_116Event.java
*@FileTitle : Link 정보 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-02
*@LastModifier : eun ho chung
*@LastVersion : 2.0
* 2006-09-27 yongchan shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrEccLnkVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;

/**
 * EES_EQR_0116 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0116HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author eun ho chung
 * @see EES_EQR_0116HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0116Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrEccLnkVO eqrEccLnkVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrEccLnkVO[] eqrEccLnkVOs = null;

	/*
	 * search Condition 조건 단건처리
	 */
	
	private EesEqr0116ConditionVO conditionVO = null;
	/*
	 * search Condition 조건 Multi Data 처리
	 */
	
	public EesEqr0116ConditionVO[] conditionVOs = null;
	
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
		return this.conditionVOs;
	}

	/**
	 * @param conditionVOs the conditionVOs to set
	 */
	public void setConditionVOs(EesEqr0116ConditionVO[] conditionVOs) {
		this.conditionVOs = conditionVOs;
	}

	public EesEqr0116Event(){}
	
	public void setEqrEccLnkVO(EqrEccLnkVO eqrEccLnkVO){
		this. eqrEccLnkVO = eqrEccLnkVO;
	}

	public void setEqrEccLnkVOS(EqrEccLnkVO[] eqrEccLnkVOs){
		this. eqrEccLnkVOs = eqrEccLnkVOs;
	}

	public EqrEccLnkVO getEqrEccLnkVO(){
		return eqrEccLnkVO;
	}

	public EqrEccLnkVO[] getEqrEccLnkVOS(){
		return eqrEccLnkVOs;
	}

}
