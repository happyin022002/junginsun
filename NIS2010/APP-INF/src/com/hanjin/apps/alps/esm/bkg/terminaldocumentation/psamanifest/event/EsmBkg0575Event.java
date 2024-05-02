/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0575Event.java
*@FileTitle : EsmBkg0575Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0575 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0575HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박상훈
 * @see ESM_BKG_0575HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0575Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PsaVvdVO psaVvdVO;
	private PsaVvdVO[] psaVvdVOs;

	/**
	 * @return the psaVvdVO
	 */
	public PsaVvdVO getPsaVvdVO() {
		return psaVvdVO;
	}

	/**
	 * @param psaVvdVO the psaVvdVO to set
	 */
	public void setPsaVvdVO(PsaVvdVO psaVvdVO) {
		this.psaVvdVO = psaVvdVO;
	}

	/**
	 * @return the psaVvdVOs
	 */
	public PsaVvdVO[] getPsaVvdVOs() {
		return psaVvdVOs;
	}

	/**
	 * @param psaVvdVOs the psaVvdVOs to set
	 */
	public void setPsaVvdVOs(PsaVvdVO[] psaVvdVOs) {
		this.psaVvdVOs = psaVvdVOs;
	}
	
}
