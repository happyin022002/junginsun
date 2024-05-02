/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0010Event.java
*@FileTitle : Estimate Expense Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo.EstExpnCreVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PsoMsaVO;


/**
 * VOP_PSO-0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/** 조회조건 VO*/
	private EstExpnCreVO estExpnCreVO = null;

	/** Multi Data 처리 변수 */
	private EstExpnCreVO[] estExpnCreVOs;



	/**
	 * Multi Data 처리 변수 getter
	 * @return
	 */
	public EstExpnCreVO[] getEstExpnCreVOs(){
		EstExpnCreVO[] tmpVOs = null;
		if (this. estExpnCreVOs != null) {
			tmpVOs = new EstExpnCreVO[estExpnCreVOs .length];
			System.arraycopy(estExpnCreVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public VopPso0010Event(){}
	
	
	/**
	 * 조회조건 VO setter
	 * @param estExpnCreVO
	 */
	public void setEstExpnCreVO(EstExpnCreVO estExpnCreVO) {
		this.estExpnCreVO = estExpnCreVO;
	}
	/**
	 * 조회 조건 VO getter
	 * @return
	 */
	public EstExpnCreVO getEstExpnCreVO() {
		// TODO Auto-generated method stub
		return this.estExpnCreVO ;
	}
	
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


	public void setEstExpnCreVOs(EstExpnCreVO[] estExpnCreVOs){
		if (estExpnCreVOs != null) {
			EstExpnCreVO[] tmpVOs = new EstExpnCreVO[estExpnCreVOs .length];
			System.arraycopy(estExpnCreVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. estExpnCreVOs = tmpVOs;
		}
	}

	

}