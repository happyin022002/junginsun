/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionBC.java
*@FileTitle : IndonesiaCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaFFVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-IndonesiaCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface IndonesiaCustomsTransmissionBC {
	/**
	 * Indonesia  generated to Customs Manifest content  FlatFile. -- UI_BKG-0310, UI_BKG-0311 <br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return List<IndonesiaFFVO>
	 * @exception EventException
	 */
	public List<IndonesiaFFVO> transmitManifestForIndonesia(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException;
}
