/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0079Event.java
*@FileTitle : Authority Office Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.15 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ConsultationConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.SettlementTargetVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0088HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0101HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConsultationConditionVO consultationConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SettlementTargetVO settlementTargetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SettlementTargetVO[] settlementTargetVOs = null;


	public FnsJoo0101Event(){}

	public void setConsultationConditionVO(ConsultationConditionVO consultationConditionVO){
		this.consultationConditionVO = consultationConditionVO;
	}
	
	public void setSettlementTargetVO(SettlementTargetVO settlementTargetVO){
		this.settlementTargetVO = settlementTargetVO;
	}

	public void setSettlementTargetVOS(SettlementTargetVO[] settlementTargetVOs){
		if (settlementTargetVOs != null) {
			SettlementTargetVO[] tmpVOs = new SettlementTargetVO[settlementTargetVOs.length];
			System.arraycopy(settlementTargetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.settlementTargetVOs = tmpVOs;
		}
	}

	public ConsultationConditionVO getConsultationConditionVO(){
		return consultationConditionVO;
	}

	public SettlementTargetVO getSettlementTargetVO(){
		return settlementTargetVO;
	}
	
	public SettlementTargetVO[] getSettlementTargetVOS(){
		SettlementTargetVO[] tmpVOs = null;
		if (this.settlementTargetVOs != null) {
			tmpVOs = new SettlementTargetVO[settlementTargetVOs.length];
			System.arraycopy(settlementTargetVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}