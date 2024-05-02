/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : Eur24CustomsTransmissionBackEndJob.java
 *@FileTitle : Eur24CustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.09.10
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2010.09.10 김경섭
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see 
 * @since J2EE 1.4
 */
public class Eur24CustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅 0127화면.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 */
	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs) {
		if (manifestTransmitVOs != null)
			this.manifestTransmitVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
	}
	
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
	 * BackEndCommand Start<br>
	 * 
	 * @return Object
	 */
	public String doStart() throws Exception {
		
		Eur24CustomsTransmissionBC command = null;
		if (pgmNo.startsWith("ESM_BKG_1106") ) {	// EUR24
			command = new Eur24CustomsTransmissionBCImpl();
			return command.transmitManifest(manifestTransmitVOs, account);
		}
		else if (pgmNo.startsWith("ESM_BKG_1121") ) {	// EUR24 OB
				command = new Eur24CustomsTransmissionBCImpl();
				return command.transmitManifestOB(manifestTransmitVOs, account);
		}
		
		return "Y";
	}
	
	
}
