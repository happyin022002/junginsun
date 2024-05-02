/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0086Event.java
*@FileTitle : L/T off hier
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.08.03 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrLongTermOffhCondVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0086ConditionVO;


/**
 * EES_EQR_0086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0086HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrLongTermOffhCondVO eqrScnrLongTermOffhCondVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrLongTermOffhCondVO[] eqrScnrLongTermOffhCondVOs = null;
	
	/** condition 정보 처리 */
	private EesEqr0086ConditionVO eesEqr0086ConditionVO = null;
	
	public EesEqr0086Event(){}

	/**
	 * @return the eqrScnrLongTermOffhCondVO
	 */
	public EqrScnrLongTermOffhCondVO getEqrScnrLongTermOffhCondVO() {
		return eqrScnrLongTermOffhCondVO;
	}

	/**
	 * @param eqrScnrLongTermOffhCondVO the eqrScnrLongTermOffhCondVO to set
	 */
	public void setEqrScnrLongTermOffhCondVO(
			EqrScnrLongTermOffhCondVO eqrScnrLongTermOffhCondVO) {
		this.eqrScnrLongTermOffhCondVO = eqrScnrLongTermOffhCondVO;
	}

	/**
	 * @return the eqrScnrLongTermOffhCondVOs
	 */
	public EqrScnrLongTermOffhCondVO[] getEqrScnrLongTermOffhCondVOs() {
		return eqrScnrLongTermOffhCondVOs;
	}

	/**
	 * @param eqrScnrLongTermOffhCondVOs the eqrScnrLongTermOffhCondVOs to set
	 */
	public void setEqrScnrLongTermOffhCondVOs(
			EqrScnrLongTermOffhCondVO[] eqrScnrLongTermOffhCondVOs) {
		this.eqrScnrLongTermOffhCondVOs = eqrScnrLongTermOffhCondVOs;
	}

	/**
	 * @return the eesEqr0086ConditionVO
	 */
	public EesEqr0086ConditionVO getEesEqr0086ConditionVO() {
		return eesEqr0086ConditionVO;
	}

	/**
	 * @param eesEqr0086ConditionVO the eesEqr0086ConditionVO to set
	 */
	public void setEesEqr0086ConditionVO(EesEqr0086ConditionVO eesEqr0086ConditionVO) {
		this.eesEqr0086ConditionVO = eesEqr0086ConditionVO;
	}
	

}