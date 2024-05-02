/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1108Event.java
*@FileTitle : ESM_BKG-1108
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  KIM GYOUNG SUB
 * @see ESM_BKG_1108HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1108Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private Eu24EnsListVO   eu24EnsListVO = null;

	public Eu24EnsListVO getEu24EnsListVO() {
		return eu24EnsListVO;
	}

	public void setEu24EnsListVO(Eu24EnsListVO eu24EnsListVO) {
		this.eu24EnsListVO = eu24EnsListVO;
	}
	
	
	 
}
