/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt2103Event.java
*@FileTitle : S/C Exception Tariff History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.23 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo.SCExceptionParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_DMT_2103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_2103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author SungHoon Lee 
 * @see EES_DMT_2103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt2103Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private SCExceptionParmVO parmVO = null;
	
	public void setSCExceptionParmVO(SCExceptionParmVO parmVO) {
		this.parmVO = parmVO;
	}
	
	public SCExceptionParmVO getSCExceptionParmVO() {
		return parmVO;
	}
}
