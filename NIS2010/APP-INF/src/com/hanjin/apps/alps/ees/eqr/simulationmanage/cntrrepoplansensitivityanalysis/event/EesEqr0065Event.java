/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0065Event.java
*@FileTitle : 민감도 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.18 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.event;

import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.cntrrepoplansensitivityanalysis.vo.EesEqr0065MultiVO;

/**
 * EES_EQR_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0065HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private EesEqr0065ConditionVO eesEqr0065ConditionVO = null;

	public EesEqr0065MultiVO[] eesEqr0065MultiVOs      = null;
	
	public EesEqr0065Event(){}
	

	/**
	 * @return the eesEqr0065ConditionVO
	 */
	public EesEqr0065ConditionVO getEesEqr0065ConditionVO() {
		return eesEqr0065ConditionVO;
	}

	/**
	 * @param eesEqr0065ConditionVO the eesEqr0065ConditionVO to set
	 */
	public void setEesEqr0065ConditionVO(EesEqr0065ConditionVO eesEqr0065ConditionVO) {
		this.eesEqr0065ConditionVO = eesEqr0065ConditionVO;
	}

	/**
	 * @return the eesEqr0065MultiVOs
	 */
	public EesEqr0065MultiVO[] getEesEqr0065MultiVOs() {
		return eesEqr0065MultiVOs;
	}

	/**
	 * @param eesEqr0065MultiVOs the eesEqr0065MultiVOs to set
	 */
	public void setEesEqr0065MultiVOs(EesEqr0065MultiVO[] eesEqr0065MultiVOs) {
		this.eesEqr0065MultiVOs = eesEqr0065MultiVOs;
	}
    
	
}