/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : HongKongCustomsTransmissionBC.java
*@FileTitle : HongKongCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.vo.HongKongManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-HongKongCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface HongKongCustomsTransmissionBC {

	/**
	 * handling searching event<br>
	 * CustomsTransmission<br>
	 * creating FlatFile
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException ;

	/**
	 * BackEndJob.
	 *
	 * @param SignOnUserAccount account
	 * @param HongKongManifestTransmitVO[] hongKongManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, HongKongManifestTransmitVO[] hongKongManifestTransmitVOs, String pgmNo)
			throws EventException;
}
