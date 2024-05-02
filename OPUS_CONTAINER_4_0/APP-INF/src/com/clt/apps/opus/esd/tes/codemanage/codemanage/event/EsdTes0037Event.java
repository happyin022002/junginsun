/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TES_0037Event.java
*@FileTitle : Terminal AGMT Verify Method Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlAgmtVrfyMzdVO;

/**
 * ESD_TES_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 *@author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
	public class EsdTes0037Event extends EventSupport {

	private TesTmlAgmtVrfyMzdVO tesTmlAgmtVrfyMzdVO = null;
	
	/**
     * 생성자
     */		
	public EsdTes0037Event(){}
	
	/**
	 * @return the TesTmlAgmtVrfyMzdVO
	 */
	public TesTmlAgmtVrfyMzdVO getTesTmlAgmtVrfyMzdVO() {
		return tesTmlAgmtVrfyMzdVO;
	}

	/**
	 * @param tesTmlAgmtVrfyMzdVO the tesTmlAgmtVrfyMzdVO to set
	 */
	public void setTesTmlAgmtVrfyMzdVO(TesTmlAgmtVrfyMzdVO tesTmlAgmtVrfyMzdVO) {
		this.tesTmlAgmtVrfyMzdVO = tesTmlAgmtVrfyMzdVO;
	}	
}
