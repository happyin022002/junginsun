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
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.vo.PSADgEdiVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-Terminaldocumentation Business Logic Command Interface<br>
 * - OPUS-Terminaldocumentation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Seung Min
 * @see
 * @since J2EE 1.6
 */

@SuppressWarnings("serial")
public class PSASpecialManifestBackEndJob extends BackEndCommandSupport{

	private String pgmNo = "";
	private SignOnUserAccount account = null;
	private PSADgEdiVO[] psaDgEdiVOs = null;

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
	 * ESM_BKG_0577 Param
	 *
	 * @param PsaImpStsVO[] psaImpStsVOs
	 */
	public void setPsaDgEdiVOs(PSADgEdiVO[] psaDgEdiVOs) {
		if (psaDgEdiVOs != null) {
			PSADgEdiVO[] tmpVOs = Arrays.copyOf(psaDgEdiVOs, psaDgEdiVOs.length);
			this.psaDgEdiVOs = tmpVOs;
		}
	}

	/**
	 * BackEndCommand Start
	 * @return List<String>
	 * @throws Exception
	 */
	public List<String> doStart() throws Exception {
		List<String> stringlist = new ArrayList<String>();
		PSASpecialManifestBC command = new PSASpecialManifestBCImpl();
		try {
			if (pgmNo.startsWith("ESM_BKG_0577-Transmit")) {
				stringlist = command.transmitDgManifest(this.psaDgEdiVOs, this.account);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return stringlist;
	}

}
