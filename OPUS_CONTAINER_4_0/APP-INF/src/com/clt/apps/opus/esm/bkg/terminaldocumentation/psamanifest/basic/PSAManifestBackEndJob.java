/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestBackEndJob.java.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.15
*@LastModifier :
**@LastVersion : 1.0
* 2013.11.15
* 1.0 Creation
*
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaIbManifestVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Terminaldocumentation Business Logic Command Interface<br>
 * - OPUS-Terminaldocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seung Min
 * @see Esm_bkg_0930EventResponse 참조
 * @since J2EE 1.6
 */

@SuppressWarnings("serial")
public class PSAManifestBackEndJob extends BackEndCommandSupport{

	private String vvd = "";
	private String pgmNo = "";
	private SignOnUserAccount account = null;
	private PsaImpStsVO psaImpStsVO = null;
	private PsaImpStsVO[] psaImpStsVOs = null;
	private PsaIbManifestVO[] psaIbManifestVOs = null;

	/**
	 * ESM_BKG_0420 Param
	 *
	 * @param PsaImpStsVO[] psaImpStsVOs
	 */
	public void setPsaImpStsVO(PsaImpStsVO psaImpStsVO) {
		this.psaImpStsVO = psaImpStsVO;
	}

	/**
	 * ESM_BKG_0420 Param
	 *
	 * @param PsaImpStsVO[] psaImpStsVOs
	 */
	public void setPsaImpStsVOs(PsaImpStsVO[] psaImpStsVOs) {
		if (psaImpStsVOs != null) {
			PsaImpStsVO[] tmpVOs = Arrays.copyOf(psaImpStsVOs, psaImpStsVOs.length);
			this.psaImpStsVOs = tmpVOs;
		}
	}

	/**
	 * ESM_BKG_1519 Param
	 *
	 * @param String vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * ESM_BKG_1519 Param
	 *
	 * @param PsaIbManifestVO[] psaIbManifestVOs
	 */
	public void setPsaIbManifestVOs(PsaIbManifestVO[] psaIbManifestVOs) {
		if (psaIbManifestVOs != null) {
			PsaIbManifestVO[] tmpVOs = Arrays.copyOf(psaIbManifestVOs, psaIbManifestVOs.length);
			this.psaIbManifestVOs = tmpVOs;
		}
	}

	/**
	 * 화면ID세팅
	 *
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * Account 세팅
	 *
	 * @param SignOnUserAccount account
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * BackEndCommand Start
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		PSAManifestBC command = new PSAManifestBCImpl();
		try {
			if (pgmNo.startsWith("ESM_BKG_0420-Save")) {
				command.managePSAImpSts(this.psaImpStsVOs);
			} else if (pgmNo.startsWith("ESM_BKG_0420-Transmit")) {
				this.psaImpStsVO.setUserId(account.getUsr_id());
				command.transmitPSAImpStsInfo(this.psaImpStsVO);
			} else if (pgmNo.startsWith("ESM_BKG_1519-Transmit")) {
				command.transmitManifest(this.vvd, this.psaIbManifestVOs, this.account);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return "Success";
	}


}
