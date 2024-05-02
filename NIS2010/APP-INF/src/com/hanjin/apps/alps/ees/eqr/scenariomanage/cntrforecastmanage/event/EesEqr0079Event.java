/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0079Event.java
*@FileTitle : 컨테이너 수요 예측(I/B)
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	sangyool pak		2006-10-18		1.0 최초 생성
* 2		1.0		Lee Byoung Hun	2009.08.06		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.06
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0079ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrIbBkgFcastVO;


/**
 * EES_EQR_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0079HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0079Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0079ConditionVO eesEqr0079ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrIbBkgFcastVO[] eqrIbBkgFcastVOS = null;

	public EesEqr0079Event(){}

	/**
	 * @return the eesEqr0079ConditionVO
	 */
	public EesEqr0079ConditionVO getEesEqr0079ConditionVO() {
		return eesEqr0079ConditionVO;
	}

	/**
	 * @param eesEqr0079ConditionVO the eesEqr0079ConditionVO to set
	 */
	public void setEesEqr0079ConditionVO(EesEqr0079ConditionVO eesEqr0079ConditionVO) {
		this.eesEqr0079ConditionVO = eesEqr0079ConditionVO;
	}

	/**
	 * @return the eqrIbBkgFcastVOS
	 */
	public EqrIbBkgFcastVO[] getEqrIbBkgFcastVOS() {
		return eqrIbBkgFcastVOS;
	}

	/**
	 * @param eqrIbBkgFcastVOS the eqrIbBkgFcastVOS to set
	 */
	public void setEqrIbBkgFcastVOS(EqrIbBkgFcastVO[] eqrIbBkgFcastVOS) {
		this.eqrIbBkgFcastVOS = eqrIbBkgFcastVOS;
	}

}