/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0026Event.java
*@FileTitle : Budget vs Actual
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.11 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author myoungjong park
 * @see VOP_PSO_0026HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvSumByMonVO invSumByMonVO = null;

	/**
	 * @param invSumByMonVO the invSumByMonVO to set
	 */
	public void setInvSumByMonVO(InvSumByMonVO invSumByMonVO) {
		this.invSumByMonVO = invSumByMonVO;
	}

	/**
	 * @return the invSumByMonVO
	 */
	public InvSumByMonVO getInvSumByMonVO() {
		return invSumByMonVO;
	}
	

}