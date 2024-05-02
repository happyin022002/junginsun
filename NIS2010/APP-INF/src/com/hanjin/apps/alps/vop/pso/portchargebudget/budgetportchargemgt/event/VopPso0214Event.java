/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0214Event.java
*@FileTitle : Invoice Summary Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier :
*@LastVersion : 1.0
* 2009.12.09
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO-0214 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0214HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see VOP_PSO-0214HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0214Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private InvSumDtlVO invSumDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private InvSumDtlVO[] invSumDtlVOs = null;

	/**
	 * @return the invSumDtlVO
	 */
	public InvSumDtlVO getInvSumDtlVO() {
		return invSumDtlVO;
	}

	/**
	 * @param invSumDtlVO the invSumDtlVO to set
	 */
	public void setInvSumDtlVO(InvSumDtlVO invSumDtlVO) {
		this.invSumDtlVO = invSumDtlVO;
	}

	/**
	 * @return the invSumDtlVOs
	 */
	public InvSumDtlVO[] getInvSumDtlVOs(){
		InvSumDtlVO[] tmpVOs = null;
		if (this. invSumDtlVOs != null) {
			tmpVOs = new InvSumDtlVO[invSumDtlVOs .length];
			System.arraycopy(invSumDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param invSumDtlVOs the invSumDtlVOs to set
	 */

	public void setInvSumDtlVOs(InvSumDtlVO[] invSumDtlVOs){
		if (invSumDtlVOs != null) {
			InvSumDtlVO[] tmpVOs = new InvSumDtlVO[invSumDtlVOs .length];
			System.arraycopy(invSumDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. invSumDtlVOs = tmpVOs;
		}
	}
}