/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanCustomsTransmissionBackEndJob.java
 *@FileTitle : JapanCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.17
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.08.17 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBCImpl;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Do Wan
 * @see ESM_BKG_1023EventResponse,UsaCustomsTransmissionBackEndBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private SignOnUserAccount account;
	private ManifestTransmitVO detailVO;
	private String pgmNo;

	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 *
	 * @param manifestListDetailVOs
	 * @param account
	 */
	public void setManifestTransmitVO(ManifestTransmitVO detailVO) {
		this.detailVO = detailVO;
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
	 * 화면ID세팅
	 *
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndCommand Start
	 * @return DBRowSet
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		if (pgmNo.startsWith("ESM_BKG_0730")) {
			JapanCustomsTransmissionBC command = new JapanCustomsTransmissionBCImpl();
			JapanManifestListTransmitDetailVO japanManifestListTransmitDetailVO = (JapanManifestListTransmitDetailVO)command.transmitManifestList(detailVO, account);
			JapanManifestListDownloadBC maniCommand = new JapanManifestListDownloadBCImpl();
			maniCommand.modifyMsgStatus(japanManifestListTransmitDetailVO.getJapanBlKeyVOs());
		}
		return null;
	}
}
