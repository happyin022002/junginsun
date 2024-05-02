/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionBackEndJob.java
*@FileTitle : MalaysiaCustomsTransmissionBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Gyoung Sub
 * @see MalaysiaCustomsTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class MalaysiaCustomsTransmissionBackEndJob extends BackEndCommandSupport {

	private SignOnUserAccount account = null;
	private String pgmNo;
	private MalaysiaManifestTransmitVO inputManifestTransmitVO = null;
	private MalaysiaImpStsVO inputImpStsVO = null;

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * 화면ID세팅<br>
	 *
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * ESM_BKG_1141 Param<br>
	 *
	 * @param MalaysiaManifestTransmitVO malaysiaManifestTransmitVO
	 */
	public void setMalaysiaManifestTransmitVO(MalaysiaManifestTransmitVO malaysiaManifestTransmitVO) {
		this.inputManifestTransmitVO = malaysiaManifestTransmitVO;
	}

	/**
	 * ESM_BKG_1522 Param
	 *
	 * @param MalaysiaImpStsVO malaysiaImpStsVO
	 */
	public void setMalaysiaImpStsVO(MalaysiaImpStsVO malaysiaImpStsVO) {
		this.inputImpStsVO = malaysiaImpStsVO;
	}

	/**
	 * BackEndCommand Start<br>
	 *
	 * @return Object
	 */
	public String doStart()throws Exception {
		MalaysiaCustomsTransmissionBC command = new MalaysiaCustomsTransmissionBCImpl();
		if (pgmNo.startsWith("ESM_BKG_1141")) {
			return command.transmitManifest(this.inputManifestTransmitVO, account);
		} else if (pgmNo.startsWith("ESM_BKG_1522-Transmit")) {
			this.inputImpStsVO.setUserId(account.getUsr_id());
			command.transmitImpStsInfo(this.inputImpStsVO);
		}
		return "Y";
	}

}