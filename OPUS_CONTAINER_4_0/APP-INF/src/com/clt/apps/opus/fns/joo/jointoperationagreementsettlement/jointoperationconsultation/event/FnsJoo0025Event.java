/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0025Event.java
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.19 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 조회조건 VO */
	private SlipConditionVO slipConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CsrSlipVO csrSlipVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CsrSlipVO[] csrSlipVOs = null;

	public FnsJoo0025Event(){}
	
	public SlipConditionVO getSlipConditionVO() {
		return slipConditionVO;
	}

	public void setSlipConditionVO(SlipConditionVO slipConditionVO) {
		this.slipConditionVO = slipConditionVO;
	}

	public void setCsrSlipVO(CsrSlipVO csrSlipVO){
		this. csrSlipVO = csrSlipVO;
	}

	public void setCsrSlipVOS(CsrSlipVO[] csrSlipVOs){
		if (csrSlipVOs != null) {
			CsrSlipVO[] tmpVOs = new CsrSlipVO[csrSlipVOs.length];
			System.arraycopy(csrSlipVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.csrSlipVOs = tmpVOs;
		}
	}

	public CsrSlipVO getCsrSlipVO(){
		return csrSlipVO;
	}

	public CsrSlipVO[] getCsrSlipVOS(){
		CsrSlipVO[] tmpVOs = null;
		if (this.csrSlipVOs != null) {
			tmpVOs = new CsrSlipVO[csrSlipVOs.length];
			System.arraycopy(csrSlipVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}