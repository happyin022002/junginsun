/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesDmt3017Event.java
*@FileTitle : Approval for Charge Deletion
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : Kim Hyun Hwa
*@LastVersion : 1.0
* 2011.07.13 Kim Hyun Hwa
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveReasonVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_3017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_3017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_3017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt3017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private InactiveReasonVO inactiveReasonVO = null;
	
	private InactiveInputVO inactiveInputVO = null;
	
	public EesDmt3017Event(){}

	public InactiveReasonVO getInactiveReasonVO() {
		return inactiveReasonVO;
	}

	public void setInactiveReasonVO(InactiveReasonVO inactiveReasonVO) {
		this.inactiveReasonVO = inactiveReasonVO;
	}

	public InactiveInputVO getInactiveInputVO() {
		return inactiveInputVO;
	}

	public void setInactiveInputVO(InactiveInputVO inactiveInputVO) {
		this.inactiveInputVO = inactiveInputVO;
	}
	
}