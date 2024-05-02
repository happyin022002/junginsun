/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0213Event.java
*@FileTitle : Expense Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.09.25 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ExpnDtlVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoChargeVO;


/**
 * VOP_PSO-0213 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0213HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0213HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0213Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoChargeVO psoChargeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoChargeVO[] psoChargeVOs = null;

	/** 조회 조건 VO */
	private ExpnDtlVO expnDtlVO;

	/**
	 * 조회조건 VO setter
	 * @param expnDtlVO
	 */
	public void setExpnDtlVO(ExpnDtlVO expnDtlVO) {
		this.expnDtlVO = expnDtlVO;
	}

	public VopPso0213Event(){}
	
	public void setPsoChargeVO(PsoChargeVO psoChargeVO){
		this. psoChargeVO = psoChargeVO;
	}

	public void setPsoChargeVOS(PsoChargeVO[] psoChargeVOs){
		if (psoChargeVOs != null) {
			PsoChargeVO[] tmpVOs = new PsoChargeVO[psoChargeVOs.length];
			System.arraycopy(psoChargeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoChargeVOs = tmpVOs;
		}
	}

	public PsoChargeVO getPsoChargeVO(){
		return psoChargeVO;
	}

	public PsoChargeVO[] getPsoChargeVOS(){
		PsoChargeVO[] tmpVOs = null;
		if (this.psoChargeVOs != null) {
			tmpVOs = new PsoChargeVO[psoChargeVOs.length];
			System.arraycopy(psoChargeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 조회 조건 VO getter
	 * @return
	 */
	public ExpnDtlVO getExpnDtlVO() {
		// TODO Auto-generated method stub
		return this.expnDtlVO;
	}

}