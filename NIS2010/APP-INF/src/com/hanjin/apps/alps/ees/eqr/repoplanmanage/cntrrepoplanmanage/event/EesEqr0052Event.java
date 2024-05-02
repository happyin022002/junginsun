/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0052Event.java
*@FileTitle : 최적화된 REPO InOut 계획 수량 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-10-19		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.08.17		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.17
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052MultiVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0052HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0052ConditionVO eesEqr0052ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0052MultiVO[] eesEqr0052MultiVOS = null;

	public EesEqr0052Event(){}

	/**
	 * @return the eesEqr0052ConditionVO
	 */
	public EesEqr0052ConditionVO getEesEqr0052ConditionVO() {
		return eesEqr0052ConditionVO;
	}

	/**
	 * @param eesEqr0052ConditionVO the eesEqr0052ConditionVO to set
	 */
	public void setEesEqr0052ConditionVO(EesEqr0052ConditionVO eesEqr0052ConditionVO) {
		this.eesEqr0052ConditionVO = eesEqr0052ConditionVO;
	}

	/**
	 * @return the eesEqr0052MultiVOS
	 */
	public EesEqr0052MultiVO[] getEesEqr0052MultiVOS() {
		return eesEqr0052MultiVOS;
	}

	/**
	 * @param eesEqr0052MultiVOS the eesEqr0052MultiVOS to set
	 */
	public void setEesEqr0052MultiVOS(EesEqr0052MultiVO[] eesEqr0052MultiVOS) {
		this.eesEqr0052MultiVOS = eesEqr0052MultiVOS;
	}

}