/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanCustomsTransmissionBackEndJob.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
**@LastVersion : 1.0
* 2009.07.10 김승민
* * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanManifestTransmitVO;
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
public class TaiwanCustomsTransmissionBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -3034414164961318353L;
	//private SignOnUserAccount account;
	private TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs;
	private String pgmNo = "";
	private SignOnUserAccount account;
	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 *
	 * @param manifestTransmitVOs
	 * @param account
	 */
	public void setTaiwanManifestTransmitVOs(TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs) {
		if (taiwanManifestTransmitVOs != null) {
			TaiwanManifestTransmitVO[] tmpVOs = Arrays.copyOf(taiwanManifestTransmitVOs, taiwanManifestTransmitVOs.length);
			this.taiwanManifestTransmitVOs = tmpVOs;
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
	 * 다운로드 할 데이터 세팅 0613화면.
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
			if (pgmNo.startsWith("ESM_BKG_0497"))
			{
				TaiwanCustomsTransmissionBC command = new TaiwanCustomsTransmissionBCImpl();
				command.transmitManifest(taiwanManifestTransmitVOs, account);
			}
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return "Success!";
	}
}

