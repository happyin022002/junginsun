/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg11Event.java
*@FileTitle : ESM_BKG-1152
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.22
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.22 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG-1152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author BOBAE KIM
 * @see ESM_BKG_1152HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1152Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private Eu24EXSListVO   eu24EXSListVO = null;

	public Eu24EXSListVO getEu24EXSListVO() {
		return eu24EXSListVO;
	}

	public void setEu24EXSListVO(Eu24EXSListVO eu24EXSListVO) {
		this.eu24EXSListVO = eu24EXSListVO;
	}
	 
}