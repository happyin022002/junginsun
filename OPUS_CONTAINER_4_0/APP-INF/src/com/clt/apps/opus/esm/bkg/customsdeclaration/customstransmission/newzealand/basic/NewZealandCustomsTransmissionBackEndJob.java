/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandCustomsTransmissionBackEndJob.java
*@FileTitle : NewZealandCustomsTransmissionBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestVO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * @author
 * @see NewZealandCustomsTransmissionBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class NewZealandCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private NewZealandManifestVO inputManifestVO = null;
	private String pgmNo;
	private SignOnUserAccount account = null;

	/**
	 * 다운로드 할 데이터 세팅<br>
	 *
	 * @param NewZealandManifestVO newZealandManifestVO
	 */
	public void setNewZealandManifestVO(NewZealandManifestVO newZealandManifestVO) {
		this.inputManifestVO = newZealandManifestVO;
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

		NewZealandCustomsTransmissionBC command = new NewZealandCustomsTransmissionBCImpl();
		if (pgmNo.startsWith("ESM_BKG_1518") ) {
			return command.transmitManifest(inputManifestVO, account);
		}
		return "Y";
	}


}