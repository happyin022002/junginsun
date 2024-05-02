/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TES_0036Event.java
*@FileTitle : Terminal Agreement Cost Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlAgmtCostVO;

/**
 * ESD_TES_0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 *@author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
	public class EsdTes0036Event extends EventSupport {

	private TesTmlAgmtCostVO tesTmlAgmtCostVO = null;

	/**
     * 생성자
     */		
	public EsdTes0036Event(){}
	
	/**
	 * @return the tesTmlAgmtCostVO
	 */
	public TesTmlAgmtCostVO getTesTmlAgmtCostVO() {
		return tesTmlAgmtCostVO;
	}

	/**
	 * @param tesTmlAgmtCostVO the tesTmlAgmtCostVO to set
	 */
	public void setTesTmlAgmtCostVO(TesTmlAgmtCostVO tesTmlAgmtCostVO) {
		this.tesTmlAgmtCostVO = tesTmlAgmtCostVO;
	}	
}
