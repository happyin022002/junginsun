/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0088Event.java
*@FileTitle : 민감도조회/분석
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.22 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0088ConditionVO;

/**
 * EES_EQR_0088 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0088HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0088Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/**  조건절 VO */
	private EesEqr0088ConditionVO eesEqr0088ConditionVO =  null;
	
	
	public EesEqr0088Event(){}
	
	/**
	 * @return the eesEqr0088ConditionVO
	 */
	public EesEqr0088ConditionVO getEesEqr0088ConditionVO() {
		return eesEqr0088ConditionVO;
	}

	/**
	 * @param eesEqr0088ConditionVO the eesEqr0088ConditionVO to set
	 */
	public void setEesEqr0088ConditionVO(EesEqr0088ConditionVO eesEqr0088ConditionVO) {
		this.eesEqr0088ConditionVO = eesEqr0088ConditionVO;
	}

	
}