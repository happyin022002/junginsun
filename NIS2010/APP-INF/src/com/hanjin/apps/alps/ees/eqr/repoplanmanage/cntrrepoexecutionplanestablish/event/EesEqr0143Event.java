/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0143Event.java
*@FileTitle : EQR All-Weeks' Plan Access Grant
*Open Issues :
*	신규프로젝트 CSRNO : CHM-201003779
*	EQR VL-VD 전주차 접근권한 유저 신규메뉴 생성
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1      	1.0      	Lee Byoung Hun				2010.05.11		1.0 최초 생성
*
*@LastModifyDate : 2010.05.11
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2010.05.11
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0143MultiVO;


/**
 * EES_EQR_0143 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0143HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0143HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0143Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0143ConditionVO eesEqr0143ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0143MultiVO[] eesEqr0143MultiVOS = null;

	public EesEqr0143Event(){}

	/**
	 * @return the eesEqr0143MultiVOS
	 */
	public EesEqr0143MultiVO[] getEesEqr0143MultiVOS() {
		return eesEqr0143MultiVOS;
	}

	/**
	 * @param eesEqr0143MultiVOS the eesEqr0143MultiVOS to set
	 */
	public void setEesEqr0143MultiVOS(EesEqr0143MultiVO[] eesEqr0143MultiVOS) {
		this.eesEqr0143MultiVOS = eesEqr0143MultiVOS;
	}

	/**
	 * @return the eesEqr0143ConditionVO
	 */
	public EesEqr0143ConditionVO getEesEqr0143ConditionVO() {
		return eesEqr0143ConditionVO;
	}

	/**
	 * @param eesEqr0143ConditionVO the eesEqr0143ConditionVO to set
	 */
	public void setEesEqr0143ConditionVO(EesEqr0143ConditionVO eesEqr0143ConditionVO) {
		this.eesEqr0143ConditionVO = eesEqr0143ConditionVO;
	}
	
}