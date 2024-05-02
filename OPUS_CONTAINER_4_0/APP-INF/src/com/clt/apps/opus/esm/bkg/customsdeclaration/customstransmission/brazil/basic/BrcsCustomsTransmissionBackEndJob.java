/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BrcsCustomsTransmissionBackEndJob.java
 *@FileTitle : BrcsCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.29
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.10.29 경종윤
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyoung Jong Yun
 * @see BrcsCustomsTransmissionBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BrcsCustomsTransmissionBackEndJob extends BackEndCommandSupport {
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
	public Object doStart() throws Exception {
		
		BrcsCustomsTransmissionBC command = null;
		if (pgmNo.startsWith("ESM_BKG_0127") ) {	// Brazil Transmit
			command = new BrcsCustomsTransmissionBCImpl();
			command.transmitManifest(manifestTransmitVOs, account);
		}
		
		return null;
	}
	
	
}