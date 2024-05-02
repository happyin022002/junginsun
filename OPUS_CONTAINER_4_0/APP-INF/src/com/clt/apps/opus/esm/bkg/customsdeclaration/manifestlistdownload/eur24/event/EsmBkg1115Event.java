/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1115Event.java
*@FileTitle : ESM_BKG-1115
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  KIM GYOUNG SUB
 * @see ESM_BKG_1115HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1115Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private EU24RcvErrorCodeTableVO   eU24RcvErrorCodeTableVO = null;

	public EU24RcvErrorCodeTableVO getEU24RcvErrorCodeTableVO() {
		return eU24RcvErrorCodeTableVO;
	}

	public void setEU24RcvErrorCodeTableVO(
			EU24RcvErrorCodeTableVO rcvErrorCodeTableVO) {
		eU24RcvErrorCodeTableVO = rcvErrorCodeTableVO;
	}
	
	
	 
}
