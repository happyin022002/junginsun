/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VietnamCustomsTransmissionBC.java
*@FileTitle : VietnamCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-VietnamManifestListDownload Business Logic Command Interface<br>
 * - OPUS-VietnamManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author
 * @see VietnamManifestListDownloadBCImpl 참조
 * @since J2EE 1.6
 */
public interface VietnamCustomsTransmissionBC {

	/**
	 * Vietnam 세관신고 위해 FlatFile을 생성
	 *
	 * @param VietnamManifestTransmitVO vietnamManifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(VietnamManifestTransmitVO vietnamManifestTransmitVO, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob을 실행.(CTA)
	 *
	 * @param SignOnUserAccount account
	 * @param VietnamManifestTransmitVO vietnamManifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, VietnamManifestTransmitVO vietnamManifestTransmitVO, String pgmNo)  throws EventException;

}

