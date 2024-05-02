/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TES_0035Event.java
*@FileTitle : Terminal Cost Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoCostVO;

/**
 * ESD_TES_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * ESD_TES_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 *@author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
	public class EsdTes0035Event extends EventSupport {

	private TesTmlSoCostVO tesTmlSoCostVO = null;

	/**
     * 생성자
     */		
	public EsdTes0035Event(){}
	
	/**
	 * @return the tesTmlSoCostVO
	 */
	public TesTmlSoCostVO getTesTmlSoCostVO() {
		return tesTmlSoCostVO;
	}

	/**
	 * @param tesTmlSoCostVO the tesTmlSoCostVO to set
	 */
	public void setTesTmlSoCostVO(TesTmlSoCostVO tesTmlSoCostVO) {
		this.tesTmlSoCostVO = tesTmlSoCostVO;
	}	
}
