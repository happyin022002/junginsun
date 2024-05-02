/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg0577Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.17
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.08.17 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListModiVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgValidationCondVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0577 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0577HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Sung Jin
 * @see ESM_BKG_0577HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0577Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PSADgListCondVO psaDgListCondVO = null;
	private PSADgValidationCondVO psaDgValidationCondVO = null;
	
	private PSADgListModiVO psaDgListModiVO = null;
	private PSADgListModiVO[] psaDgListModiVOs = null;
	
	private PSADgEdiVO[] psaDgEdiVOs = null;

	public PSADgListCondVO getPsaDgListCondVO() {
		return psaDgListCondVO;
	}

	public void setPsaDgListCondVO(PSADgListCondVO psaDgListCondVO) {
		this.psaDgListCondVO = psaDgListCondVO;
	}

	public PSADgValidationCondVO getPsaDgValidationCondVO() {
		return psaDgValidationCondVO;
	}

	public void setPsaDgValidationCondVO(PSADgValidationCondVO psaDgValidationCondVO) {
		this.psaDgValidationCondVO = psaDgValidationCondVO;
	}

	public PSADgListModiVO getPsaDgListModiVO() {
		return psaDgListModiVO;
	}

	public void setPsaDgListModiVO(PSADgListModiVO psaDgListModiVO) {
		this.psaDgListModiVO = psaDgListModiVO;
	}

	public PSADgListModiVO[] getPsaDgListModiVOs() {
		return psaDgListModiVOs;
	}

	public void setPsaDgListModiVOs(PSADgListModiVO[] psaDgListModiVOs) {
		this.psaDgListModiVOs = psaDgListModiVOs;
	}

	public PSADgEdiVO[] getPsaDgEdiVOs() {
		return psaDgEdiVOs;
	}

	public void setPsaDgEdiVOs(PSADgEdiVO[] psaDgEdiVOs) {
		this.psaDgEdiVOs = psaDgEdiVOs;
	}
	
	
	
}
