/*=========================================================
 *Copyright(c) CyberLogitec
 *@FileName : MyanmarCustomsTransmissionBC.java
 *@FileTitle : MyanmarCustomsTransmissionBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-MyanmarCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface MyanmarCustomsTransmissionBC {

	/**
	 * Myanmar 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob을 실행.(CTA)
	 *
	 * @param account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException;


}

