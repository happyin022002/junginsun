/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg0577Event.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.17
*@LastModifier :
*@LastVersion : 1.0
* 2011.08.17
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgListCondVO;
import com.clt.framework.support.layer.event.EventSupport;


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

	private PSADgEdiVO[] psaDgEdiVOs = null;

	public PSADgListCondVO getPsaDgListCondVO() {
		return psaDgListCondVO;
	}

	public void setPsaDgListCondVO(PSADgListCondVO psaDgListCondVO) {
		this.psaDgListCondVO = psaDgListCondVO;
	}

	public PSADgEdiVO[] getPsaDgEdiVOs() {
		PSADgEdiVO[] rtnVOs = null;
		if (this.psaDgEdiVOs != null) {
			rtnVOs = Arrays.copyOf(psaDgEdiVOs, psaDgEdiVOs.length);
		}
		return rtnVOs;
	}

	public void setPsaDgEdiVOs(PSADgEdiVO[] psaDgEdiVOs) {
		if (psaDgEdiVOs != null) {
			PSADgEdiVO[] tmpVOs = Arrays.copyOf(psaDgEdiVOs, psaDgEdiVOs.length);
			this.psaDgEdiVOs = tmpVOs;
		}
	}



}
