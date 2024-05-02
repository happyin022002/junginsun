/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0009Event.java
*@FileTitle : Estimate VVD Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.06 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PsoMsaVO;


/**
 * VOP_PSO-0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/**입력 파라미터 rev_yrmon*/
	private String revYrmon = "";

	/**입력 파라미터 vsl_slan_cd*/
	private String vslSlanCd = "";


	public VopPso0009Event(){}
	
	/**
	 * revYrmon의 getter
	 * @return
	 */
	public String getRevYrmon() {
		return revYrmon;
	}
	
	/**
	 * revYrmon의 setter
	 * @param parameter
	 */
	public void setRevYrmon(String revYrmon) {
		// TODO Auto-generated method stub
		this.revYrmon = revYrmon;
	}

	/**
	 * vslSlanCd의 getter
	 * @return
	 */
	public String getVslSlanCd() {
		return vslSlanCd;
	}
	
	/**
	 * vslSlanCd의 setter
	 * @param parameter
	 */
	public void setVslSlanCd(String vslSlanCd) {
		// TODO Auto-generated method stub
		this.vslSlanCd = vslSlanCd;
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
}