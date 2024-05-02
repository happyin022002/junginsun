/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1519Event.java
*@FileTitle : EsmBkg1519Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014. 12. 01.
*@LastModifier :
*@LastVersion : 1.0
* 2014. 12. 01.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaIbManifestVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_1519 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1519HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1519HTMLAction 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EsmBkg1519Event extends EventSupport {

	private String vvd = null;

	/** Table Value Object 단건 및 Multi Data 처리 */
	private PsaIbManifestVO[] psaIbManifestVOs = null;

	public EsmBkg1519Event() {}

	public PsaIbManifestVO[] getPsaIbManifestVOs() {
		PsaIbManifestVO[] rtnVOs = null;
		if (this.psaIbManifestVOs != null) {
			rtnVOs = Arrays.copyOf(psaIbManifestVOs, psaIbManifestVOs.length);
		}
		return rtnVOs;
	}

	public void setPsaIbManifestVOs(PsaIbManifestVO[] psaIbManifestVOs) {
		if (psaIbManifestVOs != null) {
			PsaIbManifestVO[] tmpVOs = Arrays.copyOf(psaIbManifestVOs, psaIbManifestVOs.length);
			this.psaIbManifestVOs = tmpVOs;
		}
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

}
