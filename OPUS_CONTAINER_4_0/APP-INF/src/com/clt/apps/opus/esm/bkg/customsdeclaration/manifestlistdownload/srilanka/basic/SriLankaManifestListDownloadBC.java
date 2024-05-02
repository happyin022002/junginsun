/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SriLankaManifestListDownloadBC.java
*@FileTitle : SriLankaManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-SriLankaManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface SriLankaManifestListDownloadBC {

	/**
	 * Searching the Manifest list for SriLanka Customs<br>
	 *
	 * @param manifestListCondVO ManifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * Searching the Vessel Arrival Info for SriLanka Customs Manifest<br>
	 *
	 * @param vesselArrivalCondVO VesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 * @exception EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO)
			throws EventException;

	/**
	 * Managing(create/modify) the SriLanka Vessel Arrival Info<br>
	 *
	 * @param VesselArrivalVO vesselArrivalVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 * @exception EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException;

	/**
	 * Saving the transmited SriLanka Vessel Arrival Info<br>
	 *
	 * @param VesselArrivalTransmitVO VesselArrivalTransmitVO
	 * @throws EventException
	 * @exception EventException
	 */
	public void modifySendDt(VesselArrivalTransmitVO VesselArrivalTransmitVO) throws EventException;
}
