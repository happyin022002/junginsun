/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0069Event.java
*@FileTitle : CSR Inquiry – CSR Details POP UP 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.10 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;


/**
 * FNS_JOO_0069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0069HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0069Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public FnsJoo0069Event(){}	
		
	private SlipConditionVO slipConditionVO = null;
	
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
 
}