/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0010Event.java
*@FileTitle : OnewaySimulate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.14 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.onewaysimulate.vo.EesEqr0010MutiVO;

/**
 * EES_EQR_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 VO  */
	private EesEqr0010ConditionVO eesEqr0010ConditionVO = null;

	public EesEqr0010MutiVO[] eesEqr0010MutiVOs  = null;
	
	public EesEqr0010Event(){}
	
		/**
	 * @return the eesEqr0010ConditionVO
	 */
	public EesEqr0010ConditionVO getEesEqr0010ConditionVO() {
		return eesEqr0010ConditionVO;
	}

	/**
	 * @param eesEqr0010ConditionVO the eesEqr0010ConditionVO to set
	 */
	public void setEesEqr0010ConditionVO(EesEqr0010ConditionVO eesEqr0010ConditionVO) {
		this.eesEqr0010ConditionVO = eesEqr0010ConditionVO;
	}

	/**
	 * @return the eesEqr0010MutiVOs
	 */
	public EesEqr0010MutiVO[] getEesEqr0010MutiVOs() {
		return eesEqr0010MutiVOs;
	}

	/**
	 * @param eesEqr0010MutiVOs the eesEqr0010MutiVOs to set
	 */
	public void setEesEqr0010MutiVOs(EesEqr0010MutiVO[] eesEqr0010MutiVOs) {
		this.eesEqr0010MutiVOs = eesEqr0010MutiVOs;
	}
	 
	
}