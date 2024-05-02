/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg1120Event.java
*@FileTitle : ESM_BKG-1120
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 이재위
*@LastVersion : 1.0
* 2011.03.28 이재위
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  Jay Lee
 * @see ESM_BKG_1120HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1120Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private Eu24EnsListVO   eu24EnsListVO = null;

	public Eu24EnsListVO getEu24EnsListVO() {
		return eu24EnsListVO;
	}

	public void setEu24EnsListVO(Eu24EnsListVO eu24EnsListVO) {
		this.eu24EnsListVO = eu24EnsListVO;
	}
	 
}