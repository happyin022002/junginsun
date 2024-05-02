/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0025Event.java
*@FileTitle : 컨테이너 수요 예측(O/B)
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	sangyool pak		2006-10-17		1.0 최초 생성
* 2		1.0		Lee Byoung Hun	2009.08.10		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.10
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0025ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrObFcastVO;


/**
 * EES_EQR_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0025ConditionVO eesEqr0025ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrObFcastVO[] eqrObFcastVOS = null;
	
	private String scnrId = null;
	
	private String scnrRmk = null;

	public EesEqr0025Event(){}

	/**
	 * @return the eesEqr0025ConditionVO
	 */
	public EesEqr0025ConditionVO getEesEqr0025ConditionVO() {
		return eesEqr0025ConditionVO;
	}

	/**
	 * @param eesEqr0025ConditionVO the eesEqr0025ConditionVO to set
	 */
	public void setEesEqr0025ConditionVO(EesEqr0025ConditionVO eesEqr0025ConditionVO) {
		this.eesEqr0025ConditionVO = eesEqr0025ConditionVO;
	}

	/**
	 * @return the eqrObFcastVOS
	 */
	public EqrObFcastVO[] getEqrObFcastVOS() {
		return eqrObFcastVOS;
	}

	/**
	 * @param eqrObFcastVOS the eqrObFcastVOS to set
	 */
	public void setEqrObFcastVOS(EqrObFcastVO[] eqrObFcastVOS) {
		this.eqrObFcastVOS = eqrObFcastVOS;
	}

	/**
	 * @return the scnrId
	 */
	public String getScnrId() {
		return scnrId;
	}

	/**
	 * @param scnrId the scnrId to set
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}

	/**
	 * @return the scnrRmk
	 */
	public String getScnrRmk() {
		return scnrRmk;
	}

	/**
	 * @param scnrRmk the scnrRmk to set
	 */
	public void setScnrRmk(String scnrRmk) {
		this.scnrRmk = scnrRmk;
	}

}