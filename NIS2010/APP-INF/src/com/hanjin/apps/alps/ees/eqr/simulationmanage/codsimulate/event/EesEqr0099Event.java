/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0099Event.java
*@FileTitle : POD Simulation Analyes
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;



/**
 * EES_EQR_0099 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0099HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0099HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0099Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/**012 화면의 조건절 사용*/
	private EesEqr0012ConditionVO  eesEqr0012ConditionVO = null;
	
	public EesEqr0099Event(){}
	

	/**
	 * @return the eesEqr0012ConditionVO
	 */
	public EesEqr0012ConditionVO getEesEqr0012ConditionVO() {
		return eesEqr0012ConditionVO;
	}

	/**
	 * @param eesEqr0012ConditionVO the eesEqr0012ConditionVO to set
	 */
	public void setEesEqr0012ConditionVO(EesEqr0012ConditionVO eesEqr0012ConditionVO) {
		this.eesEqr0012ConditionVO = eesEqr0012ConditionVO;
	}

}