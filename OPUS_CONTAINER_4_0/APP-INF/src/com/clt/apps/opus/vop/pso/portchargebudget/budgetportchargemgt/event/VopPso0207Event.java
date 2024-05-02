/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0207Event.java
*@FileTitle : Interface to ERP (Detail)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoMsaVO;


/**
 * VOP_PSO-0207 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0207HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0207HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0207Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/** 조회 조건 VO */
	private ErpDtlVO erpDtlVO = null;

	/** 다건 처리 용*/
	private ErpDtlVO[] erpDtlVOs = null;



	public VopPso0207Event(){}

	/**
	 * 수정된 데이터 리스트 setter
	 * @param erpDtlVOs
	 */
	public void setErpDtlVOs(ErpDtlVO[] erpDtlVOs) {
		if (erpDtlVOs != null) {
			ErpDtlVO[] tmpVOs = new ErpDtlVO[erpDtlVOs.length];
			System.arraycopy(erpDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.erpDtlVOs = tmpVOs;
		}
	}
	/**
	 * 수정된 데이터 리스트 getter
	 * @return
	 */
	public ErpDtlVO[] getErpDtlVOs() {
		ErpDtlVO[] tmpVOs = null;
		if (this.erpDtlVOs != null) {
			tmpVOs = new ErpDtlVO[erpDtlVOs.length];
			System.arraycopy(erpDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	/**
	 * 조회 조건 VO getter
	 * @return
	 */
	public ErpDtlVO getErpDtlVO() {
		return erpDtlVO;
	}
	/**
	 * 조회 조건 VO ErpDtlVO setter 
	 * @param vo
	 */
	public void setErpDtlVO(ErpDtlVO vo) {
		// TODO Auto-generated method stub
		this.erpDtlVO = vo;
	}
	
	public void setPsoMsaVO(PsoMsaVO psoMsaVO){
		this. psoMsaVO = psoMsaVO;
	}

	public void setPsoMsaVOS(PsoMsaVO[] psoMsaVOs){
		if (psoMsaVOs != null) {
			PsoMsaVO[] tmpVOs = new PsoMsaVO[psoMsaVOs.length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoMsaVOs = tmpVOs;
		}
	}

	public PsoMsaVO getPsoMsaVO(){
		return psoMsaVO;
	}

	public PsoMsaVO[] getPsoMsaVOS(){
		PsoMsaVO[] tmpVOs = null;
		if (this.psoMsaVOs != null) {
			tmpVOs = new PsoMsaVO[psoMsaVOs.length];
			System.arraycopy(psoMsaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}