/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongCustomsTransmissionBackEndJob.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
**@LastVersion : 1.0

=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Terminaldocumentation Business Logic Command Interface<br>
 * - OPUS-Terminaldocumentation<br>
 *
 * @author Kim Seung Min
 * @see Esm_bkg_0930EventResponse
 * @since J2EE 1.6
 */
public class HongKongCustomsTransmissionBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -3034414164961318353L;
	//private SignOnUserAccount account;
	private HongKongManifestTransmitVO[] hongKongManifestTransmitVOs;
	private String pgmNo = "";
	private SignOnUserAccount account;
	/**
	 *  setting 1023 screen to down load.
	 *
	 * @param austrailiaManifestTransmitVOs
	 * @param account
	 */
	public void setHongKongManifestTransmitVOs(HongKongManifestTransmitVO[] hongKongManifestTransmitVOs) {
		if (hongKongManifestTransmitVOs != null) {
			HongKongManifestTransmitVO[] tmpVOs = Arrays.copyOf(hongKongManifestTransmitVOs, hongKongManifestTransmitVOs.length);
			this.hongKongManifestTransmitVOs = tmpVOs;
		}
	}

	/**
	 *  setting ID
	 *
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 *  setting 0613 screen to down load..
	 *
	 * @param manifestListDetailVOs
	 * @param account
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
		try {
			if (pgmNo.startsWith("ESM_BKG_0282")) {
				HongKongCustomsTransmissionBC command = new HongKongCustomsTransmissionBCImpl();
				command.transmitManifest(hongKongManifestTransmitVOs, account);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return "Success!";
	}
}

