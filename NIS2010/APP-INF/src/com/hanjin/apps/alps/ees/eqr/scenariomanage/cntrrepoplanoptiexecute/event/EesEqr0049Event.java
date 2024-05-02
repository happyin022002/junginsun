/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr00049Event.java
*@FileTitle : run_optimizer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo.EesEqr0049ConditionVO;


/**
 * EES_EQR_00049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_00049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_00049HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0049Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0049ConditionVO eesEqr0049ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0049ConditionVO[] eesEqr0049ConditionVOs = null;
	
	
	public EesEqr0049Event(){}


	/**
	 * @return the eesEqr0049ConditionVO
	 */
	public EesEqr0049ConditionVO getEesEqr0049ConditionVO() {
		return eesEqr0049ConditionVO;
	}


	/**
	 * @param eesEqr0049ConditionVO the eesEqr0049ConditionVO to set
	 */
	public void setEesEqr0049ConditionVO(EesEqr0049ConditionVO eesEqr0049ConditionVO) {
		this.eesEqr0049ConditionVO = eesEqr0049ConditionVO;
	}


	/**
	 * @return the eesEqr0049ConditionVOs
	 */
	public EesEqr0049ConditionVO[] getEesEqr0049ConditionVOs() {
		return eesEqr0049ConditionVOs;
	}


	/**
	 * @param eesEqr0049ConditionVOs the eesEqr0049ConditionVOs to set
	 */
	public void setEesEqr0049ConditionVOs(
			EesEqr0049ConditionVO[] eesEqr0049ConditionVOs) {
		this.eesEqr0049ConditionVOs = eesEqr0049ConditionVOs;
	}
	
	

}
