/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : IsraelCustomsTransmissionBackEndJob.java
 *@FileTitle : IsraelCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.08.20
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2013.08.20 김보배
 * 1.0 Creation
 * 1.1 2015.07.07 소스보안[CWE-496, 766] 수정
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.basic;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author BOBAE KIM
 * @see 
 * @since J2EE 1.4
 */
public class IsraelCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private ManifestTransmitVO[] manifestTransmitVOs = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅 0127화면.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 */
	public void setManifestTransmitVOs(ManifestTransmitVO[] manifestTransmitVOs){
		if(manifestTransmitVOs != null){
			ManifestTransmitVO[] tmpVOs = Arrays.copyOf(manifestTransmitVOs, manifestTransmitVOs.length);
			this.manifestTransmitVOs = tmpVOs;
		}
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
		
		CustomsTransmissionBC command = null;
		if (pgmNo.startsWith("ESM_BKG_1168") ) {
			command = new IsraelCustomsTransmissionBCImpl();
			return command.transmitManifest(manifestTransmitVOs, account);
		}
		return "Y";
	}
	
	
}
