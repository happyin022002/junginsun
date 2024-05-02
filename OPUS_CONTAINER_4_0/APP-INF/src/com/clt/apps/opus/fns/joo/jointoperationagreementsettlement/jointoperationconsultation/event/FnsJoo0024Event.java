/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0024Event.java
*@FileTitle : CSR Approval - CSR Details POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.09 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0024HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SlipVO jooSlipVO = null;
	
	/**
	 * @return the jooSlipVO
	 */
	public SlipVO getJooSlipVO() {
		return jooSlipVO;
	}

	/**
	 * @param jooSlipVO the jooSlipVO to set
	 */
	public void setJooSlipVO(SlipVO jooSlipVO) {
		this.jooSlipVO = jooSlipVO;
	}

	/**
	 * @return the jooSlipVOs
	 */
	public SlipVO[] getJooSlipVOs() {
		SlipVO[] tmpVOs = null;
		if (this.jooSlipVOs != null) {
			tmpVOs = new SlipVO[jooSlipVOs.length];
			System.arraycopy(jooSlipVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param jooSlipVOs the jooSlipVOs to set
	 */
	public void setJooSlipVOs(SlipVO[] jooSlipVOs) {
		if (jooSlipVOs != null) {
			SlipVO[] tmpVOs = new SlipVO[jooSlipVOs.length];
			System.arraycopy(jooSlipVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooSlipVOs = tmpVOs;
		}
	}

	/**
	 * @return the slipConditionVO
	 */
	public SlipConditionVO getSlipConditionVO() {
		return slipConditionVO;
	}

	/**
	 * @param slipConditionVO the slipConditionVO to set
	 */
	public void setSlipConditionVO(SlipConditionVO slipConditionVO) {
		this.slipConditionVO = slipConditionVO;
	}

	private SlipVO[] jooSlipVOs = null;
	
	private SlipConditionVO slipConditionVO = null;

	public FnsJoo0024Event(){}
	 

}