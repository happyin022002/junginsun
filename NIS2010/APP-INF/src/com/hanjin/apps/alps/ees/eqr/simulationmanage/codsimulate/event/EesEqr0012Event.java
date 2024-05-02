/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0012Event.java
*@FileTitle : Change POD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.08.24 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.hanjin.apps.alps.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012MultiVO;
import com.hanjin.syscommon.common.table.EqrVslLdisPlnCodTmpVO;
import com.hanjin.syscommon.common.table.EqrVslPlnCodQtyVO;

/**
 * EES_EQR_0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0012ConditionVO eesEqr0012ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0012ConditionVO[] eesEqr0012ConditionVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrVslLdisPlnCodTmpVO[] eqrVslLdisPlnCodTmpVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrVslPlnCodQtyVO[] eqrVslPlnCodQtyVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	public EesEqr0012MultiVO[] eesEqr0012MultiVOs = null;

	public EesEqr0012Event(){}

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

	/**
	 * @return the eesEqr0012ConditionVOs
	 */
	public EesEqr0012ConditionVO[] getEesEqr0012ConditionVOs() {
		return eesEqr0012ConditionVOs;
	}

	/**
	 * @param eesEqr0012ConditionVOs the eesEqr0012ConditionVOs to set
	 */
	public void setEesEqr0012ConditionVOs(
			EesEqr0012ConditionVO[] eesEqr0012ConditionVOs) {
		this.eesEqr0012ConditionVOs = eesEqr0012ConditionVOs;
	}

	/**
	 * @return the eqrVslLdisPlnCodTmpVOs
	 */
	public EqrVslLdisPlnCodTmpVO[] getEqrVslLdisPlnCodTmpVOs() {
		return eqrVslLdisPlnCodTmpVOs;
	}

	/**
	 * @param eqrVslLdisPlnCodTmpVOs the eqrVslLdisPlnCodTmpVOs to set
	 */
	public void setEqrVslLdisPlnCodTmpVOs(
			EqrVslLdisPlnCodTmpVO[] eqrVslLdisPlnCodTmpVOs) {
		this.eqrVslLdisPlnCodTmpVOs = eqrVslLdisPlnCodTmpVOs;
	}

	/**
	 * @return the eqrVslPlnCodQtyVOs
	 */
	public EqrVslPlnCodQtyVO[] getEqrVslPlnCodQtyVOs() {
		return eqrVslPlnCodQtyVOs;
	}

	/**
	 * @param eqrVslPlnCodQtyVOs the eqrVslPlnCodQtyVOs to set
	 */
	public void setEqrVslPlnCodQtyVOs(EqrVslPlnCodQtyVO[] eqrVslPlnCodQtyVOs) {
		this.eqrVslPlnCodQtyVOs = eqrVslPlnCodQtyVOs;
	}

	/**
	 * @return the eesEqr0012MultiVOs
	 */
	public EesEqr0012MultiVO[] getEesEqr0012MultiVOs() {
		return eesEqr0012MultiVOs;
	}

	/**
	 * @param eesEqr0012MultiVOs the eesEqr0012MultiVOs to set
	 */
	public void setEesEqr0012MultiVOs(EesEqr0012MultiVO[] eesEqr0012MultiVOs) {
		this.eesEqr0012MultiVOs = eesEqr0012MultiVOs;
	}

	
	

}