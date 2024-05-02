/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg1125Event.java
*@FileTitle : ESM_BKG-1125
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.07.13 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorCondVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1125 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1125HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  김봉균
 * @see ESM_BKG_1125HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1125Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private ACIMonitorCondVO aCIMonitorCondVO = null;

	public ACIMonitorCondVO getACIMonitorCondVO() {
		return aCIMonitorCondVO;
	}

	public void setACIMonitorCondVO(ACIMonitorCondVO aCIMonitorCondVO) {
		this.aCIMonitorCondVO = aCIMonitorCondVO;
	}
	 
}