/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0059Event.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.13 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrVslLodgDchgExePlnVO;


/**
 * EES_EQR_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0059HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0059Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrVslLodgDchgExePlnVO[] eqrVslLodgDchgExePlnVOs = null;

	private EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
	private EesEqr0059MultiVO eesEqr0059MultiVO = null;
	public EesEqr0059MultiVO[] eesEqr0059MultiVOs = null;
	

	public EesEqr0059Event(){}
	
	public EqrVslLodgDchgExePlnVO getEqrVslLodgDchgExePlnVO() {
		return eqrVslLodgDchgExePlnVO;
	}

	public void setEqrVslLodgDchgExePlnVO(EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO) {
		this.eqrVslLodgDchgExePlnVO = eqrVslLodgDchgExePlnVO;
	}

	public EqrVslLodgDchgExePlnVO[] getEqrVslLodgDchgExePlnVOs() {
		return eqrVslLodgDchgExePlnVOs;
	}

	public void setEqrVslLodgDchgExePlnVOs(EqrVslLodgDchgExePlnVO[] eqrVslLodgDchgExePlnVOs) {
		this.eqrVslLodgDchgExePlnVOs = eqrVslLodgDchgExePlnVOs;
	}

	public EesEqr0059ConditionVO getEesEqr0059ConditionVO() {
		return eesEqr0059ConditionVO;
	}

	public void setEesEqr0059ConditionVO(EesEqr0059ConditionVO eesEqr0059ConditionVO) {
		this.eesEqr0059ConditionVO = eesEqr0059ConditionVO;
	}

	public EesEqr0059MultiVO getEesEqr0059MultiVO() {
		return eesEqr0059MultiVO;
	}

	public void setEesEqr0059MultiVO(EesEqr0059MultiVO eesEqr0059MultiVO) {
		this.eesEqr0059MultiVO = eesEqr0059MultiVO;
	}

	public EesEqr0059MultiVO[] getEesEqr0059MultiVOs() {
		return eesEqr0059MultiVOs;
	}

	public void setEesEqr0059MultiVOs(EesEqr0059MultiVO[] eesEqr0059MultiVOs) {
		this.eesEqr0059MultiVOs = eesEqr0059MultiVOs;
	}
	
}