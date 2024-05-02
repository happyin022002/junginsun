/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1210Event.java
*@FileTitle : S/C Exception History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.23 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionParmVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_CGM_1210 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1210HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br> 
 *
 * @author SungHoon Lee 
 * @see EES_CGM_1210HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1210Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private SCExceptionParmVO parmVO = null;
	
	public void setSCExceptionParmVO(SCExceptionParmVO parmVO) {
		this.parmVO = parmVO;
	}
	
	public SCExceptionParmVO getSCExceptionParmVO() {
		return parmVO;
	}
}
