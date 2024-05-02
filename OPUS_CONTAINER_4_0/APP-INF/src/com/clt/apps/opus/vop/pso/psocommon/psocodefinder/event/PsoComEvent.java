/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsoComEvent.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.20 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.psocommon.psocodefinder.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PsoMsaDtlVO;
import com.clt.syscommon.common.table.PsoMsaVO;


/**
 * PSO_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  PSO_COMHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see PSO_COMHTMLAction 참조
 * @since J2EE 1.4
 */

public class PsoComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaVO psoMsaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaVO[] psoMsaVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PsoMsaDtlVO psoMsaDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PsoMsaDtlVO[] psoMsaDtlVOs = null;

	public PsoComEvent(){}
	
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

	public void setPsoMsaDtlVO(PsoMsaDtlVO psoMsaDtlVO){
		this. psoMsaDtlVO = psoMsaDtlVO;
	}

	public void setPsoMsaDtlVOS(PsoMsaDtlVO[] psoMsaDtlVOs){
		if (psoMsaDtlVOs != null) {
			PsoMsaDtlVO[] tmpVOs = new PsoMsaDtlVO[psoMsaDtlVOs.length];
			System.arraycopy(psoMsaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.psoMsaDtlVOs = tmpVOs;
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

	public PsoMsaDtlVO getPsoMsaDtlVO(){
		return psoMsaDtlVO;
	}

	public PsoMsaDtlVO[] getPsoMsaDtlVOS(){
		PsoMsaDtlVO[] tmpVOs = null;
		if (this.psoMsaDtlVOs != null) {
			tmpVOs = new PsoMsaDtlVO[psoMsaDtlVOs.length];
			System.arraycopy(psoMsaDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}