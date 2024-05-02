/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TaiwanCustomsTransmissionBC.java
*@FileTitle : TaiwanCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo.TaiwanManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-TaiwanCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface TaiwanCustomsTransmissionBC {

	/**
	 * FlatFile Creation for the CustomsTransmission screen<br>
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob
	 *
	 * @param SignOnUserAccount account
	 * @param TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, TaiwanManifestTransmitVO[] taiwanManifestTransmitVOs, String pgmNo)
			throws EventException;

	/**
	 * Searching whether the B/L exist
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String retVal
	 * @throws EventException
	 */
	public String searchBLGeneralBasic(ManifestTransmitVO[] manifestTransmitVOs) throws EventException;
}
