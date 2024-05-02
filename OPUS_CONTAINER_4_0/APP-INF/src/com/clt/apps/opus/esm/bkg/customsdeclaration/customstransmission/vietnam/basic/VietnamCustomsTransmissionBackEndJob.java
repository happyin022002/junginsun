/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : VietnamCustomsTransmissionBackEndJob.java
 *@FileTitle : VietnamCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.24
 *@LastModifier : 조원주
 *@LastVersion : 1.0
 * 2012.08.24 조원주
 * 1.0 Creation
 *
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestTransmitVO;
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
public class VietnamCustomsTransmissionBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = 1L;
	private VietnamManifestTransmitVO inputManifestTransmitVO = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅 1149화면.<br>
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 */
	public void setVietnamManifestTransmitVO(VietnamManifestTransmitVO vietnamManifestTransmitVO) {
		this.inputManifestTransmitVO = vietnamManifestTransmitVO;
	}

	/**
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
	 * @return Object
	 */
	public String doStart() throws Exception {
		VietnamCustomsTransmissionBC command = new VietnamCustomsTransmissionBCImpl();
		if (pgmNo.startsWith("ESM_BKG_1149") ) {
			return command.transmitManifest(inputManifestTransmitVO, account);
		}
		return "Y";
	}

}
