/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0020Event.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.event;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalDtlVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo.CanalTzFeeBalVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PsoMsaVO;
import com.hanjin.syscommon.common.table.PsoMsaDtlVO;


/**
 * VOP_PSO-0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO-0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see VOP_PSO-0020HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopPso0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	private CanalTzFeeBalVO canalTzFeeBalVO = null;
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;
	private CanalTzFeeBalVO[] canalTzFeeBalVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaDtlVO psoMsaDtlVO = null;
	private CanalTzFeeBalDtlVO canalTzFeeBalDtlVO = null;
	
	/**
	 * @param vo
	 */
	public void setCanalTzFeeBalDtlVO(CanalTzFeeBalDtlVO canalTzFeeBalDtlVO) {
		// TODO Auto-generated method stub
		this.canalTzFeeBalDtlVO = canalTzFeeBalDtlVO;
	}
	public CanalTzFeeBalDtlVO getCanalTzFeeBalDtlVO() {
		return canalTzFeeBalDtlVO;
	}
	/** Table Value Object Multi Data 처리 */
	private PsoMsaDtlVO[] psoMsaDtlVOs = null;
	
	/**
	 * 조회 조건변수인 canalTzFeeBalVO의 setter
	 * @return
	 */
	public void setCanalTzFeeBalVO(CanalTzFeeBalVO canalTzFeeBalVO) {
		this.canalTzFeeBalVO = canalTzFeeBalVO;
	}
	/**
	 * 조회 조건변수인 canalTzFeeBalVO의 getter
	 * @return
	 */
	public CanalTzFeeBalVO getCanalTzFeeBalVO() {
		// TODO Auto-generated method stub
		return this.canalTzFeeBalVO ; 
	}




	public VopPso0020Event(){}
	
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
	
	public void setPsoMsaDtlVO(PsoMsaDtlVO psoMsaDtlVO){
		this. psoMsaDtlVO = psoMsaDtlVO;
	}


	public void setPsoMsaDtlVOS(PsoMsaDtlVO[] psoMsaDtlVOs){
		if (psoMsaDtlVOs != null) {
			PsoMsaDtlVO[] tmpVOs = new PsoMsaDtlVO[psoMsaDtlVOs .length];
			System.arraycopy(psoMsaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. psoMsaDtlVOs = tmpVOs;
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
	
	public PsoMsaDtlVO getPsoMsaDtlVO(){
		return psoMsaDtlVO;
	}


	public PsoMsaDtlVO[] getPsoMsaDtlVOS(){
		PsoMsaDtlVO[] tmpVOs = null;
		if (this. psoMsaDtlVOs != null) {
			tmpVOs = new PsoMsaDtlVO[psoMsaDtlVOs .length];
			System.arraycopy(psoMsaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setCanalTzFeeBalVOs(CanalTzFeeBalVO[] canalTzFeeBalVOs){
		if (canalTzFeeBalVOs != null) {
			CanalTzFeeBalVO[] tmpVOs = new CanalTzFeeBalVO[canalTzFeeBalVOs .length];
			System.arraycopy(canalTzFeeBalVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. canalTzFeeBalVOs = tmpVOs;
		}
	}

	public CanalTzFeeBalVO[] getCanalTzFeeBalVOs(){
		CanalTzFeeBalVO[] tmpVOs = null;
		if (this. canalTzFeeBalVOs != null) {
			tmpVOs = new CanalTzFeeBalVO[canalTzFeeBalVOs .length];
			System.arraycopy(canalTzFeeBalVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
}