/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt0005Event.java
*@FileTitle : 공제 대상 Charge 조회 및 다중 선택(Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.09.02 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.event;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtChargeDeductionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_AGT_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_0005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kyung-won Chu
 * @see ESM_AGT_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtChargeDeductionVO agtChargeDeductionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtChargeDeductionVO[] agtChargeDeductionVOs = null;

	public EsmAgt0005Event(){}
	
	public void setAgtChargeDeductionVO(AgtChargeDeductionVO agtChargeDeductionVO){
		this. agtChargeDeductionVO = agtChargeDeductionVO;
	}

	public void setAgtChargeDeductionVOS(AgtChargeDeductionVO[] agtChargeDeductionVOs){
		this. agtChargeDeductionVOs = agtChargeDeductionVOs;
	}

	public AgtChargeDeductionVO getAgtChargeDeductionVO(){
		return agtChargeDeductionVO;
	}

	public AgtChargeDeductionVO[] getAgtChargeDeductionVOS(){
		return agtChargeDeductionVOs;
	}

}