/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0013Event.java
*@FileTitle : Interface to ERP
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
* 
* 2011.03.04 진마리아 CHM-201108564-01 I/F to ERP화면내 조회 로직 및 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PsoMsaVO;


/**
 * VOP_PSO-0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/** 조회 조건 VO */
	private ErpSumVO erpSumVO = null;
	
	private ErpDtlVO erpDtlVO = null;

	/**
	 * 조회조건 ErpSumVO의 setter
	 * @param erpSumVO
	 */
	public void setErpSumVO(ErpSumVO erpSumVO) {
		this.erpSumVO = erpSumVO;
	}

	public VopPso0013Event(){}
	
	public void setPsoMsaVO(PsoMsaVO psoMsaVO){
		this. psoMsaVO = psoMsaVO;
	}

	public void setPsoMsaVOS(PsoMsaVO[] psoMsaVOs){
		if (psoMsaVOs != null) {
			PsoMsaVO[] tmpVOs = new PsoMsaVO[psoMsaVOs .length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. psoMsaVOs = tmpVOs;
		}
	}
	
	public PsoMsaVO getPsoMsaVO(){
		return psoMsaVO;
	}

	public PsoMsaVO[] getPsoMsaVOS(){
		PsoMsaVO[] tmpVOs = null;
		if (this. psoMsaVOs != null) {
			tmpVOs = new PsoMsaVO[psoMsaVOs .length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * 조회조건인 ErpSumVO의 getter
	 * @return
	 */
	public ErpSumVO getErpSumVO() {
		// TODO Auto-generated method stub
		return this.erpSumVO ;
	}

	public ErpDtlVO getErpDtlVO() {
		return erpDtlVO;
	}

	public void setErpDtlVO(ErpDtlVO erpDtlVO) {
		this.erpDtlVO = erpDtlVO;
	}

}