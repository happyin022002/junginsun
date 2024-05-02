/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SrilankaCustomsTransmissionBC.java
*@FileTitle : SrilankaCustomsTransmissionBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.basic;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-SrilankaCustomsTransmission Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface SrilankaCustomsTransmissionBC {

	/**
	 * Flat File creation handling<br>
	 * save Send Date and create FlatFile after retrieve Vessel Arrival data for report SriLanka Customs -- UI_BKG-0493
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * save Send Date and create FlatFile after retrieve Vessel Arrival data for report SriLanka Customs -- UI_BKG-0493
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO) throws EventException;

	/**
	 * RECEIVE FLAT FILE creates at Log Table
	 * @param String flatFile
	 * @param String userid
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String flatFile, String userid) throws EventException;
}
