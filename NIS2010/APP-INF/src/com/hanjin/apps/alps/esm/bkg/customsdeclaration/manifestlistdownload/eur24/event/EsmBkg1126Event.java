/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1108Event.java
*@FileTitle : ESM_BKG_1126
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1126 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1126HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  KIM GYOUNG SUB
 * @see ESM_BKG_1126HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1126Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private Eu24ExsListOBVO   eu24ExsListOBVO = null;

	public Eu24ExsListOBVO getEu24ExsListOBVO() {
		return eu24ExsListOBVO;
	}

	public void setEu24ExsListOBVO(Eu24ExsListOBVO eu24ExsListOBVO) {
		this.eu24ExsListOBVO = eu24ExsListOBVO;
	}
	
	
	 
}
