/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : MyanmarCustomsTransmissionBackEndJob.java
 *@FileTitle : MyanmarCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * MyanmarCustomsTransmissionBackEndJob
 *
 * @author
 * @see related DAO class
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class MyanmarCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅 1155화면.<br>
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 */
	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null) {
			ManifestTransmitVO[] tmpVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
			this.manifestTransmitVOs = tmpVOs;
		}
	}

	/**
	 * 사용자 Account세팅<br>
	 *
	 * @param SignOnUserAccount account
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
	 * BackEndCommand Start<br>
	 *
	 * @return String
	 */
	public String doStart() throws Exception {
		MyanmarCustomsTransmissionBC command = new MyanmarCustomsTransmissionBCImpl();

		if (pgmNo.startsWith("ESM_BKG_1155") ) {
			return command.transmitManifest(manifestTransmitVOs, account);
		}

		return "Y";
	}


}
