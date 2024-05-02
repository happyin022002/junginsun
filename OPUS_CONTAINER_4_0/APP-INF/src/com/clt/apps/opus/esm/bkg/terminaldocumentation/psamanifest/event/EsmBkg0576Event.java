/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0576Event.java
*@FileTitle : EsmBkg0576Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier :
*@LastVersion : 1.0
* 2009. 9. 4.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0576 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0576HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0576HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0576Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PsaBkgVO psaBkgVO = null;
	private PsaBkgVO[] psaBkgVOs = null;
	/**
	 * @return the psaBkgVO
	 */
	public PsaBkgVO getPsaBkgVO() {
		return psaBkgVO;
	}

	/**
	 * @param psaBkgVO the psaBkgVO to set
	 */
	public void setPsaBkgVO(PsaBkgVO psaBkgVO) {
		this.psaBkgVO = psaBkgVO;
	}

	/**
	 * @return the psaBkgVOs
	 */
	public PsaBkgVO[] getPsaBkgVOs() {
		PsaBkgVO[] rtnVOs = null;
		if (this.psaBkgVOs != null) {
			rtnVOs = Arrays.copyOf(psaBkgVOs, psaBkgVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param psaBkgVOs the psaBkgVOs to set
	 */
	public void setPsaBkgVOs(PsaBkgVO[] psaBkgVOs) {
		if (psaBkgVOs != null) {
			PsaBkgVO[] tmpVOs = Arrays.copyOf(psaBkgVOs, psaBkgVOs.length);
			this.psaBkgVOs = tmpVOs;
		}
	}

}
