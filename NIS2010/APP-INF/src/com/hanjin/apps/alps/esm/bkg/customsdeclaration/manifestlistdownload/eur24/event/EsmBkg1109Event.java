/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1109Event.java
*@FileTitle : ESM_BKG-1109
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * ESM_BKG-1109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-1109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  KIM GYOUNG SUB
 * @see ESM_BKG_1109HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1109Event extends EventSupport {
	private static final long serialVersionUID = 1L;
		
	private CustomsSetupVO   customsSetupVO = null;
	private CustomsSetupVO[] customsSetupVOs = null;

	public CustomsSetupVO[] getCustomsSetupVOs() {
		return customsSetupVOs;
	}

	public void setCustomsSetupVOs(CustomsSetupVO[] customsSetupVOs) {
		this.customsSetupVOs = customsSetupVOs;
	}

	public CustomsSetupVO getCustomsSetupVO() {
		return customsSetupVO;
	}

	public void setCustomsSetupVO(CustomsSetupVO customsSetupVO) {
		this.customsSetupVO = customsSetupVO;
	}

	
	
	
	 
}
