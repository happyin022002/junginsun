/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0007Event.java
*@FileTitle : Slot Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.04 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ProcSettlementVO procSettlementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ProcSettlementVO[] procSettlementVOs = null;
	
	public FnsJoo0007Event(){}
	
	public void setProcSettlementVO(ProcSettlementVO procSettlementVO){
		this. procSettlementVO = procSettlementVO;
	}

	public void setProcSettlementVOS(ProcSettlementVO[] procSettlementVOs){
		if (procSettlementVOs != null) {
			ProcSettlementVO[] tmpVOs = new ProcSettlementVO[procSettlementVOs.length];
			System.arraycopy(procSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.procSettlementVOs = tmpVOs;
		}
	}

	public ProcSettlementVO getProcSettlementVO(){
		return procSettlementVO;
	}

	public ProcSettlementVO[] getProcSettlementVOS(){
		ProcSettlementVO[] tmpVOs = null;
		if (this.procSettlementVOs != null) {
			tmpVOs = new ProcSettlementVO[procSettlementVOs.length];
			System.arraycopy(procSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}