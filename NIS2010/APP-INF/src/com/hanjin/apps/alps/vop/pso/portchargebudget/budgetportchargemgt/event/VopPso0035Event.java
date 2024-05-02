/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0035Event.java
*@FileTitle : Budget Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.08 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.PortChgBudByYearVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PsoMsaVO;


/**
 * VOP_PSO-0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/** 조회 조건 VO */
	private PortChgBudByYearVO portChgBudByYearVO = null;

	/** multi Data 처리를 위한 데이터 VOs */
	private PortChgBudByYearVO[] portChgBudByYearVOs;

	/**
	 * multi Data 처리를 위한 데이터 VOs getter
	 * @return
	 */
	public PortChgBudByYearVO[] getPortChgBudByYearVOs(){
		PortChgBudByYearVO[] tmpVOs = null;
		if (this. portChgBudByYearVOs != null) {
			tmpVOs = new PortChgBudByYearVO[portChgBudByYearVOs .length];
			System.arraycopy(portChgBudByYearVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 조회 조건 VO Setter
	 * @param portChgBudByYearVO
	 */
	public void setPortChgBudByYearVO(PortChgBudByYearVO portChgBudByYearVO) {
		this.portChgBudByYearVO = portChgBudByYearVO;
	}

	public VopPso0035Event(){}
	
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
	 * 조회 조건 VO getter
	 * @return
	 */
	public PortChgBudByYearVO getPortChgBudByYearVO() {
		// TODO Auto-generated method stub
		return this.portChgBudByYearVO ;
	}

	/**
	 * multi Row 처리를 위한 VO Setter
	 * @param os
	 */
	public void setPortChgBudByYearVOs(PortChgBudByYearVO[] portChgBudByYearVOs){
		if (portChgBudByYearVOs != null) {
			PortChgBudByYearVO[] tmpVOs = new PortChgBudByYearVO[portChgBudByYearVOs .length];
			System.arraycopy(portChgBudByYearVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. portChgBudByYearVOs = tmpVOs;
		}
	}

	
}