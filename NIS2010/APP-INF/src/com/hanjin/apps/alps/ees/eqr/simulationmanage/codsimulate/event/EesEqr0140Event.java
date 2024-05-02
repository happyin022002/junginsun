/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0140Event.java
*@FileTitle : Bay PLAN
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.04 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0140ConditionVO;


/**
 * EES_EQR_0140 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0140HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0140HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0140Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0140ConditionVO eesEqr0140ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	

	public EesEqr0140Event(){}

	/**
	 * @return the eesEqr0140ConditionVO
	 */
	public EesEqr0140ConditionVO getEesEqr0140ConditionVO() {
		return eesEqr0140ConditionVO;
	}

	/**
	 * @param eesEqr0140ConditionVO the eesEqr0140ConditionVO to set
	 */
	public void setEesEqr0140ConditionVO(EesEqr0140ConditionVO eesEqr0140ConditionVO) {
		this.eesEqr0140ConditionVO = eesEqr0140ConditionVO;
	}
	
	
}