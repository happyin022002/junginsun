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
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.event;

import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012ConditionVO;
import com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo.EesEqr0012MultiVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.EqrVslLdisPlnCodTmpVO;
import com.clt.syscommon.common.table.EqrVslPlnCodQtyVO;

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
	private EesEqr0012ConditionVO[] eesEqr0012ConditionVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private EqrVslLdisPlnCodTmpVO[] eqrVslLdisPlnCodTmpVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private EqrVslPlnCodQtyVO[] eqrVslPlnCodQtyVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr0012MultiVO[] eesEqr0012MultiVOs = null;

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
		EesEqr0012ConditionVO[] tmpVOs = null;
		if (this.eesEqr0012ConditionVOs != null) {
			tmpVOs = new EesEqr0012ConditionVO[eesEqr0012ConditionVOs.length];
			System.arraycopy(eesEqr0012ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eesEqr0012ConditionVOs the eesEqr0012ConditionVOs to set
	 */
	public void setEesEqr0012ConditionVOs(
			EesEqr0012ConditionVO[] eesEqr0012ConditionVOs) {
		if (eesEqr0012ConditionVOs != null) {
			EesEqr0012ConditionVO[] tmpVOs = new EesEqr0012ConditionVO[eesEqr0012ConditionVOs.length];
			System.arraycopy(eesEqr0012ConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0012ConditionVOs = tmpVOs;
		}
	}

	/**
	 * @return the eqrVslLdisPlnCodTmpVOs
	 */
	public EqrVslLdisPlnCodTmpVO[] getEqrVslLdisPlnCodTmpVOs() {
		EqrVslLdisPlnCodTmpVO[] tmpVOs = null;
		if (this.eqrVslLdisPlnCodTmpVOs != null) {
			tmpVOs = new EqrVslLdisPlnCodTmpVO[eqrVslLdisPlnCodTmpVOs.length];
			System.arraycopy(eqrVslLdisPlnCodTmpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eqrVslLdisPlnCodTmpVOs the eqrVslLdisPlnCodTmpVOs to set
	 */
	public void setEqrVslLdisPlnCodTmpVOs(
			EqrVslLdisPlnCodTmpVO[] eqrVslLdisPlnCodTmpVOs) {
		if (eqrVslLdisPlnCodTmpVOs != null) {
			EqrVslLdisPlnCodTmpVO[] tmpVOs = new EqrVslLdisPlnCodTmpVO[eqrVslLdisPlnCodTmpVOs.length];
			System.arraycopy(eqrVslLdisPlnCodTmpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrVslLdisPlnCodTmpVOs = tmpVOs;
		}
	}

	/**
	 * @return the eqrVslPlnCodQtyVOs
	 */
	public EqrVslPlnCodQtyVO[] getEqrVslPlnCodQtyVOs() {
		EqrVslPlnCodQtyVO[] tmpVOs = null;
		if (this.eqrVslPlnCodQtyVOs != null) {
			tmpVOs = new EqrVslPlnCodQtyVO[eqrVslPlnCodQtyVOs.length];
			System.arraycopy(eqrVslPlnCodQtyVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eqrVslPlnCodQtyVOs the eqrVslPlnCodQtyVOs to set
	 */
	public void setEqrVslPlnCodQtyVOs(EqrVslPlnCodQtyVO[] eqrVslPlnCodQtyVOs) {
		if (eqrVslPlnCodQtyVOs != null) {
			EqrVslPlnCodQtyVO[] tmpVOs = new EqrVslPlnCodQtyVO[eqrVslPlnCodQtyVOs.length];
			System.arraycopy(eqrVslPlnCodQtyVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrVslPlnCodQtyVOs = tmpVOs;
		}
	}

	/**
	 * @return the eesEqr0012MultiVOs
	 */
	public EesEqr0012MultiVO[] getEesEqr0012MultiVOs() {
		EesEqr0012MultiVO[] tmpVOs = null;
		if (this.eesEqr0012MultiVOs != null) {
			tmpVOs = new EesEqr0012MultiVO[eesEqr0012MultiVOs.length];
			System.arraycopy(eesEqr0012MultiVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eesEqr0012MultiVOs the eesEqr0012MultiVOs to set
	 */
	public void setEesEqr0012MultiVOs(EesEqr0012MultiVO[] eesEqr0012MultiVOs) {
		if (eesEqr0012MultiVOs != null) {
			EesEqr0012MultiVO[] tmpVOs = new EesEqr0012MultiVO[eesEqr0012MultiVOs.length];
			System.arraycopy(eesEqr0012MultiVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0012MultiVOs = tmpVOs;
		}
	}

	
	

}